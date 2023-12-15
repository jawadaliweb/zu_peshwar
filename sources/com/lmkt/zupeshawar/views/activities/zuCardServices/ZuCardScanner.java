package com.lmkt.zupeshawar.views.activities.zuCardServices;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.databinding.ActivityZuCardScannerBinding;
import com.lmkt.zupeshawar.model.zuCardFeatureModel.NFCStatusRequest;
import com.lmkt.zupeshawar.model.zuCardFeatureModel.NFCWriteStatusRequest;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.activities.zuCardServices.ZuCardScanner;
import com.microsoft.appcenter.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010V\u001a\u00020WJ\u000e\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020WH\u0002J&\u0010\\\u001a\u00020W2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u0017J\u0006\u0010_\u001a\u00020WJ\u0006\u0010`\u001a\u00020WJ\u0006\u0010\u0012\u001a\u00020WJ\u0010\u0010#\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020W2\u0006\u0010a\u001a\u00020\u0017H\u0002J\u000e\u0010b\u001a\u00020\u00172\u0006\u0010c\u001a\u00020dJ\u0006\u0010e\u001a\u00020\u0017J\b\u0010f\u001a\u00020WH\u0002J\b\u0010g\u001a\u00020WH\u0002J\b\u0010h\u001a\u00020WH\u0002J\u0010\u0010i\u001a\u00020W2\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010j\u001a\u00020W2\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010k\u001a\u00020W2\u0006\u0010l\u001a\u00020mH\u0016J\u0012\u0010n\u001a\u00020W2\b\u0010o\u001a\u0004\u0018\u00010pH\u0014J\u0010\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0014J+\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u000b2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00170w2\u0006\u0010x\u001a\u00020yH\u0016¢\u0006\u0002\u0010zJ\b\u0010{\u001a\u00020WH\u0014J\b\u0010|\u001a\u00020WH\u0002J\u0010\u0010}\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0007J\u0006\u0010M\u001a\u00020\u0017J\u000e\u0010~\u001a\u00020W2\u0006\u0010\u001a\u00020\u0017J\u0010\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020\u0017J\t\u0010\u0001\u001a\u00020WH\u0002J\u000b\u0010\u0001\u001a\u00020d*\u00020\u0017J\u000b\u0010\u0001\u001a\u00020\u0017*\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u00107\u001a\u000208X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010\u001bR\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0019\"\u0004\bO\u0010\u001bR\u001a\u0010P\u001a\u00020QX.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006\u0001"}, d2 = {"Lcom/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardScanner;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "AppAlerts", "Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "getAppAlerts", "()Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;", "setAppAlerts", "(Lcom/lmkt/zupeshawar/Utilities/AppAlertDialog;)V", "NFCPermissionCode", "", "getNFCPermissionCode", "()I", "setNFCPermissionCode", "(I)V", "adapter", "Landroid/nfc/NfcAdapter;", "getAdapter", "()Landroid/nfc/NfcAdapter;", "setAdapter", "(Landroid/nfc/NfcAdapter;)V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "analytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "balance", "getBalance", "setBalance", "binding", "Lcom/lmkt/zupeshawar/databinding/ActivityZuCardScannerBinding;", "getBinding", "()Lcom/lmkt/zupeshawar/databinding/ActivityZuCardScannerBinding;", "setBinding", "(Lcom/lmkt/zupeshawar/databinding/ActivityZuCardScannerBinding;)V", "cardNumber", "getCardNumber", "setCardNumber", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "expDate", "getExpDate", "setExpDate", "isoDepcard", "Landroid/nfc/tech/IsoDep;", "getIsoDepcard", "()Landroid/nfc/tech/IsoDep;", "setIsoDepcard", "(Landroid/nfc/tech/IsoDep;)V", "mDB", "Lcom/google/firebase/database/DatabaseReference;", "getMDB", "()Lcom/google/firebase/database/DatabaseReference;", "setMDB", "(Lcom/google/firebase/database/DatabaseReference;)V", "rawDateP", "rawExpDate", "getRawExpDate", "setRawExpDate", "rechargeFlag", "", "getRechargeFlag", "()Z", "setRechargeFlag", "(Z)V", "rechargeTime", "getRechargeTime", "setRechargeTime", "tag", "Landroid/nfc/Tag;", "getTag", "()Landroid/nfc/Tag;", "setTag", "(Landroid/nfc/Tag;)V", "FireBaseDBInstance", "", "addTopUpToServer", "NFCWrit", "Lcom/lmkt/zupeshawar/model/zuCardFeatureModel/NFCWriteStatusRequest;", "askPermissions", "confirmTransaction", "TID", "TAC", "firebaseEvent", "forGroundPatch", "result", "getDataString", "res", "", "getID", "initToolBar", "initView", "loadDashboard", "loadDetail", "loadDetailTest", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "readBalance", "readISODep", "saveNFCStatus", "NFCStatus", "toast", "message", "writeBalance", "decodeHex", "encodeAmount", "NfcAdapterStateListner", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ZuCardScanner.kt */
public final class ZuCardScanner extends AppCompatActivity implements View.OnClickListener {
    public AppAlertDialog AppAlerts;
    private int NFCPermissionCode = 101;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private NfcAdapter adapter;
    private String amount = "0";
    public FirebaseAnalytics analytics;
    private String balance = "0";
    private ActivityZuCardScannerBinding binding;
    public String cardNumber;
    private Context context;
    public String expDate;
    public IsoDep isoDepcard;
    private DatabaseReference mDB;
    private String rawDateP = "";
    private String rawExpDate;
    private boolean rechargeFlag;
    private String rechargeTime;
    public Tag tag;

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

    public final ActivityZuCardScannerBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(ActivityZuCardScannerBinding activityZuCardScannerBinding) {
        this.binding = activityZuCardScannerBinding;
    }

    public final FirebaseAnalytics getAnalytics() {
        FirebaseAnalytics firebaseAnalytics = this.analytics;
        if (firebaseAnalytics != null) {
            return firebaseAnalytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final void setAnalytics(FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<set-?>");
        this.analytics = firebaseAnalytics;
    }

    public final DatabaseReference getMDB() {
        return this.mDB;
    }

    public final void setMDB(DatabaseReference databaseReference) {
        this.mDB = databaseReference;
    }

    public final NfcAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(NfcAdapter nfcAdapter) {
        this.adapter = nfcAdapter;
    }

    public final int getNFCPermissionCode() {
        return this.NFCPermissionCode;
    }

    public final void setNFCPermissionCode(int i) {
        this.NFCPermissionCode = i;
    }

    public final String getCardNumber() {
        String str = this.cardNumber;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardNumber");
        return null;
    }

    public final void setCardNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNumber = str;
    }

    public final String getExpDate() {
        String str = this.expDate;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("expDate");
        return null;
    }

    public final void setExpDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expDate = str;
    }

    public final IsoDep getIsoDepcard() {
        IsoDep isoDep = this.isoDepcard;
        if (isoDep != null) {
            return isoDep;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isoDepcard");
        return null;
    }

    public final void setIsoDepcard(IsoDep isoDep) {
        Intrinsics.checkNotNullParameter(isoDep, "<set-?>");
        this.isoDepcard = isoDep;
    }

    public final Tag getTag() {
        Tag tag2 = this.tag;
        if (tag2 != null) {
            return tag2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tag");
        return null;
    }

    public final void setTag(Tag tag2) {
        Intrinsics.checkNotNullParameter(tag2, "<set-?>");
        this.tag = tag2;
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

    public final boolean getRechargeFlag() {
        return this.rechargeFlag;
    }

    public final void setRechargeFlag(boolean z) {
        this.rechargeFlag = z;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amount = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.balance = str;
    }

    public final String getRechargeTime() {
        return this.rechargeTime;
    }

    public final void setRechargeTime(String str) {
        this.rechargeTime = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final String getRawExpDate() {
        return this.rawExpDate;
    }

    public final void setRawExpDate(String str) {
        this.rawExpDate = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityZuCardScannerBinding inflate = ActivityZuCardScannerBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView((View) inflate.getRoot());
        initToolBar();
        initView();
        registerReceiver(new NfcAdapterStateListner(this), new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
    }

    private final void initView() {
        Intent intent = getIntent();
        Context context2 = this;
        this.context = context2;
        this.rechargeFlag = intent.getBooleanExtra("recharge", false);
        this.amount = String.valueOf(intent.getStringExtra("amount"));
        setCardNumber(String.valueOf(intent.getStringExtra("cardNumber")));
        this.balance = String.valueOf(intent.getStringExtra("pBalance"));
        this.rawDateP = String.valueOf(intent.getStringExtra("rawDate"));
        setAnalytics(AnalyticsKt.getAnalytics(Firebase.INSTANCE));
        ActivityZuCardScannerBinding activityZuCardScannerBinding = this.binding;
        Intrinsics.checkNotNull(activityZuCardScannerBinding);
        activityZuCardScannerBinding.Test.setOnClickListener(this);
        setAppAlerts(new AppAlertDialog(context2));
        FireBaseDBInstance();
        getAdapter();
        askPermissions();
    }

    public final void FireBaseDBInstance() {
        this.mDB = FirebaseDatabase.getInstance().getReference();
    }

    private final void askPermissions() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.NFC") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.NFC"}, this.NFCPermissionCode);
        } else {
            Log.d("Permission", "Granted");
        }
    }

    /* renamed from: getAdapter  reason: collision with other method in class */
    public final void m46getAdapter() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        LottieAnimationView lottieAnimationView;
        Object systemService = getSystemService("nfc");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.nfc.NfcManager");
        NfcManager nfcManager = (NfcManager) systemService;
        ImageView imageView = null;
        if (nfcManager.getDefaultAdapter() != null) {
            this.adapter = nfcManager.getDefaultAdapter();
            ActivityZuCardScannerBinding activityZuCardScannerBinding = this.binding;
            LottieAnimationView lottieAnimationView2 = activityZuCardScannerBinding != null ? activityZuCardScannerBinding.lottieAnimationView : null;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(0);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding2 = this.binding;
            if (activityZuCardScannerBinding2 != null) {
                imageView = activityZuCardScannerBinding2.errorImage;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding3 = this.binding;
            if (!(activityZuCardScannerBinding3 == null || (lottieAnimationView = activityZuCardScannerBinding3.lottieAnimationView) == null)) {
                lottieAnimationView.setAnimation((int) R.raw.animation_vtow);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding4 = this.binding;
            if (!(activityZuCardScannerBinding4 == null || (textView3 = activityZuCardScannerBinding4.inst) == null)) {
                textView3.setText(R.string.scan_inst);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding5 = this.binding;
            if (!(activityZuCardScannerBinding5 == null || (textView2 = activityZuCardScannerBinding5.inst) == null)) {
                textView2.setTextColor(getResources().getColor(R.color.kprogresshud_default_color));
            }
            if (!SharedPrefrencesUtil.getNFCCheck("NFC_CHECK", this)) {
                saveNFCStatus("True");
            }
        } else {
            this.adapter = null;
            ActivityZuCardScannerBinding activityZuCardScannerBinding6 = this.binding;
            LottieAnimationView lottieAnimationView3 = activityZuCardScannerBinding6 != null ? activityZuCardScannerBinding6.lottieAnimationView : null;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.setVisibility(8);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding7 = this.binding;
            if (activityZuCardScannerBinding7 != null) {
                imageView = activityZuCardScannerBinding7.errorImage;
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ActivityZuCardScannerBinding activityZuCardScannerBinding8 = this.binding;
            if (!(activityZuCardScannerBinding8 == null || (textView = activityZuCardScannerBinding8.inst) == null)) {
                textView.setText(R.string.scan_inst_b);
            }
            if (!SharedPrefrencesUtil.getNFCCheck("NFC_CHECK", this)) {
                saveNFCStatus("False");
            }
        }
        if (nfcManager.getDefaultAdapter() != null && !nfcManager.getDefaultAdapter().isEnabled()) {
            getAppAlerts().showAlertDialog(this, "NFC is disabled In your phone kindly turn it on ", "Info", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuCardScanner.m43getAdapter$lambda0(ZuCardScanner.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getAdapter$lambda-0  reason: not valid java name */
    public static final void m43getAdapter$lambda0(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
    }

    public final void saveNFCStatus(String str) {
        DatabaseReference child;
        DatabaseReference child2;
        Intrinsics.checkNotNullParameter(str, "NFCStatus");
        String str2 = Build.MODEL;
        String str3 = Build.MANUFACTURER;
        String str4 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str4, "RELEASE");
        Intrinsics.checkNotNullExpressionValue(str2, "deviceName");
        Intrinsics.checkNotNullExpressionValue(str3, "deviceMan");
        NFCStatusRequest nFCStatusRequest = new NFCStatusRequest(str, str2, str3, str4);
        DatabaseReference databaseReference = this.mDB;
        if (!(databaseReference == null || (child = databaseReference.child("NFCStatusCollection")) == null || (child2 = child.child(getID())) == null)) {
            child2.setValue(nFCStatusRequest);
        }
        SharedPrefrencesUtil.setNFCCheck("NFC_CHECK", true, this);
    }

    public final String getID() {
        int nextInt = new Random().nextInt(999999);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%06d", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final void initToolBar() {
        ActivityZuCardScannerBinding activityZuCardScannerBinding = this.binding;
        Intrinsics.checkNotNull(activityZuCardScannerBinding);
        activityZuCardScannerBinding.toolbarTitle.setText("Zu Card Details");
        ActivityZuCardScannerBinding activityZuCardScannerBinding2 = this.binding;
        Intrinsics.checkNotNull(activityZuCardScannerBinding2);
        activityZuCardScannerBinding2.BtnBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            onBackPressed();
        } else if (id == R.id.Test) {
            startActivity(new Intent(this, ZuCardDetail.class));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.NFCPermissionCode) {
            Log.d("Perm", "Granted");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        forGroundPatch();
    }

    public final void forGroundPatch() {
        try {
            Intent addFlags = new Intent(this, ZuCardScanner.class).addFlags(536870912);
            Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(this, ZuCardScann…FLAG_ACTIVITY_SINGLE_TOP)");
            PendingIntent activity = PendingIntent.getActivity(this, 0, addFlags, 33554432);
            NfcAdapter nfcAdapter = this.adapter;
            if (nfcAdapter != null) {
                Intrinsics.checkNotNull(nfcAdapter);
                nfcAdapter.enableForegroundDispatch(this, activity, (IntentFilter[]) null, (String[][]) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        readISODep(intent);
    }

    public final void readISODep(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual((Object) "android.nfc.action.TAG_DISCOVERED", (Object) intent.getAction()) || Intrinsics.areEqual((Object) "android.nfc.action.TECH_DISCOVERED", (Object) intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
            Intrinsics.checkNotNull(parcelableExtra);
            setTag((Tag) parcelableExtra);
            if (Intrinsics.areEqual((Object) getTag().getTechList()[0], (Object) "android.nfc.tech.IsoDep")) {
                IsoDep isoDep = IsoDep.get(getTag());
                Intrinsics.checkNotNullExpressionValue(isoDep, "get(tag)");
                setIsoDepcard(isoDep);
                getIsoDepcard().connect();
                if (getIsoDepcard().isConnected()) {
                    byte[] transceive = getIsoDepcard().transceive(decodeHex("00A40000023F01"));
                    Intrinsics.checkNotNullExpressionValue(transceive, "res");
                    String dataString = getDataString(transceive);
                    Log.d("Data", dataString);
                    if (!StringsKt.contains$default((CharSequence) dataString, (CharSequence) "9000", false, 2, (Object) null)) {
                        return;
                    }
                    if (!this.rechargeFlag) {
                        readBalance();
                    } else {
                        writeBalance();
                    }
                }
            } else {
                getAppAlerts().showAlertDialog(this, "Invalid Card.", "Warning", new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        ZuCardScanner.m45readISODep$lambda1(ZuCardScanner.this);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: readISODep$lambda-1  reason: not valid java name */
    public static final void m45readISODep$lambda1(ZuCardScanner zuCardScanner) {
        Intrinsics.checkNotNullParameter(zuCardScanner, "this$0");
        zuCardScanner.getAppAlerts().dismiss();
    }

    private final void writeBalance() {
        getAppAlerts().showPleaseWait(this);
        if (getIsoDepcard().isConnected()) {
            byte[] transceive = getIsoDepcard().transceive(decodeHex("0020000003123123"));
            Intrinsics.checkNotNullExpressionValue(transceive, "res");
            if (Intrinsics.areEqual((Object) getDataString(transceive), (Object) "9000")) {
                // byte[] transceive2 = getIsoDepcard().transceive(decodeHex("805000020B01" + encodeAmount(this.amount) + "21409000046410"));
                byte[] transceive2 = getIsoDepcard().transceive(decodeHex("805000020B01" + encodeAmount("1000") + "21409000046410"));
                Intrinsics.checkNotNullExpressionValue(transceive2, "res");
                String dataString = getDataString(transceive2);
                Log.d("write_resp", dataString);
                Intrinsics.checkNotNullExpressionValue(dataString.substring(0, 8), "this as java.lang.String…ing(startIndex, endIndex)");
                String substring = dataString.substring(8, 12);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                StringsKt.replaceFirst$default(substring, "^0+(?!$)", "", false, 4, (Object) null);
                Log.d("Number", substring);
                String substring2 = dataString.substring(16, 24);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring3 = dataString.substring(24, 32);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                this.rechargeTime = rechargeTime();
                String str = this.rechargeTime;
                Intrinsics.checkNotNull(str);
                String str2 = this.rawDateP;
                int parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
                String upperCase = substring3.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                String upperCase2 = substring2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                addTopUpToServer(new NFCWriteStatusRequest("88", "21400" + getCardNumber(), Integer.parseInt(this.balance), Integer.parseInt(this.amount), Integer.parseInt(this.balance) + Integer.parseInt(this.amount), str, str2, parseInt, upperCase2, upperCase));
            }
        }
    }

    public final void addTopUpToServer(NFCWriteStatusRequest nFCWriteStatusRequest) {
        Intrinsics.checkNotNullParameter(nFCWriteStatusRequest, "NFCWrit");
        APIManager.getInstance().NFCBalanceWriteRequest(new ZuCardScanner$addTopUpToServer$1(this), nFCWriteStatusRequest, this);
    }

    public final void confirmTransaction(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "TAC");
        Intrinsics.checkNotNullParameter(str3, "rechargeTime");
        APIManager.getInstance().NFCConfirmationReq(new ZuCardScanner$confirmTransaction$1(this), str, str2, i, str3, this.context);
    }

    /* access modifiers changed from: private */
    public final void loadDashboard() {
        startActivity(new Intent(this, MainDashboard.class));
        finish();
    }

    public final String rechargeTime() {
        String format = new SimpleDateFormat("yyyy/dd/MM hh:mm:ss").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "currentDate");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(format, "/", "", false, 4, (Object) null), MaskedEditText.SPACE, "", false, 4, (Object) null), Constants.COMMON_SCHEMA_PREFIX_SEPARATOR, "", false, 4, (Object) null);
    }

    public final String encodeAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String num = Integer.toString(Integer.parseInt(str), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        StringBuilder sb = new StringBuilder();
        String substring = "00000000".substring(num.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        sb.append(num);
        String sb2 = sb.toString();
        Log.d("write_resp", sb2);
        return sb2;
    }

    private final void readBalance() {
        if (getIsoDepcard().isConnected()) {
            byte[] transceive = getIsoDepcard().transceive(decodeHex("00B0950000"));
            Intrinsics.checkNotNullExpressionValue(transceive, "res");
            String dataString = getDataString(transceive);
            Log.d("File", dataString);
            getCardNumber(dataString);
            if (StringsKt.contains$default((CharSequence) dataString, (CharSequence) "9000", false, 2, (Object) null)) {
                byte[] transceive2 = getIsoDepcard().transceive(decodeHex("805c000204"));
                Intrinsics.checkNotNullExpressionValue(transceive2, "res");
                loadDetail(getBalance(getDataString(transceive2)));
            }
        }
    }

    public final byte[] decodeHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 0) {
            Iterable<String> chunked = StringsKt.chunked(str, 2);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
            for (String parseInt : chunked) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(parseInt, CharsKt.checkRadix(16))));
            }
            return CollectionsKt.toByteArray((List) arrayList);
        }
        throw new IllegalStateException("Must have an even length".toString());
    }

    private final void loadDetail(String str) {
        Intent intent = new Intent(this, ZuCardDetail.class);
        intent.putExtra("CardNumber", getCardNumber());
        intent.putExtra("expiryDate", getExpDate());
        intent.putExtra("rawDate", this.rawExpDate);
        intent.putExtra("Balance", str);
        startActivity(intent);
    }

    private final void loadDetailTest(String str) {
        Intent intent = new Intent(this, ZuCardDetail.class);
        intent.putExtra("CardNumber", "FG1234578D");
        intent.putExtra("expiryDate", "12-12-2026");
        intent.putExtra("Balance", str);
        startActivity(intent);
    }

    private final String getBalance(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String substring = str.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        return String.valueOf(Integer.decode(sb.toString()));
    }

    private final void getCardNumber(String str) {
        String substring = str.substring(29, 40);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        setCardNumber(substring);
        String substring2 = str.substring(48, 56);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        this.rawExpDate = substring2;
        String substring3 = substring2.substring(0, 4);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring4 = substring2.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring5 = substring2.substring(6);
        Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String).substring(startIndex)");
        setExpDate(substring3 + Soundex.SILENT_MARKER + substring4 + Soundex.SILENT_MARKER + substring5);
    }

    public final String getDataString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "res");
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb.append(format);
            Log.d("Test", format);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public final void toast(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Toast.makeText(this, str, 1).show();
    }

    public final void firebaseEvent() {
        Bundle bundle = new Bundle();
        bundle.putString("Device_modal", "Lenovo");
        bundle.putString("User", "Asad");
        getAnalytics().logEvent("Test", bundle);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardScanner$NfcAdapterStateListner;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Lcom/lmkt/zupeshawar/views/activities/zuCardServices/ZuCardScanner;Landroid/content/Context;)V", "adapter", "Landroid/nfc/NfcAdapter;", "getAdapter", "()Landroid/nfc/NfcAdapter;", "setAdapter", "(Landroid/nfc/NfcAdapter;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "logger", "", "value", "", "onReceive", "intent", "Landroid/content/Intent;", "turnOffStatusMessage", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ZuCardScanner.kt */
    public final class NfcAdapterStateListner extends BroadcastReceiver {
        private NfcAdapter adapter;
        private Context context;

        public NfcAdapterStateListner(Context context2) {
            this.context = context2;
        }

        public final NfcAdapter getAdapter() {
            return this.adapter;
        }

        public final void setAdapter(NfcAdapter nfcAdapter) {
            this.adapter = nfcAdapter;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context context2) {
            this.context = context2;
        }

        public void onReceive(Context context2, Intent intent) {
            Intrinsics.checkNotNull(intent);
            if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.nfc.action.ADAPTER_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 1);
                if (intExtra == 1) {
                    turnOffStatusMessage();
                } else if (intExtra == 2) {
                    logger("Turning On");
                } else if (intExtra == 3) {
                    ZuCardScanner.this.forGroundPatch();
                } else if (intExtra == 4) {
                    logger("Turning Off");
                }
            }
        }

        public final void logger(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            Log.d(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, str);
        }

        public final void turnOffStatusMessage() {
            AppAlertDialog appAlertDialog;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new AppAlertDialog(this.context);
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("AppAlerts");
                appAlertDialog = null;
            } else {
                appAlertDialog = (AppAlertDialog) objectRef.element;
            }
            appAlertDialog.showAlertDialog(this.context, "NFC is disabled In your phone kindly turn it on ", "Info", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuCardScanner.NfcAdapterStateListner.m48turnOffStatusMessage$lambda0(Ref.ObjectRef.this);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: turnOffStatusMessage$lambda-0  reason: not valid java name */
        public static final void m48turnOffStatusMessage$lambda0(Ref.ObjectRef objectRef) {
            AppAlertDialog appAlertDialog;
            Intrinsics.checkNotNullParameter(objectRef, "$AppAlerts");
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("AppAlerts");
                appAlertDialog = null;
            } else {
                appAlertDialog = (AppAlertDialog) objectRef.element;
            }
            appAlertDialog.dismiss();
        }
    }
}
