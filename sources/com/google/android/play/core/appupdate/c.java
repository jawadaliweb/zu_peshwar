package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

final class c implements IntentSenderForResultStarter {
    final /* synthetic */ Activity a;

    c(Activity activity) {
        this.a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
