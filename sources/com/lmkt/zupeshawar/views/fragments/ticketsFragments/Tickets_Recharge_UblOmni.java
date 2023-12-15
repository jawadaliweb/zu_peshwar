package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;

public class Tickets_Recharge_UblOmni extends Fragment implements View.OnClickListener, IOnBackPressed {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    TicketsMenuItemActivity activity;
    MaterialButton proceedOk;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_recharge_ublomni, viewGroup, false);
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
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
        this.proceedOk = materialButton;
        materialButton.setOnClickListener(this);
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.title_UBLtopup);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back || id == R.id.Btn_Proceed) {
            this.activity.loadFragment(new Recharge(), 0);
        }
    }

    public boolean onBackPressed() {
        this.activity.loadFragment(new Recharge(), 0);
        return true;
    }
}
