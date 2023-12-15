package com.lmkt.zupeshawar.model.routeModels;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/StopsTest;", "", "stopName", "", "timeToNext", "", "stopID", "routeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRouteName", "()Ljava/lang/String;", "setRouteName", "(Ljava/lang/String;)V", "getStopID", "setStopID", "getStopName", "setStopName", "getTimeToNext", "()I", "setTimeToNext", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StopsTest.kt */
public final class StopsTest {
    @SerializedName("routeName")
    private String routeName;
    @SerializedName("stopID")
    private String stopID;
    @SerializedName("stopName")
    private String stopName;
    @SerializedName("timeToNext")
    private int timeToNext;

    public static /* synthetic */ StopsTest copy$default(StopsTest stopsTest, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stopsTest.stopName;
        }
        if ((i2 & 2) != 0) {
            i = stopsTest.timeToNext;
        }
        if ((i2 & 4) != 0) {
            str2 = stopsTest.stopID;
        }
        if ((i2 & 8) != 0) {
            str3 = stopsTest.routeName;
        }
        return stopsTest.copy(str, i, str2, str3);
    }

    public final String component1() {
        return this.stopName;
    }

    public final int component2() {
        return this.timeToNext;
    }

    public final String component3() {
        return this.stopID;
    }

    public final String component4() {
        return this.routeName;
    }

    public final StopsTest copy(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "stopName");
        Intrinsics.checkNotNullParameter(str2, "stopID");
        Intrinsics.checkNotNullParameter(str3, "routeName");
        return new StopsTest(str, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StopsTest)) {
            return false;
        }
        StopsTest stopsTest = (StopsTest) obj;
        return Intrinsics.areEqual((Object) this.stopName, (Object) stopsTest.stopName) && this.timeToNext == stopsTest.timeToNext && Intrinsics.areEqual((Object) this.stopID, (Object) stopsTest.stopID) && Intrinsics.areEqual((Object) this.routeName, (Object) stopsTest.routeName);
    }

    public int hashCode() {
        return (((((this.stopName.hashCode() * 31) + this.timeToNext) * 31) + this.stopID.hashCode()) * 31) + this.routeName.hashCode();
    }

    public String toString() {
        return "StopsTest(stopName=" + this.stopName + ", timeToNext=" + this.timeToNext + ", stopID=" + this.stopID + ", routeName=" + this.routeName + ')';
    }

    public StopsTest(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "stopName");
        Intrinsics.checkNotNullParameter(str2, "stopID");
        Intrinsics.checkNotNullParameter(str3, "routeName");
        this.stopName = str;
        this.timeToNext = i;
        this.stopID = str2;
        this.routeName = str3;
    }

    public final String getStopName() {
        return this.stopName;
    }

    public final void setStopName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.stopName = str;
    }

    public final int getTimeToNext() {
        return this.timeToNext;
    }

    public final void setTimeToNext(int i) {
        this.timeToNext = i;
    }

    public final String getStopID() {
        return this.stopID;
    }

    public final void setStopID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.stopID = str;
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final void setRouteName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.routeName = str;
    }
}
