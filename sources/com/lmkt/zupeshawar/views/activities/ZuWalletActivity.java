package com.lmkt.zupeshawar.views.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.QRCode;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

public class ZuWalletActivity extends BaseActivity implements APIManager.Callback {
    private static final String TAG = "Zu Wallet Activity";
    TextView Balance_TV;
    private ImageView QR_Code_IV;
    TextView Timmer_TV;
    private int brightness;
    private Context context;
    private CountDownTimer countDownTimer;
    private Integer counterValue = 30000;
    ProgressBar imageView_PB;
    boolean isRunning = false;
    public ImageView mToolbar_LeftBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;
    User user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_zu_wallet);
        try {
            this.context = this;
            initViews();
            getQRCode(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.brightness = getBrightness();
        setBrightness(100);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        setBrightnessToPrevious(this.brightness);
    }

    private void initViews() throws Exception {
        init_Toolbar();
        this.Balance_TV = (TextView) findViewById(R.id.Balance_TV);
        this.QR_Code_IV = (ImageView) findViewById(R.id.QR_Code_IV);
        this.Timmer_TV = (TextView) findViewById(R.id.Timmer_TV);
        this.imageView_PB = (ProgressBar) findViewById(R.id.imageView_PB);
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this);
        this.user = userObject_Prefrences;
        if (userObject_Prefrences != null) {
            try {
                String format = String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(userObject_Prefrences.getAccountBalance()))});
                TextView textView = this.Balance_TV;
                textView.setText("Rs." + format);
            } catch (Exception unused) {
                TextView textView2 = this.Balance_TV;
                textView2.setText("Rs." + this.user.getAccountBalance());
            }
        }
    }

    /* access modifiers changed from: private */
    public void getQRCode(boolean z) {
        this.appAlerts.showPleaseWait(this);
        APIManager.getInstance().getQRCode(this, z, this);
    }

    private void init_Toolbar() throws Exception {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setTitle((CharSequence) "");
        this.mToolbar_Title = (TextView) this.toolbar.findViewById(R.id.toolbar_title);
        this.mToolbar_LeftBtn = (ImageView) this.toolbar.findViewById(R.id.notification_IV);
        setSupportActionBar(this.toolbar);
        this.mToolbar_Title.setText(R.string.title_zuwallet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.countDownTimer = null;
            Log.v(TAG, "Counter Canceled");
        }
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private Bitmap base64ToBitmap(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    private byte[] bitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            try {
                this.imageView_PB.setVisibility(8);
                QRCode qrCode = apiResponse.getData().getQrCode();
                Bitmap base64ToBitmap = base64ToBitmap(qrCode.getQrImage());
                Log.v(Registry.BUCKET_BITMAP, qrCode.toString());
                if (base64ToBitmap == null) {
                    this.appAlerts.showErrorDialog(this, "Error Code: 100\nMessage: Error In QR Base64", new AppAlertDialog.AlertDialogListener() {
                        public final void onClicked() {
                            ZuWalletActivity.this.lambda$onSuccess$0$ZuWalletActivity();
                        }
                    });
                    return;
                }
                Glide.with(getApplicationContext()).load(bitmapToByte(base64ToBitmap)).transition(new DrawableTransitionOptions().crossFade()).into(this.QR_Code_IV);
                this.counterValue = Integer.valueOf(qrCode.getQrTimer().intValue() * 1000);
                CountDownTimer countDownTimer2 = this.countDownTimer;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                    this.countDownTimer = null;
                }
                AnonymousClass1 r0 = new CountDownTimer((long) this.counterValue.intValue(), 1000) {
                    public void onTick(long j) {
                        ZuWalletActivity.this.isRunning = true;
                        String format = String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
                        TextView textView = ZuWalletActivity.this.Timmer_TV;
                        textView.setText("Expires In " + format);
                        Log.v(ZuWalletActivity.TAG, "Timmer seconds remaining: " + (j / 1000));
                    }

                    public void onFinish() {
                        ZuWalletActivity.this.Timmer_TV.setText("done!");
                        ZuWalletActivity.this.isRunning = false;
                        ZuWalletActivity.this.imageView_PB.setVisibility(0);
                        if (!ZuWalletActivity.this.isDestroyed()) {
                            ZuWalletActivity.this.getQRCode(true);
                        } else {
                            Log.v(ZuWalletActivity.TAG, "API Not Called");
                        }
                    }
                };
                this.countDownTimer = r0;
                r0.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 500) {
            this.appAlerts.showAlertDialog(this, apiResponse.getRespMessage(), "Server Message", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuWalletActivity.this.lambda$onSuccess$1$ZuWalletActivity();
                }
            });
            this.imageView_PB.setVisibility(8);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.ic_warning)).into(this.QR_Code_IV);
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.appAlerts.showErrorAndLogout(this, apiResponse.getRespMessage());
        } else {
            this.appAlerts.showErrorDialog(this, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuWalletActivity.this.lambda$onSuccess$2$ZuWalletActivity();
                }
            });
            this.imageView_PB.setVisibility(8);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.ic_warning)).into(this.QR_Code_IV);
        }
    }

    public /* synthetic */ void lambda$onSuccess$0$ZuWalletActivity() {
        this.appAlerts.dismiss();
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.countDownTimer = null;
        }
        finish();
    }

    public /* synthetic */ void lambda$onSuccess$1$ZuWalletActivity() {
        this.appAlerts.dismiss();
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.countDownTimer = null;
        }
        finish();
    }

    public /* synthetic */ void lambda$onSuccess$2$ZuWalletActivity() {
        this.appAlerts.dismiss();
        onBackPressed();
    }

    public /* synthetic */ void lambda$onFailure$3$ZuWalletActivity() {
        this.appAlerts.dismiss();
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.countDownTimer = null;
        }
        finish();
    }

    public void onFailure(int i, String str) {
        Integer valueOf = Integer.valueOf(R.drawable.ic_warning);
        if (i == 500) {
            this.appAlerts.showAlertDialog(this, str, "Server Message", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuWalletActivity.this.lambda$onFailure$3$ZuWalletActivity();
                }
            });
            this.imageView_PB.setVisibility(8);
            Glide.with(getApplicationContext()).load(valueOf).transition(new DrawableTransitionOptions().crossFade()).into(this.QR_Code_IV);
        } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
            this.appAlerts.showErrorAndLogout(this, str);
        } else if (i != 500) {
            this.appAlerts.showErrorDialog(this, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    ZuWalletActivity.this.lambda$onFailure$4$ZuWalletActivity();
                }
            });
            this.imageView_PB.setVisibility(8);
            Glide.with(getApplicationContext()).load(valueOf).transition(new DrawableTransitionOptions().crossFade()).into(this.QR_Code_IV);
        }
    }

    public /* synthetic */ void lambda$onFailure$4$ZuWalletActivity() {
        this.appAlerts.dismiss();
        onBackPressed();
    }
}
