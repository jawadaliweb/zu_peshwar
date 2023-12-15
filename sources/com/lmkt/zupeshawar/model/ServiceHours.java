package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lmkt/zupeshawar/model/ServiceHours;", "Ljava/io/Serializable;", "()V", "day", "", "startTime", "endTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getStartTime", "setStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ServiceHours.kt */
public final class ServiceHours implements Serializable {
    @SerializedName("day")
    private String day;
    @SerializedName("endTime")
    private String endTime;
    @SerializedName("startTime")
    private String startTime;

    public static /* synthetic */ ServiceHours copy$default(ServiceHours serviceHours, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceHours.day;
        }
        if ((i & 2) != 0) {
            str2 = serviceHours.startTime;
        }
        if ((i & 4) != 0) {
            str3 = serviceHours.endTime;
        }
        return serviceHours.copy(str, str2, str3);
    }

    public final String component1() {
        return this.day;
    }

    public final String component2() {
        return this.startTime;
    }

    public final String component3() {
        return this.endTime;
    }

    public final ServiceHours copy(String str, String str2, String str3) {
        return new ServiceHours(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceHours)) {
            return false;
        }
        ServiceHours serviceHours = (ServiceHours) obj;
        return Intrinsics.areEqual((Object) this.day, (Object) serviceHours.day) && Intrinsics.areEqual((Object) this.startTime, (Object) serviceHours.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) serviceHours.endTime);
    }

    public int hashCode() {
        String str = this.day;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.startTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endTime;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ServiceHours(day=" + this.day + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public ServiceHours(String str, String str2, String str3) {
        this.day = str;
        this.startTime = str2;
        this.endTime = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceHours(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getDay() {
        return this.day;
    }

    public final void setDay(String str) {
        this.day = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public ServiceHours() {
        this("", (String) null, (String) null, 6, (DefaultConstructorMarker) null);
    }
}
