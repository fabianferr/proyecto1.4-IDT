package com.wortise.ads;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* compiled from: AdResultCacheDao_Impl */
public final class n implements m {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<l> b;
    /* access modifiers changed from: private */
    public final o c = new o();
    /* access modifiers changed from: private */
    public final f2 d = new f2();
    private final SharedSQLiteStatement e;
    private final SharedSQLiteStatement f;

    /* compiled from: AdResultCacheDao_Impl */
    class a extends EntityInsertionAdapter<l> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, l lVar) {
            if (lVar.b() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, lVar.b());
            }
            String a2 = n.this.c.a(lVar.a());
            if (a2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, a2);
            }
            Long a3 = n.this.d.a(lVar.d());
            if (a3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindLong(3, a3.longValue());
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `ad_result_cache` (`adUnitId`,`adResult`,`date`) VALUES (?,?,?)";
        }
    }

    /* compiled from: AdResultCacheDao_Impl */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM ad_result_cache";
        }
    }

    /* compiled from: AdResultCacheDao_Impl */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM ad_result_cache WHERE adUnitId = ?";
        }
    }

    public n(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.e = new b(roomDatabase);
        this.f = new c(roomDatabase);
    }

    public void a(l... lVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((T[]) lVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.wortise.ads.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Long} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wortise.ads.l a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT * FROM ad_result_cache WHERE adUnitId = ? LIMIT 1"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r7 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r7)
        L_0x0010:
            androidx.room.RoomDatabase r7 = r6.a
            r7.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r7 = r6.a
            r1 = 0
            r2 = 0
            android.database.Cursor r7 = androidx.room.util.DBUtil.query(r7, r0, r1, r2)
            java.lang.String r1 = "adUnitId"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r1)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "adResult"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r3)     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = "date"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r4)     // Catch:{ all -> 0x0075 }
            boolean r5 = r7.moveToFirst()     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x006e
            boolean r5 = r7.isNull(r1)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x003d
            r1 = r2
            goto L_0x0041
        L_0x003d:
            java.lang.String r1 = r7.getString(r1)     // Catch:{ all -> 0x0075 }
        L_0x0041:
            boolean r5 = r7.isNull(r3)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x0049
            r3 = r2
            goto L_0x004d
        L_0x0049:
            java.lang.String r3 = r7.getString(r3)     // Catch:{ all -> 0x0075 }
        L_0x004d:
            com.wortise.ads.o r5 = r6.c     // Catch:{ all -> 0x0075 }
            com.wortise.ads.AdResult r3 = r5.a((java.lang.String) r3)     // Catch:{ all -> 0x0075 }
            boolean r5 = r7.isNull(r4)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x005a
            goto L_0x0062
        L_0x005a:
            long r4 = r7.getLong(r4)     // Catch:{ all -> 0x0075 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0075 }
        L_0x0062:
            com.wortise.ads.f2 r4 = r6.d     // Catch:{ all -> 0x0075 }
            java.util.Date r2 = r4.a((java.lang.Long) r2)     // Catch:{ all -> 0x0075 }
            com.wortise.ads.l r4 = new com.wortise.ads.l     // Catch:{ all -> 0x0075 }
            r4.<init>(r1, r3, r2)     // Catch:{ all -> 0x0075 }
            r2 = r4
        L_0x006e:
            r7.close()
            r0.release()
            return r2
        L_0x0075:
            r1 = move-exception
            r7.close()
            r0.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.n.a(java.lang.String):com.wortise.ads.l");
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
