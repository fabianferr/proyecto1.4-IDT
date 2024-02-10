package com.m2catalyst.m2sdk.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class NDTDao_Impl implements NDTDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<NetworkDiagnosticsEntity> __deletionAdapterOfNetworkDiagnosticsEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<NetworkDiagnosticsEntity> __insertionAdapterOfNetworkDiagnosticsEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllEntries;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfResetNDTTable;

    public NDTDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNetworkDiagnosticsEntity = new EntityInsertionAdapter<NetworkDiagnosticsEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `diagnostics_tbl` (`id`,`startTest`,`endTest`,`serverIP`,`timeOffset`,`connectionType`,`uploadDataUsed`,`downloadDataUsed`,`transmitted`,`cellID`,`cellIDChanged`,`mnsiID`,`testTrigger`,`testType`,`wifiNetworkInfoID`,`uploadAlgorithm`,`downloadAlgorithm`,`latencyAlgorithm`,`latencyMin`,`latencyMax`,`latencyAvg`,`latencyDev`,`jitter`,`uploadMin`,`uploadMax`,`uploadAvg`,`downloadMin`,`downloadMax`,`downloadAvg`,`locationDiff`,`permissions`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, NetworkDiagnosticsEntity networkDiagnosticsEntity) {
                supportSQLiteStatement.bindLong(1, networkDiagnosticsEntity.getId());
                supportSQLiteStatement.bindLong(2, networkDiagnosticsEntity.getStartTest());
                supportSQLiteStatement.bindLong(3, networkDiagnosticsEntity.getEndTest());
                if (networkDiagnosticsEntity.getServerIP() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, networkDiagnosticsEntity.getServerIP());
                }
                if (networkDiagnosticsEntity.getTimeOffset() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, (long) networkDiagnosticsEntity.getTimeOffset().intValue());
                }
                if (networkDiagnosticsEntity.getConnectionType() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, (long) networkDiagnosticsEntity.getConnectionType().intValue());
                }
                if (networkDiagnosticsEntity.getUploadDataUsed() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) networkDiagnosticsEntity.getUploadDataUsed().intValue());
                }
                if (networkDiagnosticsEntity.getDownloadDataUsed() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, (long) networkDiagnosticsEntity.getDownloadDataUsed().intValue());
                }
                supportSQLiteStatement.bindLong(9, (long) networkDiagnosticsEntity.getTransmitted());
                if (networkDiagnosticsEntity.getCellID() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, networkDiagnosticsEntity.getCellID());
                }
                if (networkDiagnosticsEntity.getCellIDChanged() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, (long) networkDiagnosticsEntity.getCellIDChanged().intValue());
                }
                if (networkDiagnosticsEntity.getMnsiID() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, (long) networkDiagnosticsEntity.getMnsiID().intValue());
                }
                if (networkDiagnosticsEntity.getTestTrigger() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, (long) networkDiagnosticsEntity.getTestTrigger().intValue());
                }
                if (networkDiagnosticsEntity.getTestType() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) networkDiagnosticsEntity.getTestType().intValue());
                }
                if (networkDiagnosticsEntity.getWifiNetworkInfoID() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, (long) networkDiagnosticsEntity.getWifiNetworkInfoID().intValue());
                }
                if (networkDiagnosticsEntity.getUploadAlgorithm() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindLong(16, (long) networkDiagnosticsEntity.getUploadAlgorithm().intValue());
                }
                if (networkDiagnosticsEntity.getDownloadAlgorithm() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, (long) networkDiagnosticsEntity.getDownloadAlgorithm().intValue());
                }
                if (networkDiagnosticsEntity.getLatencyAlgorithm() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindLong(18, (long) networkDiagnosticsEntity.getLatencyAlgorithm().intValue());
                }
                if (networkDiagnosticsEntity.getLatencyMin() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindDouble(19, networkDiagnosticsEntity.getLatencyMin().doubleValue());
                }
                if (networkDiagnosticsEntity.getLatencyMax() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindDouble(20, networkDiagnosticsEntity.getLatencyMax().doubleValue());
                }
                if (networkDiagnosticsEntity.getLatencyAvg() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindDouble(21, networkDiagnosticsEntity.getLatencyAvg().doubleValue());
                }
                if (networkDiagnosticsEntity.getLatencyDev() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindDouble(22, networkDiagnosticsEntity.getLatencyDev().doubleValue());
                }
                if (networkDiagnosticsEntity.getJitter() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindDouble(23, networkDiagnosticsEntity.getJitter().doubleValue());
                }
                if (networkDiagnosticsEntity.getUploadMin() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindDouble(24, networkDiagnosticsEntity.getUploadMin().doubleValue());
                }
                if (networkDiagnosticsEntity.getUploadMax() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindDouble(25, networkDiagnosticsEntity.getUploadMax().doubleValue());
                }
                if (networkDiagnosticsEntity.getUploadAvg() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindDouble(26, networkDiagnosticsEntity.getUploadAvg().doubleValue());
                }
                if (networkDiagnosticsEntity.getDownloadMin() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindDouble(27, networkDiagnosticsEntity.getDownloadMin().doubleValue());
                }
                if (networkDiagnosticsEntity.getDownloadMax() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindDouble(28, networkDiagnosticsEntity.getDownloadMax().doubleValue());
                }
                if (networkDiagnosticsEntity.getDownloadAvg() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindDouble(29, networkDiagnosticsEntity.getDownloadAvg().doubleValue());
                }
                if (networkDiagnosticsEntity.getLocationDiff() == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindDouble(30, networkDiagnosticsEntity.getLocationDiff().doubleValue());
                }
                if (networkDiagnosticsEntity.getPermissions() == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, networkDiagnosticsEntity.getPermissions());
                }
            }
        };
        this.__deletionAdapterOfNetworkDiagnosticsEntity = new EntityDeletionOrUpdateAdapter<NetworkDiagnosticsEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `diagnostics_tbl` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, NetworkDiagnosticsEntity networkDiagnosticsEntity) {
                supportSQLiteStatement.bindLong(1, networkDiagnosticsEntity.getId());
            }
        };
        this.__preparedStmtOfResetNDTTable = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM sqlite_sequence WHERE name='diagnostics_tbl'";
            }
        };
        this.__preparedStmtOfDeleteAllEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM diagnostics_tbl";
            }
        };
    }

    /* access modifiers changed from: private */
    public NetworkDiagnosticsEntity __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesNetworkDiagnosticsEntity(Cursor cursor) {
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Double d5;
        Double d6;
        Double d7;
        Double d8;
        Double d9;
        Double d10;
        Double d11;
        Double d12;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        String str;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        String str2;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("startTest");
        int columnIndex3 = cursor2.getColumnIndex("endTest");
        int columnIndex4 = cursor2.getColumnIndex("serverIP");
        int columnIndex5 = cursor2.getColumnIndex("timeOffset");
        int columnIndex6 = cursor2.getColumnIndex("connectionType");
        int columnIndex7 = cursor2.getColumnIndex("uploadDataUsed");
        int columnIndex8 = cursor2.getColumnIndex("downloadDataUsed");
        int columnIndex9 = cursor2.getColumnIndex("transmitted");
        int columnIndex10 = cursor2.getColumnIndex("cellID");
        int columnIndex11 = cursor2.getColumnIndex("cellIDChanged");
        int columnIndex12 = cursor2.getColumnIndex("mnsiID");
        int columnIndex13 = cursor2.getColumnIndex("testTrigger");
        int columnIndex14 = cursor2.getColumnIndex("testType");
        int columnIndex15 = cursor2.getColumnIndex("wifiNetworkInfoID");
        int columnIndex16 = cursor2.getColumnIndex("uploadAlgorithm");
        int columnIndex17 = cursor2.getColumnIndex("downloadAlgorithm");
        int columnIndex18 = cursor2.getColumnIndex("latencyAlgorithm");
        int columnIndex19 = cursor2.getColumnIndex("latencyMin");
        int columnIndex20 = cursor2.getColumnIndex("latencyMax");
        int columnIndex21 = cursor2.getColumnIndex("latencyAvg");
        int columnIndex22 = cursor2.getColumnIndex("latencyDev");
        int columnIndex23 = cursor2.getColumnIndex("jitter");
        int columnIndex24 = cursor2.getColumnIndex("uploadMin");
        int columnIndex25 = cursor2.getColumnIndex("uploadMax");
        int columnIndex26 = cursor2.getColumnIndex("uploadAvg");
        int columnIndex27 = cursor2.getColumnIndex("downloadMin");
        int columnIndex28 = cursor2.getColumnIndex("downloadMax");
        int columnIndex29 = cursor2.getColumnIndex("downloadAvg");
        int columnIndex30 = cursor2.getColumnIndex("locationDiff");
        int columnIndex31 = cursor2.getColumnIndex("permissions");
        NetworkDiagnosticsEntity networkDiagnosticsEntity = new NetworkDiagnosticsEntity();
        int i = columnIndex14;
        int i2 = columnIndex12;
        int i3 = columnIndex13;
        if (columnIndex != -1) {
            networkDiagnosticsEntity.setId(cursor2.getLong(columnIndex));
        }
        if (columnIndex2 != -1) {
            networkDiagnosticsEntity.setStartTest(cursor2.getLong(columnIndex2));
        }
        if (columnIndex3 != -1) {
            networkDiagnosticsEntity.setEndTest(cursor2.getLong(columnIndex3));
        }
        String str3 = null;
        if (columnIndex4 != -1) {
            if (cursor2.isNull(columnIndex4)) {
                str2 = null;
            } else {
                str2 = cursor2.getString(columnIndex4);
            }
            networkDiagnosticsEntity.setServerIP(str2);
        }
        if (columnIndex5 != -1) {
            if (cursor2.isNull(columnIndex5)) {
                num12 = null;
            } else {
                num12 = Integer.valueOf(cursor2.getInt(columnIndex5));
            }
            networkDiagnosticsEntity.setTimeOffset(num12);
        }
        if (columnIndex6 != -1) {
            if (cursor2.isNull(columnIndex6)) {
                num11 = null;
            } else {
                num11 = Integer.valueOf(cursor2.getInt(columnIndex6));
            }
            networkDiagnosticsEntity.setConnectionType(num11);
        }
        if (columnIndex7 != -1) {
            if (cursor2.isNull(columnIndex7)) {
                num10 = null;
            } else {
                num10 = Integer.valueOf(cursor2.getInt(columnIndex7));
            }
            networkDiagnosticsEntity.setUploadDataUsed(num10);
        }
        if (columnIndex8 != -1) {
            if (cursor2.isNull(columnIndex8)) {
                num9 = null;
            } else {
                num9 = Integer.valueOf(cursor2.getInt(columnIndex8));
            }
            networkDiagnosticsEntity.setDownloadDataUsed(num9);
        }
        if (columnIndex9 != -1) {
            networkDiagnosticsEntity.setTransmitted(cursor2.getInt(columnIndex9));
        }
        if (columnIndex10 != -1) {
            if (cursor2.isNull(columnIndex10)) {
                str = null;
            } else {
                str = cursor2.getString(columnIndex10);
            }
            networkDiagnosticsEntity.setCellID(str);
        }
        if (columnIndex11 != -1) {
            if (cursor2.isNull(columnIndex11)) {
                num8 = null;
            } else {
                num8 = Integer.valueOf(cursor2.getInt(columnIndex11));
            }
            networkDiagnosticsEntity.setCellIDChanged(num8);
        }
        int i4 = i2;
        if (i4 != -1) {
            if (cursor2.isNull(i4)) {
                num7 = null;
            } else {
                num7 = Integer.valueOf(cursor2.getInt(i4));
            }
            networkDiagnosticsEntity.setMnsiID(num7);
        }
        int i5 = i3;
        if (i5 != -1) {
            if (cursor2.isNull(i5)) {
                num6 = null;
            } else {
                num6 = Integer.valueOf(cursor2.getInt(i5));
            }
            networkDiagnosticsEntity.setTestTrigger(num6);
        }
        int i6 = i;
        if (i6 != -1) {
            if (cursor2.isNull(i6)) {
                num5 = null;
            } else {
                num5 = Integer.valueOf(cursor2.getInt(i6));
            }
            networkDiagnosticsEntity.setTestType(num5);
        }
        int i7 = columnIndex15;
        if (i7 != -1) {
            if (cursor2.isNull(i7)) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(cursor2.getInt(i7));
            }
            networkDiagnosticsEntity.setWifiNetworkInfoID(num4);
        }
        int i8 = columnIndex16;
        if (i8 != -1) {
            if (cursor2.isNull(i8)) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor2.getInt(i8));
            }
            networkDiagnosticsEntity.setUploadAlgorithm(num3);
        }
        int i9 = columnIndex17;
        if (i9 != -1) {
            if (cursor2.isNull(i9)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor2.getInt(i9));
            }
            networkDiagnosticsEntity.setDownloadAlgorithm(num2);
        }
        int i10 = columnIndex18;
        if (i10 != -1) {
            if (cursor2.isNull(i10)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(i10));
            }
            networkDiagnosticsEntity.setLatencyAlgorithm(num);
        }
        int i11 = columnIndex19;
        if (i11 != -1) {
            if (cursor2.isNull(i11)) {
                d12 = null;
            } else {
                d12 = Double.valueOf(cursor2.getDouble(i11));
            }
            networkDiagnosticsEntity.setLatencyMin(d12);
        }
        int i12 = columnIndex20;
        if (i12 != -1) {
            if (cursor2.isNull(i12)) {
                d11 = null;
            } else {
                d11 = Double.valueOf(cursor2.getDouble(i12));
            }
            networkDiagnosticsEntity.setLatencyMax(d11);
        }
        int i13 = columnIndex21;
        if (i13 != -1) {
            if (cursor2.isNull(i13)) {
                d10 = null;
            } else {
                d10 = Double.valueOf(cursor2.getDouble(i13));
            }
            networkDiagnosticsEntity.setLatencyAvg(d10);
        }
        int i14 = columnIndex22;
        if (i14 != -1) {
            if (cursor2.isNull(i14)) {
                d9 = null;
            } else {
                d9 = Double.valueOf(cursor2.getDouble(i14));
            }
            networkDiagnosticsEntity.setLatencyDev(d9);
        }
        int i15 = columnIndex23;
        if (i15 != -1) {
            if (cursor2.isNull(i15)) {
                d8 = null;
            } else {
                d8 = Double.valueOf(cursor2.getDouble(i15));
            }
            networkDiagnosticsEntity.setJitter(d8);
        }
        int i16 = columnIndex24;
        if (i16 != -1) {
            if (cursor2.isNull(i16)) {
                d7 = null;
            } else {
                d7 = Double.valueOf(cursor2.getDouble(i16));
            }
            networkDiagnosticsEntity.setUploadMin(d7);
        }
        int i17 = columnIndex25;
        if (i17 != -1) {
            if (cursor2.isNull(i17)) {
                d6 = null;
            } else {
                d6 = Double.valueOf(cursor2.getDouble(i17));
            }
            networkDiagnosticsEntity.setUploadMax(d6);
        }
        int i18 = columnIndex26;
        if (i18 != -1) {
            if (cursor2.isNull(i18)) {
                d5 = null;
            } else {
                d5 = Double.valueOf(cursor2.getDouble(i18));
            }
            networkDiagnosticsEntity.setUploadAvg(d5);
        }
        int i19 = columnIndex27;
        if (i19 != -1) {
            if (cursor2.isNull(i19)) {
                d4 = null;
            } else {
                d4 = Double.valueOf(cursor2.getDouble(i19));
            }
            networkDiagnosticsEntity.setDownloadMin(d4);
        }
        int i20 = columnIndex28;
        if (i20 != -1) {
            if (cursor2.isNull(i20)) {
                d3 = null;
            } else {
                d3 = Double.valueOf(cursor2.getDouble(i20));
            }
            networkDiagnosticsEntity.setDownloadMax(d3);
        }
        int i21 = columnIndex29;
        if (i21 != -1) {
            if (cursor2.isNull(i21)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(i21));
            }
            networkDiagnosticsEntity.setDownloadAvg(d2);
        }
        int i22 = columnIndex30;
        if (i22 != -1) {
            if (cursor2.isNull(i22)) {
                d = null;
            } else {
                d = Double.valueOf(cursor2.getDouble(i22));
            }
            networkDiagnosticsEntity.setLocationDiff(d);
        }
        int i23 = columnIndex31;
        if (i23 != -1) {
            if (!cursor2.isNull(i23)) {
                str3 = cursor2.getString(i23);
            }
            networkDiagnosticsEntity.setPermissions(str3);
        }
        return networkDiagnosticsEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addEntries(final List<NetworkDiagnosticsEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    NDTDao_Impl.this.__insertionAdapterOfNetworkDiagnosticsEntity.insert(list);
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object clearNDTTable(Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new NDTDao_Impl$$ExternalSyntheticLambda0(this), continuation);
    }

    public Object deleteAllEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = NDTDao_Impl.this.__preparedStmtOfDeleteAllEntries.acquire();
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                    NDTDao_Impl.this.__preparedStmtOfDeleteAllEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object deleteEntries(final List<NetworkDiagnosticsEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    NDTDao_Impl.this.__deletionAdapterOfNetworkDiagnosticsEntity.handleMultiple(list);
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object getDiagnostics(Continuation<? super List<NetworkDiagnosticsEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM diagnostics_tbl ORDER BY id ASC", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<NetworkDiagnosticsEntity>>() {
            public List<NetworkDiagnosticsEntity> call() {
                AnonymousClass10 r3;
                String str;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                String str2;
                Integer num5;
                Integer num6;
                int i;
                Integer num7;
                int i2;
                Integer num8;
                int i3;
                Integer num9;
                Integer num10;
                Integer num11;
                Integer num12;
                Double d;
                Double d2;
                Double d3;
                Double d4;
                Double d5;
                Double d6;
                Double d7;
                Double d8;
                Double d9;
                Double d10;
                Double d11;
                Double d12;
                String str3;
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "startTest");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "endTest");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "serverIP");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timeOffset");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connectionType");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "uploadDataUsed");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "downloadDataUsed");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cellID");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "cellIDChanged");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mnsiID");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "testTrigger");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "testType");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "wifiNetworkInfoID");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "uploadAlgorithm");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "downloadAlgorithm");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "latencyAlgorithm");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "latencyMin");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "latencyMax");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "latencyAvg");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "latencyDev");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "uploadMin");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "uploadMax");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "uploadAvg");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "downloadMin");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "downloadMax");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "downloadAvg");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "locationDiff");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int i4 = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            NetworkDiagnosticsEntity networkDiagnosticsEntity = new NetworkDiagnosticsEntity();
                            int i5 = columnIndexOrThrow12;
                            int i6 = columnIndexOrThrow13;
                            networkDiagnosticsEntity.setId(query.getLong(columnIndexOrThrow));
                            networkDiagnosticsEntity.setStartTest(query.getLong(columnIndexOrThrow2));
                            networkDiagnosticsEntity.setEndTest(query.getLong(columnIndexOrThrow3));
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            networkDiagnosticsEntity.setServerIP(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            networkDiagnosticsEntity.setTimeOffset(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            networkDiagnosticsEntity.setConnectionType(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            networkDiagnosticsEntity.setUploadDataUsed(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            networkDiagnosticsEntity.setDownloadDataUsed(num4);
                            networkDiagnosticsEntity.setTransmitted(query.getInt(columnIndexOrThrow9));
                            if (query.isNull(columnIndexOrThrow10)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow10);
                            }
                            networkDiagnosticsEntity.setCellID(str2);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            networkDiagnosticsEntity.setCellIDChanged(num5);
                            columnIndexOrThrow12 = i5;
                            if (query.isNull(columnIndexOrThrow12)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            networkDiagnosticsEntity.setMnsiID(num6);
                            columnIndexOrThrow13 = i6;
                            if (query.isNull(columnIndexOrThrow13)) {
                                i = columnIndexOrThrow;
                                num7 = null;
                            } else {
                                i = columnIndexOrThrow;
                                num7 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                            }
                            networkDiagnosticsEntity.setTestTrigger(num7);
                            int i7 = i4;
                            if (query.isNull(i7)) {
                                i2 = i7;
                                num8 = null;
                            } else {
                                i2 = i7;
                                num8 = Integer.valueOf(query.getInt(i7));
                            }
                            networkDiagnosticsEntity.setTestType(num8);
                            int i8 = columnIndexOrThrow15;
                            if (query.isNull(i8)) {
                                i3 = i8;
                                num9 = null;
                            } else {
                                i3 = i8;
                                num9 = Integer.valueOf(query.getInt(i8));
                            }
                            networkDiagnosticsEntity.setWifiNetworkInfoID(num9);
                            int i9 = columnIndexOrThrow16;
                            if (query.isNull(i9)) {
                                columnIndexOrThrow16 = i9;
                                num10 = null;
                            } else {
                                columnIndexOrThrow16 = i9;
                                num10 = Integer.valueOf(query.getInt(i9));
                            }
                            networkDiagnosticsEntity.setUploadAlgorithm(num10);
                            int i10 = columnIndexOrThrow17;
                            if (query.isNull(i10)) {
                                columnIndexOrThrow17 = i10;
                                num11 = null;
                            } else {
                                columnIndexOrThrow17 = i10;
                                num11 = Integer.valueOf(query.getInt(i10));
                            }
                            networkDiagnosticsEntity.setDownloadAlgorithm(num11);
                            int i11 = columnIndexOrThrow18;
                            if (query.isNull(i11)) {
                                columnIndexOrThrow18 = i11;
                                num12 = null;
                            } else {
                                columnIndexOrThrow18 = i11;
                                num12 = Integer.valueOf(query.getInt(i11));
                            }
                            networkDiagnosticsEntity.setLatencyAlgorithm(num12);
                            int i12 = columnIndexOrThrow19;
                            if (query.isNull(i12)) {
                                columnIndexOrThrow19 = i12;
                                d = null;
                            } else {
                                columnIndexOrThrow19 = i12;
                                d = Double.valueOf(query.getDouble(i12));
                            }
                            networkDiagnosticsEntity.setLatencyMin(d);
                            int i13 = columnIndexOrThrow20;
                            if (query.isNull(i13)) {
                                columnIndexOrThrow20 = i13;
                                d2 = null;
                            } else {
                                columnIndexOrThrow20 = i13;
                                d2 = Double.valueOf(query.getDouble(i13));
                            }
                            networkDiagnosticsEntity.setLatencyMax(d2);
                            int i14 = columnIndexOrThrow21;
                            if (query.isNull(i14)) {
                                columnIndexOrThrow21 = i14;
                                d3 = null;
                            } else {
                                columnIndexOrThrow21 = i14;
                                d3 = Double.valueOf(query.getDouble(i14));
                            }
                            networkDiagnosticsEntity.setLatencyAvg(d3);
                            int i15 = columnIndexOrThrow22;
                            if (query.isNull(i15)) {
                                columnIndexOrThrow22 = i15;
                                d4 = null;
                            } else {
                                columnIndexOrThrow22 = i15;
                                d4 = Double.valueOf(query.getDouble(i15));
                            }
                            networkDiagnosticsEntity.setLatencyDev(d4);
                            int i16 = columnIndexOrThrow23;
                            if (query.isNull(i16)) {
                                columnIndexOrThrow23 = i16;
                                d5 = null;
                            } else {
                                columnIndexOrThrow23 = i16;
                                d5 = Double.valueOf(query.getDouble(i16));
                            }
                            networkDiagnosticsEntity.setJitter(d5);
                            int i17 = columnIndexOrThrow24;
                            if (query.isNull(i17)) {
                                columnIndexOrThrow24 = i17;
                                d6 = null;
                            } else {
                                columnIndexOrThrow24 = i17;
                                d6 = Double.valueOf(query.getDouble(i17));
                            }
                            networkDiagnosticsEntity.setUploadMin(d6);
                            int i18 = columnIndexOrThrow25;
                            if (query.isNull(i18)) {
                                columnIndexOrThrow25 = i18;
                                d7 = null;
                            } else {
                                columnIndexOrThrow25 = i18;
                                d7 = Double.valueOf(query.getDouble(i18));
                            }
                            networkDiagnosticsEntity.setUploadMax(d7);
                            int i19 = columnIndexOrThrow26;
                            if (query.isNull(i19)) {
                                columnIndexOrThrow26 = i19;
                                d8 = null;
                            } else {
                                columnIndexOrThrow26 = i19;
                                d8 = Double.valueOf(query.getDouble(i19));
                            }
                            networkDiagnosticsEntity.setUploadAvg(d8);
                            int i20 = columnIndexOrThrow27;
                            if (query.isNull(i20)) {
                                columnIndexOrThrow27 = i20;
                                d9 = null;
                            } else {
                                columnIndexOrThrow27 = i20;
                                d9 = Double.valueOf(query.getDouble(i20));
                            }
                            networkDiagnosticsEntity.setDownloadMin(d9);
                            int i21 = columnIndexOrThrow28;
                            if (query.isNull(i21)) {
                                columnIndexOrThrow28 = i21;
                                d10 = null;
                            } else {
                                columnIndexOrThrow28 = i21;
                                d10 = Double.valueOf(query.getDouble(i21));
                            }
                            networkDiagnosticsEntity.setDownloadMax(d10);
                            int i22 = columnIndexOrThrow29;
                            if (query.isNull(i22)) {
                                columnIndexOrThrow29 = i22;
                                d11 = null;
                            } else {
                                columnIndexOrThrow29 = i22;
                                d11 = Double.valueOf(query.getDouble(i22));
                            }
                            networkDiagnosticsEntity.setDownloadAvg(d11);
                            int i23 = columnIndexOrThrow30;
                            if (query.isNull(i23)) {
                                columnIndexOrThrow30 = i23;
                                d12 = null;
                            } else {
                                columnIndexOrThrow30 = i23;
                                d12 = Double.valueOf(query.getDouble(i23));
                            }
                            networkDiagnosticsEntity.setLocationDiff(d12);
                            int i24 = columnIndexOrThrow31;
                            if (query.isNull(i24)) {
                                columnIndexOrThrow31 = i24;
                                str3 = null;
                            } else {
                                columnIndexOrThrow31 = i24;
                                str3 = query.getString(i24);
                            }
                            networkDiagnosticsEntity.setPermissions(str3);
                            arrayList.add(networkDiagnosticsEntity);
                            columnIndexOrThrow15 = i3;
                            i4 = i2;
                            columnIndexOrThrow = i;
                        }
                        query.close();
                        acquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        query.close();
                        acquire.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object getDiagnosticsTestCount(Continuation<? super Long> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT (id) FROM diagnostics_tbl", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Long>() {
            public Long call() {
                Long l = null;
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    if (query.moveToFirst()) {
                        if (!query.isNull(0)) {
                            l = Long.valueOf(query.getLong(0));
                        }
                    }
                    return l;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getDiagnosticsWhereClause(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<NetworkDiagnosticsEntity>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<NetworkDiagnosticsEntity>>() {
            public List<NetworkDiagnosticsEntity> call() {
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(NDTDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesNetworkDiagnosticsEntity(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object getNetworkDiagnosticsMNSI(int i, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT mnsiID FROM diagnostics_tbl WHERE id = ?", 1);
        acquire.bindLong(1, (long) i);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() {
            public Integer call() {
                Integer num = null;
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    if (query.moveToFirst()) {
                        if (!query.isNull(0)) {
                            num = Integer.valueOf(query.getInt(0));
                        }
                    }
                    return num;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    public Object getTestById(long j, Continuation<? super NetworkDiagnosticsEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM diagnostics_tbl WHERE id = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<NetworkDiagnosticsEntity>() {
            public NetworkDiagnosticsEntity call() {
                NetworkDiagnosticsEntity networkDiagnosticsEntity;
                String str;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                String str2;
                Integer num5;
                Integer num6;
                Integer num7;
                Integer num8;
                Integer num9;
                Integer num10;
                Integer num11;
                Integer num12;
                Double d;
                Double d2;
                Double d3;
                Double d4;
                Double d5;
                Double d6;
                Double d7;
                Double d8;
                Double d9;
                Double d10;
                Double d11;
                Double d12;
                String str3;
                AnonymousClass14 r1 = this;
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "startTest");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "endTest");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "serverIP");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timeOffset");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "connectionType");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "uploadDataUsed");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "downloadDataUsed");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "cellID");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "cellIDChanged");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mnsiID");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "testTrigger");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "testType");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "wifiNetworkInfoID");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "uploadAlgorithm");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "downloadAlgorithm");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "latencyAlgorithm");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "latencyMin");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "latencyMax");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "latencyAvg");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "latencyDev");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "uploadMin");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "uploadMax");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "uploadAvg");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "downloadMin");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "downloadMax");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "downloadAvg");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "locationDiff");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        if (query.moveToFirst()) {
                            int i = columnIndexOrThrow31;
                            NetworkDiagnosticsEntity networkDiagnosticsEntity2 = new NetworkDiagnosticsEntity();
                            int i2 = columnIndexOrThrow12;
                            int i3 = columnIndexOrThrow13;
                            networkDiagnosticsEntity2.setId(query.getLong(columnIndexOrThrow));
                            networkDiagnosticsEntity2.setStartTest(query.getLong(columnIndexOrThrow2));
                            networkDiagnosticsEntity2.setEndTest(query.getLong(columnIndexOrThrow3));
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            networkDiagnosticsEntity2.setServerIP(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                            }
                            networkDiagnosticsEntity2.setTimeOffset(num);
                            if (query.isNull(columnIndexOrThrow6)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                            }
                            networkDiagnosticsEntity2.setConnectionType(num2);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            networkDiagnosticsEntity2.setUploadDataUsed(num3);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            networkDiagnosticsEntity2.setDownloadDataUsed(num4);
                            networkDiagnosticsEntity2.setTransmitted(query.getInt(columnIndexOrThrow9));
                            if (query.isNull(columnIndexOrThrow10)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow10);
                            }
                            networkDiagnosticsEntity2.setCellID(str2);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            networkDiagnosticsEntity2.setCellIDChanged(num5);
                            int i4 = i2;
                            if (query.isNull(i4)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(i4));
                            }
                            networkDiagnosticsEntity2.setMnsiID(num6);
                            int i5 = i3;
                            if (query.isNull(i5)) {
                                num7 = null;
                            } else {
                                num7 = Integer.valueOf(query.getInt(i5));
                            }
                            networkDiagnosticsEntity2.setTestTrigger(num7);
                            if (query.isNull(columnIndexOrThrow14)) {
                                num8 = null;
                            } else {
                                num8 = Integer.valueOf(query.getInt(columnIndexOrThrow14));
                            }
                            networkDiagnosticsEntity2.setTestType(num8);
                            int i6 = columnIndexOrThrow15;
                            if (query.isNull(i6)) {
                                num9 = null;
                            } else {
                                num9 = Integer.valueOf(query.getInt(i6));
                            }
                            networkDiagnosticsEntity2.setWifiNetworkInfoID(num9);
                            int i7 = columnIndexOrThrow16;
                            if (query.isNull(i7)) {
                                num10 = null;
                            } else {
                                num10 = Integer.valueOf(query.getInt(i7));
                            }
                            networkDiagnosticsEntity2.setUploadAlgorithm(num10);
                            int i8 = columnIndexOrThrow17;
                            if (query.isNull(i8)) {
                                num11 = null;
                            } else {
                                num11 = Integer.valueOf(query.getInt(i8));
                            }
                            networkDiagnosticsEntity2.setDownloadAlgorithm(num11);
                            int i9 = columnIndexOrThrow18;
                            if (query.isNull(i9)) {
                                num12 = null;
                            } else {
                                num12 = Integer.valueOf(query.getInt(i9));
                            }
                            networkDiagnosticsEntity2.setLatencyAlgorithm(num12);
                            int i10 = columnIndexOrThrow19;
                            if (query.isNull(i10)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(i10));
                            }
                            networkDiagnosticsEntity2.setLatencyMin(d);
                            int i11 = columnIndexOrThrow20;
                            if (query.isNull(i11)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(i11));
                            }
                            networkDiagnosticsEntity2.setLatencyMax(d2);
                            int i12 = columnIndexOrThrow21;
                            if (query.isNull(i12)) {
                                d3 = null;
                            } else {
                                d3 = Double.valueOf(query.getDouble(i12));
                            }
                            networkDiagnosticsEntity2.setLatencyAvg(d3);
                            int i13 = columnIndexOrThrow22;
                            if (query.isNull(i13)) {
                                d4 = null;
                            } else {
                                d4 = Double.valueOf(query.getDouble(i13));
                            }
                            networkDiagnosticsEntity2.setLatencyDev(d4);
                            int i14 = columnIndexOrThrow23;
                            if (query.isNull(i14)) {
                                d5 = null;
                            } else {
                                d5 = Double.valueOf(query.getDouble(i14));
                            }
                            networkDiagnosticsEntity2.setJitter(d5);
                            int i15 = columnIndexOrThrow24;
                            if (query.isNull(i15)) {
                                d6 = null;
                            } else {
                                d6 = Double.valueOf(query.getDouble(i15));
                            }
                            networkDiagnosticsEntity2.setUploadMin(d6);
                            int i16 = columnIndexOrThrow25;
                            if (query.isNull(i16)) {
                                d7 = null;
                            } else {
                                d7 = Double.valueOf(query.getDouble(i16));
                            }
                            networkDiagnosticsEntity2.setUploadMax(d7);
                            int i17 = columnIndexOrThrow26;
                            if (query.isNull(i17)) {
                                d8 = null;
                            } else {
                                d8 = Double.valueOf(query.getDouble(i17));
                            }
                            networkDiagnosticsEntity2.setUploadAvg(d8);
                            int i18 = columnIndexOrThrow27;
                            if (query.isNull(i18)) {
                                d9 = null;
                            } else {
                                d9 = Double.valueOf(query.getDouble(i18));
                            }
                            networkDiagnosticsEntity2.setDownloadMin(d9);
                            int i19 = columnIndexOrThrow28;
                            if (query.isNull(i19)) {
                                d10 = null;
                            } else {
                                d10 = Double.valueOf(query.getDouble(i19));
                            }
                            networkDiagnosticsEntity2.setDownloadMax(d10);
                            int i20 = columnIndexOrThrow29;
                            if (query.isNull(i20)) {
                                d11 = null;
                            } else {
                                d11 = Double.valueOf(query.getDouble(i20));
                            }
                            networkDiagnosticsEntity2.setDownloadAvg(d11);
                            int i21 = columnIndexOrThrow30;
                            if (query.isNull(i21)) {
                                d12 = null;
                            } else {
                                d12 = Double.valueOf(query.getDouble(i21));
                            }
                            networkDiagnosticsEntity2.setLocationDiff(d12);
                            int i22 = i;
                            if (query.isNull(i22)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(i22);
                            }
                            networkDiagnosticsEntity2.setPermissions(str3);
                            networkDiagnosticsEntity = networkDiagnosticsEntity2;
                        } else {
                            networkDiagnosticsEntity = null;
                        }
                        query.close();
                        acquire.release();
                        return networkDiagnosticsEntity;
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

    public Object insertNetworkDiagnosticsEntry(final NetworkDiagnosticsEntity networkDiagnosticsEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() {
            public Long call() {
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    long insertAndReturnId = NDTDao_Impl.this.__insertionAdapterOfNetworkDiagnosticsEntity.insertAndReturnId(networkDiagnosticsEntity);
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object isCellIdUniqueForNetworkTest(String str, long j, Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT (id) FROM diagnostics_tbl WHERE cellID = ? AND startTest > ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() {
            public Integer call() {
                Integer num = null;
                Cursor query = DBUtil.query(NDTDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    if (query.moveToFirst()) {
                        if (!query.isNull(0)) {
                            num = Integer.valueOf(query.getInt(0));
                        }
                    }
                    return num;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearNDTTable$0$com-m2catalyst-m2sdk-database-daos-NDTDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m2172lambda$clearNDTTable$0$comm2catalystm2sdkdatabasedaosNDTDao_Impl(Continuation continuation) {
        return NDTDao.DefaultImpls.clearNDTTable(this, continuation);
    }

    public Object markDiagnosticsTransmittedEntries(final List<Integer> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                StringBuilder newStringBuilder = StringUtil.newStringBuilder();
                newStringBuilder.append("UPDATE diagnostics_tbl SET transmitted = 1 WHERE id IN (");
                StringUtil.appendPlaceholders(newStringBuilder, list.size());
                newStringBuilder.append(") ");
                SupportSQLiteStatement compileStatement = NDTDao_Impl.this.__db.compileStatement(newStringBuilder.toString());
                int i = 1;
                for (Integer num : list) {
                    if (num == null) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindLong(i, (long) num.intValue());
                    }
                    i++;
                }
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.executeUpdateDelete();
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object resetNDTTable(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = NDTDao_Impl.this.__preparedStmtOfResetNDTTable.acquire();
                NDTDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    NDTDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    NDTDao_Impl.this.__db.endTransaction();
                    NDTDao_Impl.this.__preparedStmtOfResetNDTTable.release(acquire);
                }
            }
        }, continuation);
    }
}
