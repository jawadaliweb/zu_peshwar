package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bartoszlipinski.viewpropertyobjectanimator.ChangeUpdateListener;

class DimensionChangeListener extends ChangeUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private ChangeUpdateListener.IntValues mHeight;
    private final ViewGroup.LayoutParams mParams;
    private ChangeUpdateListener.IntValues mWidth;

    DimensionChangeListener(View view) {
        super(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.mParams = layoutParams;
        if (layoutParams == null) {
            throw new IllegalStateException("View does not have layout params yet.");
        }
    }

    private int currentWidth() {
        if (this.mParams.width > 0) {
            return this.mParams.width;
        }
        if (hasView()) {
            return ((View) this.mView.get()).getWidth();
        }
        return 0;
    }

    private int currentHeight() {
        if (this.mParams.height > 0) {
            return this.mParams.height;
        }
        if (hasView()) {
            return ((View) this.mView.get()).getHeight();
        }
        return 0;
    }

    public void width(int i) {
        this.mWidth = new ChangeUpdateListener.IntValues(currentWidth(), i);
    }

    public void widthBy(int i) {
        this.mWidth = new ChangeUpdateListener.IntValues(currentWidth(), currentWidth() + i);
    }

    public void height(int i) {
        this.mHeight = new ChangeUpdateListener.IntValues(currentHeight(), i);
    }

    public void heightBy(int i) {
        this.mHeight = new ChangeUpdateListener.IntValues(currentHeight(), currentHeight() + i);
    }

    public void size(int i) {
        width(i);
        height(i);
    }

    public void sizeBy(int i) {
        widthBy(i);
        heightBy(i);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (hasView()) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            ChangeUpdateListener.IntValues intValues = this.mWidth;
            if (intValues != null) {
                this.mParams.width = (int) calculateAnimatedValue((float) intValues.mFrom, (float) this.mWidth.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues2 = this.mHeight;
            if (intValues2 != null) {
                this.mParams.height = (int) calculateAnimatedValue((float) intValues2.mFrom, (float) this.mHeight.mTo, animatedFraction);
            }
            ((View) this.mView.get()).requestLayout();
        }
    }
}
