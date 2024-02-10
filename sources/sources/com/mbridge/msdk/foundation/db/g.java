package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: CommonAbsDBHelper */
public abstract class g {
    private a a;

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase);

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void b(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public abstract int d();

    public g(Context context) {
        this.a = new a(context, c(), d());
    }

    public final SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r0 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.database.sqlite.SQLiteDatabase b() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.mbridge.msdk.foundation.db.g$a r0 = r1.a     // Catch:{ Exception -> 0x000b, all -> 0x0008 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x000b, all -> 0x0008 }
            goto L_0x000c
        L_0x0008:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x000b:
            r0 = 0
        L_0x000c:
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.g.b():android.database.sqlite.SQLiteDatabase");
    }

    /* compiled from: CommonAbsDBHelper */
    private class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            if (MBridgeConstans.DEBUG) {
                aa.a("DatabaseOpenHelper", "数据库： name :" + str + "  " + i);
            }
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                aa.a("DatabaseOpenHelper", "数据库创建了");
            }
            g.this.a(sQLiteDatabase);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (MBridgeConstans.DEBUG) {
                aa.a("DatabaseOpenHelper", "数据库升级了");
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !sQLiteDatabase.isReadOnly()) {
                try {
                    g.this.a(sQLiteDatabase, i, i2);
                } catch (Exception unused) {
                }
            }
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            g.this.b(sQLiteDatabase, i, i2);
        }
    }
}
