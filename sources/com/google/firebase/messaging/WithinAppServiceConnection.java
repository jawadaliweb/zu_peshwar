package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WithinAppServiceConnection implements ServiceConnection {
    private static final int REQUEST_TIMEOUT_MS = 9000;
    private WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        /* access modifiers changed from: package-private */
        public void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            long j;
            boolean z = (this.intent.getFlags() & 268435456) != 0;
            $$Lambda$WithinAppServiceConnection$BindRequest$dwnE8aMY1OlCtwZVApE_Us9evs r1 = new Runnable() {
                public final void run() {
                    WithinAppServiceConnection.BindRequest.this.lambda$arrangeTimeout$0$WithinAppServiceConnection$BindRequest();
                }
            };
            if (z) {
                j = WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
            } else {
                j = 9000;
            }
            getTask().addOnCompleteListener((Executor) scheduledExecutorService, new OnCompleteListener(scheduledExecutorService.schedule(r1, j, TimeUnit.MILLISECONDS)) {
                public final /* synthetic */ ScheduledFuture f$0;

                {
                    this.f$0 = r1;
                }

                public final void onComplete(Task task) {
                    this.f$0.cancel(false);
                }
            });
        }

        public /* synthetic */ void lambda$arrangeTimeout$0$WithinAppServiceConnection$BindRequest() {
            Log.w(Constants.TAG, "Service took too long to process intent: " + this.intent.getAction() + " Releasing WakeLock.");
            finish();
        }

        /* access modifiers changed from: package-private */
        public Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }

        /* access modifiers changed from: package-private */
        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }
    }

    WithinAppServiceConnection(Context context2, String str) {
        this(context2, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    WithinAppServiceConnection(Context context2, String str, ScheduledExecutorService scheduledExecutorService2) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Task<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "new intent queued in the bind-strategy delivery");
        }
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    private synchronized void flushQueue() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "flush queue called");
        }
        while (!this.intentQueue.isEmpty()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "found intent to be delivered");
            }
            WithinAppServiceBinder withinAppServiceBinder = this.binder;
            if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                startConnectionIfNeeded();
                return;
            }
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "binder is alive, sending the intent.");
            }
            this.binder.send(this.intentQueue.poll());
        }
    }

    private void startConnectionIfNeeded() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.connectionInProgress);
            Log.d(Constants.TAG, sb.toString());
        }
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (!ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
                    Log.e(Constants.TAG, "binding to the service failed");
                    this.connectionInProgress = false;
                    finishAllInQueue();
                }
            } catch (SecurityException e) {
                Log.e(Constants.TAG, "Exception while binding the service", e);
            }
        }
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "onServiceConnected: " + componentName);
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            Log.e(Constants.TAG, "Invalid service connection: " + iBinder);
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "onServiceDisconnected: " + componentName);
        }
        flushQueue();
    }
}
