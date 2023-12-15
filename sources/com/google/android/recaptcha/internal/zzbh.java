package com.google.android.recaptcha.internal;

import kotlin.UInt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final /* synthetic */ class zzbh {
    public static String zza(zzbi zzbi, String str, byte b) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) UInt.m152constructorimpl(UInt.m152constructorimpl(str.charAt(i)) ^ UInt.m152constructorimpl(b)));
        }
        return sb.toString();
    }
}
