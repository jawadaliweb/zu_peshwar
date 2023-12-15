package com.franmontiel.localechanger;

import java.util.Locale;

class DefaultResolvedLocalePair {
    private Locale resolvedLocale;
    private Locale supportedLocale;

    DefaultResolvedLocalePair(Locale locale, Locale locale2) {
        this.supportedLocale = locale;
        this.resolvedLocale = locale2;
    }

    /* access modifiers changed from: package-private */
    public Locale getSupportedLocale() {
        return this.supportedLocale;
    }

    /* access modifiers changed from: package-private */
    public Locale getResolvedLocale() {
        return this.resolvedLocale;
    }
}
