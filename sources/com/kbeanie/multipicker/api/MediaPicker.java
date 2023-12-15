package com.kbeanie.multipicker.api;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.callbacks.FilePickerCallback;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.callbacks.MediaPickerCallback;
import com.kbeanie.multipicker.api.callbacks.VideoPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.kbeanie.multipicker.api.entity.ChosenVideo;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.PickerManager;
import com.kbeanie.multipicker.core.threads.FileProcessorThread;
import com.kbeanie.multipicker.core.threads.ImageProcessorThread;
import com.kbeanie.multipicker.core.threads.VideoProcessorThread;
import com.kbeanie.multipicker.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaPicker extends PickerManager implements FilePickerCallback, ImagePickerCallback, VideoPickerCallback {
    private static final String TAG = "MediaPicker";
    private MediaPickerCallback callback;
    private boolean generateMetadata = true;
    private boolean generatePreviewImages = true;
    private boolean generateThumbnails = true;
    private List<ChosenImage> images;
    private List<ChosenImage> imagesToProcess;
    private List<ChosenVideo> videos;
    private List<ChosenVideo> videosToProcess;

    public void onError(String str) {
    }

    public MediaPicker(Activity activity) {
        super(activity, (int) Picker.PICK_MEDIA);
    }

    public MediaPicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_MEDIA);
    }

    public MediaPicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_MEDIA);
    }

    public void allowMultiple() {
        this.allowMultiple = true;
    }

    public void shouldGenerateThumbnails(boolean z) {
        this.generateThumbnails = z;
    }

    public void shouldGenerateMetadata(boolean z) {
        this.generateMetadata = z;
    }

    public void shouldGeneratePreviewImages(boolean z) {
        this.generatePreviewImages = z;
    }

    /* access modifiers changed from: protected */
    public String pick() throws PickerException {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (Build.VERSION.SDK_INT >= 19) {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        } else {
            intent.setType("image/*, video/*");
        }
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        intent.addFlags(1);
        pickInternal(intent, Picker.PICK_MEDIA);
        return null;
    }

    public void pickMedia() {
        try {
            pick();
        } catch (PickerException e) {
            e.printStackTrace();
        }
    }

    public void submit(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent != null) {
            if (intent.getDataString() != null && isClipDataApi() && intent.getClipData() == null) {
                String dataString = intent.getDataString();
                String str = TAG;
                LogUtils.d(str, "submit: Uri: " + dataString);
                arrayList.add(dataString);
            } else if (isClipDataApi() && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
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
            if (arrayList.size() == 0 && intent.hasExtra("pick-result-data")) {
                ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("pick-result-data");
                for (int i3 = 0; i3 < parcelableArrayListExtra2.size(); i3++) {
                    arrayList.add(((Uri) parcelableArrayListExtra2.get(i3)).toString());
                }
            }
        }
        processMedia(arrayList);
    }

    private void processMedia(List<String> list) {
        FileProcessorThread fileProcessorThread = new FileProcessorThread(getContext(), getFileObjects(list), this.cacheLocation);
        fileProcessorThread.setFilePickerCallback(this);
        fileProcessorThread.setRequestId(this.requestId);
        fileProcessorThread.start();
    }

    public void setMediaPickerCallback(MediaPickerCallback mediaPickerCallback) {
        this.callback = mediaPickerCallback;
    }

    private List<ChosenFile> getFileObjects(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String queryUri : list) {
            ChosenFile chosenFile = new ChosenFile();
            chosenFile.setQueryUri(queryUri);
            if (Build.VERSION.SDK_INT >= 19) {
                chosenFile.setDirectoryType(Environment.DIRECTORY_DOCUMENTS);
            } else {
                chosenFile.setDirectoryType(Environment.DIRECTORY_DOWNLOADS);
            }
            chosenFile.setType("file");
            arrayList.add(chosenFile);
        }
        return arrayList;
    }

    public void onFilesChosen(List<ChosenFile> list) {
        this.imagesToProcess = new ArrayList();
        this.videosToProcess = new ArrayList();
        for (ChosenFile next : list) {
            if (next.getMimeType().contains("image")) {
                ChosenImage chosenImage = new ChosenImage();
                chosenImage.setQueryUri(Uri.fromFile(new File(next.getOriginalPath())).toString());
                chosenImage.setType("image");
                chosenImage.setDirectoryType(Environment.DIRECTORY_PICTURES);
                chosenImage.setDisplayName(next.getDisplayName());
                chosenImage.setExtension(next.getExtension());
                this.imagesToProcess.add(chosenImage);
            } else if (next.getMimeType().contains("video")) {
                ChosenVideo chosenVideo = new ChosenVideo();
                chosenVideo.setQueryUri(Uri.fromFile(new File(next.getOriginalPath())).toString());
                chosenVideo.setType("video");
                chosenVideo.setDirectoryType(Environment.DIRECTORY_MOVIES);
                chosenVideo.setDisplayName(next.getDisplayName());
                chosenVideo.setExtension(next.getExtension());
                this.videosToProcess.add(chosenVideo);
            }
        }
        List<ChosenImage> list2 = this.imagesToProcess;
        if (list2 == null || list2.size() <= 0) {
            List<ChosenVideo> list3 = this.videosToProcess;
            if (list3 != null && list3.size() > 0) {
                VideoProcessorThread videoProcessorThread = new VideoProcessorThread(getContext(), this.videosToProcess, this.cacheLocation);
                videoProcessorThread.setRequestId(this.requestId);
                videoProcessorThread.setShouldGenerateMetadata(this.generateMetadata);
                videoProcessorThread.setShouldGeneratePreviewImages(this.generatePreviewImages);
                videoProcessorThread.setVideoPickerCallback(this);
                videoProcessorThread.start();
                return;
            }
            return;
        }
        ImageProcessorThread imageProcessorThread = new ImageProcessorThread(getContext(), this.imagesToProcess, this.cacheLocation);
        imageProcessorThread.setImagePickerCallback(this);
        imageProcessorThread.setShouldGenerateMetadata(this.generateMetadata);
        imageProcessorThread.setShouldGenerateThumbnails(this.generateThumbnails);
        imageProcessorThread.setRequestId(this.requestId);
        imageProcessorThread.start();
    }

    public void onImagesChosen(List<ChosenImage> list) {
        this.images = list;
        List<ChosenVideo> list2 = this.videosToProcess;
        if (list2 == null || list2.size() <= 0) {
            MediaPickerCallback mediaPickerCallback = this.callback;
            if (mediaPickerCallback != null) {
                mediaPickerCallback.onMediaChosen(list, (List<ChosenVideo>) null);
                return;
            }
            return;
        }
        VideoProcessorThread videoProcessorThread = new VideoProcessorThread(getContext(), this.videosToProcess, this.cacheLocation);
        videoProcessorThread.setRequestId(this.requestId);
        videoProcessorThread.setShouldGenerateMetadata(this.generateMetadata);
        videoProcessorThread.setShouldGeneratePreviewImages(this.generatePreviewImages);
        videoProcessorThread.setVideoPickerCallback(this);
        videoProcessorThread.start();
    }

    public void onVideosChosen(List<ChosenVideo> list) {
        this.videos = list;
        MediaPickerCallback mediaPickerCallback = this.callback;
        if (mediaPickerCallback != null) {
            mediaPickerCallback.onMediaChosen(this.images, list);
        }
    }
}
