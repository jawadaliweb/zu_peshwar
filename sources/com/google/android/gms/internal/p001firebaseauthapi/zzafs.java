package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzafs extends zzaev {
    private static final Logger zza = Logger.getLogger(zzafs.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzajf.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzaft zze;

    private zzafs() {
    }

    /* synthetic */ zzafs(zzafr zzafr) {
    }

    public static int zzA(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            j >>>= 14;
            i += 2;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static zzafs zzC(byte[] bArr, int i, int i2) {
        return new zzafo(bArr, 0, i2);
    }

    @Deprecated
    static int zzw(int i, zzahp zzahp, zzaib zzaib) {
        int zzn = ((zzaep) zzahp).zzn(zzaib);
        int zzA = zzA(i << 3);
        return zzA + zzA + zzn;
    }

    public static int zzx(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    static int zzy(zzahp zzahp, zzaib zzaib) {
        int zzn = ((zzaep) zzahp).zzn(zzaib);
        return zzA(zzn) + zzn;
    }

    public static int zzz(String str) {
        int i;
        try {
            i = zzajk.zzc(str);
        } catch (zzajj unused) {
            i = str.getBytes(zzagq.zzb).length;
        }
        return zzA(i) + i;
    }

    public final void zzD() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zzajj zzajj) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzajj);
        byte[] bytes = str.getBytes(zzagq.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzafp(e);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b) throws IOException;

    public abstract void zzK(int i, boolean z) throws IOException;

    public abstract void zzL(int i, zzaff zzaff) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzn(int i, zzahp zzahp, zzaib zzaib) throws IOException;

    public abstract void zzo(int i, String str) throws IOException;

    public abstract void zzq(int i, int i2) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i, long j) throws IOException;

    public abstract void zzu(long j) throws IOException;
}
