package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class BusstopsItemLayoutBinding implements ViewBinding {
    public final ImageView busImage;
    public final TextView originCentersTv;
    public final TextView originStationValueTv;
    private final ConstraintLayout rootView;
    public final ImageView stopsImg;

    private BusstopsItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.busImage = imageView;
        this.originCentersTv = textView;
        this.originStationValueTv = textView2;
        this.stopsImg = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusstopsItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusstopsItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.busstops_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusstopsItemLayoutBinding bind(View view) {
        int i = R.id.busImage;
        ImageView imageView = (ImageView) view.findViewById(R.id.busImage);
        if (imageView != null) {
            i = R.id.originCentersTv;
            TextView textView = (TextView) view.findViewById(R.id.originCentersTv);
            if (textView != null) {
                i = R.id.originStationValueTv;
                TextView textView2 = (TextView) view.findViewById(R.id.originStationValueTv);
                if (textView2 != null) {
                    i = R.id.stopsImg;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.stopsImg);
                    if (imageView2 != null) {
                        return new BusstopsItemLayoutBinding((ConstraintLayout) view, imageView, textView, textView2, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
