package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p001firebaseauthapi.zzac;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzaec zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zze(String str, String str2, String str3, zzaec zzaec, String str4, String str5, String str6) {
        this.zza = zzac.zzc(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaec;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zze zzb(zzaec zzaec) {
        Preconditions.checkNotNull(zzaec, "Must specify a non-null webSignInCredential");
        return new zze((String) null, (String) null, (String) null, zzaec, (String) null, (String) null, (String) null);
    }

    public static zze zzc(String str, String str2, String str3, String str4, String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zze(str, str2, str3, (zzaec) null, str4, str5, (String) null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzaec zzd(zze zze2, String str) {
        Preconditions.checkNotNull(zze2);
        zzaec zzaec = zze2.zzd;
        if (zzaec != null) {
            return zzaec;
        }
        return new zzaec(zze2.zzb, zze2.zzc, zze2.zza, (String) null, zze2.zzf, (String) null, str, zze2.zze, zze2.zzg);
    }

    public final String getAccessToken() {
        return this.zzc;
    }

    public final String getIdToken() {
        return this.zzb;
    }

    public final String getProvider() {
        return this.zza;
    }

    public final String getSecret() {
        return this.zzf;
    }

    public final String getSignInMethod() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AuthCredential zza() {
        return new zze(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
