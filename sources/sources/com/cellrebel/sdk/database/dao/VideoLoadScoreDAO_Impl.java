package com.cellrebel.sdk.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.VideoLoadScore;
import java.util.Collections;
import java.util.List;

public final class VideoLoadScoreDAO_Impl implements VideoLoadScoreDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<VideoLoadScore> b;
    private final SharedSQLiteStatement c;
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<VideoLoadScore> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoLoadScore videoLoadScore) {
            supportSQLiteStatement.bindLong(1, videoLoadScore.a);
            supportSQLiteStatement.bindLong(2, videoLoadScore.b);
            supportSQLiteStatement.bindDouble(3, videoLoadScore.c);
            supportSQLiteStatement.bindDouble(4, videoLoadScore.d);
            supportSQLiteStatement.bindDouble(5, videoLoadScore.e);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `VideoLoadScore` (`id`,`timestamp`,`score`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM videoloadscore";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE from videoloadscore WHERE timestamp < ?";
        }
    }

    public VideoLoadScoreDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public void a(VideoLoadScore videoLoadScore) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(videoLoadScore);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
