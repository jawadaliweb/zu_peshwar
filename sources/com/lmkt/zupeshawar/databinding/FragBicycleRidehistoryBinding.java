package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragBicycleRidehistoryBinding implements ViewBinding {
    public final RelativeLayout footer;
    public final MaterialButton proceedBtn;
    private final RelativeLayout rootView;

    private FragBicycleRidehistoryBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, MaterialButton materialButton) {
        this.rootView = relativeLayout;
        this.footer = relativeLayout2;
        this.proceedBtn = materialButton;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleRidehistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleRidehistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_ridehistory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleRidehistoryBinding bind(View view) {
        int i = R.id.footer;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.footer);
        if (relativeLayout != null) {
            i = R.id.proceed_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.proceed_btn);
            if (materialButton != null) {
                return new FragBicycleRidehistoryBinding((RelativeLayout) view, relativeLayout, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
