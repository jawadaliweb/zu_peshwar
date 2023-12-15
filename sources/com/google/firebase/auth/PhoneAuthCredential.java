package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzap();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private boolean zzd;
    private final String zze;

    PhoneAuthCredential(String str, String str2, String str3, boolean z, String str4) {
        boolean z2 = true;
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = str4;
    }

    public static PhoneAuthCredential zzc(String str, String str2) {
        return new PhoneAuthCredential(str, str2, (String) null, true, (String) null);
    }

    public static PhoneAuthCredential zzd(String str, String str2) {
        return new PhoneAuthCredential((String) null, (String) null, str, true, str2);
    }

    public String getProvider() {
        return "phone";
    }

    public String getSignInMethod() {
        return "phone";
    }

    public String getSmsCode() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AuthCredential zza() {
        return clone();
    }

    /* renamed from: zzb */
    public final PhoneAuthCredential clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze);
    }

    public final PhoneAuthCredential zze(boolean z) {
        this.zzd = false;
        return this;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zze;
    }

    public final boolean zzi() {
        return this.zzd;
    }
}
