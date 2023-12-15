package com.kbeanie.multipicker.core.threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import com.kbeanie.multipicker.api.callbacks.VideoPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenVideo;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.utils.LogUtils;
import com.kbeanie.multipicker.utils.StreamHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class VideoProcessorThread extends FileProcessorThread {
    private static final String TAG = "VideoProcessorThread";
    /* access modifiers changed from: private */
    public VideoPickerCallback callback;
    private int quality = 100;
    private boolean shouldGenerateMetadata;
    private boolean shouldGeneratePreviewImages;

    public VideoProcessorThread(Context context, List<? extends ChosenFile> list, int i) {
        super(context, list, i);
    }

    public void setVideoPickerCallback(VideoPickerCallback videoPickerCallback) {
        this.callback = videoPickerCallback;
    }

    public void run() {
        super.run();
        postProcessVideos();
        onDone();
    }

    private void postProcessVideos() {
        for (ChosenFile chosenFile : this.files) {
            ChosenVideo chosenVideo = (ChosenVideo) chosenFile;
            try {
                postProcessVideo(chosenVideo);
                chosenVideo.setSuccess(true);
            } catch (PickerException e) {
                e.printStackTrace();
                chosenVideo.setSuccess(false);
            }
        }
    }

    private void postProcessVideo(ChosenVideo chosenVideo) throws PickerException {
        if (this.shouldGenerateMetadata) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(chosenVideo.getOriginalPath());
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                String str = null;
                String extractMetadata2 = Build.VERSION.SDK_INT >= 17 ? mediaMetadataRetriever.extractMetadata(24) : null;
                String extractMetadata3 = Build.VERSION.SDK_INT >= 14 ? mediaMetadataRetriever.extractMetadata(19) : null;
                if (Build.VERSION.SDK_INT >= 14) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                }
                if (extractMetadata != null) {
                    chosenVideo.setDuration(Long.parseLong(extractMetadata));
                }
                if (extractMetadata2 != null) {
                    chosenVideo.setOrientation(Integer.parseInt(extractMetadata2));
                }
                if (extractMetadata3 != null) {
                    chosenVideo.setHeight(Integer.parseInt(extractMetadata3));
                }
                if (str != null) {
                    chosenVideo.setWidth(Integer.parseInt(str));
                }
            } catch (Exception e) {
                LogUtils.d(TAG, "postProcessVideo: Error generating metadata");
                e.printStackTrace();
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
            mediaMetadataRetriever.release();
        }
        if (this.shouldGeneratePreviewImages) {
            String createPreviewImage = createPreviewImage(chosenVideo.getOriginalPath());
            chosenVideo.setPreviewImage(createPreviewImage);
            String downScaleAndSaveImage = downScaleAndSaveImage(createPreviewImage, 1, this.quality);
            String downScaleAndSaveImage2 = downScaleAndSaveImage(createPreviewImage, 2, this.quality);
            chosenVideo.setPreviewThumbnail(downScaleAndSaveImage);
            chosenVideo.setPreviewThumbnailSmall(downScaleAndSaveImage2);
        }
    }

    private void onDone() {
        try {
            if (this.callback != null) {
                getActivityFromContext().runOnUiThread(new Runnable() {
                    public void run() {
                        VideoProcessorThread.this.callback.onVideosChosen(VideoProcessorThread.this.files);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setShouldGenerateMetadata(boolean z) {
        this.shouldGenerateMetadata = z;
    }

    public void setShouldGeneratePreviewImages(boolean z) {
        this.shouldGeneratePreviewImages = z;
    }

    private String createPreviewImage(String str) throws PickerException {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        FileOutputStream fileOutputStream = null;
        if (createVideoThumbnail == null) {
            return null;
        }
        String generateFileNameForVideoPreviewImage = generateFileNameForVideoPreviewImage();
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(generateFileNameForVideoPreviewImage));
            try {
                createVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                StreamHelper.flush(fileOutputStream2);
                StreamHelper.close(fileOutputStream2);
                return generateFileNameForVideoPreviewImage;
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    throw new PickerException(e);
                } catch (Throwable th) {
                    th = th;
                    StreamHelper.flush(fileOutputStream);
                    StreamHelper.close(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                StreamHelper.flush(fileOutputStream);
                StreamHelper.close(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            throw new PickerException(e);
        }
    }

    public void setThumbnailsImageQuality(int i) {
        this.quality = i;
    }
}
