package com.richpath.util;

import android.content.Context;
import android.graphics.Color;

class Utils {
    Utils() {
    }

    static float dpToPixel(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    static float getDimenFromString(String str) {
        int i = 3;
        if (str.charAt(str.length() - 3) != 'd') {
            i = 2;
        }
        return Float.parseFloat(str.substring(0, str.length() - i));
    }

    static int getColorFromString(String str) {
        if (str.length() == 7 || str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.length() == 4) {
            return Color.parseColor("#" + str.charAt(1) + str.charAt(1) + str.charAt(2) + str.charAt(2) + str.charAt(3) + str.charAt(3));
        } else if (str.length() != 2) {
            return 0;
        } else {
            return Color.parseColor("#" + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1));
        }
    }
}
