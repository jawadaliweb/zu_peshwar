package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemPdfBinding implements ViewBinding {
    public final ImageView pdf;
    public final ImageView pdfBtnCancel;
    public final CardView pdfCardView;
    private final ConstraintLayout rootView;

    private ItemPdfBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, CardView cardView) {
        this.rootView = constraintLayout;
        this.pdf = imageView;
        this.pdfBtnCancel = imageView2;
        this.pdfCardView = cardView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPdfBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPdfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_pdf, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPdfBinding bind(View view) {
        int i = R.id.pdf;
        ImageView imageView = (ImageView) view.findViewById(R.id.pdf);
        if (imageView != null) {
            i = R.id.pdfBtnCancel;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.pdfBtnCancel);
            if (imageView2 != null) {
                i = R.id.pdfCardView;
                CardView cardView = (CardView) view.findViewById(R.id.pdfCardView);
                if (cardView != null) {
                    return new ItemPdfBinding((ConstraintLayout) view, imageView, imageView2, cardView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
