package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class ActivityBaseBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityBaseBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_base, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBaseBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityBaseBinding((ConstraintLayout) view);
    }
}
