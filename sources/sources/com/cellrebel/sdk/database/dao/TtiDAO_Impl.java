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
import com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TtiDAO_Impl implements TtiDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<TimeToInteractionMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<TimeToInteractionMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, TimeToInteractionMetric timeToInteractionMetric) {
            Integer num = timeToInteractionMetric.serverId;
            if (num == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindLong(1, (long) num.intValue());
            }
            Integer num2 = timeToInteractionMetric.serverPort;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, (long) num2.intValue());
            }
            String str = timeToInteractionMetric.serverVersion;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = timeToInteractionMetric.serverBuild;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            Integer num3 = timeToInteractionMetric.latency;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, (long) num3.intValue());
            }
            Integer num4 = timeToInteractionMetric.downloadTime;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, (long) num4.intValue());
            }
            Integer num5 = timeToInteractionMetric.downloadTimeToFirstByte;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindLong(7, (long) num5.intValue());
            }
            Integer num6 = timeToInteractionMetric.bytesDownloaded;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, (long) num6.intValue());
            }
            Integer num7 = timeToInteractionMetric.uploadTime;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, (long) num7.intValue());
            }
            Integer num8 = timeToInteractionMetric.uploadTimeToFirstByte;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, (long) num8.intValue());
            }
            Integer num9 = timeToInteractionMetric.bytesUploaded;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, (long) num9.intValue());
            }
            String str3 = timeToInteractionMetric.errorTypes;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str3);
            }
            String str4 = timeToInteractionMetric.accessTechStart;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str4);
            }
            String str5 = timeToInteractionMetric.accessTechEnd;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str5);
            }
            supportSQLiteStatement.bindLong(15, (long) timeToInteractionMetric.accessTechNumChanges);
            supportSQLiteStatement.bindLong(16, timeToInteractionMetric.id);
            String str6 = timeToInteractionMetric.mobileClientId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str6);
            }
            String str7 = timeToInteractionMetric.measurementSequenceId;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str7);
            }
            String str8 = timeToInteractionMetric.clientIp;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str8);
            }
            String str9 = timeToInteractionMetric.dateTimeOfMeasurement;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str9);
            }
            supportSQLiteStatement.bindLong(21, (long) timeToInteractionMetric.stateDuringMeasurement);
            String str10 = timeToInteractionMetric.accessTechnology;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str10);
            }
            String str11 = timeToInteractionMetric.accessTypeRaw;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str11);
            }
            supportSQLiteStatement.bindLong(24, (long) timeToInteractionMetric.signalStrength);
            supportSQLiteStatement.bindLong(25, (long) timeToInteractionMetric.interference);
            String str12 = timeToInteractionMetric.simMCC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str12);
            }
            String str13 = timeToInteractionMetric.simMNC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str13);
            }
            String str14 = timeToInteractionMetric.secondarySimMCC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str14);
            }
            String str15 = timeToInteractionMetric.secondarySimMNC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str15);
            }
            supportSQLiteStatement.bindLong(30, (long) timeToInteractionMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(31, (long) timeToInteractionMetric.dataSimSlotNumber);
            String str16 = timeToInteractionMetric.networkMCC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str16);
            }
            String str17 = timeToInteractionMetric.networkMNC;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str17);
            }
            supportSQLiteStatement.bindDouble(34, timeToInteractionMetric.latitude);
            supportSQLiteStatement.bindDouble(35, timeToInteractionMetric.longitude);
            supportSQLiteStatement.bindDouble(36, timeToInteractionMetric.gpsAccuracy);
            String str18 = timeToInteractionMetric.cellId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str18);
            }
            String str19 = timeToInteractionMetric.lacId;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str19);
            }
            String str20 = timeToInteractionMetric.deviceBrand;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str20);
            }
            String str21 = timeToInteractionMetric.deviceModel;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str21);
            }
            String str22 = timeToInteractionMetric.deviceVersion;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str22);
            }
            String str23 = timeToInteractionMetric.sdkVersionNumber;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str23);
            }
            String str24 = timeToInteractionMetric.carrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str24);
            }
            String str25 = timeToInteractionMetric.secondaryCarrierName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str25);
            }
            String str26 = timeToInteractionMetric.networkOperatorName;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str26);
            }
            String str27 = timeToInteractionMetric.os;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str27);
            }
            String str28 = timeToInteractionMetric.osVersion;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str28);
            }
            String str29 = timeToInteractionMetric.readableDate;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str29);
            }
            Integer num10 = timeToInteractionMetric.physicalCellId;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num10.intValue());
            }
            Integer num11 = timeToInteractionMetric.absoluteRfChannelNumber;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num11.intValue());
            }
            Integer num12 = timeToInteractionMetric.connectionAbsoluteRfChannelNumber;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num12.intValue());
            }
            String str30 = timeToInteractionMetric.cellBands;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str30);
            }
            Integer num13 = timeToInteractionMetric.channelQualityIndicator;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num13.intValue());
            }
            Integer num14 = timeToInteractionMetric.referenceSignalSignalToNoiseRatio;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num14.intValue());
            }
            Integer num15 = timeToInteractionMetric.referenceSignalReceivedPower;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num15.intValue());
            }
            Integer num16 = timeToInteractionMetric.referenceSignalReceivedQuality;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num16.intValue());
            }
            Integer num17 = timeToInteractionMetric.csiReferenceSignalReceivedPower;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num17.intValue());
            }
            Integer num18 = timeToInteractionMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num18.intValue());
            }
            Integer num19 = timeToInteractionMetric.csiReferenceSignalReceivedQuality;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num19.intValue());
            }
            Integer num20 = timeToInteractionMetric.ssReferenceSignalReceivedPower;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num20.intValue());
            }
            Integer num21 = timeToInteractionMetric.ssReferenceSignalReceivedQuality;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num21.intValue());
            }
            Integer num22 = timeToInteractionMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num22.intValue());
            }
            Integer num23 = timeToInteractionMetric.timingAdvance;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num23.intValue());
            }
            Integer num24 = timeToInteractionMetric.signalStrengthAsu;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num24.intValue());
            }
            Integer num25 = timeToInteractionMetric.dbm;
            if (num25 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num25.intValue());
            }
            String str31 = timeToInteractionMetric.debugString;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindString(66, str31);
            }
            Boolean bool = timeToInteractionMetric.isDcNrRestricted;
            Integer num26 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) valueOf.intValue());
            }
            Boolean bool2 = timeToInteractionMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) valueOf2.intValue());
            }
            Boolean bool3 = timeToInteractionMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) valueOf3.intValue());
            }
            String str32 = timeToInteractionMetric.nrState;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str32);
            }
            Integer num27 = timeToInteractionMetric.nrFrequencyRange;
            if (num27 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num27.intValue());
            }
            Boolean bool4 = timeToInteractionMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) valueOf4.intValue());
            }
            Integer num28 = timeToInteractionMetric.vopsSupport;
            if (num28 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num28.intValue());
            }
            String str33 = timeToInteractionMetric.cellBandwidths;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindString(74, str33);
            }
            String str34 = timeToInteractionMetric.additionalPlmns;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindString(75, str34);
            }
            supportSQLiteStatement.bindDouble(76, timeToInteractionMetric.altitude);
            Float f = timeToInteractionMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindDouble(77, (double) f.floatValue());
            }
            Float f2 = timeToInteractionMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindDouble(78, (double) f2.floatValue());
            }
            Float f3 = timeToInteractionMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindDouble(79, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(80, (long) timeToInteractionMetric.getRestrictBackgroundStatus);
            String str35 = timeToInteractionMetric.cellType;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindString(81, str35);
            }
            Boolean bool5 = timeToInteractionMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) valueOf5.intValue());
            }
            Boolean bool6 = timeToInteractionMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) valueOf6.intValue());
            }
            Boolean bool7 = timeToInteractionMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindLong(84, (long) valueOf7.intValue());
            }
            Boolean bool8 = timeToInteractionMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindLong(85, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(86, (long) timeToInteractionMetric.locationAge);
            Integer num29 = timeToInteractionMetric.overrideNetworkType;
            if (num29 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) num29.intValue());
            }
            Integer num30 = timeToInteractionMetric.accessNetworkTechnologyRaw;
            if (num30 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) num30.intValue());
            }
            Boolean bool9 = timeToInteractionMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) valueOf9.intValue());
            }
            String str36 = timeToInteractionMetric.sdkOrigin;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindString(90, str36);
            }
            Boolean bool10 = timeToInteractionMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) valueOf10.intValue());
            }
            Boolean bool11 = timeToInteractionMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(93, (long) timeToInteractionMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(94, (long) timeToInteractionMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(95, (long) timeToInteractionMetric.latencyType);
            String str37 = timeToInteractionMetric.serverIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str37);
            }
            String str38 = timeToInteractionMetric.privateIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindString(97, str38);
            }
            String str39 = timeToInteractionMetric.gatewayIp;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str39);
            }
            Integer num31 = timeToInteractionMetric.locationPermissionState;
            if (num31 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) num31.intValue());
            }
            Integer num32 = timeToInteractionMetric.serviceStateStatus;
            if (num32 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindLong(100, (long) num32.intValue());
            }
            Boolean bool12 = timeToInteractionMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindLong(101, (long) valueOf12.intValue());
            }
            Boolean bool13 = timeToInteractionMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num26 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num26 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindLong(102, (long) num26.intValue());
            }
            String str40 = timeToInteractionMetric.appVersionName;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindString(103, str40);
            }
            supportSQLiteStatement.bindLong(104, timeToInteractionMetric.appVersionCode);
            supportSQLiteStatement.bindLong(105, timeToInteractionMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(106, (long) timeToInteractionMetric.duplexModeState);
            supportSQLiteStatement.bindLong(107, (long) timeToInteractionMetric.dozeModeState);
            supportSQLiteStatement.bindLong(108, (long) timeToInteractionMetric.callState);
            String str41 = timeToInteractionMetric.buildDevice;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindString(109, str41);
            }
            String str42 = timeToInteractionMetric.buildHardware;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindString(110, str42);
            }
            String str43 = timeToInteractionMetric.buildProduct;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindString(111, str43);
            }
            String str44 = timeToInteractionMetric.appId;
            if (str44 == null) {
                supportSQLiteStatement.bindNull(112);
            } else {
                supportSQLiteStatement.bindString(112, str44);
            }
            supportSQLiteStatement.bindLong(113, timeToInteractionMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `TimeToInteractionMetric` (`serverId`,`serverPort`,`serverVersion`,`serverBuild`,`latency`,`downloadTime`,`downloadTimeToFirstByte`,`bytesDownloaded`,`uploadTime`,`uploadTimeToFirstByte`,`bytesUploaded`,`errorTypes`,`accessTechStart`,`accessTechEnd`,`accessTechNumChanges`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM timetointeractionmetric";
        }
    }

    public TtiDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(TimeToInteractionMetric timeToInteractionMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(timeToInteractionMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<TimeToInteractionMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<TimeToInteractionMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i8;
        int i9;
        int i10;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i11;
        Boolean bool9;
        int i12;
        int i13;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from timetointeractionmetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "serverPort");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "serverVersion");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "serverBuild");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "downloadTime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "downloadTimeToFirstByte");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "bytesDownloaded");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "uploadTime");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "uploadTimeToFirstByte");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "bytesUploaded");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "errorTypes");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "accessTechStart");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "accessTechEnd");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "accessTechNumChanges");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i14 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    TimeToInteractionMetric timeToInteractionMetric = new TimeToInteractionMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        timeToInteractionMetric.serverId = null;
                    } else {
                        arrayList = arrayList2;
                        timeToInteractionMetric.serverId = Integer.valueOf(query.getInt(columnIndexOrThrow));
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        timeToInteractionMetric.serverPort = null;
                    } else {
                        timeToInteractionMetric.serverPort = Integer.valueOf(query.getInt(columnIndexOrThrow2));
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        timeToInteractionMetric.serverVersion = null;
                    } else {
                        timeToInteractionMetric.serverVersion = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        timeToInteractionMetric.serverBuild = null;
                    } else {
                        timeToInteractionMetric.serverBuild = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        timeToInteractionMetric.latency = null;
                    } else {
                        timeToInteractionMetric.latency = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        timeToInteractionMetric.downloadTime = null;
                    } else {
                        timeToInteractionMetric.downloadTime = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        timeToInteractionMetric.downloadTimeToFirstByte = null;
                    } else {
                        timeToInteractionMetric.downloadTimeToFirstByte = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        timeToInteractionMetric.bytesDownloaded = null;
                    } else {
                        timeToInteractionMetric.bytesDownloaded = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        timeToInteractionMetric.uploadTime = null;
                    } else {
                        timeToInteractionMetric.uploadTime = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        timeToInteractionMetric.uploadTimeToFirstByte = null;
                    } else {
                        timeToInteractionMetric.uploadTimeToFirstByte = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        timeToInteractionMetric.bytesUploaded = null;
                    } else {
                        timeToInteractionMetric.bytesUploaded = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        timeToInteractionMetric.errorTypes = null;
                    } else {
                        timeToInteractionMetric.errorTypes = query.getString(columnIndexOrThrow12);
                    }
                    int i15 = i14;
                    if (query.isNull(i15)) {
                        i = columnIndexOrThrow11;
                        timeToInteractionMetric.accessTechStart = null;
                    } else {
                        i = columnIndexOrThrow11;
                        timeToInteractionMetric.accessTechStart = query.getString(i15);
                    }
                    int i16 = columnIndexOrThrow14;
                    if (query.isNull(i16)) {
                        i2 = i15;
                        timeToInteractionMetric.accessTechEnd = null;
                    } else {
                        i2 = i15;
                        timeToInteractionMetric.accessTechEnd = query.getString(i16);
                    }
                    int i17 = columnIndexOrThrow15;
                    int i18 = i16;
                    timeToInteractionMetric.accessTechNumChanges = query.getInt(i17);
                    int i19 = columnIndexOrThrow12;
                    int i20 = columnIndexOrThrow16;
                    int i21 = columnIndexOrThrow;
                    timeToInteractionMetric.id = query.getLong(i20);
                    int i22 = columnIndexOrThrow17;
                    if (query.isNull(i22)) {
                        timeToInteractionMetric.mobileClientId = null;
                    } else {
                        timeToInteractionMetric.mobileClientId = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow18;
                    if (query.isNull(i23)) {
                        i3 = i17;
                        timeToInteractionMetric.measurementSequenceId = null;
                    } else {
                        i3 = i17;
                        timeToInteractionMetric.measurementSequenceId = query.getString(i23);
                    }
                    int i24 = columnIndexOrThrow19;
                    if (query.isNull(i24)) {
                        i4 = i20;
                        timeToInteractionMetric.clientIp = null;
                    } else {
                        i4 = i20;
                        timeToInteractionMetric.clientIp = query.getString(i24);
                    }
                    int i25 = columnIndexOrThrow20;
                    if (query.isNull(i25)) {
                        columnIndexOrThrow19 = i24;
                        timeToInteractionMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow19 = i24;
                        timeToInteractionMetric.dateTimeOfMeasurement = query.getString(i25);
                    }
                    columnIndexOrThrow20 = i25;
                    int i26 = columnIndexOrThrow21;
                    timeToInteractionMetric.stateDuringMeasurement = query.getInt(i26);
                    int i27 = columnIndexOrThrow22;
                    if (query.isNull(i27)) {
                        columnIndexOrThrow21 = i26;
                        timeToInteractionMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow21 = i26;
                        timeToInteractionMetric.accessTechnology = query.getString(i27);
                    }
                    int i28 = columnIndexOrThrow23;
                    if (query.isNull(i28)) {
                        columnIndexOrThrow22 = i27;
                        timeToInteractionMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow22 = i27;
                        timeToInteractionMetric.accessTypeRaw = query.getString(i28);
                    }
                    columnIndexOrThrow23 = i28;
                    int i29 = columnIndexOrThrow24;
                    timeToInteractionMetric.signalStrength = query.getInt(i29);
                    columnIndexOrThrow24 = i29;
                    int i30 = columnIndexOrThrow25;
                    timeToInteractionMetric.interference = query.getInt(i30);
                    int i31 = columnIndexOrThrow26;
                    if (query.isNull(i31)) {
                        columnIndexOrThrow25 = i30;
                        timeToInteractionMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow25 = i30;
                        timeToInteractionMetric.simMCC = query.getString(i31);
                    }
                    int i32 = columnIndexOrThrow27;
                    if (query.isNull(i32)) {
                        columnIndexOrThrow26 = i31;
                        timeToInteractionMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow26 = i31;
                        timeToInteractionMetric.simMNC = query.getString(i32);
                    }
                    int i33 = columnIndexOrThrow28;
                    if (query.isNull(i33)) {
                        columnIndexOrThrow27 = i32;
                        timeToInteractionMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow27 = i32;
                        timeToInteractionMetric.secondarySimMCC = query.getString(i33);
                    }
                    int i34 = columnIndexOrThrow29;
                    if (query.isNull(i34)) {
                        columnIndexOrThrow28 = i33;
                        timeToInteractionMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow28 = i33;
                        timeToInteractionMetric.secondarySimMNC = query.getString(i34);
                    }
                    columnIndexOrThrow29 = i34;
                    int i35 = columnIndexOrThrow30;
                    timeToInteractionMetric.numberOfSimSlots = query.getInt(i35);
                    columnIndexOrThrow30 = i35;
                    int i36 = columnIndexOrThrow31;
                    timeToInteractionMetric.dataSimSlotNumber = query.getInt(i36);
                    int i37 = columnIndexOrThrow32;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow31 = i36;
                        timeToInteractionMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow31 = i36;
                        timeToInteractionMetric.networkMCC = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow33;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow32 = i37;
                        timeToInteractionMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow32 = i37;
                        timeToInteractionMetric.networkMNC = query.getString(i38);
                    }
                    int i39 = i22;
                    int i40 = columnIndexOrThrow34;
                    int i41 = i23;
                    timeToInteractionMetric.latitude = query.getDouble(i40);
                    int i42 = i38;
                    int i43 = columnIndexOrThrow35;
                    int i44 = i40;
                    timeToInteractionMetric.longitude = query.getDouble(i43);
                    int i45 = i43;
                    int i46 = columnIndexOrThrow36;
                    int i47 = i42;
                    timeToInteractionMetric.gpsAccuracy = query.getDouble(i46);
                    int i48 = columnIndexOrThrow37;
                    if (query.isNull(i48)) {
                        timeToInteractionMetric.cellId = null;
                    } else {
                        timeToInteractionMetric.cellId = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow38;
                    if (query.isNull(i49)) {
                        i5 = i46;
                        timeToInteractionMetric.lacId = null;
                    } else {
                        i5 = i46;
                        timeToInteractionMetric.lacId = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow39;
                    if (query.isNull(i50)) {
                        i6 = i45;
                        timeToInteractionMetric.deviceBrand = null;
                    } else {
                        i6 = i45;
                        timeToInteractionMetric.deviceBrand = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow40;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow39 = i50;
                        timeToInteractionMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow39 = i50;
                        timeToInteractionMetric.deviceModel = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow41;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow40 = i51;
                        timeToInteractionMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow40 = i51;
                        timeToInteractionMetric.deviceVersion = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow42;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow41 = i52;
                        timeToInteractionMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow41 = i52;
                        timeToInteractionMetric.sdkVersionNumber = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow43;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow42 = i53;
                        timeToInteractionMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow42 = i53;
                        timeToInteractionMetric.carrierName = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow44;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow43 = i54;
                        timeToInteractionMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow43 = i54;
                        timeToInteractionMetric.secondaryCarrierName = query.getString(i55);
                    }
                    int i56 = columnIndexOrThrow45;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow44 = i55;
                        timeToInteractionMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow44 = i55;
                        timeToInteractionMetric.networkOperatorName = query.getString(i56);
                    }
                    int i57 = columnIndexOrThrow46;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow45 = i56;
                        timeToInteractionMetric.os = null;
                    } else {
                        columnIndexOrThrow45 = i56;
                        timeToInteractionMetric.os = query.getString(i57);
                    }
                    int i58 = columnIndexOrThrow47;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow46 = i57;
                        timeToInteractionMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow46 = i57;
                        timeToInteractionMetric.osVersion = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow48;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow47 = i58;
                        timeToInteractionMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow47 = i58;
                        timeToInteractionMetric.readableDate = query.getString(i59);
                    }
                    int i60 = columnIndexOrThrow49;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow48 = i59;
                        timeToInteractionMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow48 = i59;
                        timeToInteractionMetric.physicalCellId = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow50;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow49 = i60;
                        timeToInteractionMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow49 = i60;
                        timeToInteractionMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow51;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow50 = i61;
                        timeToInteractionMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow50 = i61;
                        timeToInteractionMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow52;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow51 = i62;
                        timeToInteractionMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow51 = i62;
                        timeToInteractionMetric.cellBands = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow53;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow52 = i63;
                        timeToInteractionMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow52 = i63;
                        timeToInteractionMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow54;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow53 = i64;
                        timeToInteractionMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow53 = i64;
                        timeToInteractionMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow55;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow54 = i65;
                        timeToInteractionMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i65;
                        timeToInteractionMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow56;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow55 = i66;
                        timeToInteractionMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow55 = i66;
                        timeToInteractionMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow57;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow56 = i67;
                        timeToInteractionMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow56 = i67;
                        timeToInteractionMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow58;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow57 = i68;
                        timeToInteractionMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow57 = i68;
                        timeToInteractionMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow59;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow58 = i69;
                        timeToInteractionMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow58 = i69;
                        timeToInteractionMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow60;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow59 = i70;
                        timeToInteractionMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow59 = i70;
                        timeToInteractionMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow61;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow60 = i71;
                        timeToInteractionMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow60 = i71;
                        timeToInteractionMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i72));
                    }
                    int i73 = columnIndexOrThrow62;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow61 = i72;
                        timeToInteractionMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow61 = i72;
                        timeToInteractionMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i73));
                    }
                    int i74 = columnIndexOrThrow63;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow62 = i73;
                        timeToInteractionMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow62 = i73;
                        timeToInteractionMetric.timingAdvance = Integer.valueOf(query.getInt(i74));
                    }
                    int i75 = columnIndexOrThrow64;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow63 = i74;
                        timeToInteractionMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow63 = i74;
                        timeToInteractionMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i75));
                    }
                    int i76 = columnIndexOrThrow65;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow64 = i75;
                        timeToInteractionMetric.dbm = null;
                    } else {
                        columnIndexOrThrow64 = i75;
                        timeToInteractionMetric.dbm = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow66;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow65 = i76;
                        timeToInteractionMetric.debugString = null;
                    } else {
                        columnIndexOrThrow65 = i76;
                        timeToInteractionMetric.debugString = query.getString(i77);
                    }
                    int i78 = columnIndexOrThrow67;
                    Integer valueOf = query.isNull(i78) ? null : Integer.valueOf(query.getInt(i78));
                    if (valueOf == null) {
                        i7 = i78;
                        bool = null;
                    } else {
                        i7 = i78;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    timeToInteractionMetric.isDcNrRestricted = bool;
                    int i79 = columnIndexOrThrow68;
                    Integer valueOf2 = query.isNull(i79) ? null : Integer.valueOf(query.getInt(i79));
                    if (valueOf2 == null) {
                        columnIndexOrThrow68 = i79;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow68 = i79;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    timeToInteractionMetric.isNrAvailable = bool2;
                    int i80 = columnIndexOrThrow69;
                    Integer valueOf3 = query.isNull(i80) ? null : Integer.valueOf(query.getInt(i80));
                    if (valueOf3 == null) {
                        columnIndexOrThrow69 = i80;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow69 = i80;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    timeToInteractionMetric.isEnDcAvailable = bool3;
                    int i81 = columnIndexOrThrow70;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow66 = i77;
                        timeToInteractionMetric.nrState = null;
                    } else {
                        columnIndexOrThrow66 = i77;
                        timeToInteractionMetric.nrState = query.getString(i81);
                    }
                    int i82 = columnIndexOrThrow71;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow70 = i81;
                        timeToInteractionMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow70 = i81;
                        timeToInteractionMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i82));
                    }
                    int i83 = columnIndexOrThrow72;
                    Integer valueOf4 = query.isNull(i83) ? null : Integer.valueOf(query.getInt(i83));
                    if (valueOf4 == null) {
                        columnIndexOrThrow72 = i83;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow72 = i83;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    timeToInteractionMetric.isUsingCarrierAggregation = bool4;
                    int i84 = columnIndexOrThrow73;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow71 = i82;
                        timeToInteractionMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow71 = i82;
                        timeToInteractionMetric.vopsSupport = Integer.valueOf(query.getInt(i84));
                    }
                    int i85 = columnIndexOrThrow74;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow73 = i84;
                        timeToInteractionMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow73 = i84;
                        timeToInteractionMetric.cellBandwidths = query.getString(i85);
                    }
                    int i86 = columnIndexOrThrow75;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow74 = i85;
                        timeToInteractionMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow74 = i85;
                        timeToInteractionMetric.additionalPlmns = query.getString(i86);
                    }
                    int i87 = i48;
                    int i88 = columnIndexOrThrow76;
                    int i89 = i49;
                    timeToInteractionMetric.altitude = query.getDouble(i88);
                    int i90 = columnIndexOrThrow77;
                    if (query.isNull(i90)) {
                        timeToInteractionMetric.locationSpeed = null;
                    } else {
                        timeToInteractionMetric.locationSpeed = Float.valueOf(query.getFloat(i90));
                    }
                    int i91 = columnIndexOrThrow78;
                    if (query.isNull(i91)) {
                        i8 = i86;
                        timeToInteractionMetric.locationSpeedAccuracy = null;
                    } else {
                        i8 = i86;
                        timeToInteractionMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i91));
                    }
                    int i92 = columnIndexOrThrow79;
                    if (query.isNull(i92)) {
                        i9 = i88;
                        timeToInteractionMetric.gpsVerticalAccuracy = null;
                    } else {
                        i9 = i88;
                        timeToInteractionMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i92));
                    }
                    columnIndexOrThrow79 = i92;
                    int i93 = columnIndexOrThrow80;
                    timeToInteractionMetric.getRestrictBackgroundStatus = query.getInt(i93);
                    int i94 = columnIndexOrThrow81;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow80 = i93;
                        timeToInteractionMetric.cellType = null;
                    } else {
                        columnIndexOrThrow80 = i93;
                        timeToInteractionMetric.cellType = query.getString(i94);
                    }
                    int i95 = columnIndexOrThrow82;
                    Integer valueOf5 = query.isNull(i95) ? null : Integer.valueOf(query.getInt(i95));
                    if (valueOf5 == null) {
                        i10 = i94;
                        bool5 = null;
                    } else {
                        i10 = i94;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    timeToInteractionMetric.isDefaultNetworkActive = bool5;
                    int i96 = columnIndexOrThrow83;
                    Integer valueOf6 = query.isNull(i96) ? null : Integer.valueOf(query.getInt(i96));
                    if (valueOf6 == null) {
                        columnIndexOrThrow83 = i96;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow83 = i96;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    timeToInteractionMetric.isActiveNetworkMetered = bool6;
                    int i97 = columnIndexOrThrow84;
                    Integer valueOf7 = query.isNull(i97) ? null : Integer.valueOf(query.getInt(i97));
                    if (valueOf7 == null) {
                        columnIndexOrThrow84 = i97;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow84 = i97;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    timeToInteractionMetric.isOnScreen = bool7;
                    int i98 = columnIndexOrThrow85;
                    Integer valueOf8 = query.isNull(i98) ? null : Integer.valueOf(query.getInt(i98));
                    if (valueOf8 == null) {
                        columnIndexOrThrow85 = i98;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow85 = i98;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    timeToInteractionMetric.isRoaming = bool8;
                    int i99 = i95;
                    int i100 = columnIndexOrThrow86;
                    timeToInteractionMetric.locationAge = query.getInt(i100);
                    int i101 = columnIndexOrThrow87;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow86 = i100;
                        timeToInteractionMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow86 = i100;
                        timeToInteractionMetric.overrideNetworkType = Integer.valueOf(query.getInt(i101));
                    }
                    int i102 = columnIndexOrThrow88;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow87 = i101;
                        timeToInteractionMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow87 = i101;
                        timeToInteractionMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i102));
                    }
                    int i103 = columnIndexOrThrow89;
                    Integer valueOf9 = query.isNull(i103) ? null : Integer.valueOf(query.getInt(i103));
                    if (valueOf9 == null) {
                        i11 = i102;
                        bool9 = null;
                    } else {
                        i11 = i102;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    timeToInteractionMetric.anonymize = bool9;
                    int i104 = columnIndexOrThrow90;
                    if (query.isNull(i104)) {
                        i12 = i103;
                        timeToInteractionMetric.sdkOrigin = null;
                    } else {
                        i12 = i103;
                        timeToInteractionMetric.sdkOrigin = query.getString(i104);
                    }
                    int i105 = columnIndexOrThrow91;
                    Integer valueOf10 = query.isNull(i105) ? null : Integer.valueOf(query.getInt(i105));
                    if (valueOf10 == null) {
                        i13 = i104;
                        bool10 = null;
                    } else {
                        i13 = i104;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    timeToInteractionMetric.isRooted = bool10;
                    int i106 = columnIndexOrThrow92;
                    Integer valueOf11 = query.isNull(i106) ? null : Integer.valueOf(query.getInt(i106));
                    if (valueOf11 == null) {
                        columnIndexOrThrow92 = i106;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow92 = i106;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    timeToInteractionMetric.isConnectedToVpn = bool11;
                    int i107 = i105;
                    int i108 = columnIndexOrThrow93;
                    timeToInteractionMetric.linkDownstreamBandwidth = query.getInt(i108);
                    columnIndexOrThrow93 = i108;
                    int i109 = columnIndexOrThrow94;
                    timeToInteractionMetric.linkUpstreamBandwidth = query.getInt(i109);
                    columnIndexOrThrow94 = i109;
                    int i110 = columnIndexOrThrow95;
                    timeToInteractionMetric.latencyType = query.getInt(i110);
                    int i111 = columnIndexOrThrow96;
                    if (query.isNull(i111)) {
                        columnIndexOrThrow95 = i110;
                        timeToInteractionMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow95 = i110;
                        timeToInteractionMetric.serverIp = query.getString(i111);
                    }
                    int i112 = columnIndexOrThrow97;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow96 = i111;
                        timeToInteractionMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow96 = i111;
                        timeToInteractionMetric.privateIp = query.getString(i112);
                    }
                    int i113 = columnIndexOrThrow98;
                    if (query.isNull(i113)) {
                        columnIndexOrThrow97 = i112;
                        timeToInteractionMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow97 = i112;
                        timeToInteractionMetric.gatewayIp = query.getString(i113);
                    }
                    int i114 = columnIndexOrThrow99;
                    if (query.isNull(i114)) {
                        columnIndexOrThrow98 = i113;
                        timeToInteractionMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow98 = i113;
                        timeToInteractionMetric.locationPermissionState = Integer.valueOf(query.getInt(i114));
                    }
                    int i115 = columnIndexOrThrow100;
                    if (query.isNull(i115)) {
                        columnIndexOrThrow99 = i114;
                        timeToInteractionMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow99 = i114;
                        timeToInteractionMetric.serviceStateStatus = Integer.valueOf(query.getInt(i115));
                    }
                    int i116 = columnIndexOrThrow101;
                    Integer valueOf12 = query.isNull(i116) ? null : Integer.valueOf(query.getInt(i116));
                    if (valueOf12 == null) {
                        columnIndexOrThrow101 = i116;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow101 = i116;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    timeToInteractionMetric.isNrCellSeen = bool12;
                    int i117 = columnIndexOrThrow102;
                    Integer valueOf13 = query.isNull(i117) ? null : Integer.valueOf(query.getInt(i117));
                    if (valueOf13 == null) {
                        columnIndexOrThrow102 = i117;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow102 = i117;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    timeToInteractionMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i118 = columnIndexOrThrow103;
                    if (query.isNull(i118)) {
                        columnIndexOrThrow100 = i115;
                        timeToInteractionMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow100 = i115;
                        timeToInteractionMetric.appVersionName = query.getString(i118);
                    }
                    int i119 = i90;
                    int i120 = columnIndexOrThrow104;
                    int i121 = i91;
                    timeToInteractionMetric.appVersionCode = query.getLong(i120);
                    int i122 = i118;
                    int i123 = columnIndexOrThrow105;
                    int i124 = i120;
                    timeToInteractionMetric.appLastUpdateTime = query.getLong(i123);
                    int i125 = columnIndexOrThrow106;
                    timeToInteractionMetric.duplexModeState = query.getInt(i125);
                    columnIndexOrThrow106 = i125;
                    int i126 = columnIndexOrThrow107;
                    timeToInteractionMetric.dozeModeState = query.getInt(i126);
                    columnIndexOrThrow107 = i126;
                    int i127 = columnIndexOrThrow108;
                    timeToInteractionMetric.callState = query.getInt(i127);
                    int i128 = columnIndexOrThrow109;
                    if (query.isNull(i128)) {
                        columnIndexOrThrow108 = i127;
                        timeToInteractionMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow108 = i127;
                        timeToInteractionMetric.buildDevice = query.getString(i128);
                    }
                    int i129 = columnIndexOrThrow110;
                    if (query.isNull(i129)) {
                        columnIndexOrThrow109 = i128;
                        timeToInteractionMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow109 = i128;
                        timeToInteractionMetric.buildHardware = query.getString(i129);
                    }
                    int i130 = columnIndexOrThrow111;
                    if (query.isNull(i130)) {
                        columnIndexOrThrow110 = i129;
                        timeToInteractionMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow110 = i129;
                        timeToInteractionMetric.buildProduct = query.getString(i130);
                    }
                    int i131 = columnIndexOrThrow112;
                    if (query.isNull(i131)) {
                        columnIndexOrThrow111 = i130;
                        timeToInteractionMetric.appId = null;
                    } else {
                        columnIndexOrThrow111 = i130;
                        timeToInteractionMetric.appId = query.getString(i131);
                    }
                    int i132 = columnIndexOrThrow113;
                    if (query.getInt(i132) != 0) {
                        columnIndexOrThrow112 = i131;
                        z = true;
                    } else {
                        columnIndexOrThrow112 = i131;
                        z = false;
                    }
                    timeToInteractionMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(timeToInteractionMetric);
                    columnIndexOrThrow113 = i132;
                    columnIndexOrThrow11 = i;
                    columnIndexOrThrow67 = i7;
                    i14 = i2;
                    columnIndexOrThrow14 = i18;
                    columnIndexOrThrow15 = i3;
                    columnIndexOrThrow17 = i39;
                    columnIndexOrThrow33 = i47;
                    columnIndexOrThrow36 = i5;
                    columnIndexOrThrow37 = i87;
                    columnIndexOrThrow75 = i8;
                    columnIndexOrThrow77 = i119;
                    columnIndexOrThrow103 = i122;
                    columnIndexOrThrow = i21;
                    columnIndexOrThrow16 = i4;
                    columnIndexOrThrow18 = i41;
                    columnIndexOrThrow34 = i44;
                    columnIndexOrThrow35 = i6;
                    columnIndexOrThrow38 = i89;
                    columnIndexOrThrow76 = i9;
                    columnIndexOrThrow78 = i121;
                    columnIndexOrThrow104 = i124;
                    columnIndexOrThrow105 = i123;
                    columnIndexOrThrow12 = i19;
                    int i133 = i10;
                    columnIndexOrThrow82 = i99;
                    columnIndexOrThrow81 = i133;
                    int i134 = i11;
                    columnIndexOrThrow89 = i12;
                    columnIndexOrThrow88 = i134;
                    int i135 = i13;
                    columnIndexOrThrow91 = i107;
                    columnIndexOrThrow90 = i135;
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
