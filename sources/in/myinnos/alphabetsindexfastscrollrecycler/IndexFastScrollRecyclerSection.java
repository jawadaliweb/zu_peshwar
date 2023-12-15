package in.myinnos.alphabetsindexfastscrollrecycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SectionIndexer;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IndexFastScrollRecyclerSection extends RecyclerView.AdapterDataObserver {
    private static final int WHAT_FADE_PREVIEW = 1;
    AttributeSet attrs;
    private int indexPaintPaintColor = -1;
    private int indexbarBackgroudAlpha;
    private int indexbarBackgroudColor;
    private int indexbarHighLateTextColor;
    private int indexbarTextColor;
    private int mCurrentSection = -1;
    private float mDensity;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                IndexFastScrollRecyclerSection.this.mRecyclerView.invalidate();
            }
        }
    };
    private float mIndexbarMargin;
    private RectF mIndexbarRect;
    private float mIndexbarWidth;
    private SectionIndexer mIndexer = null;
    private boolean mIsIndexing = false;
    private int mListViewHeight;
    private int mListViewWidth;
    private float mPreviewPadding;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView = null;
    private float mScaledDensity;
    private String[] mSections = null;
    private boolean previewVisibility = true;
    private int setIndexBarCornerRadius;
    private Boolean setIndexBarVisibility = true;
    private int setIndexTextSize;
    private float setIndexbarMargin;
    private float setIndexbarWidth;
    private int setPreviewPadding;
    private Boolean setSetIndexBarHighLateTextVisibility = false;
    private Typeface setTypeface = null;

    private int convertTransparentValueToBackgroundAlpha(float f) {
        return (int) (f * 255.0f);
    }

    public IndexFastScrollRecyclerSection(Context context, IndexFastScrollRecyclerView indexFastScrollRecyclerView) {
        this.setIndexTextSize = indexFastScrollRecyclerView.setIndexTextSize;
        this.setIndexbarWidth = indexFastScrollRecyclerView.mIndexbarWidth;
        this.setIndexbarMargin = indexFastScrollRecyclerView.mIndexbarMargin;
        this.setPreviewPadding = indexFastScrollRecyclerView.mPreviewPadding;
        this.setIndexBarCornerRadius = indexFastScrollRecyclerView.mIndexBarCornerRadius;
        this.indexbarBackgroudColor = indexFastScrollRecyclerView.mIndexbarBackgroudColor;
        this.indexbarTextColor = indexFastScrollRecyclerView.mIndexbarTextColor;
        this.indexbarHighLateTextColor = indexFastScrollRecyclerView.mIndexbarHighLateTextColor;
        this.indexbarBackgroudAlpha = convertTransparentValueToBackgroundAlpha(indexFastScrollRecyclerView.mIndexBarTransparentValue);
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        this.mRecyclerView = indexFastScrollRecyclerView;
        setAdapter(indexFastScrollRecyclerView.getAdapter());
        float f = this.setIndexbarWidth;
        float f2 = this.mDensity;
        this.mIndexbarWidth = f * f2;
        this.mIndexbarMargin = this.setIndexbarMargin * f2;
        this.mPreviewPadding = ((float) this.setPreviewPadding) * f2;
    }

    public void draw(Canvas canvas) {
        int i;
        if (this.setIndexBarVisibility.booleanValue()) {
            Paint paint = new Paint();
            paint.setColor(this.indexbarBackgroudColor);
            paint.setAlpha(this.indexbarBackgroudAlpha);
            paint.setAntiAlias(true);
            RectF rectF = this.mIndexbarRect;
            int i2 = this.setIndexBarCornerRadius;
            float f = this.mDensity;
            canvas.drawRoundRect(rectF, ((float) i2) * f, ((float) i2) * f, paint);
            String[] strArr = this.mSections;
            if (strArr != null && strArr.length > 0) {
                if (this.previewVisibility && (i = this.mCurrentSection) >= 0 && strArr[i] != "") {
                    Paint paint2 = new Paint();
                    paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
                    paint2.setAlpha(96);
                    paint2.setAntiAlias(true);
                    paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                    Paint paint3 = new Paint();
                    paint3.setColor(-1);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(this.mScaledDensity * 50.0f);
                    paint3.setTypeface(this.setTypeface);
                    float measureText = paint3.measureText(this.mSections[this.mCurrentSection]);
                    float descent = ((this.mPreviewPadding * 2.0f) + paint3.descent()) - paint3.ascent();
                    int i3 = this.mListViewWidth;
                    int i4 = this.mListViewHeight;
                    RectF rectF2 = new RectF((((float) i3) - descent) / 2.0f, (((float) i4) - descent) / 2.0f, ((((float) i3) - descent) / 2.0f) + descent, ((((float) i4) - descent) / 2.0f) + descent);
                    float f2 = this.mDensity;
                    canvas.drawRoundRect(rectF2, f2 * 5.0f, f2 * 5.0f, paint2);
                    canvas.drawText(this.mSections[this.mCurrentSection], (rectF2.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF2.top + this.mPreviewPadding) - paint3.ascent()) + 1.0f, paint3);
                    fade(300);
                }
                Paint paint4 = new Paint();
                paint4.setColor(this.indexbarTextColor);
                paint4.setAntiAlias(true);
                paint4.setTextSize(((float) this.setIndexTextSize) * this.mScaledDensity);
                paint4.setTypeface(this.setTypeface);
                float height = (this.mIndexbarRect.height() - (this.mIndexbarMargin * 2.0f)) / ((float) this.mSections.length);
                float descent2 = (height - (paint4.descent() - paint4.ascent())) / 2.0f;
                for (int i5 = 0; i5 < this.mSections.length; i5++) {
                    if (this.setSetIndexBarHighLateTextVisibility.booleanValue()) {
                        int i6 = this.mCurrentSection;
                        if (i6 <= -1 || i5 != i6) {
                            paint4.setTypeface(this.setTypeface);
                            paint4.setTextSize(((float) this.setIndexTextSize) * this.mScaledDensity);
                            paint4.setColor(this.indexbarTextColor);
                        } else {
                            paint4.setTypeface(Typeface.create(this.setTypeface, 1));
                            paint4.setTextSize(((float) (this.setIndexTextSize + 3)) * this.mScaledDensity);
                            paint4.setColor(this.indexbarHighLateTextColor);
                        }
                        canvas.drawText(this.mSections[i5], this.mIndexbarRect.left + ((this.mIndexbarWidth - paint4.measureText(this.mSections[i5])) / 2.0f), (((this.mIndexbarRect.top + this.mIndexbarMargin) + (((float) i5) * height)) + descent2) - paint4.ascent(), paint4);
                    } else {
                        canvas.drawText(this.mSections[i5], this.mIndexbarRect.left + ((this.mIndexbarWidth - paint4.measureText(this.mSections[i5])) / 2.0f), (((this.mIndexbarRect.top + this.mIndexbarMargin) + (((float) i5) * height)) + descent2) - paint4.ascent(), paint4);
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.mIsIndexing) {
                    if (contains(motionEvent.getX(), motionEvent.getY())) {
                        this.mCurrentSection = getSectionByPoint(motionEvent.getY());
                        scrollToPosition();
                    }
                    return true;
                }
            } else if (this.mIsIndexing) {
                this.mIsIndexing = false;
                this.mCurrentSection = -1;
            }
        } else if (contains(motionEvent.getX(), motionEvent.getY())) {
            this.mIsIndexing = true;
            this.mCurrentSection = getSectionByPoint(motionEvent.getY());
            scrollToPosition();
            return true;
        }
        return false;
    }

    private void scrollToPosition() {
        try {
            int positionForSection = this.mIndexer.getPositionForSection(this.mCurrentSection);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(positionForSection, 0);
            } else {
                layoutManager.scrollToPosition(positionForSection);
            }
        } catch (Exception unused) {
            Log.d("INDEX_BAR", "Data size returns null");
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mListViewWidth = i;
        this.mListViewHeight = i2;
        float f = (float) i;
        float f2 = this.mIndexbarMargin;
        this.mIndexbarRect = new RectF((f - f2) - this.mIndexbarWidth, f2, f - f2, ((float) i2) - f2);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            adapter.registerAdapterDataObserver(this);
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.mIndexer = sectionIndexer;
            this.mSections = (String[]) sectionIndexer.getSections();
        }
    }

    public void onChanged() {
        super.onChanged();
        this.mSections = (String[]) this.mIndexer.getSections();
    }

    public boolean contains(float f, float f2) {
        return f >= this.mIndexbarRect.left && f2 >= this.mIndexbarRect.top && f2 <= this.mIndexbarRect.top + this.mIndexbarRect.height();
    }

    private int getSectionByPoint(float f) {
        String[] strArr = this.mSections;
        if (strArr == null || strArr.length == 0 || f < this.mIndexbarRect.top + this.mIndexbarMargin) {
            return 0;
        }
        if (f >= (this.mIndexbarRect.top + this.mIndexbarRect.height()) - this.mIndexbarMargin) {
            return this.mSections.length - 1;
        }
        return (int) (((f - this.mIndexbarRect.top) - this.mIndexbarMargin) / ((this.mIndexbarRect.height() - (this.mIndexbarMargin * 2.0f)) / ((float) this.mSections.length)));
    }

    private void fade(long j) {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageAtTime(1, SystemClock.uptimeMillis() + j);
    }

    public void setIndexTextSize(int i) {
        this.setIndexTextSize = i;
    }

    public void setIndexbarWidth(float f) {
        this.mIndexbarWidth = f;
    }

    public void setIndexbarMargin(float f) {
        this.mIndexbarMargin = f;
    }

    public void setPreviewPadding(int i) {
        this.setPreviewPadding = i;
    }

    public void setIndexBarCornerRadius(int i) {
        this.setIndexBarCornerRadius = i;
    }

    public void setIndexBarTransparentValue(float f) {
        this.indexbarBackgroudAlpha = convertTransparentValueToBackgroundAlpha(f);
    }

    public void setTypeface(Typeface typeface) {
        this.setTypeface = typeface;
    }

    public void setIndexBarVisibility(boolean z) {
        this.setIndexBarVisibility = Boolean.valueOf(z);
    }

    public void setPreviewVisibility(boolean z) {
        this.previewVisibility = z;
    }

    public void setIndexBarColor(int i) {
        this.indexbarBackgroudColor = i;
    }

    public void setIndexBarTextColor(int i) {
        this.indexbarTextColor = i;
    }

    public void setIndexBarHighLateTextColor(int i) {
        this.indexbarHighLateTextColor = i;
    }

    public void setIndexBarHighLateTextVisibility(boolean z) {
        this.setSetIndexBarHighLateTextVisibility = Boolean.valueOf(z);
    }
}
