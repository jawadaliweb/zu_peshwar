package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class h extends g<ReviewInfo> {
    h(i iVar, i iVar2) {
        super(iVar, new ag("OnRequestInstallCallback"), iVar2);
    }

    public final void b(Bundle bundle) throws RemoteException {
        super.b(bundle);
        this.b.e(ReviewInfo.b((PendingIntent) bundle.get("confirmation_intent")));
    }
}
