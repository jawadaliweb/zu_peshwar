package com.smarteist.autoimageslider.IndicatorView.animation.type;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.smarteist.autoimageslider.IndicatorView.animation.controller.ValueController;
import com.smarteist.autoimageslider.IndicatorView.animation.data.type.ColorAnimationValue;

public class ColorAnimation extends BaseAnimation<ValueAnimator> {
    static final String ANIMATION_COLOR = "ANIMATION_COLOR";
    static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    public static final String DEFAULT_SELECTED_COLOR = "#ffffff";
    public static final String DEFAULT_UNSELECTED_COLOR = "#33ffffff";
    int colorEnd;
    int colorStart;
    private ColorAnimationValue value = new ColorAnimationValue();

    public ColorAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public ColorAnimation progress(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.animationDuration));
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }

    public ColorAnimation with(int i, int i2) {
        if (this.animator != null && hasChanges(i, i2)) {
            this.colorStart = i;
            this.colorEnd = i2;
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{createColorPropertyHolder(false), createColorPropertyHolder(true)});
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public PropertyValuesHolder createColorPropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.colorEnd;
            i2 = this.colorStart;
            str = ANIMATION_COLOR_REVERSE;
        } else {
            i = this.colorStart;
            i2 = this.colorEnd;
            str = ANIMATION_COLOR;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    private boolean hasChanges(int i, int i2) {
        if (this.colorStart == i && this.colorEnd == i2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_COLOR)).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_COLOR_REVERSE)).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }
}
