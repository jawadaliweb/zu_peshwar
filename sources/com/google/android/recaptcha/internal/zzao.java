package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.List;
import java.util.Timer;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzao implements zzaj {
    public static final zzak zza = new zzak((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Timer zzb;
    private final zzap zzc;
    /* access modifiers changed from: private */
    public final CoroutineScope zzd;
    /* access modifiers changed from: private */
    public final zzad zze;

    public /* synthetic */ zzao(Context context, zzap zzap, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        zzp zzp = zzp.zza;
        CoroutineScope zza2 = zzp.zza();
        this.zzc = zzap;
        this.zzd = zza2;
        zzad zzc2 = zzad.zzb;
        zzc2 = zzc2 == null ? new zzad(context, (DefaultConstructorMarker) null) : zzc2;
        zzad.zzb = zzc2;
        this.zze = zzc2;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        for (List<zzae> list : CollectionsKt.windowed(this.zze.zzd(), 20, 20, true)) {
            zzkz zzf = zzla.zzf();
            for (zzae zzc2 : list) {
                zzf.zzd(zzkx.zzG(zzeb.zzg().zzj(zzc2.zzc())));
            }
            if (this.zzc.zza(((zzla) zzf.zzj()).zzd())) {
                for (zzae zzf2 : list) {
                    this.zze.zzf(zzf2);
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            if (timer != null) {
                timer.schedule(new zzal(this), 120000, 120000);
            }
        }
    }

    public final void zzf(zzkx zzkx) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzan(zzkx, this, (Continuation) null), 3, (Object) null);
        zzh();
    }
}
