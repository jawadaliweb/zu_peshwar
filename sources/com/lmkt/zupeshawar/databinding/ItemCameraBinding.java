package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ItemCameraBinding implements ViewBinding {
    public final ImageView camera;
    public final ConstraintLayout layoutUploadImage;
    private final ConstraintLayout rootView;
    public final TextView text;

    private ItemCameraBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.camera = imageView;
        this.layoutUploadImage = constraintLayout2;
        this.text = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_camera, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemCameraBinding bind(View view) {
        int i = R.id.camera;
        ImageView imageView = (ImageView) view.findViewById(R.id.camera);
        if (imageView != null) {
            i = R.id.layoutUploadImage;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.layoutUploadImage);
            if (constraintLayout != null) {
                i = R.id.text;
                TextView textView = (TextView) view.findViewById(R.id.text);
                if (textView != null) {
                    return new ItemCameraBinding((ConstraintLayout) view, imageView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
