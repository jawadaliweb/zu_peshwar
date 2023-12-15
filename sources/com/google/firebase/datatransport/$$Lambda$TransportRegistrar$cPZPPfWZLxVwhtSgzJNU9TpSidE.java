package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.datatransport.-$$Lambda$TransportRegistrar$cPZPPfWZLxVwhtSgzJNU9TpSidE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$TransportRegistrar$cPZPPfWZLxVwhtSgzJNU9TpSidE implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$TransportRegistrar$cPZPPfWZLxVwhtSgzJNU9TpSidE INSTANCE = new $$Lambda$TransportRegistrar$cPZPPfWZLxVwhtSgzJNU9TpSidE();

    private /* synthetic */ $$Lambda$TransportRegistrar$cPZPPfWZLxVwhtSgzJNU9TpSidE() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
    }
}
