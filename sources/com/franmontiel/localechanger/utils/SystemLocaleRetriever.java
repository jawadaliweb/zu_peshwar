package com.franmontiel.localechanger.utils;

import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SystemLocaleRetriever {
    private SystemLocaleRetriever() {
    }

    public static List<Locale> retrieve() {
        if (Build.VERSION.SDK_INT >= 24) {
            return mapToListOfLocales(LocaleList.getDefault());
        }
        return Collections.singletonList(Locale.getDefault());
    }

    private static List<Locale> mapToListOfLocales(LocaleList localeList) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(localeList.get(i));
        }
        return arrayList;
    }
}
