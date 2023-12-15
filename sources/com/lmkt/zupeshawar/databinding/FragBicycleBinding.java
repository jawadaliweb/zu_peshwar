package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragBicycleBinding implements ViewBinding {
    public final CardView BtnLeaderboard;
    public final CardView BtnMembership;
    public final CardView BtnNearby;
    public final CardView BtnPlanRide;
    public final CardView BtnRideHistory;
    public final CardView BtnTutorial;
    private final LinearLayout rootView;

    private FragBicycleBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6) {
        this.rootView = linearLayout;
        this.BtnLeaderboard = cardView;
        this.BtnMembership = cardView2;
        this.BtnNearby = cardView3;
        this.BtnPlanRide = cardView4;
        this.BtnRideHistory = cardView5;
        this.BtnTutorial = cardView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleBinding bind(View view) {
        int i = R.id.Btn_Leaderboard;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_Leaderboard);
        if (cardView != null) {
            i = R.id.Btn_Membership;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_Membership);
            if (cardView2 != null) {
                i = R.id.Btn_Nearby;
                CardView cardView3 = (CardView) view.findViewById(R.id.Btn_Nearby);
                if (cardView3 != null) {
                    i = R.id.Btn_PlanRide;
                    CardView cardView4 = (CardView) view.findViewById(R.id.Btn_PlanRide);
                    if (cardView4 != null) {
                        i = R.id.Btn_RideHistory;
                        CardView cardView5 = (CardView) view.findViewById(R.id.Btn_RideHistory);
                        if (cardView5 != null) {
                            i = R.id.Btn_Tutorial;
                            CardView cardView6 = (CardView) view.findViewById(R.id.Btn_Tutorial);
                            if (cardView6 != null) {
                                return new FragBicycleBinding((LinearLayout) view, cardView, cardView2, cardView3, cardView4, cardView5, cardView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
