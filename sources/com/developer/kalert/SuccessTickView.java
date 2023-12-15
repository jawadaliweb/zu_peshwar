package com.developer.kalert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SuccessTickView extends View {
    /* access modifiers changed from: private */
    public final float CONST_LEFT_RECT_W = dip2px(15.0f);
    private final float CONST_RADIUS = dip2px(1.2f);
    private final float CONST_RECT_WEIGHT = dip2px(3.0f);
    /* access modifiers changed from: private */
    public final float CONST_RIGHT_RECT_W;
    /* access modifiers changed from: private */
    public final float MAX_RIGHT_RECT_W;
    /* access modifiers changed from: private */
    public final float MIN_LEFT_RECT_W;
    /* access modifiers changed from: private */
    public float leftRectWidth;
    private float mDensity = -1.0f;
    /* access modifiers changed from: private */
    public boolean mLeftRectGrowMode;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public float maxLeftRectWidth;
    /* access modifiers changed from: private */
    public float rightRectWidth;

    public SuccessTickView(Context context) {
        super(context);
        float dip2px = dip2px(25.0f);
        this.CONST_RIGHT_RECT_W = dip2px;
        this.MIN_LEFT_RECT_W = dip2px(3.3f);
        this.MAX_RIGHT_RECT_W = dip2px + dip2px(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float dip2px = dip2px(25.0f);
        this.CONST_RIGHT_RECT_W = dip2px;
        this.MIN_LEFT_RECT_W = dip2px(3.3f);
        this.MAX_RIGHT_RECT_W = dip2px + dip2px(6.7f);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(R.color.success_stroke_color);
        this.leftRectWidth = this.CONST_LEFT_RECT_W;
        this.rightRectWidth = this.CONST_RIGHT_RECT_W;
        this.mLeftRectGrowMode = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, (float) (width >> 1), (float) (height >> 1));
        int i = (int) (((double) height) / 1.4d);
        float f = (float) ((int) (((double) width) / 1.2d));
        this.maxLeftRectWidth = (((this.CONST_LEFT_RECT_W + f) / 2.0f) + this.CONST_RECT_WEIGHT) - 1.0f;
        RectF rectF = new RectF();
        if (this.mLeftRectGrowMode) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.leftRectWidth;
        } else {
            rectF.right = (((this.CONST_LEFT_RECT_W + f) / 2.0f) + this.CONST_RECT_WEIGHT) - 1.0f;
            rectF.left = rectF.right - this.leftRectWidth;
        }
        float f2 = (float) i;
        rectF.top = (this.CONST_RIGHT_RECT_W + f2) / 2.0f;
        rectF.bottom = rectF.top + this.CONST_RECT_WEIGHT;
        float f3 = this.CONST_RADIUS;
        canvas.drawRoundRect(rectF, f3, f3, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((f2 + this.CONST_RIGHT_RECT_W) / 2.0f) + this.CONST_RECT_WEIGHT) - 1.0f;
        rectF2.left = (f + this.CONST_LEFT_RECT_W) / 2.0f;
        rectF2.right = rectF2.left + this.CONST_RECT_WEIGHT;
        rectF2.top = rectF2.bottom - this.rightRectWidth;
        float f4 = this.CONST_RADIUS;
        canvas.drawRoundRect(rectF2, f4, f4, this.mPaint);
    }

    private float dip2px(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (f * this.mDensity) + 0.5f;
    }

    public void startTickAnim() {
        this.leftRectWidth = 0.0f;
        this.rightRectWidth = 0.0f;
        invalidate();
        AnonymousClass1 r0 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                double d = (double) f;
                if (0.54d < d && 0.7d >= d) {
                    boolean unused = SuccessTickView.this.mLeftRectGrowMode = true;
                    SuccessTickView successTickView = SuccessTickView.this;
                    float unused2 = successTickView.leftRectWidth = successTickView.maxLeftRectWidth * ((f - 0.54f) / 0.16f);
                    if (0.65d < d) {
                        SuccessTickView successTickView2 = SuccessTickView.this;
                        float unused3 = successTickView2.rightRectWidth = successTickView2.MAX_RIGHT_RECT_W * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < d && 0.84d >= d) {
                    boolean unused4 = SuccessTickView.this.mLeftRectGrowMode = false;
                    SuccessTickView successTickView3 = SuccessTickView.this;
                    float unused5 = successTickView3.leftRectWidth = successTickView3.maxLeftRectWidth * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView successTickView4 = SuccessTickView.this;
                    float unused6 = successTickView4.leftRectWidth = Math.max(successTickView4.leftRectWidth, SuccessTickView.this.MIN_LEFT_RECT_W);
                    SuccessTickView successTickView5 = SuccessTickView.this;
                    float unused7 = successTickView5.rightRectWidth = successTickView5.MAX_RIGHT_RECT_W * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < d && 1.0f >= f) {
                    boolean unused8 = SuccessTickView.this.mLeftRectGrowMode = false;
                    SuccessTickView successTickView6 = SuccessTickView.this;
                    float f2 = (f - 0.84f) / 0.16f;
                    float unused9 = successTickView6.leftRectWidth = successTickView6.MIN_LEFT_RECT_W + ((SuccessTickView.this.CONST_LEFT_RECT_W - SuccessTickView.this.MIN_LEFT_RECT_W) * f2);
                    SuccessTickView successTickView7 = SuccessTickView.this;
                    float unused10 = successTickView7.rightRectWidth = successTickView7.CONST_RIGHT_RECT_W + ((SuccessTickView.this.MAX_RIGHT_RECT_W - SuccessTickView.this.CONST_RIGHT_RECT_W) * (1.0f - f2));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        r0.setDuration(750);
        r0.setStartOffset(100);
        startAnimation(r0);
    }
}
