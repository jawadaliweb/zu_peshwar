package com.lmkt.zupeshawar.networkManager;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J<\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0007\u001a\u00028\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/lmkt/zupeshawar/networkManager/GenericResponseModel;", "T", "", "status", "", "message", "", "result", "error", "(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getMessage", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Z", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/lmkt/zupeshawar/networkManager/GenericResponseModel;", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GenericResponseModel.kt */
public final class GenericResponseModel<T> {
    @SerializedName("error")
    private final String error;
    @SerializedName("message")
    private final String message;
    @SerializedName("data")
    private final T result;
    @SerializedName("status")
    private final boolean status;

    public static /* synthetic */ GenericResponseModel copy$default(GenericResponseModel genericResponseModel, boolean z, String str, T t, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = genericResponseModel.status;
        }
        if ((i & 2) != 0) {
            str = genericResponseModel.message;
        }
        if ((i & 4) != 0) {
            t = genericResponseModel.result;
        }
        if ((i & 8) != 0) {
            str2 = genericResponseModel.error;
        }
        return genericResponseModel.copy(z, str, t, str2);
    }

    public final boolean component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final T component3() {
        return this.result;
    }

    public final String component4() {
        return this.error;
    }

    public final GenericResponseModel<T> copy(boolean z, String str, T t, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        return new GenericResponseModel<>(z, str, t, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericResponseModel)) {
            return false;
        }
        GenericResponseModel genericResponseModel = (GenericResponseModel) obj;
        return this.status == genericResponseModel.status && Intrinsics.areEqual((Object) this.message, (Object) genericResponseModel.message) && Intrinsics.areEqual((Object) this.result, (Object) genericResponseModel.result) && Intrinsics.areEqual((Object) this.error, (Object) genericResponseModel.error);
    }

    public int hashCode() {
        boolean z = this.status;
        if (z) {
            z = true;
        }
        int hashCode = (((z ? 1 : 0) * true) + this.message.hashCode()) * 31;
        T t = this.result;
        return ((hashCode + (t == null ? 0 : t.hashCode())) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "GenericResponseModel(status=" + this.status + ", message=" + this.message + ", result=" + this.result + ", error=" + this.error + ')';
    }

    public GenericResponseModel(boolean z, String str, T t, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        this.status = z;
        this.message = str;
        this.result = t;
        this.error = str2;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final T getResult() {
        return this.result;
    }

    public final String getError() {
        return this.error;
    }
}
