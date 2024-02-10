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
import com.cellrebel.sdk.networking.beans.request.ConnectionMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ConnectionMetricDAO_Impl implements ConnectionMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<ConnectionMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<ConnectionMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ConnectionMetric connectionMetric) {
            supportSQLiteStatement.bindLong(1, (long) connectionMetric.videoFailsToStartTotal);
            supportSQLiteStatement.bindLong(2, (long) connectionMetric.pageFailsToLoadTotal);
            supportSQLiteStatement.bindLong(3, (long) connectionMetric.callsTotal);
            supportSQLiteStatement.bindLong(4, (long) connectionMetric.callsBlocksTotal);
            supportSQLiteStatement.bindLong(5, (long) connectionMetric.callsDropsTotal);
            supportSQLiteStatement.bindLong(6, (long) connectionMetric.callSetUpTimeTotal);
            supportSQLiteStatement.bindLong(7, (long) connectionMetric.connectionTimePassive2g);
            supportSQLiteStatement.bindLong(8, (long) connectionMetric.connectionTimePassive3g);
            supportSQLiteStatement.bindLong(9, (long) connectionMetric.connectionTimePassive4g);
            supportSQLiteStatement.bindLong(10, (long) connectionMetric.connectionTimePassive5g);
            supportSQLiteStatement.bindLong(11, (long) connectionMetric.connectionTimePassiveWifi);
            supportSQLiteStatement.bindLong(12, (long) connectionMetric.noConnectionTimePassive);
            supportSQLiteStatement.bindLong(13, (long) connectionMetric.totalTimePassive);
            supportSQLiteStatement.bindLong(14, (long) connectionMetric.connectionTimeActive2g);
            supportSQLiteStatement.bindLong(15, (long) connectionMetric.connectionTimeActive3g);
            supportSQLiteStatement.bindLong(16, (long) connectionMetric.connectionTimeActive4g);
            supportSQLiteStatement.bindLong(17, (long) connectionMetric.connectionTimeActive5g);
            supportSQLiteStatement.bindLong(18, (long) connectionMetric.connectionTimeActiveWifi);
            supportSQLiteStatement.bindLong(19, (long) connectionMetric.noConnectionTimeActive);
            supportSQLiteStatement.bindLong(20, (long) connectionMetric.totalTimeActive);
            supportSQLiteStatement.bindLong(21, connectionMetric.id);
            String str = connectionMetric.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str);
            }
            String str2 = connectionMetric.measurementSequenceId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str2);
            }
            String str3 = connectionMetric.clientIp;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str3);
            }
            String str4 = connectionMetric.dateTimeOfMeasurement;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str4);
            }
            supportSQLiteStatement.bindLong(26, (long) connectionMetric.stateDuringMeasurement);
            String str5 = connectionMetric.accessTechnology;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str5);
            }
            String str6 = connectionMetric.accessTypeRaw;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str6);
            }
            supportSQLiteStatement.bindLong(29, (long) connectionMetric.signalStrength);
            supportSQLiteStatement.bindLong(30, (long) connectionMetric.interference);
            String str7 = connectionMetric.simMCC;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str7);
            }
            String str8 = connectionMetric.simMNC;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str8);
            }
            String str9 = connectionMetric.secondarySimMCC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str9);
            }
            String str10 = connectionMetric.secondarySimMNC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str10);
            }
            supportSQLiteStatement.bindLong(35, (long) connectionMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(36, (long) connectionMetric.dataSimSlotNumber);
            String str11 = connectionMetric.networkMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str11);
            }
            String str12 = connectionMetric.networkMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str12);
            }
            supportSQLiteStatement.bindDouble(39, connectionMetric.latitude);
            supportSQLiteStatement.bindDouble(40, connectionMetric.longitude);
            supportSQLiteStatement.bindDouble(41, connectionMetric.gpsAccuracy);
            String str13 = connectionMetric.cellId;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str13);
            }
            String str14 = connectionMetric.lacId;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str14);
            }
            String str15 = connectionMetric.deviceBrand;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str15);
            }
            String str16 = connectionMetric.deviceModel;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str16);
            }
            String str17 = connectionMetric.deviceVersion;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str17);
            }
            String str18 = connectionMetric.sdkVersionNumber;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str18);
            }
            String str19 = connectionMetric.carrierName;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str19);
            }
            String str20 = connectionMetric.secondaryCarrierName;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str20);
            }
            String str21 = connectionMetric.networkOperatorName;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str21);
            }
            String str22 = connectionMetric.os;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str22);
            }
            String str23 = connectionMetric.osVersion;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str23);
            }
            String str24 = connectionMetric.readableDate;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str24);
            }
            Integer num = connectionMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num.intValue());
            }
            Integer num2 = connectionMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num2.intValue());
            }
            Integer num3 = connectionMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num3.intValue());
            }
            String str25 = connectionMetric.cellBands;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str25);
            }
            Integer num4 = connectionMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num4.intValue());
            }
            Integer num5 = connectionMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num5.intValue());
            }
            Integer num6 = connectionMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num6.intValue());
            }
            Integer num7 = connectionMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num7.intValue());
            }
            Integer num8 = connectionMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num8.intValue());
            }
            Integer num9 = connectionMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num9.intValue());
            }
            Integer num10 = connectionMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num10.intValue());
            }
            Integer num11 = connectionMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num11.intValue());
            }
            Integer num12 = connectionMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num12.intValue());
            }
            Integer num13 = connectionMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num13.intValue());
            }
            Integer num14 = connectionMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num14.intValue());
            }
            Integer num15 = connectionMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num15.intValue());
            }
            Integer num16 = connectionMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num16.intValue());
            }
            String str26 = connectionMetric.debugString;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str26);
            }
            Boolean bool = connectionMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) valueOf.intValue());
            }
            Boolean bool2 = connectionMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) valueOf2.intValue());
            }
            Boolean bool3 = connectionMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) valueOf3.intValue());
            }
            String str27 = connectionMetric.nrState;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindString(75, str27);
            }
            Integer num18 = connectionMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) num18.intValue());
            }
            Boolean bool4 = connectionMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf4.intValue());
            }
            Integer num19 = connectionMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) num19.intValue());
            }
            String str28 = connectionMetric.cellBandwidths;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindString(79, str28);
            }
            String str29 = connectionMetric.additionalPlmns;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str29);
            }
            supportSQLiteStatement.bindDouble(81, connectionMetric.altitude);
            Float f = connectionMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindDouble(82, (double) f.floatValue());
            }
            Float f2 = connectionMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindDouble(83, (double) f2.floatValue());
            }
            Float f3 = connectionMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindDouble(84, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(85, (long) connectionMetric.getRestrictBackgroundStatus);
            String str30 = connectionMetric.cellType;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindString(86, str30);
            }
            Boolean bool5 = connectionMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) valueOf5.intValue());
            }
            Boolean bool6 = connectionMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) valueOf6.intValue());
            }
            Boolean bool7 = connectionMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) valueOf7.intValue());
            }
            Boolean bool8 = connectionMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(91, (long) connectionMetric.locationAge);
            Integer num20 = connectionMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) num20.intValue());
            }
            Integer num21 = connectionMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) num21.intValue());
            }
            Boolean bool9 = connectionMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) valueOf9.intValue());
            }
            String str31 = connectionMetric.sdkOrigin;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindString(95, str31);
            }
            Boolean bool10 = connectionMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) valueOf10.intValue());
            }
            Boolean bool11 = connectionMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(98, (long) connectionMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(99, (long) connectionMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(100, (long) connectionMetric.latencyType);
            String str32 = connectionMetric.serverIp;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindString(101, str32);
            }
            String str33 = connectionMetric.privateIp;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindString(102, str33);
            }
            String str34 = connectionMetric.gatewayIp;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindString(103, str34);
            }
            Integer num22 = connectionMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindLong(104, (long) num22.intValue());
            }
            Integer num23 = connectionMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindLong(105, (long) num23.intValue());
            }
            Boolean bool12 = connectionMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindLong(106, (long) valueOf12.intValue());
            }
            Boolean bool13 = connectionMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindLong(107, (long) num17.intValue());
            }
            String str35 = connectionMetric.appVersionName;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindString(108, str35);
            }
            supportSQLiteStatement.bindLong(109, connectionMetric.appVersionCode);
            supportSQLiteStatement.bindLong(110, connectionMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(111, (long) connectionMetric.duplexModeState);
            supportSQLiteStatement.bindLong(112, (long) connectionMetric.dozeModeState);
            supportSQLiteStatement.bindLong(113, (long) connectionMetric.callState);
            String str36 = connectionMetric.buildDevice;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(114);
            } else {
                supportSQLiteStatement.bindString(114, str36);
            }
            String str37 = connectionMetric.buildHardware;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(115);
            } else {
                supportSQLiteStatement.bindString(115, str37);
            }
            String str38 = connectionMetric.buildProduct;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(116);
            } else {
                supportSQLiteStatement.bindString(116, str38);
            }
            String str39 = connectionMetric.appId;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(117);
            } else {
                supportSQLiteStatement.bindString(117, str39);
            }
            supportSQLiteStatement.bindLong(118, connectionMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `ConnectionMetric` (`videoFailsToStartTotal`,`pageFailsToLoadTotal`,`callsTotal`,`callsBlocksTotal`,`callsDropsTotal`,`callSetUpTimeTotal`,`connectionTimePassive2g`,`connectionTimePassive3g`,`connectionTimePassive4g`,`connectionTimePassive5g`,`connectionTimePassiveWifi`,`noConnectionTimePassive`,`totalTimePassive`,`connectionTimeActive2g`,`connectionTimeActive3g`,`connectionTimeActive4g`,`connectionTimeActive5g`,`connectionTimeActiveWifi`,`noConnectionTimeActive`,`totalTimeActive`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM connectionmetric";
        }
    }

    public ConnectionMetricDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(ConnectionMetric connectionMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(connectionMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<ConnectionMetric> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i6;
        int i7;
        int i8;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i9;
        Boolean bool9;
        int i10;
        int i11;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from connectionmetric", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "videoFailsToStartTotal");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "pageFailsToLoadTotal");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "callsTotal");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "callsBlocksTotal");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "callsDropsTotal");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "callSetUpTimeTotal");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimePassive2g");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimePassive3g");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimePassive4g");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimePassive5g");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimePassiveWifi");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "noConnectionTimePassive");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "totalTimePassive");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimeActive2g");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimeActive3g");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimeActive4g");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimeActive5g");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "connectionTimeActiveWifi");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "noConnectionTimeActive");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "totalTimeActive");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ConnectionMetric connectionMetric = new ConnectionMetric();
                    ArrayList arrayList2 = arrayList;
                    connectionMetric.videoFailsToStartTotal = query.getInt(columnIndexOrThrow);
                    connectionMetric.pageFailsToLoadTotal = query.getInt(columnIndexOrThrow2);
                    connectionMetric.callsTotal = query.getInt(columnIndexOrThrow3);
                    connectionMetric.callsBlocksTotal = query.getInt(columnIndexOrThrow4);
                    connectionMetric.callsDropsTotal = query.getInt(columnIndexOrThrow5);
                    connectionMetric.callSetUpTimeTotal = query.getInt(columnIndexOrThrow6);
                    connectionMetric.connectionTimePassive2g = query.getInt(columnIndexOrThrow7);
                    connectionMetric.connectionTimePassive3g = query.getInt(columnIndexOrThrow8);
                    connectionMetric.connectionTimePassive4g = query.getInt(columnIndexOrThrow9);
                    connectionMetric.connectionTimePassive5g = query.getInt(columnIndexOrThrow10);
                    connectionMetric.connectionTimePassiveWifi = query.getInt(columnIndexOrThrow11);
                    connectionMetric.noConnectionTimePassive = query.getInt(columnIndexOrThrow12);
                    int i13 = i12;
                    int i14 = columnIndexOrThrow11;
                    connectionMetric.totalTimePassive = query.getInt(i13);
                    int i15 = columnIndexOrThrow14;
                    int i16 = i13;
                    connectionMetric.connectionTimeActive2g = query.getInt(i15);
                    int i17 = columnIndexOrThrow15;
                    int i18 = i15;
                    connectionMetric.connectionTimeActive3g = query.getInt(i17);
                    int i19 = columnIndexOrThrow16;
                    int i20 = i17;
                    connectionMetric.connectionTimeActive4g = query.getInt(i19);
                    int i21 = columnIndexOrThrow17;
                    int i22 = i19;
                    connectionMetric.connectionTimeActive5g = query.getInt(i21);
                    int i23 = columnIndexOrThrow18;
                    int i24 = i21;
                    connectionMetric.connectionTimeActiveWifi = query.getInt(i23);
                    int i25 = columnIndexOrThrow19;
                    int i26 = i23;
                    connectionMetric.noConnectionTimeActive = query.getInt(i25);
                    int i27 = columnIndexOrThrow20;
                    int i28 = i25;
                    connectionMetric.totalTimeActive = query.getInt(i27);
                    int i29 = columnIndexOrThrow12;
                    int i30 = columnIndexOrThrow21;
                    int i31 = columnIndexOrThrow;
                    connectionMetric.id = query.getLong(i30);
                    int i32 = columnIndexOrThrow22;
                    if (query.isNull(i32)) {
                        connectionMetric.mobileClientId = null;
                    } else {
                        connectionMetric.mobileClientId = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow23;
                    if (query.isNull(i33)) {
                        i = i30;
                        connectionMetric.measurementSequenceId = null;
                    } else {
                        i = i30;
                        connectionMetric.measurementSequenceId = query.getString(i33);
                    }
                    int i34 = columnIndexOrThrow24;
                    if (query.isNull(i34)) {
                        i2 = i27;
                        connectionMetric.clientIp = null;
                    } else {
                        i2 = i27;
                        connectionMetric.clientIp = query.getString(i34);
                    }
                    int i35 = columnIndexOrThrow25;
                    if (query.isNull(i35)) {
                        columnIndexOrThrow24 = i34;
                        connectionMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow24 = i34;
                        connectionMetric.dateTimeOfMeasurement = query.getString(i35);
                    }
                    columnIndexOrThrow25 = i35;
                    int i36 = columnIndexOrThrow26;
                    connectionMetric.stateDuringMeasurement = query.getInt(i36);
                    int i37 = columnIndexOrThrow27;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow26 = i36;
                        connectionMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow26 = i36;
                        connectionMetric.accessTechnology = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow28;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow27 = i37;
                        connectionMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow27 = i37;
                        connectionMetric.accessTypeRaw = query.getString(i38);
                    }
                    columnIndexOrThrow28 = i38;
                    int i39 = columnIndexOrThrow29;
                    connectionMetric.signalStrength = query.getInt(i39);
                    columnIndexOrThrow29 = i39;
                    int i40 = columnIndexOrThrow30;
                    connectionMetric.interference = query.getInt(i40);
                    int i41 = columnIndexOrThrow31;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow30 = i40;
                        connectionMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow30 = i40;
                        connectionMetric.simMCC = query.getString(i41);
                    }
                    int i42 = columnIndexOrThrow32;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow31 = i41;
                        connectionMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow31 = i41;
                        connectionMetric.simMNC = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow33;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow32 = i42;
                        connectionMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow32 = i42;
                        connectionMetric.secondarySimMCC = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow34;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow33 = i43;
                        connectionMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow33 = i43;
                        connectionMetric.secondarySimMNC = query.getString(i44);
                    }
                    columnIndexOrThrow34 = i44;
                    int i45 = columnIndexOrThrow35;
                    connectionMetric.numberOfSimSlots = query.getInt(i45);
                    columnIndexOrThrow35 = i45;
                    int i46 = columnIndexOrThrow36;
                    connectionMetric.dataSimSlotNumber = query.getInt(i46);
                    int i47 = columnIndexOrThrow37;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow36 = i46;
                        connectionMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow36 = i46;
                        connectionMetric.networkMCC = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow38;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow37 = i47;
                        connectionMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow37 = i47;
                        connectionMetric.networkMNC = query.getString(i48);
                    }
                    int i49 = i32;
                    int i50 = columnIndexOrThrow39;
                    int i51 = i33;
                    connectionMetric.latitude = query.getDouble(i50);
                    int i52 = i48;
                    int i53 = columnIndexOrThrow40;
                    int i54 = i50;
                    connectionMetric.longitude = query.getDouble(i53);
                    int i55 = i53;
                    int i56 = columnIndexOrThrow41;
                    int i57 = i52;
                    connectionMetric.gpsAccuracy = query.getDouble(i56);
                    int i58 = columnIndexOrThrow42;
                    if (query.isNull(i58)) {
                        connectionMetric.cellId = null;
                    } else {
                        connectionMetric.cellId = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow43;
                    if (query.isNull(i59)) {
                        i3 = i56;
                        connectionMetric.lacId = null;
                    } else {
                        i3 = i56;
                        connectionMetric.lacId = query.getString(i59);
                    }
                    int i60 = columnIndexOrThrow44;
                    if (query.isNull(i60)) {
                        i4 = i55;
                        connectionMetric.deviceBrand = null;
                    } else {
                        i4 = i55;
                        connectionMetric.deviceBrand = query.getString(i60);
                    }
                    int i61 = columnIndexOrThrow45;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow44 = i60;
                        connectionMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow44 = i60;
                        connectionMetric.deviceModel = query.getString(i61);
                    }
                    int i62 = columnIndexOrThrow46;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow45 = i61;
                        connectionMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow45 = i61;
                        connectionMetric.deviceVersion = query.getString(i62);
                    }
                    int i63 = columnIndexOrThrow47;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow46 = i62;
                        connectionMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow46 = i62;
                        connectionMetric.sdkVersionNumber = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow48;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow47 = i63;
                        connectionMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow47 = i63;
                        connectionMetric.carrierName = query.getString(i64);
                    }
                    int i65 = columnIndexOrThrow49;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow48 = i64;
                        connectionMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow48 = i64;
                        connectionMetric.secondaryCarrierName = query.getString(i65);
                    }
                    int i66 = columnIndexOrThrow50;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow49 = i65;
                        connectionMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow49 = i65;
                        connectionMetric.networkOperatorName = query.getString(i66);
                    }
                    int i67 = columnIndexOrThrow51;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow50 = i66;
                        connectionMetric.os = null;
                    } else {
                        columnIndexOrThrow50 = i66;
                        connectionMetric.os = query.getString(i67);
                    }
                    int i68 = columnIndexOrThrow52;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow51 = i67;
                        connectionMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow51 = i67;
                        connectionMetric.osVersion = query.getString(i68);
                    }
                    int i69 = columnIndexOrThrow53;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow52 = i68;
                        connectionMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow52 = i68;
                        connectionMetric.readableDate = query.getString(i69);
                    }
                    int i70 = columnIndexOrThrow54;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow53 = i69;
                        connectionMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow53 = i69;
                        connectionMetric.physicalCellId = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow55;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow54 = i70;
                        connectionMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow54 = i70;
                        connectionMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow56;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow55 = i71;
                        connectionMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow55 = i71;
                        connectionMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i72));
                    }
                    int i73 = columnIndexOrThrow57;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow56 = i72;
                        connectionMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow56 = i72;
                        connectionMetric.cellBands = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow58;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow57 = i73;
                        connectionMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow57 = i73;
                        connectionMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i74));
                    }
                    int i75 = columnIndexOrThrow59;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow58 = i74;
                        connectionMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow58 = i74;
                        connectionMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i75));
                    }
                    int i76 = columnIndexOrThrow60;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow59 = i75;
                        connectionMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow59 = i75;
                        connectionMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow61;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow60 = i76;
                        connectionMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow60 = i76;
                        connectionMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow62;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow61 = i77;
                        connectionMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow61 = i77;
                        connectionMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i78));
                    }
                    int i79 = columnIndexOrThrow63;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow62 = i78;
                        connectionMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow62 = i78;
                        connectionMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i79));
                    }
                    int i80 = columnIndexOrThrow64;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow63 = i79;
                        connectionMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow63 = i79;
                        connectionMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i80));
                    }
                    int i81 = columnIndexOrThrow65;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow64 = i80;
                        connectionMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow64 = i80;
                        connectionMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i81));
                    }
                    int i82 = columnIndexOrThrow66;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow65 = i81;
                        connectionMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow65 = i81;
                        connectionMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i82));
                    }
                    int i83 = columnIndexOrThrow67;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow66 = i82;
                        connectionMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow66 = i82;
                        connectionMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i83));
                    }
                    int i84 = columnIndexOrThrow68;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow67 = i83;
                        connectionMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow67 = i83;
                        connectionMetric.timingAdvance = Integer.valueOf(query.getInt(i84));
                    }
                    int i85 = columnIndexOrThrow69;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow68 = i84;
                        connectionMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow68 = i84;
                        connectionMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i85));
                    }
                    int i86 = columnIndexOrThrow70;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow69 = i85;
                        connectionMetric.dbm = null;
                    } else {
                        columnIndexOrThrow69 = i85;
                        connectionMetric.dbm = Integer.valueOf(query.getInt(i86));
                    }
                    int i87 = columnIndexOrThrow71;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow70 = i86;
                        connectionMetric.debugString = null;
                    } else {
                        columnIndexOrThrow70 = i86;
                        connectionMetric.debugString = query.getString(i87);
                    }
                    int i88 = columnIndexOrThrow72;
                    Integer valueOf = query.isNull(i88) ? null : Integer.valueOf(query.getInt(i88));
                    if (valueOf == null) {
                        i5 = i88;
                        bool = null;
                    } else {
                        i5 = i88;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    connectionMetric.isDcNrRestricted = bool;
                    int i89 = columnIndexOrThrow73;
                    Integer valueOf2 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf2 == null) {
                        columnIndexOrThrow73 = i89;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow73 = i89;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    connectionMetric.isNrAvailable = bool2;
                    int i90 = columnIndexOrThrow74;
                    Integer valueOf3 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf3 == null) {
                        columnIndexOrThrow74 = i90;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow74 = i90;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    connectionMetric.isEnDcAvailable = bool3;
                    int i91 = columnIndexOrThrow75;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow71 = i87;
                        connectionMetric.nrState = null;
                    } else {
                        columnIndexOrThrow71 = i87;
                        connectionMetric.nrState = query.getString(i91);
                    }
                    int i92 = columnIndexOrThrow76;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow75 = i91;
                        connectionMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow75 = i91;
                        connectionMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i92));
                    }
                    int i93 = columnIndexOrThrow77;
                    Integer valueOf4 = query.isNull(i93) ? null : Integer.valueOf(query.getInt(i93));
                    if (valueOf4 == null) {
                        columnIndexOrThrow77 = i93;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow77 = i93;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    connectionMetric.isUsingCarrierAggregation = bool4;
                    int i94 = columnIndexOrThrow78;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow76 = i92;
                        connectionMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow76 = i92;
                        connectionMetric.vopsSupport = Integer.valueOf(query.getInt(i94));
                    }
                    int i95 = columnIndexOrThrow79;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow78 = i94;
                        connectionMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow78 = i94;
                        connectionMetric.cellBandwidths = query.getString(i95);
                    }
                    int i96 = columnIndexOrThrow80;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow79 = i95;
                        connectionMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow79 = i95;
                        connectionMetric.additionalPlmns = query.getString(i96);
                    }
                    int i97 = i58;
                    int i98 = columnIndexOrThrow81;
                    int i99 = i59;
                    connectionMetric.altitude = query.getDouble(i98);
                    int i100 = columnIndexOrThrow82;
                    if (query.isNull(i100)) {
                        connectionMetric.locationSpeed = null;
                    } else {
                        connectionMetric.locationSpeed = Float.valueOf(query.getFloat(i100));
                    }
                    int i101 = columnIndexOrThrow83;
                    if (query.isNull(i101)) {
                        i6 = i96;
                        connectionMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i96;
                        connectionMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i101));
                    }
                    int i102 = columnIndexOrThrow84;
                    if (query.isNull(i102)) {
                        i7 = i98;
                        connectionMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i98;
                        connectionMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i102));
                    }
                    columnIndexOrThrow84 = i102;
                    int i103 = columnIndexOrThrow85;
                    connectionMetric.getRestrictBackgroundStatus = query.getInt(i103);
                    int i104 = columnIndexOrThrow86;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow85 = i103;
                        connectionMetric.cellType = null;
                    } else {
                        columnIndexOrThrow85 = i103;
                        connectionMetric.cellType = query.getString(i104);
                    }
                    int i105 = columnIndexOrThrow87;
                    Integer valueOf5 = query.isNull(i105) ? null : Integer.valueOf(query.getInt(i105));
                    if (valueOf5 == null) {
                        i8 = i104;
                        bool5 = null;
                    } else {
                        i8 = i104;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    connectionMetric.isDefaultNetworkActive = bool5;
                    int i106 = columnIndexOrThrow88;
                    Integer valueOf6 = query.isNull(i106) ? null : Integer.valueOf(query.getInt(i106));
                    if (valueOf6 == null) {
                        columnIndexOrThrow88 = i106;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow88 = i106;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    connectionMetric.isActiveNetworkMetered = bool6;
                    int i107 = columnIndexOrThrow89;
                    Integer valueOf7 = query.isNull(i107) ? null : Integer.valueOf(query.getInt(i107));
                    if (valueOf7 == null) {
                        columnIndexOrThrow89 = i107;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow89 = i107;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    connectionMetric.isOnScreen = bool7;
                    int i108 = columnIndexOrThrow90;
                    Integer valueOf8 = query.isNull(i108) ? null : Integer.valueOf(query.getInt(i108));
                    if (valueOf8 == null) {
                        columnIndexOrThrow90 = i108;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow90 = i108;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    connectionMetric.isRoaming = bool8;
                    int i109 = i105;
                    int i110 = columnIndexOrThrow91;
                    connectionMetric.locationAge = query.getInt(i110);
                    int i111 = columnIndexOrThrow92;
                    if (query.isNull(i111)) {
                        columnIndexOrThrow91 = i110;
                        connectionMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow91 = i110;
                        connectionMetric.overrideNetworkType = Integer.valueOf(query.getInt(i111));
                    }
                    int i112 = columnIndexOrThrow93;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow92 = i111;
                        connectionMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow92 = i111;
                        connectionMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i112));
                    }
                    int i113 = columnIndexOrThrow94;
                    Integer valueOf9 = query.isNull(i113) ? null : Integer.valueOf(query.getInt(i113));
                    if (valueOf9 == null) {
                        i9 = i112;
                        bool9 = null;
                    } else {
                        i9 = i112;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    connectionMetric.anonymize = bool9;
                    int i114 = columnIndexOrThrow95;
                    if (query.isNull(i114)) {
                        i10 = i113;
                        connectionMetric.sdkOrigin = null;
                    } else {
                        i10 = i113;
                        connectionMetric.sdkOrigin = query.getString(i114);
                    }
                    int i115 = columnIndexOrThrow96;
                    Integer valueOf10 = query.isNull(i115) ? null : Integer.valueOf(query.getInt(i115));
                    if (valueOf10 == null) {
                        i11 = i114;
                        bool10 = null;
                    } else {
                        i11 = i114;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    connectionMetric.isRooted = bool10;
                    int i116 = columnIndexOrThrow97;
                    Integer valueOf11 = query.isNull(i116) ? null : Integer.valueOf(query.getInt(i116));
                    if (valueOf11 == null) {
                        columnIndexOrThrow97 = i116;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow97 = i116;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    connectionMetric.isConnectedToVpn = bool11;
                    int i117 = i115;
                    int i118 = columnIndexOrThrow98;
                    connectionMetric.linkDownstreamBandwidth = query.getInt(i118);
                    columnIndexOrThrow98 = i118;
                    int i119 = columnIndexOrThrow99;
                    connectionMetric.linkUpstreamBandwidth = query.getInt(i119);
                    columnIndexOrThrow99 = i119;
                    int i120 = columnIndexOrThrow100;
                    connectionMetric.latencyType = query.getInt(i120);
                    int i121 = columnIndexOrThrow101;
                    if (query.isNull(i121)) {
                        columnIndexOrThrow100 = i120;
                        connectionMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow100 = i120;
                        connectionMetric.serverIp = query.getString(i121);
                    }
                    int i122 = columnIndexOrThrow102;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow101 = i121;
                        connectionMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow101 = i121;
                        connectionMetric.privateIp = query.getString(i122);
                    }
                    int i123 = columnIndexOrThrow103;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow102 = i122;
                        connectionMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow102 = i122;
                        connectionMetric.gatewayIp = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow104;
                    if (query.isNull(i124)) {
                        columnIndexOrThrow103 = i123;
                        connectionMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow103 = i123;
                        connectionMetric.locationPermissionState = Integer.valueOf(query.getInt(i124));
                    }
                    int i125 = columnIndexOrThrow105;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow104 = i124;
                        connectionMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow104 = i124;
                        connectionMetric.serviceStateStatus = Integer.valueOf(query.getInt(i125));
                    }
                    int i126 = columnIndexOrThrow106;
                    Integer valueOf12 = query.isNull(i126) ? null : Integer.valueOf(query.getInt(i126));
                    if (valueOf12 == null) {
                        columnIndexOrThrow106 = i126;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow106 = i126;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    connectionMetric.isNrCellSeen = bool12;
                    int i127 = columnIndexOrThrow107;
                    Integer valueOf13 = query.isNull(i127) ? null : Integer.valueOf(query.getInt(i127));
                    if (valueOf13 == null) {
                        columnIndexOrThrow107 = i127;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow107 = i127;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    connectionMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i128 = columnIndexOrThrow108;
                    if (query.isNull(i128)) {
                        columnIndexOrThrow105 = i125;
                        connectionMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow105 = i125;
                        connectionMetric.appVersionName = query.getString(i128);
                    }
                    int i129 = i100;
                    int i130 = columnIndexOrThrow109;
                    int i131 = i101;
                    connectionMetric.appVersionCode = query.getLong(i130);
                    int i132 = i128;
                    int i133 = columnIndexOrThrow110;
                    int i134 = i130;
                    connectionMetric.appLastUpdateTime = query.getLong(i133);
                    int i135 = columnIndexOrThrow111;
                    connectionMetric.duplexModeState = query.getInt(i135);
                    columnIndexOrThrow111 = i135;
                    int i136 = columnIndexOrThrow112;
                    connectionMetric.dozeModeState = query.getInt(i136);
                    columnIndexOrThrow112 = i136;
                    int i137 = columnIndexOrThrow113;
                    connectionMetric.callState = query.getInt(i137);
                    int i138 = columnIndexOrThrow114;
                    if (query.isNull(i138)) {
                        columnIndexOrThrow113 = i137;
                        connectionMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow113 = i137;
                        connectionMetric.buildDevice = query.getString(i138);
                    }
                    int i139 = columnIndexOrThrow115;
                    if (query.isNull(i139)) {
                        columnIndexOrThrow114 = i138;
                        connectionMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow114 = i138;
                        connectionMetric.buildHardware = query.getString(i139);
                    }
                    int i140 = columnIndexOrThrow116;
                    if (query.isNull(i140)) {
                        columnIndexOrThrow115 = i139;
                        connectionMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow115 = i139;
                        connectionMetric.buildProduct = query.getString(i140);
                    }
                    int i141 = columnIndexOrThrow117;
                    if (query.isNull(i141)) {
                        columnIndexOrThrow116 = i140;
                        connectionMetric.appId = null;
                    } else {
                        columnIndexOrThrow116 = i140;
                        connectionMetric.appId = query.getString(i141);
                    }
                    int i142 = columnIndexOrThrow118;
                    if (query.getInt(i142) != 0) {
                        columnIndexOrThrow117 = i141;
                        z = true;
                    } else {
                        columnIndexOrThrow117 = i141;
                        z = false;
                    }
                    connectionMetric.isSending = z;
                    arrayList = arrayList2;
                    arrayList.add(connectionMetric);
                    columnIndexOrThrow118 = i142;
                    columnIndexOrThrow11 = i14;
                    columnIndexOrThrow72 = i5;
                    i12 = i16;
                    columnIndexOrThrow14 = i18;
                    columnIndexOrThrow15 = i20;
                    columnIndexOrThrow16 = i22;
                    columnIndexOrThrow17 = i24;
                    columnIndexOrThrow18 = i26;
                    columnIndexOrThrow19 = i28;
                    columnIndexOrThrow20 = i2;
                    columnIndexOrThrow23 = i51;
                    columnIndexOrThrow39 = i54;
                    columnIndexOrThrow40 = i4;
                    columnIndexOrThrow43 = i99;
                    columnIndexOrThrow81 = i7;
                    columnIndexOrThrow83 = i131;
                    columnIndexOrThrow109 = i134;
                    columnIndexOrThrow110 = i133;
                    columnIndexOrThrow12 = i29;
                    int i143 = i129;
                    columnIndexOrThrow108 = i132;
                    columnIndexOrThrow = i31;
                    columnIndexOrThrow21 = i;
                    columnIndexOrThrow22 = i49;
                    columnIndexOrThrow38 = i57;
                    columnIndexOrThrow41 = i3;
                    columnIndexOrThrow42 = i97;
                    columnIndexOrThrow80 = i6;
                    columnIndexOrThrow82 = i143;
                    int i144 = i8;
                    columnIndexOrThrow87 = i109;
                    columnIndexOrThrow86 = i144;
                    int i145 = i9;
                    columnIndexOrThrow94 = i10;
                    columnIndexOrThrow93 = i145;
                    int i146 = i11;
                    columnIndexOrThrow96 = i117;
                    columnIndexOrThrow95 = i146;
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
