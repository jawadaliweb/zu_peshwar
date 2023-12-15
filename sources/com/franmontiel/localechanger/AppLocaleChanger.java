package com.franmontiel.localechanger;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import java.util.Locale;

class AppLocaleChanger {
    private Context context;

    AppLocaleChanger(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public void change(Locale locale) {
        Locale.setDefault(locale);
        if (SupportedSDK.hasNougat()) {
            updateConfiguration(locale);
        } else {
            updateConfigurationLegacy(locale);
        }
    }

    private void updateConfiguration(Locale locale) {
        this.context.getResources().getConfiguration().setLocale(locale);
    }

    private void updateConfigurationLegacy(Locale locale) {
        Configuration configuration = this.context.getResources().getConfiguration();
        configuration.locale = locale;
        this.context.getResources().updateConfiguration(configuration, this.context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: package-private */
    public Context configureBaseContext(Context context2, Locale locale) {
        return SupportedSDK.hasJellyBeanMr1() ? getLocaleConfiguredContext(context2, locale) : context2;
    }

    private Context getLocaleConfiguredContext(Context context2, Locale locale) {
        Configuration configuration = context2.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context2.createConfigurationContext(configuration);
    }

    private static class SupportedSDK {
        private SupportedSDK() {
        }

        static boolean hasNougat() {
            return Build.VERSION.SDK_INT >= 24;
        }

        static boolean hasJellyBeanMr1() {
            return Build.VERSION.SDK_INT >= 17;
        }
    }
}
