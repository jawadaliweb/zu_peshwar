package com.richpath.model;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Matrix;
import androidx.constraintlayout.motion.widget.Key;
import com.richpath.util.XmlParser;

public class Group {
    public static final String TAG_NAME = "group";
    private Matrix matrix;
    private String name;
    private float pivotX = 0.0f;
    private float pivotY = 0.0f;
    private float rotation = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translateX = 0.0f;
    private float translateY = 0.0f;

    public Group(Context context, XmlResourceParser xmlResourceParser) {
        inflate(context, xmlResourceParser);
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getPivotX() {
        return this.pivotX;
    }

    public float getPivotY() {
        return this.pivotY;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getTranslateX() {
        return this.translateX;
    }

    public float getTranslateY() {
        return this.translateY;
    }

    public String getName() {
        return this.name;
    }

    private void inflate(Context context, XmlResourceParser xmlResourceParser) {
        this.name = XmlParser.getAttributeString(context, xmlResourceParser, "name", this.name);
        this.rotation = XmlParser.getAttributeFloat(xmlResourceParser, Key.ROTATION, this.rotation);
        this.scaleX = XmlParser.getAttributeFloat(xmlResourceParser, "scaleX", this.scaleX);
        this.scaleY = XmlParser.getAttributeFloat(xmlResourceParser, "scaleY", this.scaleY);
        this.translateX = XmlParser.getAttributeFloat(xmlResourceParser, "translateX", this.translateX);
        this.translateY = XmlParser.getAttributeFloat(xmlResourceParser, "translateY", this.translateY);
        this.pivotX = XmlParser.getAttributeFloat(xmlResourceParser, "pivotX", this.pivotX) + this.translateX;
        this.pivotY = XmlParser.getAttributeFloat(xmlResourceParser, "pivotY", this.pivotY) + this.translateY;
        matrix();
    }

    public Matrix matrix() {
        if (this.matrix == null) {
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.postTranslate(-this.pivotX, -this.pivotY);
            this.matrix.postScale(this.scaleX, this.scaleY);
            this.matrix.postRotate(this.rotation, 0.0f, 0.0f);
            this.matrix.postTranslate(this.translateX + this.pivotX, this.translateY + this.pivotY);
        }
        return this.matrix;
    }

    public void scale(Matrix matrix2) {
        matrix().postConcat(matrix2);
    }
}
