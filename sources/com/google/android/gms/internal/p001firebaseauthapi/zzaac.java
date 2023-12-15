package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.internal.zzbw;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.auth.zzat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaac extends zzabj {
    public zzaac(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaaf(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    static zzx zzQ(FirebaseApp firebaseApp, zzacv zzacv) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzacv);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzacv, "firebase"));
        List zzr = zzacv.zzr();
        if (zzr != null && !zzr.isEmpty()) {
            for (int i = 0; i < zzr.size(); i++) {
                arrayList.add(new zzt((zzadj) zzr.get(i)));
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzx.zzr(new zzz(zzacv.zzb(), zzacv.zza()));
        zzx.zzq(zzacv.zzt());
        zzx.zzp(zzacv.zzd());
        zzx.zzi(zzbc.zzb(zzacv.zzq()));
        return zzx;
    }

    public final Task zzA(FirebaseApp firebaseApp, zzg zzg, String str) {
        zzzk zzzk = new zzzk(str);
        zzzk.zzf(firebaseApp);
        zzzk.zzd(zzg);
        return zzS(zzzk);
    }

    public final Task zzB(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzg zzg) {
        zzzl zzzl = new zzzl(authCredential, str);
        zzzl.zzf(firebaseApp);
        zzzl.zzd(zzg);
        return zzS(zzzl);
    }

    public final Task zzC(FirebaseApp firebaseApp, String str, String str2, zzg zzg) {
        zzzm zzzm = new zzzm(str, str2);
        zzzm.zzf(firebaseApp);
        zzzm.zzd(zzg);
        return zzS(zzzm);
    }

    public final Task zzD(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzg zzg) {
        zzzn zzzn = new zzzn(str, str2, str3, str4);
        zzzn.zzf(firebaseApp);
        zzzn.zzd(zzg);
        return zzS(zzzn);
    }

    public final Task zzE(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzg zzg) {
        zzzo zzzo = new zzzo(emailAuthCredential, str);
        zzzo.zzf(firebaseApp);
        zzzo.zzd(zzg);
        return zzS(zzzo);
    }

    public final Task zzF(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzg zzg) {
        zzabu.zzc();
        zzzp zzzp = new zzzp(phoneAuthCredential, str);
        zzzp.zzf(firebaseApp);
        zzzp.zzd(zzg);
        return zzS(zzzp);
    }

    public final Task zzG(zzag zzag, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzzq zzzq = new zzzq(zzag, str, str2, j, z, z2, str3, str4, z3);
        String str5 = str;
        zzzq.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzS(zzzq);
    }

    public final Task zzH(zzag zzag, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzzr zzzr = new zzzr(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzag.zzd()), str, j, z, z2, str2, str3, z3);
        Activity activity2 = activity;
        zzzr.zzh(onVerificationStateChangedCallbacks, activity2, executor, phoneMultiFactorInfo.getUid());
        return zzS(zzzr);
    }

    public final Task zzI(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzbw zzbw) {
        zzzs zzzs = new zzzs(firebaseUser.zzf(), str, str2);
        zzzs.zzf(firebaseApp);
        zzzs.zzg(firebaseUser);
        zzzs.zzd(zzbw);
        zzzs.zze(zzbw);
        return zzS(zzzs);
    }

    public final Task zzJ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbw zzbw) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbw);
        List zzg = firebaseUser.zzg();
        if ((zzg != null && !zzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzaag.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (((str.hashCode() == 1216985755 && str.equals("password")) ? (char) 0 : 65535) != 0) {
            zzzu zzzu = new zzzu(str);
            zzzu.zzf(firebaseApp);
            zzzu.zzg(firebaseUser);
            zzzu.zzd(zzbw);
            zzzu.zze(zzbw);
            return zzS(zzzu);
        }
        zzzt zzzt = new zzzt();
        zzzt.zzf(firebaseApp);
        zzzt.zzg(firebaseUser);
        zzzt.zzd(zzbw);
        zzzt.zze(zzbw);
        return zzS(zzzt);
    }

    public final Task zzK(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbw zzbw) {
        zzzv zzzv = new zzzv(str);
        zzzv.zzf(firebaseApp);
        zzzv.zzg(firebaseUser);
        zzzv.zzd(zzbw);
        zzzv.zze(zzbw);
        return zzS(zzzv);
    }

    public final Task zzL(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbw zzbw) {
        zzzw zzzw = new zzzw(str);
        zzzw.zzf(firebaseApp);
        zzzw.zzg(firebaseUser);
        zzzw.zzd(zzbw);
        zzzw.zze(zzbw);
        return zzS(zzzw);
    }

    public final Task zzM(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbw zzbw) {
        zzabu.zzc();
        zzzx zzzx = new zzzx(phoneAuthCredential);
        zzzx.zzf(firebaseApp);
        zzzx.zzg(firebaseUser);
        zzzx.zzd(zzbw);
        zzzx.zze(zzbw);
        return zzS(zzzx);
    }

    public final Task zzN(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbw zzbw) {
        zzzy zzzy = new zzzy(userProfileChangeRequest);
        zzzy.zzf(firebaseApp);
        zzzy.zzg(firebaseUser);
        zzzy.zzd(zzbw);
        zzzy.zze(zzbw);
        return zzS(zzzy);
    }

    public final Task zzO(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzg(7);
        return zzS(new zzzz(str, str2, actionCodeSettings));
    }

    public final Task zzP(FirebaseApp firebaseApp, String str, String str2) {
        zzaaa zzaaa = new zzaaa(str, str2);
        zzaaa.zzf(firebaseApp);
        return zzS(zzaaa);
    }

    public final void zzR(FirebaseApp firebaseApp, zzado zzado, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzaab zzaab = new zzaab(zzado);
        zzaab.zzf(firebaseApp);
        zzaab.zzh(onVerificationStateChangedCallbacks, activity, executor, zzado.zzd());
        zzS(zzaab);
    }

    public final Task zza(FirebaseApp firebaseApp, String str, String str2) {
        zzyj zzyj = new zzyj(str, str2);
        zzyj.zzf(firebaseApp);
        return zzS(zzyj);
    }

    public final Task zzb(FirebaseApp firebaseApp, String str, String str2) {
        zzyk zzyk = new zzyk(str, str2);
        zzyk.zzf(firebaseApp);
        return zzS(zzyk);
    }

    public final Task zzc(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzyl zzyl = new zzyl(str, str2, str3);
        zzyl.zzf(firebaseApp);
        return zzS(zzyl);
    }

    public final Task zzd(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzg zzg) {
        zzym zzym = new zzym(str, str2, str3, str4);
        zzym.zzf(firebaseApp);
        zzym.zzd(zzg);
        return zzS(zzym);
    }

    public final Task zze(FirebaseUser firebaseUser, zzan zzan) {
        zzyn zzyn = new zzyn();
        zzyn.zzg(firebaseUser);
        zzyn.zzd(zzan);
        zzyn.zze(zzan);
        return zzS(zzyn);
    }

    public final Task zzf(FirebaseApp firebaseApp, String str, String str2) {
        zzyo zzyo = new zzyo(str, str2);
        zzyo.zzf(firebaseApp);
        return zzS(zzyo);
    }

    public final Task zzg(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzg zzg) {
        zzabu.zzc();
        zzyp zzyp = new zzyp(phoneMultiFactorAssertion, firebaseUser.zzf(), str, (String) null);
        zzyp.zzf(firebaseApp);
        zzyp.zzd(zzg);
        return zzS(zzyp);
    }

    public final Task zzh(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzg) {
        zzabu.zzc();
        zzyq zzyq = new zzyq(phoneMultiFactorAssertion, str, (String) null);
        zzyq.zzf(firebaseApp);
        zzyq.zzd(zzg);
        if (firebaseUser != null) {
            zzyq.zzg(firebaseUser);
        }
        return zzS(zzyq);
    }

    public final Task zzi(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzat zzat, String str, zzg zzg, String str2) {
        zzyq zzyq = new zzyq(zzat, str, str2);
        zzyq.zzf(firebaseApp);
        zzyq.zzd(zzg);
        if (firebaseUser != null) {
            zzyq.zzg(firebaseUser);
        }
        return zzS(zzyq);
    }

    public final Task zzj(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbw zzbw) {
        zzyr zzyr = new zzyr(str);
        zzyr.zzf(firebaseApp);
        zzyr.zzg(firebaseUser);
        zzyr.zzd(zzbw);
        zzyr.zze(zzbw);
        return zzS(zzyr);
    }

    public final Task zzk() {
        return zzS(new zzys());
    }

    public final Task zzl(String str, String str2) {
        return zzS(new zzyt(str, "RECAPTCHA_ENTERPRISE"));
    }

    public final Task zzm(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbw zzbw) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbw);
        List zzg = firebaseUser.zzg();
        if (zzg != null && zzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzaag.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzyu zzyu = new zzyu(emailAuthCredential);
                zzyu.zzf(firebaseApp);
                zzyu.zzg(firebaseUser);
                zzyu.zzd(zzbw);
                zzyu.zze(zzbw);
                return zzS(zzyu);
            }
            zzyx zzyx = new zzyx(emailAuthCredential);
            zzyx.zzf(firebaseApp);
            zzyx.zzg(firebaseUser);
            zzyx.zzd(zzbw);
            zzyx.zze(zzbw);
            return zzS(zzyx);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzabu.zzc();
            zzyw zzyw = new zzyw((PhoneAuthCredential) authCredential);
            zzyw.zzf(firebaseApp);
            zzyw.zzg(firebaseUser);
            zzyw.zzd(zzbw);
            zzyw.zze(zzbw);
            return zzS(zzyw);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzbw);
            zzyv zzyv = new zzyv(authCredential);
            zzyv.zzf(firebaseApp);
            zzyv.zzg(firebaseUser);
            zzyv.zzd(zzbw);
            zzyv.zze(zzbw);
            return zzS(zzyv);
        }
    }

    public final Task zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbw zzbw) {
        zzyy zzyy = new zzyy(authCredential, str);
        zzyy.zzf(firebaseApp);
        zzyy.zzg(firebaseUser);
        zzyy.zzd(zzbw);
        zzyy.zze(zzbw);
        return zzS(zzyy);
    }

    public final Task zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbw zzbw) {
        zzyz zzyz = new zzyz(authCredential, str);
        zzyz.zzf(firebaseApp);
        zzyz.zzg(firebaseUser);
        zzyz.zzd(zzbw);
        zzyz.zze(zzbw);
        return zzS(zzyz);
    }

    public final Task zzp(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzbw zzbw) {
        zzza zzza = new zzza(emailAuthCredential, str);
        zzza.zzf(firebaseApp);
        zzza.zzg(firebaseUser);
        zzza.zzd(zzbw);
        zzza.zze(zzbw);
        return zzS(zzza);
    }

    public final Task zzq(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzbw zzbw) {
        zzzb zzzb = new zzzb(emailAuthCredential, str);
        zzzb.zzf(firebaseApp);
        zzzb.zzg(firebaseUser);
        zzzb.zzd(zzbw);
        zzzb.zze(zzbw);
        return zzS(zzzb);
    }

    public final Task zzr(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzbw zzbw) {
        zzzc zzzc = new zzzc(str, str2, str3, str4);
        zzzc.zzf(firebaseApp);
        zzzc.zzg(firebaseUser);
        zzzc.zzd(zzbw);
        zzzc.zze(zzbw);
        return zzS(zzzc);
    }

    public final Task zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzbw zzbw) {
        zzzd zzzd = new zzzd(str, str2, str3, str4);
        zzzd.zzf(firebaseApp);
        zzzd.zzg(firebaseUser);
        zzzd.zzd(zzbw);
        zzzd.zze(zzbw);
        return zzS(zzzd);
    }

    public final Task zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbw zzbw) {
        zzabu.zzc();
        zzze zzze = new zzze(phoneAuthCredential, str);
        zzze.zzf(firebaseApp);
        zzze.zzg(firebaseUser);
        zzze.zzd(zzbw);
        zzze.zze(zzbw);
        return zzS(zzze);
    }

    public final Task zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbw zzbw) {
        zzabu.zzc();
        zzzf zzzf = new zzzf(phoneAuthCredential, str);
        zzzf.zzf(firebaseApp);
        zzzf.zzg(firebaseUser);
        zzzf.zzd(zzbw);
        zzzf.zze(zzbw);
        return zzS(zzzf);
    }

    public final Task zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbw zzbw) {
        zzzg zzzg = new zzzg();
        zzzg.zzf(firebaseApp);
        zzzg.zzg(firebaseUser);
        zzzg.zzd(zzbw);
        zzzg.zze(zzbw);
        return zzS(zzzg);
    }

    public final Task zzw(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzzh zzzh = new zzzh(str, actionCodeSettings);
        zzzh.zzf(firebaseApp);
        return zzS(zzzh);
    }

    public final Task zzx(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zzg(1);
        zzzi zzzi = new zzzi(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail");
        zzzi.zzf(firebaseApp);
        return zzS(zzzi);
    }

    public final Task zzy(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zzg(6);
        zzzi zzzi = new zzzi(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail");
        zzzi.zzf(firebaseApp);
        return zzS(zzzi);
    }

    public final Task zzz(String str) {
        return zzS(new zzzj(str));
    }
}
