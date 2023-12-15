package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemVideoBinding implements ViewBinding {
    public final ImageView btnPlayVideo;
    private final ConstraintLayout rootView;
    public final ImageView video;
    public final ImageView videoBtnCancel;
    public final CardView videoCardView;

    private ItemVideoBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, CardView cardView) {
        this.rootView = constraintLayout;
        this.btnPlayVideo = imageView;
        this.video = imageView2;
        this.videoBtnCancel = imageView3;
        this.videoCardView = cardView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemVideoBinding bind(View view) {
        int i = R.id.btnPlayVideo;
        ImageView imageView = (ImageView) view.findViewById(R.id.btnPlayVideo);
        if (imageView != null) {
            i = R.id.video;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.video);
            if (imageView2 != null) {
                i = R.id.videoBtnCancel;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.videoBtnCancel);
                if (imageView3 != null) {
                    i = R.id.videoCardView;
                    CardView cardView = (CardView) view.findViewById(R.id.videoCardView);
                    if (cardView != null) {
                        return new ItemVideoBinding((ConstraintLayout) view, imageView, imageView2, imageView3, cardView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
