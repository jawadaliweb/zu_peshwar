package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class ItemBicycleStandBinding implements ViewBinding {
    public final RelativeLayout bicycle;
    public final RelativeLayout bicycleStands;
    public final MaterialButton direction;
    public final TextView distance;
    public final ImageView imgcycles;
    public final ImageView imgspace;
    public final RelativeLayout items;
    private final RelativeLayout rootView;
    public final TextView standsAvailable;
    public final TextView stationName;
    public final TextView time;
    public final TextView totalBicycle;

    private ItemBicycleStandBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, MaterialButton materialButton, TextView textView, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.bicycle = relativeLayout2;
        this.bicycleStands = relativeLayout3;
        this.direction = materialButton;
        this.distance = textView;
        this.imgcycles = imageView;
        this.imgspace = imageView2;
        this.items = relativeLayout4;
        this.standsAvailable = textView2;
        this.stationName = textView3;
        this.time = textView4;
        this.totalBicycle = textView5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemBicycleStandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemBicycleStandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_bicycle_stand, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemBicycleStandBinding bind(View view) {
        int i = R.id.bicycle;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bicycle);
        if (relativeLayout != null) {
            i = R.id.bicycle_stands;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.bicycle_stands);
            if (relativeLayout2 != null) {
                i = R.id.direction;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.direction);
                if (materialButton != null) {
                    i = R.id.distance;
                    TextView textView = (TextView) view.findViewById(R.id.distance);
                    if (textView != null) {
                        i = R.id.imgcycles;
                        ImageView imageView = (ImageView) view.findViewById(R.id.imgcycles);
                        if (imageView != null) {
                            i = R.id.imgspace;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.imgspace);
                            if (imageView2 != null) {
                                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                i = R.id.standsAvailable;
                                TextView textView2 = (TextView) view.findViewById(R.id.standsAvailable);
                                if (textView2 != null) {
                                    i = R.id.stationName;
                                    TextView textView3 = (TextView) view.findViewById(R.id.stationName);
                                    if (textView3 != null) {
                                        i = R.id.time;
                                        TextView textView4 = (TextView) view.findViewById(R.id.time);
                                        if (textView4 != null) {
                                            i = R.id.totalBicycle;
                                            TextView textView5 = (TextView) view.findViewById(R.id.totalBicycle);
                                            if (textView5 != null) {
                                                return new ItemBicycleStandBinding(relativeLayout3, relativeLayout, relativeLayout2, materialButton, textView, imageView, imageView2, relativeLayout3, textView2, textView3, textView4, textView5);
                                            }
                                        }
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
