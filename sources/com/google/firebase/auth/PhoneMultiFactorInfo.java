package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p001firebaseauthapi.zzvz;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzar();
    private final String zza;
    @Nullable
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public PhoneMultiFactorInfo(String str, @Nullable String str2, long j, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j;
        this.zzd = Preconditions.checkNotEmpty(str3);
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    public String getFactorId() {
        return "phone";
    }

    public String getPhoneNumber() {
        return this.zzd;
    }

    public String getUid() {
        return this.zza;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt("phoneNumber", this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzvz(e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeString(parcel, 4, getPhoneNumber(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
