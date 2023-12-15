package com.google.android.gms.internal.p001firebaseauthapi;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzabx extends zzaae {
    final /* synthetic */ zzaca zza;
    private final String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzabx(zzaca zzaca, zzaae zzaae, String str) {
        super(zzaae);
        this.zza = zzaca;
        this.zzb = str;
    }

    public final void zzb(String str) {
        zzaca.zza.d("onCodeSent", new Object[0]);
        zzabz zzabz = (zzabz) this.zza.zzd.get(this.zzb);
        if (zzabz != null) {
            for (zzaae zzb2 : zzabz.zzb) {
                zzb2.zzb(str);
            }
            zzabz.zzg = true;
            zzabz.zzd = str;
            if (zzabz.zza <= 0) {
                this.zza.zzg(this.zzb);
            } else if (!zzabz.zzc) {
                this.zza.zzm(this.zzb);
            } else if (!zzac.zzd(zzabz.zze)) {
                zzaca.zzd(this.zza, this.zzb);
            }
        }
    }

    public final void zzh(Status status) {
        Logger zza2 = zzaca.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        zza2.e("SMS verification code request failed: " + statusCodeString + MaskedEditText.SPACE + statusMessage, new Object[0]);
        zzabz zzabz = (zzabz) this.zza.zzd.get(this.zzb);
        if (zzabz != null) {
            for (zzaae zzh : zzabz.zzb) {
                zzh.zzh(status);
            }
            this.zza.zzi(this.zzb);
        }
    }
}
