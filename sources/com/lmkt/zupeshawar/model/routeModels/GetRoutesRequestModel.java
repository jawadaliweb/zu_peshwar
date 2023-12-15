package com.lmkt.zupeshawar.model.routeModels;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/GetRoutesRequestModel;", "", "origin", "", "destination", "(II)V", "getDestination", "()I", "setDestination", "(I)V", "getOrigin", "setOrigin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GetRoutesRequestModel.kt */
public final class GetRoutesRequestModel {
    @SerializedName("destination")
    private int destination;
    @SerializedName("origin")
    private int origin;

    public static /* synthetic */ GetRoutesRequestModel copy$default(GetRoutesRequestModel getRoutesRequestModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = getRoutesRequestModel.origin;
        }
        if ((i3 & 2) != 0) {
            i2 = getRoutesRequestModel.destination;
        }
        return getRoutesRequestModel.copy(i, i2);
    }

    public final int component1() {
        return this.origin;
    }

    public final int component2() {
        return this.destination;
    }

    public final GetRoutesRequestModel copy(int i, int i2) {
        return new GetRoutesRequestModel(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetRoutesRequestModel)) {
            return false;
        }
        GetRoutesRequestModel getRoutesRequestModel = (GetRoutesRequestModel) obj;
        return this.origin == getRoutesRequestModel.origin && this.destination == getRoutesRequestModel.destination;
    }

    public int hashCode() {
        return (this.origin * 31) + this.destination;
    }

    public String toString() {
        return "GetRoutesRequestModel(origin=" + this.origin + ", destination=" + this.destination + ')';
    }

    public GetRoutesRequestModel(int i, int i2) {
        this.origin = i;
        this.destination = i2;
    }

    public final int getOrigin() {
        return this.origin;
    }

    public final void setOrigin(int i) {
        this.origin = i;
    }

    public final int getDestination() {
        return this.destination;
    }

    public final void setDestination(int i) {
        this.destination = i;
    }
}
