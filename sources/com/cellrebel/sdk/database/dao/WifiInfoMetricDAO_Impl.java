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
import com.cellrebel.sdk.networking.beans.request.WifiInfoMetric;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WifiInfoMetricDAO_Impl implements WifiInfoMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<WifiInfoMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<WifiInfoMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, WifiInfoMetric wifiInfoMetric) {
            supportSQLiteStatement.bindLong(1, wifiInfoMetric.id);
            String str = wifiInfoMetric.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = wifiInfoMetric.measurementSequenceId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = wifiInfoMetric.dateTimeOfMeasurement;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = wifiInfoMetric.accessTechnology;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = wifiInfoMetric.bssid;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = wifiInfoMetric.ssid;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
            supportSQLiteStatement.bindLong(8, (long) wifiInfoMetric.level);
            supportSQLiteStatement.bindLong(9, wifiInfoMetric.age);
            Boolean bool = wifiInfoMetric.anonymize;
            Integer num = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, (long) valueOf.intValue());
            }
            String str7 = wifiInfoMetric.sdkOrigin;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            supportSQLiteStatement.bindLong(12, (long) wifiInfoMetric.frequency);
            supportSQLiteStatement.bindLong(13, (long) wifiInfoMetric.linkSpeed);
            supportSQLiteStatement.bindLong(14, (long) wifiInfoMetric.maxSupportedRxLinkSpeed);
            supportSQLiteStatement.bindLong(15, (long) wifiInfoMetric.maxSupportedTxLinkSpeed);
            String str8 = wifiInfoMetric.wifiStandard;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str8);
            }
            supportSQLiteStatement.bindLong(17, (long) wifiInfoMetric.networkId);
            Boolean bool2 = wifiInfoMetric.isConnected;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindLong(18, (long) valueOf2.intValue());
            }
            Boolean bool3 = wifiInfoMetric.isRooted;
            if (bool3 != null) {
                num = Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            }
            if (num == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindLong(19, (long) num.intValue());
            }
            supportSQLiteStatement.bindLong(20, (long) wifiInfoMetric.rxLinkSpeed);
            supportSQLiteStatement.bindLong(21, (long) wifiInfoMetric.txLinkSpeed);
            supportSQLiteStatement.bindLong(22, (long) wifiInfoMetric.channelWidth);
            supportSQLiteStatement.bindLong(23, wifiInfoMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `WifiInfoMetric` (`id`,`mobileClientId`,`measurementSequenceId`,`dateTimeOfMeasurement`,`accessTechnology`,`bssid`,`ssid`,`level`,`age`,`anonymize`,`sdkOrigin`,`frequency`,`linkSpeed`,`maxSupportedRxLinkSpeed`,`maxSupportedTxLinkSpeed`,`wifiStandard`,`networkId`,`isConnected`,`isRooted`,`rxLinkSpeed`,`txLinkSpeed`,`channelWidth`,`isSending`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM wifiinfometric";
        }
    }

    public WifiInfoMetricDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> c() {
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

    public void a(WifiInfoMetric wifiInfoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(wifiInfoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<WifiInfoMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<WifiInfoMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        Boolean bool;
        int i;
        int i2;
        Boolean bool2;
        Boolean bool3;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from wifiinfometric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "bssid");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "ssid");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "level");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, IronSourceSegment.AGE);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ThroughputConfigUtil.SHARED_PREFS_KEY_FREQUENCY);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "linkSpeed");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "maxSupportedRxLinkSpeed");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "maxSupportedTxLinkSpeed");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "wifiStandard");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "networkId");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "isConnected");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "rxLinkSpeed");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "txLinkSpeed");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "channelWidth");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    WifiInfoMetric wifiInfoMetric = new WifiInfoMetric();
                    ArrayList arrayList2 = arrayList;
                    int i4 = columnIndexOrThrow13;
                    wifiInfoMetric.id = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        wifiInfoMetric.mobileClientId = null;
                    } else {
                        wifiInfoMetric.mobileClientId = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        wifiInfoMetric.measurementSequenceId = null;
                    } else {
                        wifiInfoMetric.measurementSequenceId = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        wifiInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        wifiInfoMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        wifiInfoMetric.accessTechnology = null;
                    } else {
                        wifiInfoMetric.accessTechnology = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        wifiInfoMetric.bssid = null;
                    } else {
                        wifiInfoMetric.bssid = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        wifiInfoMetric.ssid = null;
                    } else {
                        wifiInfoMetric.ssid = query.getString(columnIndexOrThrow7);
                    }
                    wifiInfoMetric.level = query.getInt(columnIndexOrThrow8);
                    wifiInfoMetric.age = query.getLong(columnIndexOrThrow9);
                    Integer valueOf = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    if (valueOf == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    wifiInfoMetric.anonymize = bool;
                    if (query.isNull(columnIndexOrThrow11)) {
                        wifiInfoMetric.sdkOrigin = null;
                    } else {
                        wifiInfoMetric.sdkOrigin = query.getString(columnIndexOrThrow11);
                    }
                    wifiInfoMetric.frequency = query.getInt(columnIndexOrThrow12);
                    int i5 = i4;
                    wifiInfoMetric.linkSpeed = query.getInt(i5);
                    int i6 = i3;
                    int i7 = columnIndexOrThrow;
                    wifiInfoMetric.maxSupportedRxLinkSpeed = query.getInt(i6);
                    int i8 = columnIndexOrThrow15;
                    int i9 = columnIndexOrThrow12;
                    wifiInfoMetric.maxSupportedTxLinkSpeed = query.getInt(i8);
                    int i10 = columnIndexOrThrow16;
                    if (query.isNull(i10)) {
                        i = i8;
                        wifiInfoMetric.wifiStandard = null;
                    } else {
                        i = i8;
                        wifiInfoMetric.wifiStandard = query.getString(i10);
                    }
                    int i11 = columnIndexOrThrow17;
                    int i12 = i10;
                    wifiInfoMetric.networkId = query.getInt(i11);
                    int i13 = columnIndexOrThrow18;
                    Integer valueOf2 = query.isNull(i13) ? null : Integer.valueOf(query.getInt(i13));
                    if (valueOf2 == null) {
                        i2 = i11;
                        bool2 = null;
                    } else {
                        i2 = i11;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    wifiInfoMetric.isConnected = bool2;
                    int i14 = columnIndexOrThrow19;
                    Integer valueOf3 = query.isNull(i14) ? null : Integer.valueOf(query.getInt(i14));
                    if (valueOf3 == null) {
                        columnIndexOrThrow19 = i14;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow19 = i14;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    wifiInfoMetric.isRooted = bool3;
                    columnIndexOrThrow18 = i13;
                    int i15 = columnIndexOrThrow20;
                    wifiInfoMetric.rxLinkSpeed = query.getInt(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    wifiInfoMetric.txLinkSpeed = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    wifiInfoMetric.channelWidth = query.getInt(i17);
                    int i18 = columnIndexOrThrow23;
                    if (query.getInt(i18) != 0) {
                        columnIndexOrThrow22 = i17;
                        z = true;
                    } else {
                        columnIndexOrThrow22 = i17;
                        z = false;
                    }
                    wifiInfoMetric.isSending = z;
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(wifiInfoMetric);
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow12 = i9;
                    columnIndexOrThrow15 = i;
                    columnIndexOrThrow16 = i12;
                    columnIndexOrThrow17 = i2;
                    int i19 = i5;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i7;
                    i3 = i6;
                    columnIndexOrThrow13 = i19;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
