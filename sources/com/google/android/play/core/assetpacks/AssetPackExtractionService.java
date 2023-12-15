package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AssetPackExtractionService extends Service {
    b a;

    public final IBinder onBind(Intent intent) {
        return this.a;
    }

    public final void onCreate() {
        super.onCreate();
        ck.j(getApplicationContext()).b(this);
    }
}
