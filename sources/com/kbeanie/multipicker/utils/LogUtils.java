package com.kbeanie.multipicker.utils;

import android.util.Log;
import com.kbeanie.multipicker.core.PickerManager;

public class LogUtils {
    public static void d(String str, String str2) {
        if (PickerManager.debugglable) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (PickerManager.debugglable) {
            Log.e(str, str2);
        }
    }
}
