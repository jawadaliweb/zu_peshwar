package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzagq {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzafl zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzafl.zzd;
        zzf = zzafl.zzH(bArr, 0, 0, false);
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzc(Object obj, String str) {
        Objects.requireNonNull(obj, str);
        return obj;
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
