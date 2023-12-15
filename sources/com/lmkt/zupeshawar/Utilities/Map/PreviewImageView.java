package com.lmkt.zupeshawar.Utilities.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PreviewImageView extends ImageView {
    public PreviewImageView(Context context) {
        super(context);
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
}
