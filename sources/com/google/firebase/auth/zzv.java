package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzv implements Runnable {
    final /* synthetic */ FirebaseAuth zza;

    zzv(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.AuthStateListener onAuthStateChanged : this.zza.zze) {
            onAuthStateChanged.onAuthStateChanged(this.zza);
        }
    }
}
