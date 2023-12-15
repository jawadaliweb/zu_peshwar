package com.kbeanie.multipicker.core;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.threads.ImageProcessorThread;
import com.kbeanie.multipicker.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ImagePickerImpl extends PickerManager {
    private static final String TAG = "ImagePickerImpl";
    protected ImagePickerCallback callback;
    private boolean generateMetadata = true;
    private boolean generateThumbnails = true;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private String path;
    private int quality = 100;

    public ImagePickerImpl(Activity activity, int i) {
        super(activity, i);
    }

    public ImagePickerImpl(Fragment fragment, int i) {
        super(fragment, i);
    }

    public ImagePickerImpl(android.app.Fragment fragment, int i) {
        super(fragment, i);
    }

    public void shouldGenerateThumbnails(boolean z) {
        this.generateThumbnails = z;
    }

    public void shouldGenerateMetadata(boolean z) {
        this.generateMetadata = z;
    }

    public void reinitialize(String str) {
        this.path = str;
    }

    public void setImagePickerCallback(ImagePickerCallback imagePickerCallback) {
        this.callback = imagePickerCallback;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    public void ensureMaxSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.maxWidth = i;
            this.maxHeight = i2;
        }
    }

    /* access modifiers changed from: protected */
    public String pick() throws PickerException {
        if (this.callback == null) {
            throw new PickerException("ImagePickerCallback is null!!! Please set one.");
        } else if (this.pickerType == 3111) {
            return pickLocalImage();
        } else {
            if (this.pickerType != 4222) {
                return null;
            }
            String takePictureWithCamera = takePictureWithCamera();
            this.path = takePictureWithCamera;
            return takePictureWithCamera;
        }
    }

    /* access modifiers changed from: protected */
    public String pickLocalImage() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 19) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
            intent.addFlags(64);
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        intent.setType("image/*");
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        intent.addFlags(1);
        pickInternal(intent, Picker.PICK_IMAGE_DEVICE);
        return null;
    }

    /* access modifiers changed from: protected */
    public String takePictureWithCamera() throws PickerException {
        Uri uri;
        String str;
        if (Build.VERSION.SDK_INT >= 24 || this.cacheLocation == 400) {
            str = getNewFileLocation("jpeg", Environment.DIRECTORY_PICTURES);
            uri = FileProvider.getUriForFile(getContext(), getFileProviderAuthority(), new File(str));
            String str2 = TAG;
            LogUtils.d(str2, "takeVideoWithCamera: Temp Uri: " + uri.getPath());
        } else {
            str = buildFilePath("jpeg", Environment.DIRECTORY_PICTURES);
            uri = Uri.fromFile(new File(str));
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        String str3 = TAG;
        LogUtils.d(str3, "Temp Path for Camera capture: " + str);
        pickInternal(intent, Picker.PICK_IMAGE_CAMERA);
        return str;
    }

    public void submit(Intent intent) {
        if (this.pickerType == 4222) {
            handleCameraData(intent);
        } else if (this.pickerType == 3111) {
            handleGalleryData(intent);
        }
    }

    private void handleCameraData(Intent intent) {
        String str = TAG;
        LogUtils.d(str, "handleCameraData: " + this.path);
        String str2 = this.path;
        if (str2 == null || str2.isEmpty()) {
            throw new RuntimeException("Camera Path cannot be null. Re-initialize with correct path value.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.fromFile(new File(this.path)).toString());
        processImages(arrayList);
    }

    private void handleGalleryData(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent != null) {
            if (intent.getDataString() != null && isClipDataApi() && intent.getClipData() == null) {
                String dataString = intent.getDataString();
                String str = TAG;
                LogUtils.d(str, "handleGalleryData: " + dataString);
                arrayList.add(dataString);
            } else if (isClipDataApi() && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
                LogUtils.d(TAG, "handleGalleryData: Multiple images with ClipData");
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item itemAt = clipData.getItemAt(i);
                    String str2 = TAG;
                    LogUtils.d(str2, "Item [" + i + "]: " + itemAt.getUri().toString());
                    arrayList.add(itemAt.getUri().toString());
                }
            }
            if (intent.hasExtra("uris")) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("uris");
                for (int i2 = 0; i2 < parcelableArrayListExtra.size(); i2++) {
                    arrayList.add(((Uri) parcelableArrayListExtra.get(i2)).toString());
                }
            }
            processImages(arrayList);
        }
    }

    private void onError(final String str) {
        try {
            if (this.callback != null) {
                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        ImagePickerImpl.this.callback.onError(str);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void processImages(List<String> list) {
        int i;
        ImageProcessorThread imageProcessorThread = new ImageProcessorThread(getContext(), getImageObjects(list), this.cacheLocation);
        int i2 = this.maxWidth;
        if (!(i2 == -1 || (i = this.maxHeight) == -1)) {
            imageProcessorThread.setOutputImageDimensions(i2, i);
        }
        imageProcessorThread.setRequestId(this.requestId);
        imageProcessorThread.setShouldGenerateThumbnails(this.generateThumbnails);
        imageProcessorThread.setShouldGenerateMetadata(this.generateMetadata);
        imageProcessorThread.setOutputImageQuality(this.quality);
        imageProcessorThread.setImagePickerCallback(this.callback);
        imageProcessorThread.start();
    }

    private List<ChosenImage> getImageObjects(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String queryUri : list) {
            ChosenImage chosenImage = new ChosenImage();
            chosenImage.setQueryUri(queryUri);
            chosenImage.setDirectoryType(Environment.DIRECTORY_PICTURES);
            chosenImage.setType("image");
            arrayList.add(chosenImage);
        }
        return arrayList;
    }
}
