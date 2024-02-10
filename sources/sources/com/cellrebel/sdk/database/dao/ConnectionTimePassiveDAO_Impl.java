package com.cellrebel.sdk.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.ConnectionTimePassive;
import com.cellrebel.sdk.database.ConnectionTypeConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ConnectionTimePassiveDAO_Impl implements ConnectionTimePassiveDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ConnectionTimePassive> b;
    /* access modifiers changed from: private */
    public final ConnectionTypeConverter c = new ConnectionTypeConverter();
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<ConnectionTimePassive> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ConnectionTimePassive connectionTimePassive) {
            supportSQLiteStatement.bindLong(1, connectionTimePassive.a);
            String a2 = ConnectionTimePassiveDAO_Impl.this.c.a(connectionTimePassive.b);
            if (a2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, a2);
            }
            supportSQLiteStatement.bindLong(3, connectionTimePassive.c);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `ConnectionTimePassive` (`id`,`connectionType`,`duration`) VALUES (nullif(?, 0),?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM connectiontimepassive";
        }
    }

    public ConnectionTimePassiveDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.d = new b(roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    public void a(ConnectionTimePassive connectionTimePassive) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(connectionTimePassive);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<ConnectionTimePassive> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from connectiontimepassive", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "connectionType");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "duration");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ConnectionTimePassive connectionTimePassive = new ConnectionTimePassive();
                connectionTimePassive.a = query.getLong(columnIndexOrThrow);
                connectionTimePassive.b = this.c.a(query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2));
                connectionTimePassive.c = query.getLong(columnIndexOrThrow3);
                arrayList.add(connectionTimePassive);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
