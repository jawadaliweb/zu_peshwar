package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragNaviFaqBinding implements ViewBinding {
    public final WebView myWebView;
    private final ScrollView rootView;

    private FragNaviFaqBinding(ScrollView scrollView, WebView webView) {
        this.rootView = scrollView;
        this.myWebView = webView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragNaviFaqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviFaqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_faq, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviFaqBinding bind(View view) {
        WebView webView = (WebView) view.findViewById(R.id.myWebView);
        if (webView != null) {
            return new FragNaviFaqBinding((ScrollView) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.myWebView)));
    }
}
