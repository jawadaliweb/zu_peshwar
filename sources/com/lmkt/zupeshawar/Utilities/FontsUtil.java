package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Field;

public final class FontsUtil {
    public void setDefaultFont(Context context, String str, String str2) {
        replaceFont(str, Typeface.createFromAsset(context.getAssets(), str2));
    }

    /* access modifiers changed from: protected */
    public void replaceFont(String str, Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set((Object) null, typeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
}
