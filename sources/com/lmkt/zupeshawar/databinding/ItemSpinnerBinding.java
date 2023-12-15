package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemSpinnerBinding implements ViewBinding {
    public final CardView cardView5;
    public final TextView main;
    private final LinearLayout rootView;

    private ItemSpinnerBinding(LinearLayout linearLayout, CardView cardView, TextView textView) {
        this.rootView = linearLayout;
        this.cardView5 = cardView;
        this.main = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSpinnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_spinner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSpinnerBinding bind(View view) {
        int i = R.id.card_view5;
        CardView cardView = (CardView) view.findViewById(R.id.card_view5);
        if (cardView != null) {
            i = R.id.main;
            TextView textView = (TextView) view.findViewById(R.id.main);
            if (textView != null) {
                return new ItemSpinnerBinding((LinearLayout) view, cardView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
