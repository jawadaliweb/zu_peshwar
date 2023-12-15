package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class RoutesHeaderItemLayoutBinding implements ViewBinding {
    public final ImageView arrowImg;
    public final TextView destinationStationTv;
    public final TextView destinationStationValueTv;
    public final TextView esmtFareValueTv;
    public final TextView esmtFaretv;
    public final TextView originCentersTv;
    public final TextView originStationValueTv;
    private final ConstraintLayout rootView;
    public final TextView routeChange;
    public final TextView routesChagesTv;
    public final TextView routesChangestimeValueTv;

    private RoutesHeaderItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.arrowImg = imageView;
        this.destinationStationTv = textView;
        this.destinationStationValueTv = textView2;
        this.esmtFareValueTv = textView3;
        this.esmtFaretv = textView4;
        this.originCentersTv = textView5;
        this.originStationValueTv = textView6;
        this.routeChange = textView7;
        this.routesChagesTv = textView8;
        this.routesChangestimeValueTv = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RoutesHeaderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RoutesHeaderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.routes_header_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RoutesHeaderItemLayoutBinding bind(View view) {
        int i = R.id.arrowImg;
        ImageView imageView = (ImageView) view.findViewById(R.id.arrowImg);
        if (imageView != null) {
            i = R.id.destinationStationTv;
            TextView textView = (TextView) view.findViewById(R.id.destinationStationTv);
            if (textView != null) {
                i = R.id.destinationStationValueTv;
                TextView textView2 = (TextView) view.findViewById(R.id.destinationStationValueTv);
                if (textView2 != null) {
                    i = R.id.esmtFareValueTv;
                    TextView textView3 = (TextView) view.findViewById(R.id.esmtFareValueTv);
                    if (textView3 != null) {
                        i = R.id.esmtFaretv;
                        TextView textView4 = (TextView) view.findViewById(R.id.esmtFaretv);
                        if (textView4 != null) {
                            i = R.id.originCentersTv;
                            TextView textView5 = (TextView) view.findViewById(R.id.originCentersTv);
                            if (textView5 != null) {
                                i = R.id.originStationValueTv;
                                TextView textView6 = (TextView) view.findViewById(R.id.originStationValueTv);
                                if (textView6 != null) {
                                    i = R.id.routeChange;
                                    TextView textView7 = (TextView) view.findViewById(R.id.routeChange);
                                    if (textView7 != null) {
                                        i = R.id.routesChagesTv;
                                        TextView textView8 = (TextView) view.findViewById(R.id.routesChagesTv);
                                        if (textView8 != null) {
                                            i = R.id.routesChangestimeValueTv;
                                            TextView textView9 = (TextView) view.findViewById(R.id.routesChangestimeValueTv);
                                            if (textView9 != null) {
                                                return new RoutesHeaderItemLayoutBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
