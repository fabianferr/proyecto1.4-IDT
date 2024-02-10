package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.b.h;
import com.bytedance.sdk.openadsdk.b.m;
import com.bytedance.sdk.openadsdk.b.n;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DBHelper */
class f {
    /* access modifiers changed from: private */
    public static final Object c = new Object();
    private c a;
    /* access modifiers changed from: private */
    public Context b;

    f(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = o.a();
            } catch (Throwable unused) {
                return;
            }
        } else {
            context2 = context.getApplicationContext();
        }
        this.b = context2;
        if (this.a == null) {
            this.a = new c();
        }
    }

    /* access modifiers changed from: private */
    public Context c() {
        Context context = this.b;
        return context == null ? o.a() : context;
    }

    /* compiled from: DBHelper */
    public class c {
        private SQLiteDatabase b = null;

        public c() {
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        private synchronized void e() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.Object r0 = com.bytedance.sdk.openadsdk.core.f.c     // Catch:{ all -> 0x002a }
                monitor-enter(r0)     // Catch:{ all -> 0x002a }
                android.database.sqlite.SQLiteDatabase r1 = r4.b     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0010
                boolean r1 = r1.isOpen()     // Catch:{ all -> 0x0027 }
                if (r1 != 0) goto L_0x0025
            L_0x0010:
                com.bytedance.sdk.openadsdk.core.f$a r1 = new com.bytedance.sdk.openadsdk.core.f$a     // Catch:{ all -> 0x0027 }
                com.bytedance.sdk.openadsdk.core.f r2 = com.bytedance.sdk.openadsdk.core.f.this     // Catch:{ all -> 0x0027 }
                android.content.Context r3 = r2.c()     // Catch:{ all -> 0x0027 }
                r1.<init>(r3)     // Catch:{ all -> 0x0027 }
                android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x0027 }
                r4.b = r1     // Catch:{ all -> 0x0027 }
                r2 = 0
                r1.setLockingEnabled(r2)     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                goto L_0x003a
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1     // Catch:{ all -> 0x002a }
            L_0x002a:
                r0 = move-exception
                java.lang.String r1 = "DBHelper"
                java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x003d }
                com.bytedance.sdk.component.utils.l.e(r1, r2)     // Catch:{ all -> 0x003d }
                boolean r1 = r4.f()     // Catch:{ all -> 0x003d }
                if (r1 != 0) goto L_0x003c
            L_0x003a:
                monitor-exit(r4)
                return
            L_0x003c:
                throw r0     // Catch:{ all -> 0x003d }
            L_0x003d:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.c.e():void");
        }

        public SQLiteDatabase a() {
            e();
            return this.b;
        }

        public synchronized void a(String str) throws SQLException {
            try {
                e();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (f()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                e();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                l.e("DBHelper", th.getMessage());
                b bVar = new b();
                if (!f()) {
                    cursor = bVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                e();
                i = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                l.e("DBHelper", e.getMessage());
                if (!f()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                e();
                j = this.b.replace(str, str2, contentValues);
            } catch (Exception e) {
                l.e("DBHelper", e.getMessage());
                if (!f()) {
                    j = -1;
                } else {
                    throw e;
                }
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i;
            try {
                e();
                i = this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                l.e("DBHelper", e.getMessage());
                if (!f()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized void b() {
            e();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
            }
        }

        public synchronized void c() {
            e();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.setTransactionSuccessful();
            }
        }

        public synchronized void d() {
            e();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }

        private synchronized boolean f() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    /* compiled from: DBHelper */
    private class a extends SQLiteOpenHelper {
        final Context a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.a = context;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable th) {
                l.e("DBHelper", th.getMessage());
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            l.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(d.a());
            sQLiteDatabase.execSQL(h.c());
            sQLiteDatabase.execSQL(n.a());
            sQLiteDatabase.execSQL(m.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.n.b.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.a.b.a.c());
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.b);
                    l.b("DBHelper", "onUpgrade...Reverse installation. Database reset and create table.....");
                } catch (Throwable th) {
                    l.d(th.getMessage());
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                l.b("DBHelper", "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.b);
                    l.b("DBHelper", "onUpgrade...Reverse installation. Database reset and create table.....");
                } else {
                    a(sQLiteDatabase, f.this.b);
                }
                switch (i) {
                    case 1:
                        l.b("DBHelper", "onUpgrade.....perform table creation.....");
                        a(sQLiteDatabase);
                        return;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        a(sQLiteDatabase);
                        return;
                    case 3:
                        sQLiteDatabase.execSQL(n.a());
                        a(sQLiteDatabase);
                        return;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.a.b.a.c());
                        a(sQLiteDatabase);
                        return;
                    case 5:
                        sQLiteDatabase.execSQL(m.a());
                        a(sQLiteDatabase);
                        return;
                    case 6:
                        a(sQLiteDatabase);
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(d.b());
            sQLiteDatabase.execSQL(h.d());
            sQLiteDatabase.execSQL(n.b());
            sQLiteDatabase.execSQL(m.b());
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> c = c(sQLiteDatabase);
            if (c != null && c.size() > 0) {
                Iterator<String> it = c.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", new Object[]{it.next()}));
                }
            }
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
            if (r1 != 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (r1 == 0) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.util.ArrayList<java.lang.String> c(android.database.sqlite.SQLiteDatabase r4) {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "select name from sqlite_master where type='table' order by name"
                android.database.Cursor r1 = r4.rawQuery(r2, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                if (r1 == 0) goto L_0x002d
            L_0x000e:
                boolean r4 = r1.moveToNext()     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                if (r4 == 0) goto L_0x002d
                r4 = 0
                java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                java.lang.String r2 = "android_metadata"
                boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                if (r2 != 0) goto L_0x000e
                java.lang.String r2 = "sqlite_sequence"
                boolean r2 = r4.equals(r2)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                if (r2 != 0) goto L_0x000e
                r0.add(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0030 }
                goto L_0x000e
            L_0x002d:
                if (r1 == 0) goto L_0x003d
                goto L_0x003a
            L_0x0030:
                r4 = move-exception
                if (r1 == 0) goto L_0x0036
                r1.close()
            L_0x0036:
                throw r4
            L_0x0037:
                if (r1 == 0) goto L_0x003d
            L_0x003a:
                r1.close()
            L_0x003d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.a.c(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
        }
    }

    public c a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class b extends AbstractCursor {
        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int i) {
            return 0.0d;
        }

        public float getFloat(int i) {
            return 0.0f;
        }

        public int getInt(int i) {
            return 0;
        }

        public long getLong(int i) {
            return 0;
        }

        public short getShort(int i) {
            return 0;
        }

        public String getString(int i) {
            return null;
        }

        public boolean isNull(int i) {
            return true;
        }

        private b() {
        }
    }
}
