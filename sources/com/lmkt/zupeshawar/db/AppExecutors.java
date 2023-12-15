package com.lmkt.zupeshawar.db;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static final Object LOCK = new Object();
    private static AppExecutors sInstance;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutors(Executor executor, Executor executor2, Executor executor3) {
        this.diskIO = executor;
        this.networkIO = executor2;
        this.mainThread = executor3;
    }

    public static AppExecutors getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new AppExecutors(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor diskIO() {
        return this.diskIO;
    }

    public Executor mainThread() {
        return this.mainThread;
    }

    public Executor networkIO() {
        return this.networkIO;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler;

        private MainThreadExecutor() {
            this.mainThreadHandler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.mainThreadHandler.post(runnable);
        }
    }
}
