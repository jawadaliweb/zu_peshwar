package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.ortiz.touchview.TouchImageView;

public final class TermsAndConditionImageSliderLayoutItemBinding implements ViewBinding {
    public final TouchImageView imageViewBackground;
    public final ProgressBar progressSlider;
    private final RelativeLayout rootView;

    private TermsAndConditionImageSliderLayoutItemBinding(RelativeLayout relativeLayout, TouchImageView touchImageView, ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.imageViewBackground = touchImageView;
        this.progressSlider = progressBar;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TermsAndConditionImageSliderLayoutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TermsAndConditionImageSliderLayoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.terms_and_condition_image_slider_layout_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TermsAndConditionImageSliderLayoutItemBinding bind(View view) {
        int i = R.id.imageViewBackground;
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.imageViewBackground);
        if (touchImageView != null) {
            i = R.id.progressSlider;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressSlider);
            if (progressBar != null) {
                return new TermsAndConditionImageSliderLayoutItemBinding((RelativeLayout) view, touchImageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
