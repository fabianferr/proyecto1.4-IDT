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
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.database.entities.LocationEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class LocationDao_Impl implements LocationDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<LocationEntity> __insertionAdapterOfLocationEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteLocationEntries;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfMarkLocationAsTransmitted;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfResetLocationTable;

    public LocationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfLocationEntity = new EntityInsertionAdapter<LocationEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `location_tbl` (`id`,`altitude`,`longitude`,`latitude`,`indoorOutdoorWeight`,`accuracy`,`bearing`,`speed`,`timeZoneOffset`,`timeZoneId`,`timeStamp`,`transmitted`,`provider`,`barometric`,`permissions`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, LocationEntity locationEntity) {
                supportSQLiteStatement.bindLong(1, (long) locationEntity.getId());
                if (locationEntity.getAltitude() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindDouble(2, locationEntity.getAltitude().doubleValue());
                }
                if (locationEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindDouble(3, locationEntity.getLongitude().doubleValue());
                }
                if (locationEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindDouble(4, locationEntity.getLatitude().doubleValue());
                }
                if (locationEntity.getIndoorOutdoorWeight() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindDouble(5, locationEntity.getIndoorOutdoorWeight().doubleValue());
                }
                if (locationEntity.getAccuracy() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindDouble(6, (double) locationEntity.getAccuracy().floatValue());
                }
                if (locationEntity.getBearing() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindDouble(7, (double) locationEntity.getBearing().floatValue());
                }
                if (locationEntity.getSpeed() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindDouble(8, (double) locationEntity.getSpeed().floatValue());
                }
                if (locationEntity.getTimeZoneOffset() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, (long) locationEntity.getTimeZoneOffset().intValue());
                }
                if (locationEntity.getTimeZoneId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, locationEntity.getTimeZoneId());
                }
                if (locationEntity.getTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, locationEntity.getTimeStamp().longValue());
                }
                supportSQLiteStatement.bindLong(12, (long) locationEntity.getTransmitted());
                if (locationEntity.getProvider() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, locationEntity.getProvider());
                }
                if (locationEntity.getBarometric() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindDouble(14, (double) locationEntity.getBarometric().floatValue());
                }
                if (locationEntity.getPermissions() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, locationEntity.getPermissions());
                }
            }
        };
        this.__preparedStmtOfMarkLocationAsTransmitted = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE location_tbl SET transmitted = 1 WHERE id >= ? AND id <= ?";
            }
        };
        this.__preparedStmtOfDeleteLocationEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM location_tbl";
            }
        };
        this.__preparedStmtOfResetLocationTable = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM sqlite_sequence WHERE name='location_tbl'";
            }
        };
    }

    /* access modifiers changed from: private */
    public LocationEntity __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesLocationEntity(Cursor cursor) {
        Float f;
        String str;
        Long l;
        String str2;
        Integer num;
        Float f2;
        Float f3;
        Float f4;
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("altitude");
        int columnIndex3 = cursor2.getColumnIndex("longitude");
        int columnIndex4 = cursor2.getColumnIndex("latitude");
        int columnIndex5 = cursor2.getColumnIndex("indoorOutdoorWeight");
        int columnIndex6 = cursor2.getColumnIndex("accuracy");
        int columnIndex7 = cursor2.getColumnIndex("bearing");
        int columnIndex8 = cursor2.getColumnIndex("speed");
        int columnIndex9 = cursor2.getColumnIndex("timeZoneOffset");
        int columnIndex10 = cursor2.getColumnIndex("timeZoneId");
        int columnIndex11 = cursor2.getColumnIndex("timeStamp");
        int columnIndex12 = cursor2.getColumnIndex("transmitted");
        int columnIndex13 = cursor2.getColumnIndex(IronSourceConstants.EVENTS_PROVIDER);
        int columnIndex14 = cursor2.getColumnIndex("barometric");
        int columnIndex15 = cursor2.getColumnIndex("permissions");
        LocationEntity locationEntity = new LocationEntity();
        int i = columnIndex14;
        if (columnIndex != -1) {
            locationEntity.setId(cursor2.getInt(columnIndex));
        }
        String str3 = null;
        if (columnIndex2 != -1) {
            if (cursor2.isNull(columnIndex2)) {
                d4 = null;
            } else {
                d4 = Double.valueOf(cursor2.getDouble(columnIndex2));
            }
            locationEntity.setAltitude(d4);
        }
        if (columnIndex3 != -1) {
            if (cursor2.isNull(columnIndex3)) {
                d3 = null;
            } else {
                d3 = Double.valueOf(cursor2.getDouble(columnIndex3));
            }
            locationEntity.setLongitude(d3);
        }
        if (columnIndex4 != -1) {
            if (cursor2.isNull(columnIndex4)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(columnIndex4));
            }
            locationEntity.setLatitude(d2);
        }
        if (columnIndex5 != -1) {
            if (cursor2.isNull(columnIndex5)) {
                d = null;
            } else {
                d = Double.valueOf(cursor2.getDouble(columnIndex5));
            }
            locationEntity.setIndoorOutdoorWeight(d);
        }
        if (columnIndex6 != -1) {
            if (cursor2.isNull(columnIndex6)) {
                f4 = null;
            } else {
                f4 = Float.valueOf(cursor2.getFloat(columnIndex6));
            }
            locationEntity.setAccuracy(f4);
        }
        if (columnIndex7 != -1) {
            if (cursor2.isNull(columnIndex7)) {
                f3 = null;
            } else {
                f3 = Float.valueOf(cursor2.getFloat(columnIndex7));
            }
            locationEntity.setBearing(f3);
        }
        if (columnIndex8 != -1) {
            if (cursor2.isNull(columnIndex8)) {
                f2 = null;
            } else {
                f2 = Float.valueOf(cursor2.getFloat(columnIndex8));
            }
            locationEntity.setSpeed(f2);
        }
        if (columnIndex9 != -1) {
            if (cursor2.isNull(columnIndex9)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(columnIndex9));
            }
            locationEntity.setTimeZoneOffset(num);
        }
        if (columnIndex10 != -1) {
            if (cursor2.isNull(columnIndex10)) {
                str2 = null;
            } else {
                str2 = cursor2.getString(columnIndex10);
            }
            locationEntity.setTimeZoneId(str2);
        }
        if (columnIndex11 != -1) {
            if (cursor2.isNull(columnIndex11)) {
                l = null;
            } else {
                l = Long.valueOf(cursor2.getLong(columnIndex11));
            }
            locationEntity.setTimeStamp(l);
        }
        if (columnIndex12 != -1) {
            locationEntity.setTransmitted(cursor2.getInt(columnIndex12));
        }
        if (columnIndex13 != -1) {
            if (cursor2.isNull(columnIndex13)) {
                str = null;
            } else {
                str = cursor2.getString(columnIndex13);
            }
            locationEntity.setProvider(str);
        }
        int i2 = i;
        if (i2 != -1) {
            if (cursor2.isNull(i2)) {
                f = null;
            } else {
                f = Float.valueOf(cursor2.getFloat(i2));
            }
            locationEntity.setBarometric(f);
        }
        int i3 = columnIndex15;
        if (i3 != -1) {
            if (!cursor2.isNull(i3)) {
                str3 = cursor2.getString(i3);
            }
            locationEntity.setPermissions(str3);
        }
        return locationEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addLocationEntry(final LocationEntity locationEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() {
            public Long call() {
                LocationDao_Impl.this.__db.beginTransaction();
                try {
                    long insertAndReturnId = LocationDao_Impl.this.__insertionAdapterOfLocationEntity.insertAndReturnId(locationEntity);
                    LocationDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    LocationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object addLocations(final List<LocationEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                LocationDao_Impl.this.__db.beginTransaction();
                try {
                    LocationDao_Impl.this.__insertionAdapterOfLocationEntity.insert(list);
                    LocationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LocationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object clearLocationTable(Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new LocationDao_Impl$$ExternalSyntheticLambda0(this), continuation);
    }

    public Object deleteLocationEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = LocationDao_Impl.this.__preparedStmtOfDeleteLocationEntries.acquire();
                LocationDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    LocationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LocationDao_Impl.this.__db.endTransaction();
                    LocationDao_Impl.this.__preparedStmtOfDeleteLocationEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getLocationById(int i, Continuation<? super LocationEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM location_tbl WHERE id = ?", 1);
        acquire.bindLong(1, (long) i);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<LocationEntity>() {
            public LocationEntity call() {
                LocationEntity locationEntity;
                Double d;
                Double d2;
                Double d3;
                Double d4;
                Float f;
                Float f2;
                Float f3;
                Integer num;
                String str;
                Long l;
                String str2;
                Float f4;
                String str3;
                AnonymousClass10 r1 = this;
                Cursor query = DBUtil.query(LocationDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "bearing");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "speed");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneId");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, IronSourceConstants.EVENTS_PROVIDER);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        if (query.moveToFirst()) {
                            int i = columnIndexOrThrow15;
                            LocationEntity locationEntity2 = new LocationEntity();
                            locationEntity2.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(columnIndexOrThrow2));
                            }
                            locationEntity2.setAltitude(d);
                            if (query.isNull(columnIndexOrThrow3)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(columnIndexOrThrow3));
                            }
                            locationEntity2.setLongitude(d2);
                            if (query.isNull(columnIndexOrThrow4)) {
                                d3 = null;
                            } else {
                                d3 = Double.valueOf(query.getDouble(columnIndexOrThrow4));
                            }
                            locationEntity2.setLatitude(d3);
                            if (query.isNull(columnIndexOrThrow5)) {
                                d4 = null;
                            } else {
                                d4 = Double.valueOf(query.getDouble(columnIndexOrThrow5));
                            }
                            locationEntity2.setIndoorOutdoorWeight(d4);
                            if (query.isNull(columnIndexOrThrow6)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                            }
                            locationEntity2.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow7)) {
                                f2 = null;
                            } else {
                                f2 = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                            }
                            locationEntity2.setBearing(f2);
                            if (query.isNull(columnIndexOrThrow8)) {
                                f3 = null;
                            } else {
                                f3 = Float.valueOf(query.getFloat(columnIndexOrThrow8));
                            }
                            locationEntity2.setSpeed(f3);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            locationEntity2.setTimeZoneOffset(num);
                            if (query.isNull(columnIndexOrThrow10)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow10);
                            }
                            locationEntity2.setTimeZoneId(str);
                            if (query.isNull(columnIndexOrThrow11)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow11));
                            }
                            locationEntity2.setTimeStamp(l);
                            locationEntity2.setTransmitted(query.getInt(columnIndexOrThrow12));
                            if (query.isNull(columnIndexOrThrow13)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow13);
                            }
                            locationEntity2.setProvider(str2);
                            if (query.isNull(columnIndexOrThrow14)) {
                                f4 = null;
                            } else {
                                f4 = Float.valueOf(query.getFloat(columnIndexOrThrow14));
                            }
                            locationEntity2.setBarometric(f4);
                            int i2 = i;
                            if (query.isNull(i2)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(i2);
                            }
                            locationEntity2.setPermissions(str3);
                            locationEntity = locationEntity2;
                        } else {
                            locationEntity = null;
                        }
                        query.close();
                        acquire.release();
                        return locationEntity;
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

    public Object getLocationWithWHereClause(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<LocationEntity>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<LocationEntity>>() {
            public List<LocationEntity> call() {
                Cursor query = DBUtil.query(LocationDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(LocationDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesLocationEntity(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object getLocations(Continuation<? super List<LocationEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM location_tbl ORDER BY id ASC", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<LocationEntity>>() {
            public List<LocationEntity> call() {
                Double d;
                Double d2;
                Double d3;
                Double d4;
                Float f;
                Float f2;
                Float f3;
                Integer num;
                String str;
                Long l;
                String str2;
                int i;
                Float f4;
                int i2;
                String str3;
                AnonymousClass12 r1 = this;
                Cursor query = DBUtil.query(LocationDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "bearing");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "speed");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneId");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, IronSourceConstants.EVENTS_PROVIDER);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i3 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            LocationEntity locationEntity = new LocationEntity();
                            ArrayList arrayList2 = arrayList;
                            locationEntity.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(columnIndexOrThrow2));
                            }
                            locationEntity.setAltitude(d);
                            if (query.isNull(columnIndexOrThrow3)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(columnIndexOrThrow3));
                            }
                            locationEntity.setLongitude(d2);
                            if (query.isNull(columnIndexOrThrow4)) {
                                d3 = null;
                            } else {
                                d3 = Double.valueOf(query.getDouble(columnIndexOrThrow4));
                            }
                            locationEntity.setLatitude(d3);
                            if (query.isNull(columnIndexOrThrow5)) {
                                d4 = null;
                            } else {
                                d4 = Double.valueOf(query.getDouble(columnIndexOrThrow5));
                            }
                            locationEntity.setIndoorOutdoorWeight(d4);
                            if (query.isNull(columnIndexOrThrow6)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                            }
                            locationEntity.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow7)) {
                                f2 = null;
                            } else {
                                f2 = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                            }
                            locationEntity.setBearing(f2);
                            if (query.isNull(columnIndexOrThrow8)) {
                                f3 = null;
                            } else {
                                f3 = Float.valueOf(query.getFloat(columnIndexOrThrow8));
                            }
                            locationEntity.setSpeed(f3);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            locationEntity.setTimeZoneOffset(num);
                            if (query.isNull(columnIndexOrThrow10)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow10);
                            }
                            locationEntity.setTimeZoneId(str);
                            if (query.isNull(columnIndexOrThrow11)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow11));
                            }
                            locationEntity.setTimeStamp(l);
                            locationEntity.setTransmitted(query.getInt(columnIndexOrThrow12));
                            if (query.isNull(columnIndexOrThrow13)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow13);
                            }
                            locationEntity.setProvider(str2);
                            int i4 = i3;
                            if (query.isNull(i4)) {
                                i = columnIndexOrThrow;
                                f4 = null;
                            } else {
                                i = columnIndexOrThrow;
                                f4 = Float.valueOf(query.getFloat(i4));
                            }
                            locationEntity.setBarometric(f4);
                            int i5 = columnIndexOrThrow15;
                            if (query.isNull(i5)) {
                                i2 = i5;
                                str3 = null;
                            } else {
                                i2 = i5;
                                str3 = query.getString(i5);
                            }
                            locationEntity.setPermissions(str3);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(locationEntity);
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

    public Object getLocationsBetweenDates(long j, long j2, Continuation<? super List<LocationEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM location_tbl WHERE timeStamp >= ? AND timeStamp <= ?", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<LocationEntity>>() {
            public List<LocationEntity> call() {
                Double d;
                Double d2;
                Double d3;
                Double d4;
                Float f;
                Float f2;
                Float f3;
                Integer num;
                String str;
                Long l;
                String str2;
                int i;
                Float f4;
                int i2;
                String str3;
                AnonymousClass11 r1 = this;
                Cursor query = DBUtil.query(LocationDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "bearing");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "speed");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneId");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, IronSourceConstants.EVENTS_PROVIDER);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i3 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            LocationEntity locationEntity = new LocationEntity();
                            ArrayList arrayList2 = arrayList;
                            locationEntity.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(columnIndexOrThrow2));
                            }
                            locationEntity.setAltitude(d);
                            if (query.isNull(columnIndexOrThrow3)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(columnIndexOrThrow3));
                            }
                            locationEntity.setLongitude(d2);
                            if (query.isNull(columnIndexOrThrow4)) {
                                d3 = null;
                            } else {
                                d3 = Double.valueOf(query.getDouble(columnIndexOrThrow4));
                            }
                            locationEntity.setLatitude(d3);
                            if (query.isNull(columnIndexOrThrow5)) {
                                d4 = null;
                            } else {
                                d4 = Double.valueOf(query.getDouble(columnIndexOrThrow5));
                            }
                            locationEntity.setIndoorOutdoorWeight(d4);
                            if (query.isNull(columnIndexOrThrow6)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                            }
                            locationEntity.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow7)) {
                                f2 = null;
                            } else {
                                f2 = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                            }
                            locationEntity.setBearing(f2);
                            if (query.isNull(columnIndexOrThrow8)) {
                                f3 = null;
                            } else {
                                f3 = Float.valueOf(query.getFloat(columnIndexOrThrow8));
                            }
                            locationEntity.setSpeed(f3);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            locationEntity.setTimeZoneOffset(num);
                            if (query.isNull(columnIndexOrThrow10)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow10);
                            }
                            locationEntity.setTimeZoneId(str);
                            if (query.isNull(columnIndexOrThrow11)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow11));
                            }
                            locationEntity.setTimeStamp(l);
                            locationEntity.setTransmitted(query.getInt(columnIndexOrThrow12));
                            if (query.isNull(columnIndexOrThrow13)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow13);
                            }
                            locationEntity.setProvider(str2);
                            int i4 = i3;
                            if (query.isNull(i4)) {
                                i = columnIndexOrThrow;
                                f4 = null;
                            } else {
                                i = columnIndexOrThrow;
                                f4 = Float.valueOf(query.getFloat(i4));
                            }
                            locationEntity.setBarometric(f4);
                            int i5 = columnIndexOrThrow15;
                            if (query.isNull(i5)) {
                                i2 = i5;
                                str3 = null;
                            } else {
                                i2 = i5;
                                str3 = query.getString(i5);
                            }
                            locationEntity.setPermissions(str3);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(locationEntity);
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

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearLocationTable$0$com-m2catalyst-m2sdk-database-daos-LocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m2157lambda$clearLocationTable$0$comm2catalystm2sdkdatabasedaosLocationDao_Impl(Continuation continuation) {
        return LocationDao.DefaultImpls.clearLocationTable(this, continuation);
    }

    public Object markLocationAsTransmitted(final int i, final int i2, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = LocationDao_Impl.this.__preparedStmtOfMarkLocationAsTransmitted.acquire();
                acquire.bindLong(1, (long) i);
                acquire.bindLong(2, (long) i2);
                LocationDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    LocationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LocationDao_Impl.this.__db.endTransaction();
                    LocationDao_Impl.this.__preparedStmtOfMarkLocationAsTransmitted.release(acquire);
                }
            }
        }, continuation);
    }

    public Object resetLocationTable(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = LocationDao_Impl.this.__preparedStmtOfResetLocationTable.acquire();
                LocationDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    LocationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LocationDao_Impl.this.__db.endTransaction();
                    LocationDao_Impl.this.__preparedStmtOfResetLocationTable.release(acquire);
                }
            }
        }, continuation);
    }
}
