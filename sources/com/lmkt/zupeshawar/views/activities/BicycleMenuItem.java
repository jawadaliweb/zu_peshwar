package com.lmkt.zupeshawar.views.activities;

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
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.LeaderBoard;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.Membership;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.MembershipAndSecurityDeposit;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.NearBy;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.RideHistory;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.SecurityDeposit;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.TermsAndCondition;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.Tutorial_A;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class BicycleMenuItem extends BaseActivity {
    FrameLayout frame;
    public ImageView mToolbar_BackBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bicyclemenuitem);
        try {
            initViews();
            init_Toolbar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFragmentWithBackStack(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame, fragment);
        beginTransaction.addToBackStack("MembershipAndSecurityDeposit");
        beginTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        beginTransaction.commit();
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
            case -1965615457:
                if (stringExtra.equals("Nearby")) {
                    c = 0;
                    break;
                }
                break;
            case -269436824:
                if (stringExtra.equals("MembershipSecurityDeposit")) {
                    c = 1;
                    break;
                }
                break;
            case -67756227:
                if (stringExtra.equals("LeaderBoard")) {
                    c = 2;
                    break;
                }
                break;
            case 214480557:
                if (stringExtra.equals("RentPackage")) {
                    c = 3;
                    break;
                }
                break;
            case 257920894:
                if (stringExtra.equals("Tutorial")) {
                    c = 4;
                    break;
                }
                break;
            case 653222902:
                if (stringExtra.equals("Membership")) {
                    c = 5;
                    break;
                }
                break;
            case 1684747356:
                if (stringExtra.equals("RideHistory")) {
                    c = 6;
                    break;
                }
                break;
            case 1933184993:
                if (stringExtra.equals("PlanRide")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                loadFragment(new NearBy());
                return;
            case 1:
                loadFragment(new MembershipAndSecurityDeposit());
                return;
            case 2:
                loadFragment(new LeaderBoard());
                return;
            case 3:
                loadFragment(new SecurityDeposit());
                return;
            case 4:
                loadFragment(new Tutorial_A());
                return;
            case 5:
                loadFragment(new Membership());
                return;
            case 6:
                loadFragment(new RideHistory());
                return;
            case 7:
                loadFragment(new TermsAndCondition());
                return;
            default:
                return;
        }
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
            findFragmentById.getFragmentManager().popBackStack();
            finish();
            overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }
}
