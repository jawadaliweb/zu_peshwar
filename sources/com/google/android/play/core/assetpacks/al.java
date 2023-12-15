package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class al extends ag<AssetPackStates> {
    private final bo c;
    private final as d;

    al(an anVar, i<AssetPackStates> iVar, bo boVar, as asVar) {
        super(anVar, iVar);
        this.c = boVar;
        this.d = asVar;
    }

    public final void f(Bundle bundle, Bundle bundle2) {
        super.f(bundle, bundle2);
        this.a.e(AssetPackStates.d(bundle, this.c, this.d));
    }
}
