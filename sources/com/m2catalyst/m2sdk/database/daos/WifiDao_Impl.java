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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.entities.WifiEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class WifiDao_Impl implements WifiDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<WifiEntity> __insertionAdapterOfWifiEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteWifiEntries;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateLastRecordsDataUsage;

    public WifiDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWifiEntity = new EntityInsertionAdapter<WifiEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `wifi_tbl` (`id`,`time_stamp`,`ssid`,`ip_address`,`connection_speed`,`connected_wifi_band_frequency`,`signal_strenth_dbm`,`locationTimeStamp`,`locationProvider`,`accuracy`,`dataRx`,`dataTx`,`transmitted`,`timeZoneOffset`,`latitude`,`longitude`,`permissions`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WifiEntity wifiEntity) {
                supportSQLiteStatement.bindLong(1, (long) wifiEntity.getId());
                if (wifiEntity.getTime_stamp() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, wifiEntity.getTime_stamp().longValue());
                }
                if (wifiEntity.getSsid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, wifiEntity.getSsid());
                }
                if (wifiEntity.getIp_address() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, wifiEntity.getIp_address());
                }
                if (wifiEntity.getConnection_speed() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, (long) wifiEntity.getConnection_speed().intValue());
                }
                if (wifiEntity.getConnected_wifi_band_frequency() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, (long) wifiEntity.getConnected_wifi_band_frequency().intValue());
                }
                if (wifiEntity.getSignal_strenth_dbm() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) wifiEntity.getSignal_strenth_dbm().intValue());
                }
                if (wifiEntity.getLocationTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, wifiEntity.getLocationTimeStamp().longValue());
                }
                if (wifiEntity.getLocationProvider() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, wifiEntity.getLocationProvider());
                }
                if (wifiEntity.getAccuracy() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindDouble(10, (double) wifiEntity.getAccuracy().floatValue());
                }
                if (wifiEntity.getDataRx() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, (long) wifiEntity.getDataRx().intValue());
                }
                if (wifiEntity.getDataTx() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, (long) wifiEntity.getDataTx().intValue());
                }
                supportSQLiteStatement.bindLong(13, (long) wifiEntity.getTransmitted());
                if (wifiEntity.getTimeZoneOffset() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) wifiEntity.getTimeZoneOffset().intValue());
                }
                if (wifiEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindDouble(15, wifiEntity.getLatitude().doubleValue());
                }
                if (wifiEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindDouble(16, wifiEntity.getLongitude().doubleValue());
                }
                if (wifiEntity.getPermissions() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, wifiEntity.getPermissions());
                }
            }
        };
        this.__preparedStmtOfDeleteWifiEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM wifi_tbl";
            }
        };
        this.__preparedStmtOfUpdateLastRecordsDataUsage = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE wifi_tbl SET dataRx = COALESCE(dataRx, 0) + ?, dataTX = COALESCE(dataTx, 0) + ? WHERE id = (SELECT MAX(id) FROM wifi_tbl)";
            }
        };
    }

    /* access modifiers changed from: private */
    public WifiEntity __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesWifiEntity(Cursor cursor) {
        Double d;
        Double d2;
        Integer num;
        Integer num2;
        Integer num3;
        Float f;
        String str;
        Long l;
        Integer num4;
        Integer num5;
        Integer num6;
        String str2;
        String str3;
        Long l2;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("time_stamp");
        int columnIndex3 = cursor2.getColumnIndex("ssid");
        int columnIndex4 = cursor2.getColumnIndex("ip_address");
        int columnIndex5 = cursor2.getColumnIndex("connection_speed");
        int columnIndex6 = cursor2.getColumnIndex("connected_wifi_band_frequency");
        int columnIndex7 = cursor2.getColumnIndex("signal_strenth_dbm");
        int columnIndex8 = cursor2.getColumnIndex("locationTimeStamp");
        int columnIndex9 = cursor2.getColumnIndex("locationProvider");
        int columnIndex10 = cursor2.getColumnIndex("accuracy");
        int columnIndex11 = cursor2.getColumnIndex("dataRx");
        int columnIndex12 = cursor2.getColumnIndex("dataTx");
        int columnIndex13 = cursor2.getColumnIndex("transmitted");
        int columnIndex14 = cursor2.getColumnIndex("timeZoneOffset");
        int columnIndex15 = cursor2.getColumnIndex("latitude");
        int columnIndex16 = cursor2.getColumnIndex("longitude");
        int columnIndex17 = cursor2.getColumnIndex("permissions");
        WifiEntity wifiEntity = new WifiEntity();
        int i = columnIndex14;
        if (columnIndex != -1) {
            wifiEntity.setId(cursor2.getInt(columnIndex));
        }
        String str4 = null;
        if (columnIndex2 != -1) {
            if (cursor2.isNull(columnIndex2)) {
                l2 = null;
            } else {
                l2 = Long.valueOf(cursor2.getLong(columnIndex2));
            }
            wifiEntity.setTime_stamp(l2);
        }
        if (columnIndex3 != -1) {
            if (cursor2.isNull(columnIndex3)) {
                str3 = null;
            } else {
                str3 = cursor2.getString(columnIndex3);
            }
            wifiEntity.setSsid(str3);
        }
        if (columnIndex4 != -1) {
            if (cursor2.isNull(columnIndex4)) {
                str2 = null;
            } else {
                str2 = cursor2.getString(columnIndex4);
            }
            wifiEntity.setIp_address(str2);
        }
        if (columnIndex5 != -1) {
            if (cursor2.isNull(columnIndex5)) {
                num6 = null;
            } else {
                num6 = Integer.valueOf(cursor2.getInt(columnIndex5));
            }
            wifiEntity.setConnection_speed(num6);
        }
        if (columnIndex6 != -1) {
            if (cursor2.isNull(columnIndex6)) {
                num5 = null;
            } else {
                num5 = Integer.valueOf(cursor2.getInt(columnIndex6));
            }
            wifiEntity.setConnected_wifi_band_frequency(num5);
        }
        if (columnIndex7 != -1) {
            if (cursor2.isNull(columnIndex7)) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(cursor2.getInt(columnIndex7));
            }
            wifiEntity.setSignal_strenth_dbm(num4);
        }
        if (columnIndex8 != -1) {
            if (cursor2.isNull(columnIndex8)) {
                l = null;
            } else {
                l = Long.valueOf(cursor2.getLong(columnIndex8));
            }
            wifiEntity.setLocationTimeStamp(l);
        }
        if (columnIndex9 != -1) {
            if (cursor2.isNull(columnIndex9)) {
                str = null;
            } else {
                str = cursor2.getString(columnIndex9);
            }
            wifiEntity.setLocationProvider(str);
        }
        if (columnIndex10 != -1) {
            if (cursor2.isNull(columnIndex10)) {
                f = null;
            } else {
                f = Float.valueOf(cursor2.getFloat(columnIndex10));
            }
            wifiEntity.setAccuracy(f);
        }
        if (columnIndex11 != -1) {
            if (cursor2.isNull(columnIndex11)) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor2.getInt(columnIndex11));
            }
            wifiEntity.setDataRx(num3);
        }
        if (columnIndex12 != -1) {
            if (cursor2.isNull(columnIndex12)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor2.getInt(columnIndex12));
            }
            wifiEntity.setDataTx(num2);
        }
        if (columnIndex13 != -1) {
            wifiEntity.setTransmitted(cursor2.getInt(columnIndex13));
        }
        int i2 = i;
        if (i2 != -1) {
            if (cursor2.isNull(i2)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(i2));
            }
            wifiEntity.setTimeZoneOffset(num);
        }
        int i3 = columnIndex15;
        if (i3 != -1) {
            if (cursor2.isNull(i3)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(i3));
            }
            wifiEntity.setLatitude(d2);
        }
        int i4 = columnIndex16;
        if (i4 != -1) {
            if (cursor2.isNull(i4)) {
                d = null;
            } else {
                d = Double.valueOf(cursor2.getDouble(i4));
            }
            wifiEntity.setLongitude(d);
        }
        int i5 = columnIndex17;
        if (i5 != -1) {
            if (!cursor2.isNull(i5)) {
                str4 = cursor2.getString(i5);
            }
            wifiEntity.setPermissions(str4);
        }
        return wifiEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addEntries(final List<WifiEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                WifiDao_Impl.this.__db.beginTransaction();
                try {
                    WifiDao_Impl.this.__insertionAdapterOfWifiEntity.insert(list);
                    WifiDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    WifiDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object addWifiEntry(final WifiEntity wifiEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() {
            public Long call() {
                WifiDao_Impl.this.__db.beginTransaction();
                try {
                    long insertAndReturnId = WifiDao_Impl.this.__insertionAdapterOfWifiEntity.insertAndReturnId(wifiEntity);
                    WifiDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    WifiDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object deleteWifiEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = WifiDao_Impl.this.__preparedStmtOfDeleteWifiEntries.acquire();
                WifiDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    WifiDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    WifiDao_Impl.this.__db.endTransaction();
                    WifiDao_Impl.this.__preparedStmtOfDeleteWifiEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getLastWifiInfo(Continuation<? super WifiEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wifi_tbl WHERE id = (SELECT MAX(id) FROM wifi_tbl)", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<WifiEntity>() {
            public WifiEntity call() {
                WifiEntity wifiEntity;
                Long l;
                String str;
                String str2;
                Integer num;
                Integer num2;
                Integer num3;
                Long l2;
                String str3;
                Float f;
                Integer num4;
                Integer num5;
                Integer num6;
                Double d;
                Double d2;
                String str4;
                AnonymousClass11 r1 = this;
                Cursor query = DBUtil.query(WifiDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "time_stamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "ssid");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "ip_address");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "connection_speed");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connected_wifi_band_frequency");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "signal_strenth_dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "dataRx");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dataTx");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        if (query.moveToFirst()) {
                            int i = columnIndexOrThrow17;
                            WifiEntity wifiEntity2 = new WifiEntity();
                            wifiEntity2.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow2));
                            }
                            wifiEntity2.setTime_stamp(l);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow3);
                            }
                            wifiEntity2.setSsid(str);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow4);
                            }
                            wifiEntity2.setIp_address(str2);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            wifiEntity2.setConnection_speed(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            wifiEntity2.setConnected_wifi_band_frequency(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            wifiEntity2.setSignal_strenth_dbm(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            }
                            wifiEntity2.setLocationTimeStamp(l2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow9);
                            }
                            wifiEntity2.setLocationProvider(str3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow10));
                            }
                            wifiEntity2.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            wifiEntity2.setDataRx(num4);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            wifiEntity2.setDataTx(num5);
                            wifiEntity2.setTransmitted(query.getInt(columnIndexOrThrow13));
                            if (query.isNull(columnIndexOrThrow14)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow14));
                            }
                            wifiEntity2.setTimeZoneOffset(num6);
                            int i2 = columnIndexOrThrow15;
                            if (query.isNull(i2)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(i2));
                            }
                            wifiEntity2.setLatitude(d);
                            int i3 = columnIndexOrThrow16;
                            if (query.isNull(i3)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(i3));
                            }
                            wifiEntity2.setLongitude(d2);
                            int i4 = i;
                            if (query.isNull(i4)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(i4);
                            }
                            wifiEntity2.setPermissions(str4);
                            wifiEntity = wifiEntity2;
                        } else {
                            wifiEntity = null;
                        }
                        query.close();
                        acquire.release();
                        return wifiEntity;
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

    public Object getWifiInfo(long j, Continuation<? super WifiEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wifi_tbl WHERE id = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<WifiEntity>() {
            public WifiEntity call() {
                WifiEntity wifiEntity;
                Long l;
                String str;
                String str2;
                Integer num;
                Integer num2;
                Integer num3;
                Long l2;
                String str3;
                Float f;
                Integer num4;
                Integer num5;
                Integer num6;
                Double d;
                Double d2;
                String str4;
                AnonymousClass8 r1 = this;
                Cursor query = DBUtil.query(WifiDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "time_stamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "ssid");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "ip_address");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "connection_speed");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connected_wifi_band_frequency");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "signal_strenth_dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "dataRx");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dataTx");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        if (query.moveToFirst()) {
                            int i = columnIndexOrThrow17;
                            WifiEntity wifiEntity2 = new WifiEntity();
                            wifiEntity2.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow2));
                            }
                            wifiEntity2.setTime_stamp(l);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow3);
                            }
                            wifiEntity2.setSsid(str);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow4);
                            }
                            wifiEntity2.setIp_address(str2);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            wifiEntity2.setConnection_speed(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            wifiEntity2.setConnected_wifi_band_frequency(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            wifiEntity2.setSignal_strenth_dbm(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            }
                            wifiEntity2.setLocationTimeStamp(l2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow9);
                            }
                            wifiEntity2.setLocationProvider(str3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow10));
                            }
                            wifiEntity2.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            wifiEntity2.setDataRx(num4);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            wifiEntity2.setDataTx(num5);
                            wifiEntity2.setTransmitted(query.getInt(columnIndexOrThrow13));
                            if (query.isNull(columnIndexOrThrow14)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow14));
                            }
                            wifiEntity2.setTimeZoneOffset(num6);
                            int i2 = columnIndexOrThrow15;
                            if (query.isNull(i2)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(i2));
                            }
                            wifiEntity2.setLatitude(d);
                            int i3 = columnIndexOrThrow16;
                            if (query.isNull(i3)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(i3));
                            }
                            wifiEntity2.setLongitude(d2);
                            int i4 = i;
                            if (query.isNull(i4)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(i4);
                            }
                            wifiEntity2.setPermissions(str4);
                            wifiEntity = wifiEntity2;
                        } else {
                            wifiEntity = null;
                        }
                        query.close();
                        acquire.release();
                        return wifiEntity;
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

    public Object getWifiInfoEntries(String str, String str2, Continuation<? super List<WifiEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wifi_tbl WHERE time_stamp >= ? AND time_stamp <= ?", 2);
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
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<WifiEntity>>() {
            public List<WifiEntity> call() {
                Long l;
                String str;
                String str2;
                Integer num;
                Integer num2;
                Integer num3;
                Long l2;
                String str3;
                Float f;
                Integer num4;
                Integer num5;
                int i;
                Integer num6;
                int i2;
                Double d;
                Double d2;
                String str4;
                AnonymousClass10 r1 = this;
                Cursor query = DBUtil.query(WifiDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "time_stamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "ssid");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "ip_address");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "connection_speed");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connected_wifi_band_frequency");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "signal_strenth_dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "dataRx");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dataTx");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i3 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            WifiEntity wifiEntity = new WifiEntity();
                            ArrayList arrayList2 = arrayList;
                            wifiEntity.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow2));
                            }
                            wifiEntity.setTime_stamp(l);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow3);
                            }
                            wifiEntity.setSsid(str);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow4);
                            }
                            wifiEntity.setIp_address(str2);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            wifiEntity.setConnection_speed(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            wifiEntity.setConnected_wifi_band_frequency(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            wifiEntity.setSignal_strenth_dbm(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            }
                            wifiEntity.setLocationTimeStamp(l2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow9);
                            }
                            wifiEntity.setLocationProvider(str3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow10));
                            }
                            wifiEntity.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            wifiEntity.setDataRx(num4);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            wifiEntity.setDataTx(num5);
                            wifiEntity.setTransmitted(query.getInt(columnIndexOrThrow13));
                            int i4 = i3;
                            if (query.isNull(i4)) {
                                i = columnIndexOrThrow;
                                num6 = null;
                            } else {
                                i = columnIndexOrThrow;
                                num6 = Integer.valueOf(query.getInt(i4));
                            }
                            wifiEntity.setTimeZoneOffset(num6);
                            int i5 = columnIndexOrThrow15;
                            if (query.isNull(i5)) {
                                i2 = i5;
                                d = null;
                            } else {
                                i2 = i5;
                                d = Double.valueOf(query.getDouble(i5));
                            }
                            wifiEntity.setLatitude(d);
                            int i6 = columnIndexOrThrow16;
                            if (query.isNull(i6)) {
                                columnIndexOrThrow16 = i6;
                                d2 = null;
                            } else {
                                columnIndexOrThrow16 = i6;
                                d2 = Double.valueOf(query.getDouble(i6));
                            }
                            wifiEntity.setLongitude(d2);
                            int i7 = columnIndexOrThrow17;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow17 = i7;
                                str4 = null;
                            } else {
                                columnIndexOrThrow17 = i7;
                                str4 = query.getString(i7);
                            }
                            wifiEntity.setPermissions(str4);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(wifiEntity);
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

    public Object getWifiInfoWhereClause(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<WifiEntity>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<WifiEntity>>() {
            public List<WifiEntity> call() {
                Cursor query = DBUtil.query(WifiDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(WifiDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesWifiEntity(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object markWifiTransmittedEntries(final List<Integer> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                StringBuilder newStringBuilder = StringUtil.newStringBuilder();
                newStringBuilder.append("UPDATE wifi_tbl SET transmitted = 1 WHERE id IN (");
                StringUtil.appendPlaceholders(newStringBuilder, list.size());
                newStringBuilder.append(") ");
                SupportSQLiteStatement compileStatement = WifiDao_Impl.this.__db.compileStatement(newStringBuilder.toString());
                int i = 1;
                for (Integer num : list) {
                    if (num == null) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindLong(i, (long) num.intValue());
                    }
                    i++;
                }
                WifiDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.executeUpdateDelete();
                    WifiDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    WifiDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object updateLastRecordsDataUsage(long j, long j2, Continuation<? super Unit> continuation) {
        final long j3 = j;
        final long j4 = j2;
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = WifiDao_Impl.this.__preparedStmtOfUpdateLastRecordsDataUsage.acquire();
                acquire.bindLong(1, j3);
                acquire.bindLong(2, j4);
                WifiDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    WifiDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    WifiDao_Impl.this.__db.endTransaction();
                    WifiDao_Impl.this.__preparedStmtOfUpdateLastRecordsDataUsage.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getWifiInfo(Continuation<? super List<WifiEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wifi_tbl ORDER BY id ASC", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<WifiEntity>>() {
            public List<WifiEntity> call() {
                Long l;
                String str;
                String str2;
                Integer num;
                Integer num2;
                Integer num3;
                Long l2;
                String str3;
                Float f;
                Integer num4;
                Integer num5;
                int i;
                Integer num6;
                int i2;
                Double d;
                Double d2;
                String str4;
                AnonymousClass9 r1 = this;
                Cursor query = DBUtil.query(WifiDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "time_stamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "ssid");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "ip_address");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "connection_speed");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connected_wifi_band_frequency");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "signal_strenth_dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "dataRx");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dataTx");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i3 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            WifiEntity wifiEntity = new WifiEntity();
                            ArrayList arrayList2 = arrayList;
                            wifiEntity.setId(query.getInt(columnIndexOrThrow));
                            if (query.isNull(columnIndexOrThrow2)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow2));
                            }
                            wifiEntity.setTime_stamp(l);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow3);
                            }
                            wifiEntity.setSsid(str);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow4);
                            }
                            wifiEntity.setIp_address(str2);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            wifiEntity.setConnection_speed(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            wifiEntity.setConnected_wifi_band_frequency(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            wifiEntity.setSignal_strenth_dbm(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(columnIndexOrThrow8));
                            }
                            wifiEntity.setLocationTimeStamp(l2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow9);
                            }
                            wifiEntity.setLocationProvider(str3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(columnIndexOrThrow10));
                            }
                            wifiEntity.setAccuracy(f);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            wifiEntity.setDataRx(num4);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            wifiEntity.setDataTx(num5);
                            wifiEntity.setTransmitted(query.getInt(columnIndexOrThrow13));
                            int i4 = i3;
                            if (query.isNull(i4)) {
                                i = columnIndexOrThrow;
                                num6 = null;
                            } else {
                                i = columnIndexOrThrow;
                                num6 = Integer.valueOf(query.getInt(i4));
                            }
                            wifiEntity.setTimeZoneOffset(num6);
                            int i5 = columnIndexOrThrow15;
                            if (query.isNull(i5)) {
                                i2 = i5;
                                d = null;
                            } else {
                                i2 = i5;
                                d = Double.valueOf(query.getDouble(i5));
                            }
                            wifiEntity.setLatitude(d);
                            int i6 = columnIndexOrThrow16;
                            if (query.isNull(i6)) {
                                columnIndexOrThrow16 = i6;
                                d2 = null;
                            } else {
                                columnIndexOrThrow16 = i6;
                                d2 = Double.valueOf(query.getDouble(i6));
                            }
                            wifiEntity.setLongitude(d2);
                            int i7 = columnIndexOrThrow17;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow17 = i7;
                                str4 = null;
                            } else {
                                columnIndexOrThrow17 = i7;
                                str4 = query.getString(i7);
                            }
                            wifiEntity.setPermissions(str4);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(wifiEntity);
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
}
