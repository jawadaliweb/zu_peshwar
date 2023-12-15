package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        $$Lambda$Utils$QYDAU0kMkD0sRCyoHp31L98kyZM r1 = new Continuation() {
            public final Object then(Task task) {
                return Utils.lambda$race$0(TaskCompletionSource.this, task);
            }
        };
        task.continueWith(r1);
        task2.continueWith(r1);
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ Void lambda$race$0(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        }
        Exception exception = task.getException();
        Objects.requireNonNull(exception);
        taskCompletionSource.trySetException(exception);
        return null;
    }

    public static <T> Task<T> race(Executor executor, Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        $$Lambda$Utils$5a7kWS7ouTcetu0gP5GgTnQAI r1 = new Continuation() {
            public final Object then(Task task) {
                return Utils.lambda$race$1(TaskCompletionSource.this, task);
            }
        };
        task.continueWith(executor, r1);
        task2.continueWith(executor, r1);
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ Void lambda$race$1(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        }
        Exception exception = task.getException();
        Objects.requireNonNull(exception);
        taskCompletionSource.trySetException(exception);
        return null;
    }

    public static <T> Task<T> callTask(Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    ((Task) callable.call()).continueWith(new Continuation<T, Void>() {
                        public Void then(Task<T> task) throws Exception {
                            if (task.isSuccessful()) {
                                taskCompletionSource.setResult(task.getResult());
                                return null;
                            }
                            taskCompletionSource.setException(task.getException());
                            return null;
                        }
                    });
                } catch (Exception e) {
                    taskCompletionSource.setException(e);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new Continuation(countDownLatch) {
            public final /* synthetic */ CountDownLatch f$0;

            {
                this.f$0 = r1;
            }

            public final Object then(Task task) {
                return this.f$0.countDown();
            }
        });
        countDownLatch.await(4, TimeUnit.SECONDS);
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }
}
