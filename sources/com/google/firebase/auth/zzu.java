package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzu implements Runnable {
    final /* synthetic */ FirebaseAuth zza;
    final /* synthetic */ InternalTokenResult zzb;

    zzu(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zza = firebaseAuth;
        this.zzb = internalTokenResult;
    }

    public final void run() {
        for (IdTokenListener onIdTokenChanged : this.zza.zzd) {
            onIdTokenChanged.onIdTokenChanged(this.zzb);
        }
        for (FirebaseAuth.IdTokenListener onIdTokenChanged2 : this.zza.zzc) {
            onIdTokenChanged2.onIdTokenChanged(this.zza);
        }
    }
}
