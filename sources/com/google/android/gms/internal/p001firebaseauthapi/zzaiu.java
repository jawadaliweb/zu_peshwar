package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaiu extends RuntimeException {
    public zzaiu(zzahp zzahp) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzags zza() {
        return new zzags(getMessage());
    }
}
