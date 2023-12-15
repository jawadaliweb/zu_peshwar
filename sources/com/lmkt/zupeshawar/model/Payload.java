package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/lmkt/zupeshawar/model/Payload;", "Ljava/io/Serializable;", "()V", "imei", "", "userid", "(Ljava/lang/String;Ljava/lang/String;)V", "getImei", "()Ljava/lang/String;", "setImei", "(Ljava/lang/String;)V", "getUserid", "setUserid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: User.kt */
public final class Payload implements Serializable {
    @SerializedName("imei")
    private String imei;
    @SerializedName("userid")
    private String userid;

    public static /* synthetic */ Payload copy$default(Payload payload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payload.imei;
        }
        if ((i & 2) != 0) {
            str2 = payload.userid;
        }
        return payload.copy(str, str2);
    }

    public final String component1() {
        return this.imei;
    }

    public final String component2() {
        return this.userid;
    }

    public final Payload copy(String str, String str2) {
        return new Payload(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) obj;
        return Intrinsics.areEqual((Object) this.imei, (Object) payload.imei) && Intrinsics.areEqual((Object) this.userid, (Object) payload.userid);
    }

    public int hashCode() {
        String str = this.imei;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userid;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Payload(imei=" + this.imei + ", userid=" + this.userid + ')';
    }

    public Payload(String str, String str2) {
        this.imei = str;
        this.userid = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Payload(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final String getUserid() {
        return this.userid;
    }

    public final void setUserid(String str) {
        this.userid = str;
    }

    public Payload() {
        this((String) null, "", 1, (DefaultConstructorMarker) null);
    }
}
