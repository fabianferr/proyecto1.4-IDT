package com.mbridge.msdk.foundation.db;

import android.database.Cursor;

/* compiled from: ReportErrorDao */
public class n extends a {
    private static n a;

    private n(g gVar) {
        super(gVar);
    }

    public static n a(g gVar) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n(gVar);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r9 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r9 == null) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = " count(*) "
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ all -> 0x003b }
            r0 = 0
            r9 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ Exception -> 0x002c }
            java.lang.String r2 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x002c }
            if (r9 == 0) goto L_0x0024
            boolean r1 = r9.moveToFirst()     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x0024
            int r0 = r9.getInt(r0)     // Catch:{ Exception -> 0x002c }
        L_0x0024:
            if (r9 == 0) goto L_0x0033
        L_0x0026:
            r9.close()     // Catch:{ all -> 0x003b }
            goto L_0x0033
        L_0x002a:
            r0 = move-exception
            goto L_0x0035
        L_0x002c:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r9 == 0) goto L_0x0033
            goto L_0x0026
        L_0x0033:
            monitor-exit(r10)
            return r0
        L_0x0035:
            if (r9 == 0) goto L_0x003a
            r9.close()     // Catch:{ all -> 0x003b }
        L_0x003a:
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            monitor-exit(r10)
            goto L_0x003f
        L_0x003e:
            throw r0
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            java.lang.String r1 = "url=?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r3 = 0
            r2[r3] = r5     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            if (r5 != 0) goto L_0x0013
            monitor-exit(r4)
            return r0
        L_0x0013:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            java.lang.String r3 = "reporterror"
            int r5 = r5.delete(r3, r1, r2)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            monitor-exit(r4)
            return r5
        L_0x001f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0022:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String):int");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r6, java.lang.String r7, long r8) {
        /*
            r5 = this;
            java.lang.String r0 = " or count > 5 "
            java.lang.String r1 = "' and time_stamp="
            java.lang.String r2 = "' and data='"
            java.lang.String r3 = "DELETE from reporterror where url='"
            monitor-enter(r5)
            if (r6 != 0) goto L_0x000d
            java.lang.String r6 = ""
        L_0x000d:
            android.database.sqlite.SQLiteDatabase r4 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            if (r4 != 0) goto L_0x0015
            monitor-exit(r5)
            return
        L_0x0015:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r7)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r2)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r6)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r1)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r8)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r4.append(r0)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r7 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r7.execSQL(r6)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            goto L_0x003b
        L_0x0038:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x003b:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String, java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int b(int r3) {
        /*
            r2 = this;
            java.lang.String r0 = "DELETE from reporterror where count >= "
            monitor-enter(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            r1.append(r3)     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            r1 = 0
            android.database.Cursor r3 = r0.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            int r3 = r3.getCount()     // Catch:{ Exception -> 0x0021, all -> 0x001e }
            monitor-exit(r2)
            return r3
        L_0x001e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0021:
            monitor-exit(r2)
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.b(int):int");
    }

    public final synchronized int b() {
        int i;
        Cursor cursor = null;
        try {
            Cursor query = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            i = query.getCount();
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
                i = 0;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.List<com.mbridge.msdk.foundation.entity.l>] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a4 A[SYNTHETIC, Splitter:B:26:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae A[SYNTHETIC, Splitter:B:34:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.l> a(int r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 5
            r1 = 0
            r12.b(r0)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            android.database.sqlite.SQLiteDatabase r2 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            java.lang.String r3 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            r0.<init>()     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            r0.append(r13)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            java.lang.String r13 = ""
            r0.append(r13)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            if (r13 == 0) goto L_0x0093
            int r0 = r13.getCount()     // Catch:{ Exception -> 0x008e }
            if (r0 <= 0) goto L_0x0093
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x008e }
            r0.<init>()     // Catch:{ Exception -> 0x008e }
        L_0x0034:
            boolean r1 = r13.moveToNext()     // Catch:{ Exception -> 0x008c }
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = "url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "method"
            int r3 = r13.getColumnIndex(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = r13.getString(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = "unitId"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = r13.getString(r4)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "count"
            int r5 = r13.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            int r5 = r13.getInt(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r6 = "time_stamp"
            int r6 = r13.getColumnIndex(r6)     // Catch:{ Exception -> 0x008c }
            long r6 = r13.getLong(r6)     // Catch:{ Exception -> 0x008c }
            com.mbridge.msdk.foundation.entity.l r8 = new com.mbridge.msdk.foundation.entity.l     // Catch:{ Exception -> 0x008c }
            r8.<init>(r1, r3, r2, r4)     // Catch:{ Exception -> 0x008c }
            int r5 = r5 + 1
            r8.a((int) r5)     // Catch:{ Exception -> 0x008c }
            r8.a((long) r6)     // Catch:{ Exception -> 0x008c }
            r0.add(r8)     // Catch:{ Exception -> 0x008c }
            goto L_0x0034
        L_0x008a:
            r1 = r0
            goto L_0x0093
        L_0x008c:
            r1 = move-exception
            goto L_0x009f
        L_0x008e:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x009f
        L_0x0093:
            if (r13 == 0) goto L_0x00a8
            r13.close()     // Catch:{ all -> 0x00b2 }
            goto L_0x00a8
        L_0x0099:
            r0 = move-exception
            goto L_0x00ac
        L_0x009b:
            r13 = move-exception
            r0 = r1
            r1 = r13
            r13 = r0
        L_0x009f:
            r1.printStackTrace()     // Catch:{ all -> 0x00aa }
            if (r13 == 0) goto L_0x00a7
            r13.close()     // Catch:{ all -> 0x00b2 }
        L_0x00a7:
            r1 = r0
        L_0x00a8:
            monitor-exit(r12)
            return r1
        L_0x00aa:
            r0 = move-exception
            r1 = r13
        L_0x00ac:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ all -> 0x00b2 }
        L_0x00b1:
            throw r0     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x00b6
        L_0x00b5:
            throw r13
        L_0x00b6:
            goto L_0x00b5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.lang.String r6, java.lang.String r7, long r8) {
        /*
            r5 = this;
            java.lang.String r0 = "' and time_stamp="
            java.lang.String r1 = "' and data='"
            java.lang.String r2 = "select * from reporterror where url='"
            monitor-enter(r5)
            r3 = 0
            if (r6 != 0) goto L_0x000c
            java.lang.String r6 = ""
        L_0x000c:
            android.database.sqlite.SQLiteDatabase r4 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x0040 }
            if (r4 != 0) goto L_0x0014
            monitor-exit(r5)
            return r3
        L_0x0014:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0040 }
            r4.append(r7)     // Catch:{ Exception -> 0x0040 }
            r4.append(r1)     // Catch:{ Exception -> 0x0040 }
            r4.append(r6)     // Catch:{ Exception -> 0x0040 }
            r4.append(r0)     // Catch:{ Exception -> 0x0040 }
            r4.append(r8)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0040 }
            android.database.sqlite.SQLiteDatabase r7 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0040 }
            r8 = 0
            android.database.Cursor r6 = r7.rawQuery(r6, r8)     // Catch:{ Exception -> 0x0040 }
            int r6 = r6.getCount()     // Catch:{ Exception -> 0x0040 }
            if (r6 <= 0) goto L_0x003c
            r3 = 1
        L_0x003c:
            monitor-exit(r5)
            return r3
        L_0x003e:
            r6 = move-exception
            goto L_0x0046
        L_0x0040:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x003e }
            monitor-exit(r5)
            return r3
        L_0x0046:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.b(java.lang.String, java.lang.String, long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b9, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(com.mbridge.msdk.foundation.entity.l r12) {
        /*
            r11 = this;
            java.lang.String r0 = "' and time_stamp="
            java.lang.String r1 = "' and data='"
            java.lang.String r2 = " where url='"
            java.lang.String r3 = "UPDATE reporterror SET count = "
            monitor-enter(r11)
            r4 = -1
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = "url"
            java.lang.String r8 = r12.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = "method"
            java.lang.String r8 = r12.c()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = "data"
            java.lang.String r8 = r12.d()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = "unitId"
            java.lang.String r8 = r12.a()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = "time_stamp"
            long r8 = r12.f()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            android.database.sqlite.SQLiteDatabase r7 = r11.getWritableDatabase()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r7 != 0) goto L_0x004c
            monitor-exit(r11)
            return r4
        L_0x004c:
            java.lang.String r7 = r12.d()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r8 = r12.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            long r9 = r12.f()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            boolean r7 = r11.b(r7, r8, r9)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r8 = 0
            if (r7 == 0) goto L_0x009c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            int r3 = r12.e()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r2 = r12.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r1 = r12.d()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            long r0 = r12.f()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.append(r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r12 = r6.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            android.database.Cursor r12 = r0.rawQuery(r12, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            int r12 = r12.getCount()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            long r0 = (long) r12
            monitor-exit(r11)
            return r0
        L_0x009c:
            java.lang.String r0 = "count"
            int r12 = r12.e()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.put(r0, r12)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            android.database.sqlite.SQLiteDatabase r12 = r11.getWritableDatabase()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r0 = "reporterror"
            long r0 = r12.insert(r0, r8, r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            monitor-exit(r11)
            return r0
        L_0x00b5:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L_0x00b8:
            monitor-exit(r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.entity.l):long");
    }
}
