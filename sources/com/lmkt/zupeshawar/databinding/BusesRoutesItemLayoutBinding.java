package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class BusesRoutesItemLayoutBinding implements ViewBinding {
    public final ImageView busImage;
    public final ConstraintLayout contentLayout;
    public final TextView destinationStationValueTv;
    public final TextView originCentersTv;
    public final TextView originStationValueTv;
    private final ConstraintLayout rootView;
    public final RecyclerView showAllRoutesDetailsRecycler;
    public final ImageView stopsImg;

    private BusesRoutesItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.busImage = imageView;
        this.contentLayout = constraintLayout2;
        this.destinationStationValueTv = textView;
        this.originCentersTv = textView2;
        this.originStationValueTv = textView3;
        this.showAllRoutesDetailsRecycler = recyclerView;
        this.stopsImg = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusesRoutesItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusesRoutesItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.buses_routes_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusesRoutesItemLayoutBinding bind(View view) {
        int i = R.id.busImage;
        ImageView imageView = (ImageView) view.findViewById(R.id.busImage);
        if (imageView != null) {
            i = R.id.contentLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.contentLayout);
            if (constraintLayout != null) {
                i = R.id.destinationStationValueTv;
                TextView textView = (TextView) view.findViewById(R.id.destinationStationValueTv);
                if (textView != null) {
                    i = R.id.originCentersTv;
                    TextView textView2 = (TextView) view.findViewById(R.id.originCentersTv);
                    if (textView2 != null) {
                        i = R.id.originStationValueTv;
                        TextView textView3 = (TextView) view.findViewById(R.id.originStationValueTv);
                        if (textView3 != null) {
                            i = R.id.showAllRoutesDetailsRecycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.showAllRoutesDetailsRecycler);
                            if (recyclerView != null) {
                                i = R.id.stopsImg;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.stopsImg);
                                if (imageView2 != null) {
                                    return new BusesRoutesItemLayoutBinding((ConstraintLayout) view, imageView, constraintLayout, textView, textView2, textView3, recyclerView, imageView2);
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
