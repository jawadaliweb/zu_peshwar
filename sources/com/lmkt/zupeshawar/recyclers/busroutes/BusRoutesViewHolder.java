package com.lmkt.zupeshawar.recyclers.busroutes;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/BusRoutesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "multiViewRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getMultiViewRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BusRoutesViewHolder.kt */
public final class BusRoutesViewHolder extends RecyclerView.ViewHolder {
    private final RecyclerView multiViewRecycler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusRoutesViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.multiViewRecycler);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.multiViewRecycler = (RecyclerView) findViewById;
    }

    public final RecyclerView getMultiViewRecycler() {
        return this.multiViewRecycler;
    }
}
