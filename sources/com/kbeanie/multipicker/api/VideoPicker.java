package com.kbeanie.multipicker.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.VideoPickerImpl;

public class VideoPicker extends VideoPickerImpl {
    public VideoPicker(Activity activity) {
        super(activity, (int) Picker.PICK_VIDEO_DEVICE);
    }

    public VideoPicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_VIDEO_DEVICE);
    }

    public VideoPicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_VIDEO_DEVICE);
    }

    public void allowMultiple() {
        this.allowMultiple = true;
    }

    public void pickVideo() {
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
