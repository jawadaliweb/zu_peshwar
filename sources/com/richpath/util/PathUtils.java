package com.richpath.util;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import com.richpath.pathparser.PathDataNode;

public class PathUtils {
    public static void resizePath(Path path, float f, float f2) {
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        RectF rectF2 = new RectF();
        path.computeBounds(rectF2, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
        path.transform(matrix);
    }

    public static void setPathWidth(Path path, float f) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, new RectF(rectF.left, rectF.top, rectF.left + f, rectF.bottom), Matrix.ScaleToFit.FILL);
        path.transform(matrix);
    }

    public static void setPathHeight(Path path, float f) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, new RectF(rectF.left, rectF.top, rectF.right, rectF.top + f), Matrix.ScaleToFit.FILL);
        path.transform(matrix);
    }

    public static float getPathWidth(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return rectF.width();
    }

    public static float getPathHeight(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return rectF.height();
    }

    public static void setPathRotation(Path path, float f) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        setPathRotation(path, f, rectF.centerX(), rectF.centerY());
    }

    public static void setPathRotation(Path path, float f, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f, f2, f3);
        path.transform(matrix);
    }

    public static void setPathTranslationX(Path path, float f) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(f, 0.0f);
        path.transform(matrix);
    }

    public static void setPathTranslationY(Path path, float f) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(0.0f, f);
        path.transform(matrix);
    }

    public static void setPathScaleX(Path path, float f, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, 1.0f, f2, f3);
        path.transform(matrix);
    }

    public static void setPathScaleY(Path path, float f, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, f, f2, f3);
        path.transform(matrix);
    }

    public static void setPathScaleX(Path path, float f) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        setPathScaleX(path, f, rectF.centerX(), rectF.centerY());
    }

    public static void setPathScaleY(Path path, float f) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        setPathScaleY(path, f, rectF.centerX(), rectF.centerY());
    }

    public static void setPathDataNodes(Path path, PathDataNode[] pathDataNodeArr) {
        path.reset();
        PathDataNode.nodesToPath(pathDataNodeArr, path);
    }

    public static boolean isTouched(Path path, float f, float f2) {
        Region region = new Region();
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        int i = (int) f;
        int i2 = (int) f2;
        if (region.contains(i, i2)) {
            return true;
        }
        int i3 = i + 10;
        int i4 = i2 + 10;
        if (region.contains(i3, i4)) {
            return true;
        }
        int i5 = i2 - 10;
        if (region.contains(i3, i5)) {
            return true;
        }
        int i6 = i - 10;
        if (region.contains(i6, i5) || region.contains(i6, i4)) {
            return true;
        }
        return false;
    }
}
