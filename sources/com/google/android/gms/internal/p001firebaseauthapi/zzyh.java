package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzyh {
    /* access modifiers changed from: private */
    public final zzabm zza;

    public zzyh(zzabm zzabm) {
        this.zza = (zzabm) Preconditions.checkNotNull(zzabm);
    }

    private final void zzO(String str, zzabl zzabl) {
        Preconditions.checkNotNull(zzabl);
        Preconditions.checkNotEmpty(str);
        zzade zzd = zzade.zzd(str);
        if (zzd.zzj()) {
            zzabl.zzb(zzd);
            return;
        }
        this.zza.zzd(new zzacs(zzd.zzf()), new zzyg(this, zzabl));
    }

    /* access modifiers changed from: private */
    public final void zzP(zzacl zzacl, zzaae zzaae) {
        Preconditions.checkNotNull(zzacl);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzc(zzacl, new zzwr(this, zzaae));
    }

    /* access modifiers changed from: private */
    public final void zzQ(zzade zzade, String str, String str2, Boolean bool, zze zze, zzaae zzaae, zzabk zzabk) {
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(zzabk);
        Preconditions.checkNotNull(zzaae);
        this.zza.zze(new zzact(zzade.zze()), new zzwu(this, zzabk, str2, str, bool, zze, zzaae, zzade));
    }

    private final void zzR(zzacx zzacx, zzaae zzaae) {
        Preconditions.checkNotNull(zzacx);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzf(zzacx, new zzxz(this, zzaae));
    }

    static /* bridge */ /* synthetic */ void zzd(zzyh zzyh, zzaee zzaee, zzaae zzaae, zzabk zzabk) {
        Status status;
        if (zzaee.zzp()) {
            zze zzc = zzaee.zzc();
            String zzd = zzaee.zzd();
            String zzk = zzaee.zzk();
            if (zzaee.zzn()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzai.zza(zzaee.zze());
            }
            zzaae.zze(new zzwm(status, zzc, zzd, zzk));
            return;
        }
        zzyh.zzQ(new zzade(zzaee.zzj(), zzaee.zzf(), Long.valueOf(zzaee.zzb()), "Bearer"), zzaee.zzi(), zzaee.zzh(), Boolean.valueOf(zzaee.zzo()), zzaee.zzc(), zzaae, zzabk);
    }

    static /* bridge */ /* synthetic */ void zze(zzyh zzyh, zzaae zzaae, zzade zzade, zzadq zzadq, zzabk zzabk) {
        Preconditions.checkNotNull(zzaae);
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(zzadq);
        Preconditions.checkNotNull(zzabk);
        zzyh.zza.zze(new zzact(zzade.zze()), new zzws(zzyh, zzabk, zzaae, zzade, zzadq));
    }

    static /* bridge */ /* synthetic */ void zzf(zzyh zzyh, zzaae zzaae, zzade zzade, zzacv zzacv, zzadq zzadq, zzabk zzabk) {
        Preconditions.checkNotNull(zzaae);
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(zzacv);
        Preconditions.checkNotNull(zzadq);
        Preconditions.checkNotNull(zzabk);
        zzyh.zza.zzl(zzadq, new zzwt(zzyh, zzadq, zzacv, zzaae, zzade, zzabk));
    }

    public final void zzA(zzaec zzaec, zzaae zzaae) {
        Preconditions.checkNotNull(zzaec);
        Preconditions.checkNotNull(zzaae);
        zzaec.zzd(true);
        this.zza.zzp(zzaec, new zzya(this, zzaae));
    }

    public final void zzB(zzaef zzaef, zzaae zzaae) {
        Preconditions.checkNotNull(zzaef);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzq(zzaef, new zzxn(this, zzaae));
    }

    public final void zzC(String str, String str2, String str3, String str4, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzr(new zzaeh(str, str2, str3, str4), new zzwp(this, zzaae));
    }

    public final void zzD(EmailAuthCredential emailAuthCredential, String str, zzaae zzaae) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzaae);
        if (emailAuthCredential.zzh()) {
            zzO(emailAuthCredential.zzc(), new zzwq(this, emailAuthCredential, str, zzaae));
        } else {
            zzP(new zzacl(emailAuthCredential, (String) null, str), zzaae);
        }
    }

    public final void zzE(zzaej zzaej, zzaae zzaae) {
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzs(zzaej, new zzxb(this, zzaae));
    }

    public final void zzF(zzadv zzadv, zzaae zzaae) {
        Preconditions.checkNotNull(zzadv);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzo(zzadv, new zzxr(this, zzaae));
    }

    public final void zzG(String str, String str2, String str3, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxl(this, str2, str3, zzaae));
    }

    public final void zzH(String str, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxh(this, zzaae));
    }

    public final void zzI(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        zzO(str2, new zzxj(this, str, zzaae));
    }

    public final void zzJ(String str, UserProfileChangeRequest userProfileChangeRequest, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzyc(this, userProfileChangeRequest, zzaae));
    }

    public final void zzK(zzacx zzacx, zzaae zzaae) {
        zzR(zzacx, zzaae);
    }

    public final void zzL(zzacp zzacp, String str, zzaae zzaae) {
        Preconditions.checkNotNull(zzacp);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxp(this, zzacp, zzaae));
    }

    public final void zzM(zzadx zzadx, zzaae zzaae) {
        Preconditions.checkNotNull(zzadx);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzv(zzadx, new zzxm(this, zzaae));
    }

    public final void zzN(zzacq zzacq, zzaae zzaae) {
        Preconditions.checkNotNull(zzacq);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzw(zzacq, new zzxq(this, zzaae));
    }

    public final void zzg(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzadq zzadq = new zzadq();
        zzadq.zzf(str);
        zzadq.zzi(str2);
        this.zza.zzl(zzadq, new zzyf(this, zzaae));
    }

    public final void zzh(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzyd(this, str2, zzaae));
    }

    public final void zzi(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzye(this, str2, zzaae));
    }

    public final void zzj(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzj(new zzadm(str, (String) null, str2), new zzwx(this, zzaae));
    }

    public final void zzk(String str, String str2, String str3, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzj(new zzadm(str, str2, str3), new zzwz(this, zzaae));
    }

    public final void zzl(String str, String str2, String str3, String str4, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzn(new zzads(str, str2, (String) null, str3, str4), new zzwo(this, zzaae));
    }

    public final void zzm(String str, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxx(this, zzaae));
    }

    public final void zzn(String str, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzd(new zzacs(str), new zzwy(this, zzaae));
    }

    public final void zzo(zzacz zzacz, zzaae zzaae) {
        Preconditions.checkNotNull(zzacz);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzg(zzacz, new zzxt(this, zzaae));
    }

    public final void zzp(String str, String str2, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        this.zza.zza(new zzaci(str, str2), new zzwv(this, zzaae));
    }

    public final void zzq(zzadc zzadc, zzaae zzaae) {
        Preconditions.checkNotNull(zzadc);
        Preconditions.checkNotNull(zzaae);
        this.zza.zzh(zzadc, new zzxs(this, zzaae));
    }

    public final void zzr(String str, String str2, String str3, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaae);
        zzO(str3, new zzxc(this, str, str2, zzaae));
    }

    public final void zzs(String str, zzaec zzaec, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaec);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxg(this, zzaec, zzaae));
    }

    public final void zzt(String str, zzaej zzaej, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxe(this, zzaej, zzaae));
    }

    public final void zzu(String str, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzO(str, new zzxv(this, zzaae));
    }

    public final void zzv(String str, ActionCodeSettings actionCodeSettings, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzacx zzacx = new zzacx(4);
        zzacx.zzh(str);
        if (actionCodeSettings != null) {
            zzacx.zzd(actionCodeSettings);
        }
        zzR(zzacx, zzaae);
    }

    public final void zzw(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, zzaae zzaae) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaae);
        zzacx zzacx = new zzacx(actionCodeSettings.zza());
        zzacx.zzf(str);
        zzacx.zzd(actionCodeSettings);
        zzacx.zzg(str2);
        zzacx.zze(str3);
        this.zza.zzf(zzacx, new zzww(this, zzaae));
    }

    public final void zzx(zzado zzado, zzaae zzaae) {
        Preconditions.checkNotEmpty(zzado.zzd());
        Preconditions.checkNotNull(zzaae);
        this.zza.zzk(zzado, new zzxa(this, zzaae));
    }

    public final void zzy(String str, zzaae zzaae) {
        Preconditions.checkNotNull(zzaae);
        this.zza.zzm(str, new zzxy(this, zzaae));
    }

    public final void zzz(String str, zzaae zzaae) {
        Preconditions.checkNotNull(zzaae);
        this.zza.zzn(new zzads(str), new zzyb(this, zzaae));
    }
}
