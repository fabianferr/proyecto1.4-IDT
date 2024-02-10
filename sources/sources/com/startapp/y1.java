package com.startapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: Sta */
public abstract class y1 extends SQLiteOpenHelper {
    public volatile SQLiteDatabase a;
    public final Object b = new Object();

    public y1(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null) {
            synchronized (this.b) {
                sQLiteDatabase = this.a;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = getWritableDatabase();
                    this.a = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
