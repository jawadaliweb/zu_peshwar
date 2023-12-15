package uk.co.chrisjenx.calligraphy;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    public static Typeface load(AssetManager assetManager, String str) {
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                if (!map.containsKey(str)) {
                    Typeface createFromAsset = Typeface.createFromAsset(assetManager, str);
                    map.put(str, createFromAsset);
                    return createFromAsset;
                }
                Typeface typeface = map.get(str);
                return typeface;
            } catch (Exception e) {
                Log.w("Calligraphy", "Can't create asset from " + str + ". Make sure you have passed in the correct path and file name.", e);
                sCachedFonts.put(str, (Object) null);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            if (!map.containsKey(typeface)) {
                CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
                map.put(typeface, calligraphyTypefaceSpan);
                return calligraphyTypefaceSpan;
            }
            CalligraphyTypefaceSpan calligraphyTypefaceSpan2 = map.get(typeface);
            return calligraphyTypefaceSpan2;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    private TypefaceUtils() {
    }
}
