package com.lmkt.zupeshawar.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.zuCardServices.ZuCardScanner;
import com.lmkt.zupeshawar.views.fragments.ticketsFragments.CodeOfConduct;
import com.lmkt.zupeshawar.views.fragments.ticketsFragments.Recharge;
import com.lmkt.zupeshawar.views.fragments.ticketsFragments.TicketsRechargeHistory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class TicketsMenuItemActivity extends BaseActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public FrameLayout frame;
    public ImageView mToolbar_BackBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ticketsmenuitem);
        try {
            initViews();
            init_Toolbar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame, fragment);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        beginTransaction.commit();
    }

    public void loadFragment(Fragment fragment, int i) {
        if (i == 1) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            beginTransaction.replace(R.id.frame, fragment);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commit();
            return;
        }
        FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
        beginTransaction2.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction2.replace(R.id.frame, fragment);
        beginTransaction2.addToBackStack((String) null);
        beginTransaction2.commit();
    }

    public void initViews() {
        this.frame = (FrameLayout) findViewById(R.id.frame);
        String stringExtra = getIntent().getStringExtra(CommonProperties.TYPE);
        stringExtra.hashCode();
        char c = 65535;
        switch (stringExtra.hashCode()) {
            case -1294779443:
                if (stringExtra.equals("RechargeHistory")) {
                    c = 0;
                    break;
                }
                break;
            case -741547321:
                if (stringExtra.equals("Recharge")) {
                    c = 1;
                    break;
                }
                break;
            case 228336385:
                if (stringExtra.equals("TravelCondition")) {
                    c = 2;
                    break;
                }
                break;
            case 1999406353:
                if (stringExtra.equals("WhatsNew")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                loadFragment(new TicketsRechargeHistory());
                return;
            case 1:
                loadFragment(new Recharge());
                return;
            case 2:
                loadFragment(new CodeOfConduct());
                return;
            case 3:
                initiateCard();
                return;
            default:
                return;
        }
    }

    private void initiateCard() {
        startActivity(new Intent(this, ZuCardScanner.class));
        finish();
    }

    private void init_Toolbar() throws Exception {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        this.toolbar.setTitle((CharSequence) "");
        this.mToolbar_Title = (TextView) this.toolbar.findViewById(R.id.toolbar_title);
        this.mToolbar_BackBtn = (ImageView) this.toolbar.findViewById(R.id.Btn_Back);
        if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this)) {
            this.mToolbar_BackBtn.setImageResource(R.drawable.ic_go_back_urdu);
        }
        setSupportActionBar(this.toolbar);
    }

    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.frame);
        if (!(findFragmentById instanceof IOnBackPressed) || !((IOnBackPressed) findFragmentById).onBackPressed()) {
            try {
                findFragmentById.getFragmentManager().popBackStack();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finish();
            overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }
}
