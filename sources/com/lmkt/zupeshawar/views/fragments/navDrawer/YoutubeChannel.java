package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;

public class YoutubeChannel extends Fragment implements View.OnClickListener {
    NavigationDrawerItemsActivity activity;
    WebView webView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_youtubechannel, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        WebView webView2 = (WebView) view.findViewById(R.id.youtube);
        this.webView = webView2;
        webView2.getSettings().setJavaScriptEnabled(true);
        this.webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Toast.makeText(YoutubeChannel.this.activity, str, 0).show();
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.webView.loadUrl("https://www.youtube.com/@transpeshawar");
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_youtube);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        view.getId();
    }
}
