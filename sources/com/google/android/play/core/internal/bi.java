package com.google.android.play.core.internal;

public final class bi extends RuntimeException {
    bi(String str) {
        super(str);
    }

    bi(String str, Throwable th) {
        super(str, th);
    }
}
