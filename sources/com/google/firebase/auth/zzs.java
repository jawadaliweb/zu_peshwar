package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzs implements Runnable {
    final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzs(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener;
    }

    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
