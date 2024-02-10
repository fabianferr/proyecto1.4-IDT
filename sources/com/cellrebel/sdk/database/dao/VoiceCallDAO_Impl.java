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
import com.cellrebel.sdk.networking.beans.request.VoiceCallMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class VoiceCallDAO_Impl implements VoiceCallDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<VoiceCallMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<VoiceCallMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, VoiceCallMetric voiceCallMetric) {
            supportSQLiteStatement.bindLong(1, (long) voiceCallMetric.callStartTime);
            supportSQLiteStatement.bindLong(2, (long) voiceCallMetric.callEndTime);
            supportSQLiteStatement.bindLong(3, voiceCallMetric.id);
            String str = voiceCallMetric.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str);
            }
            String str2 = voiceCallMetric.measurementSequenceId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str2);
            }
            String str3 = voiceCallMetric.clientIp;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str3);
            }
            String str4 = voiceCallMetric.dateTimeOfMeasurement;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str4);
            }
            supportSQLiteStatement.bindLong(8, (long) voiceCallMetric.stateDuringMeasurement);
            String str5 = voiceCallMetric.accessTechnology;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str5);
            }
            String str6 = voiceCallMetric.accessTypeRaw;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, str6);
            }
            supportSQLiteStatement.bindLong(11, (long) voiceCallMetric.signalStrength);
            supportSQLiteStatement.bindLong(12, (long) voiceCallMetric.interference);
            String str7 = voiceCallMetric.simMCC;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str7);
            }
            String str8 = voiceCallMetric.simMNC;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str8);
            }
            String str9 = voiceCallMetric.secondarySimMCC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str9);
            }
            String str10 = voiceCallMetric.secondarySimMNC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str10);
            }
            supportSQLiteStatement.bindLong(17, (long) voiceCallMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(18, (long) voiceCallMetric.dataSimSlotNumber);
            String str11 = voiceCallMetric.networkMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str11);
            }
            String str12 = voiceCallMetric.networkMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str12);
            }
            supportSQLiteStatement.bindDouble(21, voiceCallMetric.latitude);
            supportSQLiteStatement.bindDouble(22, voiceCallMetric.longitude);
            supportSQLiteStatement.bindDouble(23, voiceCallMetric.gpsAccuracy);
            String str13 = voiceCallMetric.cellId;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str13);
            }
            String str14 = voiceCallMetric.lacId;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str14);
            }
            String str15 = voiceCallMetric.deviceBrand;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str15);
            }
            String str16 = voiceCallMetric.deviceModel;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str16);
            }
            String str17 = voiceCallMetric.deviceVersion;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str17);
            }
            String str18 = voiceCallMetric.sdkVersionNumber;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str18);
            }
            String str19 = voiceCallMetric.carrierName;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str19);
            }
            String str20 = voiceCallMetric.secondaryCarrierName;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str20);
            }
            String str21 = voiceCallMetric.networkOperatorName;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str21);
            }
            String str22 = voiceCallMetric.os;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str22);
            }
            String str23 = voiceCallMetric.osVersion;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str23);
            }
            String str24 = voiceCallMetric.readableDate;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str24);
            }
            Integer num = voiceCallMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindLong(36, (long) num.intValue());
            }
            Integer num2 = voiceCallMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindLong(37, (long) num2.intValue());
            }
            Integer num3 = voiceCallMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindLong(38, (long) num3.intValue());
            }
            String str25 = voiceCallMetric.cellBands;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str25);
            }
            Integer num4 = voiceCallMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num4.intValue());
            }
            Integer num5 = voiceCallMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindLong(41, (long) num5.intValue());
            }
            Integer num6 = voiceCallMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindLong(42, (long) num6.intValue());
            }
            Integer num7 = voiceCallMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) num7.intValue());
            }
            Integer num8 = voiceCallMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num8.intValue());
            }
            Integer num9 = voiceCallMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num9.intValue());
            }
            Integer num10 = voiceCallMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num10.intValue());
            }
            Integer num11 = voiceCallMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num11.intValue());
            }
            Integer num12 = voiceCallMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num12.intValue());
            }
            Integer num13 = voiceCallMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num13.intValue());
            }
            Integer num14 = voiceCallMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num14.intValue());
            }
            Integer num15 = voiceCallMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num15.intValue());
            }
            Integer num16 = voiceCallMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num16.intValue());
            }
            String str26 = voiceCallMetric.debugString;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str26);
            }
            Boolean bool = voiceCallMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) valueOf.intValue());
            }
            Boolean bool2 = voiceCallMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) valueOf2.intValue());
            }
            Boolean bool3 = voiceCallMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) valueOf3.intValue());
            }
            String str27 = voiceCallMetric.nrState;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str27);
            }
            Integer num18 = voiceCallMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num18.intValue());
            }
            Boolean bool4 = voiceCallMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) valueOf4.intValue());
            }
            Integer num19 = voiceCallMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num19.intValue());
            }
            String str28 = voiceCallMetric.cellBandwidths;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str28);
            }
            String str29 = voiceCallMetric.additionalPlmns;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindString(62, str29);
            }
            supportSQLiteStatement.bindDouble(63, voiceCallMetric.altitude);
            Float f = voiceCallMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindDouble(64, (double) f.floatValue());
            }
            Float f2 = voiceCallMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindDouble(65, (double) f2.floatValue());
            }
            Float f3 = voiceCallMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindDouble(66, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(67, (long) voiceCallMetric.getRestrictBackgroundStatus);
            String str30 = voiceCallMetric.cellType;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindString(68, str30);
            }
            Boolean bool5 = voiceCallMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) valueOf5.intValue());
            }
            Boolean bool6 = voiceCallMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) valueOf6.intValue());
            }
            Boolean bool7 = voiceCallMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) valueOf7.intValue());
            }
            Boolean bool8 = voiceCallMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(73, (long) voiceCallMetric.locationAge);
            Integer num20 = voiceCallMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num20.intValue());
            }
            Integer num21 = voiceCallMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) num21.intValue());
            }
            Boolean bool9 = voiceCallMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) valueOf9.intValue());
            }
            String str31 = voiceCallMetric.sdkOrigin;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindString(77, str31);
            }
            Boolean bool10 = voiceCallMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf10.intValue());
            }
            Boolean bool11 = voiceCallMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(80, (long) voiceCallMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(81, (long) voiceCallMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(82, (long) voiceCallMetric.latencyType);
            String str32 = voiceCallMetric.serverIp;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str32);
            }
            String str33 = voiceCallMetric.privateIp;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindString(84, str33);
            }
            String str34 = voiceCallMetric.gatewayIp;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str34);
            }
            Integer num22 = voiceCallMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) num22.intValue());
            }
            Integer num23 = voiceCallMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) num23.intValue());
            }
            Boolean bool12 = voiceCallMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) valueOf12.intValue());
            }
            Boolean bool13 = voiceCallMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) num17.intValue());
            }
            String str35 = voiceCallMetric.appVersionName;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindString(90, str35);
            }
            supportSQLiteStatement.bindLong(91, voiceCallMetric.appVersionCode);
            supportSQLiteStatement.bindLong(92, voiceCallMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(93, (long) voiceCallMetric.duplexModeState);
            supportSQLiteStatement.bindLong(94, (long) voiceCallMetric.dozeModeState);
            supportSQLiteStatement.bindLong(95, (long) voiceCallMetric.callState);
            String str36 = voiceCallMetric.buildDevice;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str36);
            }
            String str37 = voiceCallMetric.buildHardware;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindString(97, str37);
            }
            String str38 = voiceCallMetric.buildProduct;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str38);
            }
            String str39 = voiceCallMetric.appId;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindString(99, str39);
            }
            supportSQLiteStatement.bindLong(100, voiceCallMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `VoiceCallMetric` (`callStartTime`,`callEndTime`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM voicecallmetric";
        }
    }

    public VoiceCallDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(VoiceCallMetric voiceCallMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(voiceCallMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<VoiceCallMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<VoiceCallMetric> b() {
        RoomSQLiteQuery roomSQLiteQuery;
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
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from voicecallmetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "callStartTime");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "callEndTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "interference");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i15 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    VoiceCallMetric voiceCallMetric = new VoiceCallMetric();
                    ArrayList arrayList2 = arrayList;
                    voiceCallMetric.callStartTime = query.getInt(columnIndexOrThrow);
                    voiceCallMetric.callEndTime = query.getInt(columnIndexOrThrow2);
                    int i16 = columnIndexOrThrow;
                    int i17 = columnIndexOrThrow2;
                    voiceCallMetric.id = query.getLong(columnIndexOrThrow3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        voiceCallMetric.mobileClientId = null;
                    } else {
                        voiceCallMetric.mobileClientId = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        voiceCallMetric.measurementSequenceId = null;
                    } else {
                        voiceCallMetric.measurementSequenceId = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        voiceCallMetric.clientIp = null;
                    } else {
                        voiceCallMetric.clientIp = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        voiceCallMetric.dateTimeOfMeasurement = null;
                    } else {
                        voiceCallMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow7);
                    }
                    voiceCallMetric.stateDuringMeasurement = query.getInt(columnIndexOrThrow8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        voiceCallMetric.accessTechnology = null;
                    } else {
                        voiceCallMetric.accessTechnology = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        voiceCallMetric.accessTypeRaw = null;
                    } else {
                        voiceCallMetric.accessTypeRaw = query.getString(columnIndexOrThrow10);
                    }
                    voiceCallMetric.signalStrength = query.getInt(columnIndexOrThrow11);
                    voiceCallMetric.interference = query.getInt(columnIndexOrThrow12);
                    int i18 = i15;
                    if (query.isNull(i18)) {
                        voiceCallMetric.simMCC = null;
                    } else {
                        voiceCallMetric.simMCC = query.getString(i18);
                    }
                    int i19 = columnIndexOrThrow14;
                    if (query.isNull(i19)) {
                        i = i16;
                        voiceCallMetric.simMNC = null;
                    } else {
                        i = i16;
                        voiceCallMetric.simMNC = query.getString(i19);
                    }
                    int i20 = columnIndexOrThrow15;
                    if (query.isNull(i20)) {
                        i2 = columnIndexOrThrow11;
                        voiceCallMetric.secondarySimMCC = null;
                    } else {
                        i2 = columnIndexOrThrow11;
                        voiceCallMetric.secondarySimMCC = query.getString(i20);
                    }
                    int i21 = columnIndexOrThrow16;
                    if (query.isNull(i21)) {
                        i3 = i20;
                        voiceCallMetric.secondarySimMNC = null;
                    } else {
                        i3 = i20;
                        voiceCallMetric.secondarySimMNC = query.getString(i21);
                    }
                    int i22 = columnIndexOrThrow17;
                    int i23 = i21;
                    voiceCallMetric.numberOfSimSlots = query.getInt(i22);
                    int i24 = columnIndexOrThrow18;
                    int i25 = i22;
                    voiceCallMetric.dataSimSlotNumber = query.getInt(i24);
                    int i26 = columnIndexOrThrow19;
                    if (query.isNull(i26)) {
                        i4 = i24;
                        voiceCallMetric.networkMCC = null;
                    } else {
                        i4 = i24;
                        voiceCallMetric.networkMCC = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow20;
                    if (query.isNull(i27)) {
                        i5 = i26;
                        voiceCallMetric.networkMNC = null;
                    } else {
                        i5 = i26;
                        voiceCallMetric.networkMNC = query.getString(i27);
                    }
                    i15 = i18;
                    int i28 = columnIndexOrThrow21;
                    int i29 = columnIndexOrThrow12;
                    voiceCallMetric.latitude = query.getDouble(i28);
                    int i30 = i27;
                    int i31 = columnIndexOrThrow22;
                    int i32 = i28;
                    voiceCallMetric.longitude = query.getDouble(i31);
                    int i33 = i31;
                    int i34 = columnIndexOrThrow23;
                    int i35 = i30;
                    voiceCallMetric.gpsAccuracy = query.getDouble(i34);
                    int i36 = columnIndexOrThrow24;
                    if (query.isNull(i36)) {
                        voiceCallMetric.cellId = null;
                    } else {
                        voiceCallMetric.cellId = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow25;
                    if (query.isNull(i37)) {
                        i6 = i34;
                        voiceCallMetric.lacId = null;
                    } else {
                        i6 = i34;
                        voiceCallMetric.lacId = query.getString(i37);
                    }
                    int i38 = columnIndexOrThrow26;
                    if (query.isNull(i38)) {
                        i7 = i33;
                        voiceCallMetric.deviceBrand = null;
                    } else {
                        i7 = i33;
                        voiceCallMetric.deviceBrand = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow27;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow26 = i38;
                        voiceCallMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow26 = i38;
                        voiceCallMetric.deviceModel = query.getString(i39);
                    }
                    int i40 = columnIndexOrThrow28;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow27 = i39;
                        voiceCallMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow27 = i39;
                        voiceCallMetric.deviceVersion = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow29;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow28 = i40;
                        voiceCallMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow28 = i40;
                        voiceCallMetric.sdkVersionNumber = query.getString(i41);
                    }
                    int i42 = columnIndexOrThrow30;
                    if (query.isNull(i42)) {
                        columnIndexOrThrow29 = i41;
                        voiceCallMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow29 = i41;
                        voiceCallMetric.carrierName = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow31;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow30 = i42;
                        voiceCallMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow30 = i42;
                        voiceCallMetric.secondaryCarrierName = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow32;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow31 = i43;
                        voiceCallMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow31 = i43;
                        voiceCallMetric.networkOperatorName = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow33;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow32 = i44;
                        voiceCallMetric.os = null;
                    } else {
                        columnIndexOrThrow32 = i44;
                        voiceCallMetric.os = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow34;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow33 = i45;
                        voiceCallMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow33 = i45;
                        voiceCallMetric.osVersion = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow35;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow34 = i46;
                        voiceCallMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow34 = i46;
                        voiceCallMetric.readableDate = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow36;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow35 = i47;
                        voiceCallMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow35 = i47;
                        voiceCallMetric.physicalCellId = Integer.valueOf(query.getInt(i48));
                    }
                    int i49 = columnIndexOrThrow37;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow36 = i48;
                        voiceCallMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow36 = i48;
                        voiceCallMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i49));
                    }
                    int i50 = columnIndexOrThrow38;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow37 = i49;
                        voiceCallMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow37 = i49;
                        voiceCallMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i50));
                    }
                    int i51 = columnIndexOrThrow39;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow38 = i50;
                        voiceCallMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow38 = i50;
                        voiceCallMetric.cellBands = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow40;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow39 = i51;
                        voiceCallMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow39 = i51;
                        voiceCallMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i52));
                    }
                    int i53 = columnIndexOrThrow41;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow40 = i52;
                        voiceCallMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow40 = i52;
                        voiceCallMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i53));
                    }
                    int i54 = columnIndexOrThrow42;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow41 = i53;
                        voiceCallMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow41 = i53;
                        voiceCallMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow43;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow42 = i54;
                        voiceCallMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow42 = i54;
                        voiceCallMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i55));
                    }
                    int i56 = columnIndexOrThrow44;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow43 = i55;
                        voiceCallMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow43 = i55;
                        voiceCallMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow45;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow44 = i56;
                        voiceCallMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow44 = i56;
                        voiceCallMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow46;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow45 = i57;
                        voiceCallMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow45 = i57;
                        voiceCallMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow47;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow46 = i58;
                        voiceCallMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow46 = i58;
                        voiceCallMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow48;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow47 = i59;
                        voiceCallMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow47 = i59;
                        voiceCallMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow49;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow48 = i60;
                        voiceCallMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow48 = i60;
                        voiceCallMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow50;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow49 = i61;
                        voiceCallMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow49 = i61;
                        voiceCallMetric.timingAdvance = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow51;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow50 = i62;
                        voiceCallMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow50 = i62;
                        voiceCallMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow52;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow51 = i63;
                        voiceCallMetric.dbm = null;
                    } else {
                        columnIndexOrThrow51 = i63;
                        voiceCallMetric.dbm = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow53;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow52 = i64;
                        voiceCallMetric.debugString = null;
                    } else {
                        columnIndexOrThrow52 = i64;
                        voiceCallMetric.debugString = query.getString(i65);
                    }
                    int i66 = columnIndexOrThrow54;
                    Integer valueOf = query.isNull(i66) ? null : Integer.valueOf(query.getInt(i66));
                    if (valueOf == null) {
                        i8 = i66;
                        bool = null;
                    } else {
                        i8 = i66;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    voiceCallMetric.isDcNrRestricted = bool;
                    int i67 = columnIndexOrThrow55;
                    Integer valueOf2 = query.isNull(i67) ? null : Integer.valueOf(query.getInt(i67));
                    if (valueOf2 == null) {
                        columnIndexOrThrow55 = i67;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow55 = i67;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    voiceCallMetric.isNrAvailable = bool2;
                    int i68 = columnIndexOrThrow56;
                    Integer valueOf3 = query.isNull(i68) ? null : Integer.valueOf(query.getInt(i68));
                    if (valueOf3 == null) {
                        columnIndexOrThrow56 = i68;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow56 = i68;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    voiceCallMetric.isEnDcAvailable = bool3;
                    int i69 = columnIndexOrThrow57;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow53 = i65;
                        voiceCallMetric.nrState = null;
                    } else {
                        columnIndexOrThrow53 = i65;
                        voiceCallMetric.nrState = query.getString(i69);
                    }
                    int i70 = columnIndexOrThrow58;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow57 = i69;
                        voiceCallMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow57 = i69;
                        voiceCallMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow59;
                    Integer valueOf4 = query.isNull(i71) ? null : Integer.valueOf(query.getInt(i71));
                    if (valueOf4 == null) {
                        columnIndexOrThrow59 = i71;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow59 = i71;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    voiceCallMetric.isUsingCarrierAggregation = bool4;
                    int i72 = columnIndexOrThrow60;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow58 = i70;
                        voiceCallMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow58 = i70;
                        voiceCallMetric.vopsSupport = Integer.valueOf(query.getInt(i72));
                    }
                    int i73 = columnIndexOrThrow61;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow60 = i72;
                        voiceCallMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow60 = i72;
                        voiceCallMetric.cellBandwidths = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow62;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow61 = i73;
                        voiceCallMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow61 = i73;
                        voiceCallMetric.additionalPlmns = query.getString(i74);
                    }
                    int i75 = i36;
                    int i76 = columnIndexOrThrow63;
                    int i77 = i37;
                    voiceCallMetric.altitude = query.getDouble(i76);
                    int i78 = columnIndexOrThrow64;
                    if (query.isNull(i78)) {
                        voiceCallMetric.locationSpeed = null;
                    } else {
                        voiceCallMetric.locationSpeed = Float.valueOf(query.getFloat(i78));
                    }
                    int i79 = columnIndexOrThrow65;
                    if (query.isNull(i79)) {
                        i9 = i74;
                        voiceCallMetric.locationSpeedAccuracy = null;
                    } else {
                        i9 = i74;
                        voiceCallMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i79));
                    }
                    int i80 = columnIndexOrThrow66;
                    if (query.isNull(i80)) {
                        i10 = i76;
                        voiceCallMetric.gpsVerticalAccuracy = null;
                    } else {
                        i10 = i76;
                        voiceCallMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i80));
                    }
                    columnIndexOrThrow66 = i80;
                    int i81 = columnIndexOrThrow67;
                    voiceCallMetric.getRestrictBackgroundStatus = query.getInt(i81);
                    int i82 = columnIndexOrThrow68;
                    if (query.isNull(i82)) {
                        columnIndexOrThrow67 = i81;
                        voiceCallMetric.cellType = null;
                    } else {
                        columnIndexOrThrow67 = i81;
                        voiceCallMetric.cellType = query.getString(i82);
                    }
                    int i83 = columnIndexOrThrow69;
                    Integer valueOf5 = query.isNull(i83) ? null : Integer.valueOf(query.getInt(i83));
                    if (valueOf5 == null) {
                        i11 = i82;
                        bool5 = null;
                    } else {
                        i11 = i82;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    voiceCallMetric.isDefaultNetworkActive = bool5;
                    int i84 = columnIndexOrThrow70;
                    Integer valueOf6 = query.isNull(i84) ? null : Integer.valueOf(query.getInt(i84));
                    if (valueOf6 == null) {
                        columnIndexOrThrow70 = i84;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow70 = i84;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    voiceCallMetric.isActiveNetworkMetered = bool6;
                    int i85 = columnIndexOrThrow71;
                    Integer valueOf7 = query.isNull(i85) ? null : Integer.valueOf(query.getInt(i85));
                    if (valueOf7 == null) {
                        columnIndexOrThrow71 = i85;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow71 = i85;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    voiceCallMetric.isOnScreen = bool7;
                    int i86 = columnIndexOrThrow72;
                    Integer valueOf8 = query.isNull(i86) ? null : Integer.valueOf(query.getInt(i86));
                    if (valueOf8 == null) {
                        columnIndexOrThrow72 = i86;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow72 = i86;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    voiceCallMetric.isRoaming = bool8;
                    int i87 = i83;
                    int i88 = columnIndexOrThrow73;
                    voiceCallMetric.locationAge = query.getInt(i88);
                    int i89 = columnIndexOrThrow74;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow73 = i88;
                        voiceCallMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow73 = i88;
                        voiceCallMetric.overrideNetworkType = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow75;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow74 = i89;
                        voiceCallMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow74 = i89;
                        voiceCallMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow76;
                    Integer valueOf9 = query.isNull(i91) ? null : Integer.valueOf(query.getInt(i91));
                    if (valueOf9 == null) {
                        i12 = i90;
                        bool9 = null;
                    } else {
                        i12 = i90;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    voiceCallMetric.anonymize = bool9;
                    int i92 = columnIndexOrThrow77;
                    if (query.isNull(i92)) {
                        i13 = i91;
                        voiceCallMetric.sdkOrigin = null;
                    } else {
                        i13 = i91;
                        voiceCallMetric.sdkOrigin = query.getString(i92);
                    }
                    int i93 = columnIndexOrThrow78;
                    Integer valueOf10 = query.isNull(i93) ? null : Integer.valueOf(query.getInt(i93));
                    if (valueOf10 == null) {
                        i14 = i92;
                        bool10 = null;
                    } else {
                        i14 = i92;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    voiceCallMetric.isRooted = bool10;
                    int i94 = columnIndexOrThrow79;
                    Integer valueOf11 = query.isNull(i94) ? null : Integer.valueOf(query.getInt(i94));
                    if (valueOf11 == null) {
                        columnIndexOrThrow79 = i94;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow79 = i94;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    voiceCallMetric.isConnectedToVpn = bool11;
                    int i95 = i93;
                    int i96 = columnIndexOrThrow80;
                    voiceCallMetric.linkDownstreamBandwidth = query.getInt(i96);
                    columnIndexOrThrow80 = i96;
                    int i97 = columnIndexOrThrow81;
                    voiceCallMetric.linkUpstreamBandwidth = query.getInt(i97);
                    columnIndexOrThrow81 = i97;
                    int i98 = columnIndexOrThrow82;
                    voiceCallMetric.latencyType = query.getInt(i98);
                    int i99 = columnIndexOrThrow83;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow82 = i98;
                        voiceCallMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow82 = i98;
                        voiceCallMetric.serverIp = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow84;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow83 = i99;
                        voiceCallMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow83 = i99;
                        voiceCallMetric.privateIp = query.getString(i100);
                    }
                    int i101 = columnIndexOrThrow85;
                    if (query.isNull(i101)) {
                        columnIndexOrThrow84 = i100;
                        voiceCallMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow84 = i100;
                        voiceCallMetric.gatewayIp = query.getString(i101);
                    }
                    int i102 = columnIndexOrThrow86;
                    if (query.isNull(i102)) {
                        columnIndexOrThrow85 = i101;
                        voiceCallMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow85 = i101;
                        voiceCallMetric.locationPermissionState = Integer.valueOf(query.getInt(i102));
                    }
                    int i103 = columnIndexOrThrow87;
                    if (query.isNull(i103)) {
                        columnIndexOrThrow86 = i102;
                        voiceCallMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow86 = i102;
                        voiceCallMetric.serviceStateStatus = Integer.valueOf(query.getInt(i103));
                    }
                    int i104 = columnIndexOrThrow88;
                    Integer valueOf12 = query.isNull(i104) ? null : Integer.valueOf(query.getInt(i104));
                    if (valueOf12 == null) {
                        columnIndexOrThrow88 = i104;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow88 = i104;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    voiceCallMetric.isNrCellSeen = bool12;
                    int i105 = columnIndexOrThrow89;
                    Integer valueOf13 = query.isNull(i105) ? null : Integer.valueOf(query.getInt(i105));
                    if (valueOf13 == null) {
                        columnIndexOrThrow89 = i105;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow89 = i105;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    voiceCallMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i106 = columnIndexOrThrow90;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow87 = i103;
                        voiceCallMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow87 = i103;
                        voiceCallMetric.appVersionName = query.getString(i106);
                    }
                    int i107 = i78;
                    int i108 = columnIndexOrThrow91;
                    int i109 = i79;
                    voiceCallMetric.appVersionCode = query.getLong(i108);
                    int i110 = i106;
                    int i111 = columnIndexOrThrow92;
                    int i112 = i108;
                    voiceCallMetric.appLastUpdateTime = query.getLong(i111);
                    int i113 = columnIndexOrThrow93;
                    voiceCallMetric.duplexModeState = query.getInt(i113);
                    columnIndexOrThrow93 = i113;
                    int i114 = columnIndexOrThrow94;
                    voiceCallMetric.dozeModeState = query.getInt(i114);
                    columnIndexOrThrow94 = i114;
                    int i115 = columnIndexOrThrow95;
                    voiceCallMetric.callState = query.getInt(i115);
                    int i116 = columnIndexOrThrow96;
                    if (query.isNull(i116)) {
                        columnIndexOrThrow95 = i115;
                        voiceCallMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow95 = i115;
                        voiceCallMetric.buildDevice = query.getString(i116);
                    }
                    int i117 = columnIndexOrThrow97;
                    if (query.isNull(i117)) {
                        columnIndexOrThrow96 = i116;
                        voiceCallMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow96 = i116;
                        voiceCallMetric.buildHardware = query.getString(i117);
                    }
                    int i118 = columnIndexOrThrow98;
                    if (query.isNull(i118)) {
                        columnIndexOrThrow97 = i117;
                        voiceCallMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow97 = i117;
                        voiceCallMetric.buildProduct = query.getString(i118);
                    }
                    int i119 = columnIndexOrThrow99;
                    if (query.isNull(i119)) {
                        columnIndexOrThrow98 = i118;
                        voiceCallMetric.appId = null;
                    } else {
                        columnIndexOrThrow98 = i118;
                        voiceCallMetric.appId = query.getString(i119);
                    }
                    int i120 = columnIndexOrThrow100;
                    if (query.getInt(i120) != 0) {
                        columnIndexOrThrow99 = i119;
                        z = true;
                    } else {
                        columnIndexOrThrow99 = i119;
                        z = false;
                    }
                    voiceCallMetric.isSending = z;
                    arrayList = arrayList2;
                    arrayList.add(voiceCallMetric);
                    columnIndexOrThrow100 = i120;
                    columnIndexOrThrow11 = i2;
                    columnIndexOrThrow15 = i3;
                    columnIndexOrThrow16 = i23;
                    columnIndexOrThrow17 = i25;
                    columnIndexOrThrow18 = i4;
                    columnIndexOrThrow19 = i5;
                    columnIndexOrThrow20 = i35;
                    columnIndexOrThrow23 = i6;
                    columnIndexOrThrow24 = i75;
                    columnIndexOrThrow62 = i9;
                    columnIndexOrThrow64 = i107;
                    columnIndexOrThrow54 = i8;
                    columnIndexOrThrow90 = i110;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow14 = i19;
                    columnIndexOrThrow2 = i17;
                    int i121 = i112;
                    columnIndexOrThrow92 = i111;
                    columnIndexOrThrow12 = i29;
                    columnIndexOrThrow21 = i32;
                    columnIndexOrThrow22 = i7;
                    columnIndexOrThrow25 = i77;
                    columnIndexOrThrow63 = i10;
                    columnIndexOrThrow65 = i109;
                    columnIndexOrThrow91 = i121;
                    int i122 = i11;
                    columnIndexOrThrow69 = i87;
                    columnIndexOrThrow68 = i122;
                    int i123 = i12;
                    columnIndexOrThrow76 = i13;
                    columnIndexOrThrow75 = i123;
                    int i124 = i14;
                    columnIndexOrThrow78 = i95;
                    columnIndexOrThrow77 = i124;
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
