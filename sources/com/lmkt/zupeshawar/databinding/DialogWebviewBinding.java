package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class DialogWebviewBinding implements ViewBinding {
    public final LinearLayout close;
    public final WebView myWebView;
    private final RelativeLayout rootView;

    private DialogWebviewBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, WebView webView) {
        this.rootView = relativeLayout;
        this.close = linearLayout;
        this.myWebView = webView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogWebviewBinding bind(View view) {
        int i = R.id.close;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.close);
        if (linearLayout != null) {
            i = R.id.myWebView;
            WebView webView = (WebView) view.findViewById(R.id.myWebView);
            if (webView != null) {
                return new DialogWebviewBinding((RelativeLayout) view, linearLayout, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
