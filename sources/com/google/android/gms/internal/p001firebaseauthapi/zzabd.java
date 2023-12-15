package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzabd implements zzaad {
    final /* synthetic */ zzabg zza;

    zzabd(zzabg zzabg) {
        this.zza = zzabg;
    }

    private final void zzr(zzabe zzabe) {
        this.zza.zzm.execute(new zzabc(this, zzabe));
    }

    private final void zzs(Status status, AuthCredential authCredential, String str, String str2) {
        zzabg.zzk(this.zza, status);
        zzabg zzabg = this.zza;
        zzabg.zzt = authCredential;
        zzabg.zzu = str;
        zzabg.zzv = str2;
        zzao zzao = zzabg.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
        this.zza.zzl(status);
    }

    public final void zza(String str) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        zzabg zzabg = this.zza;
        zzabg.zzs = str;
        zzabg.zza = true;
        zzr(new zzaba(this, str));
    }

    public final void zzb(String str) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zzs = str;
        zzr(new zzaay(this, str));
    }

    public final void zzc(zzacj zzacj) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 3, "Unexpected response type " + i);
        zzabg zzabg = this.zza;
        zzabg.zzp = zzacj;
        zzabg.zzj(zzabg);
    }

    public final void zzd() throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 5, "Unexpected response type " + i);
        zzabg.zzj(this.zza);
    }

    public final void zze(zzwm zzwm) {
        zzs(zzwm.zza(), zzwm.zzb(), zzwm.zzc(), zzwm.zzd());
    }

    public final void zzf(zzwn zzwn) {
        zzabg zzabg = this.zza;
        zzabg.zzw = zzwn;
        zzabg.zzl(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 2, "Unexpected response type " + i);
        zzs(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzabg zzabg = this.zza;
        if (zzabg.zze == 8) {
            zzabg.zza = true;
            zzr(new zzabb(this, status));
            return;
        }
        zzabg.zzk(zzabg, status);
        this.zza.zzl(status);
    }

    public final void zzi(zzada zzada) throws RemoteException {
        zzabg zzabg = this.zza;
        zzabg.zzy = zzada;
        zzabg.zzj(zzabg);
    }

    public final void zzj(zzadd zzadd) throws RemoteException {
        zzabg zzabg = this.zza;
        zzabg.zzx = zzadd;
        zzabg.zzj(zzabg);
    }

    public final void zzk(zzade zzade, zzacv zzacv) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 2, "Unexpected response type: " + i);
        zzabg zzabg = this.zza;
        zzabg.zzn = zzade;
        zzabg.zzo = zzacv;
        zzabg.zzj(zzabg);
    }

    public final void zzl(zzadn zzadn) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 4, "Unexpected response type " + i);
        zzabg zzabg = this.zza;
        zzabg.zzq = zzadn;
        zzabg.zzj(zzabg);
    }

    public final void zzm() throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 6, "Unexpected response type " + i);
        zzabg.zzj(this.zza);
    }

    public final void zzn(String str) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 7, "Unexpected response type " + i);
        zzabg zzabg = this.zza;
        zzabg.zzr = str;
        zzabg.zzj(zzabg);
    }

    public final void zzo() throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 9, "Unexpected response type " + i);
        zzabg.zzj(this.zza);
    }

    public final void zzp(zzade zzade) throws RemoteException {
        int i = this.zza.zze;
        String str = "Unexpected response type: " + i;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Preconditions.checkState(z, str);
        zzabg zzabg = this.zza;
        zzabg.zzn = zzade;
        zzabg.zzj(zzabg);
    }

    public final void zzq(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zze;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zza = true;
        zzr(new zzaaz(this, phoneAuthCredential));
    }
}
