package com.lmkt.zupeshawar.Utilities;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/lmkt/zupeshawar/Utilities/Helpers;", "", "()V", "loadImageWithGlide", "", "context", "Landroid/content/Context;", "imageUrl", "", "imageView", "Landroid/widget/ImageView;", "fragment", "Landroidx/fragment/app/Fragment;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Helpers.kt */
public final class Helpers {
    public static final Helpers INSTANCE = new Helpers();

    private Helpers() {
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.File] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadImageWithGlide(android.content.Context r6, java.lang.String r7, android.widget.ImageView r8) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "imageView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((android.content.Context) r6)
            com.bumptech.glide.RequestBuilder r6 = r6.asBitmap()
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "http"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, (boolean) r2, (int) r3, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = r0
        L_0x002e:
            com.bumptech.glide.RequestBuilder r6 = r6.load((java.lang.Object) r7)
            com.bumptech.glide.load.engine.DiskCacheStrategy r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.diskCacheStrategy(r7)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            com.lmkt.zupeshawar.Utilities.Helpers$loadImageWithGlide$1 r7 = new com.lmkt.zupeshawar.Utilities.Helpers$loadImageWithGlide$1
            r7.<init>(r8)
            com.bumptech.glide.request.target.Target r7 = (com.bumptech.glide.request.target.Target) r7
            r6.into(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.Utilities.Helpers.loadImageWithGlide(android.content.Context, java.lang.String, android.widget.ImageView):void");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.File] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadImageWithGlide(androidx.fragment.app.Fragment r6, java.lang.String r7, android.widget.ImageView r8) {
        /*
            r5 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "imageView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r6)
            com.bumptech.glide.RequestBuilder r6 = r6.asBitmap()
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "http"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, (boolean) r2, (int) r3, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = r0
        L_0x002e:
            com.bumptech.glide.RequestBuilder r6 = r6.load((java.lang.Object) r7)
            com.bumptech.glide.load.engine.DiskCacheStrategy r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.diskCacheStrategy(r7)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            com.lmkt.zupeshawar.Utilities.Helpers$loadImageWithGlide$2 r7 = new com.lmkt.zupeshawar.Utilities.Helpers$loadImageWithGlide$2
            r7.<init>(r8)
            com.bumptech.glide.request.target.Target r7 = (com.bumptech.glide.request.target.Target) r7
            r6.into(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.Utilities.Helpers.loadImageWithGlide(androidx.fragment.app.Fragment, java.lang.String, android.widget.ImageView):void");
    }
}
