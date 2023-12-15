package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.lmkt.zupeshawar.R;
import com.ortiz.touchview.TouchImageView;

public final class DialogServiceBinding implements ViewBinding {
    public final MaterialButton BtnZuWallet;
    public final TouchImageView ZuMapIV;
    public final RelativeLayout button;
    public final FrameLayout frame;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;

    private DialogServiceBinding(RelativeLayout relativeLayout, MaterialButton materialButton, TouchImageView touchImageView, RelativeLayout relativeLayout2, FrameLayout frameLayout, ProgressBar progressBar2) {
        this.rootView = relativeLayout;
        this.BtnZuWallet = materialButton;
        this.ZuMapIV = touchImageView;
        this.button = relativeLayout2;
        this.frame = frameLayout;
        this.progressBar = progressBar2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogServiceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogServiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_service, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogServiceBinding bind(View view) {
        int i = R.id.Btn_ZuWallet;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.Btn_ZuWallet);
        if (materialButton != null) {
            i = R.id.ZuMap_IV;
            TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
            if (touchImageView != null) {
                i = R.id.button;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.button);
                if (relativeLayout != null) {
                    i = R.id.frame;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame);
                    if (frameLayout != null) {
                        i = R.id.progress_bar;
                        ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar);
                        if (progressBar2 != null) {
                            return new DialogServiceBinding((RelativeLayout) view, materialButton, touchImageView, relativeLayout, frameLayout, progressBar2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
