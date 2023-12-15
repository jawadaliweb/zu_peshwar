package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;

public class MembershipAndSecurityDeposit extends Fragment implements View.OnClickListener, IOnBackPressed {
    static int Title = 2131886221;
    CardView Btn_Membership;
    CardView Btn_SecurityDeposit;
    private BicycleMenuItem activity;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_membership_and_security_deposit, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViews(View view) {
        initToolbar();
        this.Btn_Membership = (CardView) view.findViewById(R.id.Btn_membership);
        this.Btn_SecurityDeposit = (CardView) view.findViewById(R.id.Btn_security_deposit);
        this.Btn_Membership.setOnClickListener(this);
        this.Btn_SecurityDeposit.setOnClickListener(this);
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_Back:
                this.activity.finish();
                this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
                return;
            case R.id.Btn_membership:
                this.activity.loadFragmentWithBackStack(new Membership());
                return;
            case R.id.Btn_security_deposit:
                this.activity.loadFragmentWithBackStack(new SecurityDeposit());
                return;
            default:
                return;
        }
    }
}
