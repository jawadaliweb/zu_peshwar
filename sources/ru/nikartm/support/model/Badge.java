package ru.nikartm.support.model;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class Badge {
    private Drawable backgroundDrawable;
    private int badgeBackground;
    private int badgeColor;
    private int badgeTextColor;
    private Typeface badgeTextFont;
    private float badgeTextSize;
    private boolean fixedRadius;
    private float fixedRadiusSize;
    private boolean limitValue;
    private int maxValue;
    private boolean ovalAfterFirst;
    private float padding;
    private int position;
    private float radius;
    private boolean roundBadge;
    private boolean showCounter;
    private int textStyle;
    private float textWidth;
    private int value;
    private boolean visible;

    public void clearValue() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }

    public Badge setValue(int i) {
        this.value = i;
        return this;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public Badge setMaxValue(int i) {
        this.maxValue = i;
        return this;
    }

    public float getRadius() {
        return this.radius;
    }

    public Badge setRadius(float f) {
        this.radius = f;
        return this;
    }

    public float getFixedRadiusSize() {
        return this.fixedRadiusSize;
    }

    public Badge setFixedRadiusSize(float f) {
        this.fixedRadiusSize = f;
        return this;
    }

    public int getBadgeColor() {
        return this.badgeColor;
    }

    public Badge setBadgeColor(int i) {
        this.badgeColor = i;
        return this;
    }

    public int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    public Badge setBadgeTextColor(int i) {
        this.badgeTextColor = i;
        return this;
    }

    public float getBadgeTextSize() {
        return this.badgeTextSize;
    }

    public Badge setBadgeTextSize(float f) {
        this.badgeTextSize = f;
        return this;
    }

    public float getPadding() {
        return this.padding;
    }

    public Badge setPadding(float f) {
        this.padding = f;
        return this;
    }

    public Typeface getBadgeTextFont() {
        return this.badgeTextFont;
    }

    public Badge setBadgeTextFont(Typeface typeface) {
        this.badgeTextFont = typeface;
        return this;
    }

    public int getTextStyle() {
        return this.textStyle;
    }

    public Badge setTextStyle(int i) {
        this.textStyle = i;
        return this;
    }

    public int getBadgeBackground() {
        return this.badgeBackground;
    }

    public Badge setBadgeBackground(int i) {
        this.badgeBackground = i;
        return this;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public Badge setVisible(boolean z) {
        this.visible = z;
        return this;
    }

    public boolean isLimitValue() {
        return this.limitValue;
    }

    public Badge setLimitValue(boolean z) {
        this.limitValue = z;
        return this;
    }

    public boolean isRoundBadge() {
        return this.roundBadge;
    }

    public Badge setRoundBadge(boolean z) {
        this.roundBadge = z;
        return this;
    }

    public boolean isFixedRadius() {
        return this.fixedRadius;
    }

    public Badge setFixedRadius(boolean z) {
        this.fixedRadius = z;
        return this;
    }

    public boolean isOvalAfterFirst() {
        return this.ovalAfterFirst;
    }

    public Badge setOvalAfterFirst(boolean z) {
        this.ovalAfterFirst = z;
        return this;
    }

    public boolean isShowCounter() {
        return this.showCounter;
    }

    public Badge setShowCounter(boolean z) {
        this.showCounter = z;
        return this;
    }

    public Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public Badge setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
        return this;
    }

    public float getTextWidth() {
        return this.textWidth;
    }

    public Badge setTextWidth(float f) {
        this.textWidth = f;
        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public Badge setPosition(int i) {
        this.position = i;
        return this;
    }
}
