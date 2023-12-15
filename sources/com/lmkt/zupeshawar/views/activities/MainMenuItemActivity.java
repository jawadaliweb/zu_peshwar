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
import com.lmkt.zupeshawar.views.fragments.busFragments.BusArrivals;
import com.lmkt.zupeshawar.views.fragments.busFragments.BusServiceHours;
import com.lmkt.zupeshawar.views.fragments.busFragments.BusTravelHistory;
import com.lmkt.zupeshawar.views.fragments.busFragments.Map;
import com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner.TripPlanner;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class MainMenuItemActivity extends BaseActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public TextView date;
    FrameLayout frame;
    public ImageView mToolbar_BackBtn;
    public TextView mToolbar_Title;
    public Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mainmenuitem);
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
            case -1609261321:
                if (stringExtra.equals("Zu Map")) {
                    c = 0;
                    break;
                }
                break;
            case -1592599558:
                if (stringExtra.equals("TravelHistory")) {
                    c = 1;
                    break;
                }
                break;
            case 503008634:
                if (stringExtra.equals("ServiceHours")) {
                    c = 2;
                    break;
                }
                break;
            case 740075981:
                if (stringExtra.equals("TripPlanner")) {
                    c = 3;
                    break;
                }
                break;
            case 1518249498:
                if (stringExtra.equals("BusArrivals")) {
                    c = 4;
                    break;
                }
                break;
            case 2105908503:
                if (stringExtra.equals("BusSchedule")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                loadFragment(new Map());
                return;
            case 1:
                loadFragment(new BusTravelHistory());
                return;
            case 2:
                loadFragment(new BusServiceHours());
                return;
            case 3:
                loadFragment(new TripPlanner());
                return;
            case 4:
                BusArrivals busArrivals = new BusArrivals();
                busArrivals.setType(stringExtra);
                loadFragment(busArrivals);
                return;
            case 5:
                BusArrivals busArrivals2 = new BusArrivals();
                busArrivals2.setType(stringExtra);
                loadFragment(busArrivals2);
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
        this.date = (TextView) this.toolbar.findViewById(R.id.date);
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
            finish();
            overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
            findFragmentById.getFragmentManager().popBackStack();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
