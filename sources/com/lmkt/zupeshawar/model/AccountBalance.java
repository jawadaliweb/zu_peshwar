package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lmkt/zupeshawar/model/AccountBalance;", "Ljava/io/Serializable;", "()V", "accountBalance", "", "userID", "lastUpdatedOn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountBalance", "()Ljava/lang/String;", "setAccountBalance", "(Ljava/lang/String;)V", "getLastUpdatedOn", "setLastUpdatedOn", "getUserID", "setUserID", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AccountBalance.kt */
public final class AccountBalance implements Serializable {
    @SerializedName("accountBalance")
    private String accountBalance;
    @SerializedName("lastUpdatedOn")
    private String lastUpdatedOn;
    @SerializedName("userID")
    private String userID;

    public static /* synthetic */ AccountBalance copy$default(AccountBalance accountBalance2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountBalance2.accountBalance;
        }
        if ((i & 2) != 0) {
            str2 = accountBalance2.userID;
        }
        if ((i & 4) != 0) {
            str3 = accountBalance2.lastUpdatedOn;
        }
        return accountBalance2.copy(str, str2, str3);
    }

    public final String component1() {
        return this.accountBalance;
    }

    public final String component2() {
        return this.userID;
    }

    public final String component3() {
        return this.lastUpdatedOn;
    }

    public final AccountBalance copy(String str, String str2, String str3) {
        return new AccountBalance(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountBalance)) {
            return false;
        }
        AccountBalance accountBalance2 = (AccountBalance) obj;
        return Intrinsics.areEqual((Object) this.accountBalance, (Object) accountBalance2.accountBalance) && Intrinsics.areEqual((Object) this.userID, (Object) accountBalance2.userID) && Intrinsics.areEqual((Object) this.lastUpdatedOn, (Object) accountBalance2.lastUpdatedOn);
    }

    public int hashCode() {
        String str = this.accountBalance;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userID;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastUpdatedOn;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AccountBalance(accountBalance=" + this.accountBalance + ", userID=" + this.userID + ", lastUpdatedOn=" + this.lastUpdatedOn + ')';
    }

    public AccountBalance(String str, String str2, String str3) {
        this.accountBalance = str;
        this.userID = str2;
        this.lastUpdatedOn = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountBalance(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getAccountBalance() {
        return this.accountBalance;
    }

    public final void setAccountBalance(String str) {
        this.accountBalance = str;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    public final String getLastUpdatedOn() {
        return this.lastUpdatedOn;
    }

    public final void setLastUpdatedOn(String str) {
        this.lastUpdatedOn = str;
    }

    public AccountBalance() {
        this("", (String) null, (String) null, 6, (DefaultConstructorMarker) null);
    }
}
