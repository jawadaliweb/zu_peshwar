package com.lmkt.zupeshawar.recyclers.busroutes;

import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.recyclers.busroutes.BusStopsRecyclerAdapter;
import com.lmkt.zupeshawar.recyclers.busroutes.RouteMultiViewRecyclerAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/lmkt/zupeshawar/recyclers/busroutes/RouteMultiViewRecyclerAdapter$onBindViewHolder$1", "Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;", "hideView", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RouteMultiViewRecyclerAdapter.kt */
public final class RouteMultiViewRecyclerAdapter$onBindViewHolder$1 implements BusStopsRecyclerAdapter.HideView {
    final /* synthetic */ RecyclerView.ViewHolder $holder;

    RouteMultiViewRecyclerAdapter$onBindViewHolder$1(RecyclerView.ViewHolder viewHolder) {
        this.$holder = viewHolder;
    }

    public void hideView() {
        ((RouteMultiViewRecyclerAdapter.HeaderViewHolder) this.$holder).getShowAllRoutesDetailsRecycler().setVisibility(8);
        ((RouteMultiViewRecyclerAdapter.HeaderViewHolder) this.$holder).getContentLayout().setVisibility(0);
    }
}
