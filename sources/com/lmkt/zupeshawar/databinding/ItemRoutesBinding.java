package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemRoutesBinding implements ViewBinding {
    public final TextView estimatedTime;
    private final LinearLayout rootView;
    public final ImageView routeIV;
    public final TextView routeTV;
    public final TextView totalStops;

    private ItemRoutesBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.estimatedTime = textView;
        this.routeIV = imageView;
        this.routeTV = textView2;
        this.totalStops = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemRoutesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemRoutesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_routes, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRoutesBinding bind(View view) {
        int i = R.id.estimatedTime;
        TextView textView = (TextView) view.findViewById(R.id.estimatedTime);
        if (textView != null) {
            i = R.id.route_IV;
            ImageView imageView = (ImageView) view.findViewById(R.id.route_IV);
            if (imageView != null) {
                i = R.id.route_TV;
                TextView textView2 = (TextView) view.findViewById(R.id.route_TV);
                if (textView2 != null) {
                    i = R.id.totalStops;
                    TextView textView3 = (TextView) view.findViewById(R.id.totalStops);
                    if (textView3 != null) {
                        return new ItemRoutesBinding((LinearLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
