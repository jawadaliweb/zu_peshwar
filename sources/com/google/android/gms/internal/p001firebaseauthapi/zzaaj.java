package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzaaj {
    public static String zza(zzaak zzaak, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(str.getBytes()));
            int length = str2.length();
            int i = 0;
            while (i < length) {
                if (zze.zza(str2.charAt(i))) {
                    char[] charArray = str2.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (zze.zza(c)) {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    return String.valueOf(charArray);
                }
                i++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaak.zza.e("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }
}
