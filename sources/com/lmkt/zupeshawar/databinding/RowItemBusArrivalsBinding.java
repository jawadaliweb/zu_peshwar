package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RowItemBusArrivalsBinding implements ViewBinding {
    public final RecyclerView arrivalTime1Rv;
    public final TextView arrivalTime1TV;
    private final LinearLayout rootView;
    public final TextView routeDestinationTV;
    public final ImageView routeIV;
    public final TextView routeSourceTV;
    public final TextView routeTV;
    public final CardView view2;

    private RowItemBusArrivalsBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, CardView cardView) {
        this.rootView = linearLayout;
        this.arrivalTime1Rv = recyclerView;
        this.arrivalTime1TV = textView;
        this.routeDestinationTV = textView2;
        this.routeIV = imageView;
        this.routeSourceTV = textView3;
        this.routeTV = textView4;
        this.view2 = cardView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowItemBusArrivalsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RowItemBusArrivalsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.row_item_bus_arrivals, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowItemBusArrivalsBinding bind(View view) {
        int i = R.id.arrivalTime1_rv;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.arrivalTime1_rv);
        if (recyclerView != null) {
            i = R.id.arrivalTime1_TV;
            TextView textView = (TextView) view.findViewById(R.id.arrivalTime1_TV);
            if (textView != null) {
                i = R.id.routeDestination_TV;
                TextView textView2 = (TextView) view.findViewById(R.id.routeDestination_TV);
                if (textView2 != null) {
                    i = R.id.route_IV;
                    ImageView imageView = (ImageView) view.findViewById(R.id.route_IV);
                    if (imageView != null) {
                        i = R.id.routeSource_TV;
                        TextView textView3 = (TextView) view.findViewById(R.id.routeSource_TV);
                        if (textView3 != null) {
                            i = R.id.route_TV;
                            TextView textView4 = (TextView) view.findViewById(R.id.route_TV);
                            if (textView4 != null) {
                                i = R.id.view2;
                                CardView cardView = (CardView) view.findViewById(R.id.view2);
                                if (cardView != null) {
                                    return new RowItemBusArrivalsBinding((LinearLayout) view, recyclerView, textView, textView2, imageView, textView3, textView4, cardView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
