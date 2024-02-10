package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.m2catalyst.m2sdk.c;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

public final class MonitoringStatsMessage extends Message<MonitoringStatsMessage, Builder> {
    public static final ProtoAdapter<MonitoringStatsMessage> ADAPTER = new ProtoAdapter_MonitoringStatsMessage();
    public static final Integer DEFAULT_APPDATAUSAGEEVENTS_COLLECTED = 0;
    public static final Integer DEFAULT_APPSESSIONS_COLLECTED = 0;
    public static final Long DEFAULT_APP_MEMORY = 0L;
    public static final Integer DEFAULT_COUNT_INSTALLED_APPS = 0;
    public static final Long DEFAULT_DATABASE_SIZE = 0L;
    public static final Integer DEFAULT_INDIVIDUAL_PERMISSIONS_ACCEPTED = 0;
    public static final Integer DEFAULT_INITIALIZE = 0;
    public static final Integer DEFAULT_INITIALIZE_CONTROLLERSETUP = 0;
    public static final Integer DEFAULT_INITIALIZE_RESETCONTROLLER = 0;
    public static final Integer DEFAULT_INITIALIZE_RESETCONTROLLERFAILED = 0;
    public static final Integer DEFAULT_INITIALIZE_SETUPCONTROLLER = 0;
    public static final Integer DEFAULT_INITIALSETUP_COMPLETE = 0;
    public static final Integer DEFAULT_INITIALSETUP_RUN = 0;
    public static final Integer DEFAULT_INITIALSETUP_START = 0;
    public static final Integer DEFAULT_INITIALSETUP_STORAGEFULL = 0;
    public static final Integer DEFAULT_IS_RUNNING = 0;
    public static final Integer DEFAULT_IS_STORAGE_FULL = 0;
    public static final Integer DEFAULT_LOCATION_COLLECTED = 0;
    public static final Integer DEFAULT_LOGGER_TOTALERRORCOUNT = 0;
    public static final Integer DEFAULT_MNSI_COLLECTED = 0;
    public static final String DEFAULT_MOST_FOREGROUND_APP_BY_PUS_PACKAGE_NAME = "";
    public static final Integer DEFAULT_MOST_FOREGROUND_APP_BY_PUS_TIME = 0;
    public static final String DEFAULT_MOST_FOREGROUND_APP_BY_SDK_PACKAGE_NAME = "";
    public static final Integer DEFAULT_MOST_FOREGROUND_APP_BY_SDK_TIME = 0;
    public static final Integer DEFAULT_NDT_CHECKFORTEST = 0;
    public static final Integer DEFAULT_NDT_RUNTEST = 0;
    public static final Integer DEFAULT_NDT_TESTCOMPLETED = 0;
    public static final Integer DEFAULT_PERMISSIONS_ACCEPTED = 0;
    public static final Integer DEFAULT_PROCESS_RUN_TIME = 0;
    public static final Integer DEFAULT_RECEIVER_BOOTCOMPLETE = 0;
    public static final Integer DEFAULT_RECEIVER_CONNECTIONCHANGED = 0;
    public static final Integer DEFAULT_RECEIVER_ONRECEIVE = 0;
    public static final Integer DEFAULT_RECEIVER_PACKAGECHANGED = 0;
    public static final String DEFAULT_REPORT_DATE = "";
    public static final Integer DEFAULT_SERVICE_MONITOR = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_DATACOLLECTIONCYCLES = 0;
    public static final Long DEFAULT_SERVICE_MONITORING_DATACOLLECTIONTIME = 0L;
    public static final Integer DEFAULT_SERVICE_MONITORING_INITIALIZE = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_APPDATAUSAGEEVENTS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_APPSESSIONS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_APPUSAGEEVENTSRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_BATTERYLOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_LOCATIONLOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_LOGDATARECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_MOBILEINFOLOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_MOBILESIGNALINFOLOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_NOSIGNALRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_SYSTEMCPULOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_PURGEDATABASE_WIFIINFOLOGRECORDS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_UPDATEDATABASE = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_UPDATEDATABASE_LOGDATA_RECORDINSERTATTEMPTS = 0;
    public static final Integer DEFAULT_SERVICE_MONITORING_UPDATEDATABASE_LOGDATA_RECORDINSERTSFAILED = 0;
    public static final Long DEFAULT_SERVICE_MONITORING_UPTIME = 0L;
    public static final Integer DEFAULT_SERVICE_MONITORING_VALIDITYCHECKFAILURE = 0;
    public static final Integer DEFAULT_SERVICE_ONCREATE = 0;
    public static final Integer DEFAULT_SERVICE_ONDESTROY = 0;
    public static final Integer DEFAULT_SERVICE_ONLOWMEMORY = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPDATALOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPDATALOGSPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPDATALOGSPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPLICATIONEVENTSPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPLICATIONEVENTSPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPSESSIONS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPUSAGEEVENTSPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDAPPUSAGEEVENTSPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDBATTERYLOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDBATTERYLOGSACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDBATTERYLOGSPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDBATTERYLOGSPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDCPULOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDCPULOGSACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDDATAUSAGEEVENTS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOCATIONLOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOCATIONPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOCATIONPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOCATIONPACKETSENT = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDLOGSACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDMOBILELOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDNETWORKPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDNETWORKPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDNETWORKPACKETSENT = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDNOSIGNALLOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDSYSTEMCPULOGPACKET = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDSYSTEMCPULOGPACKETACCEPTED = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDSYSTEMCPULOGS = 0;
    public static final Integer DEFAULT_SERVICE_TRANSMITDATA_SUBMITTEDWIFILOGS = 0;
    public static final Integer DEFAULT_START = 0;
    public static final Integer DEFAULT_STARTMONITORING = 0;
    public static final Integer DEFAULT_STARTMONITORING_STARTSERVICE = 0;
    public static final Integer DEFAULT_STARTMONITORING_STORAGEFULL = 0;
    public static final Integer DEFAULT_STATUS_INDEX = 0;
    public static final Integer DEFAULT_STOP = 0;
    public static final Integer DEFAULT_STOPMONITORING = 0;
    public static final Integer DEFAULT_SYSTEMBATTERYINFO_COLLECTED = 0;
    public static final Long DEFAULT_SYSTEM_AVAILABLE_INTERNAL_STORAGE = 0L;
    public static final Long DEFAULT_SYSTEM_AVAILABLE_MEMORY = 0L;
    public static final Long DEFAULT_SYSTEM_CLOCK_ELAPSED_TIME = 0L;
    public static final Long DEFAULT_SYSTEM_CLOCK_UP_TIME = 0L;
    public static final Long DEFAULT_SYSTEM_CURRENT_MEMORY = 0L;
    public static final Long DEFAULT_SYSTEM_TOTAL_INTERNAL_STORAGE = 0L;
    public static final Long DEFAULT_SYSTEM_UPTIME = 0L;
    public static final Integer DEFAULT_TIMECHANGEBACK = 0;
    public static final Integer DEFAULT_TIMECHANGEFORWARD = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 112)
    public final Integer appDataUsageEvents_collected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 111)
    public final Integer appSessions_collected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 28)
    public final Long app_memory;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer count_installed_apps;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 27)
    public final Long database_size;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 97)
    public final Integer individual_permissions_accepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 69)
    public final Integer initialSetup_complete;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 67)
    public final Integer initialSetup_run;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 66)
    public final Integer initialSetup_start;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 68)
    public final Integer initialSetup_storageFull;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 59)
    public final Integer initialize;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 61)
    public final Integer initialize_controllerSetup;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 62)
    public final Integer initialize_resetController;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 63)
    public final Integer initialize_resetControllerFailed;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 60)
    public final Integer initialize_setupController;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 25)
    public final Integer is_running;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer is_storage_full;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 109)
    public final Integer location_collected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 43)
    public final Integer logger_totalErrorCount;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 108)
    public final Integer mnsi_collected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 76)
    public final String most_foreground_app_by_pus_package_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 23)
    public final Integer most_foreground_app_by_pus_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 77)
    public final String most_foreground_app_by_sdk_package_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 24)
    public final Integer most_foreground_app_by_sdk_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 125)
    public final Integer ndt_checkForTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 126)
    public final Integer ndt_runTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 127)
    public final Integer ndt_testCompleted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 88)
    public final Integer permissions_accepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 70)
    public final Integer process_run_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 46)
    public final Integer receiver_bootComplete;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 47)
    public final Integer receiver_connectionChanged;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 44)
    public final Integer receiver_onReceive;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 45)
    public final Integer receiver_packageChanged;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 71)
    public final String report_date;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 52)
    public final Integer service_monitor;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 34)
    public final Integer service_monitoring_dataCollectionCycles;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 35)
    public final Long service_monitoring_dataCollectionTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 57)
    public final Integer service_monitoring_initialize;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 79)
    public final Integer service_monitoring_purgeDatabase;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 99)
    public final Integer service_monitoring_purgeDatabase_appDataUsageEvents;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 98)
    public final Integer service_monitoring_purgeDatabase_appSessions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 81)
    public final Integer service_monitoring_purgeDatabase_appUsageEventsRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 83)
    public final Integer service_monitoring_purgeDatabase_batteryLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 89)
    public final Integer service_monitoring_purgeDatabase_locationLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 80)
    public final Integer service_monitoring_purgeDatabase_logDataRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 86)
    public final Integer service_monitoring_purgeDatabase_mobileInfoLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 85)
    public final Integer service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 113)
    public final Integer service_monitoring_purgeDatabase_noSignalRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 82)
    public final Integer service_monitoring_purgeDatabase_systemCpuLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 84)
    public final Integer service_monitoring_purgeDatabase_wifiInfoLogRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 78)
    public final Long service_monitoring_upTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 36)
    public final Integer service_monitoring_updateDatabase;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 37)
    public final Integer service_monitoring_updateDatabase_logData_recordInsertAttempts;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 38)
    public final Integer service_monitoring_updateDatabase_logData_recordInsertsFailed;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 58)
    public final Integer service_monitoring_validityCheckFailure;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 54)
    public final Integer service_onCreate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 56)
    public final Integer service_onDestroy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 55)
    public final Integer service_onLowMemory;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 53)
    public final Integer service_transmitData;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 120)
    public final Integer service_transmitData_submittedAppDataLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 121)
    public final Integer service_transmitData_submittedAppDataLogsPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 122)
    public final Integer service_transmitData_submittedAppDataLogsPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 104)
    public final Integer service_transmitData_submittedAppSessions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 123)
    public final Integer service_transmitData_submittedAppUsageEventsPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 124)
    public final Integer service_transmitData_submittedAppUsageEventsPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 106)
    public final Integer service_transmitData_submittedApplicationEventsPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 107)
    public final Integer service_transmitData_submittedApplicationEventsPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 41)
    public final Integer service_transmitData_submittedBatteryLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 42)
    public final Integer service_transmitData_submittedBatteryLogsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 118)
    public final Integer service_transmitData_submittedBatteryLogsPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 119)
    public final Integer service_transmitData_submittedBatteryLogsPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 73)
    public final Integer service_transmitData_submittedCPULogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 74)
    public final Integer service_transmitData_submittedCPULogsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 105)
    public final Integer service_transmitData_submittedDataUsageEvents;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 94)
    public final Integer service_transmitData_submittedLocationLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 103)
    public final Integer service_transmitData_submittedLocationPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 96)
    public final Integer service_transmitData_submittedLocationPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 95)
    public final Integer service_transmitData_submittedLocationPacketSent;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 39)
    public final Integer service_transmitData_submittedLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 40)
    public final Integer service_transmitData_submittedLogsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 90)
    public final Integer service_transmitData_submittedMobileLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 102)
    public final Integer service_transmitData_submittedNetworkPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 93)
    public final Integer service_transmitData_submittedNetworkPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 92)
    public final Integer service_transmitData_submittedNetworkPacketSent;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 114)
    public final Integer service_transmitData_submittedNoSignalLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 116)
    public final Integer service_transmitData_submittedSystemCPULogPacket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 117)
    public final Integer service_transmitData_submittedSystemCPULogPacketAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 115)
    public final Integer service_transmitData_submittedSystemCPULogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 91)
    public final Integer service_transmitData_submittedWifiLogs;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 64)
    public final Integer start;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 48)
    public final Integer startMonitoring;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 50)
    public final Integer startMonitoring_startService;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 49)
    public final Integer startMonitoring_storageFull;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer status_index;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 65)
    public final Integer stop;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 51)
    public final Integer stopMonitoring;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 110)
    public final Integer systemBatteryInfo_collected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 75)
    public final Long system_available_internal_storage;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 30)
    public final Long system_available_memory;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 22)
    public final Long system_clock_elapsed_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long system_clock_up_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 29)
    public final Long system_current_memory;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 31)
    public final Long system_total_internal_storage;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 33)
    public final Long system_uptime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 72)
    public final Integer timeChangeBack;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 87)
    public final Integer timeChangeForward;

    public static final class Builder extends Message.Builder<MonitoringStatsMessage, Builder> {
        public Integer appDataUsageEvents_collected;
        public Integer appSessions_collected;
        public Long app_memory;
        public Integer count_installed_apps;
        public Long database_size;
        public Integer individual_permissions_accepted;
        public Integer initialSetup_complete;
        public Integer initialSetup_run;
        public Integer initialSetup_start;
        public Integer initialSetup_storageFull;
        public Integer initialize;
        public Integer initialize_controllerSetup;
        public Integer initialize_resetController;
        public Integer initialize_resetControllerFailed;
        public Integer initialize_setupController;
        public Integer is_running;
        public Integer is_storage_full;
        public Integer location_collected;
        public Integer logger_totalErrorCount;
        public Integer mnsi_collected;
        public String most_foreground_app_by_pus_package_name;
        public Integer most_foreground_app_by_pus_time;
        public String most_foreground_app_by_sdk_package_name;
        public Integer most_foreground_app_by_sdk_time;
        public Integer ndt_checkForTest;
        public Integer ndt_runTest;
        public Integer ndt_testCompleted;
        public Integer permissions_accepted;
        public Integer process_run_time;
        public Integer receiver_bootComplete;
        public Integer receiver_connectionChanged;
        public Integer receiver_onReceive;
        public Integer receiver_packageChanged;
        public String report_date;
        public Integer service_monitor;
        public Integer service_monitoring_dataCollectionCycles;
        public Long service_monitoring_dataCollectionTime;
        public Integer service_monitoring_initialize;
        public Integer service_monitoring_purgeDatabase;
        public Integer service_monitoring_purgeDatabase_appDataUsageEvents;
        public Integer service_monitoring_purgeDatabase_appSessions;
        public Integer service_monitoring_purgeDatabase_appUsageEventsRecords;
        public Integer service_monitoring_purgeDatabase_batteryLogRecords;
        public Integer service_monitoring_purgeDatabase_locationLogRecords;
        public Integer service_monitoring_purgeDatabase_logDataRecords;
        public Integer service_monitoring_purgeDatabase_mobileInfoLogRecords;
        public Integer service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
        public Integer service_monitoring_purgeDatabase_noSignalRecords;
        public Integer service_monitoring_purgeDatabase_systemCpuLogRecords;
        public Integer service_monitoring_purgeDatabase_wifiInfoLogRecords;
        public Long service_monitoring_upTime;
        public Integer service_monitoring_updateDatabase;
        public Integer service_monitoring_updateDatabase_logData_recordInsertAttempts;
        public Integer service_monitoring_updateDatabase_logData_recordInsertsFailed;
        public Integer service_monitoring_validityCheckFailure;
        public Integer service_onCreate;
        public Integer service_onDestroy;
        public Integer service_onLowMemory;
        public Integer service_transmitData;
        public Integer service_transmitData_submittedAppDataLogs;
        public Integer service_transmitData_submittedAppDataLogsPacket;
        public Integer service_transmitData_submittedAppDataLogsPacketAccepted;
        public Integer service_transmitData_submittedAppSessions;
        public Integer service_transmitData_submittedAppUsageEventsPacket;
        public Integer service_transmitData_submittedAppUsageEventsPacketAccepted;
        public Integer service_transmitData_submittedApplicationEventsPacket;
        public Integer service_transmitData_submittedApplicationEventsPacketAccepted;
        public Integer service_transmitData_submittedBatteryLogs;
        public Integer service_transmitData_submittedBatteryLogsAccepted;
        public Integer service_transmitData_submittedBatteryLogsPacket;
        public Integer service_transmitData_submittedBatteryLogsPacketAccepted;
        public Integer service_transmitData_submittedCPULogs;
        public Integer service_transmitData_submittedCPULogsAccepted;
        public Integer service_transmitData_submittedDataUsageEvents;
        public Integer service_transmitData_submittedLocationLogs;
        public Integer service_transmitData_submittedLocationPacket;
        public Integer service_transmitData_submittedLocationPacketAccepted;
        public Integer service_transmitData_submittedLocationPacketSent;
        public Integer service_transmitData_submittedLogs;
        public Integer service_transmitData_submittedLogsAccepted;
        public Integer service_transmitData_submittedMobileLogs;
        public Integer service_transmitData_submittedNetworkPacket;
        public Integer service_transmitData_submittedNetworkPacketAccepted;
        public Integer service_transmitData_submittedNetworkPacketSent;
        public Integer service_transmitData_submittedNoSignalLogs;
        public Integer service_transmitData_submittedSystemCPULogPacket;
        public Integer service_transmitData_submittedSystemCPULogPacketAccepted;
        public Integer service_transmitData_submittedSystemCPULogs;
        public Integer service_transmitData_submittedWifiLogs;
        public Integer start;
        public Integer startMonitoring;
        public Integer startMonitoring_startService;
        public Integer startMonitoring_storageFull;
        public Integer status_index;
        public Integer stop;
        public Integer stopMonitoring;
        public Integer systemBatteryInfo_collected;
        public Long system_available_internal_storage;
        public Long system_available_memory;
        public Long system_clock_elapsed_time;
        public Long system_clock_up_time;
        public Long system_current_memory;
        public Long system_total_internal_storage;
        public Long system_uptime;
        public Integer timeChangeBack;
        public Integer timeChangeForward;

        public Builder appDataUsageEvents_collected(Integer num) {
            this.appDataUsageEvents_collected = num;
            return this;
        }

        public Builder appSessions_collected(Integer num) {
            this.appSessions_collected = num;
            return this;
        }

        public Builder app_memory(Long l) {
            this.app_memory = l;
            return this;
        }

        public Builder count_installed_apps(Integer num) {
            this.count_installed_apps = num;
            return this;
        }

        public Builder database_size(Long l) {
            this.database_size = l;
            return this;
        }

        public Builder individual_permissions_accepted(Integer num) {
            this.individual_permissions_accepted = num;
            return this;
        }

        public Builder initialSetup_complete(Integer num) {
            this.initialSetup_complete = num;
            return this;
        }

        public Builder initialSetup_run(Integer num) {
            this.initialSetup_run = num;
            return this;
        }

        public Builder initialSetup_start(Integer num) {
            this.initialSetup_start = num;
            return this;
        }

        public Builder initialSetup_storageFull(Integer num) {
            this.initialSetup_storageFull = num;
            return this;
        }

        public Builder initialize(Integer num) {
            this.initialize = num;
            return this;
        }

        public Builder initialize_controllerSetup(Integer num) {
            this.initialize_controllerSetup = num;
            return this;
        }

        public Builder initialize_resetController(Integer num) {
            this.initialize_resetController = num;
            return this;
        }

        public Builder initialize_resetControllerFailed(Integer num) {
            this.initialize_resetControllerFailed = num;
            return this;
        }

        public Builder initialize_setupController(Integer num) {
            this.initialize_setupController = num;
            return this;
        }

        public Builder is_running(Integer num) {
            this.is_running = num;
            return this;
        }

        public Builder is_storage_full(Integer num) {
            this.is_storage_full = num;
            return this;
        }

        public Builder location_collected(Integer num) {
            this.location_collected = num;
            return this;
        }

        public Builder logger_totalErrorCount(Integer num) {
            this.logger_totalErrorCount = num;
            return this;
        }

        public Builder mnsi_collected(Integer num) {
            this.mnsi_collected = num;
            return this;
        }

        public Builder most_foreground_app_by_pus_package_name(String str) {
            this.most_foreground_app_by_pus_package_name = str;
            return this;
        }

        public Builder most_foreground_app_by_pus_time(Integer num) {
            this.most_foreground_app_by_pus_time = num;
            return this;
        }

        public Builder most_foreground_app_by_sdk_package_name(String str) {
            this.most_foreground_app_by_sdk_package_name = str;
            return this;
        }

        public Builder most_foreground_app_by_sdk_time(Integer num) {
            this.most_foreground_app_by_sdk_time = num;
            return this;
        }

        public Builder ndt_checkForTest(Integer num) {
            this.ndt_checkForTest = num;
            return this;
        }

        public Builder ndt_runTest(Integer num) {
            this.ndt_runTest = num;
            return this;
        }

        public Builder ndt_testCompleted(Integer num) {
            this.ndt_testCompleted = num;
            return this;
        }

        public Builder permissions_accepted(Integer num) {
            this.permissions_accepted = num;
            return this;
        }

        public Builder process_run_time(Integer num) {
            this.process_run_time = num;
            return this;
        }

        public Builder receiver_bootComplete(Integer num) {
            this.receiver_bootComplete = num;
            return this;
        }

        public Builder receiver_connectionChanged(Integer num) {
            this.receiver_connectionChanged = num;
            return this;
        }

        public Builder receiver_onReceive(Integer num) {
            this.receiver_onReceive = num;
            return this;
        }

        public Builder receiver_packageChanged(Integer num) {
            this.receiver_packageChanged = num;
            return this;
        }

        public Builder report_date(String str) {
            this.report_date = str;
            return this;
        }

        public Builder service_monitor(Integer num) {
            this.service_monitor = num;
            return this;
        }

        public Builder service_monitoring_dataCollectionCycles(Integer num) {
            this.service_monitoring_dataCollectionCycles = num;
            return this;
        }

        public Builder service_monitoring_dataCollectionTime(Long l) {
            this.service_monitoring_dataCollectionTime = l;
            return this;
        }

        public Builder service_monitoring_initialize(Integer num) {
            this.service_monitoring_initialize = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase(Integer num) {
            this.service_monitoring_purgeDatabase = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_appDataUsageEvents(Integer num) {
            this.service_monitoring_purgeDatabase_appDataUsageEvents = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_appSessions(Integer num) {
            this.service_monitoring_purgeDatabase_appSessions = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_appUsageEventsRecords(Integer num) {
            this.service_monitoring_purgeDatabase_appUsageEventsRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_batteryLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_batteryLogRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_locationLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_locationLogRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_logDataRecords(Integer num) {
            this.service_monitoring_purgeDatabase_logDataRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_mobileInfoLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_mobileInfoLogRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_mobileSignalInfoLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_noSignalRecords(Integer num) {
            this.service_monitoring_purgeDatabase_noSignalRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_systemCpuLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_systemCpuLogRecords = num;
            return this;
        }

        public Builder service_monitoring_purgeDatabase_wifiInfoLogRecords(Integer num) {
            this.service_monitoring_purgeDatabase_wifiInfoLogRecords = num;
            return this;
        }

        public Builder service_monitoring_upTime(Long l) {
            this.service_monitoring_upTime = l;
            return this;
        }

        public Builder service_monitoring_updateDatabase(Integer num) {
            this.service_monitoring_updateDatabase = num;
            return this;
        }

        public Builder service_monitoring_updateDatabase_logData_recordInsertAttempts(Integer num) {
            this.service_monitoring_updateDatabase_logData_recordInsertAttempts = num;
            return this;
        }

        public Builder service_monitoring_updateDatabase_logData_recordInsertsFailed(Integer num) {
            this.service_monitoring_updateDatabase_logData_recordInsertsFailed = num;
            return this;
        }

        public Builder service_monitoring_validityCheckFailure(Integer num) {
            this.service_monitoring_validityCheckFailure = num;
            return this;
        }

        public Builder service_onCreate(Integer num) {
            this.service_onCreate = num;
            return this;
        }

        public Builder service_onDestroy(Integer num) {
            this.service_onDestroy = num;
            return this;
        }

        public Builder service_onLowMemory(Integer num) {
            this.service_onLowMemory = num;
            return this;
        }

        public Builder service_transmitData(Integer num) {
            this.service_transmitData = num;
            return this;
        }

        public Builder service_transmitData_submittedAppDataLogs(Integer num) {
            this.service_transmitData_submittedAppDataLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedAppDataLogsPacket(Integer num) {
            this.service_transmitData_submittedAppDataLogsPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedAppDataLogsPacketAccepted(Integer num) {
            this.service_transmitData_submittedAppDataLogsPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedAppSessions(Integer num) {
            this.service_transmitData_submittedAppSessions = num;
            return this;
        }

        public Builder service_transmitData_submittedAppUsageEventsPacket(Integer num) {
            this.service_transmitData_submittedAppUsageEventsPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedAppUsageEventsPacketAccepted(Integer num) {
            this.service_transmitData_submittedAppUsageEventsPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedApplicationEventsPacket(Integer num) {
            this.service_transmitData_submittedApplicationEventsPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedApplicationEventsPacketAccepted(Integer num) {
            this.service_transmitData_submittedApplicationEventsPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedBatteryLogs(Integer num) {
            this.service_transmitData_submittedBatteryLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedBatteryLogsAccepted(Integer num) {
            this.service_transmitData_submittedBatteryLogsAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedBatteryLogsPacket(Integer num) {
            this.service_transmitData_submittedBatteryLogsPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedBatteryLogsPacketAccepted(Integer num) {
            this.service_transmitData_submittedBatteryLogsPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedCPULogs(Integer num) {
            this.service_transmitData_submittedCPULogs = num;
            return this;
        }

        public Builder service_transmitData_submittedCPULogsAccepted(Integer num) {
            this.service_transmitData_submittedCPULogsAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedDataUsageEvents(Integer num) {
            this.service_transmitData_submittedDataUsageEvents = num;
            return this;
        }

        public Builder service_transmitData_submittedLocationLogs(Integer num) {
            this.service_transmitData_submittedLocationLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedLocationPacket(Integer num) {
            this.service_transmitData_submittedLocationPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedLocationPacketAccepted(Integer num) {
            this.service_transmitData_submittedLocationPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedLocationPacketSent(Integer num) {
            this.service_transmitData_submittedLocationPacketSent = num;
            return this;
        }

        public Builder service_transmitData_submittedLogs(Integer num) {
            this.service_transmitData_submittedLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedLogsAccepted(Integer num) {
            this.service_transmitData_submittedLogsAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedMobileLogs(Integer num) {
            this.service_transmitData_submittedMobileLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedNetworkPacket(Integer num) {
            this.service_transmitData_submittedNetworkPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedNetworkPacketAccepted(Integer num) {
            this.service_transmitData_submittedNetworkPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedNetworkPacketSent(Integer num) {
            this.service_transmitData_submittedNetworkPacketSent = num;
            return this;
        }

        public Builder service_transmitData_submittedNoSignalLogs(Integer num) {
            this.service_transmitData_submittedNoSignalLogs = num;
            return this;
        }

        public Builder service_transmitData_submittedSystemCPULogPacket(Integer num) {
            this.service_transmitData_submittedSystemCPULogPacket = num;
            return this;
        }

        public Builder service_transmitData_submittedSystemCPULogPacketAccepted(Integer num) {
            this.service_transmitData_submittedSystemCPULogPacketAccepted = num;
            return this;
        }

        public Builder service_transmitData_submittedSystemCPULogs(Integer num) {
            this.service_transmitData_submittedSystemCPULogs = num;
            return this;
        }

        public Builder service_transmitData_submittedWifiLogs(Integer num) {
            this.service_transmitData_submittedWifiLogs = num;
            return this;
        }

        public Builder start(Integer num) {
            this.start = num;
            return this;
        }

        public Builder startMonitoring(Integer num) {
            this.startMonitoring = num;
            return this;
        }

        public Builder startMonitoring_startService(Integer num) {
            this.startMonitoring_startService = num;
            return this;
        }

        public Builder startMonitoring_storageFull(Integer num) {
            this.startMonitoring_storageFull = num;
            return this;
        }

        public Builder status_index(Integer num) {
            this.status_index = num;
            return this;
        }

        public Builder stop(Integer num) {
            this.stop = num;
            return this;
        }

        public Builder stopMonitoring(Integer num) {
            this.stopMonitoring = num;
            return this;
        }

        public Builder systemBatteryInfo_collected(Integer num) {
            this.systemBatteryInfo_collected = num;
            return this;
        }

        public Builder system_available_internal_storage(Long l) {
            this.system_available_internal_storage = l;
            return this;
        }

        public Builder system_available_memory(Long l) {
            this.system_available_memory = l;
            return this;
        }

        public Builder system_clock_elapsed_time(Long l) {
            this.system_clock_elapsed_time = l;
            return this;
        }

        public Builder system_clock_up_time(Long l) {
            this.system_clock_up_time = l;
            return this;
        }

        public Builder system_current_memory(Long l) {
            this.system_current_memory = l;
            return this;
        }

        public Builder system_total_internal_storage(Long l) {
            this.system_total_internal_storage = l;
            return this;
        }

        public Builder system_uptime(Long l) {
            this.system_uptime = l;
            return this;
        }

        public Builder timeChangeBack(Integer num) {
            this.timeChangeBack = num;
            return this;
        }

        public Builder timeChangeForward(Integer num) {
            this.timeChangeForward = num;
            return this;
        }

        public MonitoringStatsMessage build() {
            return new MonitoringStatsMessage(this.status_index, this.system_clock_up_time, this.system_clock_elapsed_time, this.most_foreground_app_by_pus_time, this.most_foreground_app_by_sdk_time, this.is_running, this.is_storage_full, this.database_size, this.app_memory, this.system_current_memory, this.system_available_memory, this.system_total_internal_storage, this.count_installed_apps, this.system_uptime, this.service_monitoring_dataCollectionCycles, this.service_monitoring_dataCollectionTime, this.service_monitoring_updateDatabase, this.service_monitoring_updateDatabase_logData_recordInsertAttempts, this.service_monitoring_updateDatabase_logData_recordInsertsFailed, this.service_transmitData_submittedLogs, this.service_transmitData_submittedLogsAccepted, this.service_transmitData_submittedBatteryLogs, this.service_transmitData_submittedBatteryLogsAccepted, this.logger_totalErrorCount, this.receiver_onReceive, this.receiver_packageChanged, this.receiver_bootComplete, this.receiver_connectionChanged, this.startMonitoring, this.startMonitoring_storageFull, this.startMonitoring_startService, this.stopMonitoring, this.service_monitor, this.service_transmitData, this.service_onCreate, this.service_onLowMemory, this.service_onDestroy, this.service_monitoring_initialize, this.service_monitoring_validityCheckFailure, this.initialize, this.initialize_setupController, this.initialize_controllerSetup, this.initialize_resetController, this.initialize_resetControllerFailed, this.start, this.stop, this.initialSetup_start, this.initialSetup_run, this.initialSetup_storageFull, this.initialSetup_complete, this.process_run_time, this.report_date, this.timeChangeBack, this.service_transmitData_submittedCPULogs, this.service_transmitData_submittedCPULogsAccepted, this.system_available_internal_storage, this.most_foreground_app_by_pus_package_name, this.most_foreground_app_by_sdk_package_name, this.service_monitoring_upTime, this.service_monitoring_purgeDatabase, this.service_monitoring_purgeDatabase_logDataRecords, this.service_monitoring_purgeDatabase_appUsageEventsRecords, this.service_monitoring_purgeDatabase_systemCpuLogRecords, this.service_monitoring_purgeDatabase_batteryLogRecords, this.service_monitoring_purgeDatabase_wifiInfoLogRecords, this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords, this.service_monitoring_purgeDatabase_mobileInfoLogRecords, this.timeChangeForward, this.permissions_accepted, this.service_monitoring_purgeDatabase_locationLogRecords, this.service_transmitData_submittedMobileLogs, this.service_transmitData_submittedWifiLogs, this.service_transmitData_submittedNetworkPacketSent, this.service_transmitData_submittedNetworkPacketAccepted, this.service_transmitData_submittedLocationLogs, this.service_transmitData_submittedLocationPacketSent, this.service_transmitData_submittedLocationPacketAccepted, this.individual_permissions_accepted, this.service_monitoring_purgeDatabase_appSessions, this.service_monitoring_purgeDatabase_appDataUsageEvents, this.service_transmitData_submittedNetworkPacket, this.service_transmitData_submittedLocationPacket, this.service_transmitData_submittedAppSessions, this.service_transmitData_submittedDataUsageEvents, this.service_transmitData_submittedApplicationEventsPacket, this.service_transmitData_submittedApplicationEventsPacketAccepted, this.mnsi_collected, this.location_collected, this.systemBatteryInfo_collected, this.appSessions_collected, this.appDataUsageEvents_collected, this.service_monitoring_purgeDatabase_noSignalRecords, this.service_transmitData_submittedNoSignalLogs, this.service_transmitData_submittedSystemCPULogs, this.service_transmitData_submittedSystemCPULogPacket, this.service_transmitData_submittedSystemCPULogPacketAccepted, this.service_transmitData_submittedBatteryLogsPacket, this.service_transmitData_submittedBatteryLogsPacketAccepted, this.service_transmitData_submittedAppDataLogs, this.service_transmitData_submittedAppDataLogsPacket, this.service_transmitData_submittedAppDataLogsPacketAccepted, this.service_transmitData_submittedAppUsageEventsPacket, this.service_transmitData_submittedAppUsageEventsPacketAccepted, this.ndt_checkForTest, this.ndt_runTest, this.ndt_testCompleted, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MonitoringStatsMessage extends ProtoAdapter<MonitoringStatsMessage> {
        public ProtoAdapter_MonitoringStatsMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MonitoringStatsMessage.class);
        }

        public MonitoringStatsMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 20:
                            builder.status_index(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 21:
                            builder.system_clock_up_time(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 22:
                            builder.system_clock_elapsed_time(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 23:
                            builder.most_foreground_app_by_pus_time(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 24:
                            builder.most_foreground_app_by_sdk_time(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 25:
                            builder.is_running(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 26:
                            builder.is_storage_full(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 27:
                            builder.database_size(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 28:
                            builder.app_memory(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 29:
                            builder.system_current_memory(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 30:
                            builder.system_available_memory(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 31:
                            builder.system_total_internal_storage(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 32:
                            builder.count_installed_apps(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 33:
                            builder.system_uptime(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 34:
                            builder.service_monitoring_dataCollectionCycles(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 35:
                            builder.service_monitoring_dataCollectionTime(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 36:
                            builder.service_monitoring_updateDatabase(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 37:
                            builder.service_monitoring_updateDatabase_logData_recordInsertAttempts(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 38:
                            builder.service_monitoring_updateDatabase_logData_recordInsertsFailed(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 39:
                            builder.service_transmitData_submittedLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 40:
                            builder.service_transmitData_submittedLogsAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 41:
                            builder.service_transmitData_submittedBatteryLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 42:
                            builder.service_transmitData_submittedBatteryLogsAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 43:
                            builder.logger_totalErrorCount(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 44:
                            builder.receiver_onReceive(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 45:
                            builder.receiver_packageChanged(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 46:
                            builder.receiver_bootComplete(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 47:
                            builder.receiver_connectionChanged(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 48:
                            builder.startMonitoring(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 49:
                            builder.startMonitoring_storageFull(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 50:
                            builder.startMonitoring_startService(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 51:
                            builder.stopMonitoring(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 52:
                            builder.service_monitor(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 53:
                            builder.service_transmitData(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 54:
                            builder.service_onCreate(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 55:
                            builder.service_onLowMemory(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 56:
                            builder.service_onDestroy(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 57:
                            builder.service_monitoring_initialize(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 58:
                            builder.service_monitoring_validityCheckFailure(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 59:
                            builder.initialize(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 60:
                            builder.initialize_setupController(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 61:
                            builder.initialize_controllerSetup(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 62:
                            builder.initialize_resetController(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 63:
                            builder.initialize_resetControllerFailed(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 64:
                            builder.start(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 65:
                            builder.stop(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 66:
                            builder.initialSetup_start(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 67:
                            builder.initialSetup_run(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 68:
                            builder.initialSetup_storageFull(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 69:
                            builder.initialSetup_complete(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 70:
                            builder.process_run_time(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 71:
                            builder.report_date(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 72:
                            builder.timeChangeBack(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 73:
                            builder.service_transmitData_submittedCPULogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 74:
                            builder.service_transmitData_submittedCPULogsAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 75:
                            builder.system_available_internal_storage(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 76:
                            builder.most_foreground_app_by_pus_package_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 77:
                            builder.most_foreground_app_by_sdk_package_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 78:
                            builder.service_monitoring_upTime(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 79:
                            builder.service_monitoring_purgeDatabase(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 80:
                            builder.service_monitoring_purgeDatabase_logDataRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 81:
                            builder.service_monitoring_purgeDatabase_appUsageEventsRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 82:
                            builder.service_monitoring_purgeDatabase_systemCpuLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 83:
                            builder.service_monitoring_purgeDatabase_batteryLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 84:
                            builder.service_monitoring_purgeDatabase_wifiInfoLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 85:
                            builder.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 86:
                            builder.service_monitoring_purgeDatabase_mobileInfoLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 87:
                            builder.timeChangeForward(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 88:
                            builder.permissions_accepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 89:
                            builder.service_monitoring_purgeDatabase_locationLogRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 90:
                            builder.service_transmitData_submittedMobileLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 91:
                            builder.service_transmitData_submittedWifiLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 92:
                            builder.service_transmitData_submittedNetworkPacketSent(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 93:
                            builder.service_transmitData_submittedNetworkPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 94:
                            builder.service_transmitData_submittedLocationLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 95:
                            builder.service_transmitData_submittedLocationPacketSent(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 96:
                            builder.service_transmitData_submittedLocationPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 97:
                            builder.individual_permissions_accepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 98:
                            builder.service_monitoring_purgeDatabase_appSessions(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 99:
                            builder.service_monitoring_purgeDatabase_appDataUsageEvents(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 102:
                            builder.service_transmitData_submittedNetworkPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 103:
                            builder.service_transmitData_submittedLocationPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 104:
                            builder.service_transmitData_submittedAppSessions(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 105:
                            builder.service_transmitData_submittedDataUsageEvents(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 106:
                            builder.service_transmitData_submittedApplicationEventsPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 107:
                            builder.service_transmitData_submittedApplicationEventsPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 108:
                            builder.mnsi_collected(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 109:
                            builder.location_collected(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 110:
                            builder.systemBatteryInfo_collected(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 111:
                            builder.appSessions_collected(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 112:
                            builder.appDataUsageEvents_collected(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 113:
                            builder.service_monitoring_purgeDatabase_noSignalRecords(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 114:
                            builder.service_transmitData_submittedNoSignalLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 115:
                            builder.service_transmitData_submittedSystemCPULogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 116:
                            builder.service_transmitData_submittedSystemCPULogPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 117:
                            builder.service_transmitData_submittedSystemCPULogPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 118:
                            builder.service_transmitData_submittedBatteryLogsPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 119:
                            builder.service_transmitData_submittedBatteryLogsPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 120:
                            builder.service_transmitData_submittedAppDataLogs(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 121:
                            builder.service_transmitData_submittedAppDataLogsPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 122:
                            builder.service_transmitData_submittedAppDataLogsPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 123:
                            builder.service_transmitData_submittedAppUsageEventsPacket(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 124:
                            builder.service_transmitData_submittedAppUsageEventsPacketAccepted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 125:
                            builder.ndt_checkForTest(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 126:
                            builder.ndt_runTest(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 127:
                            builder.ndt_testCompleted(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public void encode(ProtoWriter protoWriter, MonitoringStatsMessage monitoringStatsMessage) {
            Integer num = monitoringStatsMessage.status_index;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 20, num);
            }
            Long l = monitoringStatsMessage.system_clock_up_time;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 21, l);
            }
            Long l2 = monitoringStatsMessage.system_clock_elapsed_time;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 22, l2);
            }
            Integer num2 = monitoringStatsMessage.most_foreground_app_by_pus_time;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 23, num2);
            }
            Integer num3 = monitoringStatsMessage.most_foreground_app_by_sdk_time;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 24, num3);
            }
            Integer num4 = monitoringStatsMessage.is_running;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 25, num4);
            }
            Integer num5 = monitoringStatsMessage.is_storage_full;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num5);
            }
            Long l3 = monitoringStatsMessage.database_size;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 27, l3);
            }
            Long l4 = monitoringStatsMessage.app_memory;
            if (l4 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 28, l4);
            }
            Long l5 = monitoringStatsMessage.system_current_memory;
            if (l5 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 29, l5);
            }
            Long l6 = monitoringStatsMessage.system_available_memory;
            if (l6 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 30, l6);
            }
            Long l7 = monitoringStatsMessage.system_total_internal_storage;
            if (l7 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 31, l7);
            }
            Integer num6 = monitoringStatsMessage.count_installed_apps;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num6);
            }
            Long l8 = monitoringStatsMessage.system_uptime;
            if (l8 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 33, l8);
            }
            Integer num7 = monitoringStatsMessage.service_monitoring_dataCollectionCycles;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 34, num7);
            }
            Long l9 = monitoringStatsMessage.service_monitoring_dataCollectionTime;
            if (l9 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 35, l9);
            }
            Integer num8 = monitoringStatsMessage.service_monitoring_updateDatabase;
            if (num8 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 36, num8);
            }
            Integer num9 = monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertAttempts;
            if (num9 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 37, num9);
            }
            Integer num10 = monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertsFailed;
            if (num10 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 38, num10);
            }
            Integer num11 = monitoringStatsMessage.service_transmitData_submittedLogs;
            if (num11 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 39, num11);
            }
            Integer num12 = monitoringStatsMessage.service_transmitData_submittedLogsAccepted;
            if (num12 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 40, num12);
            }
            Integer num13 = monitoringStatsMessage.service_transmitData_submittedBatteryLogs;
            if (num13 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 41, num13);
            }
            Integer num14 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsAccepted;
            if (num14 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 42, num14);
            }
            Integer num15 = monitoringStatsMessage.logger_totalErrorCount;
            if (num15 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 43, num15);
            }
            Integer num16 = monitoringStatsMessage.receiver_onReceive;
            if (num16 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 44, num16);
            }
            Integer num17 = monitoringStatsMessage.receiver_packageChanged;
            if (num17 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 45, num17);
            }
            Integer num18 = monitoringStatsMessage.receiver_bootComplete;
            if (num18 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 46, num18);
            }
            Integer num19 = monitoringStatsMessage.receiver_connectionChanged;
            if (num19 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 47, num19);
            }
            Integer num20 = monitoringStatsMessage.startMonitoring;
            if (num20 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 48, num20);
            }
            Integer num21 = monitoringStatsMessage.startMonitoring_storageFull;
            if (num21 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 49, num21);
            }
            Integer num22 = monitoringStatsMessage.startMonitoring_startService;
            if (num22 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 50, num22);
            }
            Integer num23 = monitoringStatsMessage.stopMonitoring;
            if (num23 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 51, num23);
            }
            Integer num24 = monitoringStatsMessage.service_monitor;
            if (num24 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 52, num24);
            }
            Integer num25 = monitoringStatsMessage.service_transmitData;
            if (num25 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 53, num25);
            }
            Integer num26 = monitoringStatsMessage.service_onCreate;
            if (num26 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 54, num26);
            }
            Integer num27 = monitoringStatsMessage.service_onLowMemory;
            if (num27 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 55, num27);
            }
            Integer num28 = monitoringStatsMessage.service_onDestroy;
            if (num28 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 56, num28);
            }
            Integer num29 = monitoringStatsMessage.service_monitoring_initialize;
            if (num29 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 57, num29);
            }
            Integer num30 = monitoringStatsMessage.service_monitoring_validityCheckFailure;
            if (num30 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 58, num30);
            }
            Integer num31 = monitoringStatsMessage.initialize;
            if (num31 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 59, num31);
            }
            Integer num32 = monitoringStatsMessage.initialize_setupController;
            if (num32 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 60, num32);
            }
            Integer num33 = monitoringStatsMessage.initialize_controllerSetup;
            if (num33 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 61, num33);
            }
            Integer num34 = monitoringStatsMessage.initialize_resetController;
            if (num34 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 62, num34);
            }
            Integer num35 = monitoringStatsMessage.initialize_resetControllerFailed;
            if (num35 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 63, num35);
            }
            Integer num36 = monitoringStatsMessage.start;
            if (num36 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 64, num36);
            }
            Integer num37 = monitoringStatsMessage.stop;
            if (num37 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 65, num37);
            }
            Integer num38 = monitoringStatsMessage.initialSetup_start;
            if (num38 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 66, num38);
            }
            Integer num39 = monitoringStatsMessage.initialSetup_run;
            if (num39 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 67, num39);
            }
            Integer num40 = monitoringStatsMessage.initialSetup_storageFull;
            if (num40 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 68, num40);
            }
            Integer num41 = monitoringStatsMessage.initialSetup_complete;
            if (num41 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 69, num41);
            }
            Integer num42 = monitoringStatsMessage.process_run_time;
            if (num42 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 70, num42);
            }
            String str = monitoringStatsMessage.report_date;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 71, str);
            }
            Integer num43 = monitoringStatsMessage.timeChangeBack;
            if (num43 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 72, num43);
            }
            Integer num44 = monitoringStatsMessage.service_transmitData_submittedCPULogs;
            if (num44 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 73, num44);
            }
            Integer num45 = monitoringStatsMessage.service_transmitData_submittedCPULogsAccepted;
            if (num45 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 74, num45);
            }
            Long l10 = monitoringStatsMessage.system_available_internal_storage;
            if (l10 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 75, l10);
            }
            String str2 = monitoringStatsMessage.most_foreground_app_by_pus_package_name;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 76, str2);
            }
            String str3 = monitoringStatsMessage.most_foreground_app_by_sdk_package_name;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 77, str3);
            }
            Long l11 = monitoringStatsMessage.service_monitoring_upTime;
            if (l11 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 78, l11);
            }
            Integer num46 = monitoringStatsMessage.service_monitoring_purgeDatabase;
            if (num46 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 79, num46);
            }
            Integer num47 = monitoringStatsMessage.service_monitoring_purgeDatabase_logDataRecords;
            if (num47 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 80, num47);
            }
            Integer num48 = monitoringStatsMessage.service_monitoring_purgeDatabase_appUsageEventsRecords;
            if (num48 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 81, num48);
            }
            Integer num49 = monitoringStatsMessage.service_monitoring_purgeDatabase_systemCpuLogRecords;
            if (num49 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 82, num49);
            }
            Integer num50 = monitoringStatsMessage.service_monitoring_purgeDatabase_batteryLogRecords;
            if (num50 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 83, num50);
            }
            Integer num51 = monitoringStatsMessage.service_monitoring_purgeDatabase_wifiInfoLogRecords;
            if (num51 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 84, num51);
            }
            Integer num52 = monitoringStatsMessage.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
            if (num52 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 85, num52);
            }
            Integer num53 = monitoringStatsMessage.service_monitoring_purgeDatabase_mobileInfoLogRecords;
            if (num53 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 86, num53);
            }
            Integer num54 = monitoringStatsMessage.timeChangeForward;
            if (num54 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 87, num54);
            }
            Integer num55 = monitoringStatsMessage.permissions_accepted;
            if (num55 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 88, num55);
            }
            Integer num56 = monitoringStatsMessage.service_monitoring_purgeDatabase_locationLogRecords;
            if (num56 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 89, num56);
            }
            Integer num57 = monitoringStatsMessage.service_transmitData_submittedMobileLogs;
            if (num57 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 90, num57);
            }
            Integer num58 = monitoringStatsMessage.service_transmitData_submittedWifiLogs;
            if (num58 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 91, num58);
            }
            Integer num59 = monitoringStatsMessage.service_transmitData_submittedNetworkPacketSent;
            if (num59 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 92, num59);
            }
            Integer num60 = monitoringStatsMessage.service_transmitData_submittedNetworkPacketAccepted;
            if (num60 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 93, num60);
            }
            Integer num61 = monitoringStatsMessage.service_transmitData_submittedLocationLogs;
            if (num61 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 94, num61);
            }
            Integer num62 = monitoringStatsMessage.service_transmitData_submittedLocationPacketSent;
            if (num62 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 95, num62);
            }
            Integer num63 = monitoringStatsMessage.service_transmitData_submittedLocationPacketAccepted;
            if (num63 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 96, num63);
            }
            Integer num64 = monitoringStatsMessage.individual_permissions_accepted;
            if (num64 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 97, num64);
            }
            Integer num65 = monitoringStatsMessage.service_monitoring_purgeDatabase_appSessions;
            if (num65 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 98, num65);
            }
            Integer num66 = monitoringStatsMessage.service_monitoring_purgeDatabase_appDataUsageEvents;
            if (num66 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 99, num66);
            }
            Integer num67 = monitoringStatsMessage.service_transmitData_submittedNetworkPacket;
            if (num67 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 102, num67);
            }
            Integer num68 = monitoringStatsMessage.service_transmitData_submittedLocationPacket;
            if (num68 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 103, num68);
            }
            Integer num69 = monitoringStatsMessage.service_transmitData_submittedAppSessions;
            if (num69 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 104, num69);
            }
            Integer num70 = monitoringStatsMessage.service_transmitData_submittedDataUsageEvents;
            if (num70 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 105, num70);
            }
            Integer num71 = monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacket;
            if (num71 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 106, num71);
            }
            Integer num72 = monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacketAccepted;
            if (num72 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 107, num72);
            }
            Integer num73 = monitoringStatsMessage.mnsi_collected;
            if (num73 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 108, num73);
            }
            Integer num74 = monitoringStatsMessage.location_collected;
            if (num74 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 109, num74);
            }
            Integer num75 = monitoringStatsMessage.systemBatteryInfo_collected;
            if (num75 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 110, num75);
            }
            Integer num76 = monitoringStatsMessage.appSessions_collected;
            if (num76 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 111, num76);
            }
            Integer num77 = monitoringStatsMessage.appDataUsageEvents_collected;
            if (num77 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 112, num77);
            }
            Integer num78 = monitoringStatsMessage.service_monitoring_purgeDatabase_noSignalRecords;
            if (num78 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 113, num78);
            }
            Integer num79 = monitoringStatsMessage.service_transmitData_submittedNoSignalLogs;
            if (num79 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 114, num79);
            }
            Integer num80 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogs;
            if (num80 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 115, num80);
            }
            Integer num81 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacket;
            if (num81 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 116, num81);
            }
            Integer num82 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacketAccepted;
            if (num82 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 117, num82);
            }
            Integer num83 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacket;
            if (num83 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 118, num83);
            }
            Integer num84 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacketAccepted;
            if (num84 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 119, num84);
            }
            Integer num85 = monitoringStatsMessage.service_transmitData_submittedAppDataLogs;
            if (num85 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 120, num85);
            }
            Integer num86 = monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacket;
            if (num86 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 121, num86);
            }
            Integer num87 = monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacketAccepted;
            if (num87 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 122, num87);
            }
            Integer num88 = monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacket;
            if (num88 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 123, num88);
            }
            Integer num89 = monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacketAccepted;
            if (num89 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 124, num89);
            }
            Integer num90 = monitoringStatsMessage.ndt_checkForTest;
            if (num90 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 125, num90);
            }
            Integer num91 = monitoringStatsMessage.ndt_runTest;
            if (num91 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 126, num91);
            }
            Integer num92 = monitoringStatsMessage.ndt_testCompleted;
            if (num92 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 127, num92);
            }
            protoWriter.writeBytes(monitoringStatsMessage.unknownFields());
        }

        public int encodedSize(MonitoringStatsMessage monitoringStatsMessage) {
            Integer num = monitoringStatsMessage.status_index;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(20, num) : 0;
            Long l = monitoringStatsMessage.system_clock_up_time;
            int encodedSizeWithTag2 = encodedSizeWithTag + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(21, l) : 0);
            Long l2 = monitoringStatsMessage.system_clock_elapsed_time;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(22, l2) : 0);
            Integer num2 = monitoringStatsMessage.most_foreground_app_by_pus_time;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(23, num2) : 0);
            Integer num3 = monitoringStatsMessage.most_foreground_app_by_sdk_time;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(24, num3) : 0);
            Integer num4 = monitoringStatsMessage.is_running;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(25, num4) : 0);
            Integer num5 = monitoringStatsMessage.is_storage_full;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num5) : 0);
            Long l3 = monitoringStatsMessage.database_size;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (l3 != null ? ProtoAdapter.INT64.encodedSizeWithTag(27, l3) : 0);
            Long l4 = monitoringStatsMessage.app_memory;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (l4 != null ? ProtoAdapter.INT64.encodedSizeWithTag(28, l4) : 0);
            Long l5 = monitoringStatsMessage.system_current_memory;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (l5 != null ? ProtoAdapter.INT64.encodedSizeWithTag(29, l5) : 0);
            Long l6 = monitoringStatsMessage.system_available_memory;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (l6 != null ? ProtoAdapter.INT64.encodedSizeWithTag(30, l6) : 0);
            Long l7 = monitoringStatsMessage.system_total_internal_storage;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (l7 != null ? ProtoAdapter.INT64.encodedSizeWithTag(31, l7) : 0);
            Integer num6 = monitoringStatsMessage.count_installed_apps;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num6) : 0);
            Long l8 = monitoringStatsMessage.system_uptime;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (l8 != null ? ProtoAdapter.INT64.encodedSizeWithTag(33, l8) : 0);
            Integer num7 = monitoringStatsMessage.service_monitoring_dataCollectionCycles;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(34, num7) : 0);
            Long l9 = monitoringStatsMessage.service_monitoring_dataCollectionTime;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (l9 != null ? ProtoAdapter.INT64.encodedSizeWithTag(35, l9) : 0);
            Integer num8 = monitoringStatsMessage.service_monitoring_updateDatabase;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (num8 != null ? ProtoAdapter.INT32.encodedSizeWithTag(36, num8) : 0);
            Integer num9 = monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertAttempts;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (num9 != null ? ProtoAdapter.INT32.encodedSizeWithTag(37, num9) : 0);
            Integer num10 = monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertsFailed;
            int encodedSizeWithTag19 = encodedSizeWithTag18 + (num10 != null ? ProtoAdapter.INT32.encodedSizeWithTag(38, num10) : 0);
            Integer num11 = monitoringStatsMessage.service_transmitData_submittedLogs;
            int encodedSizeWithTag20 = encodedSizeWithTag19 + (num11 != null ? ProtoAdapter.INT32.encodedSizeWithTag(39, num11) : 0);
            Integer num12 = monitoringStatsMessage.service_transmitData_submittedLogsAccepted;
            int encodedSizeWithTag21 = encodedSizeWithTag20 + (num12 != null ? ProtoAdapter.INT32.encodedSizeWithTag(40, num12) : 0);
            Integer num13 = monitoringStatsMessage.service_transmitData_submittedBatteryLogs;
            int encodedSizeWithTag22 = encodedSizeWithTag21 + (num13 != null ? ProtoAdapter.INT32.encodedSizeWithTag(41, num13) : 0);
            Integer num14 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsAccepted;
            int encodedSizeWithTag23 = encodedSizeWithTag22 + (num14 != null ? ProtoAdapter.INT32.encodedSizeWithTag(42, num14) : 0);
            Integer num15 = monitoringStatsMessage.logger_totalErrorCount;
            int encodedSizeWithTag24 = encodedSizeWithTag23 + (num15 != null ? ProtoAdapter.INT32.encodedSizeWithTag(43, num15) : 0);
            Integer num16 = monitoringStatsMessage.receiver_onReceive;
            int encodedSizeWithTag25 = encodedSizeWithTag24 + (num16 != null ? ProtoAdapter.INT32.encodedSizeWithTag(44, num16) : 0);
            Integer num17 = monitoringStatsMessage.receiver_packageChanged;
            int encodedSizeWithTag26 = encodedSizeWithTag25 + (num17 != null ? ProtoAdapter.INT32.encodedSizeWithTag(45, num17) : 0);
            Integer num18 = monitoringStatsMessage.receiver_bootComplete;
            int encodedSizeWithTag27 = encodedSizeWithTag26 + (num18 != null ? ProtoAdapter.INT32.encodedSizeWithTag(46, num18) : 0);
            Integer num19 = monitoringStatsMessage.receiver_connectionChanged;
            int encodedSizeWithTag28 = encodedSizeWithTag27 + (num19 != null ? ProtoAdapter.INT32.encodedSizeWithTag(47, num19) : 0);
            Integer num20 = monitoringStatsMessage.startMonitoring;
            int encodedSizeWithTag29 = encodedSizeWithTag28 + (num20 != null ? ProtoAdapter.INT32.encodedSizeWithTag(48, num20) : 0);
            Integer num21 = monitoringStatsMessage.startMonitoring_storageFull;
            int encodedSizeWithTag30 = encodedSizeWithTag29 + (num21 != null ? ProtoAdapter.INT32.encodedSizeWithTag(49, num21) : 0);
            Integer num22 = monitoringStatsMessage.startMonitoring_startService;
            int encodedSizeWithTag31 = encodedSizeWithTag30 + (num22 != null ? ProtoAdapter.INT32.encodedSizeWithTag(50, num22) : 0);
            Integer num23 = monitoringStatsMessage.stopMonitoring;
            int encodedSizeWithTag32 = encodedSizeWithTag31 + (num23 != null ? ProtoAdapter.INT32.encodedSizeWithTag(51, num23) : 0);
            Integer num24 = monitoringStatsMessage.service_monitor;
            int encodedSizeWithTag33 = encodedSizeWithTag32 + (num24 != null ? ProtoAdapter.INT32.encodedSizeWithTag(52, num24) : 0);
            Integer num25 = monitoringStatsMessage.service_transmitData;
            int encodedSizeWithTag34 = encodedSizeWithTag33 + (num25 != null ? ProtoAdapter.INT32.encodedSizeWithTag(53, num25) : 0);
            Integer num26 = monitoringStatsMessage.service_onCreate;
            int encodedSizeWithTag35 = encodedSizeWithTag34 + (num26 != null ? ProtoAdapter.INT32.encodedSizeWithTag(54, num26) : 0);
            Integer num27 = monitoringStatsMessage.service_onLowMemory;
            int encodedSizeWithTag36 = encodedSizeWithTag35 + (num27 != null ? ProtoAdapter.INT32.encodedSizeWithTag(55, num27) : 0);
            Integer num28 = monitoringStatsMessage.service_onDestroy;
            int encodedSizeWithTag37 = encodedSizeWithTag36 + (num28 != null ? ProtoAdapter.INT32.encodedSizeWithTag(56, num28) : 0);
            Integer num29 = monitoringStatsMessage.service_monitoring_initialize;
            int encodedSizeWithTag38 = encodedSizeWithTag37 + (num29 != null ? ProtoAdapter.INT32.encodedSizeWithTag(57, num29) : 0);
            Integer num30 = monitoringStatsMessage.service_monitoring_validityCheckFailure;
            int encodedSizeWithTag39 = encodedSizeWithTag38 + (num30 != null ? ProtoAdapter.INT32.encodedSizeWithTag(58, num30) : 0);
            Integer num31 = monitoringStatsMessage.initialize;
            int encodedSizeWithTag40 = encodedSizeWithTag39 + (num31 != null ? ProtoAdapter.INT32.encodedSizeWithTag(59, num31) : 0);
            Integer num32 = monitoringStatsMessage.initialize_setupController;
            int encodedSizeWithTag41 = encodedSizeWithTag40 + (num32 != null ? ProtoAdapter.INT32.encodedSizeWithTag(60, num32) : 0);
            Integer num33 = monitoringStatsMessage.initialize_controllerSetup;
            int encodedSizeWithTag42 = encodedSizeWithTag41 + (num33 != null ? ProtoAdapter.INT32.encodedSizeWithTag(61, num33) : 0);
            Integer num34 = monitoringStatsMessage.initialize_resetController;
            int encodedSizeWithTag43 = encodedSizeWithTag42 + (num34 != null ? ProtoAdapter.INT32.encodedSizeWithTag(62, num34) : 0);
            Integer num35 = monitoringStatsMessage.initialize_resetControllerFailed;
            int encodedSizeWithTag44 = encodedSizeWithTag43 + (num35 != null ? ProtoAdapter.INT32.encodedSizeWithTag(63, num35) : 0);
            Integer num36 = monitoringStatsMessage.start;
            int encodedSizeWithTag45 = encodedSizeWithTag44 + (num36 != null ? ProtoAdapter.INT32.encodedSizeWithTag(64, num36) : 0);
            Integer num37 = monitoringStatsMessage.stop;
            int encodedSizeWithTag46 = encodedSizeWithTag45 + (num37 != null ? ProtoAdapter.INT32.encodedSizeWithTag(65, num37) : 0);
            Integer num38 = monitoringStatsMessage.initialSetup_start;
            int encodedSizeWithTag47 = encodedSizeWithTag46 + (num38 != null ? ProtoAdapter.INT32.encodedSizeWithTag(66, num38) : 0);
            Integer num39 = monitoringStatsMessage.initialSetup_run;
            int encodedSizeWithTag48 = encodedSizeWithTag47 + (num39 != null ? ProtoAdapter.INT32.encodedSizeWithTag(67, num39) : 0);
            Integer num40 = monitoringStatsMessage.initialSetup_storageFull;
            int encodedSizeWithTag49 = encodedSizeWithTag48 + (num40 != null ? ProtoAdapter.INT32.encodedSizeWithTag(68, num40) : 0);
            Integer num41 = monitoringStatsMessage.initialSetup_complete;
            int encodedSizeWithTag50 = encodedSizeWithTag49 + (num41 != null ? ProtoAdapter.INT32.encodedSizeWithTag(69, num41) : 0);
            Integer num42 = monitoringStatsMessage.process_run_time;
            int encodedSizeWithTag51 = encodedSizeWithTag50 + (num42 != null ? ProtoAdapter.INT32.encodedSizeWithTag(70, num42) : 0);
            String str = monitoringStatsMessage.report_date;
            int encodedSizeWithTag52 = encodedSizeWithTag51 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(71, str) : 0);
            Integer num43 = monitoringStatsMessage.timeChangeBack;
            int encodedSizeWithTag53 = encodedSizeWithTag52 + (num43 != null ? ProtoAdapter.INT32.encodedSizeWithTag(72, num43) : 0);
            Integer num44 = monitoringStatsMessage.service_transmitData_submittedCPULogs;
            int encodedSizeWithTag54 = encodedSizeWithTag53 + (num44 != null ? ProtoAdapter.INT32.encodedSizeWithTag(73, num44) : 0);
            Integer num45 = monitoringStatsMessage.service_transmitData_submittedCPULogsAccepted;
            int encodedSizeWithTag55 = encodedSizeWithTag54 + (num45 != null ? ProtoAdapter.INT32.encodedSizeWithTag(74, num45) : 0);
            Long l10 = monitoringStatsMessage.system_available_internal_storage;
            int encodedSizeWithTag56 = encodedSizeWithTag55 + (l10 != null ? ProtoAdapter.INT64.encodedSizeWithTag(75, l10) : 0);
            String str2 = monitoringStatsMessage.most_foreground_app_by_pus_package_name;
            int encodedSizeWithTag57 = encodedSizeWithTag56 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(76, str2) : 0);
            String str3 = monitoringStatsMessage.most_foreground_app_by_sdk_package_name;
            int encodedSizeWithTag58 = encodedSizeWithTag57 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(77, str3) : 0);
            Long l11 = monitoringStatsMessage.service_monitoring_upTime;
            int encodedSizeWithTag59 = encodedSizeWithTag58 + (l11 != null ? ProtoAdapter.INT64.encodedSizeWithTag(78, l11) : 0);
            Integer num46 = monitoringStatsMessage.service_monitoring_purgeDatabase;
            int encodedSizeWithTag60 = encodedSizeWithTag59 + (num46 != null ? ProtoAdapter.INT32.encodedSizeWithTag(79, num46) : 0);
            Integer num47 = monitoringStatsMessage.service_monitoring_purgeDatabase_logDataRecords;
            int encodedSizeWithTag61 = encodedSizeWithTag60 + (num47 != null ? ProtoAdapter.INT32.encodedSizeWithTag(80, num47) : 0);
            Integer num48 = monitoringStatsMessage.service_monitoring_purgeDatabase_appUsageEventsRecords;
            int encodedSizeWithTag62 = encodedSizeWithTag61 + (num48 != null ? ProtoAdapter.INT32.encodedSizeWithTag(81, num48) : 0);
            Integer num49 = monitoringStatsMessage.service_monitoring_purgeDatabase_systemCpuLogRecords;
            int encodedSizeWithTag63 = encodedSizeWithTag62 + (num49 != null ? ProtoAdapter.INT32.encodedSizeWithTag(82, num49) : 0);
            Integer num50 = monitoringStatsMessage.service_monitoring_purgeDatabase_batteryLogRecords;
            int encodedSizeWithTag64 = encodedSizeWithTag63 + (num50 != null ? ProtoAdapter.INT32.encodedSizeWithTag(83, num50) : 0);
            Integer num51 = monitoringStatsMessage.service_monitoring_purgeDatabase_wifiInfoLogRecords;
            int encodedSizeWithTag65 = encodedSizeWithTag64 + (num51 != null ? ProtoAdapter.INT32.encodedSizeWithTag(84, num51) : 0);
            Integer num52 = monitoringStatsMessage.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
            int encodedSizeWithTag66 = encodedSizeWithTag65 + (num52 != null ? ProtoAdapter.INT32.encodedSizeWithTag(85, num52) : 0);
            Integer num53 = monitoringStatsMessage.service_monitoring_purgeDatabase_mobileInfoLogRecords;
            int encodedSizeWithTag67 = encodedSizeWithTag66 + (num53 != null ? ProtoAdapter.INT32.encodedSizeWithTag(86, num53) : 0);
            Integer num54 = monitoringStatsMessage.timeChangeForward;
            int encodedSizeWithTag68 = encodedSizeWithTag67 + (num54 != null ? ProtoAdapter.INT32.encodedSizeWithTag(87, num54) : 0);
            Integer num55 = monitoringStatsMessage.permissions_accepted;
            int encodedSizeWithTag69 = encodedSizeWithTag68 + (num55 != null ? ProtoAdapter.INT32.encodedSizeWithTag(88, num55) : 0);
            Integer num56 = monitoringStatsMessage.service_monitoring_purgeDatabase_locationLogRecords;
            int encodedSizeWithTag70 = encodedSizeWithTag69 + (num56 != null ? ProtoAdapter.INT32.encodedSizeWithTag(89, num56) : 0);
            Integer num57 = monitoringStatsMessage.service_transmitData_submittedMobileLogs;
            int encodedSizeWithTag71 = encodedSizeWithTag70 + (num57 != null ? ProtoAdapter.INT32.encodedSizeWithTag(90, num57) : 0);
            Integer num58 = monitoringStatsMessage.service_transmitData_submittedWifiLogs;
            int encodedSizeWithTag72 = encodedSizeWithTag71 + (num58 != null ? ProtoAdapter.INT32.encodedSizeWithTag(91, num58) : 0);
            Integer num59 = monitoringStatsMessage.service_transmitData_submittedNetworkPacketSent;
            int encodedSizeWithTag73 = encodedSizeWithTag72 + (num59 != null ? ProtoAdapter.INT32.encodedSizeWithTag(92, num59) : 0);
            Integer num60 = monitoringStatsMessage.service_transmitData_submittedNetworkPacketAccepted;
            int encodedSizeWithTag74 = encodedSizeWithTag73 + (num60 != null ? ProtoAdapter.INT32.encodedSizeWithTag(93, num60) : 0);
            Integer num61 = monitoringStatsMessage.service_transmitData_submittedLocationLogs;
            int encodedSizeWithTag75 = encodedSizeWithTag74 + (num61 != null ? ProtoAdapter.INT32.encodedSizeWithTag(94, num61) : 0);
            Integer num62 = monitoringStatsMessage.service_transmitData_submittedLocationPacketSent;
            int encodedSizeWithTag76 = encodedSizeWithTag75 + (num62 != null ? ProtoAdapter.INT32.encodedSizeWithTag(95, num62) : 0);
            Integer num63 = monitoringStatsMessage.service_transmitData_submittedLocationPacketAccepted;
            int encodedSizeWithTag77 = encodedSizeWithTag76 + (num63 != null ? ProtoAdapter.INT32.encodedSizeWithTag(96, num63) : 0);
            Integer num64 = monitoringStatsMessage.individual_permissions_accepted;
            int encodedSizeWithTag78 = encodedSizeWithTag77 + (num64 != null ? ProtoAdapter.INT32.encodedSizeWithTag(97, num64) : 0);
            Integer num65 = monitoringStatsMessage.service_monitoring_purgeDatabase_appSessions;
            int encodedSizeWithTag79 = encodedSizeWithTag78 + (num65 != null ? ProtoAdapter.INT32.encodedSizeWithTag(98, num65) : 0);
            Integer num66 = monitoringStatsMessage.service_monitoring_purgeDatabase_appDataUsageEvents;
            int encodedSizeWithTag80 = encodedSizeWithTag79 + (num66 != null ? ProtoAdapter.INT32.encodedSizeWithTag(99, num66) : 0);
            Integer num67 = monitoringStatsMessage.service_transmitData_submittedNetworkPacket;
            int encodedSizeWithTag81 = encodedSizeWithTag80 + (num67 != null ? ProtoAdapter.INT32.encodedSizeWithTag(102, num67) : 0);
            Integer num68 = monitoringStatsMessage.service_transmitData_submittedLocationPacket;
            int encodedSizeWithTag82 = encodedSizeWithTag81 + (num68 != null ? ProtoAdapter.INT32.encodedSizeWithTag(103, num68) : 0);
            Integer num69 = monitoringStatsMessage.service_transmitData_submittedAppSessions;
            int encodedSizeWithTag83 = encodedSizeWithTag82 + (num69 != null ? ProtoAdapter.INT32.encodedSizeWithTag(104, num69) : 0);
            Integer num70 = monitoringStatsMessage.service_transmitData_submittedDataUsageEvents;
            int encodedSizeWithTag84 = encodedSizeWithTag83 + (num70 != null ? ProtoAdapter.INT32.encodedSizeWithTag(105, num70) : 0);
            Integer num71 = monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacket;
            int encodedSizeWithTag85 = encodedSizeWithTag84 + (num71 != null ? ProtoAdapter.INT32.encodedSizeWithTag(106, num71) : 0);
            Integer num72 = monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacketAccepted;
            int encodedSizeWithTag86 = encodedSizeWithTag85 + (num72 != null ? ProtoAdapter.INT32.encodedSizeWithTag(107, num72) : 0);
            Integer num73 = monitoringStatsMessage.mnsi_collected;
            int encodedSizeWithTag87 = encodedSizeWithTag86 + (num73 != null ? ProtoAdapter.INT32.encodedSizeWithTag(108, num73) : 0);
            Integer num74 = monitoringStatsMessage.location_collected;
            int encodedSizeWithTag88 = encodedSizeWithTag87 + (num74 != null ? ProtoAdapter.INT32.encodedSizeWithTag(109, num74) : 0);
            Integer num75 = monitoringStatsMessage.systemBatteryInfo_collected;
            int encodedSizeWithTag89 = encodedSizeWithTag88 + (num75 != null ? ProtoAdapter.INT32.encodedSizeWithTag(110, num75) : 0);
            Integer num76 = monitoringStatsMessage.appSessions_collected;
            int encodedSizeWithTag90 = encodedSizeWithTag89 + (num76 != null ? ProtoAdapter.INT32.encodedSizeWithTag(111, num76) : 0);
            Integer num77 = monitoringStatsMessage.appDataUsageEvents_collected;
            int encodedSizeWithTag91 = encodedSizeWithTag90 + (num77 != null ? ProtoAdapter.INT32.encodedSizeWithTag(112, num77) : 0);
            Integer num78 = monitoringStatsMessage.service_monitoring_purgeDatabase_noSignalRecords;
            int encodedSizeWithTag92 = encodedSizeWithTag91 + (num78 != null ? ProtoAdapter.INT32.encodedSizeWithTag(113, num78) : 0);
            Integer num79 = monitoringStatsMessage.service_transmitData_submittedNoSignalLogs;
            int encodedSizeWithTag93 = encodedSizeWithTag92 + (num79 != null ? ProtoAdapter.INT32.encodedSizeWithTag(114, num79) : 0);
            Integer num80 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogs;
            int encodedSizeWithTag94 = encodedSizeWithTag93 + (num80 != null ? ProtoAdapter.INT32.encodedSizeWithTag(115, num80) : 0);
            Integer num81 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacket;
            int encodedSizeWithTag95 = encodedSizeWithTag94 + (num81 != null ? ProtoAdapter.INT32.encodedSizeWithTag(116, num81) : 0);
            Integer num82 = monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacketAccepted;
            int encodedSizeWithTag96 = encodedSizeWithTag95 + (num82 != null ? ProtoAdapter.INT32.encodedSizeWithTag(117, num82) : 0);
            Integer num83 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacket;
            int encodedSizeWithTag97 = encodedSizeWithTag96 + (num83 != null ? ProtoAdapter.INT32.encodedSizeWithTag(118, num83) : 0);
            Integer num84 = monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacketAccepted;
            int encodedSizeWithTag98 = encodedSizeWithTag97 + (num84 != null ? ProtoAdapter.INT32.encodedSizeWithTag(119, num84) : 0);
            Integer num85 = monitoringStatsMessage.service_transmitData_submittedAppDataLogs;
            int encodedSizeWithTag99 = encodedSizeWithTag98 + (num85 != null ? ProtoAdapter.INT32.encodedSizeWithTag(120, num85) : 0);
            Integer num86 = monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacket;
            int encodedSizeWithTag100 = encodedSizeWithTag99 + (num86 != null ? ProtoAdapter.INT32.encodedSizeWithTag(121, num86) : 0);
            Integer num87 = monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacketAccepted;
            int encodedSizeWithTag101 = encodedSizeWithTag100 + (num87 != null ? ProtoAdapter.INT32.encodedSizeWithTag(122, num87) : 0);
            Integer num88 = monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacket;
            int encodedSizeWithTag102 = encodedSizeWithTag101 + (num88 != null ? ProtoAdapter.INT32.encodedSizeWithTag(123, num88) : 0);
            Integer num89 = monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacketAccepted;
            int encodedSizeWithTag103 = encodedSizeWithTag102 + (num89 != null ? ProtoAdapter.INT32.encodedSizeWithTag(124, num89) : 0);
            Integer num90 = monitoringStatsMessage.ndt_checkForTest;
            int encodedSizeWithTag104 = encodedSizeWithTag103 + (num90 != null ? ProtoAdapter.INT32.encodedSizeWithTag(125, num90) : 0);
            Integer num91 = monitoringStatsMessage.ndt_runTest;
            int encodedSizeWithTag105 = encodedSizeWithTag104 + (num91 != null ? ProtoAdapter.INT32.encodedSizeWithTag(126, num91) : 0);
            Integer num92 = monitoringStatsMessage.ndt_testCompleted;
            if (num92 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(127, num92);
            }
            return monitoringStatsMessage.unknownFields().size() + encodedSizeWithTag105 + i;
        }

        public MonitoringStatsMessage redact(MonitoringStatsMessage monitoringStatsMessage) {
            Builder newBuilder = monitoringStatsMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MonitoringStatsMessage(Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, Long l3, Long l4, Long l5, Long l6, Long l7, Integer num6, Long l8, Integer num7, Long l9, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, String str, Integer num43, Integer num44, Integer num45, Long l10, String str2, String str3, Long l11, Integer num46, Integer num47, Integer num48, Integer num49, Integer num50, Integer num51, Integer num52, Integer num53, Integer num54, Integer num55, Integer num56, Integer num57, Integer num58, Integer num59, Integer num60, Integer num61, Integer num62, Integer num63, Integer num64, Integer num65, Integer num66, Integer num67, Integer num68, Integer num69, Integer num70, Integer num71, Integer num72, Integer num73, Integer num74, Integer num75, Integer num76, Integer num77, Integer num78, Integer num79, Integer num80, Integer num81, Integer num82, Integer num83, Integer num84, Integer num85, Integer num86, Integer num87, Integer num88, Integer num89, Integer num90, Integer num91, Integer num92) {
        this(num, l, l2, num2, num3, num4, num5, l3, l4, l5, l6, l7, num6, l8, num7, l9, num8, num9, num10, num11, num12, num13, num14, num15, num16, num17, num18, num19, num20, num21, num22, num23, num24, num25, num26, num27, num28, num29, num30, num31, num32, num33, num34, num35, num36, num37, num38, num39, num40, num41, num42, str, num43, num44, num45, l10, str2, str3, l11, num46, num47, num48, num49, num50, num51, num52, num53, num54, num55, num56, num57, num58, num59, num60, num61, num62, num63, num64, num65, num66, num67, num68, num69, num70, num71, num72, num73, num74, num75, num76, num77, num78, num79, num80, num81, num82, num83, num84, num85, num86, num87, num88, num89, num90, num91, num92, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MonitoringStatsMessage)) {
            return false;
        }
        MonitoringStatsMessage monitoringStatsMessage = (MonitoringStatsMessage) obj;
        if (!unknownFields().equals(monitoringStatsMessage.unknownFields()) || !Internal.equals(this.status_index, monitoringStatsMessage.status_index) || !Internal.equals(this.system_clock_up_time, monitoringStatsMessage.system_clock_up_time) || !Internal.equals(this.system_clock_elapsed_time, monitoringStatsMessage.system_clock_elapsed_time) || !Internal.equals(this.most_foreground_app_by_pus_time, monitoringStatsMessage.most_foreground_app_by_pus_time) || !Internal.equals(this.most_foreground_app_by_sdk_time, monitoringStatsMessage.most_foreground_app_by_sdk_time) || !Internal.equals(this.is_running, monitoringStatsMessage.is_running) || !Internal.equals(this.is_storage_full, monitoringStatsMessage.is_storage_full) || !Internal.equals(this.database_size, monitoringStatsMessage.database_size) || !Internal.equals(this.app_memory, monitoringStatsMessage.app_memory) || !Internal.equals(this.system_current_memory, monitoringStatsMessage.system_current_memory) || !Internal.equals(this.system_available_memory, monitoringStatsMessage.system_available_memory) || !Internal.equals(this.system_total_internal_storage, monitoringStatsMessage.system_total_internal_storage) || !Internal.equals(this.count_installed_apps, monitoringStatsMessage.count_installed_apps) || !Internal.equals(this.system_uptime, monitoringStatsMessage.system_uptime) || !Internal.equals(this.service_monitoring_dataCollectionCycles, monitoringStatsMessage.service_monitoring_dataCollectionCycles) || !Internal.equals(this.service_monitoring_dataCollectionTime, monitoringStatsMessage.service_monitoring_dataCollectionTime) || !Internal.equals(this.service_monitoring_updateDatabase, monitoringStatsMessage.service_monitoring_updateDatabase) || !Internal.equals(this.service_monitoring_updateDatabase_logData_recordInsertAttempts, monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertAttempts) || !Internal.equals(this.service_monitoring_updateDatabase_logData_recordInsertsFailed, monitoringStatsMessage.service_monitoring_updateDatabase_logData_recordInsertsFailed) || !Internal.equals(this.service_transmitData_submittedLogs, monitoringStatsMessage.service_transmitData_submittedLogs) || !Internal.equals(this.service_transmitData_submittedLogsAccepted, monitoringStatsMessage.service_transmitData_submittedLogsAccepted) || !Internal.equals(this.service_transmitData_submittedBatteryLogs, monitoringStatsMessage.service_transmitData_submittedBatteryLogs) || !Internal.equals(this.service_transmitData_submittedBatteryLogsAccepted, monitoringStatsMessage.service_transmitData_submittedBatteryLogsAccepted) || !Internal.equals(this.logger_totalErrorCount, monitoringStatsMessage.logger_totalErrorCount) || !Internal.equals(this.receiver_onReceive, monitoringStatsMessage.receiver_onReceive) || !Internal.equals(this.receiver_packageChanged, monitoringStatsMessage.receiver_packageChanged) || !Internal.equals(this.receiver_bootComplete, monitoringStatsMessage.receiver_bootComplete) || !Internal.equals(this.receiver_connectionChanged, monitoringStatsMessage.receiver_connectionChanged) || !Internal.equals(this.startMonitoring, monitoringStatsMessage.startMonitoring) || !Internal.equals(this.startMonitoring_storageFull, monitoringStatsMessage.startMonitoring_storageFull) || !Internal.equals(this.startMonitoring_startService, monitoringStatsMessage.startMonitoring_startService) || !Internal.equals(this.stopMonitoring, monitoringStatsMessage.stopMonitoring) || !Internal.equals(this.service_monitor, monitoringStatsMessage.service_monitor) || !Internal.equals(this.service_transmitData, monitoringStatsMessage.service_transmitData) || !Internal.equals(this.service_onCreate, monitoringStatsMessage.service_onCreate) || !Internal.equals(this.service_onLowMemory, monitoringStatsMessage.service_onLowMemory) || !Internal.equals(this.service_onDestroy, monitoringStatsMessage.service_onDestroy) || !Internal.equals(this.service_monitoring_initialize, monitoringStatsMessage.service_monitoring_initialize) || !Internal.equals(this.service_monitoring_validityCheckFailure, monitoringStatsMessage.service_monitoring_validityCheckFailure) || !Internal.equals(this.initialize, monitoringStatsMessage.initialize) || !Internal.equals(this.initialize_setupController, monitoringStatsMessage.initialize_setupController) || !Internal.equals(this.initialize_controllerSetup, monitoringStatsMessage.initialize_controllerSetup) || !Internal.equals(this.initialize_resetController, monitoringStatsMessage.initialize_resetController) || !Internal.equals(this.initialize_resetControllerFailed, monitoringStatsMessage.initialize_resetControllerFailed) || !Internal.equals(this.start, monitoringStatsMessage.start) || !Internal.equals(this.stop, monitoringStatsMessage.stop) || !Internal.equals(this.initialSetup_start, monitoringStatsMessage.initialSetup_start) || !Internal.equals(this.initialSetup_run, monitoringStatsMessage.initialSetup_run) || !Internal.equals(this.initialSetup_storageFull, monitoringStatsMessage.initialSetup_storageFull) || !Internal.equals(this.initialSetup_complete, monitoringStatsMessage.initialSetup_complete) || !Internal.equals(this.process_run_time, monitoringStatsMessage.process_run_time) || !Internal.equals(this.report_date, monitoringStatsMessage.report_date) || !Internal.equals(this.timeChangeBack, monitoringStatsMessage.timeChangeBack) || !Internal.equals(this.service_transmitData_submittedCPULogs, monitoringStatsMessage.service_transmitData_submittedCPULogs) || !Internal.equals(this.service_transmitData_submittedCPULogsAccepted, monitoringStatsMessage.service_transmitData_submittedCPULogsAccepted) || !Internal.equals(this.system_available_internal_storage, monitoringStatsMessage.system_available_internal_storage) || !Internal.equals(this.most_foreground_app_by_pus_package_name, monitoringStatsMessage.most_foreground_app_by_pus_package_name) || !Internal.equals(this.most_foreground_app_by_sdk_package_name, monitoringStatsMessage.most_foreground_app_by_sdk_package_name) || !Internal.equals(this.service_monitoring_upTime, monitoringStatsMessage.service_monitoring_upTime) || !Internal.equals(this.service_monitoring_purgeDatabase, monitoringStatsMessage.service_monitoring_purgeDatabase) || !Internal.equals(this.service_monitoring_purgeDatabase_logDataRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_logDataRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_appUsageEventsRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_appUsageEventsRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_systemCpuLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_systemCpuLogRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_batteryLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_batteryLogRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_wifiInfoLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_wifiInfoLogRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords) || !Internal.equals(this.service_monitoring_purgeDatabase_mobileInfoLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_mobileInfoLogRecords) || !Internal.equals(this.timeChangeForward, monitoringStatsMessage.timeChangeForward) || !Internal.equals(this.permissions_accepted, monitoringStatsMessage.permissions_accepted) || !Internal.equals(this.service_monitoring_purgeDatabase_locationLogRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_locationLogRecords) || !Internal.equals(this.service_transmitData_submittedMobileLogs, monitoringStatsMessage.service_transmitData_submittedMobileLogs) || !Internal.equals(this.service_transmitData_submittedWifiLogs, monitoringStatsMessage.service_transmitData_submittedWifiLogs) || !Internal.equals(this.service_transmitData_submittedNetworkPacketSent, monitoringStatsMessage.service_transmitData_submittedNetworkPacketSent) || !Internal.equals(this.service_transmitData_submittedNetworkPacketAccepted, monitoringStatsMessage.service_transmitData_submittedNetworkPacketAccepted) || !Internal.equals(this.service_transmitData_submittedLocationLogs, monitoringStatsMessage.service_transmitData_submittedLocationLogs) || !Internal.equals(this.service_transmitData_submittedLocationPacketSent, monitoringStatsMessage.service_transmitData_submittedLocationPacketSent) || !Internal.equals(this.service_transmitData_submittedLocationPacketAccepted, monitoringStatsMessage.service_transmitData_submittedLocationPacketAccepted) || !Internal.equals(this.individual_permissions_accepted, monitoringStatsMessage.individual_permissions_accepted) || !Internal.equals(this.service_monitoring_purgeDatabase_appSessions, monitoringStatsMessage.service_monitoring_purgeDatabase_appSessions) || !Internal.equals(this.service_monitoring_purgeDatabase_appDataUsageEvents, monitoringStatsMessage.service_monitoring_purgeDatabase_appDataUsageEvents) || !Internal.equals(this.service_transmitData_submittedNetworkPacket, monitoringStatsMessage.service_transmitData_submittedNetworkPacket) || !Internal.equals(this.service_transmitData_submittedLocationPacket, monitoringStatsMessage.service_transmitData_submittedLocationPacket) || !Internal.equals(this.service_transmitData_submittedAppSessions, monitoringStatsMessage.service_transmitData_submittedAppSessions) || !Internal.equals(this.service_transmitData_submittedDataUsageEvents, monitoringStatsMessage.service_transmitData_submittedDataUsageEvents) || !Internal.equals(this.service_transmitData_submittedApplicationEventsPacket, monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacket) || !Internal.equals(this.service_transmitData_submittedApplicationEventsPacketAccepted, monitoringStatsMessage.service_transmitData_submittedApplicationEventsPacketAccepted) || !Internal.equals(this.mnsi_collected, monitoringStatsMessage.mnsi_collected) || !Internal.equals(this.location_collected, monitoringStatsMessage.location_collected) || !Internal.equals(this.systemBatteryInfo_collected, monitoringStatsMessage.systemBatteryInfo_collected) || !Internal.equals(this.appSessions_collected, monitoringStatsMessage.appSessions_collected) || !Internal.equals(this.appDataUsageEvents_collected, monitoringStatsMessage.appDataUsageEvents_collected) || !Internal.equals(this.service_monitoring_purgeDatabase_noSignalRecords, monitoringStatsMessage.service_monitoring_purgeDatabase_noSignalRecords) || !Internal.equals(this.service_transmitData_submittedNoSignalLogs, monitoringStatsMessage.service_transmitData_submittedNoSignalLogs) || !Internal.equals(this.service_transmitData_submittedSystemCPULogs, monitoringStatsMessage.service_transmitData_submittedSystemCPULogs) || !Internal.equals(this.service_transmitData_submittedSystemCPULogPacket, monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacket) || !Internal.equals(this.service_transmitData_submittedSystemCPULogPacketAccepted, monitoringStatsMessage.service_transmitData_submittedSystemCPULogPacketAccepted) || !Internal.equals(this.service_transmitData_submittedBatteryLogsPacket, monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacket) || !Internal.equals(this.service_transmitData_submittedBatteryLogsPacketAccepted, monitoringStatsMessage.service_transmitData_submittedBatteryLogsPacketAccepted) || !Internal.equals(this.service_transmitData_submittedAppDataLogs, monitoringStatsMessage.service_transmitData_submittedAppDataLogs) || !Internal.equals(this.service_transmitData_submittedAppDataLogsPacket, monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacket) || !Internal.equals(this.service_transmitData_submittedAppDataLogsPacketAccepted, monitoringStatsMessage.service_transmitData_submittedAppDataLogsPacketAccepted) || !Internal.equals(this.service_transmitData_submittedAppUsageEventsPacket, monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacket) || !Internal.equals(this.service_transmitData_submittedAppUsageEventsPacketAccepted, monitoringStatsMessage.service_transmitData_submittedAppUsageEventsPacketAccepted) || !Internal.equals(this.ndt_checkForTest, monitoringStatsMessage.ndt_checkForTest) || !Internal.equals(this.ndt_runTest, monitoringStatsMessage.ndt_runTest) || !Internal.equals(this.ndt_testCompleted, monitoringStatsMessage.ndt_testCompleted)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.status_index;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.system_clock_up_time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.system_clock_elapsed_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.most_foreground_app_by_pus_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.most_foreground_app_by_sdk_time;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.is_running;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.is_storage_full;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l3 = this.database_size;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.app_memory;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.system_current_memory;
        int hashCode11 = (hashCode10 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.system_available_memory;
        int hashCode12 = (hashCode11 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.system_total_internal_storage;
        int hashCode13 = (hashCode12 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num6 = this.count_installed_apps;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l8 = this.system_uptime;
        int hashCode15 = (hashCode14 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Integer num7 = this.service_monitoring_dataCollectionCycles;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l9 = this.service_monitoring_dataCollectionTime;
        int hashCode17 = (hashCode16 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Integer num8 = this.service_monitoring_updateDatabase;
        int hashCode18 = (hashCode17 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.service_monitoring_updateDatabase_logData_recordInsertAttempts;
        int hashCode19 = (hashCode18 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.service_monitoring_updateDatabase_logData_recordInsertsFailed;
        int hashCode20 = (hashCode19 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.service_transmitData_submittedLogs;
        int hashCode21 = (hashCode20 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.service_transmitData_submittedLogsAccepted;
        int hashCode22 = (hashCode21 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.service_transmitData_submittedBatteryLogs;
        int hashCode23 = (hashCode22 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.service_transmitData_submittedBatteryLogsAccepted;
        int hashCode24 = (hashCode23 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.logger_totalErrorCount;
        int hashCode25 = (hashCode24 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.receiver_onReceive;
        int hashCode26 = (hashCode25 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.receiver_packageChanged;
        int hashCode27 = (hashCode26 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.receiver_bootComplete;
        int hashCode28 = (hashCode27 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.receiver_connectionChanged;
        int hashCode29 = (hashCode28 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.startMonitoring;
        int hashCode30 = (hashCode29 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.startMonitoring_storageFull;
        int hashCode31 = (hashCode30 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Integer num22 = this.startMonitoring_startService;
        int hashCode32 = (hashCode31 + (num22 != null ? num22.hashCode() : 0)) * 37;
        Integer num23 = this.stopMonitoring;
        int hashCode33 = (hashCode32 + (num23 != null ? num23.hashCode() : 0)) * 37;
        Integer num24 = this.service_monitor;
        int hashCode34 = (hashCode33 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.service_transmitData;
        int hashCode35 = (hashCode34 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Integer num26 = this.service_onCreate;
        int hashCode36 = (hashCode35 + (num26 != null ? num26.hashCode() : 0)) * 37;
        Integer num27 = this.service_onLowMemory;
        int hashCode37 = (hashCode36 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Integer num28 = this.service_onDestroy;
        int hashCode38 = (hashCode37 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.service_monitoring_initialize;
        int hashCode39 = (hashCode38 + (num29 != null ? num29.hashCode() : 0)) * 37;
        Integer num30 = this.service_monitoring_validityCheckFailure;
        int hashCode40 = (hashCode39 + (num30 != null ? num30.hashCode() : 0)) * 37;
        Integer num31 = this.initialize;
        int hashCode41 = (hashCode40 + (num31 != null ? num31.hashCode() : 0)) * 37;
        Integer num32 = this.initialize_setupController;
        int hashCode42 = (hashCode41 + (num32 != null ? num32.hashCode() : 0)) * 37;
        Integer num33 = this.initialize_controllerSetup;
        int hashCode43 = (hashCode42 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Integer num34 = this.initialize_resetController;
        int hashCode44 = (hashCode43 + (num34 != null ? num34.hashCode() : 0)) * 37;
        Integer num35 = this.initialize_resetControllerFailed;
        int hashCode45 = (hashCode44 + (num35 != null ? num35.hashCode() : 0)) * 37;
        Integer num36 = this.start;
        int hashCode46 = (hashCode45 + (num36 != null ? num36.hashCode() : 0)) * 37;
        Integer num37 = this.stop;
        int hashCode47 = (hashCode46 + (num37 != null ? num37.hashCode() : 0)) * 37;
        Integer num38 = this.initialSetup_start;
        int hashCode48 = (hashCode47 + (num38 != null ? num38.hashCode() : 0)) * 37;
        Integer num39 = this.initialSetup_run;
        int hashCode49 = (hashCode48 + (num39 != null ? num39.hashCode() : 0)) * 37;
        Integer num40 = this.initialSetup_storageFull;
        int hashCode50 = (hashCode49 + (num40 != null ? num40.hashCode() : 0)) * 37;
        Integer num41 = this.initialSetup_complete;
        int hashCode51 = (hashCode50 + (num41 != null ? num41.hashCode() : 0)) * 37;
        Integer num42 = this.process_run_time;
        int hashCode52 = (hashCode51 + (num42 != null ? num42.hashCode() : 0)) * 37;
        String str = this.report_date;
        int hashCode53 = (hashCode52 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num43 = this.timeChangeBack;
        int hashCode54 = (hashCode53 + (num43 != null ? num43.hashCode() : 0)) * 37;
        Integer num44 = this.service_transmitData_submittedCPULogs;
        int hashCode55 = (hashCode54 + (num44 != null ? num44.hashCode() : 0)) * 37;
        Integer num45 = this.service_transmitData_submittedCPULogsAccepted;
        int hashCode56 = (hashCode55 + (num45 != null ? num45.hashCode() : 0)) * 37;
        Long l10 = this.system_available_internal_storage;
        int hashCode57 = (hashCode56 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str2 = this.most_foreground_app_by_pus_package_name;
        int hashCode58 = (hashCode57 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.most_foreground_app_by_sdk_package_name;
        int hashCode59 = (hashCode58 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l11 = this.service_monitoring_upTime;
        int hashCode60 = (hashCode59 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Integer num46 = this.service_monitoring_purgeDatabase;
        int hashCode61 = (hashCode60 + (num46 != null ? num46.hashCode() : 0)) * 37;
        Integer num47 = this.service_monitoring_purgeDatabase_logDataRecords;
        int hashCode62 = (hashCode61 + (num47 != null ? num47.hashCode() : 0)) * 37;
        Integer num48 = this.service_monitoring_purgeDatabase_appUsageEventsRecords;
        int hashCode63 = (hashCode62 + (num48 != null ? num48.hashCode() : 0)) * 37;
        Integer num49 = this.service_monitoring_purgeDatabase_systemCpuLogRecords;
        int hashCode64 = (hashCode63 + (num49 != null ? num49.hashCode() : 0)) * 37;
        Integer num50 = this.service_monitoring_purgeDatabase_batteryLogRecords;
        int hashCode65 = (hashCode64 + (num50 != null ? num50.hashCode() : 0)) * 37;
        Integer num51 = this.service_monitoring_purgeDatabase_wifiInfoLogRecords;
        int hashCode66 = (hashCode65 + (num51 != null ? num51.hashCode() : 0)) * 37;
        Integer num52 = this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
        int hashCode67 = (hashCode66 + (num52 != null ? num52.hashCode() : 0)) * 37;
        Integer num53 = this.service_monitoring_purgeDatabase_mobileInfoLogRecords;
        int hashCode68 = (hashCode67 + (num53 != null ? num53.hashCode() : 0)) * 37;
        Integer num54 = this.timeChangeForward;
        int hashCode69 = (hashCode68 + (num54 != null ? num54.hashCode() : 0)) * 37;
        Integer num55 = this.permissions_accepted;
        int hashCode70 = (hashCode69 + (num55 != null ? num55.hashCode() : 0)) * 37;
        Integer num56 = this.service_monitoring_purgeDatabase_locationLogRecords;
        int hashCode71 = (hashCode70 + (num56 != null ? num56.hashCode() : 0)) * 37;
        Integer num57 = this.service_transmitData_submittedMobileLogs;
        int hashCode72 = (hashCode71 + (num57 != null ? num57.hashCode() : 0)) * 37;
        Integer num58 = this.service_transmitData_submittedWifiLogs;
        int hashCode73 = (hashCode72 + (num58 != null ? num58.hashCode() : 0)) * 37;
        Integer num59 = this.service_transmitData_submittedNetworkPacketSent;
        int hashCode74 = (hashCode73 + (num59 != null ? num59.hashCode() : 0)) * 37;
        Integer num60 = this.service_transmitData_submittedNetworkPacketAccepted;
        int hashCode75 = (hashCode74 + (num60 != null ? num60.hashCode() : 0)) * 37;
        Integer num61 = this.service_transmitData_submittedLocationLogs;
        int hashCode76 = (hashCode75 + (num61 != null ? num61.hashCode() : 0)) * 37;
        Integer num62 = this.service_transmitData_submittedLocationPacketSent;
        int hashCode77 = (hashCode76 + (num62 != null ? num62.hashCode() : 0)) * 37;
        Integer num63 = this.service_transmitData_submittedLocationPacketAccepted;
        int hashCode78 = (hashCode77 + (num63 != null ? num63.hashCode() : 0)) * 37;
        Integer num64 = this.individual_permissions_accepted;
        int hashCode79 = (hashCode78 + (num64 != null ? num64.hashCode() : 0)) * 37;
        Integer num65 = this.service_monitoring_purgeDatabase_appSessions;
        int hashCode80 = (hashCode79 + (num65 != null ? num65.hashCode() : 0)) * 37;
        Integer num66 = this.service_monitoring_purgeDatabase_appDataUsageEvents;
        int hashCode81 = (hashCode80 + (num66 != null ? num66.hashCode() : 0)) * 37;
        Integer num67 = this.service_transmitData_submittedNetworkPacket;
        int hashCode82 = (hashCode81 + (num67 != null ? num67.hashCode() : 0)) * 37;
        Integer num68 = this.service_transmitData_submittedLocationPacket;
        int hashCode83 = (hashCode82 + (num68 != null ? num68.hashCode() : 0)) * 37;
        Integer num69 = this.service_transmitData_submittedAppSessions;
        int hashCode84 = (hashCode83 + (num69 != null ? num69.hashCode() : 0)) * 37;
        Integer num70 = this.service_transmitData_submittedDataUsageEvents;
        int hashCode85 = (hashCode84 + (num70 != null ? num70.hashCode() : 0)) * 37;
        Integer num71 = this.service_transmitData_submittedApplicationEventsPacket;
        int hashCode86 = (hashCode85 + (num71 != null ? num71.hashCode() : 0)) * 37;
        Integer num72 = this.service_transmitData_submittedApplicationEventsPacketAccepted;
        int hashCode87 = (hashCode86 + (num72 != null ? num72.hashCode() : 0)) * 37;
        Integer num73 = this.mnsi_collected;
        int hashCode88 = (hashCode87 + (num73 != null ? num73.hashCode() : 0)) * 37;
        Integer num74 = this.location_collected;
        int hashCode89 = (hashCode88 + (num74 != null ? num74.hashCode() : 0)) * 37;
        Integer num75 = this.systemBatteryInfo_collected;
        int hashCode90 = (hashCode89 + (num75 != null ? num75.hashCode() : 0)) * 37;
        Integer num76 = this.appSessions_collected;
        int hashCode91 = (hashCode90 + (num76 != null ? num76.hashCode() : 0)) * 37;
        Integer num77 = this.appDataUsageEvents_collected;
        int hashCode92 = (hashCode91 + (num77 != null ? num77.hashCode() : 0)) * 37;
        Integer num78 = this.service_monitoring_purgeDatabase_noSignalRecords;
        int hashCode93 = (hashCode92 + (num78 != null ? num78.hashCode() : 0)) * 37;
        Integer num79 = this.service_transmitData_submittedNoSignalLogs;
        int hashCode94 = (hashCode93 + (num79 != null ? num79.hashCode() : 0)) * 37;
        Integer num80 = this.service_transmitData_submittedSystemCPULogs;
        int hashCode95 = (hashCode94 + (num80 != null ? num80.hashCode() : 0)) * 37;
        Integer num81 = this.service_transmitData_submittedSystemCPULogPacket;
        int hashCode96 = (hashCode95 + (num81 != null ? num81.hashCode() : 0)) * 37;
        Integer num82 = this.service_transmitData_submittedSystemCPULogPacketAccepted;
        int hashCode97 = (hashCode96 + (num82 != null ? num82.hashCode() : 0)) * 37;
        Integer num83 = this.service_transmitData_submittedBatteryLogsPacket;
        int hashCode98 = (hashCode97 + (num83 != null ? num83.hashCode() : 0)) * 37;
        Integer num84 = this.service_transmitData_submittedBatteryLogsPacketAccepted;
        int hashCode99 = (hashCode98 + (num84 != null ? num84.hashCode() : 0)) * 37;
        Integer num85 = this.service_transmitData_submittedAppDataLogs;
        int hashCode100 = (hashCode99 + (num85 != null ? num85.hashCode() : 0)) * 37;
        Integer num86 = this.service_transmitData_submittedAppDataLogsPacket;
        int hashCode101 = (hashCode100 + (num86 != null ? num86.hashCode() : 0)) * 37;
        Integer num87 = this.service_transmitData_submittedAppDataLogsPacketAccepted;
        int hashCode102 = (hashCode101 + (num87 != null ? num87.hashCode() : 0)) * 37;
        Integer num88 = this.service_transmitData_submittedAppUsageEventsPacket;
        int hashCode103 = (hashCode102 + (num88 != null ? num88.hashCode() : 0)) * 37;
        Integer num89 = this.service_transmitData_submittedAppUsageEventsPacketAccepted;
        int hashCode104 = (hashCode103 + (num89 != null ? num89.hashCode() : 0)) * 37;
        Integer num90 = this.ndt_checkForTest;
        int hashCode105 = (hashCode104 + (num90 != null ? num90.hashCode() : 0)) * 37;
        Integer num91 = this.ndt_runTest;
        int hashCode106 = (hashCode105 + (num91 != null ? num91.hashCode() : 0)) * 37;
        Integer num92 = this.ndt_testCompleted;
        if (num92 != null) {
            i2 = num92.hashCode();
        }
        int i3 = hashCode106 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.status_index != null) {
            sb.append(", status_index=");
            sb.append(this.status_index);
        }
        if (this.system_clock_up_time != null) {
            sb.append(", system_clock_up_time=");
            sb.append(this.system_clock_up_time);
        }
        if (this.system_clock_elapsed_time != null) {
            sb.append(", system_clock_elapsed_time=");
            sb.append(this.system_clock_elapsed_time);
        }
        if (this.most_foreground_app_by_pus_time != null) {
            sb.append(", most_foreground_app_by_pus_time=");
            sb.append(this.most_foreground_app_by_pus_time);
        }
        if (this.most_foreground_app_by_sdk_time != null) {
            sb.append(", most_foreground_app_by_sdk_time=");
            sb.append(this.most_foreground_app_by_sdk_time);
        }
        if (this.is_running != null) {
            sb.append(", is_running=");
            sb.append(this.is_running);
        }
        if (this.is_storage_full != null) {
            sb.append(", is_storage_full=");
            sb.append(this.is_storage_full);
        }
        if (this.database_size != null) {
            sb.append(", database_size=");
            sb.append(this.database_size);
        }
        if (this.app_memory != null) {
            sb.append(", app_memory=");
            sb.append(this.app_memory);
        }
        if (this.system_current_memory != null) {
            sb.append(", system_current_memory=");
            sb.append(this.system_current_memory);
        }
        if (this.system_available_memory != null) {
            sb.append(", system_available_memory=");
            sb.append(this.system_available_memory);
        }
        if (this.system_total_internal_storage != null) {
            sb.append(", system_total_internal_storage=");
            sb.append(this.system_total_internal_storage);
        }
        if (this.count_installed_apps != null) {
            sb.append(", count_installed_apps=");
            sb.append(this.count_installed_apps);
        }
        if (this.system_uptime != null) {
            sb.append(", system_uptime=");
            sb.append(this.system_uptime);
        }
        if (this.service_monitoring_dataCollectionCycles != null) {
            sb.append(", service_monitoring_dataCollectionCycles=");
            sb.append(this.service_monitoring_dataCollectionCycles);
        }
        if (this.service_monitoring_dataCollectionTime != null) {
            sb.append(", service_monitoring_dataCollectionTime=");
            sb.append(this.service_monitoring_dataCollectionTime);
        }
        if (this.service_monitoring_updateDatabase != null) {
            sb.append(", service_monitoring_updateDatabase=");
            sb.append(this.service_monitoring_updateDatabase);
        }
        if (this.service_monitoring_updateDatabase_logData_recordInsertAttempts != null) {
            sb.append(", service_monitoring_updateDatabase_logData_recordInsertAttempts=");
            sb.append(this.service_monitoring_updateDatabase_logData_recordInsertAttempts);
        }
        if (this.service_monitoring_updateDatabase_logData_recordInsertsFailed != null) {
            sb.append(", service_monitoring_updateDatabase_logData_recordInsertsFailed=");
            sb.append(this.service_monitoring_updateDatabase_logData_recordInsertsFailed);
        }
        if (this.service_transmitData_submittedLogs != null) {
            sb.append(", service_transmitData_submittedLogs=");
            sb.append(this.service_transmitData_submittedLogs);
        }
        if (this.service_transmitData_submittedLogsAccepted != null) {
            sb.append(", service_transmitData_submittedLogsAccepted=");
            sb.append(this.service_transmitData_submittedLogsAccepted);
        }
        if (this.service_transmitData_submittedBatteryLogs != null) {
            sb.append(", service_transmitData_submittedBatteryLogs=");
            sb.append(this.service_transmitData_submittedBatteryLogs);
        }
        if (this.service_transmitData_submittedBatteryLogsAccepted != null) {
            sb.append(", service_transmitData_submittedBatteryLogsAccepted=");
            sb.append(this.service_transmitData_submittedBatteryLogsAccepted);
        }
        if (this.logger_totalErrorCount != null) {
            sb.append(", logger_totalErrorCount=");
            sb.append(this.logger_totalErrorCount);
        }
        if (this.receiver_onReceive != null) {
            sb.append(", receiver_onReceive=");
            sb.append(this.receiver_onReceive);
        }
        if (this.receiver_packageChanged != null) {
            sb.append(", receiver_packageChanged=");
            sb.append(this.receiver_packageChanged);
        }
        if (this.receiver_bootComplete != null) {
            sb.append(", receiver_bootComplete=");
            sb.append(this.receiver_bootComplete);
        }
        if (this.receiver_connectionChanged != null) {
            sb.append(", receiver_connectionChanged=");
            sb.append(this.receiver_connectionChanged);
        }
        if (this.startMonitoring != null) {
            sb.append(", startMonitoring=");
            sb.append(this.startMonitoring);
        }
        if (this.startMonitoring_storageFull != null) {
            sb.append(", startMonitoring_storageFull=");
            sb.append(this.startMonitoring_storageFull);
        }
        if (this.startMonitoring_startService != null) {
            sb.append(", startMonitoring_startService=");
            sb.append(this.startMonitoring_startService);
        }
        if (this.stopMonitoring != null) {
            sb.append(", stopMonitoring=");
            sb.append(this.stopMonitoring);
        }
        if (this.service_monitor != null) {
            sb.append(", service_monitor=");
            sb.append(this.service_monitor);
        }
        if (this.service_transmitData != null) {
            sb.append(", service_transmitData=");
            sb.append(this.service_transmitData);
        }
        if (this.service_onCreate != null) {
            sb.append(", service_onCreate=");
            sb.append(this.service_onCreate);
        }
        if (this.service_onLowMemory != null) {
            sb.append(", service_onLowMemory=");
            sb.append(this.service_onLowMemory);
        }
        if (this.service_onDestroy != null) {
            sb.append(", service_onDestroy=");
            sb.append(this.service_onDestroy);
        }
        if (this.service_monitoring_initialize != null) {
            sb.append(", service_monitoring_initialize=");
            sb.append(this.service_monitoring_initialize);
        }
        if (this.service_monitoring_validityCheckFailure != null) {
            sb.append(", service_monitoring_validityCheckFailure=");
            sb.append(this.service_monitoring_validityCheckFailure);
        }
        if (this.initialize != null) {
            sb.append(", initialize=");
            sb.append(this.initialize);
        }
        if (this.initialize_setupController != null) {
            sb.append(", initialize_setupController=");
            sb.append(this.initialize_setupController);
        }
        if (this.initialize_controllerSetup != null) {
            sb.append(", initialize_controllerSetup=");
            sb.append(this.initialize_controllerSetup);
        }
        if (this.initialize_resetController != null) {
            sb.append(", initialize_resetController=");
            sb.append(this.initialize_resetController);
        }
        if (this.initialize_resetControllerFailed != null) {
            sb.append(", initialize_resetControllerFailed=");
            sb.append(this.initialize_resetControllerFailed);
        }
        if (this.start != null) {
            sb.append(", start=");
            sb.append(this.start);
        }
        if (this.stop != null) {
            sb.append(", stop=");
            sb.append(this.stop);
        }
        if (this.initialSetup_start != null) {
            sb.append(", initialSetup_start=");
            sb.append(this.initialSetup_start);
        }
        if (this.initialSetup_run != null) {
            sb.append(", initialSetup_run=");
            sb.append(this.initialSetup_run);
        }
        if (this.initialSetup_storageFull != null) {
            sb.append(", initialSetup_storageFull=");
            sb.append(this.initialSetup_storageFull);
        }
        if (this.initialSetup_complete != null) {
            sb.append(", initialSetup_complete=");
            sb.append(this.initialSetup_complete);
        }
        if (this.process_run_time != null) {
            sb.append(", process_run_time=");
            sb.append(this.process_run_time);
        }
        if (this.report_date != null) {
            sb.append(", report_date=");
            sb.append(this.report_date);
        }
        if (this.timeChangeBack != null) {
            sb.append(", timeChangeBack=");
            sb.append(this.timeChangeBack);
        }
        if (this.service_transmitData_submittedCPULogs != null) {
            sb.append(", service_transmitData_submittedCPULogs=");
            sb.append(this.service_transmitData_submittedCPULogs);
        }
        if (this.service_transmitData_submittedCPULogsAccepted != null) {
            sb.append(", service_transmitData_submittedCPULogsAccepted=");
            sb.append(this.service_transmitData_submittedCPULogsAccepted);
        }
        if (this.system_available_internal_storage != null) {
            sb.append(", system_available_internal_storage=");
            sb.append(this.system_available_internal_storage);
        }
        if (this.most_foreground_app_by_pus_package_name != null) {
            sb.append(", most_foreground_app_by_pus_package_name=");
            sb.append(this.most_foreground_app_by_pus_package_name);
        }
        if (this.most_foreground_app_by_sdk_package_name != null) {
            sb.append(", most_foreground_app_by_sdk_package_name=");
            sb.append(this.most_foreground_app_by_sdk_package_name);
        }
        if (this.service_monitoring_upTime != null) {
            sb.append(", service_monitoring_upTime=");
            sb.append(this.service_monitoring_upTime);
        }
        if (this.service_monitoring_purgeDatabase != null) {
            sb.append(", service_monitoring_purgeDatabase=");
            sb.append(this.service_monitoring_purgeDatabase);
        }
        if (this.service_monitoring_purgeDatabase_logDataRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_logDataRecords=");
            sb.append(this.service_monitoring_purgeDatabase_logDataRecords);
        }
        if (this.service_monitoring_purgeDatabase_appUsageEventsRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_appUsageEventsRecords=");
            sb.append(this.service_monitoring_purgeDatabase_appUsageEventsRecords);
        }
        if (this.service_monitoring_purgeDatabase_systemCpuLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_systemCpuLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_systemCpuLogRecords);
        }
        if (this.service_monitoring_purgeDatabase_batteryLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_batteryLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_batteryLogRecords);
        }
        if (this.service_monitoring_purgeDatabase_wifiInfoLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_wifiInfoLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_wifiInfoLogRecords);
        }
        if (this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_mobileSignalInfoLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords);
        }
        if (this.service_monitoring_purgeDatabase_mobileInfoLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_mobileInfoLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_mobileInfoLogRecords);
        }
        if (this.timeChangeForward != null) {
            sb.append(", timeChangeForward=");
            sb.append(this.timeChangeForward);
        }
        if (this.permissions_accepted != null) {
            sb.append(", permissions_accepted=");
            sb.append(this.permissions_accepted);
        }
        if (this.service_monitoring_purgeDatabase_locationLogRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_locationLogRecords=");
            sb.append(this.service_monitoring_purgeDatabase_locationLogRecords);
        }
        if (this.service_transmitData_submittedMobileLogs != null) {
            sb.append(", service_transmitData_submittedMobileLogs=");
            sb.append(this.service_transmitData_submittedMobileLogs);
        }
        if (this.service_transmitData_submittedWifiLogs != null) {
            sb.append(", service_transmitData_submittedWifiLogs=");
            sb.append(this.service_transmitData_submittedWifiLogs);
        }
        if (this.service_transmitData_submittedNetworkPacketSent != null) {
            sb.append(", service_transmitData_submittedNetworkPacketSent=");
            sb.append(this.service_transmitData_submittedNetworkPacketSent);
        }
        if (this.service_transmitData_submittedNetworkPacketAccepted != null) {
            sb.append(", service_transmitData_submittedNetworkPacketAccepted=");
            sb.append(this.service_transmitData_submittedNetworkPacketAccepted);
        }
        if (this.service_transmitData_submittedLocationLogs != null) {
            sb.append(", service_transmitData_submittedLocationLogs=");
            sb.append(this.service_transmitData_submittedLocationLogs);
        }
        if (this.service_transmitData_submittedLocationPacketSent != null) {
            sb.append(", service_transmitData_submittedLocationPacketSent=");
            sb.append(this.service_transmitData_submittedLocationPacketSent);
        }
        if (this.service_transmitData_submittedLocationPacketAccepted != null) {
            sb.append(", service_transmitData_submittedLocationPacketAccepted=");
            sb.append(this.service_transmitData_submittedLocationPacketAccepted);
        }
        if (this.individual_permissions_accepted != null) {
            sb.append(", individual_permissions_accepted=");
            sb.append(this.individual_permissions_accepted);
        }
        if (this.service_monitoring_purgeDatabase_appSessions != null) {
            sb.append(", service_monitoring_purgeDatabase_appSessions=");
            sb.append(this.service_monitoring_purgeDatabase_appSessions);
        }
        if (this.service_monitoring_purgeDatabase_appDataUsageEvents != null) {
            sb.append(", service_monitoring_purgeDatabase_appDataUsageEvents=");
            sb.append(this.service_monitoring_purgeDatabase_appDataUsageEvents);
        }
        if (this.service_transmitData_submittedNetworkPacket != null) {
            sb.append(", service_transmitData_submittedNetworkPacket=");
            sb.append(this.service_transmitData_submittedNetworkPacket);
        }
        if (this.service_transmitData_submittedLocationPacket != null) {
            sb.append(", service_transmitData_submittedLocationPacket=");
            sb.append(this.service_transmitData_submittedLocationPacket);
        }
        if (this.service_transmitData_submittedAppSessions != null) {
            sb.append(", service_transmitData_submittedAppSessions=");
            sb.append(this.service_transmitData_submittedAppSessions);
        }
        if (this.service_transmitData_submittedDataUsageEvents != null) {
            sb.append(", service_transmitData_submittedDataUsageEvents=");
            sb.append(this.service_transmitData_submittedDataUsageEvents);
        }
        if (this.service_transmitData_submittedApplicationEventsPacket != null) {
            sb.append(", service_transmitData_submittedApplicationEventsPacket=");
            sb.append(this.service_transmitData_submittedApplicationEventsPacket);
        }
        if (this.service_transmitData_submittedApplicationEventsPacketAccepted != null) {
            sb.append(", service_transmitData_submittedApplicationEventsPacketAccepted=");
            sb.append(this.service_transmitData_submittedApplicationEventsPacketAccepted);
        }
        if (this.mnsi_collected != null) {
            sb.append(", mnsi_collected=");
            sb.append(this.mnsi_collected);
        }
        if (this.location_collected != null) {
            sb.append(", location_collected=");
            sb.append(this.location_collected);
        }
        if (this.systemBatteryInfo_collected != null) {
            sb.append(", systemBatteryInfo_collected=");
            sb.append(this.systemBatteryInfo_collected);
        }
        if (this.appSessions_collected != null) {
            sb.append(", appSessions_collected=");
            sb.append(this.appSessions_collected);
        }
        if (this.appDataUsageEvents_collected != null) {
            sb.append(", appDataUsageEvents_collected=");
            sb.append(this.appDataUsageEvents_collected);
        }
        if (this.service_monitoring_purgeDatabase_noSignalRecords != null) {
            sb.append(", service_monitoring_purgeDatabase_noSignalRecords=");
            sb.append(this.service_monitoring_purgeDatabase_noSignalRecords);
        }
        if (this.service_transmitData_submittedNoSignalLogs != null) {
            sb.append(", service_transmitData_submittedNoSignalLogs=");
            sb.append(this.service_transmitData_submittedNoSignalLogs);
        }
        if (this.service_transmitData_submittedSystemCPULogs != null) {
            sb.append(", service_transmitData_submittedSystemCPULogs=");
            sb.append(this.service_transmitData_submittedSystemCPULogs);
        }
        if (this.service_transmitData_submittedSystemCPULogPacket != null) {
            sb.append(", service_transmitData_submittedSystemCPULogPacket=");
            sb.append(this.service_transmitData_submittedSystemCPULogPacket);
        }
        if (this.service_transmitData_submittedSystemCPULogPacketAccepted != null) {
            sb.append(", service_transmitData_submittedSystemCPULogPacketAccepted=");
            sb.append(this.service_transmitData_submittedSystemCPULogPacketAccepted);
        }
        if (this.service_transmitData_submittedBatteryLogsPacket != null) {
            sb.append(", service_transmitData_submittedBatteryLogsPacket=");
            sb.append(this.service_transmitData_submittedBatteryLogsPacket);
        }
        if (this.service_transmitData_submittedBatteryLogsPacketAccepted != null) {
            sb.append(", service_transmitData_submittedBatteryLogsPacketAccepted=");
            sb.append(this.service_transmitData_submittedBatteryLogsPacketAccepted);
        }
        if (this.service_transmitData_submittedAppDataLogs != null) {
            sb.append(", service_transmitData_submittedAppDataLogs=");
            sb.append(this.service_transmitData_submittedAppDataLogs);
        }
        if (this.service_transmitData_submittedAppDataLogsPacket != null) {
            sb.append(", service_transmitData_submittedAppDataLogsPacket=");
            sb.append(this.service_transmitData_submittedAppDataLogsPacket);
        }
        if (this.service_transmitData_submittedAppDataLogsPacketAccepted != null) {
            sb.append(", service_transmitData_submittedAppDataLogsPacketAccepted=");
            sb.append(this.service_transmitData_submittedAppDataLogsPacketAccepted);
        }
        if (this.service_transmitData_submittedAppUsageEventsPacket != null) {
            sb.append(", service_transmitData_submittedAppUsageEventsPacket=");
            sb.append(this.service_transmitData_submittedAppUsageEventsPacket);
        }
        if (this.service_transmitData_submittedAppUsageEventsPacketAccepted != null) {
            sb.append(", service_transmitData_submittedAppUsageEventsPacketAccepted=");
            sb.append(this.service_transmitData_submittedAppUsageEventsPacketAccepted);
        }
        if (this.ndt_checkForTest != null) {
            sb.append(", ndt_checkForTest=");
            sb.append(this.ndt_checkForTest);
        }
        if (this.ndt_runTest != null) {
            sb.append(", ndt_runTest=");
            sb.append(this.ndt_runTest);
        }
        if (this.ndt_testCompleted != null) {
            sb.append(", ndt_testCompleted=");
            sb.append(this.ndt_testCompleted);
        }
        return c.a(sb, 0, 2, "MonitoringStatsMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitoringStatsMessage(Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, Long l3, Long l4, Long l5, Long l6, Long l7, Integer num6, Long l8, Integer num7, Long l9, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, String str, Integer num43, Integer num44, Integer num45, Long l10, String str2, String str3, Long l11, Integer num46, Integer num47, Integer num48, Integer num49, Integer num50, Integer num51, Integer num52, Integer num53, Integer num54, Integer num55, Integer num56, Integer num57, Integer num58, Integer num59, Integer num60, Integer num61, Integer num62, Integer num63, Integer num64, Integer num65, Integer num66, Integer num67, Integer num68, Integer num69, Integer num70, Integer num71, Integer num72, Integer num73, Integer num74, Integer num75, Integer num76, Integer num77, Integer num78, Integer num79, Integer num80, Integer num81, Integer num82, Integer num83, Integer num84, Integer num85, Integer num86, Integer num87, Integer num88, Integer num89, Integer num90, Integer num91, Integer num92, ByteString byteString) {
        super(ADAPTER, byteString);
        this.status_index = num;
        this.system_clock_up_time = l;
        this.system_clock_elapsed_time = l2;
        this.most_foreground_app_by_pus_time = num2;
        this.most_foreground_app_by_sdk_time = num3;
        this.is_running = num4;
        this.is_storage_full = num5;
        this.database_size = l3;
        this.app_memory = l4;
        this.system_current_memory = l5;
        this.system_available_memory = l6;
        this.system_total_internal_storage = l7;
        this.count_installed_apps = num6;
        this.system_uptime = l8;
        this.service_monitoring_dataCollectionCycles = num7;
        this.service_monitoring_dataCollectionTime = l9;
        this.service_monitoring_updateDatabase = num8;
        this.service_monitoring_updateDatabase_logData_recordInsertAttempts = num9;
        this.service_monitoring_updateDatabase_logData_recordInsertsFailed = num10;
        this.service_transmitData_submittedLogs = num11;
        this.service_transmitData_submittedLogsAccepted = num12;
        this.service_transmitData_submittedBatteryLogs = num13;
        this.service_transmitData_submittedBatteryLogsAccepted = num14;
        this.logger_totalErrorCount = num15;
        this.receiver_onReceive = num16;
        this.receiver_packageChanged = num17;
        this.receiver_bootComplete = num18;
        this.receiver_connectionChanged = num19;
        this.startMonitoring = num20;
        this.startMonitoring_storageFull = num21;
        this.startMonitoring_startService = num22;
        this.stopMonitoring = num23;
        this.service_monitor = num24;
        this.service_transmitData = num25;
        this.service_onCreate = num26;
        this.service_onLowMemory = num27;
        this.service_onDestroy = num28;
        this.service_monitoring_initialize = num29;
        this.service_monitoring_validityCheckFailure = num30;
        this.initialize = num31;
        this.initialize_setupController = num32;
        this.initialize_controllerSetup = num33;
        this.initialize_resetController = num34;
        this.initialize_resetControllerFailed = num35;
        this.start = num36;
        this.stop = num37;
        this.initialSetup_start = num38;
        this.initialSetup_run = num39;
        this.initialSetup_storageFull = num40;
        this.initialSetup_complete = num41;
        this.process_run_time = num42;
        this.report_date = str;
        this.timeChangeBack = num43;
        this.service_transmitData_submittedCPULogs = num44;
        this.service_transmitData_submittedCPULogsAccepted = num45;
        this.system_available_internal_storage = l10;
        this.most_foreground_app_by_pus_package_name = str2;
        this.most_foreground_app_by_sdk_package_name = str3;
        this.service_monitoring_upTime = l11;
        this.service_monitoring_purgeDatabase = num46;
        this.service_monitoring_purgeDatabase_logDataRecords = num47;
        this.service_monitoring_purgeDatabase_appUsageEventsRecords = num48;
        this.service_monitoring_purgeDatabase_systemCpuLogRecords = num49;
        this.service_monitoring_purgeDatabase_batteryLogRecords = num50;
        this.service_monitoring_purgeDatabase_wifiInfoLogRecords = num51;
        this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords = num52;
        this.service_monitoring_purgeDatabase_mobileInfoLogRecords = num53;
        this.timeChangeForward = num54;
        this.permissions_accepted = num55;
        this.service_monitoring_purgeDatabase_locationLogRecords = num56;
        this.service_transmitData_submittedMobileLogs = num57;
        this.service_transmitData_submittedWifiLogs = num58;
        this.service_transmitData_submittedNetworkPacketSent = num59;
        this.service_transmitData_submittedNetworkPacketAccepted = num60;
        this.service_transmitData_submittedLocationLogs = num61;
        this.service_transmitData_submittedLocationPacketSent = num62;
        this.service_transmitData_submittedLocationPacketAccepted = num63;
        this.individual_permissions_accepted = num64;
        this.service_monitoring_purgeDatabase_appSessions = num65;
        this.service_monitoring_purgeDatabase_appDataUsageEvents = num66;
        this.service_transmitData_submittedNetworkPacket = num67;
        this.service_transmitData_submittedLocationPacket = num68;
        this.service_transmitData_submittedAppSessions = num69;
        this.service_transmitData_submittedDataUsageEvents = num70;
        this.service_transmitData_submittedApplicationEventsPacket = num71;
        this.service_transmitData_submittedApplicationEventsPacketAccepted = num72;
        this.mnsi_collected = num73;
        this.location_collected = num74;
        this.systemBatteryInfo_collected = num75;
        this.appSessions_collected = num76;
        this.appDataUsageEvents_collected = num77;
        this.service_monitoring_purgeDatabase_noSignalRecords = num78;
        this.service_transmitData_submittedNoSignalLogs = num79;
        this.service_transmitData_submittedSystemCPULogs = num80;
        this.service_transmitData_submittedSystemCPULogPacket = num81;
        this.service_transmitData_submittedSystemCPULogPacketAccepted = num82;
        this.service_transmitData_submittedBatteryLogsPacket = num83;
        this.service_transmitData_submittedBatteryLogsPacketAccepted = num84;
        this.service_transmitData_submittedAppDataLogs = num85;
        this.service_transmitData_submittedAppDataLogsPacket = num86;
        this.service_transmitData_submittedAppDataLogsPacketAccepted = num87;
        this.service_transmitData_submittedAppUsageEventsPacket = num88;
        this.service_transmitData_submittedAppUsageEventsPacketAccepted = num89;
        this.ndt_checkForTest = num90;
        this.ndt_runTest = num91;
        this.ndt_testCompleted = num92;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.status_index = this.status_index;
        builder.system_clock_up_time = this.system_clock_up_time;
        builder.system_clock_elapsed_time = this.system_clock_elapsed_time;
        builder.most_foreground_app_by_pus_time = this.most_foreground_app_by_pus_time;
        builder.most_foreground_app_by_sdk_time = this.most_foreground_app_by_sdk_time;
        builder.is_running = this.is_running;
        builder.is_storage_full = this.is_storage_full;
        builder.database_size = this.database_size;
        builder.app_memory = this.app_memory;
        builder.system_current_memory = this.system_current_memory;
        builder.system_available_memory = this.system_available_memory;
        builder.system_total_internal_storage = this.system_total_internal_storage;
        builder.count_installed_apps = this.count_installed_apps;
        builder.system_uptime = this.system_uptime;
        builder.service_monitoring_dataCollectionCycles = this.service_monitoring_dataCollectionCycles;
        builder.service_monitoring_dataCollectionTime = this.service_monitoring_dataCollectionTime;
        builder.service_monitoring_updateDatabase = this.service_monitoring_updateDatabase;
        builder.service_monitoring_updateDatabase_logData_recordInsertAttempts = this.service_monitoring_updateDatabase_logData_recordInsertAttempts;
        builder.service_monitoring_updateDatabase_logData_recordInsertsFailed = this.service_monitoring_updateDatabase_logData_recordInsertsFailed;
        builder.service_transmitData_submittedLogs = this.service_transmitData_submittedLogs;
        builder.service_transmitData_submittedLogsAccepted = this.service_transmitData_submittedLogsAccepted;
        builder.service_transmitData_submittedBatteryLogs = this.service_transmitData_submittedBatteryLogs;
        builder.service_transmitData_submittedBatteryLogsAccepted = this.service_transmitData_submittedBatteryLogsAccepted;
        builder.logger_totalErrorCount = this.logger_totalErrorCount;
        builder.receiver_onReceive = this.receiver_onReceive;
        builder.receiver_packageChanged = this.receiver_packageChanged;
        builder.receiver_bootComplete = this.receiver_bootComplete;
        builder.receiver_connectionChanged = this.receiver_connectionChanged;
        builder.startMonitoring = this.startMonitoring;
        builder.startMonitoring_storageFull = this.startMonitoring_storageFull;
        builder.startMonitoring_startService = this.startMonitoring_startService;
        builder.stopMonitoring = this.stopMonitoring;
        builder.service_monitor = this.service_monitor;
        builder.service_transmitData = this.service_transmitData;
        builder.service_onCreate = this.service_onCreate;
        builder.service_onLowMemory = this.service_onLowMemory;
        builder.service_onDestroy = this.service_onDestroy;
        builder.service_monitoring_initialize = this.service_monitoring_initialize;
        builder.service_monitoring_validityCheckFailure = this.service_monitoring_validityCheckFailure;
        builder.initialize = this.initialize;
        builder.initialize_setupController = this.initialize_setupController;
        builder.initialize_controllerSetup = this.initialize_controllerSetup;
        builder.initialize_resetController = this.initialize_resetController;
        builder.initialize_resetControllerFailed = this.initialize_resetControllerFailed;
        builder.start = this.start;
        builder.stop = this.stop;
        builder.initialSetup_start = this.initialSetup_start;
        builder.initialSetup_run = this.initialSetup_run;
        builder.initialSetup_storageFull = this.initialSetup_storageFull;
        builder.initialSetup_complete = this.initialSetup_complete;
        builder.process_run_time = this.process_run_time;
        builder.report_date = this.report_date;
        builder.timeChangeBack = this.timeChangeBack;
        builder.service_transmitData_submittedCPULogs = this.service_transmitData_submittedCPULogs;
        builder.service_transmitData_submittedCPULogsAccepted = this.service_transmitData_submittedCPULogsAccepted;
        builder.system_available_internal_storage = this.system_available_internal_storage;
        builder.most_foreground_app_by_pus_package_name = this.most_foreground_app_by_pus_package_name;
        builder.most_foreground_app_by_sdk_package_name = this.most_foreground_app_by_sdk_package_name;
        builder.service_monitoring_upTime = this.service_monitoring_upTime;
        builder.service_monitoring_purgeDatabase = this.service_monitoring_purgeDatabase;
        builder.service_monitoring_purgeDatabase_logDataRecords = this.service_monitoring_purgeDatabase_logDataRecords;
        builder.service_monitoring_purgeDatabase_appUsageEventsRecords = this.service_monitoring_purgeDatabase_appUsageEventsRecords;
        builder.service_monitoring_purgeDatabase_systemCpuLogRecords = this.service_monitoring_purgeDatabase_systemCpuLogRecords;
        builder.service_monitoring_purgeDatabase_batteryLogRecords = this.service_monitoring_purgeDatabase_batteryLogRecords;
        builder.service_monitoring_purgeDatabase_wifiInfoLogRecords = this.service_monitoring_purgeDatabase_wifiInfoLogRecords;
        builder.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords = this.service_monitoring_purgeDatabase_mobileSignalInfoLogRecords;
        builder.service_monitoring_purgeDatabase_mobileInfoLogRecords = this.service_monitoring_purgeDatabase_mobileInfoLogRecords;
        builder.timeChangeForward = this.timeChangeForward;
        builder.permissions_accepted = this.permissions_accepted;
        builder.service_monitoring_purgeDatabase_locationLogRecords = this.service_monitoring_purgeDatabase_locationLogRecords;
        builder.service_transmitData_submittedMobileLogs = this.service_transmitData_submittedMobileLogs;
        builder.service_transmitData_submittedWifiLogs = this.service_transmitData_submittedWifiLogs;
        builder.service_transmitData_submittedNetworkPacketSent = this.service_transmitData_submittedNetworkPacketSent;
        builder.service_transmitData_submittedNetworkPacketAccepted = this.service_transmitData_submittedNetworkPacketAccepted;
        builder.service_transmitData_submittedLocationLogs = this.service_transmitData_submittedLocationLogs;
        builder.service_transmitData_submittedLocationPacketSent = this.service_transmitData_submittedLocationPacketSent;
        builder.service_transmitData_submittedLocationPacketAccepted = this.service_transmitData_submittedLocationPacketAccepted;
        builder.individual_permissions_accepted = this.individual_permissions_accepted;
        builder.service_monitoring_purgeDatabase_appSessions = this.service_monitoring_purgeDatabase_appSessions;
        builder.service_monitoring_purgeDatabase_appDataUsageEvents = this.service_monitoring_purgeDatabase_appDataUsageEvents;
        builder.service_transmitData_submittedNetworkPacket = this.service_transmitData_submittedNetworkPacket;
        builder.service_transmitData_submittedLocationPacket = this.service_transmitData_submittedLocationPacket;
        builder.service_transmitData_submittedAppSessions = this.service_transmitData_submittedAppSessions;
        builder.service_transmitData_submittedDataUsageEvents = this.service_transmitData_submittedDataUsageEvents;
        builder.service_transmitData_submittedApplicationEventsPacket = this.service_transmitData_submittedApplicationEventsPacket;
        builder.service_transmitData_submittedApplicationEventsPacketAccepted = this.service_transmitData_submittedApplicationEventsPacketAccepted;
        builder.mnsi_collected = this.mnsi_collected;
        builder.location_collected = this.location_collected;
        builder.systemBatteryInfo_collected = this.systemBatteryInfo_collected;
        builder.appSessions_collected = this.appSessions_collected;
        builder.appDataUsageEvents_collected = this.appDataUsageEvents_collected;
        builder.service_monitoring_purgeDatabase_noSignalRecords = this.service_monitoring_purgeDatabase_noSignalRecords;
        builder.service_transmitData_submittedNoSignalLogs = this.service_transmitData_submittedNoSignalLogs;
        builder.service_transmitData_submittedSystemCPULogs = this.service_transmitData_submittedSystemCPULogs;
        builder.service_transmitData_submittedSystemCPULogPacket = this.service_transmitData_submittedSystemCPULogPacket;
        builder.service_transmitData_submittedSystemCPULogPacketAccepted = this.service_transmitData_submittedSystemCPULogPacketAccepted;
        builder.service_transmitData_submittedBatteryLogsPacket = this.service_transmitData_submittedBatteryLogsPacket;
        builder.service_transmitData_submittedBatteryLogsPacketAccepted = this.service_transmitData_submittedBatteryLogsPacketAccepted;
        builder.service_transmitData_submittedAppDataLogs = this.service_transmitData_submittedAppDataLogs;
        builder.service_transmitData_submittedAppDataLogsPacket = this.service_transmitData_submittedAppDataLogsPacket;
        builder.service_transmitData_submittedAppDataLogsPacketAccepted = this.service_transmitData_submittedAppDataLogsPacketAccepted;
        builder.service_transmitData_submittedAppUsageEventsPacket = this.service_transmitData_submittedAppUsageEventsPacket;
        builder.service_transmitData_submittedAppUsageEventsPacketAccepted = this.service_transmitData_submittedAppUsageEventsPacketAccepted;
        builder.ndt_checkForTest = this.ndt_checkForTest;
        builder.ndt_runTest = this.ndt_runTest;
        builder.ndt_testCompleted = this.ndt_testCompleted;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
