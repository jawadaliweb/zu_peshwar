package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzvo extends ThreadLocal {
    final /* synthetic */ zzvp zza;

    zzvo(zzvp zzvp) {
        this.zza = zzvp;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzvc.zzb.zza(this.zza.zzb);
            mac.init(this.zza.zzc);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
