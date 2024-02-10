package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;

/* compiled from: LoadTimeDao */
public final class l extends a<h> {
    private static l a;

    private l(g gVar) {
        super(gVar);
    }

    public static synchronized l a(g gVar) {
        l lVar;
        synchronized (l.class) {
            if (a == null) {
                a = new l(gVar);
            }
            lVar = a;
        }
        return lVar;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r1 == 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r1 != 0) goto L_0x001b;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x002f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from load_stat"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0021 }
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch:{ Exception -> 0x0021 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0019
            int r0 = r1.getInt(r0)     // Catch:{ Exception -> 0x0021 }
        L_0x0019:
            if (r1 == 0) goto L_0x0028
        L_0x001b:
            r1.close()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0028
        L_0x001f:
            r0 = move-exception
            goto L_0x002a
        L_0x0021:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0028
            goto L_0x001b
        L_0x0028:
            monitor-exit(r4)
            return r0
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            throw r0     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x0034
        L_0x0033:
            throw r0
        L_0x0034:
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a():int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.List<com.mbridge.msdk.foundation.entity.h>] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:31|(2:45|46)|47|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d9, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00dc, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ee A[SYNTHETIC, Splitter:B:37:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f6 A[SYNTHETIC, Splitter:B:45:0x00f6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.h> a(int r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "select * from load_stat LIMIT "
            monitor-enter(r16)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r2.<init>(r1)     // Catch:{ all -> 0x00fa }
            r2.append(r0)     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00fa }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r16.getReadableDatabase()     // Catch:{ Exception -> 0x00e7 }
            android.database.Cursor r1 = r3.rawQuery(r1, r2)     // Catch:{ Exception -> 0x00e7 }
            if (r1 == 0) goto L_0x00df
            int r3 = r1.getCount()     // Catch:{ Exception -> 0x00db, all -> 0x00d8 }
            if (r3 <= 0) goto L_0x00df
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00db, all -> 0x00d8 }
            r3.<init>()     // Catch:{ Exception -> 0x00db, all -> 0x00d8 }
            r2 = 0
            r4 = 0
        L_0x0029:
            boolean r5 = r1.moveToNext()     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            if (r5 == 0) goto L_0x00d4
            if (r4 < r0) goto L_0x0033
            goto L_0x00d4
        L_0x0033:
            int r4 = r4 + 1
            java.lang.String r5 = "ad_source_id"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r7 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "time"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r8 = r1.getString(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "adNum"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r9 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "unitId"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r10 = r1.getString(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "fb"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r11 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "timeout"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r12 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "network_type"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r13 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "network_type_str"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r6 = "hb"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r14 = r1.getInt(r6)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            com.mbridge.msdk.foundation.entity.h r15 = new com.mbridge.msdk.foundation.entity.h     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r6 = r15
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r15.c((java.lang.String) r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r15.a((int) r14)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r3.add(r15)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = "id"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            int r5 = r1.getInt(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            android.database.sqlite.SQLiteDatabase r6 = r16.getWritableDatabase()     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            if (r6 == 0) goto L_0x0029
            android.database.sqlite.SQLiteDatabase r6 = r16.getWritableDatabase()     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r7 = "load_stat"
            java.lang.String r8 = "id = ?"
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r10.<init>()     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r10.append(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = ""
            r10.append(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            java.lang.String r5 = r10.toString()     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r9[r2] = r5     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            r6.delete(r7, r8, r9)     // Catch:{ Exception -> 0x00d6, all -> 0x00d8 }
            goto L_0x0029
        L_0x00d4:
            r2 = r3
            goto L_0x00df
        L_0x00d6:
            r0 = move-exception
            goto L_0x00dd
        L_0x00d8:
            r0 = move-exception
            r2 = r1
            goto L_0x00f4
        L_0x00db:
            r0 = move-exception
            r3 = r2
        L_0x00dd:
            r2 = r1
            goto L_0x00e9
        L_0x00df:
            if (r1 == 0) goto L_0x00f2
            r1.close()     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00f2
        L_0x00e5:
            r0 = move-exception
            goto L_0x00f4
        L_0x00e7:
            r0 = move-exception
            r3 = r2
        L_0x00e9:
            r0.printStackTrace()     // Catch:{ all -> 0x00e5 }
            if (r2 == 0) goto L_0x00f1
            r2.close()     // Catch:{ Exception -> 0x00f1 }
        L_0x00f1:
            r2 = r3
        L_0x00f2:
            monitor-exit(r16)
            return r2
        L_0x00f4:
            if (r2 == 0) goto L_0x00f9
            r2.close()     // Catch:{ Exception -> 0x00f9 }
        L_0x00f9:
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r16)
            goto L_0x00fe
        L_0x00fd:
            throw r0
        L_0x00fe:
            goto L_0x00fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a(int):java.util.List");
    }

    public final synchronized void a(h hVar) {
        if (getWritableDatabase() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", hVar.c());
            contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(hVar.b()));
            contentValues.put("adNum", Integer.valueOf(hVar.d()));
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, hVar.e());
            contentValues.put("fb", Integer.valueOf(hVar.f()));
            contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(hVar.a()));
            contentValues.put("timeout", Integer.valueOf(hVar.g()));
            contentValues.put("network_type", Integer.valueOf(hVar.h()));
            contentValues.put("network_type_str", hVar.i());
            getWritableDatabase().insert("load_stat", (String) null, contentValues);
        }
    }
}
