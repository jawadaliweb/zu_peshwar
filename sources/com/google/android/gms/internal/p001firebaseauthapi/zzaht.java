package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaht  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaht implements zzaib {
    private final zzahp zza;
    private final zzaiv zzb;
    private final boolean zzc;
    private final zzafy zzd;

    private zzaht(zzaiv zzaiv, zzafy zzafy, zzahp zzahp) {
        this.zzb = zzaiv;
        this.zzc = zzafy.zzh(zzahp);
        this.zzd = zzafy;
        this.zza = zzahp;
    }

    static zzaht zzc(zzaiv zzaiv, zzafy zzafy, zzahp zzahp) {
        return new zzaht(zzaiv, zzafy, zzahp);
    }

    public final int zza(Object obj) {
        zzaiv zzaiv = this.zzb;
        int zzb2 = zzaiv.zzb(zzaiv.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzahp zzahp = this.zza;
        if (zzahp instanceof zzagk) {
            return ((zzagk) zzahp).zzw();
        }
        return zzahp.zzC().zzk();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzaid.zzC(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, zzaia zzaia, zzafx zzafx) throws IOException {
        boolean z;
        zzaiv zzaiv = this.zzb;
        zzafy zzafy = this.zzd;
        Object zzc2 = zzaiv.zzc(obj);
        zzagc zzb2 = zzafy.zzb(obj);
        while (zzaia.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzaia.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzafy.zzc(zzafx, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzafy.zzf(zzaia, zzc3, zzafx, zzb2);
                    } else {
                        z = zzaiv.zzp(zzc2, zzaia);
                    }
                } else {
                    z = zzaia.zzO();
                }
                if (!z) {
                    zzaiv.zzn(obj, zzc2);
                    return;
                }
            } else {
                int i = 0;
                Object obj2 = null;
                zzaff zzaff = null;
                while (true) {
                    try {
                        if (zzaia.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzaia.zzd();
                        if (zzd3 == 16) {
                            i = zzaia.zzj();
                            obj2 = zzafy.zzc(zzafx, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzafy.zzf(zzaia, obj2, zzafx, zzb2);
                            } else {
                                zzaff = zzaia.zzp();
                            }
                        } else if (!zzaia.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzaiv.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzaia.zzd() != 12) {
                    throw zzags.zzb();
                } else if (zzaff != null) {
                    if (obj2 != null) {
                        zzafy.zzg(zzaff, obj2, zzafx, zzb2);
                    } else {
                        zzaiv.zzk(zzc2, i, zzaff);
                    }
                }
            }
        }
        zzaiv.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzaes zzaes) throws IOException {
        zzagk zzagk = (zzagk) obj;
        if (zzagk.zzc == zzaiw.zzc()) {
            zzagk.zzc = zzaiw.zzf();
        }
        zzagh zzagh = (zzagh) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    public final void zzm(Object obj, zzaft zzaft) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
