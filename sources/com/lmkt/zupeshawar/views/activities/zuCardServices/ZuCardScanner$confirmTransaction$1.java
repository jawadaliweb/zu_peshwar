package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.util.Log;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardScanner$confirmTransaction$1", "Lcom/lmkt/zupeshawar/networkManager/APIManager$Callback;", "onFailure", "", "code", "", "error", "", "onSuccess", "response", "Lcom/lmkt/zupeshawar/networkManager/ApiResponse;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardScanner.kt */
public final class ZuCardScanner$confirmTransaction$1 implements APIManager.Callback {
    final /* synthetic */ ZuCardScanner this$0;

    ZuCardScanner$confirmTransaction$1(ZuCardScanner zuCardScanner) {
        this.this$0 = zuCardScanner;
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNull(apiResponse);
        Log.d("Confirm", apiResponse.getRespMessage());
        this.this$0.getAppAlerts().showSuccessDialog(this.this$0.getContext(), "Card Recharge Completed successfully", new AppAlertDialog.AlertDialogListener() {
            public final void onClicked() {
                ZuCardScanner$confirmTransaction$1.m53onSuccess$lambda0(ZuCardScanner.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m53onSuccess$lambda0(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
        zuCardScanner.loadDashboard();
    }

    public void onFailure(int i, String str) {
        this.this$0.getAppAlerts().showErrorDialog(this.this$0.getContext(), "Something went wrong please try again", new AppAlertDialog.AlertDialogListener() {
            public final void onClicked() {
                ZuCardScanner$confirmTransaction$1.m52onFailure$lambda1(ZuCardScanner.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m52onFailure$lambda1(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
        zuCardScanner.loadDashboard();
    }
}
