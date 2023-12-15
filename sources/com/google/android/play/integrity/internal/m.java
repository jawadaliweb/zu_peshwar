package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final /* synthetic */ class m implements OnCompleteListener {
    public final /* synthetic */ v a;
    public final /* synthetic */ TaskCompletionSource b;

    public /* synthetic */ m(v vVar, TaskCompletionSource taskCompletionSource) {
        this.a = vVar;
        this.b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.a.q(this.b, task);
    }
}
