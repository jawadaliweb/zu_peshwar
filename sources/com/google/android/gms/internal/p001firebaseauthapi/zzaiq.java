package com.google.android.gms.internal.p001firebaseauthapi;

import org.apache.commons.compress.archivers.tar.TarConstants;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaiq {
    static String zza(zzaff zzaff) {
        StringBuilder sb = new StringBuilder(zzaff.zzd());
        for (int i = 0; i < zzaff.zzd(); i++) {
            byte zza = zzaff.zza(i);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zza >= 32 && zza <= 126) {
                            sb.append((char) zza);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + TarConstants.LF_NORMAL));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
