package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.ServerValues;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzby {
    private static final zzby zza = new zzby();
    private final zzbf zzb;
    private final zzax zzc;

    private zzby() {
        zzbf zzc2 = zzbf.zzc();
        zzax zza2 = zzax.zza();
        this.zzb = zzc2;
        this.zzc = zza2;
    }

    public static zzby zzc() {
        return zza;
    }

    public final Task zza() {
        return this.zzb.zza();
    }

    public final Task zzb() {
        return this.zzb.zzb();
    }

    public final void zzd(Context context) {
        this.zzb.zzd(context);
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        this.zzb.zze(firebaseAuth);
    }

    public final void zzf(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong(ServerValues.NAME_OP_TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public final void zzg(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.commit();
    }

    public final void zzh(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.putString("firebaseUserUid", firebaseUser.getUid());
        edit.commit();
    }

    public final boolean zzi(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, (FirebaseUser) null);
    }

    public final boolean zzj(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
