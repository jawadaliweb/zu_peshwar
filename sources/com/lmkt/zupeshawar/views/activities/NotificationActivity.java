package com.lmkt.zupeshawar.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.Notifications;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import java.util.ArrayList;

public class NotificationActivity extends BaseActivity implements APIManager.Callback {
    private static String Title = "Notifications";
    ListView list;
    public ImageView mToolbar_LeftBtn;
    public TextView mToolbar_Title;
    LinearLayout noDataView;
    public Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_notification);
        try {
            initToolbar();
            get_Notifications();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void get_Notifications() {
        this.appAlerts.showPleaseWait(this);
        APIManager.getInstance().getNotifications(this, getApplicationContext());
    }

    private void initToolbar() throws Exception {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setTitle((CharSequence) "");
        this.mToolbar_Title = (TextView) this.toolbar.findViewById(R.id.toolbar_title);
        this.mToolbar_LeftBtn = (ImageView) this.toolbar.findViewById(R.id.notification_IV);
        setSupportActionBar(this.toolbar);
        this.mToolbar_Title.setText(R.string.label_notification);
        this.list = (ListView) findViewById(R.id.listview);
        this.noDataView = (LinearLayout) findViewById(R.id.noDataView);
    }

    public void onBackPressed() {
        super.onBackPressed();
        SharedPrefrencesUtil.setInt(Constants.NOTIFICATION_COUNT, 0, this);
        finish();
        overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private ArrayList<Notifications> refactorNotificationList(ArrayList<Notifications> arrayList) {
        ArrayList<Notifications> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String[] split = arrayList.get(i).getDatetime().split(MaskedEditText.SPACE);
            String notification = arrayList.get(i).getNotification();
            String datetime = arrayList.get(i).getDatetime();
            arrayList2.add(new Notifications(notification, datetime, split[1] + MaskedEditText.SPACE + split[2], split[0], false));
        }
        return arrayList2;
    }

    private ArrayList<Notifications> AddSections(ArrayList<Notifications> arrayList) {
        ArrayList<Notifications> arrayList2 = new ArrayList<>();
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            if (!str.equals(arrayList.get(i).getNotification())) {
                Notifications notifications = new Notifications("", "", "", arrayList.get(i).getNotificationDate(), false);
                notifications.setSectionHeader(true);
                arrayList2.add(notifications);
                str = arrayList.get(i).getNotificationDate();
            }
            arrayList2.add(arrayList.get(i));
        }
        return arrayList2;
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        if (i == ReturnCodes.Companion.OK()) {
            try {
                this.appAlerts.dismiss();
                if (apiResponse.getData().getNotifications() == null) {
                    runOnUiThread(new Runnable() {
                        public final void run() {
                            NotificationActivity.this.lambda$onSuccess$0$NotificationActivity();
                        }
                    });
                    return;
                }
                runOnUiThread(new Runnable() {
                    public final void run() {
                        NotificationActivity.this.lambda$onSuccess$1$NotificationActivity();
                    }
                });
                this.list.setAdapter(new ListAdapter(this, AddSections(refactorNotificationList(apiResponse.getData().getNotifications()))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == ReturnCodes.Companion.BAD_REQUEST()) {
            this.appAlerts.dismiss();
            runOnUiThread(new Runnable() {
                public final void run() {
                    NotificationActivity.this.lambda$onSuccess$2$NotificationActivity();
                }
            });
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.appAlerts.showErrorAndLogout(this, apiResponse.getRespMessage());
        } else {
            this.appAlerts.showErrorDialog(this, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    NotificationActivity.this.lambda$onSuccess$3$NotificationActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSuccess$0$NotificationActivity() {
        this.list.setVisibility(8);
        this.noDataView.setVisibility(0);
    }

    public /* synthetic */ void lambda$onSuccess$1$NotificationActivity() {
        this.list.setVisibility(0);
        this.noDataView.setVisibility(8);
    }

    public /* synthetic */ void lambda$onSuccess$2$NotificationActivity() {
        this.list.setVisibility(8);
        this.noDataView.setVisibility(0);
    }

    public /* synthetic */ void lambda$onSuccess$3$NotificationActivity() {
        this.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        this.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.appAlerts.showErrorAndLogout(this, str);
        } else {
            this.appAlerts.showErrorDialog(this, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    NotificationActivity.this.lambda$onFailure$4$NotificationActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onFailure$4$NotificationActivity() {
        this.appAlerts.dismiss();
    }

    public class ListAdapter extends ArrayAdapter {
        LayoutInflater inflater;

        public ListAdapter(Context context, ArrayList<Notifications> arrayList) {
            super(context, 0, arrayList);
            this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Notifications notifications = (Notifications) getItem(i);
            if (notifications.isSectionHeader()) {
                View inflate = this.inflater.inflate(R.layout.section_header, (ViewGroup) null);
                inflate.setClickable(false);
                ((TextView) inflate.findViewById(R.id.section_header)).setText(notifications.getNotificationDate());
                return inflate;
            }
            View inflate2 = this.inflater.inflate(R.layout.row_item_notifications, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.notification_TV)).setText(notifications.getNotification());
            ((TextView) inflate2.findViewById(R.id.notification_date_TV)).setText(notifications.getNotificatonTime());
            return inflate2;
        }
    }
}
