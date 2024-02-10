package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.Campaign;

/* compiled from: DailyPlayCapDao */
public class i extends a<Campaign> {
    private static final String a = "com.mbridge.msdk.foundation.db.i";
    private static i b;

    private i(g gVar) {
        super(gVar);
    }

    public static synchronized i a(g gVar) {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i(gVar);
            }
            iVar = b;
        }
        return iVar;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r1 != 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r1 == 0) goto L_0x0072;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "SELECT * FROM dailyplaycap where unit_id ='"
            r1 = 0
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>(r0)     // Catch:{ all -> 0x0065 }
            r3.append(r12)     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = "'"
            r3.append(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0065 }
            android.database.sqlite.SQLiteDatabase r3 = r11.getReadableDatabase()     // Catch:{ all -> 0x0065 }
            android.database.Cursor r1 = r3.rawQuery(r0, r1)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x005f
            int r0 = r1.getCount()     // Catch:{ all -> 0x0065 }
            if (r0 <= 0) goto L_0x005f
            boolean r0 = r1.moveToFirst()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "first_insert_timestamp"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ all -> 0x0065 }
            long r3 = r1.getLong(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = "play_time"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ all -> 0x0065 }
            int r0 = r1.getInt(r0)     // Catch:{ all -> 0x0065 }
            long r5 = (long) r0     // Catch:{ all -> 0x0065 }
            r7 = 0
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x005f
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0065 }
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            long r7 = r7 - r9
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0056
            r11.b(r12)     // Catch:{ all -> 0x0065 }
            goto L_0x005f
        L_0x0056:
            if (r13 <= 0) goto L_0x005f
            long r12 = (long) r13
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x005f
            r12 = 1
            r2 = 1
        L_0x005f:
            if (r1 == 0) goto L_0x0072
        L_0x0061:
            r1.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0072
        L_0x0065:
            r12 = move-exception
            java.lang.String r13 = a     // Catch:{ all -> 0x0073 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0073 }
            com.mbridge.msdk.foundation.tools.aa.b(r13, r12)     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x0072
            goto L_0x0061
        L_0x0072:
            return r2
        L_0x0073:
            r12 = move-exception
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ all -> 0x0079 }
        L_0x0079:
            goto L_0x007b
        L_0x007a:
            throw r12
        L_0x007b:
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.i.a(java.lang.String, int):boolean");
    }

    private synchronized void b(String str) {
        try {
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("first_insert_timestamp", 0);
                contentValues.put("play_time", 0);
                getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", (String[]) null);
            } else {
                return;
            }
        } catch (Throwable th) {
            aa.b(a, th.getMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c8, code lost:
        if (r3 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r3 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00de */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078 A[Catch:{ Exception -> 0x006f, all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db A[SYNTHETIC, Splitter:B:45:0x00db] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "unit_id = '"
            java.lang.String r2 = "SELECT * FROM dailyplaycap where unit_id ='"
            monitor-enter(r18)
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r18.getWritableDatabase()     // Catch:{ Exception -> 0x00d0 }
            if (r4 != 0) goto L_0x0011
            monitor-exit(r18)
            return
        L_0x0011:
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x00d0 }
            r4.<init>()     // Catch:{ Exception -> 0x00d0 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d0 }
            boolean r7 = r18.c(r19)     // Catch:{ Exception -> 0x00d0 }
            r8 = 1
            if (r7 == 0) goto L_0x00a7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00d0 }
            r7.append(r0)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = "'"
            r7.append(r2)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x00d0 }
            android.database.sqlite.SQLiteDatabase r7 = r18.getReadableDatabase()     // Catch:{ Exception -> 0x00d0 }
            android.database.Cursor r2 = r7.rawQuery(r2, r3)     // Catch:{ Exception -> 0x00d0 }
            r10 = 0
            if (r2 == 0) goto L_0x0072
            int r7 = r2.getCount()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            if (r7 <= 0) goto L_0x0072
            r2.moveToFirst()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r7 = "first_insert_timestamp"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            long r12 = r2.getLong(r7)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r7 = "play_time"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            int r7 = r2.getInt(r7)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            long r14 = (long) r7     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r16 = 86400000(0x5265c00, double:4.2687272E-316)
            long r16 = r5 - r16
            int r7 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x0074
            r18.b(r19)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r14 = r10
            goto L_0x0074
        L_0x006b:
            r0 = move-exception
            r3 = r2
            goto L_0x00d9
        L_0x006f:
            r0 = move-exception
            r3 = r2
            goto L_0x00d1
        L_0x0072:
            r12 = r10
            r14 = r12
        L_0x0074:
            int r7 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x0081
            java.lang.String r7 = "first_insert_timestamp"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r4.put(r7, r5)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
        L_0x0081:
            java.lang.String r5 = "play_time"
            long r14 = r14 + r8
            java.lang.Long r6 = java.lang.Long.valueOf(r14)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r5.<init>(r1)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r5.append(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r0 = "'"
            r5.append(r0)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            android.database.sqlite.SQLiteDatabase r1 = r18.getWritableDatabase()     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            java.lang.String r5 = "dailyplaycap"
            r1.update(r5, r4, r0, r3)     // Catch:{ Exception -> 0x006f, all -> 0x006b }
            r3 = r2
            goto L_0x00c8
        L_0x00a7:
            java.lang.String r1 = "first_insert_timestamp"
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00d0 }
            r4.put(r1, r2)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = "play_time"
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00d0 }
            r4.put(r1, r2)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = "unit_id"
            r4.put(r1, r0)     // Catch:{ Exception -> 0x00d0 }
            android.database.sqlite.SQLiteDatabase r0 = r18.getWritableDatabase()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = "dailyplaycap"
            r0.insert(r1, r3, r4)     // Catch:{ Exception -> 0x00d0 }
        L_0x00c8:
            if (r3 == 0) goto L_0x00d7
        L_0x00ca:
            r3.close()     // Catch:{ all -> 0x00d7 }
            goto L_0x00d7
        L_0x00ce:
            r0 = move-exception
            goto L_0x00d9
        L_0x00d0:
            r0 = move-exception
        L_0x00d1:
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
            if (r3 == 0) goto L_0x00d7
            goto L_0x00ca
        L_0x00d7:
            monitor-exit(r18)
            return
        L_0x00d9:
            if (r3 == 0) goto L_0x00de
            r3.close()     // Catch:{ all -> 0x00de }
        L_0x00de:
            throw r0     // Catch:{ all -> 0x00df }
        L_0x00df:
            r0 = move-exception
            r1 = r0
            monitor-exit(r18)
            goto L_0x00e4
        L_0x00e3:
            throw r1
        L_0x00e4:
            goto L_0x00e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.i.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "SELECT play_time FROM dailyplaycap WHERE unit_id='"
            monitor-enter(r3)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r2.<init>(r0)     // Catch:{ all -> 0x0033 }
            r2.append(r4)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "'"
            r2.append(r4)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r0 = r3.getReadableDatabase()     // Catch:{ all -> 0x0033 }
            r2 = 0
            android.database.Cursor r4 = r0.rawQuery(r4, r2)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002c
            int r0 = r4.getCount()     // Catch:{ all -> 0x0033 }
            if (r0 <= 0) goto L_0x002c
            r4.close()     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x002c:
            if (r4 == 0) goto L_0x0031
            r4.close()     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r3)
            return r1
        L_0x0033:
            monitor-exit(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.i.c(java.lang.String):boolean");
    }
}
