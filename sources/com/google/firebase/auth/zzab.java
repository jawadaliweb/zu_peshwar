package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.firebase.auth.internal.zzg;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
class zzab implements zzg {
    final /* synthetic */ FirebaseAuth zza;

    zzab(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzade zzade, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzade);
        this.zza.zzP(firebaseUser, zzade, true);
    }
}
