package com.franmontiel.localechanger.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ActivityRecreationHelper {
    private static final Map<String, Locale> localesOnActivities = new HashMap();

    private ActivityRecreationHelper() {
    }

    public static void onResume(Activity activity) {
        Map<String, Locale> map = localesOnActivities;
        Locale locale = map.get(activity.toString());
        boolean z = locale != null && !locale.equals(Locale.getDefault());
        map.put(activity.toString(), Locale.getDefault());
        if (z) {
            recreate(activity, false);
        }
    }

    public static void onDestroy(Activity activity) {
        localesOnActivities.remove(activity.toString());
    }

    public static void recreate(Activity activity, boolean z) {
        Intent intent = new Intent(activity, activity.getClass());
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        if (z) {
            ActivityCompat.startActivity(activity, intent, ActivityOptionsCompat.makeCustomAnimation(activity, 17432576, 17432577).toBundle());
        } else {
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        }
        activity.finish();
    }
}
