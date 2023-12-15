package com.lmkt.zupeshawar.model.zuCardFeatureModel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/lmkt/zupeshawar/model/zuCardFeatureModel/NFCStatusRequest;", "", "NFCStatus", "", "DeviceInfo", "manufacturer", "OSVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceInfo", "()Ljava/lang/String;", "setDeviceInfo", "(Ljava/lang/String;)V", "getNFCStatus", "setNFCStatus", "getOSVersion", "setOSVersion", "getManufacturer", "setManufacturer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NFCStatusRequest.kt */
public final class NFCStatusRequest {
    @SerializedName("DeviceInfo")
    private String DeviceInfo;
    @SerializedName("NFCStatus")
    private String NFCStatus;
    @SerializedName("OSVersion")
    private String OSVersion;
    @SerializedName("Manufacturer")
    private String manufacturer;

    public static /* synthetic */ NFCStatusRequest copy$default(NFCStatusRequest nFCStatusRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nFCStatusRequest.NFCStatus;
        }
        if ((i & 2) != 0) {
            str2 = nFCStatusRequest.DeviceInfo;
        }
        if ((i & 4) != 0) {
            str3 = nFCStatusRequest.manufacturer;
        }
        if ((i & 8) != 0) {
            str4 = nFCStatusRequest.OSVersion;
        }
        return nFCStatusRequest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.NFCStatus;
    }

    public final String component2() {
        return this.DeviceInfo;
    }

    public final String component3() {
        return this.manufacturer;
    }

    public final String component4() {
        return this.OSVersion;
    }

    public final NFCStatusRequest copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "NFCStatus");
        Intrinsics.checkNotNullParameter(str2, "DeviceInfo");
        Intrinsics.checkNotNullParameter(str3, "manufacturer");
        Intrinsics.checkNotNullParameter(str4, "OSVersion");
        return new NFCStatusRequest(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NFCStatusRequest)) {
            return false;
        }
        NFCStatusRequest nFCStatusRequest = (NFCStatusRequest) obj;
        return Intrinsics.areEqual((Object) this.NFCStatus, (Object) nFCStatusRequest.NFCStatus) && Intrinsics.areEqual((Object) this.DeviceInfo, (Object) nFCStatusRequest.DeviceInfo) && Intrinsics.areEqual((Object) this.manufacturer, (Object) nFCStatusRequest.manufacturer) && Intrinsics.areEqual((Object) this.OSVersion, (Object) nFCStatusRequest.OSVersion);
    }

    public int hashCode() {
        return (((((this.NFCStatus.hashCode() * 31) + this.DeviceInfo.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.OSVersion.hashCode();
    }

    public String toString() {
        return "NFCStatusRequest(NFCStatus=" + this.NFCStatus + ", DeviceInfo=" + this.DeviceInfo + ", manufacturer=" + this.manufacturer + ", OSVersion=" + this.OSVersion + ')';
    }

    public NFCStatusRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "NFCStatus");
        Intrinsics.checkNotNullParameter(str2, "DeviceInfo");
        Intrinsics.checkNotNullParameter(str3, "manufacturer");
        Intrinsics.checkNotNullParameter(str4, "OSVersion");
        this.NFCStatus = str;
        this.DeviceInfo = str2;
        this.manufacturer = str3;
        this.OSVersion = str4;
    }

    public final String getNFCStatus() {
        return this.NFCStatus;
    }

    public final void setNFCStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.NFCStatus = str;
    }

    public final String getDeviceInfo() {
        return this.DeviceInfo;
    }

    public final void setDeviceInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.DeviceInfo = str;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manufacturer = str;
    }

    public final String getOSVersion() {
        return this.OSVersion;
    }

    public final void setOSVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.OSVersion = str;
    }
}
