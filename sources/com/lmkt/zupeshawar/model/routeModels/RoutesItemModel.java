package com.lmkt.zupeshawar.model.routeModels;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003JA\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/RoutesItemModel;", "", "viewType", "", "stopList", "", "Lcom/lmkt/zupeshawar/model/routeModels/Stops;", "totalStops", "", "originStations", "destinationStaion", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDestinationStaion", "()Ljava/lang/String;", "setDestinationStaion", "(Ljava/lang/String;)V", "getOriginStations", "setOriginStations", "getStopList", "()Ljava/util/List;", "setStopList", "(Ljava/util/List;)V", "getTotalStops", "setTotalStops", "getViewType", "()I", "setViewType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoutesItemModel.kt */
public final class RoutesItemModel {
    private String destinationStaion;
    private String originStations;
    private List<Stops> stopList;
    private String totalStops;
    private int viewType;

    public static /* synthetic */ RoutesItemModel copy$default(RoutesItemModel routesItemModel, int i, List<Stops> list, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = routesItemModel.viewType;
        }
        if ((i2 & 2) != 0) {
            list = routesItemModel.stopList;
        }
        List<Stops> list2 = list;
        if ((i2 & 4) != 0) {
            str = routesItemModel.totalStops;
        }
        String str4 = str;
        if ((i2 & 8) != 0) {
            str2 = routesItemModel.originStations;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = routesItemModel.destinationStaion;
        }
        return routesItemModel.copy(i, list2, str4, str5, str3);
    }

    public final int component1() {
        return this.viewType;
    }

    public final List<Stops> component2() {
        return this.stopList;
    }

    public final String component3() {
        return this.totalStops;
    }

    public final String component4() {
        return this.originStations;
    }

    public final String component5() {
        return this.destinationStaion;
    }

    public final RoutesItemModel copy(int i, List<Stops> list, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(list, "stopList");
        Intrinsics.checkNotNullParameter(str, "totalStops");
        Intrinsics.checkNotNullParameter(str2, "originStations");
        Intrinsics.checkNotNullParameter(str3, "destinationStaion");
        return new RoutesItemModel(i, list, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoutesItemModel)) {
            return false;
        }
        RoutesItemModel routesItemModel = (RoutesItemModel) obj;
        return this.viewType == routesItemModel.viewType && Intrinsics.areEqual((Object) this.stopList, (Object) routesItemModel.stopList) && Intrinsics.areEqual((Object) this.totalStops, (Object) routesItemModel.totalStops) && Intrinsics.areEqual((Object) this.originStations, (Object) routesItemModel.originStations) && Intrinsics.areEqual((Object) this.destinationStaion, (Object) routesItemModel.destinationStaion);
    }

    public int hashCode() {
        return (((((((this.viewType * 31) + this.stopList.hashCode()) * 31) + this.totalStops.hashCode()) * 31) + this.originStations.hashCode()) * 31) + this.destinationStaion.hashCode();
    }

    public String toString() {
        return "RoutesItemModel(viewType=" + this.viewType + ", stopList=" + this.stopList + ", totalStops=" + this.totalStops + ", originStations=" + this.originStations + ", destinationStaion=" + this.destinationStaion + ')';
    }

    public RoutesItemModel(int i, List<Stops> list, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(list, "stopList");
        Intrinsics.checkNotNullParameter(str, "totalStops");
        Intrinsics.checkNotNullParameter(str2, "originStations");
        Intrinsics.checkNotNullParameter(str3, "destinationStaion");
        this.viewType = i;
        this.stopList = list;
        this.totalStops = str;
        this.originStations = str2;
        this.destinationStaion = str3;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void setViewType(int i) {
        this.viewType = i;
    }

    public final String getOriginStations() {
        return this.originStations;
    }

    public final List<Stops> getStopList() {
        return this.stopList;
    }

    public final String getTotalStops() {
        return this.totalStops;
    }

    public final void setOriginStations(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originStations = str;
    }

    public final void setStopList(List<Stops> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.stopList = list;
    }

    public final void setTotalStops(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalStops = str;
    }

    public final String getDestinationStaion() {
        return this.destinationStaion;
    }

    public final void setDestinationStaion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.destinationStaion = str;
    }
}
