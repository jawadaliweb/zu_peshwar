package com.google.android.play.integrity.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final /* synthetic */ class n implements IBinder.DeathRecipient {
    public final /* synthetic */ v a;

    public /* synthetic */ n(v vVar) {
        this.a = vVar;
    }

    public final void binderDied() {
        v.h(this.a);
    }
}
