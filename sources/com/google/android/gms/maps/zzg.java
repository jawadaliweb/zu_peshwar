package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzaz;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
final class zzg extends zzaz {
    final /* synthetic */ GoogleMap.OnMyLocationChangeListener zza;

    zzg(GoogleMap googleMap, GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.zza = onMyLocationChangeListener;
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zza.onMyLocationChange((Location) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
