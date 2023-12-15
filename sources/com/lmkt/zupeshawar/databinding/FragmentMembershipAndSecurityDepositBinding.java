package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragmentMembershipAndSecurityDepositBinding implements ViewBinding {
    public final CardView BtnMembership;
    public final CardView BtnSecurityDeposit;
    private final LinearLayout rootView;

    private FragmentMembershipAndSecurityDepositBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2) {
        this.rootView = linearLayout;
        this.BtnMembership = cardView;
        this.BtnSecurityDeposit = cardView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMembershipAndSecurityDepositBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMembershipAndSecurityDepositBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_membership_and_security_deposit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMembershipAndSecurityDepositBinding bind(View view) {
        int i = R.id.Btn_membership;
        CardView cardView = (CardView) view.findViewById(R.id.Btn_membership);
        if (cardView != null) {
            i = R.id.Btn_security_deposit;
            CardView cardView2 = (CardView) view.findViewById(R.id.Btn_security_deposit);
            if (cardView2 != null) {
                return new FragmentMembershipAndSecurityDepositBinding((LinearLayout) view, cardView, cardView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
