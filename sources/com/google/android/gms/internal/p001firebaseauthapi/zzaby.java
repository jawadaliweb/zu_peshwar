package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaby  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaby extends BroadcastReceiver {
    final /* synthetic */ zzaca zza;
    private final String zzb;

    public zzaby(zzaca zzaca, String str) {
        this.zza = zzaca;
        this.zzb = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzabz zzabz = (zzabz) this.zza.zzd.get(this.zzb);
                if (zzabz == null) {
                    zzaca.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
                    zzabz.zze = matcher.find() ? matcher.group() : null;
                    if (zzabz.zze == null) {
                        zzaca.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzd(zzabz.zzd)) {
                        zzaca.zzd(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
