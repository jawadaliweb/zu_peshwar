package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragTicketsBinding implements ViewBinding {
    public final CardView BtnFare;
    public final CardView BtnRecharge;
    public final CardView BtnRechargeHistory;
    public final CardView BtnTravelCondition;
    public final CardView BtnTripPlanner;
    public final CardView BtnWhatsNew;
    public final CardView BtnZuWallet;
    private final LinearLayout rootView;

    private FragTicketsBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6, CardView cardView7) {
        this.rootView = linearLayout;
        this.BtnFare = cardView;
        this.BtnRecharge = cardView2;
        this.BtnRechargeHistory = cardView3;
        this.BtnTravelCondition = cardView4;
        this.BtnTripPlanner = cardView5;
        this.BtnWhatsNew = cardView6;
        this.BtnZuWallet = cardView7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsBinding bind(View view) {
        int i = R.id.Btn_Fare;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_Fare);
        if (cardView != null) {
            i = R.id.Btn_Recharge;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_Recharge);
            if (cardView2 != null) {
                i = R.id.Btn_RechargeHistory;
                CardView cardView3 = (CardView) view.findViewById(R.id.Btn_RechargeHistory);
                if (cardView3 != null) {
                    i = R.id.Btn_TravelCondition;
                    CardView cardView4 = (CardView) view.findViewById(R.id.Btn_TravelCondition);
                    if (cardView4 != null) {
                        i = R.id.Btn_TripPlanner;
                        CardView cardView5 = (CardView) view.findViewById(R.id.Btn_TripPlanner);
                        if (cardView5 != null) {
                            i = R.id.Btn_WhatsNew;
                            CardView cardView6 = (CardView) view.findViewById(R.id.Btn_WhatsNew);
                            if (cardView6 != null) {
                                i = R.id.Btn_ZuWallet;
                                CardView cardView7 = (CardView) view.findViewById(R.id.Btn_ZuWallet);
                                if (cardView7 != null) {
                                    return new FragTicketsBinding((LinearLayout) view, cardView, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
