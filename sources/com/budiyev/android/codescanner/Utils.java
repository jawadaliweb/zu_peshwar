package com.budiyev.android.codescanner;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.WindowManager;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.UByte;
import kotlinx.coroutines.DebugKt;

final class Utils {
    private static final float DISTORTION_STEP = 0.1f;
    private static final float MAX_DISTORTION = 3.0f;
    private static final int MAX_FPS = 30000;
    private static final float MIN_DISTORTION = 0.3f;
    private static final int MIN_FPS = 10000;
    private static final int MIN_PREVIEW_PIXELS = 589824;

    public static final class SuppressErrorCallback implements ErrorCallback {
        public void onError(Exception exc) {
        }
    }

    public static boolean isPortrait(int i) {
        return i == 90 || i == 270;
    }

    private Utils() {
    }

    public static Point findSuitableImageSize(Camera.Parameters parameters, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes != null && !supportedPreviewSizes.isEmpty()) {
            Collections.sort(supportedPreviewSizes, new CameraSizeComparator());
            float f = ((float) i) / ((float) i2);
            for (float f2 = 0.3f; f2 <= MAX_DISTORTION; f2 += 0.1f) {
                for (Camera.Size next : supportedPreviewSizes) {
                    int i3 = next.width;
                    int i4 = next.height;
                    if (i3 * i4 >= MIN_PREVIEW_PIXELS && Math.abs(f - (((float) i3) / ((float) i4))) <= f2) {
                        return new Point(i3, i4);
                    }
                }
            }
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        if (previewSize != null) {
            return new Point(previewSize.width, previewSize.height);
        }
        throw new CodeScannerException("Unable to configure camera preview size");
    }

    public static void configureFpsRange(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            Collections.sort(supportedPreviewFpsRange, new FpsRangeComparator());
            for (int[] next : supportedPreviewFpsRange) {
                if (next[0] >= 10000 && next[1] <= MAX_FPS) {
                    parameters.setPreviewFpsRange(next[0], next[1]);
                    return;
                }
            }
        }
    }

    public static void configureSceneMode(Camera.Parameters parameters) {
        List<String> supportedSceneModes;
        if (!"barcode".equals(parameters.getSceneMode()) && (supportedSceneModes = parameters.getSupportedSceneModes()) != null && supportedSceneModes.contains("barcode")) {
            parameters.setSceneMode("barcode");
        }
    }

    public static void configureVideoStabilization(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported() && !parameters.getVideoStabilization()) {
            parameters.setVideoStabilization(true);
        }
    }

    public static void configureFocusArea(Camera.Parameters parameters, Rect rect, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList(1);
        Rect bound = rect.rotate((float) (-i3), ((float) i) / 2.0f, ((float) i2) / 2.0f).bound(0, 0, i, i2);
        arrayList.add(new Camera.Area(new Rect(mapCoordinate(bound.getLeft(), i), mapCoordinate(bound.getTop(), i2), mapCoordinate(bound.getRight(), i), mapCoordinate(bound.getBottom(), i2)), 1000));
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
    }

    public static void configureDefaultFocusArea(Camera.Parameters parameters, Rect rect, Point point, Point point2, int i, int i2, int i3) {
        boolean isPortrait = isPortrait(i3);
        int i4 = isPortrait ? i2 : i;
        if (!isPortrait) {
            i = i2;
        }
        configureFocusArea(parameters, getImageFrameRect(i4, i, rect, point, point2), i4, i, i3);
    }

    public static void configureDefaultFocusArea(Camera.Parameters parameters, DecoderWrapper decoderWrapper, Rect rect) {
        Point imageSize = decoderWrapper.getImageSize();
        configureDefaultFocusArea(parameters, rect, decoderWrapper.getPreviewSize(), decoderWrapper.getViewSize(), imageSize.getX(), imageSize.getY(), decoderWrapper.getDisplayOrientation());
    }

    public static void configureFocusModeForTouch(Camera.Parameters parameters) {
        List<String> supportedFocusModes;
        if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
    }

    public static void disableAutoFocus(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
            String focusMode = parameters.getFocusMode();
            if (supportedFocusModes.contains("fixed")) {
                if (!"fixed".equals(focusMode)) {
                    parameters.setFocusMode("fixed");
                }
            } else if (supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && !DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(focusMode)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
        }
    }

    public static void setAutoFocusMode(Camera.Parameters parameters, AutoFocusMode autoFocusMode) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
            if (autoFocusMode == AutoFocusMode.CONTINUOUS) {
                if (!"continuous-picture".equals(parameters.getFocusMode())) {
                    if (supportedFocusModes.contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
        }
    }

    public static void setFlashMode(Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (!str.equals(parameters.getFlashMode()) && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && supportedFlashModes.contains(str)) {
            parameters.setFlashMode(str);
        }
    }

    public static void setZoom(Camera.Parameters parameters, int i) {
        if (parameters.isZoomSupported() && parameters.getZoom() != i) {
            int maxZoom = parameters.getMaxZoom();
            if (i <= maxZoom) {
                parameters.setZoom(i);
            } else {
                parameters.setZoom(maxZoom);
            }
        }
    }

    public static int getDisplayOrientation(Context context, Camera.CameraInfo cameraInfo) {
        int i;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            int i2 = 180;
            if (rotation == 0) {
                i = 0;
            } else if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            } else if (rotation % 90 == 0) {
                i = (rotation + 360) % 360;
            } else {
                throw new CodeScannerException("Invalid display rotation");
            }
            if (cameraInfo.facing != 1) {
                i2 = 360;
            }
            return ((i2 + cameraInfo.orientation) - i) % 360;
        }
        throw new CodeScannerException("Unable to access window manager");
    }

    public static Point getPreviewSize(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return new Point(i3, i4);
        }
        int i5 = (i * i4) / i2;
        if (i5 < i3) {
            return new Point(i3, (i2 * i3) / i);
        }
        return new Point(i5, i4);
    }

    public static Rect getImageFrameRect(int i, int i2, Rect rect, Point point, Point point2) {
        int x = point.getX();
        int y = point.getY();
        int x2 = (x - point2.getX()) / 2;
        int y2 = (y - point2.getY()) / 2;
        float f = ((float) i) / ((float) x);
        float f2 = ((float) i2) / ((float) y);
        return new Rect(Math.max(Math.round(((float) (rect.getLeft() + x2)) * f), 0), Math.max(Math.round(((float) (rect.getTop() + y2)) * f2), 0), Math.min(Math.round(((float) (rect.getRight() + x2)) * f), i), Math.min(Math.round(((float) (rect.getBottom() + y2)) * f2), i2));
    }

    public static byte[] rotateYuv(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i6 == 0 || i6 == 360) {
            return bArr2;
        }
        if (i6 % 90 != 0 || i6 < 0 || i6 > 270) {
            throw new IllegalArgumentException("Invalid rotation (valid: 0, 90, 180, 270)");
        }
        byte[] bArr3 = new byte[bArr2.length];
        int i7 = i4 * i5;
        boolean z = i6 % 180 != 0;
        boolean z2 = i6 % 270 != 0;
        boolean z3 = i6 >= 180;
        for (int i8 = 0; i8 < i5; i8++) {
            for (int i9 = 0; i9 < i4; i9++) {
                int i10 = (i8 * i4) + i9;
                int i11 = ((i8 >> 1) * i4) + i7 + (i9 & -2);
                int i12 = i11 + 1;
                int i13 = z ? i5 : i4;
                int i14 = z ? i4 : i5;
                int i15 = z ? i8 : i9;
                int i16 = z ? i9 : i8;
                if (z2) {
                    i15 = (i13 - i15) - 1;
                }
                if (z3) {
                    i16 = (i14 - i16) - 1;
                }
                int i17 = i7 + ((i16 >> 1) * i13) + (i15 & -2);
                bArr3[(i16 * i13) + i15] = (byte) (bArr2[i10] & UByte.MAX_VALUE);
                bArr3[i17] = (byte) (bArr2[i11] & UByte.MAX_VALUE);
                bArr3[i17 + 1] = (byte) (bArr2[i12] & UByte.MAX_VALUE);
            }
        }
        return bArr3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        return r2.decodeWithState(new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(r3.invert())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r2.reset();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.Result decodeLuminanceSource(com.google.zxing.MultiFormatReader r2, com.google.zxing.LuminanceSource r3) throws com.google.zxing.ReaderException {
        /*
            com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap     // Catch:{ NotFoundException -> 0x0014 }
            com.google.zxing.common.HybridBinarizer r1 = new com.google.zxing.common.HybridBinarizer     // Catch:{ NotFoundException -> 0x0014 }
            r1.<init>(r3)     // Catch:{ NotFoundException -> 0x0014 }
            r0.<init>(r1)     // Catch:{ NotFoundException -> 0x0014 }
            com.google.zxing.Result r3 = r2.decodeWithState(r0)     // Catch:{ NotFoundException -> 0x0014 }
            r2.reset()
            return r3
        L_0x0012:
            r3 = move-exception
            goto L_0x002a
        L_0x0014:
            com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap     // Catch:{ all -> 0x0012 }
            com.google.zxing.common.HybridBinarizer r1 = new com.google.zxing.common.HybridBinarizer     // Catch:{ all -> 0x0012 }
            com.google.zxing.LuminanceSource r3 = r3.invert()     // Catch:{ all -> 0x0012 }
            r1.<init>(r3)     // Catch:{ all -> 0x0012 }
            r0.<init>(r1)     // Catch:{ all -> 0x0012 }
            com.google.zxing.Result r3 = r2.decodeWithState(r0)     // Catch:{ all -> 0x0012 }
            r2.reset()
            return r3
        L_0x002a:
            r2.reset()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.Utils.decodeLuminanceSource(com.google.zxing.MultiFormatReader, com.google.zxing.LuminanceSource):com.google.zxing.Result");
    }

    private static int mapCoordinate(int i, int i2) {
        return ((i * 2000) / i2) + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    }

    private static final class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        public int compare(Camera.Size size, Camera.Size size2) {
            return Integer.compare(size2.height * size2.width, size.height * size.width);
        }
    }

    private static final class FpsRangeComparator implements Comparator<int[]> {
        private FpsRangeComparator() {
        }

        public int compare(int[] iArr, int[] iArr2) {
            int compare = Integer.compare(iArr2[1], iArr[1]);
            return compare == 0 ? Integer.compare(iArr2[0], iArr[0]) : compare;
        }
    }
}
