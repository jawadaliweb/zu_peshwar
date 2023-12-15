package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.databinding.ActivityZuCardRechargeBinding;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u001a\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00101\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020'H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardRecharge;", "Lcom/lmkt/zupeshawar/views/activities/BaseActivity;", "Lcom/lmkt/zupeshawar/networkManager/APIManager$Callback;", "()V", "Balance", "", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "CardNumber", "getCardNumber", "setCardNumber", "appAlerts", "Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "getAppAlerts", "()Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "setAppAlerts", "(Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;)V", "binding", "Lcom/lmkt/zupeshawar/databinding/ActivityZuCardRechargeBinding;", "getBinding", "()Lcom/lmkt/zupeshawar/databinding/ActivityZuCardRechargeBinding;", "setBinding", "(Lcom/lmkt/zupeshawar/databinding/ActivityZuCardRechargeBinding;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "rawDate", "user", "Lcom/lmkt/zupeshawar/model/User;", "getUser", "()Lcom/lmkt/zupeshawar/model/User;", "setUser", "(Lcom/lmkt/zupeshawar/model/User;)V", "initToolBar", "", "initView", "loadScanner", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "code", "", "error", "onSuccess", "response", "Lcom/lmkt/zupeshawar/networkManager/ApiResponse;", "validateBalance", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardRecharge.kt */
public final class ZuCardRecharge extends BaseActivity implements APIManager.Callback {
    private String Balance;
    private String CardNumber;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public AppAlertDialog appAlerts;
    public ActivityZuCardRechargeBinding binding;
    private Context context;
    private String rawDate = "";
    public User user;

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

    public final ActivityZuCardRechargeBinding getBinding() {
        ActivityZuCardRechargeBinding activityZuCardRechargeBinding = this.binding;
        if (activityZuCardRechargeBinding != null) {
            return activityZuCardRechargeBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityZuCardRechargeBinding activityZuCardRechargeBinding) {
        Intrinsics.checkNotNullParameter(activityZuCardRechargeBinding, "<set-?>");
        this.binding = activityZuCardRechargeBinding;
    }

    public final User getUser() {
        User user2 = this.user;
        if (user2 != null) {
            return user2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("user");
        return null;
    }

    public final void setUser(User user2) {
        Intrinsics.checkNotNullParameter(user2, "<set-?>");
        this.user = user2;
    }

    public final AppAlertDialog getAppAlerts() {
        AppAlertDialog appAlertDialog = this.appAlerts;
        if (appAlertDialog != null) {
            return appAlertDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appAlerts");
        return null;
    }

    public final void setAppAlerts(AppAlertDialog appAlertDialog) {
        Intrinsics.checkNotNullParameter(appAlertDialog, "<set-?>");
        this.appAlerts = appAlertDialog;
    }

    public final String getBalance() {
        return this.Balance;
    }

    public final void setBalance(String str) {
        this.Balance = str;
    }

    public final String getCardNumber() {
        return this.CardNumber;
    }

    public final void setCardNumber(String str) {
        this.CardNumber = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityZuCardRechargeBinding inflate = ActivityZuCardRechargeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        setBinding(inflate);
        setContentView((View) getBinding().getRoot());
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this);
        Intrinsics.checkNotNullExpressionValue(userObject_Prefrences, "getUserObject_Prefrences(this)");
        setUser(userObject_Prefrences);
        initToolBar();
        initView();
    }

    private final void initView() {
        getBinding().walletBalance.setText(getUser().getAccountBalance());
        Context context2 = this;
        this.appAlerts = new AppAlertDialog(context2);
        Intent intent = getIntent();
        this.context = context2;
        this.CardNumber = intent.getStringExtra("CardNumber");
        this.Balance = intent.getStringExtra("balance");
        this.rawDate = intent.getStringExtra("rawDate");
        getBinding().textView2.setText(this.CardNumber);
        getBinding().button2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ZuCardRecharge.m32initView$lambda0(ZuCardRecharge.this, view);
            }
        });
        getBinding().textView8.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ZuCardRecharge.m33initView$lambda1(ZuCardRecharge.this, view);
            }
        });
        getBinding().textView9.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ZuCardRecharge.m34initView$lambda2(ZuCardRecharge.this, view);
            }
        });
        getBinding().textView10.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ZuCardRecharge.m35initView$lambda3(ZuCardRecharge.this, view);
            }
        });
        getBinding().enteredBalance.addTextChangedListener(new ZuCardRecharge$initView$5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m32initView$lambda0(ZuCardRecharge zuCardRecharge, View view) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.validateBalance();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m33initView$lambda1(ZuCardRecharge zuCardRecharge, View view) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.getBinding().enteredBalance.setText("100");
        zuCardRecharge.getBinding().enteredBalance.setSelection(zuCardRecharge.getBinding().enteredBalance.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m34initView$lambda2(ZuCardRecharge zuCardRecharge, View view) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.getBinding().enteredBalance.setText("500");
        zuCardRecharge.getBinding().enteredBalance.setSelection(zuCardRecharge.getBinding().enteredBalance.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m35initView$lambda3(ZuCardRecharge zuCardRecharge, View view) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.getBinding().enteredBalance.setText("250");
        zuCardRecharge.getBinding().enteredBalance.setSelection(zuCardRecharge.getBinding().enteredBalance.length());
    }

    private final void validateBalance() {
        String obj = getBinding().enteredBalance.getText().toString();
        // if (obj.length() == 0) {
        //     this.appAlerts.showErrorDialog(this, "Please enter amount", new AppAlertDialog.AlertDialogListener() {
        //         public final void onClicked() {
        //             ZuCardRecharge.m39validateBalance$lambda4(ZuCardRecharge.this);
        //         }
        //     });
        // } else if (Integer.parseInt(obj) > Integer.parseInt(getUser().getAccountBalance())) {
        //     this.appAlerts.showErrorDialog(this, "Insufficient balance in your account", new AppAlertDialog.AlertDialogListener() {
        //         public final void onClicked() {
        //             ZuCardRecharge.m40validateBalance$lambda5(ZuCardRecharge.this);
        //         }
        //     });
        // } else if (Integer.parseInt(obj) == 0 || Integer.parseInt(obj) < 0) {
        //     this.appAlerts.showErrorDialog(this, "kindly enter amount", new AppAlertDialog.AlertDialogListener() {
        //         public final void onClicked() {
        //             ZuCardRecharge.m41validateBalance$lambda6(ZuCardRecharge.this);
        //         }
        //     });
        // } else {
        //     Integer.parseInt(getBinding().enteredBalance.getText().toString());
        //     String str = this.Balance;
        //     Intrinsics.checkNotNull(str);
        //     Integer.parseInt(str);
        //     loadScanner();
        // }
        Integer.parseInt(getBinding().enteredBalance.getText().toString());
        String str = this.Balance;
        Intrinsics.checkNotNull(str);
        Integer.parseInt(str);
        loadScanner();
    }

    /* access modifiers changed from: private */
    /* renamed from: validateBalance$lambda-4  reason: not valid java name */
    public static final void m39validateBalance$lambda4(ZuCardRecharge zuCardRecharge) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.appAlerts.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: validateBalance$lambda-5  reason: not valid java name */
    public static final void m40validateBalance$lambda5(ZuCardRecharge zuCardRecharge) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.appAlerts.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: validateBalance$lambda-6  reason: not valid java name */
    public static final void m41validateBalance$lambda6(ZuCardRecharge zuCardRecharge) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.appAlerts.dismiss();
    }

    private final void loadScanner() {
        Intent intent = new Intent(this, ZuCardScanner.class);
        intent.putExtra("recharge", true);
        intent.putExtra("amount", getBinding().enteredBalance.getText().toString());
        intent.putExtra("cardNumber", this.CardNumber);
        intent.putExtra("pBalance", this.Balance);
        intent.putExtra("rawDate", this.rawDate);
        startActivity(intent);
    }

    private final void initToolBar() {
        ActivityZuCardRechargeBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2);
        binding2.toolbarTitle.setText("Zu Card Recharge");
        ActivityZuCardRechargeBinding binding3 = getBinding();
        Intrinsics.checkNotNull(binding3);
        binding3.BtnBack.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ZuCardRecharge.m31initToolBar$lambda7(ZuCardRecharge.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: initToolBar$lambda-7  reason: not valid java name */
    public static final void m31initToolBar$lambda7(ZuCardRecharge zuCardRecharge, View view) {
        Intrinsics.checkNotNullParameter(zuCardRecharge, "this$0");
        zuCardRecharge.onBackPressed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r2 = r3.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(int r2, com.lmkt.zupeshawar.networkManager.ApiResponse r3) {
        /*
            r1 = this;
            com.lmkt.zupeshawar.Utilities.AppAlertDialog r2 = r1.appAlerts
            r2.dismiss()
            if (r3 == 0) goto L_0x0012
            com.lmkt.zupeshawar.networkManager.ApiResponseData r2 = r3.getData()
            if (r2 == 0) goto L_0x0012
            java.lang.String r2 = r2.getCardNumber()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r0 = "Response"
            android.util.Log.d(r0, r2)
            java.lang.String r2 = r3.getRespMessage()
            android.util.Log.d(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.views.activities.zuCardServices.ZuCardRecharge.onSuccess(int, com.lmkt.zupeshawar.networkManager.ApiResponse):void");
    }

    public void onFailure(int i, String str) {
        if (str != null) {
            Log.e("NFC WriteStatus", str);
        }
    }
}
