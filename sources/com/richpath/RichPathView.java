package com.richpath;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.richpath.RichPath;
import com.richpath.model.Vector;
import com.richpath.pathparser.PathParser;
import com.richpath.util.XmlParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class RichPathView extends ImageView {
    private RichPath.OnPathClickListener onPathClickListener;
    private RichPathDrawable richPathDrawable;
    private Vector vector;

    public RichPathView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RichPathView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichPathView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        setupAttributes(attributeSet);
    }

    private void init() {
        setLayerType(1, (Paint) null);
    }

    private void setupAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.RichPathView, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.RichPathView_vector, -1);
            if (resourceId != -1) {
                setVectorDrawable(resourceId);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setVectorDrawable(int i) {
        XmlResourceParser xml = getContext().getResources().getXml(i);
        Vector vector2 = new Vector();
        this.vector = vector2;
        try {
            XmlParser.parseVector(vector2, xml, getContext());
            RichPathDrawable richPathDrawable2 = new RichPathDrawable(this.vector, getScaleType());
            this.richPathDrawable = richPathDrawable2;
            setImageDrawable(richPathDrawable2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Vector vector2 = this.vector;
        if (vector2 != null) {
            int width = (int) vector2.getWidth();
            int height = (int) this.vector.getHeight();
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                width = size;
            } else if (mode == Integer.MIN_VALUE) {
                width = Math.min(width, size);
            }
            if (mode2 == 1073741824) {
                height = size2;
            } else if (mode2 == Integer.MIN_VALUE) {
                height = Math.min(height, size2);
            }
            setMeasuredDimension(width, height);
        }
    }

    public RichPath[] findAllRichPaths() {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        return richPathDrawable2 == null ? new RichPath[0] : richPathDrawable2.findAllRichPaths();
    }

    public RichPath findRichPathByName(String str) {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        if (richPathDrawable2 == null) {
            return null;
        }
        return richPathDrawable2.findRichPathByName(str);
    }

    public RichPath findFirstRichPath() {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        if (richPathDrawable2 == null) {
            return null;
        }
        return richPathDrawable2.findFirstRichPath();
    }

    public RichPath findRichPathByIndex(int i) {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        if (richPathDrawable2 == null) {
            return null;
        }
        return richPathDrawable2.findRichPathByIndex(i);
    }

    public void addPath(String str) {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        if (richPathDrawable2 != null) {
            richPathDrawable2.addPath(PathParser.createPathFromPathData(str));
        }
    }

    public void addPath(Path path) {
        RichPathDrawable richPathDrawable2 = this.richPathDrawable;
        if (richPathDrawable2 != null) {
            richPathDrawable2.addPath(path);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            performClick();
        }
        RichPath touchedPath = this.richPathDrawable.getTouchedPath(motionEvent);
        if (touchedPath != null) {
            RichPath.OnPathClickListener onPathClickListener2 = touchedPath.getOnPathClickListener();
            if (onPathClickListener2 != null) {
                onPathClickListener2.onClick(touchedPath);
            }
            RichPath.OnPathClickListener onPathClickListener3 = this.onPathClickListener;
            if (onPathClickListener3 != null) {
                onPathClickListener3.onClick(touchedPath);
            }
        }
        return true;
    }

    public void setOnPathClickListener(RichPath.OnPathClickListener onPathClickListener2) {
        this.onPathClickListener = onPathClickListener2;
    }
}
