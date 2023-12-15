package com.kbeanie.multipicker.api.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.appcompat.app.AppCompatActivity;
import com.kbeanie.multipicker.api.CameraImagePicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.Picker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.core.ImagePickerImpl;

public abstract class PickImageActivity extends AppCompatActivity implements ImagePickerCallback {
    private CameraImagePicker cameraImagePicker;
    private ImagePicker imagePicker;
    private String pickerPath;
    private int pickerType;

    /* access modifiers changed from: protected */
    public void pickSingleImage() {
        ImagePicker prepareImagePicker = prepareImagePicker();
        this.imagePicker = prepareImagePicker;
        prepareImagePicker.pickImage();
        this.pickerType = Picker.PICK_IMAGE_DEVICE;
    }

    /* access modifiers changed from: protected */
    public void pickMultipleImages() {
        ImagePicker prepareImagePicker = prepareImagePicker();
        this.imagePicker = prepareImagePicker;
        prepareImagePicker.allowMultiple();
        this.imagePicker.pickImage();
        this.pickerType = Picker.PICK_IMAGE_DEVICE;
    }

    /* access modifiers changed from: protected */
    public void pickImageFromCamera() {
        CameraImagePicker prepareCameraImagePicker = prepareCameraImagePicker();
        this.cameraImagePicker = prepareCameraImagePicker;
        this.pickerPath = prepareCameraImagePicker.pickImage();
        this.pickerType = Picker.PICK_IMAGE_CAMERA;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 4222 || i == 3111) {
            ImagePickerImpl imagePickerImpl = null;
            int i3 = this.pickerType;
            if (i3 == 3111) {
                if (this.imagePicker == null) {
                    this.imagePicker = prepareImagePicker();
                }
                imagePickerImpl = this.imagePicker;
            } else if (i3 == 4222) {
                if (this.cameraImagePicker == null) {
                    CameraImagePicker prepareCameraImagePicker = prepareCameraImagePicker();
                    this.cameraImagePicker = prepareCameraImagePicker;
                    prepareCameraImagePicker.reinitialize(this.pickerPath);
                }
                imagePickerImpl = this.cameraImagePicker;
            }
            imagePickerImpl.submit(intent);
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

    private ImagePicker prepareImagePicker() {
        ImagePicker imagePicker2 = new ImagePicker((Activity) this);
        imagePicker2.setImagePickerCallback(this);
        return imagePicker2;
    }

    private CameraImagePicker prepareCameraImagePicker() {
        CameraImagePicker cameraImagePicker2 = new CameraImagePicker((Activity) this);
        cameraImagePicker2.setImagePickerCallback(this);
        return cameraImagePicker2;
    }
}
