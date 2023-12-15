package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.text.Editable;
import android.text.TextWatcher;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardRecharge$initView$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardRecharge.kt */
public final class ZuCardRecharge$initView$5 implements TextWatcher {
    final /* synthetic */ ZuCardRecharge this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ZuCardRecharge$initView$5(ZuCardRecharge zuCardRecharge) {
        this.this$0 = zuCardRecharge;
    }

    public void afterTextChanged(Editable editable) {
        String obj = this.this$0.getBinding().enteredBalance.getText().toString();
        CharSequence charSequence = obj;
        if (!(charSequence == null || charSequence.length() == 0) && Integer.parseInt(obj) > 1000) {
            this.this$0.getBinding().enteredBalance.setText("1000");
            this.this$0.getBinding().enteredBalance.setSelection(this.this$0.getBinding().enteredBalance.length());
            this.this$0.appAlerts.showAlertDialog(this.this$0.getContext(), "Maximum amount limit is 1000", "Info", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuCardRecharge$initView$5.m42afterTextChanged$lambda0(ZuCardRecharge.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: afterTextChanged$lambda-0  reason: not valid java name */
    public static final void m42afterTextChanged$lambda0(ZuCardRecharge zuCardRecharge) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.appAlerts.dismiss();
    }
}
