package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0003J\\\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\"\u0010)\u001a\u00020\u00062\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bJ\t\u0010*\u001a\u00020\u0004HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R2\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/lmkt/zupeshawar/model/BusArrival;", "Ljava/io/Serializable;", "()V", "routeID", "", "route", "", "origin", "destination", "arrivals", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getArrivals", "()Ljava/util/ArrayList;", "setArrivals", "(Ljava/util/ArrayList;)V", "getDestination", "()Ljava/lang/String;", "setDestination", "(Ljava/lang/String;)V", "getOrigin", "setOrigin", "getRoute", "setRoute", "getRouteID", "()Ljava/lang/Integer;", "setRouteID", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/lmkt/zupeshawar/model/BusArrival;", "equals", "", "other", "", "getArrivalTimes", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BusArrival.kt */
public final class BusArrival implements Serializable {
    @SerializedName("arrivals")
    private ArrayList<String> arrivals;
    @SerializedName("destination")
    private String destination;
    @SerializedName("origin")
    private String origin;
    @SerializedName("route")
    private String route;
    @SerializedName("routeID")
    private Integer routeID;

    public static /* synthetic */ BusArrival copy$default(BusArrival busArrival, Integer num, String str, String str2, String str3, ArrayList<String> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            num = busArrival.routeID;
        }
        if ((i & 2) != 0) {
            str = busArrival.route;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = busArrival.origin;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = busArrival.destination;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            arrayList = busArrival.arrivals;
        }
        return busArrival.copy(num, str4, str5, str6, arrayList);
    }

    public final Integer component1() {
        return this.routeID;
    }

    public final String component2() {
        return this.route;
    }

    public final String component3() {
        return this.origin;
    }

    public final String component4() {
        return this.destination;
    }

    public final ArrayList<String> component5() {
        return this.arrivals;
    }

    public final BusArrival copy(Integer num, String str, String str2, String str3, ArrayList<String> arrayList) {
        return new BusArrival(num, str, str2, str3, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BusArrival)) {
            return false;
        }
        BusArrival busArrival = (BusArrival) obj;
        return Intrinsics.areEqual((Object) this.routeID, (Object) busArrival.routeID) && Intrinsics.areEqual((Object) this.route, (Object) busArrival.route) && Intrinsics.areEqual((Object) this.origin, (Object) busArrival.origin) && Intrinsics.areEqual((Object) this.destination, (Object) busArrival.destination) && Intrinsics.areEqual((Object) this.arrivals, (Object) busArrival.arrivals);
    }

    public int hashCode() {
        Integer num = this.routeID;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.route;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.origin;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.destination;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ArrayList<String> arrayList = this.arrivals;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "BusArrival(routeID=" + this.routeID + ", route=" + this.route + ", origin=" + this.origin + ", destination=" + this.destination + ", arrivals=" + this.arrivals + ')';
    }

    public BusArrival(Integer num, String str, String str2, String str3, ArrayList<String> arrayList) {
        this.routeID = num;
        this.route = str;
        this.origin = str2;
        this.destination = str3;
        this.arrivals = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BusArrival(java.lang.Integer r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.ArrayList r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0009
            r4 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0009:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0011
            r10 = r0
            goto L_0x0012
        L_0x0011:
            r10 = r5
        L_0x0012:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0018
            r1 = r0
            goto L_0x0019
        L_0x0018:
            r1 = r6
        L_0x0019:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r7
        L_0x001f:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0024
            r8 = 0
        L_0x0024:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.BusArrival.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getRouteID() {
        return this.routeID;
    }

    public final void setRouteID(Integer num) {
        this.routeID = num;
    }

    public final String getRoute() {
        return this.route;
    }

    public final void setRoute(String str) {
        this.route = str;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final void setOrigin(String str) {
        this.origin = str;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final ArrayList<String> getArrivals() {
        return this.arrivals;
    }

    public final void setArrivals(ArrayList<String> arrayList) {
        this.arrivals = arrayList;
    }

    public BusArrival() {
        this((Integer) null, "", (String) null, (String) null, (ArrayList) null, 29, (DefaultConstructorMarker) null);
    }

    public final String getArrivalTimes(ArrayList<String> arrayList) {
        Intrinsics.checkNotNull(arrayList);
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            str = str + arrayList.get(i) + ",  ";
        }
        return str;
    }
}
