package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ INSTANCE = new $$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.LITE_EXECUTOR.get();
    }
}
