package com.kbeanie.multipicker.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.ImagePickerImpl;

public class ImagePicker extends ImagePickerImpl {
    public ImagePicker(Activity activity) {
        super(activity, (int) Picker.PICK_IMAGE_DEVICE);
    }

    public ImagePicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_IMAGE_DEVICE);
    }

    public ImagePicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_IMAGE_DEVICE);
    }

    public void allowMultiple() {
        this.allowMultiple = true;
    }

    public void pickImage() {
        try {
            super.pick();
        } catch (PickerException e) {
            e.printStackTrace();
            if (this.callback != null) {
                this.callback.onError(e.getMessage());
            }
        }
    }
}
