package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lmkt/zupeshawar/model/EstimatedFare;", "Ljava/io/Serializable;", "()V", "routeName", "", "estimatedTime", "fare", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEstimatedTime", "()Ljava/lang/String;", "setEstimatedTime", "(Ljava/lang/String;)V", "getFare", "setFare", "getRouteName", "setRouteName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EstimatedFare.kt */
public final class EstimatedFare implements Serializable {
    @SerializedName("estimatedTime")
    private String estimatedTime;
    @SerializedName("fare")
    private String fare;
    @SerializedName("routeName")
    private String routeName;

    public static /* synthetic */ EstimatedFare copy$default(EstimatedFare estimatedFare, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = estimatedFare.routeName;
        }
        if ((i & 2) != 0) {
            str2 = estimatedFare.estimatedTime;
        }
        if ((i & 4) != 0) {
            str3 = estimatedFare.fare;
        }
        return estimatedFare.copy(str, str2, str3);
    }

    public final String component1() {
        return this.routeName;
    }

    public final String component2() {
        return this.estimatedTime;
    }

    public final String component3() {
        return this.fare;
    }

    public final EstimatedFare copy(String str, String str2, String str3) {
        return new EstimatedFare(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EstimatedFare)) {
            return false;
        }
        EstimatedFare estimatedFare = (EstimatedFare) obj;
        return Intrinsics.areEqual((Object) this.routeName, (Object) estimatedFare.routeName) && Intrinsics.areEqual((Object) this.estimatedTime, (Object) estimatedFare.estimatedTime) && Intrinsics.areEqual((Object) this.fare, (Object) estimatedFare.fare);
    }

    public int hashCode() {
        String str = this.routeName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.estimatedTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fare;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "EstimatedFare(routeName=" + this.routeName + ", estimatedTime=" + this.estimatedTime + ", fare=" + this.fare + ')';
    }

    public EstimatedFare(String str, String str2, String str3) {
        this.routeName = str;
        this.estimatedTime = str2;
        this.fare = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EstimatedFare(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final void setRouteName(String str) {
        this.routeName = str;
    }

    public final String getEstimatedTime() {
        return this.estimatedTime;
    }

    public final void setEstimatedTime(String str) {
        this.estimatedTime = str;
    }

    public final String getFare() {
        return this.fare;
    }

    public final void setFare(String str) {
        this.fare = str;
    }

    public EstimatedFare() {
        this("", (String) null, (String) null, 6, (DefaultConstructorMarker) null);
    }
}
