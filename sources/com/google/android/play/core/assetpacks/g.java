package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

final /* synthetic */ class g implements OnFailureListener {
    static final OnFailureListener a = new g();

    private g() {
    }

    public final void onFailure(Exception exc) {
        i.a.e(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
