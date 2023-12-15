package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\b\u00102\u001a\u00020\u0004H\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00063"}, d2 = {"Lcom/lmkt/zupeshawar/model/TopUpDetails;", "Ljava/io/Serializable;", "()V", "updatedbalance", "", "message", "date", "MobileAccount", "Amount", "Email", "PaymentSource", "", "CNIC", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getCNIC", "setCNIC", "getEmail", "setEmail", "getMobileAccount", "setMobileAccount", "getPaymentSource", "()Ljava/lang/Integer;", "setPaymentSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDate", "setDate", "getMessage", "setMessage", "getUpdatedbalance", "setUpdatedbalance", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lmkt/zupeshawar/model/TopUpDetails;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopUpDetails.kt */
public final class TopUpDetails implements Serializable {
    @SerializedName("Amount")
    private String Amount;
    @SerializedName("CNIC")
    private String CNIC;
    @SerializedName("Email")
    private String Email;
    @SerializedName("MobileAccount")
    private String MobileAccount;
    @SerializedName("PaymentSource")
    private Integer PaymentSource;
    @SerializedName("date")
    private String date;
    @SerializedName("message")
    private String message;
    @SerializedName("updatedbalance")
    private String updatedbalance;

    public static /* synthetic */ TopUpDetails copy$default(TopUpDetails topUpDetails, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, int i, Object obj) {
        TopUpDetails topUpDetails2 = topUpDetails;
        int i2 = i;
        return topUpDetails.copy((i2 & 1) != 0 ? topUpDetails2.updatedbalance : str, (i2 & 2) != 0 ? topUpDetails2.message : str2, (i2 & 4) != 0 ? topUpDetails2.date : str3, (i2 & 8) != 0 ? topUpDetails2.MobileAccount : str4, (i2 & 16) != 0 ? topUpDetails2.Amount : str5, (i2 & 32) != 0 ? topUpDetails2.Email : str6, (i2 & 64) != 0 ? topUpDetails2.PaymentSource : num, (i2 & 128) != 0 ? topUpDetails2.CNIC : str7);
    }

    public final String component1() {
        return this.updatedbalance;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.date;
    }

    public final String component4() {
        return this.MobileAccount;
    }

    public final String component5() {
        return this.Amount;
    }

    public final String component6() {
        return this.Email;
    }

    public final Integer component7() {
        return this.PaymentSource;
    }

    public final String component8() {
        return this.CNIC;
    }

    public final TopUpDetails copy(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7) {
        return new TopUpDetails(str, str2, str3, str4, str5, str6, num, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopUpDetails)) {
            return false;
        }
        TopUpDetails topUpDetails = (TopUpDetails) obj;
        return Intrinsics.areEqual((Object) this.updatedbalance, (Object) topUpDetails.updatedbalance) && Intrinsics.areEqual((Object) this.message, (Object) topUpDetails.message) && Intrinsics.areEqual((Object) this.date, (Object) topUpDetails.date) && Intrinsics.areEqual((Object) this.MobileAccount, (Object) topUpDetails.MobileAccount) && Intrinsics.areEqual((Object) this.Amount, (Object) topUpDetails.Amount) && Intrinsics.areEqual((Object) this.Email, (Object) topUpDetails.Email) && Intrinsics.areEqual((Object) this.PaymentSource, (Object) topUpDetails.PaymentSource) && Intrinsics.areEqual((Object) this.CNIC, (Object) topUpDetails.CNIC);
    }

    public int hashCode() {
        String str = this.updatedbalance;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.date;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.MobileAccount;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.Amount;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.Email;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.PaymentSource;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.CNIC;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode7 + i;
    }

    public TopUpDetails(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7) {
        this.updatedbalance = str;
        this.message = str2;
        this.date = str3;
        this.MobileAccount = str4;
        this.Amount = str5;
        this.Email = str6;
        this.PaymentSource = num;
        this.CNIC = str7;
    }

    public final String getUpdatedbalance() {
        return this.updatedbalance;
    }

    public final void setUpdatedbalance(String str) {
        this.updatedbalance = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final String getMobileAccount() {
        return this.MobileAccount;
    }

    public final void setMobileAccount(String str) {
        this.MobileAccount = str;
    }

    public final String getAmount() {
        return this.Amount;
    }

    public final void setAmount(String str) {
        this.Amount = str;
    }

    public final String getEmail() {
        return this.Email;
    }

    public final void setEmail(String str) {
        this.Email = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TopUpDetails(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Integer r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r10
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r11
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0027
        L_0x0026:
            r6 = r14
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002e
        L_0x002d:
            r7 = r15
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x003a
        L_0x0038:
            r8 = r16
        L_0x003a:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r2 = r17
        L_0x0041:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.TopUpDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getPaymentSource() {
        return this.PaymentSource;
    }

    public final void setPaymentSource(Integer num) {
        this.PaymentSource = num;
    }

    public final String getCNIC() {
        return this.CNIC;
    }

    public final void setCNIC(String str) {
        this.CNIC = str;
    }

    public TopUpDetails() {
        this("", (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, 254, (DefaultConstructorMarker) null);
    }

    public String toString() {
        return "{\"MobileAccount\":\"" + this.MobileAccount + "\",\"Email\":\"" + this.Email + "\",\"Amount\":\"" + this.Amount + "\",\"CNIC\":\"" + this.CNIC + "\",\"PaymentSource\":" + this.PaymentSource + '}';
    }
}
