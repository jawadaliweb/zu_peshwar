package ru.nikartm.support;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import ru.nikartm.support.listener.OnBadgeCountChangeListener;
import ru.nikartm.support.util.DensityUtils;

public class ImageBadgeView extends AppCompatImageView {
    private DrawerManager manager;
    private OnBadgeCountChangeListener onBadgeCountChangeListener;

    public ImageBadgeView(Context context) {
        super(context);
        initAttr((AttributeSet) null);
    }

    public ImageBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(attributeSet);
    }

    public ImageBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(attributeSet);
    }

    private void initAttr(AttributeSet attributeSet) {
        this.manager = new DrawerManager(this, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.manager.drawBadge(canvas);
    }

    public void setOnBadgeCountChangeListener(OnBadgeCountChangeListener onBadgeCountChangeListener2) {
        this.onBadgeCountChangeListener = onBadgeCountChangeListener2;
    }

    public int getBadgeValue() {
        return this.manager.getBadge().getValue();
    }

    public ImageBadgeView setBadgeValue(int i) {
        this.manager.getBadge().setValue(i);
        OnBadgeCountChangeListener onBadgeCountChangeListener2 = this.onBadgeCountChangeListener;
        if (onBadgeCountChangeListener2 != null) {
            onBadgeCountChangeListener2.onCountChange(i);
        }
        invalidate();
        return this;
    }

    public int getMaxBadgeValue() {
        return this.manager.getBadge().getMaxValue();
    }

    public ImageBadgeView setMaxBadgeValue(int i) {
        this.manager.getBadge().setMaxValue(i);
        invalidate();
        return this;
    }

    public boolean isVisibleBadge() {
        return this.manager.getBadge().isVisible();
    }

    public ImageBadgeView visibleBadge(boolean z) {
        this.manager.getBadge().setVisible(z);
        invalidate();
        return this;
    }

    public boolean isRoundBadge() {
        return this.manager.getBadge().isRoundBadge();
    }

    public ImageBadgeView setRoundBadge(boolean z) {
        this.manager.getBadge().setRoundBadge(z);
        invalidate();
        return this;
    }

    public boolean isFixedRadius() {
        return this.manager.getBadge().isFixedRadius();
    }

    public ImageBadgeView setFixedRadius(boolean z) {
        this.manager.getBadge().setFixedRadius(z);
        invalidate();
        return this;
    }

    public boolean isBadgeOvalAfterFirst() {
        return this.manager.getBadge().isOvalAfterFirst();
    }

    public ImageBadgeView setBadgeOvalAfterFirst(boolean z) {
        this.manager.getBadge().setOvalAfterFirst(z);
        invalidate();
        return this;
    }

    public boolean isShowCounter() {
        return this.manager.getBadge().isShowCounter();
    }

    public ImageBadgeView setShowCounter(boolean z) {
        this.manager.getBadge().setShowCounter(z);
        invalidate();
        return this;
    }

    public boolean isLimitValue() {
        return this.manager.getBadge().isLimitValue();
    }

    public ImageBadgeView setLimitBadgeValue(boolean z) {
        this.manager.getBadge().setLimitValue(z);
        invalidate();
        return this;
    }

    public int getBadgeColor() {
        return this.manager.getBadge().getBadgeColor();
    }

    public ImageBadgeView setBadgeColor(int i) {
        this.manager.getBadge().setBadgeColor(i);
        invalidate();
        return this;
    }

    public int getBadgeTextColor() {
        return this.manager.getBadge().getBadgeTextColor();
    }

    public ImageBadgeView setBadgeTextColor(int i) {
        this.manager.getBadge().setBadgeTextColor(i);
        invalidate();
        return this;
    }

    public float getBadgeTextSize() {
        return this.manager.getBadge().getBadgeTextSize();
    }

    public ImageBadgeView setBadgeTextSize(float f) {
        this.manager.getBadge().setBadgeTextSize(DensityUtils.dpToPx(f));
        invalidate();
        return this;
    }

    public float getBadgePadding() {
        return this.manager.getBadge().getPadding();
    }

    public ImageBadgeView setBadgePadding(int i) {
        this.manager.getBadge().setPadding(DensityUtils.txtPxToSp((float) i));
        invalidate();
        return this;
    }

    public float getBadgeRadius() {
        return this.manager.getBadge().getRadius();
    }

    public ImageBadgeView setFixedBadgeRadius(float f) {
        this.manager.getBadge().setFixedRadiusSize(f);
        invalidate();
        return this;
    }

    public Typeface getBadgeTextFont() {
        return this.manager.getBadge().getBadgeTextFont();
    }

    public ImageBadgeView setBadgeTextFont(Typeface typeface) {
        this.manager.getBadge().setBadgeTextFont(typeface);
        invalidate();
        return this;
    }

    public int getBadgeTextStyle() {
        return this.manager.getBadge().getTextStyle();
    }

    public ImageBadgeView setBadgeTextStyle(int i) {
        this.manager.getBadge().setTextStyle(i);
        invalidate();
        return this;
    }

    public int getBadgeBackground() {
        return this.manager.getBadge().getBadgeBackground();
    }

    public Drawable getBadgeBackgroundDrawable() {
        return this.manager.getBadge().getBackgroundDrawable();
    }

    public ImageBadgeView setBadgeBackground(Drawable drawable) {
        this.manager.getBadge().setBackgroundDrawable(drawable);
        invalidate();
        return this;
    }

    public void clearBadge() {
        this.manager.getBadge().clearValue();
        invalidate();
    }

    public int getBadgePosition() {
        return this.manager.getBadge().getPosition();
    }

    public ImageBadgeView setBadgePosition(int i) {
        this.manager.getBadge().setPosition(i);
        invalidate();
        return this;
    }
}
