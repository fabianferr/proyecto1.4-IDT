package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.List;
import org.json.JSONArray;

/* compiled from: CacheCampaignDao */
public class c extends a {
    private static volatile c a = null;
    private static final String b = "com.mbridge.msdk.foundation.db.c";

    private c(g gVar) {
        super(gVar);
    }

    public static c a(g gVar) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(gVar);
                }
            }
        }
        return a;
    }

    public final long a(List<CampaignEx> list, String str) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    if (!TextUtils.isEmpty(str)) {
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx == null) {
                            return 0;
                        }
                        if (getWritableDatabase() == null) {
                            return -1;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("rid", campaignEx.getRequestId());
                        contentValues.put("lrid", campaignEx.getLocalRequestId());
                        contentValues.put("unitid", str);
                        JSONArray jSONArray = new JSONArray();
                        for (CampaignEx campaignToJsonObject : list) {
                            jSONArray.put(CampaignEx.campaignToJsonObject(campaignToJsonObject));
                        }
                        contentValues.put("campaigns", jSONArray.toString());
                        contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                        long plctb = campaignEx.getPlctb();
                        if (plctb == 0) {
                            e b2 = f.a().b(b.d().h());
                            if (b2 == null) {
                                b2 = f.a().b();
                            }
                            plctb = b2.Q();
                        }
                        try {
                            if (ac.a().a("c_e_t", false)) {
                                plctb *= 24;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        contentValues.put("interval_ts", Long.valueOf(plctb * 1000));
                        contentValues.put("ecppv", campaignEx.getEcppv());
                        contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                        contentValues.put("state", 0);
                        if (!c(campaignEx.getRequestId(), campaignEx.getLocalRequestId(), str)) {
                            return getWritableDatabase().insert("CacheCampaign", (String) null, contentValues);
                        }
                        return (long) getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + campaignEx.getRequestId() + "' AND " + "lrid" + "='" + campaignEx.getLocalRequestId() + "' AND " + "unitid" + " = '" + str + "' AND " + "state" + " = 1", (String[]) null);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    private synchronized boolean c(String str, String str2, String str3) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "'", (String[]) null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
        } else if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
        return true;
    }

    public final synchronized void a(String str, int i) {
        if (i <= 0) {
            i = 1;
        }
        try {
            String str2 = "unitid = " + str + " AND ( (ts + interval_ts) < " + System.currentTimeMillis() + " OR show_count >= " + i + " )";
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.execSQL("delete from CacheCampaign where " + str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CacheCampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            if (c(str2, str3, str)) {
                String str4 = "unitid = '" + str + "' AND rid = '" + str2 + "' AND lrid = '" + str3 + "'";
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.execSQL("delete from CacheCampaign where " + str4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fd, code lost:
        if (r7 != null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        if (r7 != null) goto L_0x00ff;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.b.b> b(java.lang.String r7, int r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " WHERE unitid = '"
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = "' AND state > "
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "SELECT * FROM CacheCampaign"
            r8.<init>(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r6.getReadableDatabase()     // Catch:{ all -> 0x0103 }
            android.database.Cursor r7 = r0.rawQuery(r7, r8)     // Catch:{ all -> 0x0103 }
            if (r7 == 0) goto L_0x00fd
            int r0 = r7.getCount()     // Catch:{ all -> 0x00fb }
            if (r0 <= 0) goto L_0x00fd
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00fb }
            r0.<init>()     // Catch:{ all -> 0x00fb }
        L_0x003a:
            boolean r1 = r7.moveToNext()     // Catch:{ all -> 0x00fb }
            if (r1 == 0) goto L_0x00f5
            com.mbridge.msdk.foundation.b.b r1 = new com.mbridge.msdk.foundation.b.b     // Catch:{ all -> 0x00fb }
            r1.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "campaigns"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x00fb }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ all -> 0x00fb }
            r3.<init>(r2)     // Catch:{ all -> 0x00fb }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x005f
            r7.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            return r8
        L_0x0060:
            int r2 = r3.length()     // Catch:{ all -> 0x00fb }
            if (r2 <= 0) goto L_0x0085
            java.util.concurrent.CopyOnWriteArrayList r2 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x00fb }
            r2.<init>()     // Catch:{ all -> 0x00fb }
            r4 = 0
        L_0x006c:
            int r5 = r3.length()     // Catch:{ all -> 0x00fb }
            if (r4 >= r5) goto L_0x0082
            java.lang.Object r5 = r3.get(r4)     // Catch:{ all -> 0x00fb }
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ all -> 0x00fb }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r5)     // Catch:{ all -> 0x00fb }
            r2.add(r5)     // Catch:{ all -> 0x00fb }
            int r4 = r4 + 1
            goto L_0x006c
        L_0x0082:
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x00fb }
        L_0x0085:
            java.lang.String r2 = "lrid"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x00fb }
            r1.b((java.lang.String) r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "rid"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x00fb }
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "unitid"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x00fb }
            r1.c(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "ecppv"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x00fb }
            r1.d(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "ts"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            long r2 = r7.getLong(r2)     // Catch:{ all -> 0x00fb }
            r1.b((long) r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "state"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            int r2 = r7.getInt(r2)     // Catch:{ all -> 0x00fb }
            r1.b((int) r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "show_count"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            int r2 = r7.getInt(r2)     // Catch:{ all -> 0x00fb }
            r1.a((int) r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r2 = "interval_ts"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x00fb }
            long r2 = r7.getLong(r2)     // Catch:{ all -> 0x00fb }
            r1.a((long) r2)     // Catch:{ all -> 0x00fb }
            r0.add(r1)     // Catch:{ all -> 0x00fb }
            goto L_0x003a
        L_0x00f5:
            if (r7 == 0) goto L_0x00fa
            r7.close()     // Catch:{ Exception -> 0x00fa }
        L_0x00fa:
            return r0
        L_0x00fb:
            r0 = move-exception
            goto L_0x0105
        L_0x00fd:
            if (r7 == 0) goto L_0x010b
        L_0x00ff:
            r7.close()     // Catch:{ Exception -> 0x010b }
            goto L_0x010b
        L_0x0103:
            r0 = move-exception
            r7 = r8
        L_0x0105:
            r0.printStackTrace()     // Catch:{ all -> 0x010c }
            if (r7 == 0) goto L_0x010b
            goto L_0x00ff
        L_0x010b:
            return r8
        L_0x010c:
            r8 = move-exception
            if (r7 == 0) goto L_0x0112
            r7.close()     // Catch:{ Exception -> 0x0112 }
        L_0x0112:
            goto L_0x0114
        L_0x0113:
            throw r8
        L_0x0114:
            goto L_0x0113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.c.b(java.lang.String, int):java.util.List");
    }

    public final long a(String str, String str2, String str3, int i) {
        if (!c(str, str2, str3)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        return (long) getWritableDatabase().update("CacheCampaign", contentValues, "rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "' AND state = 0", (String[]) null);
    }

    public final void b(String str, String str2, String str3) {
        if (c(str, str2, str3)) {
            getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1 WHERE " + ("rid='" + str + "' AND lrid='" + str2 + "' AND unitid = '" + str3 + "' AND state = 1"));
        }
    }
}
