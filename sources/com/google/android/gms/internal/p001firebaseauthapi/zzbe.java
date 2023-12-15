package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbe {
    private final InputStream zza;

    private zzbe(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzbe zzc(byte[] bArr) {
        return new zzbe(new ByteArrayInputStream(bArr));
    }

    public final zzrl zza() throws IOException {
        try {
            return zzrl.zzc(this.zza, zzafx.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zztc zzb() throws IOException {
        try {
            return zztc.zzf(this.zza, zzafx.zza());
        } finally {
            this.zza.close();
        }
    }
}
