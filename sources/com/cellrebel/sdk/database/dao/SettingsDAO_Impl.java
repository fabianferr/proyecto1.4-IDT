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
import com.cellrebel.sdk.database.TrafficProfilesConverter;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SettingsDAO_Impl implements SettingsDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<Settings> b;
    /* access modifiers changed from: private */
    public final TrafficProfilesConverter c = new TrafficProfilesConverter();
    private final SharedSQLiteStatement d;

    class a extends EntityInsertionAdapter<Settings> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Settings settings) {
            supportSQLiteStatement.bindLong(1, settings.id);
            String str = settings.mobileClientId;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            Boolean bool = settings.connectionMeasurements;
            Integer num = null;
            Integer valueOf = bool == null ? null : Integer.valueOf(bool.booleanValue() ? 1 : 0);
            if (valueOf == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindLong(3, (long) valueOf.intValue());
            }
            Integer num2 = settings.connectionMeasurementPeriodicity;
            if (num2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindLong(4, (long) num2.intValue());
            }
            Integer num3 = settings.connectionMeasurementFrequency;
            if (num3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, (long) num3.intValue());
            }
            Integer num4 = settings.onScreenMeasurement;
            if (num4 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, (long) num4.intValue());
            }
            Boolean bool2 = settings.voiceCallsMeasurement;
            Integer valueOf2 = bool2 == null ? null : Integer.valueOf(bool2.booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindLong(7, (long) valueOf2.intValue());
            }
            Boolean bool3 = settings.videoBackgroundMeasurement;
            Integer valueOf3 = bool3 == null ? null : Integer.valueOf(bool3.booleanValue() ? 1 : 0);
            if (valueOf3 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, (long) valueOf3.intValue());
            }
            Boolean bool4 = settings.videoActiveMeasurement;
            Integer valueOf4 = bool4 == null ? null : Integer.valueOf(bool4.booleanValue() ? 1 : 0);
            if (valueOf4 == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, (long) valueOf4.intValue());
            }
            Integer num5 = settings.videoBackgroundPeriodicityMeasurement;
            if (num5 == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, (long) num5.intValue());
            }
            Integer num6 = settings.videoForegroundPeriodicityMeasurement;
            if (num6 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, (long) num6.intValue());
            }
            Integer num7 = settings.videoBufferingThreshold;
            if (num7 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindLong(12, (long) num7.intValue());
            }
            String str2 = settings.videoUrl;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str2);
            }
            String str3 = settings.videoProvider;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, str3);
            }
            Integer num8 = settings.videoTimeoutTimer;
            if (num8 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, (long) num8.intValue());
            }
            Integer num9 = settings.videoTimeoutFactor;
            if (num9 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindLong(16, (long) num9.intValue());
            }
            Boolean bool5 = settings.isPageLoadMeasurement;
            Integer valueOf5 = bool5 == null ? null : Integer.valueOf(bool5.booleanValue() ? 1 : 0);
            if (valueOf5 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindLong(17, (long) valueOf5.intValue());
            }
            Boolean bool6 = settings.pageLoadBackgroundMeasurement;
            Integer valueOf6 = bool6 == null ? null : Integer.valueOf(bool6.booleanValue() ? 1 : 0);
            if (valueOf6 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindLong(18, (long) valueOf6.intValue());
            }
            String str4 = settings.pageLoadUrl;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str4);
            }
            Integer num10 = settings.pageLoadTimeoutTimer;
            if (num10 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindLong(20, (long) num10.intValue());
            }
            Integer num11 = settings.pageLoadPeriodicityMeasurement;
            if (num11 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindLong(21, (long) num11.intValue());
            }
            Integer num12 = settings.pageLoadForegroundPeriodicityMeasurement;
            if (num12 == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindLong(22, (long) num12.intValue());
            }
            String str5 = settings.fileName;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str5);
            }
            Boolean bool7 = settings.fileMeasurement;
            Integer valueOf7 = bool7 == null ? null : Integer.valueOf(bool7.booleanValue() ? 1 : 0);
            if (valueOf7 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindLong(24, (long) valueOf7.intValue());
            }
            Boolean bool8 = settings.fileTransferBackgroundMeasurement;
            Integer valueOf8 = bool8 == null ? null : Integer.valueOf(bool8.booleanValue() ? 1 : 0);
            if (valueOf8 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindLong(25, (long) valueOf8.intValue());
            }
            Integer num13 = settings.fileTransferPeriodicityTimer;
            if (num13 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindLong(26, (long) num13.intValue());
            }
            Integer num14 = settings.fileTransferForegroundPeriodicityTimer;
            if (num14 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindLong(27, (long) num14.intValue());
            }
            Integer num15 = settings.fileTransferTimeoutTimer;
            if (num15 == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindLong(28, (long) num15.intValue());
            }
            String str6 = settings.serverIdFileLoad;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str6);
            }
            String str7 = settings.fileServerUrls;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str7);
            }
            Boolean bool9 = settings.cdnFileMeasurements;
            Integer valueOf9 = bool9 == null ? null : Integer.valueOf(bool9.booleanValue() ? 1 : 0);
            if (valueOf9 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindLong(31, (long) valueOf9.intValue());
            }
            Boolean bool10 = settings.cdnBackgroundMeasurement;
            Integer valueOf10 = bool10 == null ? null : Integer.valueOf(bool10.booleanValue() ? 1 : 0);
            if (valueOf10 == null) {
                supportSQLiteStatement.bindNull(32);
            } else {
                supportSQLiteStatement.bindLong(32, (long) valueOf10.intValue());
            }
            Integer num16 = settings.cdnFileDownloadPeriodicity;
            if (num16 == null) {
                supportSQLiteStatement.bindNull(33);
            } else {
                supportSQLiteStatement.bindLong(33, (long) num16.intValue());
            }
            Integer num17 = settings.cdnFileDownloadForegroundPeriodicity;
            if (num17 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindLong(34, (long) num17.intValue());
            }
            Integer num18 = settings.cdnFileDownloadTimeout;
            if (num18 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindLong(35, (long) num18.intValue());
            }
            String str8 = settings.cdnFileUrls;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(36);
            } else {
                supportSQLiteStatement.bindString(36, str8);
            }
            Integer num19 = settings.timeInBetweenMeasurements;
            if (num19 == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindLong(37, (long) num19.intValue());
            }
            Boolean bool11 = settings.dataUsage;
            Integer valueOf11 = bool11 == null ? null : Integer.valueOf(bool11.booleanValue() ? 1 : 0);
            if (valueOf11 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindLong(38, (long) valueOf11.intValue());
            }
            Boolean bool12 = settings.dataUsageBackgroundMeasurement;
            Integer valueOf12 = bool12 == null ? null : Integer.valueOf(bool12.booleanValue() ? 1 : 0);
            if (valueOf12 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindLong(39, (long) valueOf12.intValue());
            }
            Integer num20 = settings.dataUsagePeriodicity;
            if (num20 == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindLong(40, (long) num20.intValue());
            }
            Integer num21 = settings.foregroundPeriodicity;
            if (num21 == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindLong(41, (long) num21.intValue());
            }
            Integer num22 = settings.foregroundMeasurementPeriodicity;
            if (num22 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindLong(42, (long) num22.intValue());
            }
            Boolean bool13 = settings.coverageMeasurement;
            Integer valueOf13 = bool13 == null ? null : Integer.valueOf(bool13.booleanValue() ? 1 : 0);
            if (valueOf13 == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindLong(43, (long) valueOf13.intValue());
            }
            Boolean bool14 = settings.backgroundCoverageMeasurement;
            Integer valueOf14 = bool14 == null ? null : Integer.valueOf(bool14.booleanValue() ? 1 : 0);
            if (valueOf14 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindLong(44, (long) valueOf14.intValue());
            }
            Integer num23 = settings.coveragePeriodicity;
            if (num23 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindLong(45, (long) num23.intValue());
            }
            Integer num24 = settings.coverageForegroundPeriodicity;
            if (num24 == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindLong(46, (long) num24.intValue());
            }
            Integer num25 = settings.foregroundCoverageTimeout;
            if (num25 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindLong(47, (long) num25.intValue());
            }
            Integer num26 = settings.backgroundCoverageTimeout;
            if (num26 == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindLong(48, (long) num26.intValue());
            }
            Integer num27 = settings.foregroundCoverageSamplingInterval;
            if (num27 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindLong(49, (long) num27.intValue());
            }
            Integer num28 = settings.backgroundCoverageSamplingInterval;
            if (num28 == null) {
                supportSQLiteStatement.bindNull(50);
            } else {
                supportSQLiteStatement.bindLong(50, (long) num28.intValue());
            }
            Integer num29 = settings.reportingPeriodicity;
            if (num29 == null) {
                supportSQLiteStatement.bindNull(51);
            } else {
                supportSQLiteStatement.bindLong(51, (long) num29.intValue());
            }
            Integer num30 = settings.gameCacheRefresh;
            if (num30 == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindLong(52, (long) num30.intValue());
            }
            Integer num31 = settings.gamePingsPerServer;
            if (num31 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindLong(53, (long) num31.intValue());
            }
            Integer num32 = settings.gameServersCache;
            if (num32 == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindLong(54, (long) num32.intValue());
            }
            Integer num33 = settings.gameTimeoutTimer;
            if (num33 == null) {
                supportSQLiteStatement.bindNull(55);
            } else {
                supportSQLiteStatement.bindLong(55, (long) num33.intValue());
            }
            Boolean bool15 = settings.gameServersCacheEnabled;
            Integer valueOf15 = bool15 == null ? null : Integer.valueOf(bool15.booleanValue() ? 1 : 0);
            if (valueOf15 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindLong(56, (long) valueOf15.intValue());
            }
            Integer num34 = settings.backgroundGamePeriodicity;
            if (num34 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindLong(57, (long) num34.intValue());
            }
            Integer num35 = settings.backgroundGameReportingPeriodicity;
            if (num35 == null) {
                supportSQLiteStatement.bindNull(58);
            } else {
                supportSQLiteStatement.bindLong(58, (long) num35.intValue());
            }
            Boolean bool16 = settings.foregroundGameMeasurement;
            Integer valueOf16 = bool16 == null ? null : Integer.valueOf(bool16.booleanValue() ? 1 : 0);
            if (valueOf16 == null) {
                supportSQLiteStatement.bindNull(59);
            } else {
                supportSQLiteStatement.bindLong(59, (long) valueOf16.intValue());
            }
            Boolean bool17 = settings.backgroundGameMeasurement;
            Integer valueOf17 = bool17 == null ? null : Integer.valueOf(bool17.booleanValue() ? 1 : 0);
            if (valueOf17 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindLong(60, (long) valueOf17.intValue());
            }
            Integer num36 = settings.foregroundGamePeriodicity;
            if (num36 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindLong(61, (long) num36.intValue());
            }
            Boolean bool18 = settings.noLocationMeasurementEnabled;
            Integer valueOf18 = bool18 == null ? null : Integer.valueOf(bool18.booleanValue() ? 1 : 0);
            if (valueOf18 == null) {
                supportSQLiteStatement.bindNull(62);
            } else {
                supportSQLiteStatement.bindLong(62, (long) valueOf18.intValue());
            }
            Boolean bool19 = settings.wifiMeasurementsEnabled;
            Integer valueOf19 = bool19 == null ? null : Integer.valueOf(bool19.booleanValue() ? 1 : 0);
            if (valueOf19 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindLong(63, (long) valueOf19.intValue());
            }
            Boolean bool20 = settings.audioManagerEnabled;
            Integer valueOf20 = bool20 == null ? null : Integer.valueOf(bool20.booleanValue() ? 1 : 0);
            if (valueOf20 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindLong(64, (long) valueOf20.intValue());
            }
            Boolean bool21 = settings.cellInfoUpdateEnabled;
            Integer valueOf21 = bool21 == null ? null : Integer.valueOf(bool21.booleanValue() ? 1 : 0);
            if (valueOf21 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindLong(65, (long) valueOf21.intValue());
            }
            Integer num37 = settings.wifiForegroundTimer;
            if (num37 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindLong(66, (long) num37.intValue());
            }
            Integer num38 = settings.wifiPageLoadForegroundPeriodicity;
            if (num38 == null) {
                supportSQLiteStatement.bindNull(67);
            } else {
                supportSQLiteStatement.bindLong(67, (long) num38.intValue());
            }
            Integer num39 = settings.wifiFileTransferForegroundPeriodicity;
            if (num39 == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindLong(68, (long) num39.intValue());
            }
            Integer num40 = settings.wifiCdnFileDownloadForegroundPeriodicity;
            if (num40 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindLong(69, (long) num40.intValue());
            }
            Integer num41 = settings.wifiVideoForegroundPeriodicity;
            if (num41 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindLong(70, (long) num41.intValue());
            }
            Integer num42 = settings.wifiGameForegroundPeriodicity;
            if (num42 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindLong(71, (long) num42.intValue());
            }
            Integer num43 = settings.wifiCoverageForegroundPeriodicity;
            if (num43 == null) {
                supportSQLiteStatement.bindNull(72);
            } else {
                supportSQLiteStatement.bindLong(72, (long) num43.intValue());
            }
            Integer num44 = settings.wifiDataUsageForegroundPeriodicity;
            if (num44 == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindLong(73, (long) num44.intValue());
            }
            Integer num45 = settings.dataUsageForegroundPeriodicity;
            if (num45 == null) {
                supportSQLiteStatement.bindNull(74);
            } else {
                supportSQLiteStatement.bindLong(74, (long) num45.intValue());
            }
            Boolean bool22 = settings.isForegroundListenerEnabled;
            Integer valueOf22 = bool22 == null ? null : Integer.valueOf(bool22.booleanValue() ? 1 : 0);
            if (valueOf22 == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindLong(75, (long) valueOf22.intValue());
            }
            String str9 = settings.settingsUrl;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, str9);
            }
            String str10 = settings.reportingUrl;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindString(77, str10);
            }
            Boolean bool23 = settings.backgroundLocationEnabled;
            Integer valueOf23 = bool23 == null ? null : Integer.valueOf(bool23.booleanValue() ? 1 : 0);
            if (valueOf23 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindLong(78, (long) valueOf23.intValue());
            }
            Boolean bool24 = settings.anonymize;
            Integer valueOf24 = bool24 == null ? null : Integer.valueOf(bool24.booleanValue() ? 1 : 0);
            if (valueOf24 == null) {
                supportSQLiteStatement.bindNull(79);
            } else {
                supportSQLiteStatement.bindLong(79, (long) valueOf24.intValue());
            }
            String str11 = settings.sdkOrigin;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, str11);
            }
            String str12 = settings.secondaryReportingUrls;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindString(81, str12);
            }
            String str13 = settings.accessTechnologyCdnFileUrls;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindString(82, str13);
            }
            String str14 = settings.accessTechnologyFileNames;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str14);
            }
            Boolean bool25 = settings.independentBackgroundCoverageMeasurement;
            Integer valueOf25 = bool25 == null ? null : Integer.valueOf(bool25.booleanValue() ? 1 : 0);
            if (valueOf25 == null) {
                supportSQLiteStatement.bindNull(84);
            } else {
                supportSQLiteStatement.bindLong(84, (long) valueOf25.intValue());
            }
            Boolean bool26 = settings.deviceInfoActiveMeasurements;
            Integer valueOf26 = bool26 == null ? null : Integer.valueOf(bool26.booleanValue() ? 1 : 0);
            if (valueOf26 == null) {
                supportSQLiteStatement.bindNull(85);
            } else {
                supportSQLiteStatement.bindLong(85, (long) valueOf26.intValue());
            }
            Boolean bool27 = settings.deviceInfoBackgroundMeasurements;
            Integer valueOf27 = bool27 == null ? null : Integer.valueOf(bool27.booleanValue() ? 1 : 0);
            if (valueOf27 == null) {
                supportSQLiteStatement.bindNull(86);
            } else {
                supportSQLiteStatement.bindLong(86, (long) valueOf27.intValue());
            }
            Integer num46 = settings.deviceInfoBackgroundPeriodicity;
            if (num46 == null) {
                supportSQLiteStatement.bindNull(87);
            } else {
                supportSQLiteStatement.bindLong(87, (long) num46.intValue());
            }
            Integer num47 = settings.deviceInfoForegroundPeriodicity;
            if (num47 == null) {
                supportSQLiteStatement.bindNull(88);
            } else {
                supportSQLiteStatement.bindLong(88, (long) num47.intValue());
            }
            Boolean bool28 = settings.tracerouteActiveMeasurements;
            Integer valueOf28 = bool28 == null ? null : Integer.valueOf(bool28.booleanValue() ? 1 : 0);
            if (valueOf28 == null) {
                supportSQLiteStatement.bindNull(89);
            } else {
                supportSQLiteStatement.bindLong(89, (long) valueOf28.intValue());
            }
            Boolean bool29 = settings.tracerouteBackgroundMeasurements;
            Integer valueOf29 = bool29 == null ? null : Integer.valueOf(bool29.booleanValue() ? 1 : 0);
            if (valueOf29 == null) {
                supportSQLiteStatement.bindNull(90);
            } else {
                supportSQLiteStatement.bindLong(90, (long) valueOf29.intValue());
            }
            Integer num48 = settings.tracerouteBackgroundPeriodicity;
            if (num48 == null) {
                supportSQLiteStatement.bindNull(91);
            } else {
                supportSQLiteStatement.bindLong(91, (long) num48.intValue());
            }
            Integer num49 = settings.tracerouteForegroundPeriodicity;
            if (num49 == null) {
                supportSQLiteStatement.bindNull(92);
            } else {
                supportSQLiteStatement.bindLong(92, (long) num49.intValue());
            }
            Integer num50 = settings.tracerouteNumberOfHops;
            if (num50 == null) {
                supportSQLiteStatement.bindNull(93);
            } else {
                supportSQLiteStatement.bindLong(93, (long) num50.intValue());
            }
            Integer num51 = settings.traceroutePacketSize;
            if (num51 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindLong(94, (long) num51.intValue());
            }
            String str15 = settings.tracerouteUrl;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(95);
            } else {
                supportSQLiteStatement.bindString(95, str15);
            }
            Boolean bool30 = settings.voiceCallMeasurements;
            Integer valueOf30 = bool30 == null ? null : Integer.valueOf(bool30.booleanValue() ? 1 : 0);
            if (valueOf30 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindLong(96, (long) valueOf30.intValue());
            }
            Integer num52 = settings.wifiTracerouteForegroundPeriodicity;
            if (num52 == null) {
                supportSQLiteStatement.bindNull(97);
            } else {
                supportSQLiteStatement.bindLong(97, (long) num52.intValue());
            }
            Boolean bool31 = settings.loadedLatencyEnabled;
            Integer valueOf31 = bool31 == null ? null : Integer.valueOf(bool31.booleanValue() ? 1 : 0);
            if (valueOf31 == null) {
                supportSQLiteStatement.bindNull(98);
            } else {
                supportSQLiteStatement.bindLong(98, (long) valueOf31.intValue());
            }
            Boolean bool32 = settings.wifiLoadedLatencyEnabled;
            Integer valueOf32 = bool32 == null ? null : Integer.valueOf(bool32.booleanValue() ? 1 : 0);
            if (valueOf32 == null) {
                supportSQLiteStatement.bindNull(99);
            } else {
                supportSQLiteStatement.bindLong(99, (long) valueOf32.intValue());
            }
            Integer num53 = settings.foregroundLoadedLatencyPeriodicity;
            if (num53 == null) {
                supportSQLiteStatement.bindNull(100);
            } else {
                supportSQLiteStatement.bindLong(100, (long) num53.intValue());
            }
            Integer num54 = settings.foregroundLoadedLatencyPeriodicityWifi;
            if (num54 == null) {
                supportSQLiteStatement.bindNull(101);
            } else {
                supportSQLiteStatement.bindLong(101, (long) num54.intValue());
            }
            Integer num55 = settings.loadedLatencyMeasurementsPerServer;
            if (num55 == null) {
                supportSQLiteStatement.bindNull(102);
            } else {
                supportSQLiteStatement.bindLong(102, (long) num55.intValue());
            }
            Integer num56 = settings.loadedLatencyServersCache;
            if (num56 == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindLong(103, (long) num56.intValue());
            }
            Integer num57 = settings.loadedLatencyTimeoutTimer;
            if (num57 == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindLong(104, (long) num57.intValue());
            }
            Integer num58 = settings.loadedLatencyCacheRefresh;
            if (num58 == null) {
                supportSQLiteStatement.bindNull(105);
            } else {
                supportSQLiteStatement.bindLong(105, (long) num58.intValue());
            }
            Boolean bool33 = settings.loadedLatencyServersCacheEnabled;
            Integer valueOf33 = bool33 == null ? null : Integer.valueOf(bool33.booleanValue() ? 1 : 0);
            if (valueOf33 == null) {
                supportSQLiteStatement.bindNull(106);
            } else {
                supportSQLiteStatement.bindLong(106, (long) valueOf33.intValue());
            }
            Boolean bool34 = settings.randomCdnFileMeasurements;
            Integer valueOf34 = bool34 == null ? null : Integer.valueOf(bool34.booleanValue() ? 1 : 0);
            if (valueOf34 == null) {
                supportSQLiteStatement.bindNull(107);
            } else {
                supportSQLiteStatement.bindLong(107, (long) valueOf34.intValue());
            }
            Boolean bool35 = settings.randomCdnBackgroundMeasurement;
            Integer valueOf35 = bool35 == null ? null : Integer.valueOf(bool35.booleanValue() ? 1 : 0);
            if (valueOf35 == null) {
                supportSQLiteStatement.bindNull(108);
            } else {
                supportSQLiteStatement.bindLong(108, (long) valueOf35.intValue());
            }
            Integer num59 = settings.randomCdnFileDownloadForegroundPeriodicity;
            if (num59 == null) {
                supportSQLiteStatement.bindNull(109);
            } else {
                supportSQLiteStatement.bindLong(109, (long) num59.intValue());
            }
            Integer num60 = settings.randomCdnFileDownloadPeriodicity;
            if (num60 == null) {
                supportSQLiteStatement.bindNull(110);
            } else {
                supportSQLiteStatement.bindLong(110, (long) num60.intValue());
            }
            Integer num61 = settings.wifiRandomCdnFileDownloadForegroundPeriodicity;
            if (num61 == null) {
                supportSQLiteStatement.bindNull(111);
            } else {
                supportSQLiteStatement.bindLong(111, (long) num61.intValue());
            }
            Integer num62 = settings.randomCdnFileDownloadTimeout;
            if (num62 == null) {
                supportSQLiteStatement.bindNull(112);
            } else {
                supportSQLiteStatement.bindLong(112, (long) num62.intValue());
            }
            String str16 = settings.randomCdnFileUrls;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(113);
            } else {
                supportSQLiteStatement.bindString(113, str16);
            }
            Integer num63 = settings.randomCdnServerCount;
            if (num63 == null) {
                supportSQLiteStatement.bindNull(114);
            } else {
                supportSQLiteStatement.bindLong(114, (long) num63.intValue());
            }
            Boolean bool36 = settings.trafficProfileMeasurementsEnabled;
            Integer valueOf36 = bool36 == null ? null : Integer.valueOf(bool36.booleanValue() ? 1 : 0);
            if (valueOf36 == null) {
                supportSQLiteStatement.bindNull(115);
            } else {
                supportSQLiteStatement.bindLong(115, (long) valueOf36.intValue());
            }
            Boolean bool37 = settings.trafficProfileBackgroundMeasurementsEnabled;
            Integer valueOf37 = bool37 == null ? null : Integer.valueOf(bool37.booleanValue() ? 1 : 0);
            if (valueOf37 == null) {
                supportSQLiteStatement.bindNull(116);
            } else {
                supportSQLiteStatement.bindLong(116, (long) valueOf37.intValue());
            }
            Integer num64 = settings.trafficProfileForegroundPeriodicity;
            if (num64 == null) {
                supportSQLiteStatement.bindNull(117);
            } else {
                supportSQLiteStatement.bindLong(117, (long) num64.intValue());
            }
            Integer num65 = settings.trafficProfileBackgroundPeriodicity;
            if (num65 == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindLong(118, (long) num65.intValue());
            }
            Integer num66 = settings.trafficProfileWiFiPeriodicity;
            if (num66 == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindLong(119, (long) num66.intValue());
            }
            Integer num67 = settings.trafficProfileTimeout;
            if (num67 == null) {
                supportSQLiteStatement.bindNull(120);
            } else {
                supportSQLiteStatement.bindLong(120, (long) num67.intValue());
            }
            Integer num68 = settings.trafficProfileMeasurementLimit;
            if (num68 == null) {
                supportSQLiteStatement.bindNull(121);
            } else {
                supportSQLiteStatement.bindLong(121, (long) num68.intValue());
            }
            String str17 = settings.trafficProfileServerUrls;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(122);
            } else {
                supportSQLiteStatement.bindString(122, str17);
            }
            String a2 = SettingsDAO_Impl.this.c.a(settings.trafficProfiles);
            if (a2 == null) {
                supportSQLiteStatement.bindNull(123);
            } else {
                supportSQLiteStatement.bindString(123, a2);
            }
            Boolean bool38 = settings.timeToInteractionMeasurementsEnabled;
            Integer valueOf38 = bool38 == null ? null : Integer.valueOf(bool38.booleanValue() ? 1 : 0);
            if (valueOf38 == null) {
                supportSQLiteStatement.bindNull(124);
            } else {
                supportSQLiteStatement.bindLong(124, (long) valueOf38.intValue());
            }
            Boolean bool39 = settings.timeToInteractionBackgroundMeasurementsEnabled;
            Integer valueOf39 = bool39 == null ? null : Integer.valueOf(bool39.booleanValue() ? 1 : 0);
            if (valueOf39 == null) {
                supportSQLiteStatement.bindNull(125);
            } else {
                supportSQLiteStatement.bindLong(125, (long) valueOf39.intValue());
            }
            Integer num69 = settings.timeToInteractionForegroundPeriodicity;
            if (num69 == null) {
                supportSQLiteStatement.bindNull(126);
            } else {
                supportSQLiteStatement.bindLong(126, (long) num69.intValue());
            }
            Integer num70 = settings.timeToInteractionBackgroundPeriodicity;
            if (num70 == null) {
                supportSQLiteStatement.bindNull(127);
            } else {
                supportSQLiteStatement.bindLong(127, (long) num70.intValue());
            }
            Integer num71 = settings.timeToInteractionWiFiPeriodicity;
            if (num71 == null) {
                supportSQLiteStatement.bindNull(128);
            } else {
                supportSQLiteStatement.bindLong(128, (long) num71.intValue());
            }
            Integer num72 = settings.timeToInteractionTimeout;
            if (num72 == null) {
                supportSQLiteStatement.bindNull(129);
            } else {
                supportSQLiteStatement.bindLong(129, (long) num72.intValue());
            }
            Integer num73 = settings.timeToInteractionDownloadFileSize;
            if (num73 == null) {
                supportSQLiteStatement.bindNull(130);
            } else {
                supportSQLiteStatement.bindLong(130, (long) num73.intValue());
            }
            Integer num74 = settings.timeToInteractionUploadFileSize;
            if (num74 == null) {
                supportSQLiteStatement.bindNull(131);
            } else {
                supportSQLiteStatement.bindLong(131, (long) num74.intValue());
            }
            Integer num75 = settings.timeToInteractionServerListLimit;
            if (num75 == null) {
                supportSQLiteStatement.bindNull(132);
            } else {
                supportSQLiteStatement.bindLong(132, (long) num75.intValue());
            }
            Integer num76 = settings.timeToInteractionServerSelectionTimeout;
            if (num76 == null) {
                supportSQLiteStatement.bindNull(133);
            } else {
                supportSQLiteStatement.bindLong(133, (long) num76.intValue());
            }
            Integer num77 = settings.timeToInteractionPingTimeout;
            if (num77 == null) {
                supportSQLiteStatement.bindNull(134);
            } else {
                supportSQLiteStatement.bindLong(134, (long) num77.intValue());
            }
            Integer num78 = settings.timeToInteractionPingsPerServer;
            if (num78 == null) {
                supportSQLiteStatement.bindNull(135);
            } else {
                supportSQLiteStatement.bindLong(135, (long) num78.intValue());
            }
            Integer num79 = settings.timeToInteractionUploadStatsInterval;
            if (num79 == null) {
                supportSQLiteStatement.bindNull(136);
            } else {
                supportSQLiteStatement.bindLong(136, (long) num79.intValue());
            }
            Integer num80 = settings.timeToInteractionUploadStatsTimeout;
            if (num80 == null) {
                supportSQLiteStatement.bindNull(137);
            } else {
                supportSQLiteStatement.bindLong(137, (long) num80.intValue());
            }
            Boolean bool40 = settings.isMeasurementsAutoStartEnabled;
            Integer valueOf40 = bool40 == null ? null : Integer.valueOf(bool40.booleanValue() ? 1 : 0);
            if (valueOf40 == null) {
                supportSQLiteStatement.bindNull(138);
            } else {
                supportSQLiteStatement.bindLong(138, (long) valueOf40.intValue());
            }
            Integer num81 = settings.measurementsAutoStartDelay;
            if (num81 == null) {
                supportSQLiteStatement.bindNull(139);
            } else {
                supportSQLiteStatement.bindLong(139, (long) num81.intValue());
            }
            Boolean bool41 = settings.isServerFallbackEnabled;
            if (bool41 != null) {
                num = Integer.valueOf(bool41.booleanValue() ? 1 : 0);
            }
            if (num == null) {
                supportSQLiteStatement.bindNull(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT);
            } else {
                supportSQLiteStatement.bindLong(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, (long) num.intValue());
            }
            Integer num82 = settings.serverFallbackCount;
            if (num82 == null) {
                supportSQLiteStatement.bindNull(141);
            } else {
                supportSQLiteStatement.bindLong(141, (long) num82.intValue());
            }
            String str18 = settings.connectionTestVideoUrl;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(142);
            } else {
                supportSQLiteStatement.bindString(142, str18);
            }
            Integer num83 = settings.connectionTestVideoTimeout;
            if (num83 == null) {
                supportSQLiteStatement.bindNull(143);
            } else {
                supportSQLiteStatement.bindLong(143, (long) num83.intValue());
            }
            Integer num84 = settings.connectionTestVideoScore;
            if (num84 == null) {
                supportSQLiteStatement.bindNull(144);
            } else {
                supportSQLiteStatement.bindLong(144, (long) num84.intValue());
            }
            String str19 = settings.connectionTestPageLoadUrl;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(145);
            } else {
                supportSQLiteStatement.bindString(145, str19);
            }
            Integer num85 = settings.connectionTestPageLoadTimeout;
            if (num85 == null) {
                supportSQLiteStatement.bindNull(146);
            } else {
                supportSQLiteStatement.bindLong(146, (long) num85.intValue());
            }
            Integer num86 = settings.connectionTestPageLoadScore;
            if (num86 == null) {
                supportSQLiteStatement.bindNull(147);
            } else {
                supportSQLiteStatement.bindLong(147, (long) num86.intValue());
            }
            String str20 = settings.trafficProfilesJson;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(148);
            } else {
                supportSQLiteStatement.bindString(148, str20);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `Settings` (`id`,`mobileClientId`,`connectionMeasurements`,`connectionMeasurementPeriodicity`,`connectionMeasurementFrequency`,`onScreenMeasurement`,`voiceCallsMeasurement`,`videoBackgroundMeasurement`,`videoActiveMeasurement`,`videoBackgroundPeriodicityMeasurement`,`videoForegroundPeriodicityMeasurement`,`videoBufferingThreshold`,`videoUrl`,`videoProvider`,`videoTimeoutTimer`,`videoTimeoutFactor`,`isPageLoadMeasurement`,`pageLoadBackgroundMeasurement`,`pageLoadUrl`,`pageLoadTimeoutTimer`,`pageLoadPeriodicityMeasurement`,`pageLoadForegroundPeriodicityMeasurement`,`fileName`,`fileMeasurement`,`fileTransferBackgroundMeasurement`,`fileTransferPeriodicityTimer`,`fileTransferForegroundPeriodicityTimer`,`fileTransferTimeoutTimer`,`serverIdFileLoad`,`fileServerUrls`,`cdnFileMeasurements`,`cdnBackgroundMeasurement`,`cdnFileDownloadPeriodicity`,`cdnFileDownloadForegroundPeriodicity`,`cdnFileDownloadTimeout`,`cdnFileUrls`,`timeInBetweenMeasurements`,`dataUsage`,`dataUsageBackgroundMeasurement`,`dataUsagePeriodicity`,`foregroundPeriodicity`,`foregroundMeasurementPeriodicity`,`coverageMeasurement`,`backgroundCoverageMeasurement`,`coveragePeriodicity`,`coverageForegroundPeriodicity`,`foregroundCoverageTimeout`,`backgroundCoverageTimeout`,`foregroundCoverageSamplingInterval`,`backgroundCoverageSamplingInterval`,`reportingPeriodicity`,`gameCacheRefresh`,`gamePingsPerServer`,`gameServersCache`,`gameTimeoutTimer`,`gameServersCacheEnabled`,`backgroundGamePeriodicity`,`backgroundGameReportingPeriodicity`,`foregroundGameMeasurement`,`backgroundGameMeasurement`,`foregroundGamePeriodicity`,`noLocationMeasurementEnabled`,`wifiMeasurementsEnabled`,`audioManagerEnabled`,`cellInfoUpdateEnabled`,`wifiForegroundTimer`,`wifiPageLoadForegroundPeriodicity`,`wifiFileTransferForegroundPeriodicity`,`wifiCdnFileDownloadForegroundPeriodicity`,`wifiVideoForegroundPeriodicity`,`wifiGameForegroundPeriodicity`,`wifiCoverageForegroundPeriodicity`,`wifiDataUsageForegroundPeriodicity`,`dataUsageForegroundPeriodicity`,`isForegroundListenerEnabled`,`settingsUrl`,`reportingUrl`,`backgroundLocationEnabled`,`anonymize`,`sdkOrigin`,`secondaryReportingUrls`,`accessTechnologyCdnFileUrls`,`accessTechnologyFileNames`,`independentBackgroundCoverageMeasurement`,`deviceInfoActiveMeasurements`,`deviceInfoBackgroundMeasurements`,`deviceInfoBackgroundPeriodicity`,`deviceInfoForegroundPeriodicity`,`tracerouteActiveMeasurements`,`tracerouteBackgroundMeasurements`,`tracerouteBackgroundPeriodicity`,`tracerouteForegroundPeriodicity`,`tracerouteNumberOfHops`,`traceroutePacketSize`,`tracerouteUrl`,`voiceCallMeasurements`,`wifiTracerouteForegroundPeriodicity`,`loadedLatencyEnabled`,`wifiLoadedLatencyEnabled`,`foregroundLoadedLatencyPeriodicity`,`foregroundLoadedLatencyPeriodicityWifi`,`loadedLatencyMeasurementsPerServer`,`loadedLatencyServersCache`,`loadedLatencyTimeoutTimer`,`loadedLatencyCacheRefresh`,`loadedLatencyServersCacheEnabled`,`randomCdnFileMeasurements`,`randomCdnBackgroundMeasurement`,`randomCdnFileDownloadForegroundPeriodicity`,`randomCdnFileDownloadPeriodicity`,`wifiRandomCdnFileDownloadForegroundPeriodicity`,`randomCdnFileDownloadTimeout`,`randomCdnFileUrls`,`randomCdnServerCount`,`trafficProfileMeasurementsEnabled`,`trafficProfileBackgroundMeasurementsEnabled`,`trafficProfileForegroundPeriodicity`,`trafficProfileBackgroundPeriodicity`,`trafficProfileWiFiPeriodicity`,`trafficProfileTimeout`,`trafficProfileMeasurementLimit`,`trafficProfileServerUrls`,`trafficProfiles`,`timeToInteractionMeasurementsEnabled`,`timeToInteractionBackgroundMeasurementsEnabled`,`timeToInteractionForegroundPeriodicity`,`timeToInteractionBackgroundPeriodicity`,`timeToInteractionWiFiPeriodicity`,`timeToInteractionTimeout`,`timeToInteractionDownloadFileSize`,`timeToInteractionUploadFileSize`,`timeToInteractionServerListLimit`,`timeToInteractionServerSelectionTimeout`,`timeToInteractionPingTimeout`,`timeToInteractionPingsPerServer`,`timeToInteractionUploadStatsInterval`,`timeToInteractionUploadStatsTimeout`,`isMeasurementsAutoStartEnabled`,`measurementsAutoStartDelay`,`isServerFallbackEnabled`,`serverFallbackCount`,`connectionTestVideoUrl`,`connectionTestVideoTimeout`,`connectionTestVideoScore`,`connectionTestPageLoadUrl`,`connectionTestPageLoadTimeout`,`connectionTestPageLoadScore`,`traffic_profiles`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM settings";
        }
    }

    public SettingsDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.d = new b(roomDatabase);
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

    public void a(Settings settings) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(settings);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<Settings> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Boolean bool5;
        Boolean bool6;
        int i7;
        Boolean bool7;
        Boolean bool8;
        int i8;
        int i9;
        Boolean bool9;
        Boolean bool10;
        int i10;
        int i11;
        Boolean bool11;
        Boolean bool12;
        int i12;
        int i13;
        Boolean bool13;
        Boolean bool14;
        int i14;
        int i15;
        Boolean bool15;
        int i16;
        Boolean bool16;
        Boolean bool17;
        int i17;
        Boolean bool18;
        Boolean bool19;
        Boolean bool20;
        Boolean bool21;
        int i18;
        int i19;
        Boolean bool22;
        int i20;
        Boolean bool23;
        Boolean bool24;
        Boolean bool25;
        Boolean bool26;
        Boolean bool27;
        Boolean bool28;
        Boolean bool29;
        int i21;
        Boolean bool30;
        int i22;
        int i23;
        Boolean bool31;
        Boolean bool32;
        int i24;
        Boolean bool33;
        Boolean bool34;
        Boolean bool35;
        Boolean bool36;
        Boolean bool37;
        int i25;
        String string;
        Boolean bool38;
        int i26;
        Boolean bool39;
        Boolean bool40;
        Boolean bool41;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from settings", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "connectionMeasurements");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "connectionMeasurementPeriodicity");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "connectionMeasurementFrequency");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "onScreenMeasurement");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "voiceCallsMeasurement");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "videoBackgroundMeasurement");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "videoActiveMeasurement");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "videoBackgroundPeriodicityMeasurement");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "videoForegroundPeriodicityMeasurement");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "videoBufferingThreshold");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "videoUrl");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "videoProvider");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "videoTimeoutTimer");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "videoTimeoutFactor");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "isPageLoadMeasurement");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadBackgroundMeasurement");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadUrl");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadTimeoutTimer");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadPeriodicityMeasurement");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadForegroundPeriodicityMeasurement");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "fileName");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "fileMeasurement");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferBackgroundMeasurement");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferPeriodicityTimer");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferForegroundPeriodicityTimer");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferTimeoutTimer");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "serverIdFileLoad");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "fileServerUrls");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "cdnFileMeasurements");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "cdnBackgroundMeasurement");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "cdnFileDownloadPeriodicity");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "cdnFileDownloadForegroundPeriodicity");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "cdnFileDownloadTimeout");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "cdnFileUrls");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "timeInBetweenMeasurements");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "dataUsage");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "dataUsageBackgroundMeasurement");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "dataUsagePeriodicity");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "foregroundPeriodicity");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "foregroundMeasurementPeriodicity");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "coverageMeasurement");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "backgroundCoverageMeasurement");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "coveragePeriodicity");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "coverageForegroundPeriodicity");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCoverageTimeout");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "backgroundCoverageTimeout");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCoverageSamplingInterval");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "backgroundCoverageSamplingInterval");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "reportingPeriodicity");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "gameCacheRefresh");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "gamePingsPerServer");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "gameServersCache");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "gameTimeoutTimer");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "gameServersCacheEnabled");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "backgroundGamePeriodicity");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "backgroundGameReportingPeriodicity");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "foregroundGameMeasurement");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "backgroundGameMeasurement");
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "foregroundGamePeriodicity");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "noLocationMeasurementEnabled");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "wifiMeasurementsEnabled");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "audioManagerEnabled");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "cellInfoUpdateEnabled");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "wifiForegroundTimer");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "wifiPageLoadForegroundPeriodicity");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "wifiFileTransferForegroundPeriodicity");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "wifiCdnFileDownloadForegroundPeriodicity");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "wifiVideoForegroundPeriodicity");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "wifiGameForegroundPeriodicity");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "wifiCoverageForegroundPeriodicity");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "wifiDataUsageForegroundPeriodicity");
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "dataUsageForegroundPeriodicity");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "isForegroundListenerEnabled");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "settingsUrl");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "reportingUrl");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "backgroundLocationEnabled");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "anonymize");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "sdkOrigin");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "secondaryReportingUrls");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnologyCdnFileUrls");
                int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "accessTechnologyFileNames");
                int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "independentBackgroundCoverageMeasurement");
                int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "deviceInfoActiveMeasurements");
                int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "deviceInfoBackgroundMeasurements");
                int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, "deviceInfoBackgroundPeriodicity");
                int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "deviceInfoForegroundPeriodicity");
                int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteActiveMeasurements");
                int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteBackgroundMeasurements");
                int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteBackgroundPeriodicity");
                int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteForegroundPeriodicity");
                int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteNumberOfHops");
                int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "traceroutePacketSize");
                int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "tracerouteUrl");
                int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "voiceCallMeasurements");
                int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "wifiTracerouteForegroundPeriodicity");
                int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyEnabled");
                int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "wifiLoadedLatencyEnabled");
                int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLoadedLatencyPeriodicity");
                int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLoadedLatencyPeriodicityWifi");
                int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyMeasurementsPerServer");
                int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyServersCache");
                int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyTimeoutTimer");
                int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyCacheRefresh");
                int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatencyServersCacheEnabled");
                int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnFileMeasurements");
                int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnBackgroundMeasurement");
                int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnFileDownloadForegroundPeriodicity");
                int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnFileDownloadPeriodicity");
                int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(query, "wifiRandomCdnFileDownloadForegroundPeriodicity");
                int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnFileDownloadTimeout");
                int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnFileUrls");
                int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnServerCount");
                int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileMeasurementsEnabled");
                int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileBackgroundMeasurementsEnabled");
                int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileForegroundPeriodicity");
                int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileBackgroundPeriodicity");
                int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileWiFiPeriodicity");
                int columnIndexOrThrow120 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileTimeout");
                int columnIndexOrThrow121 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileMeasurementLimit");
                int columnIndexOrThrow122 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfileServerUrls");
                int columnIndexOrThrow123 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfiles");
                int columnIndexOrThrow124 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionMeasurementsEnabled");
                int columnIndexOrThrow125 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionBackgroundMeasurementsEnabled");
                int columnIndexOrThrow126 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionForegroundPeriodicity");
                int columnIndexOrThrow127 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionBackgroundPeriodicity");
                int columnIndexOrThrow128 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionWiFiPeriodicity");
                int columnIndexOrThrow129 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionTimeout");
                int columnIndexOrThrow130 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionDownloadFileSize");
                int columnIndexOrThrow131 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionUploadFileSize");
                int columnIndexOrThrow132 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionServerListLimit");
                int columnIndexOrThrow133 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionServerSelectionTimeout");
                int columnIndexOrThrow134 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionPingTimeout");
                int columnIndexOrThrow135 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionPingsPerServer");
                int columnIndexOrThrow136 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionUploadStatsInterval");
                int columnIndexOrThrow137 = CursorUtil.getColumnIndexOrThrow(query, "timeToInteractionUploadStatsTimeout");
                int columnIndexOrThrow138 = CursorUtil.getColumnIndexOrThrow(query, "isMeasurementsAutoStartEnabled");
                int columnIndexOrThrow139 = CursorUtil.getColumnIndexOrThrow(query, "measurementsAutoStartDelay");
                int columnIndexOrThrow140 = CursorUtil.getColumnIndexOrThrow(query, "isServerFallbackEnabled");
                int columnIndexOrThrow141 = CursorUtil.getColumnIndexOrThrow(query, "serverFallbackCount");
                int columnIndexOrThrow142 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestVideoUrl");
                int columnIndexOrThrow143 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestVideoTimeout");
                int columnIndexOrThrow144 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestVideoScore");
                int columnIndexOrThrow145 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestPageLoadUrl");
                int columnIndexOrThrow146 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestPageLoadTimeout");
                int columnIndexOrThrow147 = CursorUtil.getColumnIndexOrThrow(query, "connectionTestPageLoadScore");
                int columnIndexOrThrow148 = CursorUtil.getColumnIndexOrThrow(query, "traffic_profiles");
                int i27 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Settings settings = new Settings();
                    int i28 = columnIndexOrThrow9;
                    int i29 = columnIndexOrThrow10;
                    settings.id = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        settings.mobileClientId = null;
                    } else {
                        settings.mobileClientId = query.getString(columnIndexOrThrow2);
                    }
                    Integer valueOf = query.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow3));
                    if (valueOf == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    settings.connectionMeasurements = bool;
                    if (query.isNull(columnIndexOrThrow4)) {
                        settings.connectionMeasurementPeriodicity = null;
                    } else {
                        settings.connectionMeasurementPeriodicity = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        settings.connectionMeasurementFrequency = null;
                    } else {
                        settings.connectionMeasurementFrequency = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        settings.onScreenMeasurement = null;
                    } else {
                        settings.onScreenMeasurement = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                    }
                    Integer valueOf2 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                    if (valueOf2 == null) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    settings.voiceCallsMeasurement = bool2;
                    Integer valueOf3 = query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    if (valueOf3 == null) {
                        bool3 = null;
                    } else {
                        bool3 = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    settings.videoBackgroundMeasurement = bool3;
                    columnIndexOrThrow9 = i28;
                    Integer valueOf4 = query.isNull(columnIndexOrThrow9) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    if (valueOf4 == null) {
                        bool4 = null;
                    } else {
                        bool4 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    settings.videoActiveMeasurement = bool4;
                    columnIndexOrThrow10 = i29;
                    if (query.isNull(columnIndexOrThrow10)) {
                        i = columnIndexOrThrow;
                        settings.videoBackgroundPeriodicityMeasurement = null;
                    } else {
                        i = columnIndexOrThrow;
                        settings.videoBackgroundPeriodicityMeasurement = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        settings.videoForegroundPeriodicityMeasurement = null;
                    } else {
                        settings.videoForegroundPeriodicityMeasurement = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        settings.videoBufferingThreshold = null;
                    } else {
                        settings.videoBufferingThreshold = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                    }
                    int i30 = i27;
                    if (query.isNull(i30)) {
                        i2 = columnIndexOrThrow11;
                        settings.videoUrl = null;
                    } else {
                        i2 = columnIndexOrThrow11;
                        settings.videoUrl = query.getString(i30);
                    }
                    int i31 = columnIndexOrThrow14;
                    if (query.isNull(i31)) {
                        i3 = columnIndexOrThrow12;
                        settings.videoProvider = null;
                    } else {
                        i3 = columnIndexOrThrow12;
                        settings.videoProvider = query.getString(i31);
                    }
                    int i32 = columnIndexOrThrow15;
                    if (query.isNull(i32)) {
                        i4 = i31;
                        settings.videoTimeoutTimer = null;
                    } else {
                        i4 = i31;
                        settings.videoTimeoutTimer = Integer.valueOf(query.getInt(i32));
                    }
                    int i33 = columnIndexOrThrow16;
                    if (query.isNull(i33)) {
                        i5 = i32;
                        settings.videoTimeoutFactor = null;
                    } else {
                        i5 = i32;
                        settings.videoTimeoutFactor = Integer.valueOf(query.getInt(i33));
                    }
                    int i34 = columnIndexOrThrow17;
                    Integer valueOf5 = query.isNull(i34) ? null : Integer.valueOf(query.getInt(i34));
                    if (valueOf5 == null) {
                        i6 = i33;
                        bool5 = null;
                    } else {
                        i6 = i33;
                        bool5 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    settings.isPageLoadMeasurement = bool5;
                    int i35 = columnIndexOrThrow18;
                    Integer valueOf6 = query.isNull(i35) ? null : Integer.valueOf(query.getInt(i35));
                    if (valueOf6 == null) {
                        columnIndexOrThrow18 = i35;
                        bool6 = null;
                    } else {
                        columnIndexOrThrow18 = i35;
                        bool6 = Boolean.valueOf(valueOf6.intValue() != 0);
                    }
                    settings.pageLoadBackgroundMeasurement = bool6;
                    int i36 = columnIndexOrThrow19;
                    if (query.isNull(i36)) {
                        columnIndexOrThrow17 = i34;
                        settings.pageLoadUrl = null;
                    } else {
                        columnIndexOrThrow17 = i34;
                        settings.pageLoadUrl = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow20;
                    if (query.isNull(i37)) {
                        columnIndexOrThrow19 = i36;
                        settings.pageLoadTimeoutTimer = null;
                    } else {
                        columnIndexOrThrow19 = i36;
                        settings.pageLoadTimeoutTimer = Integer.valueOf(query.getInt(i37));
                    }
                    int i38 = columnIndexOrThrow21;
                    if (query.isNull(i38)) {
                        columnIndexOrThrow20 = i37;
                        settings.pageLoadPeriodicityMeasurement = null;
                    } else {
                        columnIndexOrThrow20 = i37;
                        settings.pageLoadPeriodicityMeasurement = Integer.valueOf(query.getInt(i38));
                    }
                    int i39 = columnIndexOrThrow22;
                    if (query.isNull(i39)) {
                        columnIndexOrThrow21 = i38;
                        settings.pageLoadForegroundPeriodicityMeasurement = null;
                    } else {
                        columnIndexOrThrow21 = i38;
                        settings.pageLoadForegroundPeriodicityMeasurement = Integer.valueOf(query.getInt(i39));
                    }
                    int i40 = columnIndexOrThrow23;
                    if (query.isNull(i40)) {
                        columnIndexOrThrow22 = i39;
                        settings.fileName = null;
                    } else {
                        columnIndexOrThrow22 = i39;
                        settings.fileName = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow24;
                    Integer valueOf7 = query.isNull(i41) ? null : Integer.valueOf(query.getInt(i41));
                    if (valueOf7 == null) {
                        i7 = i40;
                        bool7 = null;
                    } else {
                        i7 = i40;
                        bool7 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    settings.fileMeasurement = bool7;
                    int i42 = columnIndexOrThrow25;
                    Integer valueOf8 = query.isNull(i42) ? null : Integer.valueOf(query.getInt(i42));
                    if (valueOf8 == null) {
                        columnIndexOrThrow25 = i42;
                        bool8 = null;
                    } else {
                        columnIndexOrThrow25 = i42;
                        bool8 = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    settings.fileTransferBackgroundMeasurement = bool8;
                    int i43 = columnIndexOrThrow26;
                    if (query.isNull(i43)) {
                        i8 = i41;
                        settings.fileTransferPeriodicityTimer = null;
                    } else {
                        i8 = i41;
                        settings.fileTransferPeriodicityTimer = Integer.valueOf(query.getInt(i43));
                    }
                    int i44 = columnIndexOrThrow27;
                    if (query.isNull(i44)) {
                        columnIndexOrThrow26 = i43;
                        settings.fileTransferForegroundPeriodicityTimer = null;
                    } else {
                        columnIndexOrThrow26 = i43;
                        settings.fileTransferForegroundPeriodicityTimer = Integer.valueOf(query.getInt(i44));
                    }
                    int i45 = columnIndexOrThrow28;
                    if (query.isNull(i45)) {
                        columnIndexOrThrow27 = i44;
                        settings.fileTransferTimeoutTimer = null;
                    } else {
                        columnIndexOrThrow27 = i44;
                        settings.fileTransferTimeoutTimer = Integer.valueOf(query.getInt(i45));
                    }
                    int i46 = columnIndexOrThrow29;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow28 = i45;
                        settings.serverIdFileLoad = null;
                    } else {
                        columnIndexOrThrow28 = i45;
                        settings.serverIdFileLoad = query.getString(i46);
                    }
                    int i47 = columnIndexOrThrow30;
                    if (query.isNull(i47)) {
                        columnIndexOrThrow29 = i46;
                        settings.fileServerUrls = null;
                    } else {
                        columnIndexOrThrow29 = i46;
                        settings.fileServerUrls = query.getString(i47);
                    }
                    int i48 = columnIndexOrThrow31;
                    Integer valueOf9 = query.isNull(i48) ? null : Integer.valueOf(query.getInt(i48));
                    if (valueOf9 == null) {
                        i9 = i47;
                        bool9 = null;
                    } else {
                        i9 = i47;
                        bool9 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    settings.cdnFileMeasurements = bool9;
                    int i49 = columnIndexOrThrow32;
                    Integer valueOf10 = query.isNull(i49) ? null : Integer.valueOf(query.getInt(i49));
                    if (valueOf10 == null) {
                        columnIndexOrThrow32 = i49;
                        bool10 = null;
                    } else {
                        columnIndexOrThrow32 = i49;
                        bool10 = Boolean.valueOf(valueOf10.intValue() != 0);
                    }
                    settings.cdnBackgroundMeasurement = bool10;
                    int i50 = columnIndexOrThrow33;
                    if (query.isNull(i50)) {
                        i10 = i48;
                        settings.cdnFileDownloadPeriodicity = null;
                    } else {
                        i10 = i48;
                        settings.cdnFileDownloadPeriodicity = Integer.valueOf(query.getInt(i50));
                    }
                    int i51 = columnIndexOrThrow34;
                    if (query.isNull(i51)) {
                        columnIndexOrThrow33 = i50;
                        settings.cdnFileDownloadForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow33 = i50;
                        settings.cdnFileDownloadForegroundPeriodicity = Integer.valueOf(query.getInt(i51));
                    }
                    int i52 = columnIndexOrThrow35;
                    if (query.isNull(i52)) {
                        columnIndexOrThrow34 = i51;
                        settings.cdnFileDownloadTimeout = null;
                    } else {
                        columnIndexOrThrow34 = i51;
                        settings.cdnFileDownloadTimeout = Integer.valueOf(query.getInt(i52));
                    }
                    int i53 = columnIndexOrThrow36;
                    if (query.isNull(i53)) {
                        columnIndexOrThrow35 = i52;
                        settings.cdnFileUrls = null;
                    } else {
                        columnIndexOrThrow35 = i52;
                        settings.cdnFileUrls = query.getString(i53);
                    }
                    int i54 = columnIndexOrThrow37;
                    if (query.isNull(i54)) {
                        columnIndexOrThrow36 = i53;
                        settings.timeInBetweenMeasurements = null;
                    } else {
                        columnIndexOrThrow36 = i53;
                        settings.timeInBetweenMeasurements = Integer.valueOf(query.getInt(i54));
                    }
                    int i55 = columnIndexOrThrow38;
                    Integer valueOf11 = query.isNull(i55) ? null : Integer.valueOf(query.getInt(i55));
                    if (valueOf11 == null) {
                        i11 = i54;
                        bool11 = null;
                    } else {
                        i11 = i54;
                        bool11 = Boolean.valueOf(valueOf11.intValue() != 0);
                    }
                    settings.dataUsage = bool11;
                    int i56 = columnIndexOrThrow39;
                    Integer valueOf12 = query.isNull(i56) ? null : Integer.valueOf(query.getInt(i56));
                    if (valueOf12 == null) {
                        columnIndexOrThrow39 = i56;
                        bool12 = null;
                    } else {
                        columnIndexOrThrow39 = i56;
                        bool12 = Boolean.valueOf(valueOf12.intValue() != 0);
                    }
                    settings.dataUsageBackgroundMeasurement = bool12;
                    int i57 = columnIndexOrThrow40;
                    if (query.isNull(i57)) {
                        i12 = i55;
                        settings.dataUsagePeriodicity = null;
                    } else {
                        i12 = i55;
                        settings.dataUsagePeriodicity = Integer.valueOf(query.getInt(i57));
                    }
                    int i58 = columnIndexOrThrow41;
                    if (query.isNull(i58)) {
                        columnIndexOrThrow40 = i57;
                        settings.foregroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow40 = i57;
                        settings.foregroundPeriodicity = Integer.valueOf(query.getInt(i58));
                    }
                    int i59 = columnIndexOrThrow42;
                    if (query.isNull(i59)) {
                        columnIndexOrThrow41 = i58;
                        settings.foregroundMeasurementPeriodicity = null;
                    } else {
                        columnIndexOrThrow41 = i58;
                        settings.foregroundMeasurementPeriodicity = Integer.valueOf(query.getInt(i59));
                    }
                    int i60 = columnIndexOrThrow43;
                    Integer valueOf13 = query.isNull(i60) ? null : Integer.valueOf(query.getInt(i60));
                    if (valueOf13 == null) {
                        i13 = i59;
                        bool13 = null;
                    } else {
                        i13 = i59;
                        bool13 = Boolean.valueOf(valueOf13.intValue() != 0);
                    }
                    settings.coverageMeasurement = bool13;
                    int i61 = columnIndexOrThrow44;
                    Integer valueOf14 = query.isNull(i61) ? null : Integer.valueOf(query.getInt(i61));
                    if (valueOf14 == null) {
                        columnIndexOrThrow44 = i61;
                        bool14 = null;
                    } else {
                        columnIndexOrThrow44 = i61;
                        bool14 = Boolean.valueOf(valueOf14.intValue() != 0);
                    }
                    settings.backgroundCoverageMeasurement = bool14;
                    int i62 = columnIndexOrThrow45;
                    if (query.isNull(i62)) {
                        i14 = i60;
                        settings.coveragePeriodicity = null;
                    } else {
                        i14 = i60;
                        settings.coveragePeriodicity = Integer.valueOf(query.getInt(i62));
                    }
                    int i63 = columnIndexOrThrow46;
                    if (query.isNull(i63)) {
                        columnIndexOrThrow45 = i62;
                        settings.coverageForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow45 = i62;
                        settings.coverageForegroundPeriodicity = Integer.valueOf(query.getInt(i63));
                    }
                    int i64 = columnIndexOrThrow47;
                    if (query.isNull(i64)) {
                        columnIndexOrThrow46 = i63;
                        settings.foregroundCoverageTimeout = null;
                    } else {
                        columnIndexOrThrow46 = i63;
                        settings.foregroundCoverageTimeout = Integer.valueOf(query.getInt(i64));
                    }
                    int i65 = columnIndexOrThrow48;
                    if (query.isNull(i65)) {
                        columnIndexOrThrow47 = i64;
                        settings.backgroundCoverageTimeout = null;
                    } else {
                        columnIndexOrThrow47 = i64;
                        settings.backgroundCoverageTimeout = Integer.valueOf(query.getInt(i65));
                    }
                    int i66 = columnIndexOrThrow49;
                    if (query.isNull(i66)) {
                        columnIndexOrThrow48 = i65;
                        settings.foregroundCoverageSamplingInterval = null;
                    } else {
                        columnIndexOrThrow48 = i65;
                        settings.foregroundCoverageSamplingInterval = Integer.valueOf(query.getInt(i66));
                    }
                    int i67 = columnIndexOrThrow50;
                    if (query.isNull(i67)) {
                        columnIndexOrThrow49 = i66;
                        settings.backgroundCoverageSamplingInterval = null;
                    } else {
                        columnIndexOrThrow49 = i66;
                        settings.backgroundCoverageSamplingInterval = Integer.valueOf(query.getInt(i67));
                    }
                    int i68 = columnIndexOrThrow51;
                    if (query.isNull(i68)) {
                        columnIndexOrThrow50 = i67;
                        settings.reportingPeriodicity = null;
                    } else {
                        columnIndexOrThrow50 = i67;
                        settings.reportingPeriodicity = Integer.valueOf(query.getInt(i68));
                    }
                    int i69 = columnIndexOrThrow52;
                    if (query.isNull(i69)) {
                        columnIndexOrThrow51 = i68;
                        settings.gameCacheRefresh = null;
                    } else {
                        columnIndexOrThrow51 = i68;
                        settings.gameCacheRefresh = Integer.valueOf(query.getInt(i69));
                    }
                    int i70 = columnIndexOrThrow53;
                    if (query.isNull(i70)) {
                        columnIndexOrThrow52 = i69;
                        settings.gamePingsPerServer = null;
                    } else {
                        columnIndexOrThrow52 = i69;
                        settings.gamePingsPerServer = Integer.valueOf(query.getInt(i70));
                    }
                    int i71 = columnIndexOrThrow54;
                    if (query.isNull(i71)) {
                        columnIndexOrThrow53 = i70;
                        settings.gameServersCache = null;
                    } else {
                        columnIndexOrThrow53 = i70;
                        settings.gameServersCache = Integer.valueOf(query.getInt(i71));
                    }
                    int i72 = columnIndexOrThrow55;
                    if (query.isNull(i72)) {
                        columnIndexOrThrow54 = i71;
                        settings.gameTimeoutTimer = null;
                    } else {
                        columnIndexOrThrow54 = i71;
                        settings.gameTimeoutTimer = Integer.valueOf(query.getInt(i72));
                    }
                    int i73 = columnIndexOrThrow56;
                    Integer valueOf15 = query.isNull(i73) ? null : Integer.valueOf(query.getInt(i73));
                    if (valueOf15 == null) {
                        i15 = i72;
                        bool15 = null;
                    } else {
                        i15 = i72;
                        bool15 = Boolean.valueOf(valueOf15.intValue() != 0);
                    }
                    settings.gameServersCacheEnabled = bool15;
                    int i74 = columnIndexOrThrow57;
                    if (query.isNull(i74)) {
                        i16 = i73;
                        settings.backgroundGamePeriodicity = null;
                    } else {
                        i16 = i73;
                        settings.backgroundGamePeriodicity = Integer.valueOf(query.getInt(i74));
                    }
                    int i75 = columnIndexOrThrow58;
                    if (query.isNull(i75)) {
                        columnIndexOrThrow57 = i74;
                        settings.backgroundGameReportingPeriodicity = null;
                    } else {
                        columnIndexOrThrow57 = i74;
                        settings.backgroundGameReportingPeriodicity = Integer.valueOf(query.getInt(i75));
                    }
                    int i76 = columnIndexOrThrow59;
                    Integer valueOf16 = query.isNull(i76) ? null : Integer.valueOf(query.getInt(i76));
                    if (valueOf16 == null) {
                        columnIndexOrThrow59 = i76;
                        bool16 = null;
                    } else {
                        columnIndexOrThrow59 = i76;
                        bool16 = Boolean.valueOf(valueOf16.intValue() != 0);
                    }
                    settings.foregroundGameMeasurement = bool16;
                    int i77 = columnIndexOrThrow60;
                    Integer valueOf17 = query.isNull(i77) ? null : Integer.valueOf(query.getInt(i77));
                    if (valueOf17 == null) {
                        columnIndexOrThrow60 = i77;
                        bool17 = null;
                    } else {
                        columnIndexOrThrow60 = i77;
                        bool17 = Boolean.valueOf(valueOf17.intValue() != 0);
                    }
                    settings.backgroundGameMeasurement = bool17;
                    int i78 = columnIndexOrThrow61;
                    if (query.isNull(i78)) {
                        columnIndexOrThrow58 = i75;
                        settings.foregroundGamePeriodicity = null;
                    } else {
                        columnIndexOrThrow58 = i75;
                        settings.foregroundGamePeriodicity = Integer.valueOf(query.getInt(i78));
                    }
                    int i79 = columnIndexOrThrow62;
                    Integer valueOf18 = query.isNull(i79) ? null : Integer.valueOf(query.getInt(i79));
                    if (valueOf18 == null) {
                        i17 = i78;
                        bool18 = null;
                    } else {
                        i17 = i78;
                        bool18 = Boolean.valueOf(valueOf18.intValue() != 0);
                    }
                    settings.noLocationMeasurementEnabled = bool18;
                    int i80 = columnIndexOrThrow63;
                    Integer valueOf19 = query.isNull(i80) ? null : Integer.valueOf(query.getInt(i80));
                    if (valueOf19 == null) {
                        columnIndexOrThrow63 = i80;
                        bool19 = null;
                    } else {
                        columnIndexOrThrow63 = i80;
                        bool19 = Boolean.valueOf(valueOf19.intValue() != 0);
                    }
                    settings.wifiMeasurementsEnabled = bool19;
                    int i81 = columnIndexOrThrow64;
                    Integer valueOf20 = query.isNull(i81) ? null : Integer.valueOf(query.getInt(i81));
                    if (valueOf20 == null) {
                        columnIndexOrThrow64 = i81;
                        bool20 = null;
                    } else {
                        columnIndexOrThrow64 = i81;
                        bool20 = Boolean.valueOf(valueOf20.intValue() != 0);
                    }
                    settings.audioManagerEnabled = bool20;
                    int i82 = columnIndexOrThrow65;
                    Integer valueOf21 = query.isNull(i82) ? null : Integer.valueOf(query.getInt(i82));
                    if (valueOf21 == null) {
                        columnIndexOrThrow65 = i82;
                        bool21 = null;
                    } else {
                        columnIndexOrThrow65 = i82;
                        bool21 = Boolean.valueOf(valueOf21.intValue() != 0);
                    }
                    settings.cellInfoUpdateEnabled = bool21;
                    int i83 = columnIndexOrThrow66;
                    if (query.isNull(i83)) {
                        i18 = i79;
                        settings.wifiForegroundTimer = null;
                    } else {
                        i18 = i79;
                        settings.wifiForegroundTimer = Integer.valueOf(query.getInt(i83));
                    }
                    int i84 = columnIndexOrThrow67;
                    if (query.isNull(i84)) {
                        columnIndexOrThrow66 = i83;
                        settings.wifiPageLoadForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow66 = i83;
                        settings.wifiPageLoadForegroundPeriodicity = Integer.valueOf(query.getInt(i84));
                    }
                    int i85 = columnIndexOrThrow68;
                    if (query.isNull(i85)) {
                        columnIndexOrThrow67 = i84;
                        settings.wifiFileTransferForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow67 = i84;
                        settings.wifiFileTransferForegroundPeriodicity = Integer.valueOf(query.getInt(i85));
                    }
                    int i86 = columnIndexOrThrow69;
                    if (query.isNull(i86)) {
                        columnIndexOrThrow68 = i85;
                        settings.wifiCdnFileDownloadForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow68 = i85;
                        settings.wifiCdnFileDownloadForegroundPeriodicity = Integer.valueOf(query.getInt(i86));
                    }
                    int i87 = columnIndexOrThrow70;
                    if (query.isNull(i87)) {
                        columnIndexOrThrow69 = i86;
                        settings.wifiVideoForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow69 = i86;
                        settings.wifiVideoForegroundPeriodicity = Integer.valueOf(query.getInt(i87));
                    }
                    int i88 = columnIndexOrThrow71;
                    if (query.isNull(i88)) {
                        columnIndexOrThrow70 = i87;
                        settings.wifiGameForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow70 = i87;
                        settings.wifiGameForegroundPeriodicity = Integer.valueOf(query.getInt(i88));
                    }
                    int i89 = columnIndexOrThrow72;
                    if (query.isNull(i89)) {
                        columnIndexOrThrow71 = i88;
                        settings.wifiCoverageForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow71 = i88;
                        settings.wifiCoverageForegroundPeriodicity = Integer.valueOf(query.getInt(i89));
                    }
                    int i90 = columnIndexOrThrow73;
                    if (query.isNull(i90)) {
                        columnIndexOrThrow72 = i89;
                        settings.wifiDataUsageForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow72 = i89;
                        settings.wifiDataUsageForegroundPeriodicity = Integer.valueOf(query.getInt(i90));
                    }
                    int i91 = columnIndexOrThrow74;
                    if (query.isNull(i91)) {
                        columnIndexOrThrow73 = i90;
                        settings.dataUsageForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow73 = i90;
                        settings.dataUsageForegroundPeriodicity = Integer.valueOf(query.getInt(i91));
                    }
                    int i92 = columnIndexOrThrow75;
                    Integer valueOf22 = query.isNull(i92) ? null : Integer.valueOf(query.getInt(i92));
                    if (valueOf22 == null) {
                        i19 = i91;
                        bool22 = null;
                    } else {
                        i19 = i91;
                        bool22 = Boolean.valueOf(valueOf22.intValue() != 0);
                    }
                    settings.isForegroundListenerEnabled = bool22;
                    int i93 = columnIndexOrThrow76;
                    if (query.isNull(i93)) {
                        i20 = i92;
                        settings.settingsUrl = null;
                    } else {
                        i20 = i92;
                        settings.settingsUrl = query.getString(i93);
                    }
                    int i94 = columnIndexOrThrow77;
                    if (query.isNull(i94)) {
                        columnIndexOrThrow76 = i93;
                        settings.reportingUrl = null;
                    } else {
                        columnIndexOrThrow76 = i93;
                        settings.reportingUrl = query.getString(i94);
                    }
                    int i95 = columnIndexOrThrow78;
                    Integer valueOf23 = query.isNull(i95) ? null : Integer.valueOf(query.getInt(i95));
                    if (valueOf23 == null) {
                        columnIndexOrThrow78 = i95;
                        bool23 = null;
                    } else {
                        columnIndexOrThrow78 = i95;
                        bool23 = Boolean.valueOf(valueOf23.intValue() != 0);
                    }
                    settings.backgroundLocationEnabled = bool23;
                    int i96 = columnIndexOrThrow79;
                    Integer valueOf24 = query.isNull(i96) ? null : Integer.valueOf(query.getInt(i96));
                    if (valueOf24 == null) {
                        columnIndexOrThrow79 = i96;
                        bool24 = null;
                    } else {
                        columnIndexOrThrow79 = i96;
                        bool24 = Boolean.valueOf(valueOf24.intValue() != 0);
                    }
                    settings.anonymize = bool24;
                    int i97 = columnIndexOrThrow80;
                    if (query.isNull(i97)) {
                        columnIndexOrThrow77 = i94;
                        settings.sdkOrigin = null;
                    } else {
                        columnIndexOrThrow77 = i94;
                        settings.sdkOrigin = query.getString(i97);
                    }
                    int i98 = columnIndexOrThrow81;
                    if (query.isNull(i98)) {
                        columnIndexOrThrow80 = i97;
                        settings.secondaryReportingUrls = null;
                    } else {
                        columnIndexOrThrow80 = i97;
                        settings.secondaryReportingUrls = query.getString(i98);
                    }
                    int i99 = columnIndexOrThrow82;
                    if (query.isNull(i99)) {
                        columnIndexOrThrow81 = i98;
                        settings.accessTechnologyCdnFileUrls = null;
                    } else {
                        columnIndexOrThrow81 = i98;
                        settings.accessTechnologyCdnFileUrls = query.getString(i99);
                    }
                    int i100 = columnIndexOrThrow83;
                    if (query.isNull(i100)) {
                        columnIndexOrThrow82 = i99;
                        settings.accessTechnologyFileNames = null;
                    } else {
                        columnIndexOrThrow82 = i99;
                        settings.accessTechnologyFileNames = query.getString(i100);
                    }
                    int i101 = columnIndexOrThrow84;
                    Integer valueOf25 = query.isNull(i101) ? null : Integer.valueOf(query.getInt(i101));
                    if (valueOf25 == null) {
                        columnIndexOrThrow84 = i101;
                        bool25 = null;
                    } else {
                        columnIndexOrThrow84 = i101;
                        bool25 = Boolean.valueOf(valueOf25.intValue() != 0);
                    }
                    settings.independentBackgroundCoverageMeasurement = bool25;
                    int i102 = columnIndexOrThrow85;
                    Integer valueOf26 = query.isNull(i102) ? null : Integer.valueOf(query.getInt(i102));
                    if (valueOf26 == null) {
                        columnIndexOrThrow85 = i102;
                        bool26 = null;
                    } else {
                        columnIndexOrThrow85 = i102;
                        bool26 = Boolean.valueOf(valueOf26.intValue() != 0);
                    }
                    settings.deviceInfoActiveMeasurements = bool26;
                    int i103 = columnIndexOrThrow86;
                    Integer valueOf27 = query.isNull(i103) ? null : Integer.valueOf(query.getInt(i103));
                    if (valueOf27 == null) {
                        columnIndexOrThrow86 = i103;
                        bool27 = null;
                    } else {
                        columnIndexOrThrow86 = i103;
                        bool27 = Boolean.valueOf(valueOf27.intValue() != 0);
                    }
                    settings.deviceInfoBackgroundMeasurements = bool27;
                    int i104 = columnIndexOrThrow87;
                    if (query.isNull(i104)) {
                        columnIndexOrThrow83 = i100;
                        settings.deviceInfoBackgroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow83 = i100;
                        settings.deviceInfoBackgroundPeriodicity = Integer.valueOf(query.getInt(i104));
                    }
                    int i105 = columnIndexOrThrow88;
                    if (query.isNull(i105)) {
                        columnIndexOrThrow87 = i104;
                        settings.deviceInfoForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow87 = i104;
                        settings.deviceInfoForegroundPeriodicity = Integer.valueOf(query.getInt(i105));
                    }
                    int i106 = columnIndexOrThrow89;
                    Integer valueOf28 = query.isNull(i106) ? null : Integer.valueOf(query.getInt(i106));
                    if (valueOf28 == null) {
                        columnIndexOrThrow89 = i106;
                        bool28 = null;
                    } else {
                        columnIndexOrThrow89 = i106;
                        bool28 = Boolean.valueOf(valueOf28.intValue() != 0);
                    }
                    settings.tracerouteActiveMeasurements = bool28;
                    int i107 = columnIndexOrThrow90;
                    Integer valueOf29 = query.isNull(i107) ? null : Integer.valueOf(query.getInt(i107));
                    if (valueOf29 == null) {
                        columnIndexOrThrow90 = i107;
                        bool29 = null;
                    } else {
                        columnIndexOrThrow90 = i107;
                        bool29 = Boolean.valueOf(valueOf29.intValue() != 0);
                    }
                    settings.tracerouteBackgroundMeasurements = bool29;
                    int i108 = columnIndexOrThrow91;
                    if (query.isNull(i108)) {
                        columnIndexOrThrow88 = i105;
                        settings.tracerouteBackgroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow88 = i105;
                        settings.tracerouteBackgroundPeriodicity = Integer.valueOf(query.getInt(i108));
                    }
                    int i109 = columnIndexOrThrow92;
                    if (query.isNull(i109)) {
                        columnIndexOrThrow91 = i108;
                        settings.tracerouteForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow91 = i108;
                        settings.tracerouteForegroundPeriodicity = Integer.valueOf(query.getInt(i109));
                    }
                    int i110 = columnIndexOrThrow93;
                    if (query.isNull(i110)) {
                        columnIndexOrThrow92 = i109;
                        settings.tracerouteNumberOfHops = null;
                    } else {
                        columnIndexOrThrow92 = i109;
                        settings.tracerouteNumberOfHops = Integer.valueOf(query.getInt(i110));
                    }
                    int i111 = columnIndexOrThrow94;
                    if (query.isNull(i111)) {
                        columnIndexOrThrow93 = i110;
                        settings.traceroutePacketSize = null;
                    } else {
                        columnIndexOrThrow93 = i110;
                        settings.traceroutePacketSize = Integer.valueOf(query.getInt(i111));
                    }
                    int i112 = columnIndexOrThrow95;
                    if (query.isNull(i112)) {
                        columnIndexOrThrow94 = i111;
                        settings.tracerouteUrl = null;
                    } else {
                        columnIndexOrThrow94 = i111;
                        settings.tracerouteUrl = query.getString(i112);
                    }
                    int i113 = columnIndexOrThrow96;
                    Integer valueOf30 = query.isNull(i113) ? null : Integer.valueOf(query.getInt(i113));
                    if (valueOf30 == null) {
                        i21 = i112;
                        bool30 = null;
                    } else {
                        i21 = i112;
                        bool30 = Boolean.valueOf(valueOf30.intValue() != 0);
                    }
                    settings.voiceCallMeasurements = bool30;
                    int i114 = columnIndexOrThrow97;
                    if (query.isNull(i114)) {
                        i22 = i113;
                        settings.wifiTracerouteForegroundPeriodicity = null;
                    } else {
                        i22 = i113;
                        settings.wifiTracerouteForegroundPeriodicity = Integer.valueOf(query.getInt(i114));
                    }
                    int i115 = columnIndexOrThrow98;
                    Integer valueOf31 = query.isNull(i115) ? null : Integer.valueOf(query.getInt(i115));
                    if (valueOf31 == null) {
                        i23 = i114;
                        bool31 = null;
                    } else {
                        i23 = i114;
                        bool31 = Boolean.valueOf(valueOf31.intValue() != 0);
                    }
                    settings.loadedLatencyEnabled = bool31;
                    int i116 = columnIndexOrThrow99;
                    Integer valueOf32 = query.isNull(i116) ? null : Integer.valueOf(query.getInt(i116));
                    if (valueOf32 == null) {
                        columnIndexOrThrow99 = i116;
                        bool32 = null;
                    } else {
                        columnIndexOrThrow99 = i116;
                        bool32 = Boolean.valueOf(valueOf32.intValue() != 0);
                    }
                    settings.wifiLoadedLatencyEnabled = bool32;
                    int i117 = columnIndexOrThrow100;
                    if (query.isNull(i117)) {
                        i24 = i115;
                        settings.foregroundLoadedLatencyPeriodicity = null;
                    } else {
                        i24 = i115;
                        settings.foregroundLoadedLatencyPeriodicity = Integer.valueOf(query.getInt(i117));
                    }
                    int i118 = columnIndexOrThrow101;
                    if (query.isNull(i118)) {
                        columnIndexOrThrow100 = i117;
                        settings.foregroundLoadedLatencyPeriodicityWifi = null;
                    } else {
                        columnIndexOrThrow100 = i117;
                        settings.foregroundLoadedLatencyPeriodicityWifi = Integer.valueOf(query.getInt(i118));
                    }
                    int i119 = columnIndexOrThrow102;
                    if (query.isNull(i119)) {
                        columnIndexOrThrow101 = i118;
                        settings.loadedLatencyMeasurementsPerServer = null;
                    } else {
                        columnIndexOrThrow101 = i118;
                        settings.loadedLatencyMeasurementsPerServer = Integer.valueOf(query.getInt(i119));
                    }
                    int i120 = columnIndexOrThrow103;
                    if (query.isNull(i120)) {
                        columnIndexOrThrow102 = i119;
                        settings.loadedLatencyServersCache = null;
                    } else {
                        columnIndexOrThrow102 = i119;
                        settings.loadedLatencyServersCache = Integer.valueOf(query.getInt(i120));
                    }
                    int i121 = columnIndexOrThrow104;
                    if (query.isNull(i121)) {
                        columnIndexOrThrow103 = i120;
                        settings.loadedLatencyTimeoutTimer = null;
                    } else {
                        columnIndexOrThrow103 = i120;
                        settings.loadedLatencyTimeoutTimer = Integer.valueOf(query.getInt(i121));
                    }
                    int i122 = columnIndexOrThrow105;
                    if (query.isNull(i122)) {
                        columnIndexOrThrow104 = i121;
                        settings.loadedLatencyCacheRefresh = null;
                    } else {
                        columnIndexOrThrow104 = i121;
                        settings.loadedLatencyCacheRefresh = Integer.valueOf(query.getInt(i122));
                    }
                    int i123 = columnIndexOrThrow106;
                    Integer valueOf33 = query.isNull(i123) ? null : Integer.valueOf(query.getInt(i123));
                    if (valueOf33 == null) {
                        columnIndexOrThrow106 = i123;
                        bool33 = null;
                    } else {
                        columnIndexOrThrow106 = i123;
                        bool33 = Boolean.valueOf(valueOf33.intValue() != 0);
                    }
                    settings.loadedLatencyServersCacheEnabled = bool33;
                    int i124 = columnIndexOrThrow107;
                    Integer valueOf34 = query.isNull(i124) ? null : Integer.valueOf(query.getInt(i124));
                    if (valueOf34 == null) {
                        columnIndexOrThrow107 = i124;
                        bool34 = null;
                    } else {
                        columnIndexOrThrow107 = i124;
                        bool34 = Boolean.valueOf(valueOf34.intValue() != 0);
                    }
                    settings.randomCdnFileMeasurements = bool34;
                    int i125 = columnIndexOrThrow108;
                    Integer valueOf35 = query.isNull(i125) ? null : Integer.valueOf(query.getInt(i125));
                    if (valueOf35 == null) {
                        columnIndexOrThrow108 = i125;
                        bool35 = null;
                    } else {
                        columnIndexOrThrow108 = i125;
                        bool35 = Boolean.valueOf(valueOf35.intValue() != 0);
                    }
                    settings.randomCdnBackgroundMeasurement = bool35;
                    int i126 = columnIndexOrThrow109;
                    if (query.isNull(i126)) {
                        columnIndexOrThrow105 = i122;
                        settings.randomCdnFileDownloadForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow105 = i122;
                        settings.randomCdnFileDownloadForegroundPeriodicity = Integer.valueOf(query.getInt(i126));
                    }
                    int i127 = columnIndexOrThrow110;
                    if (query.isNull(i127)) {
                        columnIndexOrThrow109 = i126;
                        settings.randomCdnFileDownloadPeriodicity = null;
                    } else {
                        columnIndexOrThrow109 = i126;
                        settings.randomCdnFileDownloadPeriodicity = Integer.valueOf(query.getInt(i127));
                    }
                    int i128 = columnIndexOrThrow111;
                    if (query.isNull(i128)) {
                        columnIndexOrThrow110 = i127;
                        settings.wifiRandomCdnFileDownloadForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow110 = i127;
                        settings.wifiRandomCdnFileDownloadForegroundPeriodicity = Integer.valueOf(query.getInt(i128));
                    }
                    int i129 = columnIndexOrThrow112;
                    if (query.isNull(i129)) {
                        columnIndexOrThrow111 = i128;
                        settings.randomCdnFileDownloadTimeout = null;
                    } else {
                        columnIndexOrThrow111 = i128;
                        settings.randomCdnFileDownloadTimeout = Integer.valueOf(query.getInt(i129));
                    }
                    int i130 = columnIndexOrThrow113;
                    if (query.isNull(i130)) {
                        columnIndexOrThrow112 = i129;
                        settings.randomCdnFileUrls = null;
                    } else {
                        columnIndexOrThrow112 = i129;
                        settings.randomCdnFileUrls = query.getString(i130);
                    }
                    int i131 = columnIndexOrThrow114;
                    if (query.isNull(i131)) {
                        columnIndexOrThrow113 = i130;
                        settings.randomCdnServerCount = null;
                    } else {
                        columnIndexOrThrow113 = i130;
                        settings.randomCdnServerCount = Integer.valueOf(query.getInt(i131));
                    }
                    int i132 = columnIndexOrThrow115;
                    Integer valueOf36 = query.isNull(i132) ? null : Integer.valueOf(query.getInt(i132));
                    if (valueOf36 == null) {
                        columnIndexOrThrow115 = i132;
                        bool36 = null;
                    } else {
                        columnIndexOrThrow115 = i132;
                        bool36 = Boolean.valueOf(valueOf36.intValue() != 0);
                    }
                    settings.trafficProfileMeasurementsEnabled = bool36;
                    int i133 = columnIndexOrThrow116;
                    Integer valueOf37 = query.isNull(i133) ? null : Integer.valueOf(query.getInt(i133));
                    if (valueOf37 == null) {
                        columnIndexOrThrow116 = i133;
                        bool37 = null;
                    } else {
                        columnIndexOrThrow116 = i133;
                        bool37 = Boolean.valueOf(valueOf37.intValue() != 0);
                    }
                    settings.trafficProfileBackgroundMeasurementsEnabled = bool37;
                    int i134 = columnIndexOrThrow117;
                    if (query.isNull(i134)) {
                        columnIndexOrThrow114 = i131;
                        settings.trafficProfileForegroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow114 = i131;
                        settings.trafficProfileForegroundPeriodicity = Integer.valueOf(query.getInt(i134));
                    }
                    int i135 = columnIndexOrThrow118;
                    if (query.isNull(i135)) {
                        columnIndexOrThrow117 = i134;
                        settings.trafficProfileBackgroundPeriodicity = null;
                    } else {
                        columnIndexOrThrow117 = i134;
                        settings.trafficProfileBackgroundPeriodicity = Integer.valueOf(query.getInt(i135));
                    }
                    int i136 = columnIndexOrThrow119;
                    if (query.isNull(i136)) {
                        columnIndexOrThrow118 = i135;
                        settings.trafficProfileWiFiPeriodicity = null;
                    } else {
                        columnIndexOrThrow118 = i135;
                        settings.trafficProfileWiFiPeriodicity = Integer.valueOf(query.getInt(i136));
                    }
                    int i137 = columnIndexOrThrow120;
                    if (query.isNull(i137)) {
                        columnIndexOrThrow119 = i136;
                        settings.trafficProfileTimeout = null;
                    } else {
                        columnIndexOrThrow119 = i136;
                        settings.trafficProfileTimeout = Integer.valueOf(query.getInt(i137));
                    }
                    int i138 = columnIndexOrThrow121;
                    if (query.isNull(i138)) {
                        columnIndexOrThrow120 = i137;
                        settings.trafficProfileMeasurementLimit = null;
                    } else {
                        columnIndexOrThrow120 = i137;
                        settings.trafficProfileMeasurementLimit = Integer.valueOf(query.getInt(i138));
                    }
                    int i139 = columnIndexOrThrow122;
                    if (query.isNull(i139)) {
                        columnIndexOrThrow121 = i138;
                        settings.trafficProfileServerUrls = null;
                    } else {
                        columnIndexOrThrow121 = i138;
                        settings.trafficProfileServerUrls = query.getString(i139);
                    }
                    int i140 = columnIndexOrThrow123;
                    if (query.isNull(i140)) {
                        columnIndexOrThrow123 = i140;
                        columnIndexOrThrow122 = i139;
                        i25 = i30;
                        string = null;
                    } else {
                        columnIndexOrThrow123 = i140;
                        i25 = i30;
                        string = query.getString(i140);
                        columnIndexOrThrow122 = i139;
                    }
                    settings.trafficProfiles = this.c.a(string);
                    int i141 = columnIndexOrThrow124;
                    Integer valueOf38 = query.isNull(i141) ? null : Integer.valueOf(query.getInt(i141));
                    if (valueOf38 == null) {
                        bool38 = null;
                    } else {
                        bool38 = Boolean.valueOf(valueOf38.intValue() != 0);
                    }
                    settings.timeToInteractionMeasurementsEnabled = bool38;
                    int i142 = columnIndexOrThrow125;
                    Integer valueOf39 = query.isNull(i142) ? null : Integer.valueOf(query.getInt(i142));
                    if (valueOf39 == null) {
                        i26 = i141;
                        bool39 = null;
                    } else {
                        i26 = i141;
                        bool39 = Boolean.valueOf(valueOf39.intValue() != 0);
                    }
                    settings.timeToInteractionBackgroundMeasurementsEnabled = bool39;
                    int i143 = columnIndexOrThrow126;
                    if (query.isNull(i143)) {
                        settings.timeToInteractionForegroundPeriodicity = null;
                    } else {
                        settings.timeToInteractionForegroundPeriodicity = Integer.valueOf(query.getInt(i143));
                    }
                    int i144 = columnIndexOrThrow127;
                    columnIndexOrThrow126 = i143;
                    if (query.isNull(i144)) {
                        settings.timeToInteractionBackgroundPeriodicity = null;
                    } else {
                        settings.timeToInteractionBackgroundPeriodicity = Integer.valueOf(query.getInt(i144));
                    }
                    int i145 = columnIndexOrThrow128;
                    columnIndexOrThrow127 = i144;
                    if (query.isNull(i145)) {
                        settings.timeToInteractionWiFiPeriodicity = null;
                    } else {
                        settings.timeToInteractionWiFiPeriodicity = Integer.valueOf(query.getInt(i145));
                    }
                    int i146 = columnIndexOrThrow129;
                    columnIndexOrThrow128 = i145;
                    if (query.isNull(i146)) {
                        settings.timeToInteractionTimeout = null;
                    } else {
                        settings.timeToInteractionTimeout = Integer.valueOf(query.getInt(i146));
                    }
                    int i147 = columnIndexOrThrow130;
                    columnIndexOrThrow129 = i146;
                    if (query.isNull(i147)) {
                        settings.timeToInteractionDownloadFileSize = null;
                    } else {
                        settings.timeToInteractionDownloadFileSize = Integer.valueOf(query.getInt(i147));
                    }
                    int i148 = columnIndexOrThrow131;
                    columnIndexOrThrow130 = i147;
                    if (query.isNull(i148)) {
                        settings.timeToInteractionUploadFileSize = null;
                    } else {
                        settings.timeToInteractionUploadFileSize = Integer.valueOf(query.getInt(i148));
                    }
                    int i149 = columnIndexOrThrow132;
                    columnIndexOrThrow131 = i148;
                    if (query.isNull(i149)) {
                        settings.timeToInteractionServerListLimit = null;
                    } else {
                        settings.timeToInteractionServerListLimit = Integer.valueOf(query.getInt(i149));
                    }
                    int i150 = columnIndexOrThrow133;
                    columnIndexOrThrow132 = i149;
                    if (query.isNull(i150)) {
                        settings.timeToInteractionServerSelectionTimeout = null;
                    } else {
                        settings.timeToInteractionServerSelectionTimeout = Integer.valueOf(query.getInt(i150));
                    }
                    int i151 = columnIndexOrThrow134;
                    columnIndexOrThrow133 = i150;
                    if (query.isNull(i151)) {
                        settings.timeToInteractionPingTimeout = null;
                    } else {
                        settings.timeToInteractionPingTimeout = Integer.valueOf(query.getInt(i151));
                    }
                    int i152 = columnIndexOrThrow135;
                    columnIndexOrThrow134 = i151;
                    if (query.isNull(i152)) {
                        settings.timeToInteractionPingsPerServer = null;
                    } else {
                        settings.timeToInteractionPingsPerServer = Integer.valueOf(query.getInt(i152));
                    }
                    int i153 = columnIndexOrThrow136;
                    columnIndexOrThrow135 = i152;
                    if (query.isNull(i153)) {
                        settings.timeToInteractionUploadStatsInterval = null;
                    } else {
                        settings.timeToInteractionUploadStatsInterval = Integer.valueOf(query.getInt(i153));
                    }
                    int i154 = columnIndexOrThrow137;
                    columnIndexOrThrow136 = i153;
                    if (query.isNull(i154)) {
                        settings.timeToInteractionUploadStatsTimeout = null;
                    } else {
                        settings.timeToInteractionUploadStatsTimeout = Integer.valueOf(query.getInt(i154));
                    }
                    int i155 = columnIndexOrThrow138;
                    Integer valueOf40 = query.isNull(i155) ? null : Integer.valueOf(query.getInt(i155));
                    if (valueOf40 == null) {
                        columnIndexOrThrow138 = i155;
                        bool40 = null;
                    } else {
                        columnIndexOrThrow138 = i155;
                        bool40 = Boolean.valueOf(valueOf40.intValue() != 0);
                    }
                    settings.isMeasurementsAutoStartEnabled = bool40;
                    int i156 = columnIndexOrThrow139;
                    columnIndexOrThrow137 = i154;
                    if (query.isNull(i156)) {
                        settings.measurementsAutoStartDelay = null;
                    } else {
                        settings.measurementsAutoStartDelay = Integer.valueOf(query.getInt(i156));
                    }
                    int i157 = columnIndexOrThrow140;
                    Integer valueOf41 = query.isNull(i157) ? null : Integer.valueOf(query.getInt(i157));
                    if (valueOf41 == null) {
                        columnIndexOrThrow139 = i156;
                        bool41 = null;
                    } else {
                        columnIndexOrThrow139 = i156;
                        bool41 = Boolean.valueOf(valueOf41.intValue() != 0);
                    }
                    settings.isServerFallbackEnabled = bool41;
                    int i158 = columnIndexOrThrow141;
                    columnIndexOrThrow140 = i157;
                    if (query.isNull(i158)) {
                        settings.serverFallbackCount = null;
                    } else {
                        settings.serverFallbackCount = Integer.valueOf(query.getInt(i158));
                    }
                    int i159 = columnIndexOrThrow142;
                    columnIndexOrThrow141 = i158;
                    if (query.isNull(i159)) {
                        settings.connectionTestVideoUrl = null;
                    } else {
                        settings.connectionTestVideoUrl = query.getString(i159);
                    }
                    int i160 = columnIndexOrThrow143;
                    columnIndexOrThrow142 = i159;
                    if (query.isNull(i160)) {
                        settings.connectionTestVideoTimeout = null;
                    } else {
                        settings.connectionTestVideoTimeout = Integer.valueOf(query.getInt(i160));
                    }
                    int i161 = columnIndexOrThrow144;
                    columnIndexOrThrow143 = i160;
                    if (query.isNull(i161)) {
                        settings.connectionTestVideoScore = null;
                    } else {
                        settings.connectionTestVideoScore = Integer.valueOf(query.getInt(i161));
                    }
                    int i162 = columnIndexOrThrow145;
                    columnIndexOrThrow144 = i161;
                    if (query.isNull(i162)) {
                        settings.connectionTestPageLoadUrl = null;
                    } else {
                        settings.connectionTestPageLoadUrl = query.getString(i162);
                    }
                    int i163 = columnIndexOrThrow146;
                    columnIndexOrThrow145 = i162;
                    if (query.isNull(i163)) {
                        settings.connectionTestPageLoadTimeout = null;
                    } else {
                        settings.connectionTestPageLoadTimeout = Integer.valueOf(query.getInt(i163));
                    }
                    int i164 = columnIndexOrThrow147;
                    columnIndexOrThrow146 = i163;
                    if (query.isNull(i164)) {
                        settings.connectionTestPageLoadScore = null;
                    } else {
                        settings.connectionTestPageLoadScore = Integer.valueOf(query.getInt(i164));
                    }
                    int i165 = columnIndexOrThrow148;
                    columnIndexOrThrow147 = i164;
                    if (query.isNull(i165)) {
                        settings.trafficProfilesJson = null;
                    } else {
                        settings.trafficProfilesJson = query.getString(i165);
                    }
                    arrayList.add(settings);
                    columnIndexOrThrow148 = i165;
                    columnIndexOrThrow12 = i3;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow124 = i26;
                    columnIndexOrThrow11 = i2;
                    columnIndexOrThrow16 = i6;
                    i27 = i25;
                    columnIndexOrThrow125 = i142;
                    columnIndexOrThrow = i;
                    int i166 = i7;
                    columnIndexOrThrow24 = i8;
                    columnIndexOrThrow23 = i166;
                    int i167 = i9;
                    columnIndexOrThrow31 = i10;
                    columnIndexOrThrow30 = i167;
                    int i168 = i11;
                    columnIndexOrThrow38 = i12;
                    columnIndexOrThrow37 = i168;
                    int i169 = i13;
                    columnIndexOrThrow43 = i14;
                    columnIndexOrThrow42 = i169;
                    int i170 = i15;
                    columnIndexOrThrow56 = i16;
                    columnIndexOrThrow55 = i170;
                    int i171 = i17;
                    columnIndexOrThrow62 = i18;
                    columnIndexOrThrow61 = i171;
                    int i172 = i19;
                    columnIndexOrThrow75 = i20;
                    columnIndexOrThrow74 = i172;
                    int i173 = i21;
                    columnIndexOrThrow96 = i22;
                    columnIndexOrThrow95 = i173;
                    int i174 = i23;
                    columnIndexOrThrow98 = i24;
                    columnIndexOrThrow97 = i174;
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
