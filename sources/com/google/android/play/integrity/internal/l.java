package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public abstract class l implements Runnable {
    private final TaskCompletionSource a;

    l() {
        this.a = null;
    }

    public l(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: package-private */
    public final TaskCompletionSource c() {
        return this.a;
    }

    public final void run() {
        try {
            b();
        } catch (Exception e) {
            a(e);
        }
    }
}
