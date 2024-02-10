package com.cellrebel.sdk.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.PageLoadScore;
import java.util.Collections;
import java.util.List;

public final class PageLoadScoreDAO_Impl implements PageLoadScoreDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<PageLoadScore> b;
    private final SharedSQLiteStatement c;
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<PageLoadScore> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PageLoadScore pageLoadScore) {
            supportSQLiteStatement.bindLong(1, pageLoadScore.a);
            supportSQLiteStatement.bindLong(2, pageLoadScore.b);
            supportSQLiteStatement.bindDouble(3, pageLoadScore.c);
            supportSQLiteStatement.bindDouble(4, pageLoadScore.d);
            supportSQLiteStatement.bindDouble(5, pageLoadScore.e);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `PageLoadScore` (`id`,`timestamp`,`score`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM pageloadscore";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE from pageloadscore WHERE timestamp < ?";
        }
    }

    public PageLoadScoreDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public void a(PageLoadScore pageLoadScore) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(pageLoadScore);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
