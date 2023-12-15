package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ImageSliderLayoutItemBinding implements ViewBinding {
    public final ImageView imageViewBackground;
    public final ProgressBar progressSlider;
    private final RelativeLayout rootView;

    private ImageSliderLayoutItemBinding(RelativeLayout relativeLayout, ImageView imageView, ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.imageViewBackground = imageView;
        this.progressSlider = progressBar;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ImageSliderLayoutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ImageSliderLayoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.image_slider_layout_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ImageSliderLayoutItemBinding bind(View view) {
        int i = R.id.imageViewBackground;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewBackground);
        if (imageView != null) {
            i = R.id.progressSlider;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressSlider);
            if (progressBar != null) {
                return new ImageSliderLayoutItemBinding((RelativeLayout) view, imageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
