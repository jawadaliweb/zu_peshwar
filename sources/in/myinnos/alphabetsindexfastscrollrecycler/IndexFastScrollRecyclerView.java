package in.myinnos.alphabetsindexfastscrollrecycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class IndexFastScrollRecyclerView extends RecyclerView {
    private boolean mEnabled = true;
    private GestureDetector mGestureDetector = null;
    public int mIndexBarCornerRadius = 5;
    public float mIndexBarTransparentValue = 0.6f;
    public int mIndexbarBackgroudColor = ViewCompat.MEASURED_STATE_MASK;
    public int mIndexbarHighLateTextColor = ViewCompat.MEASURED_STATE_MASK;
    public float mIndexbarMargin = 5.0f;
    public int mIndexbarTextColor = -1;
    public float mIndexbarWidth = 20.0f;
    public int mPreviewPadding = 5;
    private IndexFastScrollRecyclerSection mScroller = null;
    public int setIndexTextSize = 12;

    public IndexFastScrollRecyclerView(Context context) {
        super(context);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndexFastScrollRecyclerView, 0, 0)) == null)) {
            try {
                this.setIndexTextSize = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexTextSize, this.setIndexTextSize);
                this.mIndexbarWidth = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarWidth, this.mIndexbarWidth);
                this.mIndexbarMargin = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarMargin, this.mIndexbarMargin);
                this.mPreviewPadding = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setPreviewPadding, this.mPreviewPadding);
                this.mIndexBarCornerRadius = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexBarCornerRadius, this.mIndexBarCornerRadius);
                this.mIndexBarTransparentValue = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexBarTransparentValue, this.mIndexBarTransparentValue);
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor)) {
                    this.mIndexbarBackgroudColor = Color.parseColor(obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor)) {
                    this.mIndexbarTextColor = Color.parseColor(obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor)) {
                    this.mIndexbarHighLateTextColor = Color.parseColor(obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarColorRes)) {
                    this.mIndexbarBackgroudColor = obtainStyledAttributes.getColor(R.styleable.IndexFastScrollRecyclerView_setIndexBarColorRes, this.mIndexbarBackgroudColor);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColorRes)) {
                    this.mIndexbarTextColor = obtainStyledAttributes.getColor(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColorRes, this.mIndexbarTextColor);
                }
                if (obtainStyledAttributes.hasValue(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColorRes)) {
                    this.mIndexbarHighLateTextColor = obtainStyledAttributes.getColor(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor, this.mIndexbarHighLateTextColor);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mScroller = new IndexFastScrollRecyclerSection(context, this);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
            if (indexFastScrollRecyclerSection != null && indexFastScrollRecyclerSection.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.mGestureDetector == null) {
                this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                        return super.onFling(motionEvent, motionEvent2, f, f2);
                    }
                });
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection;
        if (!this.mEnabled || (indexFastScrollRecyclerSection = this.mScroller) == null || !indexFastScrollRecyclerSection.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.setAdapter(adapter);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setIndexTextSize(int i) {
        this.mScroller.setIndexTextSize(i);
    }

    public void setIndexbarWidth(float f) {
        this.mScroller.setIndexbarWidth(f);
    }

    public void setIndexbarMargin(float f) {
        this.mScroller.setIndexbarMargin(f);
    }

    public void setPreviewPadding(int i) {
        this.mScroller.setPreviewPadding(i);
    }

    public void setIndexBarCornerRadius(int i) {
        this.mScroller.setIndexBarCornerRadius(i);
    }

    public void setIndexBarTransparentValue(float f) {
        this.mScroller.setIndexBarTransparentValue(f);
    }

    public void setTypeface(Typeface typeface) {
        this.mScroller.setTypeface(typeface);
    }

    public void setIndexBarVisibility(boolean z) {
        this.mScroller.setIndexBarVisibility(z);
        this.mEnabled = z;
    }

    public void setPreviewVisibility(boolean z) {
        this.mScroller.setPreviewVisibility(z);
    }

    public void setIndexBarColor(String str) {
        this.mScroller.setIndexBarColor(Color.parseColor(str));
    }

    public void setIndexBarColor(int i) {
        this.mScroller.setIndexBarColor(getContext().getResources().getColor(i));
    }

    public void setIndexBarTextColor(String str) {
        this.mScroller.setIndexBarTextColor(Color.parseColor(str));
    }

    public void setIndexBarTextColor(int i) {
        this.mScroller.setIndexBarTextColor(getContext().getResources().getColor(i));
    }

    public void setIndexbarHighLateTextColor(String str) {
        this.mScroller.setIndexBarHighLateTextColor(Color.parseColor(str));
    }

    public void setIndexbarHighLateTextColor(int i) {
        this.mScroller.setIndexBarHighLateTextColor(getContext().getResources().getColor(i));
    }

    public void setIndexBarHighLateTextVisibility(boolean z) {
        this.mScroller.setIndexBarHighLateTextVisibility(z);
    }
}
