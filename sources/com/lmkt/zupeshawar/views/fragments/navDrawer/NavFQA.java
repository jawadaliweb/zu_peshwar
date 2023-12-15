package com.lmkt.zupeshawar.views.fragments.navDrawer;

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
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;

public class NavFQA extends Fragment implements View.OnClickListener, APIManager.Callback {
    NavigationDrawerItemsActivity activity;
    WebView wv;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_faq, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
            initWebview(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initWebview(View view) {
        WebView webView = (WebView) view.findViewById(R.id.myWebView);
        this.wv = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.wv.setLongClickable(false);
        this.wv.setHapticFeedbackEnabled(false);
        APIManager.getInstance().getHTMLStaticContent(this, Constants.FAQS, getContext());
    }

    public void initViews(View view) throws Exception {
        initToolbar();
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_Faq);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        view.getId();
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        if (i == ReturnCodes.Companion.OK()) {
            SharedPrefrencesUtil.saveString(Constants.FAQS, apiResponse.getData().getData(), this.activity);
            this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(apiResponse.getData().getData()).toString(), "text/html", "utf-8", (String) null);
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, apiResponse.getRespMessage());
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    NavFQA.this.lambda$onSuccess$0$NavFQA();
                }
            });
            String string = SharedPrefrencesUtil.getString(Constants.FAQS, this.activity);
            if (!string.isEmpty()) {
                this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(((ApiResponse) new Gson().fromJson(string, ApiResponse.class)).getData().getData()).toString(), "text/html", "utf-8", (String) null);
            }
        }
    }

    public /* synthetic */ void lambda$onSuccess$0$NavFQA() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.activity.appAlerts.showErrorAndLogout(this.activity, str);
        } else {
            this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    NavFQA.this.lambda$onFailure$1$NavFQA();
                }
            });
        }
        String string = SharedPrefrencesUtil.getString(Constants.FAQS, this.activity);
        if (!string.isEmpty()) {
            try {
                this.wv.loadDataWithBaseURL((String) null, Html.fromHtml(((ApiResponse) new Gson().fromJson(string, ApiResponse.class)).getData().getData()).toString(), "text/html", "utf-8", (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onFailure$1$NavFQA() {
        this.activity.appAlerts.dismiss();
    }
}
