package com.budiyev.android.codescanner;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class BarcodeUtils {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_270 = 270;
    public static final int ROTATION_90 = 90;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Rotation {
    }

    private BarcodeUtils() {
    }

    public static Result decodeBitmap(Bitmap bitmap) {
        return decodeBitmap(bitmap, (Map<DecodeHintType, ?>) null);
    }

    public static Result decodeBitmap(Bitmap bitmap, Map<DecodeHintType, ?> map) {
        Objects.requireNonNull(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return decodeRgb(iArr, width, height, map);
    }

    public static Result decodeRgb(int[] iArr, int i, int i2) {
        return decodeRgb(iArr, i, i2, (Map<DecodeHintType, ?>) null);
    }

    public static Result decodeRgb(int[] iArr, int i, int i2, Map<DecodeHintType, ?> map) {
        Objects.requireNonNull(iArr);
        try {
            return Utils.decodeLuminanceSource(createReader(map), new RGBLuminanceSource(i, i2, iArr));
        } catch (ReaderException unused) {
            return null;
        }
    }

    public static Result decodeYuv(byte[] bArr, int i, int i2) {
        return decodeYuv(bArr, i, i2, 0, false, (Map<DecodeHintType, ?>) null);
    }

    public static Result decodeYuv(byte[] bArr, int i, int i2, int i3, boolean z, Map<DecodeHintType, ?> map) {
        int i4;
        int i5;
        Objects.requireNonNull(bArr);
        byte[] rotateYuv = Utils.rotateYuv(bArr, i, i2, i3);
        if (i3 == 90 || i3 == 270) {
            i4 = i;
            i5 = i2;
        } else {
            i5 = i;
            i4 = i2;
        }
        try {
            return Utils.decodeLuminanceSource(createReader(map), new PlanarYUVLuminanceSource(rotateYuv, i5, i4, 0, 0, i5, i4, z));
        } catch (ReaderException unused) {
            return null;
        }
    }

    public static BitMatrix encodeBitMatrix(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encodeBitMatrix(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public static BitMatrix encodeBitMatrix(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(barcodeFormat);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        if (map == null) {
            return multiFormatWriter.encode(str, barcodeFormat, i, i2);
        }
        try {
            return multiFormatWriter.encode(str, barcodeFormat, i, i2, map);
        } catch (WriterException unused) {
            return null;
        }
    }

    public static Bitmap encodeBitmap(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encodeBitmap(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    public static Bitmap encodeBitmap(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        BitMatrix encodeBitMatrix = encodeBitMatrix(str, barcodeFormat, i, i2, map);
        if (encodeBitMatrix != null) {
            return createBitmap(encodeBitMatrix);
        }
        return null;
    }

    public static Bitmap createBitmap(BitMatrix bitMatrix) {
        Objects.requireNonNull(bitMatrix);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = bitMatrix.get(i2 % width, i2 / height) ? ViewCompat.MEASURED_STATE_MASK : -1;
        }
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    private static MultiFormatReader createReader(Map<DecodeHintType, ?> map) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        if (map != null) {
            multiFormatReader.setHints(map);
        } else {
            multiFormatReader.setHints(Collections.singletonMap(DecodeHintType.POSSIBLE_FORMATS, CodeScanner.ALL_FORMATS));
        }
        return multiFormatReader;
    }
}
