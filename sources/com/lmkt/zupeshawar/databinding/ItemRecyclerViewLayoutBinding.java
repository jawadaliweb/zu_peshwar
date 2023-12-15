package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemRecyclerViewLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvAlphabet;

    private ItemRecyclerViewLayoutBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvAlphabet = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemRecyclerViewLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemRecyclerViewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_recycler_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRecyclerViewLayoutBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_alphabet);
        if (textView != null) {
            return new ItemRecyclerViewLayoutBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_alphabet)));
    }
}
