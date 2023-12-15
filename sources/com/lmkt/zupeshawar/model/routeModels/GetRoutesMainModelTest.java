package com.lmkt.zupeshawar.model.routeModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\bHÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/GetRoutesMainModelTest;", "Ljava/io/Serializable;", "totalStops", "", "totalBusChanges", "estimatedTravelTime", "", "stationsToChangeOn", "", "stops", "Lcom/lmkt/zupeshawar/model/routeModels/StopsTest;", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getEstimatedTravelTime", "()Ljava/lang/String;", "setEstimatedTravelTime", "(Ljava/lang/String;)V", "getStationsToChangeOn", "()Ljava/util/List;", "setStationsToChangeOn", "(Ljava/util/List;)V", "getStops", "setStops", "getTotalBusChanges", "()I", "setTotalBusChanges", "(I)V", "getTotalStops", "setTotalStops", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GetRoutesMainModelTest.kt */
public final class GetRoutesMainModelTest implements Serializable {
    @SerializedName("estimatedTravelTime")
    private String estimatedTravelTime;
    @SerializedName("stationsToChangeOn")
    private List<String> stationsToChangeOn;
    @SerializedName("stops")
    private List<StopsTest> stops;
    @SerializedName("totalBusChanges")
    private int totalBusChanges;
    @SerializedName("totalStops")
    private int totalStops;

    public static /* synthetic */ GetRoutesMainModelTest copy$default(GetRoutesMainModelTest getRoutesMainModelTest, int i, int i2, String str, List<String> list, List<StopsTest> list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = getRoutesMainModelTest.totalStops;
        }
        if ((i3 & 2) != 0) {
            i2 = getRoutesMainModelTest.totalBusChanges;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = getRoutesMainModelTest.estimatedTravelTime;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            list = getRoutesMainModelTest.stationsToChangeOn;
        }
        List<String> list3 = list;
        if ((i3 & 16) != 0) {
            list2 = getRoutesMainModelTest.stops;
        }
        return getRoutesMainModelTest.copy(i, i4, str2, list3, list2);
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
        return this.stationsToChangeOn;
    }

    public final List<StopsTest> component5() {
        return this.stops;
    }

    public final GetRoutesMainModelTest copy(int i, int i2, String str, List<String> list, List<StopsTest> list2) {
        Intrinsics.checkNotNullParameter(str, "estimatedTravelTime");
        Intrinsics.checkNotNullParameter(list, "stationsToChangeOn");
        Intrinsics.checkNotNullParameter(list2, "stops");
        return new GetRoutesMainModelTest(i, i2, str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetRoutesMainModelTest)) {
            return false;
        }
        GetRoutesMainModelTest getRoutesMainModelTest = (GetRoutesMainModelTest) obj;
        return this.totalStops == getRoutesMainModelTest.totalStops && this.totalBusChanges == getRoutesMainModelTest.totalBusChanges && Intrinsics.areEqual((Object) this.estimatedTravelTime, (Object) getRoutesMainModelTest.estimatedTravelTime) && Intrinsics.areEqual((Object) this.stationsToChangeOn, (Object) getRoutesMainModelTest.stationsToChangeOn) && Intrinsics.areEqual((Object) this.stops, (Object) getRoutesMainModelTest.stops);
    }

    public int hashCode() {
        return (((((((this.totalStops * 31) + this.totalBusChanges) * 31) + this.estimatedTravelTime.hashCode()) * 31) + this.stationsToChangeOn.hashCode()) * 31) + this.stops.hashCode();
    }

    public String toString() {
        return "GetRoutesMainModelTest(totalStops=" + this.totalStops + ", totalBusChanges=" + this.totalBusChanges + ", estimatedTravelTime=" + this.estimatedTravelTime + ", stationsToChangeOn=" + this.stationsToChangeOn + ", stops=" + this.stops + ')';
    }

    public GetRoutesMainModelTest(int i, int i2, String str, List<String> list, List<StopsTest> list2) {
        Intrinsics.checkNotNullParameter(str, "estimatedTravelTime");
        Intrinsics.checkNotNullParameter(list, "stationsToChangeOn");
        Intrinsics.checkNotNullParameter(list2, "stops");
        this.totalStops = i;
        this.totalBusChanges = i2;
        this.estimatedTravelTime = str;
        this.stationsToChangeOn = list;
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

    public final List<String> getStationsToChangeOn() {
        return this.stationsToChangeOn;
    }

    public final void setStationsToChangeOn(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.stationsToChangeOn = list;
    }

    public final List<StopsTest> getStops() {
        return this.stops;
    }

    public final void setStops(List<StopsTest> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.stops = list;
    }
}
