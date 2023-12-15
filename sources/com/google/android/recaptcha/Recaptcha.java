package com.google.android.recaptcha;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.internal.zzb;
import com.google.android.recaptcha.internal.zzp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/google/android/recaptcha/Recaptcha;", "", "()V", "getClient", "Lkotlin/Result;", "Lcom/google/android/recaptcha/RecaptchaClient;", "application", "Landroid/app/Application;", "siteKey", "", "getClient-0E7RQCE", "(Landroid/app/Application;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasksClient", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/recaptcha/RecaptchaTasksClient;", "java.com.google.android.libraries.abuse.recaptcha.enterprise_enterprise"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class Recaptcha {
    public static final Recaptcha INSTANCE = new Recaptcha();

    private Recaptcha() {
    }

    @JvmStatic
    public static final Task<RecaptchaTasksClient> getTasksClient(Application application, String str) {
        zzp zzp = zzp.zza;
        return zzb.zza(BuildersKt__Builders_commonKt.async$default(zzp.zzb(), (CoroutineContext) null, (CoroutineStart) null, new Recaptcha$getTasksClient$1(application, str, (Continuation) null), 3, (Object) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: getClient-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1getClient0E7RQCE(android.app.Application r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.google.android.recaptcha.RecaptchaClient>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.Recaptcha$getClient$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = (com.google.android.recaptcha.Recaptcha$getClient$1) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = new com.google.android.recaptcha.Recaptcha$getClient$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0029 }
            goto L_0x0051
        L_0x0029:
            r6 = move-exception
            goto L_0x0058
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0029 }
            com.google.android.recaptcha.internal.zzp r8 = com.google.android.recaptcha.internal.zzp.zza     // Catch:{ all -> 0x0029 }
            kotlinx.coroutines.CoroutineScope r8 = com.google.android.recaptcha.internal.zzp.zzb()     // Catch:{ all -> 0x0029 }
            kotlin.coroutines.CoroutineContext r8 = r8.getCoroutineContext()     // Catch:{ all -> 0x0029 }
            com.google.android.recaptcha.Recaptcha$getClient$2$1 r2 = new com.google.android.recaptcha.Recaptcha$getClient$2$1     // Catch:{ all -> 0x0029 }
            r4 = 0
            r2.<init>(r6, r7, r4)     // Catch:{ all -> 0x0029 }
            r0.zzc = r3     // Catch:{ all -> 0x0029 }
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch:{ all -> 0x0029 }
            if (r8 != r1) goto L_0x0051
            return r1
        L_0x0051:
            com.google.android.recaptcha.internal.zzaa r8 = (com.google.android.recaptcha.internal.zzaa) r8     // Catch:{ all -> 0x0029 }
            java.lang.Object r6 = kotlin.Result.m58constructorimpl(r8)     // Catch:{ all -> 0x0029 }
            goto L_0x0062
        L_0x0058:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m58constructorimpl(r6)
        L_0x0062:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.Recaptcha.m1getClient0E7RQCE(android.app.Application, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
