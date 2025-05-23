package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzz;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public abstract class zzav extends zzb implements zzaw {
    public zzav() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaa zzb = zzz.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzd(zzb);
        } else if (i == 2) {
            zzaa zzb2 = zzz.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzb(zzb2);
        } else if (i != 3) {
            return false;
        } else {
            zzaa zzb3 = zzz.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzc(zzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
