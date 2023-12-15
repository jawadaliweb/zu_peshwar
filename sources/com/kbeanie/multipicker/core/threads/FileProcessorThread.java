package com.kbeanie.multipicker.core.threads;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kbeanie.multipicker.api.callbacks.FilePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.utils.BitmapUtils;
import com.kbeanie.multipicker.utils.FileUtils;
import com.kbeanie.multipicker.utils.LogUtils;
import com.kbeanie.multipicker.utils.MimeUtils;
import com.kbeanie.multipicker.utils.StreamHelper;
import com.microsoft.appcenter.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class FileProcessorThread extends Thread {
    private static final String TAG = "FileProcessorThread";
    protected static final int THUMBNAIL_BIG = 1;
    protected static final int THUMBNAIL_SMALL = 2;
    private final int cacheLocation;
    /* access modifiers changed from: private */
    public FilePickerCallback callback;
    protected final Context context;
    protected final List<? extends ChosenFile> files;
    private int requestId;

    public FileProcessorThread(Context context2, List<? extends ChosenFile> list, int i) {
        this.context = context2;
        this.files = list;
        this.cacheLocation = i;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public void run() {
        processFiles();
        if (this.callback != null) {
            onDone();
        }
    }

    private void onDone() {
        try {
            if (this.callback != null) {
                ((Activity) this.context).runOnUiThread(new Runnable() {
                    public void run() {
                        FileProcessorThread.this.callback.onFilesChosen(FileProcessorThread.this.files);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void processFiles() {
        for (ChosenFile chosenFile : this.files) {
            try {
                chosenFile.setRequestId(this.requestId);
                String str = TAG;
                LogUtils.d(str, "processFile: Before: " + chosenFile.toString());
                processFile(chosenFile);
                postProcess(chosenFile);
                chosenFile.setSuccess(true);
                LogUtils.d(str, "processFile: Final Path: " + chosenFile.toString());
            } catch (PickerException e) {
                e.printStackTrace();
                chosenFile.setSuccess(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void postProcessFiles() {
        for (ChosenFile postProcess : this.files) {
            try {
                postProcess(postProcess);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void postProcess(ChosenFile chosenFile) throws PickerException {
        chosenFile.setCreatedAt(Calendar.getInstance().getTime());
        chosenFile.setSize(new File(chosenFile.getOriginalPath()).length());
        copyFileToFolder(chosenFile);
    }

    private void copyFileToFolder(ChosenFile chosenFile) throws PickerException {
        String str = TAG;
        LogUtils.d(str, "copyFileToFolder: folder: " + chosenFile.getDirectoryType());
        LogUtils.d(str, "copyFileToFolder: extension: " + chosenFile.getExtension());
        LogUtils.d(str, "copyFileToFolder: mimeType: " + chosenFile.getMimeType());
        LogUtils.d(str, "copyFileToFolder: type: " + chosenFile.getType());
        if (chosenFile.getType().equals("image")) {
            chosenFile.setDirectoryType(Environment.DIRECTORY_PICTURES);
        } else if (chosenFile.getType().equals("video")) {
            chosenFile.setDirectoryType(Environment.DIRECTORY_MOVIES);
        }
        String targetLocationToCopy = getTargetLocationToCopy(chosenFile);
        LogUtils.d(str, "copyFileToFolder: Out Path: " + targetLocationToCopy);
        if (!targetLocationToCopy.equals(chosenFile.getOriginalPath())) {
            try {
                File file = new File(chosenFile.getOriginalPath());
                File file2 = new File(targetLocationToCopy);
                FileUtils.copyFile(file, file2);
                chosenFile.setOriginalPath(file2.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                throw new PickerException(e);
            }
        }
    }

    private void processFile(ChosenFile chosenFile) throws PickerException {
        String queryUri = chosenFile.getQueryUri();
        String str = TAG;
        LogUtils.d(str, "processFile: uri" + queryUri);
        if (queryUri.startsWith("file://") || queryUri.startsWith("/")) {
            chosenFile = sanitizeUri(chosenFile);
            chosenFile.setDisplayName(Uri.parse(chosenFile.getOriginalPath()).getLastPathSegment());
            chosenFile.setMimeType(guessMimeTypeFromUrl(chosenFile.getOriginalPath(), chosenFile.getType()));
        } else if (queryUri.startsWith("http")) {
            chosenFile = downloadAndSaveFile(chosenFile);
        } else if (queryUri.startsWith("content:")) {
            chosenFile = getAbsolutePathIfAvailable(chosenFile);
        }
        if (chosenFile.getOriginalPath().startsWith("content:")) {
            chosenFile = getFromContentProvider(chosenFile);
        }
        if (chosenFile.getOriginalPath().startsWith("content:")) {
            chosenFile = getFromContentProviderAlternate(chosenFile);
        }
        try {
            String uri = Uri.parse(Uri.decode(chosenFile.getOriginalPath())).toString();
            if (!uri.equals(chosenFile.getOriginalPath())) {
                chosenFile.setOriginalPath(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ChosenFile sanitizeUri(ChosenFile chosenFile) {
        if (chosenFile.getQueryUri().startsWith("file://")) {
            chosenFile.setOriginalPath(chosenFile.getQueryUri().substring(7));
        }
        return chosenFile;
    }

    /* access modifiers changed from: protected */
    public ChosenFile getFromContentProviderAlternate(ChosenFile chosenFile) throws PickerException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            InputStream openInputStream = this.context.getContentResolver().openInputStream(Uri.parse(chosenFile.getOriginalPath()));
            bufferedInputStream = new BufferedInputStream(openInputStream);
            try {
                String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream(openInputStream);
                StreamHelper.verifyStream(chosenFile.getOriginalPath(), (InputStream) bufferedInputStream);
                String generateFileName = generateFileName(chosenFile);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(generateFileName));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    chosenFile.setOriginalPath(generateFileName);
                    if (chosenFile.getMimeType() != null && chosenFile.getMimeType().contains("/*")) {
                        if (guessContentTypeFromStream == null || guessContentTypeFromStream.isEmpty()) {
                            chosenFile.setMimeType(guessMimeTypeFromUrl(chosenFile.getOriginalPath(), chosenFile.getType()));
                        } else {
                            chosenFile.setMimeType(guessContentTypeFromStream);
                        }
                    }
                    StreamHelper.flush(bufferedOutputStream2);
                    StreamHelper.close(bufferedInputStream);
                    StreamHelper.close(bufferedOutputStream2);
                    return chosenFile;
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        throw new PickerException(e);
                    } catch (Throwable th) {
                        th = th;
                        StreamHelper.flush(bufferedOutputStream);
                        StreamHelper.close(bufferedInputStream);
                        StreamHelper.close(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    StreamHelper.flush(bufferedOutputStream);
                    StreamHelper.close(bufferedInputStream);
                    StreamHelper.close(bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                throw new PickerException(e);
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            throw new PickerException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            StreamHelper.flush(bufferedOutputStream);
            StreamHelper.close(bufferedInputStream);
            StreamHelper.close(bufferedOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.io.BufferedInputStream} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.kbeanie.multipicker.api.entity.ChosenFile getFromContentProvider(com.kbeanie.multipicker.api.entity.ChosenFile r11) throws com.kbeanie.multipicker.api.exceptions.PickerException {
        /*
            r10 = this;
            r0 = 16
            r1 = 0
            java.lang.String r2 = r10.generateFileName(r11)     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            android.content.Context r3 = r10.context     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            java.lang.String r4 = r11.getOriginalPath()     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r3 = r3.openFileDescriptor(r4, r5)     // Catch:{ IOException -> 0x00c2, Exception -> 0x00b5, all -> 0x00b1 }
            java.lang.String r4 = r11.getOriginalPath()     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            com.kbeanie.multipicker.utils.StreamHelper.verifyStream((java.lang.String) r4, (android.os.ParcelFileDescriptor) r3)     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            java.io.FileDescriptor r4 = r3.getFileDescriptor()     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00ae, Exception -> 0x00ab, all -> 0x00a7 }
            java.lang.String r4 = java.net.URLConnection.guessContentTypeFromStream(r5)     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            r8.<init>(r2)     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00a3, Exception -> 0x009f, all -> 0x009c }
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        L_0x0047:
            int r8 = r6.read(r1)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            if (r8 <= 0) goto L_0x0052
            r9 = 0
            r7.write(r1, r9, r8)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            goto L_0x0047
        L_0x0052:
            com.kbeanie.multipicker.utils.StreamHelper.flush(r7)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            r11.setOriginalPath(r2)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r1 = r11.getMimeType()     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = r11.getMimeType()     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r2 = "/*"
            boolean r1 = r1.contains(r2)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            if (r1 == 0) goto L_0x0085
            if (r4 == 0) goto L_0x0076
            boolean r1 = r4.isEmpty()     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            if (r1 != 0) goto L_0x0076
            r11.setMimeType(r4)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            goto L_0x0085
        L_0x0076:
            java.lang.String r1 = r11.getOriginalPath()     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r2 = r11.getType()     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            java.lang.String r1 = r10.guessMimeTypeFromUrl(r1, r2)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
            r11.setMimeType(r1)     // Catch:{ IOException -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        L_0x0085:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x008c
            com.kbeanie.multipicker.utils.StreamHelper.close(r3)
        L_0x008c:
            com.kbeanie.multipicker.utils.StreamHelper.flush(r7)
            com.kbeanie.multipicker.utils.StreamHelper.close(r7)
            com.kbeanie.multipicker.utils.StreamHelper.close(r5)
            return r11
        L_0x0096:
            r11 = move-exception
            goto L_0x00cd
        L_0x0098:
            r11 = move-exception
            goto L_0x00a1
        L_0x009a:
            r11 = move-exception
            goto L_0x00a5
        L_0x009c:
            r11 = move-exception
            r7 = r1
            goto L_0x00cd
        L_0x009f:
            r11 = move-exception
            r7 = r1
        L_0x00a1:
            r1 = r5
            goto L_0x00b8
        L_0x00a3:
            r11 = move-exception
            r7 = r1
        L_0x00a5:
            r1 = r5
            goto L_0x00c5
        L_0x00a7:
            r11 = move-exception
            r5 = r1
            r7 = r5
            goto L_0x00cd
        L_0x00ab:
            r11 = move-exception
            r7 = r1
            goto L_0x00b8
        L_0x00ae:
            r11 = move-exception
            r7 = r1
            goto L_0x00c5
        L_0x00b1:
            r11 = move-exception
            r5 = r1
            r7 = r5
            goto L_0x00ce
        L_0x00b5:
            r11 = move-exception
            r3 = r1
            r7 = r3
        L_0x00b8:
            com.kbeanie.multipicker.api.exceptions.PickerException r2 = new com.kbeanie.multipicker.api.exceptions.PickerException     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x00cb }
            r2.<init>((java.lang.String) r11)     // Catch:{ all -> 0x00cb }
            throw r2     // Catch:{ all -> 0x00cb }
        L_0x00c2:
            r11 = move-exception
            r3 = r1
            r7 = r3
        L_0x00c5:
            com.kbeanie.multipicker.api.exceptions.PickerException r2 = new com.kbeanie.multipicker.api.exceptions.PickerException     // Catch:{ all -> 0x00cb }
            r2.<init>((java.io.IOException) r11)     // Catch:{ all -> 0x00cb }
            throw r2     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r11 = move-exception
            r5 = r1
        L_0x00cd:
            r1 = r3
        L_0x00ce:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L_0x00d5
            com.kbeanie.multipicker.utils.StreamHelper.close(r1)
        L_0x00d5:
            com.kbeanie.multipicker.utils.StreamHelper.flush(r7)
            com.kbeanie.multipicker.utils.StreamHelper.close(r7)
            com.kbeanie.multipicker.utils.StreamHelper.close(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kbeanie.multipicker.core.threads.FileProcessorThread.getFromContentProvider(com.kbeanie.multipicker.api.entity.ChosenFile):com.kbeanie.multipicker.api.entity.ChosenFile");
    }

    private ChosenFile getAbsolutePathIfAvailable(ChosenFile chosenFile) {
        String[] strArr = {"_data", "_display_name", "mime_type"};
        if (chosenFile.getQueryUri().startsWith("content://com.android.gallery3d.provider")) {
            chosenFile.setOriginalPath(Uri.parse(chosenFile.getQueryUri().replace("com.android.gallery3d", "com.google.android.gallery3d")).toString());
        } else {
            chosenFile.setOriginalPath(chosenFile.getQueryUri());
        }
        if (chosenFile.getOriginalPath().startsWith("content://")) {
            try {
                Cursor query = this.context.getContentResolver().query(Uri.parse(chosenFile.getOriginalPath()), strArr, (String) null, (String[]) null, (String) null);
                query.moveToFirst();
                try {
                    if (!chosenFile.getOriginalPath().contains("com.sec.android.gallery3d.provider")) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        String str = TAG;
                        LogUtils.d(str, "processFile: Path: " + string);
                        if (string != null) {
                            chosenFile.setOriginalPath(string);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String string2 = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    if (string2 != null) {
                        chosenFile.setDisplayName(string2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String string3 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                if (string3 != null) {
                    chosenFile.setMimeType(string3);
                }
                query.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (chosenFile.getOriginalPath().startsWith("content:") && isDownloadsDocument(Uri.parse(chosenFile.getOriginalPath())) && Build.VERSION.SDK_INT >= 19) {
            String[] pathAndMimeType = getPathAndMimeType(chosenFile);
            if (pathAndMimeType[0] != null) {
                chosenFile.setOriginalPath(pathAndMimeType[0]);
            }
            if (pathAndMimeType[1] != null) {
                chosenFile.setMimeType(pathAndMimeType[1]);
            }
        }
        return chosenFile;
    }

    private String[] getPathAndMimeType(ChosenFile chosenFile) {
        boolean z = Build.VERSION.SDK_INT >= 19;
        Uri parse = Uri.parse(chosenFile.getOriginalPath());
        Uri uri = null;
        if (!z || !DocumentsContract.isDocumentUri(this.context, parse)) {
            if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(parse.getScheme())) {
                return getDataAndMimeType(parse, (String) null, (String[]) null, chosenFile.getType());
            }
            if ("file".equalsIgnoreCase(parse.getScheme())) {
                String path = parse.getPath();
                return new String[]{path, guessMimeTypeFromUrl(path, chosenFile.getType())};
            }
        } else if (isDownloadsDocument(parse)) {
            String documentId = DocumentsContract.getDocumentId(parse);
            if (documentId.startsWith("raw:")) {
                return new String[]{documentId.replaceFirst("raw:", ""), null};
            }
            if (Build.VERSION.SDK_INT < 26) {
                parse = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue());
            }
            return getDataAndMimeType(parse, (String) null, (String[]) null, chosenFile.getType());
        } else if (isMediaDocument(parse)) {
            String[] split = DocumentsContract.getDocumentId(parse).split(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR);
            String str = split[0];
            if ("image".equals(str)) {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataAndMimeType(uri, "_id=?", new String[]{split[1]}, chosenFile.getType());
        }
        return new String[]{null, null};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0[0] = r11.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r9 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        throw r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] getDataAndMimeType(android.net.Uri r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
            r10 = this;
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r1}
            r8 = 0
            r9 = 0
            android.content.Context r2 = r10.context     // Catch:{ Exception -> 0x0040 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0040 }
            r7 = 0
            r3 = r11
            r5 = r12
            r6 = r13
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0040 }
            if (r9 == 0) goto L_0x0038
            boolean r12 = r9.moveToFirst()     // Catch:{ Exception -> 0x0040 }
            if (r12 == 0) goto L_0x0038
            int r12 = r9.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r12 = r9.getString(r12)     // Catch:{ Exception -> 0x0040 }
            r0[r8] = r12     // Catch:{ Exception -> 0x0040 }
            r13 = 1
            java.lang.String r12 = r10.guessMimeTypeFromUrl(r12, r14)     // Catch:{ Exception -> 0x0040 }
            r0[r13] = r12     // Catch:{ Exception -> 0x0040 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r0
        L_0x0038:
            if (r9 == 0) goto L_0x003d
            r9.close()
        L_0x003d:
            return r0
        L_0x003e:
            r11 = move-exception
            goto L_0x004c
        L_0x0040:
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x003e }
            r0[r8] = r11     // Catch:{ all -> 0x003e }
            if (r9 == 0) goto L_0x004b
            r9.close()
        L_0x004b:
            return r0
        L_0x004c:
            if (r9 == 0) goto L_0x0051
            r9.close()
        L_0x0051:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kbeanie.multipicker.core.threads.FileProcessorThread.getDataAndMimeType(android.net.Uri, java.lang.String, java.lang.String[], java.lang.String):java.lang.String[]");
    }

    private boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private ChosenFile downloadAndSaveFile(ChosenFile chosenFile) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(chosenFile.getQueryUri()).openConnection()).getInputStream());
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(bufferedInputStream);
            String guessMimeTypeFromUrl = guessMimeTypeFromUrl(chosenFile.getQueryUri(), chosenFile.getType());
            if (guessMimeTypeFromUrl == null) {
                guessMimeTypeFromUrl = URLConnection.guessContentTypeFromStream(bufferedInputStream);
            }
            if (guessMimeTypeFromUrl == null && chosenFile.getQueryUri().contains(".")) {
                int lastIndexOf = chosenFile.getQueryUri().lastIndexOf(".");
                guessMimeTypeFromUrl = chosenFile.getType() + "/" + chosenFile.getQueryUri().substring(lastIndexOf + 1);
            }
            if (guessMimeTypeFromUrl == null) {
                guessMimeTypeFromUrl = chosenFile.getType() + "/*";
            }
            chosenFile.setMimeType(guessMimeTypeFromUrl);
            String generateFileName = generateFileName(chosenFile);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(generateFileName));
            byte[] bArr = new byte[2048];
            while (true) {
                int read = bufferedInputStream2.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream2.close();
            chosenFile.setOriginalPath(generateFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chosenFile;
    }

    /* access modifiers changed from: protected */
    public String getTargetDirectory(String str) throws PickerException {
        int i = this.cacheLocation;
        if (i == 100) {
            return FileUtils.getExternalFilesDirectory(str, this.context);
        }
        if (i == 200) {
            return FileUtils.getExternalFilesDir(str, this.context);
        }
        if (i == 300) {
            return FileUtils.getExternalCacheDir(this.context);
        }
        if (i != 400) {
            return FileUtils.getExternalFilesDirectory(str, this.context);
        }
        return FileUtils.getInternalFileDirectory(this.context);
    }

    private String guessExtensionFromUrl(String str) {
        try {
            return MimeTypeMap.getFileExtensionFromUrl(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String guessMimeTypeFromUrl(String str, String str2) {
        String guessExtensionFromUrl = guessExtensionFromUrl(str);
        if (guessExtensionFromUrl == null || guessExtensionFromUrl.isEmpty()) {
            guessExtensionFromUrl = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : "*";
        }
        if (str2.equals("file")) {
            return MimeUtils.guessMimeTypeFromExtension(guessExtensionFromUrl);
        }
        return str2 + "/" + guessExtensionFromUrl;
    }

    private String getTargetLocationToCopy(ChosenFile chosenFile) throws PickerException {
        String fileExtensionFromMimeType;
        String displayName = chosenFile.getDisplayName();
        if (displayName == null || displayName.isEmpty()) {
            displayName = UUID.randomUUID().toString();
        }
        if (!displayName.contains(".") && (fileExtensionFromMimeType = chosenFile.getFileExtensionFromMimeType()) != null && !fileExtensionFromMimeType.isEmpty()) {
            displayName = displayName + fileExtensionFromMimeType;
            chosenFile.setExtension(fileExtensionFromMimeType);
        }
        return new File(getTargetDirectory(chosenFile.getDirectoryType()) + File.separator + displayName).getAbsolutePath();
    }

    private String generateFileName(ChosenFile chosenFile) throws PickerException {
        String str;
        String fileExtensionFromMimeType;
        String displayName = chosenFile.getDisplayName();
        if (displayName == null || displayName.isEmpty()) {
            displayName = UUID.randomUUID().toString();
        }
        if (!displayName.contains(".") && (fileExtensionFromMimeType = chosenFile.getFileExtensionFromMimeType()) != null && !fileExtensionFromMimeType.isEmpty()) {
            displayName = displayName + fileExtensionFromMimeType;
            chosenFile.setExtension(fileExtensionFromMimeType);
        }
        if (TextUtils.isEmpty(chosenFile.getMimeType())) {
            chosenFile.setMimeType(guessMimeTypeFromUrl(chosenFile.getOriginalPath(), chosenFile.getType()));
        }
        File file = new File(getTargetDirectory(chosenFile.getDirectoryType()) + File.separator + displayName);
        String str2 = displayName;
        int i = 0;
        while (file.exists()) {
            i++;
            if (displayName.contains(".")) {
                int lastIndexOf = displayName.lastIndexOf(".");
                str = displayName.substring(0, lastIndexOf - 1) + "-" + i + "." + displayName.substring(lastIndexOf + 1);
            } else {
                str = displayName + "(" + i + ")";
            }
            str2 = str;
            file = new File(getTargetDirectory(chosenFile.getDirectoryType()) + File.separator + str2);
        }
        chosenFile.setDisplayName(str2);
        return getTargetDirectory(chosenFile.getDirectoryType()) + File.separator + str2;
    }

    /* access modifiers changed from: protected */
    public String generateFileNameForVideoPreviewImage() throws PickerException {
        return getTargetDirectory(Environment.DIRECTORY_PICTURES) + File.separator + (UUID.randomUUID().toString() + ".jpg");
    }

    /* access modifiers changed from: protected */
    public Activity getActivityFromContext() {
        return (Activity) this.context;
    }

    public void setFilePickerCallback(FilePickerCallback filePickerCallback) {
        this.callback = filePickerCallback;
    }

    /* access modifiers changed from: protected */
    public ChosenImage ensureMaxWidthAndHeight(int i, int i2, int i3, ChosenImage chosenImage) {
        Throwable th;
        ChosenImage chosenImage2 = chosenImage;
        FileOutputStream fileOutputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(chosenImage.getOriginalPath()));
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, (Rect) null, options);
            if (decodeStream != null) {
                decodeStream.recycle();
            }
            bufferedInputStream.close();
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            int[] scaledDimensions = BitmapUtils.getScaledDimensions(i4, i5, i, i2);
            if (!(scaledDimensions[0] == i4 && scaledDimensions[1] == i5)) {
                String attribute = new ExifInterface(chosenImage.getOriginalPath()).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(chosenImage.getOriginalPath()));
                options.inJustDecodeBounds = false;
                Bitmap decodeStream2 = BitmapFactory.decodeStream(bufferedInputStream2, (Rect) null, options);
                bufferedInputStream2.close();
                if (decodeStream2 != null) {
                    File file = new File(chosenImage.getOriginalPath());
                    chosenImage2.setTempFile(file.getAbsolutePath());
                    File file2 = new File(file.getParent() + File.separator + file.getName().replace(".", "-resized."));
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        Matrix matrix = new Matrix();
                        matrix.postScale(((float) scaledDimensions[0]) / ((float) i4), ((float) scaledDimensions[1]) / ((float) i5));
                        Bitmap.createBitmap(decodeStream2, 0, 0, decodeStream2.getWidth(), decodeStream2.getHeight(), matrix, false).compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream2);
                        chosenImage2.setOriginalPath(file2.getAbsolutePath());
                        ExifInterface exifInterface = new ExifInterface(file2.getAbsolutePath());
                        exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, attribute);
                        exifInterface.saveAttributes();
                        chosenImage2.setWidth(scaledDimensions[0]);
                        chosenImage2.setHeight(scaledDimensions[1]);
                        fileOutputStream2.close();
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            StreamHelper.close(fileOutputStream);
                            return chosenImage2;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                StreamHelper.close(fileOutputStream);
                            } catch (PickerException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        StreamHelper.close(fileOutputStream);
                        throw th;
                    }
                }
            }
            try {
                StreamHelper.close(fileOutputStream);
            } catch (PickerException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            StreamHelper.close(fileOutputStream);
            return chosenImage2;
        }
        return chosenImage2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0148, code lost:
        throw new com.kbeanie.multipicker.api.exceptions.PickerException("Error while generating thumbnail: " + r1 + br.com.sapereaude.maskedEditText.MaskedEditText.SPACE + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0149, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x012a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String downScaleAndSaveImage(java.lang.String r16, int r17, int r18) throws com.kbeanie.multipicker.api.exceptions.PickerException {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "."
            r3 = 0
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r4.<init>()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r5 = 1
            r4.inJustDecodeBounds = r5     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r6, r3, r4)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            if (r7 == 0) goto L_0x0022
            r7.recycle()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
        L_0x0022:
            r6.close()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            int r6 = r4.outWidth     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            int r4 = r4.outHeight     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            android.media.ExifInterface r7 = new android.media.ExifInterface     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r8 = "Orientation"
            int r5 = r7.getAttributeInt(r8, r5)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7 = 3
            r8 = 0
            if (r5 == r7) goto L_0x0047
            r7 = 6
            if (r5 == r7) goto L_0x0044
            r7 = 8
            if (r5 == r7) goto L_0x0041
            r5 = 0
            goto L_0x0049
        L_0x0041:
            r5 = -90
            goto L_0x0049
        L_0x0044:
            r5 = 90
            goto L_0x0049
        L_0x0047:
            r5 = 180(0xb4, float:2.52E-43)
        L_0x0049:
            if (r6 <= r4) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r6 = r4
        L_0x004d:
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r4.<init>()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7 = 3000(0xbb8, float:4.204E-42)
            if (r6 <= r7) goto L_0x005b
            int r6 = r1 * 6
            r4.inSampleSize = r6     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            goto L_0x0089
        L_0x005b:
            r9 = 2000(0x7d0, float:2.803E-42)
            if (r6 <= r9) goto L_0x0066
            if (r6 > r7) goto L_0x0066
            int r6 = r1 * 5
            r4.inSampleSize = r6     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            goto L_0x0089
        L_0x0066:
            r7 = 1500(0x5dc, float:2.102E-42)
            if (r6 <= r7) goto L_0x0071
            if (r6 > r9) goto L_0x0071
            int r6 = r1 * 4
            r4.inSampleSize = r6     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            goto L_0x0089
        L_0x0071:
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r6 <= r9) goto L_0x007c
            if (r6 > r7) goto L_0x007c
            int r6 = r1 * 3
            r4.inSampleSize = r6     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            goto L_0x0089
        L_0x007c:
            r7 = 400(0x190, float:5.6E-43)
            if (r6 <= r7) goto L_0x0087
            if (r6 > r9) goto L_0x0087
            int r6 = r1 * 2
            r4.inSampleSize = r6     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            goto L_0x0089
        L_0x0087:
            r4.inSampleSize = r1     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
        L_0x0089:
            r4.inJustDecodeBounds = r8     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r3, r4)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r6.close()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            if (r8 == 0) goto L_0x011c
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.nio.charset.Charset r6 = java.nio.charset.Charset.defaultCharset()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r6 = java.net.URLDecoder.decode(r0, r6)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.<init>()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r9 = r4.getParent()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.append(r9)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.append(r9)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r9.<init>()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r10 = "-scale-"
            r9.append(r10)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r9.append(r1)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r9.append(r2)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r2 = r4.replace(r2, r9)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r7.append(r2)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            if (r5 == 0) goto L_0x0107
            android.graphics.Matrix r13 = new android.graphics.Matrix     // Catch:{ Exception -> 0x012a }
            r13.<init>()     // Catch:{ Exception -> 0x012a }
            float r4 = (float) r5     // Catch:{ Exception -> 0x012a }
            r13.setRotate(r4)     // Catch:{ Exception -> 0x012a }
            r9 = 0
            r10 = 0
            int r11 = r8.getWidth()     // Catch:{ Exception -> 0x012a }
            int r12 = r8.getHeight()     // Catch:{ Exception -> 0x012a }
            r14 = 0
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x012a }
        L_0x0107:
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x012a }
            r5 = r18
            r8.compress(r4, r5, r2)     // Catch:{ Exception -> 0x012a }
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x012a }
            com.kbeanie.multipicker.utils.StreamHelper.close(r3)
            com.kbeanie.multipicker.utils.StreamHelper.flush(r2)
            com.kbeanie.multipicker.utils.StreamHelper.close(r2)
            return r0
        L_0x011c:
            com.kbeanie.multipicker.utils.StreamHelper.close(r3)
            com.kbeanie.multipicker.utils.StreamHelper.flush(r3)
            com.kbeanie.multipicker.utils.StreamHelper.close(r3)
            return r3
        L_0x0126:
            r0 = move-exception
            r2 = r3
            goto L_0x014a
        L_0x0129:
            r2 = r3
        L_0x012a:
            com.kbeanie.multipicker.api.exceptions.PickerException r4 = new com.kbeanie.multipicker.api.exceptions.PickerException     // Catch:{ all -> 0x0149 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0149 }
            r5.<init>()     // Catch:{ all -> 0x0149 }
            java.lang.String r6 = "Error while generating thumbnail: "
            r5.append(r6)     // Catch:{ all -> 0x0149 }
            r5.append(r1)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = " "
            r5.append(r1)     // Catch:{ all -> 0x0149 }
            r5.append(r0)     // Catch:{ all -> 0x0149 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0149 }
            r4.<init>((java.lang.String) r0)     // Catch:{ all -> 0x0149 }
            throw r4     // Catch:{ all -> 0x0149 }
        L_0x0149:
            r0 = move-exception
        L_0x014a:
            com.kbeanie.multipicker.utils.StreamHelper.close(r3)
            com.kbeanie.multipicker.utils.StreamHelper.flush(r2)
            com.kbeanie.multipicker.utils.StreamHelper.close(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kbeanie.multipicker.core.threads.FileProcessorThread.downScaleAndSaveImage(java.lang.String, int, int):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public String getWidthOfImage(String str) {
        try {
            String attribute = new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);
            if (!"0".equals(attribute)) {
                return attribute;
            }
            SoftReference<Bitmap> bitmapImage = getBitmapImage(str);
            String num = Integer.toString(bitmapImage.get().getWidth());
            bitmapImage.clear();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String getHeightOfImage(String str) {
        try {
            String attribute = new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);
            if (!"0".equals(attribute)) {
                return attribute;
            }
            SoftReference<Bitmap> bitmapImage = getBitmapImage(str);
            String num = Integer.toString(bitmapImage.get().getHeight());
            bitmapImage.clear();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public SoftReference<Bitmap> getBitmapImage(String str) {
        return new SoftReference<>(BitmapFactory.decodeFile(Uri.fromFile(new File(str)).getPath()));
    }

    /* access modifiers changed from: protected */
    public int getOrientation(String str) {
        try {
            return new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
