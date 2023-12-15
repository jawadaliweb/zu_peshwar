package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragMainmenuBusarrivalsABinding implements ViewBinding {
    public final ListView busArrivalsLV;
    public final RecyclerView busArrivalsRV;
    private final RelativeLayout rootView;

    private FragMainmenuBusarrivalsABinding(RelativeLayout relativeLayout, ListView listView, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.busArrivalsLV = listView;
        this.busArrivalsRV = recyclerView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragMainmenuBusarrivalsABinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuBusarrivalsABinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_busarrivals_a, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuBusarrivalsABinding bind(View view) {
        int i = R.id.busArrivals_LV;
        ListView listView = (ListView) view.findViewById(R.id.busArrivals_LV);
        if (listView != null) {
            i = R.id.busArrivals_RV;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.busArrivals_RV);
            if (recyclerView != null) {
                return new FragMainmenuBusarrivalsABinding((RelativeLayout) view, listView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
