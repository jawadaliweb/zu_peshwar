package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import me.relex.circleindicator.BaseCircleIndicator;

public class CircleIndicator3 extends BaseCircleIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver = new RecyclerView.AdapterDataObserver() {
        public void onChanged() {
            super.onChanged();
            if (CircleIndicator3.this.mViewpager != null) {
                RecyclerView.Adapter adapter = CircleIndicator3.this.mViewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount != CircleIndicator3.this.getChildCount()) {
                    if (CircleIndicator3.this.mLastPosition < itemCount) {
                        CircleIndicator3 circleIndicator3 = CircleIndicator3.this;
                        circleIndicator3.mLastPosition = circleIndicator3.mViewpager.getCurrentItem();
                    } else {
                        CircleIndicator3.this.mLastPosition = -1;
                    }
                    CircleIndicator3.this.createIndicators();
                }
            }
        }

        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            onChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            onChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            onChanged();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            onChanged();
        }
    };
    private final ViewPager2.OnPageChangeCallback mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        public void onPageSelected(int i) {
            if (i != CircleIndicator3.this.mLastPosition && CircleIndicator3.this.mViewpager.getAdapter() != null && CircleIndicator3.this.mViewpager.getAdapter().getItemCount() > 0) {
                CircleIndicator3.this.animatePageSelected(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public ViewPager2 mViewpager;

    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
    }

    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i) {
        super.changeIndicatorResource(i);
    }

    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i, int i2) {
        super.changeIndicatorResource(i, i2);
    }

    public /* bridge */ /* synthetic */ void createIndicators(int i, int i2) {
        super.createIndicators(i, i2);
    }

    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(BaseCircleIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public /* bridge */ /* synthetic */ void tintIndicator(int i) {
        super.tintIndicator(i);
    }

    public /* bridge */ /* synthetic */ void tintIndicator(int i, int i2) {
        super.tintIndicator(i, i2);
    }

    public CircleIndicator3(Context context) {
        super(context);
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setViewPager(ViewPager2 viewPager2) {
        this.mViewpager = viewPager2;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.mViewpager.unregisterOnPageChangeCallback(this.mInternalPageChangeCallback);
            this.mViewpager.registerOnPageChangeCallback(this.mInternalPageChangeCallback);
            this.mInternalPageChangeCallback.onPageSelected(this.mViewpager.getCurrentItem());
        }
    }

    /* access modifiers changed from: private */
    public void createIndicators() {
        int i;
        RecyclerView.Adapter adapter = this.mViewpager.getAdapter();
        if (adapter == null) {
            i = 0;
        } else {
            i = adapter.getItemCount();
        }
        createIndicators(i, this.mViewpager.getCurrentItem());
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }
}
