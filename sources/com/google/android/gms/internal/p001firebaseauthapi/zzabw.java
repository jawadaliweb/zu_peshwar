package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzabw implements OnFailureListener {
    zzabw(zzaca zzaca) {
    }

    public final void onFailure(Exception exc) {
        zzaca.zza.e("SmsRetrieverClient failed to start: ".concat(String.valueOf(exc.getMessage())), new Object[0]);
    }
}
