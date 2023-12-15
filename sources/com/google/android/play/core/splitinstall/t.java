package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;

final class t implements Runnable {
    final /* synthetic */ SplitInstallRequest a;
    final /* synthetic */ v b;

    t(v vVar, SplitInstallRequest splitInstallRequest) {
        this.b = vVar;
        this.a = splitInstallRequest;
    }

    public final void run() {
        s d = this.b.b;
        List<String> moduleNames = this.a.getModuleNames();
        List c = v.e(this.a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt(NotificationCompat.CATEGORY_STATUS, 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!c.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(c));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        d.k(SplitInstallSessionState.d(bundle));
    }
}
