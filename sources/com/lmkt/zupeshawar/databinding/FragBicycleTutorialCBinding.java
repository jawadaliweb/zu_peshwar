package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;

public final class FragBicycleTutorialCBinding implements ViewBinding {
    public final MaterialButton BtnDone;
    public final ImageView arrowIV;
    public final RelativeLayout footer;
    private final RelativeLayout rootView;

    private FragBicycleTutorialCBinding(RelativeLayout relativeLayout, MaterialButton materialButton, ImageView imageView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.BtnDone = materialButton;
        this.arrowIV = imageView;
        this.footer = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragBicycleTutorialCBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragBicycleTutorialCBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_bicycle_tutorial_c, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragBicycleTutorialCBinding bind(View view) {
        int i = R.id.Btn_Done;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_Done);
        if (materialButton != null) {
            i = R.id.arrow_IV;
            ImageView imageView = (ImageView) view.findViewById(R.id.arrow_IV);
            if (imageView != null) {
                i = R.id.footer;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.footer);
                if (relativeLayout != null) {
                    return new FragBicycleTutorialCBinding((RelativeLayout) view, materialButton, imageView, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
