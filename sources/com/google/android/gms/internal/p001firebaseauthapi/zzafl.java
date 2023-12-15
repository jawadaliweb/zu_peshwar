package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzafl {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzafm zzc;

    /* synthetic */ zzafl(zzafk zzafk) {
    }

    public static int zzF(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzG(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    static zzafl zzH(byte[] bArr, int i, int i2, boolean z) {
        zzafh zzafh = new zzafh(bArr, 0, i2, z, (zzafg) null);
        try {
            zzafh.zze(i2);
            return zzafh;
        } catch (zzags e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract void zzA(int i);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i) throws zzags;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzaff zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i) throws zzags;
}
