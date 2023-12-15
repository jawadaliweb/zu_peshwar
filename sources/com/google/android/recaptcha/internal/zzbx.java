package com.google.android.recaptcha.internal;

import kotlin.UInt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final /* synthetic */ class zzbx {
    public static String zza(zzby zzby, String str, byte b) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) UInt.m152constructorimpl(UInt.m152constructorimpl(str.charAt(i)) ^ UInt.m152constructorimpl(b)));
        }
        return sb.toString();
    }

    public static void zzb(zzby zzby, int i, int i2) throws zzt {
        if (i != i2) {
            throw new zzt(4, 24, (Throwable) null);
        }
    }
}
