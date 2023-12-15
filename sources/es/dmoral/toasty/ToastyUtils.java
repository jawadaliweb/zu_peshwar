package es.dmoral.toasty;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

final class ToastyUtils {
    private ToastyUtils() {
    }

    static Drawable tintIcon(Drawable drawable, int i) {
        drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    static Drawable tint9PatchDrawableFrame(Context context, int i) {
        return tintIcon((NinePatchDrawable) getDrawable(context, R.drawable.toast_frame), i);
    }

    static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    static Drawable getDrawable(Context context, int i) {
        return AppCompatResources.getDrawable(context, i);
    }

    static int getColor(Context context, int i) {
        return ContextCompat.getColor(context, i);
    }
}
