package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9¨\u0006:"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEvents;", "", "eventName", "", "restartingStrategy", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/RestartingStrategy;", "type", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEventMonitorStatsType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/m2catalyst/m2sdk/logger/monitor_stats/RestartingStrategy;Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEventMonitorStatsType;)V", "getEventName", "()Ljava/lang/String;", "getRestartingStrategy", "()Lcom/m2catalyst/m2sdk/logger/monitor_stats/RestartingStrategy;", "getType", "()Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEventMonitorStatsType;", "SDK_INITIALIZE", "SDK_START", "SDK_STOP", "SDK_UPDATE_CONFIGURATION", "SDK_COLLECTION_STARTED", "SDK_COLLECTION_STOPPED", "SDK_SYSTEM_UPTIME", "RECEIVER_AUTOCHECK", "RECEIVER_REINITIALIZE", "RECEIVER_INGESTION_TRANSMISSION_REQUESTED", "RECEIVER_MONITOR_STATS_TRANSMISSION_REQUESTED", "RECEIVER_LOCATION_COLLECTION_UPDATED", "RECEIVER_LOCATION_RECURRENT_COLLECTION_REQUESTED", "RECEIVER_WIFI_ON_RECEIVE", "MNSI_COLLECTED", "LOCATION_COLLECTED", "NDT_COLLECTED", "NO_SIGNAL_DATA_COLLECTED", "WIFI_COLLECTED", "BUILD_MNSI_PACKET_COUNT_RECORDS", "BUILD_WIFI_PACKET_COUNT_RECORDS", "BUILD_NO_SIGNAL_PACKET_COUNT_RECORDS", "BUILD_NDT_PACKET_COUNT_RECORDS", "BUILD_LOCATION_PACKET_COUNT_RECORDS", "TRANSMIT_DATA_SUBMITTED_NETWORK_PACKET_SENT", "TRANSMIT_DATA_SUBMITTED_LOCATION_PACKET_SENT", "TRANSMIT_DATA_SUBMITTED_MNSI_RECORDS_ACCEPTED", "TRANSMIT_DATA_SUBMITTED_LOCATION_RECORDS_ACCEPTED", "TRANSMIT_DATA_SUBMITTED_WIFI_RECORDS_ACCEPTED", "TRANSMIT_DATA_SUBMITTED_NO_SIGNAL_RECORDS_ACCEPTED", "TRANSMIT_DATA_SUBMITTED_NDT_RECORDS_ACCEPTED", "NDT_CHECK_FULL_TEST", "NDT_CHECK_LATENCY_TEST", "NDT_CHECK_DOWNLOAD_TEST", "NDT_CHECK_UPLOAD_TEST", "NDT_START_TEST_FULL", "NDT_START_TEST_LATENCY", "NDT_START_TEST_DOWNLOAD", "NDT_START_TEST_UPLOAD", "NDT_TEST_COMPLETED_FULL", "NDT_TEST_COMPLETED_LATENCY", "NDT_TEST_COMPLETED_DOWNLOAD", "NDT_TEST_COMPLETED_UPLOAD", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoggingEvents.kt */
public enum LoggingEvents {
    SDK_INITIALIZE("sdk:initialize", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_START("sdk:start", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_STOP("sdk:stop", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_UPDATE_CONFIGURATION("sdk:configurationUpdated", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_COLLECTION_STARTED("sdk:collectionStarted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_COLLECTION_STOPPED("sdk:collectionStopped", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    SDK_SYSTEM_UPTIME("sdk:monitoring:upTime", (int) null, LoggingEventMonitorStatsType.LONG, 2, (LoggingEventMonitorStatsType) null),
    RECEIVER_AUTOCHECK("receiver:autocheck", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_REINITIALIZE("receiver:reinitialize", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_INGESTION_TRANSMISSION_REQUESTED("receiver:ingestion:transmissionRequested", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_MONITOR_STATS_TRANSMISSION_REQUESTED("receiver:monitorStats:transmissionRequested", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_LOCATION_COLLECTION_UPDATED("receiver:location:updatedRequested", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_LOCATION_RECURRENT_COLLECTION_REQUESTED("receiver:location:recurrentCollectionRequested", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    RECEIVER_WIFI_ON_RECEIVE("receiver:wifi", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    MNSI_COLLECTED("collection:mnsiCollected", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    LOCATION_COLLECTED("collection:locationCollected", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_COLLECTED("collection:ndtCollected", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NO_SIGNAL_DATA_COLLECTED("collection:noSignalDataCollected", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    WIFI_COLLECTED("collection:wifiCollected", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    BUILD_MNSI_PACKET_COUNT_RECORDS("ingestion:buildPacket:mnsiRecords", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    BUILD_WIFI_PACKET_COUNT_RECORDS("ingestion:buildPacket:wifiRecords", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    BUILD_NO_SIGNAL_PACKET_COUNT_RECORDS("ingestion:buildPacket:noSignalRecords", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    BUILD_NDT_PACKET_COUNT_RECORDS("ingestion:buildPacket:networkDiagnosticRecords", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    BUILD_LOCATION_PACKET_COUNT_RECORDS("ingestion:buildPacket:locationRecords", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_NETWORK_PACKET_SENT("ingestion:transmitData:submittedNetworkPacketSent", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_LOCATION_PACKET_SENT("ingestion:transmitData:submittedLocationPacketSent", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_MNSI_RECORDS_ACCEPTED("ingestion:transmitData:submittedMnsiRecordsAccepted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_LOCATION_RECORDS_ACCEPTED("ingestion:transmitData:submittedLocationRecordsAccepted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_WIFI_RECORDS_ACCEPTED("ingestion:transmitData:submittedWifiRecordsAccepted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_NO_SIGNAL_RECORDS_ACCEPTED("ingestion:transmitData:submittedNoSignalRecordsAccepted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    TRANSMIT_DATA_SUBMITTED_NDT_RECORDS_ACCEPTED("ingestion:transmitData:submittedNetworkDiagnosticRecordsAccepted", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_CHECK_FULL_TEST("ndt:checkFullTest", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_CHECK_LATENCY_TEST("ndt:checkLatencyTest", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_CHECK_DOWNLOAD_TEST("ndt:checkDownloadTest", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_CHECK_UPLOAD_TEST("ndt:checkUploadTest", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_START_TEST_FULL("ndt:startTestFull", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_START_TEST_LATENCY("ndt:startTestLatency", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_START_TEST_DOWNLOAD("ndt:startTestDownload", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_START_TEST_UPLOAD("ndt:startTestUpload", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_TEST_COMPLETED_FULL("ndt:testCompletedFull", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_TEST_COMPLETED_LATENCY("ndt:testCompletedLatency", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_TEST_COMPLETED_DOWNLOAD("ndt:testCompletedDownload", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null),
    NDT_TEST_COMPLETED_UPLOAD("ndt:testCompletedUpload", (int) null, (String) null, 6, (LoggingEventMonitorStatsType) null);
    
    private final String eventName;
    private final RestartingStrategy restartingStrategy;
    private final LoggingEventMonitorStatsType type;

    private LoggingEvents(String str, RestartingStrategy restartingStrategy2, LoggingEventMonitorStatsType loggingEventMonitorStatsType) {
        this.eventName = str;
        this.restartingStrategy = restartingStrategy2;
        this.type = loggingEventMonitorStatsType;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final RestartingStrategy getRestartingStrategy() {
        return this.restartingStrategy;
    }

    public final LoggingEventMonitorStatsType getType() {
        return this.type;
    }
}
