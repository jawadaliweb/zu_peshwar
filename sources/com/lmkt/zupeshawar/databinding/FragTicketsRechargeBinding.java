package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragTicketsRechargeBinding implements ViewBinding {
    public final CardView BtnCreditDebit;
    public final CardView BtnEasyPaisa;
    public final CardView BtnJazzCash;
    public final CardView BtnUblOmniCash;
    private final ScrollView rootView;

    private FragTicketsRechargeBinding(ScrollView scrollView, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4) {
        this.rootView = scrollView;
        this.BtnCreditDebit = cardView;
        this.BtnEasyPaisa = cardView2;
        this.BtnJazzCash = cardView3;
        this.BtnUblOmniCash = cardView4;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargeBinding bind(View view) {
        int i = R.id.Btn_CreditDebit;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_CreditDebit);
        if (cardView != null) {
            i = R.id.Btn_EasyPaisa;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_EasyPaisa);
            if (cardView2 != null) {
                i = R.id.Btn_JazzCash;
                CardView cardView3 = (CardView) view.findViewById(R.id.Btn_JazzCash);
                if (cardView3 != null) {
                    i = R.id.Btn_UblOmniCash;
                    CardView cardView4 = (CardView) view.findViewById(R.id.Btn_UblOmniCash);
                    if (cardView4 != null) {
                        return new FragTicketsRechargeBinding((ScrollView) view, cardView, cardView2, cardView3, cardView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
