package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragMainmenuWhatsnewBinding implements ViewBinding {
    public final WebView myWebView;
    private final ScrollView rootView;

    private FragMainmenuWhatsnewBinding(ScrollView scrollView, WebView webView) {
        this.rootView = scrollView;
        this.myWebView = webView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragMainmenuWhatsnewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragMainmenuWhatsnewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_mainmenu_whatsnew, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragMainmenuWhatsnewBinding bind(View view) {
        WebView webView = (WebView) view.findViewById(R.id.myWebView);
        if (webView != null) {
            return new FragMainmenuWhatsnewBinding((ScrollView) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.myWebView)));
    }
}
