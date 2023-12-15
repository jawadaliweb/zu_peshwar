package com.lmkt.zupeshawar.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.ContextUtils;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import java.util.Locale;

public abstract class BaseActivity extends AppCompatActivity {
    public static String FCM_TOKEN = "";
    public static int bbsSecurity = 1000;
    public static int minimumBalance = 0;
    public static int otpService = 1;
    public AppAlertDialog appAlerts;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private final int requestPERMISSION = 102;

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Locale locale;
        if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", context)) {
            locale = new Locale("ur", "PK");
        } else {
            locale = new Locale("en", "US");
        }
        super.attachBaseContext(ContextUtils.Companion.updateLocale(context, locale));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.appAlerts = new AppAlertDialog(this);
            FirebaseApp.initializeApp(this);
            this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            this.mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(0).build());
            this.mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener((Activity) this, new OnCompleteListener() {
                public final void onComplete(Task task) {
                    BaseActivity.this.lambda$onCreate$0$BaseActivity(task);
                }
            });
            isPermissionAvailable("android.permission.READ_PHONE_STATE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onCreate$0$BaseActivity(Task task) {
        if (task.isSuccessful()) {
            otpService = (int) this.mFirebaseRemoteConfig.getLong("otpService");
            bbsSecurity = (int) this.mFirebaseRemoteConfig.getLong("bssSecurityFee");
            minimumBalance = (int) this.mFirebaseRemoteConfig.getLong("minimumBalance");
        }
    }

    public boolean isPermissionAvailable(String str) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), str) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{str}, 102);
        return false;
    }

    private void showMessageOKCancel(String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        new AlertDialog.Builder(this).setMessage((CharSequence) str).setPositiveButton((CharSequence) "OK", onClickListener).setNegativeButton((CharSequence) "Cancel", onClickListener2).create().show();
    }

    public void setBrightness(int i) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = 1.0f;
        getWindow().setAttributes(attributes);
    }

    public void setBrightnessToPrevious(int i) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = ((float) i) / 255.0f;
        getWindow().setAttributes(attributes);
    }

    public int getBrightness() {
        try {
            return Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
