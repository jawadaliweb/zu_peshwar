package com.budiyev.android.codescanner;

public final class CodeScannerException extends RuntimeException {
    public CodeScannerException() {
    }

    public CodeScannerException(String str) {
        super(str);
    }

    public CodeScannerException(String str, Throwable th) {
        super(str, th);
    }

    public CodeScannerException(Throwable th) {
        super(th);
    }

    protected CodeScannerException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
    }
}
