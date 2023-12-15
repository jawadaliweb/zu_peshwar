package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class FragBicycleSubscriptionBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private FragBicycleSubscriptionBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleSubscriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleSubscriptionBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new FragBicycleSubscriptionBinding((RelativeLayout) view);
    }
}
