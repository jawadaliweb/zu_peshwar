package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.model.Marker;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
final class zzf extends zzh {
    final /* synthetic */ GoogleMap.InfoWindowAdapter zza;

    zzf(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.zza = infoWindowAdapter;
    }

    public final IObjectWrapper zzb(zzaa zzaa) {
        return ObjectWrapper.wrap(this.zza.getInfoContents(new Marker(zzaa)));
    }

    public final IObjectWrapper zzc(zzaa zzaa) {
        return ObjectWrapper.wrap(this.zza.getInfoWindow(new Marker(zzaa)));
    }
}
