package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.activities.ZuWalletActivity;

public class RentPackage extends Fragment implements View.OnClickListener, IOnBackPressed {
    static int Title = 2131886366;
    Button Btn_zuWallet;
    BicycleMenuItem activity;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_bicycle_rentpackages, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        Button button = (Button) view.findViewById(R.id.Btn_zuWallet);
        this.Btn_zuWallet = button;
        button.setOnClickListener(this);
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.Btn_zuWallet) {
            startActivity(new Intent(this.activity, ZuWalletActivity.class));
            this.activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
        }
    }
}
