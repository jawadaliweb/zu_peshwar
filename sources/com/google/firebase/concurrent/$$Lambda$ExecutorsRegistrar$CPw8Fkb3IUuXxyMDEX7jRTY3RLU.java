package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU implements Provider {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU INSTANCE = new $$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU() {
    }

    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.factory("Firebase Scheduler", 0));
    }
}
