package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
abstract class zzabg implements zzabi {
    Status zzA;
    /* access modifiers changed from: private */
    public boolean zza;
    protected final int zze;
    final zzabd zzf = new zzabd(this);
    protected FirebaseApp zzg;
    protected FirebaseUser zzh;
    protected Object zzi;
    protected zzao zzj;
    protected zzaaw zzk;
    protected final List zzl = new ArrayList();
    protected Executor zzm;
    protected zzade zzn;
    protected zzacv zzo;
    protected zzacj zzp;
    protected zzadn zzq;
    protected String zzr;
    protected String zzs;
    protected AuthCredential zzt;
    protected String zzu;
    protected String zzv;
    protected zzwn zzw;
    protected zzadd zzx;
    protected zzada zzy;
    Object zzz;

    public zzabg(int i) {
        this.zze = i;
    }

    static /* bridge */ /* synthetic */ void zzj(zzabg zzabg) {
        zzabg.zzb();
        Preconditions.checkState(zzabg.zza, "no success or failure set on method implementation");
    }

    static /* bridge */ /* synthetic */ void zzk(zzabg zzabg, Status status) {
        zzao zzao = zzabg.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzabg zzd(Object obj) {
        this.zzi = Preconditions.checkNotNull(obj, "external callback cannot be null");
        return this;
    }

    public final zzabg zze(zzao zzao) {
        this.zzj = (zzao) Preconditions.checkNotNull(zzao, "external failure callback cannot be null");
        return this;
    }

    public final zzabg zzf(FirebaseApp firebaseApp) {
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzabg zzg(FirebaseUser firebaseUser) {
        this.zzh = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzabg zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzabu.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzl) {
            this.zzl.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zza2));
        }
        if (activity != null) {
            zzaax.zza(activity, this.zzl);
        }
        this.zzm = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzA = status;
        this.zzk.zza((Object) null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzz = obj;
        this.zzk.zza(obj, (Status) null);
    }
}
