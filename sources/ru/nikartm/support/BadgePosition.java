package ru.nikartm.support;

import android.view.View;
import ru.nikartm.support.model.Badge;

public class BadgePosition {
    public static final int BOTTOM_LEFT = 2;
    public static final int BOTTOM_RIGHT = 3;
    public static final int CENTER = 4;
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    private Badge badge;
    private int badgeHeight;
    private int badgeWidth;
    private float deltaX;
    private float deltaY;
    private boolean isDrawBackgroundAdded = false;
    private float pivotX;
    private float pivotY;
    private View view;
    private int viewHeight;
    private int viewWidth;

    BadgePosition(View view2, Badge badge2) {
        this.view = view2;
        this.badge = badge2;
        init();
        computeBadgeWidth();
        computeBadgeHeight();
        computeRadius();
    }

    private void init() {
        this.isDrawBackgroundAdded = this.badge.getBackgroundDrawable() != null;
        this.pivotX = this.view.getPivotX();
        this.pivotY = this.view.getPivotY();
        this.viewHeight = this.view.getMeasuredHeight();
        this.viewWidth = this.view.getMeasuredWidth();
    }

    public BadgePosition compute() {
        int position = this.badge.getPosition();
        if (position == 0) {
            computeTopLeft();
        } else if (position == 1) {
            computeTopRight();
        } else if (position == 2) {
            computeBottomLeft();
        } else if (position == 3) {
            computeBottomRight();
        } else if (position == 4) {
            computeCenter();
        }
        return this;
    }

    private void defineMeasurement() {
        if (checkFixedRadius()) {
            int max = Math.max(this.badgeWidth, this.badgeHeight);
            this.badgeWidth = max;
            this.badgeHeight = max;
        } else if ((this.badge.isOvalAfterFirst() && this.badge.getValue() <= 9) || (this.badge.isRoundBadge() && this.badgeWidth < this.badgeHeight)) {
            this.badgeWidth = this.badgeHeight;
        }
    }

    private void computeTopLeft() {
        if (this.isDrawBackgroundAdded) {
            defineMeasurement();
            this.deltaX = (this.pivotX - ((float) (this.viewWidth / 2))) + ((float) (this.badgeWidth / 2));
            this.deltaY = (this.pivotY - ((float) (this.viewHeight / 2))) + ((float) (this.badgeHeight / 2));
            return;
        }
        this.deltaX = (this.pivotX - ((float) (this.viewWidth / 2))) + this.badge.getRadius();
        this.deltaY = (this.pivotY - ((float) (this.viewHeight / 2))) + this.badge.getRadius();
    }

    private void computeTopRight() {
        if (this.isDrawBackgroundAdded) {
            defineMeasurement();
            this.deltaX = (this.pivotX + ((float) (this.viewWidth / 2))) - ((float) (this.badgeWidth / 2));
            this.deltaY = (this.pivotY - ((float) (this.viewHeight / 2))) + ((float) (this.badgeHeight / 2));
            return;
        }
        this.deltaX = (this.pivotX + ((float) (this.viewWidth / 2))) - this.badge.getRadius();
        this.deltaY = (this.pivotY - ((float) (this.viewHeight / 2))) + this.badge.getRadius();
    }

    private void computeBottomLeft() {
        if (this.isDrawBackgroundAdded) {
            defineMeasurement();
            this.deltaX = (this.pivotX - ((float) (this.viewWidth / 2))) + ((float) (this.badgeWidth / 2));
            this.deltaY = (this.pivotY + ((float) (this.viewHeight / 2))) - ((float) (this.badgeHeight / 2));
            return;
        }
        this.deltaX = (this.pivotX - ((float) (this.viewWidth / 2))) + this.badge.getRadius();
        this.deltaY = (this.pivotY + ((float) (this.viewHeight / 2))) - this.badge.getRadius();
    }

    private void computeBottomRight() {
        if (this.isDrawBackgroundAdded) {
            defineMeasurement();
            this.deltaX = (this.pivotX + ((float) (this.viewWidth / 2))) - ((float) (this.badgeWidth / 2));
            this.deltaY = (this.pivotY + ((float) (this.viewHeight / 2))) - ((float) (this.badgeHeight / 2));
            return;
        }
        this.deltaX = (this.pivotX + ((float) (this.viewWidth / 2))) - this.badge.getRadius();
        this.deltaY = (this.pivotY + ((float) (this.viewHeight / 2))) - this.badge.getRadius();
    }

    private void computeCenter() {
        this.deltaX = (float) (this.viewWidth / 2);
        this.deltaY = (float) (this.viewHeight / 2);
        if (this.isDrawBackgroundAdded) {
            defineMeasurement();
        }
    }

    private void computeBadgeWidth() {
        if (this.badge.getFixedRadiusSize() != -1.0f) {
            this.badgeWidth = (int) (this.badge.getFixedRadiusSize() * 2.0f);
        } else if (!this.isDrawBackgroundAdded || this.badge.getValue() <= 9 || !this.badge.isOvalAfterFirst() || this.badge.isFixedRadius()) {
            this.badgeWidth = (int) (this.badge.getTextWidth() + (this.badge.getPadding() * 2.0f));
        } else {
            this.badgeWidth = (int) (this.badge.getTextWidth() + (this.badge.getPadding() * 4.0f));
        }
    }

    private void computeBadgeHeight() {
        if (this.badge.getFixedRadiusSize() != -1.0f) {
            this.badgeHeight = (int) (this.badge.getFixedRadiusSize() * 2.0f);
        } else {
            this.badgeHeight = (int) (this.badge.getBadgeTextSize() + (this.badge.getPadding() * 2.0f));
        }
    }

    private void computeRadius() {
        if (this.badge.getFixedRadiusSize() != -1.0f) {
            Badge badge2 = this.badge;
            badge2.setRadius(badge2.getFixedRadiusSize());
            return;
        }
        this.badge.setRadius(((float) this.badgeWidth) / 2.0f);
    }

    private boolean checkFixedRadius() {
        return this.badge.getFixedRadiusSize() != -1.0f || this.badge.isFixedRadius();
    }

    public int getBadgeHeight() {
        return this.badgeHeight;
    }

    public int getBadgeWidth() {
        return this.badgeWidth;
    }

    public float getDeltaX() {
        return this.deltaX;
    }

    public float getDeltaY() {
        return this.deltaY;
    }
}
