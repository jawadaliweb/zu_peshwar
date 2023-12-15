package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.List;

public class TermsAndConditionImageSliderAdapter extends SliderViewAdapter<SliderAdapterVH> {
    private Context context;
    private List<String> images;
    ProgressBar progressSlider;

    public TermsAndConditionImageSliderAdapter(Context context2, List<String> list) {
        this.context = context2;
        this.images = list;
    }

    public void setTermsAndConditionImages(List<String> list) {
        this.images = list;
    }

    public SliderAdapterVH onCreateViewHolder(ViewGroup viewGroup) {
        return new SliderAdapterVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.terms_and_condition_image_slider_layout_item, (ViewGroup) null));
    }

    public void onBindViewHolder(final SliderAdapterVH sliderAdapterVH, int i) {
        RequestManager with = Glide.with(this.context);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) with.load("https://brtapp.lmkr.net:5000/api/Common/GetImage?filename=" + this.images.get(i)).placeholder((int) R.mipmap.ic_detail_)).signature(new ObjectKey(String.valueOf(System.currentTimeMillis())))).diskCacheStrategy(DiskCacheStrategy.ALL)).transition(new DrawableTransitionOptions().crossFade()).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                sliderAdapterVH.progressSlider.setVisibility(8);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                sliderAdapterVH.progressSlider.setVisibility(8);
                sliderAdapterVH.imageViewBackground.setVisibility(0);
                return false;
            }
        }).into(sliderAdapterVH.imageViewBackground);
    }

    public int getCount() {
        return this.images.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ImageView imageViewBackground;
        public View itemView;
        ProgressBar progressSlider;

        public SliderAdapterVH(View view) {
            super(view);
            this.imageViewBackground = (ImageView) view.findViewById(R.id.imageViewBackground);
            this.progressSlider = (ProgressBar) view.findViewById(R.id.progressSlider);
            this.itemView = view;
        }
    }
}
