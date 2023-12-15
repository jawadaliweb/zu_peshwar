package com.lmkt.zupeshawar.model.routeModels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/RoutesDetailsAppModel;", "", "originStationName", "", "destinationStationName", "esmtFare", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDestinationStationName", "()Ljava/lang/String;", "setDestinationStationName", "(Ljava/lang/String;)V", "getEsmtFare", "setEsmtFare", "getOriginStationName", "setOriginStationName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoutesDetailsAppModel.kt */
public final class RoutesDetailsAppModel {
    private String destinationStationName;
    private String esmtFare;
    private String originStationName;

    public static /* synthetic */ RoutesDetailsAppModel copy$default(RoutesDetailsAppModel routesDetailsAppModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = routesDetailsAppModel.originStationName;
        }
        if ((i & 2) != 0) {
            str2 = routesDetailsAppModel.destinationStationName;
        }
        if ((i & 4) != 0) {
            str3 = routesDetailsAppModel.esmtFare;
        }
        return routesDetailsAppModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.originStationName;
    }

    public final String component2() {
        return this.destinationStationName;
    }

    public final String component3() {
        return this.esmtFare;
    }

    public final RoutesDetailsAppModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "originStationName");
        Intrinsics.checkNotNullParameter(str2, "destinationStationName");
        Intrinsics.checkNotNullParameter(str3, "esmtFare");
        return new RoutesDetailsAppModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoutesDetailsAppModel)) {
            return false;
        }
        RoutesDetailsAppModel routesDetailsAppModel = (RoutesDetailsAppModel) obj;
        return Intrinsics.areEqual((Object) this.originStationName, (Object) routesDetailsAppModel.originStationName) && Intrinsics.areEqual((Object) this.destinationStationName, (Object) routesDetailsAppModel.destinationStationName) && Intrinsics.areEqual((Object) this.esmtFare, (Object) routesDetailsAppModel.esmtFare);
    }

    public int hashCode() {
        return (((this.originStationName.hashCode() * 31) + this.destinationStationName.hashCode()) * 31) + this.esmtFare.hashCode();
    }

    public String toString() {
        return "RoutesDetailsAppModel(originStationName=" + this.originStationName + ", destinationStationName=" + this.destinationStationName + ", esmtFare=" + this.esmtFare + ')';
    }

    public RoutesDetailsAppModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "originStationName");
        Intrinsics.checkNotNullParameter(str2, "destinationStationName");
        Intrinsics.checkNotNullParameter(str3, "esmtFare");
        this.originStationName = str;
        this.destinationStationName = str2;
        this.esmtFare = str3;
    }

    public final String getOriginStationName() {
        return this.originStationName;
    }

    public final void setOriginStationName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originStationName = str;
    }

    public final String getDestinationStationName() {
        return this.destinationStationName;
    }

    public final String getEsmtFare() {
        return this.esmtFare;
    }

    public final void setDestinationStationName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.destinationStationName = str;
    }

    public final void setEsmtFare(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.esmtFare = str;
    }
}
