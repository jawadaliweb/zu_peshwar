package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class FragBicyclePlanrideBinding implements ViewBinding {
    private final LinearLayout rootView;

    private FragBicyclePlanrideBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragBicyclePlanrideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicyclePlanrideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_planride, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicyclePlanrideBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new FragBicyclePlanrideBinding((LinearLayout) view);
    }
}
