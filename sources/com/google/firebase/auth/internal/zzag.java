package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zzau;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private String zza;
    private String zzb;
    private List zzc;
    private List zzd;
    private zzx zze;

    private zzag() {
    }

    public static zzag zza(String str, zzx zzx) {
        Preconditions.checkNotEmpty(str);
        zzag zzag = new zzag();
        zzag.zza = str;
        zzag.zze = zzx;
        return zzag;
    }

    public static zzag zzb(List list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzag zzag = new zzag();
        zzag.zzc = new ArrayList();
        zzag.zzd = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzag.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof zzau) {
                zzag.zzd.add((zzau) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: ".concat(String.valueOf(multiFactorInfo.getFactorId())));
            }
        }
        zzag.zzb = str;
        return zzag;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zza != null;
    }

    zzag(String str, String str2, List list, List list2, zzx zzx) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
        this.zzd = list2;
        this.zze = zzx;
    }
}
