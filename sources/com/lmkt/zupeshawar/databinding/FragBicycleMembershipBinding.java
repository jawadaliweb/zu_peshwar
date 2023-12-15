package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragBicycleMembershipBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final RelativeLayout alreadySubscription;
    public final MaterialButton cancelAction;
    public final RelativeLayout cancelPackage;
    public final LinearLayout cycleImg;
    public final TextView durationTV;
    public final RelativeLayout footer;
    public final LinearLayout memberShipValidity;
    public final TextView memberShipValidityTv;
    public final TextView membershipTv;
    public final TextView priceTv;
    private final RelativeLayout rootView;
    public final RecyclerView subscriptions;

    private FragBicycleMembershipBinding(RelativeLayout relativeLayout, MaterialButton materialButton, RelativeLayout relativeLayout2, MaterialButton materialButton2, RelativeLayout relativeLayout3, LinearLayout linearLayout, TextView textView, RelativeLayout relativeLayout4, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.alreadySubscription = relativeLayout2;
        this.cancelAction = materialButton2;
        this.cancelPackage = relativeLayout3;
        this.cycleImg = linearLayout;
        this.durationTV = textView;
        this.footer = relativeLayout4;
        this.memberShipValidity = linearLayout2;
        this.memberShipValidityTv = textView2;
        this.membershipTv = textView3;
        this.priceTv = textView4;
        this.subscriptions = recyclerView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleMembershipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleMembershipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_membership, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleMembershipBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_zuWallet;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.Btn_zuWallet);
        if (materialButton != null) {
            i = R.id.alreadySubscription;
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.alreadySubscription);
            if (relativeLayout != null) {
                i = R.id.cancel_action;
                MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.cancel_action);
                if (materialButton2 != null) {
                    i = R.id.cancelPackage;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.cancelPackage);
                    if (relativeLayout2 != null) {
                        i = R.id.cycleImg;
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.cycleImg);
                        if (linearLayout != null) {
                            i = R.id.duration_TV;
                            TextView textView = (TextView) view2.findViewById(R.id.duration_TV);
                            if (textView != null) {
                                i = R.id.footer;
                                RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.footer);
                                if (relativeLayout3 != null) {
                                    i = R.id.memberShipValidity;
                                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.memberShipValidity);
                                    if (linearLayout2 != null) {
                                        i = R.id.memberShipValidityTv;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.memberShipValidityTv);
                                        if (textView2 != null) {
                                            i = R.id.membershipTv;
                                            TextView textView3 = (TextView) view2.findViewById(R.id.membershipTv);
                                            if (textView3 != null) {
                                                i = R.id.priceTv;
                                                TextView textView4 = (TextView) view2.findViewById(R.id.priceTv);
                                                if (textView4 != null) {
                                                    i = R.id.subscriptions;
                                                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.subscriptions);
                                                    if (recyclerView != null) {
                                                        return new FragBicycleMembershipBinding((RelativeLayout) view2, materialButton, relativeLayout, materialButton2, relativeLayout2, linearLayout, textView, relativeLayout3, linearLayout2, textView2, textView3, textView4, recyclerView);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
