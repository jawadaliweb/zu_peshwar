package com.franmontiel.localechanger;

import com.franmontiel.localechanger.matcher.MatchingAlgorithm;
import com.franmontiel.localechanger.matcher.MatchingLocales;
import java.util.List;
import java.util.Locale;

class LocaleResolver {
    private MatchingAlgorithm matchingAlgorithm;
    private LocalePreference preference;
    private List<Locale> supportedLocales;
    private List<Locale> systemLocales;

    LocaleResolver(List<Locale> list, List<Locale> list2, MatchingAlgorithm matchingAlgorithm2, LocalePreference localePreference) {
        this.supportedLocales = list;
        this.systemLocales = list2;
        this.matchingAlgorithm = matchingAlgorithm2;
        this.preference = localePreference;
    }

    /* access modifiers changed from: package-private */
    public DefaultResolvedLocalePair resolveDefault() {
        MatchingLocales findDefaultMatch = this.matchingAlgorithm.findDefaultMatch(this.supportedLocales, this.systemLocales);
        if (findDefaultMatch != null) {
            return new DefaultResolvedLocalePair(findDefaultMatch.getSupportedLocale(), findDefaultMatch.getPreferredLocale(this.preference));
        }
        return new DefaultResolvedLocalePair(this.supportedLocales.get(0), this.supportedLocales.get(0));
    }

    /* access modifiers changed from: package-private */
    public Locale resolve(Locale locale) throws UnsupportedLocaleException {
        if (this.supportedLocales.contains(locale)) {
            MatchingLocales matchingLocales = null;
            if (this.preference.equals(LocalePreference.PreferSystemLocale)) {
                matchingLocales = this.matchingAlgorithm.findMatch(locale, this.systemLocales);
            }
            if (matchingLocales != null) {
                return matchingLocales.getPreferredLocale(this.preference);
            }
            return locale;
        }
        throw new UnsupportedLocaleException();
    }
}
