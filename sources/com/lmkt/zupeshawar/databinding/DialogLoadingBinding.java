package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class DialogLoadingBinding implements ViewBinding {
    public final ImageView customLoadingImageView;
    private final FrameLayout rootView;

    private DialogLoadingBinding(FrameLayout frameLayout, ImageView imageView) {
        this.rootView = frameLayout;
        this.customLoadingImageView = imageView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogLoadingBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_loading_imageView);
        if (imageView != null) {
            return new DialogLoadingBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.custom_loading_imageView)));
    }
}
