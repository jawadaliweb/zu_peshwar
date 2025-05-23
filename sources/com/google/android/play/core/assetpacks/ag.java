package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.u;
import com.google.android.play.core.tasks.i;
import java.util.List;

class ag<T> extends u {
    final i<T> a;
    final /* synthetic */ an b;

    ag(an anVar, i<T> iVar) {
        this.b = anVar;
        this.a = iVar;
    }

    ag(an anVar, i iVar, byte[] bArr) {
        this(anVar, iVar);
    }

    ag(an anVar, i iVar, char[] cArr) {
        this(anVar, iVar);
    }

    ag(an anVar, i iVar, int[] iArr) {
        this(anVar, iVar);
    }

    ag(an anVar, i iVar, short[] sArr) {
        this(anVar, iVar);
    }

    public void b(int i, Bundle bundle) {
        this.b.e.b();
        an.a.d("onStartDownload(%d)", Integer.valueOf(i));
    }

    public void c(List<Bundle> list) {
        this.b.e.b();
        an.a.d("onGetSessionStates", new Object[0]);
    }

    public void d(Bundle bundle, Bundle bundle2) {
        this.b.f.b();
        an.a.d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    public void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.b.e.b();
        an.a.d("onGetChunkFileDescriptor", new Object[0]);
    }

    public void f(Bundle bundle, Bundle bundle2) {
        this.b.e.b();
        an.a.d("onRequestDownloadInfo()", new Object[0]);
    }

    public void g(Bundle bundle) {
        this.b.e.b();
        int i = bundle.getInt("error_code");
        an.a.b("onError(%d)", Integer.valueOf(i));
        this.a.d(new AssetPackException(i));
    }

    public final void h(int i) {
        this.b.e.b();
        an.a.d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    public void i() {
        this.b.e.b();
        an.a.d("onCancelDownloads()", new Object[0]);
    }

    public final void j(int i) {
        this.b.e.b();
        an.a.d("onGetSession(%d)", Integer.valueOf(i));
    }

    public void k(Bundle bundle) {
        this.b.e.b();
        an.a.d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    public void l(Bundle bundle) {
        this.b.e.b();
        an.a.d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    public void m(Bundle bundle) {
        this.b.e.b();
        an.a.d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    public void n() {
        this.b.e.b();
        an.a.d("onRemoveModule()", new Object[0]);
    }
}
