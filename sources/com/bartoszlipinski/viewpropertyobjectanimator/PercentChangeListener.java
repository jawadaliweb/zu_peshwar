package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.percentlayout.widget.PercentLayoutHelper;
import com.bartoszlipinski.viewpropertyobjectanimator.ChangeUpdateListener;

class PercentChangeListener extends ChangeUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private ChangeUpdateListener.FloatValues mAspectRatio;
    private ChangeUpdateListener.FloatValues mBottomMarginPercent;
    private ChangeUpdateListener.FloatValues mHeightPercent;
    private ChangeUpdateListener.FloatValues mLeftMarginPercent;
    private final PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;
    private ChangeUpdateListener.FloatValues mRightMarginPercent;
    private ChangeUpdateListener.FloatValues mTopMarginPercent;
    private ChangeUpdateListener.FloatValues mWidthPercent;

    PercentChangeListener(View view) {
        super(view);
        PercentLayoutHelper.PercentLayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            try {
                if (layoutParams instanceof PercentLayoutHelper.PercentLayoutParams) {
                    this.mPercentLayoutInfo = layoutParams.getPercentLayoutInfo();
                    return;
                }
                throw new IllegalStateException("Animating percent parameters (aspectRatio is also a \"percent parameter\") is available only for children of PercentRelativeLayout or PercentFrameLayout (part of the Percent Support Library).");
            } catch (NoClassDefFoundError unused) {
                throw new IllegalStateException("Animating percent parameters (aspectRatio is also a \"percent parameter\") is available only for children of PercentRelativeLayout or PercentFrameLayout (part of the Percent Support Library).");
            }
        } else {
            throw new IllegalStateException("View does not have layout params yet.");
        }
    }

    private float currentWidthPercent() {
        return this.mPercentLayoutInfo.widthPercent;
    }

    private float currentHeightPercent() {
        return this.mPercentLayoutInfo.heightPercent;
    }

    private float currentLeftMarginPercent() {
        return this.mPercentLayoutInfo.leftMarginPercent;
    }

    private float currentTopMarginPercent() {
        return this.mPercentLayoutInfo.topMarginPercent;
    }

    private float currentRightMarginPercent() {
        return this.mPercentLayoutInfo.rightMarginPercent;
    }

    private float currentBottomMarginPercent() {
        return this.mPercentLayoutInfo.bottomMarginPercent;
    }

    private float currentAspectRatio() {
        return this.mPercentLayoutInfo.aspectRatio;
    }

    public void widthPercent(float f) {
        this.mWidthPercent = new ChangeUpdateListener.FloatValues(currentWidthPercent(), f);
    }

    public void widthPercentBy(float f) {
        this.mWidthPercent = new ChangeUpdateListener.FloatValues(currentWidthPercent(), currentWidthPercent() + f);
    }

    public void heightPercent(float f) {
        this.mHeightPercent = new ChangeUpdateListener.FloatValues(currentHeightPercent(), f);
    }

    public void heightPercentBy(float f) {
        this.mHeightPercent = new ChangeUpdateListener.FloatValues(currentHeightPercent(), currentHeightPercent() + f);
    }

    public void sizePercent(float f) {
        widthPercent(f);
        heightPercent(f);
    }

    public void sizePercentBy(float f) {
        widthPercentBy(f);
        heightPercentBy(f);
    }

    public void leftMarginPercent(float f) {
        this.mLeftMarginPercent = new ChangeUpdateListener.FloatValues(currentLeftMarginPercent(), f);
    }

    public void leftMarginPercentBy(float f) {
        this.mLeftMarginPercent = new ChangeUpdateListener.FloatValues(currentLeftMarginPercent(), currentLeftMarginPercent() + f);
    }

    public void topMarginPercent(float f) {
        this.mTopMarginPercent = new ChangeUpdateListener.FloatValues(currentTopMarginPercent(), f);
    }

    public void topMarginPercentBy(float f) {
        this.mTopMarginPercent = new ChangeUpdateListener.FloatValues(currentTopMarginPercent(), currentTopMarginPercent() + f);
    }

    public void bottomMarginPercent(float f) {
        this.mBottomMarginPercent = new ChangeUpdateListener.FloatValues(currentBottomMarginPercent(), f);
    }

    public void bottomMarginPercentBy(float f) {
        this.mBottomMarginPercent = new ChangeUpdateListener.FloatValues(currentBottomMarginPercent(), currentBottomMarginPercent() + f);
    }

    public void rightMarginPercent(float f) {
        this.mRightMarginPercent = new ChangeUpdateListener.FloatValues(currentRightMarginPercent(), f);
    }

    public void rightMarginPercentBy(float f) {
        this.mRightMarginPercent = new ChangeUpdateListener.FloatValues(currentRightMarginPercent(), currentRightMarginPercent() + f);
    }

    public void horizontalMarginPercent(float f) {
        leftMarginPercent(f);
        rightMarginPercent(f);
    }

    public void horizontalMarginPercentBy(float f) {
        leftMarginPercentBy(f);
        rightMarginPercentBy(f);
    }

    public void verticalMarginPercent(float f) {
        topMarginPercent(f);
        bottomMarginPercent(f);
    }

    public void verticalMarginPercentBy(float f) {
        topMarginPercentBy(f);
        bottomMarginPercentBy(f);
    }

    public void marginPercent(float f) {
        leftMarginPercent(f);
        topMarginPercent(f);
        bottomMarginPercent(f);
        rightMarginPercent(f);
    }

    public void marginPercentBy(float f) {
        leftMarginPercentBy(f);
        topMarginPercentBy(f);
        bottomMarginPercentBy(f);
        rightMarginPercentBy(f);
    }

    public void aspectRatio(float f) {
        this.mAspectRatio = new ChangeUpdateListener.FloatValues(currentAspectRatio(), f);
    }

    public void aspectRatioBy(float f) {
        this.mAspectRatio = new ChangeUpdateListener.FloatValues(currentAspectRatio(), currentAspectRatio() + f);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (hasView()) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            ChangeUpdateListener.FloatValues floatValues = this.mWidthPercent;
            if (floatValues != null) {
                this.mPercentLayoutInfo.widthPercent = calculateAnimatedValue(floatValues.mFrom, this.mWidthPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues2 = this.mHeightPercent;
            if (floatValues2 != null) {
                this.mPercentLayoutInfo.heightPercent = calculateAnimatedValue(floatValues2.mFrom, this.mHeightPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues3 = this.mLeftMarginPercent;
            if (floatValues3 != null) {
                this.mPercentLayoutInfo.leftMarginPercent = calculateAnimatedValue(floatValues3.mFrom, this.mLeftMarginPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues4 = this.mTopMarginPercent;
            if (floatValues4 != null) {
                this.mPercentLayoutInfo.topMarginPercent = calculateAnimatedValue(floatValues4.mFrom, this.mTopMarginPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues5 = this.mRightMarginPercent;
            if (floatValues5 != null) {
                this.mPercentLayoutInfo.rightMarginPercent = calculateAnimatedValue(floatValues5.mFrom, this.mRightMarginPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues6 = this.mBottomMarginPercent;
            if (floatValues6 != null) {
                this.mPercentLayoutInfo.bottomMarginPercent = calculateAnimatedValue(floatValues6.mFrom, this.mBottomMarginPercent.mTo, animatedFraction);
            }
            ChangeUpdateListener.FloatValues floatValues7 = this.mAspectRatio;
            if (floatValues7 != null) {
                this.mPercentLayoutInfo.aspectRatio = calculateAnimatedValue(floatValues7.mFrom, this.mAspectRatio.mTo, animatedFraction);
            }
            ((View) this.mView.get()).requestLayout();
        }
    }
}
