package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaeo;
import com.google.android.gms.internal.p001firebaseauthapi.zzaep;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzaep<MessageType extends zzaep<MessageType, BuilderType>, BuilderType extends zzaeo<MessageType, BuilderType>> implements zzahp {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zzn(zzaib zzaib) {
        throw null;
    }

    public final zzaff zzo() {
        try {
            int zzs = zzs();
            zzaff zzaff = zzaff.zzb;
            byte[] bArr = new byte[zzs];
            zzafs zzC = zzafs.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return new zzafc(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        int zzs = zzs();
        int i = zzafs.zzf;
        if (zzs > 4096) {
            zzs = 4096;
        }
        zzafq zzafq = new zzafq(outputStream, zzs);
        zzJ(zzafq);
        zzafq.zzI();
    }

    public final byte[] zzq() {
        try {
            int zzs = zzs();
            byte[] bArr = new byte[zzs];
            zzafs zzC = zzafs.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
