package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class da implements FilenameFilter {
    static final FilenameFilter a = new da();

    private da() {
    }

    public final boolean accept(File file, String str) {
        return db.a.matcher(str).matches();
    }
}
