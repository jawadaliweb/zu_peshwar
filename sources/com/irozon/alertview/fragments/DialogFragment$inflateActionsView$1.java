package com.irozon.alertview.fragments;

import android.view.View;
import com.irozon.alertview.interfaces.AlertActionListener;
import com.irozon.alertview.objects.AlertAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: DialogFragment.kt */
final class DialogFragment$inflateActionsView$1 implements View.OnClickListener {
    final /* synthetic */ AlertAction $action;
    final /* synthetic */ DialogFragment this$0;

    DialogFragment$inflateActionsView$1(DialogFragment dialogFragment, AlertAction alertAction) {
        this.this$0 = dialogFragment;
        this.$action = alertAction;
    }

    public final void onClick(View view) {
        this.this$0.dismiss();
        Function1<AlertAction, Unit> action = this.$action.getAction();
        if (action != null) {
            AlertAction alertAction = this.$action;
            Intrinsics.checkExpressionValueIsNotNull(alertAction, "action");
            Unit invoke = action.invoke(alertAction);
        }
        AlertActionListener actionListener = this.$action.getActionListener();
        if (actionListener != null) {
            AlertAction alertAction2 = this.$action;
            Intrinsics.checkExpressionValueIsNotNull(alertAction2, "action");
            actionListener.onActionClick(alertAction2);
        }
    }
}
