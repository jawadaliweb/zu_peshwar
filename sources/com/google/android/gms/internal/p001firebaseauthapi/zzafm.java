package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzafm implements zzaia {
    private final zzafl zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzafm(zzafl zzafl) {
        byte[] bArr = zzagq.zzd;
        this.zza = zzafl;
        zzafl.zzc = this;
    }

    private final void zzP(Object obj, zzaib zzaib, zzafx zzafx) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzaib.zzh(obj, this, zzafx);
            if (this.zzb != this.zzc) {
                throw zzags.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzaib zzaib, zzafx zzafx) throws IOException {
        int zzn = this.zza.zzn();
        zzafl zzafl = this.zza;
        if (zzafl.zza < zzafl.zzb) {
            int zze = zzafl.zze(zzn);
            this.zza.zza++;
            zzaib.zzh(obj, this, zzafx);
            this.zza.zzz(0);
            zzafl zzafl2 = this.zza;
            zzafl2.zza--;
            zzafl2.zzA(zze);
            return;
        }
        throw new zzags("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw zzags.zzj();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzags.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzags.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzags.zzg();
        }
    }

    public static zzafm zzq(zzafl zzafl) {
        zzafm zzafm = zzafl.zzc;
        return zzafm != null ? zzafm : new zzafm(zzafl);
    }

    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzahe.zzf(this.zza.zzo());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahe.zzf(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzage) {
            zzage zzage = (zzage) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzage.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
            } else if (i == 5) {
                do {
                    zzage.zze(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzags.zza();
            }
        }
    }

    @Deprecated
    public final void zzC(List list, zzaib zzaib, zzafx zzafx) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzaib.zze();
                zzP(zze, zzaib, zzafx);
                zzaib.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzags.zza();
    }

    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzagl.zzf(this.zza.zzh());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzagl.zzf(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzahe.zzf(this.zza.zzp());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahe.zzf(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzF(List list, zzaib zzaib, zzafx zzafx) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzaib.zze();
                zzQ(zze, zzaib, zzafx);
                zzaib.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzags.zza();
    }

    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzagl.zzf(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
            } else if (i == 5) {
                do {
                    zzagl.zzf(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzahe.zzf(this.zza.zzt());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahe.zzf(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzagl.zzf(this.zza.zzl());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzagl.zzf(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzahe.zzf(this.zza.zzu());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahe.zzf(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzm;
        int zzm2;
        if ((this.zzb & 7) != 2) {
            throw zzags.zza();
        } else if ((list instanceof zzagx) && !z) {
            zzagx zzagx = (zzagx) list;
            do {
                zzagx.zzi(zzp());
                if (!this.zza.zzC()) {
                    zzm2 = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
        } else {
            do {
                list.add(z ? zzs() : zzr());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
        }
    }

    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzagl.zzf(this.zza.zzn());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzagl.zzf(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzahe.zzf(this.zza.zzv());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahe.zzf(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    public final boolean zzO() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    public final zzaff zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzt(Object obj, zzaib zzaib, zzafx zzafx) throws IOException {
        zzS(3);
        zzP(obj, zzaib, zzafx);
    }

    public final void zzu(Object obj, zzaib zzaib, zzafx zzafx) throws IOException {
        zzS(2);
        zzQ(obj, zzaib, zzafx);
    }

    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaeu.zze(this.zza.zzD());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzaeu.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzags.zza();
    }

    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzafu) {
            zzafu zzafu = (zzafu) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzafu.zze(this.zza.zzb());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzafu.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzagl.zzf(this.zza.zzf());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzagl.zzf(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i2 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzags.zza();
            }
        }
    }

    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzagl.zzf(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
            } else if (i == 5) {
                do {
                    zzagl.zzf(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzags.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzags.zza();
            }
        }
    }
}
