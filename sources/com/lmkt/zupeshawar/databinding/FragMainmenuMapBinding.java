package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;
import com.ortiz.touchview.TouchImageView;

public final class FragMainmenuMapBinding implements ViewBinding {
    public final TouchImageView ZuMapIV;
    public final PinView imageView;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    private FragMainmenuMapBinding(LinearLayout linearLayout, TouchImageView touchImageView, PinView pinView, ProgressBar progressBar2) {
        this.rootView = linearLayout;
        this.ZuMapIV = touchImageView;
        this.imageView = pinView;
        this.progressBar = progressBar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuMapBinding bind(View view) {
        int i = R.id.ZuMap_IV;
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
        if (touchImageView != null) {
            i = R.id.imageView;
            PinView pinView = (PinView) view.findViewById(R.id.imageView);
            if (pinView != null) {
                i = R.id.progress_bar;
                ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                if (progressBar2 != null) {
                    return new FragMainmenuMapBinding((LinearLayout) view, touchImageView, pinView, progressBar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
