package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaea  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaea extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaea> CREATOR = new zzaeb();

    public final void writeToParcel(Parcel parcel, int i) {
        SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
    }
}
