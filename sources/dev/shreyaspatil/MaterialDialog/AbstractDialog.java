package dev.shreyaspatil.MaterialDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import dev.shreyaspatil.MaterialDialog.interfaces.OnCancelListener;
import dev.shreyaspatil.MaterialDialog.interfaces.OnDismissListener;
import dev.shreyaspatil.MaterialDialog.interfaces.OnShowListener;
import dev.shreyaspatil.MaterialDialog.model.DialogButton;
import dev.shreyaspatil.MaterialDialog.model.DialogMessage;
import dev.shreyaspatil.MaterialDialog.model.DialogTitle;
import dev.shreyaspatil.MaterialDialog.model.TextAlignment;

public abstract class AbstractDialog implements DialogInterface {
    public static final int BUTTON_NEGATIVE = -1;
    public static final int BUTTON_POSITIVE = 1;
    public static final int NO_ANIMATION = -111;
    public static final int NO_ICON = -111;
    protected Activity mActivity;
    protected String mAnimationFile;
    protected int mAnimationResId;
    protected LottieAnimationView mAnimationView;
    protected boolean mCancelable;
    protected Dialog mDialog;
    protected TextAlignment mMessageTextAlignment;
    protected DialogButton mNegativeButton;
    protected OnCancelListener mOnCancelListener;
    protected OnDismissListener mOnDismissListener;
    protected OnShowListener mOnShowListener;
    protected DialogButton mPositiveButton;
    protected TextAlignment mTitleTextAlignment;
    protected DialogMessage message;
    protected DialogTitle title;

    public interface OnClickListener {
        void onClick(DialogInterface dialogInterface, int i);
    }

    protected AbstractDialog(Activity activity, DialogTitle dialogTitle, DialogMessage dialogMessage, boolean z, DialogButton dialogButton, DialogButton dialogButton2, int i, String str) {
        this.mActivity = activity;
        this.title = dialogTitle;
        this.message = dialogMessage;
        this.mCancelable = z;
        this.mPositiveButton = dialogButton;
        this.mNegativeButton = dialogButton2;
        this.mAnimationResId = i;
        this.mAnimationFile = str;
    }

    /* access modifiers changed from: protected */
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.layout_alert_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.textView_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textView_message);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.button_positive);
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.button_negative);
        this.mAnimationView = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
        if (this.title != null) {
            textView.setVisibility(0);
            textView.setText(this.title.getText());
            textView.setTextAlignment(this.title.getTextAlignment().getAlignment());
        } else {
            textView.setVisibility(8);
        }
        if (this.message != null) {
            textView2.setVisibility(0);
            textView2.setText(this.message.getText());
            textView2.setTextAlignment(this.message.getTextAlignment().getAlignment());
        } else {
            textView2.setVisibility(8);
        }
        if (this.mPositiveButton != null) {
            materialButton.setVisibility(0);
            materialButton.setText(this.mPositiveButton.getTitle());
            if (Build.VERSION.SDK_INT >= 21 && this.mPositiveButton.getIcon() != -111) {
                materialButton.setIcon(ContextCompat.getDrawable(this.mActivity, this.mPositiveButton.getIcon()));
            }
            materialButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AbstractDialog.this.mPositiveButton.getOnClickListener().onClick(AbstractDialog.this, 1);
                }
            });
        } else {
            materialButton.setVisibility(4);
        }
        if (this.mNegativeButton != null) {
            materialButton2.setVisibility(0);
            materialButton2.setText(this.mNegativeButton.getTitle());
            if (Build.VERSION.SDK_INT >= 21 && this.mNegativeButton.getIcon() != -111) {
                materialButton2.setIcon(ContextCompat.getDrawable(this.mActivity, this.mNegativeButton.getIcon()));
            }
            materialButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AbstractDialog.this.mNegativeButton.getOnClickListener().onClick(AbstractDialog.this, -1);
                }
            });
        } else {
            materialButton2.setVisibility(4);
        }
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mAnimationView.setVisibility(8);
        } else if (this.mAnimationResId != -111) {
            this.mAnimationView.setVisibility(0);
            this.mAnimationView.setAnimation(this.mAnimationResId);
            this.mAnimationView.playAnimation();
        } else if (this.mAnimationFile != null) {
            this.mAnimationView.setVisibility(0);
            this.mAnimationView.setAnimation(this.mAnimationFile);
            this.mAnimationView.playAnimation();
        } else {
            this.mAnimationView.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = this.mActivity.getTheme().obtainStyledAttributes(R.styleable.MaterialDialog);
        try {
            inflate.setBackgroundColor(obtainStyledAttributes.getColor(R.styleable.MaterialDialog_material_dialog_background, this.mActivity.getResources().getColor(R.color.material_dialog_background)));
            textView.setTextColor(obtainStyledAttributes.getColor(R.styleable.MaterialDialog_material_dialog_title_text_color, this.mActivity.getResources().getColor(R.color.material_dialog_title_text_color)));
            textView2.setTextColor(obtainStyledAttributes.getColor(R.styleable.MaterialDialog_material_dialog_message_text_color, this.mActivity.getResources().getColor(R.color.material_dialog_message_text_color)));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.MaterialDialog_material_dialog_positive_button_text_color);
            if (colorStateList == null) {
                colorStateList = ContextCompat.getColorStateList(this.mActivity.getApplicationContext(), R.color.material_dialog_positive_button_text_color);
            }
            materialButton.setTextColor(colorStateList);
            materialButton.setIconTint(colorStateList);
            ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.MaterialDialog_material_dialog_negative_button_text_color);
            if (colorStateList2 == null) {
                colorStateList2 = ContextCompat.getColorStateList(this.mActivity.getApplicationContext(), R.color.material_dialog_negative_button_text_color);
            }
            materialButton2.setIconTint(colorStateList2);
            materialButton2.setTextColor(colorStateList2);
            ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.MaterialDialog_material_dialog_positive_button_color);
            if (colorStateList3 == null) {
                colorStateList3 = ContextCompat.getColorStateList(this.mActivity.getApplicationContext(), R.color.material_dialog_positive_button_color);
            }
            materialButton.setBackgroundTintList(colorStateList3);
            if (colorStateList3 != null) {
                materialButton2.setRippleColor(colorStateList3.withAlpha(75));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        return inflate;
    }

    public void show() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        } else {
            throwNullDialog();
        }
    }

    public void cancel() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.cancel();
        } else {
            throwNullDialog();
        }
    }

    public void dismiss() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        } else {
            throwNullDialog();
        }
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
        this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(android.content.DialogInterface dialogInterface) {
                AbstractDialog.this.showCallback();
            }
        });
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
        this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(android.content.DialogInterface dialogInterface) {
                AbstractDialog.this.cancelCallback();
            }
        });
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                AbstractDialog.this.dismissCallback();
            }
        });
    }

    public LottieAnimationView getAnimationView() {
        return this.mAnimationView;
    }

    /* access modifiers changed from: private */
    public void showCallback() {
        OnShowListener onShowListener = this.mOnShowListener;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
    }

    /* access modifiers changed from: private */
    public void dismissCallback() {
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    /* access modifiers changed from: private */
    public void cancelCallback() {
        OnCancelListener onCancelListener = this.mOnCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    private void throwNullDialog() {
        throw new NullPointerException("Called method on null Dialog. Create dialog using `Builder` before calling on Dialog");
    }

    public static abstract class Builder<D extends AbstractDialog> {
        protected final Activity activity;
        protected String animationFile;
        protected int animationResId = -111;
        protected boolean isCancelable;
        protected DialogMessage message;
        protected DialogButton negativeButton;
        protected DialogButton positiveButton;
        protected DialogTitle title;

        public abstract D build();

        public Builder(Activity activity2) {
            this.activity = activity2;
        }

        public Builder<D> setTitle(String str) {
            return setTitle(str, TextAlignment.CENTER);
        }

        public Builder<D> setTitle(String str, TextAlignment textAlignment) {
            this.title = new DialogTitle(str, textAlignment);
            return this;
        }

        public Builder<D> setMessage(String str) {
            return setMessage(str, TextAlignment.CENTER);
        }

        public Builder<D> setMessage(String str, TextAlignment textAlignment) {
            this.message = DialogMessage.text(str, textAlignment);
            return this;
        }

        public Builder<D> setMessage(Spanned spanned) {
            return setMessage(spanned, TextAlignment.CENTER);
        }

        public Builder<D> setMessage(Spanned spanned, TextAlignment textAlignment) {
            this.message = DialogMessage.spanned(spanned, textAlignment);
            return this;
        }

        public Builder<D> setCancelable(boolean z) {
            this.isCancelable = z;
            return this;
        }

        public Builder<D> setPositiveButton(String str, OnClickListener onClickListener) {
            return setPositiveButton(str, -111, onClickListener);
        }

        public Builder<D> setPositiveButton(String str, int i, OnClickListener onClickListener) {
            this.positiveButton = new DialogButton(str, i, onClickListener);
            return this;
        }

        public Builder<D> setNegativeButton(String str, OnClickListener onClickListener) {
            return setNegativeButton(str, -111, onClickListener);
        }

        public Builder<D> setNegativeButton(String str, int i, OnClickListener onClickListener) {
            this.negativeButton = new DialogButton(str, i, onClickListener);
            return this;
        }

        public Builder<D> setAnimation(int i) {
            this.animationResId = i;
            return this;
        }

        public Builder<D> setAnimation(String str) {
            this.animationFile = str;
            return this;
        }
    }
}
