package com.m2catalyst.m2sdk.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.entities.CounterInt;
import com.m2catalyst.m2sdk.database.entities.CounterLong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class CounterDao_Impl implements CounterDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<CounterInt> __insertionAdapterOfCounterInt;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<CounterLong> __insertionAdapterOfCounterLong;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteCounterIntEntriesByDate;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteCounterIntPriorToDate;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteCounterLongEntriesByDate;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteCounterLongPriorToDate;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfIncrementIntCounter;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfIncrementLongCounter;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfMarkCounterIntTransmitted;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfMarkCounterLongTransmitted;

    public CounterDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCounterInt = new EntityInsertionAdapter<CounterInt>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CounterInt` (`counterId`,`counterValue`,`date`,`transmitted`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CounterInt counterInt) {
                if (counterInt.getCounterId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, counterInt.getCounterId());
                }
                supportSQLiteStatement.bindLong(2, (long) counterInt.getCounterValue());
                if (counterInt.getDate() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, counterInt.getDate());
                }
                supportSQLiteStatement.bindLong(4, (long) counterInt.getTransmitted());
            }
        };
        this.__insertionAdapterOfCounterLong = new EntityInsertionAdapter<CounterLong>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CounterLong` (`counterId`,`counterValue`,`date`,`transmitted`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CounterLong counterLong) {
                if (counterLong.getCounterId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, counterLong.getCounterId());
                }
                supportSQLiteStatement.bindLong(2, counterLong.getCounterValue());
                if (counterLong.getDate() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, counterLong.getDate());
                }
                supportSQLiteStatement.bindLong(4, (long) counterLong.getTransmitted());
            }
        };
        this.__preparedStmtOfIncrementLongCounter = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE CounterLong SET counterValue = ? WHERE counterId = ? and date = ?";
            }
        };
        this.__preparedStmtOfIncrementIntCounter = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE CounterInt SET counterValue = ? WHERE counterId = ? and date = ?";
            }
        };
        this.__preparedStmtOfMarkCounterIntTransmitted = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE CounterInt SET transmitted = 1 WHERE date = ?";
            }
        };
        this.__preparedStmtOfMarkCounterLongTransmitted = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE CounterLong SET transmitted = 1 WHERE date = ?";
            }
        };
        this.__preparedStmtOfDeleteCounterLongPriorToDate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM CounterLong WHERE date < ? AND transmitted = 1";
            }
        };
        this.__preparedStmtOfDeleteCounterIntPriorToDate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM CounterInt WHERE date < ? AND transmitted = 1";
            }
        };
        this.__preparedStmtOfDeleteCounterIntEntriesByDate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM CounterInt WHERE date = ?";
            }
        };
        this.__preparedStmtOfDeleteCounterLongEntriesByDate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM CounterLong WHERE date = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object deleteCounterIntEntriesByDate(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfDeleteCounterIntEntriesByDate.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfDeleteCounterIntEntriesByDate.release(acquire);
                }
            }
        }, continuation);
    }

    public Object deleteCounterIntPriorToDate(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfDeleteCounterIntPriorToDate.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfDeleteCounterIntPriorToDate.release(acquire);
                }
            }
        }, continuation);
    }

    public Object deleteCounterLongEntriesByDate(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfDeleteCounterLongEntriesByDate.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfDeleteCounterLongEntriesByDate.release(acquire);
                }
            }
        }, continuation);
    }

    public Object deleteCounterLongPriorToDate(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfDeleteCounterLongPriorToDate.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfDeleteCounterLongPriorToDate.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getCounterIntNotTransmittedByDate(String str, Continuation<? super List<CounterInt>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT  * FROM CounterInt WHERE transmitted = 0 AND date = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<CounterInt>>() {
            public List<CounterInt> call() {
                String str;
                String str2;
                Cursor query = DBUtil.query(CounterDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "counterId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "counterValue");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "date");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow)) {
                            str = null;
                        } else {
                            str = query.getString(columnIndexOrThrow);
                        }
                        int i = query.getInt(columnIndexOrThrow2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            str2 = null;
                        } else {
                            str2 = query.getString(columnIndexOrThrow3);
                        }
                        arrayList.add(new CounterInt(str, i, str2, query.getInt(columnIndexOrThrow4)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getCounterLongsNotTransmittedByDate(String str, Continuation<? super List<CounterLong>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CounterLong WHERE transmitted = 0 AND date = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<CounterLong>>() {
            public List<CounterLong> call() {
                String str;
                String str2;
                Cursor query = DBUtil.query(CounterDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "counterId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "counterValue");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "date");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow)) {
                            str = null;
                        } else {
                            str = query.getString(columnIndexOrThrow);
                        }
                        long j = query.getLong(columnIndexOrThrow2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            str2 = null;
                        } else {
                            str2 = query.getString(columnIndexOrThrow3);
                        }
                        arrayList.add(new CounterLong(str, j, str2, query.getInt(columnIndexOrThrow4)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getDistinctCounterIntUntransmittedDates(Continuation<? super List<String>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT date FROM CounterInt WHERE transmitted = 0", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<String>>() {
            public List<String> call() {
                String str;
                Cursor query = DBUtil.query(CounterDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        arrayList.add(str);
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getDistinctCounterLongUntransmittedDates(Continuation<? super List<String>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT date FROM CounterLong WHERE transmitted = 0", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<String>>() {
            public List<String> call() {
                String str;
                Cursor query = DBUtil.query(CounterDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        arrayList.add(str);
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getIntCounterById(String str, String str2, Continuation<? super CounterInt> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CounterInt WHERE counterId = ? AND date = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CounterInt>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.m2catalyst.m2sdk.database.entities.CounterInt} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v3 */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.m2catalyst.m2sdk.database.entities.CounterInt call() {
                /*
                    r7 = this;
                    com.m2catalyst.m2sdk.database.daos.CounterDao_Impl r0 = com.m2catalyst.m2sdk.database.daos.CounterDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)
                    java.lang.String r1 = "counterId"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x005b }
                    java.lang.String r2 = "counterValue"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x005b }
                    java.lang.String r4 = "date"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x005b }
                    java.lang.String r5 = "transmitted"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x005b }
                    boolean r6 = r0.moveToFirst()     // Catch:{ all -> 0x005b }
                    if (r6 == 0) goto L_0x0052
                    boolean r6 = r0.isNull(r1)     // Catch:{ all -> 0x005b }
                    if (r6 == 0) goto L_0x0035
                    r1 = r3
                    goto L_0x0039
                L_0x0035:
                    java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x005b }
                L_0x0039:
                    int r2 = r0.getInt(r2)     // Catch:{ all -> 0x005b }
                    boolean r6 = r0.isNull(r4)     // Catch:{ all -> 0x005b }
                    if (r6 == 0) goto L_0x0044
                    goto L_0x0048
                L_0x0044:
                    java.lang.String r3 = r0.getString(r4)     // Catch:{ all -> 0x005b }
                L_0x0048:
                    int r4 = r0.getInt(r5)     // Catch:{ all -> 0x005b }
                    com.m2catalyst.m2sdk.database.entities.CounterInt r5 = new com.m2catalyst.m2sdk.database.entities.CounterInt     // Catch:{ all -> 0x005b }
                    r5.<init>(r1, r2, r3, r4)     // Catch:{ all -> 0x005b }
                    r3 = r5
                L_0x0052:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r3
                L_0x005b:
                    r1 = move-exception
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.database.daos.CounterDao_Impl.AnonymousClass21.call():com.m2catalyst.m2sdk.database.entities.CounterInt");
            }
        }, continuation);
    }

    public Object getLongCounterById(String str, String str2, Continuation<? super CounterLong> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CounterLong WHERE counterId = ? AND date = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<CounterLong>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.m2catalyst.m2sdk.database.entities.CounterLong} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.m2catalyst.m2sdk.database.entities.CounterLong} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.m2catalyst.m2sdk.database.entities.CounterLong} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.m2catalyst.m2sdk.database.entities.CounterLong} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.m2catalyst.m2sdk.database.entities.CounterLong} */
            /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.m2catalyst.m2sdk.database.entities.CounterLong call() {
                /*
                    r12 = this;
                    com.m2catalyst.m2sdk.database.daos.CounterDao_Impl r0 = com.m2catalyst.m2sdk.database.daos.CounterDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)
                    java.lang.String r1 = "counterId"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x005e }
                    java.lang.String r2 = "counterValue"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x005e }
                    java.lang.String r4 = "date"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x005e }
                    java.lang.String r5 = "transmitted"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x005e }
                    boolean r6 = r0.moveToFirst()     // Catch:{ all -> 0x005e }
                    if (r6 == 0) goto L_0x0055
                    boolean r6 = r0.isNull(r1)     // Catch:{ all -> 0x005e }
                    if (r6 == 0) goto L_0x0035
                    r7 = r3
                    goto L_0x003a
                L_0x0035:
                    java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x005e }
                    r7 = r1
                L_0x003a:
                    long r8 = r0.getLong(r2)     // Catch:{ all -> 0x005e }
                    boolean r1 = r0.isNull(r4)     // Catch:{ all -> 0x005e }
                    if (r1 == 0) goto L_0x0046
                L_0x0044:
                    r10 = r3
                    goto L_0x004b
                L_0x0046:
                    java.lang.String r3 = r0.getString(r4)     // Catch:{ all -> 0x005e }
                    goto L_0x0044
                L_0x004b:
                    int r11 = r0.getInt(r5)     // Catch:{ all -> 0x005e }
                    com.m2catalyst.m2sdk.database.entities.CounterLong r3 = new com.m2catalyst.m2sdk.database.entities.CounterLong     // Catch:{ all -> 0x005e }
                    r6 = r3
                    r6.<init>(r7, r8, r10, r11)     // Catch:{ all -> 0x005e }
                L_0x0055:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r3
                L_0x005e:
                    r1 = move-exception
                    r0.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    goto L_0x0069
                L_0x0068:
                    throw r1
                L_0x0069:
                    goto L_0x0068
                */
                throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.database.daos.CounterDao_Impl.AnonymousClass22.call():com.m2catalyst.m2sdk.database.entities.CounterLong");
            }
        }, continuation);
    }

    public Object incrementIntCounter(final String str, final String str2, final int i, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfIncrementIntCounter.acquire();
                acquire.bindLong(1, (long) i);
                String str = str;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                String str2 = str2;
                if (str2 == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindString(3, str2);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfIncrementIntCounter.release(acquire);
                }
            }
        }, continuation);
    }

    public Object incrementLongCounter(String str, String str2, long j, Continuation<? super Unit> continuation) {
        final long j2 = j;
        final String str3 = str;
        final String str4 = str2;
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfIncrementLongCounter.acquire();
                acquire.bindLong(1, j2);
                String str = str3;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                String str2 = str4;
                if (str2 == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindString(3, str2);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfIncrementLongCounter.release(acquire);
                }
            }
        }, continuation);
    }

    public Object insertIntCounter(final CounterInt counterInt, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    CounterDao_Impl.this.__insertionAdapterOfCounterInt.insert(counterInt);
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object insertLongCounter(final CounterLong counterLong, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    CounterDao_Impl.this.__insertionAdapterOfCounterLong.insert(counterLong);
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object markCounterIntTransmitted(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfMarkCounterIntTransmitted.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfMarkCounterIntTransmitted.release(acquire);
                }
            }
        }, continuation);
    }

    public Object markCounterLongTransmitted(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = CounterDao_Impl.this.__preparedStmtOfMarkCounterLongTransmitted.acquire();
                String str = str;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                CounterDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    CounterDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CounterDao_Impl.this.__db.endTransaction();
                    CounterDao_Impl.this.__preparedStmtOfMarkCounterLongTransmitted.release(acquire);
                }
            }
        }, continuation);
    }
}
