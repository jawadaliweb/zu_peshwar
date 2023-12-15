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

public final class ActivityNavigationdraweritemsBinding implements ViewBinding {
    public final FrameLayout frame;
    public final ImageView notificationIV;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityNavigationdraweritemsBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, Toolbar toolbar2, TextView textView) {
        this.rootView = linearLayout;
        this.frame = frameLayout;
        this.notificationIV = imageView;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNavigationdraweritemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityNavigationdraweritemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_navigationdraweritems, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityNavigationdraweritemsBinding bind(View view) {
        int i = R.id.frame;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
        if (frameLayout != null) {
            i = R.id.notification_IV;
            ImageView imageView = (ImageView) view.findViewById(R.id.notification_IV);
            if (imageView != null) {
                i = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                if (toolbar2 != null) {
                    i = R.id.toolbar_title;
                    TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
                    if (textView != null) {
                        return new ActivityNavigationdraweritemsBinding((LinearLayout) view, frameLayout, imageView, toolbar2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
