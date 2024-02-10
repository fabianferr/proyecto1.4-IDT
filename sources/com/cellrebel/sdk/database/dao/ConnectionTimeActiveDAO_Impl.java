package com.cellrebel.sdk.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.ConnectionTimeActive;
import com.cellrebel.sdk.database.ConnectionTypeConverter;
import java.util.Collections;
import java.util.List;

public final class ConnectionTimeActiveDAO_Impl implements ConnectionTimeActiveDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ConnectionTimeActive> b;
    /* access modifiers changed from: private */
    public final ConnectionTypeConverter c = new ConnectionTypeConverter();
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<ConnectionTimeActive> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ConnectionTimeActive connectionTimeActive) {
            supportSQLiteStatement.bindLong(1, connectionTimeActive.a);
            supportSQLiteStatement.bindLong(2, connectionTimeActive.b);
            String a2 = ConnectionTimeActiveDAO_Impl.this.c.a(connectionTimeActive.c);
            if (a2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, a2);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `ConnectionTimeActive` (`id`,`duration`,`connectionType`) VALUES (nullif(?, 0),?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM connectiontimeactive";
        }
    }

    public ConnectionTimeActiveDAO_Impl(RoomDatabase roomDatabase) {
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
}
