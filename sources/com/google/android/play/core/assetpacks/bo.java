package com.google.android.play.core.assetpacks;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

final class bo {
    private final Map<String, Double> a = new HashMap();

    bo() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str) {
        this.a.put(str, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }

    /* access modifiers changed from: package-private */
    public final synchronized double b(String str) {
        Double d = this.a.get(str);
        if (d == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d.doubleValue();
    }

    /* access modifiers changed from: package-private */
    public final synchronized double c(String str, cc ccVar) {
        double d;
        d = (((double) ((bi) ccVar).e) + 1.0d) / ((double) ((bi) ccVar).f);
        this.a.put(str, Double.valueOf(d));
        return d;
    }
}
