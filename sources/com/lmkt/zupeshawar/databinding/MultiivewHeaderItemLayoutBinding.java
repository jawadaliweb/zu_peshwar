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

public final class MultiivewHeaderItemLayoutBinding implements ViewBinding {
    public final ImageView busImage;
    public final ConstraintLayout contentLayout;
    public final TextView destinationStationValueTv;
    public final TextView multiViewHeaderTv;
    public final TextView originCentersTv;
    public final TextView originStationValueTv;
    private final ConstraintLayout rootView;
    public final RecyclerView showAllRoutesDetailsRecycler;
    public final ImageView stopsImg;

    private MultiivewHeaderItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.busImage = imageView;
        this.contentLayout = constraintLayout2;
        this.destinationStationValueTv = textView;
        this.multiViewHeaderTv = textView2;
        this.originCentersTv = textView3;
        this.originStationValueTv = textView4;
        this.showAllRoutesDetailsRecycler = recyclerView;
        this.stopsImg = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MultiivewHeaderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MultiivewHeaderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.multiivew_header_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MultiivewHeaderItemLayoutBinding bind(View view) {
        int i = R.id.busImage;
        ImageView imageView = (ImageView) view.findViewById(R.id.busImage);
        if (imageView != null) {
            i = R.id.contentLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.contentLayout);
            if (constraintLayout != null) {
                i = R.id.destinationStationValueTv;
                TextView textView = (TextView) view.findViewById(R.id.destinationStationValueTv);
                if (textView != null) {
                    i = R.id.multiViewHeaderTv;
                    TextView textView2 = (TextView) view.findViewById(R.id.multiViewHeaderTv);
                    if (textView2 != null) {
                        i = R.id.originCentersTv;
                        TextView textView3 = (TextView) view.findViewById(R.id.originCentersTv);
                        if (textView3 != null) {
                            i = R.id.originStationValueTv;
                            TextView textView4 = (TextView) view.findViewById(R.id.originStationValueTv);
                            if (textView4 != null) {
                                i = R.id.showAllRoutesDetailsRecycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.showAllRoutesDetailsRecycler);
                                if (recyclerView != null) {
                                    i = R.id.stopsImg;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.stopsImg);
                                    if (imageView2 != null) {
                                        return new MultiivewHeaderItemLayoutBinding((ConstraintLayout) view, imageView, constraintLayout, textView, textView2, textView3, textView4, recyclerView, imageView2);
                                    }
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
