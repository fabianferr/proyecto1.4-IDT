package com.m2catalyst.m2sdk.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class BadSignalsDao_Impl implements BadSignalsDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<BadSignal> __insertionAdapterOfBadSignal;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<BadSignal> __insertionAdapterOfBadSignal_1;

    public BadSignalsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBadSignal = new EntityInsertionAdapter<BadSignal>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `bad_signals_tbl` (`date`,`twoCount`,`threeCount`,`fourCount`,`fiveCount`,`noNetworkCount`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, BadSignal badSignal) {
                if (badSignal.getDate() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, badSignal.getDate());
                }
                supportSQLiteStatement.bindLong(2, (long) badSignal.getTwoCount());
                supportSQLiteStatement.bindLong(3, (long) badSignal.getThreeCount());
                supportSQLiteStatement.bindLong(4, (long) badSignal.getFourCount());
                supportSQLiteStatement.bindLong(5, (long) badSignal.getFiveCount());
                supportSQLiteStatement.bindLong(6, (long) badSignal.getNoNetworkCount());
            }
        };
        this.__insertionAdapterOfBadSignal_1 = new EntityInsertionAdapter<BadSignal>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `bad_signals_tbl` (`date`,`twoCount`,`threeCount`,`fourCount`,`fiveCount`,`noNetworkCount`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, BadSignal badSignal) {
                if (badSignal.getDate() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, badSignal.getDate());
                }
                supportSQLiteStatement.bindLong(2, (long) badSignal.getTwoCount());
                supportSQLiteStatement.bindLong(3, (long) badSignal.getThreeCount());
                supportSQLiteStatement.bindLong(4, (long) badSignal.getFourCount());
                supportSQLiteStatement.bindLong(5, (long) badSignal.getFiveCount());
                supportSQLiteStatement.bindLong(6, (long) badSignal.getNoNetworkCount());
            }
        };
    }

    /* access modifiers changed from: private */
    public BadSignal __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesBadSignal(Cursor cursor) {
        String str;
        int columnIndex = cursor.getColumnIndex("date");
        int columnIndex2 = cursor.getColumnIndex("twoCount");
        int columnIndex3 = cursor.getColumnIndex("threeCount");
        int columnIndex4 = cursor.getColumnIndex("fourCount");
        int columnIndex5 = cursor.getColumnIndex("fiveCount");
        int columnIndex6 = cursor.getColumnIndex("noNetworkCount");
        BadSignal badSignal = new BadSignal();
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                str = null;
            } else {
                str = cursor.getString(columnIndex);
            }
            badSignal.setDate(str);
        }
        if (columnIndex2 != -1) {
            badSignal.setTwoCount(cursor.getInt(columnIndex2));
        }
        if (columnIndex3 != -1) {
            badSignal.setThreeCount(cursor.getInt(columnIndex3));
        }
        if (columnIndex4 != -1) {
            badSignal.setFourCount(cursor.getInt(columnIndex4));
        }
        if (columnIndex5 != -1) {
            badSignal.setFiveCount(cursor.getInt(columnIndex5));
        }
        if (columnIndex6 != -1) {
            badSignal.setNoNetworkCount(cursor.getInt(columnIndex6));
        }
        return badSignal;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addEntries(final List<BadSignal> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                BadSignalsDao_Impl.this.__db.beginTransaction();
                try {
                    BadSignalsDao_Impl.this.__insertionAdapterOfBadSignal_1.insert(list);
                    BadSignalsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    BadSignalsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object getBadSignals(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<BadSignal>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<BadSignal>>() {
            public List<BadSignal> call() {
                Cursor query = DBUtil.query(BadSignalsDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(BadSignalsDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesBadSignal(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object getBadSignalsForDate(String str, Continuation<? super BadSignal> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM bad_signals_tbl WHERE date = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<BadSignal>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.m2catalyst.m2sdk.database.entities.BadSignal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v3 */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.m2catalyst.m2sdk.database.entities.BadSignal call() {
                /*
                    r10 = this;
                    com.m2catalyst.m2sdk.database.daos.BadSignalsDao_Impl r0 = com.m2catalyst.m2sdk.database.daos.BadSignalsDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)
                    java.lang.String r1 = "date"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x007a }
                    java.lang.String r2 = "twoCount"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x007a }
                    java.lang.String r4 = "threeCount"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x007a }
                    java.lang.String r5 = "fourCount"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x007a }
                    java.lang.String r6 = "fiveCount"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r6)     // Catch:{ all -> 0x007a }
                    java.lang.String r7 = "noNetworkCount"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r7)     // Catch:{ all -> 0x007a }
                    boolean r8 = r0.moveToFirst()     // Catch:{ all -> 0x007a }
                    if (r8 == 0) goto L_0x0071
                    com.m2catalyst.m2sdk.database.entities.BadSignal r8 = new com.m2catalyst.m2sdk.database.entities.BadSignal     // Catch:{ all -> 0x007a }
                    r8.<init>()     // Catch:{ all -> 0x007a }
                    boolean r9 = r0.isNull(r1)     // Catch:{ all -> 0x007a }
                    if (r9 == 0) goto L_0x0046
                    goto L_0x004a
                L_0x0046:
                    java.lang.String r3 = r0.getString(r1)     // Catch:{ all -> 0x007a }
                L_0x004a:
                    r8.setDate(r3)     // Catch:{ all -> 0x007a }
                    int r1 = r0.getInt(r2)     // Catch:{ all -> 0x007a }
                    r8.setTwoCount(r1)     // Catch:{ all -> 0x007a }
                    int r1 = r0.getInt(r4)     // Catch:{ all -> 0x007a }
                    r8.setThreeCount(r1)     // Catch:{ all -> 0x007a }
                    int r1 = r0.getInt(r5)     // Catch:{ all -> 0x007a }
                    r8.setFourCount(r1)     // Catch:{ all -> 0x007a }
                    int r1 = r0.getInt(r6)     // Catch:{ all -> 0x007a }
                    r8.setFiveCount(r1)     // Catch:{ all -> 0x007a }
                    int r1 = r0.getInt(r7)     // Catch:{ all -> 0x007a }
                    r8.setNoNetworkCount(r1)     // Catch:{ all -> 0x007a }
                    r3 = r8
                L_0x0071:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r3
                L_0x007a:
                    r1 = move-exception
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.database.daos.BadSignalsDao_Impl.AnonymousClass5.call():com.m2catalyst.m2sdk.database.entities.BadSignal");
            }
        }, continuation);
    }

    public Object insertOrUpdateBadSignal(final BadSignal badSignal, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                BadSignalsDao_Impl.this.__db.beginTransaction();
                try {
                    BadSignalsDao_Impl.this.__insertionAdapterOfBadSignal.insert(badSignal);
                    BadSignalsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    BadSignalsDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}
