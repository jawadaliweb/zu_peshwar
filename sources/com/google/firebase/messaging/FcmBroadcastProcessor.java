package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE;
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }

    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    public Task<Integer> startMessagingService(Context context2, Intent intent) {
        boolean z = true;
        boolean z2 = PlatformVersion.isAtLeastO() && context2.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (!z2 || z) {
            return Tasks.call(this.executor, new Callable(context2, intent) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ Intent f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final Object call() {
                    return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f$0, this.f$1));
                }
            }).continueWithTask(this.executor, new Continuation(context2, intent) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ Intent f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final Object then(Task task) {
                    return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f$0, this.f$1, task);
                }
            });
        }
        return bindToMessagingService(context2, intent);
    }

    static /* synthetic */ Task lambda$startMessagingService$2(Context context2, Intent intent, Task task) throws Exception {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : bindToMessagingService(context2, intent).continueWith($$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, $$Lambda$FcmBroadcastProcessor$Q4aSwJmV5m4tEWxTtlyNzTxxU.INSTANCE);
    }

    private static Task<Integer> bindToMessagingService(Context context2, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Binding to service");
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context2)) {
            WakeLockHolder.sendWakefulServiceIntent(context2, getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT").sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context2, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, str);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }
}
