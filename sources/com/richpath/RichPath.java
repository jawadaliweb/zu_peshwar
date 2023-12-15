package com.richpath;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import androidx.core.view.ViewCompat;
import com.richpath.listener.OnRichPathUpdatedListener;
import com.richpath.model.Group;
import com.richpath.pathparser.PathDataNode;
import com.richpath.pathparser.PathParser;
import com.richpath.pathparser.PathParserCompat;
import com.richpath.util.PathUtils;
import com.richpath.util.XmlParser;
import java.util.ArrayList;
import java.util.List;

public class RichPath extends Path {
    public static final String TAG_NAME = "path";
    private float fillAlpha;
    private int fillColor;
    private List<Matrix> matrices;
    private String name;
    private OnPathClickListener onPathClickListener;
    private OnRichPathUpdatedListener onRichPathUpdatedListener;
    private float originalHeight;
    private Path originalPath;
    private float originalWidth;
    private Paint paint;
    private PathDataNode[] pathDataNodes;
    private PathMeasure pathMeasure;
    private boolean pivotToCenter;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private float strokeAlpha;
    private int strokeColor;
    private Paint.Cap strokeLineCap;
    private Paint.Join strokeLineJoin;
    private float strokeMiterLimit;
    private float strokeWidth;
    private float translationX;
    private float translationY;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    public interface OnPathClickListener {
        void onClick(RichPath richPath);
    }

    public RichPath(String str) {
        this(PathParser.createPathFromPathData(str));
    }

    public RichPath(Path path) {
        super(path);
        this.fillColor = 0;
        this.strokeColor = 0;
        this.fillAlpha = 1.0f;
        this.strokeAlpha = 1.0f;
        this.strokeWidth = 0.0f;
        this.trimPathStart = 0.0f;
        this.trimPathEnd = 1.0f;
        this.trimPathOffset = 0.0f;
        this.strokeLineCap = Paint.Cap.BUTT;
        this.strokeLineJoin = Paint.Join.MITER;
        this.strokeMiterLimit = 4.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.pivotX = 0.0f;
        this.pivotY = 0.0f;
        this.pivotToCenter = false;
        this.originalPath = path;
        init();
    }

    private void init() {
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.matrices = new ArrayList();
        updateOriginalDimens();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setWidth(float f) {
        PathUtils.setPathWidth(this, f);
        PathUtils.setPathWidth(this.originalPath, f);
        onPathUpdated();
    }

    public float getWidth() {
        return PathUtils.getPathWidth(this);
    }

    public void setHeight(float f) {
        PathUtils.setPathHeight(this, f);
        PathUtils.setPathHeight(this.originalPath, f);
        onPathUpdated();
    }

    public float getHeight() {
        return PathUtils.getPathHeight(this);
    }

    /* access modifiers changed from: package-private */
    public void setOnRichPathUpdatedListener(OnRichPathUpdatedListener onRichPathUpdatedListener2) {
        this.onRichPathUpdatedListener = onRichPathUpdatedListener2;
    }

    public OnRichPathUpdatedListener getOnRichPathUpdatedListener() {
        return this.onRichPathUpdatedListener;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float f) {
        float f2 = f - this.rotation;
        if (this.pivotToCenter) {
            PathUtils.setPathRotation(this, f2);
            PathUtils.setPathRotation(this.originalPath, f2);
        } else {
            PathUtils.setPathRotation(this, f2, this.pivotX, this.pivotY);
            PathUtils.setPathRotation(this.originalPath, f2, this.pivotX, this.pivotY);
        }
        this.rotation = f;
        onPathUpdated();
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        if (this.pivotToCenter) {
            PathUtils.setPathScaleX(this, 1.0f / this.scaleX);
            PathUtils.setPathScaleX(this.originalPath, 1.0f / this.scaleX);
            PathUtils.setPathScaleX(this, f);
            PathUtils.setPathScaleX(this.originalPath, f);
        } else {
            PathUtils.setPathScaleX(this, 1.0f / this.scaleX, this.pivotX, this.pivotY);
            PathUtils.setPathScaleX(this.originalPath, 1.0f / this.scaleX, this.pivotX, this.pivotY);
            PathUtils.setPathScaleX(this, f, this.pivotX, this.pivotY);
            PathUtils.setPathScaleX(this.originalPath, f, this.pivotX, this.pivotY);
        }
        this.scaleX = f;
        onPathUpdated();
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        if (this.pivotToCenter) {
            PathUtils.setPathScaleY(this, 1.0f / this.scaleY);
            PathUtils.setPathScaleY(this.originalPath, 1.0f / this.scaleY);
            PathUtils.setPathScaleY(this, f);
            PathUtils.setPathScaleY(this.originalPath, f);
        } else {
            PathUtils.setPathScaleY(this, 1.0f / this.scaleY, this.pivotX, this.pivotY);
            PathUtils.setPathScaleY(this.originalPath, 1.0f / this.scaleY, this.pivotX, this.pivotY);
            PathUtils.setPathScaleY(this, f, this.pivotX, this.pivotY);
            PathUtils.setPathScaleY(this.originalPath, f, this.pivotX, this.pivotY);
        }
        this.scaleY = f;
        onPathUpdated();
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public void setTranslationX(float f) {
        PathUtils.setPathTranslationX(this, f - this.translationX);
        PathUtils.setPathTranslationX(this.originalPath, f - this.translationX);
        this.translationX = f;
        onPathUpdated();
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public void setTranslationY(float f) {
        PathUtils.setPathTranslationY(this, f - this.translationY);
        PathUtils.setPathTranslationY(this.originalPath, f - this.translationY);
        this.translationY = f;
        onPathUpdated();
    }

    public float getOriginalWidth() {
        return this.originalWidth;
    }

    public float getOriginalHeight() {
        return this.originalHeight;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        onPathUpdated();
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        onPathUpdated();
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        onPathUpdated();
    }

    public float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public void setStrokeAlpha(float f) {
        this.strokeAlpha = f;
        onPathUpdated();
    }

    public float getFillAlpha() {
        return this.fillAlpha;
    }

    public void setFillAlpha(float f) {
        this.fillAlpha = f;
        onPathUpdated();
    }

    public float getTrimPathStart() {
        return this.trimPathStart;
    }

    public void setTrimPathStart(float f) {
        this.trimPathStart = f;
        trim();
        onPathUpdated();
    }

    public float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public void setTrimPathEnd(float f) {
        this.trimPathEnd = f;
        trim();
        onPathUpdated();
    }

    public float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public void setTrimPathOffset(float f) {
        this.trimPathOffset = f;
        trim();
        onPathUpdated();
    }

    public Paint.Cap getStrokeLineCap() {
        return this.strokeLineCap;
    }

    public void setStrokeLineCap(Paint.Cap cap) {
        this.strokeLineCap = cap;
        onPathUpdated();
    }

    public Paint.Join getStrokeLineJoin() {
        return this.strokeLineJoin;
    }

    public void setStrokeLineJoin(Paint.Join join) {
        this.strokeLineJoin = join;
        onPathUpdated();
    }

    public float getStrokeMiterLimit() {
        return this.strokeMiterLimit;
    }

    public void setStrokeMiterLimit(float f) {
        this.strokeMiterLimit = f;
        onPathUpdated();
    }

    public float getPivotX() {
        return this.pivotX;
    }

    public void setPivotX(float f) {
        this.pivotX = f;
    }

    public float getPivotY() {
        return this.pivotY;
    }

    public void setPivotY(float f) {
        this.pivotY = f;
    }

    public boolean isPivotToCenter() {
        return this.pivotToCenter;
    }

    public void setPivotToCenter(boolean z) {
        this.pivotToCenter = z;
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas) {
        this.paint.setColor(applyAlpha(this.fillColor, this.fillAlpha));
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this, this.paint);
        this.paint.setColor(applyAlpha(this.strokeColor, this.strokeAlpha));
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this, this.paint);
    }

    public void applyGroup(Group group) {
        mapToMatrix(group.matrix());
        this.pivotX = group.getPivotX();
        this.pivotY = group.getPivotY();
    }

    /* access modifiers changed from: package-private */
    public void mapToMatrix(Matrix matrix) {
        this.matrices.add(matrix);
        transform(matrix);
        this.originalPath.transform(matrix);
        mapPoints(matrix);
        updateOriginalDimens();
    }

    private void mapPoints(Matrix matrix) {
        float[] fArr = {this.pivotX, this.pivotY};
        matrix.mapPoints(fArr);
        this.pivotX = fArr[0];
        this.pivotY = fArr[1];
    }

    /* access modifiers changed from: package-private */
    public void scaleStrokeWidth(float f) {
        this.paint.setStrokeWidth(this.strokeWidth * f);
    }

    public void setPathData(String str) {
        setPathDataNodes(PathParserCompat.createNodesFromPathData(str));
    }

    public PathDataNode[] getPathDataNodes() {
        return this.pathDataNodes;
    }

    public void setPathDataNodes(PathDataNode[] pathDataNodeArr) {
        PathUtils.setPathDataNodes(this, pathDataNodeArr);
        this.pathDataNodes = pathDataNodeArr;
        for (Matrix transform : this.matrices) {
            transform(transform);
        }
        onPathUpdated();
    }

    public void inflate(Context context, XmlResourceParser xmlResourceParser) {
        this.pathDataNodes = PathParserCompat.createNodesFromPathData(XmlParser.getAttributeString(context, xmlResourceParser, "pathData", this.name));
        this.name = XmlParser.getAttributeString(context, xmlResourceParser, "name", this.name);
        this.fillAlpha = XmlParser.getAttributeFloat(xmlResourceParser, "fillAlpha", this.fillAlpha);
        this.fillColor = XmlParser.getAttributeColor(context, xmlResourceParser, "fillColor", this.fillColor);
        this.strokeAlpha = XmlParser.getAttributeFloat(xmlResourceParser, "strokeAlpha", this.strokeAlpha);
        this.strokeColor = XmlParser.getAttributeColor(context, xmlResourceParser, "strokeColor", this.strokeColor);
        this.strokeLineCap = XmlParser.getAttributeStrokeLineCap(xmlResourceParser, "strokeLineCap", this.strokeLineCap);
        this.strokeLineJoin = XmlParser.getAttributeStrokeLineJoin(xmlResourceParser, "strokeLineJoin", this.strokeLineJoin);
        this.strokeMiterLimit = XmlParser.getAttributeFloat(xmlResourceParser, "strokeMiterLimit", this.strokeMiterLimit);
        this.strokeWidth = XmlParser.getAttributeFloat(xmlResourceParser, "strokeWidth", this.strokeWidth);
        this.trimPathStart = XmlParser.getAttributeFloat(xmlResourceParser, "trimPathStart", this.trimPathStart);
        this.trimPathEnd = XmlParser.getAttributeFloat(xmlResourceParser, "trimPathEnd", this.trimPathEnd);
        this.trimPathOffset = XmlParser.getAttributeFloat(xmlResourceParser, "trimPathOffset", this.trimPathOffset);
        setFillType(XmlParser.getAttributePathFillType(xmlResourceParser, "fillType", getFillType()));
        updatePaint();
        trim();
    }

    private void updateOriginalDimens() {
        this.originalWidth = PathUtils.getPathWidth(this);
        this.originalHeight = PathUtils.getPathHeight(this);
    }

    private void trim() {
        float f = this.trimPathStart;
        if (f != 0.0f || this.trimPathEnd != 1.0f) {
            float f2 = this.trimPathOffset;
            float f3 = (f + f2) % 1.0f;
            float f4 = (this.trimPathEnd + f2) % 1.0f;
            if (this.pathMeasure == null) {
                this.pathMeasure = new PathMeasure();
            }
            this.pathMeasure.setPath(this.originalPath, false);
            float length = this.pathMeasure.getLength();
            float f5 = f3 * length;
            float f6 = f4 * length;
            reset();
            if (f5 > f6) {
                this.pathMeasure.getSegment(f5, length, this, true);
                this.pathMeasure.getSegment(0.0f, f6, this, true);
            } else {
                this.pathMeasure.getSegment(f5, f6, this, true);
            }
            rLineTo(0.0f, 0.0f);
        }
    }

    private void updatePaint() {
        this.paint.setStrokeCap(this.strokeLineCap);
        this.paint.setStrokeJoin(this.strokeLineJoin);
        this.paint.setStrokeMiter(this.strokeMiterLimit);
        this.paint.setStrokeWidth(this.strokeWidth);
    }

    private void onPathUpdated() {
        OnRichPathUpdatedListener onRichPathUpdatedListener2 = this.onRichPathUpdatedListener;
        if (onRichPathUpdatedListener2 != null) {
            onRichPathUpdatedListener2.onPathUpdated();
        }
    }

    private int applyAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void setOnPathClickListener(OnPathClickListener onPathClickListener2) {
        this.onPathClickListener = onPathClickListener2;
    }

    /* access modifiers changed from: package-private */
    public OnPathClickListener getOnPathClickListener() {
        return this.onPathClickListener;
    }
}
