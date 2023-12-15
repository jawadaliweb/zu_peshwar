package com.franmontiel.localechanger.utils;

import java.util.Locale;

public class LocaleMatcher {

    public enum MatchLevel {
        NoMatch,
        LanguageMatch,
        LanguageAndCountryMatch,
        CompleteMatch
    }

    private LocaleMatcher() {
    }

    public static MatchLevel match(Locale locale, Locale locale2) {
        MatchLevel matchLevel = MatchLevel.NoMatch;
        if (locale.equals(locale2)) {
            return MatchLevel.CompleteMatch;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || !locale.getCountry().equals(locale2.getCountry())) {
            return locale.getLanguage().equals(locale2.getLanguage()) ? MatchLevel.LanguageMatch : matchLevel;
        }
        return MatchLevel.LanguageAndCountryMatch;
    }
}
