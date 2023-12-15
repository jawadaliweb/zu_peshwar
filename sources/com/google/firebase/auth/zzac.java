package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.firebase.auth.internal.zzbw;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzac implements zzbw {
    final /* synthetic */ FirebaseAuth zza;

    zzac(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzade zzade, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzade);
        FirebaseAuth.zzS(this.zza, firebaseUser, zzade, true, true);
    }

    public final void zzb(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
            this.zza.signOut();
        }
    }
}
