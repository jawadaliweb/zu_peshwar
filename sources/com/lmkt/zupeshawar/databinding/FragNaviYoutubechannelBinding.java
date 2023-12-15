package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragNaviYoutubechannelBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final WebView youtube;

    private FragNaviYoutubechannelBinding(LinearLayout linearLayout, WebView webView) {
        this.rootView = linearLayout;
        this.youtube = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragNaviYoutubechannelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragNaviYoutubechannelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_youtubechannel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragNaviYoutubechannelBinding bind(View view) {
        WebView webView = (WebView) view.findViewById(R.id.youtube);
        if (webView != null) {
            return new FragNaviYoutubechannelBinding((LinearLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.youtube)));
    }
}
