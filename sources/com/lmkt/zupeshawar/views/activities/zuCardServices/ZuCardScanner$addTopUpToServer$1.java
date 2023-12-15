package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.util.Log;
import com.google.firebase.messaging.Constants;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardScanner$addTopUpToServer$1", "Lcom/lmkt/zupeshawar/networkManager/APIManager$Callback;", "onFailure", "", "code", "", "error", "", "onSuccess", "response", "Lcom/lmkt/zupeshawar/networkManager/ApiResponse;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardScanner.kt */
public final class ZuCardScanner$addTopUpToServer$1 implements APIManager.Callback {
    final /* synthetic */ ZuCardScanner this$0;

    ZuCardScanner$addTopUpToServer$1(ZuCardScanner zuCardScanner) {
        this.this$0 = zuCardScanner;
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "response");
        if (this.this$0.getIsoDepcard().isConnected()) {
            ZuCardScanner zuCardScanner = this.this$0;
            zuCardScanner.encodeAmount(zuCardScanner.getAmount());
            apiResponse.getData().getMacAdd();
            byte[] transceive = this.this$0.getIsoDepcard().transceive(this.this$0.decodeHex("805200000B" + this.this$0.getRechargeTime() + apiResponse.getData().getMacAdd() + "04"));
            ZuCardScanner zuCardScanner2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(transceive, "res");
            String dataString = zuCardScanner2.getDataString(transceive);
            Log.d("APIHit", dataString);
            if (StringsKt.contains$default((CharSequence) dataString, (CharSequence) "9000", false, 2, (Object) null)) {
                this.this$0.getCardNumber();
                this.this$0.getRechargeTime();
                String substring = dataString.substring(0, 5);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int transactionID = apiResponse.getData().getTransactionID();
                ZuCardScanner zuCardScanner3 = this.this$0;
                String cardNumber = zuCardScanner3.getCardNumber();
                String rechargeTime = this.this$0.getRechargeTime();
                Intrinsics.checkNotNull(rechargeTime);
                zuCardScanner3.confirmTransaction(cardNumber, transactionID, substring, rechargeTime);
                return;
            }
            this.this$0.getAppAlerts().showAlertDialog(this.this$0.getContext(), "Something went wrong", "Info", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuCardScanner$addTopUpToServer$1.m51onSuccess$lambda0(ZuCardScanner.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m51onSuccess$lambda0(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m50onFailure$lambda1(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
    }

    public void onFailure(int i, String str) {
        Intrinsics.checkNotNullParameter(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        this.this$0.getAppAlerts().showAlertDialog(this.this$0.getContext(), "Something went wrong", "Info", new AppAlertDialog.AlertDialogListener() {
            public final void onClicked() {
                ZuCardScanner$addTopUpToServer$1.m50onFailure$lambda1(ZuCardScanner.this);
            }
        });
    }
}
