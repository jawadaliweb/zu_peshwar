package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import java.util.Objects;

public final class RowItemCategoryBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView title;

    private RowItemCategoryBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.title = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static RowItemCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_category, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemCategoryBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new RowItemCategoryBinding(textView, textView);
    }
}
