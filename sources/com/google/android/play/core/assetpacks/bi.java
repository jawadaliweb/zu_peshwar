package com.google.android.play.core.assetpacks;

import java.io.InputStream;

final class bi extends cc {
    final int a;
    final long b;
    final String c;
    final int d;
    final int e;
    final int f;
    final long g;
    final int h;
    final InputStream i;

    bi(int i2, String str, int i3, long j, String str2, int i4, int i5, int i6, long j2, int i7, InputStream inputStream) {
        super(i2, str);
        this.a = i3;
        this.b = j;
        this.c = str2;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = j2;
        this.h = i7;
        this.i = inputStream;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.e + 1 == this.f;
    }
}
