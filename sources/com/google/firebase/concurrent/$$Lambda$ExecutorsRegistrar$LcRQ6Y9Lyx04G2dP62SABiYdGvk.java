package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk implements Provider {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk INSTANCE = new $$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk() {
    }

    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
    }
}
