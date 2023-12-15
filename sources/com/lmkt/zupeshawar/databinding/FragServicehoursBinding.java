package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import me.relex.circleindicator.CircleIndicator;

public final class FragServicehoursBinding implements ViewBinding {
    public final ViewPager SliderContainer;
    public final RelativeLayout bottom;
    public final ImageView imageView4;
    public final CircleIndicator indicator;
    public final MaterialButton openDetailsBtn;
    private final RelativeLayout rootView;
    public final MaterialButton zuWalletBtn;

    private FragServicehoursBinding(RelativeLayout relativeLayout, ViewPager viewPager, RelativeLayout relativeLayout2, ImageView imageView, CircleIndicator circleIndicator, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = relativeLayout;
        this.SliderContainer = viewPager;
        this.bottom = relativeLayout2;
        this.imageView4 = imageView;
        this.indicator = circleIndicator;
        this.openDetailsBtn = materialButton;
        this.zuWalletBtn = materialButton2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragServicehoursBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragServicehoursBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_servicehours, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragServicehoursBinding bind(View view) {
        int i = R.id.SliderContainer;
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.SliderContainer);
        if (viewPager != null) {
            i = R.id.bottom;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bottom);
            if (relativeLayout != null) {
                i = R.id.imageView4;
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView4);
                if (imageView != null) {
                    i = R.id.indicator;
                    CircleIndicator circleIndicator = (CircleIndicator) view.findViewById(R.id.indicator);
                    if (circleIndicator != null) {
                        i = R.id.openDetails_btn;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.openDetails_btn);
                        if (materialButton != null) {
                            i = R.id.zu_wallet_Btn;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.zu_wallet_Btn);
                            if (materialButton2 != null) {
                                return new FragServicehoursBinding((RelativeLayout) view, viewPager, relativeLayout, imageView, circleIndicator, materialButton, materialButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
