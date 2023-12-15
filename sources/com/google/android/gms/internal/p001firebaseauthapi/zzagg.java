package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzagg;
import com.google.android.gms.internal.p001firebaseauthapi.zzagk;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzagg<MessageType extends zzagk<MessageType, BuilderType>, BuilderType extends zzagg<MessageType, BuilderType>> extends zzaeo<MessageType, BuilderType> {
    protected zzagk zza;
    private final zzagk zzb;

    protected zzagg(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzw();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzahx.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final /* synthetic */ zzahp zzM() {
        throw null;
    }

    /* renamed from: zzg */
    public final zzagg zzf() {
        zzagg zzagg = (zzagg) this.zzb.zzj(5, (Object) null, (Object) null);
        zzagg.zza = zzk();
        return zzagg;
    }

    public final zzagg zzh(zzagk zzagk) {
        if (!this.zzb.equals(zzagk)) {
            if (!this.zza.zzL()) {
                zzn();
            }
            zza(this.zza, zzagk);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType zzj = zzk();
        if (zzj.zzK()) {
            return zzj;
        }
        throw new zzaiu(zzj);
    }

    /* renamed from: zzj */
    public MessageType zzk() {
        if (!this.zza.zzL()) {
            return this.zza;
        }
        this.zza.zzF();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        if (!this.zza.zzL()) {
            zzn();
        }
    }

    /* access modifiers changed from: protected */
    public void zzn() {
        zzagk zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
