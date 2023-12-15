package com.lmkt.zupeshawar.model.routeModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\bHÆ\u0003JM\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/GetRoutesMainModel;", "Ljava/io/Serializable;", "totalStops", "", "totalBusChanges", "estimatedTravelTime", "", "route", "", "stops", "Lcom/lmkt/zupeshawar/model/routeModels/Stops;", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getEstimatedTravelTime", "()Ljava/lang/String;", "setEstimatedTravelTime", "(Ljava/lang/String;)V", "getRoute", "()Ljava/util/List;", "setRoute", "(Ljava/util/List;)V", "getStops", "setStops", "getTotalBusChanges", "()I", "setTotalBusChanges", "(I)V", "getTotalStops", "setTotalStops", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GetRoutesMainModel.kt */
public final class GetRoutesMainModel implements Serializable {
    @SerializedName("estimatedTravelTime")
    private String estimatedTravelTime;
    @SerializedName("route")
    private List<String> route;
    @SerializedName("stops")
    private List<? extends List<Stops>> stops;
    @SerializedName("totalBusChanges")
    private int totalBusChanges;
    @SerializedName("totalStops")
    private int totalStops;

    public static /* synthetic */ GetRoutesMainModel copy$default(GetRoutesMainModel getRoutesMainModel, int i, int i2, String str, List<String> list, List<? extends List<Stops>> list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = getRoutesMainModel.totalStops;
        }
        if ((i3 & 2) != 0) {
            i2 = getRoutesMainModel.totalBusChanges;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = getRoutesMainModel.estimatedTravelTime;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            list = getRoutesMainModel.route;
        }
        List<String> list3 = list;
        if ((i3 & 16) != 0) {
            list2 = getRoutesMainModel.stops;
        }
        return getRoutesMainModel.copy(i, i4, str2, list3, list2);
    }

    public final int component1() {
        return this.totalStops;
    }

    public final int component2() {
        return this.totalBusChanges;
    }

    public final String component3() {
        return this.estimatedTravelTime;
    }

    public final List<String> component4() {
        return this.route;
    }

    public final List<List<Stops>> component5() {
        return this.stops;
    }

    public final GetRoutesMainModel copy(int i, int i2, String str, List<String> list, List<? extends List<Stops>> list2) {
        Intrinsics.checkNotNullParameter(str, "estimatedTravelTime");
        Intrinsics.checkNotNullParameter(list, "route");
        Intrinsics.checkNotNullParameter(list2, "stops");
        return new GetRoutesMainModel(i, i2, str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetRoutesMainModel)) {
            return false;
        }
        GetRoutesMainModel getRoutesMainModel = (GetRoutesMainModel) obj;
        return this.totalStops == getRoutesMainModel.totalStops && this.totalBusChanges == getRoutesMainModel.totalBusChanges && Intrinsics.areEqual((Object) this.estimatedTravelTime, (Object) getRoutesMainModel.estimatedTravelTime) && Intrinsics.areEqual((Object) this.route, (Object) getRoutesMainModel.route) && Intrinsics.areEqual((Object) this.stops, (Object) getRoutesMainModel.stops);
    }

    public int hashCode() {
        return (((((((this.totalStops * 31) + this.totalBusChanges) * 31) + this.estimatedTravelTime.hashCode()) * 31) + this.route.hashCode()) * 31) + this.stops.hashCode();
    }

    public String toString() {
        return "GetRoutesMainModel(totalStops=" + this.totalStops + ", totalBusChanges=" + this.totalBusChanges + ", estimatedTravelTime=" + this.estimatedTravelTime + ", route=" + this.route + ", stops=" + this.stops + ')';
    }

    public GetRoutesMainModel(int i, int i2, String str, List<String> list, List<? extends List<Stops>> list2) {
        Intrinsics.checkNotNullParameter(str, "estimatedTravelTime");
        Intrinsics.checkNotNullParameter(list, "route");
        Intrinsics.checkNotNullParameter(list2, "stops");
        this.totalStops = i;
        this.totalBusChanges = i2;
        this.estimatedTravelTime = str;
        this.route = list;
        this.stops = list2;
    }

    public final int getTotalStops() {
        return this.totalStops;
    }

    public final void setTotalStops(int i) {
        this.totalStops = i;
    }

    public final int getTotalBusChanges() {
        return this.totalBusChanges;
    }

    public final void setTotalBusChanges(int i) {
        this.totalBusChanges = i;
    }

    public final String getEstimatedTravelTime() {
        return this.estimatedTravelTime;
    }

    public final void setEstimatedTravelTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.estimatedTravelTime = str;
    }

    public final List<String> getRoute() {
        return this.route;
    }

    public final void setRoute(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.route = list;
    }

    public final List<List<Stops>> getStops() {
        return this.stops;
    }

    public final void setStops(List<? extends List<Stops>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.stops = list;
    }
}
