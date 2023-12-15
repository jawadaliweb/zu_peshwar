package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzabu {
    private static final Map zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzabg zzabg) {
        zze(str, zzabg);
        return new zzabs(onVerificationStateChangedCallbacks, str);
    }

    public static void zzc() {
        zza.clear();
    }

    public static boolean zzd(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map map = zza;
        if (map.containsKey(str)) {
            zzabt zzabt = (zzabt) map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzabt.zzb < 120000) {
                zzabg zzabg = zzabt.zza;
                if (zzabg == null) {
                    return true;
                }
                zzabg.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zze(str, (zzabg) null);
            return false;
        }
        zze(str, (zzabg) null);
        return false;
    }

    private static void zze(String str, zzabg zzabg) {
        zza.put(str, new zzabt(zzabg, DefaultClock.getInstance().currentTimeMillis()));
    }
}
