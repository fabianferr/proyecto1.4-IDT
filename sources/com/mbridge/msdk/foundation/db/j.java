package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.f;

/* compiled from: FqInfoDao */
public final class j extends a<f> {
    private static j a;

    private j(g gVar) {
        super(gVar);
    }

    public static synchronized j a(g gVar) {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j(gVar);
            }
            jVar = a;
        }
        return jVar;
    }

    public final synchronized void a(f fVar) {
        try {
            if (getWritableDatabase() != null) {
                if (fVar != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", fVar.a());
                    contentValues.put("time", Long.valueOf(fVar.d()));
                    contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, fVar.b());
                    contentValues.put("type", Integer.valueOf(fVar.c()));
                    if (a(fVar.b(), fVar.a())) {
                        getWritableDatabase().update("fq_info", contentValues, "id = " + fVar.a() + " AND unitId = " + fVar.b(), (String[]) null);
                    } else {
                        getWritableDatabase().insert("fq_info", (String) null, contentValues);
                    }
                }
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "' and id='"
            java.lang.String r1 = "select id from fq_info where unitId='"
            monitor-enter(r4)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d }
            r3.<init>(r1)     // Catch:{ Exception -> 0x003d }
            r3.append(r5)     // Catch:{ Exception -> 0x003d }
            r3.append(r0)     // Catch:{ Exception -> 0x003d }
            r3.append(r6)     // Catch:{ Exception -> 0x003d }
            java.lang.String r5 = "'"
            r3.append(r5)     // Catch:{ Exception -> 0x003d }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x003d }
            android.database.sqlite.SQLiteDatabase r6 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x003d }
            r0 = 0
            android.database.Cursor r5 = r6.rawQuery(r5, r0)     // Catch:{ Exception -> 0x003d }
            if (r5 == 0) goto L_0x0034
            int r6 = r5.getCount()     // Catch:{ Exception -> 0x003d }
            if (r6 <= 0) goto L_0x0034
            r5.close()     // Catch:{ Exception -> 0x003d }
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ Exception -> 0x003d }
        L_0x0039:
            monitor-exit(r4)
            return r2
        L_0x003b:
            r5 = move-exception
            goto L_0x0043
        L_0x003d:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x003b }
            monitor-exit(r4)
            return r2
        L_0x0043:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.j.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = " and unitId=?"
            java.lang.String r1 = "time<"
            monitor-enter(r6)
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r2 - r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r4.append(r2)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r4.append(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r2 = 0
            r1[r2] = r7     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            if (r7 == 0) goto L_0x0036
            android.database.sqlite.SQLiteDatabase r7 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            java.lang.String r2 = "fq_info"
            r7.delete(r2, r0, r1)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            goto L_0x0036
        L_0x0033:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0036:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.j.a(java.lang.String):void");
    }
}
