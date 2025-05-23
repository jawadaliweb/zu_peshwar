package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzafq extends zzafn {
    private final OutputStream zzg;

    zzafq(OutputStream outputStream, int i) {
        super(i);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzG();
        }
    }

    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    public final void zzJ(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b);
    }

    public final void zzK(int i, boolean z) throws IOException {
        zzH(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : 0);
    }

    public final void zzL(int i, zzaff zzaff) throws IOException {
        zzs((i << 3) | 2);
        zzs(zzaff.zzd());
        zzaff.zzj(this);
    }

    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzp(bArr, 0, i2);
    }

    public final void zzh(int i, int i2) throws IOException {
        zzH(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    public final void zzi(int i) throws IOException {
        zzH(4);
        zzd(i);
    }

    public final void zzj(int i, long j) throws IOException {
        zzH(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    public final void zzk(long j) throws IOException {
        zzH(8);
        zze(j);
    }

    public final void zzl(int i, int i2) throws IOException {
        zzH(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg((long) i2);
        }
    }

    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu((long) i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i, zzahp zzahp, zzaib zzaib) throws IOException {
        zzs((i << 3) | 2);
        zzs(((zzaep) zzahp).zzn(zzaib));
        zzaib.zzm(zzahp, this.zze);
    }

    public final void zzo(int i, String str) throws IOException {
        zzs((i << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i4, i5);
        this.zzc = this.zzb;
        this.zzd += i5;
        zzG();
        int i6 = i2 - i5;
        if (i6 <= this.zzb) {
            System.arraycopy(bArr, i5, this.zza, 0, i6);
            this.zzc = i6;
        } else {
            this.zzg.write(bArr, i5, i6);
        }
        this.zzd += i6;
    }

    public final void zzq(int i, int i2) throws IOException {
        zzs((i << 3) | i2);
    }

    public final void zzr(int i, int i2) throws IOException {
        zzH(20);
        zzf(i << 3);
        zzf(i2);
    }

    public final void zzs(int i) throws IOException {
        zzH(5);
        zzf(i);
    }

    public final void zzt(int i, long j) throws IOException {
        zzH(20);
        zzf(i << 3);
        zzg(j);
    }

    public final void zzu(long j) throws IOException {
        zzH(10);
        zzg(j);
    }

    public final void zzv(String str) throws IOException {
        int i;
        int i2;
        try {
            int length = str.length() * 3;
            int zzA = zzA(length);
            int i3 = zzA + length;
            int i4 = this.zzb;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int zzb = zzajk.zzb(str, bArr, 0, length);
                zzs(zzb);
                zzp(bArr, 0, zzb);
                return;
            }
            if (i3 > i4 - this.zzc) {
                zzG();
            }
            int zzA2 = zzA(str.length());
            i = this.zzc;
            if (zzA2 == zzA) {
                int i5 = i + zzA2;
                this.zzc = i5;
                int zzb2 = zzajk.zzb(str, this.zza, i5, this.zzb - i5);
                this.zzc = i;
                i2 = (zzb2 - i) - zzA2;
                zzf(i2);
                this.zzc = zzb2;
            } else {
                i2 = zzajk.zzc(str);
                zzf(i2);
                this.zzc = zzajk.zzb(str, this.zza, this.zzc, i2);
            }
            this.zzd += i2;
        } catch (zzajj e) {
            this.zzd -= this.zzc - i;
            this.zzc = i;
            throw e;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzafp(e2);
        } catch (zzajj e3) {
            zzE(str, e3);
        }
    }
}
