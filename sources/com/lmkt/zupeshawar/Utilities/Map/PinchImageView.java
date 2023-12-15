package com.lmkt.zupeshawar.Utilities.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class PinchImageView extends PreviewImageView {
    private static final int CLICK = 3;
    private static final int DRAG = 1;
    private static final int NONE = 0;
    private static final int ZOOM = 2;
    private float bmHeight;
    private float bmWidth;
    /* access modifiers changed from: private */
    public float bottom;
    /* access modifiers changed from: private */
    public float height;
    /* access modifiers changed from: private */
    public PointF last = new PointF();
    /* access modifiers changed from: private */
    public float[] m;
    /* access modifiers changed from: private */
    public ScaleGestureDetector mScaleDetector;
    /* access modifiers changed from: private */
    public Matrix matrix = new Matrix();
    private float maxScale = 3.0f;
    private final float minScale = 1.0f;
    /* access modifiers changed from: private */
    public int mode = 0;
    /* access modifiers changed from: private */
    public float origHeight;
    /* access modifiers changed from: private */
    public float origWidth;
    private float redundantXSpace;
    private float redundantYSpace;
    /* access modifiers changed from: private */
    public float right;
    /* access modifiers changed from: private */
    public float saveScale = 1.0f;
    /* access modifiers changed from: private */
    public PointF start = new PointF();
    /* access modifiers changed from: private */
    public float width;

    public PinchImageView(Context context) {
        super(context);
        sharedConstructing(context);
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sharedConstructing(context);
    }

    private void sharedConstructing(Context context) {
        super.setClickable(true);
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.matrix.setTranslate(1.0f, 1.0f);
        this.m = new float[9];
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new View.OnTouchListener() {
            /* JADX WARNING: Removed duplicated region for block: B:37:0x0105  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
                /*
                    r8 = this;
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.view.ScaleGestureDetector r9 = r9.mScaleDetector
                    r9.onTouchEvent(r10)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.Matrix r9 = r9.matrix
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r0 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float[] r0 = r0.m
                    r9.getValues(r0)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float[] r9 = r9.m
                    r0 = 2
                    r9 = r9[r0]
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r1 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float[] r1 = r1.m
                    r2 = 5
                    r1 = r1[r2]
                    android.graphics.PointF r2 = new android.graphics.PointF
                    float r3 = r10.getX()
                    float r4 = r10.getY()
                    r2.<init>(r3, r4)
                    int r3 = r10.getAction()
                    r4 = 1
                    if (r3 == 0) goto L_0x015f
                    r10 = 0
                    if (r3 == r4) goto L_0x012f
                    if (r3 == r0) goto L_0x004f
                    r9 = 6
                    if (r3 == r9) goto L_0x0048
                    goto L_0x0184
                L_0x0048:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    int unused = r9.mode = r10
                    goto L_0x0184
                L_0x004f:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    int r10 = r10.mode
                    if (r10 != r4) goto L_0x0184
                    float r10 = r2.x
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r0 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r0 = r0.last
                    float r0 = r0.x
                    float r10 = r10 - r0
                    float r0 = r2.y
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r3 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r3 = r3.last
                    float r3 = r3.y
                    float r0 = r0 - r3
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r3 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r3 = r3.origWidth
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r5 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r5 = r5.saveScale
                    float r3 = r3 * r5
                    int r3 = java.lang.Math.round(r3)
                    float r3 = (float) r3
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r5 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r5 = r5.origHeight
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r6 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r6 = r6.saveScale
                    float r5 = r5 * r6
                    int r5 = java.lang.Math.round(r5)
                    float r5 = (float) r5
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r6 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r6 = r6.width
                    r7 = 0
                    int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                    if (r3 >= 0) goto L_0x00bb
                    float r9 = r1 + r0
                    int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                    if (r10 <= 0) goto L_0x00a6
                L_0x00a4:
                    float r0 = -r1
                    goto L_0x00b9
                L_0x00a6:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r10 = r10.bottom
                    float r10 = -r10
                    int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                    if (r9 >= 0) goto L_0x00b9
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r9 = r9.bottom
                    float r1 = r1 + r9
                    goto L_0x00a4
                L_0x00b9:
                    r10 = 0
                    goto L_0x0118
                L_0x00bb:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r3 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r3 = r3.height
                    int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r3 >= 0) goto L_0x00e2
                    float r0 = r9 + r10
                    int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00cd
                L_0x00cb:
                    float r10 = -r9
                    goto L_0x00e0
                L_0x00cd:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r1 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r1 = r1.right
                    float r1 = -r1
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x00e0
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r10 = r10.right
                    float r9 = r9 + r10
                    goto L_0x00cb
                L_0x00e0:
                    r0 = 0
                    goto L_0x0118
                L_0x00e2:
                    float r3 = r9 + r10
                    int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r5 <= 0) goto L_0x00ea
                L_0x00e8:
                    float r10 = -r9
                    goto L_0x00fd
                L_0x00ea:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r5 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r5 = r5.right
                    float r5 = -r5
                    int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r3 >= 0) goto L_0x00fd
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r10 = r10.right
                    float r9 = r9 + r10
                    goto L_0x00e8
                L_0x00fd:
                    float r9 = r1 + r0
                    int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                    if (r3 <= 0) goto L_0x0105
                L_0x0103:
                    float r0 = -r1
                    goto L_0x0118
                L_0x0105:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r3 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r3 = r3.bottom
                    float r3 = -r3
                    int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                    if (r9 >= 0) goto L_0x0118
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    float r9 = r9.bottom
                    float r1 = r1 + r9
                    goto L_0x0103
                L_0x0118:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.Matrix r9 = r9.matrix
                    r9.postTranslate(r10, r0)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r9 = r9.last
                    float r10 = r2.x
                    float r0 = r2.y
                    r9.set(r10, r0)
                    goto L_0x0184
                L_0x012f:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    int unused = r9.mode = r10
                    float r9 = r2.x
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r10 = r10.start
                    float r10 = r10.x
                    float r9 = r9 - r10
                    float r9 = java.lang.Math.abs(r9)
                    int r9 = (int) r9
                    float r10 = r2.y
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r0 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r0 = r0.start
                    float r0 = r0.y
                    float r10 = r10 - r0
                    float r10 = java.lang.Math.abs(r10)
                    int r10 = (int) r10
                    r0 = 3
                    if (r9 >= r0) goto L_0x0184
                    if (r10 >= r0) goto L_0x0184
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    r9.performClick()
                    goto L_0x0184
                L_0x015f:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r9 = r9.last
                    float r0 = r10.getX()
                    float r10 = r10.getY()
                    r9.set(r0, r10)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r9 = r9.start
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r10 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.PointF r10 = r10.last
                    r9.set(r10)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    int unused = r9.mode = r4
                L_0x0184:
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    android.graphics.Matrix r10 = r9.matrix
                    r9.setImageMatrix(r10)
                    com.lmkt.zupeshawar.Utilities.Map.PinchImageView r9 = com.lmkt.zupeshawar.Utilities.Map.PinchImageView.this
                    r9.invalidate()
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.Utilities.Map.PinchImageView.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.bmWidth = (float) bitmap.getWidth();
            this.bmHeight = (float) bitmap.getHeight();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null) {
                    this.bmWidth = (float) bitmapDrawable.getBitmap().getWidth();
                    this.bmHeight = (float) bitmapDrawable.getBitmap().getHeight();
                    return;
                }
                return;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            float f = 0.0f;
            this.bmHeight = intrinsicHeight > 0 ? (float) intrinsicHeight : 0.0f;
            if (intrinsicWidth > 0) {
                f = (float) intrinsicWidth;
            }
            this.bmWidth = f;
        }
    }

    public void setMaxZoom(float f) {
        this.maxScale = f;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            int unused = PinchImageView.this.mode = 2;
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PinchImageView.this.scale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void scale(float f, float f2, float f3) {
        float f4 = this.saveScale;
        float f5 = f4 * f;
        this.saveScale = f5;
        float f6 = this.maxScale;
        if (f5 > f6) {
            this.saveScale = f6;
            f = f6 / f4;
        } else if (f5 < 1.0f) {
            this.saveScale = 1.0f;
            f = 1.0f / f4;
        }
        float f7 = this.width;
        float f8 = this.saveScale;
        this.right = ((f7 * f8) - f7) - ((this.redundantXSpace * 2.0f) * f8);
        float f9 = this.height;
        this.bottom = ((f9 * f8) - f9) - ((this.redundantYSpace * 2.0f) * f8);
        if (this.origWidth * f8 <= f7 || this.origHeight * f8 <= f9) {
            this.matrix.postScale(f, f, f7 / 2.0f, f9 / 2.0f);
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i < 0) {
                this.matrix.getValues(this.m);
                float[] fArr = this.m;
                float f10 = fArr[2];
                float f11 = fArr[5];
                if (i >= 0) {
                    return;
                }
                if (((float) Math.round(this.origWidth * this.saveScale)) < this.width) {
                    float f12 = this.bottom;
                    if (f11 < (-f12)) {
                        this.matrix.postTranslate(0.0f, -(f11 + f12));
                    } else if (f11 > 0.0f) {
                        this.matrix.postTranslate(0.0f, -f11);
                    }
                } else {
                    float f13 = this.right;
                    if (f10 < (-f13)) {
                        this.matrix.postTranslate(-(f10 + f13), 0.0f);
                    } else if (f10 > 0.0f) {
                        this.matrix.postTranslate(-f10, 0.0f);
                    }
                }
            }
        } else {
            this.matrix.postScale(f, f, f2, f3);
            this.matrix.getValues(this.m);
            float[] fArr2 = this.m;
            float f14 = fArr2[2];
            float f15 = fArr2[5];
            if (f < 1.0f) {
                float f16 = this.right;
                if (f14 < (-f16)) {
                    this.matrix.postTranslate(-(f14 + f16), 0.0f);
                } else if (f14 > 0.0f) {
                    this.matrix.postTranslate(-f14, 0.0f);
                }
                float f17 = this.bottom;
                if (f15 < (-f17)) {
                    this.matrix.postTranslate(0.0f, -(f15 + f17));
                } else if (f15 > 0.0f) {
                    this.matrix.postTranslate(0.0f, -f15);
                }
            }
        }
    }

    public boolean canScrollHorizontally(int i) {
        this.matrix.getValues(this.m);
        float abs = Math.abs(this.m[2]);
        float round = (float) Math.round(this.origWidth * this.saveScale);
        float f = this.width;
        if (round < f) {
            return false;
        }
        float f2 = (float) i;
        return abs - f2 > 0.0f && (abs + f) - f2 < round;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = (float) View.MeasureSpec.getSize(i);
        this.height = (float) View.MeasureSpec.getSize(i2);
        locateImage();
    }

    /* access modifiers changed from: protected */
    public void locateImage() {
        if (Float.compare(this.bmWidth, 0.0f) * Float.compare(this.bmHeight, 0.0f) != 0) {
            float min = Math.min(this.width / this.bmWidth, this.height / this.bmHeight);
            this.matrix.setScale(min, min);
            setImageMatrix(this.matrix);
            this.saveScale = 1.0f;
            float f = this.height - (this.bmHeight * min);
            this.redundantYSpace = f;
            float f2 = this.width - (min * this.bmWidth);
            this.redundantXSpace = f2;
            float f3 = f / 2.0f;
            this.redundantYSpace = f3;
            float f4 = f2 / 2.0f;
            this.redundantXSpace = f4;
            this.matrix.postTranslate(f4, f3);
            float f5 = this.width;
            float f6 = this.redundantXSpace;
            this.origWidth = f5 - (f6 * 2.0f);
            float f7 = this.height;
            float f8 = this.redundantYSpace;
            this.origHeight = f7 - (f8 * 2.0f);
            float f9 = this.saveScale;
            this.right = ((f5 * f9) - f5) - ((f6 * 2.0f) * f9);
            this.bottom = ((f7 * f9) - f7) - ((f8 * 2.0f) * f9);
            setImageMatrix(this.matrix);
        }
    }
}
