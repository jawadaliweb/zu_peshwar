package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bartoszlipinski.viewpropertyobjectanimator.ChangeUpdateListener;

class MarginChangeListener extends ChangeUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private ChangeUpdateListener.IntValues mBottomMargin;
    private ChangeUpdateListener.IntValues mLeftMargin;
    private final ViewGroup.MarginLayoutParams mParams;
    private ChangeUpdateListener.IntValues mRightMargin;
    private ChangeUpdateListener.IntValues mTopMargin;

    MarginChangeListener(View view) {
        super(view);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.mParams = marginLayoutParams;
        if (marginLayoutParams == null) {
            throw new IllegalStateException("View does not have layout params yet.");
        }
    }

    private int currentLeftMargin() {
        return this.mParams.leftMargin;
    }

    private int currentTopMargin() {
        return this.mParams.topMargin;
    }

    private int currentRightMargin() {
        return this.mParams.rightMargin;
    }

    private int currentBottomMargin() {
        return this.mParams.bottomMargin;
    }

    public void leftMargin(int i) {
        this.mLeftMargin = new ChangeUpdateListener.IntValues(currentLeftMargin(), i);
    }

    public void leftMarginBy(int i) {
        this.mLeftMargin = new ChangeUpdateListener.IntValues(currentLeftMargin(), currentLeftMargin() + i);
    }

    public void topMargin(int i) {
        this.mTopMargin = new ChangeUpdateListener.IntValues(currentTopMargin(), i);
    }

    public void topMarginBy(int i) {
        this.mTopMargin = new ChangeUpdateListener.IntValues(currentTopMargin(), currentTopMargin() + i);
    }

    public void bottomMargin(int i) {
        this.mBottomMargin = new ChangeUpdateListener.IntValues(currentBottomMargin(), i);
    }

    public void bottomMarginBy(int i) {
        this.mBottomMargin = new ChangeUpdateListener.IntValues(currentBottomMargin(), currentBottomMargin() + i);
    }

    public void rightMargin(int i) {
        this.mRightMargin = new ChangeUpdateListener.IntValues(currentRightMargin(), i);
    }

    public void rightMarginBy(int i) {
        this.mRightMargin = new ChangeUpdateListener.IntValues(currentRightMargin(), currentRightMargin() + i);
    }

    public void horizontalMargin(int i) {
        leftMargin(i);
        rightMargin(i);
    }

    public void horizontalMarginBy(int i) {
        leftMarginBy(i);
        rightMarginBy(i);
    }

    public void verticalMargin(int i) {
        topMargin(i);
        bottomMargin(i);
    }

    public void verticalMarginBy(int i) {
        topMarginBy(i);
        bottomMarginBy(i);
    }

    public void margin(int i) {
        leftMargin(i);
        topMargin(i);
        bottomMargin(i);
        rightMargin(i);
    }

    public void marginBy(int i) {
        leftMarginBy(i);
        topMarginBy(i);
        bottomMarginBy(i);
        rightMarginBy(i);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (hasView()) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            ChangeUpdateListener.IntValues intValues = this.mLeftMargin;
            if (intValues != null) {
                this.mParams.leftMargin = (int) calculateAnimatedValue((float) intValues.mFrom, (float) this.mLeftMargin.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues2 = this.mTopMargin;
            if (intValues2 != null) {
                this.mParams.topMargin = (int) calculateAnimatedValue((float) intValues2.mFrom, (float) this.mTopMargin.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues3 = this.mRightMargin;
            if (intValues3 != null) {
                this.mParams.rightMargin = (int) calculateAnimatedValue((float) intValues3.mFrom, (float) this.mRightMargin.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues4 = this.mBottomMargin;
            if (intValues4 != null) {
                this.mParams.bottomMargin = (int) calculateAnimatedValue((float) intValues4.mFrom, (float) this.mBottomMargin.mTo, animatedFraction);
            }
            ((View) this.mView.get()).requestLayout();
        }
    }
}
