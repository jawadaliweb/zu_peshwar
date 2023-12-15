package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class NavHeaderMainBinding implements ViewBinding {
    public final ImageView imageView;
    private final LinearLayout rootView;

    private NavHeaderMainBinding(LinearLayout linearLayout, ImageView imageView2) {
        this.rootView = linearLayout;
        this.imageView = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.nav_header_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NavHeaderMainBinding bind(View view) {
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView);
        if (imageView2 != null) {
            return new NavHeaderMainBinding((LinearLayout) view, imageView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.imageView)));
    }
}
