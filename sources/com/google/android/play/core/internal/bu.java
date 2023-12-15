package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class bu extends WeakReference<Throwable> {
    private final int a;

    public bu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            bu buVar = (bu) obj;
            return this.a == buVar.a && get() == buVar.get();
        }
    }

    public final int hashCode() {
        return this.a;
    }
}
