package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

final class s extends AppUpdateOptions.Builder {
    private Integer a;
    private Boolean b;

    s() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new t(this.a.intValue(), this.b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }
}
