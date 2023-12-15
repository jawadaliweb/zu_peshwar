package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/lmkt/zupeshawar/model/TokenDetails;", "Ljava/io/Serializable;", "()V", "payload", "Lcom/lmkt/zupeshawar/model/Payload;", "token", "", "tokenExpirationTime", "userID", "(Lcom/lmkt/zupeshawar/model/Payload;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPayload", "()Lcom/lmkt/zupeshawar/model/Payload;", "setPayload", "(Lcom/lmkt/zupeshawar/model/Payload;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getTokenExpirationTime", "setTokenExpirationTime", "getUserID", "setUserID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: User.kt */
public final class TokenDetails implements Serializable {
    @SerializedName("payload")
    private Payload payload;
    @SerializedName("token")
    private String token;
    @SerializedName("tokenExpirationTime")
    private String tokenExpirationTime;
    @SerializedName("userID")
    private String userID;

    public static /* synthetic */ TokenDetails copy$default(TokenDetails tokenDetails, Payload payload2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            payload2 = tokenDetails.payload;
        }
        if ((i & 2) != 0) {
            str = tokenDetails.token;
        }
        if ((i & 4) != 0) {
            str2 = tokenDetails.tokenExpirationTime;
        }
        if ((i & 8) != 0) {
            str3 = tokenDetails.userID;
        }
        return tokenDetails.copy(payload2, str, str2, str3);
    }

    public final Payload component1() {
        return this.payload;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.tokenExpirationTime;
    }

    public final String component4() {
        return this.userID;
    }

    public final TokenDetails copy(Payload payload2, String str, String str2, String str3) {
        return new TokenDetails(payload2, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenDetails)) {
            return false;
        }
        TokenDetails tokenDetails = (TokenDetails) obj;
        return Intrinsics.areEqual((Object) this.payload, (Object) tokenDetails.payload) && Intrinsics.areEqual((Object) this.token, (Object) tokenDetails.token) && Intrinsics.areEqual((Object) this.tokenExpirationTime, (Object) tokenDetails.tokenExpirationTime) && Intrinsics.areEqual((Object) this.userID, (Object) tokenDetails.userID);
    }

    public int hashCode() {
        Payload payload2 = this.payload;
        int i = 0;
        int hashCode = (payload2 == null ? 0 : payload2.hashCode()) * 31;
        String str = this.token;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tokenExpirationTime;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userID;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "TokenDetails(payload=" + this.payload + ", token=" + this.token + ", tokenExpirationTime=" + this.tokenExpirationTime + ", userID=" + this.userID + ')';
    }

    public TokenDetails(Payload payload2, String str, String str2, String str3) {
        this.payload = payload2;
        this.token = str;
        this.tokenExpirationTime = str2;
        this.userID = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenDetails(Payload payload2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : payload2, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public final void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getTokenExpirationTime() {
        return this.tokenExpirationTime;
    }

    public final void setTokenExpirationTime(String str) {
        this.tokenExpirationTime = str;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    public TokenDetails() {
        this((Payload) null, (String) null, (String) null, "", 7, (DefaultConstructorMarker) null);
    }
}
