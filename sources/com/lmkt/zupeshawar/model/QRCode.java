package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/lmkt/zupeshawar/model/QRCode;", "Ljava/io/Serializable;", "()V", "qrImage", "", "qrTimer", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getQrImage", "()Ljava/lang/String;", "setQrImage", "(Ljava/lang/String;)V", "getQrTimer", "()Ljava/lang/Integer;", "setQrTimer", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/lmkt/zupeshawar/model/QRCode;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QRCode.kt */
public final class QRCode implements Serializable {
    @SerializedName("qrImage")
    private String qrImage;
    @SerializedName("qrTimer")
    private Integer qrTimer;

    public static /* synthetic */ QRCode copy$default(QRCode qRCode, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qRCode.qrImage;
        }
        if ((i & 2) != 0) {
            num = qRCode.qrTimer;
        }
        return qRCode.copy(str, num);
    }

    public final String component1() {
        return this.qrImage;
    }

    public final Integer component2() {
        return this.qrTimer;
    }

    public final QRCode copy(String str, Integer num) {
        return new QRCode(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QRCode)) {
            return false;
        }
        QRCode qRCode = (QRCode) obj;
        return Intrinsics.areEqual((Object) this.qrImage, (Object) qRCode.qrImage) && Intrinsics.areEqual((Object) this.qrTimer, (Object) qRCode.qrTimer);
    }

    public int hashCode() {
        String str = this.qrImage;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.qrTimer;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "QRCode(qrImage=" + this.qrImage + ", qrTimer=" + this.qrTimer + ')';
    }

    public QRCode(String str, Integer num) {
        this.qrImage = str;
        this.qrTimer = num;
    }

    public final String getQrImage() {
        return this.qrImage;
    }

    public final void setQrImage(String str) {
        this.qrImage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QRCode(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num);
    }

    public final Integer getQrTimer() {
        return this.qrTimer;
    }

    public final void setQrTimer(Integer num) {
        this.qrTimer = num;
    }

    public QRCode() {
        this("", (Integer) null, 2, (DefaultConstructorMarker) null);
    }
}
