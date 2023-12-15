package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    public abstract String getDisplayName();

    public abstract String getEmail();

    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zza()).zzc(this, z);
    }

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    public abstract String getPhoneNumber();

    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    public abstract String getProviderId();

    public abstract String getTenantId();

    public abstract String getUid();

    public abstract boolean isAnonymous();

    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzf(this, authCredential);
    }

    public Task<Void> reauthenticate(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzg(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzh(this, authCredential);
    }

    public Task<Void> reload() {
        FirebaseAuth instance = FirebaseAuth.getInstance(zza());
        return instance.zzi(this, new zzac(instance));
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzah(this));
    }

    public Task<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzl(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzm(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> unlink(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzo(this, str);
    }

    public Task<Void> updateEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzp(this, str);
    }

    public Task<Void> updatePassword(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzq(this, str);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zzr(this, phoneAuthCredential);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zzs(this, userProfileChangeRequest);
    }

    public Task<Void> verifyBeforeUpdateEmail(String str) {
        return verifyBeforeUpdateEmail(str, (ActionCodeSettings) null);
    }

    public abstract FirebaseApp zza();

    public abstract FirebaseUser zzb();

    public abstract FirebaseUser zzc(List list);

    public abstract zzade zzd();

    public abstract String zze();

    public abstract String zzf();

    public abstract List zzg();

    public abstract void zzh(zzade zzade);

    public abstract void zzi(List list);

    public Task<Void> verifyBeforeUpdateEmail(String str, ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzaj(this, str, actionCodeSettings));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzai(this, actionCodeSettings));
    }
}
