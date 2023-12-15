package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaau {
    private final Context zza;
    private zzabp zzb;
    private final String zzc;
    private final FirebaseApp zzd;
    private boolean zze = false;
    private String zzf;

    public zzaau(Context context, FirebaseApp firebaseApp, String str) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzd = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzc = String.format("Android/%s/%s", new Object[]{"Fallback", str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.net.URLConnection r7) {
        /*
            r6 = this;
            boolean r0 = r6.zze
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r6.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "/FirebaseUI-Android"
            java.lang.String r0 = r0.concat(r1)
            goto L_0x001d
        L_0x0011:
            java.lang.String r0 = r6.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "/FirebaseCore-Android"
            java.lang.String r0 = r0.concat(r1)
        L_0x001d:
            com.google.android.gms.internal.firebase-auth-api.zzabp r1 = r6.zzb
            if (r1 != 0) goto L_0x002e
            com.google.android.gms.internal.firebase-auth-api.zzabp r1 = new com.google.android.gms.internal.firebase-auth-api.zzabp
            android.content.Context r2 = r6.zza
            java.lang.String r3 = r2.getPackageName()
            r1.<init>(r2, r3)
            r6.zzb = r1
        L_0x002e:
            com.google.android.gms.internal.firebase-auth-api.zzabp r1 = r6.zzb
            java.lang.String r1 = r1.zzb()
            java.lang.String r2 = "X-Android-Package"
            r7.setRequestProperty(r2, r1)
            com.google.android.gms.internal.firebase-auth-api.zzabp r1 = r6.zzb
            java.lang.String r1 = r1.zza()
            java.lang.String r2 = "X-Android-Cert"
            r7.setRequestProperty(r2, r1)
            java.lang.String r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaav.zza()
            java.lang.String r2 = "Accept-Language"
            r7.setRequestProperty(r2, r1)
            java.lang.String r1 = "X-Client-Version"
            r7.setRequestProperty(r1, r0)
            java.lang.String r0 = r6.zzf
            java.lang.String r1 = "X-Firebase-Locale"
            r7.setRequestProperty(r1, r0)
            com.google.firebase.FirebaseApp r0 = r6.zzd
            com.google.firebase.FirebaseOptions r0 = r0.getOptions()
            java.lang.String r0 = r0.getApplicationId()
            java.lang.String r1 = "X-Firebase-GMPID"
            r7.setRequestProperty(r1, r0)
            com.google.firebase.FirebaseApp r0 = r6.zzd
            com.google.firebase.auth.FirebaseAuth r0 = com.google.firebase.auth.FirebaseAuth.getInstance(r0)
            com.google.firebase.inject.Provider r0 = r0.zzE()
            java.lang.Object r0 = r0.get()
            com.google.firebase.heartbeatinfo.HeartBeatController r0 = (com.google.firebase.heartbeatinfo.HeartBeatController) r0
            java.lang.String r1 = "LocalRequestInterceptor"
            r2 = 0
            if (r0 == 0) goto L_0x009c
            com.google.android.gms.tasks.Task r0 = r0.getHeartBeatsHeader()     // Catch:{ ExecutionException -> 0x008a, InterruptedException -> 0x0088 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0)     // Catch:{ ExecutionException -> 0x008a, InterruptedException -> 0x0088 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ExecutionException -> 0x008a, InterruptedException -> 0x0088 }
            goto L_0x009d
        L_0x0088:
            r0 = move-exception
            goto L_0x008b
        L_0x008a:
            r0 = move-exception
        L_0x008b:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Unable to get heartbeats: "
            java.lang.String r0 = r3.concat(r0)
            android.util.Log.w(r1, r0)
        L_0x009c:
            r0 = r2
        L_0x009d:
            java.lang.String r3 = "X-Firebase-Client"
            r7.setRequestProperty(r3, r0)
            com.google.firebase.FirebaseApp r0 = r6.zzd
            com.google.firebase.auth.FirebaseAuth r0 = com.google.firebase.auth.FirebaseAuth.getInstance(r0)
            com.google.firebase.inject.Provider r0 = r0.zzD()
            java.lang.Object r0 = r0.get()
            com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider r0 = (com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider) r0
            if (r0 != 0) goto L_0x00b6
        L_0x00b4:
            r0 = r2
            goto L_0x00fd
        L_0x00b6:
            r3 = 0
            com.google.android.gms.tasks.Task r0 = r0.getToken(r3)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            com.google.firebase.appcheck.AppCheckTokenResult r0 = (com.google.firebase.appcheck.AppCheckTokenResult) r0     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.Exception r3 = r0.getError()     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            if (r3 == 0) goto L_0x00e3
            java.lang.Exception r3 = r0.getError()     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            r4.<init>()     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.String r5 = "Error getting App Check token; using placeholder token instead. Error: "
            r4.append(r5)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            r4.append(r3)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            java.lang.String r3 = r4.toString()     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            android.util.Log.w(r1, r3)     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
        L_0x00e3:
            java.lang.String r0 = r0.getToken()     // Catch:{ ExecutionException -> 0x00ea, InterruptedException -> 0x00e8 }
            goto L_0x00fd
        L_0x00e8:
            r0 = move-exception
            goto L_0x00eb
        L_0x00ea:
            r0 = move-exception
        L_0x00eb:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Unexpected error getting App Check token: "
            java.lang.String r0 = r3.concat(r0)
            android.util.Log.e(r1, r0)
            goto L_0x00b4
        L_0x00fd:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0108
            java.lang.String r1 = "X-Firebase-AppCheck"
            r7.setRequestProperty(r1, r0)
        L_0x0108:
            r6.zzf = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaau.zza(java.net.URLConnection):void");
    }

    public final void zzb(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }

    public final void zzc(String str) {
        this.zzf = str;
    }
}
