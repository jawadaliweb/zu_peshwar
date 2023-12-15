package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;

public class Recharge extends Fragment implements View.OnClickListener, IOnBackPressed {
    static String Title = "Top Up";
    CardView Btn_CreditDebit;
    CardView Btn_EasyPaisa;
    CardView Btn_JazzCash;
    CardView Btn_UblOmniCash;
    TicketsMenuItemActivity activity;

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets_recharge, viewGroup, false);
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
        this.Btn_CreditDebit = (CardView) view.findViewById(R.id.Btn_CreditDebit);
        this.Btn_EasyPaisa = (CardView) view.findViewById(R.id.Btn_EasyPaisa);
        this.Btn_JazzCash = (CardView) view.findViewById(R.id.Btn_JazzCash);
        this.Btn_UblOmniCash = (CardView) view.findViewById(R.id.Btn_UblOmniCash);
        this.Btn_CreditDebit.setOnClickListener(this);
        this.Btn_EasyPaisa.setOnClickListener(this);
        this.Btn_JazzCash.setOnClickListener(this);
        this.Btn_UblOmniCash.setOnClickListener(this);
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.title_topup);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_Back:
                this.activity.finish();
                this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
                return;
            case R.id.Btn_CreditDebit:
                this.activity.appAlerts.showAlertDialog(this.activity, getResources().getString(R.string.coming_soon), getResources().getString(R.string.service_unavailable), new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        Recharge.this.lambda$onClick$0$Recharge();
                    }
                });
                return;
            case R.id.Btn_EasyPaisa:
                this.activity.loadFragment(new TicketsRechargeEasyPaisa(), 1);
                return;
            case R.id.Btn_JazzCash:
                this.activity.loadFragment(new Tickets_Recharge_JazzCash(), 1);
                return;
            case R.id.Btn_UblOmniCash:
                this.activity.loadFragment(new Tickets_Recharge_UblOmni(), 1);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$0$Recharge() {
        this.activity.appAlerts.dismiss();
    }
}
