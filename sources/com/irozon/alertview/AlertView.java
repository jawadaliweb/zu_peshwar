package com.irozon.alertview;

import androidx.appcompat.app.AppCompatActivity;
import com.irozon.alertview.fragments.BottomSheetFragment;
import com.irozon.alertview.fragments.DialogFragment;
import com.irozon.alertview.objects.AlertAction;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/irozon/alertview/AlertView;", "", "title", "", "message", "style", "Lcom/irozon/alertview/AlertStyle;", "(Ljava/lang/String;Ljava/lang/String;Lcom/irozon/alertview/AlertStyle;)V", "actions", "Ljava/util/ArrayList;", "Lcom/irozon/alertview/objects/AlertAction;", "Lkotlin/collections/ArrayList;", "theme", "Lcom/irozon/alertview/AlertTheme;", "addAction", "", "action", "setTheme", "show", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "alertview_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: AlertView.kt */
public final class AlertView {
    private ArrayList<AlertAction> actions = new ArrayList<>();
    private String message;
    private AlertStyle style;
    private AlertTheme theme = AlertTheme.LIGHT;
    private String title;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlertStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlertStyle.BOTTOM_SHEET.ordinal()] = 1;
            iArr[AlertStyle.IOS.ordinal()] = 2;
            iArr[AlertStyle.DIALOG.ordinal()] = 3;
        }
    }

    public AlertView(String str, String str2, AlertStyle alertStyle) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(alertStyle, "style");
        this.title = str;
        this.message = str2;
        this.style = alertStyle;
    }

    public final void addAction(AlertAction alertAction) {
        Intrinsics.checkParameterIsNotNull(alertAction, "action");
        this.actions.add(alertAction);
    }

    public final void show(AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        int i = WhenMappings.$EnumSwitchMapping$0[this.style.ordinal()];
        if (i == 1) {
            BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(this.title, this.message, this.actions, this.style, this.theme);
            bottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), bottomSheetFragment.getTag());
        } else if (i == 2) {
            BottomSheetFragment bottomSheetFragment2 = new BottomSheetFragment(this.title, this.message, this.actions, this.style, this.theme);
            bottomSheetFragment2.show(appCompatActivity.getSupportFragmentManager(), bottomSheetFragment2.getTag());
        } else if (i == 3) {
            DialogFragment dialogFragment = new DialogFragment(this.title, this.message, this.actions, this.theme);
            dialogFragment.show(appCompatActivity.getSupportFragmentManager(), dialogFragment.getTag());
        }
    }

    public final void setTheme(AlertTheme alertTheme) {
        Intrinsics.checkParameterIsNotNull(alertTheme, "theme");
        this.theme = alertTheme;
    }
}
