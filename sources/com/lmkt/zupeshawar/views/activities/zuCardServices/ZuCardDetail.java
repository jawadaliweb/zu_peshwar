package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.databinding.ActivityZuCardDetailBinding;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006'"}, d2 = {"Lcom/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardDetail;", "Lcom/lmkt/zupeshawar/views/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "AppAlerts", "Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "getAppAlerts", "()Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "setAppAlerts", "(Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;)V", "Balance", "", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "CardNumber", "getCardNumber", "setCardNumber", "binding", "Lcom/lmkt/zupeshawar/databinding/ActivityZuCardDetailBinding;", "getBinding", "()Lcom/lmkt/zupeshawar/databinding/ActivityZuCardDetailBinding;", "setBinding", "(Lcom/lmkt/zupeshawar/databinding/ActivityZuCardDetailBinding;)V", "rawDate", "getRawDate", "setRawDate", "goBack", "", "initToolBar", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showmessage", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardDetail.kt */
public final class ZuCardDetail extends BaseActivity implements View.OnClickListener {
    public AppAlertDialog AppAlerts;
    private String Balance;
    private String CardNumber;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public ActivityZuCardDetailBinding binding;
    private String rawDate;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final ActivityZuCardDetailBinding getBinding() {
        ActivityZuCardDetailBinding activityZuCardDetailBinding = this.binding;
        if (activityZuCardDetailBinding != null) {
            return activityZuCardDetailBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityZuCardDetailBinding activityZuCardDetailBinding) {
        Intrinsics.checkNotNullParameter(activityZuCardDetailBinding, "<set-?>");
        this.binding = activityZuCardDetailBinding;
    }

    public final AppAlertDialog getAppAlerts() {
        AppAlertDialog appAlertDialog = this.AppAlerts;
        if (appAlertDialog != null) {
            return appAlertDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("AppAlerts");
        return null;
    }

    public final void setAppAlerts(AppAlertDialog appAlertDialog) {
        Intrinsics.checkNotNullParameter(appAlertDialog, "<set-?>");
        this.AppAlerts = appAlertDialog;
    }

    public final String getCardNumber() {
        return this.CardNumber;
    }

    public final void setCardNumber(String str) {
        this.CardNumber = str;
    }

    public final String getBalance() {
        return this.Balance;
    }

    public final void setBalance(String str) {
        this.Balance = str;
    }

    public final String getRawDate() {
        return this.rawDate;
    }

    public final void setRawDate(String str) {
        this.rawDate = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityZuCardDetailBinding inflate = ActivityZuCardDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        setBinding(inflate);
        setContentView((View) getBinding().getRoot());
        initToolBar();
        initView();
    }

    private final void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("CardNumber");
        String stringExtra2 = intent.getStringExtra("expiryDate");
        String stringExtra3 = intent.getStringExtra("Balance");
        this.rawDate = intent.getStringExtra("rawDate");
        this.CardNumber = stringExtra;
        this.Balance = stringExtra3;
        getBinding().textView2.setText(stringExtra);
        getBinding().textView4.setText(stringExtra2);
        getBinding().balance.setText(stringExtra3);
        getBinding().button2.setOnClickListener(this);
        setAppAlerts(new AppAlertDialog(this));
    }

    private final void initToolBar() {
        ActivityZuCardDetailBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2);
        binding2.toolbarTitle.setText("Zu Card Details");
        ActivityZuCardDetailBinding binding3 = getBinding();
        Intrinsics.checkNotNull(binding3);
        binding3.BtnBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            goBack();
        } else if (id == R.id.button2) {
            showmessage();
        }
    }

    private final void showmessage() {
        Context context = this;
        if (Integer.parseInt(SharedPrefrencesUtil.getUserObject_Prefrences(context).getAccountBalance()) < BaseActivity.minimumBalance) {
            getAppAlerts().showErrorDialog(context, "Insufficient Balance in your wallet", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuCardDetail.m30showmessage$lambda0(ZuCardDetail.this);
                }
            });
            return;
        }
        Intent intent = new Intent(context, ZuCardRecharge.class);
        intent.putExtra("CardNumber", this.CardNumber);
        intent.putExtra("balance", this.Balance);
        intent.putExtra("rawDate", this.rawDate);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: showmessage$lambda-0  reason: not valid java name */
    public static final void m30showmessage$lambda0(ZuCardDetail zuCardDetail) {
        Intrinsics.checkNotNullParameter(zuCardDetail, "this$0");
        zuCardDetail.getAppAlerts().dismiss();
    }

    private final void goBack() {
        onBackPressed();
    }
}
