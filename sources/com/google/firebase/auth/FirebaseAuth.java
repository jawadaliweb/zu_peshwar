package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzaac;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.internal.p001firebaseauthapi.zzaal;
import com.google.android.gms.internal.p001firebaseauthapi.zzaav;
import com.google.android.gms.internal.p001firebaseauthapi.zzabu;
import com.google.android.gms.internal.p001firebaseauthapi.zzace;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.android.gms.internal.p001firebaseauthapi.zzado;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbr;
import com.google.firebase.auth.internal.zzbt;
import com.google.firebase.auth.internal.zzbv;
import com.google.firebase.auth.internal.zzbw;
import com.google.firebase.auth.internal.zzby;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class FirebaseAuth implements InternalAuthProvider {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public final FirebaseApp zzb;
    /* access modifiers changed from: private */
    public final List zzc = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zzd = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zze = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final zzaac zzf;
    /* access modifiers changed from: private */
    public FirebaseUser zzg;
    /* access modifiers changed from: private */
    public final zzw zzh;
    private final Object zzi = new Object();
    /* access modifiers changed from: private */
    public String zzj;
    private final Object zzk = new Object();
    /* access modifiers changed from: private */
    public String zzl;
    private zzbr zzm;
    private final RecaptchaAction zzn = RecaptchaAction.custom("getOobCode");
    private final RecaptchaAction zzo = RecaptchaAction.custom("signInWithPassword");
    private final RecaptchaAction zzp = RecaptchaAction.custom("signUpPassword");
    private final zzbt zzq;
    private final zzby zzr;
    private final zzf zzs;
    private final Provider zzt;
    private final Provider zzu;
    private zzbv zzv;
    private final Executor zzw;
    private final Executor zzx;
    private final Executor zzy;

    /* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(FirebaseApp firebaseApp, Provider provider, Provider provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        zzade zzb2;
        zzaac zzaac = new zzaac(firebaseApp, executor2, scheduledExecutorService);
        zzbt zzbt = new zzbt(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzby zzc2 = zzby.zzc();
        zzf zzb3 = zzf.zzb();
        this.zzb = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzf = (zzaac) Preconditions.checkNotNull(zzaac);
        zzbt zzbt2 = (zzbt) Preconditions.checkNotNull(zzbt);
        this.zzq = zzbt2;
        this.zzh = new zzw();
        zzby zzby = (zzby) Preconditions.checkNotNull(zzc2);
        this.zzr = zzby;
        this.zzs = (zzf) Preconditions.checkNotNull(zzb3);
        this.zzt = provider;
        this.zzu = provider2;
        this.zzw = executor2;
        this.zzx = executor3;
        this.zzy = executor4;
        FirebaseUser zza2 = zzbt2.zza();
        this.zzg = zza2;
        if (!(zza2 == null || (zzb2 = zzbt2.zzb(zza2)) == null)) {
            zzS(this, this.zzg, zzb2, false, false);
        }
        zzby.zze(this);
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static zzbv zzC(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzv == null) {
            firebaseAuth.zzv = new zzbv((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zzb));
        }
        return firebaseAuth.zzv;
    }

    public static void zzQ(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + uid + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.zzy.execute(new zzv(firebaseAuth));
    }

    public static void zzR(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + uid + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.zzy.execute(new zzu(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zze() : null)));
    }

    static void zzS(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzade zzade, boolean z, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzade);
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = firebaseAuth.zzg != null && firebaseUser.getUid().equals(firebaseAuth.zzg.getUid());
        if (z6 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzg;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z7 = !firebaseUser2.zzd().zze().equals(zzade.zze());
                if (!z6 || z7) {
                    z4 = true;
                }
                z3 = true ^ z6;
                z5 = z4;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzg = firebaseUser;
            } else {
                firebaseAuth.zzg.zzc(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzg.zzb();
                }
                firebaseAuth.zzg.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                firebaseAuth.zzq.zzd(firebaseAuth.zzg);
            }
            if (z5) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzg;
                if (firebaseUser3 != null) {
                    firebaseUser3.zzh(zzade);
                }
                zzR(firebaseAuth, firebaseAuth.zzg);
            }
            if (z3) {
                zzQ(firebaseAuth, firebaseAuth.zzg);
            }
            if (z) {
                firebaseAuth.zzq.zze(firebaseUser, zzade);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzg;
            if (firebaseUser4 != null) {
                zzC(firebaseAuth).zze(firebaseUser4.zzd());
            }
        }
    }

    public static final void zzW(FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback with MissingActivity exception for phone number/uid - ".concat(String.valueOf(str)));
        phoneAuthOptions.zzi().execute(new zzi(zzabu.zza(str, phoneAuthOptions.zze(), (zzabg) null), firebaseAuthMissingActivityForRecaptchaException));
    }

    private final Task zzX(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z) {
        return new zzaa(this, z, firebaseUser, emailAuthCredential).zzb(this, this.zzl, z ? this.zzn : this.zzo);
    }

    private final Task zzY(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z) {
        return new zzy(this, str, z, firebaseUser, str2, str3).zzb(this, str3, this.zzo);
    }

    private final Task zzZ(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z) {
        return new zzz(this, z, firebaseUser, emailAuthCredential).zzb(this, this.zzl, this.zzn);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzaa(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        zzw zzw2 = this.zzh;
        return (!zzw2.zzd() || str == null || !str.equals(zzw2.zza())) ? onVerificationStateChangedCallbacks : new zzl(this, onVerificationStateChangedCallbacks);
    }

    private final boolean zzab(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return parseLink != null && !TextUtils.equals(this.zzl, parseLink.zza());
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zze.add(authStateListener);
        this.zzy.execute(new zzt(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzc.add(idTokenListener);
        this.zzy.execute(new zzs(this, idTokenListener));
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zza(this.zzb, str, this.zzl);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzb(this.zzb, str, this.zzl);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzf.zzc(this.zzb, str, str2, this.zzl);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzn(this, str, str2).zzb(this, this.zzl, this.zzp);
    }

    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzf(this.zzb, str, this.zzl);
    }

    public final Task getAccessToken(boolean z) {
        return zzc(this.zzg, z);
    }

    public FirebaseApp getApp() {
        return this.zzb;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzg;
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzh;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzi) {
            str = this.zzj;
        }
        return str;
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzr.zza();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzk) {
            str = this.zzl;
        }
        return str;
    }

    public final String getUid() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzm == null) {
            this.zzm = new zzbr(this.zzb, this);
        }
        return this.zzm.zzb(this.zzl, false).continueWithTask(new zzx(this));
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zze.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzc.remove(idTokenListener);
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzj;
            if (str2 != null) {
                actionCodeSettings.zzf(str2);
            }
            return new zzp(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zzf.zzz(str);
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzi) {
            this.zzj = str;
        }
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzk) {
            this.zzl = str;
        }
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zzf.zzA(this.zzb, new zzab(this), this.zzl);
        }
        zzx zzx2 = (zzx) this.zzg;
        zzx2.zzq(false);
        return Tasks.forResult(new zzr(zzx2));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzg()) {
                return zzY(emailAuthCredential.zzd(), (String) Preconditions.checkNotNull(emailAuthCredential.zze()), this.zzl, (FirebaseUser) null, false);
            } else if (zzab(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaag.zza(new Status(17072)));
            } else {
                return zzZ(emailAuthCredential, (FirebaseUser) null, false);
            }
        } else if (!(zza2 instanceof PhoneAuthCredential)) {
            return this.zzf.zzB(this.zzb, zza2, this.zzl, new zzab(this));
        } else {
            return this.zzf.zzF(this.zzb, (PhoneAuthCredential) zza2, this.zzl, new zzab(this));
        }
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzC(this.zzb, str, this.zzl, new zzab(this));
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zzY(str, str2, this.zzl, (FirebaseUser) null, false);
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzN();
        zzbv zzbv = this.zzv;
        if (zzbv != null) {
            zzbv.zzc();
        }
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaag.zza(new Status(17057)));
        }
        this.zzr.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public void useAppLanguage() {
        synchronized (this.zzi) {
            this.zzj = zzaav.zza();
        }
    }

    public void useEmulator(String str, int i) {
        Preconditions.checkNotEmpty(str);
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        Preconditions.checkArgument(z, "Port number must be in the range 0-65535");
        zzace.zzf(this.zzb, str, i);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzP(this.zzb, str, this.zzl);
    }

    public final synchronized zzbr zzA() {
        return this.zzm;
    }

    public final synchronized zzbv zzB() {
        return zzC(this);
    }

    public final Provider zzD() {
        return this.zzt;
    }

    public final Provider zzE() {
        return this.zzu;
    }

    public final Executor zzK() {
        return this.zzw;
    }

    public final Executor zzL() {
        return this.zzx;
    }

    public final Executor zzM() {
        return this.zzy;
    }

    public final void zzN() {
        Preconditions.checkNotNull(this.zzq);
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser != null) {
            zzbt zzbt = this.zzq;
            Preconditions.checkNotNull(firebaseUser);
            zzbt.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzg = null;
        }
        this.zzq.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzR(this, (FirebaseUser) null);
        zzQ(this, (FirebaseUser) null);
    }

    public final synchronized void zzO(zzbr zzbr) {
        this.zzm = zzbr;
    }

    public final void zzP(FirebaseUser firebaseUser, zzade zzade, boolean z) {
        zzS(this, firebaseUser, zzade, true, false);
    }

    public final void zzT(PhoneAuthOptions phoneAuthOptions) {
        String str;
        String str2;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth zzb2 = phoneAuthOptions.zzb();
            if (((zzag) Preconditions.checkNotNull(phoneAuthOptions.zzc())).zze()) {
                str2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                str = str2;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                String checkNotEmpty = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                str2 = phoneMultiFactorInfo.getPhoneNumber();
                str = checkNotEmpty;
            }
            if (phoneAuthOptions.zzd() == null || !zzabu.zzd(str, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb2.zzs.zza(zzb2, str2, phoneAuthOptions.zza(), zzb2.zzV(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzk(zzb2, phoneAuthOptions, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions.zzb();
        String checkNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() != null || !zzabu.zzd(checkNotEmpty2, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            zzb3.zzs.zza(zzb3, checkNotEmpty2, phoneAuthOptions.zza(), zzb3.zzV(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzj(zzb3, phoneAuthOptions, checkNotEmpty2));
        }
    }

    public final void zzU(PhoneAuthOptions phoneAuthOptions, String str, String str2) {
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        zzado zzado = new zzado(checkNotEmpty, longValue, phoneAuthOptions.zzd() != null, this.zzj, this.zzl, str, str2, zzV());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzaa = zzaa(checkNotEmpty, phoneAuthOptions.zze());
        this.zzf.zzR(this.zzb, zzado, TextUtils.isEmpty(str) ? zzx(phoneAuthOptions, zzaa) : zzaa, phoneAuthOptions.zza(), phoneAuthOptions.zzi());
    }

    /* access modifiers changed from: package-private */
    public final boolean zzV() {
        return zzaal.zza(getApp().getApplicationContext());
    }

    public final Task zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zze(firebaseUser, new zzr(this, firebaseUser));
    }

    public final Task zzb(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (!(multiFactorAssertion instanceof PhoneMultiFactorAssertion)) {
            return Tasks.forException(zzaag.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
        }
        return this.zzf.zzg(this.zzb, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzab(this));
    }

    public final Task zzc(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaag.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzade zzd2 = firebaseUser.zzd();
        if (!zzd2.zzj() || z) {
            return this.zzf.zzj(this.zzb, firebaseUser, zzd2.zzf(), new zzw(this));
        }
        return Tasks.forResult(zzba.zza(zzd2.zze()));
    }

    public final Task zzd() {
        return this.zzf.zzk();
    }

    public final Task zze(String str) {
        return this.zzf.zzl(this.zzl, "RECAPTCHA_ENTERPRISE");
    }

    public final Task zzf(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzm(this.zzb, firebaseUser, authCredential.zza(), new zzac(this));
    }

    public final Task zzg(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzX(firebaseUser, emailAuthCredential, false);
            }
            if (zzab(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaag.zza(new Status(17072)));
            }
            return zzX(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzt(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzac(this));
        } else {
            return this.zzf.zzn(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzac(this));
        }
    }

    public final Task zzh(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzY(emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), firebaseUser.getTenantId(), firebaseUser, true);
            } else if (zzab(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaag.zza(new Status(17072)));
            } else {
                return zzZ(emailAuthCredential, firebaseUser, true);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzu(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzac(this));
        } else {
            return this.zzf.zzo(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzac(this));
        }
    }

    public final Task zzi(FirebaseUser firebaseUser, zzbw zzbw) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzv(this.zzb, firebaseUser, zzbw);
    }

    public final Task zzj(MultiFactorAssertion multiFactorAssertion, zzag zzag, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzag);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzf.zzh(this.zzb, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzag.zzd()), new zzab(this));
        } else if (multiFactorAssertion instanceof zzat) {
            return this.zzf.zzi(this.zzb, firebaseUser, (zzat) multiFactorAssertion, Preconditions.checkNotEmpty(zzag.zzd()), new zzab(this), this.zzl);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final Task zzk(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzj != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.zzj);
        }
        return this.zzf.zzw(this.zzb, actionCodeSettings, str);
    }

    public final Task zzl(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaag.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task zzm(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaag.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task zzn(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzI(this.zzb, firebaseUser, str, this.zzl, new zzac(this)).continueWithTask(new zzq(this));
    }

    public final Task zzo(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzJ(this.zzb, firebaseUser, str, new zzac(this));
    }

    public final Task zzp(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzK(this.zzb, firebaseUser, str, new zzac(this));
    }

    public final Task zzq(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzL(this.zzb, firebaseUser, str, new zzac(this));
    }

    public final Task zzr(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzf.zzM(this.zzb, firebaseUser, phoneAuthCredential.clone(), new zzac(this));
    }

    public final Task zzs(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzf.zzN(this.zzb, firebaseUser, userProfileChangeRequest, new zzac(this));
    }

    public final Task zzt(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzj;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.zzf.zzO(str, str2, actionCodeSettings);
    }

    /* access modifiers changed from: package-private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzx(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (phoneAuthOptions.zzk()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzm(this, phoneAuthOptions, onVerificationStateChangedCallbacks);
    }

    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzd.remove(idTokenListener);
        zzB().zzd(this.zzd.size());
    }

    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzl)) || ((str = this.zzl) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzaag.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zzb.getOptions().getApiKey();
            if (!firebaseUser.zzd().zzj() || !apiKey2.equals(apiKey)) {
                return zzi(firebaseUser, new zzad(this));
            }
            zzP(zzx.zzk(this.zzb, firebaseUser), firebaseUser.zzd(), true);
            return Tasks.forResult(null);
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzd.add(idTokenListener);
        zzB().zzd(this.zzd.size());
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzj;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return new zzo(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
    }
}
