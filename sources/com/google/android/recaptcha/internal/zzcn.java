package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcn implements zzby {
    public static final zzcn zza = new zzcn();

    private zzcn() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        if (objArr.length == 2) {
            int[] iArr = objArr[0];
            if (true != (iArr instanceof int[])) {
                iArr = null;
            }
            int[] iArr2 = iArr;
            if (iArr2 != null) {
                String str = objArr[1];
                if (true != (str instanceof String)) {
                    str = null;
                }
                String str2 = str;
                if (str2 != null) {
                    zzbm zzc = zzbl.zzc();
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (int charAt : iArr2) {
                            sb.append(str2.charAt(charAt));
                        }
                        zzc.zzf(i, sb.toString());
                    } catch (Exception e) {
                        throw new zzt(4, 22, e);
                    }
                } else {
                    throw new zzt(4, 5, (Throwable) null);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }
}
