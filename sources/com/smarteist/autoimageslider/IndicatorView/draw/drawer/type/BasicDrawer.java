package com.smarteist.autoimageslider.IndicatorView.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.data.Indicator;

public class BasicDrawer extends BaseDrawer {
    private Paint strokePaint;

    public BasicDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.strokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.strokePaint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth((float) indicator.getStroke());
    }

    public void draw(Canvas canvas, int i, boolean z, int i2, int i3) {
        Paint paint;
        float radius = (float) this.indicator.getRadius();
        int stroke = this.indicator.getStroke();
        float scaleFactor = this.indicator.getScaleFactor();
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int selectedPosition = this.indicator.getSelectedPosition();
        IndicatorAnimationType animationType = this.indicator.getAnimationType();
        if ((animationType == IndicatorAnimationType.SCALE && !z) || (animationType == IndicatorAnimationType.SCALE_DOWN && z)) {
            radius *= scaleFactor;
        }
        if (i != selectedPosition) {
            selectedColor = unselectedColor;
        }
        if (animationType != IndicatorAnimationType.FILL || i == selectedPosition) {
            paint = this.paint;
        } else {
            paint = this.strokePaint;
            paint.setStrokeWidth((float) stroke);
        }
        paint.setColor(selectedColor);
        canvas.drawCircle((float) i2, (float) i3, radius, paint);
    }
}
