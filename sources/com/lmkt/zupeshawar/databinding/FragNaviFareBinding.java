package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;
import com.ortiz.touchview.TouchImageView;

public final class FragNaviFareBinding implements ViewBinding {
    public final TouchImageView ZuMapIV;
    public final FrameLayout frame;
    public final ListView listServiceHours;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    private FragNaviFareBinding(LinearLayout linearLayout, TouchImageView touchImageView, FrameLayout frameLayout, ListView listView, ProgressBar progressBar2) {
        this.rootView = linearLayout;
        this.ZuMapIV = touchImageView;
        this.frame = frameLayout;
        this.listServiceHours = listView;
        this.progressBar = progressBar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviFareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviFareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_fare, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviFareBinding bind(View view) {
        int i = R.id.ZuMap_IV;
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
        if (touchImageView != null) {
            i = R.id.frame;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
            if (frameLayout != null) {
                i = R.id.listServiceHours;
                ListView listView = (ListView) view.findViewById(R.id.listServiceHours);
                if (listView != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                    if (progressBar2 != null) {
                        return new FragNaviFareBinding((LinearLayout) view, touchImageView, frameLayout, listView, progressBar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
