package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class MapInfoWindowBinding implements ViewBinding {
    public final TextView addressLocation;
    private final FrameLayout rootView;
    public final TextView stationName;
    public final TextView timeLeftText;
    public final LinearLayout top;

    private MapInfoWindowBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.addressLocation = textView;
        this.stationName = textView2;
        this.timeLeftText = textView3;
        this.top = linearLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MapInfoWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MapInfoWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.map_info_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MapInfoWindowBinding bind(View view) {
        int i = R.id.address_location;
        TextView textView = (TextView) view.findViewById(R.id.address_location);
        if (textView != null) {
            i = R.id.stationName;
            TextView textView2 = (TextView) view.findViewById(R.id.stationName);
            if (textView2 != null) {
                i = R.id.time_left_text;
                TextView textView3 = (TextView) view.findViewById(R.id.time_left_text);
                if (textView3 != null) {
                    i = R.id.top;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.top);
                    if (linearLayout != null) {
                        return new MapInfoWindowBinding((FrameLayout) view, textView, textView2, textView3, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
