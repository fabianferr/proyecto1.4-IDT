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
import com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DeviceInfoDAO_Impl implements DeviceInfoDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<DeviceInfoMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<DeviceInfoMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, DeviceInfoMetric deviceInfoMetric) {
            String str = deviceInfoMetric.lteFrequencySupport;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = deviceInfoMetric.nrFrequencySupport;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = deviceInfoMetric.ueCategory;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            Boolean bool = deviceInfoMetric.is4gCapable;
            Integer num = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindLong(4, (long) valueOf.intValue());
            }
            Boolean bool2 = deviceInfoMetric.is5gCapable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, (long) valueOf2.intValue());
            }
            Boolean bool3 = deviceInfoMetric.volteSupport;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, (long) valueOf3.intValue());
            }
            Integer num2 = deviceInfoMetric.deviceYear;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindLong(7, (long) num2.intValue());
            }
            Integer num3 = deviceInfoMetric.maximumStorage;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, (long) num3.intValue());
            }
            Integer num4 = deviceInfoMetric.freeStorage;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, (long) num4.intValue());
            }
            Integer num5 = deviceInfoMetric.ram;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, (long) num5.intValue());
            }
            Integer num6 = deviceInfoMetric.freeRam;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, (long) num6.intValue());
            }
            supportSQLiteStatement.bindLong(12, (long) deviceInfoMetric.cpuUsage);
            Float f = deviceInfoMetric.batteryLevel;
            if (f == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindDouble(13, (double) f.floatValue());
            }
            Integer num7 = deviceInfoMetric.batteryState;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, (long) num7.intValue());
            }
            Integer num8 = deviceInfoMetric.batteryChargeType;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, (long) num8.intValue());
            }
            Integer num9 = deviceInfoMetric.batteryHealth;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindLong(16, (long) num9.intValue());
            }
            Float f2 = deviceInfoMetric.batteryTemperature;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindDouble(17, (double) f2.floatValue());
            }
            String str4 = deviceInfoMetric.language;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str4);
            }
            String str5 = deviceInfoMetric.locale;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str5);
            }
            String str6 = deviceInfoMetric.userAgent;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str6);
            }
            Integer num10 = deviceInfoMetric.screenWidth;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindLong(21, (long) num10.intValue());
            }
            Integer num11 = deviceInfoMetric.screenHeight;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindLong(22, (long) num11.intValue());
            }
            Long l = deviceInfoMetric.elapsedRealtimeNanos;
            if (l == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindLong(23, l.longValue());
            }
            supportSQLiteStatement.bindLong(24, deviceInfoMetric.id);
            String str7 = deviceInfoMetric.mobileClientId;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str7);
            }
            String str8 = deviceInfoMetric.measurementSequenceId;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str8);
            }
            String str9 = deviceInfoMetric.clientIp;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str9);
            }
            String str10 = deviceInfoMetric.dateTimeOfMeasurement;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str10);
            }
            supportSQLiteStatement.bindLong(29, (long) deviceInfoMetric.stateDuringMeasurement);
            String str11 = deviceInfoMetric.accessTechnology;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str11);
            }
            String str12 = deviceInfoMetric.accessTypeRaw;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str12);
            }
            supportSQLiteStatement.bindLong(32, (long) deviceInfoMetric.signalStrength);
            supportSQLiteStatement.bindLong(33, (long) deviceInfoMetric.interference);
            String str13 = deviceInfoMetric.simMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str13);
            }
            String str14 = deviceInfoMetric.simMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str14);
            }
            String str15 = deviceInfoMetric.secondarySimMCC;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str15);
            }
            String str16 = deviceInfoMetric.secondarySimMNC;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str16);
            }
            supportSQLiteStatement.bindLong(38, (long) deviceInfoMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(39, (long) deviceInfoMetric.dataSimSlotNumber);
            String str17 = deviceInfoMetric.networkMCC;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, str17);
            }
            String str18 = deviceInfoMetric.networkMNC;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str18);
            }
            supportSQLiteStatement.bindDouble(42, deviceInfoMetric.latitude);
            supportSQLiteStatement.bindDouble(43, deviceInfoMetric.longitude);
            supportSQLiteStatement.bindDouble(44, deviceInfoMetric.gpsAccuracy);
            String str19 = deviceInfoMetric.cellId;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str19);
            }
            String str20 = deviceInfoMetric.lacId;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, str20);
            }
            String str21 = deviceInfoMetric.deviceBrand;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str21);
            }
            String str22 = deviceInfoMetric.deviceModel;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, str22);
            }
            String str23 = deviceInfoMetric.deviceVersion;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str23);
            }
            String str24 = deviceInfoMetric.sdkVersionNumber;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindString(50, str24);
            }
            String str25 = deviceInfoMetric.carrierName;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindString(51, str25);
            }
            String str26 = deviceInfoMetric.secondaryCarrierName;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, str26);
            }
            String str27 = deviceInfoMetric.networkOperatorName;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str27);
            }
            String str28 = deviceInfoMetric.os;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, str28);
            }
            String str29 = deviceInfoMetric.osVersion;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str29);
            }
            String str30 = deviceInfoMetric.readableDate;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, str30);
            }
            Integer num12 = deviceInfoMetric.physicalCellId;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num12.intValue());
            }
            Integer num13 = deviceInfoMetric.absoluteRfChannelNumber;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num13.intValue());
            }
            Integer num14 = deviceInfoMetric.connectionAbsoluteRfChannelNumber;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) num14.intValue());
            }
            String str31 = deviceInfoMetric.cellBands;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str31);
            }
            Integer num15 = deviceInfoMetric.channelQualityIndicator;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num15.intValue());
            }
            Integer num16 = deviceInfoMetric.referenceSignalSignalToNoiseRatio;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num16.intValue());
            }
            Integer num17 = deviceInfoMetric.referenceSignalReceivedPower;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) num17.intValue());
            }
            Integer num18 = deviceInfoMetric.referenceSignalReceivedQuality;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) num18.intValue());
            }
            Integer num19 = deviceInfoMetric.csiReferenceSignalReceivedPower;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) num19.intValue());
            }
            Integer num20 = deviceInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num20.intValue());
            }
            Integer num21 = deviceInfoMetric.csiReferenceSignalReceivedQuality;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num21.intValue());
            }
            Integer num22 = deviceInfoMetric.ssReferenceSignalReceivedPower;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num22.intValue());
            }
            Integer num23 = deviceInfoMetric.ssReferenceSignalReceivedQuality;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num23.intValue());
            }
            Integer num24 = deviceInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num24.intValue());
            }
            Integer num25 = deviceInfoMetric.timingAdvance;
            if (num25 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num25.intValue());
            }
            Integer num26 = deviceInfoMetric.signalStrengthAsu;
            if (num26 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num26.intValue());
            }
            Integer num27 = deviceInfoMetric.dbm;
            if (num27 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num27.intValue());
            }
            String str32 = deviceInfoMetric.debugString;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindString(74, str32);
            }
            Boolean bool4 = deviceInfoMetric.isDcNrRestricted;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf4.intValue());
            }
            Boolean bool5 = deviceInfoMetric.isNrAvailable;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) valueOf5.intValue());
            }
            Boolean bool6 = deviceInfoMetric.isEnDcAvailable;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) valueOf6.intValue());
            }
            String str33 = deviceInfoMetric.nrState;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindString(78, str33);
            }
            Integer num28 = deviceInfoMetric.nrFrequencyRange;
            if (num28 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) num28.intValue());
            }
            Boolean bool7 = deviceInfoMetric.isUsingCarrierAggregation;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) valueOf7.intValue());
            }
            Integer num29 = deviceInfoMetric.vopsSupport;
            if (num29 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) num29.intValue());
            }
            String str34 = deviceInfoMetric.cellBandwidths;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindString(82, str34);
            }
            String str35 = deviceInfoMetric.additionalPlmns;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str35);
            }
            supportSQLiteStatement.bindDouble(84, deviceInfoMetric.altitude);
            Float f3 = deviceInfoMetric.locationSpeed;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindDouble(85, (double) f3.floatValue());
            }
            Float f4 = deviceInfoMetric.locationSpeedAccuracy;
            if (f4 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindDouble(86, (double) f4.floatValue());
            }
            Float f5 = deviceInfoMetric.gpsVerticalAccuracy;
            if (f5 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindDouble(87, (double) f5.floatValue());
            }
            supportSQLiteStatement.bindLong(88, (long) deviceInfoMetric.getRestrictBackgroundStatus);
            String str36 = deviceInfoMetric.cellType;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindString(89, str36);
            }
            Boolean bool8 = deviceInfoMetric.isDefaultNetworkActive;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf8.intValue());
            }
            Boolean bool9 = deviceInfoMetric.isActiveNetworkMetered;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) valueOf9.intValue());
            }
            Boolean bool10 = deviceInfoMetric.isOnScreen;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) valueOf10.intValue());
            }
            Boolean bool11 = deviceInfoMetric.isRoaming;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(94, (long) deviceInfoMetric.locationAge);
            Integer num30 = deviceInfoMetric.overrideNetworkType;
            if (num30 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindLong(95, (long) num30.intValue());
            }
            Integer num31 = deviceInfoMetric.accessNetworkTechnologyRaw;
            if (num31 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) num31.intValue());
            }
            Boolean bool12 = deviceInfoMetric.anonymize;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) valueOf12.intValue());
            }
            String str37 = deviceInfoMetric.sdkOrigin;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str37);
            }
            Boolean bool13 = deviceInfoMetric.isRooted;
            Integer valueOf13 = bool13 == null ? null : Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            if (valueOf13 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf13.intValue());
            }
            Boolean bool14 = deviceInfoMetric.isConnectedToVpn;
            Integer valueOf14 = bool14 == null ? null : Integer.valueOf(bool14.booleanValue() ? 1 : 0);
            if (valueOf14 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindLong(100, (long) valueOf14.intValue());
            }
            supportSQLiteStatement.bindLong(101, (long) deviceInfoMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(102, (long) deviceInfoMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(103, (long) deviceInfoMetric.latencyType);
            String str38 = deviceInfoMetric.serverIp;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, str38);
            }
            String str39 = deviceInfoMetric.privateIp;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindString(105, str39);
            }
            String str40 = deviceInfoMetric.gatewayIp;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindString(106, str40);
            }
            Integer num32 = deviceInfoMetric.locationPermissionState;
            if (num32 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindLong(107, (long) num32.intValue());
            }
            Integer num33 = deviceInfoMetric.serviceStateStatus;
            if (num33 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindLong(108, (long) num33.intValue());
            }
            Boolean bool15 = deviceInfoMetric.isNrCellSeen;
            Integer valueOf15 = bool15 == null ? null : Integer.valueOf(bool15.booleanValue() ? 1 : 0);
            if (valueOf15 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) valueOf15.intValue());
            }
            Boolean bool16 = deviceInfoMetric.isReadPhoneStatePermissionGranted;
            if (bool16 != null) {
                num = Integer.valueOf(bool16.booleanValue() ? 1 : 0);
            }
            if (num == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindLong(110, (long) num.intValue());
            }
            String str41 = deviceInfoMetric.appVersionName;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindString(111, str41);
            }
            supportSQLiteStatement.bindLong(112, deviceInfoMetric.appVersionCode);
            supportSQLiteStatement.bindLong(113, deviceInfoMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(114, (long) deviceInfoMetric.duplexModeState);
            supportSQLiteStatement.bindLong(115, (long) deviceInfoMetric.dozeModeState);
            supportSQLiteStatement.bindLong(116, (long) deviceInfoMetric.callState);
            String str42 = deviceInfoMetric.buildDevice;
            if (str42 == null) {
                supportSQLiteStatement.bindNull(117);
            } else {
                supportSQLiteStatement.bindString(117, str42);
            }
            String str43 = deviceInfoMetric.buildHardware;
            if (str43 == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindString(118, str43);
            }
            String str44 = deviceInfoMetric.buildProduct;
            if (str44 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, str44);
            }
            String str45 = deviceInfoMetric.appId;
            if (str45 == null) {
                supportSQLiteStatement.bindNull(120);
            } else {
                supportSQLiteStatement.bindString(120, str45);
            }
            supportSQLiteStatement.bindLong(121, deviceInfoMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `DeviceInfoMetric` (`lteFrequencySupport`,`nrFrequencySupport`,`ueCategory`,`is4gCapable`,`is5gCapable`,`volteSupport`,`deviceYear`,`maximumStorage`,`freeStorage`,`ram`,`freeRam`,`cpuUsage`,`batteryLevel`,`batteryState`,`batteryChargeType`,`batteryHealth`,`batteryTemperature`,`language`,`locale`,`userAgent`,`screenWidth`,`screenHeight`,`elapsedRealtimeNanos`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM deviceinfometric";
        }
    }

    public DeviceInfoDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(DeviceInfoMetric deviceInfoMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(deviceInfoMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<DeviceInfoMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<DeviceInfoMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        ArrayList arrayList;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
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
        int i13;
        int i14;
        int i15;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        int i16;
        int i17;
        int i18;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        int i19;
        Boolean bool12;
        int i20;
        int i21;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from deviceinfometric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "lteFrequencySupport");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencySupport");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "ueCategory");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "is4gCapable");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "is5gCapable");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "volteSupport");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "deviceYear");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "maximumStorage");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "freeStorage");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "ram");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "freeRam");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "cpuUsage");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "batteryLevel");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "batteryState");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "batteryChargeType");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "batteryHealth");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "batteryTemperature");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "language");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "locale");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "userAgent");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "screenWidth");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "screenHeight");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "elapsedRealtimeNanos");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i22 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DeviceInfoMetric deviceInfoMetric = new DeviceInfoMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        deviceInfoMetric.lteFrequencySupport = null;
                    } else {
                        arrayList = arrayList2;
                        deviceInfoMetric.lteFrequencySupport = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        deviceInfoMetric.nrFrequencySupport = null;
                    } else {
                        deviceInfoMetric.nrFrequencySupport = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        deviceInfoMetric.ueCategory = null;
                    } else {
                        deviceInfoMetric.ueCategory = query.getString(columnIndexOrThrow3);
                    }
                    Integer valueOf = query.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow4));
                    if (valueOf == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    deviceInfoMetric.is4gCapable = bool;
                    Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    if (valueOf2 == null) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    deviceInfoMetric.is5gCapable = bool2;
                    Integer valueOf3 = query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6));
                    if (valueOf3 == null) {
                        bool3 = null;
                    } else {
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    deviceInfoMetric.volteSupport = bool3;
                    if (query.isNull(columnIndexOrThrow7)) {
                        deviceInfoMetric.deviceYear = null;
                    } else {
                        deviceInfoMetric.deviceYear = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        deviceInfoMetric.maximumStorage = null;
                    } else {
                        deviceInfoMetric.maximumStorage = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        deviceInfoMetric.freeStorage = null;
                    } else {
                        deviceInfoMetric.freeStorage = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        deviceInfoMetric.ram = null;
                    } else {
                        deviceInfoMetric.ram = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        deviceInfoMetric.freeRam = null;
                    } else {
                        deviceInfoMetric.freeRam = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    }
                    deviceInfoMetric.cpuUsage = query.getInt(columnIndexOrThrow12);
                    int i23 = i22;
                    if (query.isNull(i23)) {
                        i = columnIndexOrThrow11;
                        deviceInfoMetric.batteryLevel = null;
                    } else {
                        i = columnIndexOrThrow11;
                        deviceInfoMetric.batteryLevel = Float.valueOf(query.getFloat(i23));
                    }
                    int i24 = columnIndexOrThrow14;
                    if (query.isNull(i24)) {
                        i2 = i23;
                        deviceInfoMetric.batteryState = null;
                    } else {
                        i2 = i23;
                        deviceInfoMetric.batteryState = Integer.valueOf(query.getInt(i24));
                    }
                    int i25 = columnIndexOrThrow15;
                    if (query.isNull(i25)) {
                        i3 = i24;
                        deviceInfoMetric.batteryChargeType = null;
                    } else {
                        i3 = i24;
                        deviceInfoMetric.batteryChargeType = Integer.valueOf(query.getInt(i25));
                    }
                    int i26 = columnIndexOrThrow16;
                    if (query.isNull(i26)) {
                        i4 = i25;
                        deviceInfoMetric.batteryHealth = null;
                    } else {
                        i4 = i25;
                        deviceInfoMetric.batteryHealth = Integer.valueOf(query.getInt(i26));
                    }
                    int i27 = columnIndexOrThrow17;
                    if (query.isNull(i27)) {
                        i5 = i26;
                        deviceInfoMetric.batteryTemperature = null;
                    } else {
                        i5 = i26;
                        deviceInfoMetric.batteryTemperature = Float.valueOf(query.getFloat(i27));
                    }
                    int i28 = columnIndexOrThrow18;
                    if (query.isNull(i28)) {
                        i6 = i27;
                        deviceInfoMetric.language = null;
                    } else {
                        i6 = i27;
                        deviceInfoMetric.language = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow19;
                    if (query.isNull(i29)) {
                        i7 = i28;
                        deviceInfoMetric.locale = null;
                    } else {
                        i7 = i28;
                        deviceInfoMetric.locale = query.getString(i29);
                    }
                    int i30 = columnIndexOrThrow20;
                    if (query.isNull(i30)) {
                        i8 = i29;
                        deviceInfoMetric.userAgent = null;
                    } else {
                        i8 = i29;
                        deviceInfoMetric.userAgent = query.getString(i30);
                    }
                    int i31 = columnIndexOrThrow21;
                    if (query.isNull(i31)) {
                        i9 = i30;
                        deviceInfoMetric.screenWidth = null;
                    } else {
                        i9 = i30;
                        deviceInfoMetric.screenWidth = Integer.valueOf(query.getInt(i31));
                    }
                    int i32 = columnIndexOrThrow22;
                    if (query.isNull(i32)) {
                        i10 = i31;
                        deviceInfoMetric.screenHeight = null;
                    } else {
                        i10 = i31;
                        deviceInfoMetric.screenHeight = Integer.valueOf(query.getInt(i32));
                    }
                    int i33 = columnIndexOrThrow23;
                    if (query.isNull(i33)) {
                        i11 = i32;
                        deviceInfoMetric.elapsedRealtimeNanos = null;
                    } else {
                        i11 = i32;
                        deviceInfoMetric.elapsedRealtimeNanos = Long.valueOf(query.getLong(i33));
                    }
                    int i34 = columnIndexOrThrow12;
                    int i35 = columnIndexOrThrow24;
                    int i36 = columnIndexOrThrow;
                    deviceInfoMetric.id = query.getLong(i35);
                    int i37 = columnIndexOrThrow25;
                    if (query.isNull(i37)) {
                        deviceInfoMetric.mobileClientId = null;
                    } else {
                        deviceInfoMetric.mobileClientId = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow26;
                    if (query.isNull(i38)) {
                        i12 = i33;
                        deviceInfoMetric.measurementSequenceId = null;
                    } else {
                        i12 = i33;
                        deviceInfoMetric.measurementSequenceId = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow27;
                    if (query.isNull(i39)) {
                        i13 = i35;
                        deviceInfoMetric.clientIp = null;
                    } else {
                        i13 = i35;
                        deviceInfoMetric.clientIp = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow28;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow27 = i39;
                        deviceInfoMetric.dateTimeOfMeasurement = null;
                    } else {
                        columnIndexOrThrow27 = i39;
                        deviceInfoMetric.dateTimeOfMeasurement = query.getString(i40);
                    }
                    columnIndexOrThrow28 = i40;
                    int i41 = columnIndexOrThrow29;
                    deviceInfoMetric.stateDuringMeasurement = query.getInt(i41);
                    int i42 = columnIndexOrThrow30;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow29 = i41;
                        deviceInfoMetric.accessTechnology = null;
                    } else {
                        columnIndexOrThrow29 = i41;
                        deviceInfoMetric.accessTechnology = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow31;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow30 = i42;
                        deviceInfoMetric.accessTypeRaw = null;
                    } else {
                        columnIndexOrThrow30 = i42;
                        deviceInfoMetric.accessTypeRaw = query.getString(i43);
                    }
                    columnIndexOrThrow31 = i43;
                    int i44 = columnIndexOrThrow32;
                    deviceInfoMetric.signalStrength = query.getInt(i44);
                    columnIndexOrThrow32 = i44;
                    int i45 = columnIndexOrThrow33;
                    deviceInfoMetric.interference = query.getInt(i45);
                    int i46 = columnIndexOrThrow34;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow33 = i45;
                        deviceInfoMetric.simMCC = null;
                    } else {
                        columnIndexOrThrow33 = i45;
                        deviceInfoMetric.simMCC = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow35;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow34 = i46;
                        deviceInfoMetric.simMNC = null;
                    } else {
                        columnIndexOrThrow34 = i46;
                        deviceInfoMetric.simMNC = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow36;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow35 = i47;
                        deviceInfoMetric.secondarySimMCC = null;
                    } else {
                        columnIndexOrThrow35 = i47;
                        deviceInfoMetric.secondarySimMCC = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow37;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow36 = i48;
                        deviceInfoMetric.secondarySimMNC = null;
                    } else {
                        columnIndexOrThrow36 = i48;
                        deviceInfoMetric.secondarySimMNC = query.getString(i49);
                    }
                    columnIndexOrThrow37 = i49;
                    int i50 = columnIndexOrThrow38;
                    deviceInfoMetric.numberOfSimSlots = query.getInt(i50);
                    columnIndexOrThrow38 = i50;
                    int i51 = columnIndexOrThrow39;
                    deviceInfoMetric.dataSimSlotNumber = query.getInt(i51);
                    int i52 = columnIndexOrThrow40;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow39 = i51;
                        deviceInfoMetric.networkMCC = null;
                    } else {
                        columnIndexOrThrow39 = i51;
                        deviceInfoMetric.networkMCC = query.getString(i52);
                    }
                    int i53 = columnIndexOrThrow41;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow40 = i52;
                        deviceInfoMetric.networkMNC = null;
                    } else {
                        columnIndexOrThrow40 = i52;
                        deviceInfoMetric.networkMNC = query.getString(i53);
                    }
                    int i54 = i37;
                    int i55 = columnIndexOrThrow42;
                    int i56 = i38;
                    deviceInfoMetric.latitude = query.getDouble(i55);
                    int i57 = i53;
                    int i58 = columnIndexOrThrow43;
                    int i59 = i55;
                    deviceInfoMetric.longitude = query.getDouble(i58);
                    int i60 = i58;
                    int i61 = columnIndexOrThrow44;
                    int i62 = i57;
                    deviceInfoMetric.gpsAccuracy = query.getDouble(i61);
                    int i63 = columnIndexOrThrow45;
                    if (query.isNull(i63)) {
                        deviceInfoMetric.cellId = null;
                    } else {
                        deviceInfoMetric.cellId = query.getString(i63);
                    }
                    int i64 = columnIndexOrThrow46;
                    if (query.isNull(i64)) {
                        i14 = i61;
                        deviceInfoMetric.lacId = null;
                    } else {
                        i14 = i61;
                        deviceInfoMetric.lacId = query.getString(i64);
                    }
                    int i65 = columnIndexOrThrow47;
                    if (query.isNull(i65)) {
                        i15 = i60;
                        deviceInfoMetric.deviceBrand = null;
                    } else {
                        i15 = i60;
                        deviceInfoMetric.deviceBrand = query.getString(i65);
                    }
                    int i66 = columnIndexOrThrow48;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow47 = i65;
                        deviceInfoMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow47 = i65;
                        deviceInfoMetric.deviceModel = query.getString(i66);
                    }
                    int i67 = columnIndexOrThrow49;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow48 = i66;
                        deviceInfoMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow48 = i66;
                        deviceInfoMetric.deviceVersion = query.getString(i67);
                    }
                    int i68 = columnIndexOrThrow50;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow49 = i67;
                        deviceInfoMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow49 = i67;
                        deviceInfoMetric.sdkVersionNumber = query.getString(i68);
                    }
                    int i69 = columnIndexOrThrow51;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow50 = i68;
                        deviceInfoMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow50 = i68;
                        deviceInfoMetric.carrierName = query.getString(i69);
                    }
                    int i70 = columnIndexOrThrow52;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow51 = i69;
                        deviceInfoMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow51 = i69;
                        deviceInfoMetric.secondaryCarrierName = query.getString(i70);
                    }
                    int i71 = columnIndexOrThrow53;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow52 = i70;
                        deviceInfoMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow52 = i70;
                        deviceInfoMetric.networkOperatorName = query.getString(i71);
                    }
                    int i72 = columnIndexOrThrow54;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow53 = i71;
                        deviceInfoMetric.os = null;
                    } else {
                        columnIndexOrThrow53 = i71;
                        deviceInfoMetric.os = query.getString(i72);
                    }
                    int i73 = columnIndexOrThrow55;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow54 = i72;
                        deviceInfoMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow54 = i72;
                        deviceInfoMetric.osVersion = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow56;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow55 = i73;
                        deviceInfoMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow55 = i73;
                        deviceInfoMetric.readableDate = query.getString(i74);
                    }
                    int i75 = columnIndexOrThrow57;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow56 = i74;
                        deviceInfoMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow56 = i74;
                        deviceInfoMetric.physicalCellId = Integer.valueOf(query.getInt(i75));
                    }
                    int i76 = columnIndexOrThrow58;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow57 = i75;
                        deviceInfoMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow57 = i75;
                        deviceInfoMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow59;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow58 = i76;
                        deviceInfoMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow58 = i76;
                        deviceInfoMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i77));
                    }
                    int i78 = columnIndexOrThrow60;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow59 = i77;
                        deviceInfoMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow59 = i77;
                        deviceInfoMetric.cellBands = query.getString(i78);
                    }
                    int i79 = columnIndexOrThrow61;
                    if (query.isNull(i79)) {
                        columnIndexOrThrow60 = i78;
                        deviceInfoMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow60 = i78;
                        deviceInfoMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i79));
                    }
                    int i80 = columnIndexOrThrow62;
                    if (query.isNull(i80)) {
                        columnIndexOrThrow61 = i79;
                        deviceInfoMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow61 = i79;
                        deviceInfoMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i80));
                    }
                    int i81 = columnIndexOrThrow63;
                    if (query.isNull(i81)) {
                        columnIndexOrThrow62 = i80;
                        deviceInfoMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow62 = i80;
                        deviceInfoMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i81));
                    }
                    int i82 = columnIndexOrThrow64;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow63 = i81;
                        deviceInfoMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow63 = i81;
                        deviceInfoMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i82));
                    }
                    int i83 = columnIndexOrThrow65;
                    if (query.isNull(i83)) {
                        columnIndexOrThrow64 = i82;
                        deviceInfoMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow64 = i82;
                        deviceInfoMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i83));
                    }
                    int i84 = columnIndexOrThrow66;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow65 = i83;
                        deviceInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow65 = i83;
                        deviceInfoMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i84));
                    }
                    int i85 = columnIndexOrThrow67;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow66 = i84;
                        deviceInfoMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow66 = i84;
                        deviceInfoMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i85));
                    }
                    int i86 = columnIndexOrThrow68;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow67 = i85;
                        deviceInfoMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow67 = i85;
                        deviceInfoMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i86));
                    }
                    int i87 = columnIndexOrThrow69;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow68 = i86;
                        deviceInfoMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow68 = i86;
                        deviceInfoMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow70;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow69 = i87;
                        deviceInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow69 = i87;
                        deviceInfoMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i88));
                    }
                    int i89 = columnIndexOrThrow71;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow70 = i88;
                        deviceInfoMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow70 = i88;
                        deviceInfoMetric.timingAdvance = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow72;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow71 = i89;
                        deviceInfoMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow71 = i89;
                        deviceInfoMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow73;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow72 = i90;
                        deviceInfoMetric.dbm = null;
                    } else {
                        columnIndexOrThrow72 = i90;
                        deviceInfoMetric.dbm = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow74;
                    if (query.isNull(i92)) {
                        columnIndexOrThrow73 = i91;
                        deviceInfoMetric.debugString = null;
                    } else {
                        columnIndexOrThrow73 = i91;
                        deviceInfoMetric.debugString = query.getString(i92);
                    }
                    int i93 = columnIndexOrThrow75;
                    Integer valueOf4 = query.isNull(i93) ? null : Integer.valueOf(query.getInt(i93));
                    if (valueOf4 == null) {
                        columnIndexOrThrow75 = i93;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow75 = i93;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    deviceInfoMetric.isDcNrRestricted = bool4;
                    int i94 = columnIndexOrThrow76;
                    Integer valueOf5 = query.isNull(i94) ? null : Integer.valueOf(query.getInt(i94));
                    if (valueOf5 == null) {
                        columnIndexOrThrow76 = i94;
                        bool5 = null;
                    } else {
                        columnIndexOrThrow76 = i94;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    deviceInfoMetric.isNrAvailable = bool5;
                    int i95 = columnIndexOrThrow77;
                    Integer valueOf6 = query.isNull(i95) ? null : Integer.valueOf(query.getInt(i95));
                    if (valueOf6 == null) {
                        columnIndexOrThrow77 = i95;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow77 = i95;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    deviceInfoMetric.isEnDcAvailable = bool6;
                    int i96 = columnIndexOrThrow78;
                    if (query.isNull(i96)) {
                        columnIndexOrThrow74 = i92;
                        deviceInfoMetric.nrState = null;
                    } else {
                        columnIndexOrThrow74 = i92;
                        deviceInfoMetric.nrState = query.getString(i96);
                    }
                    int i97 = columnIndexOrThrow79;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow78 = i96;
                        deviceInfoMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow78 = i96;
                        deviceInfoMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i97));
                    }
                    int i98 = columnIndexOrThrow80;
                    Integer valueOf7 = query.isNull(i98) ? null : Integer.valueOf(query.getInt(i98));
                    if (valueOf7 == null) {
                        columnIndexOrThrow80 = i98;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow80 = i98;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    deviceInfoMetric.isUsingCarrierAggregation = bool7;
                    int i99 = columnIndexOrThrow81;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow79 = i97;
                        deviceInfoMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow79 = i97;
                        deviceInfoMetric.vopsSupport = Integer.valueOf(query.getInt(i99));
                    }
                    int i100 = columnIndexOrThrow82;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow81 = i99;
                        deviceInfoMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow81 = i99;
                        deviceInfoMetric.cellBandwidths = query.getString(i100);
                    }
                    int i101 = columnIndexOrThrow83;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow82 = i100;
                        deviceInfoMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow82 = i100;
                        deviceInfoMetric.additionalPlmns = query.getString(i101);
                    }
                    int i102 = i63;
                    int i103 = columnIndexOrThrow84;
                    int i104 = i64;
                    deviceInfoMetric.altitude = query.getDouble(i103);
                    int i105 = columnIndexOrThrow85;
                    if (query.isNull(i105)) {
                        deviceInfoMetric.locationSpeed = null;
                    } else {
                        deviceInfoMetric.locationSpeed = Float.valueOf(query.getFloat(i105));
                    }
                    int i106 = columnIndexOrThrow86;
                    if (query.isNull(i106)) {
                        i16 = i101;
                        deviceInfoMetric.locationSpeedAccuracy = null;
                    } else {
                        i16 = i101;
                        deviceInfoMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i106));
                    }
                    int i107 = columnIndexOrThrow87;
                    if (query.isNull(i107)) {
                        i17 = i103;
                        deviceInfoMetric.gpsVerticalAccuracy = null;
                    } else {
                        i17 = i103;
                        deviceInfoMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i107));
                    }
                    columnIndexOrThrow87 = i107;
                    int i108 = columnIndexOrThrow88;
                    deviceInfoMetric.getRestrictBackgroundStatus = query.getInt(i108);
                    int i109 = columnIndexOrThrow89;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow88 = i108;
                        deviceInfoMetric.cellType = null;
                    } else {
                        columnIndexOrThrow88 = i108;
                        deviceInfoMetric.cellType = query.getString(i109);
                    }
                    int i110 = columnIndexOrThrow90;
                    Integer valueOf8 = query.isNull(i110) ? null : Integer.valueOf(query.getInt(i110));
                    if (valueOf8 == null) {
                        i18 = i109;
                        bool8 = null;
                    } else {
                        i18 = i109;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    deviceInfoMetric.isDefaultNetworkActive = bool8;
                    int i111 = columnIndexOrThrow91;
                    Integer valueOf9 = query.isNull(i111) ? null : Integer.valueOf(query.getInt(i111));
                    if (valueOf9 == null) {
                        columnIndexOrThrow91 = i111;
                        bool9 = null;
                    } else {
                        columnIndexOrThrow91 = i111;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    deviceInfoMetric.isActiveNetworkMetered = bool9;
                    int i112 = columnIndexOrThrow92;
                    Integer valueOf10 = query.isNull(i112) ? null : Integer.valueOf(query.getInt(i112));
                    if (valueOf10 == null) {
                        columnIndexOrThrow92 = i112;
                        bool10 = null;
                    } else {
                        columnIndexOrThrow92 = i112;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    deviceInfoMetric.isOnScreen = bool10;
                    int i113 = columnIndexOrThrow93;
                    Integer valueOf11 = query.isNull(i113) ? null : Integer.valueOf(query.getInt(i113));
                    if (valueOf11 == null) {
                        columnIndexOrThrow93 = i113;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow93 = i113;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    deviceInfoMetric.isRoaming = bool11;
                    int i114 = i110;
                    int i115 = columnIndexOrThrow94;
                    deviceInfoMetric.locationAge = query.getInt(i115);
                    int i116 = columnIndexOrThrow95;
                    if (query.isNull(i116)) {
                        columnIndexOrThrow94 = i115;
                        deviceInfoMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow94 = i115;
                        deviceInfoMetric.overrideNetworkType = Integer.valueOf(query.getInt(i116));
                    }
                    int i117 = columnIndexOrThrow96;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow95 = i116;
                        deviceInfoMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow95 = i116;
                        deviceInfoMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i117));
                    }
                    int i118 = columnIndexOrThrow97;
                    Integer valueOf12 = query.isNull(i118) ? null : Integer.valueOf(query.getInt(i118));
                    if (valueOf12 == null) {
                        i19 = i117;
                        bool12 = null;
                    } else {
                        i19 = i117;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    deviceInfoMetric.anonymize = bool12;
                    int i119 = columnIndexOrThrow98;
                    if (query.isNull(i119)) {
                        i20 = i118;
                        deviceInfoMetric.sdkOrigin = null;
                    } else {
                        i20 = i118;
                        deviceInfoMetric.sdkOrigin = query.getString(i119);
                    }
                    int i120 = columnIndexOrThrow99;
                    Integer valueOf13 = query.isNull(i120) ? null : Integer.valueOf(query.getInt(i120));
                    if (valueOf13 == null) {
                        i21 = i119;
                        bool13 = null;
                    } else {
                        i21 = i119;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    deviceInfoMetric.isRooted = bool13;
                    int i121 = columnIndexOrThrow100;
                    Integer valueOf14 = query.isNull(i121) ? null : Integer.valueOf(query.getInt(i121));
                    if (valueOf14 == null) {
                        columnIndexOrThrow100 = i121;
                        bool14 = null;
                    } else {
                        columnIndexOrThrow100 = i121;
                        bool14 = Boolean.valueOf(valueOf14.intValue() != 0);
                    }
                    deviceInfoMetric.isConnectedToVpn = bool14;
                    int i122 = i120;
                    int i123 = columnIndexOrThrow101;
                    deviceInfoMetric.linkDownstreamBandwidth = query.getInt(i123);
                    columnIndexOrThrow101 = i123;
                    int i124 = columnIndexOrThrow102;
                    deviceInfoMetric.linkUpstreamBandwidth = query.getInt(i124);
                    columnIndexOrThrow102 = i124;
                    int i125 = columnIndexOrThrow103;
                    deviceInfoMetric.latencyType = query.getInt(i125);
                    int i126 = columnIndexOrThrow104;
                    if (query.isNull(i126)) {
                        columnIndexOrThrow103 = i125;
                        deviceInfoMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow103 = i125;
                        deviceInfoMetric.serverIp = query.getString(i126);
                    }
                    int i127 = columnIndexOrThrow105;
                    if (query.isNull(i127)) {
                        columnIndexOrThrow104 = i126;
                        deviceInfoMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow104 = i126;
                        deviceInfoMetric.privateIp = query.getString(i127);
                    }
                    int i128 = columnIndexOrThrow106;
                    if (query.isNull(i128)) {
                        columnIndexOrThrow105 = i127;
                        deviceInfoMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow105 = i127;
                        deviceInfoMetric.gatewayIp = query.getString(i128);
                    }
                    int i129 = columnIndexOrThrow107;
                    if (query.isNull(i129)) {
                        columnIndexOrThrow106 = i128;
                        deviceInfoMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow106 = i128;
                        deviceInfoMetric.locationPermissionState = Integer.valueOf(query.getInt(i129));
                    }
                    int i130 = columnIndexOrThrow108;
                    if (query.isNull(i130)) {
                        columnIndexOrThrow107 = i129;
                        deviceInfoMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow107 = i129;
                        deviceInfoMetric.serviceStateStatus = Integer.valueOf(query.getInt(i130));
                    }
                    int i131 = columnIndexOrThrow109;
                    Integer valueOf15 = query.isNull(i131) ? null : Integer.valueOf(query.getInt(i131));
                    if (valueOf15 == null) {
                        columnIndexOrThrow109 = i131;
                        bool15 = null;
                    } else {
                        columnIndexOrThrow109 = i131;
                        bool15 = Boolean.valueOf(valueOf15.intValue() != 0);
                    }
                    deviceInfoMetric.isNrCellSeen = bool15;
                    int i132 = columnIndexOrThrow110;
                    Integer valueOf16 = query.isNull(i132) ? null : Integer.valueOf(query.getInt(i132));
                    if (valueOf16 == null) {
                        columnIndexOrThrow110 = i132;
                        bool16 = null;
                    } else {
                        columnIndexOrThrow110 = i132;
                        bool16 = Boolean.valueOf(valueOf16.intValue() != 0);
                    }
                    deviceInfoMetric.isReadPhoneStatePermissionGranted = bool16;
                    int i133 = columnIndexOrThrow111;
                    if (query.isNull(i133)) {
                        columnIndexOrThrow108 = i130;
                        deviceInfoMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow108 = i130;
                        deviceInfoMetric.appVersionName = query.getString(i133);
                    }
                    int i134 = i105;
                    int i135 = columnIndexOrThrow112;
                    int i136 = i106;
                    deviceInfoMetric.appVersionCode = query.getLong(i135);
                    int i137 = i133;
                    int i138 = columnIndexOrThrow113;
                    int i139 = i135;
                    deviceInfoMetric.appLastUpdateTime = query.getLong(i138);
                    int i140 = columnIndexOrThrow114;
                    deviceInfoMetric.duplexModeState = query.getInt(i140);
                    columnIndexOrThrow114 = i140;
                    int i141 = columnIndexOrThrow115;
                    deviceInfoMetric.dozeModeState = query.getInt(i141);
                    columnIndexOrThrow115 = i141;
                    int i142 = columnIndexOrThrow116;
                    deviceInfoMetric.callState = query.getInt(i142);
                    int i143 = columnIndexOrThrow117;
                    if (query.isNull(i143)) {
                        columnIndexOrThrow116 = i142;
                        deviceInfoMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow116 = i142;
                        deviceInfoMetric.buildDevice = query.getString(i143);
                    }
                    int i144 = columnIndexOrThrow118;
                    if (query.isNull(i144)) {
                        columnIndexOrThrow117 = i143;
                        deviceInfoMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow117 = i143;
                        deviceInfoMetric.buildHardware = query.getString(i144);
                    }
                    int i145 = columnIndexOrThrow119;
                    if (query.isNull(i145)) {
                        columnIndexOrThrow118 = i144;
                        deviceInfoMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow118 = i144;
                        deviceInfoMetric.buildProduct = query.getString(i145);
                    }
                    int i146 = columnIndexOrThrow120;
                    if (query.isNull(i146)) {
                        columnIndexOrThrow119 = i145;
                        deviceInfoMetric.appId = null;
                    } else {
                        columnIndexOrThrow119 = i145;
                        deviceInfoMetric.appId = query.getString(i146);
                    }
                    int i147 = columnIndexOrThrow121;
                    if (query.getInt(i147) != 0) {
                        columnIndexOrThrow120 = i146;
                        z = true;
                    } else {
                        columnIndexOrThrow120 = i146;
                        z = false;
                    }
                    deviceInfoMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(deviceInfoMetric);
                    columnIndexOrThrow121 = i147;
                    columnIndexOrThrow11 = i;
                    i22 = i2;
                    columnIndexOrThrow14 = i3;
                    columnIndexOrThrow15 = i4;
                    columnIndexOrThrow16 = i5;
                    columnIndexOrThrow17 = i6;
                    columnIndexOrThrow18 = i7;
                    columnIndexOrThrow19 = i8;
                    columnIndexOrThrow20 = i9;
                    columnIndexOrThrow21 = i10;
                    columnIndexOrThrow22 = i11;
                    columnIndexOrThrow23 = i12;
                    columnIndexOrThrow25 = i54;
                    columnIndexOrThrow41 = i62;
                    columnIndexOrThrow44 = i14;
                    columnIndexOrThrow45 = i102;
                    columnIndexOrThrow83 = i16;
                    columnIndexOrThrow85 = i134;
                    columnIndexOrThrow111 = i137;
                    columnIndexOrThrow = i36;
                    columnIndexOrThrow24 = i13;
                    columnIndexOrThrow26 = i56;
                    columnIndexOrThrow42 = i59;
                    columnIndexOrThrow43 = i15;
                    columnIndexOrThrow46 = i104;
                    columnIndexOrThrow84 = i17;
                    columnIndexOrThrow86 = i136;
                    columnIndexOrThrow112 = i139;
                    columnIndexOrThrow113 = i138;
                    columnIndexOrThrow12 = i34;
                    int i148 = i18;
                    columnIndexOrThrow90 = i114;
                    columnIndexOrThrow89 = i148;
                    int i149 = i19;
                    columnIndexOrThrow97 = i20;
                    columnIndexOrThrow96 = i149;
                    int i150 = i21;
                    columnIndexOrThrow99 = i122;
                    columnIndexOrThrow98 = i150;
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
