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
import com.cellrebel.sdk.networking.beans.request.VideoMetric;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class VideoMetricDAO_Impl implements VideoMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<VideoMetric> b;
    private final EntityDeletionOrUpdateAdapter<VideoMetric> c;
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<VideoMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoMetric videoMetric) {
            String str = videoMetric.videoSource;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = videoMetric.fileUrl;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, videoMetric.videoInitialBufferingTime);
            supportSQLiteStatement.bindLong(4, videoMetric.videoRebufferingTime);
            supportSQLiteStatement.bindLong(5, (long) videoMetric.videoRebufferingCount);
            supportSQLiteStatement.bindLong(6, videoMetric.isVideoFailsToStart ? 1 : 0);
            supportSQLiteStatement.bindLong(7, videoMetric.videoTimeToStart);
            supportSQLiteStatement.bindLong(8, videoMetric.inStreamFailure ? 1 : 0);
            supportSQLiteStatement.bindLong(9, (long) videoMetric.videoLength);
            supportSQLiteStatement.bindLong(10, videoMetric.videoQualityTime144p);
            supportSQLiteStatement.bindLong(11, videoMetric.videoQualityTime240p);
            supportSQLiteStatement.bindLong(12, videoMetric.videoQualityTime360p);
            supportSQLiteStatement.bindLong(13, videoMetric.videoQualityTime480p);
            supportSQLiteStatement.bindLong(14, videoMetric.videoQualityTime720p);
            supportSQLiteStatement.bindLong(15, videoMetric.videoQualityTime1080p);
            supportSQLiteStatement.bindLong(16, videoMetric.videoQualityTime1440p);
            supportSQLiteStatement.bindLong(17, videoMetric.videoQualityTime2160p);
            supportSQLiteStatement.bindLong(18, videoMetric.videoQualityTimeHighRes);
            supportSQLiteStatement.bindLong(19, videoMetric.videoQualityTimeDefault);
            supportSQLiteStatement.bindLong(20, videoMetric.videoQualityTimeUnknown);
            String str3 = videoMetric.accessTechStart;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str3);
            }
            String str4 = videoMetric.accessTechEnd;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str4);
            }
            supportSQLiteStatement.bindLong(23, (long) videoMetric.accessTechNumChanges);
            supportSQLiteStatement.bindLong(24, videoMetric.bytesSent);
            supportSQLiteStatement.bindLong(25, videoMetric.bytesReceived);
            supportSQLiteStatement.bindLong(26, videoMetric.id);
            String str5 = videoMetric.mobileClientId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str5);
            }
            String str6 = videoMetric.measurementSequenceId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str6);
            }
            String str7 = videoMetric.clientIp;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str7);
            }
            String str8 = videoMetric.dateTimeOfMeasurement;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str8);
            }
            supportSQLiteStatement.bindLong(31, (long) videoMetric.stateDuringMeasurement);
            String str9 = videoMetric.accessTechnology;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str9);
            }
            String str10 = videoMetric.accessTypeRaw;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str10);
            }
            supportSQLiteStatement.bindLong(34, (long) videoMetric.signalStrength);
            supportSQLiteStatement.bindLong(35, (long) videoMetric.interference);
            String str11 = videoMetric.simMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str11);
            }
            String str12 = videoMetric.simMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str12);
            }
            String str13 = videoMetric.secondarySimMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str13);
            }
            String str14 = videoMetric.secondarySimMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str14);
            }
            supportSQLiteStatement.bindLong(40, (long) videoMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(41, (long) videoMetric.dataSimSlotNumber);
            String str15 = videoMetric.networkMCC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str15);
            }
            String str16 = videoMetric.networkMNC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str16);
            }
            supportSQLiteStatement.bindDouble(44, videoMetric.latitude);
            supportSQLiteStatement.bindDouble(45, videoMetric.longitude);
            supportSQLiteStatement.bindDouble(46, videoMetric.gpsAccuracy);
            String str17 = videoMetric.cellId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str17);
            }
            String str18 = videoMetric.lacId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str18);
            }
            String str19 = videoMetric.deviceBrand;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str19);
            }
            String str20 = videoMetric.deviceModel;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str20);
            }
            String str21 = videoMetric.deviceVersion;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str21);
            }
            String str22 = videoMetric.sdkVersionNumber;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str22);
            }
            String str23 = videoMetric.carrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str23);
            }
            String str24 = videoMetric.secondaryCarrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str24);
            }
            String str25 = videoMetric.networkOperatorName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str25);
            }
            String str26 = videoMetric.os;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str26);
            }
            String str27 = videoMetric.osVersion;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str27);
            }
            String str28 = videoMetric.readableDate;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str28);
            }
            Integer num = videoMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num.intValue());
            }
            Integer num2 = videoMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num2.intValue());
            }
            Integer num3 = videoMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num3.intValue());
            }
            String str29 = videoMetric.cellBands;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindString(62, str29);
            }
            Integer num4 = videoMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num4.intValue());
            }
            Integer num5 = videoMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num5.intValue());
            }
            Integer num6 = videoMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num6.intValue());
            }
            Integer num7 = videoMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num7.intValue());
            }
            Integer num8 = videoMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num8.intValue());
            }
            Integer num9 = videoMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num9.intValue());
            }
            Integer num10 = videoMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num10.intValue());
            }
            Integer num11 = videoMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num11.intValue());
            }
            Integer num12 = videoMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num12.intValue());
            }
            Integer num13 = videoMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num13.intValue());
            }
            Integer num14 = videoMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num14.intValue());
            }
            Integer num15 = videoMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num15.intValue());
            }
            Integer num16 = videoMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) num16.intValue());
            }
            String str30 = videoMetric.debugString;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str30);
            }
            Boolean bool = videoMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf.intValue());
            }
            Boolean bool2 = videoMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf2.intValue());
            }
            Boolean bool3 = videoMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf3.intValue());
            }
            String str31 = videoMetric.nrState;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str31);
            }
            Integer num18 = videoMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) num18.intValue());
            }
            Boolean bool4 = videoMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) valueOf4.intValue());
            }
            Integer num19 = videoMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) num19.intValue());
            }
            String str32 = videoMetric.cellBandwidths;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindString(84, str32);
            }
            String str33 = videoMetric.additionalPlmns;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str33);
            }
            supportSQLiteStatement.bindDouble(86, videoMetric.altitude);
            Float f = videoMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindDouble(87, (double) f.floatValue());
            }
            Float f2 = videoMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindDouble(88, (double) f2.floatValue());
            }
            Float f3 = videoMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindDouble(89, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(90, (long) videoMetric.getRestrictBackgroundStatus);
            String str34 = videoMetric.cellType;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindString(91, str34);
            }
            Boolean bool5 = videoMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf5.intValue());
            }
            Boolean bool6 = videoMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) valueOf6.intValue());
            }
            Boolean bool7 = videoMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) valueOf7.intValue());
            }
            Boolean bool8 = videoMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(96, (long) videoMetric.locationAge);
            Integer num20 = videoMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num20.intValue());
            }
            Integer num21 = videoMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) num21.intValue());
            }
            Boolean bool9 = videoMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf9.intValue());
            }
            String str35 = videoMetric.sdkOrigin;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindString(100, str35);
            }
            Boolean bool10 = videoMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindLong(101, (long) valueOf10.intValue());
            }
            Boolean bool11 = videoMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindLong(102, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(103, (long) videoMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(104, (long) videoMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(105, (long) videoMetric.latencyType);
            String str36 = videoMetric.serverIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str36);
            }
            String str37 = videoMetric.privateIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str37);
            }
            String str38 = videoMetric.gatewayIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindString(108, str38);
            }
            Integer num22 = videoMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) num22.intValue());
            }
            Integer num23 = videoMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindLong(110, (long) num23.intValue());
            }
            Boolean bool12 = videoMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindLong(111, (long) valueOf12.intValue());
            }
            Boolean bool13 = videoMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(112);
            } else {
                supportSQLiteStatement.bindLong(112, (long) num17.intValue());
            }
            String str39 = videoMetric.appVersionName;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(113);
            } else {
                supportSQLiteStatement.bindString(113, str39);
            }
            supportSQLiteStatement.bindLong(114, videoMetric.appVersionCode);
            supportSQLiteStatement.bindLong(115, videoMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(116, (long) videoMetric.duplexModeState);
            supportSQLiteStatement.bindLong(117, (long) videoMetric.dozeModeState);
            supportSQLiteStatement.bindLong(118, (long) videoMetric.callState);
            String str40 = videoMetric.buildDevice;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, str40);
            }
            String str41 = videoMetric.buildHardware;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(120);
            } else {
                supportSQLiteStatement.bindString(120, str41);
            }
            String str42 = videoMetric.buildProduct;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(121);
            } else {
                supportSQLiteStatement.bindString(121, str42);
            }
            String str43 = videoMetric.appId;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(122);
            } else {
                supportSQLiteStatement.bindString(122, str43);
            }
            supportSQLiteStatement.bindLong(123, videoMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `VideoMetric` (`videoSource`,`fileUrl`,`videoInitialBufferingTime`,`videoRebufferingTime`,`videoRebufferingCount`,`isVideoFailsToStart`,`videoTimeToStart`,`inStreamFailure`,`videoLength`,`videoQualityTime144p`,`videoQualityTime240p`,`videoQualityTime360p`,`videoQualityTime480p`,`videoQualityTime720p`,`videoQualityTime1080p`,`videoQualityTime1440p`,`videoQualityTime2160p`,`videoQualityTimeHighRes`,`videoQualityTimeDefault`,`videoQualityTimeUnknown`,`accessTechStart`,`accessTechEnd`,`accessTechNumChanges`,`bytesSent`,`bytesReceived`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<VideoMetric> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoMetric videoMetric) {
            String str = videoMetric.videoSource;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = videoMetric.fileUrl;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, videoMetric.videoInitialBufferingTime);
            supportSQLiteStatement.bindLong(4, videoMetric.videoRebufferingTime);
            supportSQLiteStatement.bindLong(5, (long) videoMetric.videoRebufferingCount);
            supportSQLiteStatement.bindLong(6, videoMetric.isVideoFailsToStart ? 1 : 0);
            supportSQLiteStatement.bindLong(7, videoMetric.videoTimeToStart);
            supportSQLiteStatement.bindLong(8, videoMetric.inStreamFailure ? 1 : 0);
            supportSQLiteStatement.bindLong(9, (long) videoMetric.videoLength);
            supportSQLiteStatement.bindLong(10, videoMetric.videoQualityTime144p);
            supportSQLiteStatement.bindLong(11, videoMetric.videoQualityTime240p);
            supportSQLiteStatement.bindLong(12, videoMetric.videoQualityTime360p);
            supportSQLiteStatement.bindLong(13, videoMetric.videoQualityTime480p);
            supportSQLiteStatement.bindLong(14, videoMetric.videoQualityTime720p);
            supportSQLiteStatement.bindLong(15, videoMetric.videoQualityTime1080p);
            supportSQLiteStatement.bindLong(16, videoMetric.videoQualityTime1440p);
            supportSQLiteStatement.bindLong(17, videoMetric.videoQualityTime2160p);
            supportSQLiteStatement.bindLong(18, videoMetric.videoQualityTimeHighRes);
            supportSQLiteStatement.bindLong(19, videoMetric.videoQualityTimeDefault);
            supportSQLiteStatement.bindLong(20, videoMetric.videoQualityTimeUnknown);
            String str3 = videoMetric.accessTechStart;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str3);
            }
            String str4 = videoMetric.accessTechEnd;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str4);
            }
            supportSQLiteStatement.bindLong(23, (long) videoMetric.accessTechNumChanges);
            supportSQLiteStatement.bindLong(24, videoMetric.bytesSent);
            supportSQLiteStatement.bindLong(25, videoMetric.bytesReceived);
            supportSQLiteStatement.bindLong(26, videoMetric.id);
            String str5 = videoMetric.mobileClientId;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str5);
            }
            String str6 = videoMetric.measurementSequenceId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str6);
            }
            String str7 = videoMetric.clientIp;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str7);
            }
            String str8 = videoMetric.dateTimeOfMeasurement;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str8);
            }
            supportSQLiteStatement.bindLong(31, (long) videoMetric.stateDuringMeasurement);
            String str9 = videoMetric.accessTechnology;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str9);
            }
            String str10 = videoMetric.accessTypeRaw;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str10);
            }
            supportSQLiteStatement.bindLong(34, (long) videoMetric.signalStrength);
            supportSQLiteStatement.bindLong(35, (long) videoMetric.interference);
            String str11 = videoMetric.simMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str11);
            }
            String str12 = videoMetric.simMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str12);
            }
            String str13 = videoMetric.secondarySimMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str13);
            }
            String str14 = videoMetric.secondarySimMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str14);
            }
            supportSQLiteStatement.bindLong(40, (long) videoMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(41, (long) videoMetric.dataSimSlotNumber);
            String str15 = videoMetric.networkMCC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str15);
            }
            String str16 = videoMetric.networkMNC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, str16);
            }
            supportSQLiteStatement.bindDouble(44, videoMetric.latitude);
            supportSQLiteStatement.bindDouble(45, videoMetric.longitude);
            supportSQLiteStatement.bindDouble(46, videoMetric.gpsAccuracy);
            String str17 = videoMetric.cellId;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str17);
            }
            String str18 = videoMetric.lacId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str18);
            }
            String str19 = videoMetric.deviceBrand;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str19);
            }
            String str20 = videoMetric.deviceModel;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str20);
            }
            String str21 = videoMetric.deviceVersion;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str21);
            }
            String str22 = videoMetric.sdkVersionNumber;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str22);
            }
            String str23 = videoMetric.carrierName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str23);
            }
            String str24 = videoMetric.secondaryCarrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str24);
            }
            String str25 = videoMetric.networkOperatorName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str25);
            }
            String str26 = videoMetric.os;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str26);
            }
            String str27 = videoMetric.osVersion;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str27);
            }
            String str28 = videoMetric.readableDate;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindString(58, str28);
            }
            Integer num = videoMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num.intValue());
            }
            Integer num2 = videoMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num2.intValue());
            }
            Integer num3 = videoMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num3.intValue());
            }
            String str29 = videoMetric.cellBands;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindString(62, str29);
            }
            Integer num4 = videoMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num4.intValue());
            }
            Integer num5 = videoMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num5.intValue());
            }
            Integer num6 = videoMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num6.intValue());
            }
            Integer num7 = videoMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num7.intValue());
            }
            Integer num8 = videoMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num8.intValue());
            }
            Integer num9 = videoMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num9.intValue());
            }
            Integer num10 = videoMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num10.intValue());
            }
            Integer num11 = videoMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num11.intValue());
            }
            Integer num12 = videoMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num12.intValue());
            }
            Integer num13 = videoMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num13.intValue());
            }
            Integer num14 = videoMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num14.intValue());
            }
            Integer num15 = videoMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num15.intValue());
            }
            Integer num16 = videoMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) num16.intValue());
            }
            String str30 = videoMetric.debugString;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str30);
            }
            Boolean bool = videoMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf.intValue());
            }
            Boolean bool2 = videoMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf2.intValue());
            }
            Boolean bool3 = videoMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf3.intValue());
            }
            String str31 = videoMetric.nrState;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str31);
            }
            Integer num18 = videoMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) num18.intValue());
            }
            Boolean bool4 = videoMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindLong(82, (long) valueOf4.intValue());
            }
            Integer num19 = videoMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindLong(83, (long) num19.intValue());
            }
            String str32 = videoMetric.cellBandwidths;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindString(84, str32);
            }
            String str33 = videoMetric.additionalPlmns;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str33);
            }
            supportSQLiteStatement.bindDouble(86, videoMetric.altitude);
            Float f = videoMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindDouble(87, (double) f.floatValue());
            }
            Float f2 = videoMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindDouble(88, (double) f2.floatValue());
            }
            Float f3 = videoMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindDouble(89, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(90, (long) videoMetric.getRestrictBackgroundStatus);
            String str34 = videoMetric.cellType;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindString(91, str34);
            }
            Boolean bool5 = videoMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf5.intValue());
            }
            Boolean bool6 = videoMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) valueOf6.intValue());
            }
            Boolean bool7 = videoMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) valueOf7.intValue());
            }
            Boolean bool8 = videoMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(96, (long) videoMetric.locationAge);
            Integer num20 = videoMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num20.intValue());
            }
            Integer num21 = videoMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) num21.intValue());
            }
            Boolean bool9 = videoMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf9.intValue());
            }
            String str35 = videoMetric.sdkOrigin;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindString(100, str35);
            }
            Boolean bool10 = videoMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindLong(101, (long) valueOf10.intValue());
            }
            Boolean bool11 = videoMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindLong(102, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(103, (long) videoMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(104, (long) videoMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(105, (long) videoMetric.latencyType);
            String str36 = videoMetric.serverIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str36);
            }
            String str37 = videoMetric.privateIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindString(107, str37);
            }
            String str38 = videoMetric.gatewayIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindString(108, str38);
            }
            Integer num22 = videoMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) num22.intValue());
            }
            Integer num23 = videoMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindLong(110, (long) num23.intValue());
            }
            Boolean bool12 = videoMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindLong(111, (long) valueOf12.intValue());
            }
            Boolean bool13 = videoMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(112);
            } else {
                supportSQLiteStatement.bindLong(112, (long) num17.intValue());
            }
            String str39 = videoMetric.appVersionName;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(113);
            } else {
                supportSQLiteStatement.bindString(113, str39);
            }
            supportSQLiteStatement.bindLong(114, videoMetric.appVersionCode);
            supportSQLiteStatement.bindLong(115, videoMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(116, (long) videoMetric.duplexModeState);
            supportSQLiteStatement.bindLong(117, (long) videoMetric.dozeModeState);
            supportSQLiteStatement.bindLong(118, (long) videoMetric.callState);
            String str40 = videoMetric.buildDevice;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, str40);
            }
            String str41 = videoMetric.buildHardware;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(120);
            } else {
                supportSQLiteStatement.bindString(120, str41);
            }
            String str42 = videoMetric.buildProduct;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(121);
            } else {
                supportSQLiteStatement.bindString(121, str42);
            }
            String str43 = videoMetric.appId;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(122);
            } else {
                supportSQLiteStatement.bindString(122, str43);
            }
            supportSQLiteStatement.bindLong(123, videoMetric.isSending ? 1 : 0);
            supportSQLiteStatement.bindLong(124, videoMetric.id);
        }

        public String createQuery() {
            return "UPDATE OR ABORT `VideoMetric` SET `videoSource` = ?,`fileUrl` = ?,`videoInitialBufferingTime` = ?,`videoRebufferingTime` = ?,`videoRebufferingCount` = ?,`isVideoFailsToStart` = ?,`videoTimeToStart` = ?,`inStreamFailure` = ?,`videoLength` = ?,`videoQualityTime144p` = ?,`videoQualityTime240p` = ?,`videoQualityTime360p` = ?,`videoQualityTime480p` = ?,`videoQualityTime720p` = ?,`videoQualityTime1080p` = ?,`videoQualityTime1440p` = ?,`videoQualityTime2160p` = ?,`videoQualityTimeHighRes` = ?,`videoQualityTimeDefault` = ?,`videoQualityTimeUnknown` = ?,`accessTechStart` = ?,`accessTechEnd` = ?,`accessTechNumChanges` = ?,`bytesSent` = ?,`bytesReceived` = ?,`id` = ?,`mobileClientId` = ?,`measurementSequenceId` = ?,`clientIp` = ?,`dateTimeOfMeasurement` = ?,`stateDuringMeasurement` = ?,`accessTechnology` = ?,`accessTypeRaw` = ?,`signalStrength` = ?,`interference` = ?,`simMCC` = ?,`simMNC` = ?,`secondarySimMCC` = ?,`secondarySimMNC` = ?,`numberOfSimSlots` = ?,`dataSimSlotNumber` = ?,`networkMCC` = ?,`networkMNC` = ?,`latitude` = ?,`longitude` = ?,`gpsAccuracy` = ?,`cellId` = ?,`lacId` = ?,`deviceBrand` = ?,`deviceModel` = ?,`deviceVersion` = ?,`sdkVersionNumber` = ?,`carrierName` = ?,`secondaryCarrierName` = ?,`networkOperatorName` = ?,`os` = ?,`osVersion` = ?,`readableDate` = ?,`physicalCellId` = ?,`absoluteRfChannelNumber` = ?,`connectionAbsoluteRfChannelNumber` = ?,`cellBands` = ?,`channelQualityIndicator` = ?,`referenceSignalSignalToNoiseRatio` = ?,`referenceSignalReceivedPower` = ?,`referenceSignalReceivedQuality` = ?,`csiReferenceSignalReceivedPower` = ?,`csiReferenceSignalToNoiseAndInterferenceRatio` = ?,`csiReferenceSignalReceivedQuality` = ?,`ssReferenceSignalReceivedPower` = ?,`ssReferenceSignalReceivedQuality` = ?,`ssReferenceSignalToNoiseAndInterferenceRatio` = ?,`timingAdvance` = ?,`signalStrengthAsu` = ?,`dbm` = ?,`debugString` = ?,`isDcNrRestricted` = ?,`isNrAvailable` = ?,`isEnDcAvailable` = ?,`nrState` = ?,`nrFrequencyRange` = ?,`isUsingCarrierAggregation` = ?,`vopsSupport` = ?,`cellBandwidths` = ?,`additionalPlmns` = ?,`altitude` = ?,`locationSpeed` = ?,`locationSpeedAccuracy` = ?,`gpsVerticalAccuracy` = ?,`getRestrictBackgroundStatus` = ?,`cellType` = ?,`isDefaultNetworkActive` = ?,`isActiveNetworkMetered` = ?,`isOnScreen` = ?,`isRoaming` = ?,`locationAge` = ?,`overrideNetworkType` = ?,`accessNetworkTechnologyRaw` = ?,`anonymize` = ?,`sdkOrigin` = ?,`isRooted` = ?,`isConnectedToVpn` = ?,`linkDownstreamBandwidth` = ?,`linkUpstreamBandwidth` = ?,`latencyType` = ?,`serverIp` = ?,`privateIp` = ?,`gatewayIp` = ?,`locationPermissionState` = ?,`serviceStateStatus` = ?,`isNrCellSeen` = ?,`isReadPhoneStatePermissionGranted` = ?,`appVersionName` = ?,`appVersionCode` = ?,`appLastUpdateTime` = ?,`duplexModeState` = ?,`dozeModeState` = ?,`callState` = ?,`buildDevice` = ?,`buildHardware` = ?,`buildProduct` = ?,`appId` = ?,`isSending` = ? WHERE `id` = ?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM videometric";
        }
    }

    public VideoMetricDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(VideoMetric videoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(videoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<VideoMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<VideoMetric> b() {
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from videometric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "videoSource");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "fileUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "videoInitialBufferingTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "videoRebufferingTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "videoRebufferingCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "isVideoFailsToStart");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "videoTimeToStart");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "inStreamFailure");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, MRAIDPresenter.VIDEO_LENGTH);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime144p");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime240p");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime360p");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime480p");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime720p");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime1080p");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime1440p");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTime2160p");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTimeHighRes");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTimeDefault");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "videoQualityTimeUnknown");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "accessTechStart");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "accessTechEnd");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "accessTechNumChanges");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "bytesSent");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "bytesReceived");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    VideoMetric videoMetric = new VideoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        videoMetric.videoSource = null;
                    } else {
                        arrayList = arrayList2;
                        videoMetric.videoSource = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        videoMetric.fileUrl = null;
                    } else {
                        videoMetric.fileUrl = query.getString(columnIndexOrThrow2);
                    }
                    int i13 = columnIndexOrThrow;
                    int i14 = columnIndexOrThrow2;
                    videoMetric.videoInitialBufferingTime = query.getLong(columnIndexOrThrow3);
                    videoMetric.videoRebufferingTime = query.getLong(columnIndexOrThrow4);
                    videoMetric.videoRebufferingCount = query.getInt(columnIndexOrThrow5);
                    videoMetric.isVideoFailsToStart = query.getInt(columnIndexOrThrow6) != 0;
                    int i15 = columnIndexOrThrow3;
                    videoMetric.videoTimeToStart = query.getLong(columnIndexOrThrow7);
                    videoMetric.inStreamFailure = query.getInt(columnIndexOrThrow8) != 0;
                    videoMetric.videoLength = query.getInt(columnIndexOrThrow9);
                    videoMetric.videoQualityTime144p = query.getLong(columnIndexOrThrow10);
                    videoMetric.videoQualityTime240p = query.getLong(columnIndexOrThrow11);
                    videoMetric.videoQualityTime360p = query.getLong(columnIndexOrThrow12);
                    int i16 = columnIndexOrThrow11;
                    int i17 = i12;
                    int i18 = i13;
                    videoMetric.videoQualityTime480p = query.getLong(i17);
                    int i19 = columnIndexOrThrow12;
                    int i20 = columnIndexOrThrow14;
                    int i21 = i15;
                    videoMetric.videoQualityTime720p = query.getLong(i20);
                    int i22 = i20;
                    int i23 = columnIndexOrThrow15;
                    int i24 = i19;
                    videoMetric.videoQualityTime1080p = query.getLong(i23);
                    int i25 = i23;
                    int i26 = columnIndexOrThrow16;
                    int i27 = i22;
                    videoMetric.videoQualityTime1440p = query.getLong(i26);
                    int i28 = i26;
                    int i29 = columnIndexOrThrow17;
                    int i30 = i25;
                    videoMetric.videoQualityTime2160p = query.getLong(i29);
                    int i31 = i29;
                    int i32 = columnIndexOrThrow18;
                    int i33 = i28;
                    videoMetric.videoQualityTimeHighRes = query.getLong(i32);
                    int i34 = i32;
                    int i35 = columnIndexOrThrow19;
                    int i36 = i31;
                    videoMetric.videoQualityTimeDefault = query.getLong(i35);
                    int i37 = i35;
                    int i38 = columnIndexOrThrow20;
                    int i39 = i34;
                    videoMetric.videoQualityTimeUnknown = query.getLong(i38);
                    int i40 = columnIndexOrThrow21;
                    if (query.isNull(i40)) {
                        videoMetric.accessTechStart = null;
                    } else {
                        videoMetric.accessTechStart = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow22;
                    if (query.isNull(i41)) {
                        i = i38;
                        videoMetric.accessTechEnd = null;
                    } else {
                        i = i38;
                        videoMetric.accessTechEnd = query.getString(i41);
                    }
                    int i42 = i37;
                    int i43 = columnIndexOrThrow23;
                    videoMetric.accessTechNumChanges = query.getInt(i43);
                    int i44 = i40;
                    int i45 = columnIndexOrThrow24;
                    int i46 = i41;
                    videoMetric.bytesSent = query.getLong(i45);
                    int i47 = i43;
                    int i48 = columnIndexOrThrow25;
                    int i49 = i45;
                    videoMetric.bytesReceived = query.getLong(i48);
                    int i50 = i48;
                    int i51 = columnIndexOrThrow26;
                    int i52 = i47;
                    videoMetric.id = query.getLong(i51);
                    int i53 = columnIndexOrThrow27;
                    if (query.isNull(i53)) {
                        videoMetric.mobileClientId = null;
                    } else {
                        videoMetric.mobileClientId = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow28;
                    if (query.isNull(i54)) {
                        i2 = i51;
                        videoMetric.measurementSequenceId = null;
                    } else {
                        i2 = i51;
                        videoMetric.measurementSequenceId = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow29;
                    if (query.isNull(i55)) {
                        i3 = i50;
                        videoMetric.clientIp = null;
                    } else {
                        i3 = i50;
                        videoMetric.clientIp = query.getString(i55);
                    }
                    int i56 = columnIndexOrThrow30;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow29 = i55;
                        videoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow29 = i55;
                        videoMetric.dateTimeOfMeasurement = query.getString(i56);
                    }
                    columnIndexOrThrow30 = i56;
                    int i57 = columnIndexOrThrow31;
                    videoMetric.stateDuringMeasurement = query.getInt(i57);
                    int i58 = columnIndexOrThrow32;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow31 = i57;
                        videoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow31 = i57;
                        videoMetric.accessTechnology = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow33;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow32 = i58;
                        videoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow32 = i58;
                        videoMetric.accessTypeRaw = query.getString(i59);
                    }
                    columnIndexOrThrow33 = i59;
                    int i60 = columnIndexOrThrow34;
                    videoMetric.signalStrength = query.getInt(i60);
                    columnIndexOrThrow34 = i60;
                    int i61 = columnIndexOrThrow35;
                    videoMetric.interference = query.getInt(i61);
                    int i62 = columnIndexOrThrow36;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow35 = i61;
                        videoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow35 = i61;
                        videoMetric.simMCC = query.getString(i62);
                    }
                    int i63 = columnIndexOrThrow37;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow36 = i62;
                        videoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow36 = i62;
                        videoMetric.simMNC = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow38;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow37 = i63;
                        videoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow37 = i63;
                        videoMetric.secondarySimMCC = query.getString(i64);
                    }
                    int i65 = columnIndexOrThrow39;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow38 = i64;
                        videoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow38 = i64;
                        videoMetric.secondarySimMNC = query.getString(i65);
                    }
                    columnIndexOrThrow39 = i65;
                    int i66 = columnIndexOrThrow40;
                    videoMetric.numberOfSimSlots = query.getInt(i66);
                    columnIndexOrThrow40 = i66;
                    int i67 = columnIndexOrThrow41;
                    videoMetric.dataSimSlotNumber = query.getInt(i67);
                    int i68 = columnIndexOrThrow42;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow41 = i67;
                        videoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow41 = i67;
                        videoMetric.networkMCC = query.getString(i68);
                    }
                    int i69 = columnIndexOrThrow43;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow42 = i68;
                        videoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow42 = i68;
                        videoMetric.networkMNC = query.getString(i69);
                    }
                    int i70 = i53;
                    int i71 = columnIndexOrThrow44;
                    int i72 = i54;
                    videoMetric.latitude = query.getDouble(i71);
                    int i73 = i69;
                    int i74 = columnIndexOrThrow45;
                    int i75 = i71;
                    videoMetric.longitude = query.getDouble(i74);
                    int i76 = i74;
                    int i77 = columnIndexOrThrow46;
                    int i78 = i73;
                    videoMetric.gpsAccuracy = query.getDouble(i77);
                    int i79 = columnIndexOrThrow47;
                    if (query.isNull(i79)) {
                        videoMetric.cellId = null;
                    } else {
                        videoMetric.cellId = query.getString(i79);
                    }
                    int i80 = columnIndexOrThrow48;
                    if (query.isNull(i80)) {
                        i4 = i77;
                        videoMetric.lacId = null;
                    } else {
                        i4 = i77;
                        videoMetric.lacId = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow49;
                    if (query.isNull(i81)) {
                        i5 = i76;
                        videoMetric.deviceBrand = null;
                    } else {
                        i5 = i76;
                        videoMetric.deviceBrand = query.getString(i81);
                    }
                    int i82 = columnIndexOrThrow50;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow49 = i81;
                        videoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow49 = i81;
                        videoMetric.deviceModel = query.getString(i82);
                    }
                    int i83 = columnIndexOrThrow51;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow50 = i82;
                        videoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow50 = i82;
                        videoMetric.deviceVersion = query.getString(i83);
                    }
                    int i84 = columnIndexOrThrow52;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow51 = i83;
                        videoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow51 = i83;
                        videoMetric.sdkVersionNumber = query.getString(i84);
                    }
                    int i85 = columnIndexOrThrow53;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow52 = i84;
                        videoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow52 = i84;
                        videoMetric.carrierName = query.getString(i85);
                    }
                    int i86 = columnIndexOrThrow54;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow53 = i85;
                        videoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow53 = i85;
                        videoMetric.secondaryCarrierName = query.getString(i86);
                    }
                    int i87 = columnIndexOrThrow55;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow54 = i86;
                        videoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow54 = i86;
                        videoMetric.networkOperatorName = query.getString(i87);
                    }
                    int i88 = columnIndexOrThrow56;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow55 = i87;
                        videoMetric.os = null;
                    } else {
                        columnIndexOrThrow55 = i87;
                        videoMetric.os = query.getString(i88);
                    }
                    int i89 = columnIndexOrThrow57;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow56 = i88;
                        videoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow56 = i88;
                        videoMetric.osVersion = query.getString(i89);
                    }
                    int i90 = columnIndexOrThrow58;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow57 = i89;
                        videoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow57 = i89;
                        videoMetric.readableDate = query.getString(i90);
                    }
                    int i91 = columnIndexOrThrow59;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow58 = i90;
                        videoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow58 = i90;
                        videoMetric.physicalCellId = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow60;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow59 = i91;
                        videoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow59 = i91;
                        videoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i92));
                    }
                    int i93 = columnIndexOrThrow61;
                    if (query.isNull(i93)) {
                        columnIndexOrThrow60 = i92;
                        videoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow60 = i92;
                        videoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i93));
                    }
                    int i94 = columnIndexOrThrow62;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow61 = i93;
                        videoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow61 = i93;
                        videoMetric.cellBands = query.getString(i94);
                    }
                    int i95 = columnIndexOrThrow63;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow62 = i94;
                        videoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow62 = i94;
                        videoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow64;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow63 = i95;
                        videoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow63 = i95;
                        videoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow65;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow64 = i96;
                        videoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow64 = i96;
                        videoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow66;
                    if (query.isNull(i98)) {
                        columnIndexOrThrow65 = i97;
                        videoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow65 = i97;
                        videoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i98));
                    }
                    int i99 = columnIndexOrThrow67;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow66 = i98;
                        videoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow66 = i98;
                        videoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i99));
                    }
                    int i100 = columnIndexOrThrow68;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow67 = i99;
                        videoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow67 = i99;
                        videoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i100));
                    }
                    int i101 = columnIndexOrThrow69;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow68 = i100;
                        videoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow68 = i100;
                        videoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i101));
                    }
                    int i102 = columnIndexOrThrow70;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow69 = i101;
                        videoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow69 = i101;
                        videoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i102));
                    }
                    int i103 = columnIndexOrThrow71;
                    if (query.isNull(i103)) {
                        columnIndexOrThrow70 = i102;
                        videoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow70 = i102;
                        videoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i103));
                    }
                    int i104 = columnIndexOrThrow72;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow71 = i103;
                        videoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow71 = i103;
                        videoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i104));
                    }
                    int i105 = columnIndexOrThrow73;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow72 = i104;
                        videoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow72 = i104;
                        videoMetric.timingAdvance = Integer.valueOf(query.getInt(i105));
                    }
                    int i106 = columnIndexOrThrow74;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow73 = i105;
                        videoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow73 = i105;
                        videoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i106));
                    }
                    int i107 = columnIndexOrThrow75;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow74 = i106;
                        videoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow74 = i106;
                        videoMetric.dbm = Integer.valueOf(query.getInt(i107));
                    }
                    int i108 = columnIndexOrThrow76;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow75 = i107;
                        videoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow75 = i107;
                        videoMetric.debugString = query.getString(i108);
                    }
                    int i109 = columnIndexOrThrow77;
                    Integer valueOf = query.isNull(i109) ? null : Integer.valueOf(query.getInt(i109));
                    if (valueOf == null) {
                        columnIndexOrThrow77 = i109;
                        bool = null;
                    } else {
                        columnIndexOrThrow77 = i109;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    videoMetric.isDcNrRestricted = bool;
                    int i110 = columnIndexOrThrow78;
                    Integer valueOf2 = query.isNull(i110) ? null : Integer.valueOf(query.getInt(i110));
                    if (valueOf2 == null) {
                        columnIndexOrThrow78 = i110;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow78 = i110;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    videoMetric.isNrAvailable = bool2;
                    int i111 = columnIndexOrThrow79;
                    Integer valueOf3 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf3 == null) {
                        columnIndexOrThrow79 = i111;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow79 = i111;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    videoMetric.isEnDcAvailable = bool3;
                    int i112 = columnIndexOrThrow80;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow76 = i108;
                        videoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow76 = i108;
                        videoMetric.nrState = query.getString(i112);
                    }
                    int i113 = columnIndexOrThrow81;
                    if (query.isNull(i113)) {
                        columnIndexOrThrow80 = i112;
                        videoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow80 = i112;
                        videoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i113));
                    }
                    int i114 = columnIndexOrThrow82;
                    Integer valueOf4 = query.isNull(i114) ? null : Integer.valueOf(query.getInt(i114));
                    if (valueOf4 == null) {
                        columnIndexOrThrow82 = i114;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow82 = i114;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    videoMetric.isUsingCarrierAggregation = bool4;
                    int i115 = columnIndexOrThrow83;
                    if (query.isNull(i115)) {
                        columnIndexOrThrow81 = i113;
                        videoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow81 = i113;
                        videoMetric.vopsSupport = Integer.valueOf(query.getInt(i115));
                    }
                    int i116 = columnIndexOrThrow84;
                    if (query.isNull(i116)) {
                        columnIndexOrThrow83 = i115;
                        videoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow83 = i115;
                        videoMetric.cellBandwidths = query.getString(i116);
                    }
                    int i117 = columnIndexOrThrow85;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow84 = i116;
                        videoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow84 = i116;
                        videoMetric.additionalPlmns = query.getString(i117);
                    }
                    int i118 = i79;
                    int i119 = columnIndexOrThrow86;
                    int i120 = i80;
                    videoMetric.altitude = query.getDouble(i119);
                    int i121 = columnIndexOrThrow87;
                    if (query.isNull(i121)) {
                        videoMetric.locationSpeed = null;
                    } else {
                        videoMetric.locationSpeed = Float.valueOf(query.getFloat(i121));
                    }
                    int i122 = columnIndexOrThrow88;
                    if (query.isNull(i122)) {
                        i6 = i117;
                        videoMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i117;
                        videoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i122));
                    }
                    int i123 = columnIndexOrThrow89;
                    if (query.isNull(i123)) {
                        i7 = i119;
                        videoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i119;
                        videoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i123));
                    }
                    columnIndexOrThrow89 = i123;
                    int i124 = columnIndexOrThrow90;
                    videoMetric.getRestrictBackgroundStatus = query.getInt(i124);
                    int i125 = columnIndexOrThrow91;
                    if (query.isNull(i125)) {
                        columnIndexOrThrow90 = i124;
                        videoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow90 = i124;
                        videoMetric.cellType = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow92;
                    Integer valueOf5 = query.isNull(i126) ? null : Integer.valueOf(query.getInt(i126));
                    if (valueOf5 == null) {
                        i8 = i125;
                        bool5 = null;
                    } else {
                        i8 = i125;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    videoMetric.isDefaultNetworkActive = bool5;
                    int i127 = columnIndexOrThrow93;
                    Integer valueOf6 = query.isNull(i127) ? null : Integer.valueOf(query.getInt(i127));
                    if (valueOf6 == null) {
                        columnIndexOrThrow93 = i127;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow93 = i127;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    videoMetric.isActiveNetworkMetered = bool6;
                    int i128 = columnIndexOrThrow94;
                    Integer valueOf7 = query.isNull(i128) ? null : Integer.valueOf(query.getInt(i128));
                    if (valueOf7 == null) {
                        columnIndexOrThrow94 = i128;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow94 = i128;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    videoMetric.isOnScreen = bool7;
                    int i129 = columnIndexOrThrow95;
                    Integer valueOf8 = query.isNull(i129) ? null : Integer.valueOf(query.getInt(i129));
                    if (valueOf8 == null) {
                        columnIndexOrThrow95 = i129;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow95 = i129;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    videoMetric.isRoaming = bool8;
                    int i130 = i126;
                    int i131 = columnIndexOrThrow96;
                    videoMetric.locationAge = query.getInt(i131);
                    int i132 = columnIndexOrThrow97;
                    if (query.isNull(i132)) {
                        columnIndexOrThrow96 = i131;
                        videoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow96 = i131;
                        videoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i132));
                    }
                    int i133 = columnIndexOrThrow98;
                    if (query.isNull(i133)) {
                        columnIndexOrThrow97 = i132;
                        videoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow97 = i132;
                        videoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i133));
                    }
                    int i134 = columnIndexOrThrow99;
                    Integer valueOf9 = query.isNull(i134) ? null : Integer.valueOf(query.getInt(i134));
                    if (valueOf9 == null) {
                        i9 = i133;
                        bool9 = null;
                    } else {
                        i9 = i133;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    videoMetric.anonymize = bool9;
                    int i135 = columnIndexOrThrow100;
                    if (query.isNull(i135)) {
                        i10 = i134;
                        videoMetric.sdkOrigin = null;
                    } else {
                        i10 = i134;
                        videoMetric.sdkOrigin = query.getString(i135);
                    }
                    int i136 = columnIndexOrThrow101;
                    Integer valueOf10 = query.isNull(i136) ? null : Integer.valueOf(query.getInt(i136));
                    if (valueOf10 == null) {
                        i11 = i135;
                        bool10 = null;
                    } else {
                        i11 = i135;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    videoMetric.isRooted = bool10;
                    int i137 = columnIndexOrThrow102;
                    Integer valueOf11 = query.isNull(i137) ? null : Integer.valueOf(query.getInt(i137));
                    if (valueOf11 == null) {
                        columnIndexOrThrow102 = i137;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow102 = i137;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    videoMetric.isConnectedToVpn = bool11;
                    int i138 = i136;
                    int i139 = columnIndexOrThrow103;
                    videoMetric.linkDownstreamBandwidth = query.getInt(i139);
                    columnIndexOrThrow103 = i139;
                    int i140 = columnIndexOrThrow104;
                    videoMetric.linkUpstreamBandwidth = query.getInt(i140);
                    columnIndexOrThrow104 = i140;
                    int i141 = columnIndexOrThrow105;
                    videoMetric.latencyType = query.getInt(i141);
                    int i142 = columnIndexOrThrow106;
                    if (query.isNull(i142)) {
                        columnIndexOrThrow105 = i141;
                        videoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow105 = i141;
                        videoMetric.serverIp = query.getString(i142);
                    }
                    int i143 = columnIndexOrThrow107;
                    if (query.isNull(i143)) {
                        columnIndexOrThrow106 = i142;
                        videoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow106 = i142;
                        videoMetric.privateIp = query.getString(i143);
                    }
                    int i144 = columnIndexOrThrow108;
                    if (query.isNull(i144)) {
                        columnIndexOrThrow107 = i143;
                        videoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow107 = i143;
                        videoMetric.gatewayIp = query.getString(i144);
                    }
                    int i145 = columnIndexOrThrow109;
                    if (query.isNull(i145)) {
                        columnIndexOrThrow108 = i144;
                        videoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow108 = i144;
                        videoMetric.locationPermissionState = Integer.valueOf(query.getInt(i145));
                    }
                    int i146 = columnIndexOrThrow110;
                    if (query.isNull(i146)) {
                        columnIndexOrThrow109 = i145;
                        videoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow109 = i145;
                        videoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i146));
                    }
                    int i147 = columnIndexOrThrow111;
                    Integer valueOf12 = query.isNull(i147) ? null : Integer.valueOf(query.getInt(i147));
                    if (valueOf12 == null) {
                        columnIndexOrThrow111 = i147;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow111 = i147;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    videoMetric.isNrCellSeen = bool12;
                    int i148 = columnIndexOrThrow112;
                    Integer valueOf13 = query.isNull(i148) ? null : Integer.valueOf(query.getInt(i148));
                    if (valueOf13 == null) {
                        columnIndexOrThrow112 = i148;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow112 = i148;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    videoMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i149 = columnIndexOrThrow113;
                    if (query.isNull(i149)) {
                        columnIndexOrThrow110 = i146;
                        videoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow110 = i146;
                        videoMetric.appVersionName = query.getString(i149);
                    }
                    int i150 = i121;
                    int i151 = columnIndexOrThrow114;
                    int i152 = i122;
                    videoMetric.appVersionCode = query.getLong(i151);
                    int i153 = i149;
                    int i154 = columnIndexOrThrow115;
                    int i155 = i151;
                    videoMetric.appLastUpdateTime = query.getLong(i154);
                    int i156 = columnIndexOrThrow116;
                    videoMetric.duplexModeState = query.getInt(i156);
                    columnIndexOrThrow116 = i156;
                    int i157 = columnIndexOrThrow117;
                    videoMetric.dozeModeState = query.getInt(i157);
                    columnIndexOrThrow117 = i157;
                    int i158 = columnIndexOrThrow118;
                    videoMetric.callState = query.getInt(i158);
                    int i159 = columnIndexOrThrow119;
                    if (query.isNull(i159)) {
                        columnIndexOrThrow118 = i158;
                        videoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow118 = i158;
                        videoMetric.buildDevice = query.getString(i159);
                    }
                    int i160 = columnIndexOrThrow120;
                    if (query.isNull(i160)) {
                        columnIndexOrThrow119 = i159;
                        videoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow119 = i159;
                        videoMetric.buildHardware = query.getString(i160);
                    }
                    int i161 = columnIndexOrThrow121;
                    if (query.isNull(i161)) {
                        columnIndexOrThrow120 = i160;
                        videoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow120 = i160;
                        videoMetric.buildProduct = query.getString(i161);
                    }
                    int i162 = columnIndexOrThrow122;
                    if (query.isNull(i162)) {
                        columnIndexOrThrow121 = i161;
                        videoMetric.appId = null;
                    } else {
                        columnIndexOrThrow121 = i161;
                        videoMetric.appId = query.getString(i162);
                    }
                    int i163 = columnIndexOrThrow123;
                    if (query.getInt(i163) != 0) {
                        columnIndexOrThrow122 = i162;
                        z = true;
                    } else {
                        columnIndexOrThrow122 = i162;
                        z = false;
                    }
                    videoMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(videoMetric);
                    columnIndexOrThrow123 = i163;
                    columnIndexOrThrow11 = i16;
                    columnIndexOrThrow3 = i21;
                    columnIndexOrThrow14 = i27;
                    columnIndexOrThrow16 = i33;
                    columnIndexOrThrow18 = i39;
                    columnIndexOrThrow20 = i;
                    columnIndexOrThrow21 = i44;
                    columnIndexOrThrow23 = i52;
                    columnIndexOrThrow26 = i2;
                    columnIndexOrThrow27 = i70;
                    columnIndexOrThrow43 = i78;
                    columnIndexOrThrow46 = i4;
                    columnIndexOrThrow47 = i118;
                    columnIndexOrThrow85 = i6;
                    columnIndexOrThrow87 = i150;
                    columnIndexOrThrow113 = i153;
                    columnIndexOrThrow = i18;
                    i12 = i17;
                    columnIndexOrThrow2 = i14;
                    int i164 = i155;
                    columnIndexOrThrow115 = i154;
                    columnIndexOrThrow12 = i24;
                    columnIndexOrThrow15 = i30;
                    columnIndexOrThrow17 = i36;
                    columnIndexOrThrow19 = i42;
                    columnIndexOrThrow22 = i46;
                    columnIndexOrThrow24 = i49;
                    columnIndexOrThrow25 = i3;
                    columnIndexOrThrow28 = i72;
                    columnIndexOrThrow44 = i75;
                    columnIndexOrThrow45 = i5;
                    columnIndexOrThrow48 = i120;
                    columnIndexOrThrow86 = i7;
                    columnIndexOrThrow88 = i152;
                    columnIndexOrThrow114 = i164;
                    int i165 = i8;
                    columnIndexOrThrow92 = i130;
                    columnIndexOrThrow91 = i165;
                    int i166 = i9;
                    columnIndexOrThrow99 = i10;
                    columnIndexOrThrow98 = i166;
                    int i167 = i11;
                    columnIndexOrThrow101 = i138;
                    columnIndexOrThrow100 = i167;
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
