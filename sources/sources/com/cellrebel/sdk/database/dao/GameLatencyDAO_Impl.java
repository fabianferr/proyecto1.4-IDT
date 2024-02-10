package com.cellrebel.sdk.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.GPSPoint;
import com.cellrebel.sdk.database.GameLatency;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GameLatencyDAO_Impl implements GameLatencyDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<GameLatency> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<GameLatency> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, GameLatency gameLatency) {
            supportSQLiteStatement.bindLong(1, gameLatency.a);
            supportSQLiteStatement.bindLong(2, gameLatency.b);
            String str = gameLatency.c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = gameLatency.d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            Float f = gameLatency.e;
            if (f == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindDouble(5, (double) f.floatValue());
            }
            supportSQLiteStatement.bindDouble(6, gameLatency.f);
            supportSQLiteStatement.bindDouble(7, gameLatency.g);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `GameLatency` (`id`,`timestamp`,`gameName`,`serverName`,`latency`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM gamelatency WHERE id NOT IN (SELECT id FROM gamelatency ORDER BY timestamp DESC LIMIT ?)";
        }
    }

    public GameLatencyDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public int a() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM gamelatency", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<GameLatency> a(double d, double d2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM gamelatency WHERE latitude = ? AND longitude = ?", 2);
        acquire.bindDouble(1, d);
        acquire.bindDouble(2, d2);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, CampaignEx.JSON_KEY_TIMESTAMP);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "gameName");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "serverName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                GameLatency gameLatency = new GameLatency();
                gameLatency.a = query.getLong(columnIndexOrThrow);
                gameLatency.b = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    gameLatency.c = null;
                } else {
                    gameLatency.c = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    gameLatency.d = null;
                } else {
                    gameLatency.d = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    gameLatency.e = null;
                } else {
                    gameLatency.e = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                }
                gameLatency.f = query.getDouble(columnIndexOrThrow6);
                gameLatency.g = query.getDouble(columnIndexOrThrow7);
                arrayList.add(gameLatency);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void a(int i) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        acquire.bindLong(1, (long) i);
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    public void a(GameLatency gameLatency) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(gameLatency);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<Long> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM gamelatency WHERE id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (Long next : list) {
            if (next == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindLong(i, next.longValue());
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<GPSPoint> b() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT latitude, longitude FROM gamelatency GROUP BY latitude, longitude", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                GPSPoint gPSPoint = new GPSPoint();
                gPSPoint.a = query.getDouble(0);
                gPSPoint.b = query.getDouble(1);
                arrayList.add(gPSPoint);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
