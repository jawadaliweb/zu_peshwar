package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
class zzafc extends zzafb {
    protected final byte[] zza;

    zzafc(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaff) || zzd() != ((zzaff) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzafc)) {
            return obj.equals(this);
        }
        zzafc zzafc = (zzafc) obj;
        int zzm = zzm();
        int zzm2 = zzafc.zzm();
        if (zzm != 0 && zzm2 != 0 && zzm != zzm2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzafc.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd > zzafc.zzd()) {
            int zzd3 = zzafc.zzd();
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
        } else if (!(zzafc instanceof zzafc)) {
            return zzafc.zzg(0, zzd).equals(zzg(0, zzd));
        } else {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzafc.zza;
            zzafc.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzd) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i, int i2, int i3) {
        return zzagq.zzb(i, this.zza, 0, i3);
    }

    public final zzaff zzg(int i, int i2) {
        int zzl = zzl(0, i2, zzd());
        if (zzl == 0) {
            return zzaff.zzb;
        }
        return new zzaez(this.zza, 0, zzl);
    }

    public final zzafl zzh() {
        return zzafl.zzH(this.zza, 0, zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzaev zzaev) throws IOException {
        zzaev.zza(this.zza, 0, zzd());
    }

    public final boolean zzk() {
        return zzajk.zzf(this.zza, 0, zzd());
    }
}
