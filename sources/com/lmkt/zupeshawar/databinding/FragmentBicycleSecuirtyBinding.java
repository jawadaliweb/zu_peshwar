package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragmentBicycleSecuirtyBinding implements ViewBinding {
    public final MaterialButton BtnProceed;
    public final CheckBox agreeTerms;
    public final RelativeLayout alreadySubscription;
    public final MaterialButton cancelAction;
    public final RelativeLayout cancelPackage;
    public final LinearLayout checkView;
    public final LinearLayout cycleImg;
    public final TextView despositDetail;
    public final TextView durationTV;
    public final RelativeLayout infoView;
    public final TextView membershipTv;
    public final RelativeLayout noSubscription;
    public final TextView priceTv;
    private final RelativeLayout rootView;
    public final TextView subscriptionDateTV;

    private FragmentBicycleSecuirtyBinding(RelativeLayout relativeLayout, MaterialButton materialButton, CheckBox checkBox, RelativeLayout relativeLayout2, MaterialButton materialButton2, RelativeLayout relativeLayout3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, RelativeLayout relativeLayout4, TextView textView3, RelativeLayout relativeLayout5, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.BtnProceed = materialButton;
        this.agreeTerms = checkBox;
        this.alreadySubscription = relativeLayout2;
        this.cancelAction = materialButton2;
        this.cancelPackage = relativeLayout3;
        this.checkView = linearLayout;
        this.cycleImg = linearLayout2;
        this.despositDetail = textView;
        this.durationTV = textView2;
        this.infoView = relativeLayout4;
        this.membershipTv = textView3;
        this.noSubscription = relativeLayout5;
        this.priceTv = textView4;
        this.subscriptionDateTV = textView5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBicycleSecuirtyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentBicycleSecuirtyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bicycle_secuirty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentBicycleSecuirtyBinding bind(View view) {
        View view2 = view;
        int i = R.id.Btn_Proceed;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.Btn_Proceed);
        if (materialButton != null) {
            i = R.id.agreeTerms;
            CheckBox checkBox = (CheckBox) view2.findViewById(R.id.agreeTerms);
            if (checkBox != null) {
                i = R.id.alreadySubscription;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.alreadySubscription);
                if (relativeLayout != null) {
                    i = R.id.cancel_action;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.cancel_action);
                    if (materialButton2 != null) {
                        i = R.id.cancelPackage;
                        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.cancelPackage);
                        if (relativeLayout2 != null) {
                            i = R.id.checkView;
                            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.checkView);
                            if (linearLayout != null) {
                                i = R.id.cycleImg;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.cycleImg);
                                if (linearLayout2 != null) {
                                    i = R.id.desposit_detail;
                                    TextView textView = (TextView) view2.findViewById(R.id.desposit_detail);
                                    if (textView != null) {
                                        i = R.id.duration_TV;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.duration_TV);
                                        if (textView2 != null) {
                                            i = R.id.infoView;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.infoView);
                                            if (relativeLayout3 != null) {
                                                i = R.id.membershipTv;
                                                TextView textView3 = (TextView) view2.findViewById(R.id.membershipTv);
                                                if (textView3 != null) {
                                                    i = R.id.noSubscription;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.noSubscription);
                                                    if (relativeLayout4 != null) {
                                                        i = R.id.priceTv;
                                                        TextView textView4 = (TextView) view2.findViewById(R.id.priceTv);
                                                        if (textView4 != null) {
                                                            i = R.id.subscriptionDateTV;
                                                            TextView textView5 = (TextView) view2.findViewById(R.id.subscriptionDateTV);
                                                            if (textView5 != null) {
                                                                return new FragmentBicycleSecuirtyBinding((RelativeLayout) view2, materialButton, checkBox, relativeLayout, materialButton2, relativeLayout2, linearLayout, linearLayout2, textView, textView2, relativeLayout3, textView3, relativeLayout4, textView4, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
