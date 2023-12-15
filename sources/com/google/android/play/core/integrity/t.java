package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.e;
import com.google.android.play.integrity.internal.k;
import com.google.android.play.integrity.internal.q;
import com.google.android.play.integrity.internal.v;
import com.google.android.play.integrity.internal.y;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class t {
    final v a;
    /* access modifiers changed from: private */
    public final k b;
    private final String c;

    t(Context context, k kVar) {
        this.c = context.getPackageName();
        this.b = kVar;
        if (!y.a(context)) {
            kVar.b("Phonesky is not installed.", new Object[0]);
            this.a = null;
            return;
        }
        this.a = new v(context, kVar, "IntegrityService", u.a, q.a, (q) null, (byte[]) null);
    }

    static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l != null) {
            bundle.putLong("cloud.prj", l.longValue());
        }
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(e.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (e b2 : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", b2.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(arrayList2));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            this.b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.a.p(new r(this, taskCompletionSource, decode, cloudProjectNumber, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e) {
            return Tasks.forException(new IntegrityServiceException(-13, e));
        }
    }
}
