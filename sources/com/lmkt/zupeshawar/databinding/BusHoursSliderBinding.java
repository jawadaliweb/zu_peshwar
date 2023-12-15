package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.ortiz.touchview.TouchImageView;

public final class BusHoursSliderBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TouchImageView serverImage;

    private BusHoursSliderBinding(ConstraintLayout constraintLayout, TouchImageView touchImageView) {
        this.rootView = constraintLayout;
        this.serverImage = touchImageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusHoursSliderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusHoursSliderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bus_hours_slider, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusHoursSliderBinding bind(View view) {
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.serverImage);
        if (touchImageView != null) {
            return new BusHoursSliderBinding((ConstraintLayout) view, touchImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.serverImage)));
    }
}
