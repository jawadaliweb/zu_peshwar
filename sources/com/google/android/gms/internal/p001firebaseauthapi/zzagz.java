package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzagz extends zzahd {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzagz() {
        super((zzahc) null);
    }

    /* synthetic */ zzagz(zzagy zzagy) {
        super((zzahc) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.firebase-auth-api.zzagw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.firebase-auth-api.zzagw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.firebase-auth-api.zzagw} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List zzf(java.lang.Object r3, long r4, int r6) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r3, r4)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzagx
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.internal.firebase-auth-api.zzagw r0 = new com.google.android.gms.internal.firebase-auth-api.zzagw
            r0.<init>((int) r6)
            goto L_0x002b
        L_0x0016:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahw
            if (r1 == 0) goto L_0x0026
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzagp
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.internal.firebase-auth-api.zzagp r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzagp) r0
            com.google.android.gms.internal.firebase-auth-api.zzagp r6 = r0.zzd(r6)
            r0 = r6
            goto L_0x002b
        L_0x0026:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x002b:
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r3, r4, r0)
            goto L_0x0087
        L_0x002f:
            java.lang.Class r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r3, r4, r1)
        L_0x004b:
            r0 = r1
            goto L_0x0087
        L_0x004d:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaja
            if (r1 == 0) goto L_0x0068
            com.google.android.gms.internal.firebase-auth-api.zzagw r1 = new com.google.android.gms.internal.firebase-auth-api.zzagw
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.firebase-auth-api.zzaja r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzaja) r0
            int r6 = r1.size()
            r1.addAll(r6, r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r3, r4, r1)
            goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahw
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzagp
            if (r1 == 0) goto L_0x0087
            r1 = r0
            com.google.android.gms.internal.firebase-auth-api.zzagp r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzagp) r1
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.firebase-auth-api.zzagp r6 = r1.zzd(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r3, r4, r6)
            return r6
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzagz.zzf(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzajf.zzf(obj, j);
        if (list instanceof zzagx) {
            obj2 = ((zzagx) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzahw) || !(list instanceof zzagp)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzagp zzagp = (zzagp) list;
                if (zzagp.zzc()) {
                    zzagp.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzajf.zzs(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzajf.zzf(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzajf.zzs(obj, j, list);
    }
}
