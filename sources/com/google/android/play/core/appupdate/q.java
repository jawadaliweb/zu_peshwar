package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

final class q {
    private final Context a;

    q(Context context) {
        this.a = context;
    }

    private static long b(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File b : listFiles) {
                j += b(b);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        return b(new File(this.a.getFilesDir(), "assetpacks"));
    }
}
