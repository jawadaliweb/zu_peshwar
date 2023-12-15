package com.google.android.play.core.appupdate;

final class t extends AppUpdateOptions {
    private final int a;
    private final boolean b;

    /* synthetic */ t(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public final boolean allowAssetPackDeletion() {
        return this.b;
    }

    public final int appUpdateType() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            return this.a == appUpdateOptions.appUpdateType() && this.b == appUpdateOptions.allowAssetPackDeletion();
        }
    }

    public final int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.a;
        boolean z = this.b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
