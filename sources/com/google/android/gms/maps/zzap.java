package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
public final class zzap implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String str = null;
        LatLng latLng = null;
        Integer num = null;
        StreetViewSource streetViewSource = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.createParcelable(parcel, readHeader, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 5:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 6:
                    b = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 7:
                    b2 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 8:
                    b3 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 9:
                    b4 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 10:
                    b5 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.createParcelable(parcel, readHeader, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b, b2, b3, b4, b5, streetViewSource);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
