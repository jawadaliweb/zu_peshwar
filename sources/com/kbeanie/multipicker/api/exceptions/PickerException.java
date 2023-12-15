package com.kbeanie.multipicker.api.exceptions;

import android.content.ActivityNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PickerException extends Exception {
    public PickerException(String str) {
        super(str);
    }

    public PickerException(ActivityNotFoundException activityNotFoundException) {
        super(activityNotFoundException);
    }

    public PickerException(FileNotFoundException fileNotFoundException) {
        super(fileNotFoundException);
    }

    public PickerException(IOException iOException) {
        super(iOException);
    }
}
