package ru.nikartm.support;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import ru.nikartm.support.model.Badge;

public class BadgeDrawer {
    private Badge badge;
    private Paint paint;
    private BadgePosition position;
    private View view;

    BadgeDrawer(View view2, Badge badge2) {
        this.view = view2;
        this.badge = badge2;
    }

    public void draw(Canvas canvas) {
        if (this.badge.isVisible() || this.badge.getValue() > 0) {
            initPaint();
            computeTextWidth();
            this.position = new BadgePosition(this.view, this.badge).compute();
            drawBadge(canvas);
            if (this.badge.isShowCounter()) {
                drawText(canvas);
            }
        }
    }

    private void initPaint() {
        if (this.paint == null) {
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setAntiAlias(true);
            this.paint.setTypeface(Typeface.create(this.badge.getBadgeTextFont(), this.badge.getTextStyle()));
            this.paint.setTextSize(this.badge.getBadgeTextSize());
        }
    }

    private void drawBadge(Canvas canvas) {
        this.paint.setColor(this.badge.getBadgeColor());
        if (this.badge.getBackgroundDrawable() != null) {
            this.badge.getBackgroundDrawable().setBounds(0, 0, this.position.getBadgeWidth(), this.position.getBadgeHeight());
            canvas.save();
            canvas.translate(this.position.getDeltaX() - ((float) (this.position.getBadgeWidth() / 2)), this.position.getDeltaY() - ((float) (this.position.getBadgeHeight() / 2)));
            this.badge.getBackgroundDrawable().draw(canvas);
            canvas.restore();
            return;
        }
        canvas.drawCircle(this.position.getDeltaX(), this.position.getDeltaY(), this.badge.getRadius(), this.paint);
    }

    private void drawText(Canvas canvas) {
        this.paint.setColor(this.badge.getBadgeTextColor());
        if (!this.badge.isLimitValue() || this.badge.getValue() <= this.badge.getMaxValue()) {
            canvas.drawText(String.valueOf(this.badge.getValue()), this.position.getDeltaX() - (this.badge.getTextWidth() / 2.0f), this.position.getDeltaY() + (this.badge.getBadgeTextSize() / 3.0f), this.paint);
        } else {
            canvas.drawText(String.valueOf(this.badge.getMaxValue()).concat("+"), this.position.getDeltaX() - (this.badge.getTextWidth() / 2.0f), this.position.getDeltaY() + (this.badge.getBadgeTextSize() / 3.0f), this.paint);
        }
    }

    private void computeTextWidth() {
        float f;
        if (!this.badge.isLimitValue() || this.badge.getValue() <= this.badge.getMaxValue()) {
            f = this.paint.measureText(String.valueOf(this.badge.getValue()));
        } else {
            f = this.paint.measureText(String.valueOf(this.badge.getMaxValue()).concat("+"));
        }
        this.badge.setTextWidth(f);
    }
}
