package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzada;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzb implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ IntegrityManager zzb;
    final /* synthetic */ zzf zzc;

    zzb(zzf zzf, String str, IntegrityManager integrityManager) {
        this.zzc = zzf;
        this.zza = str;
        this.zzb = integrityManager;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = ((zzada) task.getResult()).zzb();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzada) task.getResult()).zzb())).setNonce(new String(Base64.encode(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(this.zza.getBytes("UTF-8")), 11))).build());
        }
        Log.e(zzf.zza, "Problem retrieving Play Integrity producer project:  ".concat(String.valueOf(task.getException().getMessage())));
        return Tasks.forException(task.getException());
    }
}
