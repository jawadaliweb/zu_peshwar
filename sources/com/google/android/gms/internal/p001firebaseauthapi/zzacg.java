package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzacg extends zzadl {
    private final String zza;
    private final String zzb;

    zzacg(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzadl) {
            zzadl zzadl = (zzadl) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzadl.zzb()) : zzadl.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzadl.zza()) : zzadl.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "RecaptchaEnforcementState{provider=" + str + ", enforcementState=" + str2 + "}";
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zza;
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i ^ 1000003) * 1000003) ^ i2;
    }
}
