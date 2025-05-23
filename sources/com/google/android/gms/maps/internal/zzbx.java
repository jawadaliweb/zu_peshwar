package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public final class zzbx extends zza implements IStreetViewPanoramaFragmentDelegate {
    zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate getStreetViewPanorama() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 1
            android.os.Parcel r0 = r4.zzH(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate r1 = (com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.maps.internal.zzbw r2 = new com.google.android.gms.maps.internal.zzbw
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzbx.getStreetViewPanorama():com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    public final void getStreetViewPanoramaAsync(zzbs zzbs) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, zzbs);
        zzc(12, zza);
    }

    public final boolean isReady() throws RemoteException {
        Parcel zzH = zzH(11, zza());
        boolean zzh = zzc.zzh(zzH);
        zzH.recycle();
        return zzh;
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bundle);
        zzc(3, zza);
    }

    public final IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, iObjectWrapper);
        zzc.zzg(zza, iObjectWrapper2);
        zzc.zze(zza, bundle);
        Parcel zzH = zzH(4, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzH.readStrongBinder());
        zzH.recycle();
        return asInterface;
    }

    public final void onDestroy() throws RemoteException {
        zzc(8, zza());
    }

    public final void onDestroyView() throws RemoteException {
        zzc(7, zza());
    }

    public final void onInflate(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, iObjectWrapper);
        zzc.zze(zza, streetViewPanoramaOptions);
        zzc.zze(zza, bundle);
        zzc(2, zza);
    }

    public final void onLowMemory() throws RemoteException {
        zzc(9, zza());
    }

    public final void onPause() throws RemoteException {
        zzc(6, zza());
    }

    public final void onResume() throws RemoteException {
        zzc(5, zza());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bundle);
        Parcel zzH = zzH(10, zza);
        if (zzH.readInt() != 0) {
            bundle.readFromParcel(zzH);
        }
        zzH.recycle();
    }

    public final void onStart() throws RemoteException {
        zzc(13, zza());
    }

    public final void onStop() throws RemoteException {
        zzc(14, zza());
    }
}
