package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragTicketsRechargeUblomniBinding implements ViewBinding {
    public final MaterialButton BtnProceed;
    public final ImageView iv;
    public final TextView labelPoint;
    private final RelativeLayout rootView;

    private FragTicketsRechargeUblomniBinding(RelativeLayout relativeLayout, MaterialButton materialButton, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.BtnProceed = materialButton;
        this.iv = imageView;
        this.labelPoint = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragTicketsRechargeUblomniBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsRechargeUblomniBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_recharge_ublomni, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsRechargeUblomniBinding bind(View view) {
        int i = R.id.Btn_Proceed;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Proceed);
        if (materialButton != null) {
            i = R.id.iv;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            if (imageView != null) {
                i = R.id.label_point;
                TextView textView = (TextView) view.findViewById(R.id.label_point);
                if (textView != null) {
                    return new FragTicketsRechargeUblomniBinding((RelativeLayout) view, materialButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
