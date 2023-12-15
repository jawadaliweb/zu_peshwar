package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;

public class TravelCondition extends Fragment implements View.OnClickListener, IOnBackPressed, APIManager.Callback {
    private static final String TAG = "Tickets_Travel_Condition";
    TicketsMenuItemActivity activity;
    WebView wv;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_travelcondition, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        initWebview(view);
    }

    private void initWebview(View view) {
        WebView webView = (WebView) view.findViewById(R.id.myWebView);
        this.wv = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.wv.setLongClickable(false);
        this.wv.setHapticFeedbackEnabled(false);
        APIManager.getInstance().getHTMLStaticContent(this, Constants.TRAVEL_CONDITION, getContext());
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.title_travelconditions);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        if (i == ReturnCodes.Companion.OK()) {
            SharedPrefrencesUtil.saveString(Constants.TRAVEL_CONDITION, apiResponse.getData().getData(), this.activity);
            this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(apiResponse.getData().getData()).toString(), "text/html", "utf-8", (String) null);
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    TravelCondition.this.lambda$onSuccess$0$TravelCondition();
                }
            });
            String string = SharedPrefrencesUtil.getString(Constants.TRAVEL_CONDITION, this.activity);
            if (!string.isEmpty()) {
                this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(((ApiResponse) new Gson().fromJson(string, ApiResponse.class)).getData().getData()).toString(), "text/html", "utf-8", (String) null);
            }
        }
    }

    public /* synthetic */ void lambda$onSuccess$0$TravelCondition() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    TravelCondition.this.lambda$onFailure$1$TravelCondition();
                }
            });
        }
        String string = SharedPrefrencesUtil.getString(Constants.TRAVEL_CONDITION, this.activity);
        if (!string.isEmpty()) {
            try {
                this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(((ApiResponse) new Gson().fromJson(string, ApiResponse.class)).getData().getData()).toString(), "text/html", "utf-8", (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onFailure$1$TravelCondition() {
        this.activity.appAlerts.dismiss();
    }
}
