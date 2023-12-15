package com.lmkt.zupeshawar.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class Bicycle extends Fragment implements View.OnClickListener {
    public static String TITLE = "Bicycle";
    public static String TITLE_UR = "بائیسکل";
    CardView Btn_Leaderboard;
    CardView Btn_Membership;
    CardView Btn_Nearby;
    CardView Btn_PlanRide;
    CardView Btn_RideHistory;
    CardView Btn_Tutorial;
    MainDashboard activity;
    private long mLastClickTime = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_bicycle, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
            this.activity = (MainDashboard) getActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        this.Btn_Leaderboard = (CardView) view.findViewById(R.id.Btn_Leaderboard);
        this.Btn_Nearby = (CardView) view.findViewById(R.id.Btn_Nearby);
        this.Btn_PlanRide = (CardView) view.findViewById(R.id.Btn_PlanRide);
        this.Btn_RideHistory = (CardView) view.findViewById(R.id.Btn_RideHistory);
        this.Btn_Membership = (CardView) view.findViewById(R.id.Btn_Membership);
        this.Btn_Tutorial = (CardView) view.findViewById(R.id.Btn_Tutorial);
        this.Btn_Leaderboard.setOnClickListener(this);
        this.Btn_Nearby.setOnClickListener(this);
        this.Btn_PlanRide.setOnClickListener(this);
        this.Btn_RideHistory.setOnClickListener(this);
        this.Btn_Membership.setOnClickListener(this);
        this.Btn_Tutorial.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
            this.mLastClickTime = SystemClock.elapsedRealtime();
            switch (view.getId()) {
                case R.id.Btn_Leaderboard:
                    Intent intent = new Intent(requireActivity(), BicycleMenuItem.class);
                    intent.putExtra(CommonProperties.TYPE, "LeaderBoard");
                    startActivity(intent);
                    requireActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                case R.id.Btn_Membership:
                    Intent intent2 = new Intent(getActivity(), BicycleMenuItem.class);
                    intent2.putExtra(CommonProperties.TYPE, "MembershipSecurityDeposit");
                    startActivity(intent2);
                    requireActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                case R.id.Btn_Nearby:
                    Intent intent3 = new Intent(getActivity(), BicycleMenuItem.class);
                    intent3.putExtra(CommonProperties.TYPE, "Nearby");
                    startActivity(intent3);
                    requireActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                case R.id.Btn_PlanRide:
                    Intent intent4 = new Intent(getActivity(), BicycleMenuItem.class);
                    intent4.putExtra(CommonProperties.TYPE, "PlanRide");
                    startActivity(intent4);
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                case R.id.Btn_RideHistory:
                    Intent intent5 = new Intent(getActivity(), BicycleMenuItem.class);
                    intent5.putExtra(CommonProperties.TYPE, "RideHistory");
                    startActivity(intent5);
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                case R.id.Btn_Tutorial:
                    Intent intent6 = new Intent(getActivity(), BicycleMenuItem.class);
                    intent6.putExtra(CommonProperties.TYPE, "Tutorial");
                    startActivity(intent6);
                    requireActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                    return;
                default:
                    return;
            }
        }
    }
}
