package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

final class ProxyNotificationInitializer {
    private static final String MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED = "firebase_messaging_notification_delegation_enabled";

    private ProxyNotificationInitializer() {
    }

    static Task<Void> setEnableProxyNotification(Executor executor, Context context, boolean z) {
        if (!PlatformVersion.isAtLeastQ()) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable(context, z, taskCompletionSource) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ TaskCompletionSource f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.f$0, this.f$1, this.f$2);
            }
        });
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$setEnableProxyNotification$0(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        try {
            if (!allowedToUse(context)) {
                Log.e(Constants.TAG, "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            ProxyNotificationPreferences.setProxyNotificationsInitialized(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (z) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate((String) null);
            }
            taskCompletionSource.trySetResult(null);
        } finally {
            taskCompletionSource.trySetResult(null);
        }
    }

    static boolean isProxyNotificationEnabled(Context context) {
        if (!PlatformVersion.isAtLeastQ()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "Platform doesn't support proxying.");
            }
            return false;
        } else if (!allowedToUse(context)) {
            Log.e(Constants.TAG, "error retrieving notification delegate for package " + context.getPackageName());
            return false;
        } else if (!"com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
            return false;
        } else {
            if (!Log.isLoggable(Constants.TAG, 3)) {
                return true;
            }
            Log.d(Constants.TAG, "GMS core is set for proxying");
            return true;
        }
    }

    private static boolean shouldEnableProxyNotification(Context context) {
        ApplicationInfo applicationInfo;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    static void initialize(Context context) {
        if (!ProxyNotificationPreferences.isProxyNotificationInitialized(context)) {
            setEnableProxyNotification($$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, context, shouldEnableProxyNotification(context));
        }
    }

    private static boolean allowedToUse(Context context) {
        return Binder.getCallingUid() == context.getApplicationInfo().uid;
    }
}
