package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.List;

public class FakeAppUpdateManager implements AppUpdateManager {
    private final a a;
    private final Context b;
    private final List<Integer> c = new ArrayList();
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private int g = 0;
    private Integer h = null;
    private int i = 0;
    private long j = 0;
    private long k = 0;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private Integer o;

    public FakeAppUpdateManager(Context context) {
        this.a = new a(context);
        this.b = context;
    }

    private final boolean a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i2;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.m = true;
            i2 = 1;
        } else {
            this.l = true;
            i2 = 0;
        }
        this.o = i2;
        return true;
    }

    private final int b() {
        if (!this.f) {
            return 1;
        }
        int i2 = this.d;
        return (i2 == 0 || i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3;
    }

    private final void c() {
        this.a.i(InstallState.a(this.d, this.j, this.k, this.e, this.b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i2 = this.e;
        if (i2 != 0) {
            return Tasks.b(new InstallException(i2));
        }
        int i3 = this.d;
        if (i3 != 11) {
            return i3 == 3 ? Tasks.b(new InstallException(-8)) : Tasks.b(new InstallException(-7));
        }
        this.d = 3;
        this.n = true;
        Integer num = 0;
        if (num.equals(this.o)) {
            c();
        }
        return Tasks.a(null);
    }

    public void downloadCompletes() {
        int i2 = this.d;
        if (i2 == 2 || i2 == 1) {
            this.d = 11;
            this.j = 0;
            this.k = 0;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.o)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i2 = this.d;
        if (i2 == 1 || i2 == 2) {
            this.d = 5;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
            this.o = null;
            this.m = false;
            this.d = 0;
        }
    }

    public void downloadStarts() {
        if (this.d == 1) {
            this.d = 2;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        PendingIntent pendingIntent5;
        PendingIntent pendingIntent6;
        int i2 = this.e;
        if (i2 != 0) {
            return Tasks.b(new InstallException(i2));
        }
        if (b() == 2 && this.e == 0) {
            if (this.c.contains(0)) {
                pendingIntent6 = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
                pendingIntent5 = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
            } else {
                pendingIntent6 = null;
                pendingIntent5 = null;
            }
            if (this.c.contains(1)) {
                PendingIntent broadcast = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
                pendingIntent3 = pendingIntent6;
                pendingIntent2 = PendingIntent.getBroadcast(this.b, 0, new Intent(), 0);
                pendingIntent4 = broadcast;
            } else {
                pendingIntent3 = pendingIntent6;
                pendingIntent4 = null;
                pendingIntent2 = null;
            }
            pendingIntent = pendingIntent5;
        } else {
            pendingIntent4 = null;
            pendingIntent3 = null;
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.a(AppUpdateInfo.a(this.b.getPackageName(), this.g, b(), this.d, this.h, this.i, this.j, this.k, 0, 0, pendingIntent4, pendingIntent3, pendingIntent2, pendingIntent));
    }

    public Integer getTypeForUpdateInProgress() {
        return this.o;
    }

    public void installCompletes() {
        if (this.d == 3) {
            this.d = 4;
            this.f = false;
            this.g = 0;
            this.h = null;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.m = false;
            this.n = false;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
            this.o = null;
            this.d = 0;
        }
    }

    public void installFails() {
        if (this.d == 3) {
            this.d = 5;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
            this.o = null;
            this.n = false;
            this.m = false;
            this.d = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.l;
    }

    public boolean isImmediateFlowVisible() {
        return this.m;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.n;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.f(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j2) {
        if (this.d == 2 && j2 <= this.k) {
            this.j = j2;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.f) {
            this.h = num;
        }
    }

    public void setInstallErrorCode(int i2) {
        this.e = i2;
    }

    public void setTotalBytesToDownload(long j2) {
        if (this.d == 2) {
            this.k = j2;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
        }
    }

    public void setUpdateAvailable(int i2) {
        this.f = true;
        this.c.clear();
        this.c.add(0);
        this.c.add(1);
        this.g = i2;
    }

    public void setUpdateAvailable(int i2, int i3) {
        this.f = true;
        this.c.clear();
        this.c.add(Integer.valueOf(i3));
        this.g = i2;
    }

    public void setUpdateNotAvailable() {
        this.f = false;
        this.h = null;
    }

    public void setUpdatePriority(int i2) {
        if (this.f) {
            this.i = i2;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return a(appUpdateInfo, appUpdateOptions) ? Tasks.a(-1) : Tasks.b(new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i2, Activity activity, int i3) {
        return a(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i2, IntentSenderForResultStarter intentSenderForResultStarter, int i3) {
        return a(appUpdateInfo, AppUpdateOptions.newBuilder(i2).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i2) {
        return a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i2) {
        return a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.g(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.l || this.m) {
            this.l = false;
            this.d = 1;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
        }
    }

    public void userCancelsDownload() {
        int i2 = this.d;
        if (i2 == 1 || i2 == 2) {
            this.d = 6;
            Integer num = 0;
            if (num.equals(this.o)) {
                c();
            }
            this.o = null;
            this.m = false;
            this.d = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.l || this.m) {
            this.l = false;
            this.m = false;
            this.o = null;
            this.d = 0;
        }
    }
}
