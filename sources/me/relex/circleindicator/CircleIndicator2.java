package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import me.relex.circleindicator.BaseCircleIndicator;

public class CircleIndicator2 extends BaseCircleIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver = new RecyclerView.AdapterDataObserver() {
        public void onChanged() {
            super.onChanged();
            if (CircleIndicator2.this.mRecyclerView != null) {
                RecyclerView.Adapter adapter = CircleIndicator2.this.mRecyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount != CircleIndicator2.this.getChildCount()) {
                    if (CircleIndicator2.this.mLastPosition < itemCount) {
                        CircleIndicator2 circleIndicator2 = CircleIndicator2.this;
                        circleIndicator2.mLastPosition = circleIndicator2.getSnapPosition(circleIndicator2.mRecyclerView.getLayoutManager());
                    } else {
                        CircleIndicator2.this.mLastPosition = -1;
                    }
                    CircleIndicator2.this.createIndicators();
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
    private final RecyclerView.OnScrollListener mInternalOnScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            int snapPosition = CircleIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
            if (snapPosition != -1) {
                CircleIndicator2.this.animatePageSelected(snapPosition);
            }
        }
    };
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private SnapHelper mSnapHelper;

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

    public CircleIndicator2(Context context) {
        super(context);
    }

    public CircleIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleIndicator2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CircleIndicator2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void attachToRecyclerView(RecyclerView recyclerView, SnapHelper snapHelper) {
        this.mRecyclerView = recyclerView;
        this.mSnapHelper = snapHelper;
        this.mLastPosition = -1;
        createIndicators();
        recyclerView.removeOnScrollListener(this.mInternalOnScrollListener);
        recyclerView.addOnScrollListener(this.mInternalOnScrollListener);
    }

    /* access modifiers changed from: private */
    public void createIndicators() {
        int i;
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null) {
            i = 0;
        } else {
            i = adapter.getItemCount();
        }
        createIndicators(i, getSnapPosition(this.mRecyclerView.getLayoutManager()));
    }

    public int getSnapPosition(RecyclerView.LayoutManager layoutManager) {
        View findSnapView;
        if (layoutManager == null || (findSnapView = this.mSnapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(findSnapView);
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }
}
