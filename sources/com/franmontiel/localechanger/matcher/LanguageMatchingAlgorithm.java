package com.franmontiel.localechanger.matcher;

import com.franmontiel.localechanger.utils.LocaleMatcher;
import java.util.List;
import java.util.Locale;

public final class LanguageMatchingAlgorithm implements MatchingAlgorithm {
    public MatchingLocales findDefaultMatch(List<Locale> list, List<Locale> list2) {
        for (Locale next : list2) {
            Locale findMatchingLocale = findMatchingLocale(next, list);
            if (findMatchingLocale != null) {
                return new MatchingLocales(findMatchingLocale, next);
            }
        }
        return null;
    }

    public MatchingLocales findMatch(Locale locale, List<Locale> list) {
        Locale findMatchingLocale = findMatchingLocale(locale, list);
        if (findMatchingLocale != null) {
            return new MatchingLocales(locale, findMatchingLocale);
        }
        return null;
    }

    private static Locale findMatchingLocale(Locale locale, List<Locale> list) {
        for (Locale next : list) {
            if (LocaleMatcher.match(locale, next) != LocaleMatcher.MatchLevel.NoMatch) {
                return next;
            }
        }
        return null;
    }
}
