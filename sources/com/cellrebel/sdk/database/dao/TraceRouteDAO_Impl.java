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
import com.cellrebel.sdk.networking.beans.request.TraceRouteMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TraceRouteDAO_Impl implements TraceRouteDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<TraceRouteMetric> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<TraceRouteMetric> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, TraceRouteMetric traceRouteMetric) {
            String str = traceRouteMetric.traceroute;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = traceRouteMetric.serverUrl;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, (long) traceRouteMetric.numberOfHops);
            supportSQLiteStatement.bindLong(4, (long) traceRouteMetric.packetSize);
            supportSQLiteStatement.bindLong(5, traceRouteMetric.id);
            String str3 = traceRouteMetric.mobileClientId;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str3);
            }
            String str4 = traceRouteMetric.measurementSequenceId;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str4);
            }
            String str5 = traceRouteMetric.clientIp;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str5);
            }
            String str6 = traceRouteMetric.dateTimeOfMeasurement;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, str6);
            }
            supportSQLiteStatement.bindLong(10, (long) traceRouteMetric.stateDuringMeasurement);
            String str7 = traceRouteMetric.accessTechnology;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            String str8 = traceRouteMetric.accessTypeRaw;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str8);
            }
            supportSQLiteStatement.bindLong(13, (long) traceRouteMetric.signalStrength);
            supportSQLiteStatement.bindLong(14, (long) traceRouteMetric.interference);
            String str9 = traceRouteMetric.simMCC;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str9);
            }
            String str10 = traceRouteMetric.simMNC;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str10);
            }
            String str11 = traceRouteMetric.secondarySimMCC;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, str11);
            }
            String str12 = traceRouteMetric.secondarySimMNC;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, str12);
            }
            supportSQLiteStatement.bindLong(19, (long) traceRouteMetric.numberOfSimSlots);
            supportSQLiteStatement.bindLong(20, (long) traceRouteMetric.dataSimSlotNumber);
            String str13 = traceRouteMetric.networkMCC;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str13);
            }
            String str14 = traceRouteMetric.networkMNC;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, str14);
            }
            supportSQLiteStatement.bindDouble(23, traceRouteMetric.latitude);
            supportSQLiteStatement.bindDouble(24, traceRouteMetric.longitude);
            supportSQLiteStatement.bindDouble(25, traceRouteMetric.gpsAccuracy);
            String str15 = traceRouteMetric.cellId;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str15);
            }
            String str16 = traceRouteMetric.lacId;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str16);
            }
            String str17 = traceRouteMetric.deviceBrand;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, str17);
            }
            String str18 = traceRouteMetric.deviceModel;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str18);
            }
            String str19 = traceRouteMetric.deviceVersion;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str19);
            }
            String str20 = traceRouteMetric.sdkVersionNumber;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str20);
            }
            String str21 = traceRouteMetric.carrierName;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindString(32, str21);
            }
            String str22 = traceRouteMetric.secondaryCarrierName;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindString(33, str22);
            }
            String str23 = traceRouteMetric.networkOperatorName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str23);
            }
            String str24 = traceRouteMetric.os;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str24);
            }
            String str25 = traceRouteMetric.osVersion;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str25);
            }
            String str26 = traceRouteMetric.readableDate;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, str26);
            }
            Integer num = traceRouteMetric.physicalCellId;
            if (num == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindLong(38, (long) num.intValue());
            }
            Integer num2 = traceRouteMetric.absoluteRfChannelNumber;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindLong(39, (long) num2.intValue());
            }
            Integer num3 = traceRouteMetric.connectionAbsoluteRfChannelNumber;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num3.intValue());
            }
            String str27 = traceRouteMetric.cellBands;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, str27);
            }
            Integer num4 = traceRouteMetric.channelQualityIndicator;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindLong(42, (long) num4.intValue());
            }
            Integer num5 = traceRouteMetric.referenceSignalSignalToNoiseRatio;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) num5.intValue());
            }
            Integer num6 = traceRouteMetric.referenceSignalReceivedPower;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) num6.intValue());
            }
            Integer num7 = traceRouteMetric.referenceSignalReceivedQuality;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num7.intValue());
            }
            Integer num8 = traceRouteMetric.csiReferenceSignalReceivedPower;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num8.intValue());
            }
            Integer num9 = traceRouteMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num9.intValue());
            }
            Integer num10 = traceRouteMetric.csiReferenceSignalReceivedQuality;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num10.intValue());
            }
            Integer num11 = traceRouteMetric.ssReferenceSignalReceivedPower;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num11.intValue());
            }
            Integer num12 = traceRouteMetric.ssReferenceSignalReceivedQuality;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num12.intValue());
            }
            Integer num13 = traceRouteMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num13.intValue());
            }
            Integer num14 = traceRouteMetric.timingAdvance;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num14.intValue());
            }
            Integer num15 = traceRouteMetric.signalStrengthAsu;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num15.intValue());
            }
            Integer num16 = traceRouteMetric.dbm;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num16.intValue());
            }
            String str28 = traceRouteMetric.debugString;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindString(55, str28);
            }
            Boolean bool = traceRouteMetric.isDcNrRestricted;
            Integer num17 = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) valueOf.intValue());
            }
            Boolean bool2 = traceRouteMetric.isNrAvailable;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) valueOf2.intValue());
            }
            Boolean bool3 = traceRouteMetric.isEnDcAvailable;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) valueOf3.intValue());
            }
            String str29 = traceRouteMetric.nrState;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindString(59, str29);
            }
            Integer num18 = traceRouteMetric.nrFrequencyRange;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) num18.intValue());
            }
            Boolean bool4 = traceRouteMetric.isUsingCarrierAggregation;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) valueOf4.intValue());
            }
            Integer num19 = traceRouteMetric.vopsSupport;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) num19.intValue());
            }
            String str30 = traceRouteMetric.cellBandwidths;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str30);
            }
            String str31 = traceRouteMetric.additionalPlmns;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str31);
            }
            supportSQLiteStatement.bindDouble(65, traceRouteMetric.altitude);
            Float f = traceRouteMetric.locationSpeed;
            if (f == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindDouble(66, (double) f.floatValue());
            }
            Float f2 = traceRouteMetric.locationSpeedAccuracy;
            if (f2 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindDouble(67, (double) f2.floatValue());
            }
            Float f3 = traceRouteMetric.gpsVerticalAccuracy;
            if (f3 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindDouble(68, (double) f3.floatValue());
            }
            supportSQLiteStatement.bindLong(69, (long) traceRouteMetric.getRestrictBackgroundStatus);
            String str32 = traceRouteMetric.cellType;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str32);
            }
            Boolean bool5 = traceRouteMetric.isDefaultNetworkActive;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) valueOf5.intValue());
            }
            Boolean bool6 = traceRouteMetric.isActiveNetworkMetered;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) valueOf6.intValue());
            }
            Boolean bool7 = traceRouteMetric.isOnScreen;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) valueOf7.intValue());
            }
            Boolean bool8 = traceRouteMetric.isRoaming;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) valueOf8.intValue());
            }
            supportSQLiteStatement.bindLong(75, (long) traceRouteMetric.locationAge);
            Integer num20 = traceRouteMetric.overrideNetworkType;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindLong(76, (long) num20.intValue());
            }
            Integer num21 = traceRouteMetric.accessNetworkTechnologyRaw;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindLong(77, (long) num21.intValue());
            }
            Boolean bool9 = traceRouteMetric.anonymize;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf9.intValue());
            }
            String str33 = traceRouteMetric.sdkOrigin;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindString(79, str33);
            }
            Boolean bool10 = traceRouteMetric.isRooted;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindLong(80, (long) valueOf10.intValue());
            }
            Boolean bool11 = traceRouteMetric.isConnectedToVpn;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindLong(81, (long) valueOf11.intValue());
            }
            supportSQLiteStatement.bindLong(82, (long) traceRouteMetric.linkDownstreamBandwidth);
            supportSQLiteStatement.bindLong(83, (long) traceRouteMetric.linkUpstreamBandwidth);
            supportSQLiteStatement.bindLong(84, (long) traceRouteMetric.latencyType);
            String str34 = traceRouteMetric.serverIp;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindString(85, str34);
            }
            String str35 = traceRouteMetric.privateIp;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindString(86, str35);
            }
            String str36 = traceRouteMetric.gatewayIp;
            if (str36 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindString(87, str36);
            }
            Integer num22 = traceRouteMetric.locationPermissionState;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) num22.intValue());
            }
            Integer num23 = traceRouteMetric.serviceStateStatus;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) num23.intValue());
            }
            Boolean bool12 = traceRouteMetric.isNrCellSeen;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf12.intValue());
            }
            Boolean bool13 = traceRouteMetric.isReadPhoneStatePermissionGranted;
            if (bool13 != null) {
                num17 = Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            }
            if (num17 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) num17.intValue());
            }
            String str37 = traceRouteMetric.appVersionName;
            if (str37 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindString(92, str37);
            }
            supportSQLiteStatement.bindLong(93, traceRouteMetric.appVersionCode);
            supportSQLiteStatement.bindLong(94, traceRouteMetric.appLastUpdateTime);
            supportSQLiteStatement.bindLong(95, (long) traceRouteMetric.duplexModeState);
            supportSQLiteStatement.bindLong(96, (long) traceRouteMetric.dozeModeState);
            supportSQLiteStatement.bindLong(97, (long) traceRouteMetric.callState);
            String str38 = traceRouteMetric.buildDevice;
            if (str38 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindString(98, str38);
            }
            String str39 = traceRouteMetric.buildHardware;
            if (str39 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindString(99, str39);
            }
            String str40 = traceRouteMetric.buildProduct;
            if (str40 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindString(100, str40);
            }
            String str41 = traceRouteMetric.appId;
            if (str41 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindString(101, str41);
            }
            supportSQLiteStatement.bindLong(102, traceRouteMetric.isSending ? 1 : 0);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `TraceRouteMetric` (`traceroute`,`serverUrl`,`numberOfHops`,`packetSize`,`id`,`mobileClientId`,`measurementSequenceId`,`clientIp`,`dateTimeOfMeasurement`,`stateDuringMeasurement`,`accessTechnology`,`accessTypeRaw`,`signalStrength`,`interference`,`simMCC`,`simMNC`,`secondarySimMCC`,`secondarySimMNC`,`numberOfSimSlots`,`dataSimSlotNumber`,`networkMCC`,`networkMNC`,`latitude`,`longitude`,`gpsAccuracy`,`cellId`,`lacId`,`deviceBrand`,`deviceModel`,`deviceVersion`,`sdkVersionNumber`,`carrierName`,`secondaryCarrierName`,`networkOperatorName`,`os`,`osVersion`,`readableDate`,`physicalCellId`,`absoluteRfChannelNumber`,`connectionAbsoluteRfChannelNumber`,`cellBands`,`channelQualityIndicator`,`referenceSignalSignalToNoiseRatio`,`referenceSignalReceivedPower`,`referenceSignalReceivedQuality`,`csiReferenceSignalReceivedPower`,`csiReferenceSignalToNoiseAndInterferenceRatio`,`csiReferenceSignalReceivedQuality`,`ssReferenceSignalReceivedPower`,`ssReferenceSignalReceivedQuality`,`ssReferenceSignalToNoiseAndInterferenceRatio`,`timingAdvance`,`signalStrengthAsu`,`dbm`,`debugString`,`isDcNrRestricted`,`isNrAvailable`,`isEnDcAvailable`,`nrState`,`nrFrequencyRange`,`isUsingCarrierAggregation`,`vopsSupport`,`cellBandwidths`,`additionalPlmns`,`altitude`,`locationSpeed`,`locationSpeedAccuracy`,`gpsVerticalAccuracy`,`getRestrictBackgroundStatus`,`cellType`,`isDefaultNetworkActive`,`isActiveNetworkMetered`,`isOnScreen`,`isRoaming`,`locationAge`,`overrideNetworkType`,`accessNetworkTechnologyRaw`,`anonymize`,`sdkOrigin`,`isRooted`,`isConnectedToVpn`,`linkDownstreamBandwidth`,`linkUpstreamBandwidth`,`latencyType`,`serverIp`,`privateIp`,`gatewayIp`,`locationPermissionState`,`serviceStateStatus`,`isNrCellSeen`,`isReadPhoneStatePermissionGranted`,`appVersionName`,`appVersionCode`,`appLastUpdateTime`,`duplexModeState`,`dozeModeState`,`callState`,`buildDevice`,`buildHardware`,`buildProduct`,`appId`,`isSending`) VALUES (?,?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM traceroutemetric";
        }
    }

    public TraceRouteDAO_Impl(RoomDatabase roomDatabase) {
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

    public void a(TraceRouteMetric traceRouteMetric) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(traceRouteMetric);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(List<TraceRouteMetric> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<TraceRouteMetric> b() {
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
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i10;
        int i11;
        int i12;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        int i13;
        Boolean bool9;
        int i14;
        int i15;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        boolean z;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from traceroutemetric WHERE isSending = 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "traceroute");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "serverUrl");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "numberOfHops");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "packetSize");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "measurementSequenceId");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "clientIp");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "dateTimeOfMeasurement");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "stateDuringMeasurement");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnology");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "accessTypeRaw");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "signalStrength");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "interference");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "simMCC");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "simMNC");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMCC");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "secondarySimMNC");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "numberOfSimSlots");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "dataSimSlotNumber");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "networkMCC");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "networkMNC");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "gpsAccuracy");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "cellId");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "lacId");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "deviceBrand");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "deviceModel");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "deviceVersion");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionNumber");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "carrierName");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "secondaryCarrierName");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "os");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "osVersion");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "readableDate");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "physicalCellId");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "absoluteRfChannelNumber");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "connectionAbsoluteRfChannelNumber");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "cellBands");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "channelQualityIndicator");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalSignalToNoiseRatio");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedPower");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "referenceSignalReceivedQuality");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedPower");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "csiReferenceSignalReceivedQuality");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedPower");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalReceivedQuality");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "ssReferenceSignalToNoiseAndInterferenceRatio");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "timingAdvance");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "signalStrengthAsu");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "debugString");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "isDcNrRestricted");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "isNrAvailable");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "isEnDcAvailable");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "nrState");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "nrFrequencyRange");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "vopsSupport");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "cellBandwidths");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "additionalPlmns");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeed");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "locationSpeedAccuracy");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "gpsVerticalAccuracy");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "getRestrictBackgroundStatus");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "cellType");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "isDefaultNetworkActive");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "isActiveNetworkMetered");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "isOnScreen");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "isRoaming");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "locationAge");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "accessNetworkTechnologyRaw");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "isRooted");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "isConnectedToVpn");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "linkDownstreamBandwidth");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "linkUpstreamBandwidth");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "latencyType");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "serverIp");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "privateIp");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "gatewayIp");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "locationPermissionState");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "serviceStateStatus");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "isNrCellSeen");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "isReadPhoneStatePermissionGranted");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "appVersionName");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "appLastUpdateTime");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "duplexModeState");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "dozeModeState");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "callState");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "buildDevice");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "buildHardware");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "buildProduct");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "isSending");
                int i16 = columnIndexOrThrow13;
                ArrayList arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    TraceRouteMetric traceRouteMetric = new TraceRouteMetric();
                    if (query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayList2;
                        traceRouteMetric.traceroute = null;
                    } else {
                        arrayList = arrayList2;
                        traceRouteMetric.traceroute = query.getString(columnIndexOrThrow);
                    }
                    if (query.isNull(columnIndexOrThrow2)) {
                        traceRouteMetric.serverUrl = null;
                    } else {
                        traceRouteMetric.serverUrl = query.getString(columnIndexOrThrow2);
                    }
                    traceRouteMetric.numberOfHops = query.getInt(columnIndexOrThrow3);
                    traceRouteMetric.packetSize = query.getInt(columnIndexOrThrow4);
                    int i17 = columnIndexOrThrow;
                    int i18 = columnIndexOrThrow2;
                    traceRouteMetric.id = query.getLong(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        traceRouteMetric.mobileClientId = null;
                    } else {
                        traceRouteMetric.mobileClientId = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        traceRouteMetric.measurementSequenceId = null;
                    } else {
                        traceRouteMetric.measurementSequenceId = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        traceRouteMetric.clientIp = null;
                    } else {
                        traceRouteMetric.clientIp = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        traceRouteMetric.dateTimeOfMeasurement = null;
                    } else {
                        traceRouteMetric.dateTimeOfMeasurement = query.getString(columnIndexOrThrow9);
                    }
                    traceRouteMetric.stateDuringMeasurement = query.getInt(columnIndexOrThrow10);
                    if (query.isNull(columnIndexOrThrow11)) {
                        traceRouteMetric.accessTechnology = null;
                    } else {
                        traceRouteMetric.accessTechnology = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        traceRouteMetric.accessTypeRaw = null;
                    } else {
                        traceRouteMetric.accessTypeRaw = query.getString(columnIndexOrThrow12);
                    }
                    int i19 = i16;
                    traceRouteMetric.signalStrength = query.getInt(i19);
                    int i20 = columnIndexOrThrow14;
                    int i21 = i17;
                    traceRouteMetric.interference = query.getInt(i20);
                    int i22 = columnIndexOrThrow15;
                    if (query.isNull(i22)) {
                        i = columnIndexOrThrow11;
                        traceRouteMetric.simMCC = null;
                    } else {
                        i = columnIndexOrThrow11;
                        traceRouteMetric.simMCC = query.getString(i22);
                    }
                    int i23 = columnIndexOrThrow16;
                    if (query.isNull(i23)) {
                        i2 = i22;
                        traceRouteMetric.simMNC = null;
                    } else {
                        i2 = i22;
                        traceRouteMetric.simMNC = query.getString(i23);
                    }
                    int i24 = columnIndexOrThrow17;
                    if (query.isNull(i24)) {
                        i3 = i23;
                        traceRouteMetric.secondarySimMCC = null;
                    } else {
                        i3 = i23;
                        traceRouteMetric.secondarySimMCC = query.getString(i24);
                    }
                    int i25 = columnIndexOrThrow18;
                    if (query.isNull(i25)) {
                        i4 = i24;
                        traceRouteMetric.secondarySimMNC = null;
                    } else {
                        i4 = i24;
                        traceRouteMetric.secondarySimMNC = query.getString(i25);
                    }
                    int i26 = columnIndexOrThrow19;
                    int i27 = i25;
                    traceRouteMetric.numberOfSimSlots = query.getInt(i26);
                    int i28 = columnIndexOrThrow20;
                    int i29 = i26;
                    traceRouteMetric.dataSimSlotNumber = query.getInt(i28);
                    int i30 = columnIndexOrThrow21;
                    if (query.isNull(i30)) {
                        i5 = i28;
                        traceRouteMetric.networkMCC = null;
                    } else {
                        i5 = i28;
                        traceRouteMetric.networkMCC = query.getString(i30);
                    }
                    int i31 = columnIndexOrThrow22;
                    if (query.isNull(i31)) {
                        i6 = i30;
                        traceRouteMetric.networkMNC = null;
                    } else {
                        i6 = i30;
                        traceRouteMetric.networkMNC = query.getString(i31);
                    }
                    i16 = i19;
                    int i32 = columnIndexOrThrow23;
                    int i33 = columnIndexOrThrow12;
                    traceRouteMetric.latitude = query.getDouble(i32);
                    int i34 = i31;
                    int i35 = columnIndexOrThrow24;
                    int i36 = i32;
                    traceRouteMetric.longitude = query.getDouble(i35);
                    int i37 = i35;
                    int i38 = columnIndexOrThrow25;
                    int i39 = i34;
                    traceRouteMetric.gpsAccuracy = query.getDouble(i38);
                    int i40 = columnIndexOrThrow26;
                    if (query.isNull(i40)) {
                        traceRouteMetric.cellId = null;
                    } else {
                        traceRouteMetric.cellId = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow27;
                    if (query.isNull(i41)) {
                        i7 = i38;
                        traceRouteMetric.lacId = null;
                    } else {
                        i7 = i38;
                        traceRouteMetric.lacId = query.getString(i41);
                    }
                    int i42 = columnIndexOrThrow28;
                    if (query.isNull(i42)) {
                        i8 = i37;
                        traceRouteMetric.deviceBrand = null;
                    } else {
                        i8 = i37;
                        traceRouteMetric.deviceBrand = query.getString(i42);
                    }
                    int i43 = columnIndexOrThrow29;
                    if (query.isNull(i43)) {
                        columnIndexOrThrow28 = i42;
                        traceRouteMetric.deviceModel = null;
                    } else {
                        columnIndexOrThrow28 = i42;
                        traceRouteMetric.deviceModel = query.getString(i43);
                    }
                    int i44 = columnIndexOrThrow30;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow29 = i43;
                        traceRouteMetric.deviceVersion = null;
                    } else {
                        columnIndexOrThrow29 = i43;
                        traceRouteMetric.deviceVersion = query.getString(i44);
                    }
                    int i45 = columnIndexOrThrow31;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow30 = i44;
                        traceRouteMetric.sdkVersionNumber = null;
                    } else {
                        columnIndexOrThrow30 = i44;
                        traceRouteMetric.sdkVersionNumber = query.getString(i45);
                    }
                    int i46 = columnIndexOrThrow32;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow31 = i45;
                        traceRouteMetric.carrierName = null;
                    } else {
                        columnIndexOrThrow31 = i45;
                        traceRouteMetric.carrierName = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow33;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow32 = i46;
                        traceRouteMetric.secondaryCarrierName = null;
                    } else {
                        columnIndexOrThrow32 = i46;
                        traceRouteMetric.secondaryCarrierName = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow34;
                    if (query.isNull(i48)) {
                        columnIndexOrThrow33 = i47;
                        traceRouteMetric.networkOperatorName = null;
                    } else {
                        columnIndexOrThrow33 = i47;
                        traceRouteMetric.networkOperatorName = query.getString(i48);
                    }
                    int i49 = columnIndexOrThrow35;
                    if (query.isNull(i49)) {
                        columnIndexOrThrow34 = i48;
                        traceRouteMetric.os = null;
                    } else {
                        columnIndexOrThrow34 = i48;
                        traceRouteMetric.os = query.getString(i49);
                    }
                    int i50 = columnIndexOrThrow36;
                    if (query.isNull(i50)) {
                        columnIndexOrThrow35 = i49;
                        traceRouteMetric.osVersion = null;
                    } else {
                        columnIndexOrThrow35 = i49;
                        traceRouteMetric.osVersion = query.getString(i50);
                    }
                    int i51 = columnIndexOrThrow37;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow36 = i50;
                        traceRouteMetric.readableDate = null;
                    } else {
                        columnIndexOrThrow36 = i50;
                        traceRouteMetric.readableDate = query.getString(i51);
                    }
                    int i52 = columnIndexOrThrow38;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow37 = i51;
                        traceRouteMetric.physicalCellId = null;
                    } else {
                        columnIndexOrThrow37 = i51;
                        traceRouteMetric.physicalCellId = Integer.valueOf(query.getInt(i52));
                    }
                    int i53 = columnIndexOrThrow39;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow38 = i52;
                        traceRouteMetric.absoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow38 = i52;
                        traceRouteMetric.absoluteRfChannelNumber = Integer.valueOf(query.getInt(i53));
                    }
                    int i54 = columnIndexOrThrow40;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow39 = i53;
                        traceRouteMetric.connectionAbsoluteRfChannelNumber = null;
                    } else {
                        columnIndexOrThrow39 = i53;
                        traceRouteMetric.connectionAbsoluteRfChannelNumber = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow41;
                    if (query.isNull(i55)) {
                        columnIndexOrThrow40 = i54;
                        traceRouteMetric.cellBands = null;
                    } else {
                        columnIndexOrThrow40 = i54;
                        traceRouteMetric.cellBands = query.getString(i55);
                    }
                    int i56 = columnIndexOrThrow42;
                    if (query.isNull(i56)) {
                        columnIndexOrThrow41 = i55;
                        traceRouteMetric.channelQualityIndicator = null;
                    } else {
                        columnIndexOrThrow41 = i55;
                        traceRouteMetric.channelQualityIndicator = Integer.valueOf(query.getInt(i56));
                    }
                    int i57 = columnIndexOrThrow43;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow42 = i56;
                        traceRouteMetric.referenceSignalSignalToNoiseRatio = null;
                    } else {
                        columnIndexOrThrow42 = i56;
                        traceRouteMetric.referenceSignalSignalToNoiseRatio = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow44;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow43 = i57;
                        traceRouteMetric.referenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow43 = i57;
                        traceRouteMetric.referenceSignalReceivedPower = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow45;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow44 = i58;
                        traceRouteMetric.referenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow44 = i58;
                        traceRouteMetric.referenceSignalReceivedQuality = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow46;
                    if (query.isNull(i60)) {
                        columnIndexOrThrow45 = i59;
                        traceRouteMetric.csiReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow45 = i59;
                        traceRouteMetric.csiReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i60));
                    }
                    int i61 = columnIndexOrThrow47;
                    if (query.isNull(i61)) {
                        columnIndexOrThrow46 = i60;
                        traceRouteMetric.csiReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow46 = i60;
                        traceRouteMetric.csiReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i61));
                    }
                    int i62 = columnIndexOrThrow48;
                    if (query.isNull(i62)) {
                        columnIndexOrThrow47 = i61;
                        traceRouteMetric.csiReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow47 = i61;
                        traceRouteMetric.csiReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow49;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow48 = i62;
                        traceRouteMetric.ssReferenceSignalReceivedPower = null;
                    } else {
                        columnIndexOrThrow48 = i62;
                        traceRouteMetric.ssReferenceSignalReceivedPower = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow50;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow49 = i63;
                        traceRouteMetric.ssReferenceSignalReceivedQuality = null;
                    } else {
                        columnIndexOrThrow49 = i63;
                        traceRouteMetric.ssReferenceSignalReceivedQuality = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow51;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow50 = i64;
                        traceRouteMetric.ssReferenceSignalToNoiseAndInterferenceRatio = null;
                    } else {
                        columnIndexOrThrow50 = i64;
                        traceRouteMetric.ssReferenceSignalToNoiseAndInterferenceRatio = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow52;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow51 = i65;
                        traceRouteMetric.timingAdvance = null;
                    } else {
                        columnIndexOrThrow51 = i65;
                        traceRouteMetric.timingAdvance = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow53;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow52 = i66;
                        traceRouteMetric.signalStrengthAsu = null;
                    } else {
                        columnIndexOrThrow52 = i66;
                        traceRouteMetric.signalStrengthAsu = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow54;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow53 = i67;
                        traceRouteMetric.dbm = null;
                    } else {
                        columnIndexOrThrow53 = i67;
                        traceRouteMetric.dbm = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow55;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow54 = i68;
                        traceRouteMetric.debugString = null;
                    } else {
                        columnIndexOrThrow54 = i68;
                        traceRouteMetric.debugString = query.getString(i69);
                    }
                    int i70 = columnIndexOrThrow56;
                    Integer valueOf = query.isNull(i70) ? null : Integer.valueOf(query.getInt(i70));
                    if (valueOf == null) {
                        i9 = i70;
                        bool = null;
                    } else {
                        i9 = i70;
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    traceRouteMetric.isDcNrRestricted = bool;
                    int i71 = columnIndexOrThrow57;
                    Integer valueOf2 = query.isNull(i71) ? null : Integer.valueOf(query.getInt(i71));
                    if (valueOf2 == null) {
                        columnIndexOrThrow57 = i71;
                        bool2 = null;
                    } else {
                        columnIndexOrThrow57 = i71;
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    traceRouteMetric.isNrAvailable = bool2;
                    int i72 = columnIndexOrThrow58;
                    Integer valueOf3 = query.isNull(i72) ? null : Integer.valueOf(query.getInt(i72));
                    if (valueOf3 == null) {
                        columnIndexOrThrow58 = i72;
                        bool3 = null;
                    } else {
                        columnIndexOrThrow58 = i72;
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    traceRouteMetric.isEnDcAvailable = bool3;
                    int i73 = columnIndexOrThrow59;
                    if (query.isNull(i73)) {
                        columnIndexOrThrow55 = i69;
                        traceRouteMetric.nrState = null;
                    } else {
                        columnIndexOrThrow55 = i69;
                        traceRouteMetric.nrState = query.getString(i73);
                    }
                    int i74 = columnIndexOrThrow60;
                    if (query.isNull(i74)) {
                        columnIndexOrThrow59 = i73;
                        traceRouteMetric.nrFrequencyRange = null;
                    } else {
                        columnIndexOrThrow59 = i73;
                        traceRouteMetric.nrFrequencyRange = Integer.valueOf(query.getInt(i74));
                    }
                    int i75 = columnIndexOrThrow61;
                    Integer valueOf4 = query.isNull(i75) ? null : Integer.valueOf(query.getInt(i75));
                    if (valueOf4 == null) {
                        columnIndexOrThrow61 = i75;
                        bool4 = null;
                    } else {
                        columnIndexOrThrow61 = i75;
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    traceRouteMetric.isUsingCarrierAggregation = bool4;
                    int i76 = columnIndexOrThrow62;
                    if (query.isNull(i76)) {
                        columnIndexOrThrow60 = i74;
                        traceRouteMetric.vopsSupport = null;
                    } else {
                        columnIndexOrThrow60 = i74;
                        traceRouteMetric.vopsSupport = Integer.valueOf(query.getInt(i76));
                    }
                    int i77 = columnIndexOrThrow63;
                    if (query.isNull(i77)) {
                        columnIndexOrThrow62 = i76;
                        traceRouteMetric.cellBandwidths = null;
                    } else {
                        columnIndexOrThrow62 = i76;
                        traceRouteMetric.cellBandwidths = query.getString(i77);
                    }
                    int i78 = columnIndexOrThrow64;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow63 = i77;
                        traceRouteMetric.additionalPlmns = null;
                    } else {
                        columnIndexOrThrow63 = i77;
                        traceRouteMetric.additionalPlmns = query.getString(i78);
                    }
                    int i79 = i40;
                    int i80 = columnIndexOrThrow65;
                    int i81 = i41;
                    traceRouteMetric.altitude = query.getDouble(i80);
                    int i82 = columnIndexOrThrow66;
                    if (query.isNull(i82)) {
                        traceRouteMetric.locationSpeed = null;
                    } else {
                        traceRouteMetric.locationSpeed = Float.valueOf(query.getFloat(i82));
                    }
                    int i83 = columnIndexOrThrow67;
                    if (query.isNull(i83)) {
                        i10 = i78;
                        traceRouteMetric.locationSpeedAccuracy = null;
                    } else {
                        i10 = i78;
                        traceRouteMetric.locationSpeedAccuracy = Float.valueOf(query.getFloat(i83));
                    }
                    int i84 = columnIndexOrThrow68;
                    if (query.isNull(i84)) {
                        i11 = i80;
                        traceRouteMetric.gpsVerticalAccuracy = null;
                    } else {
                        i11 = i80;
                        traceRouteMetric.gpsVerticalAccuracy = Float.valueOf(query.getFloat(i84));
                    }
                    columnIndexOrThrow68 = i84;
                    int i85 = columnIndexOrThrow69;
                    traceRouteMetric.getRestrictBackgroundStatus = query.getInt(i85);
                    int i86 = columnIndexOrThrow70;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow69 = i85;
                        traceRouteMetric.cellType = null;
                    } else {
                        columnIndexOrThrow69 = i85;
                        traceRouteMetric.cellType = query.getString(i86);
                    }
                    int i87 = columnIndexOrThrow71;
                    Integer valueOf5 = query.isNull(i87) ? null : Integer.valueOf(query.getInt(i87));
                    if (valueOf5 == null) {
                        i12 = i86;
                        bool5 = null;
                    } else {
                        i12 = i86;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    traceRouteMetric.isDefaultNetworkActive = bool5;
                    int i88 = columnIndexOrThrow72;
                    Integer valueOf6 = query.isNull(i88) ? null : Integer.valueOf(query.getInt(i88));
                    if (valueOf6 == null) {
                        columnIndexOrThrow72 = i88;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow72 = i88;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    traceRouteMetric.isActiveNetworkMetered = bool6;
                    int i89 = columnIndexOrThrow73;
                    Integer valueOf7 = query.isNull(i89) ? null : Integer.valueOf(query.getInt(i89));
                    if (valueOf7 == null) {
                        columnIndexOrThrow73 = i89;
                        bool7 = null;
                    } else {
                        columnIndexOrThrow73 = i89;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    traceRouteMetric.isOnScreen = bool7;
                    int i90 = columnIndexOrThrow74;
                    Integer valueOf8 = query.isNull(i90) ? null : Integer.valueOf(query.getInt(i90));
                    if (valueOf8 == null) {
                        columnIndexOrThrow74 = i90;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow74 = i90;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    traceRouteMetric.isRoaming = bool8;
                    int i91 = i87;
                    int i92 = columnIndexOrThrow75;
                    traceRouteMetric.locationAge = query.getInt(i92);
                    int i93 = columnIndexOrThrow76;
                    if (query.isNull(i93)) {
                        columnIndexOrThrow75 = i92;
                        traceRouteMetric.overrideNetworkType = null;
                    } else {
                        columnIndexOrThrow75 = i92;
                        traceRouteMetric.overrideNetworkType = Integer.valueOf(query.getInt(i93));
                    }
                    int i94 = columnIndexOrThrow77;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow76 = i93;
                        traceRouteMetric.accessNetworkTechnologyRaw = null;
                    } else {
                        columnIndexOrThrow76 = i93;
                        traceRouteMetric.accessNetworkTechnologyRaw = Integer.valueOf(query.getInt(i94));
                    }
                    int i95 = columnIndexOrThrow78;
                    Integer valueOf9 = query.isNull(i95) ? null : Integer.valueOf(query.getInt(i95));
                    if (valueOf9 == null) {
                        i13 = i94;
                        bool9 = null;
                    } else {
                        i13 = i94;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    traceRouteMetric.anonymize = bool9;
                    int i96 = columnIndexOrThrow79;
                    if (query.isNull(i96)) {
                        i14 = i95;
                        traceRouteMetric.sdkOrigin = null;
                    } else {
                        i14 = i95;
                        traceRouteMetric.sdkOrigin = query.getString(i96);
                    }
                    int i97 = columnIndexOrThrow80;
                    Integer valueOf10 = query.isNull(i97) ? null : Integer.valueOf(query.getInt(i97));
                    if (valueOf10 == null) {
                        i15 = i96;
                        bool10 = null;
                    } else {
                        i15 = i96;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    traceRouteMetric.isRooted = bool10;
                    int i98 = columnIndexOrThrow81;
                    Integer valueOf11 = query.isNull(i98) ? null : Integer.valueOf(query.getInt(i98));
                    if (valueOf11 == null) {
                        columnIndexOrThrow81 = i98;
                        bool11 = null;
                    } else {
                        columnIndexOrThrow81 = i98;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    traceRouteMetric.isConnectedToVpn = bool11;
                    int i99 = i97;
                    int i100 = columnIndexOrThrow82;
                    traceRouteMetric.linkDownstreamBandwidth = query.getInt(i100);
                    columnIndexOrThrow82 = i100;
                    int i101 = columnIndexOrThrow83;
                    traceRouteMetric.linkUpstreamBandwidth = query.getInt(i101);
                    columnIndexOrThrow83 = i101;
                    int i102 = columnIndexOrThrow84;
                    traceRouteMetric.latencyType = query.getInt(i102);
                    int i103 = columnIndexOrThrow85;
                    if (query.isNull(i103)) {
                        columnIndexOrThrow84 = i102;
                        traceRouteMetric.serverIp = null;
                    } else {
                        columnIndexOrThrow84 = i102;
                        traceRouteMetric.serverIp = query.getString(i103);
                    }
                    int i104 = columnIndexOrThrow86;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow85 = i103;
                        traceRouteMetric.privateIp = null;
                    } else {
                        columnIndexOrThrow85 = i103;
                        traceRouteMetric.privateIp = query.getString(i104);
                    }
                    int i105 = columnIndexOrThrow87;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow86 = i104;
                        traceRouteMetric.gatewayIp = null;
                    } else {
                        columnIndexOrThrow86 = i104;
                        traceRouteMetric.gatewayIp = query.getString(i105);
                    }
                    int i106 = columnIndexOrThrow88;
                    if (query.isNull(i106)) {
                        columnIndexOrThrow87 = i105;
                        traceRouteMetric.locationPermissionState = null;
                    } else {
                        columnIndexOrThrow87 = i105;
                        traceRouteMetric.locationPermissionState = Integer.valueOf(query.getInt(i106));
                    }
                    int i107 = columnIndexOrThrow89;
                    if (query.isNull(i107)) {
                        columnIndexOrThrow88 = i106;
                        traceRouteMetric.serviceStateStatus = null;
                    } else {
                        columnIndexOrThrow88 = i106;
                        traceRouteMetric.serviceStateStatus = Integer.valueOf(query.getInt(i107));
                    }
                    int i108 = columnIndexOrThrow90;
                    Integer valueOf12 = query.isNull(i108) ? null : Integer.valueOf(query.getInt(i108));
                    if (valueOf12 == null) {
                        columnIndexOrThrow90 = i108;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow90 = i108;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    traceRouteMetric.isNrCellSeen = bool12;
                    int i109 = columnIndexOrThrow91;
                    Integer valueOf13 = query.isNull(i109) ? null : Integer.valueOf(query.getInt(i109));
                    if (valueOf13 == null) {
                        columnIndexOrThrow91 = i109;
                        bool13 = null;
                    } else {
                        columnIndexOrThrow91 = i109;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    traceRouteMetric.isReadPhoneStatePermissionGranted = bool13;
                    int i110 = columnIndexOrThrow92;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow89 = i107;
                        traceRouteMetric.appVersionName = null;
                    } else {
                        columnIndexOrThrow89 = i107;
                        traceRouteMetric.appVersionName = query.getString(i110);
                    }
                    int i111 = i82;
                    int i112 = columnIndexOrThrow93;
                    int i113 = i83;
                    traceRouteMetric.appVersionCode = query.getLong(i112);
                    int i114 = i110;
                    int i115 = columnIndexOrThrow94;
                    int i116 = i112;
                    traceRouteMetric.appLastUpdateTime = query.getLong(i115);
                    int i117 = columnIndexOrThrow95;
                    traceRouteMetric.duplexModeState = query.getInt(i117);
                    columnIndexOrThrow95 = i117;
                    int i118 = columnIndexOrThrow96;
                    traceRouteMetric.dozeModeState = query.getInt(i118);
                    columnIndexOrThrow96 = i118;
                    int i119 = columnIndexOrThrow97;
                    traceRouteMetric.callState = query.getInt(i119);
                    int i120 = columnIndexOrThrow98;
                    if (query.isNull(i120)) {
                        columnIndexOrThrow97 = i119;
                        traceRouteMetric.buildDevice = null;
                    } else {
                        columnIndexOrThrow97 = i119;
                        traceRouteMetric.buildDevice = query.getString(i120);
                    }
                    int i121 = columnIndexOrThrow99;
                    if (query.isNull(i121)) {
                        columnIndexOrThrow98 = i120;
                        traceRouteMetric.buildHardware = null;
                    } else {
                        columnIndexOrThrow98 = i120;
                        traceRouteMetric.buildHardware = query.getString(i121);
                    }
                    int i122 = columnIndexOrThrow100;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow99 = i121;
                        traceRouteMetric.buildProduct = null;
                    } else {
                        columnIndexOrThrow99 = i121;
                        traceRouteMetric.buildProduct = query.getString(i122);
                    }
                    int i123 = columnIndexOrThrow101;
                    if (query.isNull(i123)) {
                        columnIndexOrThrow100 = i122;
                        traceRouteMetric.appId = null;
                    } else {
                        columnIndexOrThrow100 = i122;
                        traceRouteMetric.appId = query.getString(i123);
                    }
                    int i124 = columnIndexOrThrow102;
                    if (query.getInt(i124) != 0) {
                        columnIndexOrThrow101 = i123;
                        z = true;
                    } else {
                        columnIndexOrThrow101 = i123;
                        z = false;
                    }
                    traceRouteMetric.isSending = z;
                    arrayList2 = arrayList;
                    arrayList2.add(traceRouteMetric);
                    columnIndexOrThrow102 = i124;
                    columnIndexOrThrow11 = i;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow16 = i3;
                    columnIndexOrThrow17 = i4;
                    columnIndexOrThrow18 = i27;
                    columnIndexOrThrow19 = i29;
                    columnIndexOrThrow20 = i5;
                    columnIndexOrThrow21 = i6;
                    columnIndexOrThrow22 = i39;
                    columnIndexOrThrow25 = i7;
                    columnIndexOrThrow26 = i79;
                    columnIndexOrThrow64 = i10;
                    columnIndexOrThrow66 = i111;
                    columnIndexOrThrow56 = i9;
                    columnIndexOrThrow92 = i114;
                    columnIndexOrThrow = i21;
                    columnIndexOrThrow14 = i20;
                    columnIndexOrThrow2 = i18;
                    int i125 = i116;
                    columnIndexOrThrow94 = i115;
                    columnIndexOrThrow12 = i33;
                    columnIndexOrThrow23 = i36;
                    columnIndexOrThrow24 = i8;
                    columnIndexOrThrow27 = i81;
                    columnIndexOrThrow65 = i11;
                    columnIndexOrThrow67 = i113;
                    columnIndexOrThrow93 = i125;
                    int i126 = i12;
                    columnIndexOrThrow71 = i91;
                    columnIndexOrThrow70 = i126;
                    int i127 = i13;
                    columnIndexOrThrow78 = i14;
                    columnIndexOrThrow77 = i127;
                    int i128 = i15;
                    columnIndexOrThrow80 = i99;
                    columnIndexOrThrow79 = i128;
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
