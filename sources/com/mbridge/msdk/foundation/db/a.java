package com.mbridge.msdk.foundation.db;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: BaseDao */
public class a<T> {
    protected g mHelper;

    public a(g gVar) {
        this.mHelper = gVar;
    }

    /* access modifiers changed from: protected */
    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mHelper.a();
    }

    /* access modifiers changed from: protected */
    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mHelper.b();
    }
}
