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
import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import com.ironsource.mediationsdk.IronSourceSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CellInfoDAO_Impl implements CellInfoDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<CellInfoMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<CellInfoMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, CellInfoMetric cellInfoMetric) {
            supportSQLiteStatement.bindLong(1, cellInfoMetric.id);
            String str = cellInfoMetric.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = cellInfoMetric.measurementSequenceId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = cellInfoMetric.sdkOrigin;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            supportSQLiteStatement.bindLong(5, cellInfoMetric.isRegistered ? 1 : 0);
            String str4 = cellInfoMetric.dateTimeOfMeasurement;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str4);
            }
            String str5 = cellInfoMetric.simMCC;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str5);
            }
            String str6 = cellInfoMetric.simMNC;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            String str7 = cellInfoMetric.secondarySimMCC;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str7);
            }
            String str8 = cellInfoMetric.secondarySimMNC;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str8);
            }
            supportSQLiteStatement.bindLong(11, (long) cellInfoMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(12, (long) cellInfoMetric.dataSimSlotNumber);
            String str9 = cellInfoMetric.networkMCC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str9);
            }
            String str10 = cellInfoMetric.networkMNC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str10);
            }
            supportSQLiteStatement.bindDouble(15, cellInfoMetric.latitude);
            supportSQLiteStatement.bindDouble(16, cellInfoMetric.longitude);
            supportSQLiteStatement.bindDouble(17, cellInfoMetric.gpsAccuracy);
            String str11 = cellInfoMetric.deviceBrand;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str11);
            }
            String str12 = cellInfoMetric.deviceModel;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str12);
            }
            String str13 = cellInfoMetric.deviceVersion;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str13);
            }
            String str14 = cellInfoMetric.carrierName;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str14);
            }
            String str15 = cellInfoMetric.secondaryCarrierName;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str15);
            }
            String str16 = cellInfoMetric.os;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str16);
            }
            String str17 = cellInfoMetric.osVersion;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str17);
            }
            supportSQLiteStatement.bindLong(25, (long) cellInfoMetric.cellConnectionStatus);
            String str18 = cellInfoMetric.cellType;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str18);
            }
            supportSQLiteStatement.bindLong(27, cellInfoMetric.age);
            Integer num = cellInfoMetric.bandwidth;
            if (num == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindLong(28, (long) num.intValue());
            }
            String str19 = cellInfoMetric.cellId;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str19);
            }
            Integer num2 = cellInfoMetric.arfc;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindLong(30, (long) num2.intValue());
            }
            Integer num3 = cellInfoMetric.connectionArfc;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindLong(31, (long) num3.intValue());
            }
            String str20 = cellInfoMetric.cellBands;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str20);
            }
            Integer num4 = cellInfoMetric.pci;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindLong(33, (long) num4.intValue());
            }
            String str21 = cellInfoMetric.lac;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str21);
            }
            Integer num5 = cellInfoMetric.asuLevel;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindLong(35, (long) num5.intValue());
            }
            Integer num6 = cellInfoMetric.dbm;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindLong(36, (long) num6.intValue());
            }
            Integer num7 = cellInfoMetric.cqi;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindLong(37, (long) num7.intValue());
            }
            Integer num8 = cellInfoMetric.level;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindLong(38, (long) num8.intValue());
            }
            Integer num9 = cellInfoMetric.rsrp;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindLong(39, (long) num9.intValue());
            }
            Integer num10 = cellInfoMetric.rsrq;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num10.intValue());
            }
            Integer num11 = cellInfoMetric.rssi;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindLong(41, (long) num11.intValue());
            }
            Integer num12 = cellInfoMetric.rssnr;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindLong(42, (long) num12.intValue());
            }
            Integer num13 = cellInfoMetric.csiRsrp;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) num13.intValue());
            }
            Integer num14 = cellInfoMetric.csiSinr;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num14.intValue());
            }
            Integer num15 = cellInfoMetric.csiRsrq;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num15.intValue());
            }
            Integer num16 = cellInfoMetric.ssRsrp;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num16.intValue());
            }
            Integer num17 = cellInfoMetric.ssRsrq;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num17.intValue());
            }
            Integer num18 = cellInfoMetric.ssSinr;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num18.intValue());
            }
            Integer num19 = cellInfoMetric.timingAdvance;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num19.intValue());
            }
            Boolean bool = cellInfoMetric.isDcNrRestricted;
            Integer num20 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) valueOf.intValue());
            }
            Boolean bool2 = cellInfoMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) valueOf2.intValue());
            }
            Boolean bool3 = cellInfoMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) valueOf3.intValue());
            }
            String str22 = cellInfoMetric.nrState;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str22);
            }
            Integer num21 = cellInfoMetric.nrFrequencyRange;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num21.intValue());
            }
            Boolean bool4 = cellInfoMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) valueOf4.intValue());
            }
            Integer num22 = cellInfoMetric.vopsSupport;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num22.intValue());
            }
            String str23 = cellInfoMetric.cellBandwidths;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str23);
            }
            String str24 = cellInfoMetric.additionalPlmns;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str24);
            }
            supportSQLiteStatement.bindDouble(59, cellInfoMetric.altitude);
            Float f = cellInfoMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindDouble(60, (double) f.floatValue());
            }
            Float f2 = cellInfoMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindDouble(61, (double) f2.floatValue());
            }
            supportSQLiteStatement.bindLong(62, (long) cellInfoMetric.locationAge);
            String str25 = cellInfoMetric.sdkVersionNumber;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str25);
            }
            Integer num23 = cellInfoMetric.wcdmaEcNo;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num23.intValue());
            }
            String str26 = cellInfoMetric.networkOperatorName;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str26);
            }
            supportSQLiteStatement.bindLong(66, (long) cellInfoMetric.stateDuringMeasurement);
            Integer num24 = cellInfoMetric.overrideNetworkType;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num24.intValue());
            }
            Integer num25 = cellInfoMetric.accessNetworkTechnologyRaw;
            if (num25 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num25.intValue());
            }
            Boolean bool5 = cellInfoMetric.anonymize;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) valueOf5.intValue());
            }
            Boolean bool6 = cellInfoMetric.isRooted;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) valueOf6.intValue());
            }
            Boolean bool7 = cellInfoMetric.isConnectedToVpn;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) valueOf7.intValue());
            }
            Float f3 = cellInfoMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindDouble(72, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(73, (long) cellInfoMetric.getRestrictBackgroundStatus);
            Boolean bool8 = cellInfoMetric.isDefaultNetworkActive;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) valueOf8.intValue());
            }
            Boolean bool9 = cellInfoMetric.isActiveNetworkMetered;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf9.intValue());
            }
            Boolean bool10 = cellInfoMetric.isOnScreen;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) valueOf10.intValue());
            }
            Boolean bool11 = cellInfoMetric.isRoaming;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(78, (long) cellInfoMetric.latencyType);
            String str27 = cellInfoMetric.serverIp;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindString(79, str27);
            }
            String str28 = cellInfoMetric.privateIp;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str28);
            }
            String str29 = cellInfoMetric.gatewayIp;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindString(81, str29);
            }
            Integer num26 = cellInfoMetric.locationPermissionState;
            if (num26 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) num26.intValue());
            }
            Boolean bool12 = cellInfoMetric.isReadPhoneStatePermissionGranted;
            if (bool12 != null) {
                num20 = Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            }
            if (num20 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) num20.intValue());
            }
            supportSQLiteStatement.bindLong(84, cellInfoMetric.isSending ? 1 : 0);
            String str30 = cellInfoMetric.appVersionName;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str30);
            }
            supportSQLiteStatement.bindLong(86, cellInfoMetric.appVersionCode);
            supportSQLiteStatement.bindLong(87, cellInfoMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(88, (long) cellInfoMetric.duplexModeState);
            supportSQLiteStatement.bindLong(89, (long) cellInfoMetric.dozeModeState);
            supportSQLiteStatement.bindLong(90, (long) cellInfoMetric.callState);
            String str31 = cellInfoMetric.buildDevice;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindString(91, str31);
            }
            String str32 = cellInfoMetric.buildHardware;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindString(92, str32);
            }
            String str33 = cellInfoMetric.buildProduct;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindString(93, str33);
            }
            String str34 = cellInfoMetric.appId;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindString(94, str34);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `CellInfoMetric` (`id`,`mobileClientId`,`measurementSequenceId`,`sdkOrigin`,`isRegistered`,`dateTimeOfMeasurement`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`deviceBrand`,`deviceModel`,`deviceVersion`,`carrierName`,`secondaryCarrierName`,`os`,`osVersion`,`cellConnectionStatus`,`cellType`,`age`,`bandwidth`,`cellId`,`arfc`,`connectionArfc`,`cellBands`,`pci`,`lac`,`asuLevel`,`dbm`,`cqi`,`level`,`rsrp`,`rsrq`,`rssi`,`rssnr`,`csiRsrp`,`csiSinr`,`csiRsrq`,`ssRsrp`,`ssRsrq`,`ssSinr`,`timingAdvance`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`locationAge`,`sdkVersionNumber`,`wcdmaEcNo`,`networkOperatorName`,`stateDuringMeasurement`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`isRooted`,`isConnectedToVpn`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`isReadPhoneStatePermissionGranted`,`isSending`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM cellinfometric";
        }
    }

    public CellInfoDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(CellInfoMetric cellInfoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(cellInfoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<CellInfoMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<CellInfoMetric> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i7;
        int i8;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        int i9;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        int i10;
        Boolean bool12;
        int i11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from cellinfometric", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isRegistered");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "cellConnectionStatus");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, IronSourceSegment.AGE);
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "bandwidth");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "arfc");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "connectionArfc");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "pci");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "lac");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "asuLevel");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "cqi");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "level");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "rsrp");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "rsrq");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "rssi");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "rssnr");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "csiRsrp");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "csiSinr");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "csiRsrq");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "ssRsrp");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "ssRsrq");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "ssSinr");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaEcNo");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    CellInfoMetric cellInfoMetric = new CellInfoMetric();
                    ArrayList arrayList2 = arrayList;
                    int i13 = columnIndexOrThrow11;
                    cellInfoMetric.id = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        cellInfoMetric.mobileClientId = null;
                    } else {
                        cellInfoMetric.mobileClientId = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        cellInfoMetric.measurementSequenceId = null;
                    } else {
                        cellInfoMetric.measurementSequenceId = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        cellInfoMetric.sdkOrigin = null;
                    } else {
                        cellInfoMetric.sdkOrigin = query.getString(columnIndexOrThrow4);
                    }
                    cellInfoMetric.isRegistered = query.getInt(columnIndexOrThrow5) != 0;
                    if (query.isNull(columnIndexOrThrow6)) {
                        cellInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        cellInfoMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        cellInfoMetric.simMCC = null;
                    } else {
                        cellInfoMetric.simMCC = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        cellInfoMetric.simMNC = null;
                    } else {
                        cellInfoMetric.simMNC = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        cellInfoMetric.secondarySimMCC = null;
                    } else {
                        cellInfoMetric.secondarySimMCC = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        cellInfoMetric.secondarySimMNC = null;
                    } else {
                        cellInfoMetric.secondarySimMNC = query.getString(columnIndexOrThrow10);
                    }
                    int i14 = i13;
                    cellInfoMetric.numberOfSimSlots = query.getInt(i14);
                    cellInfoMetric.dataSimSlotNumber = query.getInt(columnIndexOrThrow12);
                    int i15 = i12;
                    if (query.isNull(i15)) {
                        i = i14;
                        cellInfoMetric.networkMCC = null;
                    } else {
                        i = i14;
                        cellInfoMetric.networkMCC = query.getString(i15);
                    }
                    int i16 = columnIndexOrThrow14;
                    if (query.isNull(i16)) {
                        i2 = i15;
                        cellInfoMetric.networkMNC = null;
                    } else {
                        i2 = i15;
                        cellInfoMetric.networkMNC = query.getString(i16);
                    }
                    int i17 = columnIndexOrThrow12;
                    int i18 = columnIndexOrThrow15;
                    int i19 = columnIndexOrThrow;
                    cellInfoMetric.latitude = query.getDouble(i18);
                    int i20 = i16;
                    int i21 = columnIndexOrThrow16;
                    int i22 = i18;
                    cellInfoMetric.longitude = query.getDouble(i21);
                    int i23 = i21;
                    int i24 = columnIndexOrThrow17;
                    int i25 = i20;
                    cellInfoMetric.gpsAccuracy = query.getDouble(i24);
                    int i26 = columnIndexOrThrow18;
                    if (query.isNull(i26)) {
                        cellInfoMetric.deviceBrand = null;
                    } else {
                        cellInfoMetric.deviceBrand = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow19;
                    if (query.isNull(i27)) {
                        i3 = i24;
                        cellInfoMetric.deviceModel = null;
                    } else {
                        i3 = i24;
                        cellInfoMetric.deviceModel = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow20;
                    if (query.isNull(i28)) {
                        i4 = i23;
                        cellInfoMetric.deviceVersion = null;
                    } else {
                        i4 = i23;
                        cellInfoMetric.deviceVersion = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow21;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow20 = i28;
                        cellInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow20 = i28;
                        cellInfoMetric.carrierName = query.getString(i29);
                    }
                    int i30 = columnIndexOrThrow22;
                    if (query.isNull(i30)) {
                        columnIndexOrThrow21 = i29;
                        cellInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow21 = i29;
                        cellInfoMetric.secondaryCarrierName = query.getString(i30);
                    }
                    int i31 = columnIndexOrThrow23;
                    if (query.isNull(i31)) {
                        columnIndexOrThrow22 = i30;
                        cellInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow22 = i30;
                        cellInfoMetric.os = query.getString(i31);
                    }
                    int i32 = columnIndexOrThrow24;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow23 = i31;
                        cellInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow23 = i31;
                        cellInfoMetric.osVersion = query.getString(i32);
                    }
                    columnIndexOrThrow24 = i32;
                    int i33 = columnIndexOrThrow25;
                    cellInfoMetric.cellConnectionStatus = query.getInt(i33);
                    int i34 = columnIndexOrThrow26;
                    if (query.isNull(i34)) {
                        columnIndexOrThrow25 = i33;
                        cellInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow25 = i33;
                        cellInfoMetric.cellType = query.getString(i34);
                    }
                    int i35 = i26;
                    int i36 = columnIndexOrThrow27;
                    int i37 = i27;
                    cellInfoMetric.age = query.getLong(i36);
                    int i38 = columnIndexOrThrow28;
                    if (query.isNull(i38)) {
                        cellInfoMetric.bandwidth = null;
                    } else {
                        cellInfoMetric.bandwidth = Integer.valueOf(query.getInt(i38));
                    }
                    int i39 = columnIndexOrThrow29;
                    if (query.isNull(i39)) {
                        i5 = i34;
                        cellInfoMetric.cellId = null;
                    } else {
                        i5 = i34;
                        cellInfoMetric.cellId = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow30;
                    if (query.isNull(i40)) {
                        i6 = i36;
                        cellInfoMetric.arfc = null;
                    } else {
                        i6 = i36;
                        cellInfoMetric.arfc = Integer.valueOf(query.getInt(i40));
                    }
                    int i41 = columnIndexOrThrow31;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow30 = i40;
                        cellInfoMetric.connectionArfc = null;
                    } else {
                        columnIndexOrThrow30 = i40;
                        cellInfoMetric.connectionArfc = Integer.valueOf(query.getInt(i41));
                    }
                    int i42 = columnIndexOrThrow32;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow31 = i41;
                        cellInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow31 = i41;
                        cellInfoMetric.cellBands = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow33;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow32 = i42;
                        cellInfoMetric.pci = null;
                    } else {
                        columnIndexOrThrow32 = i42;
                        cellInfoMetric.pci = Integer.valueOf(query.getInt(i43));
                    }
                    int i44 = columnIndexOrThrow34;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow33 = i43;
                        cellInfoMetric.lac = null;
                    } else {
                        columnIndexOrThrow33 = i43;
                        cellInfoMetric.lac = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow35;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow34 = i44;
                        cellInfoMetric.asuLevel = null;
                    } else {
                        columnIndexOrThrow34 = i44;
                        cellInfoMetric.asuLevel = Integer.valueOf(query.getInt(i45));
                    }
                    int i46 = columnIndexOrThrow36;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow35 = i45;
                        cellInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow35 = i45;
                        cellInfoMetric.dbm = Integer.valueOf(query.getInt(i46));
                    }
                    int i47 = columnIndexOrThrow37;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow36 = i46;
                        cellInfoMetric.cqi = null;
                    } else {
                        columnIndexOrThrow36 = i46;
                        cellInfoMetric.cqi = Integer.valueOf(query.getInt(i47));
                    }
                    int i48 = columnIndexOrThrow38;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow37 = i47;
                        cellInfoMetric.level = null;
                    } else {
                        columnIndexOrThrow37 = i47;
                        cellInfoMetric.level = Integer.valueOf(query.getInt(i48));
                    }
                    int i49 = columnIndexOrThrow39;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow38 = i48;
                        cellInfoMetric.rsrp = null;
                    } else {
                        columnIndexOrThrow38 = i48;
                        cellInfoMetric.rsrp = Integer.valueOf(query.getInt(i49));
                    }
                    int i50 = columnIndexOrThrow40;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow39 = i49;
                        cellInfoMetric.rsrq = null;
                    } else {
                        columnIndexOrThrow39 = i49;
                        cellInfoMetric.rsrq = Integer.valueOf(query.getInt(i50));
                    }
                    int i51 = columnIndexOrThrow41;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow40 = i50;
                        cellInfoMetric.rssi = null;
                    } else {
                        columnIndexOrThrow40 = i50;
                        cellInfoMetric.rssi = Integer.valueOf(query.getInt(i51));
                    }
                    int i52 = columnIndexOrThrow42;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow41 = i51;
                        cellInfoMetric.rssnr = null;
                    } else {
                        columnIndexOrThrow41 = i51;
                        cellInfoMetric.rssnr = Integer.valueOf(query.getInt(i52));
                    }
                    int i53 = columnIndexOrThrow43;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow42 = i52;
                        cellInfoMetric.csiRsrp = null;
                    } else {
                        columnIndexOrThrow42 = i52;
                        cellInfoMetric.csiRsrp = Integer.valueOf(query.getInt(i53));
                    }
                    int i54 = columnIndexOrThrow44;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow43 = i53;
                        cellInfoMetric.csiSinr = null;
                    } else {
                        columnIndexOrThrow43 = i53;
                        cellInfoMetric.csiSinr = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow45;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow44 = i54;
                        cellInfoMetric.csiRsrq = null;
                    } else {
                        columnIndexOrThrow44 = i54;
                        cellInfoMetric.csiRsrq = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow46;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow45 = i55;
                        cellInfoMetric.ssRsrp = null;
                    } else {
                        columnIndexOrThrow45 = i55;
                        cellInfoMetric.ssRsrp = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow47;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow46 = i56;
                        cellInfoMetric.ssRsrq = null;
                    } else {
                        columnIndexOrThrow46 = i56;
                        cellInfoMetric.ssRsrq = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow48;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow47 = i57;
                        cellInfoMetric.ssSinr = null;
                    } else {
                        columnIndexOrThrow47 = i57;
                        cellInfoMetric.ssSinr = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow49;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow48 = i58;
                        cellInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow48 = i58;
                        cellInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow50;
                    Integer valueOf = query.isNull(i60) ? null : Integer.valueOf(query.getInt(i60));
                    if (valueOf == null) {
                        columnIndexOrThrow50 = i60;
                        bool = null;
                    } else {
                        columnIndexOrThrow50 = i60;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    cellInfoMetric.isDcNrRestricted = bool;
                    int i61 = columnIndexOrThrow51;
                    Integer valueOf2 = query.isNull(i61) ? null : Integer.valueOf(query.getInt(i61));
                    if (valueOf2 == null) {
                        columnIndexOrThrow51 = i61;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow51 = i61;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    cellInfoMetric.isNrAvailable = bool2;
                    int i62 = columnIndexOrThrow52;
                    Integer valueOf3 = query.isNull(i62) ? null : Integer.valueOf(query.getInt(i62));
                    if (valueOf3 == null) {
                        columnIndexOrThrow52 = i62;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow52 = i62;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    cellInfoMetric.isEnDcAvailable = bool3;
                    int i63 = columnIndexOrThrow53;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow49 = i59;
                        cellInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow49 = i59;
                        cellInfoMetric.nrState = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow54;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow53 = i63;
                        cellInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow53 = i63;
                        cellInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow55;
                    Integer valueOf4 = query.isNull(i65) ? null : Integer.valueOf(query.getInt(i65));
                    if (valueOf4 == null) {
                        columnIndexOrThrow55 = i65;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow55 = i65;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    cellInfoMetric.isUsingCarrierAggregation = bool4;
                    int i66 = columnIndexOrThrow56;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow54 = i64;
                        cellInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow54 = i64;
                        cellInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow57;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow56 = i66;
                        cellInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow56 = i66;
                        cellInfoMetric.cellBandwidths = query.getString(i67);
                    }
                    int i68 = columnIndexOrThrow58;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow57 = i67;
                        cellInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow57 = i67;
                        cellInfoMetric.additionalPlmns = query.getString(i68);
                    }
                    int i69 = i38;
                    int i70 = columnIndexOrThrow59;
                    int i71 = i39;
                    cellInfoMetric.altitude = query.getDouble(i70);
                    int i72 = columnIndexOrThrow60;
                    if (query.isNull(i72)) {
                        cellInfoMetric.locationSpeed = null;
                    } else {
                        cellInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i72));
                    }
                    int i73 = columnIndexOrThrow61;
                    if (query.isNull(i73)) {
                        i7 = i68;
                        cellInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i7 = i68;
                        cellInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i73));
                    }
                    int i74 = i70;
                    int i75 = columnIndexOrThrow62;
                    cellInfoMetric.locationAge = query.getInt(i75);
                    int i76 = columnIndexOrThrow63;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow62 = i75;
                        cellInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow62 = i75;
                        cellInfoMetric.sdkVersionNumber = query.getString(i76);
                    }
                    int i77 = columnIndexOrThrow64;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow63 = i76;
                        cellInfoMetric.wcdmaEcNo = null;
                    } else {
                        columnIndexOrThrow63 = i76;
                        cellInfoMetric.wcdmaEcNo = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow65;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow64 = i77;
                        cellInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow64 = i77;
                        cellInfoMetric.networkOperatorName = query.getString(i78);
                    }
                    columnIndexOrThrow65 = i78;
                    int i79 = columnIndexOrThrow66;
                    cellInfoMetric.stateDuringMeasurement = query.getInt(i79);
                    int i80 = columnIndexOrThrow67;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow66 = i79;
                        cellInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow66 = i79;
                        cellInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i80));
                    }
                    int i81 = columnIndexOrThrow68;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow67 = i80;
                        cellInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow67 = i80;
                        cellInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i81));
                    }
                    int i82 = columnIndexOrThrow69;
                    Integer valueOf5 = query.isNull(i82) ? null : Integer.valueOf(query.getInt(i82));
                    if (valueOf5 == null) {
                        i8 = i81;
                        bool5 = null;
                    } else {
                        i8 = i81;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    cellInfoMetric.anonymize = bool5;
                    int i83 = columnIndexOrThrow70;
                    Integer valueOf6 = query.isNull(i83) ? null : Integer.valueOf(query.getInt(i83));
                    if (valueOf6 == null) {
                        columnIndexOrThrow70 = i83;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow70 = i83;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    cellInfoMetric.isRooted = bool6;
                    int i84 = columnIndexOrThrow71;
                    Integer valueOf7 = query.isNull(i84) ? null : Integer.valueOf(query.getInt(i84));
                    if (valueOf7 == null) {
                        columnIndexOrThrow71 = i84;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow71 = i84;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    cellInfoMetric.isConnectedToVpn = bool7;
                    int i85 = columnIndexOrThrow72;
                    if (query.isNull(i85)) {
                        i9 = i82;
                        cellInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i9 = i82;
                        cellInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i85));
                    }
                    columnIndexOrThrow72 = i85;
                    int i86 = columnIndexOrThrow73;
                    cellInfoMetric.getRestrictBackgroundStatus = query.getInt(i86);
                    int i87 = columnIndexOrThrow74;
                    Integer valueOf8 = query.isNull(i87) ? null : Integer.valueOf(query.getInt(i87));
                    if (valueOf8 == null) {
                        columnIndexOrThrow74 = i87;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow74 = i87;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    cellInfoMetric.isDefaultNetworkActive = bool8;
                    int i88 = columnIndexOrThrow75;
                    Integer valueOf9 = query.isNull(i88) ? null : Integer.valueOf(query.getInt(i88));
                    if (valueOf9 == null) {
                        columnIndexOrThrow75 = i88;
                        bool9 = null;
                    } else {
                        columnIndexOrThrow75 = i88;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    cellInfoMetric.isActiveNetworkMetered = bool9;
                    int i89 = columnIndexOrThrow76;
                    Integer valueOf10 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf10 == null) {
                        columnIndexOrThrow76 = i89;
                        bool10 = null;
                    } else {
                        columnIndexOrThrow76 = i89;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    cellInfoMetric.isOnScreen = bool10;
                    int i90 = columnIndexOrThrow77;
                    Integer valueOf11 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf11 == null) {
                        columnIndexOrThrow77 = i90;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow77 = i90;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    cellInfoMetric.isRoaming = bool11;
                    columnIndexOrThrow73 = i86;
                    int i91 = columnIndexOrThrow78;
                    cellInfoMetric.latencyType = query.getInt(i91);
                    int i92 = columnIndexOrThrow79;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow78 = i91;
                        cellInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow78 = i91;
                        cellInfoMetric.serverIp = query.getString(i92);
                    }
                    int i93 = columnIndexOrThrow80;
                    if (query.isNull(i93)) {
                        columnIndexOrThrow79 = i92;
                        cellInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow79 = i92;
                        cellInfoMetric.privateIp = query.getString(i93);
                    }
                    int i94 = columnIndexOrThrow81;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow80 = i93;
                        cellInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow80 = i93;
                        cellInfoMetric.gatewayIp = query.getString(i94);
                    }
                    int i95 = columnIndexOrThrow82;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow81 = i94;
                        cellInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow81 = i94;
                        cellInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow83;
                    Integer valueOf12 = query.isNull(i96) ? null : Integer.valueOf(query.getInt(i96));
                    if (valueOf12 == null) {
                        i10 = i95;
                        bool12 = null;
                    } else {
                        i10 = i95;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    cellInfoMetric.isReadPhoneStatePermissionGranted = bool12;
                    int i97 = columnIndexOrThrow84;
                    columnIndexOrThrow84 = i97;
                    cellInfoMetric.isSending = query.getInt(i97) != 0;
                    int i98 = columnIndexOrThrow85;
                    if (query.isNull(i98)) {
                        i11 = i96;
                        cellInfoMetric.appVersionName = null;
                    } else {
                        i11 = i96;
                        cellInfoMetric.appVersionName = query.getString(i98);
                    }
                    int i99 = i72;
                    int i100 = columnIndexOrThrow86;
                    int i101 = i73;
                    cellInfoMetric.appVersionCode = query.getLong(i100);
                    int i102 = i98;
                    int i103 = columnIndexOrThrow87;
                    int i104 = i100;
                    cellInfoMetric.appLastUpdateTime = query.getLong(i103);
                    int i105 = columnIndexOrThrow88;
                    cellInfoMetric.duplexModeState = query.getInt(i105);
                    columnIndexOrThrow88 = i105;
                    int i106 = columnIndexOrThrow89;
                    cellInfoMetric.dozeModeState = query.getInt(i106);
                    columnIndexOrThrow89 = i106;
                    int i107 = columnIndexOrThrow90;
                    cellInfoMetric.callState = query.getInt(i107);
                    int i108 = columnIndexOrThrow91;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow90 = i107;
                        cellInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow90 = i107;
                        cellInfoMetric.buildDevice = query.getString(i108);
                    }
                    int i109 = columnIndexOrThrow92;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow91 = i108;
                        cellInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow91 = i108;
                        cellInfoMetric.buildHardware = query.getString(i109);
                    }
                    int i110 = columnIndexOrThrow93;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow92 = i109;
                        cellInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow92 = i109;
                        cellInfoMetric.buildProduct = query.getString(i110);
                    }
                    int i111 = columnIndexOrThrow94;
                    if (query.isNull(i111)) {
                        columnIndexOrThrow93 = i110;
                        cellInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow93 = i110;
                        cellInfoMetric.appId = query.getString(i111);
                    }
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(cellInfoMetric);
                    columnIndexOrThrow94 = i111;
                    arrayList = arrayList3;
                    columnIndexOrThrow11 = i;
                    i12 = i2;
                    columnIndexOrThrow14 = i25;
                    columnIndexOrThrow17 = i3;
                    columnIndexOrThrow18 = i35;
                    columnIndexOrThrow26 = i5;
                    columnIndexOrThrow28 = i69;
                    columnIndexOrThrow58 = i7;
                    columnIndexOrThrow60 = i99;
                    columnIndexOrThrow85 = i102;
                    columnIndexOrThrow = i19;
                    columnIndexOrThrow15 = i22;
                    columnIndexOrThrow16 = i4;
                    columnIndexOrThrow19 = i37;
                    columnIndexOrThrow27 = i6;
                    columnIndexOrThrow29 = i71;
                    columnIndexOrThrow59 = i74;
                    columnIndexOrThrow61 = i101;
                    columnIndexOrThrow86 = i104;
                    columnIndexOrThrow87 = i103;
                    columnIndexOrThrow12 = i17;
                    int i112 = i8;
                    columnIndexOrThrow69 = i9;
                    columnIndexOrThrow68 = i112;
                    int i113 = i10;
                    columnIndexOrThrow83 = i11;
                    columnIndexOrThrow82 = i113;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                query.close();
                roomSQLiteQuery.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            Throwable th22 = th;
            query.close();
            roomSQLiteQuery.release();
            throw th22;
        }
    }
}
