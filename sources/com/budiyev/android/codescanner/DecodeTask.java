package com.budiyev.android.codescanner;

import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;

final class DecodeTask {
    private final byte[] mImage;
    private final Point mImageSize;
    private final int mOrientation;
    private final Point mPreviewSize;
    private final boolean mReverseHorizontal;
    private final Rect mViewFrameRect;
    private final Point mViewSize;

    public DecodeTask(byte[] bArr, Point point, Point point2, Point point3, Rect rect, int i, boolean z) {
        this.mImage = bArr;
        this.mImageSize = point;
        this.mPreviewSize = point2;
        this.mViewSize = point3;
        this.mViewFrameRect = rect;
        this.mOrientation = i;
        this.mReverseHorizontal = z;
    }

    public Result decode(MultiFormatReader multiFormatReader) throws ReaderException {
        int i;
        int i2;
        int x = this.mImageSize.getX();
        int y = this.mImageSize.getY();
        int i3 = this.mOrientation;
        byte[] rotateYuv = Utils.rotateYuv(this.mImage, x, y, i3);
        if (i3 == 90 || i3 == 270) {
            i = x;
            i2 = y;
        } else {
            i2 = x;
            i = y;
        }
        Rect imageFrameRect = Utils.getImageFrameRect(i2, i, this.mViewFrameRect, this.mPreviewSize, this.mViewSize);
        int width = imageFrameRect.getWidth();
        int height = imageFrameRect.getHeight();
        if (width < 1 || height < 1) {
            return null;
        }
        return Utils.decodeLuminanceSource(multiFormatReader, new PlanarYUVLuminanceSource(rotateYuv, i2, i, imageFrameRect.getLeft(), imageFrameRect.getTop(), width, height, this.mReverseHorizontal));
    }
}
