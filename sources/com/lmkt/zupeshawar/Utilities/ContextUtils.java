package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/lmkt/zupeshawar/Utilities/ContextUtils;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Companion", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContextUtils.kt */
public final class ContextUtils extends ContextWrapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextUtils(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "base");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/lmkt/zupeshawar/Utilities/ContextUtils$Companion;", "", "()V", "updateLocale", "Landroid/content/ContextWrapper;", "c", "Landroid/content/Context;", "localeToSwitchTo", "Ljava/util/Locale;", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ContextUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContextWrapper updateLocale(Context context, Locale locale) {
            Intrinsics.checkNotNullParameter(context, "c");
            Intrinsics.checkNotNullParameter(locale, "localeToSwitchTo");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "resources.configuration");
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleList localeList = new LocaleList(new Locale[]{locale});
                LocaleList.setDefault(localeList);
                configuration.setLocales(localeList);
            } else {
                configuration.locale = locale;
            }
            if (Build.VERSION.SDK_INT >= 25) {
                context = context.createConfigurationContext(configuration);
                Intrinsics.checkNotNullExpressionValue(context, "context.createConfigurationContext(configuration)");
            } else {
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
            return new ContextUtils(context);
        }
    }
}
