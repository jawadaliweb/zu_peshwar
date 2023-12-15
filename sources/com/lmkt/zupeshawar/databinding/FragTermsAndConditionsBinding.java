package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.smarteist.autoimageslider.SliderView;

public final class FragTermsAndConditionsBinding implements ViewBinding {
    public final FrameLayout frame;
    public final SliderView imageSlider;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    private FragTermsAndConditionsBinding(LinearLayout linearLayout, FrameLayout frameLayout, SliderView sliderView, ProgressBar progressBar2) {
        this.rootView = linearLayout;
        this.frame = frameLayout;
        this.imageSlider = sliderView;
        this.progressBar = progressBar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragTermsAndConditionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTermsAndConditionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_terms_and_conditions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTermsAndConditionsBinding bind(View view) {
        int i = R.id.frame;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
        if (frameLayout != null) {
            i = R.id.imageSlider;
            SliderView sliderView = (SliderView) view.findViewById(R.id.imageSlider);
            if (sliderView != null) {
                i = R.id.progress_bar;
                ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                if (progressBar2 != null) {
                    return new FragTermsAndConditionsBinding((LinearLayout) view, frameLayout, sliderView, progressBar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
