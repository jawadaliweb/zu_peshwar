package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>($$Lambda$ExecutorsRegistrar$TiDqygDBKMAJW7krWBoK3hUmMi4.INSTANCE);
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>($$Lambda$ExecutorsRegistrar$LcRQ6Y9Lyx04G2dP62SABiYdGvk.INSTANCE);
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>($$Lambda$ExecutorsRegistrar$NeK9WbUtv295kcYOKB69YB08fs.INSTANCE);
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>($$Lambda$ExecutorsRegistrar$CPw8Fkb3IUuXxyMDEX7jRTY3RLU.INSTANCE);

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)}).factory($$Lambda$ExecutorsRegistrar$zUzQedCnza4BjszhsGQ_Vcga9ug.INSTANCE).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)}).factory($$Lambda$ExecutorsRegistrar$B0uxZM3vtzbxsibaBG0uULoiD4.INSTANCE).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)}).factory($$Lambda$ExecutorsRegistrar$SnTBB1AjAOre7G4M8m4LWvmxVDQ.INSTANCE).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory($$Lambda$ExecutorsRegistrar$OmRqLzOqJOhYC48xZMdQxijepyk.INSTANCE).build()});
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    private static ThreadFactory factory(String str, int i) {
        return new CustomThreadFactory(str, i, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory factory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i, threadPolicy);
    }

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        if (Build.VERSION.SDK_INT >= 23) {
            detectNetwork.detectResourceMismatches();
            if (Build.VERSION.SDK_INT >= 26) {
                detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }
}
