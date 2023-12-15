package es.dmoral.toasty;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Toasty {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    /* access modifiers changed from: private */
    public static final Typeface LOADED_TOAST_TYPEFACE;
    /* access modifiers changed from: private */
    public static boolean allowQueue = true;
    /* access modifiers changed from: private */
    public static Typeface currentTypeface;
    private static Toast lastToast = null;
    /* access modifiers changed from: private */
    public static int textSize = 16;
    /* access modifiers changed from: private */
    public static boolean tintIcon = true;

    static {
        Typeface create = Typeface.create("sans-serif-condensed", 0);
        LOADED_TOAST_TYPEFACE = create;
        currentTypeface = create;
    }

    private Toasty() {
    }

    public static Toast normal(Context context, int i) {
        return normal(context, (CharSequence) context.getString(i), 0, (Drawable) null, false);
    }

    public static Toast normal(Context context, CharSequence charSequence) {
        return normal(context, charSequence, 0, (Drawable) null, false);
    }

    public static Toast normal(Context context, int i, Drawable drawable) {
        return normal(context, (CharSequence) context.getString(i), 0, drawable, true);
    }

    public static Toast normal(Context context, CharSequence charSequence, Drawable drawable) {
        return normal(context, charSequence, 0, drawable, true);
    }

    public static Toast normal(Context context, int i, int i2) {
        return normal(context, (CharSequence) context.getString(i), i2, (Drawable) null, false);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i) {
        return normal(context, charSequence, i, (Drawable) null, false);
    }

    public static Toast normal(Context context, int i, int i2, Drawable drawable) {
        return normal(context, (CharSequence) context.getString(i), i2, drawable, true);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i, Drawable drawable) {
        return normal(context, charSequence, i, drawable, true);
    }

    public static Toast normal(Context context, int i, int i2, Drawable drawable, boolean z) {
        return custom(context, (CharSequence) context.getString(i), drawable, ToastyUtils.getColor(context, R.color.normalColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast normal(Context context, CharSequence charSequence, int i, Drawable drawable, boolean z) {
        return custom(context, charSequence, drawable, ToastyUtils.getColor(context, R.color.normalColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast warning(Context context, int i) {
        return warning(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast warning(Context context, CharSequence charSequence) {
        return warning(context, charSequence, 0, true);
    }

    public static Toast warning(Context context, int i, int i2) {
        return warning(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast warning(Context context, CharSequence charSequence, int i) {
        return warning(context, charSequence, i, true);
    }

    public static Toast warning(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp), ToastyUtils.getColor(context, R.color.warningColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast warning(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp), ToastyUtils.getColor(context, R.color.warningColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast info(Context context, int i) {
        return info(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast info(Context context, CharSequence charSequence) {
        return info(context, charSequence, 0, true);
    }

    public static Toast info(Context context, int i, int i2) {
        return info(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast info(Context context, CharSequence charSequence, int i) {
        return info(context, charSequence, i, true);
    }

    public static Toast info(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp), ToastyUtils.getColor(context, R.color.infoColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast info(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp), ToastyUtils.getColor(context, R.color.infoColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast success(Context context, int i) {
        return success(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast success(Context context, CharSequence charSequence) {
        return success(context, charSequence, 0, true);
    }

    public static Toast success(Context context, int i, int i2) {
        return success(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast success(Context context, CharSequence charSequence, int i) {
        return success(context, charSequence, i, true);
    }

    public static Toast success(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp), ToastyUtils.getColor(context, R.color.successColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast success(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp), ToastyUtils.getColor(context, R.color.successColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast error(Context context, int i) {
        return error(context, (CharSequence) context.getString(i), 0, true);
    }

    public static Toast error(Context context, CharSequence charSequence) {
        return error(context, charSequence, 0, true);
    }

    public static Toast error(Context context, int i, int i2) {
        return error(context, (CharSequence) context.getString(i), i2, true);
    }

    public static Toast error(Context context, CharSequence charSequence, int i) {
        return error(context, charSequence, i, true);
    }

    public static Toast error(Context context, int i, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp), ToastyUtils.getColor(context, R.color.errorColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, true);
    }

    public static Toast error(Context context, CharSequence charSequence, int i, boolean z) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp), ToastyUtils.getColor(context, R.color.errorColor), ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, true);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, boolean z) {
        return custom(context, (CharSequence) context.getString(i), drawable, -1, ToastyUtils.getColor(context, R.color.defaultTextColor), i2, z, false);
    }

    public static Toast custom(Context context, CharSequence charSequence, Drawable drawable, int i, boolean z) {
        return custom(context, charSequence, drawable, -1, ToastyUtils.getColor(context, R.color.defaultTextColor), i, z, false);
    }

    public static Toast custom(Context context, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return custom(context, (CharSequence) context.getString(i), ToastyUtils.getDrawable(context, i2), ToastyUtils.getColor(context, i3), ToastyUtils.getColor(context, R.color.defaultTextColor), i4, z, z2);
    }

    public static Toast custom(Context context, CharSequence charSequence, int i, int i2, int i3, boolean z, boolean z2) {
        return custom(context, charSequence, ToastyUtils.getDrawable(context, i), ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, R.color.defaultTextColor), i3, z, z2);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, int i3, boolean z, boolean z2) {
        return custom(context, (CharSequence) context.getString(i), drawable, ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, R.color.defaultTextColor), i3, z, z2);
    }

    public static Toast custom(Context context, int i, Drawable drawable, int i2, int i3, int i4, boolean z, boolean z2) {
        return custom(context, (CharSequence) context.getString(i), drawable, ToastyUtils.getColor(context, i2), ToastyUtils.getColor(context, i3), i4, z, z2);
    }

    public static Toast custom(Context context, CharSequence charSequence, Drawable drawable, int i, int i2, int i3, boolean z, boolean z2) {
        Drawable drawable2;
        Toast makeText = Toast.makeText(context, "", i3);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
        if (z2) {
            drawable2 = ToastyUtils.tint9PatchDrawableFrame(context, i);
        } else {
            drawable2 = ToastyUtils.getDrawable(context, R.drawable.toast_frame);
        }
        ToastyUtils.setBackground(inflate, drawable2);
        if (!z) {
            imageView.setVisibility(8);
        } else if (drawable != null) {
            if (tintIcon) {
                drawable = ToastyUtils.tintIcon(drawable, i2);
            }
            ToastyUtils.setBackground(imageView, drawable);
        } else {
            throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
        }
        textView.setText(charSequence);
        textView.setTextColor(i2);
        textView.setTypeface(currentTypeface);
        textView.setTextSize(2, (float) textSize);
        makeText.setView(inflate);
        if (!allowQueue) {
            Toast toast = lastToast;
            if (toast != null) {
                toast.cancel();
            }
            lastToast = makeText;
        }
        return makeText;
    }

    public static class Config {
        private boolean allowQueue = true;
        private int textSize = Toasty.textSize;
        private boolean tintIcon = Toasty.tintIcon;
        private Typeface typeface = Toasty.currentTypeface;

        private Config() {
        }

        public static Config getInstance() {
            return new Config();
        }

        public static void reset() {
            Typeface unused = Toasty.currentTypeface = Toasty.LOADED_TOAST_TYPEFACE;
            int unused2 = Toasty.textSize = 16;
            boolean unused3 = Toasty.tintIcon = true;
            boolean unused4 = Toasty.allowQueue = true;
        }

        public Config setToastTypeface(Typeface typeface2) {
            this.typeface = typeface2;
            return this;
        }

        public Config setTextSize(int i) {
            this.textSize = i;
            return this;
        }

        public Config tintIcon(boolean z) {
            this.tintIcon = z;
            return this;
        }

        public Config allowQueue(boolean z) {
            this.allowQueue = z;
            return this;
        }

        public void apply() {
            Typeface unused = Toasty.currentTypeface = this.typeface;
            int unused2 = Toasty.textSize = this.textSize;
            boolean unused3 = Toasty.tintIcon = this.tintIcon;
            boolean unused4 = Toasty.allowQueue = this.allowQueue;
        }
    }
}
