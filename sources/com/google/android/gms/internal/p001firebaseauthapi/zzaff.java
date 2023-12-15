package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaff  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzaff implements Iterable, Serializable {
    private static final Comparator zza = new zzaex();
    public static final zzaff zzb = new zzafc(zzagq.zzd);
    private static final zzafe zzd = new zzafe((zzafd) null);
    private int zzc = 0;

    static {
        int i = zzaer.zza;
    }

    zzaff() {
    }

    public static zzaff zzn(byte[] bArr, int i, int i2) {
        zzl(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzafc(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzf(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzaew(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzaiq.zza(this) : zzaiq.zza(zzg(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzf(int i, int i2, int i3);

    public abstract zzaff zzg(int i, int i2);

    public abstract zzafl zzh();

    /* access modifiers changed from: protected */
    public abstract String zzi(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzj(zzaev zzaev) throws IOException;

    public abstract boolean zzk();

    /* access modifiers changed from: protected */
    public final int zzm() {
        return this.zzc;
    }

    public final String zzo(Charset charset) {
        return zzd() == 0 ? "" : zzi(charset);
    }

    public final boolean zzp() {
        return zzd() == 0;
    }

    public final byte[] zzq() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzagq.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    static int zzl(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }
}
