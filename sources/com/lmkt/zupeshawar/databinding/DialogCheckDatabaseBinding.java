package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class DialogCheckDatabaseBinding implements ViewBinding {
    private final LinearLayout rootView;

    private DialogCheckDatabaseBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogCheckDatabaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogCheckDatabaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_check_database, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCheckDatabaseBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new DialogCheckDatabaseBinding((LinearLayout) view);
    }
}
