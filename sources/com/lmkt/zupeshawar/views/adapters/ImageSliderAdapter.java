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
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.model.AdvertImages;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.ArrayList;

public class ImageSliderAdapter extends SliderViewAdapter<SliderAdapterVH> {
    private ArrayList<AdvertImages> advertImages;
    private Context context;
    ProgressBar progressSlider;

    public ImageSliderAdapter(Context context2, ArrayList<AdvertImages> arrayList) {
        this.context = context2;
        this.advertImages = arrayList;
    }

    public void setAdvertImages(ArrayList<AdvertImages> arrayList) {
        this.advertImages = arrayList;
    }

    public SliderAdapterVH onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_slider_layout_item, (ViewGroup) null);
        this.progressSlider = (ProgressBar) inflate.findViewById(R.id.progressSlider);
        return new SliderAdapterVH(inflate);
    }

    public void onBindViewHolder(SliderAdapterVH sliderAdapterVH, int i) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.context).load(this.advertImages.get(i).getImageUrl()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)).centerCrop()).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                ImageSliderAdapter.this.progressSlider.setVisibility(4);
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                ImageSliderAdapter.this.progressSlider.setVisibility(4);
                return false;
            }
        }).into(sliderAdapterVH.imageViewBackground);
    }

    public int getCount() {
        return this.advertImages.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ImageView imageViewBackground;
        public View itemView;

        public SliderAdapterVH(View view) {
            super(view);
            this.imageViewBackground = (ImageView) view.findViewById(R.id.imageViewBackground);
            this.itemView = view;
        }
    }
}
