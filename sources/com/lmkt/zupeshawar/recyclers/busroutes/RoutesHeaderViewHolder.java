package com.lmkt.zupeshawar.recyclers.busroutes;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/RoutesHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "destinationStationValueTv", "Landroid/widget/TextView;", "getDestinationStationValueTv", "()Landroid/widget/TextView;", "esmtFareValueTv", "getEsmtFareValueTv", "originStationValueTv", "getOriginStationValueTv", "routeChange", "getRouteChange", "routesChangestimeValueTv", "getRoutesChangestimeValueTv", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoutesHeaderViewHolder.kt */
public final class RoutesHeaderViewHolder extends RecyclerView.ViewHolder {
    private final TextView destinationStationValueTv;
    private final TextView esmtFareValueTv;
    private final TextView originStationValueTv;
    private final TextView routeChange;
    private final TextView routesChangestimeValueTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoutesHeaderViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.originStationValueTv);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.originStationValueTv = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.destinationStationValueTv);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.destinationStationValueTv = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.routeChange);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.routeChange = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.routesChangestimeValueTv);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.routesChangestimeValueTv = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.esmtFareValueTv);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.esmtFareValueTv = (TextView) findViewById5;
    }

    public final TextView getOriginStationValueTv() {
        return this.originStationValueTv;
    }

    public final TextView getDestinationStationValueTv() {
        return this.destinationStationValueTv;
    }

    public final TextView getRouteChange() {
        return this.routeChange;
    }

    public final TextView getRoutesChangestimeValueTv() {
        return this.routesChangestimeValueTv;
    }

    public final TextView getEsmtFareValueTv() {
        return this.esmtFareValueTv;
    }
}
