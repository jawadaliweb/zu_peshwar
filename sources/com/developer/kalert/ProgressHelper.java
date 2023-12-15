package com.developer.kalert;

import android.content.Context;
import android.os.Build;
import com.developer.progressx.ProgressWheel;

public class ProgressHelper {
    private int barColor;
    private int barWidth;
    private int circleRadius;
    private boolean progress;
    private float progressValue;
    private ProgressWheel progressWheel;
    private int rimColor;
    private int rimWidth;
    private boolean spin = true;
    private float spinSpeed = 0.75f;

    ProgressHelper(Context context) {
        this.barWidth = context.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1;
        if (Build.VERSION.SDK_INT >= 23) {
            this.barColor = context.getResources().getColor(R.color.success_stroke_color, context.getTheme());
        } else {
            this.barColor = context.getResources().getColor(R.color.success_stroke_color);
        }
        this.rimWidth = 0;
        this.rimColor = 0;
        this.progress = false;
        this.progressValue = -1.0f;
        this.circleRadius = context.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
    }

    /* access modifiers changed from: package-private */
    public void setProgressWheel(ProgressWheel progressWheel2) {
        this.progressWheel = progressWheel2;
        updatePropsIfNeed();
    }

    private void updatePropsIfNeed() {
        ProgressWheel progressWheel2 = this.progressWheel;
        if (progressWheel2 != null) {
            if (!this.spin && progressWheel2.isSpinning()) {
                this.progressWheel.stopSpinning();
            } else if (this.spin && !this.progressWheel.isSpinning()) {
                this.progressWheel.spin();
            }
            if (this.spinSpeed != this.progressWheel.getSpinSpeed()) {
                this.progressWheel.setSpinSpeed(this.spinSpeed);
            }
            if (this.barWidth != this.progressWheel.getBarWidth()) {
                this.progressWheel.setBarWidth(this.barWidth);
            }
            if (this.barColor != this.progressWheel.getBarColor()) {
                this.progressWheel.setBarColor(this.barColor);
            }
            if (this.rimWidth != this.progressWheel.getRimWidth()) {
                this.progressWheel.setRimWidth(this.rimWidth);
            }
            if (this.rimColor != this.progressWheel.getRimColor()) {
                this.progressWheel.setRimColor(this.rimColor);
            }
            if (this.progressValue != this.progressWheel.getProgress()) {
                if (this.progress) {
                    this.progressWheel.setInstantProgress(this.progressValue);
                } else {
                    this.progressWheel.setProgress(this.progressValue);
                }
            }
            if (this.circleRadius != this.progressWheel.getCircleRadius()) {
                this.progressWheel.setCircleRadius(this.circleRadius);
            }
        }
    }

    public ProgressWheel getProgressWheel() {
        return this.progressWheel;
    }

    public void resetCount() {
        ProgressWheel progressWheel2 = this.progressWheel;
        if (progressWheel2 != null) {
            progressWheel2.resetCount();
        }
    }

    public boolean isSpinning() {
        return this.spin;
    }

    public void spin() {
        this.spin = true;
        updatePropsIfNeed();
    }

    public void stopSpinning() {
        this.spin = false;
        updatePropsIfNeed();
    }

    public float getProgress() {
        return this.progressValue;
    }

    public void setProgress(float f) {
        this.progress = false;
        this.progressValue = f;
        updatePropsIfNeed();
    }

    public void setInstantProgress(float f) {
        this.progressValue = f;
        this.progress = true;
        updatePropsIfNeed();
    }

    public int getCircleRadius() {
        return this.circleRadius;
    }

    public void setCircleRadius(int i) {
        this.circleRadius = i;
        updatePropsIfNeed();
    }

    public int getBarWidth() {
        return this.barWidth;
    }

    public void setBarWidth(int i) {
        this.barWidth = i;
        updatePropsIfNeed();
    }

    public int getBarColor() {
        return this.barColor;
    }

    public void setBarColor(int i) {
        this.barColor = i;
        updatePropsIfNeed();
    }

    public int getRimWidth() {
        return this.rimWidth;
    }

    public void setRimWidth(int i) {
        this.rimWidth = i;
        updatePropsIfNeed();
    }

    public int getRimColor() {
        return this.rimColor;
    }

    public void setRimColor(int i) {
        this.rimColor = i;
        updatePropsIfNeed();
    }

    public float getSpinSpeed() {
        return this.spinSpeed;
    }

    public void setSpinSpeed(float f) {
        this.spinSpeed = f;
        updatePropsIfNeed();
    }
}
