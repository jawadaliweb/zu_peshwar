package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzw {
    private zzw() {
    }

    public /* synthetic */ zzw(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae A[Catch:{ all -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0165 A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019b A[SYNTHETIC, Splitter:B:66:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d4 A[SYNTHETIC, Splitter:B:74:0x01d4] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(android.app.Application r24, java.lang.String r25, com.google.android.recaptcha.internal.zzr r26, android.webkit.WebView r27, kotlin.coroutines.Continuation r28) throws kotlinx.coroutines.TimeoutCancellationException, com.google.android.gms.common.api.ApiException {
        /*
            r23 = this;
            r0 = r28
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzv
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.google.android.recaptcha.internal.zzv r1 = (com.google.android.recaptcha.internal.zzv) r1
            int r2 = r1.zzg
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.zzg = r2
            r2 = r23
            goto L_0x001e
        L_0x0017:
            com.google.android.recaptcha.internal.zzv r1 = new com.google.android.recaptcha.internal.zzv
            r2 = r23
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.zze
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.zzg
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x0084
            if (r4 == r7) goto L_0x0069
            if (r4 == r6) goto L_0x004a
            if (r4 == r5) goto L_0x003a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            java.lang.Object r3 = r1.zzb
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.Object r1 = r1.zza
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x01d2
        L_0x0047:
            r0 = move-exception
            goto L_0x01de
        L_0x004a:
            java.lang.Object r4 = r1.zzd
            com.google.android.recaptcha.internal.zzda r4 = (com.google.android.recaptcha.internal.zzda) r4
            java.lang.Object r6 = r1.zzc
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r9 = r1.zzb
            com.google.android.recaptcha.internal.zzr r9 = (com.google.android.recaptcha.internal.zzr) r9
            java.lang.Object r10 = r1.zza
            android.app.Application r10 = (android.app.Application) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0065 }
            kotlin.Result r0 = (kotlin.Result) r0     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.m67unboximpl()     // Catch:{ all -> 0x0065 }
            goto L_0x015f
        L_0x0065:
            r0 = move-exception
            r1 = r6
            goto L_0x01de
        L_0x0069:
            java.lang.Object r4 = r1.zzd
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            com.google.android.recaptcha.internal.zzw r9 = r1.zzh
            android.webkit.WebView r9 = (android.webkit.WebView) r9
            java.lang.Object r10 = r1.zzc
            com.google.android.recaptcha.internal.zzr r10 = (com.google.android.recaptcha.internal.zzr) r10
            java.lang.Object r11 = r1.zzb
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.zza
            android.app.Application r12 = (android.app.Application) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r9
            r9 = r4
            r4 = r12
            goto L_0x00a6
        L_0x0084:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = com.google.android.recaptcha.internal.zzaa.zze
            r4 = r24
            r1.zza = r4
            r9 = r25
            r1.zzb = r9
            r10 = r26
            r1.zzc = r10
            r1.zzh = r8
            r1.zzd = r0
            r1.zzg = r7
            java.lang.Object r11 = r0.lock(r8, r1)
            if (r11 == r3) goto L_0x01e2
            r11 = r9
            r9 = r0
            r0 = r8
        L_0x00a6:
            java.lang.String r12 = "android.permission.INTERNET"
            int r12 = androidx.core.content.ContextCompat.checkSelfPermission(r4, r12)     // Catch:{ all -> 0x01dc }
            if (r12 != 0) goto L_0x01d4
            com.google.android.recaptcha.internal.zzaa r12 = com.google.android.recaptcha.internal.zzaa.zzb     // Catch:{ all -> 0x01dc }
            if (r12 == 0) goto L_0x00b6
            goto L_0x0197
        L_0x00b6:
            com.google.android.recaptcha.internal.zzw r15 = com.google.android.recaptcha.internal.zzaa.zza     // Catch:{ all -> 0x01dc }
            java.util.UUID r12 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x01dc }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzaa.zzd = r12     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzai r12 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzaf r12 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzkw r17 = com.google.android.recaptcha.internal.zzkw.INIT_TOTAL     // Catch:{ all -> 0x01dc }
            java.lang.String r18 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x01dc }
            java.lang.String r13 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x01dc }
            if (r13 != 0) goto L_0x00d6
            r19 = r8
            goto L_0x00d8
        L_0x00d6:
            r19 = r13
        L_0x00d8:
            java.lang.String r13 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x01dc }
            if (r13 != 0) goto L_0x00e1
            r20 = r8
            goto L_0x00e3
        L_0x00e1:
            r20 = r13
        L_0x00e3:
            r21 = 0
            r16 = r12
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzs r13 = new com.google.android.recaptcha.internal.zzs     // Catch:{ all -> 0x01dc }
            r13.<init>()     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzai.zzb(r12, r11, r13)     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzda r14 = new com.google.android.recaptcha.internal.zzda     // Catch:{ all -> 0x01dc }
            if (r0 != 0) goto L_0x00fb
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x01dc }
            r0.<init>(r4)     // Catch:{ all -> 0x01dc }
        L_0x00fb:
            java.lang.String r18 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x01dc }
            java.lang.String r12 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x01dc }
            if (r12 != 0) goto L_0x0108
            r19 = r8
            goto L_0x010a
        L_0x0108:
            r19 = r12
        L_0x010a:
            com.google.android.recaptcha.internal.zzao r20 = new com.google.android.recaptcha.internal.zzao     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzaq r13 = new com.google.android.recaptcha.internal.zzaq     // Catch:{ all -> 0x01dc }
            java.lang.String r12 = r10.zzc()     // Catch:{ all -> 0x01dc }
            r13.<init>(r12)     // Catch:{ all -> 0x01dc }
            r16 = 0
            r17 = 4
            r21 = 0
            r12 = r20
            r22 = r13
            r13 = r4
            r24 = r14
            r14 = r22
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r21
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.internal.zzp r12 = com.google.android.recaptcha.internal.zzp.zza     // Catch:{ all -> 0x01dc }
            kotlinx.coroutines.CoroutineScope r21 = com.google.android.recaptcha.internal.zzp.zzb()     // Catch:{ all -> 0x01dc }
            r12 = r24
            r13 = r0
            r14 = r11
            r15 = r4
            r16 = r10
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x01dc }
            r1.zza = r4     // Catch:{ all -> 0x01dc }
            r1.zzb = r10     // Catch:{ all -> 0x01dc }
            r1.zzc = r9     // Catch:{ all -> 0x01dc }
            r1.zzh = r5     // Catch:{ all -> 0x01dc }
            r0 = r24
            r1.zzd = r0     // Catch:{ all -> 0x01dc }
            r1.zzg = r6     // Catch:{ all -> 0x01dc }
            java.lang.Object r5 = r0.zzg(r1)     // Catch:{ all -> 0x01dc }
            if (r5 == r3) goto L_0x01d3
            r6 = r9
            r9 = r10
            r10 = r4
            r4 = r0
            r0 = r5
        L_0x015f:
            java.lang.Throwable r0 = kotlin.Result.m61exceptionOrNullimpl(r0)     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x019b
            com.google.android.recaptcha.internal.zzaa r12 = new com.google.android.recaptcha.internal.zzaa     // Catch:{ all -> 0x0065 }
            r12.<init>(r4)     // Catch:{ all -> 0x0065 }
            com.google.android.recaptcha.internal.zzai r0 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ all -> 0x0065 }
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ all -> 0x0065 }
            com.google.android.recaptcha.internal.zzkw r14 = com.google.android.recaptcha.internal.zzkw.INIT_TOTAL     // Catch:{ all -> 0x0065 }
            java.lang.String r15 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x017d
            r16 = r8
            goto L_0x017f
        L_0x017d:
            r16 = r1
        L_0x017f:
            java.lang.String r1 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0188
            r17 = r8
            goto L_0x018a
        L_0x0188:
            r17 = r1
        L_0x018a:
            r18 = 0
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0065 }
            com.google.android.recaptcha.internal.zzai.zzc(r0, r10, r9)     // Catch:{ all -> 0x0065 }
            com.google.android.recaptcha.internal.zzaa.zzb = r12     // Catch:{ all -> 0x0065 }
            r9 = r6
        L_0x0197:
            r9.unlock(r8)
            return r12
        L_0x019b:
            com.google.android.recaptcha.internal.zzp r4 = com.google.android.recaptcha.internal.zzp.zza     // Catch:{ all -> 0x0065 }
            kotlinx.coroutines.CoroutineScope r4 = com.google.android.recaptcha.internal.zzp.zzc()     // Catch:{ all -> 0x0065 }
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()     // Catch:{ all -> 0x0065 }
            kotlinx.coroutines.JobKt__JobKt.cancelChildren$default((kotlin.coroutines.CoroutineContext) r4, (java.util.concurrent.CancellationException) r8, (int) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0065 }
            kotlinx.coroutines.CoroutineScope r4 = com.google.android.recaptcha.internal.zzp.zzc()     // Catch:{ all -> 0x0065 }
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()     // Catch:{ all -> 0x0065 }
            kotlinx.coroutines.Job r4 = kotlinx.coroutines.JobKt.getJob(r4)     // Catch:{ all -> 0x0065 }
            kotlin.sequences.Sequence r4 = r4.getChildren()     // Catch:{ all -> 0x0065 }
            java.util.List r4 = kotlin.sequences.SequencesKt.toList(r4)     // Catch:{ all -> 0x0065 }
            r1.zza = r6     // Catch:{ all -> 0x0065 }
            r1.zzb = r0     // Catch:{ all -> 0x0065 }
            r1.zzc = r8     // Catch:{ all -> 0x0065 }
            r1.zzh = r8     // Catch:{ all -> 0x0065 }
            r1.zzd = r8     // Catch:{ all -> 0x0065 }
            r5 = 3
            r1.zzg = r5     // Catch:{ all -> 0x0065 }
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1)     // Catch:{ all -> 0x0065 }
            if (r1 != r3) goto L_0x01d0
            return r3
        L_0x01d0:
            r3 = r0
            r1 = r6
        L_0x01d2:
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x01d3:
            return r3
        L_0x01d4:
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ all -> 0x01dc }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.NETWORK_ERROR     // Catch:{ all -> 0x01dc }
            r0.<init>(r1, r8, r6, r8)     // Catch:{ all -> 0x01dc }
            throw r0     // Catch:{ all -> 0x01dc }
        L_0x01dc:
            r0 = move-exception
            r1 = r9
        L_0x01de:
            r1.unlock(r8)
            throw r0
        L_0x01e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzw.zza(android.app.Application, java.lang.String, com.google.android.recaptcha.internal.zzr, android.webkit.WebView, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
