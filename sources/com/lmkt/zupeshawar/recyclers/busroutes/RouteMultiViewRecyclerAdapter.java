package com.lmkt.zupeshawar.recyclers.busroutes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.routeModels.RoutesItemModel;
import com.lmkt.zupeshawar.model.routeModels.Stops;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006 "}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/RouteMultiViewRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "list", "", "Lcom/lmkt/zupeshawar/model/routeModels/RoutesItemModel;", "routes", "", "context", "Landroid/content/Context;", "(Ljava/util/List;Ljava/util/List;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getRoutes", "setRoutes", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HeaderViewHolder", "RoutesHolder", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RouteMultiViewRecyclerAdapter.kt */
public final class RouteMultiViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private List<RoutesItemModel> list;
    private List<String> routes;

    public final List<RoutesItemModel> getList() {
        return this.list;
    }

    public final void setList(List<RoutesItemModel> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.list = list2;
    }

    public final List<String> getRoutes() {
        return this.routes;
    }

    public final void setRoutes(List<String> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.routes = list2;
    }

    public RouteMultiViewRecyclerAdapter(List<RoutesItemModel> list2, List<String> list3, Context context2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(list3, "routes");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.list = list2;
        this.routes = list3;
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.buses_routes_item_layout, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …em_layout, parent, false)");
            return new RoutesHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.multiivew_header_item_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …em_layout, parent, false)");
        return new HeaderViewHolder(inflate2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        int i2 = i;
        Intrinsics.checkNotNullParameter(viewHolder2, "holder");
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.bus_points_bg);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.colorImg);
        Intrinsics.checkNotNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) findDrawableByLayerId;
        if (viewHolder2 instanceof HeaderViewHolder) {
            String str = this.routes.get(i2);
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode != 1572) {
                        if (hashCode != 1646) {
                            if (hashCode != 1647) {
                                if (hashCode != 1677) {
                                    if (hashCode != 1678) {
                                        switch (hashCode) {
                                            case 53:
                                                if (str.equals("5")) {
                                                    HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder2;
                                                    headerViewHolder.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    headerViewHolder.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_05));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_05));
                                                    headerViewHolder.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 54:
                                                if (str.equals("6")) {
                                                    HeaderViewHolder headerViewHolder2 = (HeaderViewHolder) viewHolder2;
                                                    headerViewHolder2.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    headerViewHolder2.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_06));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_06));
                                                    headerViewHolder2.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 55:
                                                if (str.equals("7")) {
                                                    HeaderViewHolder headerViewHolder3 = (HeaderViewHolder) viewHolder2;
                                                    headerViewHolder3.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    headerViewHolder3.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_07));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_07));
                                                    headerViewHolder3.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 56:
                                                if (str.equals("8")) {
                                                    HeaderViewHolder headerViewHolder4 = (HeaderViewHolder) viewHolder2;
                                                    headerViewHolder4.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    headerViewHolder4.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_08));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_08));
                                                    headerViewHolder4.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 57:
                                                if (str.equals("9")) {
                                                    HeaderViewHolder headerViewHolder5 = (HeaderViewHolder) viewHolder2;
                                                    headerViewHolder5.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    headerViewHolder5.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_09));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_09));
                                                    headerViewHolder5.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (hashCode) {
                                                    case 1567:
                                                        if (str.equals("10")) {
                                                            HeaderViewHolder headerViewHolder6 = (HeaderViewHolder) viewHolder2;
                                                            headerViewHolder6.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                            headerViewHolder6.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_10));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_10));
                                                            headerViewHolder6.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                    case 1568:
                                                        if (str.equals("11")) {
                                                            HeaderViewHolder headerViewHolder7 = (HeaderViewHolder) viewHolder2;
                                                            headerViewHolder7.getBusImage().setImageResource(R.drawable.ic_bus_011);
                                                            headerViewHolder7.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_11));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_11));
                                                            headerViewHolder7.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                    case 1569:
                                                        if (str.equals("12")) {
                                                            HeaderViewHolder headerViewHolder8 = (HeaderViewHolder) viewHolder2;
                                                            headerViewHolder8.getBusImage().setImageResource(R.drawable.ic_bus_12);
                                                            headerViewHolder8.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_12));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_12));
                                                            headerViewHolder8.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                }
                                        }
                                    } else if (str.equals("4B")) {
                                        HeaderViewHolder headerViewHolder9 = (HeaderViewHolder) viewHolder2;
                                        headerViewHolder9.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                        headerViewHolder9.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_04B));
                                        gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_04B));
                                        headerViewHolder9.getStopsImg().setImageDrawable(layerDrawable);
                                    }
                                } else if (str.equals("4A")) {
                                    HeaderViewHolder headerViewHolder10 = (HeaderViewHolder) viewHolder2;
                                    headerViewHolder10.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                    headerViewHolder10.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_04A));
                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_04A));
                                    headerViewHolder10.getStopsImg().setImageDrawable(layerDrawable);
                                }
                            } else if (str.equals("3B")) {
                                HeaderViewHolder headerViewHolder11 = (HeaderViewHolder) viewHolder2;
                                headerViewHolder11.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                headerViewHolder11.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_03B));
                                gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_03B));
                                headerViewHolder11.getStopsImg().setImageDrawable(layerDrawable);
                            }
                        } else if (str.equals("3A")) {
                            HeaderViewHolder headerViewHolder12 = (HeaderViewHolder) viewHolder2;
                            headerViewHolder12.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                            headerViewHolder12.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_03A));
                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_03A));
                            headerViewHolder12.getStopsImg().setImageDrawable(layerDrawable);
                        }
                    } else if (str.equals("15")) {
                        HeaderViewHolder headerViewHolder13 = (HeaderViewHolder) viewHolder2;
                        headerViewHolder13.getBusImage().setImageResource(R.drawable.ic_bus_15);
                        headerViewHolder13.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_15));
                        gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_15));
                        headerViewHolder13.getStopsImg().setImageDrawable(layerDrawable);
                    }
                } else if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    HeaderViewHolder headerViewHolder14 = (HeaderViewHolder) viewHolder2;
                    headerViewHolder14.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                    headerViewHolder14.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_02));
                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_02));
                    headerViewHolder14.getStopsImg().setImageDrawable(layerDrawable);
                }
            } else if (str.equals("1")) {
                HeaderViewHolder headerViewHolder15 = (HeaderViewHolder) viewHolder2;
                headerViewHolder15.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                headerViewHolder15.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_01));
                gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_01));
                headerViewHolder15.getStopsImg().setImageDrawable(layerDrawable);
            }
            HeaderViewHolder headerViewHolder16 = (HeaderViewHolder) viewHolder2;
            TextView multiViewHeaderTv = headerViewHolder16.getMultiViewHeaderTv();
            multiViewHeaderTv.setText("Change Routes to Direct " + this.routes.get(i2));
            int i3 = 0;
            int i4 = 0;
            for (Stops next : this.list.get(i2).getStopList()) {
                int i5 = i3 + 1;
                if (i3 != this.list.get(i2).getStopList().size() - 1) {
                    i4 += next.getTimeToNext();
                }
                i3 = i5;
            }
            if (this.list.get(i2).getStopList().size() - 2 == 0) {
                TextView originCentersTv = headerViewHolder16.getOriginCentersTv();
                originCentersTv.setText('(' + i4 + " min)");
            } else {
                TextView originCentersTv2 = headerViewHolder16.getOriginCentersTv();
                StringBuilder sb = new StringBuilder();
                sb.append(this.list.get(i2).getStopList().size() - 2);
                sb.append(" stops (");
                sb.append(i4);
                sb.append(" min)");
                originCentersTv2.setText(sb.toString());
            }
            headerViewHolder16.getOriginStationValueTv().setText(this.list.get(i2).getOriginStations());
            headerViewHolder16.getDestinationStationValueTv().setText(this.list.get(i2).getDestinationStaion());
            headerViewHolder16.getShowAllRoutesDetailsRecycler().setAdapter(new BusStopsRecyclerAdapter(this.list.get(i2).getStopList(), this.routes.get(i2), new RouteMultiViewRecyclerAdapter$onBindViewHolder$1(viewHolder2), this.context));
            headerViewHolder16.getContentLayout().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RouteMultiViewRecyclerAdapter.m28onBindViewHolder$lambda0(RecyclerView.ViewHolder.this, view);
                }
            });
        } else if (viewHolder2 instanceof RoutesHolder) {
            String str2 = this.routes.get(i2);
            int hashCode2 = str2.hashCode();
            if (hashCode2 != 49) {
                if (hashCode2 != 50) {
                    if (hashCode2 != 1572) {
                        if (hashCode2 != 1646) {
                            if (hashCode2 != 1647) {
                                if (hashCode2 != 1677) {
                                    if (hashCode2 != 1678) {
                                        switch (hashCode2) {
                                            case 53:
                                                if (str2.equals("5")) {
                                                    RoutesHolder routesHolder = (RoutesHolder) viewHolder2;
                                                    routesHolder.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    routesHolder.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_05));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_05));
                                                    routesHolder.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 54:
                                                if (str2.equals("6")) {
                                                    RoutesHolder routesHolder2 = (RoutesHolder) viewHolder2;
                                                    routesHolder2.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    routesHolder2.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_06));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_06));
                                                    routesHolder2.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 55:
                                                if (str2.equals("7")) {
                                                    RoutesHolder routesHolder3 = (RoutesHolder) viewHolder2;
                                                    routesHolder3.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    routesHolder3.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_07));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_07));
                                                    routesHolder3.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 56:
                                                if (str2.equals("8")) {
                                                    RoutesHolder routesHolder4 = (RoutesHolder) viewHolder2;
                                                    routesHolder4.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    routesHolder4.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_08));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_08));
                                                    routesHolder4.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            case 57:
                                                if (str2.equals("9")) {
                                                    RoutesHolder routesHolder5 = (RoutesHolder) viewHolder2;
                                                    routesHolder5.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                    routesHolder5.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_09));
                                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_09));
                                                    routesHolder5.getStopsImg().setImageDrawable(layerDrawable);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (hashCode2) {
                                                    case 1567:
                                                        if (str2.equals("10")) {
                                                            RoutesHolder routesHolder6 = (RoutesHolder) viewHolder2;
                                                            routesHolder6.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                                            routesHolder6.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_10));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_10));
                                                            routesHolder6.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                    case 1568:
                                                        if (str2.equals("11")) {
                                                            RoutesHolder routesHolder7 = (RoutesHolder) viewHolder2;
                                                            routesHolder7.getBusImage().setImageResource(R.drawable.ic_bus_011);
                                                            routesHolder7.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_11));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_11));
                                                            routesHolder7.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                    case 1569:
                                                        if (str2.equals("12")) {
                                                            RoutesHolder routesHolder8 = (RoutesHolder) viewHolder2;
                                                            routesHolder8.getBusImage().setImageResource(R.drawable.ic_bus_12);
                                                            routesHolder8.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_12));
                                                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_12));
                                                            routesHolder8.getStopsImg().setImageDrawable(layerDrawable);
                                                            break;
                                                        }
                                                        break;
                                                }
                                        }
                                    } else if (str2.equals("4B")) {
                                        RoutesHolder routesHolder9 = (RoutesHolder) viewHolder2;
                                        routesHolder9.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                        routesHolder9.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_04B));
                                        gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_04B));
                                        routesHolder9.getStopsImg().setImageDrawable(layerDrawable);
                                    }
                                } else if (str2.equals("4A")) {
                                    RoutesHolder routesHolder10 = (RoutesHolder) viewHolder2;
                                    routesHolder10.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                    routesHolder10.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_04A));
                                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_04A));
                                    routesHolder10.getStopsImg().setImageDrawable(layerDrawable);
                                }
                            } else if (str2.equals("3B")) {
                                RoutesHolder routesHolder11 = (RoutesHolder) viewHolder2;
                                routesHolder11.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                                routesHolder11.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_03B));
                                gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_03B));
                                routesHolder11.getStopsImg().setImageDrawable(layerDrawable);
                            }
                        } else if (str2.equals("3A")) {
                            RoutesHolder routesHolder12 = (RoutesHolder) viewHolder2;
                            routesHolder12.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                            routesHolder12.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_03A));
                            gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_03A));
                            routesHolder12.getStopsImg().setImageDrawable(layerDrawable);
                        }
                    } else if (str2.equals("15")) {
                        RoutesHolder routesHolder13 = (RoutesHolder) viewHolder2;
                        routesHolder13.getBusImage().setImageResource(R.drawable.ic_bus_15);
                        routesHolder13.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_15));
                        gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_15));
                        routesHolder13.getStopsImg().setImageDrawable(layerDrawable);
                    }
                } else if (str2.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    RoutesHolder routesHolder14 = (RoutesHolder) viewHolder2;
                    routesHolder14.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                    routesHolder14.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_02));
                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_02));
                    routesHolder14.getStopsImg().setImageDrawable(layerDrawable);
                }
            } else if (str2.equals("1")) {
                RoutesHolder routesHolder15 = (RoutesHolder) viewHolder2;
                routesHolder15.getBusImage().setImageResource(R.drawable.ic_bus_route_01);
                routesHolder15.getBusImage().setColorFilter(ContextCompat.getColor(this.context, R.color.color_Bus_Route_01));
                gradientDrawable.setColor(this.context.getResources().getColor(R.color.color_Bus_Route_01));
                routesHolder15.getStopsImg().setImageDrawable(layerDrawable);
            }
            int i6 = 0;
            int i7 = 0;
            for (Stops next2 : this.list.get(i2).getStopList()) {
                int i8 = i6 + 1;
                if (i6 != this.list.get(i2).getStopList().size() - 1) {
                    i7 += next2.getTimeToNext();
                }
                i6 = i8;
            }
            if (this.list.get(i2).getStopList().size() - 2 == 0) {
                TextView originCentersTv3 = ((RoutesHolder) viewHolder2).getOriginCentersTv();
                originCentersTv3.setText('(' + i7 + " min)");
            } else {
                TextView originCentersTv4 = ((RoutesHolder) viewHolder2).getOriginCentersTv();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.list.get(i2).getStopList().size() - 2);
                sb2.append(" stops (");
                sb2.append(i7);
                sb2.append(" min)");
                originCentersTv4.setText(sb2.toString());
            }
            RoutesHolder routesHolder16 = (RoutesHolder) viewHolder2;
            routesHolder16.getOriginStationValueTv().setText(this.list.get(i2).getOriginStations());
            routesHolder16.getDestinationStationValueTv().setText(this.list.get(i2).getDestinationStaion());
            routesHolder16.getShowAllRoutesDetailsRecycler().setAdapter(new BusStopsRecyclerAdapter(this.list.get(i2).getStopList(), this.routes.get(i2), new RouteMultiViewRecyclerAdapter$onBindViewHolder$3(viewHolder2), this.context));
            routesHolder16.getContentLayout().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RouteMultiViewRecyclerAdapter.m29onBindViewHolder$lambda1(RecyclerView.ViewHolder.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m28onBindViewHolder$lambda0(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
        if (headerViewHolder.getShowAllRoutesDetailsRecycler().getVisibility() == 8) {
            headerViewHolder.getShowAllRoutesDetailsRecycler().setVisibility(0);
            headerViewHolder.getContentLayout().setVisibility(8);
            return;
        }
        headerViewHolder.getShowAllRoutesDetailsRecycler().setVisibility(8);
        headerViewHolder.getContentLayout().setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m29onBindViewHolder$lambda1(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        RoutesHolder routesHolder = (RoutesHolder) viewHolder;
        if (routesHolder.getShowAllRoutesDetailsRecycler().getVisibility() == 8) {
            routesHolder.getShowAllRoutesDetailsRecycler().setVisibility(0);
            routesHolder.getContentLayout().setVisibility(8);
            return;
        }
        routesHolder.getShowAllRoutesDetailsRecycler().setVisibility(8);
        routesHolder.getContentLayout().setVisibility(0);
    }

    public int getItemCount() {
        return this.list.size();
    }

    public int getItemViewType(int i) {
        return this.list.get(i).getViewType() == 1 ? 1 : 2;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/RouteMultiViewRecyclerAdapter$RoutesHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "busImage", "Landroid/widget/ImageView;", "getBusImage", "()Landroid/widget/ImageView;", "contentLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "destinationStationValueTv", "Landroid/widget/TextView;", "getDestinationStationValueTv", "()Landroid/widget/TextView;", "originCentersTv", "getOriginCentersTv", "originStationValueTv", "getOriginStationValueTv", "showAllRoutesDetailsRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getShowAllRoutesDetailsRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "stopsImg", "getStopsImg", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RouteMultiViewRecyclerAdapter.kt */
    public static final class RoutesHolder extends RecyclerView.ViewHolder {
        private final ImageView busImage;
        private final ConstraintLayout contentLayout;
        private final TextView destinationStationValueTv;
        private final TextView originCentersTv;
        private final TextView originStationValueTv;
        private final RecyclerView showAllRoutesDetailsRecycler;
        private final ImageView stopsImg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RoutesHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.showAllRoutesDetailsRecycler);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            this.showAllRoutesDetailsRecycler = (RecyclerView) findViewById;
            View findViewById2 = view.findViewById(R.id.originStationValueTv);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.originStationValueTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.originCentersTv);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.originCentersTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.destinationStationValueTv);
            Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.destinationStationValueTv = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.contentLayout);
            Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.contentLayout = (ConstraintLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.busImage);
            Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
            this.busImage = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.stopsImg);
            Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
            this.stopsImg = (ImageView) findViewById7;
        }

        public final RecyclerView getShowAllRoutesDetailsRecycler() {
            return this.showAllRoutesDetailsRecycler;
        }

        public final TextView getOriginStationValueTv() {
            return this.originStationValueTv;
        }

        public final TextView getOriginCentersTv() {
            return this.originCentersTv;
        }

        public final TextView getDestinationStationValueTv() {
            return this.destinationStationValueTv;
        }

        public final ConstraintLayout getContentLayout() {
            return this.contentLayout;
        }

        public final ImageView getBusImage() {
            return this.busImage;
        }

        public final ImageView getStopsImg() {
            return this.stopsImg;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/busroutes/RouteMultiViewRecyclerAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "busImage", "Landroid/widget/ImageView;", "getBusImage", "()Landroid/widget/ImageView;", "contentLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContentLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "destinationStationValueTv", "Landroid/widget/TextView;", "getDestinationStationValueTv", "()Landroid/widget/TextView;", "multiViewHeaderTv", "getMultiViewHeaderTv", "originCentersTv", "getOriginCentersTv", "originStationValueTv", "getOriginStationValueTv", "showAllRoutesDetailsRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getShowAllRoutesDetailsRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "stopsImg", "getStopsImg", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RouteMultiViewRecyclerAdapter.kt */
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final ImageView busImage;
        private final ConstraintLayout contentLayout;
        private final TextView destinationStationValueTv;
        private final TextView multiViewHeaderTv;
        private final TextView originCentersTv;
        private final TextView originStationValueTv;
        private final RecyclerView showAllRoutesDetailsRecycler;
        private final ImageView stopsImg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.multiViewHeaderTv);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.multiViewHeaderTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.showAllRoutesDetailsRecycler);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            this.showAllRoutesDetailsRecycler = (RecyclerView) findViewById2;
            View findViewById3 = view.findViewById(R.id.originStationValueTv);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.originStationValueTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.originCentersTv);
            Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.originCentersTv = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.destinationStationValueTv);
            Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
            this.destinationStationValueTv = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.contentLayout);
            Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.contentLayout = (ConstraintLayout) findViewById6;
            View findViewById7 = view.findViewById(R.id.busImage);
            Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
            this.busImage = (ImageView) findViewById7;
            View findViewById8 = view.findViewById(R.id.stopsImg);
            Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type android.widget.ImageView");
            this.stopsImg = (ImageView) findViewById8;
        }

        public final TextView getMultiViewHeaderTv() {
            return this.multiViewHeaderTv;
        }

        public final RecyclerView getShowAllRoutesDetailsRecycler() {
            return this.showAllRoutesDetailsRecycler;
        }

        public final TextView getOriginStationValueTv() {
            return this.originStationValueTv;
        }

        public final TextView getOriginCentersTv() {
            return this.originCentersTv;
        }

        public final TextView getDestinationStationValueTv() {
            return this.destinationStationValueTv;
        }

        public final ConstraintLayout getContentLayout() {
            return this.contentLayout;
        }

        public final ImageView getBusImage() {
            return this.busImage;
        }

        public final ImageView getStopsImg() {
            return this.stopsImg;
        }
    }
}
