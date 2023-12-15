package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;
import com.ortiz.touchview.TouchImageView;

public class NavFare extends Fragment {
    private static String TAG = "Fare";
    NavigationDrawerItemsActivity activity;
    TouchImageView imageView;
    ProgressBar progress_bar;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_navi_fare, viewGroup, false);
        try {
            initViews(inflate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        String str = SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.activity) ? "FarePolicy_Urdu.jpeg" : "FarePolicy_English.jpeg";
        RequestManager with = Glide.with((FragmentActivity) this.activity);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) with.load("https://brtapp.lmkr.net:5000/api/Common/GetImage?filename=" + str).placeholder((int) R.mipmap.ic_detail_)).signature(new ObjectKey(String.valueOf(System.currentTimeMillis())))).diskCacheStrategy(DiskCacheStrategy.ALL)).transition(new DrawableTransitionOptions().crossFade()).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                NavFare.this.progress_bar.setVisibility(8);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                NavFare.this.progress_bar.setVisibility(8);
                NavFare.this.imageView.setVisibility(0);
                return false;
            }
        }).into((ImageView) this.imageView);
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.ZuMap_IV);
        this.imageView = touchImageView;
        touchImageView.setVisibility(0);
        this.progress_bar = (ProgressBar) view.findViewById(R.id.progress_bar);
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_Fare);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }
}
