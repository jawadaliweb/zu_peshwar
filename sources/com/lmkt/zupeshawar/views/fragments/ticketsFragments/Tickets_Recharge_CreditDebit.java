package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;

public class Tickets_Recharge_CreditDebit extends Fragment implements View.OnClickListener, IOnBackPressed {
    TicketsMenuItemActivity activity;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_recharge_creditdebit, viewGroup, false);
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
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.title_CDtopup);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.loadFragment(new Recharge(), 0);
        }
    }

    public boolean onBackPressed() {
        this.activity.loadFragment(new Recharge(), 0);
        return true;
    }
}
