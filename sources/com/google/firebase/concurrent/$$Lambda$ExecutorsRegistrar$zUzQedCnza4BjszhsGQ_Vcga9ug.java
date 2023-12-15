package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug INSTANCE = new $$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BG_EXECUTOR.get();
    }
}
