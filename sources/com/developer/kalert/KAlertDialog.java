package com.developer.kalert;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.developer.kalert.KAlertDialog;
import com.developer.progressx.ProgressWheel;
import java.util.Objects;

public class KAlertDialog extends AlertDialog implements View.OnClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static boolean DARK_STYLE = false;
    public static final int ERROR_TYPE = 1;
    public static final int INPUT_TYPE = 6;
    public static final int NORMAL_TYPE = 0;
    public static final int PROGRESS_TYPE = 5;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    private int contentTextSize;
    private int mAlertType;
    private Button mCancelButton;
    private KAlertClickListener mCancelClickListener;
    private Drawable mCancelColor;
    private String mCancelText;
    /* access modifiers changed from: private */
    public boolean mCloseFromCancel;
    private Drawable mColor;
    private Button mConfirmButton;
    private KAlertClickListener mConfirmClickListener;
    private String mConfirmText;
    private String mContentText;
    private TextView mContentTextView;
    private ImageView mCustomImage;
    private Drawable mCustomImgDrawable;
    private View mCustomView;
    private FrameLayout mCustomViewContainer;
    /* access modifiers changed from: private */
    public View mDialogView;
    private EditText mEditText;
    private FrameLayout mErrorFrame;
    private ImageView mErrorX;
    private final AnimationSet mErrorXInAnim;
    private final Animation mImageAnim;
    private final AnimationSet mModalInAnim;
    private final AnimationSet mModalOutAnim;
    private final Animation mOverlayOutAnim;
    private FrameLayout mProgressFrame;
    private final ProgressHelper mProgressHelper;
    private boolean mShowCancel;
    private boolean mShowConfirm;
    private boolean mShowContent;
    private boolean mShowTitleText;
    private FrameLayout mSuccessFrame;
    private ImageView mSuccessTick;
    private String mTitleText;
    private TextView mTitleTextView;
    private FrameLayout mWarningFrame;
    private int titleTextSize;

    public interface KAlertClickListener {
        void onClick(KAlertDialog kAlertDialog);
    }

    public KAlertDialog(Context context) {
        this(context, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alert_dialog);
        Window window = getWindow();
        Objects.requireNonNull(window);
        this.mDialogView = window.getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(R.id.title_text);
        this.mContentTextView = (TextView) findViewById(R.id.content_text);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.error_frame);
        this.mErrorFrame = frameLayout;
        this.mErrorX = (ImageView) frameLayout.findViewById(R.id.error_x);
        this.mEditText = (EditText) findViewById(R.id.edit_text);
        this.mSuccessFrame = (FrameLayout) findViewById(R.id.success_frame);
        this.mProgressFrame = (FrameLayout) findViewById(R.id.progress_dialog);
        this.mSuccessTick = (ImageView) this.mSuccessFrame.findViewById(R.id.success_x);
        this.mCustomImage = (ImageView) findViewById(R.id.custom_image);
        this.mWarningFrame = (FrameLayout) findViewById(R.id.warning_frame);
        this.mCustomViewContainer = (FrameLayout) findViewById(R.id.custom_view_container);
        this.mProgressHelper.setProgressWheel((ProgressWheel) findViewById(R.id.progressWheel));
        this.mConfirmButton = (Button) findViewById(R.id.custom_confirm_button);
        this.mCancelButton = (Button) findViewById(R.id.cancel_button);
        this.mConfirmButton.setOnClickListener(this);
        this.mCancelButton.setOnClickListener(this);
        setCustomView(this.mCustomView);
        setTitleText(this.mTitleText);
        setContentText(this.mContentText);
        setCancelText(this.mCancelText);
        setConfirmText(this.mConfirmText);
        setConfirmButtonColor(this.mColor);
        setCancelButtonColor(this.mCancelColor);
        changeAlertType(this.mAlertType, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KAlertDialog(Context context, int i) {
        super(context, DARK_STYLE ? R.style.alert_dialog_dark : R.style.alert_dialog_light);
        this.contentTextSize = 0;
        this.titleTextSize = 0;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.mProgressHelper = new ProgressHelper(context);
        this.mAlertType = i;
        this.mImageAnim = AnimationLoader.loadAnimation(getContext(), R.anim.error_frame_in);
        this.mErrorXInAnim = (AnimationSet) AnimationLoader.loadAnimation(getContext(), R.anim.error_x_in);
        this.mModalInAnim = (AnimationSet) AnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        AnimationSet animationSet = (AnimationSet) AnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        this.mModalOutAnim = animationSet;
        Objects.requireNonNull(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                KAlertDialog.this.mDialogView.setVisibility(8);
                KAlertDialog.this.mDialogView.post(new Runnable() {
                    public final void run() {
                        KAlertDialog.AnonymousClass1.this.lambda$onAnimationEnd$0$KAlertDialog$1();
                    }
                });
            }

            public /* synthetic */ void lambda$onAnimationEnd$0$KAlertDialog$1() {
                if (KAlertDialog.this.mCloseFromCancel) {
                    KAlertDialog.super.cancel();
                } else {
                    KAlertDialog.super.dismiss();
                }
            }
        });
        AnonymousClass2 r3 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                Window window = KAlertDialog.this.getWindow();
                Objects.requireNonNull(window);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 1.0f - f;
                KAlertDialog.this.getWindow().setAttributes(attributes);
            }
        };
        this.mOverlayOutAnim = r3;
        r3.setDuration(120);
        Window window = getWindow();
        Objects.requireNonNull(window);
        window.setSoftInputMode(3);
    }

    private void restore() {
        this.mCustomImage.setVisibility(8);
        this.mErrorFrame.setVisibility(8);
        this.mSuccessFrame.setVisibility(8);
        this.mWarningFrame.setVisibility(8);
        this.mProgressFrame.setVisibility(8);
        this.mConfirmButton.setVisibility(0);
        this.mConfirmButton.setBackgroundResource(R.drawable.button_background);
        this.mErrorFrame.clearAnimation();
        this.mErrorX.clearAnimation();
        this.mSuccessTick.clearAnimation();
    }

    private void playAnimation() {
        int i = this.mAlertType;
        if (i == 1) {
            this.mErrorFrame.startAnimation(this.mImageAnim);
            this.mErrorX.startAnimation(this.mErrorXInAnim);
        } else if (i == 2) {
            this.mSuccessTick.startAnimation(this.mImageAnim);
            this.mSuccessFrame.startAnimation(this.mImageAnim);
        }
    }

    private void changeAlertType(int i, boolean z) {
        this.mAlertType = i;
        if (this.mDialogView != null) {
            if (!z) {
                restore();
            }
            switch (this.mAlertType) {
                case 1:
                    this.mErrorFrame.setVisibility(0);
                    setConfirmButtonColor(this.mColor);
                    break;
                case 2:
                    this.mSuccessFrame.setVisibility(0);
                    setConfirmButtonColor(this.mColor);
                    break;
                case 3:
                    this.mWarningFrame.setVisibility(0);
                    setConfirmButtonColor(this.mColor);
                    break;
                case 4:
                    setCustomImage1(this.mCustomImgDrawable);
                    setConfirmButtonColor(this.mColor);
                    break;
                case 5:
                    this.mProgressFrame.setVisibility(0);
                    this.mConfirmButton.setVisibility(8);
                    setConfirmButtonColor(this.mColor);
                    break;
                case 6:
                    this.mEditText.requestFocus();
                    setConfirmButtonColor(this.mColor);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public void changeAlertType(int i) {
        changeAlertType(i, false);
    }

    public KAlertDialog setTitleText(String str) {
        this.mTitleText = str;
        if (!(this.mTitleTextView == null || str == null)) {
            showTitleText();
            int i = this.titleTextSize;
            if (i != 0) {
                this.mTitleTextView.setTextSize(0, (float) spToPx((float) i, getContext()));
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.mTitleTextView.setText(Html.fromHtml(this.mTitleText, 1));
            } else {
                this.mTitleTextView.setText(Html.fromHtml(this.mTitleText));
            }
        }
        return this;
    }

    private void showTitleText() {
        this.mShowTitleText = true;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setVisibility(0);
            this.mContentTextView.setAutoLinkMask(15);
        }
    }

    public KAlertDialog setCustomImage(int i, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return setCustomImage1(getContext().getResources().getDrawable(i, context.getTheme()));
        }
        return setCustomImage1(getContext().getResources().getDrawable(i));
    }

    private KAlertDialog setCustomImage1(Drawable drawable) {
        this.mCustomImgDrawable = drawable;
        ImageView imageView = this.mCustomImage;
        if (!(imageView == null || drawable == null)) {
            imageView.setVisibility(0);
            this.mCustomImage.setImageDrawable(this.mCustomImgDrawable);
        }
        return this;
    }

    public KAlertDialog setContentText(String str) {
        this.mContentText = str;
        if (!(this.mContentTextView == null || str == null)) {
            showContentText();
            int i = this.contentTextSize;
            if (i != 0) {
                this.mContentTextView.setTextSize(0, (float) spToPx((float) i, getContext()));
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.mContentTextView.setText(Html.fromHtml(this.mContentText, 0));
            } else {
                this.mContentTextView.setText(Html.fromHtml(this.mContentText));
            }
            this.mCustomViewContainer.setVisibility(8);
        }
        return this;
    }

    public KAlertDialog showCancelButton(boolean z) {
        this.mShowCancel = z;
        Button button = this.mCancelButton;
        if (button != null) {
            button.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    public KAlertDialog showConfirmButton(boolean z) {
        this.mShowConfirm = z;
        Button button = this.mConfirmButton;
        if (button != null) {
            button.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    private void showContentText() {
        this.mShowContent = true;
        TextView textView = this.mContentTextView;
        if (textView != null) {
            textView.setVisibility(0);
            this.mContentTextView.setAutoLinkMask(15);
        }
    }

    public KAlertDialog setCancelClickListener(KAlertClickListener kAlertClickListener) {
        this.mCancelClickListener = kAlertClickListener;
        return this;
    }

    public KAlertDialog setConfirmClickListener(KAlertClickListener kAlertClickListener) {
        this.mConfirmClickListener = kAlertClickListener;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mDialogView.startAnimation(this.mModalInAnim);
        playAnimation();
    }

    public void cancel() {
        dismissWithAnimation(true);
    }

    private KAlertDialog setConfirmButtonColor(Drawable drawable) {
        this.mColor = drawable;
        Button button = this.mConfirmButton;
        if (!(button == null || drawable == null)) {
            button.setBackground(drawable);
        }
        return this;
    }

    private KAlertDialog setCancelButtonColor(Drawable drawable) {
        this.mCancelColor = drawable;
        Button button = this.mCancelButton;
        if (!(button == null || drawable == null)) {
            button.setBackground(drawable);
        }
        return this;
    }

    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    public void dismissWithAnimation(boolean z) {
        this.mCloseFromCancel = z;
        this.mConfirmButton.startAnimation(this.mOverlayOutAnim);
        this.mDialogView.startAnimation(this.mModalOutAnim);
    }

    public static int spToPx(float f, Context context) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public int getAlertType() {
        return this.mAlertType;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public boolean isShowTitleText() {
        return this.mShowTitleText;
    }

    public String getContentText() {
        return this.mContentText;
    }

    public String getInputText() {
        return this.mEditText.getText().toString();
    }

    public void setInputText(String str) {
        this.mEditText.setText(str);
    }

    public boolean isShowCancelButton() {
        return this.mShowCancel;
    }

    public boolean isShowConfirmButton() {
        return this.mShowConfirm;
    }

    public boolean isShowContentText() {
        return this.mShowContent;
    }

    public String getCancelText() {
        return this.mCancelText;
    }

    public KAlertDialog setCancelText(String str) {
        this.mCancelText = str;
        if (!(this.mCancelButton == null || str == null)) {
            showCancelButton(true);
            this.mCancelButton.setText(this.mCancelText);
        }
        return this;
    }

    public String getConfirmText() {
        return this.mConfirmText;
    }

    public KAlertDialog setConfirmText(String str) {
        this.mConfirmText = str;
        if (!(this.mConfirmButton == null || str == null)) {
            showConfirmButton(true);
            this.mConfirmButton.setText(this.mConfirmText);
        }
        return this;
    }

    public KAlertDialog confirmButtonColor(int i, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return setConfirmButtonColor(getContext().getResources().getDrawable(i, context.getTheme()));
        }
        return setConfirmButtonColor(getContext().getResources().getDrawable(i));
    }

    public KAlertDialog cancelButtonColor(int i, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return setCancelButtonColor(getContext().getResources().getDrawable(i, context.getTheme()));
        }
        return setCancelButtonColor(getContext().getResources().getDrawable(i));
    }

    public KAlertDialog setTitleTextSize(int i) {
        this.titleTextSize = i;
        return this;
    }

    public int getTitleTextSize() {
        return this.titleTextSize;
    }

    public KAlertDialog setContentTextSize(int i) {
        this.contentTextSize = i;
        return this;
    }

    public int getContentTextSize() {
        return this.contentTextSize;
    }

    public KAlertDialog setCustomView(View view) {
        FrameLayout frameLayout;
        this.mCustomView = view;
        if (!(view == null || (frameLayout = this.mCustomViewContainer) == null)) {
            frameLayout.addView(view);
            this.mCustomViewContainer.setVisibility(0);
        }
        return this;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.cancel_button) {
            KAlertClickListener kAlertClickListener = this.mCancelClickListener;
            if (kAlertClickListener != null) {
                kAlertClickListener.onClick(this);
            } else {
                dismissWithAnimation();
            }
        } else if (view.getId() == R.id.custom_confirm_button) {
            KAlertClickListener kAlertClickListener2 = this.mConfirmClickListener;
            if (kAlertClickListener2 != null) {
                kAlertClickListener2.onClick(this);
            } else {
                dismissWithAnimation();
            }
        }
    }

    public ProgressHelper getProgressHelper() {
        return this.mProgressHelper;
    }
}
