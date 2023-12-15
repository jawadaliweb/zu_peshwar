package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzadi;
import com.google.android.gms.internal.p001firebaseauthapi.zzaea;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zzau;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbc {
    @Nullable
    public static MultiFactorInfo zza(zzadi zzadi) {
        if (zzadi == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzadi.zzf())) {
            return new PhoneMultiFactorInfo(zzadi.zze(), zzadi.zzd(), zzadi.zza(), Preconditions.checkNotEmpty(zzadi.zzf()));
        }
        if (zzadi.zzc() != null) {
            return new zzau(zzadi.zze(), zzadi.zzd(), zzadi.zza(), (zzaea) Preconditions.checkNotNull(zzadi.zzc(), "totpInfo cannot not be null."));
        }
        return null;
    }

    public static List zzb(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo zza = zza((zzadi) it.next());
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        return arrayList;
    }
}
