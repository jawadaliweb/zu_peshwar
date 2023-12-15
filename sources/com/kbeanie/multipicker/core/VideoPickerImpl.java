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
import com.kbeanie.multipicker.api.callbacks.VideoPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenVideo;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.threads.VideoProcessorThread;
import com.kbeanie.multipicker.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class VideoPickerImpl extends PickerManager {
    private static final String TAG = "VideoPickerImpl";
    protected VideoPickerCallback callback;
    private boolean generateMetadata = true;
    private boolean generatePreviewImages = true;
    private String path;
    private int quality = 100;

    public VideoPickerImpl(Activity activity, int i) {
        super(activity, i);
    }

    public VideoPickerImpl(Fragment fragment, int i) {
        super(fragment, i);
    }

    public VideoPickerImpl(android.app.Fragment fragment, int i) {
        super(fragment, i);
    }

    public void reinitialize(String str) {
        this.path = str;
    }

    public void setVideoPickerCallback(VideoPickerCallback videoPickerCallback) {
        this.callback = videoPickerCallback;
    }

    public void shouldGeneratePreviewImages(boolean z) {
        this.generatePreviewImages = z;
    }

    public void shouldGenerateMetadata(boolean z) {
        this.generateMetadata = z;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    /* access modifiers changed from: protected */
    public String pick() throws PickerException {
        if (this.callback == null) {
            throw new PickerException("VideoPickerCallback null!!! Please set one");
        } else if (this.pickerType == 5333) {
            return pickLocalVideo();
        } else {
            if (this.pickerType != 6444) {
                return null;
            }
            String takeVideoWithCamera = takeVideoWithCamera();
            this.path = takeVideoWithCamera;
            return takeVideoWithCamera;
        }
    }

    /* access modifiers changed from: protected */
    public String takeVideoWithCamera() throws PickerException {
        Uri uri;
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            str = getNewFileLocation("mp4", Environment.DIRECTORY_MOVIES);
            uri = FileProvider.getUriForFile(getContext(), getFileProviderAuthority(), new File(str));
            String str2 = TAG;
            LogUtils.d(str2, "takeVideoWithCamera: Temp Uri: " + uri.getPath());
        } else {
            str = buildFilePath("mp4", Environment.DIRECTORY_MOVIES);
            uri = Uri.fromFile(new File(str));
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", uri);
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        String str3 = TAG;
        LogUtils.d(str3, "Temp Path for Camera capture: " + str);
        pickInternal(intent, Picker.PICK_VIDEO_CAMERA);
        return str;
    }

    /* access modifiers changed from: protected */
    public String pickLocalVideo() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        intent.addFlags(1);
        pickInternal(intent, Picker.PICK_VIDEO_DEVICE);
        return null;
    }

    public void submit(Intent intent) {
        if (this.pickerType == 6444) {
            handleCameraData(intent);
        } else if (this.pickerType == 5333) {
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
        File file = new File(this.path);
        if (!file.exists()) {
            arrayList.add(intent.getDataString());
        } else {
            arrayList.add(Uri.fromFile(file).toString());
        }
        processVideos(arrayList);
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
                LogUtils.d(TAG, "handleGalleryData: Multiple videos with ClipData");
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
            processVideos(arrayList);
        }
    }

    private void processVideos(List<String> list) {
        VideoProcessorThread videoProcessorThread = new VideoProcessorThread(getContext(), getVideoObjects(list), this.cacheLocation);
        videoProcessorThread.setRequestId(this.requestId);
        videoProcessorThread.setShouldGeneratePreviewImages(this.generatePreviewImages);
        videoProcessorThread.setShouldGenerateMetadata(this.generateMetadata);
        videoProcessorThread.setThumbnailsImageQuality(this.quality);
        videoProcessorThread.setVideoPickerCallback(this.callback);
        videoProcessorThread.start();
    }

    private List<ChosenVideo> getVideoObjects(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String queryUri : list) {
            ChosenVideo chosenVideo = new ChosenVideo();
            chosenVideo.setQueryUri(queryUri);
            chosenVideo.setDirectoryType(Environment.DIRECTORY_MOVIES);
            chosenVideo.setType("video");
            arrayList.add(chosenVideo);
        }
        return arrayList;
    }

    private void onError(final String str) {
        try {
            if (this.callback != null) {
                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        VideoPickerImpl.this.callback.onError(str);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
