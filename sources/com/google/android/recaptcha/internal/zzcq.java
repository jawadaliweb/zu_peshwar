package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcq {
    public static final zzcp zza = new zzcp((DefaultConstructorMarker) null);
    private int zzb;

    public zzcq(short s, short s2) {
        this.zzb = Math.abs(s);
    }

    public final short zza() {
        int i = ((this.zzb * 4391) + 277) % 32779;
        this.zzb = i;
        return (short) (i % 255);
    }
}
