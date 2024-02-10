package com.cellrebel.sdk.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.cellrebel.sdk.database.dao.CellInfoDAO;
import com.cellrebel.sdk.database.dao.CellInfoDAO_Impl;
import com.cellrebel.sdk.database.dao.ConnectionMetricDAO;
import com.cellrebel.sdk.database.dao.ConnectionMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.ConnectionTimeActiveDAO;
import com.cellrebel.sdk.database.dao.ConnectionTimeActiveDAO_Impl;
import com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO;
import com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO_Impl;
import com.cellrebel.sdk.database.dao.CoverageMetricDAO;
import com.cellrebel.sdk.database.dao.CoverageMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.DataUsageMetricDAO;
import com.cellrebel.sdk.database.dao.DataUsageMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.DeviceInfoDAO;
import com.cellrebel.sdk.database.dao.DeviceInfoDAO_Impl;
import com.cellrebel.sdk.database.dao.FileTransferDAO;
import com.cellrebel.sdk.database.dao.FileTransferDAO_Impl;
import com.cellrebel.sdk.database.dao.FileTransferMetricDAO;
import com.cellrebel.sdk.database.dao.FileTransferMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.GameLatencyDAO;
import com.cellrebel.sdk.database.dao.GameLatencyDAO_Impl;
import com.cellrebel.sdk.database.dao.GameListDAO;
import com.cellrebel.sdk.database.dao.GameListDAO_Impl;
import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.database.dao.GameMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.PageLoadScoreDAO;
import com.cellrebel.sdk.database.dao.PageLoadScoreDAO_Impl;
import com.cellrebel.sdk.database.dao.PageLoadedMetricDAO;
import com.cellrebel.sdk.database.dao.PageLoadedMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.PreferencesDAO;
import com.cellrebel.sdk.database.dao.PreferencesDAO_Impl;
import com.cellrebel.sdk.database.dao.SettingsDAO;
import com.cellrebel.sdk.database.dao.SettingsDAO_Impl;
import com.cellrebel.sdk.database.dao.TimestampsDAO;
import com.cellrebel.sdk.database.dao.TimestampsDAO_Impl;
import com.cellrebel.sdk.database.dao.TraceRouteDAO;
import com.cellrebel.sdk.database.dao.TraceRouteDAO_Impl;
import com.cellrebel.sdk.database.dao.TrafficProfileDAO;
import com.cellrebel.sdk.database.dao.TrafficProfileDAO_Impl;
import com.cellrebel.sdk.database.dao.TtiDAO;
import com.cellrebel.sdk.database.dao.TtiDAO_Impl;
import com.cellrebel.sdk.database.dao.VideoLoadScoreDAO;
import com.cellrebel.sdk.database.dao.VideoLoadScoreDAO_Impl;
import com.cellrebel.sdk.database.dao.VideoMetricDAO;
import com.cellrebel.sdk.database.dao.VideoMetricDAO_Impl;
import com.cellrebel.sdk.database.dao.VoiceCallDAO;
import com.cellrebel.sdk.database.dao.VoiceCallDAO_Impl;
import com.cellrebel.sdk.database.dao.WifiInfoMetricDAO;
import com.cellrebel.sdk.database.dao.WifiInfoMetricDAO_Impl;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SDKRoomDatabase_Impl extends SDKRoomDatabase {
    private volatile VoiceCallDAO A;
    private volatile TraceRouteDAO B;
    private volatile VideoMetricDAO e;
    private volatile VideoLoadScoreDAO f;
    private volatile TtiDAO g;
    private volatile TrafficProfileDAO h;
    private volatile PreferencesDAO i;
    private volatile SettingsDAO j;
    private volatile TimestampsDAO k;
    private volatile PageLoadScoreDAO l;
    private volatile PageLoadedMetricDAO m;
    private volatile GameListDAO n;
    private volatile GameMetricDAO o;
    private volatile CellInfoDAO p;
    private volatile CoverageMetricDAO q;
    private volatile WifiInfoMetricDAO r;
    private volatile ConnectionMetricDAO s;
    private volatile FileTransferDAO t;
    private volatile FileTransferMetricDAO u;
    private volatile DataUsageMetricDAO v;
    private volatile ConnectionTimeActiveDAO w;
    private volatile ConnectionTimePassiveDAO x;
    private volatile GameLatencyDAO y;
    private volatile DeviceInfoDAO z;

    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        private RoomOpenHelper.ValidationResult a(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
            HashMap hashMap = new HashMap(5);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap.put("name", new TableInfo.Column("name", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap.put("isHidden", new TableInfo.Column("isHidden", "INTEGER", false, 0, (String) null, 1));
            hashMap.put(MediaTrack.ROLE_SUBTITLE, new TableInfo.Column(MediaTrack.ROLE_SUBTITLE, AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap.put("servers", new TableInfo.Column("servers", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("Game", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase2, "Game");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "Game(com.cellrebel.sdk.networking.beans.response.Game).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(111);
            hashMap2.put("serverName", new TableInfo.Column("serverName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("gameName", new TableInfo.Column("gameName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("serverUrl", new TableInfo.Column("serverUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("latency", new TableInfo.Column("latency", "REAL", false, 0, (String) null, 1));
            hashMap2.put("pingsCount", new TableInfo.Column("pingsCount", "REAL", false, 0, (String) null, 1));
            hashMap2.put("failedMeasurementsCount", new TableInfo.Column("failedMeasurementsCount", "REAL", false, 0, (String) null, 1));
            hashMap2.put("jitter", new TableInfo.Column("jitter", "REAL", false, 0, (String) null, 1));
            hashMap2.put("isSent", new TableInfo.Column("isSent", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("isOffline", new TableInfo.Column("isOffline", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("isUnderAdditionalLoad", new TableInfo.Column("isUnderAdditionalLoad", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("isCached", new TableInfo.Column("isCached", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("loadedLatencyTestFileTransferUrl", new TableInfo.Column("loadedLatencyTestFileTransferUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("fileTransferId", new TableInfo.Column("fileTransferId", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap2.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("secondarySimMCC", new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("secondarySimMNC", new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj = "stateDuringMeasurement";
            hashMap2.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj2 = "networkMNC";
            hashMap2.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            Object obj3 = "latitude";
            hashMap2.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            Object obj4 = "longitude";
            hashMap2.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            Object obj5 = "gpsAccuracy";
            hashMap2.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj6 = "cellId";
            hashMap2.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj7 = "deviceBrand";
            hashMap2.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj8 = "deviceModel";
            hashMap2.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj9 = "deviceVersion";
            hashMap2.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap2.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap2.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap2.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap2.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap2.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj10 = "networkMCC";
            Object obj11 = "dataSimSlotNumber";
            TableInfo tableInfo2 = new TableInfo("GameInfoMetric", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "GameInfoMetric");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "GameInfoMetric(com.cellrebel.sdk.networking.beans.request.GameInfoMetric).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(94);
            hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap3.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("isRegistered", new TableInfo.Column("isRegistered", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("secondarySimMCC", new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("secondarySimMNC", new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            Object obj12 = obj11;
            hashMap3.put(obj12, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            Object obj13 = obj10;
            hashMap3.put(obj13, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj14 = obj3;
            hashMap3.put(obj14, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            Object obj15 = obj13;
            Object obj16 = obj4;
            hashMap3.put(obj16, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            Object obj17 = obj12;
            hashMap3.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap3.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("cellConnectionStatus", new TableInfo.Column("cellConnectionStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put(IronSourceSegment.AGE, new TableInfo.Column(IronSourceSegment.AGE, "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("bandwidth", new TableInfo.Column("bandwidth", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("arfc", new TableInfo.Column("arfc", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("connectionArfc", new TableInfo.Column("connectionArfc", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("pci", new TableInfo.Column("pci", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("lac", new TableInfo.Column("lac", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("asuLevel", new TableInfo.Column("asuLevel", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("cqi", new TableInfo.Column("cqi", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("level", new TableInfo.Column("level", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("rsrp", new TableInfo.Column("rsrp", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("rsrq", new TableInfo.Column("rsrq", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("rssi", new TableInfo.Column("rssi", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("rssnr", new TableInfo.Column("rssnr", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("csiRsrp", new TableInfo.Column("csiRsrp", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("csiSinr", new TableInfo.Column("csiSinr", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("csiRsrq", new TableInfo.Column("csiRsrq", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("ssRsrp", new TableInfo.Column("ssRsrp", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("ssRsrq", new TableInfo.Column("ssRsrq", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("ssSinr", new TableInfo.Column("ssSinr", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap3.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap3.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap3.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("wcdmaEcNo", new TableInfo.Column("wcdmaEcNo", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj18 = obj;
            hashMap3.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            Object obj19 = "numberOfSimSlots";
            hashMap3.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap3.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj20 = "secondarySimMNC";
            Object obj21 = "secondarySimMCC";
            TableInfo tableInfo3 = new TableInfo("CellInfoMetric", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "CellInfoMetric");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "CellInfoMetric(com.cellrebel.sdk.networking.beans.request.CellInfoMetric).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(7);
            hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap4.put(CampaignEx.JSON_KEY_TIMESTAMP, new TableInfo.Column(CampaignEx.JSON_KEY_TIMESTAMP, "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("gameName", new TableInfo.Column("gameName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("serverName", new TableInfo.Column("serverName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("latency", new TableInfo.Column("latency", "REAL", false, 0, (String) null, 1));
            hashMap4.put(obj14, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap4.put(obj16, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            TableInfo tableInfo4 = new TableInfo("GameLatency", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "GameLatency");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "GameLatency(com.cellrebel.sdk.database.GameLatency).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(121);
            hashMap5.put("lteFrequencySupport", new TableInfo.Column("lteFrequencySupport", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("nrFrequencySupport", new TableInfo.Column("nrFrequencySupport", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("ueCategory", new TableInfo.Column("ueCategory", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("is4gCapable", new TableInfo.Column("is4gCapable", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("is5gCapable", new TableInfo.Column("is5gCapable", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("volteSupport", new TableInfo.Column("volteSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("deviceYear", new TableInfo.Column("deviceYear", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("maximumStorage", new TableInfo.Column("maximumStorage", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("freeStorage", new TableInfo.Column("freeStorage", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("ram", new TableInfo.Column("ram", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("freeRam", new TableInfo.Column("freeRam", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("cpuUsage", new TableInfo.Column("cpuUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("batteryLevel", new TableInfo.Column("batteryLevel", "REAL", false, 0, (String) null, 1));
            hashMap5.put("batteryState", new TableInfo.Column("batteryState", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("batteryChargeType", new TableInfo.Column("batteryChargeType", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("batteryHealth", new TableInfo.Column("batteryHealth", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("batteryTemperature", new TableInfo.Column("batteryTemperature", "REAL", false, 0, (String) null, 1));
            hashMap5.put("language", new TableInfo.Column("language", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("locale", new TableInfo.Column("locale", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("userAgent", new TableInfo.Column("userAgent", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("screenWidth", new TableInfo.Column("screenWidth", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("screenHeight", new TableInfo.Column("screenHeight", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("elapsedRealtimeNanos", new TableInfo.Column("elapsedRealtimeNanos", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap5.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj22 = obj21;
            hashMap5.put(obj22, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj23 = obj20;
            hashMap5.put(obj23, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj19, new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            Object obj24 = obj17;
            hashMap5.put(obj24, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            Object obj25 = obj24;
            hashMap5.put(obj15, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj14, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap5.put(obj16, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            Object obj26 = obj16;
            hashMap5.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap5.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap5.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap5.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap5.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap5.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap5.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap5.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj27 = obj14;
            TableInfo tableInfo5 = new TableInfo("DeviceInfoMetric", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "DeviceInfoMetric");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "DeviceInfoMetric(com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(100);
            hashMap6.put("callStartTime", new TableInfo.Column("callStartTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("callEndTime", new TableInfo.Column("callEndTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap6.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj22, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj23, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj19, new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            Object obj28 = obj25;
            hashMap6.put(obj28, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            Object obj29 = obj15;
            hashMap6.put(obj29, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj30 = obj29;
            hashMap6.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj27, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put(obj26, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap6.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap6.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap6.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap6.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj31 = obj28;
            TableInfo tableInfo6 = new TableInfo("VoiceCallMetric", hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "VoiceCallMetric");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "VoiceCallMetric(com.cellrebel.sdk.networking.beans.request.VoiceCallMetric).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(102);
            hashMap7.put("traceroute", new TableInfo.Column("traceroute", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("serverUrl", new TableInfo.Column("serverUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("numberOfHops", new TableInfo.Column("numberOfHops", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("packetSize", new TableInfo.Column("packetSize", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap7.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj22, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj23, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj19, new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            Object obj32 = obj31;
            hashMap7.put(obj32, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            Object obj33 = obj30;
            hashMap7.put(obj33, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj34 = obj33;
            hashMap7.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj27, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put(obj26, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap7.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap7.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap7.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap7.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj35 = obj32;
            TableInfo tableInfo7 = new TableInfo("TraceRouteMetric", hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, "TraceRouteMetric");
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "TraceRouteMetric(com.cellrebel.sdk.networking.beans.request.TraceRouteMetric).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            HashMap hashMap8 = new HashMap(113);
            hashMap8.put("serverId", new TableInfo.Column("serverId", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("serverPort", new TableInfo.Column("serverPort", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("serverVersion", new TableInfo.Column("serverVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("serverBuild", new TableInfo.Column("serverBuild", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("latency", new TableInfo.Column("latency", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("downloadTime", new TableInfo.Column("downloadTime", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("downloadTimeToFirstByte", new TableInfo.Column("downloadTimeToFirstByte", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("bytesDownloaded", new TableInfo.Column("bytesDownloaded", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("uploadTime", new TableInfo.Column("uploadTime", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("uploadTimeToFirstByte", new TableInfo.Column("uploadTimeToFirstByte", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("bytesUploaded", new TableInfo.Column("bytesUploaded", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("errorTypes", new TableInfo.Column("errorTypes", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("accessTechStart", new TableInfo.Column("accessTechStart", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("accessTechEnd", new TableInfo.Column("accessTechEnd", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("accessTechNumChanges", new TableInfo.Column("accessTechNumChanges", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap8.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj22, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj23, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj19, new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            Object obj36 = obj35;
            hashMap8.put(obj36, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            Object obj37 = obj34;
            hashMap8.put(obj37, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj38 = obj37;
            hashMap8.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj27, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put(obj26, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap8.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap8.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap8.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap8.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj39 = obj36;
            TableInfo tableInfo8 = new TableInfo("TimeToInteractionMetric", hashMap8, new HashSet(0), new HashSet(0));
            TableInfo read8 = TableInfo.read(supportSQLiteDatabase2, "TimeToInteractionMetric");
            if (!tableInfo8.equals(read8)) {
                return new RoomOpenHelper.ValidationResult(false, "TimeToInteractionMetric(com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
            HashMap hashMap9 = new HashMap(122);
            hashMap9.put("profileName", new TableInfo.Column("profileName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(Scopes.PROFILE, new TableInfo.Column(Scopes.PROFILE, AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("profileType", new TableInfo.Column("profileType", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("meanLatency", new TableInfo.Column("meanLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("medianLatency", new TableInfo.Column("medianLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("minimumLatency", new TableInfo.Column("minimumLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("maximumLatency", new TableInfo.Column("maximumLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("p10Latency", new TableInfo.Column("p10Latency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("p90Latency", new TableInfo.Column("p90Latency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("iqmLatency", new TableInfo.Column("iqmLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("meanJitter", new TableInfo.Column("meanJitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("medianJitter", new TableInfo.Column("medianJitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("minimumJitter", new TableInfo.Column("minimumJitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("maximumJitter", new TableInfo.Column("maximumJitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("p10Jitter", new TableInfo.Column("p10Jitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("p90Jitter", new TableInfo.Column("p90Jitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("iqmJitter", new TableInfo.Column("iqmJitter", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("packetLoss", new TableInfo.Column("packetLoss", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("outOfOrderPackets", new TableInfo.Column("outOfOrderPackets", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("packetCount", new TableInfo.Column("packetCount", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("numberOfOutOfOrderPackets", new TableInfo.Column("numberOfOutOfOrderPackets", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("throughput", new TableInfo.Column("throughput", "REAL", true, 0, (String) null, 1));
            hashMap9.put("serverUrl", new TableInfo.Column("serverUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("errors", new TableInfo.Column("errors", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap9.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj18, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj22, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj23, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj19, new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put(obj39, new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put(obj38, new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj2, new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj27, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap9.put(obj26, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap9.put(obj5, new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap9.put(obj6, new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj7, new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj8, new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj9, new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap9.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap9.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap9.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap9.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo9 = new TableInfo("TrafficProfileMetric", hashMap9, new HashSet(0), new HashSet(0));
            TableInfo read9 = TableInfo.read(supportSQLiteDatabase2, "TrafficProfileMetric");
            if (tableInfo9.equals(read9)) {
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
            return new RoomOpenHelper.ValidationResult(false, "TrafficProfileMetric(com.cellrebel.sdk.networking.beans.request.TrafficProfileMetric).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ConnectionTimePassive` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `connectionType` TEXT, `duration` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ConnectionTimeActive` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `duration` INTEGER NOT NULL, `connectionType` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WifiInfoMetric` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `dateTimeOfMeasurement` TEXT, `accessTechnology` TEXT, `bssid` TEXT, `ssid` TEXT, `level` INTEGER NOT NULL, `age` INTEGER NOT NULL, `anonymize` INTEGER, `sdkOrigin` TEXT, `frequency` INTEGER NOT NULL, `linkSpeed` INTEGER NOT NULL, `maxSupportedRxLinkSpeed` INTEGER NOT NULL, `maxSupportedTxLinkSpeed` INTEGER NOT NULL, `wifiStandard` TEXT, `networkId` INTEGER NOT NULL, `isConnected` INTEGER, `isRooted` INTEGER, `rxLinkSpeed` INTEGER NOT NULL, `txLinkSpeed` INTEGER NOT NULL, `channelWidth` INTEGER NOT NULL, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `DataUsageMetric` (`wiFiSentUsage` INTEGER NOT NULL, `wiFiReceivedUsage` INTEGER NOT NULL, `cellularSentUsage` INTEGER NOT NULL, `cellularReceivedUsage` INTEGER NOT NULL, `timePeriod` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FileTransferServer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FileTransferMetric` (`serverIdFileLoad` TEXT, `downLoadFileTime` INTEGER NOT NULL, `upLoadFileTime` INTEGER NOT NULL, `isFileDownLoaded` INTEGER NOT NULL, `isFileUpLoaded` INTEGER NOT NULL, `latency` INTEGER NOT NULL, `downloadFirstByteTime` INTEGER NOT NULL, `downloadAccessTechStart` TEXT, `downloadAccessTechEnd` TEXT, `downloadAccessTechNumChanges` INTEGER NOT NULL, `uploadFirstByteTime` INTEGER NOT NULL, `uploadAccessTechStart` TEXT, `uploadAccessTechEnd` TEXT, `uploadAccessTechNumChanges` INTEGER NOT NULL, `bytesSent` INTEGER NOT NULL, `bytesReceived` INTEGER NOT NULL, `dnsLookupTime` INTEGER NOT NULL, `tcpConnectTime` INTEGER NOT NULL, `tlsSetupTime` INTEGER NOT NULL, `fileSize` INTEGER NOT NULL, `isFromLatencyTest` INTEGER NOT NULL, `fileTransferId` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ConnectionMetric` (`videoFailsToStartTotal` INTEGER NOT NULL, `pageFailsToLoadTotal` INTEGER NOT NULL, `callsTotal` INTEGER NOT NULL, `callsBlocksTotal` INTEGER NOT NULL, `callsDropsTotal` INTEGER NOT NULL, `callSetUpTimeTotal` INTEGER NOT NULL, `connectionTimePassive2g` INTEGER NOT NULL, `connectionTimePassive3g` INTEGER NOT NULL, `connectionTimePassive4g` INTEGER NOT NULL, `connectionTimePassive5g` INTEGER NOT NULL, `connectionTimePassiveWifi` INTEGER NOT NULL, `noConnectionTimePassive` INTEGER NOT NULL, `totalTimePassive` INTEGER NOT NULL, `connectionTimeActive2g` INTEGER NOT NULL, `connectionTimeActive3g` INTEGER NOT NULL, `connectionTimeActive4g` INTEGER NOT NULL, `connectionTimeActive5g` INTEGER NOT NULL, `connectionTimeActiveWifi` INTEGER NOT NULL, `noConnectionTimeActive` INTEGER NOT NULL, `totalTimeActive` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CoverageMetric` (`cellInfoMetricsJSON` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `VideoMetric` (`videoSource` TEXT, `fileUrl` TEXT, `videoInitialBufferingTime` INTEGER NOT NULL, `videoRebufferingTime` INTEGER NOT NULL, `videoRebufferingCount` INTEGER NOT NULL, `isVideoFailsToStart` INTEGER NOT NULL, `videoTimeToStart` INTEGER NOT NULL, `inStreamFailure` INTEGER NOT NULL, `videoLength` INTEGER NOT NULL, `videoQualityTime144p` INTEGER NOT NULL, `videoQualityTime240p` INTEGER NOT NULL, `videoQualityTime360p` INTEGER NOT NULL, `videoQualityTime480p` INTEGER NOT NULL, `videoQualityTime720p` INTEGER NOT NULL, `videoQualityTime1080p` INTEGER NOT NULL, `videoQualityTime1440p` INTEGER NOT NULL, `videoQualityTime2160p` INTEGER NOT NULL, `videoQualityTimeHighRes` INTEGER NOT NULL, `videoQualityTimeDefault` INTEGER NOT NULL, `videoQualityTimeUnknown` INTEGER NOT NULL, `accessTechStart` TEXT, `accessTechEnd` TEXT, `accessTechNumChanges` INTEGER NOT NULL, `bytesSent` INTEGER NOT NULL, `bytesReceived` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preferences` (`id` INTEGER NOT NULL, `token` TEXT, `manufacturer` TEXT, `marketName` TEXT, `codename` TEXT, `mobileClientId` TEXT, `clientKey` TEXT, `fileTransferTimeout` INTEGER NOT NULL, `currentRefreshCache` INTEGER NOT NULL, `onLoadRefreshCache` INTEGER NOT NULL, `ranksJson` TEXT, `countriesJson` TEXT, `ranksTimestamp` INTEGER NOT NULL, `wiFiSentUsage` INTEGER NOT NULL, `wiFiReceivedUsage` INTEGER NOT NULL, `cellularSentUsage` INTEGER NOT NULL, `cellularReceivedUsage` INTEGER NOT NULL, `callStartTime` INTEGER NOT NULL, `dataUsageMeasurementTimestamp` INTEGER NOT NULL, `pageLoadTimestamp` REAL NOT NULL, `fileLoadTimestamp` REAL NOT NULL, `videoLoadTimestamp` REAL NOT NULL, `locationDebug` TEXT, `cellInfoDebug` TEXT, `isMeasurementsStopped` INTEGER NOT NULL, `isBackgroundMeasurementEnabled` INTEGER NOT NULL, `isCallEnded` INTEGER NOT NULL, `isOnCall` INTEGER NOT NULL, `isRinging` INTEGER NOT NULL, `fileTransferAccessTechs` TEXT, `cdnDownloadAccessTechs` TEXT, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Settings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `connectionMeasurements` INTEGER, `connectionMeasurementPeriodicity` INTEGER, `connectionMeasurementFrequency` INTEGER, `onScreenMeasurement` INTEGER, `voiceCallsMeasurement` INTEGER, `videoBackgroundMeasurement` INTEGER, `videoActiveMeasurement` INTEGER, `videoBackgroundPeriodicityMeasurement` INTEGER, `videoForegroundPeriodicityMeasurement` INTEGER, `videoBufferingThreshold` INTEGER, `videoUrl` TEXT, `videoProvider` TEXT, `videoTimeoutTimer` INTEGER, `videoTimeoutFactor` INTEGER, `isPageLoadMeasurement` INTEGER, `pageLoadBackgroundMeasurement` INTEGER, `pageLoadUrl` TEXT, `pageLoadTimeoutTimer` INTEGER, `pageLoadPeriodicityMeasurement` INTEGER, `pageLoadForegroundPeriodicityMeasurement` INTEGER, `fileName` TEXT, `fileMeasurement` INTEGER, `fileTransferBackgroundMeasurement` INTEGER, `fileTransferPeriodicityTimer` INTEGER, `fileTransferForegroundPeriodicityTimer` INTEGER, `fileTransferTimeoutTimer` INTEGER, `serverIdFileLoad` TEXT, `fileServerUrls` TEXT, `cdnFileMeasurements` INTEGER, `cdnBackgroundMeasurement` INTEGER, `cdnFileDownloadPeriodicity` INTEGER, `cdnFileDownloadForegroundPeriodicity` INTEGER, `cdnFileDownloadTimeout` INTEGER, `cdnFileUrls` TEXT, `timeInBetweenMeasurements` INTEGER, `dataUsage` INTEGER, `dataUsageBackgroundMeasurement` INTEGER, `dataUsagePeriodicity` INTEGER, `foregroundPeriodicity` INTEGER, `foregroundMeasurementPeriodicity` INTEGER, `coverageMeasurement` INTEGER, `backgroundCoverageMeasurement` INTEGER, `coveragePeriodicity` INTEGER, `coverageForegroundPeriodicity` INTEGER, `foregroundCoverageTimeout` INTEGER, `backgroundCoverageTimeout` INTEGER, `foregroundCoverageSamplingInterval` INTEGER, `backgroundCoverageSamplingInterval` INTEGER, `reportingPeriodicity` INTEGER, `gameCacheRefresh` INTEGER, `gamePingsPerServer` INTEGER, `gameServersCache` INTEGER, `gameTimeoutTimer` INTEGER, `gameServersCacheEnabled` INTEGER, `backgroundGamePeriodicity` INTEGER, `backgroundGameReportingPeriodicity` INTEGER, `foregroundGameMeasurement` INTEGER, `backgroundGameMeasurement` INTEGER, `foregroundGamePeriodicity` INTEGER, `noLocationMeasurementEnabled` INTEGER, `wifiMeasurementsEnabled` INTEGER, `audioManagerEnabled` INTEGER, `cellInfoUpdateEnabled` INTEGER, `wifiForegroundTimer` INTEGER, `wifiPageLoadForegroundPeriodicity` INTEGER, `wifiFileTransferForegroundPeriodicity` INTEGER, `wifiCdnFileDownloadForegroundPeriodicity` INTEGER, `wifiVideoForegroundPeriodicity` INTEGER, `wifiGameForegroundPeriodicity` INTEGER, `wifiCoverageForegroundPeriodicity` INTEGER, `wifiDataUsageForegroundPeriodicity` INTEGER, `dataUsageForegroundPeriodicity` INTEGER, `isForegroundListenerEnabled` INTEGER, `settingsUrl` TEXT, `reportingUrl` TEXT, `backgroundLocationEnabled` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `secondaryReportingUrls` TEXT, `accessTechnologyCdnFileUrls` TEXT, `accessTechnologyFileNames` TEXT, `independentBackgroundCoverageMeasurement` INTEGER, `deviceInfoActiveMeasurements` INTEGER, `deviceInfoBackgroundMeasurements` INTEGER, `deviceInfoBackgroundPeriodicity` INTEGER, `deviceInfoForegroundPeriodicity` INTEGER, `tracerouteActiveMeasurements` INTEGER, `tracerouteBackgroundMeasurements` INTEGER, `tracerouteBackgroundPeriodicity` INTEGER, `tracerouteForegroundPeriodicity` INTEGER, `tracerouteNumberOfHops` INTEGER, `traceroutePacketSize` INTEGER, `tracerouteUrl` TEXT, `voiceCallMeasurements` INTEGER, `wifiTracerouteForegroundPeriodicity` INTEGER, `loadedLatencyEnabled` INTEGER, `wifiLoadedLatencyEnabled` INTEGER, `foregroundLoadedLatencyPeriodicity` INTEGER, `foregroundLoadedLatencyPeriodicityWifi` INTEGER, `loadedLatencyMeasurementsPerServer` INTEGER, `loadedLatencyServersCache` INTEGER, `loadedLatencyTimeoutTimer` INTEGER, `loadedLatencyCacheRefresh` INTEGER, `loadedLatencyServersCacheEnabled` INTEGER, `randomCdnFileMeasurements` INTEGER, `randomCdnBackgroundMeasurement` INTEGER, `randomCdnFileDownloadForegroundPeriodicity` INTEGER, `randomCdnFileDownloadPeriodicity` INTEGER, `wifiRandomCdnFileDownloadForegroundPeriodicity` INTEGER, `randomCdnFileDownloadTimeout` INTEGER, `randomCdnFileUrls` TEXT, `randomCdnServerCount` INTEGER, `trafficProfileMeasurementsEnabled` INTEGER, `trafficProfileBackgroundMeasurementsEnabled` INTEGER, `trafficProfileForegroundPeriodicity` INTEGER, `trafficProfileBackgroundPeriodicity` INTEGER, `trafficProfileWiFiPeriodicity` INTEGER, `trafficProfileTimeout` INTEGER, `trafficProfileMeasurementLimit` INTEGER, `trafficProfileServerUrls` TEXT, `trafficProfiles` TEXT, `timeToInteractionMeasurementsEnabled` INTEGER, `timeToInteractionBackgroundMeasurementsEnabled` INTEGER, `timeToInteractionForegroundPeriodicity` INTEGER, `timeToInteractionBackgroundPeriodicity` INTEGER, `timeToInteractionWiFiPeriodicity` INTEGER, `timeToInteractionTimeout` INTEGER, `timeToInteractionDownloadFileSize` INTEGER, `timeToInteractionUploadFileSize` INTEGER, `timeToInteractionServerListLimit` INTEGER, `timeToInteractionServerSelectionTimeout` INTEGER, `timeToInteractionPingTimeout` INTEGER, `timeToInteractionPingsPerServer` INTEGER, `timeToInteractionUploadStatsInterval` INTEGER, `timeToInteractionUploadStatsTimeout` INTEGER, `isMeasurementsAutoStartEnabled` INTEGER, `measurementsAutoStartDelay` INTEGER, `isServerFallbackEnabled` INTEGER, `serverFallbackCount` INTEGER, `connectionTestVideoUrl` TEXT, `connectionTestVideoTimeout` INTEGER, `connectionTestVideoScore` INTEGER, `connectionTestPageLoadUrl` TEXT, `connectionTestPageLoadTimeout` INTEGER, `connectionTestPageLoadScore` INTEGER, `traffic_profiles` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Timestamps` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pageLoad` INTEGER NOT NULL, `fileTransfer` INTEGER NOT NULL, `cdnDownload` INTEGER NOT NULL, `video` INTEGER NOT NULL, `coverage` INTEGER NOT NULL, `dataUsage` INTEGER NOT NULL, `connection` INTEGER NOT NULL, `coverageReporting` INTEGER NOT NULL, `game` INTEGER NOT NULL, `traceroute` INTEGER NOT NULL, `tti` INTEGER NOT NULL, `trafficProfile` INTEGER NOT NULL, `deviceInfo` INTEGER NOT NULL, `loadedLatency` INTEGER NOT NULL, `randomCdnDownload` INTEGER NOT NULL, `cellInfoReportingPeriodicity` INTEGER NOT NULL, `foregroundLaunchTime` INTEGER NOT NULL, `foregroundLaunchTimeWiFi` INTEGER NOT NULL, `backgroundLaunchTime` INTEGER NOT NULL, `metaWorkerLaunchTme` INTEGER NOT NULL, `settingsRefreshTime` INTEGER NOT NULL, `foregroundPageLoad` INTEGER NOT NULL, `foregroundDeviceInfo` INTEGER NOT NULL, `foregroundFileTransfer` INTEGER NOT NULL, `foregroundCdnDownload` INTEGER NOT NULL, `foregroundVideo` INTEGER NOT NULL, `foregroundTraceroute` INTEGER NOT NULL, `foregroundCoverage` INTEGER NOT NULL, `foregroundGame` INTEGER NOT NULL, `foregroundLoadedLatency` INTEGER NOT NULL, `foregroundDataUsage` INTEGER NOT NULL, `foregroundRandomCdnDownload` INTEGER NOT NULL, `foregroundTti` INTEGER NOT NULL, `foregroundTrafficProfile` INTEGER NOT NULL, `foregroundPageLoadWiFi` INTEGER NOT NULL, `foregroundFileTransferWiFi` INTEGER NOT NULL, `foregroundCdnDownloadWiFi` INTEGER NOT NULL, `foregroundVideoWiFi` INTEGER NOT NULL, `foregroundTracerouteWiFi` INTEGER NOT NULL, `foregroundCoverageWiFi` INTEGER NOT NULL, `foregroundGameWiFi` INTEGER NOT NULL, `foregroundDataUsageWiFi` INTEGER NOT NULL, `foregroundLoadedLatencyWiFi` INTEGER NOT NULL, `foregroundRandomCdnDownloadWiFi` INTEGER NOT NULL, `foregroundTtiWiFi` INTEGER NOT NULL, `foregroundTrafficProfileWiFi` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PageLoadScore` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `score` REAL NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `VideoLoadScore` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `score` REAL NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PageLoadMetric` (`pageUrl` TEXT, `pageSize` INTEGER NOT NULL, `pageLoadTime` INTEGER NOT NULL, `firstByteTime` INTEGER NOT NULL, `isPageFailsToLoad` INTEGER NOT NULL, `accessTechStart` TEXT, `accessTechEnd` TEXT, `accessTechNumChanges` INTEGER NOT NULL, `bytesSent` INTEGER NOT NULL, `bytesReceived` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Game` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `isHidden` INTEGER, `subtitle` TEXT, `servers` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `GameInfoMetric` (`serverName` TEXT, `gameName` TEXT, `serverUrl` TEXT, `latency` REAL, `pingsCount` REAL, `failedMeasurementsCount` REAL, `jitter` REAL, `isSent` INTEGER NOT NULL, `isOffline` INTEGER NOT NULL, `isUnderAdditionalLoad` INTEGER NOT NULL, `isCached` INTEGER NOT NULL, `loadedLatencyTestFileTransferUrl` TEXT, `fileTransferId` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CellInfoMetric` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `sdkOrigin` TEXT, `isRegistered` INTEGER NOT NULL, `dateTimeOfMeasurement` TEXT, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `os` TEXT, `osVersion` TEXT, `cellConnectionStatus` INTEGER NOT NULL, `cellType` TEXT, `age` INTEGER NOT NULL, `bandwidth` INTEGER, `cellId` TEXT, `arfc` INTEGER, `connectionArfc` INTEGER, `cellBands` TEXT, `pci` INTEGER, `lac` TEXT, `asuLevel` INTEGER, `dbm` INTEGER, `cqi` INTEGER, `level` INTEGER, `rsrp` INTEGER, `rsrq` INTEGER, `rssi` INTEGER, `rssnr` INTEGER, `csiRsrp` INTEGER, `csiSinr` INTEGER, `csiRsrq` INTEGER, `ssRsrp` INTEGER, `ssRsrq` INTEGER, `ssSinr` INTEGER, `timingAdvance` INTEGER, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `locationAge` INTEGER NOT NULL, `sdkVersionNumber` TEXT, `wcdmaEcNo` INTEGER, `networkOperatorName` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `isSending` INTEGER NOT NULL, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `GameLatency` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `gameName` TEXT, `serverName` TEXT, `latency` REAL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `DeviceInfoMetric` (`lteFrequencySupport` TEXT, `nrFrequencySupport` TEXT, `ueCategory` TEXT, `is4gCapable` INTEGER, `is5gCapable` INTEGER, `volteSupport` INTEGER, `deviceYear` INTEGER, `maximumStorage` INTEGER, `freeStorage` INTEGER, `ram` INTEGER, `freeRam` INTEGER, `cpuUsage` INTEGER NOT NULL, `batteryLevel` REAL, `batteryState` INTEGER, `batteryChargeType` INTEGER, `batteryHealth` INTEGER, `batteryTemperature` REAL, `language` TEXT, `locale` TEXT, `userAgent` TEXT, `screenWidth` INTEGER, `screenHeight` INTEGER, `elapsedRealtimeNanos` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `VoiceCallMetric` (`callStartTime` INTEGER NOT NULL, `callEndTime` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TraceRouteMetric` (`traceroute` TEXT, `serverUrl` TEXT, `numberOfHops` INTEGER NOT NULL, `packetSize` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TimeToInteractionMetric` (`serverId` INTEGER, `serverPort` INTEGER, `serverVersion` TEXT, `serverBuild` TEXT, `latency` INTEGER, `downloadTime` INTEGER, `downloadTimeToFirstByte` INTEGER, `bytesDownloaded` INTEGER, `uploadTime` INTEGER, `uploadTimeToFirstByte` INTEGER, `bytesUploaded` INTEGER, `errorTypes` TEXT, `accessTechStart` TEXT, `accessTechEnd` TEXT, `accessTechNumChanges` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TrafficProfileMetric` (`profileName` TEXT, `profile` TEXT, `profileType` INTEGER NOT NULL, `meanLatency` INTEGER NOT NULL, `medianLatency` INTEGER NOT NULL, `minimumLatency` INTEGER NOT NULL, `maximumLatency` INTEGER NOT NULL, `p10Latency` INTEGER NOT NULL, `p90Latency` INTEGER NOT NULL, `iqmLatency` INTEGER NOT NULL, `meanJitter` INTEGER NOT NULL, `medianJitter` INTEGER NOT NULL, `minimumJitter` INTEGER NOT NULL, `maximumJitter` INTEGER NOT NULL, `p10Jitter` INTEGER NOT NULL, `p90Jitter` INTEGER NOT NULL, `iqmJitter` INTEGER NOT NULL, `packetLoss` INTEGER NOT NULL, `outOfOrderPackets` INTEGER NOT NULL, `packetCount` INTEGER NOT NULL, `numberOfOutOfOrderPackets` INTEGER NOT NULL, `throughput` REAL NOT NULL, `serverUrl` TEXT, `errors` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mobileClientId` TEXT, `measurementSequenceId` TEXT, `clientIp` TEXT, `dateTimeOfMeasurement` TEXT, `stateDuringMeasurement` INTEGER NOT NULL, `accessTechnology` TEXT, `accessTypeRaw` TEXT, `signalStrength` INTEGER NOT NULL, `interference` INTEGER NOT NULL, `simMCC` TEXT, `simMNC` TEXT, `secondarySimMCC` TEXT, `secondarySimMNC` TEXT, `numberOfSimSlots` INTEGER NOT NULL, `dataSimSlotNumber` INTEGER NOT NULL, `networkMCC` TEXT, `networkMNC` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `gpsAccuracy` REAL NOT NULL, `cellId` TEXT, `lacId` TEXT, `deviceBrand` TEXT, `deviceModel` TEXT, `deviceVersion` TEXT, `sdkVersionNumber` TEXT, `carrierName` TEXT, `secondaryCarrierName` TEXT, `networkOperatorName` TEXT, `os` TEXT, `osVersion` TEXT, `readableDate` TEXT, `physicalCellId` INTEGER, `absoluteRfChannelNumber` INTEGER, `connectionAbsoluteRfChannelNumber` INTEGER, `cellBands` TEXT, `channelQualityIndicator` INTEGER, `referenceSignalSignalToNoiseRatio` INTEGER, `referenceSignalReceivedPower` INTEGER, `referenceSignalReceivedQuality` INTEGER, `csiReferenceSignalReceivedPower` INTEGER, `csiReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `csiReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalReceivedPower` INTEGER, `ssReferenceSignalReceivedQuality` INTEGER, `ssReferenceSignalToNoiseAndInterferenceRatio` INTEGER, `timingAdvance` INTEGER, `signalStrengthAsu` INTEGER, `dbm` INTEGER, `debugString` TEXT, `isDcNrRestricted` INTEGER, `isNrAvailable` INTEGER, `isEnDcAvailable` INTEGER, `nrState` TEXT, `nrFrequencyRange` INTEGER, `isUsingCarrierAggregation` INTEGER, `vopsSupport` INTEGER, `cellBandwidths` TEXT, `additionalPlmns` TEXT, `altitude` REAL NOT NULL, `locationSpeed` REAL, `locationSpeedAccuracy` REAL, `gpsVerticalAccuracy` REAL, `getRestrictBackgroundStatus` INTEGER NOT NULL, `cellType` TEXT, `isDefaultNetworkActive` INTEGER, `isActiveNetworkMetered` INTEGER, `isOnScreen` INTEGER, `isRoaming` INTEGER, `locationAge` INTEGER NOT NULL, `overrideNetworkType` INTEGER, `accessNetworkTechnologyRaw` INTEGER, `anonymize` INTEGER, `sdkOrigin` TEXT, `isRooted` INTEGER, `isConnectedToVpn` INTEGER, `linkDownstreamBandwidth` INTEGER NOT NULL, `linkUpstreamBandwidth` INTEGER NOT NULL, `latencyType` INTEGER NOT NULL, `serverIp` TEXT, `privateIp` TEXT, `gatewayIp` TEXT, `locationPermissionState` INTEGER, `serviceStateStatus` INTEGER, `isNrCellSeen` INTEGER, `isReadPhoneStatePermissionGranted` INTEGER, `appVersionName` TEXT, `appVersionCode` INTEGER NOT NULL, `appLastUpdateTime` INTEGER NOT NULL, `duplexModeState` INTEGER NOT NULL, `dozeModeState` INTEGER NOT NULL, `callState` INTEGER NOT NULL, `buildDevice` TEXT, `buildHardware` TEXT, `buildProduct` TEXT, `appId` TEXT, `isSending` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ebf5efac687f7a93a2dc77e398dd200c')");
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ConnectionTimePassive`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ConnectionTimeActive`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WifiInfoMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `DataUsageMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FileTransferServer`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FileTransferMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ConnectionMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CoverageMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `VideoMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preferences`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Settings`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Timestamps`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PageLoadScore`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `VideoLoadScore`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PageLoadMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Game`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `GameInfoMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CellInfoMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `GameLatency`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `DeviceInfoMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `VoiceCallMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TraceRouteMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TimeToInteractionMetric`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TrafficProfileMetric`");
            if (SDKRoomDatabase_Impl.this.mCallbacks != null) {
                int size = SDKRoomDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SDKRoomDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (SDKRoomDatabase_Impl.this.mCallbacks != null) {
                int size = SDKRoomDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SDKRoomDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase unused = SDKRoomDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            SDKRoomDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (SDKRoomDatabase_Impl.this.mCallbacks != null) {
                int size = SDKRoomDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SDKRoomDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        /* access modifiers changed from: protected */
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
            HashMap hashMap = new HashMap(3);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap.put("connectionType", new TableInfo.Column("connectionType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("ConnectionTimePassive", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase2, "ConnectionTimePassive");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "ConnectionTimePassive(com.cellrebel.sdk.database.ConnectionTimePassive).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap2.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("connectionType", new TableInfo.Column("connectionType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            TableInfo tableInfo2 = new TableInfo("ConnectionTimeActive", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "ConnectionTimeActive");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "ConnectionTimeActive(com.cellrebel.sdk.database.ConnectionTimeActive).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(23);
            hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap3.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("bssid", new TableInfo.Column("bssid", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("ssid", new TableInfo.Column("ssid", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("level", new TableInfo.Column("level", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put(IronSourceSegment.AGE, new TableInfo.Column(IronSourceSegment.AGE, "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put(ThroughputConfigUtil.SHARED_PREFS_KEY_FREQUENCY, new TableInfo.Column(ThroughputConfigUtil.SHARED_PREFS_KEY_FREQUENCY, "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("linkSpeed", new TableInfo.Column("linkSpeed", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("maxSupportedRxLinkSpeed", new TableInfo.Column("maxSupportedRxLinkSpeed", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("maxSupportedTxLinkSpeed", new TableInfo.Column("maxSupportedTxLinkSpeed", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("wifiStandard", new TableInfo.Column("wifiStandard", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap3.put("networkId", new TableInfo.Column("networkId", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("isConnected", new TableInfo.Column("isConnected", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("rxLinkSpeed", new TableInfo.Column("rxLinkSpeed", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("txLinkSpeed", new TableInfo.Column("txLinkSpeed", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("channelWidth", new TableInfo.Column("channelWidth", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo3 = new TableInfo("WifiInfoMetric", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "WifiInfoMetric");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "WifiInfoMetric(com.cellrebel.sdk.networking.beans.request.WifiInfoMetric).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(103);
            hashMap4.put("wiFiSentUsage", new TableInfo.Column("wiFiSentUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("wiFiReceivedUsage", new TableInfo.Column("wiFiReceivedUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("cellularSentUsage", new TableInfo.Column("cellularSentUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("cellularReceivedUsage", new TableInfo.Column("cellularReceivedUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("timePeriod", new TableInfo.Column("timePeriod", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap4.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("accessTypeRaw", new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj = "accessTypeRaw";
            hashMap4.put("signalStrength", new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            Object obj2 = "signalStrength";
            hashMap4.put("interference", new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            Object obj3 = "interference";
            hashMap4.put("simMCC", new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj4 = "simMCC";
            hashMap4.put("simMNC", new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj5 = "simMNC";
            hashMap4.put("secondarySimMCC", new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj6 = "secondarySimMCC";
            hashMap4.put("secondarySimMNC", new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj7 = "secondarySimMNC";
            hashMap4.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            Object obj8 = "latitude";
            hashMap4.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            Object obj9 = "longitude";
            hashMap4.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap4.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap4.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap4.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap4.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap4.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("isRooted", new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap4.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap4.put("isSending", new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj10 = "isSending";
            Object obj11 = "isRooted";
            TableInfo tableInfo4 = new TableInfo("DataUsageMetric", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "DataUsageMetric");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "DataUsageMetric(com.cellrebel.sdk.networking.beans.request.DataUsageMetric).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap5.put("url", new TableInfo.Column("url", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            TableInfo tableInfo5 = new TableInfo("FileTransferServer", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "FileTransferServer");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "FileTransferServer(com.cellrebel.sdk.database.FileTransferServer).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(120);
            hashMap6.put("serverIdFileLoad", new TableInfo.Column("serverIdFileLoad", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("downLoadFileTime", new TableInfo.Column("downLoadFileTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("upLoadFileTime", new TableInfo.Column("upLoadFileTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("isFileDownLoaded", new TableInfo.Column("isFileDownLoaded", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("isFileUpLoaded", new TableInfo.Column("isFileUpLoaded", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("latency", new TableInfo.Column("latency", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("downloadFirstByteTime", new TableInfo.Column("downloadFirstByteTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("downloadAccessTechStart", new TableInfo.Column("downloadAccessTechStart", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("downloadAccessTechEnd", new TableInfo.Column("downloadAccessTechEnd", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("downloadAccessTechNumChanges", new TableInfo.Column("downloadAccessTechNumChanges", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("uploadFirstByteTime", new TableInfo.Column("uploadFirstByteTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("uploadAccessTechStart", new TableInfo.Column("uploadAccessTechStart", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("uploadAccessTechEnd", new TableInfo.Column("uploadAccessTechEnd", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("uploadAccessTechNumChanges", new TableInfo.Column("uploadAccessTechNumChanges", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("bytesSent", new TableInfo.Column("bytesSent", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("bytesReceived", new TableInfo.Column("bytesReceived", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("dnsLookupTime", new TableInfo.Column("dnsLookupTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("tcpConnectTime", new TableInfo.Column("tcpConnectTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("tlsSetupTime", new TableInfo.Column("tlsSetupTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("isFromLatencyTest", new TableInfo.Column("isFromLatencyTest", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("fileTransferId", new TableInfo.Column("fileTransferId", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap6.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj12 = obj;
            hashMap6.put(obj12, new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj13 = obj2;
            hashMap6.put(obj13, new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put(obj3, new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put(obj4, new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj5, new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj6, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj7, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj8, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put(obj9, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap6.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap6.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap6.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap6.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap6.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("anonymize", new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("sdkOrigin", new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj14 = obj11;
            hashMap6.put(obj14, new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            Object obj15 = obj14;
            hashMap6.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap6.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap6.put(obj10, new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj16 = "sdkOrigin";
            Object obj17 = "anonymize";
            TableInfo tableInfo6 = new TableInfo("FileTransferMetric", hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "FileTransferMetric");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "FileTransferMetric(com.cellrebel.sdk.networking.beans.request.FileTransferMetric).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(118);
            hashMap7.put("videoFailsToStartTotal", new TableInfo.Column("videoFailsToStartTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("pageFailsToLoadTotal", new TableInfo.Column("pageFailsToLoadTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callsTotal", new TableInfo.Column("callsTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callsBlocksTotal", new TableInfo.Column("callsBlocksTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callsDropsTotal", new TableInfo.Column("callsDropsTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callSetUpTimeTotal", new TableInfo.Column("callSetUpTimeTotal", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimePassive2g", new TableInfo.Column("connectionTimePassive2g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimePassive3g", new TableInfo.Column("connectionTimePassive3g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimePassive4g", new TableInfo.Column("connectionTimePassive4g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimePassive5g", new TableInfo.Column("connectionTimePassive5g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimePassiveWifi", new TableInfo.Column("connectionTimePassiveWifi", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("noConnectionTimePassive", new TableInfo.Column("noConnectionTimePassive", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("totalTimePassive", new TableInfo.Column("totalTimePassive", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimeActive2g", new TableInfo.Column("connectionTimeActive2g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimeActive3g", new TableInfo.Column("connectionTimeActive3g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimeActive4g", new TableInfo.Column("connectionTimeActive4g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimeActive5g", new TableInfo.Column("connectionTimeActive5g", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("connectionTimeActiveWifi", new TableInfo.Column("connectionTimeActiveWifi", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("noConnectionTimeActive", new TableInfo.Column("noConnectionTimeActive", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("totalTimeActive", new TableInfo.Column("totalTimeActive", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap7.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj12, new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj13, new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put(obj3, new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put(obj4, new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj5, new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj6, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj7, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj8, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put(obj9, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap7.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap7.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap7.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap7.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap7.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put(obj17, new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put(obj16, new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj18 = obj15;
            hashMap7.put(obj18, new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            Object obj19 = obj18;
            hashMap7.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap7.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap7.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap7.put(obj10, new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo7 = new TableInfo("ConnectionMetric", hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, "ConnectionMetric");
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "ConnectionMetric(com.cellrebel.sdk.networking.beans.request.ConnectionMetric).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            HashMap hashMap8 = new HashMap(99);
            hashMap8.put("cellInfoMetricsJSON", new TableInfo.Column("cellInfoMetricsJSON", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap8.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj12, new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj13, new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put(obj3, new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put(obj4, new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj5, new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj6, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj7, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj8, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put(obj9, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap8.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap8.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap8.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap8.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap8.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put(obj17, new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put(obj16, new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj20 = obj19;
            hashMap8.put(obj20, new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            Object obj21 = obj20;
            hashMap8.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap8.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap8.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap8.put(obj10, new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo8 = new TableInfo("CoverageMetric", hashMap8, new HashSet(0), new HashSet(0));
            TableInfo read8 = TableInfo.read(supportSQLiteDatabase2, "CoverageMetric");
            if (!tableInfo8.equals(read8)) {
                return new RoomOpenHelper.ValidationResult(false, "CoverageMetric(com.cellrebel.sdk.networking.beans.request.CoverageMetric).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
            HashMap hashMap9 = new HashMap(123);
            hashMap9.put("videoSource", new TableInfo.Column("videoSource", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("fileUrl", new TableInfo.Column("fileUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("videoInitialBufferingTime", new TableInfo.Column("videoInitialBufferingTime", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoRebufferingTime", new TableInfo.Column("videoRebufferingTime", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoRebufferingCount", new TableInfo.Column("videoRebufferingCount", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("isVideoFailsToStart", new TableInfo.Column("isVideoFailsToStart", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoTimeToStart", new TableInfo.Column("videoTimeToStart", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("inStreamFailure", new TableInfo.Column("inStreamFailure", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put(MRAIDPresenter.VIDEO_LENGTH, new TableInfo.Column(MRAIDPresenter.VIDEO_LENGTH, "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime144p", new TableInfo.Column("videoQualityTime144p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime240p", new TableInfo.Column("videoQualityTime240p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime360p", new TableInfo.Column("videoQualityTime360p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime480p", new TableInfo.Column("videoQualityTime480p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime720p", new TableInfo.Column("videoQualityTime720p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime1080p", new TableInfo.Column("videoQualityTime1080p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime1440p", new TableInfo.Column("videoQualityTime1440p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTime2160p", new TableInfo.Column("videoQualityTime2160p", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTimeHighRes", new TableInfo.Column("videoQualityTimeHighRes", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTimeDefault", new TableInfo.Column("videoQualityTimeDefault", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("videoQualityTimeUnknown", new TableInfo.Column("videoQualityTimeUnknown", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("accessTechStart", new TableInfo.Column("accessTechStart", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("accessTechEnd", new TableInfo.Column("accessTechEnd", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("accessTechNumChanges", new TableInfo.Column("accessTechNumChanges", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("bytesSent", new TableInfo.Column("bytesSent", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("bytesReceived", new TableInfo.Column("bytesReceived", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap9.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("stateDuringMeasurement", new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("accessTechnology", new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj12, new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj13, new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put(obj3, new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put(obj4, new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj5, new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj6, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj7, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj22 = obj8;
            hashMap9.put(obj22, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            Object obj23 = obj9;
            hashMap9.put(obj23, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap9.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap9.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap9.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap9.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap9.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap9.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            Object obj24 = obj17;
            hashMap9.put(obj24, new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            Object obj25 = obj13;
            Object obj26 = obj16;
            hashMap9.put(obj26, new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            Object obj27 = obj12;
            Object obj28 = obj21;
            hashMap9.put(obj28, new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            Object obj29 = obj28;
            hashMap9.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap9.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap9.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap9.put(obj10, new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            Object obj30 = "accessTechnology";
            Object obj31 = "stateDuringMeasurement";
            TableInfo tableInfo9 = new TableInfo("VideoMetric", hashMap9, new HashSet(0), new HashSet(0));
            TableInfo read9 = TableInfo.read(supportSQLiteDatabase2, "VideoMetric");
            if (!tableInfo9.equals(read9)) {
                return new RoomOpenHelper.ValidationResult(false, "VideoMetric(com.cellrebel.sdk.networking.beans.request.VideoMetric).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
            }
            HashMap hashMap10 = new HashMap(31);
            hashMap10.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap10.put(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY, new TableInfo.Column(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY, AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("manufacturer", new TableInfo.Column("manufacturer", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("marketName", new TableInfo.Column("marketName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("codename", new TableInfo.Column("codename", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("clientKey", new TableInfo.Column("clientKey", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("fileTransferTimeout", new TableInfo.Column("fileTransferTimeout", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("currentRefreshCache", new TableInfo.Column("currentRefreshCache", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("onLoadRefreshCache", new TableInfo.Column("onLoadRefreshCache", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("ranksJson", new TableInfo.Column("ranksJson", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("countriesJson", new TableInfo.Column("countriesJson", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("ranksTimestamp", new TableInfo.Column("ranksTimestamp", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("wiFiSentUsage", new TableInfo.Column("wiFiSentUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("wiFiReceivedUsage", new TableInfo.Column("wiFiReceivedUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("cellularSentUsage", new TableInfo.Column("cellularSentUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("cellularReceivedUsage", new TableInfo.Column("cellularReceivedUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("callStartTime", new TableInfo.Column("callStartTime", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("dataUsageMeasurementTimestamp", new TableInfo.Column("dataUsageMeasurementTimestamp", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("pageLoadTimestamp", new TableInfo.Column("pageLoadTimestamp", "REAL", true, 0, (String) null, 1));
            hashMap10.put("fileLoadTimestamp", new TableInfo.Column("fileLoadTimestamp", "REAL", true, 0, (String) null, 1));
            hashMap10.put("videoLoadTimestamp", new TableInfo.Column("videoLoadTimestamp", "REAL", true, 0, (String) null, 1));
            hashMap10.put("locationDebug", new TableInfo.Column("locationDebug", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("cellInfoDebug", new TableInfo.Column("cellInfoDebug", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("isMeasurementsStopped", new TableInfo.Column("isMeasurementsStopped", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("isBackgroundMeasurementEnabled", new TableInfo.Column("isBackgroundMeasurementEnabled", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("isCallEnded", new TableInfo.Column("isCallEnded", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("isOnCall", new TableInfo.Column("isOnCall", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("isRinging", new TableInfo.Column("isRinging", "INTEGER", true, 0, (String) null, 1));
            hashMap10.put("fileTransferAccessTechs", new TableInfo.Column("fileTransferAccessTechs", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap10.put("cdnDownloadAccessTechs", new TableInfo.Column("cdnDownloadAccessTechs", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            TableInfo tableInfo10 = new TableInfo("Preferences", hashMap10, new HashSet(0), new HashSet(0));
            TableInfo read10 = TableInfo.read(supportSQLiteDatabase2, "Preferences");
            if (!tableInfo10.equals(read10)) {
                return new RoomOpenHelper.ValidationResult(false, "Preferences(com.cellrebel.sdk.database.Preferences).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
            }
            HashMap hashMap11 = new HashMap(148);
            hashMap11.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap11.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("connectionMeasurements", new TableInfo.Column("connectionMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionMeasurementPeriodicity", new TableInfo.Column("connectionMeasurementPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionMeasurementFrequency", new TableInfo.Column("connectionMeasurementFrequency", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("onScreenMeasurement", new TableInfo.Column("onScreenMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("voiceCallsMeasurement", new TableInfo.Column("voiceCallsMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoBackgroundMeasurement", new TableInfo.Column("videoBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoActiveMeasurement", new TableInfo.Column("videoActiveMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoBackgroundPeriodicityMeasurement", new TableInfo.Column("videoBackgroundPeriodicityMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoForegroundPeriodicityMeasurement", new TableInfo.Column("videoForegroundPeriodicityMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoBufferingThreshold", new TableInfo.Column("videoBufferingThreshold", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoUrl", new TableInfo.Column("videoUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("videoProvider", new TableInfo.Column("videoProvider", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("videoTimeoutTimer", new TableInfo.Column("videoTimeoutTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("videoTimeoutFactor", new TableInfo.Column("videoTimeoutFactor", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("isPageLoadMeasurement", new TableInfo.Column("isPageLoadMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("pageLoadBackgroundMeasurement", new TableInfo.Column("pageLoadBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("pageLoadUrl", new TableInfo.Column("pageLoadUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("pageLoadTimeoutTimer", new TableInfo.Column("pageLoadTimeoutTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("pageLoadPeriodicityMeasurement", new TableInfo.Column("pageLoadPeriodicityMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("pageLoadForegroundPeriodicityMeasurement", new TableInfo.Column("pageLoadForegroundPeriodicityMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("fileName", new TableInfo.Column("fileName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("fileMeasurement", new TableInfo.Column("fileMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("fileTransferBackgroundMeasurement", new TableInfo.Column("fileTransferBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("fileTransferPeriodicityTimer", new TableInfo.Column("fileTransferPeriodicityTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("fileTransferForegroundPeriodicityTimer", new TableInfo.Column("fileTransferForegroundPeriodicityTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("fileTransferTimeoutTimer", new TableInfo.Column("fileTransferTimeoutTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("serverIdFileLoad", new TableInfo.Column("serverIdFileLoad", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("fileServerUrls", new TableInfo.Column("fileServerUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("cdnFileMeasurements", new TableInfo.Column("cdnFileMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cdnBackgroundMeasurement", new TableInfo.Column("cdnBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cdnFileDownloadPeriodicity", new TableInfo.Column("cdnFileDownloadPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cdnFileDownloadForegroundPeriodicity", new TableInfo.Column("cdnFileDownloadForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cdnFileDownloadTimeout", new TableInfo.Column("cdnFileDownloadTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cdnFileUrls", new TableInfo.Column("cdnFileUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("timeInBetweenMeasurements", new TableInfo.Column("timeInBetweenMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("dataUsage", new TableInfo.Column("dataUsage", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("dataUsageBackgroundMeasurement", new TableInfo.Column("dataUsageBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("dataUsagePeriodicity", new TableInfo.Column("dataUsagePeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundPeriodicity", new TableInfo.Column("foregroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundMeasurementPeriodicity", new TableInfo.Column("foregroundMeasurementPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("coverageMeasurement", new TableInfo.Column("coverageMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundCoverageMeasurement", new TableInfo.Column("backgroundCoverageMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("coveragePeriodicity", new TableInfo.Column("coveragePeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("coverageForegroundPeriodicity", new TableInfo.Column("coverageForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundCoverageTimeout", new TableInfo.Column("foregroundCoverageTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundCoverageTimeout", new TableInfo.Column("backgroundCoverageTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundCoverageSamplingInterval", new TableInfo.Column("foregroundCoverageSamplingInterval", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundCoverageSamplingInterval", new TableInfo.Column("backgroundCoverageSamplingInterval", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("reportingPeriodicity", new TableInfo.Column("reportingPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("gameCacheRefresh", new TableInfo.Column("gameCacheRefresh", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("gamePingsPerServer", new TableInfo.Column("gamePingsPerServer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("gameServersCache", new TableInfo.Column("gameServersCache", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("gameTimeoutTimer", new TableInfo.Column("gameTimeoutTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("gameServersCacheEnabled", new TableInfo.Column("gameServersCacheEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundGamePeriodicity", new TableInfo.Column("backgroundGamePeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundGameReportingPeriodicity", new TableInfo.Column("backgroundGameReportingPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundGameMeasurement", new TableInfo.Column("foregroundGameMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("backgroundGameMeasurement", new TableInfo.Column("backgroundGameMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundGamePeriodicity", new TableInfo.Column("foregroundGamePeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("noLocationMeasurementEnabled", new TableInfo.Column("noLocationMeasurementEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiMeasurementsEnabled", new TableInfo.Column("wifiMeasurementsEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("audioManagerEnabled", new TableInfo.Column("audioManagerEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("cellInfoUpdateEnabled", new TableInfo.Column("cellInfoUpdateEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiForegroundTimer", new TableInfo.Column("wifiForegroundTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiPageLoadForegroundPeriodicity", new TableInfo.Column("wifiPageLoadForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiFileTransferForegroundPeriodicity", new TableInfo.Column("wifiFileTransferForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiCdnFileDownloadForegroundPeriodicity", new TableInfo.Column("wifiCdnFileDownloadForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiVideoForegroundPeriodicity", new TableInfo.Column("wifiVideoForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiGameForegroundPeriodicity", new TableInfo.Column("wifiGameForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiCoverageForegroundPeriodicity", new TableInfo.Column("wifiCoverageForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiDataUsageForegroundPeriodicity", new TableInfo.Column("wifiDataUsageForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("dataUsageForegroundPeriodicity", new TableInfo.Column("dataUsageForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("isForegroundListenerEnabled", new TableInfo.Column("isForegroundListenerEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("settingsUrl", new TableInfo.Column("settingsUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("reportingUrl", new TableInfo.Column("reportingUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("backgroundLocationEnabled", new TableInfo.Column("backgroundLocationEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put(obj24, new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put(obj26, new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("secondaryReportingUrls", new TableInfo.Column("secondaryReportingUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("accessTechnologyCdnFileUrls", new TableInfo.Column("accessTechnologyCdnFileUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("accessTechnologyFileNames", new TableInfo.Column("accessTechnologyFileNames", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("independentBackgroundCoverageMeasurement", new TableInfo.Column("independentBackgroundCoverageMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("deviceInfoActiveMeasurements", new TableInfo.Column("deviceInfoActiveMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("deviceInfoBackgroundMeasurements", new TableInfo.Column("deviceInfoBackgroundMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("deviceInfoBackgroundPeriodicity", new TableInfo.Column("deviceInfoBackgroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("deviceInfoForegroundPeriodicity", new TableInfo.Column("deviceInfoForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteActiveMeasurements", new TableInfo.Column("tracerouteActiveMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteBackgroundMeasurements", new TableInfo.Column("tracerouteBackgroundMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteBackgroundPeriodicity", new TableInfo.Column("tracerouteBackgroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteForegroundPeriodicity", new TableInfo.Column("tracerouteForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteNumberOfHops", new TableInfo.Column("tracerouteNumberOfHops", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("traceroutePacketSize", new TableInfo.Column("traceroutePacketSize", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("tracerouteUrl", new TableInfo.Column("tracerouteUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("voiceCallMeasurements", new TableInfo.Column("voiceCallMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiTracerouteForegroundPeriodicity", new TableInfo.Column("wifiTracerouteForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyEnabled", new TableInfo.Column("loadedLatencyEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiLoadedLatencyEnabled", new TableInfo.Column("wifiLoadedLatencyEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundLoadedLatencyPeriodicity", new TableInfo.Column("foregroundLoadedLatencyPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("foregroundLoadedLatencyPeriodicityWifi", new TableInfo.Column("foregroundLoadedLatencyPeriodicityWifi", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyMeasurementsPerServer", new TableInfo.Column("loadedLatencyMeasurementsPerServer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyServersCache", new TableInfo.Column("loadedLatencyServersCache", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyTimeoutTimer", new TableInfo.Column("loadedLatencyTimeoutTimer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyCacheRefresh", new TableInfo.Column("loadedLatencyCacheRefresh", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("loadedLatencyServersCacheEnabled", new TableInfo.Column("loadedLatencyServersCacheEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnFileMeasurements", new TableInfo.Column("randomCdnFileMeasurements", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnBackgroundMeasurement", new TableInfo.Column("randomCdnBackgroundMeasurement", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnFileDownloadForegroundPeriodicity", new TableInfo.Column("randomCdnFileDownloadForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnFileDownloadPeriodicity", new TableInfo.Column("randomCdnFileDownloadPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("wifiRandomCdnFileDownloadForegroundPeriodicity", new TableInfo.Column("wifiRandomCdnFileDownloadForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnFileDownloadTimeout", new TableInfo.Column("randomCdnFileDownloadTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("randomCdnFileUrls", new TableInfo.Column("randomCdnFileUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("randomCdnServerCount", new TableInfo.Column("randomCdnServerCount", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileMeasurementsEnabled", new TableInfo.Column("trafficProfileMeasurementsEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileBackgroundMeasurementsEnabled", new TableInfo.Column("trafficProfileBackgroundMeasurementsEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileForegroundPeriodicity", new TableInfo.Column("trafficProfileForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileBackgroundPeriodicity", new TableInfo.Column("trafficProfileBackgroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileWiFiPeriodicity", new TableInfo.Column("trafficProfileWiFiPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileTimeout", new TableInfo.Column("trafficProfileTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileMeasurementLimit", new TableInfo.Column("trafficProfileMeasurementLimit", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("trafficProfileServerUrls", new TableInfo.Column("trafficProfileServerUrls", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("trafficProfiles", new TableInfo.Column("trafficProfiles", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionMeasurementsEnabled", new TableInfo.Column("timeToInteractionMeasurementsEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionBackgroundMeasurementsEnabled", new TableInfo.Column("timeToInteractionBackgroundMeasurementsEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionForegroundPeriodicity", new TableInfo.Column("timeToInteractionForegroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionBackgroundPeriodicity", new TableInfo.Column("timeToInteractionBackgroundPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionWiFiPeriodicity", new TableInfo.Column("timeToInteractionWiFiPeriodicity", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionTimeout", new TableInfo.Column("timeToInteractionTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionDownloadFileSize", new TableInfo.Column("timeToInteractionDownloadFileSize", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionUploadFileSize", new TableInfo.Column("timeToInteractionUploadFileSize", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionServerListLimit", new TableInfo.Column("timeToInteractionServerListLimit", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionServerSelectionTimeout", new TableInfo.Column("timeToInteractionServerSelectionTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionPingTimeout", new TableInfo.Column("timeToInteractionPingTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionPingsPerServer", new TableInfo.Column("timeToInteractionPingsPerServer", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionUploadStatsInterval", new TableInfo.Column("timeToInteractionUploadStatsInterval", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("timeToInteractionUploadStatsTimeout", new TableInfo.Column("timeToInteractionUploadStatsTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("isMeasurementsAutoStartEnabled", new TableInfo.Column("isMeasurementsAutoStartEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("measurementsAutoStartDelay", new TableInfo.Column("measurementsAutoStartDelay", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("isServerFallbackEnabled", new TableInfo.Column("isServerFallbackEnabled", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("serverFallbackCount", new TableInfo.Column("serverFallbackCount", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionTestVideoUrl", new TableInfo.Column("connectionTestVideoUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("connectionTestVideoTimeout", new TableInfo.Column("connectionTestVideoTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionTestVideoScore", new TableInfo.Column("connectionTestVideoScore", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionTestPageLoadUrl", new TableInfo.Column("connectionTestPageLoadUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap11.put("connectionTestPageLoadTimeout", new TableInfo.Column("connectionTestPageLoadTimeout", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("connectionTestPageLoadScore", new TableInfo.Column("connectionTestPageLoadScore", "INTEGER", false, 0, (String) null, 1));
            hashMap11.put("traffic_profiles", new TableInfo.Column("traffic_profiles", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            TableInfo tableInfo11 = new TableInfo("Settings", hashMap11, new HashSet(0), new HashSet(0));
            TableInfo read11 = TableInfo.read(supportSQLiteDatabase2, "Settings");
            if (!tableInfo11.equals(read11)) {
                return new RoomOpenHelper.ValidationResult(false, "Settings(com.cellrebel.sdk.networking.beans.response.Settings).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
            }
            HashMap hashMap12 = new HashMap(47);
            hashMap12.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap12.put("pageLoad", new TableInfo.Column("pageLoad", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("fileTransfer", new TableInfo.Column("fileTransfer", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("cdnDownload", new TableInfo.Column("cdnDownload", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("video", new TableInfo.Column("video", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("coverage", new TableInfo.Column("coverage", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("dataUsage", new TableInfo.Column("dataUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("connection", new TableInfo.Column("connection", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("coverageReporting", new TableInfo.Column("coverageReporting", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("game", new TableInfo.Column("game", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("traceroute", new TableInfo.Column("traceroute", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("tti", new TableInfo.Column("tti", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("trafficProfile", new TableInfo.Column("trafficProfile", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("deviceInfo", new TableInfo.Column("deviceInfo", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("loadedLatency", new TableInfo.Column("loadedLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("randomCdnDownload", new TableInfo.Column("randomCdnDownload", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("cellInfoReportingPeriodicity", new TableInfo.Column("cellInfoReportingPeriodicity", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundLaunchTime", new TableInfo.Column("foregroundLaunchTime", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundLaunchTimeWiFi", new TableInfo.Column("foregroundLaunchTimeWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("backgroundLaunchTime", new TableInfo.Column("backgroundLaunchTime", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("metaWorkerLaunchTme", new TableInfo.Column("metaWorkerLaunchTme", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("settingsRefreshTime", new TableInfo.Column("settingsRefreshTime", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundPageLoad", new TableInfo.Column("foregroundPageLoad", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundDeviceInfo", new TableInfo.Column("foregroundDeviceInfo", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundFileTransfer", new TableInfo.Column("foregroundFileTransfer", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundCdnDownload", new TableInfo.Column("foregroundCdnDownload", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundVideo", new TableInfo.Column("foregroundVideo", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTraceroute", new TableInfo.Column("foregroundTraceroute", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundCoverage", new TableInfo.Column("foregroundCoverage", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundGame", new TableInfo.Column("foregroundGame", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundLoadedLatency", new TableInfo.Column("foregroundLoadedLatency", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundDataUsage", new TableInfo.Column("foregroundDataUsage", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundRandomCdnDownload", new TableInfo.Column("foregroundRandomCdnDownload", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTti", new TableInfo.Column("foregroundTti", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTrafficProfile", new TableInfo.Column("foregroundTrafficProfile", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundPageLoadWiFi", new TableInfo.Column("foregroundPageLoadWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundFileTransferWiFi", new TableInfo.Column("foregroundFileTransferWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundCdnDownloadWiFi", new TableInfo.Column("foregroundCdnDownloadWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundVideoWiFi", new TableInfo.Column("foregroundVideoWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTracerouteWiFi", new TableInfo.Column("foregroundTracerouteWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundCoverageWiFi", new TableInfo.Column("foregroundCoverageWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundGameWiFi", new TableInfo.Column("foregroundGameWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundDataUsageWiFi", new TableInfo.Column("foregroundDataUsageWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundLoadedLatencyWiFi", new TableInfo.Column("foregroundLoadedLatencyWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundRandomCdnDownloadWiFi", new TableInfo.Column("foregroundRandomCdnDownloadWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTtiWiFi", new TableInfo.Column("foregroundTtiWiFi", "INTEGER", true, 0, (String) null, 1));
            hashMap12.put("foregroundTrafficProfileWiFi", new TableInfo.Column("foregroundTrafficProfileWiFi", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo12 = new TableInfo("Timestamps", hashMap12, new HashSet(0), new HashSet(0));
            TableInfo read12 = TableInfo.read(supportSQLiteDatabase2, "Timestamps");
            if (!tableInfo12.equals(read12)) {
                return new RoomOpenHelper.ValidationResult(false, "Timestamps(com.cellrebel.sdk.database.Timestamps).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
            }
            HashMap hashMap13 = new HashMap(5);
            hashMap13.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap13.put(CampaignEx.JSON_KEY_TIMESTAMP, new TableInfo.Column(CampaignEx.JSON_KEY_TIMESTAMP, "INTEGER", true, 0, (String) null, 1));
            hashMap13.put(FirebaseAnalytics.Param.SCORE, new TableInfo.Column(FirebaseAnalytics.Param.SCORE, "REAL", true, 0, (String) null, 1));
            hashMap13.put(obj22, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap13.put(obj23, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            TableInfo tableInfo13 = new TableInfo("PageLoadScore", hashMap13, new HashSet(0), new HashSet(0));
            TableInfo read13 = TableInfo.read(supportSQLiteDatabase2, "PageLoadScore");
            if (!tableInfo13.equals(read13)) {
                return new RoomOpenHelper.ValidationResult(false, "PageLoadScore(com.cellrebel.sdk.database.PageLoadScore).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
            }
            HashMap hashMap14 = new HashMap(5);
            hashMap14.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap14.put(CampaignEx.JSON_KEY_TIMESTAMP, new TableInfo.Column(CampaignEx.JSON_KEY_TIMESTAMP, "INTEGER", true, 0, (String) null, 1));
            hashMap14.put(FirebaseAnalytics.Param.SCORE, new TableInfo.Column(FirebaseAnalytics.Param.SCORE, "REAL", true, 0, (String) null, 1));
            hashMap14.put(obj22, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap14.put(obj23, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            TableInfo tableInfo14 = new TableInfo("VideoLoadScore", hashMap14, new HashSet(0), new HashSet(0));
            TableInfo read14 = TableInfo.read(supportSQLiteDatabase2, "VideoLoadScore");
            if (!tableInfo14.equals(read14)) {
                return new RoomOpenHelper.ValidationResult(false, "VideoLoadScore(com.cellrebel.sdk.database.VideoLoadScore).\n Expected:\n" + tableInfo14 + "\n Found:\n" + read14);
            }
            HashMap hashMap15 = new HashMap(108);
            hashMap15.put("pageUrl", new TableInfo.Column("pageUrl", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("pageSize", new TableInfo.Column("pageSize", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("pageLoadTime", new TableInfo.Column("pageLoadTime", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("firstByteTime", new TableInfo.Column("firstByteTime", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("isPageFailsToLoad", new TableInfo.Column("isPageFailsToLoad", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("accessTechStart", new TableInfo.Column("accessTechStart", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("accessTechEnd", new TableInfo.Column("accessTechEnd", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("accessTechNumChanges", new TableInfo.Column("accessTechNumChanges", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("bytesSent", new TableInfo.Column("bytesSent", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("bytesReceived", new TableInfo.Column("bytesReceived", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
            hashMap15.put("mobileClientId", new TableInfo.Column("mobileClientId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("measurementSequenceId", new TableInfo.Column("measurementSequenceId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("clientIp", new TableInfo.Column("clientIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("dateTimeOfMeasurement", new TableInfo.Column("dateTimeOfMeasurement", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj31, new TableInfo.Column("stateDuringMeasurement", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put(obj30, new TableInfo.Column("accessTechnology", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj27, new TableInfo.Column("accessTypeRaw", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj25, new TableInfo.Column("signalStrength", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put(obj3, new TableInfo.Column("interference", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put(obj4, new TableInfo.Column("simMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj5, new TableInfo.Column("simMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj6, new TableInfo.Column("secondarySimMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj7, new TableInfo.Column("secondarySimMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("numberOfSimSlots", new TableInfo.Column("numberOfSimSlots", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("dataSimSlotNumber", new TableInfo.Column("dataSimSlotNumber", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("networkMCC", new TableInfo.Column("networkMCC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("networkMNC", new TableInfo.Column("networkMNC", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj22, new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
            hashMap15.put(obj23, new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
            hashMap15.put("gpsAccuracy", new TableInfo.Column("gpsAccuracy", "REAL", true, 0, (String) null, 1));
            hashMap15.put("cellId", new TableInfo.Column("cellId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("lacId", new TableInfo.Column("lacId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("deviceBrand", new TableInfo.Column("deviceBrand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("deviceModel", new TableInfo.Column("deviceModel", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("deviceVersion", new TableInfo.Column("deviceVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("sdkVersionNumber", new TableInfo.Column("sdkVersionNumber", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("carrierName", new TableInfo.Column("carrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("secondaryCarrierName", new TableInfo.Column("secondaryCarrierName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("os", new TableInfo.Column("os", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("osVersion", new TableInfo.Column("osVersion", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("readableDate", new TableInfo.Column("readableDate", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("physicalCellId", new TableInfo.Column("physicalCellId", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("absoluteRfChannelNumber", new TableInfo.Column("absoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("connectionAbsoluteRfChannelNumber", new TableInfo.Column("connectionAbsoluteRfChannelNumber", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("cellBands", new TableInfo.Column("cellBands", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("channelQualityIndicator", new TableInfo.Column("channelQualityIndicator", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("referenceSignalSignalToNoiseRatio", new TableInfo.Column("referenceSignalSignalToNoiseRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("referenceSignalReceivedPower", new TableInfo.Column("referenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("referenceSignalReceivedQuality", new TableInfo.Column("referenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("csiReferenceSignalReceivedPower", new TableInfo.Column("csiReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("csiReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("csiReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("csiReferenceSignalReceivedQuality", new TableInfo.Column("csiReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("ssReferenceSignalReceivedPower", new TableInfo.Column("ssReferenceSignalReceivedPower", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("ssReferenceSignalReceivedQuality", new TableInfo.Column("ssReferenceSignalReceivedQuality", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("ssReferenceSignalToNoiseAndInterferenceRatio", new TableInfo.Column("ssReferenceSignalToNoiseAndInterferenceRatio", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("timingAdvance", new TableInfo.Column("timingAdvance", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("signalStrengthAsu", new TableInfo.Column("signalStrengthAsu", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("debugString", new TableInfo.Column("debugString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("isDcNrRestricted", new TableInfo.Column("isDcNrRestricted", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isNrAvailable", new TableInfo.Column("isNrAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isEnDcAvailable", new TableInfo.Column("isEnDcAvailable", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("nrState", new TableInfo.Column("nrState", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("nrFrequencyRange", new TableInfo.Column("nrFrequencyRange", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("vopsSupport", new TableInfo.Column("vopsSupport", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("cellBandwidths", new TableInfo.Column("cellBandwidths", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("additionalPlmns", new TableInfo.Column("additionalPlmns", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("altitude", new TableInfo.Column("altitude", "REAL", true, 0, (String) null, 1));
            hashMap15.put("locationSpeed", new TableInfo.Column("locationSpeed", "REAL", false, 0, (String) null, 1));
            hashMap15.put("locationSpeedAccuracy", new TableInfo.Column("locationSpeedAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap15.put("gpsVerticalAccuracy", new TableInfo.Column("gpsVerticalAccuracy", "REAL", false, 0, (String) null, 1));
            hashMap15.put("getRestrictBackgroundStatus", new TableInfo.Column("getRestrictBackgroundStatus", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("cellType", new TableInfo.Column("cellType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("isDefaultNetworkActive", new TableInfo.Column("isDefaultNetworkActive", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isActiveNetworkMetered", new TableInfo.Column("isActiveNetworkMetered", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isOnScreen", new TableInfo.Column("isOnScreen", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isRoaming", new TableInfo.Column("isRoaming", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("locationAge", new TableInfo.Column("locationAge", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("accessNetworkTechnologyRaw", new TableInfo.Column("accessNetworkTechnologyRaw", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put(obj24, new TableInfo.Column("anonymize", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put(obj26, new TableInfo.Column("sdkOrigin", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj29, new TableInfo.Column("isRooted", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isConnectedToVpn", new TableInfo.Column("isConnectedToVpn", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("linkDownstreamBandwidth", new TableInfo.Column("linkDownstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("linkUpstreamBandwidth", new TableInfo.Column("linkUpstreamBandwidth", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("latencyType", new TableInfo.Column("latencyType", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("serverIp", new TableInfo.Column("serverIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("privateIp", new TableInfo.Column("privateIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("gatewayIp", new TableInfo.Column("gatewayIp", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("locationPermissionState", new TableInfo.Column("locationPermissionState", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("serviceStateStatus", new TableInfo.Column("serviceStateStatus", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isNrCellSeen", new TableInfo.Column("isNrCellSeen", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("isReadPhoneStatePermissionGranted", new TableInfo.Column("isReadPhoneStatePermissionGranted", "INTEGER", false, 0, (String) null, 1));
            hashMap15.put("appVersionName", new TableInfo.Column("appVersionName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("appVersionCode", new TableInfo.Column("appVersionCode", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("appLastUpdateTime", new TableInfo.Column("appLastUpdateTime", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("duplexModeState", new TableInfo.Column("duplexModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("dozeModeState", new TableInfo.Column("dozeModeState", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("callState", new TableInfo.Column("callState", "INTEGER", true, 0, (String) null, 1));
            hashMap15.put("buildDevice", new TableInfo.Column("buildDevice", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("buildHardware", new TableInfo.Column("buildHardware", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("buildProduct", new TableInfo.Column("buildProduct", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put("appId", new TableInfo.Column("appId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
            hashMap15.put(obj10, new TableInfo.Column("isSending", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo15 = new TableInfo("PageLoadMetric", hashMap15, new HashSet(0), new HashSet(0));
            TableInfo read15 = TableInfo.read(supportSQLiteDatabase2, "PageLoadMetric");
            if (!tableInfo15.equals(read15)) {
                return new RoomOpenHelper.ValidationResult(false, "PageLoadMetric(com.cellrebel.sdk.networking.beans.request.PageLoadMetric).\n Expected:\n" + tableInfo15 + "\n Found:\n" + read15);
            }
            RoomOpenHelper.ValidationResult a2 = a(supportSQLiteDatabase);
            return !a2.isValid ? a2 : new RoomOpenHelper.ValidationResult(true, (String) null);
        }
    }

    public CellInfoDAO a() {
        CellInfoDAO cellInfoDAO;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            if (this.p == null) {
                this.p = new CellInfoDAO_Impl(this);
            }
            cellInfoDAO = this.p;
        }
        return cellInfoDAO;
    }

    public ConnectionMetricDAO b() {
        ConnectionMetricDAO connectionMetricDAO;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new ConnectionMetricDAO_Impl(this);
            }
            connectionMetricDAO = this.s;
        }
        return connectionMetricDAO;
    }

    public ConnectionTimeActiveDAO c() {
        ConnectionTimeActiveDAO connectionTimeActiveDAO;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            if (this.w == null) {
                this.w = new ConnectionTimeActiveDAO_Impl(this);
            }
            connectionTimeActiveDAO = this.w;
        }
        return connectionTimeActiveDAO;
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ConnectionTimePassive`");
            writableDatabase.execSQL("DELETE FROM `ConnectionTimeActive`");
            writableDatabase.execSQL("DELETE FROM `WifiInfoMetric`");
            writableDatabase.execSQL("DELETE FROM `DataUsageMetric`");
            writableDatabase.execSQL("DELETE FROM `FileTransferServer`");
            writableDatabase.execSQL("DELETE FROM `FileTransferMetric`");
            writableDatabase.execSQL("DELETE FROM `ConnectionMetric`");
            writableDatabase.execSQL("DELETE FROM `CoverageMetric`");
            writableDatabase.execSQL("DELETE FROM `VideoMetric`");
            writableDatabase.execSQL("DELETE FROM `Preferences`");
            writableDatabase.execSQL("DELETE FROM `Settings`");
            writableDatabase.execSQL("DELETE FROM `Timestamps`");
            writableDatabase.execSQL("DELETE FROM `PageLoadScore`");
            writableDatabase.execSQL("DELETE FROM `VideoLoadScore`");
            writableDatabase.execSQL("DELETE FROM `PageLoadMetric`");
            writableDatabase.execSQL("DELETE FROM `Game`");
            writableDatabase.execSQL("DELETE FROM `GameInfoMetric`");
            writableDatabase.execSQL("DELETE FROM `CellInfoMetric`");
            writableDatabase.execSQL("DELETE FROM `GameLatency`");
            writableDatabase.execSQL("DELETE FROM `DeviceInfoMetric`");
            writableDatabase.execSQL("DELETE FROM `VoiceCallMetric`");
            writableDatabase.execSQL("DELETE FROM `TraceRouteMetric`");
            writableDatabase.execSQL("DELETE FROM `TimeToInteractionMetric`");
            writableDatabase.execSQL("DELETE FROM `TrafficProfileMetric`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ConnectionTimePassive", "ConnectionTimeActive", "WifiInfoMetric", "DataUsageMetric", "FileTransferServer", "FileTransferMetric", "ConnectionMetric", "CoverageMetric", "VideoMetric", "Preferences", "Settings", "Timestamps", "PageLoadScore", "VideoLoadScore", "PageLoadMetric", "Game", "GameInfoMetric", "CellInfoMetric", "GameLatency", "DeviceInfoMetric", "VoiceCallMetric", "TraceRouteMetric", "TimeToInteractionMetric", "TrafficProfileMetric");
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(73), "ebf5efac687f7a93a2dc77e398dd200c", "245892ebc7ce9cbba1163f3dc9bb546a")).build());
    }

    public ConnectionTimePassiveDAO d() {
        ConnectionTimePassiveDAO connectionTimePassiveDAO;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            if (this.x == null) {
                this.x = new ConnectionTimePassiveDAO_Impl(this);
            }
            connectionTimePassiveDAO = this.x;
        }
        return connectionTimePassiveDAO;
    }

    public CoverageMetricDAO e() {
        CoverageMetricDAO coverageMetricDAO;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = new CoverageMetricDAO_Impl(this);
            }
            coverageMetricDAO = this.q;
        }
        return coverageMetricDAO;
    }

    public DataUsageMetricDAO f() {
        DataUsageMetricDAO dataUsageMetricDAO;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new DataUsageMetricDAO_Impl(this);
            }
            dataUsageMetricDAO = this.v;
        }
        return dataUsageMetricDAO;
    }

    public DeviceInfoDAO g() {
        DeviceInfoDAO deviceInfoDAO;
        if (this.z != null) {
            return this.z;
        }
        synchronized (this) {
            if (this.z == null) {
                this.z = new DeviceInfoDAO_Impl(this);
            }
            deviceInfoDAO = this.z;
        }
        return deviceInfoDAO;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(VideoMetricDAO.class, VideoMetricDAO_Impl.c());
        hashMap.put(VideoLoadScoreDAO.class, VideoLoadScoreDAO_Impl.a());
        hashMap.put(TtiDAO.class, TtiDAO_Impl.c());
        hashMap.put(TrafficProfileDAO.class, TrafficProfileDAO_Impl.c());
        hashMap.put(PreferencesDAO.class, PreferencesDAO_Impl.c());
        hashMap.put(SettingsDAO.class, SettingsDAO_Impl.c());
        hashMap.put(TimestampsDAO.class, TimestampsDAO_Impl.b());
        hashMap.put(PageLoadScoreDAO.class, PageLoadScoreDAO_Impl.a());
        hashMap.put(PageLoadedMetricDAO.class, PageLoadedMetricDAO_Impl.c());
        hashMap.put(GameListDAO.class, GameListDAO_Impl.b());
        hashMap.put(GameMetricDAO.class, GameMetricDAO_Impl.a());
        hashMap.put(CellInfoDAO.class, CellInfoDAO_Impl.b());
        hashMap.put(CoverageMetricDAO.class, CoverageMetricDAO_Impl.c());
        hashMap.put(WifiInfoMetricDAO.class, WifiInfoMetricDAO_Impl.c());
        hashMap.put(ConnectionMetricDAO.class, ConnectionMetricDAO_Impl.b());
        hashMap.put(FileTransferDAO.class, FileTransferDAO_Impl.a());
        hashMap.put(FileTransferMetricDAO.class, FileTransferMetricDAO_Impl.c());
        hashMap.put(DataUsageMetricDAO.class, DataUsageMetricDAO_Impl.c());
        hashMap.put(ConnectionTimeActiveDAO.class, ConnectionTimeActiveDAO_Impl.b());
        hashMap.put(ConnectionTimePassiveDAO.class, ConnectionTimePassiveDAO_Impl.b());
        hashMap.put(GameLatencyDAO.class, GameLatencyDAO_Impl.c());
        hashMap.put(DeviceInfoDAO.class, DeviceInfoDAO_Impl.c());
        hashMap.put(VoiceCallDAO.class, VoiceCallDAO_Impl.c());
        hashMap.put(TraceRouteDAO.class, TraceRouteDAO_Impl.c());
        return hashMap;
    }

    public FileTransferDAO h() {
        FileTransferDAO fileTransferDAO;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new FileTransferDAO_Impl(this);
            }
            fileTransferDAO = this.t;
        }
        return fileTransferDAO;
    }

    public FileTransferMetricDAO i() {
        FileTransferMetricDAO fileTransferMetricDAO;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new FileTransferMetricDAO_Impl(this);
            }
            fileTransferMetricDAO = this.u;
        }
        return fileTransferMetricDAO;
    }

    public GameMetricDAO j() {
        GameMetricDAO gameMetricDAO;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            if (this.o == null) {
                this.o = new GameMetricDAO_Impl(this);
            }
            gameMetricDAO = this.o;
        }
        return gameMetricDAO;
    }

    public GameLatencyDAO k() {
        GameLatencyDAO gameLatencyDAO;
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            if (this.y == null) {
                this.y = new GameLatencyDAO_Impl(this);
            }
            gameLatencyDAO = this.y;
        }
        return gameLatencyDAO;
    }

    public GameListDAO l() {
        GameListDAO gameListDAO;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            if (this.n == null) {
                this.n = new GameListDAO_Impl(this);
            }
            gameListDAO = this.n;
        }
        return gameListDAO;
    }

    public PageLoadedMetricDAO m() {
        PageLoadedMetricDAO pageLoadedMetricDAO;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new PageLoadedMetricDAO_Impl(this);
            }
            pageLoadedMetricDAO = this.m;
        }
        return pageLoadedMetricDAO;
    }

    public PageLoadScoreDAO n() {
        PageLoadScoreDAO pageLoadScoreDAO;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            if (this.l == null) {
                this.l = new PageLoadScoreDAO_Impl(this);
            }
            pageLoadScoreDAO = this.l;
        }
        return pageLoadScoreDAO;
    }

    public PreferencesDAO o() {
        PreferencesDAO preferencesDAO;
        if (this.i != null) {
            return this.i;
        }
        synchronized (this) {
            if (this.i == null) {
                this.i = new PreferencesDAO_Impl(this);
            }
            preferencesDAO = this.i;
        }
        return preferencesDAO;
    }

    public SettingsDAO p() {
        SettingsDAO settingsDAO;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new SettingsDAO_Impl(this);
            }
            settingsDAO = this.j;
        }
        return settingsDAO;
    }

    public TimestampsDAO q() {
        TimestampsDAO timestampsDAO;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            if (this.k == null) {
                this.k = new TimestampsDAO_Impl(this);
            }
            timestampsDAO = this.k;
        }
        return timestampsDAO;
    }

    public TraceRouteDAO r() {
        TraceRouteDAO traceRouteDAO;
        if (this.B != null) {
            return this.B;
        }
        synchronized (this) {
            if (this.B == null) {
                this.B = new TraceRouteDAO_Impl(this);
            }
            traceRouteDAO = this.B;
        }
        return traceRouteDAO;
    }

    public TrafficProfileDAO s() {
        TrafficProfileDAO trafficProfileDAO;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new TrafficProfileDAO_Impl(this);
            }
            trafficProfileDAO = this.h;
        }
        return trafficProfileDAO;
    }

    public TtiDAO t() {
        TtiDAO ttiDAO;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new TtiDAO_Impl(this);
            }
            ttiDAO = this.g;
        }
        return ttiDAO;
    }

    public VideoMetricDAO u() {
        VideoMetricDAO videoMetricDAO;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new VideoMetricDAO_Impl(this);
            }
            videoMetricDAO = this.e;
        }
        return videoMetricDAO;
    }

    public VideoLoadScoreDAO v() {
        VideoLoadScoreDAO videoLoadScoreDAO;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new VideoLoadScoreDAO_Impl(this);
            }
            videoLoadScoreDAO = this.f;
        }
        return videoLoadScoreDAO;
    }

    public VoiceCallDAO w() {
        VoiceCallDAO voiceCallDAO;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new VoiceCallDAO_Impl(this);
            }
            voiceCallDAO = this.A;
        }
        return voiceCallDAO;
    }

    public WifiInfoMetricDAO x() {
        WifiInfoMetricDAO wifiInfoMetricDAO;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new WifiInfoMetricDAO_Impl(this);
            }
            wifiInfoMetricDAO = this.r;
        }
        return wifiInfoMetricDAO;
    }
}
