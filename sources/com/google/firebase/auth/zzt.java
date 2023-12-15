package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzt implements Runnable {
    final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzt(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
