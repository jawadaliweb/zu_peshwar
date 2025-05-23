package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zzau;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    private final List zza;
    private final zzag zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zze zzd;
    private final zzx zze;
    private final List zzf;

    public zzae(List list, zzag zzag, String str, zze zze2, zzx zzx, List list2) {
        this.zza = (List) Preconditions.checkNotNull(list);
        this.zzb = (zzag) Preconditions.checkNotNull(zzag);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zze2;
        this.zze = zzx;
        this.zzf = (List) Preconditions.checkNotNull(list2);
    }

    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (zzau add2 : this.zzf) {
            arrayList.add(add2);
        }
        return arrayList;
    }

    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzj(multiFactorAssertion, this.zzb, this.zze).continueWithTask(new zzad(this));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
