package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemCustomSuggestionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView title;

    private ItemCustomSuggestionBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.title = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemCustomSuggestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemCustomSuggestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_custom_suggestion, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemCustomSuggestionBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (textView != null) {
            return new ItemCustomSuggestionBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.title)));
    }
}
