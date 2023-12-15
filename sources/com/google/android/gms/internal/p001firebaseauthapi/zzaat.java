package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaat extends zzabm implements zzacd {
    zzaau zza;
    private zzaan zzb;
    private zzaao zzc;
    private zzabr zzd;
    private final zzaas zze;
    private final FirebaseApp zzf;
    private final String zzg;

    zzaat(FirebaseApp firebaseApp, zzaas zzaas, zzabr zzabr, zzaan zzaan, zzaao zzaao) {
        this.zzf = firebaseApp;
        String apiKey = firebaseApp.getOptions().getApiKey();
        this.zzg = apiKey;
        this.zze = (zzaas) Preconditions.checkNotNull(zzaas);
        zzy((zzabr) null, (zzaan) null, (zzaao) null);
        zzace.zze(apiKey, this);
    }

    private final zzaau zzx() {
        if (this.zza == null) {
            FirebaseApp firebaseApp = this.zzf;
            this.zza = new zzaau(firebaseApp.getApplicationContext(), firebaseApp, this.zze.zzb());
        }
        return this.zza;
    }

    private final void zzy(zzabr zzabr, zzaan zzaan, zzaao zzaao) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza2 = zzacb.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzace.zzd(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: ".concat(String.valueOf(zza2)));
        }
        if (this.zzd == null) {
            this.zzd = new zzabr(zza2, zzx());
        }
        String zza3 = zzacb.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzace.zzb(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: ".concat(String.valueOf(zza3)));
        }
        if (this.zzb == null) {
            this.zzb = new zzaan(zza3, zzx());
        }
        String zza4 = zzacb.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzace.zzc(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: ".concat(String.valueOf(zza4)));
        }
        if (this.zzc == null) {
            this.zzc = new zzaao(zza4, zzx());
        }
    }

    public final void zza(zzaci zzaci, zzabl zzabl) {
        Preconditions.checkNotNull(zzaci);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/createAuthUri", this.zzg), zzaci, zzabl, zzacj.class, zzaan.zzb);
    }

    public final void zzb(zzack zzack, zzabl zzabl) {
        Preconditions.checkNotNull(zzack);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/deleteAccount", this.zzg), zzack, zzabl, Void.class, zzaan.zzb);
    }

    public final void zzc(zzacl zzacl, zzabl zzabl) {
        Preconditions.checkNotNull(zzacl);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/emailLinkSignin", this.zzg), zzacl, zzabl, zzacm.class, zzaan.zzb);
    }

    public final void zzd(zzacs zzacs, zzabl zzabl) {
        Preconditions.checkNotNull(zzacs);
        Preconditions.checkNotNull(zzabl);
        zzabr zzabr = this.zzd;
        zzabo.zzb(zzabr.zza("/token", this.zzg), zzacs, zzabl, zzade.class, zzabr.zzb);
    }

    public final void zze(zzact zzact, zzabl zzabl) {
        Preconditions.checkNotNull(zzact);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/getAccountInfo", this.zzg), zzact, zzabl, zzacu.class, zzaan.zzb);
    }

    public final void zzf(zzacx zzacx, zzabl zzabl) {
        Preconditions.checkNotNull(zzacx);
        Preconditions.checkNotNull(zzabl);
        if (zzacx.zzb() != null) {
            zzx().zzc(zzacx.zzb().zze());
        }
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/getOobConfirmationCode", this.zzg), zzacx, zzabl, zzacy.class, zzaan.zzb);
    }

    public final void zzg(zzacz zzacz, zzabl zzabl) {
        Preconditions.checkNotNull(zzacz);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zza(zzaan.zza("/getRecaptchaParam", this.zzg), zzabl, zzada.class, zzaan.zzb);
    }

    public final void zzh(zzadc zzadc, zzabl zzabl) {
        Preconditions.checkNotNull(zzadc);
        Preconditions.checkNotNull(zzabl);
        zzaao zzaao = this.zzc;
        String zza2 = zzaao.zza("/recaptchaConfig", this.zzg);
        String zzc2 = zzadc.zzc();
        String zzd2 = zzadc.zzd();
        zzabo.zza(zza2 + "&clientType=" + zzc2 + "&version=" + zzd2, zzabl, zzadd.class, zzaao.zzb);
    }

    public final void zzi() {
        zzy((zzabr) null, (zzaan) null, (zzaao) null);
    }

    public final void zzj(zzadm zzadm, zzabl zzabl) {
        Preconditions.checkNotNull(zzadm);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/resetPassword", this.zzg), zzadm, zzabl, zzadn.class, zzaan.zzb);
    }

    public final void zzk(zzado zzado, zzabl zzabl) {
        Preconditions.checkNotNull(zzado);
        Preconditions.checkNotNull(zzabl);
        if (!TextUtils.isEmpty(zzado.zzc())) {
            zzx().zzc(zzado.zzc());
        }
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/sendVerificationCode", this.zzg), zzado, zzabl, zzadp.class, zzaan.zzb);
    }

    public final void zzl(zzadq zzadq, zzabl zzabl) {
        Preconditions.checkNotNull(zzadq);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/setAccountInfo", this.zzg), zzadq, zzabl, zzadr.class, zzaan.zzb);
    }

    public final void zzm(String str, zzabl zzabl) {
        Preconditions.checkNotNull(zzabl);
        zzx().zzb(str);
        ((zzxy) zzabl).zza.zzo();
    }

    public final void zzn(zzads zzads, zzabl zzabl) {
        Preconditions.checkNotNull(zzads);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/signupNewUser", this.zzg), zzads, zzabl, zzadt.class, zzaan.zzb);
    }

    public final void zzo(zzadv zzadv, zzabl zzabl) {
        Preconditions.checkNotNull(zzadv);
        Preconditions.checkNotNull(zzabl);
        if (!TextUtils.isEmpty(zzadv.zzc())) {
            zzx().zzc(zzadv.zzc());
        }
        zzaao zzaao = this.zzc;
        zzabo.zzb(zzaao.zza("/accounts/mfaSignIn:start", this.zzg), zzadv, zzabl, zzadw.class, zzaao.zzb);
    }

    public final void zzp(zzaec zzaec, zzabl zzabl) {
        Preconditions.checkNotNull(zzaec);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/verifyAssertion", this.zzg), zzaec, zzabl, zzaee.class, zzaan.zzb);
    }

    public final void zzq(zzaef zzaef, zzabl zzabl) {
        Preconditions.checkNotNull(zzaef);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/verifyCustomToken", this.zzg), zzaef, zzabl, zzaeg.class, zzaan.zzb);
    }

    public final void zzr(zzaeh zzaeh, zzabl zzabl) {
        Preconditions.checkNotNull(zzaeh);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/verifyPassword", this.zzg), zzaeh, zzabl, zzaei.class, zzaan.zzb);
    }

    public final void zzs(zzaej zzaej, zzabl zzabl) {
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzabl);
        zzaan zzaan = this.zzb;
        zzabo.zzb(zzaan.zza("/verifyPhoneNumber", this.zzg), zzaej, zzabl, zzaek.class, zzaan.zzb);
    }

    public final void zzt(zzael zzael, zzabl zzabl) {
        Preconditions.checkNotNull(zzael);
        Preconditions.checkNotNull(zzabl);
        zzaao zzaao = this.zzc;
        zzabo.zzb(zzaao.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzael, zzabl, zzaem.class, zzaao.zzb);
    }

    public final void zzu(zzacp zzacp, zzabl zzabl) {
        Preconditions.checkNotNull(zzacp);
        Preconditions.checkNotNull(zzabl);
        zzaao zzaao = this.zzc;
        zzabo.zzb(zzaao.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzacp, zzabl, zzacn.class, zzaao.zzb);
    }

    public final void zzv(zzadx zzadx, zzabl zzabl) {
        Preconditions.checkNotNull(zzadx);
        Preconditions.checkNotNull(zzabl);
        if (!TextUtils.isEmpty(zzadx.zzc())) {
            zzx().zzc(zzadx.zzc());
        }
        zzaao zzaao = this.zzc;
        zzabo.zzb(zzaao.zza("/accounts/mfaEnrollment:start", this.zzg), zzadx, zzabl, zzadu.class, zzaao.zzb);
    }

    public final void zzw(zzacq zzacq, zzabl zzabl) {
        Preconditions.checkNotNull(zzacq);
        Preconditions.checkNotNull(zzabl);
        zzaao zzaao = this.zzc;
        zzabo.zzb(zzaao.zza("/accounts/mfaSignIn:finalize", this.zzg), zzacq, zzabl, zzaco.class, zzaao.zzb);
    }
}
