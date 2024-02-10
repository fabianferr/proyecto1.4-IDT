package com.mbridge.msdk.e;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.List;

/* compiled from: Utils */
final class y {
    public static long a(int i, long j, long j2) {
        if (i <= 0 || j == 0 || i <= 10) {
            return j2;
        }
        if (i <= 20) {
            return 60000;
        }
        if (i <= 30) {
            return 120000;
        }
        if (i <= 40) {
            return 180000;
        }
        return i <= 50 ? 240000 : 300000;
    }

    static boolean a(Object obj) {
        return obj == null;
    }

    static boolean b(Object obj) {
        return obj != null;
    }

    static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    static boolean b(List<i> list) {
        if (a((List<?>) list)) {
            return false;
        }
        for (i next : list) {
            if (!a((Object) next)) {
                e c = next.c();
                if (!a((Object) c) && c.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static void a(Cursor cursor) {
        boolean z = false;
        try {
            if (b((Object) cursor) && !cursor.isClosed()) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (z) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00de A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<com.mbridge.msdk.e.i> b(android.database.Cursor r18) {
        /*
            r1 = r18
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r0 = "name"
            int r3 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "type"
            int r4 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "time_stamp"
            int r5 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "properties"
            int r6 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "priority"
            int r7 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "uuid"
            int r8 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "duration"
            int r9 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "state"
            int r10 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "report_count"
            int r11 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "ignore_max_timeout"
            int r12 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "ignore_max_retry_times"
            int r13 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "invalid_time"
            int r14 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e4 }
        L_0x0053:
            boolean r0 = r18.moveToNext()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r1.getString(r3)     // Catch:{ JSONException -> 0x00ce }
            com.mbridge.msdk.e.e r15 = new com.mbridge.msdk.e.e     // Catch:{ JSONException -> 0x00ce }
            r15.<init>(r0)     // Catch:{ JSONException -> 0x00ce }
            int r0 = r1.getInt(r4)     // Catch:{ JSONException -> 0x00ce }
            r15.a((int) r0)     // Catch:{ JSONException -> 0x00ce }
            r16 = r3
            r17 = r4
            long r3 = r1.getLong(r5)     // Catch:{ JSONException -> 0x00cc }
            r15.a((long) r3)     // Catch:{ JSONException -> 0x00cc }
            java.lang.String r0 = r1.getString(r6)     // Catch:{ JSONException -> 0x00cc }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cc }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x00cc }
            r15.a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x00cc }
            int r0 = r1.getInt(r7)     // Catch:{ JSONException -> 0x00cc }
            r15.b((int) r0)     // Catch:{ JSONException -> 0x00cc }
            java.lang.String r0 = r1.getString(r8)     // Catch:{ JSONException -> 0x00cc }
            r15.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x00cc }
            long r3 = r1.getLong(r9)     // Catch:{ JSONException -> 0x00cc }
            r15.b((long) r3)     // Catch:{ JSONException -> 0x00cc }
            com.mbridge.msdk.e.i r0 = new com.mbridge.msdk.e.i     // Catch:{ JSONException -> 0x00cc }
            r0.<init>(r15)     // Catch:{ JSONException -> 0x00cc }
            int r3 = r1.getInt(r10)     // Catch:{ JSONException -> 0x00cc }
            r0.b((int) r3)     // Catch:{ JSONException -> 0x00cc }
            int r3 = r1.getInt(r11)     // Catch:{ JSONException -> 0x00cc }
            r0.a((int) r3)     // Catch:{ JSONException -> 0x00cc }
            int r3 = r1.getInt(r12)     // Catch:{ JSONException -> 0x00cc }
            r4 = 1
            r15 = 0
            if (r3 != 0) goto L_0x00b2
            r3 = 1
            goto L_0x00b3
        L_0x00b2:
            r3 = 0
        L_0x00b3:
            r0.a((boolean) r3)     // Catch:{ JSONException -> 0x00cc }
            int r3 = r1.getInt(r13)     // Catch:{ JSONException -> 0x00cc }
            if (r3 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r4 = 0
        L_0x00be:
            r0.b((boolean) r4)     // Catch:{ JSONException -> 0x00cc }
            long r3 = r1.getLong(r14)     // Catch:{ JSONException -> 0x00cc }
            r0.a((long) r3)     // Catch:{ JSONException -> 0x00cc }
            r2.add(r0)     // Catch:{ JSONException -> 0x00cc }
            goto L_0x00de
        L_0x00cc:
            r0 = move-exception
            goto L_0x00d3
        L_0x00ce:
            r0 = move-exception
            r16 = r3
            r17 = r4
        L_0x00d3:
            boolean r3 = com.mbridge.msdk.e.a.a
            if (r3 == 0) goto L_0x00de
            java.lang.String r3 = "TrackManager"
            java.lang.String r4 = "create: "
            android.util.Log.e(r3, r4, r0)
        L_0x00de:
            r3 = r16
            r4 = r17
            goto L_0x0053
        L_0x00e4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.y.b(android.database.Cursor):java.util.List");
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return true;
        }
        NetworkInfo networkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            Log.d("TrackManager", e.getLocalizedMessage());
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return true;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            Log.d("TrackManager", e2.getLocalizedMessage());
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
