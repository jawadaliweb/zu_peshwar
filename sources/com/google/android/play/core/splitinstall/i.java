package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.ca;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class i implements SplitInstallManager {
    private final ca<v> a;
    private final ca<FakeSplitInstallManager> b;
    private final ca<File> c;

    i(ca<v> caVar, ca<FakeSplitInstallManager> caVar2, ca<File> caVar3) {
        this.a = caVar;
        this.b = caVar2;
        this.c = caVar3;
    }

    private final SplitInstallManager c() {
        return (SplitInstallManager) (this.c.a() == null ? this.a : this.b).a();
    }

    public final void a(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        c().a(splitInstallStateUpdatedListener);
    }

    public final void b(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        c().b(splitInstallStateUpdatedListener);
    }

    public final Task<Void> cancelInstall(int i) {
        return c().cancelInstall(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return c().deferredInstall(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return c().deferredLanguageInstall(list);
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return c().deferredLanguageUninstall(list);
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return c().deferredUninstall(list);
    }

    public final Set<String> getInstalledLanguages() {
        return c().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return c().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return c().getSessionState(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return c().getSessionStates();
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        c().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return c().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return c().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return c().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        c().unregisterListener(splitInstallStateUpdatedListener);
    }
}
