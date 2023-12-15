package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzan {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r3 == false) goto L_0x003d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[Catch:{ all -> 0x00ca, SQLiteException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A[Catch:{ all -> 0x00ca, SQLiteException -> 0x00cf }, LOOP:1: B:31:0x009f->B:36:0x00b1, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:30:0x009d, B:36:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba A[Catch:{ all -> 0x00ca, SQLiteException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(com.google.android.gms.measurement.internal.zzeu r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) throws android.database.sqlite.SQLiteException {
        /*
            if (r10 == 0) goto L_0x00e2
            r0 = 0
            r1 = 0
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r2 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            java.lang.String r5 = "name=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            r6[r0] = r12     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0027 }
            if (r2 == 0) goto L_0x0024
            r2.close()
        L_0x0024:
            if (r3 != 0) goto L_0x0040
            goto L_0x003d
        L_0x0027:
            r3 = move-exception
            goto L_0x002f
        L_0x0029:
            r10 = move-exception
            goto L_0x00dc
        L_0x002c:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x002f:
            com.google.android.gms.measurement.internal.zzes r4 = r10.zzk()     // Catch:{ all -> 0x00da }
            java.lang.String r5 = "Error querying for table"
            r4.zzc(r5, r12, r3)     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x003d
            r2.close()
        L_0x003d:
            r11.execSQL(r13)
        L_0x0040:
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00cf }
            r13.<init>()     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00cf }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00cf }
            r2.append(r12)     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r3 = " LIMIT 0"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x00cf }
            android.database.Cursor r1 = r11.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String[] r2 = r1.getColumnNames()     // Catch:{ all -> 0x00ca }
            java.util.Collections.addAll(r13, r2)     // Catch:{ all -> 0x00ca }
            r1.close()     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r1 = ","
            java.lang.String[] r14 = r14.split(r1)     // Catch:{ SQLiteException -> 0x00cf }
            int r1 = r14.length     // Catch:{ SQLiteException -> 0x00cf }
            r2 = 0
        L_0x0071:
            if (r2 >= r1) goto L_0x009d
            r3 = r14[r2]     // Catch:{ SQLiteException -> 0x00cf }
            boolean r4 = r13.remove(r3)     // Catch:{ SQLiteException -> 0x00cf }
            if (r4 == 0) goto L_0x007e
            int r2 = r2 + 1
            goto L_0x0071
        L_0x007e:
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00cf }
            r13.<init>()     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r14 = "Table "
            r13.append(r14)     // Catch:{ SQLiteException -> 0x00cf }
            r13.append(r12)     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r14 = " is missing required column: "
            r13.append(r14)     // Catch:{ SQLiteException -> 0x00cf }
            r13.append(r3)     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r13 = r13.toString()     // Catch:{ SQLiteException -> 0x00cf }
            r11.<init>(r13)     // Catch:{ SQLiteException -> 0x00cf }
            throw r11     // Catch:{ SQLiteException -> 0x00cf }
        L_0x009d:
            if (r15 == 0) goto L_0x00b4
        L_0x009f:
            int r14 = r15.length     // Catch:{ SQLiteException -> 0x00cf }
            if (r0 >= r14) goto L_0x00b4
            r14 = r15[r0]     // Catch:{ SQLiteException -> 0x00cf }
            boolean r14 = r13.remove(r14)     // Catch:{ SQLiteException -> 0x00cf }
            if (r14 != 0) goto L_0x00b1
            int r14 = r0 + 1
            r14 = r15[r14]     // Catch:{ SQLiteException -> 0x00cf }
            r11.execSQL(r14)     // Catch:{ SQLiteException -> 0x00cf }
        L_0x00b1:
            int r0 = r0 + 2
            goto L_0x009f
        L_0x00b4:
            boolean r11 = r13.isEmpty()     // Catch:{ SQLiteException -> 0x00cf }
            if (r11 != 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzes r11 = r10.zzk()     // Catch:{ SQLiteException -> 0x00cf }
            java.lang.String r14 = "Table has extra columns. table, columns"
            java.lang.String r15 = ", "
            java.lang.String r13 = android.text.TextUtils.join(r15, r13)     // Catch:{ SQLiteException -> 0x00cf }
            r11.zzc(r14, r12, r13)     // Catch:{ SQLiteException -> 0x00cf }
        L_0x00c9:
            return
        L_0x00ca:
            r11 = move-exception
            r1.close()     // Catch:{ SQLiteException -> 0x00cf }
            throw r11     // Catch:{ SQLiteException -> 0x00cf }
        L_0x00cf:
            r11 = move-exception
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzd()
            java.lang.String r13 = "Failed to verify columns on table that was just created"
            r10.zzb(r13, r12)
            throw r11
        L_0x00da:
            r10 = move-exception
            r1 = r2
        L_0x00dc:
            if (r1 == 0) goto L_0x00e1
            r1.close()
        L_0x00e1:
            throw r10
        L_0x00e2:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Monitor must not be null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzeu, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void zzb(zzeu zzeu, SQLiteDatabase sQLiteDatabase) {
        if (zzeu != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzeu.zzk().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzeu.zzk().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzeu.zzk().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzeu.zzk().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
