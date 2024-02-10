package com.appnext.core.ra.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c implements b {
    private final RoomDatabase dM;
    private final EntityInsertionAdapter<a> ek;
    private final EntityInsertionAdapter<a> el;
    private final SharedSQLiteStatement em;

    public c(RoomDatabase roomDatabase) {
        this.dM = roomDatabase;
        this.ek = new EntityInsertionAdapter<a>(roomDatabase) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `RecentApp` (`recentAppPackage`,`storeDate`,`sent`) VALUES (?,?,?)";
            }

            public final /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
                a aVar = (a) obj;
                if (aVar.eh == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, aVar.eh);
                }
                if (aVar.ei == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, aVar.ei);
                }
                supportSQLiteStatement.bindLong(3, aVar.ej ? 1 : 0);
            }
        };
        this.el = new EntityInsertionAdapter<a>(roomDatabase) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `RecentApp` (`recentAppPackage`,`storeDate`,`sent`) VALUES (?,?,?)";
            }

            public final /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
                a aVar = (a) obj;
                if (aVar.eh == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, aVar.eh);
                }
                if (aVar.ei == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, aVar.ei);
                }
                supportSQLiteStatement.bindLong(3, aVar.ej ? 1 : 0);
            }
        };
        this.em = new SharedSQLiteStatement(roomDatabase) {
            public final String createQuery() {
                return "DELETE FROM recentapp WHERE storeDate NOT LIKE ?";
            }
        };
    }

    public final long[] a(List<a> list) {
        this.dM.assertNotSuspendingTransaction();
        this.dM.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.ek.insertAndReturnIdsArray(list);
            this.dM.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.dM.endTransaction();
        }
    }

    public final void b(List<a> list) {
        this.dM.assertNotSuspendingTransaction();
        this.dM.beginTransaction();
        try {
            this.el.insert(list);
            this.dM.setTransactionSuccessful();
        } finally {
            this.dM.endTransaction();
        }
    }

    public final int z(String str) {
        this.dM.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.em.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.dM.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.dM.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.dM.endTransaction();
            this.em.release(acquire);
        }
    }

    public final List<a> as() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM recentapp", 0);
        this.dM.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.dM, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "recentAppPackage");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "storeDate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sent");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                a aVar = new a();
                if (query.isNull(columnIndexOrThrow)) {
                    aVar.eh = null;
                } else {
                    aVar.eh = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    aVar.ei = null;
                } else {
                    aVar.ei = query.getString(columnIndexOrThrow2);
                }
                aVar.ej = query.getInt(columnIndexOrThrow3) != 0;
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final List<a> at() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM recentapp WHERE sent = 0", 0);
        this.dM.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.dM, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "recentAppPackage");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "storeDate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sent");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                a aVar = new a();
                if (query.isNull(columnIndexOrThrow)) {
                    aVar.eh = null;
                } else {
                    aVar.eh = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    aVar.ei = null;
                } else {
                    aVar.ei = query.getString(columnIndexOrThrow2);
                }
                aVar.ej = query.getInt(columnIndexOrThrow3) != 0;
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> ae() {
        return Collections.emptyList();
    }
}
