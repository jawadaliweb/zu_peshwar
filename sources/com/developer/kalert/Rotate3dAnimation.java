package com.developer.kalert;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {
    private static final int ROLL_BY_X = 0;
    private static final int ROLL_BY_Y = 1;
    private static final int ROLL_BY_Z = 2;
    private Camera camera;
    private final float fromDegrees;
    private int mPivotXType = 0;
    private float mPivotXValue = 0.0f;
    private int mPivotYType = 0;
    private float mPivotYValue = 0.0f;
    private float pivotX;
    private float pivotY;
    private final int rollType;
    private final float toDegrees;

    static class Description {
        int type;
        float value;

        Description() {
        }
    }

    private Description parseValue(TypedValue typedValue) {
        Description description = new Description();
        if (typedValue == null) {
            description.type = 0;
            description.value = 0.0f;
        } else if (typedValue.type == 6) {
            int i = 1;
            if ((typedValue.data & 15) == 1) {
                i = 2;
            }
            description.type = i;
            description.value = TypedValue.complexToFloat(typedValue.data);
            return description;
        } else if (typedValue.type == 4) {
            description.type = 0;
            description.value = typedValue.getFloat();
            return description;
        } else if (typedValue.type >= 16 && typedValue.type <= 31) {
            description.type = 0;
            description.value = (float) typedValue.data;
            return description;
        }
        description.type = 0;
        description.value = 0.0f;
        return description;
    }

    public Rotate3dAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Rotate3dAnimation);
        this.fromDegrees = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_fromDeg, 0.0f);
        this.toDegrees = obtainStyledAttributes.getFloat(R.styleable.Rotate3dAnimation_toDeg, 0.0f);
        this.rollType = obtainStyledAttributes.getInt(R.styleable.Rotate3dAnimation_rollType, 0);
        Description parseValue = parseValue(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotX));
        this.mPivotXType = parseValue.type;
        this.mPivotXValue = parseValue.value;
        Description parseValue2 = parseValue(obtainStyledAttributes.peekValue(R.styleable.Rotate3dAnimation_pivotY));
        this.mPivotYType = parseValue2.type;
        this.mPivotYValue = parseValue2.value;
        obtainStyledAttributes.recycle();
        initializePivotPoint();
    }

    public Rotate3dAnimation(int i, float f, float f2) {
        this.rollType = i;
        this.fromDegrees = f;
        this.toDegrees = f2;
        this.pivotX = 0.0f;
        this.pivotY = 0.0f;
    }

    public Rotate3dAnimation(int i, float f, float f2, float f3, float f4) {
        this.rollType = i;
        this.fromDegrees = f;
        this.toDegrees = f2;
        this.mPivotXType = 0;
        this.mPivotYType = 0;
        this.mPivotXValue = f3;
        this.mPivotYValue = f4;
        initializePivotPoint();
    }

    public Rotate3dAnimation(int i, float f, float f2, int i2, float f3, int i3, float f4) {
        this.rollType = i;
        this.fromDegrees = f;
        this.toDegrees = f2;
        this.mPivotXValue = f3;
        this.mPivotXType = i2;
        this.mPivotYValue = f4;
        this.mPivotYType = i3;
        initializePivotPoint();
    }

    private void initializePivotPoint() {
        if (this.mPivotXType == 0) {
            this.pivotX = this.mPivotXValue;
        }
        if (this.mPivotYType == 0) {
            this.pivotY = this.mPivotYValue;
        }
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.camera = new Camera();
        this.pivotX = resolveSize(this.mPivotXType, this.mPivotXValue, i, i3);
        this.pivotY = resolveSize(this.mPivotYType, this.mPivotYValue, i2, i4);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.fromDegrees;
        float f3 = f2 + ((this.toDegrees - f2) * f);
        Matrix matrix = transformation.getMatrix();
        this.camera.save();
        int i = this.rollType;
        if (i == 0) {
            this.camera.rotateX(f3);
        } else if (i == 1) {
            this.camera.rotateY(f3);
        } else if (i == 2) {
            this.camera.rotateZ(f3);
        }
        this.camera.getMatrix(matrix);
        this.camera.restore();
        matrix.preTranslate(-this.pivotX, -this.pivotY);
        matrix.postTranslate(this.pivotX, this.pivotY);
    }
}
