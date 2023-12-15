package com.kbeanie.multipicker.core.threads;

import android.content.Context;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.utils.LogUtils;
import java.util.List;

public final class ImageProcessorThread extends FileProcessorThread {
    private static final String TAG = "ImageProcessorThread";
    /* access modifiers changed from: private */
    public ImagePickerCallback callback;
    private int maxImageHeight = -1;
    private int maxImageWidth = -1;
    private int quality = 100;
    private boolean shouldGenerateMetadata;
    private boolean shouldGenerateThumbnails;

    public ImageProcessorThread(Context context, List<ChosenImage> list, int i) {
        super(context, list, i);
    }

    public void setShouldGenerateThumbnails(boolean z) {
        this.shouldGenerateThumbnails = z;
    }

    public void setImagePickerCallback(ImagePickerCallback imagePickerCallback) {
        this.callback = imagePickerCallback;
    }

    public void run() {
        super.run();
        postProcessImages();
        onDone();
    }

    private void onDone() {
        try {
            if (this.callback != null) {
                getActivityFromContext().runOnUiThread(new Runnable() {
                    public void run() {
                        ImageProcessorThread.this.callback.onImagesChosen(ImageProcessorThread.this.files);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void postProcessImages() {
        for (ChosenFile chosenFile : this.files) {
            ChosenImage chosenImage = (ChosenImage) chosenFile;
            try {
                postProcessImage(chosenImage);
                chosenImage.setSuccess(true);
            } catch (PickerException e) {
                e.printStackTrace();
                chosenImage.setSuccess(false);
            }
        }
    }

    private ChosenImage postProcessImage(ChosenImage chosenImage) throws PickerException {
        int i;
        int i2 = this.maxImageWidth;
        if (!(i2 == -1 || (i = this.maxImageHeight) == -1)) {
            chosenImage = ensureMaxWidthAndHeight(i2, i, this.quality, chosenImage);
        }
        String str = TAG;
        LogUtils.d(str, "postProcessImage: " + chosenImage.getMimeType());
        if (this.shouldGenerateMetadata) {
            try {
                chosenImage = generateMetadata(chosenImage);
            } catch (Exception e) {
                LogUtils.d(TAG, "postProcessImage: Error generating metadata");
                e.printStackTrace();
            }
        }
        if (this.shouldGenerateThumbnails) {
            chosenImage = generateThumbnails(chosenImage);
        }
        String str2 = TAG;
        LogUtils.d(str2, "postProcessImage: " + chosenImage);
        return chosenImage;
    }

    private ChosenImage generateMetadata(ChosenImage chosenImage) {
        chosenImage.setWidth(Integer.parseInt(getWidthOfImage(chosenImage.getOriginalPath())));
        chosenImage.setHeight(Integer.parseInt(getHeightOfImage(chosenImage.getOriginalPath())));
        chosenImage.setOrientation(getOrientation(chosenImage.getOriginalPath()));
        return chosenImage;
    }

    private ChosenImage generateThumbnails(ChosenImage chosenImage) throws PickerException {
        chosenImage.setThumbnailPath(downScaleAndSaveImage(chosenImage.getOriginalPath(), 1, this.quality));
        chosenImage.setThumbnailSmallPath(downScaleAndSaveImage(chosenImage.getOriginalPath(), 2, this.quality));
        return chosenImage;
    }

    public void setShouldGenerateMetadata(boolean z) {
        this.shouldGenerateMetadata = z;
    }

    public void setOutputImageDimensions(int i, int i2) {
        this.maxImageWidth = i;
        this.maxImageHeight = i2;
    }

    public void setOutputImageQuality(int i) {
        this.quality = i;
    }
}
