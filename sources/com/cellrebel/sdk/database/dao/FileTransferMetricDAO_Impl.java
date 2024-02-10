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
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FileTransferMetricDAO_Impl implements FileTransferMetricDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<FileTransferMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<FileTransferMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FileTransferMetric fileTransferMetric) {
            String str = fileTransferMetric.serverIdFileLoad;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, fileTransferMetric.downLoadFileTime);
            supportSQLiteStatement.bindLong(3, fileTransferMetric.upLoadFileTime);
            supportSQLiteStatement.bindLong(4, fileTransferMetric.isFileDownLoaded ? 1 : 0);
            supportSQLiteStatement.bindLong(5, fileTransferMetric.isFileUpLoaded ? 1 : 0);
            supportSQLiteStatement.bindLong(6, (long) fileTransferMetric.latency);
            supportSQLiteStatement.bindLong(7, fileTransferMetric.downloadFirstByteTime);
            String str2 = fileTransferMetric.downloadAccessTechStart;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str2);
            }
            String str3 = fileTransferMetric.downloadAccessTechEnd;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str3);
            }
            supportSQLiteStatement.bindLong(10, (long) fileTransferMetric.downloadAccessTechNumChanges);
            supportSQLiteStatement.bindLong(11, fileTransferMetric.uploadFirstByteTime);
            String str4 = fileTransferMetric.uploadAccessTechStart;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str4);
            }
            String str5 = fileTransferMetric.uploadAccessTechEnd;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str5);
            }
            supportSQLiteStatement.bindLong(14, (long) fileTransferMetric.uploadAccessTechNumChanges);
            supportSQLiteStatement.bindLong(15, fileTransferMetric.bytesSent);
            supportSQLiteStatement.bindLong(16, fileTransferMetric.bytesReceived);
            supportSQLiteStatement.bindLong(17, fileTransferMetric.dnsLookupTime);
            supportSQLiteStatement.bindLong(18, fileTransferMetric.tcpConnectTime);
            supportSQLiteStatement.bindLong(19, fileTransferMetric.tlsSetupTime);
            supportSQLiteStatement.bindLong(20, fileTransferMetric.fileSize);
            supportSQLiteStatement.bindLong(21, fileTransferMetric.isFromLatencyTest ? 1 : 0);
            Integer num = fileTransferMetric.fileTransferId;
            if (num == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindLong(22, (long) num.intValue());
            }
            supportSQLiteStatement.bindLong(23, fileTransferMetric.id);
            String str6 = fileTransferMetric.mobileClientId;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str6);
            }
            String str7 = fileTransferMetric.measurementSequenceId;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str7);
            }
            String str8 = fileTransferMetric.clientIp;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str8);
            }
            String str9 = fileTransferMetric.dateTimeOfMeasurement;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str9);
            }
            supportSQLiteStatement.bindLong(28, (long) fileTransferMetric.stateDuringMeasurement);
            String str10 = fileTransferMetric.accessTechnology;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str10);
            }
            String str11 = fileTransferMetric.accessTypeRaw;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str11);
            }
            supportSQLiteStatement.bindLong(31, (long) fileTransferMetric.signalStrength);
            supportSQLiteStatement.bindLong(32, (long) fileTransferMetric.interference);
            String str12 = fileTransferMetric.simMCC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str12);
            }
            String str13 = fileTransferMetric.simMNC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str13);
            }
            String str14 = fileTransferMetric.secondarySimMCC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str14);
            }
            String str15 = fileTransferMetric.secondarySimMNC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str15);
            }
            supportSQLiteStatement.bindLong(37, (long) fileTransferMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(38, (long) fileTransferMetric.dataSimSlotNumber);
            String str16 = fileTransferMetric.networkMCC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str16);
            }
            String str17 = fileTransferMetric.networkMNC;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str17);
            }
            supportSQLiteStatement.bindDouble(41, fileTransferMetric.latitude);
            supportSQLiteStatement.bindDouble(42, fileTransferMetric.longitude);
            supportSQLiteStatement.bindDouble(43, fileTransferMetric.gpsAccuracy);
            String str18 = fileTransferMetric.cellId;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str18);
            }
            String str19 = fileTransferMetric.lacId;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str19);
            }
            String str20 = fileTransferMetric.deviceBrand;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str20);
            }
            String str21 = fileTransferMetric.deviceModel;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str21);
            }
            String str22 = fileTransferMetric.deviceVersion;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str22);
            }
            String str23 = fileTransferMetric.sdkVersionNumber;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str23);
            }
            String str24 = fileTransferMetric.carrierName;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str24);
            }
            String str25 = fileTransferMetric.secondaryCarrierName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str25);
            }
            String str26 = fileTransferMetric.networkOperatorName;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str26);
            }
            String str27 = fileTransferMetric.os;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str27);
            }
            String str28 = fileTransferMetric.osVersion;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str28);
            }
            String str29 = fileTransferMetric.readableDate;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str29);
            }
            Integer num2 = fileTransferMetric.physicalCellId;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) num2.intValue());
            }
            Integer num3 = fileTransferMetric.absoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num3.intValue());
            }
            Integer num4 = fileTransferMetric.connectionAbsoluteRfChannelNumber;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num4.intValue());
            }
            String str30 = fileTransferMetric.cellBands;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindString(59, str30);
            }
            Integer num5 = fileTransferMetric.channelQualityIndicator;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num5.intValue());
            }
            Integer num6 = fileTransferMetric.referenceSignalSignalToNoiseRatio;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num6.intValue());
            }
            Integer num7 = fileTransferMetric.referenceSignalReceivedPower;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num7.intValue());
            }
            Integer num8 = fileTransferMetric.referenceSignalReceivedQuality;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num8.intValue());
            }
            Integer num9 = fileTransferMetric.csiReferenceSignalReceivedPower;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num9.intValue());
            }
            Integer num10 = fileTransferMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num10.intValue());
            }
            Integer num11 = fileTransferMetric.csiReferenceSignalReceivedQuality;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num11.intValue());
            }
            Integer num12 = fileTransferMetric.ssReferenceSignalReceivedPower;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num12.intValue());
            }
            Integer num13 = fileTransferMetric.ssReferenceSignalReceivedQuality;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num13.intValue());
            }
            Integer num14 = fileTransferMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num14.intValue());
            }
            Integer num15 = fileTransferMetric.timingAdvance;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num15.intValue());
            }
            Integer num16 = fileTransferMetric.signalStrengthAsu;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num16.intValue());
            }
            Integer num17 = fileTransferMetric.dbm;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num17.intValue());
            }
            String str31 = fileTransferMetric.debugString;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindString(73, str31);
            }
            Boolean bool = fileTransferMetric.isDcNrRestricted;
            Integer num18 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) valueOf.intValue());
            }
            Boolean bool2 = fileTransferMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf2.intValue());
            }
            Boolean bool3 = fileTransferMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) valueOf3.intValue());
            }
            String str32 = fileTransferMetric.nrState;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindString(77, str32);
            }
            Integer num19 = fileTransferMetric.nrFrequencyRange;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) num19.intValue());
            }
            Boolean bool4 = fileTransferMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf4.intValue());
            }
            Integer num20 = fileTransferMetric.vopsSupport;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) num20.intValue());
            }
            String str33 = fileTransferMetric.cellBandwidths;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindString(81, str33);
            }
            String str34 = fileTransferMetric.additionalPlmns;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindString(82, str34);
            }
            supportSQLiteStatement.bindDouble(83, fileTransferMetric.altitude);
            Float f = fileTransferMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindDouble(84, (double) f.floatValue());
            }
            Float f2 = fileTransferMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindDouble(85, (double) f2.floatValue());
            }
            Float f3 = fileTransferMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindDouble(86, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(87, (long) fileTransferMetric.getRestrictBackgroundStatus);
            String str35 = fileTransferMetric.cellType;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindString(88, str35);
            }
            Boolean bool5 = fileTransferMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) valueOf5.intValue());
            }
            Boolean bool6 = fileTransferMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf6.intValue());
            }
            Boolean bool7 = fileTransferMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) valueOf7.intValue());
            }
            Boolean bool8 = fileTransferMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(93, (long) fileTransferMetric.locationAge);
            Integer num21 = fileTransferMetric.overrideNetworkType;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) num21.intValue());
            }
            Integer num22 = fileTransferMetric.accessNetworkTechnologyRaw;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) num22.intValue());
            }
            Boolean bool9 = fileTransferMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) valueOf9.intValue());
            }
            String str36 = fileTransferMetric.sdkOrigin;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindString(97, str36);
            }
            Boolean bool10 = fileTransferMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) valueOf10.intValue());
            }
            Boolean bool11 = fileTransferMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(100, (long) fileTransferMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(101, (long) fileTransferMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(102, (long) fileTransferMetric.latencyType);
            String str37 = fileTransferMetric.serverIp;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindString(103, str37);
            }
            String str38 = fileTransferMetric.privateIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, str38);
            }
            String str39 = fileTransferMetric.gatewayIp;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindString(105, str39);
            }
            Integer num23 = fileTransferMetric.locationPermissionState;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindLong(106, (long) num23.intValue());
            }
            Integer num24 = fileTransferMetric.serviceStateStatus;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindLong(107, (long) num24.intValue());
            }
            Boolean bool12 = fileTransferMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindLong(108, (long) valueOf12.intValue());
            }
            Boolean bool13 = fileTransferMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num18 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num18 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) num18.intValue());
            }
            String str40 = fileTransferMetric.appVersionName;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindString(110, str40);
            }
            supportSQLiteStatement.bindLong(111, fileTransferMetric.appVersionCode);
            supportSQLiteStatement.bindLong(112, fileTransferMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(113, (long) fileTransferMetric.duplexModeState);
            supportSQLiteStatement.bindLong(114, (long) fileTransferMetric.dozeModeState);
            supportSQLiteStatement.bindLong(115, (long) fileTransferMetric.callState);
            String str41 = fileTransferMetric.buildDevice;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(116);
            } else {
                supportSQLiteStatement.bindString(116, str41);
            }
            String str42 = fileTransferMetric.buildHardware;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(117);
            } else {
                supportSQLiteStatement.bindString(117, str42);
            }
            String str43 = fileTransferMetric.buildProduct;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindString(118, str43);
            }
            String str44 = fileTransferMetric.appId;
            if (str44 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, str44);
            }
            supportSQLiteStatement.bindLong(120, fileTransferMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `FileTransferMetric` (`serverIdFileLoad`,`downLoadFileTime`,`upLoadFileTime`,`isFileDownLoaded`,`isFileUpLoaded`,`latency`,`downloadFirstByteTime`,`downloadAccessTechStart`,`downloadAccessTechEnd`,`downloadAccessTechNumChanges`,`uploadFirstByteTime`,`uploadAccessTechStart`,`uploadAccessTechEnd`,`uploadAccessTechNumChanges`,`bytesSent`,`bytesReceived`,`dnsLookupTime`,`tcpConnectTime`,`tlsSetupTime`,`fileSize`,`isFromLatencyTest`,`fileTransferId`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM filetransfermetric";
        }
    }

    public FileTransferMetricDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(FileTransferMetric fileTransferMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(fileTransferMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<FileTransferMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<FileTransferMetric> b() {
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from filetransfermetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "serverIdFileLoad");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "downLoadFileTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "upLoadFileTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isFileDownLoaded");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isFileUpLoaded");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "latency");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "downloadFirstByteTime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "downloadAccessTechStart");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "downloadAccessTechEnd");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "downloadAccessTechNumChanges");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadFirstByteTime");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "uploadAccessTechStart");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "uploadAccessTechEnd");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "uploadAccessTechNumChanges");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "bytesSent");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "bytesReceived");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "dnsLookupTime");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "tcpConnectTime");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "tlsSetupTime");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "fileSize");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "isFromLatencyTest");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferId");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i12 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    FileTransferMetric fileTransferMetric = new FileTransferMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        fileTransferMetric.serverIdFileLoad = null;
                    } else {
                        arrayList = arrayList2;
                        fileTransferMetric.serverIdFileLoad = query.getString(columnIndexOrThrow);
                    }
                    int i13 = columnIndexOrThrow12;
                    int i14 = columnIndexOrThrow;
                    fileTransferMetric.downLoadFileTime = query.getLong(columnIndexOrThrow2);
                    fileTransferMetric.upLoadFileTime = query.getLong(columnIndexOrThrow3);
                    fileTransferMetric.isFileDownLoaded = query.getInt(columnIndexOrThrow4) != 0;
                    fileTransferMetric.isFileUpLoaded = query.getInt(columnIndexOrThrow5) != 0;
                    fileTransferMetric.latency = query.getInt(columnIndexOrThrow6);
                    int i15 = columnIndexOrThrow2;
                    fileTransferMetric.downloadFirstByteTime = query.getLong(columnIndexOrThrow7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        fileTransferMetric.downloadAccessTechStart = null;
                    } else {
                        fileTransferMetric.downloadAccessTechStart = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        fileTransferMetric.downloadAccessTechEnd = null;
                    } else {
                        fileTransferMetric.downloadAccessTechEnd = query.getString(columnIndexOrThrow9);
                    }
                    fileTransferMetric.downloadAccessTechNumChanges = query.getInt(columnIndexOrThrow10);
                    fileTransferMetric.uploadFirstByteTime = query.getLong(columnIndexOrThrow11);
                    int i16 = i13;
                    if (query.isNull(i16)) {
                        fileTransferMetric.uploadAccessTechStart = null;
                    } else {
                        fileTransferMetric.uploadAccessTechStart = query.getString(i16);
                    }
                    int i17 = i12;
                    if (query.isNull(i17)) {
                        i = i14;
                        fileTransferMetric.uploadAccessTechEnd = null;
                    } else {
                        i = i14;
                        fileTransferMetric.uploadAccessTechEnd = query.getString(i17);
                    }
                    int i18 = columnIndexOrThrow14;
                    int i19 = columnIndexOrThrow11;
                    fileTransferMetric.uploadAccessTechNumChanges = query.getInt(i18);
                    int i20 = i16;
                    int i21 = columnIndexOrThrow15;
                    int i22 = i15;
                    fileTransferMetric.bytesSent = query.getLong(i21);
                    int i23 = i18;
                    int i24 = columnIndexOrThrow16;
                    int i25 = i21;
                    fileTransferMetric.bytesReceived = query.getLong(i24);
                    int i26 = i24;
                    int i27 = columnIndexOrThrow17;
                    int i28 = i23;
                    fileTransferMetric.dnsLookupTime = query.getLong(i27);
                    int i29 = i27;
                    int i30 = columnIndexOrThrow18;
                    int i31 = i26;
                    fileTransferMetric.tcpConnectTime = query.getLong(i30);
                    int i32 = i30;
                    int i33 = columnIndexOrThrow19;
                    int i34 = i29;
                    fileTransferMetric.tlsSetupTime = query.getLong(i33);
                    int i35 = i33;
                    int i36 = columnIndexOrThrow20;
                    int i37 = i32;
                    fileTransferMetric.fileSize = query.getLong(i36);
                    int i38 = columnIndexOrThrow21;
                    fileTransferMetric.isFromLatencyTest = query.getInt(i38) != 0;
                    int i39 = columnIndexOrThrow22;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow21 = i38;
                        fileTransferMetric.fileTransferId = null;
                    } else {
                        columnIndexOrThrow21 = i38;
                        fileTransferMetric.fileTransferId = Integer.valueOf(query.getInt(i39));
                    }
                    int i40 = i36;
                    int i41 = columnIndexOrThrow23;
                    int i42 = i35;
                    fileTransferMetric.id = query.getLong(i41);
                    int i43 = columnIndexOrThrow24;
                    if (query.isNull(i43)) {
                        fileTransferMetric.mobileClientId = null;
                    } else {
                        fileTransferMetric.mobileClientId = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow25;
                    if (query.isNull(i44)) {
                        i2 = i41;
                        fileTransferMetric.measurementSequenceId = null;
                    } else {
                        i2 = i41;
                        fileTransferMetric.measurementSequenceId = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow26;
                    if (query.isNull(i45)) {
                        i3 = i39;
                        fileTransferMetric.clientIp = null;
                    } else {
                        i3 = i39;
                        fileTransferMetric.clientIp = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow27;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow26 = i45;
                        fileTransferMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow26 = i45;
                        fileTransferMetric.dateTimeOfMeasurement = query.getString(i46);
                    }
                    columnIndexOrThrow27 = i46;
                    int i47 = columnIndexOrThrow28;
                    fileTransferMetric.stateDuringMeasurement = query.getInt(i47);
                    int i48 = columnIndexOrThrow29;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow28 = i47;
                        fileTransferMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow28 = i47;
                        fileTransferMetric.accessTechnology = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow30;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow29 = i48;
                        fileTransferMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow29 = i48;
                        fileTransferMetric.accessTypeRaw = query.getString(i49);
                    }
                    columnIndexOrThrow30 = i49;
                    int i50 = columnIndexOrThrow31;
                    fileTransferMetric.signalStrength = query.getInt(i50);
                    columnIndexOrThrow31 = i50;
                    int i51 = columnIndexOrThrow32;
                    fileTransferMetric.interference = query.getInt(i51);
                    int i52 = columnIndexOrThrow33;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow32 = i51;
                        fileTransferMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow32 = i51;
                        fileTransferMetric.simMCC = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow34;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow33 = i52;
                        fileTransferMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow33 = i52;
                        fileTransferMetric.simMNC = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow35;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow34 = i53;
                        fileTransferMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow34 = i53;
                        fileTransferMetric.secondarySimMCC = query.getString(i54);
                    }
                    int i55 = columnIndexOrThrow36;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow35 = i54;
                        fileTransferMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow35 = i54;
                        fileTransferMetric.secondarySimMNC = query.getString(i55);
                    }
                    columnIndexOrThrow36 = i55;
                    int i56 = columnIndexOrThrow37;
                    fileTransferMetric.numberOfSimSlots = query.getInt(i56);
                    columnIndexOrThrow37 = i56;
                    int i57 = columnIndexOrThrow38;
                    fileTransferMetric.dataSimSlotNumber = query.getInt(i57);
                    int i58 = columnIndexOrThrow39;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow38 = i57;
                        fileTransferMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow38 = i57;
                        fileTransferMetric.networkMCC = query.getString(i58);
                    }
                    int i59 = columnIndexOrThrow40;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow39 = i58;
                        fileTransferMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow39 = i58;
                        fileTransferMetric.networkMNC = query.getString(i59);
                    }
                    int i60 = i43;
                    int i61 = columnIndexOrThrow41;
                    int i62 = i44;
                    fileTransferMetric.latitude = query.getDouble(i61);
                    int i63 = i59;
                    int i64 = columnIndexOrThrow42;
                    int i65 = i61;
                    fileTransferMetric.longitude = query.getDouble(i64);
                    int i66 = i64;
                    int i67 = columnIndexOrThrow43;
                    int i68 = i63;
                    fileTransferMetric.gpsAccuracy = query.getDouble(i67);
                    int i69 = columnIndexOrThrow44;
                    if (query.isNull(i69)) {
                        fileTransferMetric.cellId = null;
                    } else {
                        fileTransferMetric.cellId = query.getString(i69);
                    }
                    int i70 = columnIndexOrThrow45;
                    if (query.isNull(i70)) {
                        i4 = i67;
                        fileTransferMetric.lacId = null;
                    } else {
                        i4 = i67;
                        fileTransferMetric.lacId = query.getString(i70);
                    }
                    int i71 = columnIndexOrThrow46;
                    if (query.isNull(i71)) {
                        i5 = i66;
                        fileTransferMetric.deviceBrand = null;
                    } else {
                        i5 = i66;
                        fileTransferMetric.deviceBrand = query.getString(i71);
                    }
                    int i72 = columnIndexOrThrow47;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow46 = i71;
                        fileTransferMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow46 = i71;
                        fileTransferMetric.deviceModel = query.getString(i72);
                    }
                    int i73 = columnIndexOrThrow48;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow47 = i72;
                        fileTransferMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow47 = i72;
                        fileTransferMetric.deviceVersion = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow49;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow48 = i73;
                        fileTransferMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow48 = i73;
                        fileTransferMetric.sdkVersionNumber = query.getString(i74);
                    }
                    int i75 = columnIndexOrThrow50;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow49 = i74;
                        fileTransferMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow49 = i74;
                        fileTransferMetric.carrierName = query.getString(i75);
                    }
                    int i76 = columnIndexOrThrow51;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow50 = i75;
                        fileTransferMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow50 = i75;
                        fileTransferMetric.secondaryCarrierName = query.getString(i76);
                    }
                    int i77 = columnIndexOrThrow52;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow51 = i76;
                        fileTransferMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow51 = i76;
                        fileTransferMetric.networkOperatorName = query.getString(i77);
                    }
                    int i78 = columnIndexOrThrow53;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow52 = i77;
                        fileTransferMetric.os = null;
                    } else {
                        columnIndexOrThrow52 = i77;
                        fileTransferMetric.os = query.getString(i78);
                    }
                    int i79 = columnIndexOrThrow54;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow53 = i78;
                        fileTransferMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow53 = i78;
                        fileTransferMetric.osVersion = query.getString(i79);
                    }
                    int i80 = columnIndexOrThrow55;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow54 = i79;
                        fileTransferMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow54 = i79;
                        fileTransferMetric.readableDate = query.getString(i80);
                    }
                    int i81 = columnIndexOrThrow56;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow55 = i80;
                        fileTransferMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow55 = i80;
                        fileTransferMetric.physicalCellId = Integer.valueOf(query.getInt(i81));
                    }
                    int i82 = columnIndexOrThrow57;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow56 = i81;
                        fileTransferMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow56 = i81;
                        fileTransferMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i82));
                    }
                    int i83 = columnIndexOrThrow58;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow57 = i82;
                        fileTransferMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow57 = i82;
                        fileTransferMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i83));
                    }
                    int i84 = columnIndexOrThrow59;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow58 = i83;
                        fileTransferMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow58 = i83;
                        fileTransferMetric.cellBands = query.getString(i84);
                    }
                    int i85 = columnIndexOrThrow60;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow59 = i84;
                        fileTransferMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow59 = i84;
                        fileTransferMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i85));
                    }
                    int i86 = columnIndexOrThrow61;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow60 = i85;
                        fileTransferMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow60 = i85;
                        fileTransferMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i86));
                    }
                    int i87 = columnIndexOrThrow62;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow61 = i86;
                        fileTransferMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow61 = i86;
                        fileTransferMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow63;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow62 = i87;
                        fileTransferMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow62 = i87;
                        fileTransferMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i88));
                    }
                    int i89 = columnIndexOrThrow64;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow63 = i88;
                        fileTransferMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow63 = i88;
                        fileTransferMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow65;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow64 = i89;
                        fileTransferMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow64 = i89;
                        fileTransferMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow66;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow65 = i90;
                        fileTransferMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow65 = i90;
                        fileTransferMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow67;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow66 = i91;
                        fileTransferMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow66 = i91;
                        fileTransferMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i92));
                    }
                    int i93 = columnIndexOrThrow68;
                    if (query.isNull(i93)) {
                        columnIndexOrThrow67 = i92;
                        fileTransferMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow67 = i92;
                        fileTransferMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i93));
                    }
                    int i94 = columnIndexOrThrow69;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow68 = i93;
                        fileTransferMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow68 = i93;
                        fileTransferMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i94));
                    }
                    int i95 = columnIndexOrThrow70;
                    if (query.isNull(i95)) {
                        columnIndexOrThrow69 = i94;
                        fileTransferMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow69 = i94;
                        fileTransferMetric.timingAdvance = Integer.valueOf(query.getInt(i95));
                    }
                    int i96 = columnIndexOrThrow71;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow70 = i95;
                        fileTransferMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow70 = i95;
                        fileTransferMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i96));
                    }
                    int i97 = columnIndexOrThrow72;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow71 = i96;
                        fileTransferMetric.dbm = null;
                    } else {
                        columnIndexOrThrow71 = i96;
                        fileTransferMetric.dbm = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow73;
                    if (query.isNull(i98)) {
                        columnIndexOrThrow72 = i97;
                        fileTransferMetric.debugString = null;
                    } else {
                        columnIndexOrThrow72 = i97;
                        fileTransferMetric.debugString = query.getString(i98);
                    }
                    int i99 = columnIndexOrThrow74;
                    Integer valueOf = query.isNull(i99) ? null : Integer.valueOf(query.getInt(i99));
                    if (valueOf == null) {
                        columnIndexOrThrow74 = i99;
                        bool = null;
                    } else {
                        columnIndexOrThrow74 = i99;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    fileTransferMetric.isDcNrRestricted = bool;
                    int i100 = columnIndexOrThrow75;
                    Integer valueOf2 = query.isNull(i100) ? null : Integer.valueOf(query.getInt(i100));
                    if (valueOf2 == null) {
                        columnIndexOrThrow75 = i100;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow75 = i100;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    fileTransferMetric.isNrAvailable = bool2;
                    int i101 = columnIndexOrThrow76;
                    Integer valueOf3 = query.isNull(i101) ? null : Integer.valueOf(query.getInt(i101));
                    if (valueOf3 == null) {
                        columnIndexOrThrow76 = i101;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow76 = i101;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    fileTransferMetric.isEnDcAvailable = bool3;
                    int i102 = columnIndexOrThrow77;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow73 = i98;
                        fileTransferMetric.nrState = null;
                    } else {
                        columnIndexOrThrow73 = i98;
                        fileTransferMetric.nrState = query.getString(i102);
                    }
                    int i103 = columnIndexOrThrow78;
                    if (query.isNull(i103)) {
                        columnIndexOrThrow77 = i102;
                        fileTransferMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow77 = i102;
                        fileTransferMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i103));
                    }
                    int i104 = columnIndexOrThrow79;
                    Integer valueOf4 = query.isNull(i104) ? null : Integer.valueOf(query.getInt(i104));
                    if (valueOf4 == null) {
                        columnIndexOrThrow79 = i104;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow79 = i104;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    fileTransferMetric.isUsingCarrierAggregation = bool4;
                    int i105 = columnIndexOrThrow80;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow78 = i103;
                        fileTransferMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow78 = i103;
                        fileTransferMetric.vopsSupport = Integer.valueOf(query.getInt(i105));
                    }
                    int i106 = columnIndexOrThrow81;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow80 = i105;
                        fileTransferMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow80 = i105;
                        fileTransferMetric.cellBandwidths = query.getString(i106);
                    }
                    int i107 = columnIndexOrThrow82;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow81 = i106;
                        fileTransferMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow81 = i106;
                        fileTransferMetric.additionalPlmns = query.getString(i107);
                    }
                    int i108 = i69;
                    int i109 = columnIndexOrThrow83;
                    int i110 = i70;
                    fileTransferMetric.altitude = query.getDouble(i109);
                    int i111 = columnIndexOrThrow84;
                    if (query.isNull(i111)) {
                        fileTransferMetric.locationSpeed = null;
                    } else {
                        fileTransferMetric.locationSpeed = Float.valueOf(query.getFloat(i111));
                    }
                    int i112 = columnIndexOrThrow85;
                    if (query.isNull(i112)) {
                        i6 = i107;
                        fileTransferMetric.locationSpeedAccuracy = null;
                    } else {
                        i6 = i107;
                        fileTransferMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i112));
                    }
                    int i113 = columnIndexOrThrow86;
                    if (query.isNull(i113)) {
                        i7 = i109;
                        fileTransferMetric.gpsVerticalAccuracy = null;
                    } else {
                        i7 = i109;
                        fileTransferMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i113));
                    }
                    columnIndexOrThrow86 = i113;
                    int i114 = columnIndexOrThrow87;
                    fileTransferMetric.getRestrictBackgroundStatus = query.getInt(i114);
                    int i115 = columnIndexOrThrow88;
                    if (query.isNull(i115)) {
                        columnIndexOrThrow87 = i114;
                        fileTransferMetric.cellType = null;
                    } else {
                        columnIndexOrThrow87 = i114;
                        fileTransferMetric.cellType = query.getString(i115);
                    }
                    int i116 = columnIndexOrThrow89;
                    Integer valueOf5 = query.isNull(i116) ? null : Integer.valueOf(query.getInt(i116));
                    if (valueOf5 == null) {
                        i8 = i115;
                        bool5 = null;
                    } else {
                        i8 = i115;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    fileTransferMetric.isDefaultNetworkActive = bool5;
                    int i117 = columnIndexOrThrow90;
                    Integer valueOf6 = query.isNull(i117) ? null : Integer.valueOf(query.getInt(i117));
                    if (valueOf6 == null) {
                        columnIndexOrThrow90 = i117;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow90 = i117;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    fileTransferMetric.isActiveNetworkMetered = bool6;
                    int i118 = columnIndexOrThrow91;
                    Integer valueOf7 = query.isNull(i118) ? null : Integer.valueOf(query.getInt(i118));
                    if (valueOf7 == null) {
                        columnIndexOrThrow91 = i118;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow91 = i118;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    fileTransferMetric.isOnScreen = bool7;
                    int i119 = columnIndexOrThrow92;
                    Integer valueOf8 = query.isNull(i119) ? null : Integer.valueOf(query.getInt(i119));
                    if (valueOf8 == null) {
                        columnIndexOrThrow92 = i119;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow92 = i119;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    fileTransferMetric.isRoaming = bool8;
                    int i120 = i116;
                    int i121 = columnIndexOrThrow93;
                    fileTransferMetric.locationAge = query.getInt(i121);
                    int i122 = columnIndexOrThrow94;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow93 = i121;
                        fileTransferMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow93 = i121;
                        fileTransferMetric.overrideNetworkType = Integer.valueOf(query.getInt(i122));
                    }
                    int i123 = columnIndexOrThrow95;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow94 = i122;
                        fileTransferMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow94 = i122;
                        fileTransferMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i123));
                    }
                    int i124 = columnIndexOrThrow96;
                    Integer valueOf9 = query.isNull(i124) ? null : Integer.valueOf(query.getInt(i124));
                    if (valueOf9 == null) {
                        i9 = i123;
                        bool9 = null;
                    } else {
                        i9 = i123;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    fileTransferMetric.anonymize = bool9;
                    int i125 = columnIndexOrThrow97;
                    if (query.isNull(i125)) {
                        i10 = i124;
                        fileTransferMetric.sdkOrigin = null;
                    } else {
                        i10 = i124;
                        fileTransferMetric.sdkOrigin = query.getString(i125);
                    }
                    int i126 = columnIndexOrThrow98;
                    Integer valueOf10 = query.isNull(i126) ? null : Integer.valueOf(query.getInt(i126));
                    if (valueOf10 == null) {
                        i11 = i125;
                        bool10 = null;
                    } else {
                        i11 = i125;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    fileTransferMetric.isRooted = bool10;
                    int i127 = columnIndexOrThrow99;
                    Integer valueOf11 = query.isNull(i127) ? null : Integer.valueOf(query.getInt(i127));
                    if (valueOf11 == null) {
                        columnIndexOrThrow99 = i127;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow99 = i127;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    fileTransferMetric.isConnectedToVpn = bool11;
                    int i128 = i126;
                    int i129 = columnIndexOrThrow100;
                    fileTransferMetric.linkDownstreamBandwidth = query.getInt(i129);
                    columnIndexOrThrow100 = i129;
                    int i130 = columnIndexOrThrow101;
                    fileTransferMetric.linkUpstreamBandwidth = query.getInt(i130);
                    columnIndexOrThrow101 = i130;
                    int i131 = columnIndexOrThrow102;
                    fileTransferMetric.latencyType = query.getInt(i131);
                    int i132 = columnIndexOrThrow103;
                    if (query.isNull(i132)) {
                        columnIndexOrThrow102 = i131;
                        fileTransferMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow102 = i131;
                        fileTransferMetric.serverIp = query.getString(i132);
                    }
                    int i133 = columnIndexOrThrow104;
                    if (query.isNull(i133)) {
                        columnIndexOrThrow103 = i132;
                        fileTransferMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow103 = i132;
                        fileTransferMetric.privateIp = query.getString(i133);
                    }
                    int i134 = columnIndexOrThrow105;
                    if (query.isNull(i134)) {
                        columnIndexOrThrow104 = i133;
                        fileTransferMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow104 = i133;
                        fileTransferMetric.gatewayIp = query.getString(i134);
                    }
                    int i135 = columnIndexOrThrow106;
                    if (query.isNull(i135)) {
                        columnIndexOrThrow105 = i134;
                        fileTransferMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow105 = i134;
                        fileTransferMetric.locationPermissionState = Integer.valueOf(query.getInt(i135));
                    }
                    int i136 = columnIndexOrThrow107;
                    if (query.isNull(i136)) {
                        columnIndexOrThrow106 = i135;
                        fileTransferMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow106 = i135;
                        fileTransferMetric.serviceStateStatus = Integer.valueOf(query.getInt(i136));
                    }
                    int i137 = columnIndexOrThrow108;
                    Integer valueOf12 = query.isNull(i137) ? null : Integer.valueOf(query.getInt(i137));
                    if (valueOf12 == null) {
                        columnIndexOrThrow108 = i137;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow108 = i137;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    fileTransferMetric.isNrCellSeen = bool12;
                    int i138 = columnIndexOrThrow109;
                    Integer valueOf13 = query.isNull(i138) ? null : Integer.valueOf(query.getInt(i138));
                    if (valueOf13 == null) {
                        columnIndexOrThrow109 = i138;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow109 = i138;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    fileTransferMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i139 = columnIndexOrThrow110;
                    if (query.isNull(i139)) {
                        columnIndexOrThrow107 = i136;
                        fileTransferMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow107 = i136;
                        fileTransferMetric.appVersionName = query.getString(i139);
                    }
                    int i140 = i111;
                    int i141 = columnIndexOrThrow111;
                    int i142 = i112;
                    fileTransferMetric.appVersionCode = query.getLong(i141);
                    int i143 = i139;
                    int i144 = columnIndexOrThrow112;
                    int i145 = i141;
                    fileTransferMetric.appLastUpdateTime = query.getLong(i144);
                    int i146 = columnIndexOrThrow113;
                    fileTransferMetric.duplexModeState = query.getInt(i146);
                    columnIndexOrThrow113 = i146;
                    int i147 = columnIndexOrThrow114;
                    fileTransferMetric.dozeModeState = query.getInt(i147);
                    columnIndexOrThrow114 = i147;
                    int i148 = columnIndexOrThrow115;
                    fileTransferMetric.callState = query.getInt(i148);
                    int i149 = columnIndexOrThrow116;
                    if (query.isNull(i149)) {
                        columnIndexOrThrow115 = i148;
                        fileTransferMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow115 = i148;
                        fileTransferMetric.buildDevice = query.getString(i149);
                    }
                    int i150 = columnIndexOrThrow117;
                    if (query.isNull(i150)) {
                        columnIndexOrThrow116 = i149;
                        fileTransferMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow116 = i149;
                        fileTransferMetric.buildHardware = query.getString(i150);
                    }
                    int i151 = columnIndexOrThrow118;
                    if (query.isNull(i151)) {
                        columnIndexOrThrow117 = i150;
                        fileTransferMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow117 = i150;
                        fileTransferMetric.buildProduct = query.getString(i151);
                    }
                    int i152 = columnIndexOrThrow119;
                    if (query.isNull(i152)) {
                        columnIndexOrThrow118 = i151;
                        fileTransferMetric.appId = null;
                    } else {
                        columnIndexOrThrow118 = i151;
                        fileTransferMetric.appId = query.getString(i152);
                    }
                    int i153 = columnIndexOrThrow120;
                    if (query.getInt(i153) != 0) {
                        columnIndexOrThrow119 = i152;
                        z = true;
                    } else {
                        columnIndexOrThrow119 = i152;
                        z = false;
                    }
                    fileTransferMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(fileTransferMetric);
                    columnIndexOrThrow120 = i153;
                    columnIndexOrThrow11 = i19;
                    columnIndexOrThrow14 = i28;
                    columnIndexOrThrow17 = i34;
                    columnIndexOrThrow19 = i42;
                    columnIndexOrThrow23 = i2;
                    columnIndexOrThrow24 = i60;
                    columnIndexOrThrow40 = i68;
                    columnIndexOrThrow43 = i4;
                    columnIndexOrThrow44 = i108;
                    columnIndexOrThrow82 = i6;
                    columnIndexOrThrow84 = i140;
                    columnIndexOrThrow110 = i143;
                    columnIndexOrThrow = i;
                    i12 = i17;
                    columnIndexOrThrow2 = i22;
                    columnIndexOrThrow15 = i25;
                    columnIndexOrThrow16 = i31;
                    columnIndexOrThrow18 = i37;
                    columnIndexOrThrow20 = i40;
                    columnIndexOrThrow22 = i3;
                    columnIndexOrThrow25 = i62;
                    columnIndexOrThrow41 = i65;
                    columnIndexOrThrow42 = i5;
                    columnIndexOrThrow45 = i110;
                    columnIndexOrThrow83 = i7;
                    columnIndexOrThrow85 = i142;
                    columnIndexOrThrow111 = i145;
                    columnIndexOrThrow112 = i144;
                    columnIndexOrThrow12 = i20;
                    int i154 = i8;
                    columnIndexOrThrow89 = i120;
                    columnIndexOrThrow88 = i154;
                    int i155 = i9;
                    columnIndexOrThrow96 = i10;
                    columnIndexOrThrow95 = i155;
                    int i156 = i11;
                    columnIndexOrThrow98 = i128;
                    columnIndexOrThrow97 = i156;
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
