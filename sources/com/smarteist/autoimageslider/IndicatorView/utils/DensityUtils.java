package com.smarteist.autoimageslider.IndicatorView.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DensityUtils {
    public static int dpToPx(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, Resources.getSystem().getDisplayMetrics());
    }

    public static int pxToDp(float f) {
        return (int) TypedValue.applyDimension(0, f, Resources.getSystem().getDisplayMetrics());
    }
}
