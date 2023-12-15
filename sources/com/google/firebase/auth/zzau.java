package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p001firebaseauthapi.zzaea;
import com.google.android.gms.internal.p001firebaseauthapi.zzvz;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzau extends MultiFactorInfo {
    public static final Parcelable.Creator<zzau> CREATOR = new zzav();
    private final String zza;
    @Nullable
    private final String zzb;
    private final long zzc;
    private final zzaea zzd;

    public zzau(String str, @Nullable String str2, long j, zzaea zzaea) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j;
        this.zzd = (zzaea) Preconditions.checkNotNull(zzaea, "totpInfo cannot not be null.");
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzb;
    }

    public final long getEnrollmentTimestamp() {
        return this.zzc;
    }

    public final String getFactorId() {
        return "totp";
    }

    public final String getUid() {
        return this.zza;
    }

    @Nullable
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "totp");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt("totpInfo", this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzvz(e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
