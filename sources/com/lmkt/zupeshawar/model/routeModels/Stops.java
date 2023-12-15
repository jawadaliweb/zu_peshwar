package com.lmkt.zupeshawar.model.routeModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/Stops;", "Ljava/io/Serializable;", "stopName", "", "routeSequenceId", "id", "timeToNext", "", "onRouteNo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOnRouteNo", "()Ljava/util/List;", "setOnRouteNo", "(Ljava/util/List;)V", "getRouteSequenceId", "setRouteSequenceId", "getStopName", "setStopName", "getTimeToNext", "()I", "setTimeToNext", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Stops.kt */
public final class Stops implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("on_route_no")
    private List<String> onRouteNo;
    @SerializedName("route_sequence_id")
    private String routeSequenceId;
    @SerializedName("stop_name")
    private String stopName;
    @SerializedName("timeToNext")
    private int timeToNext;

    public static /* synthetic */ Stops copy$default(Stops stops, String str, String str2, String str3, int i, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stops.stopName;
        }
        if ((i2 & 2) != 0) {
            str2 = stops.routeSequenceId;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = stops.id;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = stops.timeToNext;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            list = stops.onRouteNo;
        }
        return stops.copy(str, str4, str5, i3, list);
    }

    public final String component1() {
        return this.stopName;
    }

    public final String component2() {
        return this.routeSequenceId;
    }

    public final String component3() {
        return this.id;
    }

    public final int component4() {
        return this.timeToNext;
    }

    public final List<String> component5() {
        return this.onRouteNo;
    }

    public final Stops copy(String str, String str2, String str3, int i, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "stopName");
        Intrinsics.checkNotNullParameter(list, "onRouteNo");
        return new Stops(str, str2, str3, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stops)) {
            return false;
        }
        Stops stops = (Stops) obj;
        return Intrinsics.areEqual((Object) this.stopName, (Object) stops.stopName) && Intrinsics.areEqual((Object) this.routeSequenceId, (Object) stops.routeSequenceId) && Intrinsics.areEqual((Object) this.id, (Object) stops.id) && this.timeToNext == stops.timeToNext && Intrinsics.areEqual((Object) this.onRouteNo, (Object) stops.onRouteNo);
    }

    public int hashCode() {
        int hashCode = this.stopName.hashCode() * 31;
        String str = this.routeSequenceId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.timeToNext) * 31) + this.onRouteNo.hashCode();
    }

    public String toString() {
        return "Stops(stopName=" + this.stopName + ", routeSequenceId=" + this.routeSequenceId + ", id=" + this.id + ", timeToNext=" + this.timeToNext + ", onRouteNo=" + this.onRouteNo + ')';
    }

    public Stops(String str, String str2, String str3, int i, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "stopName");
        Intrinsics.checkNotNullParameter(list, "onRouteNo");
        this.stopName = str;
        this.routeSequenceId = str2;
        this.id = str3;
        this.timeToNext = i;
        this.onRouteNo = list;
    }

    public final String getStopName() {
        return this.stopName;
    }

    public final void setStopName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.stopName = str;
    }

    public final String getRouteSequenceId() {
        return this.routeSequenceId;
    }

    public final void setRouteSequenceId(String str) {
        this.routeSequenceId = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final int getTimeToNext() {
        return this.timeToNext;
    }

    public final void setTimeToNext(int i) {
        this.timeToNext = i;
    }

    public final List<String> getOnRouteNo() {
        return this.onRouteNo;
    }

    public final void setOnRouteNo(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.onRouteNo = list;
    }
}
