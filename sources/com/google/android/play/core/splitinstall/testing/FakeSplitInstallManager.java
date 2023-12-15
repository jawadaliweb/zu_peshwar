package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.af;
import com.google.android.play.core.internal.ax;
import com.google.android.play.core.internal.bo;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.e;
import com.google.android.play.core.splitinstall.h;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {
    public static final /* synthetic */ int a = 0;
    private static final long c = TimeUnit.SECONDS.toMillis(1);
    private final Handler b;
    private final Context d;
    private final p e;
    private final bo f;
    private final af<SplitInstallSessionState> g;
    private final af<SplitInstallSessionState> h;
    private final Executor i;
    private final e j;
    private final File k;
    private final AtomicReference<SplitInstallSessionState> l;
    private final Set<String> m;
    private final Set<String> n;
    private final AtomicBoolean o;
    private final a p;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, File file, p pVar) {
        Executor a2 = com.google.android.play.core.splitcompat.p.a();
        bo boVar = new bo(context);
        a aVar = a.a;
        this.b = new Handler(Looper.getMainLooper());
        this.l = new AtomicReference<>();
        this.m = Collections.synchronizedSet(new HashSet());
        this.n = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicBoolean(false);
        this.d = context;
        this.k = file;
        this.e = pVar;
        this.i = a2;
        this.f = boVar;
        this.p = aVar;
        this.h = new af<>();
        this.g = new af<>();
        this.j = l.a;
    }

    static final /* synthetic */ SplitInstallSessionState g(int i2, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i2 == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i2, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    static final /* synthetic */ SplitInstallSessionState i(Integer num, int i2, int i3, Long l2, Long l3, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i2, i3, l2 == null ? create.bytesDownloaded() : l2.longValue(), l3 == null ? create.totalBytesToDownload() : l3.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    private final SplitInstallSessionState n() {
        return this.l.get();
    }

    private final synchronized SplitInstallSessionState o(i iVar) {
        SplitInstallSessionState n2 = n();
        SplitInstallSessionState a2 = iVar.a(n2);
        if (this.l.compareAndSet(n2, a2)) {
            return a2;
        }
        return null;
    }

    private final boolean p(int i2, int i3, Long l2, Long l3, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState o2 = o(new b(num, i2, i3, l2, l3, list, list2));
        if (o2 == null) {
            return false;
        }
        t(o2);
        return true;
    }

    private final Task<Integer> q(int i2) {
        o(new e(i2, (byte[]) null));
        return Tasks.b(new SplitInstallException(i2));
    }

    private static String r(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    private final h s() {
        h c2 = this.e.c();
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    private final void t(SplitInstallSessionState splitInstallSessionState) {
        this.b.post(new f(this, splitInstallSessionState));
    }

    /* access modifiers changed from: private */
    public final void u(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        List<Intent> list4 = list;
        this.j.a().a(list, new h(this, list2, list3, j2, z, list));
    }

    /* access modifiers changed from: private */
    public final void v(List<String> list, List<String> list2, long j2) {
        this.m.addAll(list);
        this.n.addAll(list2);
        Long valueOf = Long.valueOf(j2);
        p(5, 0, valueOf, valueOf, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* access modifiers changed from: private */
    public final boolean w(int i2) {
        return p(6, i2, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    public final void a(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.a(splitInstallStateUpdatedListener);
    }

    public final void b(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.g.b(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    public final File c() {
        return this.k;
    }

    public final Task<Void> cancelInstall(int i2) {
        try {
            SplitInstallSessionState o2 = o(new e(i2));
            if (o2 != null) {
                t(o2);
            }
            return Tasks.a(null);
        } catch (SplitInstallException e2) {
            return Tasks.b(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(List list, List list2, List list3, long j2) {
        if (this.o.get()) {
            w(-6);
        } else if (this.j.a() != null) {
            u(list, list2, list3, j2, false);
        } else {
            v(list2, list3, j2);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.b(new SplitInstallException(-5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void e(long j2, List list, List list2, List list3) {
        long j3 = j2;
        long j4 = j3 / 3;
        long j5 = 0;
        int i2 = 0;
        while (i2 < 3) {
            j5 = Math.min(j3, j5 + j4);
            p(2, 0, Long.valueOf(j5), Long.valueOf(j2), (List<String>) null, (Integer) null, (List<String>) null);
            SystemClock.sleep(c);
            SplitInstallSessionState n2 = n();
            if (n2.status() != 9 && n2.status() != 7 && n2.status() != 6) {
                i2++;
            } else {
                return;
            }
        }
        this.i.execute(new g(this, list, list2, list3, j2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(SplitInstallSessionState splitInstallSessionState) {
        this.g.c(splitInstallSessionState);
        this.h.c(splitInstallSessionState);
    }

    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.e.b() != null) {
            hashSet.addAll(this.e.b());
        }
        hashSet.addAll(this.n);
        return hashSet;
    }

    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.e.a());
        hashSet.addAll(this.m);
        return hashSet;
    }

    public final Task<SplitInstallSessionState> getSessionState(int i2) {
        SplitInstallSessionState n2 = n();
        return (n2 == null || n2.sessionId() != i2) ? Tasks.b(new SplitInstallException(-4)) : Tasks.a(n2);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState n2 = n();
        return Tasks.a(n2 != null ? Collections.singletonList(n2) : Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String b2 = ax.b(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", r(b2));
            intent.putExtra("split_id", b2);
            arrayList.add(intent);
            arrayList2.add(r(ax.b(file)));
        }
        SplitInstallSessionState n2 = n();
        if (n2 != null) {
            this.i.execute(new g(this, n2.totalBytesToDownload(), (List) arrayList, (List) arrayList2, list2));
        }
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.h.a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.o.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0131, code lost:
        if (r0.contains(r6) == false) goto L_0x013a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r22) {
        /*
            r21 = this;
            r9 = r21
            com.google.android.play.core.splitinstall.testing.d r0 = new com.google.android.play.core.splitinstall.testing.d     // Catch:{ SplitInstallException -> 0x021d }
            r1 = r22
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x021d }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r9.o(r0)     // Catch:{ SplitInstallException -> 0x021d }
            if (r0 == 0) goto L_0x0216
            int r0 = r0.sessionId()     // Catch:{ SplitInstallException -> 0x021d }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r2 = r22.getLanguages()
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.k
            java.io.File[] r3 = r3.listFiles()
            java.lang.String r4 = "FakeSplitInstallManager"
            if (r3 != 0) goto L_0x0053
            java.lang.String r0 = "Specified splits directory does not exist."
            android.util.Log.w(r4, r0)
            r0 = -5
            com.google.android.play.core.tasks.Task r0 = r9.q(r0)
            return r0
        L_0x0053:
            int r5 = r3.length
            r12 = 0
            r13 = 0
        L_0x0057:
            if (r12 >= r5) goto L_0x019a
            r15 = r3[r12]
            java.lang.String r6 = com.google.android.play.core.internal.ax.b(r15)
            java.lang.String r7 = r(r6)
            r2.add(r6)
            java.util.List r8 = r22.getModuleNames()
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0134
            java.lang.String r7 = r(r6)
            java.util.HashSet r8 = new java.util.HashSet
            com.google.android.play.core.internal.bo r1 = r9.f
            java.util.List r1 = r1.a()
            r8.<init>(r1)
            com.google.android.play.core.splitinstall.h r1 = r21.s()
            r17 = r3
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]
            r16 = 0
            r3[r16] = r7
            java.util.List r3 = java.util.Arrays.asList(r3)
            java.util.Map r1 = r1.a(r3)
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a1:
            boolean r18 = r7.hasNext()
            if (r18 == 0) goto L_0x00b7
            java.lang.Object r18 = r7.next()
            r19 = r5
            r5 = r18
            java.util.Set r5 = (java.util.Set) r5
            r3.addAll(r5)
            r5 = r19
            goto L_0x00a1
        L_0x00b7:
            r19 = r5
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Iterator r7 = r8.iterator()
        L_0x00c2:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00ee
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r18 = r7
            java.lang.String r7 = "_"
            boolean r20 = r8.contains(r7)
            if (r20 == 0) goto L_0x00e3
            r20 = r0
            r0 = -1
            java.lang.String[] r0 = r8.split(r7, r0)
            r7 = 0
            r8 = r0[r7]
            goto L_0x00e6
        L_0x00e3:
            r20 = r0
            r7 = 0
        L_0x00e6:
            r5.add(r8)
            r7 = r18
            r0 = r20
            goto L_0x00c2
        L_0x00ee:
            r20 = r0
            r7 = 0
            java.util.Set<java.lang.String> r0 = r9.n
            r5.addAll(r0)
            r5.addAll(r10)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0106:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0127
            java.lang.Object r8 = r1.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r7 = r8.getKey()
            boolean r7 = r5.contains(r7)
            if (r7 == 0) goto L_0x0125
            java.lang.Object r7 = r8.getValue()
            java.util.Collection r7 = (java.util.Collection) r7
            r0.addAll(r7)
        L_0x0125:
            r7 = 0
            goto L_0x0106
        L_0x0127:
            boolean r1 = r3.contains(r6)
            if (r1 == 0) goto L_0x0186
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x013a
            goto L_0x0186
        L_0x0134:
            r20 = r0
            r17 = r3
            r19 = r5
        L_0x013a:
            java.util.List r0 = r22.getLanguages()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set<java.lang.String> r3 = r9.m
            r1.<init>(r3)
            java.lang.String r3 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r3 = new java.lang.String[]{r3, r5}
            java.util.List r3 = java.util.Arrays.asList(r3)
            r1.addAll(r3)
            com.google.android.play.core.splitinstall.h r3 = r21.s()
            java.util.Map r1 = r3.a(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0160:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x018e
            java.lang.Object r3 = r0.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r5 = r3.getLanguage()
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x0160
            java.lang.String r3 = r3.getLanguage()
            java.lang.Object r3 = r1.get(r3)
            java.util.Set r3 = (java.util.Set) r3
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x0160
        L_0x0186:
            long r0 = r15.length()
            long r13 = r13 + r0
            r11.add(r15)
        L_0x018e:
            int r12 = r12 + 1
            r1 = r22
            r3 = r17
            r5 = r19
            r0 = r20
            goto L_0x0057
        L_0x019a:
            r20 = r0
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.util.List r1 = r22.getModuleNames()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r3 = r3 + 22
            int r3 = r3 + r5
            r6.<init>(r3)
            java.lang.String r3 = "availableSplits "
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = " want "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = r6.toString()
            android.util.Log.i(r4, r0)
            java.util.HashSet r0 = new java.util.HashSet
            java.util.List r1 = r22.getModuleNames()
            r0.<init>(r1)
            boolean r0 = r2.containsAll(r0)
            if (r0 != 0) goto L_0x01ec
            r0 = -2
            com.google.android.play.core.tasks.Task r0 = r9.q(r0)
            return r0
        L_0x01ec:
            r0 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            java.lang.Long r5 = java.lang.Long.valueOf(r13)
            java.util.List r6 = r22.getModuleNames()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r2 = 1
            r3 = 0
            r1 = r21
            r7 = r0
            r8 = r10
            r1.p(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.i
            com.google.android.play.core.splitinstall.testing.c r2 = new com.google.android.play.core.splitinstall.testing.c
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.a(r0)
            return r0
        L_0x0216:
            r0 = -100
            com.google.android.play.core.tasks.Task r0 = r9.q(r0)     // Catch:{ SplitInstallException -> 0x021d }
            return r0
        L_0x021d:
            r0 = move-exception
            int r0 = r0.getErrorCode()
            com.google.android.play.core.tasks.Task r0 = r9.q(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.h.b(splitInstallStateUpdatedListener);
    }
}
