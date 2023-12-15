package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivitySplashBinding implements ViewBinding {
    public final ImageView logoIV;
    private final RelativeLayout rootView;

    private ActivitySplashBinding(RelativeLayout relativeLayout, ImageView imageView) {
        this.rootView = relativeLayout;
        this.logoIV = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySplashBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.logoIV);
        if (imageView != null) {
            return new ActivitySplashBinding((RelativeLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.logoIV)));
    }
}
