package com.franmontiel.localechanger.matcher;

import java.util.List;
import java.util.Locale;

public interface MatchingAlgorithm {
    MatchingLocales findDefaultMatch(List<Locale> list, List<Locale> list2);

    MatchingLocales findMatch(Locale locale, List<Locale> list);
}
