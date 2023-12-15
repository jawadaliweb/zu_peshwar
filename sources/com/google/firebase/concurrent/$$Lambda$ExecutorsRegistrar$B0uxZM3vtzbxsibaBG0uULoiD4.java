package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsiba-BG0uULoiD4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsibaBG0uULoiD4 implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsibaBG0uULoiD4 INSTANCE = new $$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsibaBG0uULoiD4();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsibaBG0uULoiD4() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
    }
}
