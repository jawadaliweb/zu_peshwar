package com.bartoszlipinski.viewpropertyobjectanimator;

import android.view.View;
import java.lang.ref.WeakReference;

abstract class ChangeUpdateListener {
    protected final WeakReference<View> mView;

    public float calculateAnimatedValue(float f, float f2, float f3) {
        return f2 - ((f2 - f) * (1.0f - f3));
    }

    public ChangeUpdateListener(View view) {
        this.mView = new WeakReference<>(view);
    }

    /* access modifiers changed from: protected */
    public boolean hasView() {
        return this.mView.get() != null;
    }

    protected class IntValues {
        public int mFrom;
        public int mTo;

        public IntValues(int i, int i2) {
            this.mFrom = i;
            this.mTo = i2;
        }
    }

    protected class FloatValues {
        public float mFrom;
        public float mTo;

        public FloatValues(float f, float f2) {
            this.mFrom = f;
            this.mTo = f2;
        }
    }
}
