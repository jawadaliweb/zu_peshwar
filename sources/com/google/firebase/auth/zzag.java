package com.google.firebase.auth;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzag implements ComponentFactory {
    public final /* synthetic */ Qualified zza;
    public final /* synthetic */ Qualified zzb;
    public final /* synthetic */ Qualified zzc;
    public final /* synthetic */ Qualified zzd;
    public final /* synthetic */ Qualified zze;

    public /* synthetic */ zzag(Qualified qualified, Qualified qualified2, Qualified qualified3, Qualified qualified4, Qualified qualified5) {
        this.zza = qualified;
        this.zzb = qualified2;
        this.zzc = qualified3;
        this.zzd = qualified4;
        this.zze = qualified5;
    }

    public final Object create(ComponentContainer componentContainer) {
        return FirebaseAuthRegistrar.lambda$getComponents$0(this.zza, this.zzb, this.zzc, this.zzd, this.zze, componentContainer);
    }
}
