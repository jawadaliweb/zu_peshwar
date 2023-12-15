package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;

final /* synthetic */ class v implements OnSuccessListener {
    private final an a;

    v(an anVar) {
        this.a = anVar;
    }

    public final void onSuccess(Object obj) {
        AssetPackStates assetPackStates = (AssetPackStates) obj;
        this.a.j();
    }
}
