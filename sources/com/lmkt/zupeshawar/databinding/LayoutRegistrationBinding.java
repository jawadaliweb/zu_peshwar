package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class LayoutRegistrationBinding implements ViewBinding {
    public final FrameLayout frameLayout;
    private final LinearLayout rootView;
    public final Toolbar toolbar;

    private LayoutRegistrationBinding(LinearLayout linearLayout, FrameLayout frameLayout2, Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.frameLayout = frameLayout2;
        this.toolbar = toolbar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutRegistrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutRegistrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_registration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutRegistrationBinding bind(View view) {
        int i = R.id.frameLayout;
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.frameLayout);
        if (frameLayout2 != null) {
            i = R.id.toolbar;
            Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
            if (toolbar2 != null) {
                return new LayoutRegistrationBinding((LinearLayout) view, frameLayout2, toolbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
