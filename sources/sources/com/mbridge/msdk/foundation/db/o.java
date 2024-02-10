package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;

/* compiled from: UnitIDDao */
public final class o extends a<h> {
    private static o a;

    private o(g gVar) {
        super(gVar);
    }

    public static synchronized o a(g gVar) {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o(gVar);
            }
            oVar = a;
        }
        return oVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List<com.mbridge.msdk.foundation.entity.i>] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|(0)|42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0072 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A[SYNTHETIC, Splitter:B:32:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006f A[SYNTHETIC, Splitter:B:40:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.i> a(int r6) {
        /*
            r5 = this;
            java.lang.String r0 = "select * from unit_id WHERE ad_type = "
            monitor-enter(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r1.<init>(r0)     // Catch:{ all -> 0x0073 }
            r1.append(r6)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0073 }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0060 }
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x0058
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            if (r2 <= 0) goto L_0x0058
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
        L_0x0029:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            if (r1 == 0) goto L_0x004d
            java.lang.String r1 = "placement_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            java.lang.String r3 = "unitId"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            com.mbridge.msdk.foundation.entity.i r4 = new com.mbridge.msdk.foundation.entity.i     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            r4.<init>(r1, r3, r6)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            r2.add(r4)     // Catch:{ Exception -> 0x004f, all -> 0x0051 }
            goto L_0x0029
        L_0x004d:
            r1 = r2
            goto L_0x0058
        L_0x004f:
            r6 = move-exception
            goto L_0x0056
        L_0x0051:
            r6 = move-exception
            r1 = r0
            goto L_0x006d
        L_0x0054:
            r6 = move-exception
            r2 = r1
        L_0x0056:
            r1 = r0
            goto L_0x0062
        L_0x0058:
            if (r0 == 0) goto L_0x006b
            r0.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006b
        L_0x005e:
            r6 = move-exception
            goto L_0x006d
        L_0x0060:
            r6 = move-exception
            r2 = r1
        L_0x0062:
            r6.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x006a
            r1.close()     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            r1 = r2
        L_0x006b:
            monitor-exit(r5)
            return r1
        L_0x006d:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            throw r6     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x0077
        L_0x0076:
            throw r6
        L_0x0077:
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.o.a(int):java.util.List");
    }

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i) {
        if (getWritableDatabase() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, str);
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
            contentValues.put("ad_type", Integer.valueOf(i));
            getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, (String) null, contentValues);
        }
    }
}
