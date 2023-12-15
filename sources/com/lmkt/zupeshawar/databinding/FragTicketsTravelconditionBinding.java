package com.lmkt.zupeshawar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.lmkt.zupeshawar.R;

public final class FragTicketsTravelconditionBinding implements ViewBinding {
    public final WebView myWebView;
    private final ScrollView rootView;

    private FragTicketsTravelconditionBinding(ScrollView scrollView, WebView webView) {
        this.rootView = scrollView;
        this.myWebView = webView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragTicketsTravelconditionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragTicketsTravelconditionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_tickets_travelcondition, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragTicketsTravelconditionBinding bind(View view) {
        WebView webView = (WebView) view.findViewById(R.id.myWebView);
        if (webView != null) {
            return new FragTicketsTravelconditionBinding((ScrollView) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.myWebView)));
    }
}
