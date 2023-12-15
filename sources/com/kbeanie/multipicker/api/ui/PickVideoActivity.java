package com.kbeanie.multipicker.api.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.appcompat.app.AppCompatActivity;
import com.kbeanie.multipicker.api.CameraVideoPicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.VideoPicker;
import com.kbeanie.multipicker.api.callbacks.VideoPickerCallback;
import com.kbeanie.multipicker.core.VideoPickerImpl;

public abstract class PickVideoActivity extends AppCompatActivity implements VideoPickerCallback {
    private CameraVideoPicker cameraVideoPicker;
    private String pickerPath;
    private int pickerType;
    private VideoPicker videoPicker;

    /* access modifiers changed from: protected */
    public void pickSingleVideo() {
        VideoPicker prepareVideoPicker = prepareVideoPicker();
        this.videoPicker = prepareVideoPicker;
        prepareVideoPicker.pickVideo();
        this.pickerType = Picker.PICK_VIDEO_DEVICE;
    }

    /* access modifiers changed from: protected */
    public void pickMultipleVideos() {
        VideoPicker prepareVideoPicker = prepareVideoPicker();
        this.videoPicker = prepareVideoPicker;
        prepareVideoPicker.allowMultiple();
        this.videoPicker.pickVideo();
        this.pickerType = Picker.PICK_VIDEO_DEVICE;
    }

    /* access modifiers changed from: protected */
    public void pickVideoFromCamera() {
        CameraVideoPicker prepareCameraVideoPicker = prepareCameraVideoPicker();
        this.cameraVideoPicker = prepareCameraVideoPicker;
        this.pickerPath = prepareCameraVideoPicker.pickVideo();
        this.pickerType = Picker.PICK_VIDEO_CAMERA;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 6444 || i == 5333) {
            VideoPickerImpl videoPickerImpl = null;
            int i3 = this.pickerType;
            if (i3 == 5333) {
                if (this.videoPicker == null) {
                    this.videoPicker = prepareVideoPicker();
                }
                videoPickerImpl = this.videoPicker;
            } else if (i3 == 6444) {
                if (this.cameraVideoPicker == null) {
                    CameraVideoPicker prepareCameraVideoPicker = prepareCameraVideoPicker();
                    this.cameraVideoPicker = prepareCameraVideoPicker;
                    prepareCameraVideoPicker.reinitialize(this.pickerPath);
                }
                videoPickerImpl = this.cameraVideoPicker;
            }
            videoPickerImpl.submit(intent);
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        bundle.putInt("mpl_picker_type", this.pickerType);
        bundle.putString("mpl_picker_path", this.pickerPath);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.pickerType = bundle.getInt("mpl_picker_type");
        this.pickerPath = bundle.getString("mpl_picker_path");
    }

    private VideoPicker prepareVideoPicker() {
        VideoPicker videoPicker2 = new VideoPicker((Activity) this);
        videoPicker2.setVideoPickerCallback(this);
        return videoPicker2;
    }

    private CameraVideoPicker prepareCameraVideoPicker() {
        CameraVideoPicker cameraVideoPicker2 = new CameraVideoPicker((Activity) this);
        cameraVideoPicker2.setVideoPickerCallback(this);
        return cameraVideoPicker2;
    }
}
