package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaca {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap zzd = new HashMap();

    zzaca(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    static /* bridge */ /* synthetic */ void zzd(zzaca zzaca, String str) {
        zzabz zzabz = (zzabz) zzaca.zzd.get(str);
        if (zzabz != null && !zzac.zzd(zzabz.zzd) && !zzac.zzd(zzabz.zze) && !zzabz.zzb.isEmpty()) {
            for (zzaae zzq : zzabz.zzb) {
                zzq.zzq(PhoneAuthCredential.zzc(zzabz.zzd, zzabz.zze));
            }
            zzabz.zzh = true;
        }
    }

    private static String zzl(String str, String str2) {
        String str3 = str + MaskedEditText.SPACE + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(str3.getBytes(zzk.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: ".concat(String.valueOf(e.getMessage())), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzm(String str) {
        zzabz zzabz = (zzabz) this.zzd.get(str);
        if (zzabz != null && !zzabz.zzh && !zzac.zzd(zzabz.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzaae zza2 : zzabz.zzb) {
                zza2.zza(zzabz.zzd);
            }
            zzabz.zzi = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzabz zzabz = (zzabz) this.zzd.get(str);
        if (zzabz != null) {
            if (!zzabz.zzi) {
                zzm(str);
            }
            zzi(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zzl = zzl(packageName, signatureArr[0].toCharsString());
            if (zzl != null) {
                return zzl;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzaae zzaae, String str) {
        zzabz zzabz = (zzabz) this.zzd.get(str);
        if (zzabz != null) {
            zzabz.zzb.add(zzaae);
            if (zzabz.zzg) {
                zzaae.zzb(zzabz.zzd);
            }
            if (zzabz.zzh) {
                zzaae.zzq(PhoneAuthCredential.zzc(zzabz.zzd, zzabz.zze));
            }
            if (zzabz.zzi) {
                zzaae.zza(zzabz.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(String str) {
        zzabz zzabz = (zzabz) this.zzd.get(str);
        if (zzabz != null) {
            ScheduledFuture scheduledFuture = zzabz.zzf;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                zzabz.zzf.cancel(false);
            }
            zzabz.zzb.clear();
            this.zzd.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(String str, zzaae zzaae, long j, boolean z) {
        this.zzd.put(str, new zzabz(j, z));
        zzh(zzaae, str);
        zzabz zzabz = (zzabz) this.zzd.get(str);
        long j2 = zzabz.zza;
        if (j2 <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzabz.zzf = this.zzc.schedule(new zzabv(this, str), j2, TimeUnit.SECONDS);
        if (!zzabz.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzaby zzaby = new zzaby(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        zzb.zza(this.zzb.getApplicationContext(), zzaby, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzabw(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(String str) {
        return this.zzd.get(str) != null;
    }
}
