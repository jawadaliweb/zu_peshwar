package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public enum zzajl {
    DOUBLE(zzajm.DOUBLE, 1),
    FLOAT(zzajm.FLOAT, 5),
    INT64(zzajm.LONG, 0),
    UINT64(zzajm.LONG, 0),
    INT32(zzajm.INT, 0),
    FIXED64(zzajm.LONG, 1),
    FIXED32(zzajm.INT, 5),
    BOOL(zzajm.BOOLEAN, 0),
    STRING(zzajm.STRING, 2),
    GROUP(zzajm.MESSAGE, 3),
    MESSAGE(zzajm.MESSAGE, 2),
    BYTES(zzajm.BYTE_STRING, 2),
    UINT32(zzajm.INT, 0),
    ENUM(zzajm.ENUM, 0),
    SFIXED32(zzajm.INT, 5),
    SFIXED64(zzajm.LONG, 1),
    SINT32(zzajm.INT, 0),
    SINT64(zzajm.LONG, 0);
    
    private final zzajm zzt;

    private zzajl(zzajm zzajm, int i) {
        this.zzt = zzajm;
    }

    public final zzajm zza() {
        return this.zzt;
    }
}
