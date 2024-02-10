package com.startapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONTokener;

/* compiled from: Sta */
public class l3 extends y1 {
    public static final String[] d = {"rowid", CampaignEx.JSON_KEY_TIMESTAMP, "sdkVersion", "category", "appActivity", "value", "details", "detailsJson", "dParam", NotificationCompat.CATEGORY_SERVICE, ViewHierarchyConstants.TAG_KEY};
    public final List<i2<Void>> c = new LinkedList();

    public l3(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final boolean a(i3 i3Var, m3 m3Var, SQLiteDatabase sQLiteDatabase, Map<String, String> map, long j) {
        i3 i3Var2 = i3Var;
        m3 m3Var2 = m3Var;
        Map<String, String> map2 = map;
        if (m3Var2.a.size() > 0 && !m3Var2.a.contains(i3Var2.d)) {
            return false;
        }
        if (m3Var2.b.size() > 0 && m3Var2.b.contains(i3Var2.d)) {
            return false;
        }
        if (m3Var2.c.size() > 0 && !m3Var2.c.contains(i3Var2.i)) {
            return false;
        }
        if (m3Var2.d.size() > 0 && m3Var2.d.contains(i3Var2.i)) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map2.containsKey("sdkVersion")) {
            linkedHashMap.put("sdkVersion", map2.get("sdkVersion"));
        }
        if (map2.containsKey("category")) {
            linkedHashMap.put("category", map2.get("category"));
        }
        for (String next : m3Var2.e) {
            if (map2.containsKey(next)) {
                linkedHashMap.put(next, map2.get(next));
            }
        }
        int size = linkedHashMap.size();
        if (size >= 1) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList(size);
            String str = "";
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                sb.append(str);
                sb.append((String) entry.getKey());
                if (entry.getValue() == null) {
                    sb.append(" IS NULL");
                } else {
                    sb.append(" = ?");
                    arrayList.add(entry.getValue());
                }
                str = " AND ";
            }
            Pair pair = new Pair(sb.toString(), arrayList.toArray(new String[0]));
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.query("events", new String[]{"sendSuccess"}, (String) pair.first, (String[]) pair.second, (String) null, (String) null, "sendSuccess DESC");
                if (cursor.moveToFirst()) {
                    long j2 = cursor.getLong(0);
                    if (j2 <= 0) {
                        return true;
                    }
                    long j3 = j - j2;
                    long j4 = m3Var2.f;
                    if (j4 > 0 && j3 < j4) {
                        a(cursor);
                        return true;
                    }
                }
                a(cursor);
                return false;
            } finally {
                a(cursor);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void b() {
        for (i2<Void> a : this.c) {
            a.a();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events ( timestamp INTEGER NOT NULL, validTill INTEGER NOT NULL, sdkVersion TEXT NOT NULL, category TEXT NOT NULL, appActivity TEXT, value TEXT, details TEXT, detailsJson TEXT, dParam TEXT, service INTEGER NOT NULL DEFAULT 0, tag TEXT, priority INTEGER NOT NULL, attempt INTEGER NOT NULL DEFAULT 0, send INTEGER NOT NULL DEFAULT 0, sendFailure INTEGER NOT NULL DEFAULT 0, sendSuccess INTEGER NOT NULL DEFAULT 0, CHECK (attempt >= 0), CHECK (send >= 0), CHECK (sendFailure >= 0), CHECK (sendSuccess >= 0));");
    }

    public static i3 b(Cursor cursor) {
        boolean z = false;
        long j = cursor.getLong(0);
        long j2 = cursor.getLong(1);
        a(j, j2);
        String string = cursor.getString(2);
        j3 a = j3.a(cursor.getString(3));
        String string2 = cursor.getString(4);
        String string3 = cursor.getString(5);
        String string4 = cursor.getString(6);
        String string5 = cursor.getString(7);
        String string6 = cursor.getString(8);
        if (cursor.getInt(9) == 1) {
            z = true;
        }
        String string7 = cursor.getString(10);
        if (string == null || string.trim().length() < 1) {
            throw new IllegalArgumentException();
        } else if (a != null) {
            Object obj = null;
            if (string5 != null) {
                try {
                    obj = new JSONTokener(string5).nextValue();
                } catch (JSONException unused) {
                }
            }
            i3 i3Var = new i3(a, j);
            i3Var.h = Long.valueOf(j2);
            i3Var.c = string;
            i3Var.i = string2;
            i3Var.d = string3;
            i3Var.e = string4;
            i3Var.f = obj;
            i3Var.g = string6;
            i3Var.j = z;
            i3Var.k = string7;
            return i3Var;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(g2<i3, Void> g2Var, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = a().query("events", d, "attempt < " + i + " AND validTill >= " + currentTimeMillis + " AND sendSuccess = 0  AND send <= sendFailure", (String[]) null, (String) null, (String) null, "priority DESC, timestamp ASC", String.valueOf(Math.max(1, i2)));
            while (cursor.moveToNext()) {
                g2Var.a(b(cursor));
            }
        } finally {
            a(cursor);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r14v1, types: [java.lang.String[], java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r14v4 */
    public boolean a(i3 i3Var, k3 k3Var) {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ? r14;
        String str7;
        String str8;
        i3 i3Var2 = i3Var;
        k3 k3Var2 = k3Var;
        SQLiteDatabase a = a();
        a.beginTransaction();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis + k3Var2.e;
            Long l = i3Var2.h;
            if (l != null) {
                j = l.longValue();
            } else {
                i3Var2.h = Long.valueOf(currentTimeMillis);
                j = currentTimeMillis;
            }
            Object obj = i3Var2.f;
            String obj2 = obj != null ? obj.toString() : null;
            String str9 = i3Var2.c;
            if (str9 == null) {
                str9 = "4.11.0";
            }
            String str10 = str9;
            List<m3> list = k3Var2.g;
            int size = list.size();
            String str11 = NotificationCompat.CATEGORY_SERVICE;
            String str12 = "dParam";
            String str13 = "detailsJson";
            long j3 = j2;
            String str14 = "details";
            String str15 = "value";
            long j4 = j;
            String str16 = "events";
            String str17 = "sdkVersion";
            if (size > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(str17, str10);
                String str18 = str10;
                hashMap.put("category", i3Var2.a.a);
                hashMap.put("appActivity", i3Var2.i);
                hashMap.put(str15, i3Var2.d);
                hashMap.put(str14, i3Var2.e);
                hashMap.put(str13, obj2);
                hashMap.put(str12, i3Var2.g);
                hashMap.put(str11, i3Var2.j ? "1" : "0");
                for (m3 a2 : list) {
                    HashMap hashMap2 = hashMap;
                    String str19 = str12;
                    String str20 = str11;
                    String str21 = str13;
                    String str22 = str18;
                    String str23 = obj2;
                    String str24 = str14;
                    String str25 = str15;
                    String str26 = str17;
                    if (a(i3Var, a2, a, hashMap2, currentTimeMillis)) {
                        a.endTransaction();
                        return false;
                    }
                    str17 = str26;
                    str14 = str24;
                    str15 = str25;
                    hashMap = hashMap2;
                    str12 = str19;
                    str11 = str20;
                    obj2 = str23;
                    str18 = str22;
                    str13 = str21;
                }
                str4 = str12;
                str2 = str11;
                str = obj2;
                str3 = str13;
                str6 = str14;
                str8 = str18;
                str7 = str17;
                str5 = str15;
                r14 = 0;
            } else {
                str4 = str12;
                str2 = str11;
                str = obj2;
                str3 = str13;
                str6 = str14;
                str5 = str15;
                r14 = 0;
                str8 = str10;
                str7 = str17;
            }
            String str27 = str16;
            a.delete(str27, "validTill < " + currentTimeMillis, r14);
            ContentValues contentValues = new ContentValues();
            contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j4));
            contentValues.put("validTill", Long.valueOf(j3));
            contentValues.put(str7, str8);
            contentValues.put("category", i3Var2.a.a);
            contentValues.put("appActivity", i3Var2.i);
            contentValues.put(str5, i3Var2.d);
            contentValues.put(str6, i3Var2.e);
            contentValues.put(str3, str);
            contentValues.put(str4, i3Var2.g);
            contentValues.put(str2, Integer.valueOf(i3Var2.j ? 1 : 0));
            contentValues.put(ViewHierarchyConstants.TAG_KEY, i3Var2.k);
            contentValues.put("priority", Integer.valueOf(k3Var.c));
            a.insertOrThrow(str27, r14, contentValues);
            a.setTransactionSuccessful();
            a.endTransaction();
            b();
            return true;
        } catch (Throwable th) {
            a.endTransaction();
            throw th;
        }
    }

    public static void a(long j, long j2) {
        if (j <= 0) {
            throw new IllegalArgumentException();
        } else if (j2 <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int a(SQLiteDatabase sQLiteDatabase, long j) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            cursor = sQLiteDatabase2.query("events", new String[]{"attempt"}, "rowid = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
            throw new IllegalStateException();
        } finally {
            a(cursor);
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }
}
