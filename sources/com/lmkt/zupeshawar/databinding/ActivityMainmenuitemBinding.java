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

public final class ActivityMainmenuitemBinding implements ViewBinding {
    public final ImageView BtnBack;
    public final TextView date;
    public final FrameLayout frame;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityMainmenuitemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, FrameLayout frameLayout, Toolbar toolbar2, TextView textView2) {
        this.rootView = linearLayout;
        this.BtnBack = imageView;
        this.date = textView;
        this.frame = frameLayout;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainmenuitemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainmenuitemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_mainmenuitem, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainmenuitemBinding bind(View view) {
        int i = R.id.Btn_Back;
        ImageView imageView = (ImageView) view.findViewById(R.id.Btn_Back);
        if (imageView != null) {
            i = R.id.date;
            TextView textView = (TextView) view.findViewById(R.id.date);
            if (textView != null) {
                i = R.id.frame;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
                if (frameLayout != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                    if (toolbar2 != null) {
                        i = R.id.toolbar_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.toolbar_title);
                        if (textView2 != null) {
                            return new ActivityMainmenuitemBinding((LinearLayout) view, imageView, textView, frameLayout, toolbar2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
