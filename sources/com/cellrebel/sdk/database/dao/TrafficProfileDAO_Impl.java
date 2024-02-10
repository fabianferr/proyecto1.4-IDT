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
import com.cellrebel.sdk.networking.beans.request.TrafficProfileMetric;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrafficProfileDAO_Impl implements TrafficProfileDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<TrafficProfileMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<TrafficProfileMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, TrafficProfileMetric trafficProfileMetric) {
            String str = trafficProfileMetric.profileName;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = trafficProfileMetric.profile;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, (long) trafficProfileMetric.profileType);
            supportSQLiteStatement.bindLong(4, trafficProfileMetric.meanLatency);
            supportSQLiteStatement.bindLong(5, trafficProfileMetric.medianLatency);
            supportSQLiteStatement.bindLong(6, trafficProfileMetric.minimumLatency);
            supportSQLiteStatement.bindLong(7, trafficProfileMetric.maximumLatency);
            supportSQLiteStatement.bindLong(8, trafficProfileMetric.p10Latency);
            supportSQLiteStatement.bindLong(9, trafficProfileMetric.p90Latency);
            supportSQLiteStatement.bindLong(10, trafficProfileMetric.iqmLatency);
            supportSQLiteStatement.bindLong(11, trafficProfileMetric.meanJitter);
            supportSQLiteStatement.bindLong(12, trafficProfileMetric.medianJitter);
            supportSQLiteStatement.bindLong(13, trafficProfileMetric.minimumJitter);
            supportSQLiteStatement.bindLong(14, trafficProfileMetric.maximumJitter);
            supportSQLiteStatement.bindLong(15, trafficProfileMetric.p10Jitter);
            supportSQLiteStatement.bindLong(16, trafficProfileMetric.p90Jitter);
            supportSQLiteStatement.bindLong(17, trafficProfileMetric.iqmJitter);
            supportSQLiteStatement.bindLong(18, trafficProfileMetric.packetLoss);
            supportSQLiteStatement.bindLong(19, (long) trafficProfileMetric.outOfOrderPackets);
            supportSQLiteStatement.bindLong(20, (long) trafficProfileMetric.packetCount);
            supportSQLiteStatement.bindLong(21, (long) trafficProfileMetric.numberOfOutOfOrderPackets);
            supportSQLiteStatement.bindDouble(22, trafficProfileMetric.throughput);
            String str3 = trafficProfileMetric.serverUrl;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str3);
            }
            String str4 = trafficProfileMetric.errors;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str4);
            }
            supportSQLiteStatement.bindLong(25, trafficProfileMetric.id);
            String str5 = trafficProfileMetric.mobileClientId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str5);
            }
            String str6 = trafficProfileMetric.measurementSequenceId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str6);
            }
            String str7 = trafficProfileMetric.clientIp;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str7);
            }
            String str8 = trafficProfileMetric.dateTimeOfMeasurement;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str8);
            }
            supportSQLiteStatement.bindLong(30, (long) trafficProfileMetric.stateDuringMeasurement);
            String str9 = trafficProfileMetric.accessTechnology;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str9);
            }
            String str10 = trafficProfileMetric.accessTypeRaw;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str10);
            }
            supportSQLiteStatement.bindLong(33, (long) trafficProfileMetric.signalStrength);
            supportSQLiteStatement.bindLong(34, (long) trafficProfileMetric.interference);
            String str11 = trafficProfileMetric.simMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str11);
            }
            String str12 = trafficProfileMetric.simMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str12);
            }
            String str13 = trafficProfileMetric.secondarySimMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str13);
            }
            String str14 = trafficProfileMetric.secondarySimMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str14);
            }
            supportSQLiteStatement.bindLong(39, (long) trafficProfileMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(40, (long) trafficProfileMetric.dataSimSlotNumber);
            String str15 = trafficProfileMetric.networkMCC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str15);
            }
            String str16 = trafficProfileMetric.networkMNC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str16);
            }
            supportSQLiteStatement.bindDouble(43, trafficProfileMetric.latitude);
            supportSQLiteStatement.bindDouble(44, trafficProfileMetric.longitude);
            supportSQLiteStatement.bindDouble(45, trafficProfileMetric.gpsAccuracy);
            String str17 = trafficProfileMetric.cellId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str17);
            }
            String str18 = trafficProfileMetric.lacId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str18);
            }
            String str19 = trafficProfileMetric.deviceBrand;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str19);
            }
            String str20 = trafficProfileMetric.deviceModel;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str20);
            }
            String str21 = trafficProfileMetric.deviceVersion;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str21);
            }
            String str22 = trafficProfileMetric.sdkVersionNumber;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str22);
            }
            String str23 = trafficProfileMetric.carrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str23);
            }
            String str24 = trafficProfileMetric.secondaryCarrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str24);
            }
            String str25 = trafficProfileMetric.networkOperatorName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str25);
            }
            String str26 = trafficProfileMetric.os;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str26);
            }
            String str27 = trafficProfileMetric.osVersion;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str27);
            }
            String str28 = trafficProfileMetric.readableDate;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str28);
            }
            Integer num = trafficProfileMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num.intValue());
            }
            Integer num2 = trafficProfileMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num2.intValue());
            }
            Integer num3 = trafficProfileMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num3.intValue());
            }
            String str29 = trafficProfileMetric.cellBands;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str29);
            }
            Integer num4 = trafficProfileMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num4.intValue());
            }
            Integer num5 = trafficProfileMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num5.intValue());
            }
            Integer num6 = trafficProfileMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num6.intValue());
            }
            Integer num7 = trafficProfileMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num7.intValue());
            }
            Integer num8 = trafficProfileMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num8.intValue());
            }
            Integer num9 = trafficProfileMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num9.intValue());
            }
            Integer num10 = trafficProfileMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num10.intValue());
            }
            Integer num11 = trafficProfileMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num11.intValue());
            }
            Integer num12 = trafficProfileMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num12.intValue());
            }
            Integer num13 = trafficProfileMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num13.intValue());
            }
            Integer num14 = trafficProfileMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num14.intValue());
            }
            Integer num15 = trafficProfileMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num15.intValue());
            }
            Integer num16 = trafficProfileMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num16.intValue());
            }
            String str30 = trafficProfileMetric.debugString;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindString(75, str30);
            }
            Boolean bool = trafficProfileMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) valueOf.intValue());
            }
            Boolean bool2 = trafficProfileMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf2.intValue());
            }
            Boolean bool3 = trafficProfileMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf3.intValue());
            }
            String str31 = trafficProfileMetric.nrState;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindString(79, str31);
            }
            Integer num18 = trafficProfileMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) num18.intValue());
            }
            Boolean bool4 = trafficProfileMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) valueOf4.intValue());
            }
            Integer num19 = trafficProfileMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) num19.intValue());
            }
            String str32 = trafficProfileMetric.cellBandwidths;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str32);
            }
            String str33 = trafficProfileMetric.additionalPlmns;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindString(84, str33);
            }
            supportSQLiteStatement.bindDouble(85, trafficProfileMetric.altitude);
            Float f = trafficProfileMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindDouble(86, (double) f.floatValue());
            }
            Float f2 = trafficProfileMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindDouble(87, (double) f2.floatValue());
            }
            Float f3 = trafficProfileMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindDouble(88, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(89, (long) trafficProfileMetric.getRestrictBackgroundStatus);
            String str34 = trafficProfileMetric.cellType;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindString(90, str34);
            }
            Boolean bool5 = trafficProfileMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) valueOf5.intValue());
            }
            Boolean bool6 = trafficProfileMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf6.intValue());
            }
            Boolean bool7 = trafficProfileMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) valueOf7.intValue());
            }
            Boolean bool8 = trafficProfileMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(95, (long) trafficProfileMetric.locationAge);
            Integer num20 = trafficProfileMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) num20.intValue());
            }
            Integer num21 = trafficProfileMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num21.intValue());
            }
            Boolean bool9 = trafficProfileMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) valueOf9.intValue());
            }
            String str35 = trafficProfileMetric.sdkOrigin;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindString(99, str35);
            }
            Boolean bool10 = trafficProfileMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindLong(100, (long) valueOf10.intValue());
            }
            Boolean bool11 = trafficProfileMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindLong(101, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(102, (long) trafficProfileMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(103, (long) trafficProfileMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(104, (long) trafficProfileMetric.latencyType);
            String str36 = trafficProfileMetric.serverIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindString(105, str36);
            }
            String str37 = trafficProfileMetric.privateIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str37);
            }
            String str38 = trafficProfileMetric.gatewayIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str38);
            }
            Integer num22 = trafficProfileMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindLong(108, (long) num22.intValue());
            }
            Integer num23 = trafficProfileMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) num23.intValue());
            }
            Boolean bool12 = trafficProfileMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindLong(110, (long) valueOf12.intValue());
            }
            Boolean bool13 = trafficProfileMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindLong(111, (long) num17.intValue());
            }
            String str39 = trafficProfileMetric.appVersionName;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(112);
            } else {
                supportSQLiteStatement.bindString(112, str39);
            }
            supportSQLiteStatement.bindLong(113, trafficProfileMetric.appVersionCode);
            supportSQLiteStatement.bindLong(114, trafficProfileMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(115, (long) trafficProfileMetric.duplexModeState);
            supportSQLiteStatement.bindLong(116, (long) trafficProfileMetric.dozeModeState);
            supportSQLiteStatement.bindLong(117, (long) trafficProfileMetric.callState);
            String str40 = trafficProfileMetric.buildDevice;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindString(118, str40);
            }
            String str41 = trafficProfileMetric.buildHardware;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, str41);
            }
            String str42 = trafficProfileMetric.buildProduct;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(120);
            } else {
                supportSQLiteStatement.bindString(120, str42);
            }
            String str43 = trafficProfileMetric.appId;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(121);
            } else {
                supportSQLiteStatement.bindString(121, str43);
            }
            supportSQLiteStatement.bindLong(122, trafficProfileMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `TrafficProfileMetric` (`profileName`,`profile`,`profileType`,`meanLatency`,`medianLatency`,`minimumLatency`,`maximumLatency`,`p10Latency`,`p90Latency`,`iqmLatency`,`meanJitter`,`medianJitter`,`minimumJitter`,`maximumJitter`,`p10Jitter`,`p90Jitter`,`iqmJitter`,`packetLoss`,`outOfOrderPackets`,`packetCount`,`numberOfOutOfOrderPackets`,`throughput`,`serverUrl`,`errors`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM TrafficProfileMetric";
        }
    }

    public TrafficProfileDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(TrafficProfileMetric trafficProfileMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(trafficProfileMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<TrafficProfileMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<TrafficProfileMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
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
        int i9;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i10;
        Boolean bool9;
        int i11;
        int i12;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from TrafficProfileMetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "profileName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, Scopes.PROFILE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "profileType");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "meanLatency");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "medianLatency");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "minimumLatency");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "maximumLatency");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "p10Latency");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "p90Latency");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "iqmLatency");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "meanJitter");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "medianJitter");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "minimumJitter");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "maximumJitter");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "p10Jitter");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "p90Jitter");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "iqmJitter");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "packetLoss");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "outOfOrderPackets");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "packetCount");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "numberOfOutOfOrderPackets");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "throughput");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "errors");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i13 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    TrafficProfileMetric trafficProfileMetric = new TrafficProfileMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        trafficProfileMetric.profileName = null;
                    } else {
                        arrayList = arrayList2;
                        trafficProfileMetric.profileName = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        trafficProfileMetric.profile = null;
                    } else {
                        trafficProfileMetric.profile = query.getString(columnIndexOrThrow2);
                    }
                    trafficProfileMetric.profileType = query.getInt(columnIndexOrThrow3);
                    int i14 = columnIndexOrThrow;
                    int i15 = columnIndexOrThrow2;
                    trafficProfileMetric.meanLatency = query.getLong(columnIndexOrThrow4);
                    trafficProfileMetric.medianLatency = query.getLong(columnIndexOrThrow5);
                    trafficProfileMetric.minimumLatency = query.getLong(columnIndexOrThrow6);
                    trafficProfileMetric.maximumLatency = query.getLong(columnIndexOrThrow7);
                    trafficProfileMetric.p10Latency = query.getLong(columnIndexOrThrow8);
                    trafficProfileMetric.p90Latency = query.getLong(columnIndexOrThrow9);
                    trafficProfileMetric.iqmLatency = query.getLong(columnIndexOrThrow10);
                    trafficProfileMetric.meanJitter = query.getLong(columnIndexOrThrow11);
                    trafficProfileMetric.medianJitter = query.getLong(columnIndexOrThrow12);
                    int i16 = columnIndexOrThrow11;
                    int i17 = i13;
                    int i18 = i14;
                    trafficProfileMetric.minimumJitter = query.getLong(i17);
                    int i19 = columnIndexOrThrow12;
                    int i20 = columnIndexOrThrow14;
                    int i21 = i17;
                    trafficProfileMetric.maximumJitter = query.getLong(i20);
                    int i22 = i20;
                    int i23 = columnIndexOrThrow15;
                    int i24 = i19;
                    trafficProfileMetric.p10Jitter = query.getLong(i23);
                    int i25 = i23;
                    int i26 = columnIndexOrThrow16;
                    int i27 = i22;
                    trafficProfileMetric.p90Jitter = query.getLong(i26);
                    int i28 = i26;
                    int i29 = columnIndexOrThrow17;
                    int i30 = i25;
                    trafficProfileMetric.iqmJitter = query.getLong(i29);
                    int i31 = i29;
                    int i32 = columnIndexOrThrow18;
                    int i33 = i28;
                    trafficProfileMetric.packetLoss = query.getLong(i32);
                    int i34 = columnIndexOrThrow19;
                    trafficProfileMetric.outOfOrderPackets = query.getInt(i34);
                    int i35 = i32;
                    int i36 = columnIndexOrThrow20;
                    trafficProfileMetric.packetCount = query.getInt(i36);
                    int i37 = i31;
                    int i38 = columnIndexOrThrow21;
                    trafficProfileMetric.numberOfOutOfOrderPackets = query.getInt(i38);
                    int i39 = i34;
                    int i40 = columnIndexOrThrow22;
                    int i41 = i36;
                    trafficProfileMetric.throughput = query.getDouble(i40);
                    int i42 = columnIndexOrThrow23;
                    if (query.isNull(i42)) {
                        trafficProfileMetric.serverUrl = null;
                    } else {
                        trafficProfileMetric.serverUrl = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow24;
                    if (query.isNull(i43)) {
                        i = i38;
                        trafficProfileMetric.errors = null;
                    } else {
                        i = i38;
                        trafficProfileMetric.errors = query.getString(i43);
                    }
                    int i44 = i42;
                    int i45 = columnIndexOrThrow25;
                    int i46 = i43;
                    trafficProfileMetric.id = query.getLong(i45);
                    int i47 = columnIndexOrThrow26;
                    if (query.isNull(i47)) {
                        trafficProfileMetric.mobileClientId = null;
                    } else {
                        trafficProfileMetric.mobileClientId = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow27;
                    if (query.isNull(i48)) {
                        i2 = i45;
                        trafficProfileMetric.measurementSequenceId = null;
                    } else {
                        i2 = i45;
                        trafficProfileMetric.measurementSequenceId = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow28;
                    if (query.isNull(i49)) {
                        i3 = i40;
                        trafficProfileMetric.clientIp = null;
                    } else {
                        i3 = i40;
                        trafficProfileMetric.clientIp = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow29;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow28 = i49;
                        trafficProfileMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow28 = i49;
                        trafficProfileMetric.dateTimeOfMeasurement = query.getString(i50);
                    }
                    columnIndexOrThrow29 = i50;
                    int i51 = columnIndexOrThrow30;
                    trafficProfileMetric.stateDuringMeasurement = query.getInt(i51);
                    int i52 = columnIndexOrThrow31;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow30 = i51;
                        trafficProfileMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow30 = i51;
                        trafficProfileMetric.accessTechnology = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow32;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow31 = i52;
                        trafficProfileMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow31 = i52;
                        trafficProfileMetric.accessTypeRaw = query.getString(i53);
                    }
                    columnIndexOrThrow32 = i53;
                    int i54 = columnIndexOrThrow33;
                    trafficProfileMetric.signalStrength = query.getInt(i54);
                    columnIndexOrThrow33 = i54;
                    int i55 = columnIndexOrThrow34;
                    trafficProfileMetric.interference = query.getInt(i55);
                    int i56 = columnIndexOrThrow35;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow34 = i55;
                        trafficProfileMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow34 = i55;
                        trafficProfileMetric.simMCC = query.getString(i56);
                    }
                    int i57 = columnIndexOrThrow36;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow35 = i56;
                        trafficProfileMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow35 = i56;
                        trafficProfileMetric.simMNC = query.getString(i57);
                    }
                    int i58 = columnIndexOrThrow37;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow36 = i57;
                        trafficProfileMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow36 = i57;
                        trafficProfileMetric.secondarySimMCC = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow38;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow37 = i58;
                        trafficProfileMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow37 = i58;
                        trafficProfileMetric.secondarySimMNC = query.getString(i59);
                    }
                    columnIndexOrThrow38 = i59;
                    int i60 = columnIndexOrThrow39;
                    trafficProfileMetric.numberOfSimSlots = query.getInt(i60);
                    columnIndexOrThrow39 = i60;
                    int i61 = columnIndexOrThrow40;
                    trafficProfileMetric.dataSimSlotNumber = query.getInt(i61);
                    int i62 = columnIndexOrThrow41;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow40 = i61;
                        trafficProfileMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow40 = i61;
                        trafficProfileMetric.networkMCC = query.getString(i62);
                    }
                    int i63 = columnIndexOrThrow42;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow41 = i62;
                        trafficProfileMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow41 = i62;
                        trafficProfileMetric.networkMNC = query.getString(i63);
                    }
                    int i64 = i47;
                    int i65 = columnIndexOrThrow43;
                    int i66 = i48;
                    trafficProfileMetric.latitude = query.getDouble(i65);
                    int i67 = i63;
                    int i68 = columnIndexOrThrow44;
                    int i69 = i65;
                    trafficProfileMetric.longitude = query.getDouble(i68);
                    int i70 = i68;
                    int i71 = columnIndexOrThrow45;
                    int i72 = i67;
                    trafficProfileMetric.gpsAccuracy = query.getDouble(i71);
                    int i73 = columnIndexOrThrow46;
                    if (query.isNull(i73)) {
                        trafficProfileMetric.cellId = null;
                    } else {
                        trafficProfileMetric.cellId = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow47;
                    if (query.isNull(i74)) {
                        i4 = i71;
                        trafficProfileMetric.lacId = null;
                    } else {
                        i4 = i71;
                        trafficProfileMetric.lacId = query.getString(i74);
                    }
                    int i75 = columnIndexOrThrow48;
                    if (query.isNull(i75)) {
                        i5 = i70;
                        trafficProfileMetric.deviceBrand = null;
                    } else {
                        i5 = i70;
                        trafficProfileMetric.deviceBrand = query.getString(i75);
                    }
                    int i76 = columnIndexOrThrow49;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow48 = i75;
                        trafficProfileMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow48 = i75;
                        trafficProfileMetric.deviceModel = query.getString(i76);
                    }
                    int i77 = columnIndexOrThrow50;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow49 = i76;
                        trafficProfileMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow49 = i76;
                        trafficProfileMetric.deviceVersion = query.getString(i77);
                    }
                    int i78 = columnIndexOrThrow51;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow50 = i77;
                        trafficProfileMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow50 = i77;
                        trafficProfileMetric.sdkVersionNumber = query.getString(i78);
                    }
                    int i79 = columnIndexOrThrow52;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow51 = i78;
                        trafficProfileMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow51 = i78;
                        trafficProfileMetric.carrierName = query.getString(i79);
                    }
                    int i80 = columnIndexOrThrow53;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow52 = i79;
                        trafficProfileMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow52 = i79;
                        trafficProfileMetric.secondaryCarrierName = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow54;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow53 = i80;
                        trafficProfileMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow53 = i80;
                        trafficProfileMetric.networkOperatorName = query.getString(i81);
                    }
                    int i82 = columnIndexOrThrow55;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow54 = i81;
                        trafficProfileMetric.os = null;
                    } else {
                        columnIndexOrThrow54 = i81;
                        trafficProfileMetric.os = query.getString(i82);
                    }
                    int i83 = columnIndexOrThrow56;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow55 = i82;
                        trafficProfileMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow55 = i82;
                        trafficProfileMetric.osVersion = query.getString(i83);
                    }
                    int i84 = columnIndexOrThrow57;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow56 = i83;
                        trafficProfileMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow56 = i83;
                        trafficProfileMetric.readableDate = query.getString(i84);
                    }
                    int i85 = columnIndexOrThrow58;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow57 = i84;
                        trafficProfileMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow57 = i84;
                        trafficProfileMetric.physicalCellId = Integer.valueOf(query.getInt(i85));
                    }
                    int i86 = columnIndexOrThrow59;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow58 = i85;
                        trafficProfileMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow58 = i85;
                        trafficProfileMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i86));
                    }
                    int i87 = columnIndexOrThrow60;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow59 = i86;
                        trafficProfileMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow59 = i86;
                        trafficProfileMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow61;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow60 = i87;
                        trafficProfileMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow60 = i87;
                        trafficProfileMetric.cellBands = query.getString(i88);
                    }
                    int i89 = columnIndexOrThrow62;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow61 = i88;
                        trafficProfileMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow61 = i88;
                        trafficProfileMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow63;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow62 = i89;
                        trafficProfileMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow62 = i89;
                        trafficProfileMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow64;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow63 = i90;
                        trafficProfileMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow63 = i90;
                        trafficProfileMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow65;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow64 = i91;
                        trafficProfileMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow64 = i91;
                        trafficProfileMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i92));
                    }
                    int i93 = columnIndexOrThrow66;
                    if (query.isNull(i93)) {
                        columnIndexOrThrow65 = i92;
                        trafficProfileMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow65 = i92;
                        trafficProfileMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i93));
                    }
                    int i94 = columnIndexOrThrow67;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow66 = i93;
                        trafficProfileMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow66 = i93;
                        trafficProfileMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i94));
                    }
                    int i95 = columnIndexOrThrow68;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow67 = i94;
                        trafficProfileMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow67 = i94;
                        trafficProfileMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow69;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow68 = i95;
                        trafficProfileMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow68 = i95;
                        trafficProfileMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow70;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow69 = i96;
                        trafficProfileMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow69 = i96;
                        trafficProfileMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow71;
                    if (query.isNull(i98)) {
                        columnIndexOrThrow70 = i97;
                        trafficProfileMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow70 = i97;
                        trafficProfileMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i98));
                    }
                    int i99 = columnIndexOrThrow72;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow71 = i98;
                        trafficProfileMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow71 = i98;
                        trafficProfileMetric.timingAdvance = Integer.valueOf(query.getInt(i99));
                    }
                    int i100 = columnIndexOrThrow73;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow72 = i99;
                        trafficProfileMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow72 = i99;
                        trafficProfileMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i100));
                    }
                    int i101 = columnIndexOrThrow74;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow73 = i100;
                        trafficProfileMetric.dbm = null;
                    } else {
                        columnIndexOrThrow73 = i100;
                        trafficProfileMetric.dbm = Integer.valueOf(query.getInt(i101));
                    }
                    int i102 = columnIndexOrThrow75;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow74 = i101;
                        trafficProfileMetric.debugString = null;
                    } else {
                        columnIndexOrThrow74 = i101;
                        trafficProfileMetric.debugString = query.getString(i102);
                    }
                    int i103 = columnIndexOrThrow76;
                    Integer valueOf = query.isNull(i103) ? null : Integer.valueOf(query.getInt(i103));
                    if (valueOf == null) {
                        i6 = i103;
                        bool = null;
                    } else {
                        i6 = i103;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    trafficProfileMetric.isDcNrRestricted = bool;
                    int i104 = columnIndexOrThrow77;
                    Integer valueOf2 = query.isNull(i104) ? null : Integer.valueOf(query.getInt(i104));
                    if (valueOf2 == null) {
                        columnIndexOrThrow77 = i104;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow77 = i104;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    trafficProfileMetric.isNrAvailable = bool2;
                    int i105 = columnIndexOrThrow78;
                    Integer valueOf3 = query.isNull(i105) ? null : Integer.valueOf(query.getInt(i105));
                    if (valueOf3 == null) {
                        columnIndexOrThrow78 = i105;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow78 = i105;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    trafficProfileMetric.isEnDcAvailable = bool3;
                    int i106 = columnIndexOrThrow79;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow75 = i102;
                        trafficProfileMetric.nrState = null;
                    } else {
                        columnIndexOrThrow75 = i102;
                        trafficProfileMetric.nrState = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow80;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow79 = i106;
                        trafficProfileMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow79 = i106;
                        trafficProfileMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i107));
                    }
                    int i108 = columnIndexOrThrow81;
                    Integer valueOf4 = query.isNull(i108) ? null : Integer.valueOf(query.getInt(i108));
                    if (valueOf4 == null) {
                        columnIndexOrThrow81 = i108;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow81 = i108;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    trafficProfileMetric.isUsingCarrierAggregation = bool4;
                    int i109 = columnIndexOrThrow82;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow80 = i107;
                        trafficProfileMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow80 = i107;
                        trafficProfileMetric.vopsSupport = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow83;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow82 = i109;
                        trafficProfileMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow82 = i109;
                        trafficProfileMetric.cellBandwidths = query.getString(i110);
                    }
                    int i111 = columnIndexOrThrow84;
                    if (query.isNull(i111)) {
                        columnIndexOrThrow83 = i110;
                        trafficProfileMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow83 = i110;
                        trafficProfileMetric.additionalPlmns = query.getString(i111);
                    }
                    int i112 = i73;
                    int i113 = columnIndexOrThrow85;
                    int i114 = i74;
                    trafficProfileMetric.altitude = query.getDouble(i113);
                    int i115 = columnIndexOrThrow86;
                    if (query.isNull(i115)) {
                        trafficProfileMetric.locationSpeed = null;
                    } else {
                        trafficProfileMetric.locationSpeed = Float.valueOf(query.getFloat(i115));
                    }
                    int i116 = columnIndexOrThrow87;
                    if (query.isNull(i116)) {
                        i7 = i111;
                        trafficProfileMetric.locationSpeedAccuracy = null;
                    } else {
                        i7 = i111;
                        trafficProfileMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i116));
                    }
                    int i117 = columnIndexOrThrow88;
                    if (query.isNull(i117)) {
                        i8 = i113;
                        trafficProfileMetric.gpsVerticalAccuracy = null;
                    } else {
                        i8 = i113;
                        trafficProfileMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i117));
                    }
                    columnIndexOrThrow88 = i117;
                    int i118 = columnIndexOrThrow89;
                    trafficProfileMetric.getRestrictBackgroundStatus = query.getInt(i118);
                    int i119 = columnIndexOrThrow90;
                    if (query.isNull(i119)) {
                        columnIndexOrThrow89 = i118;
                        trafficProfileMetric.cellType = null;
                    } else {
                        columnIndexOrThrow89 = i118;
                        trafficProfileMetric.cellType = query.getString(i119);
                    }
                    int i120 = columnIndexOrThrow91;
                    Integer valueOf5 = query.isNull(i120) ? null : Integer.valueOf(query.getInt(i120));
                    if (valueOf5 == null) {
                        i9 = i119;
                        bool5 = null;
                    } else {
                        i9 = i119;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    trafficProfileMetric.isDefaultNetworkActive = bool5;
                    int i121 = columnIndexOrThrow92;
                    Integer valueOf6 = query.isNull(i121) ? null : Integer.valueOf(query.getInt(i121));
                    if (valueOf6 == null) {
                        columnIndexOrThrow92 = i121;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow92 = i121;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    trafficProfileMetric.isActiveNetworkMetered = bool6;
                    int i122 = columnIndexOrThrow93;
                    Integer valueOf7 = query.isNull(i122) ? null : Integer.valueOf(query.getInt(i122));
                    if (valueOf7 == null) {
                        columnIndexOrThrow93 = i122;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow93 = i122;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    trafficProfileMetric.isOnScreen = bool7;
                    int i123 = columnIndexOrThrow94;
                    Integer valueOf8 = query.isNull(i123) ? null : Integer.valueOf(query.getInt(i123));
                    if (valueOf8 == null) {
                        columnIndexOrThrow94 = i123;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow94 = i123;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    trafficProfileMetric.isRoaming = bool8;
                    int i124 = i120;
                    int i125 = columnIndexOrThrow95;
                    trafficProfileMetric.locationAge = query.getInt(i125);
                    int i126 = columnIndexOrThrow96;
                    if (query.isNull(i126)) {
                        columnIndexOrThrow95 = i125;
                        trafficProfileMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow95 = i125;
                        trafficProfileMetric.overrideNetworkType = Integer.valueOf(query.getInt(i126));
                    }
                    int i127 = columnIndexOrThrow97;
                    if (query.isNull(i127)) {
                        columnIndexOrThrow96 = i126;
                        trafficProfileMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow96 = i126;
                        trafficProfileMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i127));
                    }
                    int i128 = columnIndexOrThrow98;
                    Integer valueOf9 = query.isNull(i128) ? null : Integer.valueOf(query.getInt(i128));
                    if (valueOf9 == null) {
                        i10 = i127;
                        bool9 = null;
                    } else {
                        i10 = i127;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    trafficProfileMetric.anonymize = bool9;
                    int i129 = columnIndexOrThrow99;
                    if (query.isNull(i129)) {
                        i11 = i128;
                        trafficProfileMetric.sdkOrigin = null;
                    } else {
                        i11 = i128;
                        trafficProfileMetric.sdkOrigin = query.getString(i129);
                    }
                    int i130 = columnIndexOrThrow100;
                    Integer valueOf10 = query.isNull(i130) ? null : Integer.valueOf(query.getInt(i130));
                    if (valueOf10 == null) {
                        i12 = i129;
                        bool10 = null;
                    } else {
                        i12 = i129;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    trafficProfileMetric.isRooted = bool10;
                    int i131 = columnIndexOrThrow101;
                    Integer valueOf11 = query.isNull(i131) ? null : Integer.valueOf(query.getInt(i131));
                    if (valueOf11 == null) {
                        columnIndexOrThrow101 = i131;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow101 = i131;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    trafficProfileMetric.isConnectedToVpn = bool11;
                    int i132 = i130;
                    int i133 = columnIndexOrThrow102;
                    trafficProfileMetric.linkDownstreamBandwidth = query.getInt(i133);
                    columnIndexOrThrow102 = i133;
                    int i134 = columnIndexOrThrow103;
                    trafficProfileMetric.linkUpstreamBandwidth = query.getInt(i134);
                    columnIndexOrThrow103 = i134;
                    int i135 = columnIndexOrThrow104;
                    trafficProfileMetric.latencyType = query.getInt(i135);
                    int i136 = columnIndexOrThrow105;
                    if (query.isNull(i136)) {
                        columnIndexOrThrow104 = i135;
                        trafficProfileMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow104 = i135;
                        trafficProfileMetric.serverIp = query.getString(i136);
                    }
                    int i137 = columnIndexOrThrow106;
                    if (query.isNull(i137)) {
                        columnIndexOrThrow105 = i136;
                        trafficProfileMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow105 = i136;
                        trafficProfileMetric.privateIp = query.getString(i137);
                    }
                    int i138 = columnIndexOrThrow107;
                    if (query.isNull(i138)) {
                        columnIndexOrThrow106 = i137;
                        trafficProfileMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow106 = i137;
                        trafficProfileMetric.gatewayIp = query.getString(i138);
                    }
                    int i139 = columnIndexOrThrow108;
                    if (query.isNull(i139)) {
                        columnIndexOrThrow107 = i138;
                        trafficProfileMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow107 = i138;
                        trafficProfileMetric.locationPermissionState = Integer.valueOf(query.getInt(i139));
                    }
                    int i140 = columnIndexOrThrow109;
                    if (query.isNull(i140)) {
                        columnIndexOrThrow108 = i139;
                        trafficProfileMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow108 = i139;
                        trafficProfileMetric.serviceStateStatus = Integer.valueOf(query.getInt(i140));
                    }
                    int i141 = columnIndexOrThrow110;
                    Integer valueOf12 = query.isNull(i141) ? null : Integer.valueOf(query.getInt(i141));
                    if (valueOf12 == null) {
                        columnIndexOrThrow110 = i141;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow110 = i141;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    trafficProfileMetric.isNrCellSeen = bool12;
                    int i142 = columnIndexOrThrow111;
                    Integer valueOf13 = query.isNull(i142) ? null : Integer.valueOf(query.getInt(i142));
                    if (valueOf13 == null) {
                        columnIndexOrThrow111 = i142;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow111 = i142;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    trafficProfileMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i143 = columnIndexOrThrow112;
                    if (query.isNull(i143)) {
                        columnIndexOrThrow109 = i140;
                        trafficProfileMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow109 = i140;
                        trafficProfileMetric.appVersionName = query.getString(i143);
                    }
                    int i144 = i115;
                    int i145 = columnIndexOrThrow113;
                    int i146 = i116;
                    trafficProfileMetric.appVersionCode = query.getLong(i145);
                    int i147 = i143;
                    int i148 = columnIndexOrThrow114;
                    int i149 = i145;
                    trafficProfileMetric.appLastUpdateTime = query.getLong(i148);
                    int i150 = columnIndexOrThrow115;
                    trafficProfileMetric.duplexModeState = query.getInt(i150);
                    columnIndexOrThrow115 = i150;
                    int i151 = columnIndexOrThrow116;
                    trafficProfileMetric.dozeModeState = query.getInt(i151);
                    columnIndexOrThrow116 = i151;
                    int i152 = columnIndexOrThrow117;
                    trafficProfileMetric.callState = query.getInt(i152);
                    int i153 = columnIndexOrThrow118;
                    if (query.isNull(i153)) {
                        columnIndexOrThrow117 = i152;
                        trafficProfileMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow117 = i152;
                        trafficProfileMetric.buildDevice = query.getString(i153);
                    }
                    int i154 = columnIndexOrThrow119;
                    if (query.isNull(i154)) {
                        columnIndexOrThrow118 = i153;
                        trafficProfileMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow118 = i153;
                        trafficProfileMetric.buildHardware = query.getString(i154);
                    }
                    int i155 = columnIndexOrThrow120;
                    if (query.isNull(i155)) {
                        columnIndexOrThrow119 = i154;
                        trafficProfileMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow119 = i154;
                        trafficProfileMetric.buildProduct = query.getString(i155);
                    }
                    int i156 = columnIndexOrThrow121;
                    if (query.isNull(i156)) {
                        columnIndexOrThrow120 = i155;
                        trafficProfileMetric.appId = null;
                    } else {
                        columnIndexOrThrow120 = i155;
                        trafficProfileMetric.appId = query.getString(i156);
                    }
                    int i157 = columnIndexOrThrow122;
                    if (query.getInt(i157) != 0) {
                        columnIndexOrThrow121 = i156;
                        z = true;
                    } else {
                        columnIndexOrThrow121 = i156;
                        z = false;
                    }
                    trafficProfileMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(trafficProfileMetric);
                    columnIndexOrThrow122 = i157;
                    columnIndexOrThrow11 = i16;
                    columnIndexOrThrow2 = i15;
                    columnIndexOrThrow76 = i6;
                    int i158 = i149;
                    columnIndexOrThrow114 = i148;
                    columnIndexOrThrow12 = i24;
                    columnIndexOrThrow15 = i30;
                    columnIndexOrThrow17 = i37;
                    columnIndexOrThrow20 = i41;
                    columnIndexOrThrow22 = i3;
                    columnIndexOrThrow27 = i66;
                    columnIndexOrThrow43 = i69;
                    columnIndexOrThrow44 = i5;
                    columnIndexOrThrow47 = i114;
                    columnIndexOrThrow85 = i8;
                    columnIndexOrThrow87 = i146;
                    columnIndexOrThrow113 = i158;
                    int i159 = i144;
                    columnIndexOrThrow112 = i147;
                    columnIndexOrThrow = i18;
                    i13 = i21;
                    columnIndexOrThrow14 = i27;
                    columnIndexOrThrow16 = i33;
                    columnIndexOrThrow18 = i35;
                    columnIndexOrThrow19 = i39;
                    columnIndexOrThrow21 = i;
                    columnIndexOrThrow23 = i44;
                    columnIndexOrThrow24 = i46;
                    columnIndexOrThrow25 = i2;
                    columnIndexOrThrow26 = i64;
                    columnIndexOrThrow42 = i72;
                    columnIndexOrThrow45 = i4;
                    columnIndexOrThrow46 = i112;
                    columnIndexOrThrow84 = i7;
                    columnIndexOrThrow86 = i159;
                    int i160 = i9;
                    columnIndexOrThrow91 = i124;
                    columnIndexOrThrow90 = i160;
                    int i161 = i10;
                    columnIndexOrThrow98 = i11;
                    columnIndexOrThrow97 = i161;
                    int i162 = i12;
                    columnIndexOrThrow100 = i132;
                    columnIndexOrThrow99 = i162;
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
