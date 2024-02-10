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
import com.cellrebel.sdk.networking.beans.request.CoverageMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CoverageMetricDAO_Impl implements CoverageMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<CoverageMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<CoverageMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverageMetric coverageMetric) {
            String str = coverageMetric.cellInfoMetricsJSON;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, coverageMetric.id);
            String str2 = coverageMetric.mobileClientId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = coverageMetric.measurementSequenceId;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = coverageMetric.clientIp;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = coverageMetric.dateTimeOfMeasurement;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            supportSQLiteStatement.bindLong(7, (long) coverageMetric.stateDuringMeasurement);
            String str6 = coverageMetric.accessTechnology;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str6);
            }
            String str7 = coverageMetric.accessTypeRaw;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str7);
            }
            supportSQLiteStatement.bindLong(10, (long) coverageMetric.signalStrength);
            supportSQLiteStatement.bindLong(11, (long) coverageMetric.interference);
            String str8 = coverageMetric.simMCC;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str8);
            }
            String str9 = coverageMetric.simMNC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str9);
            }
            String str10 = coverageMetric.secondarySimMCC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str10);
            }
            String str11 = coverageMetric.secondarySimMNC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str11);
            }
            supportSQLiteStatement.bindLong(16, (long) coverageMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(17, (long) coverageMetric.dataSimSlotNumber);
            String str12 = coverageMetric.networkMCC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str12);
            }
            String str13 = coverageMetric.networkMNC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str13);
            }
            supportSQLiteStatement.bindDouble(20, coverageMetric.latitude);
            supportSQLiteStatement.bindDouble(21, coverageMetric.longitude);
            supportSQLiteStatement.bindDouble(22, coverageMetric.gpsAccuracy);
            String str14 = coverageMetric.cellId;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str14);
            }
            String str15 = coverageMetric.lacId;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str15);
            }
            String str16 = coverageMetric.deviceBrand;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str16);
            }
            String str17 = coverageMetric.deviceModel;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str17);
            }
            String str18 = coverageMetric.deviceVersion;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str18);
            }
            String str19 = coverageMetric.sdkVersionNumber;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str19);
            }
            String str20 = coverageMetric.carrierName;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str20);
            }
            String str21 = coverageMetric.secondaryCarrierName;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str21);
            }
            String str22 = coverageMetric.networkOperatorName;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str22);
            }
            String str23 = coverageMetric.os;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str23);
            }
            String str24 = coverageMetric.osVersion;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str24);
            }
            String str25 = coverageMetric.readableDate;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str25);
            }
            Integer num = coverageMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindLong(35, (long) num.intValue());
            }
            Integer num2 = coverageMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindLong(36, (long) num2.intValue());
            }
            Integer num3 = coverageMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindLong(37, (long) num3.intValue());
            }
            String str26 = coverageMetric.cellBands;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str26);
            }
            Integer num4 = coverageMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindLong(39, (long) num4.intValue());
            }
            Integer num5 = coverageMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num5.intValue());
            }
            Integer num6 = coverageMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindLong(41, (long) num6.intValue());
            }
            Integer num7 = coverageMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindLong(42, (long) num7.intValue());
            }
            Integer num8 = coverageMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) num8.intValue());
            }
            Integer num9 = coverageMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num9.intValue());
            }
            Integer num10 = coverageMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num10.intValue());
            }
            Integer num11 = coverageMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num11.intValue());
            }
            Integer num12 = coverageMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num12.intValue());
            }
            Integer num13 = coverageMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num13.intValue());
            }
            Integer num14 = coverageMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num14.intValue());
            }
            Integer num15 = coverageMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num15.intValue());
            }
            Integer num16 = coverageMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num16.intValue());
            }
            String str27 = coverageMetric.debugString;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str27);
            }
            Boolean bool = coverageMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) valueOf.intValue());
            }
            Boolean bool2 = coverageMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) valueOf2.intValue());
            }
            Boolean bool3 = coverageMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) valueOf3.intValue());
            }
            String str28 = coverageMetric.nrState;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str28);
            }
            Integer num18 = coverageMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num18.intValue());
            }
            Boolean bool4 = coverageMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) valueOf4.intValue());
            }
            Integer num19 = coverageMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num19.intValue());
            }
            String str29 = coverageMetric.cellBandwidths;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str29);
            }
            String str30 = coverageMetric.additionalPlmns;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str30);
            }
            supportSQLiteStatement.bindDouble(62, coverageMetric.altitude);
            Float f = coverageMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindDouble(63, (double) f.floatValue());
            }
            Float f2 = coverageMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindDouble(64, (double) f2.floatValue());
            }
            Float f3 = coverageMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindDouble(65, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(66, (long) coverageMetric.getRestrictBackgroundStatus);
            String str31 = coverageMetric.cellType;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindString(67, str31);
            }
            Boolean bool5 = coverageMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) valueOf5.intValue());
            }
            Boolean bool6 = coverageMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) valueOf6.intValue());
            }
            Boolean bool7 = coverageMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) valueOf7.intValue());
            }
            Boolean bool8 = coverageMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(72, (long) coverageMetric.locationAge);
            Integer num20 = coverageMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num20.intValue());
            }
            Integer num21 = coverageMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num21.intValue());
            }
            Boolean bool9 = coverageMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf9.intValue());
            }
            String str32 = coverageMetric.sdkOrigin;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str32);
            }
            Boolean bool10 = coverageMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf10.intValue());
            }
            Boolean bool11 = coverageMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(79, (long) coverageMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(80, (long) coverageMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(81, (long) coverageMetric.latencyType);
            String str33 = coverageMetric.serverIp;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindString(82, str33);
            }
            String str34 = coverageMetric.privateIp;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str34);
            }
            String str35 = coverageMetric.gatewayIp;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindString(84, str35);
            }
            Integer num22 = coverageMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindLong(85, (long) num22.intValue());
            }
            Integer num23 = coverageMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) num23.intValue());
            }
            Boolean bool12 = coverageMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) valueOf12.intValue());
            }
            Boolean bool13 = coverageMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) num17.intValue());
            }
            String str36 = coverageMetric.appVersionName;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindString(89, str36);
            }
            supportSQLiteStatement.bindLong(90, coverageMetric.appVersionCode);
            supportSQLiteStatement.bindLong(91, coverageMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(92, (long) coverageMetric.duplexModeState);
            supportSQLiteStatement.bindLong(93, (long) coverageMetric.dozeModeState);
            supportSQLiteStatement.bindLong(94, (long) coverageMetric.callState);
            String str37 = coverageMetric.buildDevice;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindString(95, str37);
            }
            String str38 = coverageMetric.buildHardware;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str38);
            }
            String str39 = coverageMetric.buildProduct;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindString(97, str39);
            }
            String str40 = coverageMetric.appId;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str40);
            }
            supportSQLiteStatement.bindLong(99, coverageMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `CoverageMetric` (`cellInfoMetricsJSON`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM coveragemetric";
        }
    }

    public CoverageMetricDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(CoverageMetric coverageMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(coverageMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<CoverageMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<CoverageMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i9;
        int i10;
        int i11;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i12;
        Boolean bool9;
        int i13;
        int i14;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from coveragemetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "cellInfoMetricsJSON");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "interference");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i15 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    CoverageMetric coverageMetric = new CoverageMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        coverageMetric.cellInfoMetricsJSON = null;
                    } else {
                        arrayList = arrayList2;
                        coverageMetric.cellInfoMetricsJSON = query.getString(columnIndexOrThrow);
                    }
                    int i16 = columnIndexOrThrow12;
                    int i17 = columnIndexOrThrow;
                    coverageMetric.id = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        coverageMetric.mobileClientId = null;
                    } else {
                        coverageMetric.mobileClientId = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        coverageMetric.measurementSequenceId = null;
                    } else {
                        coverageMetric.measurementSequenceId = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        coverageMetric.clientIp = null;
                    } else {
                        coverageMetric.clientIp = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        coverageMetric.dateTimeOfMeasurement = null;
                    } else {
                        coverageMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow6);
                    }
                    coverageMetric.stateDuringMeasurement = query.getInt(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        coverageMetric.accessTechnology = null;
                    } else {
                        coverageMetric.accessTechnology = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        coverageMetric.accessTypeRaw = null;
                    } else {
                        coverageMetric.accessTypeRaw = query.getString(columnIndexOrThrow9);
                    }
                    coverageMetric.signalStrength = query.getInt(columnIndexOrThrow10);
                    coverageMetric.interference = query.getInt(columnIndexOrThrow11);
                    int i18 = i16;
                    if (query.isNull(i18)) {
                        coverageMetric.simMCC = null;
                    } else {
                        coverageMetric.simMCC = query.getString(i18);
                    }
                    int i19 = i15;
                    if (query.isNull(i19)) {
                        i = i17;
                        coverageMetric.simMNC = null;
                    } else {
                        i = i17;
                        coverageMetric.simMNC = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow14;
                    if (query.isNull(i20)) {
                        i2 = columnIndexOrThrow11;
                        coverageMetric.secondarySimMCC = null;
                    } else {
                        i2 = columnIndexOrThrow11;
                        coverageMetric.secondarySimMCC = query.getString(i20);
                    }
                    int i21 = columnIndexOrThrow15;
                    if (query.isNull(i21)) {
                        i3 = i20;
                        coverageMetric.secondarySimMNC = null;
                    } else {
                        i3 = i20;
                        coverageMetric.secondarySimMNC = query.getString(i21);
                    }
                    int i22 = columnIndexOrThrow16;
                    int i23 = i21;
                    coverageMetric.numberOfSimSlots = query.getInt(i22);
                    int i24 = columnIndexOrThrow17;
                    int i25 = i22;
                    coverageMetric.dataSimSlotNumber = query.getInt(i24);
                    int i26 = columnIndexOrThrow18;
                    if (query.isNull(i26)) {
                        i4 = i24;
                        coverageMetric.networkMCC = null;
                    } else {
                        i4 = i24;
                        coverageMetric.networkMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow19;
                    if (query.isNull(i27)) {
                        i5 = i26;
                        coverageMetric.networkMNC = null;
                    } else {
                        i5 = i26;
                        coverageMetric.networkMNC = query.getString(i27);
                    }
                    int i28 = i18;
                    int i29 = columnIndexOrThrow20;
                    int i30 = i19;
                    coverageMetric.latitude = query.getDouble(i29);
                    int i31 = i27;
                    int i32 = columnIndexOrThrow21;
                    int i33 = i29;
                    coverageMetric.longitude = query.getDouble(i32);
                    int i34 = i32;
                    int i35 = columnIndexOrThrow22;
                    int i36 = i31;
                    coverageMetric.gpsAccuracy = query.getDouble(i35);
                    int i37 = columnIndexOrThrow23;
                    if (query.isNull(i37)) {
                        coverageMetric.cellId = null;
                    } else {
                        coverageMetric.cellId = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow24;
                    if (query.isNull(i38)) {
                        i6 = i35;
                        coverageMetric.lacId = null;
                    } else {
                        i6 = i35;
                        coverageMetric.lacId = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow25;
                    if (query.isNull(i39)) {
                        i7 = i34;
                        coverageMetric.deviceBrand = null;
                    } else {
                        i7 = i34;
                        coverageMetric.deviceBrand = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow26;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow25 = i39;
                        coverageMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow25 = i39;
                        coverageMetric.deviceModel = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow27;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow26 = i40;
                        coverageMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow26 = i40;
                        coverageMetric.deviceVersion = query.getString(i41);
                    }
                    int i42 = columnIndexOrThrow28;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow27 = i41;
                        coverageMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow27 = i41;
                        coverageMetric.sdkVersionNumber = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow29;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow28 = i42;
                        coverageMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow28 = i42;
                        coverageMetric.carrierName = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow30;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow29 = i43;
                        coverageMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow29 = i43;
                        coverageMetric.secondaryCarrierName = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow31;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow30 = i44;
                        coverageMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow30 = i44;
                        coverageMetric.networkOperatorName = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow32;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow31 = i45;
                        coverageMetric.os = null;
                    } else {
                        columnIndexOrThrow31 = i45;
                        coverageMetric.os = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow33;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow32 = i46;
                        coverageMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow32 = i46;
                        coverageMetric.osVersion = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow34;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow33 = i47;
                        coverageMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow33 = i47;
                        coverageMetric.readableDate = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow35;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow34 = i48;
                        coverageMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow34 = i48;
                        coverageMetric.physicalCellId = Integer.valueOf(query.getInt(i49));
                    }
                    int i50 = columnIndexOrThrow36;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow35 = i49;
                        coverageMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow35 = i49;
                        coverageMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i50));
                    }
                    int i51 = columnIndexOrThrow37;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow36 = i50;
                        coverageMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow36 = i50;
                        coverageMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i51));
                    }
                    int i52 = columnIndexOrThrow38;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow37 = i51;
                        coverageMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow37 = i51;
                        coverageMetric.cellBands = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow39;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow38 = i52;
                        coverageMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow38 = i52;
                        coverageMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i53));
                    }
                    int i54 = columnIndexOrThrow40;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow39 = i53;
                        coverageMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow39 = i53;
                        coverageMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow41;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow40 = i54;
                        coverageMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow40 = i54;
                        coverageMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow42;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow41 = i55;
                        coverageMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow41 = i55;
                        coverageMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow43;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow42 = i56;
                        coverageMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow42 = i56;
                        coverageMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow44;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow43 = i57;
                        coverageMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow43 = i57;
                        coverageMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow45;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow44 = i58;
                        coverageMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow44 = i58;
                        coverageMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow46;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow45 = i59;
                        coverageMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow45 = i59;
                        coverageMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow47;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow46 = i60;
                        coverageMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow46 = i60;
                        coverageMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow48;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow47 = i61;
                        coverageMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow47 = i61;
                        coverageMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow49;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow48 = i62;
                        coverageMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow48 = i62;
                        coverageMetric.timingAdvance = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow50;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow49 = i63;
                        coverageMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow49 = i63;
                        coverageMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow51;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow50 = i64;
                        coverageMetric.dbm = null;
                    } else {
                        columnIndexOrThrow50 = i64;
                        coverageMetric.dbm = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow52;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow51 = i65;
                        coverageMetric.debugString = null;
                    } else {
                        columnIndexOrThrow51 = i65;
                        coverageMetric.debugString = query.getString(i66);
                    }
                    int i67 = columnIndexOrThrow53;
                    Integer valueOf = query.isNull(i67) ? null : Integer.valueOf(query.getInt(i67));
                    if (valueOf == null) {
                        i8 = i67;
                        bool = null;
                    } else {
                        i8 = i67;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    coverageMetric.isDcNrRestricted = bool;
                    int i68 = columnIndexOrThrow54;
                    Integer valueOf2 = query.isNull(i68) ? null : Integer.valueOf(query.getInt(i68));
                    if (valueOf2 == null) {
                        columnIndexOrThrow54 = i68;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow54 = i68;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    coverageMetric.isNrAvailable = bool2;
                    int i69 = columnIndexOrThrow55;
                    Integer valueOf3 = query.isNull(i69) ? null : Integer.valueOf(query.getInt(i69));
                    if (valueOf3 == null) {
                        columnIndexOrThrow55 = i69;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow55 = i69;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    coverageMetric.isEnDcAvailable = bool3;
                    int i70 = columnIndexOrThrow56;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow52 = i66;
                        coverageMetric.nrState = null;
                    } else {
                        columnIndexOrThrow52 = i66;
                        coverageMetric.nrState = query.getString(i70);
                    }
                    int i71 = columnIndexOrThrow57;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow56 = i70;
                        coverageMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow56 = i70;
                        coverageMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow58;
                    Integer valueOf4 = query.isNull(i72) ? null : Integer.valueOf(query.getInt(i72));
                    if (valueOf4 == null) {
                        columnIndexOrThrow58 = i72;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow58 = i72;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    coverageMetric.isUsingCarrierAggregation = bool4;
                    int i73 = columnIndexOrThrow59;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow57 = i71;
                        coverageMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow57 = i71;
                        coverageMetric.vopsSupport = Integer.valueOf(query.getInt(i73));
                    }
                    int i74 = columnIndexOrThrow60;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow59 = i73;
                        coverageMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow59 = i73;
                        coverageMetric.cellBandwidths = query.getString(i74);
                    }
                    int i75 = columnIndexOrThrow61;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow60 = i74;
                        coverageMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow60 = i74;
                        coverageMetric.additionalPlmns = query.getString(i75);
                    }
                    int i76 = i37;
                    int i77 = columnIndexOrThrow62;
                    int i78 = i38;
                    coverageMetric.altitude = query.getDouble(i77);
                    int i79 = columnIndexOrThrow63;
                    if (query.isNull(i79)) {
                        coverageMetric.locationSpeed = null;
                    } else {
                        coverageMetric.locationSpeed = Float.valueOf(query.getFloat(i79));
                    }
                    int i80 = columnIndexOrThrow64;
                    if (query.isNull(i80)) {
                        i9 = i75;
                        coverageMetric.locationSpeedAccuracy = null;
                    } else {
                        i9 = i75;
                        coverageMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i80));
                    }
                    int i81 = columnIndexOrThrow65;
                    if (query.isNull(i81)) {
                        i10 = i77;
                        coverageMetric.gpsVerticalAccuracy = null;
                    } else {
                        i10 = i77;
                        coverageMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i81));
                    }
                    columnIndexOrThrow65 = i81;
                    int i82 = columnIndexOrThrow66;
                    coverageMetric.getRestrictBackgroundStatus = query.getInt(i82);
                    int i83 = columnIndexOrThrow67;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow66 = i82;
                        coverageMetric.cellType = null;
                    } else {
                        columnIndexOrThrow66 = i82;
                        coverageMetric.cellType = query.getString(i83);
                    }
                    int i84 = columnIndexOrThrow68;
                    Integer valueOf5 = query.isNull(i84) ? null : Integer.valueOf(query.getInt(i84));
                    if (valueOf5 == null) {
                        i11 = i83;
                        bool5 = null;
                    } else {
                        i11 = i83;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    coverageMetric.isDefaultNetworkActive = bool5;
                    int i85 = columnIndexOrThrow69;
                    Integer valueOf6 = query.isNull(i85) ? null : Integer.valueOf(query.getInt(i85));
                    if (valueOf6 == null) {
                        columnIndexOrThrow69 = i85;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow69 = i85;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    coverageMetric.isActiveNetworkMetered = bool6;
                    int i86 = columnIndexOrThrow70;
                    Integer valueOf7 = query.isNull(i86) ? null : Integer.valueOf(query.getInt(i86));
                    if (valueOf7 == null) {
                        columnIndexOrThrow70 = i86;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow70 = i86;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    coverageMetric.isOnScreen = bool7;
                    int i87 = columnIndexOrThrow71;
                    Integer valueOf8 = query.isNull(i87) ? null : Integer.valueOf(query.getInt(i87));
                    if (valueOf8 == null) {
                        columnIndexOrThrow71 = i87;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow71 = i87;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    coverageMetric.isRoaming = bool8;
                    int i88 = i84;
                    int i89 = columnIndexOrThrow72;
                    coverageMetric.locationAge = query.getInt(i89);
                    int i90 = columnIndexOrThrow73;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow72 = i89;
                        coverageMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow72 = i89;
                        coverageMetric.overrideNetworkType = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow74;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow73 = i90;
                        coverageMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow73 = i90;
                        coverageMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow75;
                    Integer valueOf9 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf9 == null) {
                        i12 = i91;
                        bool9 = null;
                    } else {
                        i12 = i91;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    coverageMetric.anonymize = bool9;
                    int i93 = columnIndexOrThrow76;
                    if (query.isNull(i93)) {
                        i13 = i92;
                        coverageMetric.sdkOrigin = null;
                    } else {
                        i13 = i92;
                        coverageMetric.sdkOrigin = query.getString(i93);
                    }
                    int i94 = columnIndexOrThrow77;
                    Integer valueOf10 = query.isNull(i94) ? null : Integer.valueOf(query.getInt(i94));
                    if (valueOf10 == null) {
                        i14 = i93;
                        bool10 = null;
                    } else {
                        i14 = i93;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    coverageMetric.isRooted = bool10;
                    int i95 = columnIndexOrThrow78;
                    Integer valueOf11 = query.isNull(i95) ? null : Integer.valueOf(query.getInt(i95));
                    if (valueOf11 == null) {
                        columnIndexOrThrow78 = i95;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow78 = i95;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    coverageMetric.isConnectedToVpn = bool11;
                    int i96 = i94;
                    int i97 = columnIndexOrThrow79;
                    coverageMetric.linkDownstreamBandwidth = query.getInt(i97);
                    columnIndexOrThrow79 = i97;
                    int i98 = columnIndexOrThrow80;
                    coverageMetric.linkUpstreamBandwidth = query.getInt(i98);
                    columnIndexOrThrow80 = i98;
                    int i99 = columnIndexOrThrow81;
                    coverageMetric.latencyType = query.getInt(i99);
                    int i100 = columnIndexOrThrow82;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow81 = i99;
                        coverageMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow81 = i99;
                        coverageMetric.serverIp = query.getString(i100);
                    }
                    int i101 = columnIndexOrThrow83;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow82 = i100;
                        coverageMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow82 = i100;
                        coverageMetric.privateIp = query.getString(i101);
                    }
                    int i102 = columnIndexOrThrow84;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow83 = i101;
                        coverageMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow83 = i101;
                        coverageMetric.gatewayIp = query.getString(i102);
                    }
                    int i103 = columnIndexOrThrow85;
                    if (query.isNull(i103)) {
                        columnIndexOrThrow84 = i102;
                        coverageMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow84 = i102;
                        coverageMetric.locationPermissionState = Integer.valueOf(query.getInt(i103));
                    }
                    int i104 = columnIndexOrThrow86;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow85 = i103;
                        coverageMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow85 = i103;
                        coverageMetric.serviceStateStatus = Integer.valueOf(query.getInt(i104));
                    }
                    int i105 = columnIndexOrThrow87;
                    Integer valueOf12 = query.isNull(i105) ? null : Integer.valueOf(query.getInt(i105));
                    if (valueOf12 == null) {
                        columnIndexOrThrow87 = i105;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow87 = i105;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    coverageMetric.isNrCellSeen = bool12;
                    int i106 = columnIndexOrThrow88;
                    Integer valueOf13 = query.isNull(i106) ? null : Integer.valueOf(query.getInt(i106));
                    if (valueOf13 == null) {
                        columnIndexOrThrow88 = i106;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow88 = i106;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    coverageMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i107 = columnIndexOrThrow89;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow86 = i104;
                        coverageMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow86 = i104;
                        coverageMetric.appVersionName = query.getString(i107);
                    }
                    int i108 = i79;
                    int i109 = columnIndexOrThrow90;
                    int i110 = i80;
                    coverageMetric.appVersionCode = query.getLong(i109);
                    int i111 = i107;
                    int i112 = columnIndexOrThrow91;
                    int i113 = i109;
                    coverageMetric.appLastUpdateTime = query.getLong(i112);
                    int i114 = columnIndexOrThrow92;
                    coverageMetric.duplexModeState = query.getInt(i114);
                    columnIndexOrThrow92 = i114;
                    int i115 = columnIndexOrThrow93;
                    coverageMetric.dozeModeState = query.getInt(i115);
                    columnIndexOrThrow93 = i115;
                    int i116 = columnIndexOrThrow94;
                    coverageMetric.callState = query.getInt(i116);
                    int i117 = columnIndexOrThrow95;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow94 = i116;
                        coverageMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow94 = i116;
                        coverageMetric.buildDevice = query.getString(i117);
                    }
                    int i118 = columnIndexOrThrow96;
                    if (query.isNull(i118)) {
                        columnIndexOrThrow95 = i117;
                        coverageMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow95 = i117;
                        coverageMetric.buildHardware = query.getString(i118);
                    }
                    int i119 = columnIndexOrThrow97;
                    if (query.isNull(i119)) {
                        columnIndexOrThrow96 = i118;
                        coverageMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow96 = i118;
                        coverageMetric.buildProduct = query.getString(i119);
                    }
                    int i120 = columnIndexOrThrow98;
                    if (query.isNull(i120)) {
                        columnIndexOrThrow97 = i119;
                        coverageMetric.appId = null;
                    } else {
                        columnIndexOrThrow97 = i119;
                        coverageMetric.appId = query.getString(i120);
                    }
                    int i121 = columnIndexOrThrow99;
                    if (query.getInt(i121) != 0) {
                        columnIndexOrThrow98 = i120;
                        z = true;
                    } else {
                        columnIndexOrThrow98 = i120;
                        z = false;
                    }
                    coverageMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(coverageMetric);
                    columnIndexOrThrow99 = i121;
                    columnIndexOrThrow11 = i2;
                    columnIndexOrThrow14 = i3;
                    columnIndexOrThrow15 = i23;
                    columnIndexOrThrow16 = i25;
                    columnIndexOrThrow17 = i4;
                    columnIndexOrThrow18 = i5;
                    columnIndexOrThrow19 = i36;
                    columnIndexOrThrow22 = i6;
                    columnIndexOrThrow23 = i76;
                    columnIndexOrThrow61 = i9;
                    columnIndexOrThrow63 = i108;
                    columnIndexOrThrow53 = i8;
                    columnIndexOrThrow89 = i111;
                    columnIndexOrThrow = i;
                    i15 = i30;
                    columnIndexOrThrow20 = i33;
                    columnIndexOrThrow21 = i7;
                    columnIndexOrThrow24 = i78;
                    columnIndexOrThrow62 = i10;
                    columnIndexOrThrow64 = i110;
                    columnIndexOrThrow90 = i113;
                    columnIndexOrThrow91 = i112;
                    columnIndexOrThrow12 = i28;
                    int i122 = i11;
                    columnIndexOrThrow68 = i88;
                    columnIndexOrThrow67 = i122;
                    int i123 = i12;
                    columnIndexOrThrow75 = i13;
                    columnIndexOrThrow74 = i123;
                    int i124 = i14;
                    columnIndexOrThrow77 = i96;
                    columnIndexOrThrow76 = i124;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList2;
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
