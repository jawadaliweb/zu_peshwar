package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public enum zztv implements zzagm {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzagn zzg = null;
    private final int zzi;

    static {
        zzg = new zztu();
    }

    private zztv(int i) {
        this.zzi = i;
    }

    public static zztv zzb(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
