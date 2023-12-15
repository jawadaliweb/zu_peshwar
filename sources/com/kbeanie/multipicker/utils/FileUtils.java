package com.kbeanie.multipicker.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.ContextCompat;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import storage.StoragePreferences;

public class FileUtils {
    private static final String TAG = "FileUtils";

    public static String getExternalFilesDirectory(String str, Context context) throws PickerException {
        if (Build.VERSION.SDK_INT < 23 || checkForExternalStorageRuntimePermission(context)) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String appName = getAppName(context);
            File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + appName);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file.getAbsolutePath() + File.separator + appName + MaskedEditText.SPACE + str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.getAbsolutePath();
        }
        Log.e(TAG, "android.permission.WRITE_EXTERNAL_STORAGE permission not available");
        throw new PickerException("android.permission.WRITE_EXTERNAL_STORAGE permission not available");
    }

    private static String getAppName(Context context) {
        String str;
        StoragePreferences storagePreferences = new StoragePreferences(context);
        String folderName = storagePreferences.getFolderName();
        if (folderName != null && !folderName.isEmpty()) {
            return folderName;
        }
        try {
            return context.getString(context.getApplicationInfo().labelRes);
        } catch (Exception unused) {
            String packageName = context.getPackageName();
            if (packageName.contains(".")) {
                str = packageName.substring(packageName.lastIndexOf(".") + 1);
            } else {
                str = context.getPackageName();
            }
            String str2 = str;
            storagePreferences.setFolderName(str2);
            return str2;
        }
    }

    public static String getExternalFilesDir(String str, Context context) throws PickerException {
        if (Build.VERSION.SDK_INT < 23 || checkForExternalStorageRuntimePermission(context)) {
            File externalFilesDir = context.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                return externalFilesDir.getAbsolutePath();
            }
            throw new PickerException("Couldn't initialize External Files Directory");
        }
        Log.e(TAG, "android.permission.WRITE_EXTERNAL_STORAGE permission not available");
        throw new PickerException("android.permission.WRITE_EXTERNAL_STORAGE permission not available");
    }

    private static boolean checkForExternalStorageRuntimePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String getExternalCacheDir(Context context) throws PickerException {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        throw new PickerException("Couldn't intialize External Cache Directory");
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else if (file2.getParentFile() != null && !file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        } else if (!file2.exists() || file2.canWrite()) {
            doCopyFile(file, file2, z);
        } else {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        if (!file2.exists() || !file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                copy(fileInputStream, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileInputStream.close();
                if (file.length() != file2.length()) {
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                } else if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } else {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[2048];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static String getInternalFileDirectory(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }
}
