package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzv extends zzz {
    final /* synthetic */ zzw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzw zzw, zzab zzab, CharSequence charSequence) {
        super(zzab, charSequence);
        this.zza = zzw;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzj zzj = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzu.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zzj.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
