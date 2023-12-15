package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class bk extends k implements bl {
    public static bl b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof bl ? (bl) queryLocalInterface : new bj(iBinder);
    }
}
