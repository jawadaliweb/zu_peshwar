package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemImageBinding implements ViewBinding {
    public final ImageView image;
    public final ImageView imgBtnCancel;
    public final CardView imgCardView;
    private final ConstraintLayout rootView;

    private ItemImageBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, CardView cardView) {
        this.rootView = constraintLayout;
        this.image = imageView;
        this.imgBtnCancel = imageView2;
        this.imgCardView = cardView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_image, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemImageBinding bind(View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        if (imageView != null) {
            i = R.id.imgBtnCancel;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imgBtnCancel);
            if (imageView2 != null) {
                i = R.id.imgCardView;
                CardView cardView = (CardView) view.findViewById(R.id.imgCardView);
                if (cardView != null) {
                    return new ItemImageBinding((ConstraintLayout) view, imageView, imageView2, cardView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
