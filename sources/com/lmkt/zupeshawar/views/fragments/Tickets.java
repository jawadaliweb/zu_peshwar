package com.lmkt.zupeshawar.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class Tickets extends Fragment implements View.OnClickListener {
    public static String TITLE = "Tickets";
    public static final CharSequence TITLE_UR = "ٹکٹ";
    CardView Btn_Fare;
    CardView Btn_Recharge;
    CardView Btn_RechargeHistory;
    CardView Btn_TravelCondition;
    CardView Btn_TripPlanner;
    CardView Btn_WhatsNew;
    CardView Btn_ZuWallet;
    TicketsMenuItemActivity activity;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_tickets, viewGroup, false);
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
        this.Btn_TripPlanner = (CardView) view.findViewById(R.id.Btn_TripPlanner);
        this.Btn_ZuWallet = (CardView) view.findViewById(R.id.Btn_ZuWallet);
        this.Btn_Recharge = (CardView) view.findViewById(R.id.Btn_Recharge);
        this.Btn_RechargeHistory = (CardView) view.findViewById(R.id.Btn_RechargeHistory);
        this.Btn_Fare = (CardView) view.findViewById(R.id.Btn_Fare);
        this.Btn_TravelCondition = (CardView) view.findViewById(R.id.Btn_TravelCondition);
        this.Btn_WhatsNew = (CardView) view.findViewById(R.id.Btn_WhatsNew);
        this.Btn_TripPlanner.setOnClickListener(this);
        this.Btn_Recharge.setOnClickListener(this);
        this.Btn_RechargeHistory.setOnClickListener(this);
        this.Btn_Fare.setOnClickListener(this);
        this.Btn_TravelCondition.setOnClickListener(this);
        this.Btn_WhatsNew.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_Fare:
                Intent intent = new Intent(getActivity(), NavigationDrawerItemsActivity.class);
                intent.putExtra(CommonProperties.TYPE, "fare");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_Recharge:
                Intent intent2 = new Intent(getActivity(), TicketsMenuItemActivity.class);
                intent2.putExtra(CommonProperties.TYPE, "Recharge");
                startActivity(intent2);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_RechargeHistory:
                Intent intent3 = new Intent(getActivity(), TicketsMenuItemActivity.class);
                intent3.putExtra(CommonProperties.TYPE, "RechargeHistory");
                startActivity(intent3);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_TravelCondition:
                Intent intent4 = new Intent(getActivity(), TicketsMenuItemActivity.class);
                intent4.putExtra(CommonProperties.TYPE, "TravelCondition");
                startActivity(intent4);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_TripPlanner:
                Intent intent5 = new Intent(getActivity(), MainMenuItemActivity.class);
                intent5.putExtra(CommonProperties.TYPE, "TripPlanner");
                startActivity(intent5);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_WhatsNew:
                Intent intent6 = new Intent(getActivity(), TicketsMenuItemActivity.class);
                intent6.putExtra(CommonProperties.TYPE, "WhatsNew");
                startActivity(intent6);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            default:
                return;
        }
    }
}
