package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class ActivityZuWalletBinding implements ViewBinding {
    public final TextView BalanceTV;
    public final ImageView QRCodeIV;
    public final TextView TimmerTV;
    public final ProgressBar imageViewPB;
    public final ImageView notificationIV;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityZuWalletBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, ProgressBar progressBar, ImageView imageView2, Toolbar toolbar2, TextView textView3) {
        this.rootView = linearLayout;
        this.BalanceTV = textView;
        this.QRCodeIV = imageView;
        this.TimmerTV = textView2;
        this.imageViewPB = progressBar;
        this.notificationIV = imageView2;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZuWalletBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityZuWalletBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_zu_wallet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityZuWalletBinding bind(View view) {
        int i = R.id.Balance_TV;
        TextView textView = (TextView) view.findViewById(R.id.Balance_TV);
        if (textView != null) {
            i = R.id.QR_Code_IV;
            ImageView imageView = (ImageView) view.findViewById(R.id.QR_Code_IV);
            if (imageView != null) {
                i = R.id.Timmer_TV;
                TextView textView2 = (TextView) view.findViewById(R.id.Timmer_TV);
                if (textView2 != null) {
                    i = R.id.imageView_PB;
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.imageView_PB);
                    if (progressBar != null) {
                        i = R.id.notification_IV;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.notification_IV);
                        if (imageView2 != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                            if (toolbar2 != null) {
                                i = R.id.toolbar_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.toolbar_title);
                                if (textView3 != null) {
                                    return new ActivityZuWalletBinding((LinearLayout) view, textView, imageView, textView2, progressBar, imageView2, toolbar2, textView3);
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
