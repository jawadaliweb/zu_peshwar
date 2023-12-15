package com.budiyev.android.codescanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

final class ViewFinderView extends View {
    private int mFrameCornersRadius = 0;
    private int mFrameCornersSize = 0;
    private final Paint mFramePaint;
    private float mFrameRatioHeight = 1.0f;
    private float mFrameRatioWidth = 1.0f;
    private Rect mFrameRect;
    private float mFrameSize = 0.75f;
    private final Paint mMaskPaint;
    private final Path mPath;

    public ViewFinderView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.mMaskPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mFramePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        this.mPath = path;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.mFrameRect;
        if (rect != null) {
            int width = getWidth();
            int height = getHeight();
            float top = (float) rect.getTop();
            float left = (float) rect.getLeft();
            float right = (float) rect.getRight();
            float bottom = (float) rect.getBottom();
            float f = (float) this.mFrameCornersSize;
            float f2 = (float) this.mFrameCornersRadius;
            Path path = this.mPath;
            if (f2 > 0.0f) {
                float min = Math.min(f2, Math.max(f - 1.0f, 0.0f));
                path.reset();
                float f3 = top + min;
                path.moveTo(left, f3);
                float f4 = left + min;
                path.quadTo(left, top, f4, top);
                float f5 = right - min;
                path.lineTo(f5, top);
                path.quadTo(right, top, right, f3);
                float f6 = bottom - min;
                path.lineTo(right, f6);
                path.quadTo(right, bottom, f5, bottom);
                path.lineTo(f4, bottom);
                path.quadTo(left, bottom, left, f6);
                path.lineTo(left, f3);
                path.moveTo(0.0f, 0.0f);
                float f7 = (float) width;
                path.lineTo(f7, 0.0f);
                float f8 = (float) height;
                path.lineTo(f7, f8);
                path.lineTo(0.0f, f8);
                path.lineTo(0.0f, 0.0f);
                canvas.drawPath(path, this.mMaskPaint);
                path.reset();
                float f9 = top + f;
                path.moveTo(left, f9);
                path.lineTo(left, f3);
                path.quadTo(left, top, f4, top);
                float f10 = left + f;
                path.lineTo(f10, top);
                float f11 = right - f;
                path.moveTo(f11, top);
                path.lineTo(f5, top);
                path.quadTo(right, top, right, f3);
                path.lineTo(right, f9);
                float f12 = bottom - f;
                path.moveTo(right, f12);
                path.lineTo(right, f6);
                path.quadTo(right, bottom, f5, bottom);
                path.lineTo(f11, bottom);
                path.moveTo(f10, bottom);
                path.lineTo(f4, bottom);
                path.quadTo(left, bottom, left, f6);
                path.lineTo(left, f12);
                canvas.drawPath(path, this.mFramePaint);
                return;
            }
            path.reset();
            path.moveTo(left, top);
            path.lineTo(right, top);
            path.lineTo(right, bottom);
            path.lineTo(left, bottom);
            path.lineTo(left, top);
            path.moveTo(0.0f, 0.0f);
            float f13 = (float) width;
            path.lineTo(f13, 0.0f);
            float f14 = (float) height;
            path.lineTo(f13, f14);
            path.lineTo(0.0f, f14);
            path.lineTo(0.0f, 0.0f);
            canvas.drawPath(path, this.mMaskPaint);
            path.reset();
            float f15 = top + f;
            path.moveTo(left, f15);
            path.lineTo(left, top);
            float f16 = left + f;
            path.lineTo(f16, top);
            float f17 = right - f;
            path.moveTo(f17, top);
            path.lineTo(right, top);
            path.lineTo(right, f15);
            float f18 = bottom - f;
            path.moveTo(right, f18);
            path.lineTo(right, bottom);
            path.lineTo(f17, bottom);
            path.moveTo(f16, bottom);
            path.lineTo(left, bottom);
            path.lineTo(left, f18);
            canvas.drawPath(path, this.mFramePaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        invalidateFrameRect(i3 - i, i4 - i2);
    }

    /* access modifiers changed from: package-private */
    public Rect getFrameRect() {
        return this.mFrameRect;
    }

    /* access modifiers changed from: package-private */
    public void setFrameAspectRatio(float f, float f2) {
        this.mFrameRatioWidth = f;
        this.mFrameRatioHeight = f2;
        invalidateFrameRect();
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public float getFrameAspectRatioWidth() {
        return this.mFrameRatioWidth;
    }

    /* access modifiers changed from: package-private */
    public void setFrameAspectRatioWidth(float f) {
        this.mFrameRatioWidth = f;
        invalidateFrameRect();
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public float getFrameAspectRatioHeight() {
        return this.mFrameRatioHeight;
    }

    /* access modifiers changed from: package-private */
    public void setFrameAspectRatioHeight(float f) {
        this.mFrameRatioHeight = f;
        invalidateFrameRect();
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getMaskColor() {
        return this.mMaskPaint.getColor();
    }

    /* access modifiers changed from: package-private */
    public void setMaskColor(int i) {
        this.mMaskPaint.setColor(i);
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getFrameColor() {
        return this.mFramePaint.getColor();
    }

    /* access modifiers changed from: package-private */
    public void setFrameColor(int i) {
        this.mFramePaint.setColor(i);
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getFrameThickness() {
        return (int) this.mFramePaint.getStrokeWidth();
    }

    /* access modifiers changed from: package-private */
    public void setFrameThickness(int i) {
        this.mFramePaint.setStrokeWidth((float) i);
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getFrameCornersSize() {
        return this.mFrameCornersSize;
    }

    /* access modifiers changed from: package-private */
    public void setFrameCornersSize(int i) {
        this.mFrameCornersSize = i;
        if (isLaidOut()) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getFrameCornersRadius() {
        return this.mFrameCornersRadius;
    }

    /* access modifiers changed from: package-private */
    public void setFrameCornersRadius(int i) {
        this.mFrameCornersRadius = i;
        if (isLaidOut()) {
            invalidate();
        }
    }

    public float getFrameSize() {
        return this.mFrameSize;
    }

    /* access modifiers changed from: package-private */
    public void setFrameSize(float f) {
        this.mFrameSize = f;
        invalidateFrameRect();
        if (isLaidOut()) {
            invalidate();
        }
    }

    private void invalidateFrameRect() {
        invalidateFrameRect(getWidth(), getHeight());
    }

    private void invalidateFrameRect(int i, int i2) {
        int i3;
        int i4;
        if (i > 0 && i2 > 0) {
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = this.mFrameRatioWidth / this.mFrameRatioHeight;
            if (f / f2 <= f3) {
                i4 = Math.round(f * this.mFrameSize);
                i3 = Math.round(((float) i4) / f3);
            } else {
                i3 = Math.round(f2 * this.mFrameSize);
                i4 = Math.round(((float) i3) * f3);
            }
            int i5 = (i - i4) / 2;
            int i6 = (i2 - i3) / 2;
            this.mFrameRect = new Rect(i5, i6, i4 + i5, i3 + i6);
        }
    }
}
