package com.kbeanie.multipicker.utils;

public class BitmapUtils {
    public static int[] getScaledDimensions(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (i <= i3 && i2 <= i4) {
            iArr[0] = i;
            iArr[1] = i2;
        } else if (i2 >= i4 && i <= i3) {
            iArr[0] = (int) ((((float) i) / ((float) i2)) * ((float) i4));
            iArr[1] = i4;
        } else if (i >= i3 && i2 <= i4) {
            iArr[0] = i3;
            iArr[1] = (int) (((float) i3) / (((float) i) / ((float) i2)));
        } else if (i >= i3 && i2 >= i4) {
            if (i2 > i4) {
                iArr[0] = (int) ((((float) i) / ((float) i2)) * ((float) i4));
                iArr[1] = i4;
            } else {
                iArr[0] = i3;
                iArr[1] = (int) (((float) i3) / (((float) i) / ((float) i2)));
            }
        }
        return iArr;
    }
}
