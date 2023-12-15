package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.budiyev.android.codescanner.CodeScannerView;
import com.lmkt.zupeshawar.R;

public final class ActivityQrScanBinding implements ViewBinding {
    public final FrameLayout frameLay;
    public final LinearLayout headertext;
    public final ImageView notificationIV;
    private final LinearLayout rootView;
    public final CodeScannerView scannerView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private ActivityQrScanBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView, CodeScannerView codeScannerView, Toolbar toolbar2, TextView textView) {
        this.rootView = linearLayout;
        this.frameLay = frameLayout;
        this.headertext = linearLayout2;
        this.notificationIV = imageView;
        this.scannerView = codeScannerView;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQrScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityQrScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_qr_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityQrScanBinding bind(View view) {
        int i = R.id.frameLay;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frameLay);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.notification_IV;
            ImageView imageView = (ImageView) view.findViewById(R.id.notification_IV);
            if (imageView != null) {
                i = R.id.scanner_view;
                CodeScannerView codeScannerView = (CodeScannerView) view.findViewById(R.id.scanner_view);
                if (codeScannerView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                    if (toolbar2 != null) {
                        i = R.id.toolbar_title;
                        TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
                        if (textView != null) {
                            return new ActivityQrScanBinding(linearLayout, frameLayout, linearLayout, imageView, codeScannerView, toolbar2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
