package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public final class zzw extends zzb implements zzx {
    public static zzx zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
        return queryLocalInterface instanceof zzx ? (zzx) queryLocalInterface : new zzv(iBinder);
    }
}
