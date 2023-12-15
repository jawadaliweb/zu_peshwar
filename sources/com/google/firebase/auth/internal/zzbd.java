package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zzau;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
    private final List zza;
    private final List zzb;

    zzbd(List list, List list2) {
        this.zza = list == null ? new ArrayList() : list;
        this.zzb = list2 == null ? new ArrayList() : list2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (zzau add2 : this.zzb) {
            arrayList.add(add2);
        }
        return arrayList;
    }
}
