package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzz;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public abstract class zzag extends zzb implements zzah {
    public zzag() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowLongClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzaa zzb = zzz.zzb(parcel.readStrongBinder());
        zzc.zzc(parcel);
        zzb(zzb);
        parcel2.writeNoException();
        return true;
    }
}
