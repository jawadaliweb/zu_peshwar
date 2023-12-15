package com.irozon.alertview.objects;

import com.irozon.alertview.AlertActionStyle;
import com.irozon.alertview.interfaces.AlertActionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/irozon/alertview/objects/AlertAction;", "", "title", "", "style", "Lcom/irozon/alertview/AlertActionStyle;", "action", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lcom/irozon/alertview/AlertActionStyle;Lkotlin/jvm/functions/Function1;)V", "actionListener", "Lcom/irozon/alertview/interfaces/AlertActionListener;", "(Ljava/lang/String;Lcom/irozon/alertview/AlertActionStyle;Lcom/irozon/alertview/interfaces/AlertActionListener;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "setAction", "(Lkotlin/jvm/functions/Function1;)V", "getActionListener", "()Lcom/irozon/alertview/interfaces/AlertActionListener;", "setActionListener", "(Lcom/irozon/alertview/interfaces/AlertActionListener;)V", "getStyle", "()Lcom/irozon/alertview/AlertActionStyle;", "setStyle", "(Lcom/irozon/alertview/AlertActionStyle;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "alertview_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: AlertAction.kt */
public final class AlertAction {
    private Function1<? super AlertAction, Unit> action;
    private AlertActionListener actionListener;
    private AlertActionStyle style;
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final AlertActionStyle getStyle() {
        return this.style;
    }

    public final void setStyle(AlertActionStyle alertActionStyle) {
        Intrinsics.checkParameterIsNotNull(alertActionStyle, "<set-?>");
        this.style = alertActionStyle;
    }

    public final Function1<AlertAction, Unit> getAction() {
        return this.action;
    }

    public final void setAction(Function1<? super AlertAction, Unit> function1) {
        this.action = function1;
    }

    public final AlertActionListener getActionListener() {
        return this.actionListener;
    }

    public final void setActionListener(AlertActionListener alertActionListener) {
        this.actionListener = alertActionListener;
    }

    public AlertAction(String str, AlertActionStyle alertActionStyle, Function1<? super AlertAction, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(alertActionStyle, "style");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.title = str;
        this.style = alertActionStyle;
        this.action = function1;
        this.actionListener = null;
    }

    public AlertAction(String str, AlertActionStyle alertActionStyle, AlertActionListener alertActionListener) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(alertActionStyle, "style");
        Intrinsics.checkParameterIsNotNull(alertActionListener, "actionListener");
        this.title = str;
        this.style = alertActionStyle;
        this.actionListener = alertActionListener;
        this.action = null;
    }
}
