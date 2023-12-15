package com.franmontiel.localechanger.matcher;

import com.franmontiel.localechanger.utils.LocaleMatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class ClosestMatchingAlgorithm implements MatchingAlgorithm {
    public MatchingLocales findDefaultMatch(List<Locale> list, List<Locale> list2) {
        MatchingLocales matchingLocales = null;
        MatchingLocales matchingLocales2 = null;
        MatchingLocales matchingLocales3 = null;
        for (Locale next : list2) {
            Iterator<Locale> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Locale next2 = it.next();
                LocaleMatcher.MatchLevel match = LocaleMatcher.match(next, next2);
                if (match.equals(LocaleMatcher.MatchLevel.CompleteMatch)) {
                    matchingLocales = new MatchingLocales(next2, next);
                    continue;
                    break;
                } else if (match.equals(LocaleMatcher.MatchLevel.LanguageAndCountryMatch) && matchingLocales2 == null) {
                    matchingLocales2 = new MatchingLocales(next2, next);
                } else if (match.equals(LocaleMatcher.MatchLevel.LanguageMatch) && matchingLocales3 == null) {
                    matchingLocales3 = new MatchingLocales(next2, next);
                }
            }
            if (matchingLocales != null) {
                break;
            }
        }
        if (matchingLocales != null) {
            return matchingLocales;
        }
        return matchingLocales2 != null ? matchingLocales2 : matchingLocales3;
    }

    public MatchingLocales findMatch(Locale locale, List<Locale> list) {
        Iterator<Locale> it = list.iterator();
        MatchingLocales matchingLocales = null;
        MatchingLocales matchingLocales2 = null;
        MatchingLocales matchingLocales3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Locale next = it.next();
            LocaleMatcher.MatchLevel match = LocaleMatcher.match(next, locale);
            if (match.equals(LocaleMatcher.MatchLevel.CompleteMatch)) {
                matchingLocales = new MatchingLocales(locale, next);
                break;
            } else if (match.equals(LocaleMatcher.MatchLevel.LanguageAndCountryMatch) && matchingLocales2 == null) {
                matchingLocales2 = new MatchingLocales(locale, next);
            } else if (match.equals(LocaleMatcher.MatchLevel.LanguageMatch) && matchingLocales3 == null) {
                matchingLocales3 = new MatchingLocales(locale, next);
            }
        }
        if (matchingLocales != null) {
            return matchingLocales;
        }
        return matchingLocales2 != null ? matchingLocales2 : matchingLocales3;
    }
}
