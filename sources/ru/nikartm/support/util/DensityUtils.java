package ru.nikartm.support.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class DensityUtils {
    public static float dpToPx(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static float pxToDp(float f) {
        return TypedValue.applyDimension(0, f, Resources.getSystem().getDisplayMetrics());
    }

    public static float txtPxToSp(float f) {
        return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }
}
