package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005BM\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001dHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0005R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0005R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0005R \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0005¨\u0006+"}, d2 = {"Lcom/lmkt/zupeshawar/model/RechargeHistory;", "Ljava/io/Serializable;", "", "transactionDate", "", "(Ljava/lang/String;)V", "userID", "amount", "source", "mobileAccount", "isSectionHeader", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "()Ljava/lang/Boolean;", "setSectionHeader", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMobileAccount", "setMobileAccount", "getSource", "setSource", "getTransactionDate", "setTransactionDate", "getUserID", "setUserID", "compareTo", "", "other", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/lmkt/zupeshawar/model/RechargeHistory;", "equals", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RechargeHistory.kt */
public final class RechargeHistory implements Serializable, Comparable<RechargeHistory> {
    @SerializedName("amount")
    private String amount;
    @SerializedName("isSectionHeader")
    private Boolean isSectionHeader;
    @SerializedName("mobileAccount")
    private String mobileAccount;
    @SerializedName("source")
    private String source;
    @SerializedName("transactionDate")
    private String transactionDate;
    @SerializedName("userID")
    private String userID;

    public RechargeHistory() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RechargeHistory copy$default(RechargeHistory rechargeHistory, String str, String str2, String str3, String str4, String str5, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rechargeHistory.userID;
        }
        if ((i & 2) != 0) {
            str2 = rechargeHistory.amount;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = rechargeHistory.source;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = rechargeHistory.mobileAccount;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = rechargeHistory.transactionDate;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            bool = rechargeHistory.isSectionHeader;
        }
        return rechargeHistory.copy(str, str6, str7, str8, str9, bool);
    }

    public final String component1() {
        return this.userID;
    }

    public final String component2() {
        return this.amount;
    }

    public final String component3() {
        return this.source;
    }

    public final String component4() {
        return this.mobileAccount;
    }

    public final String component5() {
        return this.transactionDate;
    }

    public final Boolean component6() {
        return this.isSectionHeader;
    }

    public final RechargeHistory copy(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        return new RechargeHistory(str, str2, str3, str4, str5, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RechargeHistory)) {
            return false;
        }
        RechargeHistory rechargeHistory = (RechargeHistory) obj;
        return Intrinsics.areEqual((Object) this.userID, (Object) rechargeHistory.userID) && Intrinsics.areEqual((Object) this.amount, (Object) rechargeHistory.amount) && Intrinsics.areEqual((Object) this.source, (Object) rechargeHistory.source) && Intrinsics.areEqual((Object) this.mobileAccount, (Object) rechargeHistory.mobileAccount) && Intrinsics.areEqual((Object) this.transactionDate, (Object) rechargeHistory.transactionDate) && Intrinsics.areEqual((Object) this.isSectionHeader, (Object) rechargeHistory.isSectionHeader);
    }

    public int hashCode() {
        String str = this.userID;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.source;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mobileAccount;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.transactionDate;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isSectionHeader;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "RechargeHistory(userID=" + this.userID + ", amount=" + this.amount + ", source=" + this.source + ", mobileAccount=" + this.mobileAccount + ", transactionDate=" + this.transactionDate + ", isSectionHeader=" + this.isSectionHeader + ')';
    }

    public RechargeHistory(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.userID = str;
        this.amount = str2;
        this.source = str3;
        this.mobileAccount = str4;
        this.transactionDate = str5;
        this.isSectionHeader = bool;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getMobileAccount() {
        return this.mobileAccount;
    }

    public final void setMobileAccount(String str) {
        this.mobileAccount = str;
    }

    public final String getTransactionDate() {
        return this.transactionDate;
    }

    public final void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RechargeHistory(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0008
            r12 = r0
            goto L_0x0009
        L_0x0008:
            r12 = r5
        L_0x0009:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r9
        L_0x0024:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002d
            r5 = 0
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)
        L_0x002d:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r3
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.RechargeHistory.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    public final void setSectionHeader(Boolean bool) {
        this.isSectionHeader = bool;
    }

    public RechargeHistory(String str) {
        this((String) null, (String) null, (String) null, (String) null, str, (Boolean) null, 32, (DefaultConstructorMarker) null);
    }

    public int compareTo(RechargeHistory rechargeHistory) {
        Intrinsics.checkNotNullParameter(rechargeHistory, "other");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
