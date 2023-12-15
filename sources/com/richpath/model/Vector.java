package com.richpath.model;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.richpath.RichPath;
import com.richpath.util.XmlParser;
import java.util.ArrayList;
import java.util.List;

public class Vector {
    public static final String TAG_NAME = "vector";
    private float alpha;
    private boolean autoMirrored;
    private float currentHeight;
    private float currentWidth;
    private float height;
    private String name;
    public List<RichPath> paths = new ArrayList();
    private int tint;
    private float viewportHeight;
    private float viewportWidth;
    private float width;

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public float getViewportWidth() {
        return this.viewportWidth;
    }

    public float getViewportHeight() {
        return this.viewportHeight;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }

    public float getCurrentWidth() {
        return this.currentWidth;
    }

    public void setCurrentWidth(float f) {
        this.currentWidth = f;
    }

    public float getCurrentHeight() {
        return this.currentHeight;
    }

    public void setCurrentHeight(float f) {
        this.currentHeight = f;
    }

    public void inflate(XmlResourceParser xmlResourceParser, Context context) {
        this.name = XmlParser.getAttributeString(context, xmlResourceParser, "name", this.name);
        this.tint = XmlParser.getAttributeColor(context, xmlResourceParser, "tint", this.tint);
        this.width = XmlParser.getAttributeDimen(context, xmlResourceParser, "width", this.width);
        this.height = XmlParser.getAttributeDimen(context, xmlResourceParser, "height", this.height);
        this.alpha = XmlParser.getAttributeFloat(xmlResourceParser, "alpha", this.alpha);
        this.autoMirrored = XmlParser.getAttributeBoolean(xmlResourceParser, "autoMirrored", this.autoMirrored);
        this.viewportWidth = XmlParser.getAttributeFloat(xmlResourceParser, "viewportWidth", this.viewportWidth);
        float attributeFloat = XmlParser.getAttributeFloat(xmlResourceParser, "viewportHeight", this.viewportHeight);
        this.viewportHeight = attributeFloat;
        this.currentWidth = this.viewportWidth;
        this.currentHeight = attributeFloat;
    }
}
