package com.lmkt.zupeshawar.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class MainMenu extends Fragment implements View.OnClickListener {
    public static String TITLE = "Bus";
    public static final CharSequence TITLE_UR = "بس";
    CardView Btn_BusArrival;
    CardView Btn_Complaints;
    CardView Btn_Map;
    CardView Btn_ServiceHours;
    CardView Btn_TravelHistory;
    CardView Btn_TripPlanner;
    MainDashboard activity;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_mainmenu, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            this.activity = (MainDashboard) getActivity();
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        this.Btn_TripPlanner = (CardView) view.findViewById(R.id.Btn_TripPlanner);
        this.Btn_BusArrival = (CardView) view.findViewById(R.id.Btn_BusArrival);
        this.Btn_Map = (CardView) view.findViewById(R.id.Btn_Map);
        this.Btn_TravelHistory = (CardView) view.findViewById(R.id.Btn_TravelHistory);
        this.Btn_Complaints = (CardView) view.findViewById(R.id.Btn_Complaints);
        this.Btn_ServiceHours = (CardView) view.findViewById(R.id.Btn_ServiceHours);
        this.Btn_TripPlanner.setOnClickListener(this);
        this.Btn_BusArrival.setOnClickListener(this);
        this.Btn_TravelHistory.setOnClickListener(this);
        this.Btn_Map.setOnClickListener(this);
        this.Btn_Complaints.setOnClickListener(this);
        this.Btn_ServiceHours.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_BusArrival:
                Intent intent = new Intent(getActivity(), MainMenuItemActivity.class);
                intent.putExtra(CommonProperties.TYPE, "BusArrivals");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_Complaints:
                Intent intent2 = new Intent(getActivity(), NavigationDrawerItemsActivity.class);
                intent2.putExtra(CommonProperties.TYPE, "helpline");
                startActivity(intent2);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_Map:
                Intent intent3 = new Intent(getActivity(), MainMenuItemActivity.class);
                intent3.putExtra(CommonProperties.TYPE, "Zu Map");
                startActivity(intent3);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_ServiceHours:
                Intent intent4 = new Intent(getActivity(), MainMenuItemActivity.class);
                intent4.putExtra(CommonProperties.TYPE, "ServiceHours");
                startActivity(intent4);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_TravelHistory:
                Intent intent5 = new Intent(getActivity(), MainMenuItemActivity.class);
                intent5.putExtra(CommonProperties.TYPE, "TravelHistory");
                startActivity(intent5);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            case R.id.Btn_TripPlanner:
                Intent intent6 = new Intent(getActivity(), MainMenuItemActivity.class);
                intent6.putExtra(CommonProperties.TYPE, "BusSchedule");
                startActivity(intent6);
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.stay);
                return;
            default:
                return;
        }
    }
}
