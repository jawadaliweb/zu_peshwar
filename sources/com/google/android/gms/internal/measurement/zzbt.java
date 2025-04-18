package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 6
            r3 = 24
            java.lang.String r4 = "JobSchedulerCompat"
            r5 = 0
            if (r0 < r3) goto L_0x0036
            java.lang.Class<android.app.job.JobScheduler> r0 = android.app.job.JobScheduler.class
            java.lang.String r6 = "scheduleAsPackage"
            r7 = 4
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.Class<android.app.job.JobInfo> r8 = android.app.job.JobInfo.class
            r7[r1] = r8     // Catch:{ NoSuchMethodException -> 0x002a }
            r8 = 1
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r7[r8] = r9     // Catch:{ NoSuchMethodException -> 0x002a }
            r8 = 2
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x002a }
            r7[r8] = r9     // Catch:{ NoSuchMethodException -> 0x002a }
            r8 = 3
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r7[r8] = r9     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x002a }
            goto L_0x0037
        L_0x002a:
            boolean r0 = android.util.Log.isLoggable(r4, r2)
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r4, r0)
        L_0x0036:
            r0 = r5
        L_0x0037:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x0054
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r3 = "myUserId"
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0048 }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r3, r1)     // Catch:{ NoSuchMethodException -> 0x0048 }
            goto L_0x0054
        L_0x0048:
            boolean r0 = android.util.Log.isLoggable(r4, r2)
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r4, r0)
        L_0x0054:
            zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            java.util.Objects.requireNonNull(r7)
            java.lang.reflect.Method r8 = zza
            if (r8 == 0) goto L_0x0074
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x0018
            goto L_0x0074
        L_0x0018:
            java.lang.reflect.Method r5 = zzb
            r8 = 0
            if (r5 == 0) goto L_0x003f
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            if (r5 == 0) goto L_0x003f
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            goto L_0x0040
        L_0x002e:
            r5 = move-exception
            goto L_0x0031
        L_0x0030:
            r5 = move-exception
        L_0x0031:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
        L_0x003f:
            r5 = 0
        L_0x0040:
            java.lang.String r0 = "UploadAlarm"
            java.lang.String r1 = "com.google.android.gms"
            java.lang.reflect.Method r2 = zza
            if (r2 == 0) goto L_0x006f
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            r3[r8] = r6     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            r4 = 1
            r3[r4] = r1     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            r1 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            r3[r1] = r5     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            r5 = 3
            r3[r5] = r0     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            java.lang.Object r5 = r2.invoke(r7, r3)     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            if (r5 == 0) goto L_0x0073
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0067 }
            goto L_0x0073
        L_0x0067:
            r5 = move-exception
            goto L_0x006a
        L_0x0069:
            r5 = move-exception
        L_0x006a:
            java.lang.String r8 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r8, r5)
        L_0x006f:
            int r8 = r7.schedule(r6)
        L_0x0073:
            return r8
        L_0x0074:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
