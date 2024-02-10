package com.startapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: Sta */
public class x5 extends y1 {
    public static final String[] c = {"id"};

    public x5(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void a(String str, String str2, long j, long j2) {
        String str3 = str;
        String str4 = str2;
        SQLiteDatabase a = a();
        a.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            long a2 = a(a, "requests", str);
            if (a2 < 0) {
                contentValues.clear();
                contentValues.put("value", str);
                a2 = a.insert("requests", (String) null, contentValues);
            }
            long a3 = a(a, "statuses", str4);
            if (a3 < 0) {
                contentValues.clear();
                contentValues.put("value", str4);
                a3 = a.insert("statuses", (String) null, contentValues);
            }
            contentValues.clear();
            contentValues.put("requestId", Long.valueOf(a2));
            contentValues.put("statusId", Long.valueOf(a3));
            contentValues.put("timeMillis", Long.valueOf(j));
            contentValues.put("durationNanos", Long.valueOf(j2));
            a.insert("traces", (String) null, contentValues);
            a.setTransactionSuccessful();
        } finally {
            a.endTransaction();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statuses (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traces (requestId INTEGER NOT NULL,statusId INTEGER NOT NULL,timeMillis INTEGER NOT NULL,durationNanos INTEGER NOT NULL,FOREIGN KEY (requestId)REFERENCES requests (requestId)ON UPDATE CASCADE ON DELETE CASCADE,FOREIGN KEY (statusId)REFERENCES statuses (statusId)ON UPDATE CASCADE ON DELETE CASCADE,CHECK (timeMillis > 0),CHECK (durationNanos > 0));");
    }

    public static long a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor query = sQLiteDatabase.query(str, c, "value=?", new String[]{str2}, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getLong(0);
                }
            } finally {
                query.close();
            }
        }
        if (query == null) {
            return -1;
        }
        query.close();
        return -1;
    }
}
