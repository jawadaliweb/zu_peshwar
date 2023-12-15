package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.zzat;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaaf {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzyh zzb;
    private final zzaca zzc;

    zzaaf(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzyh(new zzaat(firebaseApp, zzaas.zza(), (zzabr) null, (zzaan) null, (zzaao) null));
        this.zzc = new zzaca(applicationContext, scheduledExecutorService);
    }

    private static boolean zzI(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzwj zzwj, zzaad zzaad) {
        Preconditions.checkNotNull(zzaad);
        Preconditions.checkNotNull(zzwj);
        this.zzb.zzE(zzabq.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwj.zza())), new zzaae(zzaad, zza));
    }

    public final void zzB(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, boolean z3, zzaad zzaad) {
        String str6 = str2;
        String str7 = str;
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaad);
        zzaae zzaae = new zzaae(zzaad, zza);
        if (this.zzc.zzk(str2)) {
            if (z) {
                this.zzc.zzi(str2);
            } else {
                this.zzc.zzh(zzaae, str2);
                return;
            }
        }
        zzadx zzb2 = zzadx.zzb(str, str2, str3, str4, str5, (String) null);
        long j2 = j;
        if (zzI(j, z3)) {
            zzb2.zzd(new zzacf(this.zzc.zzb()));
        }
        this.zzc.zzj(str2, zzaae, j, z3);
        this.zzb.zzM(zzb2, new zzabx(this.zzc, zzaae, str2));
    }

    public final void zzC(zzwk zzwk, zzaad zzaad) {
        Preconditions.checkNotNull(zzwk);
        Preconditions.checkNotNull(zzaad);
        String phoneNumber = zzwk.zzb().getPhoneNumber();
        zzaae zzaae = new zzaae(zzaad, zza);
        if (this.zzc.zzk(phoneNumber)) {
            if (zzwk.zzg()) {
                this.zzc.zzi(phoneNumber);
            } else {
                this.zzc.zzh(zzaae, phoneNumber);
                return;
            }
        }
        long zza2 = zzwk.zza();
        boolean zzh = zzwk.zzh();
        zzadv zzb2 = zzadv.zzb(zzwk.zzd(), zzwk.zzb().getUid(), zzwk.zzb().getPhoneNumber(), zzwk.zzc(), zzwk.zzf(), zzwk.zze());
        if (zzI(zza2, zzh)) {
            zzb2.zzd(new zzacf(this.zzc.zzb()));
        }
        this.zzc.zzj(phoneNumber, zzaae, zza2, zzh);
        this.zzb.zzF(zzb2, new zzabx(this.zzc, zzaae, phoneNumber));
    }

    public final void zzD(String str, String str2, String str3, zzaad zzaad) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzG(str, str2, str3, new zzaae(zzaad, zza));
    }

    public final void zzE(String str, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzH(str, new zzaae(zzaad, zza));
    }

    public final void zzF(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzI(str, str2, new zzaae(zzaad, zza));
    }

    public final void zzG(String str, UserProfileChangeRequest userProfileChangeRequest, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzJ(str, userProfileChangeRequest, new zzaae(zzaad, zza));
    }

    public final void zzH(zzwl zzwl, zzaad zzaad) {
        Preconditions.checkNotNull(zzwl);
        this.zzb.zzK(zzacx.zzc(zzwl.zza(), zzwl.zzb(), zzwl.zzc()), new zzaae(zzaad, zza));
    }

    public final void zza(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzg(str, str2, new zzaae(zzaad, zza));
    }

    public final void zzb(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzh(str, str2, new zzaae(zzaad, zza));
    }

    public final void zzc(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzi(str, str2, new zzaae(zzaad, zza));
    }

    public final void zzd(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzj(str, str2, new zzaae(zzaad, zza));
    }

    public final void zze(zzwa zzwa, zzaad zzaad) {
        Preconditions.checkNotNull(zzwa);
        Preconditions.checkNotEmpty(zzwa.zza());
        Preconditions.checkNotEmpty(zzwa.zzb());
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzk(zzwa.zza(), zzwa.zzb(), zzwa.zzc(), new zzaae(zzaad, zza));
    }

    public final void zzf(String str, String str2, String str3, String str4, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzl(str, str2, str3, str4, new zzaae(zzaad, zza));
    }

    public final void zzg(String str, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzm(str, new zzaae(zzaad, zza));
    }

    public final void zzh(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaad zzaad) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaad);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zzL(zzacp.zzb(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2, (String) null), str, new zzaae(zzaad, zza));
        } else if (multiFactorAssertion instanceof zzat) {
            throw new IllegalArgumentException("Not implemented");
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzi(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaad);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zzN(zzacq.zzb(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzaae(zzaad, zza));
        } else if (multiFactorAssertion instanceof zzat) {
            zzat zzat = (zzat) multiFactorAssertion;
            throw null;
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzj(String str, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzn(str, new zzaae(zzaad, zza));
    }

    public final void zzk(zzwb zzwb, zzaad zzaad) {
        Preconditions.checkNotNull(zzwb);
        this.zzb.zzo(zzacz.zzb(), new zzaae(zzaad, zza));
    }

    public final void zzl(String str, String str2, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zzp(str, str2, new zzaae(zzaad, zza));
    }

    public final void zzm(zzwc zzwc, zzaad zzaad) {
        Preconditions.checkNotNull(zzwc);
        this.zzb.zzq(zzadc.zzb(zzwc.zzb(), zzwc.zza()), new zzaae(zzaad, zza));
    }

    public final void zzn(String str, String str2, String str3, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzr(str, str2, str3, new zzaae(zzaad, zza));
    }

    public final void zzo(String str, zzaec zzaec, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaec);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzs(str, zzaec, new zzaae(zzaad, zza));
    }

    public final void zzp(zzwd zzwd, zzaad zzaad) {
        Preconditions.checkNotNull(zzaad);
        Preconditions.checkNotNull(zzwd);
        this.zzb.zzt(Preconditions.checkNotEmpty(zzwd.zzb()), zzabq.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwd.zza())), new zzaae(zzaad, zza));
    }

    public final void zzq(String str, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzu(str, new zzaae(zzaad, zza));
    }

    public final void zzr(zzwe zzwe, zzaad zzaad) {
        Preconditions.checkNotNull(zzwe);
        Preconditions.checkNotEmpty(zzwe.zzb());
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzv(zzwe.zzb(), zzwe.zza(), new zzaae(zzaad, zza));
    }

    public final void zzs(zzwf zzwf, zzaad zzaad) {
        Preconditions.checkNotNull(zzwf);
        Preconditions.checkNotEmpty(zzwf.zzc());
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzw(zzwf.zzc(), zzwf.zza(), zzwf.zzd(), zzwf.zzb(), new zzaae(zzaad, zza));
    }

    public final void zzt(zzwg zzwg, zzaad zzaad) {
        Preconditions.checkNotNull(zzaad);
        Preconditions.checkNotNull(zzwg);
        zzado zzado = (zzado) Preconditions.checkNotNull(zzwg.zza());
        String zzd = zzado.zzd();
        zzaae zzaae = new zzaae(zzaad, zza);
        if (this.zzc.zzk(zzd)) {
            if (zzado.zzf()) {
                this.zzc.zzi(zzd);
            } else {
                this.zzc.zzh(zzaae, zzd);
                return;
            }
        }
        long zzb2 = zzado.zzb();
        boolean zzg = zzado.zzg();
        if (zzI(zzb2, zzg)) {
            zzado.zze(new zzacf(this.zzc.zzb()));
        }
        this.zzc.zzj(zzd, zzaae, zzb2, zzg);
        this.zzb.zzx(zzado, new zzabx(this.zzc, zzaae, zzd));
    }

    public final void zzu(zzwh zzwh, zzaad zzaad) {
        Preconditions.checkNotNull(zzwh);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzy(zzwh.zza(), new zzaae(zzaad, zza));
    }

    public final void zzv(String str, zzaad zzaad) {
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzz(str, new zzaae(zzaad, zza));
    }

    public final void zzw(zzaec zzaec, zzaad zzaad) {
        Preconditions.checkNotNull(zzaec);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzA(zzaec, new zzaae(zzaad, zza));
    }

    public final void zzx(zzaef zzaef, zzaad zzaad) {
        Preconditions.checkNotNull(zzaef);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzB(zzaef, new zzaae(zzaad, zza));
    }

    public final void zzy(String str, String str2, String str3, String str4, zzaad zzaad) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaad);
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzC(str, str2, str3, str4, new zzaae(zzaad, zza));
    }

    public final void zzz(zzwi zzwi, zzaad zzaad) {
        Preconditions.checkNotNull(zzwi);
        Preconditions.checkNotNull(zzwi.zza());
        Preconditions.checkNotNull(zzaad);
        this.zzb.zzD(zzwi.zza(), zzwi.zzb(), new zzaae(zzaad, zza));
    }
}
