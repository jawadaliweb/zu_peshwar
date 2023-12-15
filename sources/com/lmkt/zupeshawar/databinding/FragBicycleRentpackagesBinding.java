package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragBicycleRentpackagesBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final TextView DOBTV;
    public final TextView EmailTV;
    public final TextView MemberSinceTV;
    public final TextView NameTV;
    public final TextView TotalBalanceTV;
    public final TextView ZuBicycleTV;
    public final RelativeLayout bottom;
    private final RelativeLayout rootView;

    private FragBicycleRentpackagesBinding(RelativeLayout relativeLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.DOBTV = textView;
        this.EmailTV = textView2;
        this.MemberSinceTV = textView3;
        this.NameTV = textView4;
        this.TotalBalanceTV = textView5;
        this.ZuBicycleTV = textView6;
        this.bottom = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleRentpackagesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleRentpackagesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_rentpackages, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleRentpackagesBinding bind(View view) {
        int i = R.id.Btn_zuWallet;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_zuWallet);
        if (materialButton != null) {
            i = R.id.DOB_TV;
            TextView textView = (TextView) view.findViewById(R.id.DOB_TV);
            if (textView != null) {
                i = R.id.Email_TV;
                TextView textView2 = (TextView) view.findViewById(R.id.Email_TV);
                if (textView2 != null) {
                    i = R.id.MemberSince_TV;
                    TextView textView3 = (TextView) view.findViewById(R.id.MemberSince_TV);
                    if (textView3 != null) {
                        i = R.id.Name_TV;
                        TextView textView4 = (TextView) view.findViewById(R.id.Name_TV);
                        if (textView4 != null) {
                            i = R.id.TotalBalance_TV;
                            TextView textView5 = (TextView) view.findViewById(R.id.TotalBalance_TV);
                            if (textView5 != null) {
                                i = R.id.ZuBicycle_TV;
                                TextView textView6 = (TextView) view.findViewById(R.id.ZuBicycle_TV);
                                if (textView6 != null) {
                                    i = R.id.bottom;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bottom);
                                    if (relativeLayout != null) {
                                        return new FragBicycleRentpackagesBinding((RelativeLayout) view, materialButton, textView, textView2, textView3, textView4, textView5, textView6, relativeLayout);
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
