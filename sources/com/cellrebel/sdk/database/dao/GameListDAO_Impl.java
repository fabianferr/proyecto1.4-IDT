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
import com.cellrebel.sdk.database.ServerConverter;
import com.cellrebel.sdk.networking.beans.response.Game;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GameListDAO_Impl implements GameListDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<Game> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<Game> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Game game) {
            supportSQLiteStatement.bindLong(1, game.id);
            String str = game.name;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            Boolean bool = game.isHidden;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindLong(3, (long) valueOf.intValue());
            }
            String str2 = game.subtitle;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            String a2 = ServerConverter.a(game.servers);
            if (a2 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, a2);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `Game` (`id`,`name`,`isHidden`,`subtitle`,`servers`) VALUES (nullif(?, 0),?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM game";
        }
    }

    public GameListDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    public void a(List<Game> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<Game> getAll() {
        Boolean bool;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from game", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "isHidden");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, MediaTrack.ROLE_SUBTITLE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "servers");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Game game = new Game();
                game.id = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    game.name = null;
                } else {
                    game.name = query.getString(columnIndexOrThrow2);
                }
                Integer valueOf = query.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow3));
                if (valueOf == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(valueOf.intValue() != 0);
                }
                game.isHidden = bool;
                if (query.isNull(columnIndexOrThrow4)) {
                    game.subtitle = null;
                } else {
                    game.subtitle = query.getString(columnIndexOrThrow4);
                }
                game.servers = ServerConverter.a(query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5));
                arrayList.add(game);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
