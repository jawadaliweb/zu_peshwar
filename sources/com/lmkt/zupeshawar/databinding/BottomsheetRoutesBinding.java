package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class BottomsheetRoutesBinding implements ViewBinding {
    public final ConstraintLayout bottomSheet;
    public final ImageView lineImage;
    private final ConstraintLayout rootView;
    public final RecyclerView routesRecyclerView;

    private BottomsheetRoutesBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.bottomSheet = constraintLayout2;
        this.lineImage = imageView;
        this.routesRecyclerView = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomsheetRoutesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BottomsheetRoutesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottomsheet_routes, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomsheetRoutesBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.lineImage;
        ImageView imageView = (ImageView) view.findViewById(R.id.lineImage);
        if (imageView != null) {
            i = R.id.routesRecyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.routesRecyclerView);
            if (recyclerView != null) {
                return new BottomsheetRoutesBinding(constraintLayout, constraintLayout, imageView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
