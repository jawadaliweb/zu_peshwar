package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzh {
    private long zzA;
    private long zzB;
    private long zzC;
    private String zzD;
    private boolean zzE;
    private long zzF;
    private long zzG;
    private final zzge zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private String zzq;
    private Boolean zzr;
    private long zzs;
    private List zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    zzh(zzge zzge, String str) {
        Preconditions.checkNotNull(zzge);
        Preconditions.checkNotEmpty(str);
        this.zza = zzge;
        this.zzb = str;
        zzge.zzaB().zzg();
    }

    public final String zzA() {
        this.zza.zzaB().zzg();
        return this.zzD;
    }

    public final String zzB() {
        this.zza.zzaB().zzg();
        return this.zze;
    }

    public final String zzC() {
        this.zza.zzaB().zzg();
        return this.zzu;
    }

    public final List zzD() {
        this.zza.zzaB().zzg();
        return this.zzt;
    }

    public final void zzE() {
        this.zza.zzaB().zzg();
        this.zzE = false;
    }

    public final void zzF() {
        this.zza.zzaB().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzaA().zzk().zzb("Bundle index overflow. appId", zzeu.zzn(this.zzb));
            j = 0;
        }
        this.zzE = true;
        this.zzg = j;
    }

    public final void zzG(String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzE |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzH(boolean z) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzp != z;
        this.zzp = z;
    }

    public final void zzI(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzJ(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzK(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzL(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzk != j;
        this.zzk = j;
    }

    public final void zzM(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzF != j;
        this.zzF = j;
    }

    public final void zzN(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzA != j;
        this.zzA = j;
    }

    public final void zzO(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzB != j;
        this.zzB = j;
    }

    public final void zzP(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzz != j;
        this.zzz = j;
    }

    public final void zzQ(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzy != j;
        this.zzy = j;
    }

    public final void zzR(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzC != j;
        this.zzC = j;
    }

    public final void zzS(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzx != j;
        this.zzx = j;
    }

    public final void zzT(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzn != j;
        this.zzn = j;
    }

    public final void zzU(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzs != j;
        this.zzs = j;
    }

    public final void zzV(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzG != j;
        this.zzG = j;
    }

    public final void zzW(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzX(String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzE |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzY(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzm != j;
        this.zzm = j;
    }

    public final void zzZ(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzD, str);
        this.zzD = str;
    }

    public final long zza() {
        this.zza.zzaB().zzg();
        return 0;
    }

    public final void zzaa(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzi != j;
        this.zzi = j;
    }

    public final void zzab(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzaB().zzg();
        boolean z2 = this.zzE;
        if (this.zzg == j) {
            z = false;
        }
        this.zzE = z | z2;
        this.zzg = j;
    }

    public final void zzac(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzh != j;
        this.zzh = j;
    }

    public final void zzad(boolean z) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzae(Boolean bool) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzr, bool);
        this.zzr = bool;
    }

    public final void zzaf(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzag(List list) {
        this.zza.zzaB().zzg();
        if (!zzg.zza(this.zzt, list)) {
            this.zzE = true;
            this.zzt = list != null ? new ArrayList(list) : null;
        }
    }

    public final void zzah(String str) {
        this.zza.zzaB().zzg();
        this.zzE |= !zzg.zza(this.zzu, str);
        this.zzu = str;
    }

    public final void zzai(boolean z) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzv != z;
        this.zzv = z;
    }

    public final void zzaj(long j) {
        this.zza.zzaB().zzg();
        this.zzE |= this.zzw != j;
        this.zzw = j;
    }

    public final boolean zzak() {
        this.zza.zzaB().zzg();
        return this.zzp;
    }

    public final boolean zzal() {
        this.zza.zzaB().zzg();
        return this.zzo;
    }

    public final boolean zzam() {
        this.zza.zzaB().zzg();
        return this.zzE;
    }

    public final boolean zzan() {
        this.zza.zzaB().zzg();
        return this.zzv;
    }

    public final long zzb() {
        this.zza.zzaB().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaB().zzg();
        return this.zzF;
    }

    public final long zzd() {
        this.zza.zzaB().zzg();
        return this.zzA;
    }

    public final long zze() {
        this.zza.zzaB().zzg();
        return this.zzB;
    }

    public final long zzf() {
        this.zza.zzaB().zzg();
        return this.zzz;
    }

    public final long zzg() {
        this.zza.zzaB().zzg();
        return this.zzy;
    }

    public final long zzh() {
        this.zza.zzaB().zzg();
        return this.zzC;
    }

    public final long zzi() {
        this.zza.zzaB().zzg();
        return this.zzx;
    }

    public final long zzj() {
        this.zza.zzaB().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaB().zzg();
        return this.zzs;
    }

    public final long zzl() {
        this.zza.zzaB().zzg();
        return this.zzG;
    }

    public final long zzm() {
        this.zza.zzaB().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaB().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaB().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaB().zzg();
        return this.zzh;
    }

    public final long zzq() {
        this.zza.zzaB().zzg();
        return this.zzw;
    }

    public final Boolean zzr() {
        this.zza.zzaB().zzg();
        return this.zzr;
    }

    public final String zzs() {
        this.zza.zzaB().zzg();
        return this.zzq;
    }

    public final String zzt() {
        this.zza.zzaB().zzg();
        String str = this.zzD;
        zzZ((String) null);
        return str;
    }

    public final String zzu() {
        this.zza.zzaB().zzg();
        return this.zzb;
    }

    public final String zzv() {
        this.zza.zzaB().zzg();
        return this.zzc;
    }

    public final String zzw() {
        this.zza.zzaB().zzg();
        return this.zzl;
    }

    public final String zzx() {
        this.zza.zzaB().zzg();
        return this.zzj;
    }

    public final String zzy() {
        this.zza.zzaB().zzg();
        return this.zzf;
    }

    public final String zzz() {
        this.zza.zzaB().zzg();
        return this.zzd;
    }
}
