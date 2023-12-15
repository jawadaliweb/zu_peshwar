package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragMainmenuBinding implements ViewBinding {
    public final CardView BtnBusArrival;
    public final CardView BtnComplaints;
    public final CardView BtnMap;
    public final CardView BtnServiceHours;
    public final CardView BtnTravelHistory;
    public final CardView BtnTripPlanner;
    private final LinearLayout rootView;

    private FragMainmenuBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6) {
        this.rootView = linearLayout;
        this.BtnBusArrival = cardView;
        this.BtnComplaints = cardView2;
        this.BtnMap = cardView3;
        this.BtnServiceHours = cardView4;
        this.BtnTravelHistory = cardView5;
        this.BtnTripPlanner = cardView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuBinding bind(View view) {
        int i = R.id.Btn_BusArrival;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_BusArrival);
        if (cardView != null) {
            i = R.id.Btn_Complaints;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_Complaints);
            if (cardView2 != null) {
                i = R.id.Btn_Map;
                CardView cardView3 = (CardView) view.findViewById(R.id.Btn_Map);
                if (cardView3 != null) {
                    i = R.id.Btn_ServiceHours;
                    CardView cardView4 = (CardView) view.findViewById(R.id.Btn_ServiceHours);
                    if (cardView4 != null) {
                        i = R.id.Btn_TravelHistory;
                        CardView cardView5 = (CardView) view.findViewById(R.id.Btn_TravelHistory);
                        if (cardView5 != null) {
                            i = R.id.Btn_TripPlanner;
                            CardView cardView6 = (CardView) view.findViewById(R.id.Btn_TripPlanner);
                            if (cardView6 != null) {
                                return new FragMainmenuBinding((LinearLayout) view, cardView, cardView2, cardView3, cardView4, cardView5, cardView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
