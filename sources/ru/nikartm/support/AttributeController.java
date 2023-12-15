package ru.nikartm.support;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import ru.nikartm.support.constant.Constants;
import ru.nikartm.support.model.Badge;
import ru.nikartm.support.util.DensityUtils;

public class AttributeController {
    private AttributeSet attrs;
    private Badge badge = new Badge();
    private View view;

    public AttributeController(View view2, AttributeSet attributeSet) {
        this.view = view2;
        this.attrs = attributeSet;
        initAttr();
    }

    private void initAttr() {
        TypedArray obtainStyledAttributes = this.view.getContext().obtainStyledAttributes(this.attrs, R.styleable.ImageBadgeView);
        int i = obtainStyledAttributes.getInt(R.styleable.ImageBadgeView_ibv_badgeValue, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.ImageBadgeView_ibv_maxBadgeValue, 99);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.ImageBadgeView_ibv_badgeTextSize, DensityUtils.txtPxToSp(12.0f));
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.ImageBadgeView_ibv_badgePadding, DensityUtils.pxToDp(0.0f));
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.ImageBadgeView_ibv_fixedBadgeRadius, DensityUtils.pxToDp(-1.0f));
        int i3 = obtainStyledAttributes.getInt(R.styleable.ImageBadgeView_ibv_badgeTextStyle, 0);
        String string = obtainStyledAttributes.getString(R.styleable.ImageBadgeView_ibv_badgeTextFont);
        Typeface createFromFile = string != null ? Typeface.createFromFile(string) : Constants.DEFAULT_FONT;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageBadgeView_ibv_badgeBackground);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_visibleBadge, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_badgeLimitValue, true);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_roundBadge, true);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_fixedRadius, false);
        boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_badgeOvalAfterFirst, false);
        int color = obtainStyledAttributes.getColor(R.styleable.ImageBadgeView_ibv_badgeColor, Constants.DEFAULT_BADGE_COLOR);
        int color2 = obtainStyledAttributes.getColor(R.styleable.ImageBadgeView_ibv_badgeTextColor, -1);
        this.badge.setValue(i).setMaxValue(i2).setBadgeTextSize(dimension).setPadding(dimension2).setFixedRadiusSize(dimension3).setTextStyle(i3).setBadgeTextFont(createFromFile).setBackgroundDrawable(drawable).setVisible(z).setLimitValue(z2).setRoundBadge(z3).setFixedRadius(z4).setOvalAfterFirst(z5).setShowCounter(obtainStyledAttributes.getBoolean(R.styleable.ImageBadgeView_ibv_showCounter, true)).setBadgeColor(color).setBadgeTextColor(color2).setPosition(obtainStyledAttributes.getInt(R.styleable.ImageBadgeView_ibv_badgePosition, 1));
        obtainStyledAttributes.recycle();
    }

    public Badge getBadge() {
        return this.badge;
    }
}
