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
import com.cellrebel.sdk.networking.beans.request.DataUsageMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataUsageMetricDAO_Impl implements DataUsageMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<DataUsageMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<DataUsageMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, DataUsageMetric dataUsageMetric) {
            supportSQLiteStatement.bindLong(1, dataUsageMetric.wiFiSentUsage);
            supportSQLiteStatement.bindLong(2, dataUsageMetric.wiFiReceivedUsage);
            supportSQLiteStatement.bindLong(3, dataUsageMetric.cellularSentUsage);
            supportSQLiteStatement.bindLong(4, dataUsageMetric.cellularReceivedUsage);
            supportSQLiteStatement.bindLong(5, dataUsageMetric.timePeriod);
            supportSQLiteStatement.bindLong(6, dataUsageMetric.id);
            String str = dataUsageMetric.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str);
            }
            String str2 = dataUsageMetric.measurementSequenceId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str2);
            }
            String str3 = dataUsageMetric.clientIp;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str3);
            }
            String str4 = dataUsageMetric.dateTimeOfMeasurement;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str4);
            }
            supportSQLiteStatement.bindLong(11, (long) dataUsageMetric.stateDuringMeasurement);
            String str5 = dataUsageMetric.accessTechnology;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
            String str6 = dataUsageMetric.accessTypeRaw;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str6);
            }
            supportSQLiteStatement.bindLong(14, (long) dataUsageMetric.signalStrength);
            supportSQLiteStatement.bindLong(15, (long) dataUsageMetric.interference);
            String str7 = dataUsageMetric.simMCC;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str7);
            }
            String str8 = dataUsageMetric.simMNC;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str8);
            }
            String str9 = dataUsageMetric.secondarySimMCC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str9);
            }
            String str10 = dataUsageMetric.secondarySimMNC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str10);
            }
            supportSQLiteStatement.bindLong(20, (long) dataUsageMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(21, (long) dataUsageMetric.dataSimSlotNumber);
            String str11 = dataUsageMetric.networkMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str11);
            }
            String str12 = dataUsageMetric.networkMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str12);
            }
            supportSQLiteStatement.bindDouble(24, dataUsageMetric.latitude);
            supportSQLiteStatement.bindDouble(25, dataUsageMetric.longitude);
            supportSQLiteStatement.bindDouble(26, dataUsageMetric.gpsAccuracy);
            String str13 = dataUsageMetric.cellId;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str13);
            }
            String str14 = dataUsageMetric.lacId;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str14);
            }
            String str15 = dataUsageMetric.deviceBrand;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str15);
            }
            String str16 = dataUsageMetric.deviceModel;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str16);
            }
            String str17 = dataUsageMetric.deviceVersion;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str17);
            }
            String str18 = dataUsageMetric.sdkVersionNumber;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str18);
            }
            String str19 = dataUsageMetric.carrierName;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str19);
            }
            String str20 = dataUsageMetric.secondaryCarrierName;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str20);
            }
            String str21 = dataUsageMetric.networkOperatorName;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str21);
            }
            String str22 = dataUsageMetric.os;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str22);
            }
            String str23 = dataUsageMetric.osVersion;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str23);
            }
            String str24 = dataUsageMetric.readableDate;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str24);
            }
            Integer num = dataUsageMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindLong(39, (long) num.intValue());
            }
            Integer num2 = dataUsageMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num2.intValue());
            }
            Integer num3 = dataUsageMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindLong(41, (long) num3.intValue());
            }
            String str25 = dataUsageMetric.cellBands;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str25);
            }
            Integer num4 = dataUsageMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) num4.intValue());
            }
            Integer num5 = dataUsageMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num5.intValue());
            }
            Integer num6 = dataUsageMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num6.intValue());
            }
            Integer num7 = dataUsageMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num7.intValue());
            }
            Integer num8 = dataUsageMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num8.intValue());
            }
            Integer num9 = dataUsageMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num9.intValue());
            }
            Integer num10 = dataUsageMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num10.intValue());
            }
            Integer num11 = dataUsageMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num11.intValue());
            }
            Integer num12 = dataUsageMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num12.intValue());
            }
            Integer num13 = dataUsageMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num13.intValue());
            }
            Integer num14 = dataUsageMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num14.intValue());
            }
            Integer num15 = dataUsageMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num15.intValue());
            }
            Integer num16 = dataUsageMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num16.intValue());
            }
            String str26 = dataUsageMetric.debugString;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str26);
            }
            Boolean bool = dataUsageMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) valueOf.intValue());
            }
            Boolean bool2 = dataUsageMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) valueOf2.intValue());
            }
            Boolean bool3 = dataUsageMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) valueOf3.intValue());
            }
            String str27 = dataUsageMetric.nrState;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str27);
            }
            Integer num18 = dataUsageMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num18.intValue());
            }
            Boolean bool4 = dataUsageMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) valueOf4.intValue());
            }
            Integer num19 = dataUsageMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num19.intValue());
            }
            String str28 = dataUsageMetric.cellBandwidths;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str28);
            }
            String str29 = dataUsageMetric.additionalPlmns;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str29);
            }
            supportSQLiteStatement.bindDouble(66, dataUsageMetric.altitude);
            Float f = dataUsageMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindDouble(67, (double) f.floatValue());
            }
            Float f2 = dataUsageMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindDouble(68, (double) f2.floatValue());
            }
            Float f3 = dataUsageMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindDouble(69, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(70, (long) dataUsageMetric.getRestrictBackgroundStatus);
            String str30 = dataUsageMetric.cellType;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str30);
            }
            Boolean bool5 = dataUsageMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) valueOf5.intValue());
            }
            Boolean bool6 = dataUsageMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) valueOf6.intValue());
            }
            Boolean bool7 = dataUsageMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) valueOf7.intValue());
            }
            Boolean bool8 = dataUsageMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(76, (long) dataUsageMetric.locationAge);
            Integer num20 = dataUsageMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) num20.intValue());
            }
            Integer num21 = dataUsageMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) num21.intValue());
            }
            Boolean bool9 = dataUsageMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf9.intValue());
            }
            String str31 = dataUsageMetric.sdkOrigin;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str31);
            }
            Boolean bool10 = dataUsageMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) valueOf10.intValue());
            }
            Boolean bool11 = dataUsageMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(83, (long) dataUsageMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(84, (long) dataUsageMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(85, (long) dataUsageMetric.latencyType);
            String str32 = dataUsageMetric.serverIp;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindString(86, str32);
            }
            String str33 = dataUsageMetric.privateIp;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindString(87, str33);
            }
            String str34 = dataUsageMetric.gatewayIp;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindString(88, str34);
            }
            Integer num22 = dataUsageMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) num22.intValue());
            }
            Integer num23 = dataUsageMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) num23.intValue());
            }
            Boolean bool12 = dataUsageMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) valueOf12.intValue());
            }
            Boolean bool13 = dataUsageMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) num17.intValue());
            }
            String str35 = dataUsageMetric.appVersionName;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindString(93, str35);
            }
            supportSQLiteStatement.bindLong(94, dataUsageMetric.appVersionCode);
            supportSQLiteStatement.bindLong(95, dataUsageMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(96, (long) dataUsageMetric.duplexModeState);
            supportSQLiteStatement.bindLong(97, (long) dataUsageMetric.dozeModeState);
            supportSQLiteStatement.bindLong(98, (long) dataUsageMetric.callState);
            String str36 = dataUsageMetric.buildDevice;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindString(99, str36);
            }
            String str37 = dataUsageMetric.buildHardware;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindString(100, str37);
            }
            String str38 = dataUsageMetric.buildProduct;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindString(101, str38);
            }
            String str39 = dataUsageMetric.appId;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindString(102, str39);
            }
            supportSQLiteStatement.bindLong(103, dataUsageMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `DataUsageMetric` (`wiFiSentUsage`,`wiFiReceivedUsage`,`cellularSentUsage`,`cellularReceivedUsage`,`timePeriod`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM datausagemetric";
        }
    }

    public DataUsageMetricDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(DataUsageMetric dataUsageMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(dataUsageMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<DataUsageMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<DataUsageMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        int i2;
        int i3;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i4;
        int i5;
        int i6;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i7;
        Boolean bool9;
        int i8;
        int i9;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from datausagemetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "wiFiSentUsage");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "wiFiReceivedUsage");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "cellularSentUsage");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cellularReceivedUsage");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "timePeriod");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i10 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DataUsageMetric dataUsageMetric = new DataUsageMetric();
                    ArrayList arrayList2 = arrayList;
                    int i11 = columnIndexOrThrow11;
                    dataUsageMetric.wiFiSentUsage = query.getLong(columnIndexOrThrow);
                    dataUsageMetric.wiFiReceivedUsage = query.getLong(columnIndexOrThrow2);
                    dataUsageMetric.cellularSentUsage = query.getLong(columnIndexOrThrow3);
                    dataUsageMetric.cellularReceivedUsage = query.getLong(columnIndexOrThrow4);
                    dataUsageMetric.timePeriod = query.getLong(columnIndexOrThrow5);
                    dataUsageMetric.id = query.getLong(columnIndexOrThrow6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        dataUsageMetric.mobileClientId = null;
                    } else {
                        dataUsageMetric.mobileClientId = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        dataUsageMetric.measurementSequenceId = null;
                    } else {
                        dataUsageMetric.measurementSequenceId = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        dataUsageMetric.clientIp = null;
                    } else {
                        dataUsageMetric.clientIp = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        dataUsageMetric.dateTimeOfMeasurement = null;
                    } else {
                        dataUsageMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow10);
                    }
                    int i12 = i11;
                    dataUsageMetric.stateDuringMeasurement = query.getInt(i12);
                    if (query.isNull(columnIndexOrThrow12)) {
                        dataUsageMetric.accessTechnology = null;
                    } else {
                        dataUsageMetric.accessTechnology = query.getString(columnIndexOrThrow12);
                    }
                    int i13 = i10;
                    int i14 = i12;
                    if (query.isNull(i13)) {
                        dataUsageMetric.accessTypeRaw = null;
                    } else {
                        dataUsageMetric.accessTypeRaw = query.getString(i13);
                    }
                    i10 = i13;
                    int i15 = columnIndexOrThrow14;
                    dataUsageMetric.signalStrength = query.getInt(i15);
                    columnIndexOrThrow14 = i15;
                    int i16 = columnIndexOrThrow15;
                    dataUsageMetric.interference = query.getInt(i16);
                    int i17 = columnIndexOrThrow16;
                    if (query.isNull(i17)) {
                        columnIndexOrThrow15 = i16;
                        dataUsageMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow15 = i16;
                        dataUsageMetric.simMCC = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow17;
                    if (query.isNull(i18)) {
                        columnIndexOrThrow16 = i17;
                        dataUsageMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow16 = i17;
                        dataUsageMetric.simMNC = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow18;
                    if (query.isNull(i19)) {
                        columnIndexOrThrow17 = i18;
                        dataUsageMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow17 = i18;
                        dataUsageMetric.secondarySimMCC = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow19;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow18 = i19;
                        dataUsageMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow18 = i19;
                        dataUsageMetric.secondarySimMNC = query.getString(i20);
                    }
                    columnIndexOrThrow19 = i20;
                    int i21 = columnIndexOrThrow20;
                    dataUsageMetric.numberOfSimSlots = query.getInt(i21);
                    columnIndexOrThrow20 = i21;
                    int i22 = columnIndexOrThrow21;
                    dataUsageMetric.dataSimSlotNumber = query.getInt(i22);
                    int i23 = columnIndexOrThrow22;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow21 = i22;
                        dataUsageMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow21 = i22;
                        dataUsageMetric.networkMCC = query.getString(i23);
                    }
                    int i24 = columnIndexOrThrow23;
                    if (query.isNull(i24)) {
                        columnIndexOrThrow22 = i23;
                        dataUsageMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow22 = i23;
                        dataUsageMetric.networkMNC = query.getString(i24);
                    }
                    int i25 = columnIndexOrThrow;
                    int i26 = columnIndexOrThrow24;
                    int i27 = columnIndexOrThrow12;
                    dataUsageMetric.latitude = query.getDouble(i26);
                    int i28 = i24;
                    int i29 = columnIndexOrThrow25;
                    int i30 = i26;
                    dataUsageMetric.longitude = query.getDouble(i29);
                    int i31 = i29;
                    int i32 = columnIndexOrThrow26;
                    int i33 = i28;
                    dataUsageMetric.gpsAccuracy = query.getDouble(i32);
                    int i34 = columnIndexOrThrow27;
                    if (query.isNull(i34)) {
                        dataUsageMetric.cellId = null;
                    } else {
                        dataUsageMetric.cellId = query.getString(i34);
                    }
                    int i35 = columnIndexOrThrow28;
                    if (query.isNull(i35)) {
                        i = i32;
                        dataUsageMetric.lacId = null;
                    } else {
                        i = i32;
                        dataUsageMetric.lacId = query.getString(i35);
                    }
                    int i36 = columnIndexOrThrow29;
                    if (query.isNull(i36)) {
                        i2 = i31;
                        dataUsageMetric.deviceBrand = null;
                    } else {
                        i2 = i31;
                        dataUsageMetric.deviceBrand = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow30;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow29 = i36;
                        dataUsageMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow29 = i36;
                        dataUsageMetric.deviceModel = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow31;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow30 = i37;
                        dataUsageMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow30 = i37;
                        dataUsageMetric.deviceVersion = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow32;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow31 = i38;
                        dataUsageMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow31 = i38;
                        dataUsageMetric.sdkVersionNumber = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow33;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow32 = i39;
                        dataUsageMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow32 = i39;
                        dataUsageMetric.carrierName = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow34;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow33 = i40;
                        dataUsageMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow33 = i40;
                        dataUsageMetric.secondaryCarrierName = query.getString(i41);
                    }
                    int i42 = columnIndexOrThrow35;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow34 = i41;
                        dataUsageMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow34 = i41;
                        dataUsageMetric.networkOperatorName = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow36;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow35 = i42;
                        dataUsageMetric.os = null;
                    } else {
                        columnIndexOrThrow35 = i42;
                        dataUsageMetric.os = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow37;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow36 = i43;
                        dataUsageMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow36 = i43;
                        dataUsageMetric.osVersion = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow38;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow37 = i44;
                        dataUsageMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow37 = i44;
                        dataUsageMetric.readableDate = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow39;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow38 = i45;
                        dataUsageMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow38 = i45;
                        dataUsageMetric.physicalCellId = Integer.valueOf(query.getInt(i46));
                    }
                    int i47 = columnIndexOrThrow40;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow39 = i46;
                        dataUsageMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow39 = i46;
                        dataUsageMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i47));
                    }
                    int i48 = columnIndexOrThrow41;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow40 = i47;
                        dataUsageMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow40 = i47;
                        dataUsageMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i48));
                    }
                    int i49 = columnIndexOrThrow42;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow41 = i48;
                        dataUsageMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow41 = i48;
                        dataUsageMetric.cellBands = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow43;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow42 = i49;
                        dataUsageMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow42 = i49;
                        dataUsageMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i50));
                    }
                    int i51 = columnIndexOrThrow44;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow43 = i50;
                        dataUsageMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow43 = i50;
                        dataUsageMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i51));
                    }
                    int i52 = columnIndexOrThrow45;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow44 = i51;
                        dataUsageMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow44 = i51;
                        dataUsageMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i52));
                    }
                    int i53 = columnIndexOrThrow46;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow45 = i52;
                        dataUsageMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow45 = i52;
                        dataUsageMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i53));
                    }
                    int i54 = columnIndexOrThrow47;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow46 = i53;
                        dataUsageMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow46 = i53;
                        dataUsageMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow48;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow47 = i54;
                        dataUsageMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow47 = i54;
                        dataUsageMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow49;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow48 = i55;
                        dataUsageMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow48 = i55;
                        dataUsageMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow50;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow49 = i56;
                        dataUsageMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow49 = i56;
                        dataUsageMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow51;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow50 = i57;
                        dataUsageMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow50 = i57;
                        dataUsageMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow52;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow51 = i58;
                        dataUsageMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow51 = i58;
                        dataUsageMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow53;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow52 = i59;
                        dataUsageMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow52 = i59;
                        dataUsageMetric.timingAdvance = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow54;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow53 = i60;
                        dataUsageMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow53 = i60;
                        dataUsageMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow55;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow54 = i61;
                        dataUsageMetric.dbm = null;
                    } else {
                        columnIndexOrThrow54 = i61;
                        dataUsageMetric.dbm = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow56;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow55 = i62;
                        dataUsageMetric.debugString = null;
                    } else {
                        columnIndexOrThrow55 = i62;
                        dataUsageMetric.debugString = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow57;
                    Integer valueOf = query.isNull(i64) ? null : Integer.valueOf(query.getInt(i64));
                    if (valueOf == null) {
                        i3 = i64;
                        bool = null;
                    } else {
                        i3 = i64;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    dataUsageMetric.isDcNrRestricted = bool;
                    int i65 = columnIndexOrThrow58;
                    Integer valueOf2 = query.isNull(i65) ? null : Integer.valueOf(query.getInt(i65));
                    if (valueOf2 == null) {
                        columnIndexOrThrow58 = i65;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow58 = i65;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    dataUsageMetric.isNrAvailable = bool2;
                    int i66 = columnIndexOrThrow59;
                    Integer valueOf3 = query.isNull(i66) ? null : Integer.valueOf(query.getInt(i66));
                    if (valueOf3 == null) {
                        columnIndexOrThrow59 = i66;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow59 = i66;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    dataUsageMetric.isEnDcAvailable = bool3;
                    int i67 = columnIndexOrThrow60;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow56 = i63;
                        dataUsageMetric.nrState = null;
                    } else {
                        columnIndexOrThrow56 = i63;
                        dataUsageMetric.nrState = query.getString(i67);
                    }
                    int i68 = columnIndexOrThrow61;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow60 = i67;
                        dataUsageMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow60 = i67;
                        dataUsageMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow62;
                    Integer valueOf4 = query.isNull(i69) ? null : Integer.valueOf(query.getInt(i69));
                    if (valueOf4 == null) {
                        columnIndexOrThrow62 = i69;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow62 = i69;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    dataUsageMetric.isUsingCarrierAggregation = bool4;
                    int i70 = columnIndexOrThrow63;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow61 = i68;
                        dataUsageMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow61 = i68;
                        dataUsageMetric.vopsSupport = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow64;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow63 = i70;
                        dataUsageMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow63 = i70;
                        dataUsageMetric.cellBandwidths = query.getString(i71);
                    }
                    int i72 = columnIndexOrThrow65;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow64 = i71;
                        dataUsageMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow64 = i71;
                        dataUsageMetric.additionalPlmns = query.getString(i72);
                    }
                    int i73 = i34;
                    int i74 = columnIndexOrThrow66;
                    int i75 = i35;
                    dataUsageMetric.altitude = query.getDouble(i74);
                    int i76 = columnIndexOrThrow67;
                    if (query.isNull(i76)) {
                        dataUsageMetric.locationSpeed = null;
                    } else {
                        dataUsageMetric.locationSpeed = Float.valueOf(query.getFloat(i76));
                    }
                    int i77 = columnIndexOrThrow68;
                    if (query.isNull(i77)) {
                        i4 = i72;
                        dataUsageMetric.locationSpeedAccuracy = null;
                    } else {
                        i4 = i72;
                        dataUsageMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i77));
                    }
                    int i78 = columnIndexOrThrow69;
                    if (query.isNull(i78)) {
                        i5 = i74;
                        dataUsageMetric.gpsVerticalAccuracy = null;
                    } else {
                        i5 = i74;
                        dataUsageMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i78));
                    }
                    columnIndexOrThrow69 = i78;
                    int i79 = columnIndexOrThrow70;
                    dataUsageMetric.getRestrictBackgroundStatus = query.getInt(i79);
                    int i80 = columnIndexOrThrow71;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow70 = i79;
                        dataUsageMetric.cellType = null;
                    } else {
                        columnIndexOrThrow70 = i79;
                        dataUsageMetric.cellType = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow72;
                    Integer valueOf5 = query.isNull(i81) ? null : Integer.valueOf(query.getInt(i81));
                    if (valueOf5 == null) {
                        i6 = i80;
                        bool5 = null;
                    } else {
                        i6 = i80;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    dataUsageMetric.isDefaultNetworkActive = bool5;
                    int i82 = columnIndexOrThrow73;
                    Integer valueOf6 = query.isNull(i82) ? null : Integer.valueOf(query.getInt(i82));
                    if (valueOf6 == null) {
                        columnIndexOrThrow73 = i82;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow73 = i82;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    dataUsageMetric.isActiveNetworkMetered = bool6;
                    int i83 = columnIndexOrThrow74;
                    Integer valueOf7 = query.isNull(i83) ? null : Integer.valueOf(query.getInt(i83));
                    if (valueOf7 == null) {
                        columnIndexOrThrow74 = i83;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow74 = i83;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    dataUsageMetric.isOnScreen = bool7;
                    int i84 = columnIndexOrThrow75;
                    Integer valueOf8 = query.isNull(i84) ? null : Integer.valueOf(query.getInt(i84));
                    if (valueOf8 == null) {
                        columnIndexOrThrow75 = i84;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow75 = i84;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    dataUsageMetric.isRoaming = bool8;
                    int i85 = i81;
                    int i86 = columnIndexOrThrow76;
                    dataUsageMetric.locationAge = query.getInt(i86);
                    int i87 = columnIndexOrThrow77;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow76 = i86;
                        dataUsageMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow76 = i86;
                        dataUsageMetric.overrideNetworkType = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow78;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow77 = i87;
                        dataUsageMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow77 = i87;
                        dataUsageMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i88));
                    }
                    int i89 = columnIndexOrThrow79;
                    Integer valueOf9 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf9 == null) {
                        i7 = i88;
                        bool9 = null;
                    } else {
                        i7 = i88;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    dataUsageMetric.anonymize = bool9;
                    int i90 = columnIndexOrThrow80;
                    if (query.isNull(i90)) {
                        i8 = i89;
                        dataUsageMetric.sdkOrigin = null;
                    } else {
                        i8 = i89;
                        dataUsageMetric.sdkOrigin = query.getString(i90);
                    }
                    int i91 = columnIndexOrThrow81;
                    Integer valueOf10 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf10 == null) {
                        i9 = i90;
                        bool10 = null;
                    } else {
                        i9 = i90;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    dataUsageMetric.isRooted = bool10;
                    int i92 = columnIndexOrThrow82;
                    Integer valueOf11 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf11 == null) {
                        columnIndexOrThrow82 = i92;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow82 = i92;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    dataUsageMetric.isConnectedToVpn = bool11;
                    int i93 = i91;
                    int i94 = columnIndexOrThrow83;
                    dataUsageMetric.linkDownstreamBandwidth = query.getInt(i94);
                    columnIndexOrThrow83 = i94;
                    int i95 = columnIndexOrThrow84;
                    dataUsageMetric.linkUpstreamBandwidth = query.getInt(i95);
                    columnIndexOrThrow84 = i95;
                    int i96 = columnIndexOrThrow85;
                    dataUsageMetric.latencyType = query.getInt(i96);
                    int i97 = columnIndexOrThrow86;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow85 = i96;
                        dataUsageMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow85 = i96;
                        dataUsageMetric.serverIp = query.getString(i97);
                    }
                    int i98 = columnIndexOrThrow87;
                    if (query.isNull(i98)) {
                        columnIndexOrThrow86 = i97;
                        dataUsageMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow86 = i97;
                        dataUsageMetric.privateIp = query.getString(i98);
                    }
                    int i99 = columnIndexOrThrow88;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow87 = i98;
                        dataUsageMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow87 = i98;
                        dataUsageMetric.gatewayIp = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow89;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow88 = i99;
                        dataUsageMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow88 = i99;
                        dataUsageMetric.locationPermissionState = Integer.valueOf(query.getInt(i100));
                    }
                    int i101 = columnIndexOrThrow90;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow89 = i100;
                        dataUsageMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow89 = i100;
                        dataUsageMetric.serviceStateStatus = Integer.valueOf(query.getInt(i101));
                    }
                    int i102 = columnIndexOrThrow91;
                    Integer valueOf12 = query.isNull(i102) ? null : Integer.valueOf(query.getInt(i102));
                    if (valueOf12 == null) {
                        columnIndexOrThrow91 = i102;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow91 = i102;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    dataUsageMetric.isNrCellSeen = bool12;
                    int i103 = columnIndexOrThrow92;
                    Integer valueOf13 = query.isNull(i103) ? null : Integer.valueOf(query.getInt(i103));
                    if (valueOf13 == null) {
                        columnIndexOrThrow92 = i103;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow92 = i103;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    dataUsageMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i104 = columnIndexOrThrow93;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow90 = i101;
                        dataUsageMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow90 = i101;
                        dataUsageMetric.appVersionName = query.getString(i104);
                    }
                    int i105 = i76;
                    int i106 = columnIndexOrThrow94;
                    int i107 = i77;
                    dataUsageMetric.appVersionCode = query.getLong(i106);
                    int i108 = i104;
                    int i109 = columnIndexOrThrow95;
                    int i110 = i106;
                    dataUsageMetric.appLastUpdateTime = query.getLong(i109);
                    int i111 = columnIndexOrThrow96;
                    dataUsageMetric.duplexModeState = query.getInt(i111);
                    columnIndexOrThrow96 = i111;
                    int i112 = columnIndexOrThrow97;
                    dataUsageMetric.dozeModeState = query.getInt(i112);
                    columnIndexOrThrow97 = i112;
                    int i113 = columnIndexOrThrow98;
                    dataUsageMetric.callState = query.getInt(i113);
                    int i114 = columnIndexOrThrow99;
                    if (query.isNull(i114)) {
                        columnIndexOrThrow98 = i113;
                        dataUsageMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow98 = i113;
                        dataUsageMetric.buildDevice = query.getString(i114);
                    }
                    int i115 = columnIndexOrThrow100;
                    if (query.isNull(i115)) {
                        columnIndexOrThrow99 = i114;
                        dataUsageMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow99 = i114;
                        dataUsageMetric.buildHardware = query.getString(i115);
                    }
                    int i116 = columnIndexOrThrow101;
                    if (query.isNull(i116)) {
                        columnIndexOrThrow100 = i115;
                        dataUsageMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow100 = i115;
                        dataUsageMetric.buildProduct = query.getString(i116);
                    }
                    int i117 = columnIndexOrThrow102;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow101 = i116;
                        dataUsageMetric.appId = null;
                    } else {
                        columnIndexOrThrow101 = i116;
                        dataUsageMetric.appId = query.getString(i117);
                    }
                    int i118 = columnIndexOrThrow103;
                    if (query.getInt(i118) != 0) {
                        columnIndexOrThrow102 = i117;
                        z = true;
                    } else {
                        columnIndexOrThrow102 = i117;
                        z = false;
                    }
                    dataUsageMetric.isSending = z;
                    arrayList = arrayList2;
                    arrayList.add(dataUsageMetric);
                    columnIndexOrThrow103 = i118;
                    columnIndexOrThrow11 = i14;
                    columnIndexOrThrow57 = i3;
                    int i119 = i110;
                    columnIndexOrThrow95 = i109;
                    columnIndexOrThrow12 = i27;
                    columnIndexOrThrow24 = i30;
                    columnIndexOrThrow25 = i2;
                    columnIndexOrThrow28 = i75;
                    columnIndexOrThrow66 = i5;
                    columnIndexOrThrow68 = i107;
                    columnIndexOrThrow94 = i119;
                    int i120 = i105;
                    columnIndexOrThrow93 = i108;
                    columnIndexOrThrow = i25;
                    columnIndexOrThrow23 = i33;
                    columnIndexOrThrow26 = i;
                    columnIndexOrThrow27 = i73;
                    columnIndexOrThrow65 = i4;
                    columnIndexOrThrow67 = i120;
                    int i121 = i6;
                    columnIndexOrThrow72 = i85;
                    columnIndexOrThrow71 = i121;
                    int i122 = i7;
                    columnIndexOrThrow79 = i8;
                    columnIndexOrThrow78 = i122;
                    int i123 = i9;
                    columnIndexOrThrow81 = i93;
                    columnIndexOrThrow80 = i123;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
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
