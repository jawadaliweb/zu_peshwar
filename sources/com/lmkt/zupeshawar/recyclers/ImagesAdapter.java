package com.lmkt.zupeshawar.recyclers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Helpers;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.model.QuestionAttachment;
import com.lmkt.zupeshawar.recyclers.ImagesAdapter;
import com.lmkt.zupeshawar.views.fragments.navDrawer.NavHelpline;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000756789:;BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\u0006j\b\u0012\u0004\u0012\u00020'`\bJ\u000e\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*H\u0016J\u001e\u00104\u001a\u00020.2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006<"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Lcom/lmkt/zupeshawar/views/fragments/navDrawer/NavHelpline;", "list", "Ljava/util/ArrayList;", "Lcom/lmkt/zupeshawar/model/QuestionAttachment;", "Lkotlin/collections/ArrayList;", "isComment", "", "showDeleteBtn", "cancelBtnClicked", "Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CancelBtnClicked;", "imageItemClicked", "Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageClicked;", "(Lcom/lmkt/zupeshawar/views/fragments/navDrawer/NavHelpline;Ljava/util/ArrayList;ZZLcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CancelBtnClicked;Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageClicked;)V", "getCancelBtnClicked", "()Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CancelBtnClicked;", "setCancelBtnClicked", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CancelBtnClicked;)V", "getContext", "()Lcom/lmkt/zupeshawar/views/fragments/navDrawer/NavHelpline;", "setContext", "(Lcom/lmkt/zupeshawar/views/fragments/navDrawer/NavHelpline;)V", "getImageItemClicked", "()Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageClicked;", "setImageItemClicked", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageClicked;)V", "()Z", "setComment", "(Z)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getShowDeleteBtn", "setShowDeleteBtn", "getDocuments", "", "getItem", "position", "", "getItemCount", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDocuments", "CameraViewHolder", "CancelBtnClicked", "Companion", "ImageClicked", "ImageViewHolder", "PdfViewHolder", "VideoViewHolder", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImagesAdapter.kt */
public final class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int VIEW_TYPE_CAMERA = 4;
    public static final int VIEW_TYPE_IMAGE = 1;
    public static final int VIEW_TYPE_PDF = 3;
    public static final int VIEW_TYPE_VIDEO = 2;
    private CancelBtnClicked cancelBtnClicked;
    private NavHelpline context;
    private ImageClicked imageItemClicked;
    private boolean isComment;
    private ArrayList<QuestionAttachment> list;
    private boolean showDeleteBtn;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CancelBtnClicked;", "", "cancelBtnClicked", "", "pos", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    public interface CancelBtnClicked {
        void cancelBtnClicked(int i);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00032\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\f\u001a\u00020\tH&J(\u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u000f\u001a\u00020\tH&¨\u0006\u0010"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageClicked;", "", "onImageClicked", "", "list", "Ljava/util/ArrayList;", "Lcom/lmkt/zupeshawar/model/QuestionAttachment;", "Lkotlin/collections/ArrayList;", "attachments", "", "onPdfClicked", "pdfList", "pdfPosition", "onVideoClicked", "videoList", "videoPosition", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    public interface ImageClicked {
        void onImageClicked(ArrayList<QuestionAttachment> arrayList, int i);

        void onPdfClicked(ArrayList<QuestionAttachment> arrayList, int i);

        void onVideoClicked(ArrayList<QuestionAttachment> arrayList, int i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImagesAdapter(NavHelpline navHelpline, ArrayList arrayList, boolean z, boolean z2, CancelBtnClicked cancelBtnClicked2, ImageClicked imageClicked, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(navHelpline, arrayList, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : cancelBtnClicked2, (i & 32) != 0 ? null : imageClicked);
    }

    public final NavHelpline getContext() {
        return this.context;
    }

    public final void setContext(NavHelpline navHelpline) {
        Intrinsics.checkNotNullParameter(navHelpline, "<set-?>");
        this.context = navHelpline;
    }

    public final ArrayList<QuestionAttachment> getList() {
        return this.list;
    }

    public final void setList(ArrayList<QuestionAttachment> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final boolean isComment() {
        return this.isComment;
    }

    public final void setComment(boolean z) {
        this.isComment = z;
    }

    public final boolean getShowDeleteBtn() {
        return this.showDeleteBtn;
    }

    public final void setShowDeleteBtn(boolean z) {
        this.showDeleteBtn = z;
    }

    public final CancelBtnClicked getCancelBtnClicked() {
        return this.cancelBtnClicked;
    }

    public final void setCancelBtnClicked(CancelBtnClicked cancelBtnClicked2) {
        this.cancelBtnClicked = cancelBtnClicked2;
    }

    public final ImageClicked getImageItemClicked() {
        return this.imageItemClicked;
    }

    public final void setImageItemClicked(ImageClicked imageClicked) {
        this.imageItemClicked = imageClicked;
    }

    public ImagesAdapter(NavHelpline navHelpline, ArrayList<QuestionAttachment> arrayList, boolean z, boolean z2, CancelBtnClicked cancelBtnClicked2, ImageClicked imageClicked) {
        Intrinsics.checkNotNullParameter(navHelpline, "context");
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.context = navHelpline;
        this.list = arrayList;
        this.isComment = z;
        this.showDeleteBtn = z2;
        this.cancelBtnClicked = cancelBtnClicked2;
        this.imageItemClicked = imageClicked;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$Companion;", "", "()V", "VIEW_TYPE_CAMERA", "", "VIEW_TYPE_IMAGE", "VIEW_TYPE_PDF", "VIEW_TYPE_VIDEO", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter;Landroid/view/View;)V", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    private final class ImageViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ImagesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageViewHolder(ImagesAdapter imagesAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = imagesAdapter;
        }

        public final void bind(int i) {
            if (this.this$0.isComment()) {
                ((CardView) this.itemView.findViewById(R.id.imgCardView)).getLayoutParams().height = 200;
                ((CardView) this.itemView.findViewById(R.id.imgCardView)).getLayoutParams().width = 200;
            }
            if (this.this$0.getShowDeleteBtn()) {
                ((ImageView) this.itemView.findViewById(R.id.imgBtnCancel)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R.id.imgBtnCancel)).setOnClickListener(new View.OnClickListener(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ImagesAdapter.ImageViewHolder.m23bind$lambda0(ImagesAdapter.this, this.f$1, view);
                    }
                });
            }
            QuestionAttachment questionAttachment = this.this$0.getList().get(i);
            Intrinsics.checkNotNullExpressionValue(questionAttachment, "list[position]");
            String attachmentUrl = questionAttachment.getAttachmentUrl();
            Intrinsics.checkNotNull(attachmentUrl);
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.image);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.image");
            Helpers.INSTANCE.loadImageWithGlide((Fragment) this.this$0.getContext(), attachmentUrl, imageView);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m23bind$lambda0(ImagesAdapter imagesAdapter, int i, View view) {
            Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
            CancelBtnClicked cancelBtnClicked = imagesAdapter.getCancelBtnClicked();
            if (cancelBtnClicked != null) {
                cancelBtnClicked.cancelBtnClicked(i);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter;Landroid/view/View;)V", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    private final class VideoViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ImagesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoViewHolder(ImagesAdapter imagesAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = imagesAdapter;
        }

        public final void bind(int i) {
            if (this.this$0.isComment()) {
                ((CardView) this.itemView.findViewById(R.id.videoCardView)).getLayoutParams().height = 200;
                ((CardView) this.itemView.findViewById(R.id.videoCardView)).getLayoutParams().width = 200;
            }
            if (this.this$0.getShowDeleteBtn()) {
                ((ImageView) this.itemView.findViewById(R.id.videoBtnCancel)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R.id.videoBtnCancel)).setOnClickListener(new View.OnClickListener(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ImagesAdapter.VideoViewHolder.m25bind$lambda0(ImagesAdapter.this, this.f$1, view);
                    }
                });
            }
            QuestionAttachment questionAttachment = this.this$0.getList().get(i);
            Intrinsics.checkNotNullExpressionValue(questionAttachment, "list[position]");
            String attachmentUrl = questionAttachment.getAttachmentUrl();
            Intrinsics.checkNotNull(attachmentUrl);
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.video);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.video");
            Helpers.INSTANCE.loadImageWithGlide((Fragment) this.this$0.getContext(), attachmentUrl, imageView);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m25bind$lambda0(ImagesAdapter imagesAdapter, int i, View view) {
            Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
            CancelBtnClicked cancelBtnClicked = imagesAdapter.getCancelBtnClicked();
            if (cancelBtnClicked != null) {
                cancelBtnClicked.cancelBtnClicked(i);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$CameraViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter;Landroid/view/View;)V", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    private final class CameraViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ImagesAdapter this$0;

        public final void bind(int i) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CameraViewHolder(ImagesAdapter imagesAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = imagesAdapter;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter$PdfViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/lmkt/zupeshawar/recyclers/ImagesAdapter;Landroid/view/View;)V", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImagesAdapter.kt */
    private final class PdfViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ImagesAdapter this$0;

        public final void bind(int i) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PdfViewHolder(ImagesAdapter imagesAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = imagesAdapter;
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 1) {
            View inflate = LayoutInflater.from(this.context.getContext()).inflate(R.layout.item_image, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context.context).in…tem_image, parent, false)");
            return new ImageViewHolder(this, inflate);
        } else if (i == 2) {
            View inflate2 = LayoutInflater.from(this.context.getContext()).inflate(R.layout.item_video, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(context.context).in…tem_video, parent, false)");
            return new VideoViewHolder(this, inflate2);
        } else if (i != 3) {
            View inflate3 = LayoutInflater.from(this.context.getContext()).inflate(R.layout.item_camera, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(context.context).in…em_camera, parent, false)");
            return new CameraViewHolder(this, inflate3);
        } else {
            View inflate4 = LayoutInflater.from(this.context.getContext()).inflate(R.layout.item_pdf, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "from(context.context).in….item_pdf, parent, false)");
            return new PdfViewHolder(this, inflate4);
        }
    }

    public int getItemCount() {
        return this.list.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (this.list.get(i).getType() == 1) {
            ((ImageViewHolder) viewHolder).bind(i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ImagesAdapter.m19onBindViewHolder$lambda0(ImagesAdapter.this, this.f$1, view);
                }
            });
        } else if (this.list.get(i).getType() == 3) {
            ((PdfViewHolder) viewHolder).bind(i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ImagesAdapter.m20onBindViewHolder$lambda1(ImagesAdapter.this, this.f$1, view);
                }
            });
        } else if (this.list.get(i).getType() == 2) {
            ((VideoViewHolder) viewHolder).bind(i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ImagesAdapter.m21onBindViewHolder$lambda2(ImagesAdapter.this, this.f$1, view);
                }
            });
        } else {
            ((CameraViewHolder) viewHolder).bind(i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ImagesAdapter.m22onBindViewHolder$lambda3(ImagesAdapter.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m19onBindViewHolder$lambda0(ImagesAdapter imagesAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
        ImageClicked imageClicked = imagesAdapter.imageItemClicked;
        if (imageClicked != null) {
            imageClicked.onImageClicked(imagesAdapter.list, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m20onBindViewHolder$lambda1(ImagesAdapter imagesAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
        ImageClicked imageClicked = imagesAdapter.imageItemClicked;
        if (imageClicked != null) {
            imageClicked.onPdfClicked(imagesAdapter.list, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2  reason: not valid java name */
    public static final void m21onBindViewHolder$lambda2(ImagesAdapter imagesAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
        ImageClicked imageClicked = imagesAdapter.imageItemClicked;
        if (imageClicked != null) {
            imageClicked.onVideoClicked(imagesAdapter.list, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-3  reason: not valid java name */
    public static final void m22onBindViewHolder$lambda3(ImagesAdapter imagesAdapter, View view) {
        Intrinsics.checkNotNullParameter(imagesAdapter, "this$0");
        if (imagesAdapter.list.size() <= 1) {
            imagesAdapter.context.openDocument();
        } else {
            ToastUtil.showToast(ToastUtil.ToastType.error, "you can only select single document to upload");
        }
    }

    public int getItemViewType(int i) {
        return this.list.get(i).getType();
    }

    public final QuestionAttachment getItem(int i) {
        QuestionAttachment questionAttachment = this.list.get(i);
        Intrinsics.checkNotNullExpressionValue(questionAttachment, "list[position]");
        return questionAttachment;
    }

    public final void setDocuments(ArrayList<QuestionAttachment> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.list = arrayList;
        notifyDataSetChanged();
    }

    public final ArrayList<String> getDocuments() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            if (this.list.get(i).getAttachmentUrl() != null) {
                String attachmentUrl = this.list.get(i).getAttachmentUrl();
                Intrinsics.checkNotNull(attachmentUrl);
                arrayList.add(attachmentUrl);
            } else {
                String attachmentFile = this.list.get(i).getAttachmentFile();
                Intrinsics.checkNotNull(attachmentFile);
                arrayList.add(attachmentFile);
            }
        }
        return arrayList;
    }
}
