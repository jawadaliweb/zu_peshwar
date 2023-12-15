package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzbf;
import com.google.android.gms.internal.p001firebaseauthapi.zzbj;
import com.google.android.gms.internal.p001firebaseauthapi.zzca;
import com.google.android.gms.internal.p001firebaseauthapi.zzim;
import com.google.android.gms.internal.p001firebaseauthapi.zzir;
import com.google.android.gms.internal.p001firebaseauthapi.zzjp;
import com.google.android.gms.internal.p001firebaseauthapi.zzjr;
import com.google.android.gms.internal.p001firebaseauthapi.zzq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzk {
    private static zzk zza;
    private final String zzb;
    private final zzjr zzc;

    private zzk(Context context, String str, boolean z) {
        zzjr zzjr;
        this.zzb = str;
        try {
            zzim.zza();
            zzjp zzjp = new zzjp();
            zzjp.zzf(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str}));
            zzjp.zzd(zzir.zza);
            zzjp.zze(String.format("android-keystore://firebear_master_key_id.%s", new Object[]{str}));
            zzjr = zzjp.zzg();
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n".concat(String.valueOf(e.getMessage())));
            zzjr = null;
        }
        this.zzc = zzjr;
    }

    public static zzk zza(Context context, String str) {
        zzk zzk = zza;
        if (zzk == null || !zzq.zza(zzk.zzb, str)) {
            zza = new zzk(context, str, true);
        }
        return zza;
    }

    public final String zzb(String str) {
        String str2;
        zzjr zzjr = this.zzc;
        if (zzjr != null) {
            try {
                synchronized (zzjr) {
                    str2 = new String(((zzbj) this.zzc.zza().zze(zzbj.class)).zza(Base64.decode(str, 8), (byte[]) null), "UTF-8");
                }
                return str2;
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n".concat(String.valueOf(e.getMessage())));
                return null;
            }
        } else {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
    }

    public final String zzc() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzca zza2 = zzbf.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zzb().zzg(zza2);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n".concat(String.valueOf(e.getMessage())));
            return null;
        }
    }
}
