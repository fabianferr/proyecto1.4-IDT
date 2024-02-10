package com.mbridge.msdk.foundation.db;

import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: CampaignClickDao */
public class d extends a<JumpLoaderResult> {
    public static final String a = "d";
    private static d b;

    private d(g gVar) {
        super(gVar);
    }

    public static synchronized d a(g gVar) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(gVar);
            }
            dVar = b;
        }
        return dVar;
    }

    public final synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", (String[]) null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d8, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(com.mbridge.msdk.foundation.entity.CampaignEx r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = " AND unitid = "
            java.lang.String r1 = "id = "
            monitor-enter(r9)
            if (r10 != 0) goto L_0x000b
            monitor-exit(r9)
            r10 = 0
            return r10
        L_0x000b:
            r2 = -1
            com.mbridge.msdk.click.entity.JumpLoaderResult r4 = r10.getJumpResult()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.ag.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.<init>()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r6 = "id"
            java.lang.String r7 = r10.getId()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r6 = "unitid"
            r5.put(r6, r11)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r6 = "result"
            r5.put(r6, r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r4 = "cti"
            int r6 = r10.getClickInterval()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            int r6 = r6 * 1000
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r4, r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r4 = "package_name"
            java.lang.String r6 = r10.getPackageName()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r4, r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            com.mbridge.msdk.c.f r4 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r6 = r6.h()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            com.mbridge.msdk.c.e r4 = r4.b(r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r6 = "ts"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            if (r4 == 0) goto L_0x007b
            int r6 = r4.ab()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            if (r6 <= 0) goto L_0x007b
            java.lang.String r6 = "cpei"
            int r7 = r4.ab()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            int r7 = r7 * 1000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
        L_0x007b:
            if (r4 == 0) goto L_0x0092
            int r6 = r4.ac()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            if (r6 <= 0) goto L_0x0092
            java.lang.String r6 = "cpoci"
            int r4 = r4.ac()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            int r4 = r4 * 1000
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
        L_0x0092:
            java.lang.String r4 = r10.getId()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            boolean r4 = r9.c(r4, r11)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r6 = 0
            if (r4 == 0) goto L_0x00c8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r4.append(r10)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            r4.append(r11)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            android.database.sqlite.SQLiteDatabase r11 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            if (r11 != 0) goto L_0x00bb
            monitor-exit(r9)
            return r2
        L_0x00bb:
            android.database.sqlite.SQLiteDatabase r11 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r0 = "campaignclick"
            int r10 = r11.update(r0, r5, r10, r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            long r10 = (long) r10
            monitor-exit(r9)
            return r10
        L_0x00c8:
            android.database.sqlite.SQLiteDatabase r10 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            java.lang.String r11 = "campaignclick"
            long r10 = r10.insert(r11, r6, r5)     // Catch:{ Exception -> 0x00d7, all -> 0x00d4 }
            monitor-exit(r9)
            return r10
        L_0x00d4:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x00d7:
            monitor-exit(r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.a(com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "' AND cti + ts > "
            java.lang.String r1 = "' AND unitid='"
            java.lang.String r2 = "SELECT id FROM campaignclick WHERE id='"
            monitor-enter(r5)
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0044 }
            r4.append(r6)     // Catch:{ Exception -> 0x0044 }
            r4.append(r1)     // Catch:{ Exception -> 0x0044 }
            r4.append(r7)     // Catch:{ Exception -> 0x0044 }
            r4.append(r0)     // Catch:{ Exception -> 0x0044 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0044 }
            r4.append(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r7 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0044 }
            r0 = 0
            android.database.Cursor r6 = r7.rawQuery(r6, r0)     // Catch:{ Exception -> 0x0044 }
            if (r6 == 0) goto L_0x003b
            int r7 = r6.getCount()     // Catch:{ Exception -> 0x0044 }
            if (r7 <= 0) goto L_0x003b
            r6.close()     // Catch:{ Exception -> 0x0044 }
            monitor-exit(r5)
            r6 = 1
            return r6
        L_0x003b:
            if (r6 == 0) goto L_0x0040
            r6.close()     // Catch:{ Exception -> 0x0044 }
        L_0x0040:
            monitor-exit(r5)
            return r3
        L_0x0042:
            r6 = move-exception
            goto L_0x0050
        L_0x0044:
            r6 = move-exception
            java.lang.String r7 = a     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0042 }
            com.mbridge.msdk.foundation.tools.aa.d(r7, r6)     // Catch:{ all -> 0x0042 }
            monitor-exit(r5)
            return r3
        L_0x0050:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r11 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r11 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[SYNTHETIC, Splitter:B:33:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.mbridge.msdk.click.entity.JumpLoaderResult b(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.lang.String r2 = "campaignclick"
            r3 = 0
            java.lang.String r4 = "id=? AND unitid=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            r6 = 0
            r5[r6] = r11     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            r11 = 1
            r5[r11] = r12     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            if (r11 == 0) goto L_0x0049
            int r12 = r11.getCount()     // Catch:{ Exception -> 0x0047 }
            if (r12 <= 0) goto L_0x0049
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0047 }
            if (r12 == 0) goto L_0x0049
            java.lang.String r12 = "result"
            int r12 = r11.getColumnIndex(r12)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0047 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x0049
            java.lang.Object r12 = com.mbridge.msdk.foundation.tools.ag.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0047 }
            com.mbridge.msdk.click.entity.JumpLoaderResult r12 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r12     // Catch:{ Exception -> 0x0047 }
            if (r11 == 0) goto L_0x0045
            r11.close()     // Catch:{ all -> 0x0063 }
        L_0x0045:
            monitor-exit(r10)
            return r12
        L_0x0047:
            r12 = move-exception
            goto L_0x0053
        L_0x0049:
            if (r11 == 0) goto L_0x0059
        L_0x004b:
            r11.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0059
        L_0x004f:
            r12 = move-exception
            goto L_0x005d
        L_0x0051:
            r12 = move-exception
            r11 = r0
        L_0x0053:
            r12.printStackTrace()     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0059
            goto L_0x004b
        L_0x0059:
            monitor-exit(r10)
            return r0
        L_0x005b:
            r12 = move-exception
            r0 = r11
        L_0x005d:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ all -> 0x0063 }
        L_0x0062:
            throw r12     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0067
        L_0x0066:
            throw r11
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.b(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "' AND unitid= '"
            java.lang.String r1 = "SELECT id FROM campaignclick WHERE id='"
            monitor-enter(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r2.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.append(r4)     // Catch:{ all -> 0x003b }
            r2.append(r0)     // Catch:{ all -> 0x003b }
            r2.append(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "'"
            r2.append(r4)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x003b }
            android.database.sqlite.SQLiteDatabase r5 = r3.getReadableDatabase()     // Catch:{ all -> 0x003b }
            r0 = 0
            android.database.Cursor r4 = r5.rawQuery(r4, r0)     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0033
            int r5 = r4.getCount()     // Catch:{ all -> 0x003b }
            if (r5 <= 0) goto L_0x0033
            r4.close()     // Catch:{ all -> 0x003b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0033:
            if (r4 == 0) goto L_0x0038
            r4.close()     // Catch:{ all -> 0x003b }
        L_0x0038:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x003b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.c(java.lang.String, java.lang.String):boolean");
    }
}
