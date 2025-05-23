package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

final class q implements d {
    final /* synthetic */ SplitInstallSessionState a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ s d;

    q(s sVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = sVar;
        this.a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    public final void a() {
        this.d.d.post(new r(this.d, this.a, 5, 0));
    }

    public final void b() {
        if (!this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
            return;
        }
        this.d.a.b("Splits copied and verified more than once.", new Object[0]);
    }

    public final void c(int i) {
        this.d.d.post(new r(this.d, this.a, 6, i));
    }
}
