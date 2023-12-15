package com.kbeanie.multipicker.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.ImagePickerImpl;

public class CameraImagePicker extends ImagePickerImpl {
    public CameraImagePicker(Activity activity) {
        super(activity, (int) Picker.PICK_IMAGE_CAMERA);
    }

    public CameraImagePicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_IMAGE_CAMERA);
    }

    public CameraImagePicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_IMAGE_CAMERA);
    }

    public CameraImagePicker(Activity activity, String str) {
        super(activity, (int) Picker.PICK_IMAGE_CAMERA);
        reinitialize(str);
    }

    public CameraImagePicker(Fragment fragment, String str) {
        super(fragment, (int) Picker.PICK_IMAGE_CAMERA);
        reinitialize(str);
    }

    public CameraImagePicker(android.app.Fragment fragment, String str) {
        super(fragment, (int) Picker.PICK_IMAGE_CAMERA);
        reinitialize(str);
    }

    public String pickImage() {
        try {
            return pick();
        } catch (PickerException e) {
            e.printStackTrace();
            if (this.callback != null) {
                this.callback.onError(e.getMessage());
            }
            return null;
        }
    }
}
