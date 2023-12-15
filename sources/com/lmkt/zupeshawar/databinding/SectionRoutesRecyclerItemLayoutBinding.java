package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class SectionRoutesRecyclerItemLayoutBinding implements ViewBinding {
    public final RecyclerView multiViewRecycler;
    private final ConstraintLayout rootView;

    private SectionRoutesRecyclerItemLayoutBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.multiViewRecycler = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SectionRoutesRecyclerItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SectionRoutesRecyclerItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.section_routes_recycler_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SectionRoutesRecyclerItemLayoutBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.multiViewRecycler);
        if (recyclerView != null) {
            return new SectionRoutesRecyclerItemLayoutBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.multiViewRecycler)));
    }
}
