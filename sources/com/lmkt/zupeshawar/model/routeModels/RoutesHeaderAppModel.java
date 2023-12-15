package com.lmkt.zupeshawar.model.routeModels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/lmkt/zupeshawar/model/routeModels/RoutesHeaderAppModel;", "", "originStationName", "", "destinationStationName", "esmtTime", "esmtFare", "totalRoutes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDestinationStationName", "()Ljava/lang/String;", "setDestinationStationName", "(Ljava/lang/String;)V", "getEsmtFare", "setEsmtFare", "getEsmtTime", "setEsmtTime", "getOriginStationName", "setOriginStationName", "getTotalRoutes", "setTotalRoutes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoutesHeaderAppModel.kt */
public final class RoutesHeaderAppModel {
    private String destinationStationName;
    private String esmtFare;
    private String esmtTime;
    private String originStationName;
    private String totalRoutes;

    public static /* synthetic */ RoutesHeaderAppModel copy$default(RoutesHeaderAppModel routesHeaderAppModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = routesHeaderAppModel.originStationName;
        }
        if ((i & 2) != 0) {
            str2 = routesHeaderAppModel.destinationStationName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = routesHeaderAppModel.esmtTime;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = routesHeaderAppModel.esmtFare;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = routesHeaderAppModel.totalRoutes;
        }
        return routesHeaderAppModel.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.originStationName;
    }

    public final String component2() {
        return this.destinationStationName;
    }

    public final String component3() {
        return this.esmtTime;
    }

    public final String component4() {
        return this.esmtFare;
    }

    public final String component5() {
        return this.totalRoutes;
    }

    public final RoutesHeaderAppModel copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "originStationName");
        Intrinsics.checkNotNullParameter(str2, "destinationStationName");
        Intrinsics.checkNotNullParameter(str3, "esmtTime");
        Intrinsics.checkNotNullParameter(str4, "esmtFare");
        Intrinsics.checkNotNullParameter(str5, "totalRoutes");
        return new RoutesHeaderAppModel(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoutesHeaderAppModel)) {
            return false;
        }
        RoutesHeaderAppModel routesHeaderAppModel = (RoutesHeaderAppModel) obj;
        return Intrinsics.areEqual((Object) this.originStationName, (Object) routesHeaderAppModel.originStationName) && Intrinsics.areEqual((Object) this.destinationStationName, (Object) routesHeaderAppModel.destinationStationName) && Intrinsics.areEqual((Object) this.esmtTime, (Object) routesHeaderAppModel.esmtTime) && Intrinsics.areEqual((Object) this.esmtFare, (Object) routesHeaderAppModel.esmtFare) && Intrinsics.areEqual((Object) this.totalRoutes, (Object) routesHeaderAppModel.totalRoutes);
    }

    public int hashCode() {
        return (((((((this.originStationName.hashCode() * 31) + this.destinationStationName.hashCode()) * 31) + this.esmtTime.hashCode()) * 31) + this.esmtFare.hashCode()) * 31) + this.totalRoutes.hashCode();
    }

    public String toString() {
        return "RoutesHeaderAppModel(originStationName=" + this.originStationName + ", destinationStationName=" + this.destinationStationName + ", esmtTime=" + this.esmtTime + ", esmtFare=" + this.esmtFare + ", totalRoutes=" + this.totalRoutes + ')';
    }

    public RoutesHeaderAppModel(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "originStationName");
        Intrinsics.checkNotNullParameter(str2, "destinationStationName");
        Intrinsics.checkNotNullParameter(str3, "esmtTime");
        Intrinsics.checkNotNullParameter(str4, "esmtFare");
        Intrinsics.checkNotNullParameter(str5, "totalRoutes");
        this.originStationName = str;
        this.destinationStationName = str2;
        this.esmtTime = str3;
        this.esmtFare = str4;
        this.totalRoutes = str5;
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

    public final void setDestinationStationName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.destinationStationName = str;
    }

    public final String getEsmtTime() {
        return this.esmtTime;
    }

    public final void setEsmtTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.esmtTime = str;
    }

    public final String getEsmtFare() {
        return this.esmtFare;
    }

    public final void setEsmtFare(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.esmtFare = str;
    }

    public final String getTotalRoutes() {
        return this.totalRoutes;
    }

    public final void setTotalRoutes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalRoutes = str;
    }
}
