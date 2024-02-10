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
import com.cellrebel.sdk.networking.beans.request.PageLoadMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PageLoadedMetricDAO_Impl implements PageLoadedMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<PageLoadMetric> b;
    private final EntityDeletionOrUpdateAdapter<PageLoadMetric> c;
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<PageLoadMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PageLoadMetric pageLoadMetric) {
            String str = pageLoadMetric.pageUrl;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) pageLoadMetric.pageSize);
            supportSQLiteStatement.bindLong(3, (long) pageLoadMetric.pageLoadTime);
            supportSQLiteStatement.bindLong(4, pageLoadMetric.firstByteTime);
            supportSQLiteStatement.bindLong(5, pageLoadMetric.isPageFailsToLoad ? 1 : 0);
            String str2 = pageLoadMetric.accessTechStart;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str2);
            }
            String str3 = pageLoadMetric.accessTechEnd;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            supportSQLiteStatement.bindLong(8, (long) pageLoadMetric.accessTechNumChanges);
            supportSQLiteStatement.bindLong(9, pageLoadMetric.bytesSent);
            supportSQLiteStatement.bindLong(10, pageLoadMetric.bytesReceived);
            supportSQLiteStatement.bindLong(11, pageLoadMetric.id);
            String str4 = pageLoadMetric.mobileClientId;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str4);
            }
            String str5 = pageLoadMetric.measurementSequenceId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str5);
            }
            String str6 = pageLoadMetric.clientIp;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str6);
            }
            String str7 = pageLoadMetric.dateTimeOfMeasurement;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str7);
            }
            supportSQLiteStatement.bindLong(16, (long) pageLoadMetric.stateDuringMeasurement);
            String str8 = pageLoadMetric.accessTechnology;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str8);
            }
            String str9 = pageLoadMetric.accessTypeRaw;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str9);
            }
            supportSQLiteStatement.bindLong(19, (long) pageLoadMetric.signalStrength);
            supportSQLiteStatement.bindLong(20, (long) pageLoadMetric.interference);
            String str10 = pageLoadMetric.simMCC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str10);
            }
            String str11 = pageLoadMetric.simMNC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str11);
            }
            String str12 = pageLoadMetric.secondarySimMCC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str12);
            }
            String str13 = pageLoadMetric.secondarySimMNC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str13);
            }
            supportSQLiteStatement.bindLong(25, (long) pageLoadMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(26, (long) pageLoadMetric.dataSimSlotNumber);
            String str14 = pageLoadMetric.networkMCC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str14);
            }
            String str15 = pageLoadMetric.networkMNC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str15);
            }
            supportSQLiteStatement.bindDouble(29, pageLoadMetric.latitude);
            supportSQLiteStatement.bindDouble(30, pageLoadMetric.longitude);
            supportSQLiteStatement.bindDouble(31, pageLoadMetric.gpsAccuracy);
            String str16 = pageLoadMetric.cellId;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str16);
            }
            String str17 = pageLoadMetric.lacId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str17);
            }
            String str18 = pageLoadMetric.deviceBrand;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str18);
            }
            String str19 = pageLoadMetric.deviceModel;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str19);
            }
            String str20 = pageLoadMetric.deviceVersion;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str20);
            }
            String str21 = pageLoadMetric.sdkVersionNumber;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str21);
            }
            String str22 = pageLoadMetric.carrierName;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str22);
            }
            String str23 = pageLoadMetric.secondaryCarrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str23);
            }
            String str24 = pageLoadMetric.networkOperatorName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str24);
            }
            String str25 = pageLoadMetric.os;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str25);
            }
            String str26 = pageLoadMetric.osVersion;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str26);
            }
            String str27 = pageLoadMetric.readableDate;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str27);
            }
            Integer num = pageLoadMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num.intValue());
            }
            Integer num2 = pageLoadMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num2.intValue());
            }
            Integer num3 = pageLoadMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num3.intValue());
            }
            String str28 = pageLoadMetric.cellBands;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str28);
            }
            Integer num4 = pageLoadMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num4.intValue());
            }
            Integer num5 = pageLoadMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num5.intValue());
            }
            Integer num6 = pageLoadMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num6.intValue());
            }
            Integer num7 = pageLoadMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num7.intValue());
            }
            Integer num8 = pageLoadMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num8.intValue());
            }
            Integer num9 = pageLoadMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num9.intValue());
            }
            Integer num10 = pageLoadMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num10.intValue());
            }
            Integer num11 = pageLoadMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num11.intValue());
            }
            Integer num12 = pageLoadMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num12.intValue());
            }
            Integer num13 = pageLoadMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num13.intValue());
            }
            Integer num14 = pageLoadMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num14.intValue());
            }
            Integer num15 = pageLoadMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num15.intValue());
            }
            Integer num16 = pageLoadMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num16.intValue());
            }
            String str29 = pageLoadMetric.debugString;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str29);
            }
            Boolean bool = pageLoadMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) valueOf.intValue());
            }
            Boolean bool2 = pageLoadMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) valueOf2.intValue());
            }
            Boolean bool3 = pageLoadMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) valueOf3.intValue());
            }
            String str30 = pageLoadMetric.nrState;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str30);
            }
            Integer num18 = pageLoadMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num18.intValue());
            }
            Boolean bool4 = pageLoadMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) valueOf4.intValue());
            }
            Integer num19 = pageLoadMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num19.intValue());
            }
            String str31 = pageLoadMetric.cellBandwidths;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindString(69, str31);
            }
            String str32 = pageLoadMetric.additionalPlmns;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str32);
            }
            supportSQLiteStatement.bindDouble(71, pageLoadMetric.altitude);
            Float f = pageLoadMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindDouble(72, (double) f.floatValue());
            }
            Float f2 = pageLoadMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindDouble(73, (double) f2.floatValue());
            }
            Float f3 = pageLoadMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindDouble(74, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(75, (long) pageLoadMetric.getRestrictBackgroundStatus);
            String str33 = pageLoadMetric.cellType;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str33);
            }
            Boolean bool5 = pageLoadMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf5.intValue());
            }
            Boolean bool6 = pageLoadMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf6.intValue());
            }
            Boolean bool7 = pageLoadMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf7.intValue());
            }
            Boolean bool8 = pageLoadMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(81, (long) pageLoadMetric.locationAge);
            Integer num20 = pageLoadMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) num20.intValue());
            }
            Integer num21 = pageLoadMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) num21.intValue());
            }
            Boolean bool9 = pageLoadMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindLong(84, (long) valueOf9.intValue());
            }
            String str34 = pageLoadMetric.sdkOrigin;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str34);
            }
            Boolean bool10 = pageLoadMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) valueOf10.intValue());
            }
            Boolean bool11 = pageLoadMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(88, (long) pageLoadMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(89, (long) pageLoadMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(90, (long) pageLoadMetric.latencyType);
            String str35 = pageLoadMetric.serverIp;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindString(91, str35);
            }
            String str36 = pageLoadMetric.privateIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindString(92, str36);
            }
            String str37 = pageLoadMetric.gatewayIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindString(93, str37);
            }
            Integer num22 = pageLoadMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) num22.intValue());
            }
            Integer num23 = pageLoadMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) num23.intValue());
            }
            Boolean bool12 = pageLoadMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) valueOf12.intValue());
            }
            Boolean bool13 = pageLoadMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num17.intValue());
            }
            String str38 = pageLoadMetric.appVersionName;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str38);
            }
            supportSQLiteStatement.bindLong(99, pageLoadMetric.appVersionCode);
            supportSQLiteStatement.bindLong(100, pageLoadMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(101, (long) pageLoadMetric.duplexModeState);
            supportSQLiteStatement.bindLong(102, (long) pageLoadMetric.dozeModeState);
            supportSQLiteStatement.bindLong(103, (long) pageLoadMetric.callState);
            String str39 = pageLoadMetric.buildDevice;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, str39);
            }
            String str40 = pageLoadMetric.buildHardware;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindString(105, str40);
            }
            String str41 = pageLoadMetric.buildProduct;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str41);
            }
            String str42 = pageLoadMetric.appId;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str42);
            }
            supportSQLiteStatement.bindLong(108, pageLoadMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `PageLoadMetric` (`pageUrl`,`pageSize`,`pageLoadTime`,`firstByteTime`,`isPageFailsToLoad`,`accessTechStart`,`accessTechEnd`,`accessTechNumChanges`,`bytesSent`,`bytesReceived`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<PageLoadMetric> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PageLoadMetric pageLoadMetric) {
            String str = pageLoadMetric.pageUrl;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) pageLoadMetric.pageSize);
            supportSQLiteStatement.bindLong(3, (long) pageLoadMetric.pageLoadTime);
            supportSQLiteStatement.bindLong(4, pageLoadMetric.firstByteTime);
            supportSQLiteStatement.bindLong(5, pageLoadMetric.isPageFailsToLoad ? 1 : 0);
            String str2 = pageLoadMetric.accessTechStart;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str2);
            }
            String str3 = pageLoadMetric.accessTechEnd;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            supportSQLiteStatement.bindLong(8, (long) pageLoadMetric.accessTechNumChanges);
            supportSQLiteStatement.bindLong(9, pageLoadMetric.bytesSent);
            supportSQLiteStatement.bindLong(10, pageLoadMetric.bytesReceived);
            supportSQLiteStatement.bindLong(11, pageLoadMetric.id);
            String str4 = pageLoadMetric.mobileClientId;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str4);
            }
            String str5 = pageLoadMetric.measurementSequenceId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str5);
            }
            String str6 = pageLoadMetric.clientIp;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str6);
            }
            String str7 = pageLoadMetric.dateTimeOfMeasurement;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str7);
            }
            supportSQLiteStatement.bindLong(16, (long) pageLoadMetric.stateDuringMeasurement);
            String str8 = pageLoadMetric.accessTechnology;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str8);
            }
            String str9 = pageLoadMetric.accessTypeRaw;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str9);
            }
            supportSQLiteStatement.bindLong(19, (long) pageLoadMetric.signalStrength);
            supportSQLiteStatement.bindLong(20, (long) pageLoadMetric.interference);
            String str10 = pageLoadMetric.simMCC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str10);
            }
            String str11 = pageLoadMetric.simMNC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str11);
            }
            String str12 = pageLoadMetric.secondarySimMCC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str12);
            }
            String str13 = pageLoadMetric.secondarySimMNC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str13);
            }
            supportSQLiteStatement.bindLong(25, (long) pageLoadMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(26, (long) pageLoadMetric.dataSimSlotNumber);
            String str14 = pageLoadMetric.networkMCC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str14);
            }
            String str15 = pageLoadMetric.networkMNC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str15);
            }
            supportSQLiteStatement.bindDouble(29, pageLoadMetric.latitude);
            supportSQLiteStatement.bindDouble(30, pageLoadMetric.longitude);
            supportSQLiteStatement.bindDouble(31, pageLoadMetric.gpsAccuracy);
            String str16 = pageLoadMetric.cellId;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str16);
            }
            String str17 = pageLoadMetric.lacId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str17);
            }
            String str18 = pageLoadMetric.deviceBrand;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str18);
            }
            String str19 = pageLoadMetric.deviceModel;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str19);
            }
            String str20 = pageLoadMetric.deviceVersion;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str20);
            }
            String str21 = pageLoadMetric.sdkVersionNumber;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str21);
            }
            String str22 = pageLoadMetric.carrierName;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str22);
            }
            String str23 = pageLoadMetric.secondaryCarrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str23);
            }
            String str24 = pageLoadMetric.networkOperatorName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str24);
            }
            String str25 = pageLoadMetric.os;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str25);
            }
            String str26 = pageLoadMetric.osVersion;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str26);
            }
            String str27 = pageLoadMetric.readableDate;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str27);
            }
            Integer num = pageLoadMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num.intValue());
            }
            Integer num2 = pageLoadMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num2.intValue());
            }
            Integer num3 = pageLoadMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num3.intValue());
            }
            String str28 = pageLoadMetric.cellBands;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str28);
            }
            Integer num4 = pageLoadMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num4.intValue());
            }
            Integer num5 = pageLoadMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num5.intValue());
            }
            Integer num6 = pageLoadMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num6.intValue());
            }
            Integer num7 = pageLoadMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num7.intValue());
            }
            Integer num8 = pageLoadMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num8.intValue());
            }
            Integer num9 = pageLoadMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num9.intValue());
            }
            Integer num10 = pageLoadMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num10.intValue());
            }
            Integer num11 = pageLoadMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num11.intValue());
            }
            Integer num12 = pageLoadMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num12.intValue());
            }
            Integer num13 = pageLoadMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num13.intValue());
            }
            Integer num14 = pageLoadMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num14.intValue());
            }
            Integer num15 = pageLoadMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num15.intValue());
            }
            Integer num16 = pageLoadMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num16.intValue());
            }
            String str29 = pageLoadMetric.debugString;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str29);
            }
            Boolean bool = pageLoadMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) valueOf.intValue());
            }
            Boolean bool2 = pageLoadMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) valueOf2.intValue());
            }
            Boolean bool3 = pageLoadMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) valueOf3.intValue());
            }
            String str30 = pageLoadMetric.nrState;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, str30);
            }
            Integer num18 = pageLoadMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num18.intValue());
            }
            Boolean bool4 = pageLoadMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) valueOf4.intValue());
            }
            Integer num19 = pageLoadMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num19.intValue());
            }
            String str31 = pageLoadMetric.cellBandwidths;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindString(69, str31);
            }
            String str32 = pageLoadMetric.additionalPlmns;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str32);
            }
            supportSQLiteStatement.bindDouble(71, pageLoadMetric.altitude);
            Float f = pageLoadMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindDouble(72, (double) f.floatValue());
            }
            Float f2 = pageLoadMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindDouble(73, (double) f2.floatValue());
            }
            Float f3 = pageLoadMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindDouble(74, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(75, (long) pageLoadMetric.getRestrictBackgroundStatus);
            String str33 = pageLoadMetric.cellType;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str33);
            }
            Boolean bool5 = pageLoadMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf5.intValue());
            }
            Boolean bool6 = pageLoadMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf6.intValue());
            }
            Boolean bool7 = pageLoadMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf7.intValue());
            }
            Boolean bool8 = pageLoadMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(81, (long) pageLoadMetric.locationAge);
            Integer num20 = pageLoadMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) num20.intValue());
            }
            Integer num21 = pageLoadMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) num21.intValue());
            }
            Boolean bool9 = pageLoadMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindLong(84, (long) valueOf9.intValue());
            }
            String str34 = pageLoadMetric.sdkOrigin;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str34);
            }
            Boolean bool10 = pageLoadMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) valueOf10.intValue());
            }
            Boolean bool11 = pageLoadMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(88, (long) pageLoadMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(89, (long) pageLoadMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(90, (long) pageLoadMetric.latencyType);
            String str35 = pageLoadMetric.serverIp;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindString(91, str35);
            }
            String str36 = pageLoadMetric.privateIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindString(92, str36);
            }
            String str37 = pageLoadMetric.gatewayIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindString(93, str37);
            }
            Integer num22 = pageLoadMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) num22.intValue());
            }
            Integer num23 = pageLoadMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) num23.intValue());
            }
            Boolean bool12 = pageLoadMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) valueOf12.intValue());
            }
            Boolean bool13 = pageLoadMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num17.intValue());
            }
            String str38 = pageLoadMetric.appVersionName;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str38);
            }
            supportSQLiteStatement.bindLong(99, pageLoadMetric.appVersionCode);
            supportSQLiteStatement.bindLong(100, pageLoadMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(101, (long) pageLoadMetric.duplexModeState);
            supportSQLiteStatement.bindLong(102, (long) pageLoadMetric.dozeModeState);
            supportSQLiteStatement.bindLong(103, (long) pageLoadMetric.callState);
            String str39 = pageLoadMetric.buildDevice;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, str39);
            }
            String str40 = pageLoadMetric.buildHardware;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindString(105, str40);
            }
            String str41 = pageLoadMetric.buildProduct;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str41);
            }
            String str42 = pageLoadMetric.appId;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str42);
            }
            supportSQLiteStatement.bindLong(108, pageLoadMetric.isSending ? 1 : 0);
            supportSQLiteStatement.bindLong(109, pageLoadMetric.id);
        }

        public String createQuery() {
            return "UPDATE OR ABORT `PageLoadMetric` SET `pageUrl` = ?,`pageSize` = ?,`pageLoadTime` = ?,`firstByteTime` = ?,`isPageFailsToLoad` = ?,`accessTechStart` = ?,`accessTechEnd` = ?,`accessTechNumChanges` = ?,`bytesSent` = ?,`bytesReceived` = ?,`id` = ?,`mobileClientId` = ?,`measurementSequenceId` = ?,`clientIp` = ?,`dateTimeOfMeasurement` = ?,`stateDuringMeasurement` = ?,`accessTechnology` = ?,`accessTypeRaw` = ?,`signalStrength` = ?,`interference` = ?,`simMCC` = ?,`simMNC` = ?,`secondarySimMCC` = ?,`secondarySimMNC` = ?,`numberOfSimSlots` = ?,`dataSimSlotNumber` = ?,`networkMCC` = ?,`networkMNC` = ?,`latitude` = ?,`longitude` = ?,`gpsAccuracy` = ?,`cellId` = ?,`lacId` = ?,`deviceBrand` = ?,`deviceModel` = ?,`deviceVersion` = ?,`sdkVersionNumber` = ?,`carrierName` = ?,`secondaryCarrierName` = ?,`networkOperatorName` = ?,`os` = ?,`osVersion` = ?,`readableDate` = ?,`physicalCellId` = ?,`absoluteRfChannelNumber` = ?,`connectionAbsoluteRfChannelNumber` = ?,`cellBands` = ?,`channelQualityIndicator` = ?,`referenceSignalSignalToNoiseRatio` = ?,`referenceSignalReceivedPower` = ?,`referenceSignalReceivedQuality` = ?,`csiReferenceSignalReceivedPower` = ?,`csiReferenceSignalToNoiseAndInterferenceRatio` = ?,`csiReferenceSignalReceivedQuality` = ?,`ssReferenceSignalReceivedPower` = ?,`ssReferenceSignalReceivedQuality` = ?,`ssReferenceSignalToNoiseAndInterferenceRatio` = ?,`timingAdvance` = ?,`signalStrengthAsu` = ?,`dbm` = ?,`debugString` = ?,`isDcNrRestricted` = ?,`isNrAvailable` = ?,`isEnDcAvailable` = ?,`nrState` = ?,`nrFrequencyRange` = ?,`isUsingCarrierAggregation` = ?,`vopsSupport` = ?,`cellBandwidths` = ?,`additionalPlmns` = ?,`altitude` = ?,`locationSpeed` = ?,`locationSpeedAccuracy` = ?,`gpsVerticalAccuracy` = ?,`getRestrictBackgroundStatus` = ?,`cellType` = ?,`isDefaultNetworkActive` = ?,`isActiveNetworkMetered` = ?,`isOnScreen` = ?,`isRoaming` = ?,`locationAge` = ?,`overrideNetworkType` = ?,`accessNetworkTechnologyRaw` = ?,`anonymize` = ?,`sdkOrigin` = ?,`isRooted` = ?,`isConnectedToVpn` = ?,`linkDownstreamBandwidth` = ?,`linkUpstreamBandwidth` = ?,`latencyType` = ?,`serverIp` = ?,`privateIp` = ?,`gatewayIp` = ?,`locationPermissionState` = ?,`serviceStateStatus` = ?,`isNrCellSeen` = ?,`isReadPhoneStatePermissionGranted` = ?,`appVersionName` = ?,`appVersionCode` = ?,`appLastUpdateTime` = ?,`duplexModeState` = ?,`dozeModeState` = ?,`callState` = ?,`buildDevice` = ?,`buildHardware` = ?,`buildProduct` = ?,`appId` = ?,`isSending` = ? WHERE `id` = ?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM pageloadmetric";
        }
    }

    public PageLoadedMetricDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    public void a(PageLoadMetric pageLoadMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(pageLoadMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<PageLoadMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<PageLoadMetric> b() {
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
        int i9;
        int i10;
        int i11;
        int i12;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i13;
        int i14;
        int i15;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i16;
        Boolean bool9;
        int i17;
        int i18;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from pageloadmetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "pageUrl");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "pageSize");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "firstByteTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isPageFailsToLoad");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "accessTechStart");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "accessTechEnd");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "accessTechNumChanges");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "bytesSent");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "bytesReceived");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i19 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    PageLoadMetric pageLoadMetric = new PageLoadMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        pageLoadMetric.pageUrl = null;
                    } else {
                        arrayList = arrayList2;
                        pageLoadMetric.pageUrl = query.getString(columnIndexOrThrow);
                    }
                    pageLoadMetric.pageSize = query.getInt(columnIndexOrThrow2);
                    pageLoadMetric.pageLoadTime = query.getInt(columnIndexOrThrow3);
                    int i20 = columnIndexOrThrow;
                    int i21 = columnIndexOrThrow2;
                    pageLoadMetric.firstByteTime = query.getLong(columnIndexOrThrow4);
                    pageLoadMetric.isPageFailsToLoad = query.getInt(columnIndexOrThrow5) != 0;
                    if (query.isNull(columnIndexOrThrow6)) {
                        pageLoadMetric.accessTechStart = null;
                    } else {
                        pageLoadMetric.accessTechStart = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        pageLoadMetric.accessTechEnd = null;
                    } else {
                        pageLoadMetric.accessTechEnd = query.getString(columnIndexOrThrow7);
                    }
                    pageLoadMetric.accessTechNumChanges = query.getInt(columnIndexOrThrow8);
                    int i22 = columnIndexOrThrow3;
                    pageLoadMetric.bytesSent = query.getLong(columnIndexOrThrow9);
                    pageLoadMetric.bytesReceived = query.getLong(columnIndexOrThrow10);
                    pageLoadMetric.id = query.getLong(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        pageLoadMetric.mobileClientId = null;
                    } else {
                        pageLoadMetric.mobileClientId = query.getString(columnIndexOrThrow12);
                    }
                    int i23 = i19;
                    if (query.isNull(i23)) {
                        pageLoadMetric.measurementSequenceId = null;
                    } else {
                        pageLoadMetric.measurementSequenceId = query.getString(i23);
                    }
                    int i24 = columnIndexOrThrow14;
                    if (query.isNull(i24)) {
                        i = i20;
                        pageLoadMetric.clientIp = null;
                    } else {
                        i = i20;
                        pageLoadMetric.clientIp = query.getString(i24);
                    }
                    int i25 = columnIndexOrThrow15;
                    if (query.isNull(i25)) {
                        i2 = columnIndexOrThrow11;
                        pageLoadMetric.dateTimeOfMeasurement = null;
                    } else {
                        i2 = columnIndexOrThrow11;
                        pageLoadMetric.dateTimeOfMeasurement = query.getString(i25);
                    }
                    int i26 = columnIndexOrThrow16;
                    int i27 = i25;
                    pageLoadMetric.stateDuringMeasurement = query.getInt(i26);
                    int i28 = columnIndexOrThrow17;
                    if (query.isNull(i28)) {
                        i3 = i26;
                        pageLoadMetric.accessTechnology = null;
                    } else {
                        i3 = i26;
                        pageLoadMetric.accessTechnology = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow18;
                    if (query.isNull(i29)) {
                        i4 = i28;
                        pageLoadMetric.accessTypeRaw = null;
                    } else {
                        i4 = i28;
                        pageLoadMetric.accessTypeRaw = query.getString(i29);
                    }
                    int i30 = columnIndexOrThrow19;
                    int i31 = i29;
                    pageLoadMetric.signalStrength = query.getInt(i30);
                    int i32 = columnIndexOrThrow20;
                    int i33 = i30;
                    pageLoadMetric.interference = query.getInt(i32);
                    int i34 = columnIndexOrThrow21;
                    if (query.isNull(i34)) {
                        i5 = i32;
                        pageLoadMetric.simMCC = null;
                    } else {
                        i5 = i32;
                        pageLoadMetric.simMCC = query.getString(i34);
                    }
                    int i35 = columnIndexOrThrow22;
                    if (query.isNull(i35)) {
                        i6 = i34;
                        pageLoadMetric.simMNC = null;
                    } else {
                        i6 = i34;
                        pageLoadMetric.simMNC = query.getString(i35);
                    }
                    int i36 = columnIndexOrThrow23;
                    if (query.isNull(i36)) {
                        i7 = i35;
                        pageLoadMetric.secondarySimMCC = null;
                    } else {
                        i7 = i35;
                        pageLoadMetric.secondarySimMCC = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow24;
                    if (query.isNull(i37)) {
                        i8 = i36;
                        pageLoadMetric.secondarySimMNC = null;
                    } else {
                        i8 = i36;
                        pageLoadMetric.secondarySimMNC = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow25;
                    int i39 = i37;
                    pageLoadMetric.numberOfSimSlots = query.getInt(i38);
                    int i40 = columnIndexOrThrow26;
                    int i41 = i38;
                    pageLoadMetric.dataSimSlotNumber = query.getInt(i40);
                    int i42 = columnIndexOrThrow27;
                    if (query.isNull(i42)) {
                        i9 = i40;
                        pageLoadMetric.networkMCC = null;
                    } else {
                        i9 = i40;
                        pageLoadMetric.networkMCC = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow28;
                    if (query.isNull(i43)) {
                        i10 = i42;
                        pageLoadMetric.networkMNC = null;
                    } else {
                        i10 = i42;
                        pageLoadMetric.networkMNC = query.getString(i43);
                    }
                    int i44 = i22;
                    int i45 = columnIndexOrThrow29;
                    int i46 = columnIndexOrThrow12;
                    pageLoadMetric.latitude = query.getDouble(i45);
                    int i47 = i43;
                    int i48 = columnIndexOrThrow30;
                    int i49 = i45;
                    pageLoadMetric.longitude = query.getDouble(i48);
                    int i50 = i48;
                    int i51 = columnIndexOrThrow31;
                    int i52 = i47;
                    pageLoadMetric.gpsAccuracy = query.getDouble(i51);
                    int i53 = columnIndexOrThrow32;
                    if (query.isNull(i53)) {
                        pageLoadMetric.cellId = null;
                    } else {
                        pageLoadMetric.cellId = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow33;
                    if (query.isNull(i54)) {
                        i11 = i51;
                        pageLoadMetric.lacId = null;
                    } else {
                        i11 = i51;
                        pageLoadMetric.lacId = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow34;
                    if (query.isNull(i55)) {
                        i12 = i50;
                        pageLoadMetric.deviceBrand = null;
                    } else {
                        i12 = i50;
                        pageLoadMetric.deviceBrand = query.getString(i55);
                    }
                    int i56 = columnIndexOrThrow35;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow34 = i55;
                        pageLoadMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow34 = i55;
                        pageLoadMetric.deviceModel = query.getString(i56);
                    }
                    int i57 = columnIndexOrThrow36;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow35 = i56;
                        pageLoadMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow35 = i56;
                        pageLoadMetric.deviceVersion = query.getString(i57);
                    }
                    int i58 = columnIndexOrThrow37;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow36 = i57;
                        pageLoadMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow36 = i57;
                        pageLoadMetric.sdkVersionNumber = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow38;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow37 = i58;
                        pageLoadMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow37 = i58;
                        pageLoadMetric.carrierName = query.getString(i59);
                    }
                    int i60 = columnIndexOrThrow39;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow38 = i59;
                        pageLoadMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow38 = i59;
                        pageLoadMetric.secondaryCarrierName = query.getString(i60);
                    }
                    int i61 = columnIndexOrThrow40;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow39 = i60;
                        pageLoadMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow39 = i60;
                        pageLoadMetric.networkOperatorName = query.getString(i61);
                    }
                    int i62 = columnIndexOrThrow41;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow40 = i61;
                        pageLoadMetric.os = null;
                    } else {
                        columnIndexOrThrow40 = i61;
                        pageLoadMetric.os = query.getString(i62);
                    }
                    int i63 = columnIndexOrThrow42;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow41 = i62;
                        pageLoadMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow41 = i62;
                        pageLoadMetric.osVersion = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow43;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow42 = i63;
                        pageLoadMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow42 = i63;
                        pageLoadMetric.readableDate = query.getString(i64);
                    }
                    int i65 = columnIndexOrThrow44;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow43 = i64;
                        pageLoadMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow43 = i64;
                        pageLoadMetric.physicalCellId = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow45;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow44 = i65;
                        pageLoadMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow44 = i65;
                        pageLoadMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow46;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow45 = i66;
                        pageLoadMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow45 = i66;
                        pageLoadMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow47;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow46 = i67;
                        pageLoadMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow46 = i67;
                        pageLoadMetric.cellBands = query.getString(i68);
                    }
                    int i69 = columnIndexOrThrow48;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow47 = i68;
                        pageLoadMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow47 = i68;
                        pageLoadMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow49;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow48 = i69;
                        pageLoadMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow48 = i69;
                        pageLoadMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow50;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow49 = i70;
                        pageLoadMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow49 = i70;
                        pageLoadMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow51;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow50 = i71;
                        pageLoadMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow50 = i71;
                        pageLoadMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i72));
                    }
                    int i73 = columnIndexOrThrow52;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow51 = i72;
                        pageLoadMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow51 = i72;
                        pageLoadMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i73));
                    }
                    int i74 = columnIndexOrThrow53;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow52 = i73;
                        pageLoadMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow52 = i73;
                        pageLoadMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i74));
                    }
                    int i75 = columnIndexOrThrow54;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow53 = i74;
                        pageLoadMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow53 = i74;
                        pageLoadMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i75));
                    }
                    int i76 = columnIndexOrThrow55;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow54 = i75;
                        pageLoadMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow54 = i75;
                        pageLoadMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow56;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow55 = i76;
                        pageLoadMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow55 = i76;
                        pageLoadMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow57;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow56 = i77;
                        pageLoadMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow56 = i77;
                        pageLoadMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i78));
                    }
                    int i79 = columnIndexOrThrow58;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow57 = i78;
                        pageLoadMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow57 = i78;
                        pageLoadMetric.timingAdvance = Integer.valueOf(query.getInt(i79));
                    }
                    int i80 = columnIndexOrThrow59;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow58 = i79;
                        pageLoadMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow58 = i79;
                        pageLoadMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i80));
                    }
                    int i81 = columnIndexOrThrow60;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow59 = i80;
                        pageLoadMetric.dbm = null;
                    } else {
                        columnIndexOrThrow59 = i80;
                        pageLoadMetric.dbm = Integer.valueOf(query.getInt(i81));
                    }
                    int i82 = columnIndexOrThrow61;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow60 = i81;
                        pageLoadMetric.debugString = null;
                    } else {
                        columnIndexOrThrow60 = i81;
                        pageLoadMetric.debugString = query.getString(i82);
                    }
                    int i83 = columnIndexOrThrow62;
                    Integer valueOf = query.isNull(i83) ? null : Integer.valueOf(query.getInt(i83));
                    if (valueOf == null) {
                        columnIndexOrThrow62 = i83;
                        bool = null;
                    } else {
                        columnIndexOrThrow62 = i83;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    pageLoadMetric.isDcNrRestricted = bool;
                    int i84 = columnIndexOrThrow63;
                    Integer valueOf2 = query.isNull(i84) ? null : Integer.valueOf(query.getInt(i84));
                    if (valueOf2 == null) {
                        columnIndexOrThrow63 = i84;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow63 = i84;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    pageLoadMetric.isNrAvailable = bool2;
                    int i85 = columnIndexOrThrow64;
                    Integer valueOf3 = query.isNull(i85) ? null : Integer.valueOf(query.getInt(i85));
                    if (valueOf3 == null) {
                        columnIndexOrThrow64 = i85;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow64 = i85;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    pageLoadMetric.isEnDcAvailable = bool3;
                    int i86 = columnIndexOrThrow65;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow61 = i82;
                        pageLoadMetric.nrState = null;
                    } else {
                        columnIndexOrThrow61 = i82;
                        pageLoadMetric.nrState = query.getString(i86);
                    }
                    int i87 = columnIndexOrThrow66;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow65 = i86;
                        pageLoadMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow65 = i86;
                        pageLoadMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow67;
                    Integer valueOf4 = query.isNull(i88) ? null : Integer.valueOf(query.getInt(i88));
                    if (valueOf4 == null) {
                        columnIndexOrThrow67 = i88;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow67 = i88;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    pageLoadMetric.isUsingCarrierAggregation = bool4;
                    int i89 = columnIndexOrThrow68;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow66 = i87;
                        pageLoadMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow66 = i87;
                        pageLoadMetric.vopsSupport = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow69;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow68 = i89;
                        pageLoadMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow68 = i89;
                        pageLoadMetric.cellBandwidths = query.getString(i90);
                    }
                    int i91 = columnIndexOrThrow70;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow69 = i90;
                        pageLoadMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow69 = i90;
                        pageLoadMetric.additionalPlmns = query.getString(i91);
                    }
                    int i92 = i53;
                    int i93 = columnIndexOrThrow71;
                    int i94 = i54;
                    pageLoadMetric.altitude = query.getDouble(i93);
                    int i95 = columnIndexOrThrow72;
                    if (query.isNull(i95)) {
                        pageLoadMetric.locationSpeed = null;
                    } else {
                        pageLoadMetric.locationSpeed = Float.valueOf(query.getFloat(i95));
                    }
                    int i96 = columnIndexOrThrow73;
                    if (query.isNull(i96)) {
                        i13 = i91;
                        pageLoadMetric.locationSpeedAccuracy = null;
                    } else {
                        i13 = i91;
                        pageLoadMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i96));
                    }
                    int i97 = columnIndexOrThrow74;
                    if (query.isNull(i97)) {
                        i14 = i93;
                        pageLoadMetric.gpsVerticalAccuracy = null;
                    } else {
                        i14 = i93;
                        pageLoadMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i97));
                    }
                    columnIndexOrThrow74 = i97;
                    int i98 = columnIndexOrThrow75;
                    pageLoadMetric.getRestrictBackgroundStatus = query.getInt(i98);
                    int i99 = columnIndexOrThrow76;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow75 = i98;
                        pageLoadMetric.cellType = null;
                    } else {
                        columnIndexOrThrow75 = i98;
                        pageLoadMetric.cellType = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow77;
                    Integer valueOf5 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf5 == null) {
                        i15 = i99;
                        bool5 = null;
                    } else {
                        i15 = i99;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    pageLoadMetric.isDefaultNetworkActive = bool5;
                    int i101 = columnIndexOrThrow78;
                    Integer valueOf6 = query.isNull(i101) ? null : Integer.valueOf(query.getInt(i101));
                    if (valueOf6 == null) {
                        columnIndexOrThrow78 = i101;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow78 = i101;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    pageLoadMetric.isActiveNetworkMetered = bool6;
                    int i102 = columnIndexOrThrow79;
                    Integer valueOf7 = query.isNull(i102) ? null : Integer.valueOf(query.getInt(i102));
                    if (valueOf7 == null) {
                        columnIndexOrThrow79 = i102;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow79 = i102;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    pageLoadMetric.isOnScreen = bool7;
                    int i103 = columnIndexOrThrow80;
                    Integer valueOf8 = query.isNull(i103) ? null : Integer.valueOf(query.getInt(i103));
                    if (valueOf8 == null) {
                        columnIndexOrThrow80 = i103;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow80 = i103;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    pageLoadMetric.isRoaming = bool8;
                    int i104 = i100;
                    int i105 = columnIndexOrThrow81;
                    pageLoadMetric.locationAge = query.getInt(i105);
                    int i106 = columnIndexOrThrow82;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow81 = i105;
                        pageLoadMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow81 = i105;
                        pageLoadMetric.overrideNetworkType = Integer.valueOf(query.getInt(i106));
                    }
                    int i107 = columnIndexOrThrow83;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow82 = i106;
                        pageLoadMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow82 = i106;
                        pageLoadMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i107));
                    }
                    int i108 = columnIndexOrThrow84;
                    Integer valueOf9 = query.isNull(i108) ? null : Integer.valueOf(query.getInt(i108));
                    if (valueOf9 == null) {
                        i16 = i107;
                        bool9 = null;
                    } else {
                        i16 = i107;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    pageLoadMetric.anonymize = bool9;
                    int i109 = columnIndexOrThrow85;
                    if (query.isNull(i109)) {
                        i17 = i108;
                        pageLoadMetric.sdkOrigin = null;
                    } else {
                        i17 = i108;
                        pageLoadMetric.sdkOrigin = query.getString(i109);
                    }
                    int i110 = columnIndexOrThrow86;
                    Integer valueOf10 = query.isNull(i110) ? null : Integer.valueOf(query.getInt(i110));
                    if (valueOf10 == null) {
                        i18 = i109;
                        bool10 = null;
                    } else {
                        i18 = i109;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    pageLoadMetric.isRooted = bool10;
                    int i111 = columnIndexOrThrow87;
                    Integer valueOf11 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf11 == null) {
                        columnIndexOrThrow87 = i111;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow87 = i111;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    pageLoadMetric.isConnectedToVpn = bool11;
                    int i112 = i110;
                    int i113 = columnIndexOrThrow88;
                    pageLoadMetric.linkDownstreamBandwidth = query.getInt(i113);
                    columnIndexOrThrow88 = i113;
                    int i114 = columnIndexOrThrow89;
                    pageLoadMetric.linkUpstreamBandwidth = query.getInt(i114);
                    columnIndexOrThrow89 = i114;
                    int i115 = columnIndexOrThrow90;
                    pageLoadMetric.latencyType = query.getInt(i115);
                    int i116 = columnIndexOrThrow91;
                    if (query.isNull(i116)) {
                        columnIndexOrThrow90 = i115;
                        pageLoadMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow90 = i115;
                        pageLoadMetric.serverIp = query.getString(i116);
                    }
                    int i117 = columnIndexOrThrow92;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow91 = i116;
                        pageLoadMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow91 = i116;
                        pageLoadMetric.privateIp = query.getString(i117);
                    }
                    int i118 = columnIndexOrThrow93;
                    if (query.isNull(i118)) {
                        columnIndexOrThrow92 = i117;
                        pageLoadMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow92 = i117;
                        pageLoadMetric.gatewayIp = query.getString(i118);
                    }
                    int i119 = columnIndexOrThrow94;
                    if (query.isNull(i119)) {
                        columnIndexOrThrow93 = i118;
                        pageLoadMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow93 = i118;
                        pageLoadMetric.locationPermissionState = Integer.valueOf(query.getInt(i119));
                    }
                    int i120 = columnIndexOrThrow95;
                    if (query.isNull(i120)) {
                        columnIndexOrThrow94 = i119;
                        pageLoadMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow94 = i119;
                        pageLoadMetric.serviceStateStatus = Integer.valueOf(query.getInt(i120));
                    }
                    int i121 = columnIndexOrThrow96;
                    Integer valueOf12 = query.isNull(i121) ? null : Integer.valueOf(query.getInt(i121));
                    if (valueOf12 == null) {
                        columnIndexOrThrow96 = i121;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow96 = i121;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    pageLoadMetric.isNrCellSeen = bool12;
                    int i122 = columnIndexOrThrow97;
                    Integer valueOf13 = query.isNull(i122) ? null : Integer.valueOf(query.getInt(i122));
                    if (valueOf13 == null) {
                        columnIndexOrThrow97 = i122;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow97 = i122;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    pageLoadMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i123 = columnIndexOrThrow98;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow95 = i120;
                        pageLoadMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow95 = i120;
                        pageLoadMetric.appVersionName = query.getString(i123);
                    }
                    int i124 = i95;
                    int i125 = columnIndexOrThrow99;
                    int i126 = i96;
                    pageLoadMetric.appVersionCode = query.getLong(i125);
                    int i127 = i123;
                    int i128 = columnIndexOrThrow100;
                    int i129 = i125;
                    pageLoadMetric.appLastUpdateTime = query.getLong(i128);
                    int i130 = columnIndexOrThrow101;
                    pageLoadMetric.duplexModeState = query.getInt(i130);
                    columnIndexOrThrow101 = i130;
                    int i131 = columnIndexOrThrow102;
                    pageLoadMetric.dozeModeState = query.getInt(i131);
                    columnIndexOrThrow102 = i131;
                    int i132 = columnIndexOrThrow103;
                    pageLoadMetric.callState = query.getInt(i132);
                    int i133 = columnIndexOrThrow104;
                    if (query.isNull(i133)) {
                        columnIndexOrThrow103 = i132;
                        pageLoadMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow103 = i132;
                        pageLoadMetric.buildDevice = query.getString(i133);
                    }
                    int i134 = columnIndexOrThrow105;
                    if (query.isNull(i134)) {
                        columnIndexOrThrow104 = i133;
                        pageLoadMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow104 = i133;
                        pageLoadMetric.buildHardware = query.getString(i134);
                    }
                    int i135 = columnIndexOrThrow106;
                    if (query.isNull(i135)) {
                        columnIndexOrThrow105 = i134;
                        pageLoadMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow105 = i134;
                        pageLoadMetric.buildProduct = query.getString(i135);
                    }
                    int i136 = columnIndexOrThrow107;
                    if (query.isNull(i136)) {
                        columnIndexOrThrow106 = i135;
                        pageLoadMetric.appId = null;
                    } else {
                        columnIndexOrThrow106 = i135;
                        pageLoadMetric.appId = query.getString(i136);
                    }
                    int i137 = columnIndexOrThrow108;
                    if (query.getInt(i137) != 0) {
                        columnIndexOrThrow107 = i136;
                        z = true;
                    } else {
                        columnIndexOrThrow107 = i136;
                        z = false;
                    }
                    pageLoadMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(pageLoadMetric);
                    columnIndexOrThrow108 = i137;
                    columnIndexOrThrow11 = i2;
                    columnIndexOrThrow15 = i27;
                    columnIndexOrThrow16 = i3;
                    columnIndexOrThrow17 = i4;
                    columnIndexOrThrow18 = i31;
                    columnIndexOrThrow19 = i33;
                    columnIndexOrThrow20 = i5;
                    columnIndexOrThrow21 = i6;
                    columnIndexOrThrow22 = i7;
                    columnIndexOrThrow23 = i8;
                    columnIndexOrThrow24 = i39;
                    columnIndexOrThrow25 = i41;
                    columnIndexOrThrow26 = i9;
                    columnIndexOrThrow27 = i10;
                    columnIndexOrThrow28 = i52;
                    columnIndexOrThrow31 = i11;
                    columnIndexOrThrow32 = i92;
                    columnIndexOrThrow70 = i13;
                    columnIndexOrThrow72 = i124;
                    columnIndexOrThrow98 = i127;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow14 = i24;
                    columnIndexOrThrow3 = i44;
                    i19 = i23;
                    columnIndexOrThrow2 = i21;
                    int i138 = i129;
                    columnIndexOrThrow100 = i128;
                    columnIndexOrThrow12 = i46;
                    columnIndexOrThrow29 = i49;
                    columnIndexOrThrow30 = i12;
                    columnIndexOrThrow33 = i94;
                    columnIndexOrThrow71 = i14;
                    columnIndexOrThrow73 = i126;
                    columnIndexOrThrow99 = i138;
                    int i139 = i15;
                    columnIndexOrThrow77 = i104;
                    columnIndexOrThrow76 = i139;
                    int i140 = i16;
                    columnIndexOrThrow84 = i17;
                    columnIndexOrThrow83 = i140;
                    int i141 = i18;
                    columnIndexOrThrow86 = i112;
                    columnIndexOrThrow85 = i141;
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
