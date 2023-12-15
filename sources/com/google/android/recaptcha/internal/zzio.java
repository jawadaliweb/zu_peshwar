package com.google.android.recaptcha.internal;

import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzio extends zziy {
    zzio(int i) {
        super(i, (zzix) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                ((zzgd) zzg(i).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzgd) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
