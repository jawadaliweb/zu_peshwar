package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final class f extends a implements h {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    public final void c(Bundle bundle, j jVar) throws RemoteException {
        Parcel a = a();
        c.c(a, bundle);
        c.d(a, jVar);
        b(2, a);
    }
}
