package com.mbridge.msdk.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* compiled from: Database */
final class b extends SQLiteOpenHelper {
    private final String a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = str2;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.a, new Object[]{this.a}));
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "create table error", e);
                }
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.b, new Object[]{this.a}));
                sQLiteDatabase.execSQL(String.format(i.a, new Object[]{this.a}));
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "upgrade table error", e);
                }
            }
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.b, new Object[]{this.a}));
                sQLiteDatabase.execSQL(String.format(i.a, new Object[]{this.a}));
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "downgrade table error", e);
                }
            }
        }
    }
}
