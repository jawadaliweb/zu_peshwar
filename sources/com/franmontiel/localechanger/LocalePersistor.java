package com.franmontiel.localechanger;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;

class LocalePersistor {
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_VARIANT = "variant";
    private static final String SP_LOCALE = "LocaleChanger.LocalePersistence";
    private static SharedPreferences localeSharedPrefs;

    LocalePersistor(Context context) {
        localeSharedPrefs = context.getSharedPreferences(SP_LOCALE, 0);
    }

    /* access modifiers changed from: package-private */
    public Locale load() {
        String string = localeSharedPrefs.getString(KEY_LANGUAGE, "");
        if (!string.isEmpty()) {
            return new Locale(string, localeSharedPrefs.getString(KEY_COUNTRY, ""), localeSharedPrefs.getString(KEY_VARIANT, ""));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void save(Locale locale) {
        SharedPreferences.Editor edit = localeSharedPrefs.edit();
        edit.putString(KEY_LANGUAGE, locale.getLanguage());
        edit.putString(KEY_COUNTRY, locale.getCountry());
        edit.putString(KEY_VARIANT, locale.getVariant());
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        SharedPreferences.Editor edit = localeSharedPrefs.edit();
        edit.clear();
        edit.apply();
    }
}
