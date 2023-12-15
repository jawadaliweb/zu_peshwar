package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzan;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzr implements zzan {
    final /* synthetic */ FirebaseUser zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzr(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzb = firebaseAuth;
        this.zza = firebaseUser;
    }

    public final void zza() {
        FirebaseAuth firebaseAuth = this.zzb;
        if (firebaseAuth.zzg != null && firebaseAuth.zzg.getUid().equalsIgnoreCase(this.zza.getUid())) {
            this.zzb.zzN();
        }
    }

    public final void zzb(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzb.signOut();
        }
    }
}
