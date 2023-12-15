package com.google.android.play.core.review;

import com.google.android.play.core.tasks.j;

final class e extends j {
    e() {
        super("Play Store app is either not installed or not the official version");
    }

    public final int getErrorCode() {
        return -1;
    }
}
