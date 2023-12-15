package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class o extends l {
    final /* synthetic */ l a;
    final /* synthetic */ v b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(v vVar, TaskCompletionSource taskCompletionSource, l lVar) {
        super(taskCompletionSource);
        this.b = vVar;
        this.a = lVar;
    }

    public final void b() {
        v.m(this.b, this.a);
    }
}
