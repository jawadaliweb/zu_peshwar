package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.ValueAnimator;
import android.view.View;
import com.bartoszlipinski.viewpropertyobjectanimator.ChangeUpdateListener;

class PaddingChangeListener extends ChangeUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private ChangeUpdateListener.IntValues mBottomPadding;
    private ChangeUpdateListener.IntValues mLeftPadding;
    private ChangeUpdateListener.IntValues mRightPadding;
    private ChangeUpdateListener.IntValues mTopPadding;

    PaddingChangeListener(View view) {
        super(view);
    }

    private int currentLeftPadding() {
        if (hasView()) {
            return ((View) this.mView.get()).getPaddingLeft();
        }
        return 0;
    }

    private int currentTopPadding() {
        if (hasView()) {
            return ((View) this.mView.get()).getPaddingTop();
        }
        return 0;
    }

    private int currentRightPadding() {
        if (hasView()) {
            return ((View) this.mView.get()).getPaddingRight();
        }
        return 0;
    }

    private int currentBottomPadding() {
        if (hasView()) {
            return ((View) this.mView.get()).getPaddingBottom();
        }
        return 0;
    }

    public void leftPadding(int i) {
        this.mLeftPadding = new ChangeUpdateListener.IntValues(currentLeftPadding(), i);
    }

    public void leftPaddingBy(int i) {
        this.mLeftPadding = new ChangeUpdateListener.IntValues(currentLeftPadding(), currentLeftPadding() + i);
    }

    public void topPadding(int i) {
        this.mTopPadding = new ChangeUpdateListener.IntValues(currentTopPadding(), i);
    }

    public void topPaddingBy(int i) {
        this.mTopPadding = new ChangeUpdateListener.IntValues(currentTopPadding(), currentTopPadding() + i);
    }

    public void bottomPadding(int i) {
        this.mBottomPadding = new ChangeUpdateListener.IntValues(currentBottomPadding(), i);
    }

    public void bottomPaddingBy(int i) {
        this.mBottomPadding = new ChangeUpdateListener.IntValues(currentBottomPadding(), currentBottomPadding() + i);
    }

    public void rightPadding(int i) {
        this.mRightPadding = new ChangeUpdateListener.IntValues(currentRightPadding(), i);
    }

    public void rightPaddingBy(int i) {
        this.mRightPadding = new ChangeUpdateListener.IntValues(currentRightPadding(), currentRightPadding() + i);
    }

    public void horizontalPadding(int i) {
        leftPadding(i);
        rightPadding(i);
    }

    public void horizontalPaddingBy(int i) {
        leftPaddingBy(i);
        rightPaddingBy(i);
    }

    public void verticalPadding(int i) {
        topPadding(i);
        bottomPadding(i);
    }

    public void verticalPaddingBy(int i) {
        topPaddingBy(i);
        bottomPaddingBy(i);
    }

    public void padding(int i) {
        leftPadding(i);
        topPadding(i);
        bottomPadding(i);
        rightPadding(i);
    }

    public void paddingBy(int i) {
        leftPaddingBy(i);
        topPaddingBy(i);
        bottomPaddingBy(i);
        rightPaddingBy(i);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (hasView()) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            int currentLeftPadding = currentLeftPadding();
            int currentTopPadding = currentTopPadding();
            int currentRightPadding = currentRightPadding();
            int currentBottomPadding = currentBottomPadding();
            ChangeUpdateListener.IntValues intValues = this.mLeftPadding;
            if (intValues != null) {
                currentLeftPadding = (int) calculateAnimatedValue((float) intValues.mFrom, (float) this.mLeftPadding.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues2 = this.mTopPadding;
            if (intValues2 != null) {
                currentTopPadding = (int) calculateAnimatedValue((float) intValues2.mFrom, (float) this.mTopPadding.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues3 = this.mRightPadding;
            if (intValues3 != null) {
                currentRightPadding = (int) calculateAnimatedValue((float) intValues3.mFrom, (float) this.mRightPadding.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues4 = this.mBottomPadding;
            if (intValues4 != null) {
                currentBottomPadding = (int) calculateAnimatedValue((float) intValues4.mFrom, (float) this.mBottomPadding.mTo, animatedFraction);
            }
            ((View) this.mView.get()).setPadding(currentLeftPadding, currentTopPadding, currentRightPadding, currentBottomPadding);
        }
    }
}
