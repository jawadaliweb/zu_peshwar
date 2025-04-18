package com.smarteist.autoimageslider.IndicatorView.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import com.smarteist.autoimageslider.IndicatorView.animation.controller.ValueController;

public class ScaleDownAnimation extends ScaleAnimation {
    public ScaleDownAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    /* access modifiers changed from: protected */
    public PropertyValuesHolder createScalePropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = (int) (((float) this.radius) * this.scaleFactor);
            i2 = this.radius;
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i = this.radius;
            i2 = (int) (((float) this.radius) * this.scaleFactor);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
