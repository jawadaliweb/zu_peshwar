package com.franmontiel.localechanger;

import android.content.Context;
import com.franmontiel.localechanger.matcher.LanguageMatchingAlgorithm;
import com.franmontiel.localechanger.matcher.MatchingAlgorithm;
import com.franmontiel.localechanger.utils.SystemLocaleRetriever;
import java.util.List;
import java.util.Locale;

public class LocaleChanger {
    private static LocaleChangerDelegate delegate;

    private LocaleChanger() {
    }

    public static void initialize(Context context, List<Locale> list) {
        initialize(context, list, new LanguageMatchingAlgorithm(), LocalePreference.PreferSupportedLocale);
    }

    public static void initialize(Context context, List<Locale> list, MatchingAlgorithm matchingAlgorithm, LocalePreference localePreference) {
        if (delegate == null) {
            LocaleChangerDelegate localeChangerDelegate = new LocaleChangerDelegate(new LocalePersistor(context), new LocaleResolver(list, SystemLocaleRetriever.retrieve(), matchingAlgorithm, localePreference), new AppLocaleChanger(context));
            delegate = localeChangerDelegate;
            localeChangerDelegate.initialize();
            return;
        }
        throw new IllegalStateException("LocaleChanger is already initialized");
    }

    public static void resetLocale() {
        delegate.resetLocale();
    }

    public static void setLocale(Locale locale) {
        delegate.setLocale(locale);
    }

    public static Locale getLocale() {
        return delegate.getLocale();
    }

    public static Context configureBaseContext(Context context) {
        return delegate.configureBaseContext(context);
    }

    public static void onConfigurationChanged() {
        delegate.onConfigurationChanged();
    }
}
