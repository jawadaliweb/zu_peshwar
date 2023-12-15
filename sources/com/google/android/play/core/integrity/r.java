package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.l;
import com.google.android.play.integrity.internal.w;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class r extends l {
    final /* synthetic */ byte[] a;
    final /* synthetic */ Long b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ IntegrityTokenRequest d;
    final /* synthetic */ t e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.e = tVar;
        this.a = bArr;
        this.b = l;
        this.c = taskCompletionSource2;
        this.d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof w) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.integrity.internal.h] */
    /* access modifiers changed from: protected */
    public final void b() {
        try {
            this.e.a.e().c(t.a(this.e, this.a, this.b), new s(this.e, this.c));
        } catch (RemoteException e2) {
            this.e.b.c(e2, "requestIntegrityToken(%s)", this.d);
            this.c.trySetException(new IntegrityServiceException(-100, e2));
        }
    }
}
