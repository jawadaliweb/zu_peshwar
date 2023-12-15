package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaae  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzaae {
    private final zzaad zza;
    private final Logger zzb;

    public zzaae(zzaad zzaad, Logger logger) {
        this.zza = (zzaad) Preconditions.checkNotNull(zzaad);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zzc(zzacj zzacj) {
        try {
            this.zza.zzc(zzacj);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zzd() {
        try {
            this.zza.zzd();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zze(zzwm zzwm) {
        try {
            this.zza.zze(zzwm);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zzf(zzwn zzwn) {
        try {
            this.zza.zzf(zzwn);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzg(status, phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public void zzh(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzi(zzada zzada) {
        try {
            this.zza.zzi(zzada);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e, new Object[0]);
        }
    }

    public final void zzj(zzadd zzadd) {
        try {
            this.zza.zzj(zzadd);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e, new Object[0]);
        }
    }

    public final void zzk(zzade zzade, zzacv zzacv) {
        try {
            this.zza.zzk(zzade, zzacv);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zzl(zzadn zzadn) {
        try {
            this.zza.zzl(zzadn);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzn(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public final void zzo() {
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zzp(zzade zzade) {
        try {
            this.zza.zzp(zzade);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zzq(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzq(phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }

    public zzaae(zzaae zzaae) {
        this(zzaae.zza, zzaae.zzb);
    }
}
