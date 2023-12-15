package com.franmontiel.localechanger.matcher;

import com.franmontiel.localechanger.LocalePreference;
import java.util.Locale;

public final class MatchingLocales {
    private Locale supportedLocale;
    private Locale systemLocale;

    public MatchingLocales(Locale locale, Locale locale2) {
        this.supportedLocale = locale;
        this.systemLocale = locale2;
    }

    public Locale getSupportedLocale() {
        return this.supportedLocale;
    }

    public Locale getSystemLocale() {
        return this.systemLocale;
    }

    public Locale getPreferredLocale(LocalePreference localePreference) {
        return localePreference.equals(LocalePreference.PreferSupportedLocale) ? this.supportedLocale : this.systemLocale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchingLocales matchingLocales = (MatchingLocales) obj;
        if (!this.supportedLocale.equals(matchingLocales.supportedLocale) || !this.systemLocale.equals(matchingLocales.systemLocale)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.supportedLocale.hashCode() * 31) + this.systemLocale.hashCode();
    }

    public String toString() {
        return this.supportedLocale.toString() + ", " + this.systemLocale.toString();
    }
}
