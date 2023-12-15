package com.budiyev.android.codescanner;

import com.budiyev.android.codescanner.Utils;

public interface ErrorCallback {
    public static final ErrorCallback SUPPRESS = new Utils.SuppressErrorCallback();

    void onError(Exception exc);
}
