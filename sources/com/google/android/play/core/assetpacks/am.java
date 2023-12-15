package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class am extends ag<AssetPackStates> {
    private final List<String> c;
    private final bo d;

    am(an anVar, i<AssetPackStates> iVar, bo boVar, List<String> list) {
        super(anVar, iVar);
        this.d = boVar;
        this.c = list;
    }

    public final void b(int i, Bundle bundle) {
        super.b(i, bundle);
        this.a.e(AssetPackStates.c(bundle, this.d, this.c));
    }
}
