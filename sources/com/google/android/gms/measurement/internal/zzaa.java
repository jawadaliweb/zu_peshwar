package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzaa extends zzkt {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzlg zzlg) {
        super(zzlg);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02cc, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02ce, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d8, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02e2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02e3, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0301, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0304, code lost:
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r1 = new androidx.collection.ArrayMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0313, code lost:
        if (r13.isEmpty() == false) goto L_0x0317;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0317, code lost:
        r3 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0323, code lost:
        if (r3.hasNext() == false) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0325, code lost:
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgi) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x033f, code lost:
        if (r7 == null) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0345, code lost:
        if (r7.isEmpty() == false) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0349, code lost:
        r5 = r10.zzf.zzu().zzq(r6.zzi(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x035b, code lost:
        if (r5.isEmpty() != false) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x035d, code lost:
        r8 = (com.google.android.gms.internal.measurement.zzgh) r6.zzbB();
        r8.zzf();
        r8.zzb(r5);
        r20 = r0;
        r0 = r10.zzf.zzu().zzq(r6.zzk(), r7);
        r8.zzh();
        r8.zzd(r0);
        r0 = new java.util.ArrayList();
        r5 = r6.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0390, code lost:
        if (r5.hasNext() == false) goto L_0x03b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0392, code lost:
        r22 = r3;
        r3 = (com.google.android.gms.internal.measurement.zzfr) r5.next();
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03aa, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r3.zza())) != false) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03ac, code lost:
        r0.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03af, code lost:
        r3 = r22;
        r5 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03b4, code lost:
        r22 = r3;
        r8.zze();
        r8.zza(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.zzj().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03cd, code lost:
        if (r3.hasNext() == false) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03cf, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzgk) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03e1, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r5.zzb())) != false) goto L_0x03c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03e3, code lost:
        r0.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03e7, code lost:
        r8.zzg();
        r8.zzc(r0);
        r1.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgi) r8.zzaD());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03fb, code lost:
        r20 = r0;
        r22 = r3;
        r1.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0402, code lost:
        r0 = r20;
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0408, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x040c, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x073e, code lost:
        if (r5 != null) goto L_0x0740;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0740, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x074e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0758, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0759, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0778, code lost:
        if (r5 == null) goto L_0x077b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0781, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x08f1, code lost:
        if (r3 != null) goto L_0x08f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x08f3, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x08f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x08ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0900, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x091f, code lost:
        if (r3 == null) goto L_0x0922;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0a33, code lost:
        if (r7.zzj() == false) goto L_0x0a3e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0a35, code lost:
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0a3e, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0a3f, code lost:
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0153, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0175, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:112:0x028f] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05c1  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0758 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:249:0x06ae] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0781  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x082e  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x08ff A[ExcHandler: all (th java.lang.Throwable), Splitter:B:331:0x0873] */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x092a  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0a7c  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0b10  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b4 A[Catch:{ SQLiteException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c4 A[SYNTHETIC, Splitter:B:70:0x01c4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            r64 = this;
            r10 = r64
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            r0 = r65
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r68
            r10.zzd = r0
            r0 = r69
            r10.zze = r0
            java.util.Iterator r0 = r66.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            com.google.android.gms.internal.measurement.zzov.zzc()
            com.google.android.gms.measurement.internal.zzge r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzeg r3 = com.google.android.gms.measurement.internal.zzeh.zzY
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzov.zzc()
            com.google.android.gms.measurement.internal.zzge r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzeg r3 = com.google.android.gms.measurement.internal.zzeh.zzX
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r7[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017e
            if (r14 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String r17 = "event_filters"
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 == 0) goto L_0x014d
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.internal.measurement.zzej r13 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzli.zzl(r13, r0)     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x012b }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0159 }
            if (r13 != 0) goto L_0x010c
            goto L_0x013d
        L_0x010c:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0159 }
            if (r16 != 0) goto L_0x0125
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0159 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0159 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x0127
        L_0x0125:
            r12 = r16
        L_0x0127:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x013d
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r12 = r2.zzt     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzeu r12 = r12.zzaA()     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ SQLiteException -> 0x0159 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0159 }
        L_0x013d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 != 0) goto L_0x014a
            if (r5 == 0) goto L_0x0148
            r5.close()
        L_0x0148:
            r12 = r4
            goto L_0x017f
        L_0x014a:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014d:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0159 }
            if (r5 == 0) goto L_0x017e
        L_0x0153:
            r5.close()
            goto L_0x017e
        L_0x0157:
            r0 = move-exception
            goto L_0x0178
        L_0x0159:
            r0 = move-exception
            goto L_0x0160
        L_0x015b:
            r0 = move-exception
            r5 = 0
            goto L_0x0178
        L_0x015e:
            r0 = move-exception
            r5 = 0
        L_0x0160:
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0157 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0157 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x017e
            goto L_0x0153
        L_0x0178:
            if (r5 == 0) goto L_0x017d
            r5.close()
        L_0x017d:
            throw r0
        L_0x017e:
            r12 = r0
        L_0x017f:
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String r17 = "audience_filter_values"
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            java.lang.String r19 = "app_id=?"
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x01c4
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0228 }
            if (r4 == 0) goto L_0x01bd
            r4.close()
        L_0x01bd:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0255
        L_0x01c4:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0228 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0228 }
        L_0x01c9:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zze()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzli.zzl(r13, r0)     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x01f1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0228 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020f
        L_0x01f1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r13 = r2.zzt     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzeu r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzes r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ SQLiteException -> 0x0226 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0224 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0224 }
        L_0x020f:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0224 }
            if (r0 != 0) goto L_0x021d
            if (r4 == 0) goto L_0x021a
            r4.close()
        L_0x021a:
            r13 = r17
            goto L_0x0255
        L_0x021d:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c9
        L_0x0224:
            r0 = move-exception
            goto L_0x0238
        L_0x0226:
            r0 = move-exception
            goto L_0x022b
        L_0x0228:
            r0 = move-exception
            r18 = r6
        L_0x022b:
            r19 = r7
            goto L_0x0238
        L_0x022e:
            r0 = move-exception
            r5 = 0
            goto L_0x0b0e
        L_0x0232:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0238:
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt     // Catch:{ all -> 0x0b0c }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ all -> 0x0b0c }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0b0c }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0b0c }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b0c }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b0c }
            if (r4 == 0) goto L_0x0254
            r4.close()
        L_0x0254:
            r13 = r0
        L_0x0255:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0264
            r12 = r8
            r13 = r9
        L_0x025e:
            r28 = r18
            r29 = r19
            goto L_0x05b5
        L_0x0264:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0410
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r0.zzi()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String r6 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r16 = r8
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02e2 }
            r7 = 0
            r8[r7] = r4     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02e2 }
            r20 = 1
            r8[r20] = r4     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02e2 }
            android.database.Cursor r5 = r5.rawQuery(r6, r8)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02e2 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02de }
            if (r6 == 0) goto L_0x02d4
        L_0x02a2:
            int r6 = r5.getInt(r7)     // Catch:{ SQLiteException -> 0x02de }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x02de }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02de }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02de }
            if (r7 != 0) goto L_0x02ba
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02de }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02de }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02de }
        L_0x02ba:
            r6 = 1
            int r8 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02de }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ SQLiteException -> 0x02de }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02de }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02de }
            if (r6 != 0) goto L_0x02d2
            if (r5 == 0) goto L_0x0304
        L_0x02ce:
            r5.close()
            goto L_0x0304
        L_0x02d2:
            r7 = 0
            goto L_0x02a2
        L_0x02d4:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02de }
            if (r5 == 0) goto L_0x0304
            goto L_0x02ce
        L_0x02db:
            r0 = move-exception
            goto L_0x040a
        L_0x02de:
            r0 = move-exception
            goto L_0x02ea
        L_0x02e0:
            r0 = move-exception
            goto L_0x02e9
        L_0x02e2:
            r0 = move-exception
            r5 = 0
            goto L_0x040a
        L_0x02e6:
            r0 = move-exception
            r16 = r8
        L_0x02e9:
            r5 = 0
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x02db }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r4)     // Catch:{ all -> 0x02db }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02db }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02db }
            if (r5 == 0) goto L_0x0304
            goto L_0x02ce
        L_0x0304:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x0317
            goto L_0x0408
        L_0x0317:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x031f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0408
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgi r6 = (com.google.android.gms.internal.measurement.zzgi) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x03fb
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0349
            goto L_0x03fb
        L_0x0349:
            com.google.android.gms.measurement.internal.zzlg r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzli r5 = r5.zzu()
            java.util.List r8 = r6.zzi()
            java.util.List r5 = r5.zzq(r8, r7)
            boolean r8 = r5.isEmpty()
            if (r8 != 0) goto L_0x031f
            com.google.android.gms.internal.measurement.zzkx r8 = r6.zzbB()
            com.google.android.gms.internal.measurement.zzgh r8 = (com.google.android.gms.internal.measurement.zzgh) r8
            r8.zzf()
            r8.zzb(r5)
            com.google.android.gms.measurement.internal.zzlg r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzli r5 = r5.zzu()
            r20 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            r8.zzh()
            r8.zzd(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r5 = r6.zzh()
            java.util.Iterator r5 = r5.iterator()
        L_0x038c:
            boolean r21 = r5.hasNext()
            if (r21 == 0) goto L_0x03b4
            java.lang.Object r21 = r5.next()
            r22 = r3
            r3 = r21
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            int r21 = r3.zza()
            r23 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            boolean r5 = r7.contains(r5)
            if (r5 != 0) goto L_0x03af
            r0.add(r3)
        L_0x03af:
            r3 = r22
            r5 = r23
            goto L_0x038c
        L_0x03b4:
            r22 = r3
            r8.zze()
            r8.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x03c9:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03e7
            java.lang.Object r5 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r5 = (com.google.android.gms.internal.measurement.zzgk) r5
            int r6 = r5.zzb()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r6 = r7.contains(r6)
            if (r6 != 0) goto L_0x03c9
            r0.add(r5)
            goto L_0x03c9
        L_0x03e7:
            r8.zzg()
            r8.zzc(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzlb r3 = r8.zzaD()
            com.google.android.gms.internal.measurement.zzgi r3 = (com.google.android.gms.internal.measurement.zzgi) r3
            r1.put(r0, r3)
            goto L_0x0402
        L_0x03fb:
            r20 = r0
            r22 = r3
            r1.put(r5, r6)
        L_0x0402:
            r0 = r20
            r3 = r22
            goto L_0x031f
        L_0x0408:
            r0 = r1
            goto L_0x0413
        L_0x040a:
            if (r5 == 0) goto L_0x040f
            r5.close()
        L_0x040f:
            throw r0
        L_0x0410:
            r16 = r8
            r0 = r13
        L_0x0413:
            java.util.Iterator r20 = r2.iterator()
        L_0x0417:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x05b0
            java.lang.Object r1 = r20.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r21 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x047f
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0449
            goto L_0x047f
        L_0x0449:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0451:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x047f
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x0451
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x047a
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x047b
        L_0x047a:
            r3 = 0
        L_0x047b:
            r7.put(r4, r3)
            goto L_0x0451
        L_0x047f:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x04cb
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x048d
            goto L_0x04cb
        L_0x048d:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x0495:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04cb
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x0495
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x0495
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x0495
        L_0x04cb:
            r23 = r0
            if (r1 == 0) goto L_0x051a
            r0 = 0
        L_0x04d0:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x051a
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzli.zzv(r2, r0)
            if (r2 == 0) goto L_0x050c
            com.google.android.gms.measurement.internal.zzge r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzi()
            boolean r2 = com.google.android.gms.measurement.internal.zzli.zzv(r2, r0)
            if (r2 == 0) goto L_0x050e
            r5.set(r0)
            goto L_0x0515
        L_0x050c:
            r22 = r9
        L_0x050e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0515:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x04d0
        L_0x051a:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            if (r15 == 0) goto L_0x0587
            if (r14 == 0) goto L_0x0587
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0587
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x0587
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x053c
            goto L_0x0587
        L_0x053c:
            java.util.Iterator r0 = r0.iterator()
        L_0x0540:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0587
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x0568
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x0568:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x0579
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x0579:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0540
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0540
        L_0x0587:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r64
            r28 = r18
            r29 = r19
            r17 = r12
            r12 = r16
            r65 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)
            r1.put(r2, r0)
            r9 = r13
            r12 = r17
            r0 = r23
            r13 = r65
            goto L_0x0417
        L_0x05b0:
            r13 = r9
            r12 = r16
            goto L_0x025e
        L_0x05b5:
            boolean r0 = r66.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05c1
        L_0x05bd:
            r24 = r11
            goto L_0x0824
        L_0x05c1:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r66.iterator()
        L_0x05d0:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x05bd
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzft r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x05d0
            com.google.android.gms.measurement.internal.zzlg r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r7 = r7.zzi()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzas r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x0639
            com.google.android.gms.measurement.internal.zzge r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r14 = r14.zzaA()
            com.google.android.gms.measurement.internal.zzes r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeu.zzn(r8)
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r30 = r7
            java.lang.String r32 = r0.zzh()
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r0.zzd()
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r31 = r8
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)
            goto L_0x066e
        L_0x0639:
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r47 = r7
            java.lang.String r0 = r14.zza
            r48 = r0
            java.lang.String r0 = r14.zzb
            r49 = r0
            long r8 = r14.zzc
            r15 = 1
            long r50 = r8 + r15
            long r8 = r14.zzd
            long r52 = r8 + r15
            long r8 = r14.zze
            long r54 = r8 + r15
            long r8 = r14.zzf
            r56 = r8
            long r8 = r14.zzg
            r58 = r8
            java.lang.Long r0 = r14.zzh
            r60 = r0
            java.lang.Long r0 = r14.zzi
            r61 = r0
            java.lang.Long r0 = r14.zzj
            r62 = r0
            java.lang.Boolean r0 = r14.zzk
            r63 = r0
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r60, r61, r62, r63)
        L_0x066e:
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r0 = r0.zzi()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0785
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r15 = r0.zzi()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r65 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r15.zzh()
            java.lang.String r17 = "event_filters"
            r66 = r5
            r24 = r11
            r11 = r28
            r5 = r29
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x0750, all -> 0x0758 }
            java.lang.String r19 = "app_id=? AND event_name=?"
            r29 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x074e, all -> 0x0758 }
            r20 = 0
            r0[r20] = r3     // Catch:{ SQLiteException -> 0x074e, all -> 0x0758 }
            r20 = 1
            r0[r20] = r14     // Catch:{ SQLiteException -> 0x074e, all -> 0x0758 }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x074e, all -> 0x0758 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0748 }
            if (r0 == 0) goto L_0x0736
            r28 = r11
        L_0x06d5:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0732 }
            com.google.android.gms.internal.measurement.zzej r11 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x070e }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzli.zzl(r11, r0)     // Catch:{ IOException -> 0x070e }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x070e }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x070e }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x070e }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x0732 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0732 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x0732 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0732 }
            if (r16 != 0) goto L_0x0706
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0744 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0744 }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x0744 }
            goto L_0x070a
        L_0x0706:
            r22 = r7
            r7 = r16
        L_0x070a:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x0744 }
            goto L_0x0722
        L_0x070e:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.zzge r7 = r15.zzt     // Catch:{ SQLiteException -> 0x0744 }
            com.google.android.gms.measurement.internal.zzeu r7 = r7.zzaA()     // Catch:{ SQLiteException -> 0x0744 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x0744 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ SQLiteException -> 0x0744 }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x0744 }
        L_0x0722:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0744 }
            if (r0 != 0) goto L_0x072f
            if (r5 == 0) goto L_0x072d
            r5.close()
        L_0x072d:
            r0 = r2
            goto L_0x077b
        L_0x072f:
            r7 = r22
            goto L_0x06d5
        L_0x0732:
            r0 = move-exception
            r22 = r7
            goto L_0x0763
        L_0x0736:
            r22 = r7
            r28 = r11
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0744 }
            if (r5 == 0) goto L_0x077b
        L_0x0740:
            r5.close()
            goto L_0x077b
        L_0x0744:
            r0 = move-exception
            goto L_0x0763
        L_0x0746:
            r0 = move-exception
            goto L_0x077f
        L_0x0748:
            r0 = move-exception
            r22 = r7
            r28 = r11
            goto L_0x0763
        L_0x074e:
            r0 = move-exception
            goto L_0x0753
        L_0x0750:
            r0 = move-exception
            r29 = r5
        L_0x0753:
            r22 = r7
            r28 = r11
            goto L_0x0762
        L_0x0758:
            r0 = move-exception
            r5 = 0
            goto L_0x077f
        L_0x075b:
            r0 = move-exception
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x0762:
            r5 = 0
        L_0x0763:
            com.google.android.gms.measurement.internal.zzge r2 = r15.zzt     // Catch:{ all -> 0x0746 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ all -> 0x0746 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0746 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0746 }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x0746 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0746 }
            if (r5 == 0) goto L_0x077b
            goto L_0x0740
        L_0x077b:
            r4.put(r14, r0)
            goto L_0x078d
        L_0x077f:
            if (r5 == 0) goto L_0x0784
            r5.close()
        L_0x0784:
            throw r0
        L_0x0785:
            r65 = r2
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x078d:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0795:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x081b
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x07bf
            com.google.android.gms.measurement.internal.zzge r3 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x0795
        L_0x07bf:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x07ca:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x080e
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r15 = r10.zzd
            java.lang.Long r14 = r10.zze
            int r7 = r7.zzb()
            boolean r21 = r10.zzf(r3, r7)
            r7 = r14
            r14 = r11
            r16 = r7
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r7 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r7 == 0) goto L_0x0805
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x07ca
        L_0x0805:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x080e:
            if (r7 != 0) goto L_0x0795
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x0795
        L_0x081b:
            r2 = r65
            r5 = r66
            r11 = r24
            r3 = 0
            goto L_0x05d0
        L_0x0824:
            boolean r0 = r67.isEmpty()
            if (r0 == 0) goto L_0x082e
        L_0x082a:
            r11 = r28
            goto L_0x0a62
        L_0x082e:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r67.iterator()
        L_0x0837:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x082a
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x092e
            com.google.android.gms.measurement.internal.zzlg r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            java.lang.String r14 = "property_filters"
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x08fb, all -> 0x08ff }
            java.lang.String r16 = "app_id=? AND property_name=?"
            r65 = r3
            r3 = 2
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x08f9, all -> 0x08ff }
            r3 = 0
            r0[r3] = r7     // Catch:{ SQLiteException -> 0x08f9, all -> 0x08ff }
            r3 = 1
            r0[r3] = r5     // Catch:{ SQLiteException -> 0x08f9, all -> 0x08ff }
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r3 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x08f9, all -> 0x08ff }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x08f7 }
            if (r0 == 0) goto L_0x08ed
        L_0x0896:
            r13 = 1
            byte[] r0 = r3.getBlob(r13)     // Catch:{ SQLiteException -> 0x08f7 }
            com.google.android.gms.internal.measurement.zzes r14 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x08cb }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzli.zzl(r14, r0)     // Catch:{ IOException -> 0x08cb }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x08cb }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x08cb }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x08cb }
            r14 = 0
            int r15 = r3.getInt(r14)     // Catch:{ SQLiteException -> 0x08f7 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x08f7 }
            java.lang.Object r16 = r8.get(r15)     // Catch:{ SQLiteException -> 0x08f7 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08f7 }
            if (r16 != 0) goto L_0x08c5
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08f7 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x08f7 }
            r8.put(r15, r13)     // Catch:{ SQLiteException -> 0x08f7 }
            goto L_0x08c7
        L_0x08c5:
            r13 = r16
        L_0x08c7:
            r13.add(r0)     // Catch:{ SQLiteException -> 0x08f7 }
            goto L_0x08e0
        L_0x08cb:
            r0 = move-exception
            r14 = 0
            com.google.android.gms.measurement.internal.zzge r13 = r6.zzt     // Catch:{ SQLiteException -> 0x08f7 }
            com.google.android.gms.measurement.internal.zzeu r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x08f7 }
            com.google.android.gms.measurement.internal.zzes r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x08f7 }
            java.lang.String r15 = "Failed to merge filter"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ SQLiteException -> 0x08f7 }
            r13.zzc(r15, r14, r0)     // Catch:{ SQLiteException -> 0x08f7 }
        L_0x08e0:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x08f7 }
            if (r0 != 0) goto L_0x0896
            if (r3 == 0) goto L_0x08eb
            r3.close()
        L_0x08eb:
            r0 = r8
            goto L_0x0922
        L_0x08ed:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x08f7 }
            if (r3 == 0) goto L_0x0922
        L_0x08f3:
            r3.close()
            goto L_0x0922
        L_0x08f7:
            r0 = move-exception
            goto L_0x090a
        L_0x08f9:
            r0 = move-exception
            goto L_0x0909
        L_0x08fb:
            r0 = move-exception
            r65 = r3
            goto L_0x0909
        L_0x08ff:
            r0 = move-exception
            r5 = 0
            goto L_0x0928
        L_0x0902:
            r0 = move-exception
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x0909:
            r3 = 0
        L_0x090a:
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt     // Catch:{ all -> 0x0926 }
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()     // Catch:{ all -> 0x0926 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzd()     // Catch:{ all -> 0x0926 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0926 }
            r6.zzc(r12, r7, r0)     // Catch:{ all -> 0x0926 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0926 }
            if (r3 == 0) goto L_0x0922
            goto L_0x08f3
        L_0x0922:
            r2.put(r5, r0)
            goto L_0x0934
        L_0x0926:
            r0 = move-exception
            r5 = r3
        L_0x0928:
            if (r5 == 0) goto L_0x092d
            r5.close()
        L_0x092d:
            throw r0
        L_0x092e:
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x0934:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x093c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a5a
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0967
            com.google.android.gms.measurement.internal.zzge r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0a5a
        L_0x0967:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x0972:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a49
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzet r7 = (com.google.android.gms.internal.measurement.zzet) r7
            com.google.android.gms.measurement.internal.zzge r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r8 = r8.zzaA()
            java.lang.String r8 = r8.zzr()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x09dc
            com.google.android.gms.measurement.internal.zzge r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r8 = r8.zzaA()
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x09ac
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09ad
        L_0x09ac:
            r15 = 0
        L_0x09ad:
            com.google.android.gms.measurement.internal.zzge r13 = r10.zzt
            com.google.android.gms.measurement.internal.zzep r13 = r13.zzj()
            r66 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzge r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzlg r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzli r8 = r8.zzu()
            java.lang.String r8 = r8.zzp(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x09de
        L_0x09dc:
            r66 = r0
        L_0x09de:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a1f
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x09ed
            goto L_0x0a1f
        L_0x09ed:
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a15
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzu r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r66
            goto L_0x0972
        L_0x0a15:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a4b
        L_0x0a1f:
            com.google.android.gms.measurement.internal.zzge r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a3e
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a3f
        L_0x0a3e:
            r7 = 0
        L_0x0a3f:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a4d
        L_0x0a49:
            r66 = r0
        L_0x0a4b:
            if (r7 != 0) goto L_0x0a56
        L_0x0a4d:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0a56:
            r0 = r66
            goto L_0x093c
        L_0x0a5a:
            r3 = r65
            r29 = r9
            r28 = r11
            goto L_0x0837
        L_0x0a62:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a76:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b0b
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfp r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzlg r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgi r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbx()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r24
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0af2 }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0af0 }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b07
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzt     // Catch:{ SQLiteException -> 0x0af0 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0af0 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0af0 }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)     // Catch:{ SQLiteException -> 0x0af0 }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0af0 }
            goto L_0x0b07
        L_0x0af0:
            r0 = move-exception
            goto L_0x0af4
        L_0x0af2:
            r0 = move-exception
            r9 = 0
        L_0x0af4:
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0b07:
            r24 = r4
            goto L_0x0a76
        L_0x0b0b:
            return r1
        L_0x0b0c:
            r0 = move-exception
            r5 = r4
        L_0x0b0e:
            if (r5 == 0) goto L_0x0b13
            r5.close()
        L_0x0b13:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
