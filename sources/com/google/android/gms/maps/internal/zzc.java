package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public abstract class zzc extends zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzc();
        } else if (i != 2) {
            return false;
        } else {
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
