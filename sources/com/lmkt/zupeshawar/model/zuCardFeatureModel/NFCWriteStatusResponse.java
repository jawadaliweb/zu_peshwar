package com.lmkt.zupeshawar.model.zuCardFeatureModel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006#"}, d2 = {"Lcom/lmkt/zupeshawar/model/zuCardFeatureModel/NFCWriteStatusResponse;", "", "cardNumber", "", "WalletUpdatedBalance", "", "cardUpdatedBalance", "TransID", "maC2", "(Ljava/lang/String;IIILjava/lang/String;)V", "getTransID", "()I", "setTransID", "(I)V", "getWalletUpdatedBalance", "setWalletUpdatedBalance", "getCardNumber", "()Ljava/lang/String;", "setCardNumber", "(Ljava/lang/String;)V", "getCardUpdatedBalance", "setCardUpdatedBalance", "getMaC2", "setMaC2", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NFCWriteStatusResponse.kt */
public final class NFCWriteStatusResponse {
    @SerializedName("transactionID")
    private int TransID;
    @SerializedName("walletUpdatedBalance")
    private int WalletUpdatedBalance;
    @SerializedName("cardNumber")
    private String cardNumber;
    @SerializedName("cardUpdatedBalance")
    private int cardUpdatedBalance;
    @SerializedName("maC2")
    private String maC2;

    public static /* synthetic */ NFCWriteStatusResponse copy$default(NFCWriteStatusResponse nFCWriteStatusResponse, String str, int i, int i2, int i3, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = nFCWriteStatusResponse.cardNumber;
        }
        if ((i4 & 2) != 0) {
            i = nFCWriteStatusResponse.WalletUpdatedBalance;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = nFCWriteStatusResponse.cardUpdatedBalance;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = nFCWriteStatusResponse.TransID;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            str2 = nFCWriteStatusResponse.maC2;
        }
        return nFCWriteStatusResponse.copy(str, i5, i6, i7, str2);
    }

    public final String component1() {
        return this.cardNumber;
    }

    public final int component2() {
        return this.WalletUpdatedBalance;
    }

    public final int component3() {
        return this.cardUpdatedBalance;
    }

    public final int component4() {
        return this.TransID;
    }

    public final String component5() {
        return this.maC2;
    }

    public final NFCWriteStatusResponse copy(String str, int i, int i2, int i3, String str2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "maC2");
        return new NFCWriteStatusResponse(str, i, i2, i3, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NFCWriteStatusResponse)) {
            return false;
        }
        NFCWriteStatusResponse nFCWriteStatusResponse = (NFCWriteStatusResponse) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) nFCWriteStatusResponse.cardNumber) && this.WalletUpdatedBalance == nFCWriteStatusResponse.WalletUpdatedBalance && this.cardUpdatedBalance == nFCWriteStatusResponse.cardUpdatedBalance && this.TransID == nFCWriteStatusResponse.TransID && Intrinsics.areEqual((Object) this.maC2, (Object) nFCWriteStatusResponse.maC2);
    }

    public int hashCode() {
        return (((((((this.cardNumber.hashCode() * 31) + this.WalletUpdatedBalance) * 31) + this.cardUpdatedBalance) * 31) + this.TransID) * 31) + this.maC2.hashCode();
    }

    public String toString() {
        return "NFCWriteStatusResponse(cardNumber=" + this.cardNumber + ", WalletUpdatedBalance=" + this.WalletUpdatedBalance + ", cardUpdatedBalance=" + this.cardUpdatedBalance + ", TransID=" + this.TransID + ", maC2=" + this.maC2 + ')';
    }

    public NFCWriteStatusResponse(String str, int i, int i2, int i3, String str2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "maC2");
        this.cardNumber = str;
        this.WalletUpdatedBalance = i;
        this.cardUpdatedBalance = i2;
        this.TransID = i3;
        this.maC2 = str2;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNumber = str;
    }

    public final int getWalletUpdatedBalance() {
        return this.WalletUpdatedBalance;
    }

    public final void setWalletUpdatedBalance(int i) {
        this.WalletUpdatedBalance = i;
    }

    public final int getCardUpdatedBalance() {
        return this.cardUpdatedBalance;
    }

    public final void setCardUpdatedBalance(int i) {
        this.cardUpdatedBalance = i;
    }

    public final int getTransID() {
        return this.TransID;
    }

    public final void setTransID(int i) {
        this.TransID = i;
    }

    public final String getMaC2() {
        return this.maC2;
    }

    public final void setMaC2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maC2 = str;
    }
}
