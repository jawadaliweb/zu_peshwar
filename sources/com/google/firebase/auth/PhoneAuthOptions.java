package com.google.firebase.auth;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class PhoneAuthOptions {
    private final FirebaseAuth zza;
    private final Long zzb;
    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc;
    private final Executor zzd;
    private final String zze;
    private final Activity zzf;
    private final PhoneAuthProvider.ForceResendingToken zzg;
    private final MultiFactorSession zzh;
    private final PhoneMultiFactorInfo zzi;
    private final boolean zzj;
    private boolean zzk;

    /* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
    public static final class Builder {
        private final FirebaseAuth zza;
        private String zzb;
        private Long zzc;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
        private Executor zze;
        private Activity zzf;
        private PhoneAuthProvider.ForceResendingToken zzg;
        private MultiFactorSession zzh;
        private PhoneMultiFactorInfo zzi;
        private boolean zzj;

        public Builder(FirebaseAuth firebaseAuth) {
            this.zza = (FirebaseAuth) Preconditions.checkNotNull(firebaseAuth);
        }

        public PhoneAuthOptions build() {
            Preconditions.checkNotNull(this.zza, "FirebaseAuth instance cannot be null");
            Preconditions.checkNotNull(this.zzc, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            Preconditions.checkNotNull(this.zzd, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            this.zze = this.zza.zzM();
            if (this.zzc.longValue() < 0 || this.zzc.longValue() > 120) {
                throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            }
            MultiFactorSession multiFactorSession = this.zzh;
            boolean z = false;
            if (multiFactorSession == null) {
                Preconditions.checkNotEmpty(this.zzb, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                Preconditions.checkArgument(!this.zzj, "You cannot require sms validation without setting a multi-factor session.");
                if (this.zzi == null) {
                    z = true;
                }
                Preconditions.checkArgument(z, "A phoneMultiFactorInfo must be set for second factor sign-in.");
            } else if (((zzag) multiFactorSession).zze()) {
                Preconditions.checkNotEmpty(this.zzb);
                if (this.zzi == null) {
                    z = true;
                }
                Preconditions.checkArgument(z, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
            } else {
                Preconditions.checkArgument(this.zzi != null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                if (this.zzb == null) {
                    z = true;
                }
                Preconditions.checkArgument(z, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
            }
            return new PhoneAuthOptions(this.zza, this.zzc, this.zzd, this.zze, this.zzb, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, (zzaq) null);
        }

        public Builder requireSmsValidation(boolean z) {
            this.zzj = z;
            return this;
        }

        public Builder setActivity(Activity activity) {
            this.zzf = activity;
            return this;
        }

        public Builder setCallbacks(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
            this.zzd = onVerificationStateChangedCallbacks;
            return this;
        }

        public Builder setForceResendingToken(PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            this.zzg = forceResendingToken;
            return this;
        }

        public Builder setMultiFactorHint(PhoneMultiFactorInfo phoneMultiFactorInfo) {
            this.zzi = phoneMultiFactorInfo;
            return this;
        }

        public Builder setMultiFactorSession(MultiFactorSession multiFactorSession) {
            this.zzh = multiFactorSession;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setTimeout(Long l, TimeUnit timeUnit) {
            this.zzc = Long.valueOf(TimeUnit.SECONDS.convert(l.longValue(), timeUnit));
            return this;
        }
    }

    /* synthetic */ PhoneAuthOptions(FirebaseAuth firebaseAuth, Long l, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, String str, Activity activity, PhoneAuthProvider.ForceResendingToken forceResendingToken, MultiFactorSession multiFactorSession, PhoneMultiFactorInfo phoneMultiFactorInfo, boolean z, zzaq zzaq) {
        this.zza = firebaseAuth;
        this.zze = str;
        this.zzb = l;
        this.zzc = onVerificationStateChangedCallbacks;
        this.zzf = activity;
        this.zzd = executor;
        this.zzg = forceResendingToken;
        this.zzh = multiFactorSession;
        this.zzi = phoneMultiFactorInfo;
        this.zzj = z;
    }

    public static Builder newBuilder() {
        return new Builder(FirebaseAuth.getInstance());
    }

    public final Activity zza() {
        return this.zzf;
    }

    public final FirebaseAuth zzb() {
        return this.zza;
    }

    public final MultiFactorSession zzc() {
        return this.zzh;
    }

    public final PhoneAuthProvider.ForceResendingToken zzd() {
        return this.zzg;
    }

    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zze() {
        return this.zzc;
    }

    public final PhoneMultiFactorInfo zzf() {
        return this.zzi;
    }

    public final Long zzg() {
        return this.zzb;
    }

    public final String zzh() {
        return this.zze;
    }

    public final Executor zzi() {
        return this.zzd;
    }

    public final void zzj(boolean z) {
        this.zzk = true;
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zzh != null;
    }

    public static Builder newBuilder(FirebaseAuth firebaseAuth) {
        return new Builder(firebaseAuth);
    }
}
