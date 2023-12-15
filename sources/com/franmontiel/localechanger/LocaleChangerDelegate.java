package com.franmontiel.localechanger;

import android.content.Context;
import java.util.Locale;

class LocaleChangerDelegate {
    private AppLocaleChanger appLocaleChanger;
    private Locale currentLocale;
    private LocalePersistor persistor;
    private LocaleResolver resolver;

    LocaleChangerDelegate(LocalePersistor localePersistor, LocaleResolver localeResolver, AppLocaleChanger appLocaleChanger2) {
        this.persistor = localePersistor;
        this.resolver = localeResolver;
        this.appLocaleChanger = appLocaleChanger2;
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        Locale load = this.persistor.load();
        if (load != null) {
            try {
                this.currentLocale = this.resolver.resolve(load);
            } catch (UnsupportedLocaleException unused) {
                load = null;
            }
        }
        if (load == null) {
            DefaultResolvedLocalePair resolveDefault = this.resolver.resolveDefault();
            this.currentLocale = resolveDefault.getResolvedLocale();
            this.persistor.save(resolveDefault.getSupportedLocale());
        }
        this.appLocaleChanger.change(this.currentLocale);
    }

    /* access modifiers changed from: package-private */
    public void resetLocale() {
        this.persistor.clear();
        initialize();
    }

    /* access modifiers changed from: package-private */
    public void setLocale(Locale locale) {
        try {
            this.currentLocale = this.resolver.resolve(locale);
            this.persistor.save(locale);
            this.appLocaleChanger.change(this.currentLocale);
        } catch (UnsupportedLocaleException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.persistor.load();
    }

    /* access modifiers changed from: package-private */
    public Context configureBaseContext(Context context) {
        return this.appLocaleChanger.configureBaseContext(context, this.currentLocale);
    }

    /* access modifiers changed from: package-private */
    public void onConfigurationChanged() {
        this.appLocaleChanger.change(this.currentLocale);
    }
}
