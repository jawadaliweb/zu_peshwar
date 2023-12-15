package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadz {
    private List zza;

    public zzadz() {
        this((List) null);
    }

    public final List zza() {
        return this.zza;
    }

    public zzadz(int i, List list) {
        if (!list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, Strings.emptyToNull((String) list.get(i2)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.emptyList();
    }

    public zzadz(List list) {
        this.zza = new ArrayList();
    }
}
