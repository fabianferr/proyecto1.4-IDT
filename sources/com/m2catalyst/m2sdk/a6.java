package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.external.LoggingLevel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SDKPreferences.kt */
public enum a6 {
    API_KEY("apikey", ""),
    COMPANY_ID("companyId", 1),
    M2_UUID("m2Uuid", ""),
    DEVICE_ID("deviceId", -3),
    M2CONFIG_JSON("m2configJSON", ""),
    DB_MIGRATION_V8_V9("dbMigrationV8V9", r11),
    LAST_TIME_DATA_TRANSMITTED("lasttimeDataTransmitted", 0L),
    NEXT_TIME_DATA_TRANSMISSION("nextTimeDataTransmission", 0L),
    LAST_TIME_MONITOR_STATS_TRANSMITTED("lastTimeMonitorStatsTransmitted", 0L),
    NEXT_TIME_MONITOR_STATS_TRANSMISSION("nextTimeMonitorStatsTransmission", 0L),
    LAST_TIME_VERIFY_API_CLIENT("lastTimeVerifyApiClient", 0L),
    LAST_TIME_WIFI_COLLECTED("lastTimeWifiCollectecAuto", 0L),
    CROWDSOURCE_SHARING_ENABLED("crowdsourceSharingEnable", r13),
    REMOTE_SDK_SPEED_TEST_CONFIGURATION("remoteSdkNDTConfiguration", ""),
    REMOTE_SDK_DATA_ACCESS_CONFIGURATION("remoteSdkDataAccessCnfiguration", ""),
    REMOTE_SDK_GENERAL_CONFIGURATION("remoteSdkGeneralConfiguration", ""),
    REMOTE_SDK_LOCATION_CONFIGURATION("remoteSdkLocationConfiguration", ""),
    REMOTE_SDK_MNSI_CONFIGURATION("remoteSdkMNSIConfiguration", ""),
    REMOTE_SDK_INGESTION_CONFIGURATION("remoteSdkIngestionConfiguration", ""),
    SDK_PERSISTENT_DATA_COLLECTION_ON("sdkPersistentDataCollectionOn", r11),
    SDK_CRASH_RECORDING("sdkCrashRecording", r13),
    SDK_LOGGING_LEVEL("sdkLoggingLevel", Integer.valueOf(LoggingLevel.INFO.getId())),
    SDK_SUPER_LOGGING_LEVEL("sdkSuperLoggingLevel", -1),
    SDK_INITIALIZATION_ALARM_TRIES("initializationAlarmTries", 0),
    NEXT_TIME_SDK_INITIALIZATION_ALARM("nextTimeInitializationAlarm", 0),
    M2_SDK_CONFIG("m2SDKConfig", ""),
    LAST_TIME_SYNCED("lastTimeSynced", 0L),
    LOCAL_SDK_PACKAGE_NAME("packageName", ""),
    LOCAL_SDK_APP_NAME("appName", ""),
    SDK_UPTIME("sdkUptime", 0L),
    PERMISSION_MONITOR_MODE("permissionMonitorMode", r11),
    PERMISSION_READ_PHONE_STATE_GRANTED("permissionReadPhoneState", r11),
    PERMISSION_FINE_LOCATION_GRANTED("permissionFineLocationGranted", r11),
    PERMISSION_COARSE_LOCATION_GRANTED("permissionCoarseLocationGranted", r11),
    PERMISSION_BACKGROUND_LOCATION_GRANTED("permissionBackgroundLocationGranted", r11),
    PERMISSION_PACKAGE_USAGE_STATS_GRANTED("permissionPackageUsageStatsGranted", r11);
    
    public final String a;
    public final Object b;

    /* access modifiers changed from: public */
    a6(String str, Object obj) {
        this.a = str;
        this.b = obj;
    }

    public final <T> T a() {
        T t = this.b;
        Intrinsics.checkNotNull(t);
        return t;
    }

    public final Object b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }
}
