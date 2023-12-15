package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class FragNaviCustomerfeedbackBinding implements ViewBinding {
    private final ScrollView rootView;

    private FragNaviCustomerfeedbackBinding(ScrollView scrollView) {
        this.rootView = scrollView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragNaviCustomerfeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviCustomerfeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_customerfeedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviCustomerfeedbackBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new FragNaviCustomerfeedbackBinding((ScrollView) view);
    }
}
