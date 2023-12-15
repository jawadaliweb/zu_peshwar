package com.lmkt.zupeshawar.Utilities;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/lmkt/zupeshawar/Utilities/Helpers$loadImageWithGlide$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Helpers.kt */
public final class Helpers$loadImageWithGlide$1 extends CustomTarget<Bitmap> {
    final /* synthetic */ ImageView $imageView;

    public void onLoadCleared(Drawable drawable) {
    }

    Helpers$loadImageWithGlide$1(ImageView imageView) {
        this.$imageView = imageView;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        this.$imageView.setImageBitmap(bitmap);
    }
}
