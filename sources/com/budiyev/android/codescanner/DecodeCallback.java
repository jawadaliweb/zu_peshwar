package com.budiyev.android.codescanner;

import com.google.zxing.Result;

public interface DecodeCallback {
    void onDecoded(Result result);
}
