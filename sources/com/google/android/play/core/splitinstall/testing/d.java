package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;

final /* synthetic */ class d implements i {
    private final SplitInstallRequest a;

    d(SplitInstallRequest splitInstallRequest) {
        this.a = splitInstallRequest;
    }

    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        SplitInstallRequest splitInstallRequest = this.a;
        int i = FakeSplitInstallManager.a;
        if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
            return SplitInstallSessionState.create(splitInstallSessionState == null ? 1 : 1 + splitInstallSessionState.sessionId(), 1, 0, 0, 0, splitInstallRequest.getModuleNames(), new ArrayList());
        }
        throw new SplitInstallException(-1);
    }
}
