package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;

public class TypefaceUtil {
    public static void overrideFont(Context context, String str, String str2) {
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str2);
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap = new HashMap();
            hashMap.put("serif", createFromAsset);
            try {
                Field declaredField = Typeface.class.getDeclaredField("sSystemFontMap");
                declaredField.setAccessible(true);
                declaredField.set((Object) null, hashMap);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                Field declaredField2 = Typeface.class.getDeclaredField(str);
                declaredField2.setAccessible(true);
                declaredField2.set((Object) null, createFromAsset);
            } catch (Exception unused) {
                String simpleName = TypefaceUtil.class.getSimpleName();
                Log.e(simpleName, "Can not set custom font " + str2 + " instead of " + str);
            }
        }
    }
}
