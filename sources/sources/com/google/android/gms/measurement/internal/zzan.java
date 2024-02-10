package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzan {
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r0 == false) goto L_0x0045;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[Catch:{ all -> 0x00d1, SQLiteException -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A[Catch:{ all -> 0x00d1, SQLiteException -> 0x00d6 }, LOOP:1: B:32:0x00a6->B:37:0x00b8, LOOP_START, PHI: r13 
      PHI: (r13v1 int) = (r13v0 int), (r13v2 int) binds: [B:31:0x00a4, B:37:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c1 A[Catch:{ all -> 0x00d1, SQLiteException -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(com.google.android.gms.measurement.internal.zzeo r15, android.database.sqlite.SQLiteDatabase r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String[] r20) throws android.database.sqlite.SQLiteException {
        /*
            r9 = r16
            r10 = r17
            r11 = r20
            java.lang.String r12 = "SELECT * FROM "
            if (r15 == 0) goto L_0x00e9
            r13 = 0
            r14 = 0
            java.lang.String r0 = "name"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0035, all -> 0x0032 }
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0035, all -> 0x0032 }
            r5[r13] = r10     // Catch:{ SQLiteException -> 0x0035, all -> 0x0032 }
            java.lang.String r2 = "SQLITE_MASTER"
            java.lang.String r4 = "name=?"
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r16
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0035, all -> 0x0032 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0030 }
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            if (r0 != 0) goto L_0x004a
            goto L_0x0045
        L_0x0030:
            r0 = move-exception
            goto L_0x0037
        L_0x0032:
            r0 = move-exception
            goto L_0x00e3
        L_0x0035:
            r0 = move-exception
            r1 = r14
        L_0x0037:
            com.google.android.gms.measurement.internal.zzem r2 = r15.zzk()     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = "Error querying for table"
            r2.zzc(r3, r10, r0)     // Catch:{ all -> 0x00e1 }
            if (r1 == 0) goto L_0x0045
            r1.close()
        L_0x0045:
            r1 = r18
            r9.execSQL(r1)
        L_0x004a:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00d6 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d6 }
            r1.<init>(r12)     // Catch:{ SQLiteException -> 0x00d6 }
            r1.append(r10)     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r2 = " LIMIT 0"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x00d6 }
            android.database.Cursor r1 = r9.rawQuery(r1, r14)     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String[] r2 = r1.getColumnNames()     // Catch:{ all -> 0x00d1 }
            java.util.Collections.addAll(r0, r2)     // Catch:{ all -> 0x00d1 }
            r1.close()     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r1 = ","
            r2 = r19
            java.lang.String[] r1 = r2.split(r1)     // Catch:{ SQLiteException -> 0x00d6 }
            int r2 = r1.length     // Catch:{ SQLiteException -> 0x00d6 }
            r3 = 0
        L_0x0078:
            if (r3 >= r2) goto L_0x00a4
            r4 = r1[r3]     // Catch:{ SQLiteException -> 0x00d6 }
            boolean r5 = r0.remove(r4)     // Catch:{ SQLiteException -> 0x00d6 }
            if (r5 == 0) goto L_0x0085
            int r3 = r3 + 1
            goto L_0x0078
        L_0x0085:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d6 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r2 = "Table "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d6 }
            r1.append(r10)     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r2 = " is missing required column: "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d6 }
            r1.append(r4)     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x00d6 }
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x00d6 }
            throw r0     // Catch:{ SQLiteException -> 0x00d6 }
        L_0x00a4:
            if (r11 == 0) goto L_0x00bb
        L_0x00a6:
            int r1 = r11.length     // Catch:{ SQLiteException -> 0x00d6 }
            if (r13 >= r1) goto L_0x00bb
            r1 = r11[r13]     // Catch:{ SQLiteException -> 0x00d6 }
            boolean r1 = r0.remove(r1)     // Catch:{ SQLiteException -> 0x00d6 }
            if (r1 != 0) goto L_0x00b8
            int r1 = r13 + 1
            r1 = r11[r1]     // Catch:{ SQLiteException -> 0x00d6 }
            r9.execSQL(r1)     // Catch:{ SQLiteException -> 0x00d6 }
        L_0x00b8:
            int r13 = r13 + 2
            goto L_0x00a6
        L_0x00bb:
            boolean r1 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x00d6 }
            if (r1 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzem r1 = r15.zzk()     // Catch:{ SQLiteException -> 0x00d6 }
            java.lang.String r2 = "Table has extra columns. table, columns"
            java.lang.String r3 = ", "
            java.lang.String r0 = android.text.TextUtils.join(r3, r0)     // Catch:{ SQLiteException -> 0x00d6 }
            r1.zzc(r2, r10, r0)     // Catch:{ SQLiteException -> 0x00d6 }
        L_0x00d0:
            return
        L_0x00d1:
            r0 = move-exception
            r1.close()     // Catch:{ SQLiteException -> 0x00d6 }
            throw r0     // Catch:{ SQLiteException -> 0x00d6 }
        L_0x00d6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzem r1 = r15.zzd()
            java.lang.String r2 = "Failed to verify columns on table that was just created"
            r1.zzb(r2, r10)
            throw r0
        L_0x00e1:
            r0 = move-exception
            r14 = r1
        L_0x00e3:
            if (r14 == 0) goto L_0x00e8
            r14.close()
        L_0x00e8:
            throw r0
        L_0x00e9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Monitor must not be null"
            r0.<init>(r1)
            goto L_0x00f2
        L_0x00f1:
            throw r0
        L_0x00f2:
            goto L_0x00f1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzeo, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void zzb(zzeo zzeo, SQLiteDatabase sQLiteDatabase) {
        if (zzeo != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzeo.zzk().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzeo.zzk().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzeo.zzk().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzeo.zzk().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
