package com.google.android.play.core.internal;

public final class bf extends RuntimeException {
    public bf(String str) {
        super(str);
    }

    public bf(Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
