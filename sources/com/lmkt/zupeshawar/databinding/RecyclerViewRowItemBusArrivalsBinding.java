package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RecyclerViewRowItemBusArrivalsBinding implements ViewBinding {
    public final TextView arrivalTime1TV;
    private final LinearLayout rootView;

    private RecyclerViewRowItemBusArrivalsBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.arrivalTime1TV = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerViewRowItemBusArrivalsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RecyclerViewRowItemBusArrivalsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_view_row_item_bus_arrivals, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RecyclerViewRowItemBusArrivalsBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.arrivalTime1_TV);
        if (textView != null) {
            return new RecyclerViewRowItemBusArrivalsBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.arrivalTime1_TV)));
    }
}
