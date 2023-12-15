package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.firebase.auth.internal.zzbw;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzw implements zzbw {
    final /* synthetic */ FirebaseAuth zza;

    zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzade zzade, FirebaseUser firebaseUser) {
        FirebaseAuth.zzS(this.zza, firebaseUser, zzade, true, true);
    }

    public final void zzb(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
