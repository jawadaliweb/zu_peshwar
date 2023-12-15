package com.kbeanie.multipicker.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.VideoPickerImpl;

public class CameraVideoPicker extends VideoPickerImpl {
    public CameraVideoPicker(Activity activity) {
        super(activity, (int) Picker.PICK_VIDEO_CAMERA);
    }

    public CameraVideoPicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_VIDEO_CAMERA);
    }

    public CameraVideoPicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_VIDEO_CAMERA);
    }

    public CameraVideoPicker(Activity activity, String str) {
        super(activity, (int) Picker.PICK_VIDEO_CAMERA);
        reinitialize(str);
    }

    public CameraVideoPicker(Fragment fragment, String str) {
        super(fragment, (int) Picker.PICK_VIDEO_CAMERA);
        reinitialize(str);
    }

    public CameraVideoPicker(android.app.Fragment fragment, String str) {
        super(fragment, (int) Picker.PICK_VIDEO_CAMERA);
        reinitialize(str);
    }

    public String pickVideo() {
        try {
            return super.pick();
        } catch (PickerException e) {
            e.printStackTrace();
            if (this.callback != null) {
                this.callback.onError(e.getMessage());
            }
            return null;
        }
    }
}
