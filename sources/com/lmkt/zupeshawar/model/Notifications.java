package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006$"}, d2 = {"Lcom/lmkt/zupeshawar/model/Notifications;", "Ljava/io/Serializable;", "()V", "notification", "", "datetime", "NotificatonTime", "NotificationDate", "isSectionHeader", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getNotificationDate", "()Ljava/lang/String;", "setNotificationDate", "(Ljava/lang/String;)V", "getNotificatonTime", "setNotificatonTime", "getDatetime", "setDatetime", "()Z", "setSectionHeader", "(Z)V", "getNotification", "setNotification", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Notifications.kt */
public final class Notifications implements Serializable {
    private String NotificationDate;
    private String NotificatonTime;
    @SerializedName("datetime")
    private String datetime;
    private boolean isSectionHeader;
    @SerializedName("notification")
    private String notification;

    public static /* synthetic */ Notifications copy$default(Notifications notifications, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notifications.notification;
        }
        if ((i & 2) != 0) {
            str2 = notifications.datetime;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = notifications.NotificatonTime;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = notifications.NotificationDate;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = notifications.isSectionHeader;
        }
        return notifications.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.notification;
    }

    public final String component2() {
        return this.datetime;
    }

    public final String component3() {
        return this.NotificatonTime;
    }

    public final String component4() {
        return this.NotificationDate;
    }

    public final boolean component5() {
        return this.isSectionHeader;
    }

    public final Notifications copy(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "notification");
        Intrinsics.checkNotNullParameter(str2, "datetime");
        Intrinsics.checkNotNullParameter(str3, "NotificatonTime");
        Intrinsics.checkNotNullParameter(str4, "NotificationDate");
        return new Notifications(str, str2, str3, str4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Notifications)) {
            return false;
        }
        Notifications notifications = (Notifications) obj;
        return Intrinsics.areEqual((Object) this.notification, (Object) notifications.notification) && Intrinsics.areEqual((Object) this.datetime, (Object) notifications.datetime) && Intrinsics.areEqual((Object) this.NotificatonTime, (Object) notifications.NotificatonTime) && Intrinsics.areEqual((Object) this.NotificationDate, (Object) notifications.NotificationDate) && this.isSectionHeader == notifications.isSectionHeader;
    }

    public int hashCode() {
        int hashCode = ((((((this.notification.hashCode() * 31) + this.datetime.hashCode()) * 31) + this.NotificatonTime.hashCode()) * 31) + this.NotificationDate.hashCode()) * 31;
        boolean z = this.isSectionHeader;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "Notifications(notification=" + this.notification + ", datetime=" + this.datetime + ", NotificatonTime=" + this.NotificatonTime + ", NotificationDate=" + this.NotificationDate + ", isSectionHeader=" + this.isSectionHeader + ')';
    }

    public Notifications(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "notification");
        Intrinsics.checkNotNullParameter(str2, "datetime");
        Intrinsics.checkNotNullParameter(str3, "NotificatonTime");
        Intrinsics.checkNotNullParameter(str4, "NotificationDate");
        this.notification = str;
        this.datetime = str2;
        this.NotificatonTime = str3;
        this.NotificationDate = str4;
        this.isSectionHeader = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Notifications(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0008
            r10 = r0
            goto L_0x0009
        L_0x0008:
            r10 = r4
        L_0x0009:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r5
        L_0x0010:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r6
        L_0x0017:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r7
        L_0x001d:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0024
            r8 = 0
            r9 = 0
            goto L_0x0025
        L_0x0024:
            r9 = r8
        L_0x0025:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.Notifications.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getNotification() {
        return this.notification;
    }

    public final void setNotification(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notification = str;
    }

    public final String getDatetime() {
        return this.datetime;
    }

    public final void setDatetime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.datetime = str;
    }

    public final String getNotificatonTime() {
        return this.NotificatonTime;
    }

    public final void setNotificatonTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.NotificatonTime = str;
    }

    public final String getNotificationDate() {
        return this.NotificationDate;
    }

    public final void setNotificationDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.NotificationDate = str;
    }

    public final boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    public final void setSectionHeader(boolean z) {
        this.isSectionHeader = z;
    }

    public Notifications() {
        this("", (String) null, (String) null, (String) null, false, 30, (DefaultConstructorMarker) null);
    }
}
