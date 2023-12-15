package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.ValueAnimator;
import android.view.View;
import com.bartoszlipinski.viewpropertyobjectanimator.ChangeUpdateListener;

class ScrollChangeListener extends ChangeUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private ChangeUpdateListener.IntValues mScrollX;
    private ChangeUpdateListener.IntValues mScrollY;

    ScrollChangeListener(View view) {
        super(view);
    }

    private int currentScrollX() {
        if (hasView()) {
            return ((View) this.mView.get()).getScrollX();
        }
        return 0;
    }

    private int currentScrollY() {
        if (hasView()) {
            return ((View) this.mView.get()).getScrollY();
        }
        return 0;
    }

    public void scrollX(int i) {
        this.mScrollX = new ChangeUpdateListener.IntValues(currentScrollX(), i);
    }

    public void scrollXBy(int i) {
        this.mScrollX = new ChangeUpdateListener.IntValues(currentScrollX(), currentScrollX() + i);
    }

    public void scrollY(int i) {
        this.mScrollY = new ChangeUpdateListener.IntValues(currentScrollY(), i);
    }

    public void scrollYBy(int i) {
        this.mScrollY = new ChangeUpdateListener.IntValues(currentScrollY(), currentScrollY() + i);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (hasView()) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            int currentScrollX = currentScrollX();
            int currentScrollY = currentScrollY();
            ChangeUpdateListener.IntValues intValues = this.mScrollX;
            if (intValues != null) {
                currentScrollX = (int) calculateAnimatedValue((float) intValues.mFrom, (float) this.mScrollX.mTo, animatedFraction);
            }
            ChangeUpdateListener.IntValues intValues2 = this.mScrollY;
            if (intValues2 != null) {
                currentScrollY = (int) calculateAnimatedValue((float) intValues2.mFrom, (float) this.mScrollY.mTo, animatedFraction);
            }
            ((View) this.mView.get()).scrollTo(currentScrollX, currentScrollY);
        }
    }
}
