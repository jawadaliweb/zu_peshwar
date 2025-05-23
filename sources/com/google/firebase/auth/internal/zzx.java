package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzau;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private zzade zza;
    private zzt zzb;
    private final String zzc;
    private String zzd;
    private List zze;
    private List zzf;
    private String zzg;
    private Boolean zzh;
    private zzz zzi;
    private boolean zzj;
    private zze zzk;
    private zzbd zzl;

    public zzx(FirebaseApp firebaseApp, List list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = ExifInterface.GPS_MEASUREMENT_2D;
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzx = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzx2 = (zzx) firebaseUser;
            zzx.zzg = zzx2.zzg;
            zzx.zzd = zzx2.zzd;
            zzx.zzi = zzx2.zzi;
        } else {
            zzx.zzi = null;
        }
        if (firebaseUser.zzd() != null) {
            zzx.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzx.zzm();
        }
        return zzx;
    }

    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    public final String getEmail() {
        return this.zzb.getEmail();
    }

    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    public final String getTenantId() {
        Map map;
        zzade zzade = this.zza;
        if (zzade == null || zzade.zze() == null || (map = (Map) zzba.zza(zzade.zze()).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public final String getUid() {
        return this.zzb.getUid();
    }

    public final boolean isAnonymous() {
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzade zzade = this.zza;
            String signInProvider = zzade != null ? zzba.zza(zzade.zze()).getSignInProvider() : "";
            boolean z = false;
            if (this.zze.size() <= 1 && (signInProvider == null || !signInProvider.equals("custom"))) {
                z = true;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    public final synchronized FirebaseUser zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals("firebase")) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = (zzt) this.zze.get(0);
        }
        return this;
    }

    public final zzade zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zza.zze();
    }

    public final String zzf() {
        return this.zza.zzh();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final void zzh(zzade zzade) {
        this.zza = (zzade) Preconditions.checkNotNull(zzade);
    }

    public final void zzi(List list) {
        Parcelable.Creator<zzbd> creator = zzbd.CREATOR;
        zzbd zzbd = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                } else if (multiFactorInfo instanceof zzau) {
                    arrayList2.add((zzau) multiFactorInfo);
                }
            }
            zzbd = new zzbd(arrayList, arrayList2);
        }
        this.zzl = zzbd;
    }

    public final zze zzj() {
        return this.zzk;
    }

    public final zzx zzl(String str) {
        this.zzg = str;
        return this;
    }

    public final zzx zzm() {
        this.zzh = false;
        return this;
    }

    public final List zzn() {
        zzbd zzbd = this.zzl;
        if (zzbd != null) {
            return zzbd.zza();
        }
        return new ArrayList();
    }

    public final List zzo() {
        return this.zze;
    }

    public final void zzp(zze zze2) {
        this.zzk = zze2;
    }

    public final void zzq(boolean z) {
        this.zzj = z;
    }

    public final void zzr(zzz zzz) {
        this.zzi = zzz;
    }

    public final boolean zzs() {
        return this.zzj;
    }

    zzx(zzade zzade, zzt zzt, String str, String str2, List list, List list2, String str3, Boolean bool, zzz zzz, boolean z, zze zze2, zzbd zzbd) {
        this.zza = zzade;
        this.zzb = zzt;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzz;
        this.zzj = z;
        this.zzk = zze2;
        this.zzl = zzbd;
    }
}
