package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lmkt.zupeshawar.R;

public final class FragmentZuCardRechargeBinding implements ViewBinding {
    public final Button Test;
    public final LottieAnimationView lottieAnimationView;
    private final ConstraintLayout rootView;

    private FragmentZuCardRechargeBinding(ConstraintLayout constraintLayout, Button button, LottieAnimationView lottieAnimationView2) {
        this.rootView = constraintLayout;
        this.Test = button;
        this.lottieAnimationView = lottieAnimationView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentZuCardRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentZuCardRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_zu_card_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentZuCardRechargeBinding bind(View view) {
        int i = R.id.Test;
        Button button = (Button) view.findViewById(R.id.Test);
        if (button != null) {
            i = R.id.lottieAnimationView;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.lottieAnimationView);
            if (lottieAnimationView2 != null) {
                return new FragmentZuCardRechargeBinding((ConstraintLayout) view, button, lottieAnimationView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
