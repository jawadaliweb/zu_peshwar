package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzb extends ContextCompat {
    @Deprecated
    public static Intent zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (!zza.zza()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, true != zza.zza() ? 0 : 2);
    }
}
