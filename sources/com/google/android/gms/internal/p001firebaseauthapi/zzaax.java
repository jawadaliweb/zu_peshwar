package com.google.android.gms.internal.p001firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaax  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaax extends LifecycleCallback {
    private final List zza;

    private zzaax(LifecycleFragment lifecycleFragment, List list) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
        this.zza = list;
    }

    public static void zza(Activity activity, List list) {
        LifecycleFragment fragment = getFragment(activity);
        if (((zzaax) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zzaax.class)) == null) {
            new zzaax(fragment, list);
        }
    }

    public final void onStop() {
        synchronized (this.zza) {
            this.zza.clear();
        }
    }
}
