package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcl implements zzby {
    public static final zzcl zza = new zzcl();

    private zzcl() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        if (objArr.length == 1) {
            Byte b = objArr[0];
            if (true != (b instanceof Byte)) {
                b = null;
            }
            Byte b2 = b;
            if (b2 != null) {
                zzbl.zzh(b2.byteValue());
                return;
            }
            throw new zzt(4, 5, (Throwable) null);
        }
        throw new zzt(4, 3, (Throwable) null);
    }
}
