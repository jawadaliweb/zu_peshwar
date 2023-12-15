package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.AdvertImages;
import com.ortiz.touchview.TouchImageView;
import java.util.ArrayList;

public class BusHoursAdapter extends PagerAdapter {
    ArrayList<AdvertImages> imagesData;
    LayoutInflater inflater;
    Context mContext;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public BusHoursAdapter(Context context, ArrayList<AdvertImages> arrayList) {
        this.mContext = context;
        this.imagesData = arrayList;
    }

    public int getCount() {
        return this.imagesData.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.inflater = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.bus_hours_slider, (ViewGroup) null);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(this.imagesData.get(i).getImageUrl()).placeholder((int) R.mipmap.ic_detail_)).signature(new ObjectKey(String.valueOf(System.currentTimeMillis())))).diskCacheStrategy(DiskCacheStrategy.ALL)).transition(new DrawableTransitionOptions().crossFade()).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        }).into((ImageView) (TouchImageView) inflate.findViewById(R.id.serverImage));
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }
}
