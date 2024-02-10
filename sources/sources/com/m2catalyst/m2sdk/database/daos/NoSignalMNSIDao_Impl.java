package com.m2catalyst.m2sdk.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class NoSignalMNSIDao_Impl implements NoSignalMNSIDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<NoSignalMNSIEntity> __insertionAdapterOfNoSignalMNSIEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllEntries;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfResetNDTTable;

    public NoSignalMNSIDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNoSignalMNSIEntity = new EntityInsertionAdapter<NoSignalMNSIEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `no_network_signal_tbl` (`id`,`transmitted`,`phoneType`,`timeZone`,`simOperatorName`,`locationTimeStamp`,`locationProvider`,`accuracy`,`simMnc`,`simMcc`,`simSlot`,`timeStamp`,`timeZoneId`,`timeZoneOffset`,`latitude`,`longitude`,`permissions`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, NoSignalMNSIEntity noSignalMNSIEntity) {
                supportSQLiteStatement.bindLong(1, (long) noSignalMNSIEntity.getId());
                supportSQLiteStatement.bindLong(2, (long) noSignalMNSIEntity.getTransmitted());
                if (noSignalMNSIEntity.getPhoneType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, noSignalMNSIEntity.getPhoneType());
                }
                if (noSignalMNSIEntity.getTimeZone() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, noSignalMNSIEntity.getTimeZone());
                }
                if (noSignalMNSIEntity.getSimOperatorName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, noSignalMNSIEntity.getSimOperatorName());
                }
                if (noSignalMNSIEntity.getLocationTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, noSignalMNSIEntity.getLocationTimeStamp().longValue());
                }
                if (noSignalMNSIEntity.getLocationProvider() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, noSignalMNSIEntity.getLocationProvider());
                }
                if (noSignalMNSIEntity.getAccuracy() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindDouble(8, (double) noSignalMNSIEntity.getAccuracy().floatValue());
                }
                if (noSignalMNSIEntity.getSimMnc() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, (long) noSignalMNSIEntity.getSimMnc().intValue());
                }
                if (noSignalMNSIEntity.getSimMcc() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, (long) noSignalMNSIEntity.getSimMcc().intValue());
                }
                if (noSignalMNSIEntity.getSimSlot() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, (long) noSignalMNSIEntity.getSimSlot().intValue());
                }
                if (noSignalMNSIEntity.getTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, noSignalMNSIEntity.getTimeStamp().longValue());
                }
                if (noSignalMNSIEntity.getTimeZoneId() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, noSignalMNSIEntity.getTimeZoneId());
                }
                if (noSignalMNSIEntity.getTimeZoneOffset() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, noSignalMNSIEntity.getTimeZoneOffset().longValue());
                }
                if (noSignalMNSIEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindDouble(15, noSignalMNSIEntity.getLatitude().doubleValue());
                }
                if (noSignalMNSIEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindDouble(16, noSignalMNSIEntity.getLongitude().doubleValue());
                }
                if (noSignalMNSIEntity.getPermissions() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, noSignalMNSIEntity.getPermissions());
                }
            }
        };
        this.__preparedStmtOfResetNDTTable = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM sqlite_sequence WHERE name='no_network_signal_tbl'";
            }
        };
        this.__preparedStmtOfDeleteAllEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM no_network_signal_tbl";
            }
        };
    }

    /* access modifiers changed from: private */
    public NoSignalMNSIEntity __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesNoSignalMNSIEntity(Cursor cursor) {
        Double d;
        Double d2;
        Long l;
        String str;
        Long l2;
        Integer num;
        Integer num2;
        Integer num3;
        Float f;
        String str2;
        Long l3;
        String str3;
        String str4;
        String str5;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("transmitted");
        int columnIndex3 = cursor2.getColumnIndex("phoneType");
        int columnIndex4 = cursor2.getColumnIndex("timeZone");
        int columnIndex5 = cursor2.getColumnIndex("simOperatorName");
        int columnIndex6 = cursor2.getColumnIndex("locationTimeStamp");
        int columnIndex7 = cursor2.getColumnIndex("locationProvider");
        int columnIndex8 = cursor2.getColumnIndex("accuracy");
        int columnIndex9 = cursor2.getColumnIndex("simMnc");
        int columnIndex10 = cursor2.getColumnIndex("simMcc");
        int columnIndex11 = cursor2.getColumnIndex("simSlot");
        int columnIndex12 = cursor2.getColumnIndex("timeStamp");
        int columnIndex13 = cursor2.getColumnIndex("timeZoneId");
        int columnIndex14 = cursor2.getColumnIndex("timeZoneOffset");
        int columnIndex15 = cursor2.getColumnIndex("latitude");
        int columnIndex16 = cursor2.getColumnIndex("longitude");
        int columnIndex17 = cursor2.getColumnIndex("permissions");
        NoSignalMNSIEntity noSignalMNSIEntity = new NoSignalMNSIEntity();
        int i = columnIndex14;
        if (columnIndex != -1) {
            noSignalMNSIEntity.setId(cursor2.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            noSignalMNSIEntity.setTransmitted(cursor2.getInt(columnIndex2));
        }
        String str6 = null;
        if (columnIndex3 != -1) {
            if (cursor2.isNull(columnIndex3)) {
                str5 = null;
            } else {
                str5 = cursor2.getString(columnIndex3);
            }
            noSignalMNSIEntity.setPhoneType(str5);
        }
        if (columnIndex4 != -1) {
            if (cursor2.isNull(columnIndex4)) {
                str4 = null;
            } else {
                str4 = cursor2.getString(columnIndex4);
            }
            noSignalMNSIEntity.setTimeZone(str4);
        }
        if (columnIndex5 != -1) {
            if (cursor2.isNull(columnIndex5)) {
                str3 = null;
            } else {
                str3 = cursor2.getString(columnIndex5);
            }
            noSignalMNSIEntity.setSimOperatorName(str3);
        }
        if (columnIndex6 != -1) {
            if (cursor2.isNull(columnIndex6)) {
                l3 = null;
            } else {
                l3 = Long.valueOf(cursor2.getLong(columnIndex6));
            }
            noSignalMNSIEntity.setLocationTimeStamp(l3);
        }
        if (columnIndex7 != -1) {
            if (cursor2.isNull(columnIndex7)) {
                str2 = null;
            } else {
                str2 = cursor2.getString(columnIndex7);
            }
            noSignalMNSIEntity.setLocationProvider(str2);
        }
        if (columnIndex8 != -1) {
            if (cursor2.isNull(columnIndex8)) {
                f = null;
            } else {
                f = Float.valueOf(cursor2.getFloat(columnIndex8));
            }
            noSignalMNSIEntity.setAccuracy(f);
        }
        if (columnIndex9 != -1) {
            if (cursor2.isNull(columnIndex9)) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor2.getInt(columnIndex9));
            }
            noSignalMNSIEntity.setSimMnc(num3);
        }
        if (columnIndex10 != -1) {
            if (cursor2.isNull(columnIndex10)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor2.getInt(columnIndex10));
            }
            noSignalMNSIEntity.setSimMcc(num2);
        }
        if (columnIndex11 != -1) {
            if (cursor2.isNull(columnIndex11)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(columnIndex11));
            }
            noSignalMNSIEntity.setSimSlot(num);
        }
        if (columnIndex12 != -1) {
            if (cursor2.isNull(columnIndex12)) {
                l2 = null;
            } else {
                l2 = Long.valueOf(cursor2.getLong(columnIndex12));
            }
            noSignalMNSIEntity.setTimeStamp(l2);
        }
        if (columnIndex13 != -1) {
            if (cursor2.isNull(columnIndex13)) {
                str = null;
            } else {
                str = cursor2.getString(columnIndex13);
            }
            noSignalMNSIEntity.setTimeZoneId(str);
        }
        int i2 = i;
        if (i2 != -1) {
            if (cursor2.isNull(i2)) {
                l = null;
            } else {
                l = Long.valueOf(cursor2.getLong(i2));
            }
            noSignalMNSIEntity.setTimeZoneOffset(l);
        }
        int i3 = columnIndex15;
        if (i3 != -1) {
            if (cursor2.isNull(i3)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(i3));
            }
            noSignalMNSIEntity.setLatitude(d2);
        }
        int i4 = columnIndex16;
        if (i4 != -1) {
            if (cursor2.isNull(i4)) {
                d = null;
            } else {
                d = Double.valueOf(cursor2.getDouble(i4));
            }
            noSignalMNSIEntity.setLongitude(d);
        }
        int i5 = columnIndex17;
        if (i5 != -1) {
            if (!cursor2.isNull(i5)) {
                str6 = cursor2.getString(i5);
            }
            noSignalMNSIEntity.setPermissions(str6);
        }
        return noSignalMNSIEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addEntries(final List<NoSignalMNSIEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                NoSignalMNSIDao_Impl.this.__db.beginTransaction();
                try {
                    NoSignalMNSIDao_Impl.this.__insertionAdapterOfNoSignalMNSIEntity.insert(list);
                    NoSignalMNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NoSignalMNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object clearNoSignalTable(Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new NoSignalMNSIDao_Impl$$ExternalSyntheticLambda0(this), continuation);
    }

    public Object deleteAllEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = NoSignalMNSIDao_Impl.this.__preparedStmtOfDeleteAllEntries.acquire();
                NoSignalMNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    NoSignalMNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NoSignalMNSIDao_Impl.this.__db.endTransaction();
                    NoSignalMNSIDao_Impl.this.__preparedStmtOfDeleteAllEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getEntries(Continuation<? super List<NoSignalMNSIEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM no_network_signal_tbl ORDER BY id ASC", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<NoSignalMNSIEntity>>() {
            public List<NoSignalMNSIEntity> call() {
                String str;
                String str2;
                String str3;
                Long l;
                String str4;
                Float f;
                Integer num;
                Integer num2;
                Integer num3;
                Long l2;
                String str5;
                int i;
                Long l3;
                int i2;
                Double d;
                Double d2;
                String str6;
                AnonymousClass8 r1 = this;
                Cursor query = DBUtil.query(NoSignalMNSIDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "phoneType");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timeZone");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "simOperatorName");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "simMnc");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "simMcc");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "simSlot");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneId");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i3 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            NoSignalMNSIEntity noSignalMNSIEntity = new NoSignalMNSIEntity();
                            ArrayList arrayList2 = arrayList;
                            noSignalMNSIEntity.setId(query.getInt(columnIndexOrThrow));
                            noSignalMNSIEntity.setTransmitted(query.getInt(columnIndexOrThrow2));
                            if (query.isNull(columnIndexOrThrow3)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow3);
                            }
                            noSignalMNSIEntity.setPhoneType(str);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow4);
                            }
                            noSignalMNSIEntity.setTimeZone(str2);
                            if (query.isNull(columnIndexOrThrow5)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow5);
                            }
                            noSignalMNSIEntity.setSimOperatorName(str3);
                            if (query.isNull(columnIndexOrThrow6)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow6));
                            }
                            noSignalMNSIEntity.setLocationTimeStamp(l);
                            if (query.isNull(columnIndexOrThrow7)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(columnIndexOrThrow7);
                            }
                            noSignalMNSIEntity.setLocationProvider(str4);
                            if (query.isNull(columnIndexOrThrow8)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow8));
                            }
                            noSignalMNSIEntity.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            noSignalMNSIEntity.setSimMnc(num);
                            if (query.isNull(columnIndexOrThrow10)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                            }
                            noSignalMNSIEntity.setSimMcc(num2);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            noSignalMNSIEntity.setSimSlot(num3);
                            if (query.isNull(columnIndexOrThrow12)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(columnIndexOrThrow12));
                            }
                            noSignalMNSIEntity.setTimeStamp(l2);
                            if (query.isNull(columnIndexOrThrow13)) {
                                str5 = null;
                            } else {
                                str5 = query.getString(columnIndexOrThrow13);
                            }
                            noSignalMNSIEntity.setTimeZoneId(str5);
                            int i4 = i3;
                            if (query.isNull(i4)) {
                                i = columnIndexOrThrow;
                                l3 = null;
                            } else {
                                i = columnIndexOrThrow;
                                l3 = Long.valueOf(query.getLong(i4));
                            }
                            noSignalMNSIEntity.setTimeZoneOffset(l3);
                            int i5 = columnIndexOrThrow15;
                            if (query.isNull(i5)) {
                                i2 = i5;
                                d = null;
                            } else {
                                i2 = i5;
                                d = Double.valueOf(query.getDouble(i5));
                            }
                            noSignalMNSIEntity.setLatitude(d);
                            int i6 = columnIndexOrThrow16;
                            if (query.isNull(i6)) {
                                columnIndexOrThrow16 = i6;
                                d2 = null;
                            } else {
                                columnIndexOrThrow16 = i6;
                                d2 = Double.valueOf(query.getDouble(i6));
                            }
                            noSignalMNSIEntity.setLongitude(d2);
                            int i7 = columnIndexOrThrow17;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow17 = i7;
                                str6 = null;
                            } else {
                                columnIndexOrThrow17 = i7;
                                str6 = query.getString(i7);
                            }
                            noSignalMNSIEntity.setPermissions(str6);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(noSignalMNSIEntity);
                            columnIndexOrThrow15 = i2;
                            i3 = i4;
                            arrayList = arrayList3;
                            columnIndexOrThrow = i;
                        }
                        ArrayList arrayList4 = arrayList;
                        query.close();
                        acquire.release();
                        return arrayList4;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        query.close();
                        acquire.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object getEntriesWithWhereClause(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<NoSignalMNSIEntity>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<NoSignalMNSIEntity>>() {
            public List<NoSignalMNSIEntity> call() {
                Cursor query = DBUtil.query(NoSignalMNSIDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(NoSignalMNSIDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesNoSignalMNSIEntity(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object insertNoSignalEntry(final NoSignalMNSIEntity noSignalMNSIEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() {
            public Long call() {
                NoSignalMNSIDao_Impl.this.__db.beginTransaction();
                try {
                    long insertAndReturnId = NoSignalMNSIDao_Impl.this.__insertionAdapterOfNoSignalMNSIEntity.insertAndReturnId(noSignalMNSIEntity);
                    NoSignalMNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    NoSignalMNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearNoSignalTable$0$com-m2catalyst-m2sdk-database-daos-NoSignalMNSIDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m2178lambda$clearNoSignalTable$0$comm2catalystm2sdkdatabasedaosNoSignalMNSIDao_Impl(Continuation continuation) {
        return NoSignalMNSIDao.DefaultImpls.clearNoSignalTable(this, continuation);
    }

    public Object markNoSignalEntriesAsTransmitted(final List<Integer> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                StringBuilder newStringBuilder = StringUtil.newStringBuilder();
                newStringBuilder.append("UPDATE no_network_signal_tbl SET transmitted = 1 WHERE id IN (");
                StringUtil.appendPlaceholders(newStringBuilder, list.size());
                newStringBuilder.append(")");
                SupportSQLiteStatement compileStatement = NoSignalMNSIDao_Impl.this.__db.compileStatement(newStringBuilder.toString());
                int i = 1;
                for (Integer num : list) {
                    if (num == null) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindLong(i, (long) num.intValue());
                    }
                    i++;
                }
                NoSignalMNSIDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.executeUpdateDelete();
                    NoSignalMNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NoSignalMNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object resetNDTTable(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = NoSignalMNSIDao_Impl.this.__preparedStmtOfResetNDTTable.acquire();
                NoSignalMNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    NoSignalMNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NoSignalMNSIDao_Impl.this.__db.endTransaction();
                    NoSignalMNSIDao_Impl.this.__preparedStmtOfResetNDTTable.release(acquire);
                }
            }
        }, continuation);
    }
}
