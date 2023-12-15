package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$NeK9WbUt-v295kcYOKB69YB08fs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$NeK9WbUtv295kcYOKB69YB08fs implements Provider {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$NeK9WbUtv295kcYOKB69YB08fs INSTANCE = new $$Lambda$ExecutorsRegistrar$NeK9WbUtv295kcYOKB69YB08fs();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$NeK9WbUtv295kcYOKB69YB08fs() {
    }

    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.factory("Firebase Lite", 0, ExecutorsRegistrar.litePolicy())));
    }
}
