package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzagv {
    private static final zzafx zzb = zzafx.zza;
    protected volatile zzahp zza;
    private volatile zzaff zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzagv)) {
            return false;
        }
        zzagv zzagv = (zzagv) obj;
        zzahp zzahp = this.zza;
        zzahp zzahp2 = zzagv.zza;
        if (zzahp == null && zzahp2 == null) {
            return zzb().equals(zzagv.zzb());
        }
        if (zzahp != null && zzahp2 != null) {
            return zzahp.equals(zzahp2);
        }
        if (zzahp != null) {
            zzagv.zzc(zzahp.zzM());
            return zzahp.equals(zzagv.zza);
        }
        zzc(zzahp2.zzM());
        return this.zza.equals(zzahp2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzafc) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzaff zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzaff zzaff = this.zzc;
                return zzaff;
            }
            if (this.zza == null) {
                this.zzc = zzaff.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            zzaff zzaff2 = this.zzc;
            return zzaff2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.p001firebaseauthapi.zzahp r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzahp r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzahp r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzags -> 0x0011 }
            com.google.android.gms.internal.firebase-auth-api.zzaff r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzb     // Catch:{ zzags -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzags -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.firebase-auth-api.zzaff r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzagv.zzc(com.google.android.gms.internal.firebase-auth-api.zzahp):void");
    }
}
