package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONObject;

/* compiled from: ReplaceTempDao */
public final class m extends a {
    private static String a = "ReplaceTempDao";
    private static m b;

    private m(g gVar) {
        super(gVar);
    }

    public static m a(g gVar) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new m(gVar);
                }
            }
        }
        return b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r4 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r4 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "SELECT * FROM c_replace_temp WHERE d_key = '"
            r0.<init>(r2)
            r0.append(r4)
            java.lang.String r4 = "'"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            android.database.sqlite.SQLiteDatabase r0 = r3.getReadableDatabase()
            android.database.Cursor r4 = r0.rawQuery(r4, r1)
            if (r4 == 0) goto L_0x004a
            int r0 = r4.getCount()     // Catch:{ all -> 0x0048 }
            if (r0 <= 0) goto L_0x004a
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0048 }
            r0.<init>()     // Catch:{ all -> 0x0048 }
            r1 = r0
        L_0x0031:
            boolean r0 = r4.moveToNext()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "d_value"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0048 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0048 }
            r2.<init>(r0)     // Catch:{ all -> 0x0048 }
            r1 = r2
            goto L_0x0031
        L_0x0048:
            r0 = move-exception
            goto L_0x0050
        L_0x004a:
            if (r4 == 0) goto L_0x0066
            r4.close()     // Catch:{ all -> 0x0048 }
            goto L_0x0066
        L_0x0050:
            java.lang.String r2 = a     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005f }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r0)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x0069
        L_0x005b:
            r4.close()
            goto L_0x0069
        L_0x005f:
            r0 = move-exception
            if (r4 == 0) goto L_0x0065
            r4.close()
        L_0x0065:
            throw r0
        L_0x0066:
            if (r4 == 0) goto L_0x0069
            goto L_0x005b
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a(java.lang.String):org.json.JSONObject");
    }

    public final void a(String str, JSONObject jSONObject) {
        boolean z;
        try {
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("d_key", str);
                contentValues.put("d_value", jSONObject.toString());
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                Cursor rawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key='" + str + "'", (String[]) null);
                if (rawQuery == null || rawQuery.getCount() <= 0) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    z = false;
                } else {
                    rawQuery.close();
                    z = true;
                }
                if (!z) {
                    getWritableDatabase().insert("c_replace_temp", (String) null, contentValues);
                    return;
                }
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = '" + str + "'", (String[]) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a() {
        /*
            r7 = this;
            r0 = 604800000(0x240c8400, float:3.046947E-17)
            long r0 = (long) r0
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            android.database.sqlite.SQLiteDatabase r0 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x0027 }
            if (r0 != 0) goto L_0x0010
            goto L_0x002b
        L_0x0010:
            android.database.sqlite.SQLiteDatabase r0 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r1 = "c_replace_temp"
            java.lang.String r4 = "time<?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0027 }
            r3 = 0
            r5[r3] = r2     // Catch:{ Exception -> 0x0027 }
            r0.delete(r1, r4, r5)     // Catch:{ Exception -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002b:
            java.lang.String r0 = "SELECT * FROM c_replace_temp"
            android.database.sqlite.SQLiteDatabase r1 = r7.getReadableDatabase()
            r2 = 0
            android.database.Cursor r0 = r1.rawQuery(r0, r2)
            if (r0 == 0) goto L_0x006f
            int r1 = r0.getCount()     // Catch:{ all -> 0x006a }
            if (r1 <= 0) goto L_0x006f
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r1.<init>()     // Catch:{ all -> 0x006a }
        L_0x0043:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = "d_key"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "d_value"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0068 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0068 }
            r4.<init>(r3)     // Catch:{ all -> 0x0068 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0068 }
            goto L_0x0043
        L_0x0066:
            r2 = r1
            goto L_0x008b
        L_0x0068:
            r2 = move-exception
            goto L_0x0075
        L_0x006a:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0075
        L_0x006f:
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ all -> 0x006a }
            goto L_0x008b
        L_0x0075:
            java.lang.String r3 = a     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0084 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r2)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0091
            r0.close()
            goto L_0x0091
        L_0x0084:
            r1 = move-exception
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            throw r1
        L_0x008b:
            if (r0 == 0) goto L_0x0090
            r0.close()
        L_0x0090:
            r1 = r2
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a():org.json.JSONObject");
    }
}
