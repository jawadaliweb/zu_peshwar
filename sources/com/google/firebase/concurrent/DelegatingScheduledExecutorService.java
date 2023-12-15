package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    private final ExecutorService delegate;
    private final ScheduledExecutorService scheduler;

    DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.delegate = executorService;
        this.scheduler = scheduledExecutorService;
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.delegate.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver(runnable, j, timeUnit) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ long f$2;
            public final /* synthetic */ TimeUnit f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
            }

            public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
                return DelegatingScheduledExecutorService.this.lambda$schedule$2$DelegatingScheduledExecutorService(this.f$1, this.f$2, this.f$3, completer);
            }
        });
    }

    public /* synthetic */ ScheduledFuture lambda$schedule$2$DelegatingScheduledExecutorService(Runnable runnable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DelegatingScheduledExecutorService.this.lambda$schedule$1$DelegatingScheduledExecutorService(this.f$1, this.f$2);
            }
        }, j, timeUnit);
    }

    public /* synthetic */ void lambda$schedule$1$DelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$0;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                DelegatingScheduledExecutorService.lambda$schedule$0(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$schedule$0(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
            completer.set(null);
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver(callable, j, timeUnit) {
            public final /* synthetic */ Callable f$1;
            public final /* synthetic */ long f$2;
            public final /* synthetic */ TimeUnit f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
            }

            public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
                return DelegatingScheduledExecutorService.this.lambda$schedule$5$DelegatingScheduledExecutorService(this.f$1, this.f$2, this.f$3, completer);
            }
        });
    }

    public /* synthetic */ ScheduledFuture lambda$schedule$5$DelegatingScheduledExecutorService(Callable callable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new Callable(callable, completer) {
            public final /* synthetic */ Callable f$1;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object call() {
                return DelegatingScheduledExecutorService.this.lambda$schedule$4$DelegatingScheduledExecutorService(this.f$1, this.f$2);
            }
        }, j, timeUnit);
    }

    public /* synthetic */ Future lambda$schedule$4$DelegatingScheduledExecutorService(Callable callable, DelegatingScheduledFuture.Completer completer) throws Exception {
        return this.delegate.submit(new Runnable(callable, completer) {
            public final /* synthetic */ Callable f$0;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                DelegatingScheduledExecutorService.lambda$schedule$3(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$schedule$3(Callable callable, DelegatingScheduledFuture.Completer completer) {
        try {
            completer.set(callable.call());
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver(runnable, j, j2, timeUnit) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ long f$2;
            public final /* synthetic */ long f$3;
            public final /* synthetic */ TimeUnit f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
                this.f$4 = r7;
            }

            public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
                return DelegatingScheduledExecutorService.this.lambda$scheduleAtFixedRate$8$DelegatingScheduledExecutorService(this.f$1, this.f$2, this.f$3, this.f$4, completer);
            }
        });
    }

    public /* synthetic */ ScheduledFuture lambda$scheduleAtFixedRate$8$DelegatingScheduledExecutorService(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleAtFixedRate(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DelegatingScheduledExecutorService.this.lambda$scheduleAtFixedRate$7$DelegatingScheduledExecutorService(this.f$1, this.f$2);
            }
        }, j, j2, timeUnit);
    }

    public /* synthetic */ void lambda$scheduleAtFixedRate$7$DelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$0;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$scheduleAtFixedRate$6(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
            throw e;
        }
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver(runnable, j, j2, timeUnit) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ long f$2;
            public final /* synthetic */ long f$3;
            public final /* synthetic */ TimeUnit f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
                this.f$4 = r7;
            }

            public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
                return DelegatingScheduledExecutorService.this.lambda$scheduleWithFixedDelay$11$DelegatingScheduledExecutorService(this.f$1, this.f$2, this.f$3, this.f$4, completer);
            }
        });
    }

    public /* synthetic */ ScheduledFuture lambda$scheduleWithFixedDelay$11$DelegatingScheduledExecutorService(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleWithFixedDelay(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$1;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DelegatingScheduledExecutorService.this.lambda$scheduleWithFixedDelay$10$DelegatingScheduledExecutorService(this.f$1, this.f$2);
            }
        }, j, j2, timeUnit);
    }

    public /* synthetic */ void lambda$scheduleWithFixedDelay$10$DelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new Runnable(runnable, completer) {
            public final /* synthetic */ Runnable f$0;
            public final /* synthetic */ DelegatingScheduledFuture.Completer f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$scheduleWithFixedDelay$9(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
        }
    }
}
