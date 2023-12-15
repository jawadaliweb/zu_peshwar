package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

public class DynamicColors {
    private static final Precondition ALWAYS_ALLOW = new Precondition() {
        public boolean shouldApplyDynamicColors(Activity activity, int i) {
            return true;
        }
    };
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    private DynamicColors() {
    }

    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, 0);
    }

    public static void applyToActivitiesIfAvailable(Application application, int i) {
        applyToActivitiesIfAvailable(application, i, ALWAYS_ALLOW);
    }

    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, 0, precondition);
    }

    public static void applyToActivitiesIfAvailable(Application application, int i, Precondition precondition) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(i, precondition));
    }

    public static void applyIfAvailable(Activity activity) {
        applyIfAvailable(activity, 0);
    }

    public static void applyIfAvailable(Activity activity, int i) {
        applyIfAvailable(activity, i, ALWAYS_ALLOW);
    }

    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyIfAvailable(activity, 0, precondition);
    }

    /* access modifiers changed from: private */
    public static void applyIfAvailable(Activity activity, int i, Precondition precondition) {
        if (isDynamicColorAvailable()) {
            if (i == 0) {
                i = getDefaultThemeOverlay(activity);
            }
            if (i != 0 && precondition.shouldApplyDynamicColors(activity, i)) {
                activity.setTheme(i);
            }
        }
    }

    public static Context wrapContextIfAvailable(Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static Context wrapContextIfAvailable(Context context, int i) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        if (i == 0) {
            i = getDefaultThemeOverlay(context);
        }
        return i == 0 ? context : new ContextThemeWrapper(context, i);
    }

    public static boolean isDynamicColorAvailable() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private static int getDefaultThemeOverlay(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final int dynamicColorThemeOverlay;
        private final Precondition precondition;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        DynamicColorsActivityLifecycleCallbacks(int i, Precondition precondition2) {
            this.dynamicColorThemeOverlay = i;
            this.precondition = precondition2;
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyIfAvailable(activity, this.dynamicColorThemeOverlay, this.precondition);
        }
    }
}
