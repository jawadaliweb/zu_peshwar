package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzx extends zzz {
    final /* synthetic */ zzl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzy zzy, zzab zzab, CharSequence charSequence, zzl zzl) {
        super(zzab, charSequence);
        this.zza = zzl;
    }

    public final int zzc(int i) {
        return ((zzo) this.zza).zza.end();
    }

    public final int zzd(int i) {
        if (((zzo) this.zza).zza.find(i)) {
            return ((zzo) this.zza).zza.start();
        }
        return -1;
    }
}
