package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityBicyclemenuitemBinding implements ViewBinding {
    public final ImageView BtnBack;
    public final FrameLayout frame;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityBicyclemenuitemBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, Toolbar toolbar2, TextView textView) {
        this.rootView = linearLayout;
        this.BtnBack = imageView;
        this.frame = frameLayout;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBicyclemenuitemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBicyclemenuitemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_bicyclemenuitem, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBicyclemenuitemBinding bind(View view) {
        int i = R.id.Btn_Back;
        ImageView imageView = (ImageView) view.findViewById(R.id.Btn_Back);
        if (imageView != null) {
            i = R.id.frame;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
            if (frameLayout != null) {
                i = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                if (toolbar2 != null) {
                    i = R.id.toolbar_title;
                    TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
                    if (textView != null) {
                        return new ActivityBicyclemenuitemBinding((LinearLayout) view, imageView, frameLayout, toolbar2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
