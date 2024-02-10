package com.mbridge.msdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/* compiled from: DatabaseManager */
final class c {
    private final b a;
    private final String b;
    private final Object c = new Object();

    public c(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    public final long a(i iVar) {
        synchronized (this.c) {
            long j = -1;
            if (y.a((Object) this.a)) {
                return -1;
            }
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (a(writableDatabase)) {
                return -1;
            }
            try {
                d(writableDatabase);
                ContentValues contentValues = new ContentValues(16);
                e c2 = iVar.c();
                contentValues.put("name", c2.a());
                contentValues.put("type", Integer.valueOf(c2.b()));
                contentValues.put("time_stamp", Long.valueOf(c2.f()));
                contentValues.put("properties", c2.d().toString());
                contentValues.put("priority", Integer.valueOf(c2.c()));
                contentValues.put("state", Integer.valueOf(iVar.e()));
                contentValues.put("report_count", Integer.valueOf(iVar.d()));
                contentValues.put("uuid", c2.e());
                int i = 0;
                contentValues.put("ignore_max_timeout", Integer.valueOf(c2.j() ? 0 : 1));
                if (!c2.k()) {
                    i = 1;
                }
                contentValues.put("ignore_max_retry_times", Integer.valueOf(i));
                contentValues.put("invalid_time", Long.valueOf(iVar.g()));
                j = writableDatabase.insert(this.b, (String) null, contentValues);
                c(writableDatabase);
            } catch (Exception e) {
                try {
                    if (a.a) {
                        Log.e("TrackManager", "insert: " + e.getMessage());
                    }
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            }
            b(writableDatabase);
            return j;
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [java.util.List<com.mbridge.msdk.e.i>] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064 A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.e.i> a(int r15) {
        /*
            r14 = this;
            java.lang.String r0 = "getAvailable: "
            java.lang.Object r1 = r14.c
            monitor-enter(r1)
            com.mbridge.msdk.e.b r2 = r14.a     // Catch:{ all -> 0x0089 }
            boolean r2 = com.mbridge.msdk.e.y.a((java.lang.Object) r2)     // Catch:{ all -> 0x0089 }
            r3 = 0
            if (r2 == 0) goto L_0x0010
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            return r3
        L_0x0010:
            com.mbridge.msdk.e.b r2 = r14.a     // Catch:{ all -> 0x0089 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ all -> 0x0089 }
            boolean r4 = a((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x001e
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            return r3
        L_0x001e:
            d(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.String r7 = "state = ? OR state = ?"
            r4 = 2
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ Exception -> 0x005e }
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x005e }
            r8[r4] = r5     // Catch:{ Exception -> 0x005e }
            r4 = 3
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x005e }
            r5 = 1
            r8[r5] = r4     // Catch:{ Exception -> 0x005e }
            java.lang.String r11 = "priority DESC"
            java.lang.String r5 = r14.b     // Catch:{ Exception -> 0x005e }
            r6 = 0
            r9 = 0
            r10 = 0
            java.lang.String r12 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x005e }
            r4 = r2
            android.database.Cursor r15 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x005e }
            java.util.List r3 = com.mbridge.msdk.e.y.b((android.database.Cursor) r15)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            c((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            b((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ all -> 0x0089 }
            com.mbridge.msdk.e.y.a((android.database.Cursor) r15)     // Catch:{ all -> 0x0089 }
            goto L_0x0080
        L_0x0054:
            r0 = move-exception
            r3 = r15
            goto L_0x0082
        L_0x0057:
            r4 = move-exception
            r13 = r3
            r3 = r15
            r15 = r13
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            goto L_0x0082
        L_0x005e:
            r4 = move-exception
            r15 = r3
        L_0x0060:
            boolean r5 = com.mbridge.msdk.e.a.a     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x0079
            java.lang.String r5 = "TrackManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r6.<init>(r0)     // Catch:{ all -> 0x005c }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x005c }
            r6.append(r0)     // Catch:{ all -> 0x005c }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x005c }
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x005c }
        L_0x0079:
            b((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ all -> 0x0089 }
            com.mbridge.msdk.e.y.a((android.database.Cursor) r3)     // Catch:{ all -> 0x0089 }
            r3 = r15
        L_0x0080:
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            return r3
        L_0x0082:
            b((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ all -> 0x0089 }
            com.mbridge.msdk.e.y.a((android.database.Cursor) r3)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r15 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.c.a(int):java.util.List");
    }

    public final int a() {
        synchronized (this.c) {
            int i = 0;
            if (y.a((Object) this.a)) {
                return 0;
            }
            SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            if (a(readableDatabase)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                d(readableDatabase);
                SQLiteDatabase sQLiteDatabase = readableDatabase;
                cursor = sQLiteDatabase.query(this.b, (String[]) null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, (String) null, (String) null, (String) null, (String) null);
                if (cursor != null && cursor.moveToNext()) {
                    i = Math.max(cursor.getCount(), 0);
                }
                c(readableDatabase);
                b(readableDatabase);
            } catch (Exception e) {
                try {
                    if (a.a) {
                        Log.e("TrackManager", "getAvailableCount: " + e.getMessage());
                    }
                    b(readableDatabase);
                } catch (Throwable th) {
                    b(readableDatabase);
                    y.a((Cursor) null);
                    throw th;
                }
            }
            y.a(cursor);
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.List<com.mbridge.msdk.e.i> r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.c
            monitor-enter(r0)
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0087 }
            boolean r1 = com.mbridge.msdk.e.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x0085
            boolean r1 = com.mbridge.msdk.e.y.a((java.util.List<?>) r8)     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0012
            goto L_0x0085
        L_0x0012:
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0087 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x0087 }
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0087 }
            if (r2 == 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0020:
            d(r1)     // Catch:{ Exception -> 0x005e }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x005e }
        L_0x0027:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x005e }
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r8.next()     // Catch:{ Exception -> 0x005e }
            com.mbridge.msdk.e.i r2 = (com.mbridge.msdk.e.i) r2     // Catch:{ Exception -> 0x005e }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x005e }
            r3.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "state"
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x005e }
            r3.put(r4, r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "uuid = ?"
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x005e }
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = r7.b     // Catch:{ Exception -> 0x005e }
            r1.update(r2, r3, r4, r5)     // Catch:{ Exception -> 0x005e }
            goto L_0x0027
        L_0x0055:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x005e }
        L_0x0058:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0087 }
            goto L_0x007f
        L_0x005c:
            r8 = move-exception
            goto L_0x0081
        L_0x005e:
            r8 = move-exception
            boolean r2 = com.mbridge.msdk.e.a.a     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0058
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r3.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "updateReportStateReporting: "
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x005c }
            r3.append(r8)     // Catch:{ all -> 0x005c }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x005c }
            android.util.Log.e(r2, r8)     // Catch:{ all -> 0x005c }
            goto L_0x0058
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0081:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0087 }
            throw r8     // Catch:{ all -> 0x0087 }
        L_0x0085:
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            goto L_0x008b
        L_0x008a:
            throw r8
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.c.a(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.List<com.mbridge.msdk.e.i> r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.c
            monitor-enter(r0)
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0088 }
            boolean r1 = com.mbridge.msdk.e.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0086
            boolean r1 = com.mbridge.msdk.e.y.a((java.util.List<?>) r8)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0012
            goto L_0x0086
        L_0x0012:
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0088 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x0088 }
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0020:
            d(r1)     // Catch:{ Exception -> 0x005f }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x005f }
        L_0x0027:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x005f }
            if (r2 == 0) goto L_0x0056
            java.lang.Object r2 = r8.next()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.e.i r2 = (com.mbridge.msdk.e.i) r2     // Catch:{ Exception -> 0x005f }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x005f }
            r3.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "state"
            r5 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x005f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "uuid = ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x005f }
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = r7.b     // Catch:{ Exception -> 0x005f }
            r1.update(r2, r3, r4, r5)     // Catch:{ Exception -> 0x005f }
            goto L_0x0027
        L_0x0056:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x005f }
        L_0x0059:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0088 }
            goto L_0x0080
        L_0x005d:
            r8 = move-exception
            goto L_0x0082
        L_0x005f:
            r8 = move-exception
            boolean r2 = com.mbridge.msdk.e.a.a     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0059
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r3.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "updateReportStateSuccess: "
            r3.append(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x005d }
            r3.append(r8)     // Catch:{ all -> 0x005d }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x005d }
            android.util.Log.e(r2, r8)     // Catch:{ all -> 0x005d }
            goto L_0x0059
        L_0x0080:
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0082:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0088 }
            throw r8     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0088:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x008b:
            throw r8
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.c.b(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.util.List<com.mbridge.msdk.e.i> r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.c
            monitor-enter(r0)
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0099 }
            boolean r1 = com.mbridge.msdk.e.y.a((java.lang.Object) r1)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0097
            boolean r1 = com.mbridge.msdk.e.y.a((java.util.List<?>) r8)     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0013
            goto L_0x0097
        L_0x0013:
            com.mbridge.msdk.e.b r1 = r7.a     // Catch:{ all -> 0x0099 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x0099 }
            boolean r2 = a((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0021
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0021:
            d(r1)     // Catch:{ Exception -> 0x0070 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0070 }
        L_0x0028:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x0070 }
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r8.next()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.e.i r2 = (com.mbridge.msdk.e.i) r2     // Catch:{ Exception -> 0x0070 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0070 }
            r3.<init>()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r4 = "state"
            int r5 = r2.e()     // Catch:{ Exception -> 0x0070 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0070 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r4 = "report_count"
            int r5 = r2.d()     // Catch:{ Exception -> 0x0070 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0070 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r4 = "uuid = ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0070 }
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x0070 }
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x0070 }
            java.lang.String r2 = r7.b     // Catch:{ Exception -> 0x0070 }
            r1.update(r2, r3, r4, r5)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0028
        L_0x0067:
            c((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ Exception -> 0x0070 }
        L_0x006a:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0099 }
            goto L_0x0091
        L_0x006e:
            r8 = move-exception
            goto L_0x0093
        L_0x0070:
            r8 = move-exception
            boolean r2 = com.mbridge.msdk.e.a.a     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x006a
            java.lang.String r2 = "TrackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r3.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = "updateReportStateFailed: "
            r3.append(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x006e }
            r3.append(r8)     // Catch:{ all -> 0x006e }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.e(r2, r8)     // Catch:{ all -> 0x006e }
            goto L_0x006a
        L_0x0091:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0093:
            b((android.database.sqlite.SQLiteDatabase) r1)     // Catch:{ all -> 0x0099 }
            throw r8     // Catch:{ all -> 0x0099 }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0099:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.c.c(java.util.List):void");
    }

    public final int b() {
        synchronized (this.c) {
            int i = -1;
            if (y.a((Object) this.a)) {
                return -1;
            }
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (a(writableDatabase)) {
                return -1;
            }
            try {
                d(writableDatabase);
                i = writableDatabase.delete(this.b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                c(writableDatabase);
            } catch (Exception e) {
                try {
                    if (a.a) {
                        Log.e("TrackManager", "deleteInvalidEvents: " + e.getMessage());
                    }
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            }
            b(writableDatabase);
            return i;
        }
    }

    public final void c() {
        synchronized (this.c) {
            if (!y.a((Object) this.a)) {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                if (!a(writableDatabase)) {
                    try {
                        d(writableDatabase);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", 3);
                        writableDatabase.update(this.b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                        c(writableDatabase);
                    } catch (Exception e) {
                        try {
                            if (a.a) {
                                Log.e("TrackManager", "updateReportStateForReporting: " + e.getMessage());
                            }
                        } catch (Throwable th) {
                            b(writableDatabase);
                            throw th;
                        }
                    }
                    b(writableDatabase);
                }
            }
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "endTransaction: ", e);
                }
            }
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "transactionSuccess: ", e);
                }
            }
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "beginTransaction: ", e);
                }
            }
        }
    }
}
