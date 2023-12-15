package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lmkt.zupeshawar.R;

public final class ActivityZuCardScannerBinding implements ViewBinding {
    public final ImageView BtnBack;
    public final Button Test;
    public final TextView date;
    public final ImageView errorImage;
    public final TextView inst;
    public final LottieAnimationView lottieAnimationView;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final ConstraintLayout toolbarContainer;
    public final TextView toolbarTitle;

    private ActivityZuCardScannerBinding(ConstraintLayout constraintLayout, ImageView imageView, Button button, TextView textView, ImageView imageView2, TextView textView2, LottieAnimationView lottieAnimationView2, Toolbar toolbar2, ConstraintLayout constraintLayout2, TextView textView3) {
        this.rootView = constraintLayout;
        this.BtnBack = imageView;
        this.Test = button;
        this.date = textView;
        this.errorImage = imageView2;
        this.inst = textView2;
        this.lottieAnimationView = lottieAnimationView2;
        this.toolbar = toolbar2;
        this.toolbarContainer = constraintLayout2;
        this.toolbarTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZuCardScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityZuCardScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_zu_card_scanner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityZuCardScannerBinding bind(View view) {
        int i = R.id.Btn_Back;
        ImageView imageView = (ImageView) view.findViewById(R.id.Btn_Back);
        if (imageView != null) {
            i = R.id.Test;
            Button button = (Button) view.findViewById(R.id.Test);
            if (button != null) {
                i = R.id.date;
                TextView textView = (TextView) view.findViewById(R.id.date);
                if (textView != null) {
                    i = R.id.error_image;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.error_image);
                    if (imageView2 != null) {
                        i = R.id.inst;
                        TextView textView2 = (TextView) view.findViewById(R.id.inst);
                        if (textView2 != null) {
                            i = R.id.lottieAnimationView;
                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.lottieAnimationView);
                            if (lottieAnimationView2 != null) {
                                i = R.id.toolbar;
                                Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                                if (toolbar2 != null) {
                                    i = R.id.toolbarContainer;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.toolbarContainer);
                                    if (constraintLayout != null) {
                                        i = R.id.toolbar_title;
                                        TextView textView3 = (TextView) view.findViewById(R.id.toolbar_title);
                                        if (textView3 != null) {
                                            return new ActivityZuCardScannerBinding((ConstraintLayout) view, imageView, button, textView, imageView2, textView2, lottieAnimationView2, toolbar2, constraintLayout, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
