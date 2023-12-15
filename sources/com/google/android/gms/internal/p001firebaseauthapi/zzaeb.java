package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaeb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            SafeParcelReader.getFieldId(readHeader);
            SafeParcelReader.skipUnknownField(parcel, readHeader);
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaea();
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaea[i];
    }
}
