package com.lmkt.zupeshawar.views.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.fragments.registration.FireBasePinCodeFragment;
import com.lmkt.zupeshawar.views.fragments.registration.LoginFragment;
import com.lmkt.zupeshawar.views.fragments.registration.RegistrationFragment;
import java.util.Objects;

public class RegistrationActivity extends BaseActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int REQUEST_READ_PHONE_STATE = 10;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_registration);
        loadFragment(new LoginFragment(), true);
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE");
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener($$Lambda$RegistrationActivity$PxW0jzPV5NBe4N8c79XQm2I12eM.INSTANCE).addOnSuccessListener($$Lambda$RegistrationActivity$hv_8e27gM78bUZc6WwRM3rATo1Y.INSTANCE);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setTitleTextColor(getResources().getColor(R.color.txt_color_Darkgrey));
        setSupportActionBar(this.toolbar);
        this.toolbar.setVisibility(8);
        if (checkSelfPermission != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 10);
        }
    }

    static /* synthetic */ void lambda$onCreate$0(Task task) {
        if (task.isSuccessful()) {
            FCM_TOKEN = (String) task.getResult();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void hideToolBar() {
        this.toolbar.setVisibility(8);
    }

    public void setToolBar(String str) {
        this.toolbar.setVisibility(0);
        this.toolbar.setTitle((CharSequence) str);
    }

    public void loadFragment(Fragment fragment, boolean z) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (z) {
            beginTransaction.add((int) R.id.frameLayout, fragment);
        } else {
            beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            beginTransaction.replace(R.id.frameLayout, fragment);
        }
        beginTransaction.commit();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 10 && iArr.length > 0) {
            int i2 = iArr[0];
        }
    }

    public void showDialog() {
        if (this.appAlerts != null) {
            this.appAlerts.dismiss();
            this.appAlerts.showPleaseWait(this);
        }
    }

    public void hideDialog() {
        if (this.appAlerts != null) {
            this.appAlerts.dismiss();
        }
    }

    public void showErrorDialog(String str) {
        if (this.appAlerts != null) {
            this.appAlerts.dismiss();
            this.appAlerts.showErrorDialog(this, str, new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    RegistrationActivity.this.lambda$showErrorDialog$2$RegistrationActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$showErrorDialog$2$RegistrationActivity() {
        this.appAlerts.dismiss();
    }

    public void showAlertDialog(String str) {
        if (this.appAlerts != null) {
            this.appAlerts.dismiss();
            this.appAlerts.showAlertDialog(this, str, "Server Message", new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    RegistrationActivity.this.lambda$showAlertDialog$3$RegistrationActivity();
                }
            });
        }
    }

    public /* synthetic */ void lambda$showAlertDialog$3$RegistrationActivity() {
        this.appAlerts.dismiss();
    }

    public void popFragments() {
        getSupportFragmentManager().findFragmentById(R.id.frameLayout).getFragmentManager().popBackStack();
    }

    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if ((findFragmentById instanceof IOnBackPressed) && ((IOnBackPressed) findFragmentById).onBackPressed()) {
            super.onBackPressed();
        } else if (findFragmentById instanceof LoginFragment) {
            popFragments();
            finishAffinity();
        } else if (findFragmentById instanceof FireBasePinCodeFragment) {
            popFragments();
            loadFragment(new LoginFragment(), true);
        } else if (findFragmentById instanceof RegistrationFragment) {
            popFragments();
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }
}
