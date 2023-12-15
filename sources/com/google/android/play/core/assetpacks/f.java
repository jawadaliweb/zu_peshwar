package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

final /* synthetic */ class f implements OnSuccessListener {
    private final au a;

    private f(au auVar) {
        this.a = auVar;
    }

    static OnSuccessListener a(au auVar) {
        return new f(auVar);
    }

    public final void onSuccess(Object obj) {
        this.a.A((List) obj);
    }
}
