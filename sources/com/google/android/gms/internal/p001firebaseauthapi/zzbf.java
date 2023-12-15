package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbf implements zzca {
    private final OutputStream zza;

    private zzbf(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzca zza(OutputStream outputStream) {
        return new zzbf(outputStream);
    }

    public final void zzb(zzrl zzrl) throws IOException {
        throw null;
    }

    public final void zzc(zztc zztc) throws IOException {
        try {
            zztc.zzp(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
