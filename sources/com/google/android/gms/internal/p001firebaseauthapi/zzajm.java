package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public enum zzajm {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzaff.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zzajm(Object obj) {
        this.zzk = obj;
    }
}
