package com.lmkt.zupeshawar.recyclers.busroutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.routeModels.Stops;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$BusStopsViewHolder;", "list", "", "Lcom/lmkt/zupeshawar/model/routeModels/Stops;", "route", "", "hideView", "Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;", "context", "Landroid/content/Context;", "(Ljava/util/List;Ljava/lang/String;Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;Landroid/content/Context;)V", "_context", "get_context", "()Landroid/content/Context;", "getContext", "getHideView", "()Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;", "setHideView", "(Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getRoute", "()Ljava/lang/String;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BusStopsViewHolder", "HideView", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BusStopsRecyclerAdapter.kt */
public final class BusStopsRecyclerAdapter extends RecyclerView.Adapter<BusStopsViewHolder> {
    private final Context _context;
    private final Context context;
    private HideView hideView;
    private List<Stops> list;
    private final String route;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$HideView;", "", "hideView", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BusStopsRecyclerAdapter.kt */
    public interface HideView {
        void hideView();
    }

    public final List<Stops> getList() {
        return this.list;
    }

    public final void setList(List<Stops> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.list = list2;
    }

    public final HideView getHideView() {
        return this.hideView;
    }

    public final void setHideView(HideView hideView2) {
        Intrinsics.checkNotNullParameter(hideView2, "<set-?>");
        this.hideView = hideView2;
    }

    public final Context getContext() {
        return this.context;
    }

    public BusStopsRecyclerAdapter(List<Stops> list2, String str, HideView hideView2, Context context2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(hideView2, "hideView");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.list = list2;
        this.hideView = hideView2;
        this.context = context2;
        this.route = str;
        this._context = context2;
    }

    public final String getRoute() {
        return this.route;
    }

    public final Context get_context() {
        return this._context;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/BusStopsRecyclerAdapter$BusStopsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "busImage", "Landroid/widget/ImageView;", "getBusImage", "()Landroid/widget/ImageView;", "originCentersTv", "Landroid/widget/TextView;", "getOriginCentersTv", "()Landroid/widget/TextView;", "originStationValueTv", "getOriginStationValueTv", "stopsImg", "getStopsImg", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BusStopsRecyclerAdapter.kt */
    public static final class BusStopsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView busImage;
        private final TextView originCentersTv;
        private final TextView originStationValueTv;
        private final ImageView stopsImg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BusStopsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.originStationValueTv);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.originStationValueTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.originCentersTv);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.originCentersTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.busImage);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            this.busImage = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.stopsImg);
            Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.stopsImg = (ImageView) findViewById4;
        }

        public final TextView getOriginStationValueTv() {
            return this.originStationValueTv;
        }

        public final TextView getOriginCentersTv() {
            return this.originCentersTv;
        }

        public final ImageView getBusImage() {
            return this.busImage;
        }

        public final ImageView getStopsImg() {
            return this.stopsImg;
        }
    }

    public BusStopsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.busstops_item_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new BusStopsViewHolder(inflate);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.lmkt.zupeshawar.recyclers.busroutes.BusStopsRecyclerAdapter.BusStopsViewHolder r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.TextView r0 = r6.getOriginStationValueTv()
            java.util.List<com.lmkt.zupeshawar.model.routeModels.Stops> r1 = r5.list
            java.lang.Object r1 = r1.get(r7)
            com.lmkt.zupeshawar.model.routeModels.Stops r1 = (com.lmkt.zupeshawar.model.routeModels.Stops) r1
            java.lang.String r1 = r1.getStopName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.util.List<com.lmkt.zupeshawar.model.routeModels.Stops> r0 = r5.list
            int r0 = r0.size()
            int r0 = r0 + -1
            if (r7 >= r0) goto L_0x0050
            android.widget.TextView r0 = r6.getOriginCentersTv()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 40
            r1.append(r2)
            java.util.List<com.lmkt.zupeshawar.model.routeModels.Stops> r2 = r5.list
            java.lang.Object r7 = r2.get(r7)
            com.lmkt.zupeshawar.model.routeModels.Stops r7 = (com.lmkt.zupeshawar.model.routeModels.Stops) r7
            int r7 = r7.getTimeToNext()
            r1.append(r7)
            java.lang.String r7 = " min)"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            goto L_0x005b
        L_0x0050:
            android.widget.TextView r7 = r6.getOriginCentersTv()
            java.lang.String r0 = ""
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
        L_0x005b:
            android.content.Context r7 = r5.context
            r0 = 2131230845(0x7f08007d, float:1.8077754E38)
            android.graphics.drawable.Drawable r7 = androidx.core.content.ContextCompat.getDrawable(r7, r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r0)
            android.graphics.drawable.LayerDrawable r7 = (android.graphics.drawable.LayerDrawable) r7
            r0 = 2131362077(0x7f0a011d, float:1.8343924E38)
            android.graphics.drawable.Drawable r0 = r7.findDrawableByLayerId(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            java.lang.String r1 = r5.route
            int r2 = r1.hashCode()
            r3 = 49
            r4 = 2131230900(0x7f0800b4, float:1.8077866E38)
            if (r2 == r3) goto L_0x0312
            r3 = 50
            if (r2 == r3) goto L_0x02db
            r3 = 1567(0x61f, float:2.196E-42)
            if (r2 == r3) goto L_0x02a4
            r3 = 1646(0x66e, float:2.307E-42)
            if (r2 == r3) goto L_0x026b
            r3 = 1647(0x66f, float:2.308E-42)
            if (r2 == r3) goto L_0x0232
            r3 = 1677(0x68d, float:2.35E-42)
            if (r2 == r3) goto L_0x01f9
            r3 = 1678(0x68e, float:2.351E-42)
            if (r2 == r3) goto L_0x01c0
            switch(r2) {
                case 53: goto L_0x0187;
                case 54: goto L_0x014e;
                case 55: goto L_0x0115;
                case 56: goto L_0x00dc;
                case 57: goto L_0x00a3;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            goto L_0x031a
        L_0x00a3:
            java.lang.String r2 = "9"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ad
            goto L_0x031a
        L_0x00ad:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099723(0x7f06004b, float:1.7811807E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x00dc:
            java.lang.String r2 = "8"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00e6
            goto L_0x031a
        L_0x00e6:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099722(0x7f06004a, float:1.7811805E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x0115:
            java.lang.String r2 = "7"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x011f
            goto L_0x031a
        L_0x011f:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099721(0x7f060049, float:1.7811803E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x014e:
            java.lang.String r2 = "6"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0158
            goto L_0x031a
        L_0x0158:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099720(0x7f060048, float:1.7811801E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x0187:
            java.lang.String r2 = "5"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0191
            goto L_0x031a
        L_0x0191:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099719(0x7f060047, float:1.78118E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x01c0:
            java.lang.String r2 = "4B"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01ca
            goto L_0x031a
        L_0x01ca:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099718(0x7f060046, float:1.7811797E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x01f9:
            java.lang.String r2 = "4A"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0203
            goto L_0x031a
        L_0x0203:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099717(0x7f060045, float:1.7811795E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x0232:
            java.lang.String r2 = "3B"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x023c
            goto L_0x031a
        L_0x023c:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099716(0x7f060044, float:1.7811793E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x026b:
            java.lang.String r2 = "3A"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0275
            goto L_0x031a
        L_0x0275:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099715(0x7f060043, float:1.7811791E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x02a4:
            java.lang.String r2 = "10"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02ad
            goto L_0x031a
        L_0x02ad:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099724(0x7f06004c, float:1.781181E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x02db:
            java.lang.String r2 = "2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02e4
            goto L_0x031a
        L_0x02e4:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099714(0x7f060042, float:1.781179E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
            goto L_0x034f
        L_0x0312:
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0322
        L_0x031a:
            java.io.PrintStream r7 = java.lang.System.out
            java.lang.String r0 = "x is neither 1 nor 2"
            r7.print(r0)
            goto L_0x034f
        L_0x0322:
            android.widget.ImageView r1 = r6.getBusImage()
            r1.setImageResource(r4)
            android.widget.ImageView r1 = r6.getBusImage()
            android.content.Context r2 = r5.context
            r3 = 2131099713(0x7f060041, float:1.7811787E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setColorFilter(r2)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            int r1 = r1.getColor(r3)
            r0.setColor(r1)
            android.widget.ImageView r0 = r6.getStopsImg()
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r0.setImageDrawable(r7)
        L_0x034f:
            android.view.View r6 = r6.itemView
            com.lmkt.zupeshawar.recyclers.busroutes.-$$Lambda$BusStopsRecyclerAdapter$LEzc4b2I_bTWzd5Ky7uBR_gq0fY r7 = new com.lmkt.zupeshawar.recyclers.busroutes.-$$Lambda$BusStopsRecyclerAdapter$LEzc4b2I_bTWzd5Ky7uBR_gq0fY
            r7.<init>()
            r6.setOnClickListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.recyclers.busroutes.BusStopsRecyclerAdapter.onBindViewHolder(com.lmkt.zupeshawar.recyclers.busroutes.BusStopsRecyclerAdapter$BusStopsViewHolder, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m27onBindViewHolder$lambda0(BusStopsRecyclerAdapter busStopsRecyclerAdapter, View view) {
        Intrinsics.checkNotNullParameter(busStopsRecyclerAdapter, "this$0");
        busStopsRecyclerAdapter.hideView.hideView();
    }

    public int getItemCount() {
        return this.list.size();
    }
}
