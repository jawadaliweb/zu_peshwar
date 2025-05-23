package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzr {
    public static final zzq zza = new zzq((DefaultConstructorMarker) null);
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    public zzr() {
        this((String) null, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ zzr(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.zzb = "https://www.recaptcha.net/recaptcha/api3";
        this.zzc = "https://www.recaptcha.net/recaptcha/api3".concat("/mwv");
        this.zzd = "https://www.recaptcha.net/recaptcha/api3".concat("/mlg");
        this.zze = "https://www.recaptcha.net/recaptcha/api3".concat("/mal");
    }

    public final String zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzd;
    }
}
