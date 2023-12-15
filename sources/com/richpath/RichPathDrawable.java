package com.richpath;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.richpath.listener.OnRichPathUpdatedListener;
import com.richpath.model.Vector;
import com.richpath.pathparser.PathParser;
import com.richpath.util.PathUtils;

class RichPathDrawable extends Drawable {
    private int height;
    private ImageView.ScaleType scaleType;
    private Vector vector;
    private int width;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public RichPathDrawable(Vector vector2, ImageView.ScaleType scaleType2) {
        this.vector = vector2;
        this.scaleType = scaleType2;
        listenToPathsUpdates();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.width() > 0 && rect.height() > 0) {
            this.width = rect.width();
            this.height = rect.height();
            mapPaths();
        }
    }

    /* access modifiers changed from: package-private */
    public void mapPaths() {
        if (this.vector != null) {
            float f = (float) (this.width / 2);
            float f2 = (float) (this.height / 2);
            Matrix matrix = new Matrix();
            matrix.postTranslate(f - (this.vector.getCurrentWidth() / 2.0f), f2 - (this.vector.getCurrentHeight() / 2.0f));
            float currentWidth = ((float) this.width) / this.vector.getCurrentWidth();
            float currentHeight = ((float) this.height) / this.vector.getCurrentHeight();
            if (this.scaleType == ImageView.ScaleType.FIT_XY) {
                matrix.postScale(currentWidth, currentHeight, f, f2);
            } else {
                if (this.width >= this.height) {
                    currentWidth = currentHeight;
                }
                matrix.postScale(currentWidth, currentWidth, f, f2);
            }
            float min = Math.min(((float) this.width) / this.vector.getViewportWidth(), ((float) this.height) / this.vector.getViewportHeight());
            for (RichPath next : this.vector.paths) {
                next.mapToMatrix(matrix);
                next.scaleStrokeWidth(min);
            }
            this.vector.setCurrentWidth((float) this.width);
            this.vector.setCurrentHeight((float) this.height);
        }
    }

    public RichPath[] findAllRichPaths() {
        Vector vector2 = this.vector;
        if (vector2 == null) {
            return new RichPath[0];
        }
        return (RichPath[]) this.vector.paths.toArray(new RichPath[vector2.paths.size()]);
    }

    public RichPath findRichPathByName(String str) {
        Vector vector2 = this.vector;
        if (vector2 == null) {
            return null;
        }
        for (RichPath next : vector2.paths) {
            if (str.equals(next.getName())) {
                return next;
            }
        }
        return null;
    }

    public RichPath findFirstRichPath() {
        return findRichPathByIndex(0);
    }

    public RichPath findRichPathByIndex(int i) {
        Vector vector2 = this.vector;
        if (vector2 == null || i < 0 || i >= vector2.paths.size()) {
            return null;
        }
        return this.vector.paths.get(i);
    }

    public void listenToPathsUpdates() {
        Vector vector2 = this.vector;
        if (vector2 != null) {
            for (RichPath onRichPathUpdatedListener : vector2.paths) {
                onRichPathUpdatedListener.setOnRichPathUpdatedListener(new OnRichPathUpdatedListener() {
                    public void onPathUpdated() {
                        RichPathDrawable.this.invalidateSelf();
                    }
                });
            }
        }
    }

    public void addPath(String str) {
        addPath(PathParser.createPathFromPathData(str));
    }

    public void addPath(Path path) {
        if (path instanceof RichPath) {
            addPath((RichPath) path);
        } else {
            addPath(new RichPath(path));
        }
    }

    private void addPath(RichPath richPath) {
        Vector vector2 = this.vector;
        if (vector2 != null) {
            vector2.paths.add(richPath);
            richPath.setOnRichPathUpdatedListener(new OnRichPathUpdatedListener() {
                public void onPathUpdated() {
                    RichPathDrawable.this.invalidateSelf();
                }
            });
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public RichPath getTouchedPath(MotionEvent motionEvent) {
        if (this.vector != null && motionEvent.getAction() == 1) {
            for (int size = this.vector.paths.size() - 1; size >= 0; size--) {
                RichPath richPath = this.vector.paths.get(size);
                if (PathUtils.isTouched(richPath, motionEvent.getX(), motionEvent.getY())) {
                    return richPath;
                }
            }
        }
        return null;
    }

    public void draw(Canvas canvas) {
        Vector vector2 = this.vector;
        if (vector2 != null && vector2.paths.size() >= 0) {
            for (RichPath draw : this.vector.paths) {
                draw.draw(canvas);
            }
        }
    }
}
