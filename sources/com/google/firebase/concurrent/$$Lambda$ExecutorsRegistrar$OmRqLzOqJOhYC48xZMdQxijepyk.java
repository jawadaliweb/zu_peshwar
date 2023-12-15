package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.concurrent.-$$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk INSTANCE = new $$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk();

    private /* synthetic */ $$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return UiExecutor.INSTANCE;
    }
}
