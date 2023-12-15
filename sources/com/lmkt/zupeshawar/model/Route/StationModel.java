package com.lmkt.zupeshawar.model.Route;

import android.graphics.RectF;
import androidx.core.view.ViewCompat;

public class StationModel {
    private int color_1;
    private int color_2;
    private String name;
    private RectF position;
    private Float rotationAngle;
    private int stationID;
    private StopType type;

    public StationModel(String str, RectF rectF, Float f, StopType stopType, int i, int i2) {
        this.name = str;
        this.position = rectF;
        this.rotationAngle = f;
        this.type = stopType;
        this.color_1 = i;
        this.color_2 = i2;
    }

    public StationModel(String str, RectF rectF, Float f, StopType stopType, int i) {
        this.name = str;
        this.position = rectF;
        this.rotationAngle = f;
        this.type = stopType;
        this.color_1 = ViewCompat.MEASURED_STATE_MASK;
        this.color_2 = ViewCompat.MEASURED_STATE_MASK;
        this.stationID = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public RectF getPosition() {
        return this.position;
    }

    public void setPosition(RectF rectF) {
        this.position = rectF;
    }

    public Float getRotationAngle() {
        return this.rotationAngle;
    }

    public void setRotationAngle(Float f) {
        this.rotationAngle = f;
    }

    public StopType getType() {
        return this.type;
    }

    public void setType(StopType stopType) {
        this.type = stopType;
    }

    public int getColor_1() {
        return this.color_1;
    }

    public void setColor_1(int i) {
        this.color_1 = i;
    }

    public int getColor_2() {
        return this.color_2;
    }

    public void setColor_2(int i) {
        this.color_2 = i;
    }

    public int getStationID() {
        return this.stationID;
    }

    public void setStationID(int i) {
        this.stationID = i;
    }
}
