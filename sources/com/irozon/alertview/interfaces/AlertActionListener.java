package com.irozon.alertview.interfaces;

import com.irozon.alertview.objects.AlertAction;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/irozon/alertview/interfaces/AlertActionListener;", "", "onActionClick", "", "action", "Lcom/irozon/alertview/objects/AlertAction;", "alertview_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: AlertActionListener.kt */
public interface AlertActionListener {
    void onActionClick(AlertAction alertAction);
}
