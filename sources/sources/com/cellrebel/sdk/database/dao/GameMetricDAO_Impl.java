package com.cellrebel.sdk.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GameMetricDAO_Impl implements GameMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<GameInfoMetric> b;
    private final EntityDeletionOrUpdateAdapter<GameInfoMetric> c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;

    class a extends EntityInsertionAdapter<GameInfoMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, GameInfoMetric gameInfoMetric) {
            String str = gameInfoMetric.serverName;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = gameInfoMetric.gameName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = gameInfoMetric.serverUrl;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            Float f = gameInfoMetric.latency;
            if (f == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindDouble(4, (double) f.floatValue());
            }
            Float f2 = gameInfoMetric.pingsCount;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindDouble(5, (double) f2.floatValue());
            }
            Float f3 = gameInfoMetric.failedMeasurementsCount;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindDouble(6, (double) f3.floatValue());
            }
            Float f4 = gameInfoMetric.jitter;
            if (f4 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindDouble(7, (double) f4.floatValue());
            }
            supportSQLiteStatement.bindLong(8, gameInfoMetric.isSent ? 1 : 0);
            supportSQLiteStatement.bindLong(9, gameInfoMetric.isOffline ? 1 : 0);
            supportSQLiteStatement.bindLong(10, gameInfoMetric.isUnderAdditionalLoad ? 1 : 0);
            supportSQLiteStatement.bindLong(11, gameInfoMetric.isCached ? 1 : 0);
            String str4 = gameInfoMetric.loadedLatencyTestFileTransferUrl;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str4);
            }
            Integer num = gameInfoMetric.fileTransferId;
            if (num == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, (long) num.intValue());
            }
            supportSQLiteStatement.bindLong(14, gameInfoMetric.id);
            String str5 = gameInfoMetric.mobileClientId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str5);
            }
            String str6 = gameInfoMetric.measurementSequenceId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str6);
            }
            String str7 = gameInfoMetric.clientIp;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str7);
            }
            String str8 = gameInfoMetric.dateTimeOfMeasurement;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str8);
            }
            supportSQLiteStatement.bindLong(19, (long) gameInfoMetric.stateDuringMeasurement);
            String str9 = gameInfoMetric.accessTechnology;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str9);
            }
            String str10 = gameInfoMetric.accessTypeRaw;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str10);
            }
            supportSQLiteStatement.bindLong(22, (long) gameInfoMetric.signalStrength);
            supportSQLiteStatement.bindLong(23, (long) gameInfoMetric.interference);
            String str11 = gameInfoMetric.simMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str11);
            }
            String str12 = gameInfoMetric.simMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str12);
            }
            String str13 = gameInfoMetric.secondarySimMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str13);
            }
            String str14 = gameInfoMetric.secondarySimMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str14);
            }
            supportSQLiteStatement.bindLong(28, (long) gameInfoMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(29, (long) gameInfoMetric.dataSimSlotNumber);
            String str15 = gameInfoMetric.networkMCC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str15);
            }
            String str16 = gameInfoMetric.networkMNC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str16);
            }
            supportSQLiteStatement.bindDouble(32, gameInfoMetric.latitude);
            supportSQLiteStatement.bindDouble(33, gameInfoMetric.longitude);
            supportSQLiteStatement.bindDouble(34, gameInfoMetric.gpsAccuracy);
            String str17 = gameInfoMetric.cellId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str17);
            }
            String str18 = gameInfoMetric.lacId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str18);
            }
            String str19 = gameInfoMetric.deviceBrand;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str19);
            }
            String str20 = gameInfoMetric.deviceModel;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str20);
            }
            String str21 = gameInfoMetric.deviceVersion;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str21);
            }
            String str22 = gameInfoMetric.sdkVersionNumber;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str22);
            }
            String str23 = gameInfoMetric.carrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str23);
            }
            String str24 = gameInfoMetric.secondaryCarrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str24);
            }
            String str25 = gameInfoMetric.networkOperatorName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str25);
            }
            String str26 = gameInfoMetric.os;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str26);
            }
            String str27 = gameInfoMetric.osVersion;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str27);
            }
            String str28 = gameInfoMetric.readableDate;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str28);
            }
            Integer num2 = gameInfoMetric.physicalCellId;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num2.intValue());
            }
            Integer num3 = gameInfoMetric.absoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num3.intValue());
            }
            Integer num4 = gameInfoMetric.connectionAbsoluteRfChannelNumber;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num4.intValue());
            }
            String str29 = gameInfoMetric.cellBands;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str29);
            }
            Integer num5 = gameInfoMetric.channelQualityIndicator;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num5.intValue());
            }
            Integer num6 = gameInfoMetric.referenceSignalSignalToNoiseRatio;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num6.intValue());
            }
            Integer num7 = gameInfoMetric.referenceSignalReceivedPower;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num7.intValue());
            }
            Integer num8 = gameInfoMetric.referenceSignalReceivedQuality;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num8.intValue());
            }
            Integer num9 = gameInfoMetric.csiReferenceSignalReceivedPower;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num9.intValue());
            }
            Integer num10 = gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num10.intValue());
            }
            Integer num11 = gameInfoMetric.csiReferenceSignalReceivedQuality;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num11.intValue());
            }
            Integer num12 = gameInfoMetric.ssReferenceSignalReceivedPower;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num12.intValue());
            }
            Integer num13 = gameInfoMetric.ssReferenceSignalReceivedQuality;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num13.intValue());
            }
            Integer num14 = gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num14.intValue());
            }
            Integer num15 = gameInfoMetric.timingAdvance;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num15.intValue());
            }
            Integer num16 = gameInfoMetric.signalStrengthAsu;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num16.intValue());
            }
            Integer num17 = gameInfoMetric.dbm;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num17.intValue());
            }
            String str30 = gameInfoMetric.debugString;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str30);
            }
            Boolean bool = gameInfoMetric.isDcNrRestricted;
            Integer num18 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) valueOf.intValue());
            }
            Boolean bool2 = gameInfoMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) valueOf2.intValue());
            }
            Boolean bool3 = gameInfoMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) valueOf3.intValue());
            }
            String str31 = gameInfoMetric.nrState;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindString(68, str31);
            }
            Integer num19 = gameInfoMetric.nrFrequencyRange;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num19.intValue());
            }
            Boolean bool4 = gameInfoMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) valueOf4.intValue());
            }
            Integer num20 = gameInfoMetric.vopsSupport;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num20.intValue());
            }
            String str32 = gameInfoMetric.cellBandwidths;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindString(72, str32);
            }
            String str33 = gameInfoMetric.additionalPlmns;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindString(73, str33);
            }
            supportSQLiteStatement.bindDouble(74, gameInfoMetric.altitude);
            Float f5 = gameInfoMetric.locationSpeed;
            if (f5 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindDouble(75, (double) f5.floatValue());
            }
            Float f6 = gameInfoMetric.locationSpeedAccuracy;
            if (f6 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindDouble(76, (double) f6.floatValue());
            }
            Float f7 = gameInfoMetric.gpsVerticalAccuracy;
            if (f7 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindDouble(77, (double) f7.floatValue());
            }
            supportSQLiteStatement.bindLong(78, (long) gameInfoMetric.getRestrictBackgroundStatus);
            String str34 = gameInfoMetric.cellType;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindString(79, str34);
            }
            Boolean bool5 = gameInfoMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) valueOf5.intValue());
            }
            Boolean bool6 = gameInfoMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) valueOf6.intValue());
            }
            Boolean bool7 = gameInfoMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) valueOf7.intValue());
            }
            Boolean bool8 = gameInfoMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(84, (long) gameInfoMetric.locationAge);
            Integer num21 = gameInfoMetric.overrideNetworkType;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindLong(85, (long) num21.intValue());
            }
            Integer num22 = gameInfoMetric.accessNetworkTechnologyRaw;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) num22.intValue());
            }
            Boolean bool9 = gameInfoMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) valueOf9.intValue());
            }
            String str35 = gameInfoMetric.sdkOrigin;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindString(88, str35);
            }
            Boolean bool10 = gameInfoMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) valueOf10.intValue());
            }
            Boolean bool11 = gameInfoMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(91, (long) gameInfoMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(92, (long) gameInfoMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(93, (long) gameInfoMetric.latencyType);
            String str36 = gameInfoMetric.serverIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindString(94, str36);
            }
            String str37 = gameInfoMetric.privateIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindString(95, str37);
            }
            String str38 = gameInfoMetric.gatewayIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str38);
            }
            Integer num23 = gameInfoMetric.locationPermissionState;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num23.intValue());
            }
            Integer num24 = gameInfoMetric.serviceStateStatus;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) num24.intValue());
            }
            Boolean bool12 = gameInfoMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf12.intValue());
            }
            Boolean bool13 = gameInfoMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num18 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num18 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindLong(100, (long) num18.intValue());
            }
            String str39 = gameInfoMetric.appVersionName;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindString(101, str39);
            }
            supportSQLiteStatement.bindLong(102, gameInfoMetric.appVersionCode);
            supportSQLiteStatement.bindLong(103, gameInfoMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(104, (long) gameInfoMetric.duplexModeState);
            supportSQLiteStatement.bindLong(105, (long) gameInfoMetric.dozeModeState);
            supportSQLiteStatement.bindLong(106, (long) gameInfoMetric.callState);
            String str40 = gameInfoMetric.buildDevice;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str40);
            }
            String str41 = gameInfoMetric.buildHardware;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindString(108, str41);
            }
            String str42 = gameInfoMetric.buildProduct;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindString(109, str42);
            }
            String str43 = gameInfoMetric.appId;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindString(110, str43);
            }
            supportSQLiteStatement.bindLong(111, gameInfoMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `GameInfoMetric` (`serverName`,`gameName`,`serverUrl`,`latency`,`pingsCount`,`failedMeasurementsCount`,`jitter`,`isSent`,`isOffline`,`isUnderAdditionalLoad`,`isCached`,`loadedLatencyTestFileTransferUrl`,`fileTransferId`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<GameInfoMetric> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, GameInfoMetric gameInfoMetric) {
            supportSQLiteStatement.bindLong(1, gameInfoMetric.id);
        }

        public String createQuery() {
            return "DELETE FROM `GameInfoMetric` WHERE `id` = ?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM gameinfometric";
        }
    }

    class d extends SharedSQLiteStatement {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM gameinfometric WHERE gameName = ? AND serverUrl = ? AND isUnderAdditionalLoad = ?";
        }
    }

    public GameMetricDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public List<GameInfoMetric> a(String str, Integer num, boolean z) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
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
        boolean z2;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from gameinfometric WHERE gameName = ? AND isUnderAdditionalLoad = ? ORDER BY latency ASC LIMIT ?", 3);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        acquire.bindLong(2, z ? 1 : 0);
        if (num == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindLong(3, (long) num.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gameName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "pingsCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "failedMeasurementsCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isSent");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "isOffline");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "isUnderAdditionalLoad");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "isCached");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyTestFileTransferUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferId");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    GameInfoMetric gameInfoMetric = new GameInfoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = null;
                    } else {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        gameInfoMetric.gameName = null;
                    } else {
                        gameInfoMetric.gameName = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        gameInfoMetric.serverUrl = null;
                    } else {
                        gameInfoMetric.serverUrl = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        gameInfoMetric.latency = null;
                    } else {
                        gameInfoMetric.latency = Float.valueOf(query.getFloat(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        gameInfoMetric.pingsCount = null;
                    } else {
                        gameInfoMetric.pingsCount = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        gameInfoMetric.failedMeasurementsCount = null;
                    } else {
                        gameInfoMetric.failedMeasurementsCount = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        gameInfoMetric.jitter = null;
                    } else {
                        gameInfoMetric.jitter = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                    }
                    gameInfoMetric.isSent = query.getInt(columnIndexOrThrow8) != 0;
                    gameInfoMetric.isOffline = query.getInt(columnIndexOrThrow9) != 0;
                    gameInfoMetric.isUnderAdditionalLoad = query.getInt(columnIndexOrThrow10) != 0;
                    gameInfoMetric.isCached = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = null;
                    } else {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = query.getString(columnIndexOrThrow12);
                    }
                    int i13 = i12;
                    if (query.isNull(i13)) {
                        i = columnIndexOrThrow10;
                        gameInfoMetric.fileTransferId = null;
                    } else {
                        i = columnIndexOrThrow10;
                        gameInfoMetric.fileTransferId = Integer.valueOf(query.getInt(i13));
                    }
                    int i14 = columnIndexOrThrow14;
                    int i15 = columnIndexOrThrow11;
                    int i16 = columnIndexOrThrow12;
                    gameInfoMetric.id = query.getLong(i14);
                    int i17 = columnIndexOrThrow15;
                    if (query.isNull(i17)) {
                        gameInfoMetric.mobileClientId = null;
                    } else {
                        gameInfoMetric.mobileClientId = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow16;
                    if (query.isNull(i18)) {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = null;
                    } else {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow17;
                    if (query.isNull(i19)) {
                        i3 = i14;
                        gameInfoMetric.clientIp = null;
                    } else {
                        i3 = i14;
                        gameInfoMetric.clientIp = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow18;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = query.getString(i20);
                    }
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    gameInfoMetric.stateDuringMeasurement = query.getInt(i21);
                    int i22 = columnIndexOrThrow20;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow21;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = query.getString(i23);
                    }
                    columnIndexOrThrow21 = i23;
                    int i24 = columnIndexOrThrow22;
                    gameInfoMetric.signalStrength = query.getInt(i24);
                    columnIndexOrThrow22 = i24;
                    int i25 = columnIndexOrThrow23;
                    gameInfoMetric.interference = query.getInt(i25);
                    int i26 = columnIndexOrThrow24;
                    if (query.isNull(i26)) {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow25;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow26;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow27;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = query.getString(i29);
                    }
                    columnIndexOrThrow27 = i29;
                    int i30 = columnIndexOrThrow28;
                    gameInfoMetric.numberOfSimSlots = query.getInt(i30);
                    columnIndexOrThrow28 = i30;
                    int i31 = columnIndexOrThrow29;
                    gameInfoMetric.dataSimSlotNumber = query.getInt(i31);
                    int i32 = columnIndexOrThrow30;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow31;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = query.getString(i33);
                    }
                    int i34 = i17;
                    int i35 = columnIndexOrThrow32;
                    int i36 = i18;
                    gameInfoMetric.latitude = query.getDouble(i35);
                    int i37 = i33;
                    int i38 = columnIndexOrThrow33;
                    int i39 = i35;
                    gameInfoMetric.longitude = query.getDouble(i38);
                    int i40 = columnIndexOrThrow34;
                    int i41 = i38;
                    gameInfoMetric.gpsAccuracy = query.getDouble(i40);
                    int i42 = columnIndexOrThrow35;
                    if (query.isNull(i42)) {
                        gameInfoMetric.cellId = null;
                    } else {
                        gameInfoMetric.cellId = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow36;
                    if (query.isNull(i43)) {
                        i4 = i40;
                        gameInfoMetric.lacId = null;
                    } else {
                        i4 = i40;
                        gameInfoMetric.lacId = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow37;
                    if (query.isNull(i44)) {
                        i5 = i42;
                        gameInfoMetric.deviceBrand = null;
                    } else {
                        i5 = i42;
                        gameInfoMetric.deviceBrand = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow38;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow37 = i44;
                        gameInfoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow37 = i44;
                        gameInfoMetric.deviceModel = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow39;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow38 = i45;
                        gameInfoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow38 = i45;
                        gameInfoMetric.deviceVersion = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow40;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow39 = i46;
                        gameInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow39 = i46;
                        gameInfoMetric.sdkVersionNumber = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow41;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow40 = i47;
                        gameInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow40 = i47;
                        gameInfoMetric.carrierName = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow42;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow41 = i48;
                        gameInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow41 = i48;
                        gameInfoMetric.secondaryCarrierName = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow43;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow42 = i49;
                        gameInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow42 = i49;
                        gameInfoMetric.networkOperatorName = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow44;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow43 = i50;
                        gameInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow43 = i50;
                        gameInfoMetric.os = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow45;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow44 = i51;
                        gameInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow44 = i51;
                        gameInfoMetric.osVersion = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow46;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow45 = i52;
                        gameInfoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow45 = i52;
                        gameInfoMetric.readableDate = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow47;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow46 = i53;
                        gameInfoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow46 = i53;
                        gameInfoMetric.physicalCellId = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow48;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow47 = i54;
                        gameInfoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow47 = i54;
                        gameInfoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow49;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow48 = i55;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow48 = i55;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow50;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow49 = i56;
                        gameInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow49 = i56;
                        gameInfoMetric.cellBands = query.getString(i57);
                    }
                    int i58 = columnIndexOrThrow51;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow50 = i57;
                        gameInfoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow50 = i57;
                        gameInfoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow52;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow51 = i58;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow51 = i58;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow53;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow52 = i59;
                        gameInfoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow52 = i59;
                        gameInfoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow54;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow53 = i60;
                        gameInfoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow53 = i60;
                        gameInfoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow55;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow54 = i61;
                        gameInfoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i61;
                        gameInfoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow56;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow55 = i62;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow55 = i62;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow57;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow56 = i63;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow56 = i63;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow58;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow57 = i64;
                        gameInfoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow57 = i64;
                        gameInfoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow59;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow58 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow58 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow60;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow59 = i66;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow59 = i66;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow61;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow60 = i67;
                        gameInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow60 = i67;
                        gameInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow62;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow61 = i68;
                        gameInfoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow61 = i68;
                        gameInfoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow63;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow62 = i69;
                        gameInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow62 = i69;
                        gameInfoMetric.dbm = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow64;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow63 = i70;
                        gameInfoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow63 = i70;
                        gameInfoMetric.debugString = query.getString(i71);
                    }
                    int i72 = columnIndexOrThrow65;
                    Integer valueOf = query.isNull(i72) ? null : Integer.valueOf(query.getInt(i72));
                    if (valueOf == null) {
                        columnIndexOrThrow65 = i72;
                        bool = null;
                    } else {
                        columnIndexOrThrow65 = i72;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    gameInfoMetric.isDcNrRestricted = bool;
                    int i73 = columnIndexOrThrow66;
                    Integer valueOf2 = query.isNull(i73) ? null : Integer.valueOf(query.getInt(i73));
                    if (valueOf2 == null) {
                        columnIndexOrThrow66 = i73;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow66 = i73;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    gameInfoMetric.isNrAvailable = bool2;
                    int i74 = columnIndexOrThrow67;
                    Integer valueOf3 = query.isNull(i74) ? null : Integer.valueOf(query.getInt(i74));
                    if (valueOf3 == null) {
                        columnIndexOrThrow67 = i74;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow67 = i74;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    gameInfoMetric.isEnDcAvailable = bool3;
                    int i75 = columnIndexOrThrow68;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow64 = i71;
                        gameInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow64 = i71;
                        gameInfoMetric.nrState = query.getString(i75);
                    }
                    int i76 = columnIndexOrThrow69;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow68 = i75;
                        gameInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow68 = i75;
                        gameInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow70;
                    Integer valueOf4 = query.isNull(i77) ? null : Integer.valueOf(query.getInt(i77));
                    if (valueOf4 == null) {
                        columnIndexOrThrow70 = i77;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow70 = i77;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    gameInfoMetric.isUsingCarrierAggregation = bool4;
                    int i78 = columnIndexOrThrow71;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow69 = i76;
                        gameInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow69 = i76;
                        gameInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i78));
                    }
                    int i79 = columnIndexOrThrow72;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow71 = i78;
                        gameInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow71 = i78;
                        gameInfoMetric.cellBandwidths = query.getString(i79);
                    }
                    int i80 = columnIndexOrThrow73;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow72 = i79;
                        gameInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow72 = i79;
                        gameInfoMetric.additionalPlmns = query.getString(i80);
                    }
                    int i81 = i37;
                    int i82 = columnIndexOrThrow74;
                    int i83 = i43;
                    gameInfoMetric.altitude = query.getDouble(i82);
                    int i84 = columnIndexOrThrow75;
                    if (query.isNull(i84)) {
                        gameInfoMetric.locationSpeed = null;
                    } else {
                        gameInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i84));
                    }
                    int i85 = columnIndexOrThrow76;
                    if (query.isNull(i85)) {
                        i6 = i80;
                        gameInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i80;
                        gameInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i85));
                    }
                    int i86 = columnIndexOrThrow77;
                    if (query.isNull(i86)) {
                        i7 = i82;
                        gameInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i82;
                        gameInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i86));
                    }
                    columnIndexOrThrow77 = i86;
                    int i87 = columnIndexOrThrow78;
                    gameInfoMetric.getRestrictBackgroundStatus = query.getInt(i87);
                    int i88 = columnIndexOrThrow79;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow78 = i87;
                        gameInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow78 = i87;
                        gameInfoMetric.cellType = query.getString(i88);
                    }
                    int i89 = columnIndexOrThrow80;
                    Integer valueOf5 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf5 == null) {
                        i8 = i88;
                        bool5 = null;
                    } else {
                        i8 = i88;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    gameInfoMetric.isDefaultNetworkActive = bool5;
                    int i90 = columnIndexOrThrow81;
                    Integer valueOf6 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf6 == null) {
                        columnIndexOrThrow81 = i90;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow81 = i90;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    gameInfoMetric.isActiveNetworkMetered = bool6;
                    int i91 = columnIndexOrThrow82;
                    Integer valueOf7 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf7 == null) {
                        columnIndexOrThrow82 = i91;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow82 = i91;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    gameInfoMetric.isOnScreen = bool7;
                    int i92 = columnIndexOrThrow83;
                    Integer valueOf8 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf8 == null) {
                        columnIndexOrThrow83 = i92;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow83 = i92;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    gameInfoMetric.isRoaming = bool8;
                    int i93 = i89;
                    int i94 = columnIndexOrThrow84;
                    gameInfoMetric.locationAge = query.getInt(i94);
                    int i95 = columnIndexOrThrow85;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow84 = i94;
                        gameInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow84 = i94;
                        gameInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow86;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow85 = i95;
                        gameInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow85 = i95;
                        gameInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow87;
                    Integer valueOf9 = query.isNull(i97) ? null : Integer.valueOf(query.getInt(i97));
                    if (valueOf9 == null) {
                        i9 = i96;
                        bool9 = null;
                    } else {
                        i9 = i96;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    gameInfoMetric.anonymize = bool9;
                    int i98 = columnIndexOrThrow88;
                    if (query.isNull(i98)) {
                        i10 = i97;
                        gameInfoMetric.sdkOrigin = null;
                    } else {
                        i10 = i97;
                        gameInfoMetric.sdkOrigin = query.getString(i98);
                    }
                    int i99 = columnIndexOrThrow89;
                    Integer valueOf10 = query.isNull(i99) ? null : Integer.valueOf(query.getInt(i99));
                    if (valueOf10 == null) {
                        i11 = i98;
                        bool10 = null;
                    } else {
                        i11 = i98;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    gameInfoMetric.isRooted = bool10;
                    int i100 = columnIndexOrThrow90;
                    Integer valueOf11 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf11 == null) {
                        columnIndexOrThrow90 = i100;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow90 = i100;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    gameInfoMetric.isConnectedToVpn = bool11;
                    int i101 = i99;
                    int i102 = columnIndexOrThrow91;
                    gameInfoMetric.linkDownstreamBandwidth = query.getInt(i102);
                    columnIndexOrThrow91 = i102;
                    int i103 = columnIndexOrThrow92;
                    gameInfoMetric.linkUpstreamBandwidth = query.getInt(i103);
                    columnIndexOrThrow92 = i103;
                    int i104 = columnIndexOrThrow93;
                    gameInfoMetric.latencyType = query.getInt(i104);
                    int i105 = columnIndexOrThrow94;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow93 = i104;
                        gameInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow93 = i104;
                        gameInfoMetric.serverIp = query.getString(i105);
                    }
                    int i106 = columnIndexOrThrow95;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow94 = i105;
                        gameInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow94 = i105;
                        gameInfoMetric.privateIp = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow96;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow95 = i106;
                        gameInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow95 = i106;
                        gameInfoMetric.gatewayIp = query.getString(i107);
                    }
                    int i108 = columnIndexOrThrow97;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow96 = i107;
                        gameInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow96 = i107;
                        gameInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i108));
                    }
                    int i109 = columnIndexOrThrow98;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow97 = i108;
                        gameInfoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow97 = i108;
                        gameInfoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow99;
                    Integer valueOf12 = query.isNull(i110) ? null : Integer.valueOf(query.getInt(i110));
                    if (valueOf12 == null) {
                        columnIndexOrThrow99 = i110;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow99 = i110;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    gameInfoMetric.isNrCellSeen = bool12;
                    int i111 = columnIndexOrThrow100;
                    Integer valueOf13 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf13 == null) {
                        columnIndexOrThrow100 = i111;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow100 = i111;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    gameInfoMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i112 = columnIndexOrThrow101;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow98 = i109;
                        gameInfoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow98 = i109;
                        gameInfoMetric.appVersionName = query.getString(i112);
                    }
                    int i113 = i84;
                    int i114 = columnIndexOrThrow102;
                    int i115 = i85;
                    gameInfoMetric.appVersionCode = query.getLong(i114);
                    int i116 = i112;
                    int i117 = columnIndexOrThrow103;
                    int i118 = i114;
                    gameInfoMetric.appLastUpdateTime = query.getLong(i117);
                    int i119 = columnIndexOrThrow104;
                    gameInfoMetric.duplexModeState = query.getInt(i119);
                    columnIndexOrThrow104 = i119;
                    int i120 = columnIndexOrThrow105;
                    gameInfoMetric.dozeModeState = query.getInt(i120);
                    columnIndexOrThrow105 = i120;
                    int i121 = columnIndexOrThrow106;
                    gameInfoMetric.callState = query.getInt(i121);
                    int i122 = columnIndexOrThrow107;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow106 = i121;
                        gameInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow106 = i121;
                        gameInfoMetric.buildDevice = query.getString(i122);
                    }
                    int i123 = columnIndexOrThrow108;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow107 = i122;
                        gameInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow107 = i122;
                        gameInfoMetric.buildHardware = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow109;
                    if (query.isNull(i124)) {
                        columnIndexOrThrow108 = i123;
                        gameInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow108 = i123;
                        gameInfoMetric.buildProduct = query.getString(i124);
                    }
                    int i125 = columnIndexOrThrow110;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow109 = i124;
                        gameInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow109 = i124;
                        gameInfoMetric.appId = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow111;
                    if (query.getInt(i126) != 0) {
                        columnIndexOrThrow110 = i125;
                        z2 = true;
                    } else {
                        columnIndexOrThrow110 = i125;
                        z2 = false;
                    }
                    gameInfoMetric.isSending = z2;
                    arrayList2 = arrayList;
                    arrayList2.add(gameInfoMetric);
                    columnIndexOrThrow111 = i126;
                    columnIndexOrThrow10 = i;
                    i12 = i2;
                    columnIndexOrThrow15 = i34;
                    columnIndexOrThrow31 = i81;
                    columnIndexOrThrow73 = i6;
                    columnIndexOrThrow75 = i113;
                    columnIndexOrThrow101 = i116;
                    columnIndexOrThrow12 = i16;
                    int i127 = i117;
                    columnIndexOrThrow11 = i15;
                    columnIndexOrThrow14 = i3;
                    columnIndexOrThrow16 = i36;
                    columnIndexOrThrow32 = i39;
                    columnIndexOrThrow33 = i41;
                    columnIndexOrThrow34 = i4;
                    columnIndexOrThrow35 = i5;
                    columnIndexOrThrow36 = i83;
                    columnIndexOrThrow74 = i7;
                    columnIndexOrThrow76 = i115;
                    columnIndexOrThrow102 = i118;
                    columnIndexOrThrow103 = i127;
                    int i128 = i8;
                    columnIndexOrThrow80 = i93;
                    columnIndexOrThrow79 = i128;
                    int i129 = i9;
                    columnIndexOrThrow87 = i10;
                    columnIndexOrThrow86 = i129;
                    int i130 = i11;
                    columnIndexOrThrow89 = i101;
                    columnIndexOrThrow88 = i130;
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

    public void a(GameInfoMetric gameInfoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(gameInfoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(String str, String str2, boolean z) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
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
        acquire.bindLong(3, z ? 1 : 0);
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }

    public void a(List<GameInfoMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<GameInfoMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from gameinfometric WHERE isSending = 0 AND pingsCount > 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gameName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "pingsCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "failedMeasurementsCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isSent");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "isOffline");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "isUnderAdditionalLoad");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "isCached");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyTestFileTransferUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferId");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    GameInfoMetric gameInfoMetric = new GameInfoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = null;
                    } else {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        gameInfoMetric.gameName = null;
                    } else {
                        gameInfoMetric.gameName = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        gameInfoMetric.serverUrl = null;
                    } else {
                        gameInfoMetric.serverUrl = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        gameInfoMetric.latency = null;
                    } else {
                        gameInfoMetric.latency = Float.valueOf(query.getFloat(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        gameInfoMetric.pingsCount = null;
                    } else {
                        gameInfoMetric.pingsCount = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        gameInfoMetric.failedMeasurementsCount = null;
                    } else {
                        gameInfoMetric.failedMeasurementsCount = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        gameInfoMetric.jitter = null;
                    } else {
                        gameInfoMetric.jitter = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                    }
                    gameInfoMetric.isSent = query.getInt(columnIndexOrThrow8) != 0;
                    gameInfoMetric.isOffline = query.getInt(columnIndexOrThrow9) != 0;
                    gameInfoMetric.isUnderAdditionalLoad = query.getInt(columnIndexOrThrow10) != 0;
                    gameInfoMetric.isCached = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = null;
                    } else {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = query.getString(columnIndexOrThrow12);
                    }
                    int i13 = i12;
                    if (query.isNull(i13)) {
                        i = columnIndexOrThrow11;
                        gameInfoMetric.fileTransferId = null;
                    } else {
                        i = columnIndexOrThrow11;
                        gameInfoMetric.fileTransferId = Integer.valueOf(query.getInt(i13));
                    }
                    int i14 = columnIndexOrThrow12;
                    int i15 = columnIndexOrThrow14;
                    int i16 = columnIndexOrThrow;
                    gameInfoMetric.id = query.getLong(i15);
                    int i17 = columnIndexOrThrow15;
                    if (query.isNull(i17)) {
                        gameInfoMetric.mobileClientId = null;
                    } else {
                        gameInfoMetric.mobileClientId = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow16;
                    if (query.isNull(i18)) {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = null;
                    } else {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow17;
                    if (query.isNull(i19)) {
                        i3 = i15;
                        gameInfoMetric.clientIp = null;
                    } else {
                        i3 = i15;
                        gameInfoMetric.clientIp = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow18;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = query.getString(i20);
                    }
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    gameInfoMetric.stateDuringMeasurement = query.getInt(i21);
                    int i22 = columnIndexOrThrow20;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow21;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = query.getString(i23);
                    }
                    columnIndexOrThrow21 = i23;
                    int i24 = columnIndexOrThrow22;
                    gameInfoMetric.signalStrength = query.getInt(i24);
                    columnIndexOrThrow22 = i24;
                    int i25 = columnIndexOrThrow23;
                    gameInfoMetric.interference = query.getInt(i25);
                    int i26 = columnIndexOrThrow24;
                    if (query.isNull(i26)) {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow25;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow26;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow27;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = query.getString(i29);
                    }
                    columnIndexOrThrow27 = i29;
                    int i30 = columnIndexOrThrow28;
                    gameInfoMetric.numberOfSimSlots = query.getInt(i30);
                    columnIndexOrThrow28 = i30;
                    int i31 = columnIndexOrThrow29;
                    gameInfoMetric.dataSimSlotNumber = query.getInt(i31);
                    int i32 = columnIndexOrThrow30;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow31;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = query.getString(i33);
                    }
                    int i34 = i17;
                    int i35 = columnIndexOrThrow32;
                    int i36 = i18;
                    gameInfoMetric.latitude = query.getDouble(i35);
                    int i37 = i33;
                    int i38 = columnIndexOrThrow33;
                    int i39 = i35;
                    gameInfoMetric.longitude = query.getDouble(i38);
                    int i40 = i38;
                    int i41 = columnIndexOrThrow34;
                    int i42 = i37;
                    gameInfoMetric.gpsAccuracy = query.getDouble(i41);
                    int i43 = columnIndexOrThrow35;
                    if (query.isNull(i43)) {
                        gameInfoMetric.cellId = null;
                    } else {
                        gameInfoMetric.cellId = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow36;
                    if (query.isNull(i44)) {
                        i4 = i41;
                        gameInfoMetric.lacId = null;
                    } else {
                        i4 = i41;
                        gameInfoMetric.lacId = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow37;
                    if (query.isNull(i45)) {
                        i5 = i40;
                        gameInfoMetric.deviceBrand = null;
                    } else {
                        i5 = i40;
                        gameInfoMetric.deviceBrand = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow38;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow37 = i45;
                        gameInfoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow37 = i45;
                        gameInfoMetric.deviceModel = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow39;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow38 = i46;
                        gameInfoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow38 = i46;
                        gameInfoMetric.deviceVersion = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow40;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow39 = i47;
                        gameInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow39 = i47;
                        gameInfoMetric.sdkVersionNumber = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow41;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow40 = i48;
                        gameInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow40 = i48;
                        gameInfoMetric.carrierName = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow42;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow41 = i49;
                        gameInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow41 = i49;
                        gameInfoMetric.secondaryCarrierName = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow43;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow42 = i50;
                        gameInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow42 = i50;
                        gameInfoMetric.networkOperatorName = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow44;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow43 = i51;
                        gameInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow43 = i51;
                        gameInfoMetric.os = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow45;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow44 = i52;
                        gameInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow44 = i52;
                        gameInfoMetric.osVersion = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow46;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow45 = i53;
                        gameInfoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow45 = i53;
                        gameInfoMetric.readableDate = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow47;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow46 = i54;
                        gameInfoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow46 = i54;
                        gameInfoMetric.physicalCellId = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow48;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow47 = i55;
                        gameInfoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow47 = i55;
                        gameInfoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow49;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow48 = i56;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow48 = i56;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow50;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow49 = i57;
                        gameInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow49 = i57;
                        gameInfoMetric.cellBands = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow51;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow50 = i58;
                        gameInfoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow50 = i58;
                        gameInfoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow52;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow51 = i59;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow51 = i59;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow53;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow52 = i60;
                        gameInfoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow52 = i60;
                        gameInfoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow54;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow53 = i61;
                        gameInfoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow53 = i61;
                        gameInfoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow55;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow54 = i62;
                        gameInfoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i62;
                        gameInfoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow56;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow55 = i63;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow55 = i63;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow57;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow56 = i64;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow56 = i64;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow58;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow57 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow57 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow59;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow58 = i66;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow58 = i66;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow60;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow59 = i67;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow59 = i67;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow61;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow60 = i68;
                        gameInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow60 = i68;
                        gameInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow62;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow61 = i69;
                        gameInfoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow61 = i69;
                        gameInfoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow63;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow62 = i70;
                        gameInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow62 = i70;
                        gameInfoMetric.dbm = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow64;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow63 = i71;
                        gameInfoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow63 = i71;
                        gameInfoMetric.debugString = query.getString(i72);
                    }
                    int i73 = columnIndexOrThrow65;
                    Integer valueOf = query.isNull(i73) ? null : Integer.valueOf(query.getInt(i73));
                    if (valueOf == null) {
                        columnIndexOrThrow65 = i73;
                        bool = null;
                    } else {
                        columnIndexOrThrow65 = i73;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    gameInfoMetric.isDcNrRestricted = bool;
                    int i74 = columnIndexOrThrow66;
                    Integer valueOf2 = query.isNull(i74) ? null : Integer.valueOf(query.getInt(i74));
                    if (valueOf2 == null) {
                        columnIndexOrThrow66 = i74;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow66 = i74;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    gameInfoMetric.isNrAvailable = bool2;
                    int i75 = columnIndexOrThrow67;
                    Integer valueOf3 = query.isNull(i75) ? null : Integer.valueOf(query.getInt(i75));
                    if (valueOf3 == null) {
                        columnIndexOrThrow67 = i75;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow67 = i75;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    gameInfoMetric.isEnDcAvailable = bool3;
                    int i76 = columnIndexOrThrow68;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow64 = i72;
                        gameInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow64 = i72;
                        gameInfoMetric.nrState = query.getString(i76);
                    }
                    int i77 = columnIndexOrThrow69;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow68 = i76;
                        gameInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow68 = i76;
                        gameInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow70;
                    Integer valueOf4 = query.isNull(i78) ? null : Integer.valueOf(query.getInt(i78));
                    if (valueOf4 == null) {
                        columnIndexOrThrow70 = i78;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow70 = i78;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    gameInfoMetric.isUsingCarrierAggregation = bool4;
                    int i79 = columnIndexOrThrow71;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow69 = i77;
                        gameInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow69 = i77;
                        gameInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i79));
                    }
                    int i80 = columnIndexOrThrow72;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow71 = i79;
                        gameInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow71 = i79;
                        gameInfoMetric.cellBandwidths = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow73;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow72 = i80;
                        gameInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow72 = i80;
                        gameInfoMetric.additionalPlmns = query.getString(i81);
                    }
                    int i82 = i43;
                    int i83 = columnIndexOrThrow74;
                    int i84 = i44;
                    gameInfoMetric.altitude = query.getDouble(i83);
                    int i85 = columnIndexOrThrow75;
                    if (query.isNull(i85)) {
                        gameInfoMetric.locationSpeed = null;
                    } else {
                        gameInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i85));
                    }
                    int i86 = columnIndexOrThrow76;
                    if (query.isNull(i86)) {
                        i6 = i81;
                        gameInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i81;
                        gameInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i86));
                    }
                    int i87 = columnIndexOrThrow77;
                    if (query.isNull(i87)) {
                        i7 = i83;
                        gameInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i83;
                        gameInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i87));
                    }
                    columnIndexOrThrow77 = i87;
                    int i88 = columnIndexOrThrow78;
                    gameInfoMetric.getRestrictBackgroundStatus = query.getInt(i88);
                    int i89 = columnIndexOrThrow79;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow78 = i88;
                        gameInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow78 = i88;
                        gameInfoMetric.cellType = query.getString(i89);
                    }
                    int i90 = columnIndexOrThrow80;
                    Integer valueOf5 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf5 == null) {
                        i8 = i89;
                        bool5 = null;
                    } else {
                        i8 = i89;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    gameInfoMetric.isDefaultNetworkActive = bool5;
                    int i91 = columnIndexOrThrow81;
                    Integer valueOf6 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf6 == null) {
                        columnIndexOrThrow81 = i91;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow81 = i91;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    gameInfoMetric.isActiveNetworkMetered = bool6;
                    int i92 = columnIndexOrThrow82;
                    Integer valueOf7 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf7 == null) {
                        columnIndexOrThrow82 = i92;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow82 = i92;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    gameInfoMetric.isOnScreen = bool7;
                    int i93 = columnIndexOrThrow83;
                    Integer valueOf8 = query.isNull(i93) ? null : Integer.valueOf(query.getInt(i93));
                    if (valueOf8 == null) {
                        columnIndexOrThrow83 = i93;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow83 = i93;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    gameInfoMetric.isRoaming = bool8;
                    int i94 = i90;
                    int i95 = columnIndexOrThrow84;
                    gameInfoMetric.locationAge = query.getInt(i95);
                    int i96 = columnIndexOrThrow85;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow84 = i95;
                        gameInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow84 = i95;
                        gameInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow86;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow85 = i96;
                        gameInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow85 = i96;
                        gameInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow87;
                    Integer valueOf9 = query.isNull(i98) ? null : Integer.valueOf(query.getInt(i98));
                    if (valueOf9 == null) {
                        i9 = i97;
                        bool9 = null;
                    } else {
                        i9 = i97;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    gameInfoMetric.anonymize = bool9;
                    int i99 = columnIndexOrThrow88;
                    if (query.isNull(i99)) {
                        i10 = i98;
                        gameInfoMetric.sdkOrigin = null;
                    } else {
                        i10 = i98;
                        gameInfoMetric.sdkOrigin = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow89;
                    Integer valueOf10 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf10 == null) {
                        i11 = i99;
                        bool10 = null;
                    } else {
                        i11 = i99;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    gameInfoMetric.isRooted = bool10;
                    int i101 = columnIndexOrThrow90;
                    Integer valueOf11 = query.isNull(i101) ? null : Integer.valueOf(query.getInt(i101));
                    if (valueOf11 == null) {
                        columnIndexOrThrow90 = i101;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow90 = i101;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    gameInfoMetric.isConnectedToVpn = bool11;
                    int i102 = i100;
                    int i103 = columnIndexOrThrow91;
                    gameInfoMetric.linkDownstreamBandwidth = query.getInt(i103);
                    columnIndexOrThrow91 = i103;
                    int i104 = columnIndexOrThrow92;
                    gameInfoMetric.linkUpstreamBandwidth = query.getInt(i104);
                    columnIndexOrThrow92 = i104;
                    int i105 = columnIndexOrThrow93;
                    gameInfoMetric.latencyType = query.getInt(i105);
                    int i106 = columnIndexOrThrow94;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow93 = i105;
                        gameInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow93 = i105;
                        gameInfoMetric.serverIp = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow95;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow94 = i106;
                        gameInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow94 = i106;
                        gameInfoMetric.privateIp = query.getString(i107);
                    }
                    int i108 = columnIndexOrThrow96;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow95 = i107;
                        gameInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow95 = i107;
                        gameInfoMetric.gatewayIp = query.getString(i108);
                    }
                    int i109 = columnIndexOrThrow97;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow96 = i108;
                        gameInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow96 = i108;
                        gameInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow98;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow97 = i109;
                        gameInfoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow97 = i109;
                        gameInfoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i110));
                    }
                    int i111 = columnIndexOrThrow99;
                    Integer valueOf12 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf12 == null) {
                        columnIndexOrThrow99 = i111;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow99 = i111;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    gameInfoMetric.isNrCellSeen = bool12;
                    int i112 = columnIndexOrThrow100;
                    Integer valueOf13 = query.isNull(i112) ? null : Integer.valueOf(query.getInt(i112));
                    if (valueOf13 == null) {
                        columnIndexOrThrow100 = i112;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow100 = i112;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    gameInfoMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i113 = columnIndexOrThrow101;
                    if (query.isNull(i113)) {
                        columnIndexOrThrow98 = i110;
                        gameInfoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow98 = i110;
                        gameInfoMetric.appVersionName = query.getString(i113);
                    }
                    int i114 = i85;
                    int i115 = columnIndexOrThrow102;
                    int i116 = i86;
                    gameInfoMetric.appVersionCode = query.getLong(i115);
                    int i117 = i113;
                    int i118 = columnIndexOrThrow103;
                    int i119 = i115;
                    gameInfoMetric.appLastUpdateTime = query.getLong(i118);
                    int i120 = columnIndexOrThrow104;
                    gameInfoMetric.duplexModeState = query.getInt(i120);
                    columnIndexOrThrow104 = i120;
                    int i121 = columnIndexOrThrow105;
                    gameInfoMetric.dozeModeState = query.getInt(i121);
                    columnIndexOrThrow105 = i121;
                    int i122 = columnIndexOrThrow106;
                    gameInfoMetric.callState = query.getInt(i122);
                    int i123 = columnIndexOrThrow107;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow106 = i122;
                        gameInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow106 = i122;
                        gameInfoMetric.buildDevice = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow108;
                    if (query.isNull(i124)) {
                        columnIndexOrThrow107 = i123;
                        gameInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow107 = i123;
                        gameInfoMetric.buildHardware = query.getString(i124);
                    }
                    int i125 = columnIndexOrThrow109;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow108 = i124;
                        gameInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow108 = i124;
                        gameInfoMetric.buildProduct = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow110;
                    if (query.isNull(i126)) {
                        columnIndexOrThrow109 = i125;
                        gameInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow109 = i125;
                        gameInfoMetric.appId = query.getString(i126);
                    }
                    int i127 = columnIndexOrThrow111;
                    if (query.getInt(i127) != 0) {
                        columnIndexOrThrow110 = i126;
                        z = true;
                    } else {
                        columnIndexOrThrow110 = i126;
                        z = false;
                    }
                    gameInfoMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(gameInfoMetric);
                    columnIndexOrThrow111 = i127;
                    columnIndexOrThrow11 = i;
                    i12 = i2;
                    columnIndexOrThrow15 = i34;
                    columnIndexOrThrow31 = i42;
                    columnIndexOrThrow34 = i4;
                    columnIndexOrThrow35 = i82;
                    columnIndexOrThrow73 = i6;
                    columnIndexOrThrow75 = i114;
                    columnIndexOrThrow101 = i117;
                    columnIndexOrThrow = i16;
                    columnIndexOrThrow14 = i3;
                    columnIndexOrThrow16 = i36;
                    columnIndexOrThrow32 = i39;
                    columnIndexOrThrow33 = i5;
                    columnIndexOrThrow36 = i84;
                    columnIndexOrThrow74 = i7;
                    columnIndexOrThrow76 = i116;
                    columnIndexOrThrow102 = i119;
                    columnIndexOrThrow103 = i118;
                    columnIndexOrThrow12 = i14;
                    int i128 = i8;
                    columnIndexOrThrow80 = i94;
                    columnIndexOrThrow79 = i128;
                    int i129 = i9;
                    columnIndexOrThrow87 = i10;
                    columnIndexOrThrow86 = i129;
                    int i130 = i11;
                    columnIndexOrThrow89 = i102;
                    columnIndexOrThrow88 = i130;
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

    public List<GameInfoMetric> b(String str, String str2, boolean z) {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
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
        boolean z2;
        String str3 = str;
        String str4 = str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from gameinfometric WHERE gameName = ? AND serverUrl = ? AND isUnderAdditionalLoad = ?", 3);
        if (str3 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str3);
        }
        if (str4 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str4);
        }
        acquire.bindLong(3, z ? 1 : 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gameName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "pingsCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "failedMeasurementsCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isSent");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "isOffline");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "isUnderAdditionalLoad");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "isCached");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyTestFileTransferUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferId");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    GameInfoMetric gameInfoMetric = new GameInfoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = null;
                    } else {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        gameInfoMetric.gameName = null;
                    } else {
                        gameInfoMetric.gameName = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        gameInfoMetric.serverUrl = null;
                    } else {
                        gameInfoMetric.serverUrl = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        gameInfoMetric.latency = null;
                    } else {
                        gameInfoMetric.latency = Float.valueOf(query.getFloat(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        gameInfoMetric.pingsCount = null;
                    } else {
                        gameInfoMetric.pingsCount = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        gameInfoMetric.failedMeasurementsCount = null;
                    } else {
                        gameInfoMetric.failedMeasurementsCount = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        gameInfoMetric.jitter = null;
                    } else {
                        gameInfoMetric.jitter = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                    }
                    gameInfoMetric.isSent = query.getInt(columnIndexOrThrow8) != 0;
                    gameInfoMetric.isOffline = query.getInt(columnIndexOrThrow9) != 0;
                    gameInfoMetric.isUnderAdditionalLoad = query.getInt(columnIndexOrThrow10) != 0;
                    gameInfoMetric.isCached = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = null;
                    } else {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = query.getString(columnIndexOrThrow12);
                    }
                    int i13 = i12;
                    if (query.isNull(i13)) {
                        i = columnIndexOrThrow10;
                        gameInfoMetric.fileTransferId = null;
                    } else {
                        i = columnIndexOrThrow10;
                        gameInfoMetric.fileTransferId = Integer.valueOf(query.getInt(i13));
                    }
                    int i14 = columnIndexOrThrow14;
                    int i15 = i13;
                    int i16 = columnIndexOrThrow12;
                    gameInfoMetric.id = query.getLong(i14);
                    int i17 = columnIndexOrThrow15;
                    if (query.isNull(i17)) {
                        gameInfoMetric.mobileClientId = null;
                    } else {
                        gameInfoMetric.mobileClientId = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow16;
                    if (query.isNull(i18)) {
                        i2 = i14;
                        gameInfoMetric.measurementSequenceId = null;
                    } else {
                        i2 = i14;
                        gameInfoMetric.measurementSequenceId = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow17;
                    if (query.isNull(i19)) {
                        i3 = i17;
                        gameInfoMetric.clientIp = null;
                    } else {
                        i3 = i17;
                        gameInfoMetric.clientIp = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow18;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = query.getString(i20);
                    }
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    gameInfoMetric.stateDuringMeasurement = query.getInt(i21);
                    int i22 = columnIndexOrThrow20;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow21;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = query.getString(i23);
                    }
                    columnIndexOrThrow21 = i23;
                    int i24 = columnIndexOrThrow22;
                    gameInfoMetric.signalStrength = query.getInt(i24);
                    columnIndexOrThrow22 = i24;
                    int i25 = columnIndexOrThrow23;
                    gameInfoMetric.interference = query.getInt(i25);
                    int i26 = columnIndexOrThrow24;
                    if (query.isNull(i26)) {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow25;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow26;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow27;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = query.getString(i29);
                    }
                    columnIndexOrThrow27 = i29;
                    int i30 = columnIndexOrThrow28;
                    gameInfoMetric.numberOfSimSlots = query.getInt(i30);
                    columnIndexOrThrow28 = i30;
                    int i31 = columnIndexOrThrow29;
                    gameInfoMetric.dataSimSlotNumber = query.getInt(i31);
                    int i32 = columnIndexOrThrow30;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow31;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = query.getString(i33);
                    }
                    int i34 = columnIndexOrThrow11;
                    int i35 = columnIndexOrThrow32;
                    int i36 = i18;
                    gameInfoMetric.latitude = query.getDouble(i35);
                    int i37 = i33;
                    int i38 = columnIndexOrThrow33;
                    int i39 = i35;
                    gameInfoMetric.longitude = query.getDouble(i38);
                    int i40 = columnIndexOrThrow34;
                    int i41 = i38;
                    gameInfoMetric.gpsAccuracy = query.getDouble(i40);
                    int i42 = columnIndexOrThrow35;
                    if (query.isNull(i42)) {
                        gameInfoMetric.cellId = null;
                    } else {
                        gameInfoMetric.cellId = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow36;
                    if (query.isNull(i43)) {
                        i4 = i40;
                        gameInfoMetric.lacId = null;
                    } else {
                        i4 = i40;
                        gameInfoMetric.lacId = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow37;
                    if (query.isNull(i44)) {
                        i5 = i42;
                        gameInfoMetric.deviceBrand = null;
                    } else {
                        i5 = i42;
                        gameInfoMetric.deviceBrand = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow38;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow37 = i44;
                        gameInfoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow37 = i44;
                        gameInfoMetric.deviceModel = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow39;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow38 = i45;
                        gameInfoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow38 = i45;
                        gameInfoMetric.deviceVersion = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow40;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow39 = i46;
                        gameInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow39 = i46;
                        gameInfoMetric.sdkVersionNumber = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow41;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow40 = i47;
                        gameInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow40 = i47;
                        gameInfoMetric.carrierName = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow42;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow41 = i48;
                        gameInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow41 = i48;
                        gameInfoMetric.secondaryCarrierName = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow43;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow42 = i49;
                        gameInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow42 = i49;
                        gameInfoMetric.networkOperatorName = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow44;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow43 = i50;
                        gameInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow43 = i50;
                        gameInfoMetric.os = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow45;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow44 = i51;
                        gameInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow44 = i51;
                        gameInfoMetric.osVersion = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow46;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow45 = i52;
                        gameInfoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow45 = i52;
                        gameInfoMetric.readableDate = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow47;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow46 = i53;
                        gameInfoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow46 = i53;
                        gameInfoMetric.physicalCellId = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow48;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow47 = i54;
                        gameInfoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow47 = i54;
                        gameInfoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow49;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow48 = i55;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow48 = i55;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow50;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow49 = i56;
                        gameInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow49 = i56;
                        gameInfoMetric.cellBands = query.getString(i57);
                    }
                    int i58 = columnIndexOrThrow51;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow50 = i57;
                        gameInfoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow50 = i57;
                        gameInfoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow52;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow51 = i58;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow51 = i58;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow53;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow52 = i59;
                        gameInfoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow52 = i59;
                        gameInfoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow54;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow53 = i60;
                        gameInfoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow53 = i60;
                        gameInfoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow55;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow54 = i61;
                        gameInfoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i61;
                        gameInfoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow56;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow55 = i62;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow55 = i62;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow57;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow56 = i63;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow56 = i63;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow58;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow57 = i64;
                        gameInfoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow57 = i64;
                        gameInfoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow59;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow58 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow58 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow60;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow59 = i66;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow59 = i66;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow61;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow60 = i67;
                        gameInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow60 = i67;
                        gameInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow62;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow61 = i68;
                        gameInfoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow61 = i68;
                        gameInfoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow63;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow62 = i69;
                        gameInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow62 = i69;
                        gameInfoMetric.dbm = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow64;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow63 = i70;
                        gameInfoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow63 = i70;
                        gameInfoMetric.debugString = query.getString(i71);
                    }
                    int i72 = columnIndexOrThrow65;
                    Integer valueOf = query.isNull(i72) ? null : Integer.valueOf(query.getInt(i72));
                    if (valueOf == null) {
                        columnIndexOrThrow65 = i72;
                        bool = null;
                    } else {
                        columnIndexOrThrow65 = i72;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    gameInfoMetric.isDcNrRestricted = bool;
                    int i73 = columnIndexOrThrow66;
                    Integer valueOf2 = query.isNull(i73) ? null : Integer.valueOf(query.getInt(i73));
                    if (valueOf2 == null) {
                        columnIndexOrThrow66 = i73;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow66 = i73;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    gameInfoMetric.isNrAvailable = bool2;
                    int i74 = columnIndexOrThrow67;
                    Integer valueOf3 = query.isNull(i74) ? null : Integer.valueOf(query.getInt(i74));
                    if (valueOf3 == null) {
                        columnIndexOrThrow67 = i74;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow67 = i74;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    gameInfoMetric.isEnDcAvailable = bool3;
                    int i75 = columnIndexOrThrow68;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow64 = i71;
                        gameInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow64 = i71;
                        gameInfoMetric.nrState = query.getString(i75);
                    }
                    int i76 = columnIndexOrThrow69;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow68 = i75;
                        gameInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow68 = i75;
                        gameInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow70;
                    Integer valueOf4 = query.isNull(i77) ? null : Integer.valueOf(query.getInt(i77));
                    if (valueOf4 == null) {
                        columnIndexOrThrow70 = i77;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow70 = i77;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    gameInfoMetric.isUsingCarrierAggregation = bool4;
                    int i78 = columnIndexOrThrow71;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow69 = i76;
                        gameInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow69 = i76;
                        gameInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i78));
                    }
                    int i79 = columnIndexOrThrow72;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow71 = i78;
                        gameInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow71 = i78;
                        gameInfoMetric.cellBandwidths = query.getString(i79);
                    }
                    int i80 = columnIndexOrThrow73;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow72 = i79;
                        gameInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow72 = i79;
                        gameInfoMetric.additionalPlmns = query.getString(i80);
                    }
                    int i81 = i37;
                    int i82 = columnIndexOrThrow74;
                    int i83 = i43;
                    gameInfoMetric.altitude = query.getDouble(i82);
                    int i84 = columnIndexOrThrow75;
                    if (query.isNull(i84)) {
                        gameInfoMetric.locationSpeed = null;
                    } else {
                        gameInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i84));
                    }
                    int i85 = columnIndexOrThrow76;
                    if (query.isNull(i85)) {
                        i6 = i80;
                        gameInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i80;
                        gameInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i85));
                    }
                    int i86 = columnIndexOrThrow77;
                    if (query.isNull(i86)) {
                        i7 = i82;
                        gameInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i82;
                        gameInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i86));
                    }
                    columnIndexOrThrow77 = i86;
                    int i87 = columnIndexOrThrow78;
                    gameInfoMetric.getRestrictBackgroundStatus = query.getInt(i87);
                    int i88 = columnIndexOrThrow79;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow78 = i87;
                        gameInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow78 = i87;
                        gameInfoMetric.cellType = query.getString(i88);
                    }
                    int i89 = columnIndexOrThrow80;
                    Integer valueOf5 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf5 == null) {
                        i8 = i88;
                        bool5 = null;
                    } else {
                        i8 = i88;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    gameInfoMetric.isDefaultNetworkActive = bool5;
                    int i90 = columnIndexOrThrow81;
                    Integer valueOf6 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf6 == null) {
                        columnIndexOrThrow81 = i90;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow81 = i90;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    gameInfoMetric.isActiveNetworkMetered = bool6;
                    int i91 = columnIndexOrThrow82;
                    Integer valueOf7 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf7 == null) {
                        columnIndexOrThrow82 = i91;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow82 = i91;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    gameInfoMetric.isOnScreen = bool7;
                    int i92 = columnIndexOrThrow83;
                    Integer valueOf8 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf8 == null) {
                        columnIndexOrThrow83 = i92;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow83 = i92;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    gameInfoMetric.isRoaming = bool8;
                    int i93 = i89;
                    int i94 = columnIndexOrThrow84;
                    gameInfoMetric.locationAge = query.getInt(i94);
                    int i95 = columnIndexOrThrow85;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow84 = i94;
                        gameInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow84 = i94;
                        gameInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow86;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow85 = i95;
                        gameInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow85 = i95;
                        gameInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow87;
                    Integer valueOf9 = query.isNull(i97) ? null : Integer.valueOf(query.getInt(i97));
                    if (valueOf9 == null) {
                        i9 = i96;
                        bool9 = null;
                    } else {
                        i9 = i96;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    gameInfoMetric.anonymize = bool9;
                    int i98 = columnIndexOrThrow88;
                    if (query.isNull(i98)) {
                        i10 = i97;
                        gameInfoMetric.sdkOrigin = null;
                    } else {
                        i10 = i97;
                        gameInfoMetric.sdkOrigin = query.getString(i98);
                    }
                    int i99 = columnIndexOrThrow89;
                    Integer valueOf10 = query.isNull(i99) ? null : Integer.valueOf(query.getInt(i99));
                    if (valueOf10 == null) {
                        i11 = i98;
                        bool10 = null;
                    } else {
                        i11 = i98;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    gameInfoMetric.isRooted = bool10;
                    int i100 = columnIndexOrThrow90;
                    Integer valueOf11 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf11 == null) {
                        columnIndexOrThrow90 = i100;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow90 = i100;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    gameInfoMetric.isConnectedToVpn = bool11;
                    int i101 = i99;
                    int i102 = columnIndexOrThrow91;
                    gameInfoMetric.linkDownstreamBandwidth = query.getInt(i102);
                    columnIndexOrThrow91 = i102;
                    int i103 = columnIndexOrThrow92;
                    gameInfoMetric.linkUpstreamBandwidth = query.getInt(i103);
                    columnIndexOrThrow92 = i103;
                    int i104 = columnIndexOrThrow93;
                    gameInfoMetric.latencyType = query.getInt(i104);
                    int i105 = columnIndexOrThrow94;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow93 = i104;
                        gameInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow93 = i104;
                        gameInfoMetric.serverIp = query.getString(i105);
                    }
                    int i106 = columnIndexOrThrow95;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow94 = i105;
                        gameInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow94 = i105;
                        gameInfoMetric.privateIp = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow96;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow95 = i106;
                        gameInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow95 = i106;
                        gameInfoMetric.gatewayIp = query.getString(i107);
                    }
                    int i108 = columnIndexOrThrow97;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow96 = i107;
                        gameInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow96 = i107;
                        gameInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i108));
                    }
                    int i109 = columnIndexOrThrow98;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow97 = i108;
                        gameInfoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow97 = i108;
                        gameInfoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow99;
                    Integer valueOf12 = query.isNull(i110) ? null : Integer.valueOf(query.getInt(i110));
                    if (valueOf12 == null) {
                        columnIndexOrThrow99 = i110;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow99 = i110;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    gameInfoMetric.isNrCellSeen = bool12;
                    int i111 = columnIndexOrThrow100;
                    Integer valueOf13 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf13 == null) {
                        columnIndexOrThrow100 = i111;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow100 = i111;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    gameInfoMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i112 = columnIndexOrThrow101;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow98 = i109;
                        gameInfoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow98 = i109;
                        gameInfoMetric.appVersionName = query.getString(i112);
                    }
                    int i113 = i84;
                    int i114 = columnIndexOrThrow102;
                    int i115 = i85;
                    gameInfoMetric.appVersionCode = query.getLong(i114);
                    int i116 = i112;
                    int i117 = columnIndexOrThrow103;
                    int i118 = i114;
                    gameInfoMetric.appLastUpdateTime = query.getLong(i117);
                    int i119 = columnIndexOrThrow104;
                    gameInfoMetric.duplexModeState = query.getInt(i119);
                    columnIndexOrThrow104 = i119;
                    int i120 = columnIndexOrThrow105;
                    gameInfoMetric.dozeModeState = query.getInt(i120);
                    columnIndexOrThrow105 = i120;
                    int i121 = columnIndexOrThrow106;
                    gameInfoMetric.callState = query.getInt(i121);
                    int i122 = columnIndexOrThrow107;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow106 = i121;
                        gameInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow106 = i121;
                        gameInfoMetric.buildDevice = query.getString(i122);
                    }
                    int i123 = columnIndexOrThrow108;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow107 = i122;
                        gameInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow107 = i122;
                        gameInfoMetric.buildHardware = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow109;
                    if (query.isNull(i124)) {
                        columnIndexOrThrow108 = i123;
                        gameInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow108 = i123;
                        gameInfoMetric.buildProduct = query.getString(i124);
                    }
                    int i125 = columnIndexOrThrow110;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow109 = i124;
                        gameInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow109 = i124;
                        gameInfoMetric.appId = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow111;
                    if (query.getInt(i126) != 0) {
                        columnIndexOrThrow110 = i125;
                        z2 = true;
                    } else {
                        columnIndexOrThrow110 = i125;
                        z2 = false;
                    }
                    gameInfoMetric.isSending = z2;
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(gameInfoMetric);
                    columnIndexOrThrow111 = i126;
                    arrayList2 = arrayList3;
                    columnIndexOrThrow10 = i;
                    i12 = i15;
                    int i127 = i117;
                    columnIndexOrThrow12 = i16;
                    columnIndexOrThrow14 = i2;
                    columnIndexOrThrow15 = i3;
                    columnIndexOrThrow16 = i36;
                    columnIndexOrThrow32 = i39;
                    columnIndexOrThrow33 = i41;
                    columnIndexOrThrow34 = i4;
                    columnIndexOrThrow35 = i5;
                    columnIndexOrThrow36 = i83;
                    columnIndexOrThrow74 = i7;
                    columnIndexOrThrow76 = i115;
                    columnIndexOrThrow102 = i118;
                    columnIndexOrThrow103 = i127;
                    int i128 = i113;
                    columnIndexOrThrow101 = i116;
                    columnIndexOrThrow11 = i34;
                    columnIndexOrThrow31 = i81;
                    columnIndexOrThrow73 = i6;
                    columnIndexOrThrow75 = i128;
                    int i129 = i8;
                    columnIndexOrThrow80 = i93;
                    columnIndexOrThrow79 = i129;
                    int i130 = i9;
                    columnIndexOrThrow87 = i10;
                    columnIndexOrThrow86 = i130;
                    int i131 = i11;
                    columnIndexOrThrow89 = i101;
                    columnIndexOrThrow88 = i131;
                }
                ArrayList arrayList4 = arrayList2;
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

    public void b(GameInfoMetric gameInfoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(gameInfoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<GameInfoMetric> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from gameinfometric", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gameName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "pingsCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "failedMeasurementsCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "jitter");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isSent");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "isOffline");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "isUnderAdditionalLoad");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "isCached");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyTestFileTransferUrl");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferId");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    GameInfoMetric gameInfoMetric = new GameInfoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = null;
                    } else {
                        arrayList = arrayList2;
                        gameInfoMetric.serverName = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        gameInfoMetric.gameName = null;
                    } else {
                        gameInfoMetric.gameName = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        gameInfoMetric.serverUrl = null;
                    } else {
                        gameInfoMetric.serverUrl = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        gameInfoMetric.latency = null;
                    } else {
                        gameInfoMetric.latency = Float.valueOf(query.getFloat(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        gameInfoMetric.pingsCount = null;
                    } else {
                        gameInfoMetric.pingsCount = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        gameInfoMetric.failedMeasurementsCount = null;
                    } else {
                        gameInfoMetric.failedMeasurementsCount = Float.valueOf(query.getFloat(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        gameInfoMetric.jitter = null;
                    } else {
                        gameInfoMetric.jitter = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                    }
                    gameInfoMetric.isSent = query.getInt(columnIndexOrThrow8) != 0;
                    gameInfoMetric.isOffline = query.getInt(columnIndexOrThrow9) != 0;
                    gameInfoMetric.isUnderAdditionalLoad = query.getInt(columnIndexOrThrow10) != 0;
                    gameInfoMetric.isCached = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = null;
                    } else {
                        gameInfoMetric.loadedLatencyTestFileTransferUrl = query.getString(columnIndexOrThrow12);
                    }
                    int i13 = i12;
                    if (query.isNull(i13)) {
                        i = columnIndexOrThrow11;
                        gameInfoMetric.fileTransferId = null;
                    } else {
                        i = columnIndexOrThrow11;
                        gameInfoMetric.fileTransferId = Integer.valueOf(query.getInt(i13));
                    }
                    int i14 = columnIndexOrThrow12;
                    int i15 = columnIndexOrThrow14;
                    int i16 = columnIndexOrThrow;
                    gameInfoMetric.id = query.getLong(i15);
                    int i17 = columnIndexOrThrow15;
                    if (query.isNull(i17)) {
                        gameInfoMetric.mobileClientId = null;
                    } else {
                        gameInfoMetric.mobileClientId = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow16;
                    if (query.isNull(i18)) {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = null;
                    } else {
                        i2 = i13;
                        gameInfoMetric.measurementSequenceId = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow17;
                    if (query.isNull(i19)) {
                        i3 = i15;
                        gameInfoMetric.clientIp = null;
                    } else {
                        i3 = i15;
                        gameInfoMetric.clientIp = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow18;
                    if (query.isNull(i20)) {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow17 = i19;
                        gameInfoMetric.dateTimeOfMeasurement = query.getString(i20);
                    }
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    gameInfoMetric.stateDuringMeasurement = query.getInt(i21);
                    int i22 = columnIndexOrThrow20;
                    if (query.isNull(i22)) {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow19 = i21;
                        gameInfoMetric.accessTechnology = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow21;
                    if (query.isNull(i23)) {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow20 = i22;
                        gameInfoMetric.accessTypeRaw = query.getString(i23);
                    }
                    columnIndexOrThrow21 = i23;
                    int i24 = columnIndexOrThrow22;
                    gameInfoMetric.signalStrength = query.getInt(i24);
                    columnIndexOrThrow22 = i24;
                    int i25 = columnIndexOrThrow23;
                    gameInfoMetric.interference = query.getInt(i25);
                    int i26 = columnIndexOrThrow24;
                    if (query.isNull(i26)) {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow23 = i25;
                        gameInfoMetric.simMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow25;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow24 = i26;
                        gameInfoMetric.simMNC = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow26;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow25 = i27;
                        gameInfoMetric.secondarySimMCC = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow27;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow26 = i28;
                        gameInfoMetric.secondarySimMNC = query.getString(i29);
                    }
                    columnIndexOrThrow27 = i29;
                    int i30 = columnIndexOrThrow28;
                    gameInfoMetric.numberOfSimSlots = query.getInt(i30);
                    columnIndexOrThrow28 = i30;
                    int i31 = columnIndexOrThrow29;
                    gameInfoMetric.dataSimSlotNumber = query.getInt(i31);
                    int i32 = columnIndexOrThrow30;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow29 = i31;
                        gameInfoMetric.networkMCC = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow31;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow30 = i32;
                        gameInfoMetric.networkMNC = query.getString(i33);
                    }
                    int i34 = i17;
                    int i35 = columnIndexOrThrow32;
                    int i36 = i18;
                    gameInfoMetric.latitude = query.getDouble(i35);
                    int i37 = i33;
                    int i38 = columnIndexOrThrow33;
                    int i39 = i35;
                    gameInfoMetric.longitude = query.getDouble(i38);
                    int i40 = i38;
                    int i41 = columnIndexOrThrow34;
                    int i42 = i37;
                    gameInfoMetric.gpsAccuracy = query.getDouble(i41);
                    int i43 = columnIndexOrThrow35;
                    if (query.isNull(i43)) {
                        gameInfoMetric.cellId = null;
                    } else {
                        gameInfoMetric.cellId = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow36;
                    if (query.isNull(i44)) {
                        i4 = i41;
                        gameInfoMetric.lacId = null;
                    } else {
                        i4 = i41;
                        gameInfoMetric.lacId = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow37;
                    if (query.isNull(i45)) {
                        i5 = i40;
                        gameInfoMetric.deviceBrand = null;
                    } else {
                        i5 = i40;
                        gameInfoMetric.deviceBrand = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow38;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow37 = i45;
                        gameInfoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow37 = i45;
                        gameInfoMetric.deviceModel = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow39;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow38 = i46;
                        gameInfoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow38 = i46;
                        gameInfoMetric.deviceVersion = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow40;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow39 = i47;
                        gameInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow39 = i47;
                        gameInfoMetric.sdkVersionNumber = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow41;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow40 = i48;
                        gameInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow40 = i48;
                        gameInfoMetric.carrierName = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow42;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow41 = i49;
                        gameInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow41 = i49;
                        gameInfoMetric.secondaryCarrierName = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow43;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow42 = i50;
                        gameInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow42 = i50;
                        gameInfoMetric.networkOperatorName = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow44;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow43 = i51;
                        gameInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow43 = i51;
                        gameInfoMetric.os = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow45;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow44 = i52;
                        gameInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow44 = i52;
                        gameInfoMetric.osVersion = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow46;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow45 = i53;
                        gameInfoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow45 = i53;
                        gameInfoMetric.readableDate = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow47;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow46 = i54;
                        gameInfoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow46 = i54;
                        gameInfoMetric.physicalCellId = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow48;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow47 = i55;
                        gameInfoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow47 = i55;
                        gameInfoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow49;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow48 = i56;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow48 = i56;
                        gameInfoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow50;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow49 = i57;
                        gameInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow49 = i57;
                        gameInfoMetric.cellBands = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow51;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow50 = i58;
                        gameInfoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow50 = i58;
                        gameInfoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow52;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow51 = i59;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow51 = i59;
                        gameInfoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow53;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow52 = i60;
                        gameInfoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow52 = i60;
                        gameInfoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow54;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow53 = i61;
                        gameInfoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow53 = i61;
                        gameInfoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow55;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow54 = i62;
                        gameInfoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i62;
                        gameInfoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow56;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow55 = i63;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow55 = i63;
                        gameInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow57;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow56 = i64;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow56 = i64;
                        gameInfoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow58;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow57 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow57 = i65;
                        gameInfoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow59;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow58 = i66;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow58 = i66;
                        gameInfoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow60;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow59 = i67;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow59 = i67;
                        gameInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow61;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow60 = i68;
                        gameInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow60 = i68;
                        gameInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow62;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow61 = i69;
                        gameInfoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow61 = i69;
                        gameInfoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow63;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow62 = i70;
                        gameInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow62 = i70;
                        gameInfoMetric.dbm = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow64;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow63 = i71;
                        gameInfoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow63 = i71;
                        gameInfoMetric.debugString = query.getString(i72);
                    }
                    int i73 = columnIndexOrThrow65;
                    Integer valueOf = query.isNull(i73) ? null : Integer.valueOf(query.getInt(i73));
                    if (valueOf == null) {
                        columnIndexOrThrow65 = i73;
                        bool = null;
                    } else {
                        columnIndexOrThrow65 = i73;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    gameInfoMetric.isDcNrRestricted = bool;
                    int i74 = columnIndexOrThrow66;
                    Integer valueOf2 = query.isNull(i74) ? null : Integer.valueOf(query.getInt(i74));
                    if (valueOf2 == null) {
                        columnIndexOrThrow66 = i74;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow66 = i74;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    gameInfoMetric.isNrAvailable = bool2;
                    int i75 = columnIndexOrThrow67;
                    Integer valueOf3 = query.isNull(i75) ? null : Integer.valueOf(query.getInt(i75));
                    if (valueOf3 == null) {
                        columnIndexOrThrow67 = i75;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow67 = i75;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    gameInfoMetric.isEnDcAvailable = bool3;
                    int i76 = columnIndexOrThrow68;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow64 = i72;
                        gameInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow64 = i72;
                        gameInfoMetric.nrState = query.getString(i76);
                    }
                    int i77 = columnIndexOrThrow69;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow68 = i76;
                        gameInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow68 = i76;
                        gameInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow70;
                    Integer valueOf4 = query.isNull(i78) ? null : Integer.valueOf(query.getInt(i78));
                    if (valueOf4 == null) {
                        columnIndexOrThrow70 = i78;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow70 = i78;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    gameInfoMetric.isUsingCarrierAggregation = bool4;
                    int i79 = columnIndexOrThrow71;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow69 = i77;
                        gameInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow69 = i77;
                        gameInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i79));
                    }
                    int i80 = columnIndexOrThrow72;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow71 = i79;
                        gameInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow71 = i79;
                        gameInfoMetric.cellBandwidths = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow73;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow72 = i80;
                        gameInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow72 = i80;
                        gameInfoMetric.additionalPlmns = query.getString(i81);
                    }
                    int i82 = i43;
                    int i83 = columnIndexOrThrow74;
                    int i84 = i44;
                    gameInfoMetric.altitude = query.getDouble(i83);
                    int i85 = columnIndexOrThrow75;
                    if (query.isNull(i85)) {
                        gameInfoMetric.locationSpeed = null;
                    } else {
                        gameInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i85));
                    }
                    int i86 = columnIndexOrThrow76;
                    if (query.isNull(i86)) {
                        i6 = i81;
                        gameInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i81;
                        gameInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i86));
                    }
                    int i87 = columnIndexOrThrow77;
                    if (query.isNull(i87)) {
                        i7 = i83;
                        gameInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i83;
                        gameInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i87));
                    }
                    columnIndexOrThrow77 = i87;
                    int i88 = columnIndexOrThrow78;
                    gameInfoMetric.getRestrictBackgroundStatus = query.getInt(i88);
                    int i89 = columnIndexOrThrow79;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow78 = i88;
                        gameInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow78 = i88;
                        gameInfoMetric.cellType = query.getString(i89);
                    }
                    int i90 = columnIndexOrThrow80;
                    Integer valueOf5 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf5 == null) {
                        i8 = i89;
                        bool5 = null;
                    } else {
                        i8 = i89;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    gameInfoMetric.isDefaultNetworkActive = bool5;
                    int i91 = columnIndexOrThrow81;
                    Integer valueOf6 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf6 == null) {
                        columnIndexOrThrow81 = i91;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow81 = i91;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    gameInfoMetric.isActiveNetworkMetered = bool6;
                    int i92 = columnIndexOrThrow82;
                    Integer valueOf7 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf7 == null) {
                        columnIndexOrThrow82 = i92;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow82 = i92;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    gameInfoMetric.isOnScreen = bool7;
                    int i93 = columnIndexOrThrow83;
                    Integer valueOf8 = query.isNull(i93) ? null : Integer.valueOf(query.getInt(i93));
                    if (valueOf8 == null) {
                        columnIndexOrThrow83 = i93;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow83 = i93;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    gameInfoMetric.isRoaming = bool8;
                    int i94 = i90;
                    int i95 = columnIndexOrThrow84;
                    gameInfoMetric.locationAge = query.getInt(i95);
                    int i96 = columnIndexOrThrow85;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow84 = i95;
                        gameInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow84 = i95;
                        gameInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow86;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow85 = i96;
                        gameInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow85 = i96;
                        gameInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow87;
                    Integer valueOf9 = query.isNull(i98) ? null : Integer.valueOf(query.getInt(i98));
                    if (valueOf9 == null) {
                        i9 = i97;
                        bool9 = null;
                    } else {
                        i9 = i97;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    gameInfoMetric.anonymize = bool9;
                    int i99 = columnIndexOrThrow88;
                    if (query.isNull(i99)) {
                        i10 = i98;
                        gameInfoMetric.sdkOrigin = null;
                    } else {
                        i10 = i98;
                        gameInfoMetric.sdkOrigin = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow89;
                    Integer valueOf10 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf10 == null) {
                        i11 = i99;
                        bool10 = null;
                    } else {
                        i11 = i99;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    gameInfoMetric.isRooted = bool10;
                    int i101 = columnIndexOrThrow90;
                    Integer valueOf11 = query.isNull(i101) ? null : Integer.valueOf(query.getInt(i101));
                    if (valueOf11 == null) {
                        columnIndexOrThrow90 = i101;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow90 = i101;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    gameInfoMetric.isConnectedToVpn = bool11;
                    int i102 = i100;
                    int i103 = columnIndexOrThrow91;
                    gameInfoMetric.linkDownstreamBandwidth = query.getInt(i103);
                    columnIndexOrThrow91 = i103;
                    int i104 = columnIndexOrThrow92;
                    gameInfoMetric.linkUpstreamBandwidth = query.getInt(i104);
                    columnIndexOrThrow92 = i104;
                    int i105 = columnIndexOrThrow93;
                    gameInfoMetric.latencyType = query.getInt(i105);
                    int i106 = columnIndexOrThrow94;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow93 = i105;
                        gameInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow93 = i105;
                        gameInfoMetric.serverIp = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow95;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow94 = i106;
                        gameInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow94 = i106;
                        gameInfoMetric.privateIp = query.getString(i107);
                    }
                    int i108 = columnIndexOrThrow96;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow95 = i107;
                        gameInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow95 = i107;
                        gameInfoMetric.gatewayIp = query.getString(i108);
                    }
                    int i109 = columnIndexOrThrow97;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow96 = i108;
                        gameInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow96 = i108;
                        gameInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow98;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow97 = i109;
                        gameInfoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow97 = i109;
                        gameInfoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i110));
                    }
                    int i111 = columnIndexOrThrow99;
                    Integer valueOf12 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf12 == null) {
                        columnIndexOrThrow99 = i111;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow99 = i111;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    gameInfoMetric.isNrCellSeen = bool12;
                    int i112 = columnIndexOrThrow100;
                    Integer valueOf13 = query.isNull(i112) ? null : Integer.valueOf(query.getInt(i112));
                    if (valueOf13 == null) {
                        columnIndexOrThrow100 = i112;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow100 = i112;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    gameInfoMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i113 = columnIndexOrThrow101;
                    if (query.isNull(i113)) {
                        columnIndexOrThrow98 = i110;
                        gameInfoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow98 = i110;
                        gameInfoMetric.appVersionName = query.getString(i113);
                    }
                    int i114 = i85;
                    int i115 = columnIndexOrThrow102;
                    int i116 = i86;
                    gameInfoMetric.appVersionCode = query.getLong(i115);
                    int i117 = i113;
                    int i118 = columnIndexOrThrow103;
                    int i119 = i115;
                    gameInfoMetric.appLastUpdateTime = query.getLong(i118);
                    int i120 = columnIndexOrThrow104;
                    gameInfoMetric.duplexModeState = query.getInt(i120);
                    columnIndexOrThrow104 = i120;
                    int i121 = columnIndexOrThrow105;
                    gameInfoMetric.dozeModeState = query.getInt(i121);
                    columnIndexOrThrow105 = i121;
                    int i122 = columnIndexOrThrow106;
                    gameInfoMetric.callState = query.getInt(i122);
                    int i123 = columnIndexOrThrow107;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow106 = i122;
                        gameInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow106 = i122;
                        gameInfoMetric.buildDevice = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow108;
                    if (query.isNull(i124)) {
                        columnIndexOrThrow107 = i123;
                        gameInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow107 = i123;
                        gameInfoMetric.buildHardware = query.getString(i124);
                    }
                    int i125 = columnIndexOrThrow109;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow108 = i124;
                        gameInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow108 = i124;
                        gameInfoMetric.buildProduct = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow110;
                    if (query.isNull(i126)) {
                        columnIndexOrThrow109 = i125;
                        gameInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow109 = i125;
                        gameInfoMetric.appId = query.getString(i126);
                    }
                    int i127 = columnIndexOrThrow111;
                    if (query.getInt(i127) != 0) {
                        columnIndexOrThrow110 = i126;
                        z = true;
                    } else {
                        columnIndexOrThrow110 = i126;
                        z = false;
                    }
                    gameInfoMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(gameInfoMetric);
                    columnIndexOrThrow111 = i127;
                    columnIndexOrThrow11 = i;
                    i12 = i2;
                    columnIndexOrThrow15 = i34;
                    columnIndexOrThrow31 = i42;
                    columnIndexOrThrow34 = i4;
                    columnIndexOrThrow35 = i82;
                    columnIndexOrThrow73 = i6;
                    columnIndexOrThrow75 = i114;
                    columnIndexOrThrow101 = i117;
                    columnIndexOrThrow = i16;
                    columnIndexOrThrow14 = i3;
                    columnIndexOrThrow16 = i36;
                    columnIndexOrThrow32 = i39;
                    columnIndexOrThrow33 = i5;
                    columnIndexOrThrow36 = i84;
                    columnIndexOrThrow74 = i7;
                    columnIndexOrThrow76 = i116;
                    columnIndexOrThrow102 = i119;
                    columnIndexOrThrow103 = i118;
                    columnIndexOrThrow12 = i14;
                    int i128 = i8;
                    columnIndexOrThrow80 = i94;
                    columnIndexOrThrow79 = i128;
                    int i129 = i9;
                    columnIndexOrThrow87 = i10;
                    columnIndexOrThrow86 = i129;
                    int i130 = i11;
                    columnIndexOrThrow89 = i102;
                    columnIndexOrThrow88 = i130;
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
