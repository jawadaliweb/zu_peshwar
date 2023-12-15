package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class ActivitySampleKotlinBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivitySampleKotlinBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySampleKotlinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySampleKotlinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_sample_kotlin, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySampleKotlinBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivitySampleKotlinBinding((ConstraintLayout) view);
    }
}
