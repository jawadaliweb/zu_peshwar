package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzly  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzly {
    public static final Charset zza = Charset.forName("UTF-8");

    public static int zza() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & ByteCompanionObject.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        }
        return b;
    }

    public static final zzvx zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new zzlx("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return zzvx.zzb(bArr);
    }
}
