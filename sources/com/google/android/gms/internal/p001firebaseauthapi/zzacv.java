package com.google.android.gms.internal.p001firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacv {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzadk zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private zze zzl;
    private List zzm;

    public zzacv() {
        this.zzf = new zzadk();
    }

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzj;
    }

    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    public final zze zzd() {
        return this.zzl;
    }

    public final zzacv zze(zze zze2) {
        this.zzl = zze2;
        return this;
    }

    public final zzacv zzf(String str) {
        this.zzd = str;
        return this;
    }

    public final zzacv zzg(String str) {
        this.zzb = str;
        return this;
    }

    public final zzacv zzh(boolean z) {
        this.zzk = z;
        return this;
    }

    public final zzacv zzi(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    public final zzacv zzj(String str) {
        this.zze = str;
        return this;
    }

    public final zzacv zzk(List list) {
        Preconditions.checkNotNull(list);
        zzadk zzadk = new zzadk();
        this.zzf = zzadk;
        zzadk.zzc().addAll(list);
        return this;
    }

    public final zzadk zzl() {
        return this.zzf;
    }

    public final String zzm() {
        return this.zzd;
    }

    public final String zzn() {
        return this.zzb;
    }

    public final String zzo() {
        return this.zza;
    }

    public final String zzp() {
        return this.zzh;
    }

    public final List zzq() {
        return this.zzm;
    }

    public final List zzr() {
        return this.zzf.zzc();
    }

    public final boolean zzs() {
        return this.zzc;
    }

    public final boolean zzt() {
        return this.zzk;
    }

    public zzacv(String str, String str2, boolean z, String str3, String str4, zzadk zzadk, String str5, String str6, long j, long j2, boolean z2, zze zze2, List list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = zzadk.zzb(zzadk);
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list;
    }
}
