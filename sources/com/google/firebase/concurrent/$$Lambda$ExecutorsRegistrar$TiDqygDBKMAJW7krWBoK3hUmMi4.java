package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4 implements Provider {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4 INSTANCE = new $$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4() {
    }

    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(4, ExecutorsRegistrar.factory("Firebase Background", 10, ExecutorsRegistrar.bgPolicy())));
    }
}
