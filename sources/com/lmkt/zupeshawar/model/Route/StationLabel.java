package com.lmkt.zupeshawar.model.Route;

import android.graphics.RectF;

public class StationLabel {
    Float angle;
    RectF rectangle;
    String title;

    public StationLabel(String str, RectF rectF, Float f) {
        this.title = str;
        this.rectangle = rectF;
        this.angle = f;
    }
}
