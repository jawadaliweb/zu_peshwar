package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public abstract class g extends b implements h {
    public static h b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
        return queryLocalInterface instanceof h ? (h) queryLocalInterface : new f(iBinder);
    }
}
