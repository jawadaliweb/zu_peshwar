package com.lmkt.zupeshawar.recyclers.busroutes;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel;
import com.lmkt.zupeshawar.model.routeModels.RoutesHeaderAppModel;
import com.lmkt.zupeshawar.model.routeModels.RoutesItemModel;
import com.lmkt.zupeshawar.model.routeModels.Stops;
import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/SectionRoutesAdapter;", "Lio/github/luizgrp/sectionedrecyclerviewadapter/Section;", "headerAppModel", "Lcom/lmkt/zupeshawar/model/routeModels/RoutesHeaderAppModel;", "list", "", "Lcom/lmkt/zupeshawar/model/routeModels/GetRoutesMainModel;", "context", "Landroid/content/Context;", "(Lcom/lmkt/zupeshawar/model/routeModels/RoutesHeaderAppModel;Ljava/util/List;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getHeaderAppModel", "()Lcom/lmkt/zupeshawar/model/routeModels/RoutesHeaderAppModel;", "setHeaderAppModel", "(Lcom/lmkt/zupeshawar/model/routeModels/RoutesHeaderAppModel;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getContentItemsTotal", "", "getHeaderViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "getItemViewHolder", "onBindHeaderViewHolder", "", "holder", "onBindItemViewHolder", "position", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SectionRoutesAdapter.kt */
public final class SectionRoutesAdapter extends Section {
    private final Context context;
    private RoutesHeaderAppModel headerAppModel;
    private List<GetRoutesMainModel> list;

    public final RoutesHeaderAppModel getHeaderAppModel() {
        return this.headerAppModel;
    }

    public final void setHeaderAppModel(RoutesHeaderAppModel routesHeaderAppModel) {
        Intrinsics.checkNotNullParameter(routesHeaderAppModel, "<set-?>");
        this.headerAppModel = routesHeaderAppModel;
    }

    public final List<GetRoutesMainModel> getList() {
        return this.list;
    }

    public final void setList(List<GetRoutesMainModel> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.list = list2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionRoutesAdapter(RoutesHeaderAppModel routesHeaderAppModel, List<GetRoutesMainModel> list2, Context context2) {
        super(SectionParameters.builder().headerResourceId(R.layout.routes_header_item_layout).itemResourceId(R.layout.section_routes_recycler_item_layout).build());
        Intrinsics.checkNotNullParameter(routesHeaderAppModel, "headerAppModel");
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.headerAppModel = routesHeaderAppModel;
        this.list = list2;
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public int getContentItemsTotal() {
        return this.list.size();
    }

    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        Intrinsics.checkNotNull(view);
        return new BusRoutesViewHolder(view);
    }

    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        if (viewHolder2 instanceof BusRoutesViewHolder) {
            GetRoutesMainModel getRoutesMainModel = this.list.get(i);
            ArrayList arrayList = new ArrayList();
            if (getRoutesMainModel.getStops().size() > 1) {
                int i2 = 0;
                for (List next : getRoutesMainModel.getStops()) {
                    int i3 = i2 + 1;
                    if (next.size() > 0) {
                        if (i2 == 0) {
                            arrayList.add(new RoutesItemModel(1, next, "10", ((Stops) next.get(0)).getStopName(), ((Stops) CollectionsKt.last(next)).getStopName()));
                        } else {
                            arrayList.add(new RoutesItemModel(2, next, "10", ((Stops) next.get(0)).getStopName(), ((Stops) CollectionsKt.last(next)).getStopName()));
                        }
                    }
                    i2 = i3;
                }
            } else {
                arrayList.add(new RoutesItemModel(1, getRoutesMainModel.getStops().get(0), "10", ((Stops) getRoutesMainModel.getStops().get(0).get(0)).getStopName(), ((Stops) ((List) CollectionsKt.last(getRoutesMainModel.getStops())).get(getRoutesMainModel.getStops().get(0).size() - 1)).getStopName()));
            }
            ((BusRoutesViewHolder) viewHolder2).getMultiViewRecycler().setAdapter(new RouteMultiViewRecyclerAdapter(arrayList, getRoutesMainModel.getRoute(), this.context));
        }
    }

    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        Intrinsics.checkNotNull(view);
        return new RoutesHeaderViewHolder(view);
    }

    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof RoutesHeaderViewHolder) {
            RoutesHeaderViewHolder routesHeaderViewHolder = (RoutesHeaderViewHolder) viewHolder;
            routesHeaderViewHolder.getOriginStationValueTv().setText(this.headerAppModel.getOriginStationName());
            routesHeaderViewHolder.getDestinationStationValueTv().setText(this.headerAppModel.getDestinationStationName());
            routesHeaderViewHolder.getRoutesChangestimeValueTv().setText(this.headerAppModel.getEsmtTime());
            routesHeaderViewHolder.getEsmtFareValueTv().setText(this.headerAppModel.getEsmtFare());
            routesHeaderViewHolder.getRouteChange().setText(this.headerAppModel.getTotalRoutes());
        }
    }
}
