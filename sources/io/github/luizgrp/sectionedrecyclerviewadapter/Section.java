package io.github.luizgrp.sectionedrecyclerviewadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class Section {
    private final Integer emptyResourceId;
    private final boolean emptyViewWillBeProvided;
    private final Integer failedResourceId;
    private final boolean failedViewWillBeProvided;
    private final Integer footerResourceId;
    private final boolean footerViewWillBeProvided;
    private boolean hasFooter;
    private boolean hasHeader;
    private final Integer headerResourceId;
    private final boolean headerViewWillBeProvided;
    private final Integer itemResourceId;
    private final boolean itemViewWillBeProvided;
    private final Integer loadingResourceId;
    private final boolean loadingViewWillBeProvided;
    private State state = State.LOADED;
    private boolean visible;

    public enum State {
        LOADING,
        LOADED,
        FAILED,
        EMPTY
    }

    public abstract int getContentItemsTotal();

    public abstract RecyclerView.ViewHolder getItemViewHolder(View view);

    public void onBindEmptyViewHolder(RecyclerView.ViewHolder viewHolder) {
    }

    public void onBindFailedViewHolder(RecyclerView.ViewHolder viewHolder) {
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder viewHolder) {
    }

    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder) {
    }

    public abstract void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    public void onBindLoadingViewHolder(RecyclerView.ViewHolder viewHolder) {
    }

    public Section(SectionParameters sectionParameters) {
        boolean z = true;
        this.visible = true;
        this.itemResourceId = sectionParameters.itemResourceId;
        Integer num = sectionParameters.headerResourceId;
        this.headerResourceId = num;
        Integer num2 = sectionParameters.footerResourceId;
        this.footerResourceId = num2;
        this.loadingResourceId = sectionParameters.loadingResourceId;
        this.failedResourceId = sectionParameters.failedResourceId;
        this.emptyResourceId = sectionParameters.emptyResourceId;
        this.itemViewWillBeProvided = sectionParameters.itemViewWillBeProvided;
        boolean z2 = sectionParameters.headerViewWillBeProvided;
        this.headerViewWillBeProvided = z2;
        boolean z3 = sectionParameters.footerViewWillBeProvided;
        this.footerViewWillBeProvided = z3;
        this.loadingViewWillBeProvided = sectionParameters.loadingViewWillBeProvided;
        this.failedViewWillBeProvided = sectionParameters.failedViewWillBeProvided;
        this.emptyViewWillBeProvided = sectionParameters.emptyViewWillBeProvided;
        this.hasHeader = num != null || z2;
        if (num2 == null && !z3) {
            z = false;
        }
        this.hasFooter = z;
    }

    /* renamed from: io.github.luizgrp.sectionedrecyclerviewadapter.Section$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State[] r0 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State = r0
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.LOADED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.github.luizgrp.sectionedrecyclerviewadapter.Section.AnonymousClass1.<clinit>():void");
        }
    }

    public final void setState(State state2) {
        int i = AnonymousClass1.$SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State[state2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && this.emptyResourceId == null && !this.emptyViewWillBeProvided) {
                    throw new IllegalStateException("Resource id for 'empty state' should be provided or 'emptyViewWillBeProvided' should be set");
                }
            } else if (this.failedResourceId == null && !this.failedViewWillBeProvided) {
                throw new IllegalStateException("Resource id for 'failed state' should be provided or 'failedViewWillBeProvided' should be set");
            }
        } else if (this.loadingResourceId == null && !this.loadingViewWillBeProvided) {
            throw new IllegalStateException("Resource id for 'loading state' should be provided or 'loadingViewWillBeProvided' should be set");
        }
        this.state = state2;
    }

    public final State getState() {
        return this.state;
    }

    public final boolean isVisible() {
        return this.visible;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }

    public final boolean hasHeader() {
        return this.hasHeader;
    }

    public final void setHasHeader(boolean z) {
        this.hasHeader = z;
    }

    public final boolean hasFooter() {
        return this.hasFooter;
    }

    public final void setHasFooter(boolean z) {
        this.hasFooter = z;
    }

    public final boolean isItemViewWillBeProvided() {
        return this.itemViewWillBeProvided;
    }

    public final Integer getItemResourceId() {
        return this.itemResourceId;
    }

    public final boolean isHeaderViewWillBeProvided() {
        return this.headerViewWillBeProvided;
    }

    public final Integer getHeaderResourceId() {
        return this.headerResourceId;
    }

    public final boolean isFooterViewWillBeProvided() {
        return this.footerViewWillBeProvided;
    }

    public final Integer getFooterResourceId() {
        return this.footerResourceId;
    }

    public final boolean isLoadingViewWillBeProvided() {
        return this.loadingViewWillBeProvided;
    }

    public final Integer getLoadingResourceId() {
        return this.loadingResourceId;
    }

    public final boolean isFailedViewWillBeProvided() {
        return this.failedViewWillBeProvided;
    }

    public final Integer getFailedResourceId() {
        return this.failedResourceId;
    }

    public final boolean isEmptyViewWillBeProvided() {
        return this.emptyViewWillBeProvided;
    }

    public final Integer getEmptyResourceId() {
        return this.emptyResourceId;
    }

    public final int getSectionItemsTotal() {
        int i = AnonymousClass1.$SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State[this.state.ordinal()];
        int i2 = 1;
        if (!(i == 1 || i == 2 || i == 3)) {
            if (i == 4) {
                i2 = getContentItemsTotal();
            } else {
                throw new IllegalStateException("Invalid state");
            }
        }
        return i2 + (this.hasHeader ? 1 : 0) + (this.hasFooter ? 1 : 0);
    }

    public View getItemView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getItemView() if you set itemViewWillBeProvided");
    }

    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        onBindItemViewHolder(viewHolder, i);
    }

    public View getHeaderView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getHeaderView() if you set headerViewWillBeProvided");
    }

    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        throw new UnsupportedOperationException("You need to implement getHeaderViewHolder() if you set headerResourceId");
    }

    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        onBindHeaderViewHolder(viewHolder);
    }

    public View getFooterView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getFooterView() if you set footerViewWillBeProvided");
    }

    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
        throw new UnsupportedOperationException("You need to implement getFooterViewHolder() if you set footerResourceId");
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        onBindFooterViewHolder(viewHolder);
    }

    public View getLoadingView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getLoadingView() if you set loadingViewWillBeProvided");
    }

    public RecyclerView.ViewHolder getLoadingViewHolder(View view) {
        throw new UnsupportedOperationException("You need to implement getLoadingViewHolder() if you set loadingResourceId");
    }

    public void onBindLoadingViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        onBindLoadingViewHolder(viewHolder);
    }

    public View getFailedView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getFailedView() if you set failedViewWillBeProvided");
    }

    public RecyclerView.ViewHolder getFailedViewHolder(View view) {
        throw new UnsupportedOperationException("You need to implement getFailedViewHolder() if you set failedResourceId");
    }

    public void onBindFailedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        onBindFailedViewHolder(viewHolder);
    }

    public View getEmptyView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getEmptyView() if you set emptyViewWillBeProvided");
    }

    public RecyclerView.ViewHolder getEmptyViewHolder(View view) {
        throw new UnsupportedOperationException("You need to implement getEmptyViewHolder() if you set emptyResourceId");
    }

    public void onBindEmptyViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        onBindEmptyViewHolder(viewHolder);
    }
}
