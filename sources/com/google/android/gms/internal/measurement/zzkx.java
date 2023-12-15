package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.internal.measurement.zzlb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.2 */
public class zzkx<MessageType extends zzlb<MessageType, BuilderType>, BuilderType extends zzkx<MessageType, BuilderType>> extends zzjj<MessageType, BuilderType> {
    protected zzlb zza;
    private final zzlb zzb;

    protected zzkx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzbR()) {
            this.zza = messagetype.zzbD();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzmq.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* renamed from: zzaA */
    public final zzkx zzav() {
        zzkx zzkx = (zzkx) this.zzb.zzl(5, (Object) null, (Object) null);
        zzkx.zza = zzaF();
        return zzkx;
    }

    public final zzkx zzaB(zzlb zzlb) {
        if (!this.zzb.equals(zzlb)) {
            if (!this.zza.zzbR()) {
                zzaI();
            }
            zza(this.zza, zzlb);
        }
        return this;
    }

    public final zzkx zzaC(byte[] bArr, int i, int i2, zzkn zzkn) throws zzll {
        if (!this.zza.zzbR()) {
            zzaI();
        }
        try {
            zzmq.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzjn(zzkn));
            return this;
        } catch (zzll e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzll.zzf();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r3 != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzaD() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzlb r0 = r5.zzaF()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0015
            goto L_0x0032
        L_0x0015:
            if (r3 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.zzmq r3 = com.google.android.gms.internal.measurement.zzmq.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.zzmt r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r0)
            if (r1 == r3) goto L_0x002b
            r1 = r2
            goto L_0x002c
        L_0x002b:
            r1 = r0
        L_0x002c:
            r4 = 2
            r0.zzl(r4, r1, r2)
            if (r3 == 0) goto L_0x0033
        L_0x0032:
            return r0
        L_0x0033:
            com.google.android.gms.internal.measurement.zznj r1 = new com.google.android.gms.internal.measurement.zznj
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zzaD():com.google.android.gms.internal.measurement.zzlb");
    }

    /* renamed from: zzaE */
    public MessageType zzaF() {
        if (!this.zza.zzbR()) {
            return this.zza;
        }
        this.zza.zzbM();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaH() {
        if (!this.zza.zzbR()) {
            zzaI();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaI() {
        zzlb zzbD = this.zzb.zzbD();
        zza(zzbD, this.zza);
        this.zza = zzbD;
    }

    public final /* bridge */ /* synthetic */ zzjj zzaw(byte[] bArr, int i, int i2) throws zzll {
        zzaC(bArr, 0, i2, zzkn.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzjj zzax(byte[] bArr, int i, int i2, zzkn zzkn) throws zzll {
        zzaC(bArr, 0, i2, zzkn);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzmi zzbV() {
        throw null;
    }
}
