package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B­\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J±\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0004HÖ\u0001R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016¨\u0006G"}, d2 = {"Lcom/lmkt/zupeshawar/model/TravelHistory;", "Ljava/io/Serializable;", "()V", "checkinStation", "", "checkoutStation", "userId", "date", "duration", "fare", "checkintime", "checkouttime", "rentSite", "returnSite", "orderId", "rentoutTime", "returnTime", "bikeNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBikeNumber", "()Ljava/lang/String;", "setBikeNumber", "(Ljava/lang/String;)V", "getCheckinStation", "setCheckinStation", "getCheckintime", "setCheckintime", "getCheckoutStation", "setCheckoutStation", "getCheckouttime", "setCheckouttime", "getDate", "setDate", "getDuration", "setDuration", "getFare", "setFare", "getOrderId", "setOrderId", "getRentSite", "setRentSite", "getRentoutTime", "setRentoutTime", "getReturnSite", "setReturnSite", "getReturnTime", "setReturnTime", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TravelHistory.kt */
public final class TravelHistory implements Serializable {
    @SerializedName("bikeNumber")
    private String bikeNumber;
    @SerializedName("checkinStation")
    private String checkinStation;
    @SerializedName("checkintime")
    private String checkintime;
    @SerializedName("checkoutStation")
    private String checkoutStation;
    @SerializedName("checkouttime")
    private String checkouttime;
    @SerializedName("date")
    private String date;
    @SerializedName("duration")
    private String duration;
    @SerializedName("fare")
    private String fare;
    @SerializedName("orderId")
    private String orderId;
    @SerializedName("rentSite")
    private String rentSite;
    @SerializedName("rentoutTime")
    private String rentoutTime;
    @SerializedName("returnSite")
    private String returnSite;
    @SerializedName("returnTime")
    private String returnTime;
    @SerializedName("userId")
    private String userId;

    public static /* synthetic */ TravelHistory copy$default(TravelHistory travelHistory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, Object obj) {
        TravelHistory travelHistory2 = travelHistory;
        int i2 = i;
        return travelHistory.copy((i2 & 1) != 0 ? travelHistory2.checkinStation : str, (i2 & 2) != 0 ? travelHistory2.checkoutStation : str2, (i2 & 4) != 0 ? travelHistory2.userId : str3, (i2 & 8) != 0 ? travelHistory2.date : str4, (i2 & 16) != 0 ? travelHistory2.duration : str5, (i2 & 32) != 0 ? travelHistory2.fare : str6, (i2 & 64) != 0 ? travelHistory2.checkintime : str7, (i2 & 128) != 0 ? travelHistory2.checkouttime : str8, (i2 & 256) != 0 ? travelHistory2.rentSite : str9, (i2 & 512) != 0 ? travelHistory2.returnSite : str10, (i2 & 1024) != 0 ? travelHistory2.orderId : str11, (i2 & 2048) != 0 ? travelHistory2.rentoutTime : str12, (i2 & 4096) != 0 ? travelHistory2.returnTime : str13, (i2 & 8192) != 0 ? travelHistory2.bikeNumber : str14);
    }

    public final String component1() {
        return this.checkinStation;
    }

    public final String component10() {
        return this.returnSite;
    }

    public final String component11() {
        return this.orderId;
    }

    public final String component12() {
        return this.rentoutTime;
    }

    public final String component13() {
        return this.returnTime;
    }

    public final String component14() {
        return this.bikeNumber;
    }

    public final String component2() {
        return this.checkoutStation;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.date;
    }

    public final String component5() {
        return this.duration;
    }

    public final String component6() {
        return this.fare;
    }

    public final String component7() {
        return this.checkintime;
    }

    public final String component8() {
        return this.checkouttime;
    }

    public final String component9() {
        return this.rentSite;
    }

    public final TravelHistory copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        return new TravelHistory(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TravelHistory)) {
            return false;
        }
        TravelHistory travelHistory = (TravelHistory) obj;
        return Intrinsics.areEqual((Object) this.checkinStation, (Object) travelHistory.checkinStation) && Intrinsics.areEqual((Object) this.checkoutStation, (Object) travelHistory.checkoutStation) && Intrinsics.areEqual((Object) this.userId, (Object) travelHistory.userId) && Intrinsics.areEqual((Object) this.date, (Object) travelHistory.date) && Intrinsics.areEqual((Object) this.duration, (Object) travelHistory.duration) && Intrinsics.areEqual((Object) this.fare, (Object) travelHistory.fare) && Intrinsics.areEqual((Object) this.checkintime, (Object) travelHistory.checkintime) && Intrinsics.areEqual((Object) this.checkouttime, (Object) travelHistory.checkouttime) && Intrinsics.areEqual((Object) this.rentSite, (Object) travelHistory.rentSite) && Intrinsics.areEqual((Object) this.returnSite, (Object) travelHistory.returnSite) && Intrinsics.areEqual((Object) this.orderId, (Object) travelHistory.orderId) && Intrinsics.areEqual((Object) this.rentoutTime, (Object) travelHistory.rentoutTime) && Intrinsics.areEqual((Object) this.returnTime, (Object) travelHistory.returnTime) && Intrinsics.areEqual((Object) this.bikeNumber, (Object) travelHistory.bikeNumber);
    }

    public int hashCode() {
        String str = this.checkinStation;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.checkoutStation;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.date;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.duration;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fare;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.checkintime;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.checkouttime;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.rentSite;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.returnSite;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.orderId;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.rentoutTime;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.returnTime;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.bikeNumber;
        if (str14 != null) {
            i = str14.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        return "TravelHistory(checkinStation=" + this.checkinStation + ", checkoutStation=" + this.checkoutStation + ", userId=" + this.userId + ", date=" + this.date + ", duration=" + this.duration + ", fare=" + this.fare + ", checkintime=" + this.checkintime + ", checkouttime=" + this.checkouttime + ", rentSite=" + this.rentSite + ", returnSite=" + this.returnSite + ", orderId=" + this.orderId + ", rentoutTime=" + this.rentoutTime + ", returnTime=" + this.returnTime + ", bikeNumber=" + this.bikeNumber + ')';
    }

    public TravelHistory(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.checkinStation = str;
        this.checkoutStation = str2;
        this.userId = str3;
        this.date = str4;
        this.duration = str5;
        this.fare = str6;
        this.checkintime = str7;
        this.checkouttime = str8;
        this.rentSite = str9;
        this.returnSite = str10;
        this.orderId = str11;
        this.rentoutTime = str12;
        this.returnTime = str13;
        this.bikeNumber = str14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TravelHistory(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r16
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r17
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r18
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r19
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r20
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r21
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r2
            goto L_0x003c
        L_0x003a:
            r8 = r22
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r2
            goto L_0x0044
        L_0x0042:
            r9 = r23
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r2
            goto L_0x004c
        L_0x004a:
            r10 = r24
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r2
            goto L_0x0054
        L_0x0052:
            r11 = r25
        L_0x0054:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005a
            r12 = r2
            goto L_0x005c
        L_0x005a:
            r12 = r26
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            r13 = r2
            goto L_0x0064
        L_0x0062:
            r13 = r27
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = r2
            goto L_0x006c
        L_0x006a:
            r14 = r28
        L_0x006c:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r2 = r29
        L_0x0073:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.TravelHistory.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCheckinStation() {
        return this.checkinStation;
    }

    public final void setCheckinStation(String str) {
        this.checkinStation = str;
    }

    public final String getCheckoutStation() {
        return this.checkoutStation;
    }

    public final void setCheckoutStation(String str) {
        this.checkoutStation = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getFare() {
        return this.fare;
    }

    public final void setFare(String str) {
        this.fare = str;
    }

    public final String getCheckintime() {
        return this.checkintime;
    }

    public final void setCheckintime(String str) {
        this.checkintime = str;
    }

    public final String getCheckouttime() {
        return this.checkouttime;
    }

    public final void setCheckouttime(String str) {
        this.checkouttime = str;
    }

    public final String getRentSite() {
        return this.rentSite;
    }

    public final void setRentSite(String str) {
        this.rentSite = str;
    }

    public final String getReturnSite() {
        return this.returnSite;
    }

    public final void setReturnSite(String str) {
        this.returnSite = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getRentoutTime() {
        return this.rentoutTime;
    }

    public final void setRentoutTime(String str) {
        this.rentoutTime = str;
    }

    public final String getReturnTime() {
        return this.returnTime;
    }

    public final void setReturnTime(String str) {
        this.returnTime = str;
    }

    public final String getBikeNumber() {
        return this.bikeNumber;
    }

    public final void setBikeNumber(String str) {
        this.bikeNumber = str;
    }

    public TravelHistory() {
        this("", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (DefaultConstructorMarker) null);
    }
}
