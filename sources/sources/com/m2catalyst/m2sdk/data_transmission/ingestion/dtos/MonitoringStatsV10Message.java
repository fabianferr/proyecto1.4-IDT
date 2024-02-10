package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
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

public final class MonitoringStatsV10Message extends Message<MonitoringStatsV10Message, Builder> {
    public static final ProtoAdapter<MonitoringStatsV10Message> ADAPTER = new ProtoAdapter_MonitoringStatsV10Message();
    public static final Long DEFAULT_APP_MEMORY = 0L;
    public static final Integer DEFAULT_COLLECTION_LOCATIONCOLLECTED = 0;
    public static final Integer DEFAULT_COLLECTION_MNSICOLLECTED = 0;
    public static final Integer DEFAULT_COLLECTION_NDTCOLLECTED = 0;
    public static final Integer DEFAULT_COLLECTION_NOSIGNALDATACOLLECTED = 0;
    public static final Integer DEFAULT_COLLECTION_WIFICOLLECTED = 0;
    public static final Integer DEFAULT_COUNT_INSTALLED_APPS = 0;
    public static final Integer DEFAULT_INGESTION_BUILDPACKET_LOCATIONRECORDS = 0;
    public static final Integer DEFAULT_INGESTION_BUILDPACKET_MNSIRECORDS = 0;
    public static final Integer DEFAULT_INGESTION_BUILDPACKET_NETWORKDIAGNOSTICRECORDS = 0;
    public static final Integer DEFAULT_INGESTION_BUILDPACKET_NOSIGNALRECORDS = 0;
    public static final Integer DEFAULT_INGESTION_BUILDPACKET_WIFIRECORDS = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDLOCATIONPACKETSENT = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDLOCATIONRECORDSACCEPTED = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDMNSIRECORDSACCEPTED = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDNETWORKDIAGNOSTICRECORDSACCEPTED = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDNETWORKPACKETSENT = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDNOSIGNALRECORDSACCEPTED = 0;
    public static final Integer DEFAULT_INGESTION_TRANSMITDATA_SUBMITTEDWIFIRECORDSACCEPTED = 0;
    public static final Integer DEFAULT_IS_STORAGE_FULL = 0;
    public static final Integer DEFAULT_LOGGER_TOTALERRORCOUNT = 0;
    public static final Integer DEFAULT_NDT_CHECKDOWNLOADTEST = 0;
    public static final Integer DEFAULT_NDT_CHECKFULLTEST = 0;
    public static final Integer DEFAULT_NDT_CHECKLATENCYTEST = 0;
    public static final Integer DEFAULT_NDT_CHECKUPLOADTEST = 0;
    public static final Integer DEFAULT_NDT_STARTTESTDOWNLOAD = 0;
    public static final Integer DEFAULT_NDT_STARTTESTFULL = 0;
    public static final Integer DEFAULT_NDT_STARTTESTLATENCY = 0;
    public static final Integer DEFAULT_NDT_STARTTESTUPLOAD = 0;
    public static final Integer DEFAULT_NDT_TESTCOMPLETEDDOWNLOAD = 0;
    public static final Integer DEFAULT_NDT_TESTCOMPLETEDFULL = 0;
    public static final Integer DEFAULT_NDT_TESTCOMPLETEDLATENCY = 0;
    public static final Integer DEFAULT_NDT_TESTCOMPLETEDUPLOAD = 0;
    public static final Integer DEFAULT_RECEIVER_AUTOCHECK = 0;
    public static final Integer DEFAULT_RECEIVER_INGESTION_TRANSMISSIONREQUESTED = 0;
    public static final Integer DEFAULT_RECEIVER_LOCATION_RECURRENTCOLLECTIONREQUESTED = 0;
    public static final Integer DEFAULT_RECEIVER_LOCATION_UPDATEDREQUESTED = 0;
    public static final Integer DEFAULT_RECEIVER_MONITORSTATS_TRANSMISSIONREQUESTED = 0;
    public static final Integer DEFAULT_RECEIVER_REINITIALIZE = 0;
    public static final Integer DEFAULT_RECEIVER_WIFI = 0;
    public static final String DEFAULT_REPORT_DATE = "";
    public static final Integer DEFAULT_SDK_COLLECTIONSTARTED = 0;
    public static final Integer DEFAULT_SDK_COLLECTIONSTOPPED = 0;
    public static final Integer DEFAULT_SDK_CONFIGURATIONUPDATED = 0;
    public static final Integer DEFAULT_SDK_INITIALIZE = 0;
    public static final Long DEFAULT_SDK_MONITORING_UPTIME = 0L;
    public static final Integer DEFAULT_SDK_START = 0;
    public static final Integer DEFAULT_SDK_STOP = 0;
    public static final Integer DEFAULT_SDK_TIMECHANGEBACK = 0;
    public static final Integer DEFAULT_SDK_TIMECHANGEFORWARD = 0;
    public static final Long DEFAULT_SYSTEM_AVAILABLE_INTERNAL_STORAGE = 0L;
    public static final Long DEFAULT_SYSTEM_AVAILABLE_MEMORY = 0L;
    public static final Long DEFAULT_SYSTEM_CLOCK_ELAPSED_TIME = 0L;
    public static final Long DEFAULT_SYSTEM_CLOCK_UP_TIME = 0L;
    public static final Long DEFAULT_SYSTEM_CURRENT_MEMORY = 0L;
    public static final Long DEFAULT_SYSTEM_TOTAL_INTERNAL_STORAGE = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 28)
    public final Long app_memory;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 146)
    public final Integer collection_locationCollected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 145)
    public final Integer collection_mnsiCollected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 147)
    public final Integer collection_ndtCollected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 148)
    public final Integer collection_noSignalDataCollected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 173)
    public final Integer collection_wifiCollected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer count_installed_apps;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 153)
    public final Integer ingestion_buildPacket_locationRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 149)
    public final Integer ingestion_buildPacket_mnsiRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 152)
    public final Integer ingestion_buildPacket_networkDiagnosticRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 151)
    public final Integer ingestion_buildPacket_noSignalRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 150)
    public final Integer ingestion_buildPacket_wifiRecords;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 155)
    public final Integer ingestion_transmitData_submittedLocationPacketSent;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 160)
    public final Integer ingestion_transmitData_submittedLocationRecordsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 156)
    public final Integer ingestion_transmitData_submittedMnsiRecordsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 159)
    public final Integer ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 154)
    public final Integer ingestion_transmitData_submittedNetworkPacketSent;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 158)
    public final Integer ingestion_transmitData_submittedNoSignalRecordsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 157)
    public final Integer ingestion_transmitData_submittedWifiRecordsAccepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer is_storage_full;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 43)
    public final Integer logger_totalErrorCount;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 163)
    public final Integer ndt_checkDownloadTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 161)
    public final Integer ndt_checkFullTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 162)
    public final Integer ndt_checkLatencyTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 164)
    public final Integer ndt_checkUploadTest;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 167)
    public final Integer ndt_startTestDownload;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 165)
    public final Integer ndt_startTestFull;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 166)
    public final Integer ndt_startTestLatency;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 168)
    public final Integer ndt_startTestUpload;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 171)
    public final Integer ndt_testCompletedDownload;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 169)
    public final Integer ndt_testCompletedFull;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 170)
    public final Integer ndt_testCompletedLatency;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 172)
    public final Integer ndt_testCompletedUpload;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 137)
    public final Integer receiver_autocheck;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 139)
    public final Integer receiver_ingestion_transmissionRequested;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 142)
    public final Integer receiver_location_recurrentCollectionRequested;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 141)
    public final Integer receiver_location_updatedRequested;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 140)
    public final Integer receiver_monitorStats_transmissionRequested;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 138)
    public final Integer receiver_reinitialize;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 143)
    public final Integer receiver_wifi;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 71)
    public final String report_date;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 135)
    public final Integer sdk_collectionStarted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 136)
    public final Integer sdk_collectionStopped;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 131)
    public final Integer sdk_configurationUpdated;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 128)
    public final Integer sdk_initialize;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 132)
    public final Long sdk_monitoring_upTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 129)
    public final Integer sdk_start;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 130)
    public final Integer sdk_stop;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 133)
    public final Integer sdk_timeChangeBack;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 134)
    public final Integer sdk_timeChangeForward;
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

    public static final class Builder extends Message.Builder<MonitoringStatsV10Message, Builder> {
        public Long app_memory;
        public Integer collection_locationCollected;
        public Integer collection_mnsiCollected;
        public Integer collection_ndtCollected;
        public Integer collection_noSignalDataCollected;
        public Integer collection_wifiCollected;
        public Integer count_installed_apps;
        public Integer ingestion_buildPacket_locationRecords;
        public Integer ingestion_buildPacket_mnsiRecords;
        public Integer ingestion_buildPacket_networkDiagnosticRecords;
        public Integer ingestion_buildPacket_noSignalRecords;
        public Integer ingestion_buildPacket_wifiRecords;
        public Integer ingestion_transmitData_submittedLocationPacketSent;
        public Integer ingestion_transmitData_submittedLocationRecordsAccepted;
        public Integer ingestion_transmitData_submittedMnsiRecordsAccepted;
        public Integer ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
        public Integer ingestion_transmitData_submittedNetworkPacketSent;
        public Integer ingestion_transmitData_submittedNoSignalRecordsAccepted;
        public Integer ingestion_transmitData_submittedWifiRecordsAccepted;
        public Integer is_storage_full;
        public Integer logger_totalErrorCount;
        public Integer ndt_checkDownloadTest;
        public Integer ndt_checkFullTest;
        public Integer ndt_checkLatencyTest;
        public Integer ndt_checkUploadTest;
        public Integer ndt_startTestDownload;
        public Integer ndt_startTestFull;
        public Integer ndt_startTestLatency;
        public Integer ndt_startTestUpload;
        public Integer ndt_testCompletedDownload;
        public Integer ndt_testCompletedFull;
        public Integer ndt_testCompletedLatency;
        public Integer ndt_testCompletedUpload;
        public Integer receiver_autocheck;
        public Integer receiver_ingestion_transmissionRequested;
        public Integer receiver_location_recurrentCollectionRequested;
        public Integer receiver_location_updatedRequested;
        public Integer receiver_monitorStats_transmissionRequested;
        public Integer receiver_reinitialize;
        public Integer receiver_wifi;
        public String report_date;
        public Integer sdk_collectionStarted;
        public Integer sdk_collectionStopped;
        public Integer sdk_configurationUpdated;
        public Integer sdk_initialize;
        public Long sdk_monitoring_upTime;
        public Integer sdk_start;
        public Integer sdk_stop;
        public Integer sdk_timeChangeBack;
        public Integer sdk_timeChangeForward;
        public Long system_available_internal_storage;
        public Long system_available_memory;
        public Long system_clock_elapsed_time;
        public Long system_clock_up_time;
        public Long system_current_memory;
        public Long system_total_internal_storage;

        public Builder app_memory(Long l) {
            this.app_memory = l;
            return this;
        }

        public Builder collection_locationCollected(Integer num) {
            this.collection_locationCollected = num;
            return this;
        }

        public Builder collection_mnsiCollected(Integer num) {
            this.collection_mnsiCollected = num;
            return this;
        }

        public Builder collection_ndtCollected(Integer num) {
            this.collection_ndtCollected = num;
            return this;
        }

        public Builder collection_noSignalDataCollected(Integer num) {
            this.collection_noSignalDataCollected = num;
            return this;
        }

        public Builder collection_wifiCollected(Integer num) {
            this.collection_wifiCollected = num;
            return this;
        }

        public Builder count_installed_apps(Integer num) {
            this.count_installed_apps = num;
            return this;
        }

        public Builder ingestion_buildPacket_locationRecords(Integer num) {
            this.ingestion_buildPacket_locationRecords = num;
            return this;
        }

        public Builder ingestion_buildPacket_mnsiRecords(Integer num) {
            this.ingestion_buildPacket_mnsiRecords = num;
            return this;
        }

        public Builder ingestion_buildPacket_networkDiagnosticRecords(Integer num) {
            this.ingestion_buildPacket_networkDiagnosticRecords = num;
            return this;
        }

        public Builder ingestion_buildPacket_noSignalRecords(Integer num) {
            this.ingestion_buildPacket_noSignalRecords = num;
            return this;
        }

        public Builder ingestion_buildPacket_wifiRecords(Integer num) {
            this.ingestion_buildPacket_wifiRecords = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedLocationPacketSent(Integer num) {
            this.ingestion_transmitData_submittedLocationPacketSent = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedLocationRecordsAccepted(Integer num) {
            this.ingestion_transmitData_submittedLocationRecordsAccepted = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedMnsiRecordsAccepted(Integer num) {
            this.ingestion_transmitData_submittedMnsiRecordsAccepted = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted(Integer num) {
            this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedNetworkPacketSent(Integer num) {
            this.ingestion_transmitData_submittedNetworkPacketSent = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedNoSignalRecordsAccepted(Integer num) {
            this.ingestion_transmitData_submittedNoSignalRecordsAccepted = num;
            return this;
        }

        public Builder ingestion_transmitData_submittedWifiRecordsAccepted(Integer num) {
            this.ingestion_transmitData_submittedWifiRecordsAccepted = num;
            return this;
        }

        public Builder is_storage_full(Integer num) {
            this.is_storage_full = num;
            return this;
        }

        public Builder logger_totalErrorCount(Integer num) {
            this.logger_totalErrorCount = num;
            return this;
        }

        public Builder ndt_checkDownloadTest(Integer num) {
            this.ndt_checkDownloadTest = num;
            return this;
        }

        public Builder ndt_checkFullTest(Integer num) {
            this.ndt_checkFullTest = num;
            return this;
        }

        public Builder ndt_checkLatencyTest(Integer num) {
            this.ndt_checkLatencyTest = num;
            return this;
        }

        public Builder ndt_checkUploadTest(Integer num) {
            this.ndt_checkUploadTest = num;
            return this;
        }

        public Builder ndt_startTestDownload(Integer num) {
            this.ndt_startTestDownload = num;
            return this;
        }

        public Builder ndt_startTestFull(Integer num) {
            this.ndt_startTestFull = num;
            return this;
        }

        public Builder ndt_startTestLatency(Integer num) {
            this.ndt_startTestLatency = num;
            return this;
        }

        public Builder ndt_startTestUpload(Integer num) {
            this.ndt_startTestUpload = num;
            return this;
        }

        public Builder ndt_testCompletedDownload(Integer num) {
            this.ndt_testCompletedDownload = num;
            return this;
        }

        public Builder ndt_testCompletedFull(Integer num) {
            this.ndt_testCompletedFull = num;
            return this;
        }

        public Builder ndt_testCompletedLatency(Integer num) {
            this.ndt_testCompletedLatency = num;
            return this;
        }

        public Builder ndt_testCompletedUpload(Integer num) {
            this.ndt_testCompletedUpload = num;
            return this;
        }

        public Builder receiver_autocheck(Integer num) {
            this.receiver_autocheck = num;
            return this;
        }

        public Builder receiver_ingestion_transmissionRequested(Integer num) {
            this.receiver_ingestion_transmissionRequested = num;
            return this;
        }

        public Builder receiver_location_recurrentCollectionRequested(Integer num) {
            this.receiver_location_recurrentCollectionRequested = num;
            return this;
        }

        public Builder receiver_location_updatedRequested(Integer num) {
            this.receiver_location_updatedRequested = num;
            return this;
        }

        public Builder receiver_monitorStats_transmissionRequested(Integer num) {
            this.receiver_monitorStats_transmissionRequested = num;
            return this;
        }

        public Builder receiver_reinitialize(Integer num) {
            this.receiver_reinitialize = num;
            return this;
        }

        public Builder receiver_wifi(Integer num) {
            this.receiver_wifi = num;
            return this;
        }

        public Builder report_date(String str) {
            this.report_date = str;
            return this;
        }

        public Builder sdk_collectionStarted(Integer num) {
            this.sdk_collectionStarted = num;
            return this;
        }

        public Builder sdk_collectionStopped(Integer num) {
            this.sdk_collectionStopped = num;
            return this;
        }

        public Builder sdk_configurationUpdated(Integer num) {
            this.sdk_configurationUpdated = num;
            return this;
        }

        public Builder sdk_initialize(Integer num) {
            this.sdk_initialize = num;
            return this;
        }

        public Builder sdk_monitoring_upTime(Long l) {
            this.sdk_monitoring_upTime = l;
            return this;
        }

        public Builder sdk_start(Integer num) {
            this.sdk_start = num;
            return this;
        }

        public Builder sdk_stop(Integer num) {
            this.sdk_stop = num;
            return this;
        }

        public Builder sdk_timeChangeBack(Integer num) {
            this.sdk_timeChangeBack = num;
            return this;
        }

        public Builder sdk_timeChangeForward(Integer num) {
            this.sdk_timeChangeForward = num;
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

        public MonitoringStatsV10Message build() {
            return new MonitoringStatsV10Message(this.system_clock_up_time, this.system_clock_elapsed_time, this.is_storage_full, this.app_memory, this.system_current_memory, this.system_available_memory, this.system_total_internal_storage, this.count_installed_apps, this.logger_totalErrorCount, this.report_date, this.system_available_internal_storage, this.sdk_initialize, this.sdk_start, this.sdk_stop, this.sdk_configurationUpdated, this.sdk_monitoring_upTime, this.sdk_timeChangeBack, this.sdk_timeChangeForward, this.sdk_collectionStarted, this.sdk_collectionStopped, this.receiver_autocheck, this.receiver_reinitialize, this.receiver_ingestion_transmissionRequested, this.receiver_monitorStats_transmissionRequested, this.receiver_location_updatedRequested, this.receiver_location_recurrentCollectionRequested, this.receiver_wifi, this.collection_mnsiCollected, this.collection_locationCollected, this.collection_ndtCollected, this.collection_noSignalDataCollected, this.collection_wifiCollected, this.ingestion_buildPacket_mnsiRecords, this.ingestion_buildPacket_wifiRecords, this.ingestion_buildPacket_noSignalRecords, this.ingestion_buildPacket_networkDiagnosticRecords, this.ingestion_buildPacket_locationRecords, this.ingestion_transmitData_submittedNetworkPacketSent, this.ingestion_transmitData_submittedLocationPacketSent, this.ingestion_transmitData_submittedMnsiRecordsAccepted, this.ingestion_transmitData_submittedWifiRecordsAccepted, this.ingestion_transmitData_submittedNoSignalRecordsAccepted, this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted, this.ingestion_transmitData_submittedLocationRecordsAccepted, this.ndt_checkFullTest, this.ndt_checkLatencyTest, this.ndt_checkDownloadTest, this.ndt_checkUploadTest, this.ndt_startTestFull, this.ndt_startTestLatency, this.ndt_startTestDownload, this.ndt_startTestUpload, this.ndt_testCompletedFull, this.ndt_testCompletedLatency, this.ndt_testCompletedDownload, this.ndt_testCompletedUpload, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MonitoringStatsV10Message extends ProtoAdapter<MonitoringStatsV10Message> {
        public ProtoAdapter_MonitoringStatsV10Message() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MonitoringStatsV10Message.class);
        }

        public MonitoringStatsV10Message decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 21) {
                    builder.system_clock_up_time(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag == 22) {
                    builder.system_clock_elapsed_time(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag == 26) {
                    builder.is_storage_full(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 43) {
                    builder.logger_totalErrorCount(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 71) {
                    builder.report_date(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 75) {
                    switch (nextTag) {
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
                        default:
                            switch (nextTag) {
                                case 128:
                                    builder.sdk_initialize(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 129:
                                    builder.sdk_start(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 130:
                                    builder.sdk_stop(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 131:
                                    builder.sdk_configurationUpdated(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 132:
                                    builder.sdk_monitoring_upTime(ProtoAdapter.INT64.decode(protoReader));
                                    break;
                                case 133:
                                    builder.sdk_timeChangeBack(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 134:
                                    builder.sdk_timeChangeForward(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 135:
                                    builder.sdk_collectionStarted(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 136:
                                    builder.sdk_collectionStopped(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 137:
                                    builder.receiver_autocheck(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 138:
                                    builder.receiver_reinitialize(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 139:
                                    builder.receiver_ingestion_transmissionRequested(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case IronSourceConstants.USING_CACHE_FOR_INIT_EVENT /*140*/:
                                    builder.receiver_monitorStats_transmissionRequested(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 141:
                                    builder.receiver_location_updatedRequested(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 142:
                                    builder.receiver_location_recurrentCollectionRequested(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 143:
                                    builder.receiver_wifi(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                default:
                                    switch (nextTag) {
                                        case 145:
                                            builder.collection_mnsiCollected(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 146:
                                            builder.collection_locationCollected(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 147:
                                            builder.collection_ndtCollected(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 148:
                                            builder.collection_noSignalDataCollected(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 149:
                                            builder.ingestion_buildPacket_mnsiRecords(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED /*150*/:
                                            builder.ingestion_buildPacket_wifiRecords(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 151:
                                            builder.ingestion_buildPacket_noSignalRecords(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 152:
                                            builder.ingestion_buildPacket_networkDiagnosticRecords(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 153:
                                            builder.ingestion_buildPacket_locationRecords(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 154:
                                            builder.ingestion_transmitData_submittedNetworkPacketSent(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 155:
                                            builder.ingestion_transmitData_submittedLocationPacketSent(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 156:
                                            builder.ingestion_transmitData_submittedMnsiRecordsAccepted(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 157:
                                            builder.ingestion_transmitData_submittedWifiRecordsAccepted(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 158:
                                            builder.ingestion_transmitData_submittedNoSignalRecordsAccepted(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 159:
                                            builder.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 160:
                                            builder.ingestion_transmitData_submittedLocationRecordsAccepted(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 161:
                                            builder.ndt_checkFullTest(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 162:
                                            builder.ndt_checkLatencyTest(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 163:
                                            builder.ndt_checkDownloadTest(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 164:
                                            builder.ndt_checkUploadTest(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 165:
                                            builder.ndt_startTestFull(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 166:
                                            builder.ndt_startTestLatency(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 167:
                                            builder.ndt_startTestDownload(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 168:
                                            builder.ndt_startTestUpload(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 169:
                                            builder.ndt_testCompletedFull(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 170:
                                            builder.ndt_testCompletedLatency(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 171:
                                            builder.ndt_testCompletedDownload(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 172:
                                            builder.ndt_testCompletedUpload(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        case 173:
                                            builder.collection_wifiCollected(ProtoAdapter.INT32.decode(protoReader));
                                            break;
                                        default:
                                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                            break;
                                    }
                            }
                    }
                } else {
                    builder.system_available_internal_storage(ProtoAdapter.INT64.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, MonitoringStatsV10Message monitoringStatsV10Message) {
            Long l = monitoringStatsV10Message.system_clock_up_time;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 21, l);
            }
            Long l2 = monitoringStatsV10Message.system_clock_elapsed_time;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 22, l2);
            }
            Integer num = monitoringStatsV10Message.is_storage_full;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num);
            }
            Long l3 = monitoringStatsV10Message.app_memory;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 28, l3);
            }
            Long l4 = monitoringStatsV10Message.system_current_memory;
            if (l4 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 29, l4);
            }
            Long l5 = monitoringStatsV10Message.system_available_memory;
            if (l5 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 30, l5);
            }
            Long l6 = monitoringStatsV10Message.system_total_internal_storage;
            if (l6 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 31, l6);
            }
            Integer num2 = monitoringStatsV10Message.count_installed_apps;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num2);
            }
            Integer num3 = monitoringStatsV10Message.logger_totalErrorCount;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 43, num3);
            }
            String str = monitoringStatsV10Message.report_date;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 71, str);
            }
            Long l7 = monitoringStatsV10Message.system_available_internal_storage;
            if (l7 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 75, l7);
            }
            Integer num4 = monitoringStatsV10Message.sdk_initialize;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 128, num4);
            }
            Integer num5 = monitoringStatsV10Message.sdk_start;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 129, num5);
            }
            Integer num6 = monitoringStatsV10Message.sdk_stop;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 130, num6);
            }
            Integer num7 = monitoringStatsV10Message.sdk_configurationUpdated;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 131, num7);
            }
            Long l8 = monitoringStatsV10Message.sdk_monitoring_upTime;
            if (l8 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 132, l8);
            }
            Integer num8 = monitoringStatsV10Message.sdk_timeChangeBack;
            if (num8 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 133, num8);
            }
            Integer num9 = monitoringStatsV10Message.sdk_timeChangeForward;
            if (num9 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 134, num9);
            }
            Integer num10 = monitoringStatsV10Message.sdk_collectionStarted;
            if (num10 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 135, num10);
            }
            Integer num11 = monitoringStatsV10Message.sdk_collectionStopped;
            if (num11 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 136, num11);
            }
            Integer num12 = monitoringStatsV10Message.receiver_autocheck;
            if (num12 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 137, num12);
            }
            Integer num13 = monitoringStatsV10Message.receiver_reinitialize;
            if (num13 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 138, num13);
            }
            Integer num14 = monitoringStatsV10Message.receiver_ingestion_transmissionRequested;
            if (num14 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 139, num14);
            }
            Integer num15 = monitoringStatsV10Message.receiver_monitorStats_transmissionRequested;
            if (num15 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, (int) IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, num15);
            }
            Integer num16 = monitoringStatsV10Message.receiver_location_updatedRequested;
            if (num16 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 141, num16);
            }
            Integer num17 = monitoringStatsV10Message.receiver_location_recurrentCollectionRequested;
            if (num17 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 142, num17);
            }
            Integer num18 = monitoringStatsV10Message.receiver_wifi;
            if (num18 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 143, num18);
            }
            Integer num19 = monitoringStatsV10Message.collection_mnsiCollected;
            if (num19 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 145, num19);
            }
            Integer num20 = monitoringStatsV10Message.collection_locationCollected;
            if (num20 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 146, num20);
            }
            Integer num21 = monitoringStatsV10Message.collection_ndtCollected;
            if (num21 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 147, num21);
            }
            Integer num22 = monitoringStatsV10Message.collection_noSignalDataCollected;
            if (num22 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 148, num22);
            }
            Integer num23 = monitoringStatsV10Message.collection_wifiCollected;
            if (num23 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 173, num23);
            }
            Integer num24 = monitoringStatsV10Message.ingestion_buildPacket_mnsiRecords;
            if (num24 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 149, num24);
            }
            Integer num25 = monitoringStatsV10Message.ingestion_buildPacket_wifiRecords;
            if (num25 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, (int) IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, num25);
            }
            Integer num26 = monitoringStatsV10Message.ingestion_buildPacket_noSignalRecords;
            if (num26 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 151, num26);
            }
            Integer num27 = monitoringStatsV10Message.ingestion_buildPacket_networkDiagnosticRecords;
            if (num27 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 152, num27);
            }
            Integer num28 = monitoringStatsV10Message.ingestion_buildPacket_locationRecords;
            if (num28 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 153, num28);
            }
            Integer num29 = monitoringStatsV10Message.ingestion_transmitData_submittedNetworkPacketSent;
            if (num29 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 154, num29);
            }
            Integer num30 = monitoringStatsV10Message.ingestion_transmitData_submittedLocationPacketSent;
            if (num30 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 155, num30);
            }
            Integer num31 = monitoringStatsV10Message.ingestion_transmitData_submittedMnsiRecordsAccepted;
            if (num31 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 156, num31);
            }
            Integer num32 = monitoringStatsV10Message.ingestion_transmitData_submittedWifiRecordsAccepted;
            if (num32 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 157, num32);
            }
            Integer num33 = monitoringStatsV10Message.ingestion_transmitData_submittedNoSignalRecordsAccepted;
            if (num33 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 158, num33);
            }
            Integer num34 = monitoringStatsV10Message.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
            if (num34 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 159, num34);
            }
            Integer num35 = monitoringStatsV10Message.ingestion_transmitData_submittedLocationRecordsAccepted;
            if (num35 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 160, num35);
            }
            Integer num36 = monitoringStatsV10Message.ndt_checkFullTest;
            if (num36 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 161, num36);
            }
            Integer num37 = monitoringStatsV10Message.ndt_checkLatencyTest;
            if (num37 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 162, num37);
            }
            Integer num38 = monitoringStatsV10Message.ndt_checkDownloadTest;
            if (num38 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 163, num38);
            }
            Integer num39 = monitoringStatsV10Message.ndt_checkUploadTest;
            if (num39 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 164, num39);
            }
            Integer num40 = monitoringStatsV10Message.ndt_startTestFull;
            if (num40 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 165, num40);
            }
            Integer num41 = monitoringStatsV10Message.ndt_startTestLatency;
            if (num41 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 166, num41);
            }
            Integer num42 = monitoringStatsV10Message.ndt_startTestDownload;
            if (num42 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 167, num42);
            }
            Integer num43 = monitoringStatsV10Message.ndt_startTestUpload;
            if (num43 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 168, num43);
            }
            Integer num44 = monitoringStatsV10Message.ndt_testCompletedFull;
            if (num44 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 169, num44);
            }
            Integer num45 = monitoringStatsV10Message.ndt_testCompletedLatency;
            if (num45 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 170, num45);
            }
            Integer num46 = monitoringStatsV10Message.ndt_testCompletedDownload;
            if (num46 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 171, num46);
            }
            Integer num47 = monitoringStatsV10Message.ndt_testCompletedUpload;
            if (num47 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 172, num47);
            }
            protoWriter.writeBytes(monitoringStatsV10Message.unknownFields());
        }

        public int encodedSize(MonitoringStatsV10Message monitoringStatsV10Message) {
            Long l = monitoringStatsV10Message.system_clock_up_time;
            int i = 0;
            int encodedSizeWithTag = l != null ? ProtoAdapter.INT64.encodedSizeWithTag(21, l) : 0;
            Long l2 = monitoringStatsV10Message.system_clock_elapsed_time;
            int encodedSizeWithTag2 = encodedSizeWithTag + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(22, l2) : 0);
            Integer num = monitoringStatsV10Message.is_storage_full;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num) : 0);
            Long l3 = monitoringStatsV10Message.app_memory;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (l3 != null ? ProtoAdapter.INT64.encodedSizeWithTag(28, l3) : 0);
            Long l4 = monitoringStatsV10Message.system_current_memory;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (l4 != null ? ProtoAdapter.INT64.encodedSizeWithTag(29, l4) : 0);
            Long l5 = monitoringStatsV10Message.system_available_memory;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (l5 != null ? ProtoAdapter.INT64.encodedSizeWithTag(30, l5) : 0);
            Long l6 = monitoringStatsV10Message.system_total_internal_storage;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (l6 != null ? ProtoAdapter.INT64.encodedSizeWithTag(31, l6) : 0);
            Integer num2 = monitoringStatsV10Message.count_installed_apps;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num2) : 0);
            Integer num3 = monitoringStatsV10Message.logger_totalErrorCount;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(43, num3) : 0);
            String str = monitoringStatsV10Message.report_date;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(71, str) : 0);
            Long l7 = monitoringStatsV10Message.system_available_internal_storage;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (l7 != null ? ProtoAdapter.INT64.encodedSizeWithTag(75, l7) : 0);
            Integer num4 = monitoringStatsV10Message.sdk_initialize;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(128, num4) : 0);
            Integer num5 = monitoringStatsV10Message.sdk_start;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(129, num5) : 0);
            Integer num6 = monitoringStatsV10Message.sdk_stop;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(130, num6) : 0);
            Integer num7 = monitoringStatsV10Message.sdk_configurationUpdated;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(131, num7) : 0);
            Long l8 = monitoringStatsV10Message.sdk_monitoring_upTime;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (l8 != null ? ProtoAdapter.INT64.encodedSizeWithTag(132, l8) : 0);
            Integer num8 = monitoringStatsV10Message.sdk_timeChangeBack;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (num8 != null ? ProtoAdapter.INT32.encodedSizeWithTag(133, num8) : 0);
            Integer num9 = monitoringStatsV10Message.sdk_timeChangeForward;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (num9 != null ? ProtoAdapter.INT32.encodedSizeWithTag(134, num9) : 0);
            Integer num10 = monitoringStatsV10Message.sdk_collectionStarted;
            int encodedSizeWithTag19 = encodedSizeWithTag18 + (num10 != null ? ProtoAdapter.INT32.encodedSizeWithTag(135, num10) : 0);
            Integer num11 = monitoringStatsV10Message.sdk_collectionStopped;
            int encodedSizeWithTag20 = encodedSizeWithTag19 + (num11 != null ? ProtoAdapter.INT32.encodedSizeWithTag(136, num11) : 0);
            Integer num12 = monitoringStatsV10Message.receiver_autocheck;
            int encodedSizeWithTag21 = encodedSizeWithTag20 + (num12 != null ? ProtoAdapter.INT32.encodedSizeWithTag(137, num12) : 0);
            Integer num13 = monitoringStatsV10Message.receiver_reinitialize;
            int encodedSizeWithTag22 = encodedSizeWithTag21 + (num13 != null ? ProtoAdapter.INT32.encodedSizeWithTag(138, num13) : 0);
            Integer num14 = monitoringStatsV10Message.receiver_ingestion_transmissionRequested;
            int encodedSizeWithTag23 = encodedSizeWithTag22 + (num14 != null ? ProtoAdapter.INT32.encodedSizeWithTag(139, num14) : 0);
            Integer num15 = monitoringStatsV10Message.receiver_monitorStats_transmissionRequested;
            int encodedSizeWithTag24 = encodedSizeWithTag23 + (num15 != null ? ProtoAdapter.INT32.encodedSizeWithTag(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, num15) : 0);
            Integer num16 = monitoringStatsV10Message.receiver_location_updatedRequested;
            int encodedSizeWithTag25 = encodedSizeWithTag24 + (num16 != null ? ProtoAdapter.INT32.encodedSizeWithTag(141, num16) : 0);
            Integer num17 = monitoringStatsV10Message.receiver_location_recurrentCollectionRequested;
            int encodedSizeWithTag26 = encodedSizeWithTag25 + (num17 != null ? ProtoAdapter.INT32.encodedSizeWithTag(142, num17) : 0);
            Integer num18 = monitoringStatsV10Message.receiver_wifi;
            int encodedSizeWithTag27 = encodedSizeWithTag26 + (num18 != null ? ProtoAdapter.INT32.encodedSizeWithTag(143, num18) : 0);
            Integer num19 = monitoringStatsV10Message.collection_mnsiCollected;
            int encodedSizeWithTag28 = encodedSizeWithTag27 + (num19 != null ? ProtoAdapter.INT32.encodedSizeWithTag(145, num19) : 0);
            Integer num20 = monitoringStatsV10Message.collection_locationCollected;
            int encodedSizeWithTag29 = encodedSizeWithTag28 + (num20 != null ? ProtoAdapter.INT32.encodedSizeWithTag(146, num20) : 0);
            Integer num21 = monitoringStatsV10Message.collection_ndtCollected;
            int encodedSizeWithTag30 = encodedSizeWithTag29 + (num21 != null ? ProtoAdapter.INT32.encodedSizeWithTag(147, num21) : 0);
            Integer num22 = monitoringStatsV10Message.collection_noSignalDataCollected;
            int encodedSizeWithTag31 = encodedSizeWithTag30 + (num22 != null ? ProtoAdapter.INT32.encodedSizeWithTag(148, num22) : 0);
            Integer num23 = monitoringStatsV10Message.collection_wifiCollected;
            int encodedSizeWithTag32 = encodedSizeWithTag31 + (num23 != null ? ProtoAdapter.INT32.encodedSizeWithTag(173, num23) : 0);
            Integer num24 = monitoringStatsV10Message.ingestion_buildPacket_mnsiRecords;
            int encodedSizeWithTag33 = encodedSizeWithTag32 + (num24 != null ? ProtoAdapter.INT32.encodedSizeWithTag(149, num24) : 0);
            Integer num25 = monitoringStatsV10Message.ingestion_buildPacket_wifiRecords;
            int encodedSizeWithTag34 = encodedSizeWithTag33 + (num25 != null ? ProtoAdapter.INT32.encodedSizeWithTag(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, num25) : 0);
            Integer num26 = monitoringStatsV10Message.ingestion_buildPacket_noSignalRecords;
            int encodedSizeWithTag35 = encodedSizeWithTag34 + (num26 != null ? ProtoAdapter.INT32.encodedSizeWithTag(151, num26) : 0);
            Integer num27 = monitoringStatsV10Message.ingestion_buildPacket_networkDiagnosticRecords;
            int encodedSizeWithTag36 = encodedSizeWithTag35 + (num27 != null ? ProtoAdapter.INT32.encodedSizeWithTag(152, num27) : 0);
            Integer num28 = monitoringStatsV10Message.ingestion_buildPacket_locationRecords;
            int encodedSizeWithTag37 = encodedSizeWithTag36 + (num28 != null ? ProtoAdapter.INT32.encodedSizeWithTag(153, num28) : 0);
            Integer num29 = monitoringStatsV10Message.ingestion_transmitData_submittedNetworkPacketSent;
            int encodedSizeWithTag38 = encodedSizeWithTag37 + (num29 != null ? ProtoAdapter.INT32.encodedSizeWithTag(154, num29) : 0);
            Integer num30 = monitoringStatsV10Message.ingestion_transmitData_submittedLocationPacketSent;
            int encodedSizeWithTag39 = encodedSizeWithTag38 + (num30 != null ? ProtoAdapter.INT32.encodedSizeWithTag(155, num30) : 0);
            Integer num31 = monitoringStatsV10Message.ingestion_transmitData_submittedMnsiRecordsAccepted;
            int encodedSizeWithTag40 = encodedSizeWithTag39 + (num31 != null ? ProtoAdapter.INT32.encodedSizeWithTag(156, num31) : 0);
            Integer num32 = monitoringStatsV10Message.ingestion_transmitData_submittedWifiRecordsAccepted;
            int encodedSizeWithTag41 = encodedSizeWithTag40 + (num32 != null ? ProtoAdapter.INT32.encodedSizeWithTag(157, num32) : 0);
            Integer num33 = monitoringStatsV10Message.ingestion_transmitData_submittedNoSignalRecordsAccepted;
            int encodedSizeWithTag42 = encodedSizeWithTag41 + (num33 != null ? ProtoAdapter.INT32.encodedSizeWithTag(158, num33) : 0);
            Integer num34 = monitoringStatsV10Message.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
            int encodedSizeWithTag43 = encodedSizeWithTag42 + (num34 != null ? ProtoAdapter.INT32.encodedSizeWithTag(159, num34) : 0);
            Integer num35 = monitoringStatsV10Message.ingestion_transmitData_submittedLocationRecordsAccepted;
            int encodedSizeWithTag44 = encodedSizeWithTag43 + (num35 != null ? ProtoAdapter.INT32.encodedSizeWithTag(160, num35) : 0);
            Integer num36 = monitoringStatsV10Message.ndt_checkFullTest;
            int encodedSizeWithTag45 = encodedSizeWithTag44 + (num36 != null ? ProtoAdapter.INT32.encodedSizeWithTag(161, num36) : 0);
            Integer num37 = monitoringStatsV10Message.ndt_checkLatencyTest;
            int encodedSizeWithTag46 = encodedSizeWithTag45 + (num37 != null ? ProtoAdapter.INT32.encodedSizeWithTag(162, num37) : 0);
            Integer num38 = monitoringStatsV10Message.ndt_checkDownloadTest;
            int encodedSizeWithTag47 = encodedSizeWithTag46 + (num38 != null ? ProtoAdapter.INT32.encodedSizeWithTag(163, num38) : 0);
            Integer num39 = monitoringStatsV10Message.ndt_checkUploadTest;
            int encodedSizeWithTag48 = encodedSizeWithTag47 + (num39 != null ? ProtoAdapter.INT32.encodedSizeWithTag(164, num39) : 0);
            Integer num40 = monitoringStatsV10Message.ndt_startTestFull;
            int encodedSizeWithTag49 = encodedSizeWithTag48 + (num40 != null ? ProtoAdapter.INT32.encodedSizeWithTag(165, num40) : 0);
            Integer num41 = monitoringStatsV10Message.ndt_startTestLatency;
            int encodedSizeWithTag50 = encodedSizeWithTag49 + (num41 != null ? ProtoAdapter.INT32.encodedSizeWithTag(166, num41) : 0);
            Integer num42 = monitoringStatsV10Message.ndt_startTestDownload;
            int encodedSizeWithTag51 = encodedSizeWithTag50 + (num42 != null ? ProtoAdapter.INT32.encodedSizeWithTag(167, num42) : 0);
            Integer num43 = monitoringStatsV10Message.ndt_startTestUpload;
            int encodedSizeWithTag52 = encodedSizeWithTag51 + (num43 != null ? ProtoAdapter.INT32.encodedSizeWithTag(168, num43) : 0);
            Integer num44 = monitoringStatsV10Message.ndt_testCompletedFull;
            int encodedSizeWithTag53 = encodedSizeWithTag52 + (num44 != null ? ProtoAdapter.INT32.encodedSizeWithTag(169, num44) : 0);
            Integer num45 = monitoringStatsV10Message.ndt_testCompletedLatency;
            int encodedSizeWithTag54 = encodedSizeWithTag53 + (num45 != null ? ProtoAdapter.INT32.encodedSizeWithTag(170, num45) : 0);
            Integer num46 = monitoringStatsV10Message.ndt_testCompletedDownload;
            int encodedSizeWithTag55 = encodedSizeWithTag54 + (num46 != null ? ProtoAdapter.INT32.encodedSizeWithTag(171, num46) : 0);
            Integer num47 = monitoringStatsV10Message.ndt_testCompletedUpload;
            if (num47 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(172, num47);
            }
            return monitoringStatsV10Message.unknownFields().size() + encodedSizeWithTag55 + i;
        }

        public MonitoringStatsV10Message redact(MonitoringStatsV10Message monitoringStatsV10Message) {
            Builder newBuilder = monitoringStatsV10Message.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MonitoringStatsV10Message(Long l, Long l2, Integer num, Long l3, Long l4, Long l5, Long l6, Integer num2, Integer num3, String str, Long l7, Integer num4, Integer num5, Integer num6, Integer num7, Long l8, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47) {
        this(l, l2, num, l3, l4, l5, l6, num2, num3, str, l7, num4, num5, num6, num7, l8, num8, num9, num10, num11, num12, num13, num14, num15, num16, num17, num18, num19, num20, num21, num22, num23, num24, num25, num26, num27, num28, num29, num30, num31, num32, num33, num34, num35, num36, num37, num38, num39, num40, num41, num42, num43, num44, num45, num46, num47, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MonitoringStatsV10Message)) {
            return false;
        }
        MonitoringStatsV10Message monitoringStatsV10Message = (MonitoringStatsV10Message) obj;
        if (!unknownFields().equals(monitoringStatsV10Message.unknownFields()) || !Internal.equals(this.system_clock_up_time, monitoringStatsV10Message.system_clock_up_time) || !Internal.equals(this.system_clock_elapsed_time, monitoringStatsV10Message.system_clock_elapsed_time) || !Internal.equals(this.is_storage_full, monitoringStatsV10Message.is_storage_full) || !Internal.equals(this.app_memory, monitoringStatsV10Message.app_memory) || !Internal.equals(this.system_current_memory, monitoringStatsV10Message.system_current_memory) || !Internal.equals(this.system_available_memory, monitoringStatsV10Message.system_available_memory) || !Internal.equals(this.system_total_internal_storage, monitoringStatsV10Message.system_total_internal_storage) || !Internal.equals(this.count_installed_apps, monitoringStatsV10Message.count_installed_apps) || !Internal.equals(this.logger_totalErrorCount, monitoringStatsV10Message.logger_totalErrorCount) || !Internal.equals(this.report_date, monitoringStatsV10Message.report_date) || !Internal.equals(this.system_available_internal_storage, monitoringStatsV10Message.system_available_internal_storage) || !Internal.equals(this.sdk_initialize, monitoringStatsV10Message.sdk_initialize) || !Internal.equals(this.sdk_start, monitoringStatsV10Message.sdk_start) || !Internal.equals(this.sdk_stop, monitoringStatsV10Message.sdk_stop) || !Internal.equals(this.sdk_configurationUpdated, monitoringStatsV10Message.sdk_configurationUpdated) || !Internal.equals(this.sdk_monitoring_upTime, monitoringStatsV10Message.sdk_monitoring_upTime) || !Internal.equals(this.sdk_timeChangeBack, monitoringStatsV10Message.sdk_timeChangeBack) || !Internal.equals(this.sdk_timeChangeForward, monitoringStatsV10Message.sdk_timeChangeForward) || !Internal.equals(this.sdk_collectionStarted, monitoringStatsV10Message.sdk_collectionStarted) || !Internal.equals(this.sdk_collectionStopped, monitoringStatsV10Message.sdk_collectionStopped) || !Internal.equals(this.receiver_autocheck, monitoringStatsV10Message.receiver_autocheck) || !Internal.equals(this.receiver_reinitialize, monitoringStatsV10Message.receiver_reinitialize) || !Internal.equals(this.receiver_ingestion_transmissionRequested, monitoringStatsV10Message.receiver_ingestion_transmissionRequested) || !Internal.equals(this.receiver_monitorStats_transmissionRequested, monitoringStatsV10Message.receiver_monitorStats_transmissionRequested) || !Internal.equals(this.receiver_location_updatedRequested, monitoringStatsV10Message.receiver_location_updatedRequested) || !Internal.equals(this.receiver_location_recurrentCollectionRequested, monitoringStatsV10Message.receiver_location_recurrentCollectionRequested) || !Internal.equals(this.receiver_wifi, monitoringStatsV10Message.receiver_wifi) || !Internal.equals(this.collection_mnsiCollected, monitoringStatsV10Message.collection_mnsiCollected) || !Internal.equals(this.collection_locationCollected, monitoringStatsV10Message.collection_locationCollected) || !Internal.equals(this.collection_ndtCollected, monitoringStatsV10Message.collection_ndtCollected) || !Internal.equals(this.collection_noSignalDataCollected, monitoringStatsV10Message.collection_noSignalDataCollected) || !Internal.equals(this.collection_wifiCollected, monitoringStatsV10Message.collection_wifiCollected) || !Internal.equals(this.ingestion_buildPacket_mnsiRecords, monitoringStatsV10Message.ingestion_buildPacket_mnsiRecords) || !Internal.equals(this.ingestion_buildPacket_wifiRecords, monitoringStatsV10Message.ingestion_buildPacket_wifiRecords) || !Internal.equals(this.ingestion_buildPacket_noSignalRecords, monitoringStatsV10Message.ingestion_buildPacket_noSignalRecords) || !Internal.equals(this.ingestion_buildPacket_networkDiagnosticRecords, monitoringStatsV10Message.ingestion_buildPacket_networkDiagnosticRecords) || !Internal.equals(this.ingestion_buildPacket_locationRecords, monitoringStatsV10Message.ingestion_buildPacket_locationRecords) || !Internal.equals(this.ingestion_transmitData_submittedNetworkPacketSent, monitoringStatsV10Message.ingestion_transmitData_submittedNetworkPacketSent) || !Internal.equals(this.ingestion_transmitData_submittedLocationPacketSent, monitoringStatsV10Message.ingestion_transmitData_submittedLocationPacketSent) || !Internal.equals(this.ingestion_transmitData_submittedMnsiRecordsAccepted, monitoringStatsV10Message.ingestion_transmitData_submittedMnsiRecordsAccepted) || !Internal.equals(this.ingestion_transmitData_submittedWifiRecordsAccepted, monitoringStatsV10Message.ingestion_transmitData_submittedWifiRecordsAccepted) || !Internal.equals(this.ingestion_transmitData_submittedNoSignalRecordsAccepted, monitoringStatsV10Message.ingestion_transmitData_submittedNoSignalRecordsAccepted) || !Internal.equals(this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted, monitoringStatsV10Message.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted) || !Internal.equals(this.ingestion_transmitData_submittedLocationRecordsAccepted, monitoringStatsV10Message.ingestion_transmitData_submittedLocationRecordsAccepted) || !Internal.equals(this.ndt_checkFullTest, monitoringStatsV10Message.ndt_checkFullTest) || !Internal.equals(this.ndt_checkLatencyTest, monitoringStatsV10Message.ndt_checkLatencyTest) || !Internal.equals(this.ndt_checkDownloadTest, monitoringStatsV10Message.ndt_checkDownloadTest) || !Internal.equals(this.ndt_checkUploadTest, monitoringStatsV10Message.ndt_checkUploadTest) || !Internal.equals(this.ndt_startTestFull, monitoringStatsV10Message.ndt_startTestFull) || !Internal.equals(this.ndt_startTestLatency, monitoringStatsV10Message.ndt_startTestLatency) || !Internal.equals(this.ndt_startTestDownload, monitoringStatsV10Message.ndt_startTestDownload) || !Internal.equals(this.ndt_startTestUpload, monitoringStatsV10Message.ndt_startTestUpload) || !Internal.equals(this.ndt_testCompletedFull, monitoringStatsV10Message.ndt_testCompletedFull) || !Internal.equals(this.ndt_testCompletedLatency, monitoringStatsV10Message.ndt_testCompletedLatency) || !Internal.equals(this.ndt_testCompletedDownload, monitoringStatsV10Message.ndt_testCompletedDownload) || !Internal.equals(this.ndt_testCompletedUpload, monitoringStatsV10Message.ndt_testCompletedUpload)) {
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
        Long l = this.system_clock_up_time;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.system_clock_elapsed_time;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.is_storage_full;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.app_memory;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.system_current_memory;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.system_available_memory;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.system_total_internal_storage;
        int hashCode8 = (hashCode7 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num2 = this.count_installed_apps;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.logger_totalErrorCount;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.report_date;
        int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
        Long l7 = this.system_available_internal_storage;
        int hashCode12 = (hashCode11 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num4 = this.sdk_initialize;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.sdk_start;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.sdk_stop;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.sdk_configurationUpdated;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l8 = this.sdk_monitoring_upTime;
        int hashCode17 = (hashCode16 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Integer num8 = this.sdk_timeChangeBack;
        int hashCode18 = (hashCode17 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.sdk_timeChangeForward;
        int hashCode19 = (hashCode18 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.sdk_collectionStarted;
        int hashCode20 = (hashCode19 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.sdk_collectionStopped;
        int hashCode21 = (hashCode20 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.receiver_autocheck;
        int hashCode22 = (hashCode21 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.receiver_reinitialize;
        int hashCode23 = (hashCode22 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.receiver_ingestion_transmissionRequested;
        int hashCode24 = (hashCode23 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.receiver_monitorStats_transmissionRequested;
        int hashCode25 = (hashCode24 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.receiver_location_updatedRequested;
        int hashCode26 = (hashCode25 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.receiver_location_recurrentCollectionRequested;
        int hashCode27 = (hashCode26 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.receiver_wifi;
        int hashCode28 = (hashCode27 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.collection_mnsiCollected;
        int hashCode29 = (hashCode28 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.collection_locationCollected;
        int hashCode30 = (hashCode29 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.collection_ndtCollected;
        int hashCode31 = (hashCode30 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Integer num22 = this.collection_noSignalDataCollected;
        int hashCode32 = (hashCode31 + (num22 != null ? num22.hashCode() : 0)) * 37;
        Integer num23 = this.collection_wifiCollected;
        int hashCode33 = (hashCode32 + (num23 != null ? num23.hashCode() : 0)) * 37;
        Integer num24 = this.ingestion_buildPacket_mnsiRecords;
        int hashCode34 = (hashCode33 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.ingestion_buildPacket_wifiRecords;
        int hashCode35 = (hashCode34 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Integer num26 = this.ingestion_buildPacket_noSignalRecords;
        int hashCode36 = (hashCode35 + (num26 != null ? num26.hashCode() : 0)) * 37;
        Integer num27 = this.ingestion_buildPacket_networkDiagnosticRecords;
        int hashCode37 = (hashCode36 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Integer num28 = this.ingestion_buildPacket_locationRecords;
        int hashCode38 = (hashCode37 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.ingestion_transmitData_submittedNetworkPacketSent;
        int hashCode39 = (hashCode38 + (num29 != null ? num29.hashCode() : 0)) * 37;
        Integer num30 = this.ingestion_transmitData_submittedLocationPacketSent;
        int hashCode40 = (hashCode39 + (num30 != null ? num30.hashCode() : 0)) * 37;
        Integer num31 = this.ingestion_transmitData_submittedMnsiRecordsAccepted;
        int hashCode41 = (hashCode40 + (num31 != null ? num31.hashCode() : 0)) * 37;
        Integer num32 = this.ingestion_transmitData_submittedWifiRecordsAccepted;
        int hashCode42 = (hashCode41 + (num32 != null ? num32.hashCode() : 0)) * 37;
        Integer num33 = this.ingestion_transmitData_submittedNoSignalRecordsAccepted;
        int hashCode43 = (hashCode42 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Integer num34 = this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
        int hashCode44 = (hashCode43 + (num34 != null ? num34.hashCode() : 0)) * 37;
        Integer num35 = this.ingestion_transmitData_submittedLocationRecordsAccepted;
        int hashCode45 = (hashCode44 + (num35 != null ? num35.hashCode() : 0)) * 37;
        Integer num36 = this.ndt_checkFullTest;
        int hashCode46 = (hashCode45 + (num36 != null ? num36.hashCode() : 0)) * 37;
        Integer num37 = this.ndt_checkLatencyTest;
        int hashCode47 = (hashCode46 + (num37 != null ? num37.hashCode() : 0)) * 37;
        Integer num38 = this.ndt_checkDownloadTest;
        int hashCode48 = (hashCode47 + (num38 != null ? num38.hashCode() : 0)) * 37;
        Integer num39 = this.ndt_checkUploadTest;
        int hashCode49 = (hashCode48 + (num39 != null ? num39.hashCode() : 0)) * 37;
        Integer num40 = this.ndt_startTestFull;
        int hashCode50 = (hashCode49 + (num40 != null ? num40.hashCode() : 0)) * 37;
        Integer num41 = this.ndt_startTestLatency;
        int hashCode51 = (hashCode50 + (num41 != null ? num41.hashCode() : 0)) * 37;
        Integer num42 = this.ndt_startTestDownload;
        int hashCode52 = (hashCode51 + (num42 != null ? num42.hashCode() : 0)) * 37;
        Integer num43 = this.ndt_startTestUpload;
        int hashCode53 = (hashCode52 + (num43 != null ? num43.hashCode() : 0)) * 37;
        Integer num44 = this.ndt_testCompletedFull;
        int hashCode54 = (hashCode53 + (num44 != null ? num44.hashCode() : 0)) * 37;
        Integer num45 = this.ndt_testCompletedLatency;
        int hashCode55 = (hashCode54 + (num45 != null ? num45.hashCode() : 0)) * 37;
        Integer num46 = this.ndt_testCompletedDownload;
        int hashCode56 = (hashCode55 + (num46 != null ? num46.hashCode() : 0)) * 37;
        Integer num47 = this.ndt_testCompletedUpload;
        if (num47 != null) {
            i2 = num47.hashCode();
        }
        int i3 = hashCode56 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.system_clock_up_time != null) {
            sb.append(", system_clock_up_time=");
            sb.append(this.system_clock_up_time);
        }
        if (this.system_clock_elapsed_time != null) {
            sb.append(", system_clock_elapsed_time=");
            sb.append(this.system_clock_elapsed_time);
        }
        if (this.is_storage_full != null) {
            sb.append(", is_storage_full=");
            sb.append(this.is_storage_full);
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
        if (this.logger_totalErrorCount != null) {
            sb.append(", logger_totalErrorCount=");
            sb.append(this.logger_totalErrorCount);
        }
        if (this.report_date != null) {
            sb.append(", report_date=");
            sb.append(this.report_date);
        }
        if (this.system_available_internal_storage != null) {
            sb.append(", system_available_internal_storage=");
            sb.append(this.system_available_internal_storage);
        }
        if (this.sdk_initialize != null) {
            sb.append(", sdk_initialize=");
            sb.append(this.sdk_initialize);
        }
        if (this.sdk_start != null) {
            sb.append(", sdk_start=");
            sb.append(this.sdk_start);
        }
        if (this.sdk_stop != null) {
            sb.append(", sdk_stop=");
            sb.append(this.sdk_stop);
        }
        if (this.sdk_configurationUpdated != null) {
            sb.append(", sdk_configurationUpdated=");
            sb.append(this.sdk_configurationUpdated);
        }
        if (this.sdk_monitoring_upTime != null) {
            sb.append(", sdk_monitoring_upTime=");
            sb.append(this.sdk_monitoring_upTime);
        }
        if (this.sdk_timeChangeBack != null) {
            sb.append(", sdk_timeChangeBack=");
            sb.append(this.sdk_timeChangeBack);
        }
        if (this.sdk_timeChangeForward != null) {
            sb.append(", sdk_timeChangeForward=");
            sb.append(this.sdk_timeChangeForward);
        }
        if (this.sdk_collectionStarted != null) {
            sb.append(", sdk_collectionStarted=");
            sb.append(this.sdk_collectionStarted);
        }
        if (this.sdk_collectionStopped != null) {
            sb.append(", sdk_collectionStopped=");
            sb.append(this.sdk_collectionStopped);
        }
        if (this.receiver_autocheck != null) {
            sb.append(", receiver_autocheck=");
            sb.append(this.receiver_autocheck);
        }
        if (this.receiver_reinitialize != null) {
            sb.append(", receiver_reinitialize=");
            sb.append(this.receiver_reinitialize);
        }
        if (this.receiver_ingestion_transmissionRequested != null) {
            sb.append(", receiver_ingestion_transmissionRequested=");
            sb.append(this.receiver_ingestion_transmissionRequested);
        }
        if (this.receiver_monitorStats_transmissionRequested != null) {
            sb.append(", receiver_monitorStats_transmissionRequested=");
            sb.append(this.receiver_monitorStats_transmissionRequested);
        }
        if (this.receiver_location_updatedRequested != null) {
            sb.append(", receiver_location_updatedRequested=");
            sb.append(this.receiver_location_updatedRequested);
        }
        if (this.receiver_location_recurrentCollectionRequested != null) {
            sb.append(", receiver_location_recurrentCollectionRequested=");
            sb.append(this.receiver_location_recurrentCollectionRequested);
        }
        if (this.receiver_wifi != null) {
            sb.append(", receiver_wifi=");
            sb.append(this.receiver_wifi);
        }
        if (this.collection_mnsiCollected != null) {
            sb.append(", collection_mnsiCollected=");
            sb.append(this.collection_mnsiCollected);
        }
        if (this.collection_locationCollected != null) {
            sb.append(", collection_locationCollected=");
            sb.append(this.collection_locationCollected);
        }
        if (this.collection_ndtCollected != null) {
            sb.append(", collection_ndtCollected=");
            sb.append(this.collection_ndtCollected);
        }
        if (this.collection_noSignalDataCollected != null) {
            sb.append(", collection_noSignalDataCollected=");
            sb.append(this.collection_noSignalDataCollected);
        }
        if (this.collection_wifiCollected != null) {
            sb.append(", collection_wifiCollected=");
            sb.append(this.collection_wifiCollected);
        }
        if (this.ingestion_buildPacket_mnsiRecords != null) {
            sb.append(", ingestion_buildPacket_mnsiRecords=");
            sb.append(this.ingestion_buildPacket_mnsiRecords);
        }
        if (this.ingestion_buildPacket_wifiRecords != null) {
            sb.append(", ingestion_buildPacket_wifiRecords=");
            sb.append(this.ingestion_buildPacket_wifiRecords);
        }
        if (this.ingestion_buildPacket_noSignalRecords != null) {
            sb.append(", ingestion_buildPacket_noSignalRecords=");
            sb.append(this.ingestion_buildPacket_noSignalRecords);
        }
        if (this.ingestion_buildPacket_networkDiagnosticRecords != null) {
            sb.append(", ingestion_buildPacket_networkDiagnosticRecords=");
            sb.append(this.ingestion_buildPacket_networkDiagnosticRecords);
        }
        if (this.ingestion_buildPacket_locationRecords != null) {
            sb.append(", ingestion_buildPacket_locationRecords=");
            sb.append(this.ingestion_buildPacket_locationRecords);
        }
        if (this.ingestion_transmitData_submittedNetworkPacketSent != null) {
            sb.append(", ingestion_transmitData_submittedNetworkPacketSent=");
            sb.append(this.ingestion_transmitData_submittedNetworkPacketSent);
        }
        if (this.ingestion_transmitData_submittedLocationPacketSent != null) {
            sb.append(", ingestion_transmitData_submittedLocationPacketSent=");
            sb.append(this.ingestion_transmitData_submittedLocationPacketSent);
        }
        if (this.ingestion_transmitData_submittedMnsiRecordsAccepted != null) {
            sb.append(", ingestion_transmitData_submittedMnsiRecordsAccepted=");
            sb.append(this.ingestion_transmitData_submittedMnsiRecordsAccepted);
        }
        if (this.ingestion_transmitData_submittedWifiRecordsAccepted != null) {
            sb.append(", ingestion_transmitData_submittedWifiRecordsAccepted=");
            sb.append(this.ingestion_transmitData_submittedWifiRecordsAccepted);
        }
        if (this.ingestion_transmitData_submittedNoSignalRecordsAccepted != null) {
            sb.append(", ingestion_transmitData_submittedNoSignalRecordsAccepted=");
            sb.append(this.ingestion_transmitData_submittedNoSignalRecordsAccepted);
        }
        if (this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted != null) {
            sb.append(", ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted=");
            sb.append(this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted);
        }
        if (this.ingestion_transmitData_submittedLocationRecordsAccepted != null) {
            sb.append(", ingestion_transmitData_submittedLocationRecordsAccepted=");
            sb.append(this.ingestion_transmitData_submittedLocationRecordsAccepted);
        }
        if (this.ndt_checkFullTest != null) {
            sb.append(", ndt_checkFullTest=");
            sb.append(this.ndt_checkFullTest);
        }
        if (this.ndt_checkLatencyTest != null) {
            sb.append(", ndt_checkLatencyTest=");
            sb.append(this.ndt_checkLatencyTest);
        }
        if (this.ndt_checkDownloadTest != null) {
            sb.append(", ndt_checkDownloadTest=");
            sb.append(this.ndt_checkDownloadTest);
        }
        if (this.ndt_checkUploadTest != null) {
            sb.append(", ndt_checkUploadTest=");
            sb.append(this.ndt_checkUploadTest);
        }
        if (this.ndt_startTestFull != null) {
            sb.append(", ndt_startTestFull=");
            sb.append(this.ndt_startTestFull);
        }
        if (this.ndt_startTestLatency != null) {
            sb.append(", ndt_startTestLatency=");
            sb.append(this.ndt_startTestLatency);
        }
        if (this.ndt_startTestDownload != null) {
            sb.append(", ndt_startTestDownload=");
            sb.append(this.ndt_startTestDownload);
        }
        if (this.ndt_startTestUpload != null) {
            sb.append(", ndt_startTestUpload=");
            sb.append(this.ndt_startTestUpload);
        }
        if (this.ndt_testCompletedFull != null) {
            sb.append(", ndt_testCompletedFull=");
            sb.append(this.ndt_testCompletedFull);
        }
        if (this.ndt_testCompletedLatency != null) {
            sb.append(", ndt_testCompletedLatency=");
            sb.append(this.ndt_testCompletedLatency);
        }
        if (this.ndt_testCompletedDownload != null) {
            sb.append(", ndt_testCompletedDownload=");
            sb.append(this.ndt_testCompletedDownload);
        }
        if (this.ndt_testCompletedUpload != null) {
            sb.append(", ndt_testCompletedUpload=");
            sb.append(this.ndt_testCompletedUpload);
        }
        return c.a(sb, 0, 2, "MonitoringStatsV10Message{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitoringStatsV10Message(Long l, Long l2, Integer num, Long l3, Long l4, Long l5, Long l6, Integer num2, Integer num3, String str, Long l7, Integer num4, Integer num5, Integer num6, Integer num7, Long l8, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, ByteString byteString) {
        super(ADAPTER, byteString);
        this.system_clock_up_time = l;
        this.system_clock_elapsed_time = l2;
        this.is_storage_full = num;
        this.app_memory = l3;
        this.system_current_memory = l4;
        this.system_available_memory = l5;
        this.system_total_internal_storage = l6;
        this.count_installed_apps = num2;
        this.logger_totalErrorCount = num3;
        this.report_date = str;
        this.system_available_internal_storage = l7;
        this.sdk_initialize = num4;
        this.sdk_start = num5;
        this.sdk_stop = num6;
        this.sdk_configurationUpdated = num7;
        this.sdk_monitoring_upTime = l8;
        this.sdk_timeChangeBack = num8;
        this.sdk_timeChangeForward = num9;
        this.sdk_collectionStarted = num10;
        this.sdk_collectionStopped = num11;
        this.receiver_autocheck = num12;
        this.receiver_reinitialize = num13;
        this.receiver_ingestion_transmissionRequested = num14;
        this.receiver_monitorStats_transmissionRequested = num15;
        this.receiver_location_updatedRequested = num16;
        this.receiver_location_recurrentCollectionRequested = num17;
        this.receiver_wifi = num18;
        this.collection_mnsiCollected = num19;
        this.collection_locationCollected = num20;
        this.collection_ndtCollected = num21;
        this.collection_noSignalDataCollected = num22;
        this.collection_wifiCollected = num23;
        this.ingestion_buildPacket_mnsiRecords = num24;
        this.ingestion_buildPacket_wifiRecords = num25;
        this.ingestion_buildPacket_noSignalRecords = num26;
        this.ingestion_buildPacket_networkDiagnosticRecords = num27;
        this.ingestion_buildPacket_locationRecords = num28;
        this.ingestion_transmitData_submittedNetworkPacketSent = num29;
        this.ingestion_transmitData_submittedLocationPacketSent = num30;
        this.ingestion_transmitData_submittedMnsiRecordsAccepted = num31;
        this.ingestion_transmitData_submittedWifiRecordsAccepted = num32;
        this.ingestion_transmitData_submittedNoSignalRecordsAccepted = num33;
        this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted = num34;
        this.ingestion_transmitData_submittedLocationRecordsAccepted = num35;
        this.ndt_checkFullTest = num36;
        this.ndt_checkLatencyTest = num37;
        this.ndt_checkDownloadTest = num38;
        this.ndt_checkUploadTest = num39;
        this.ndt_startTestFull = num40;
        this.ndt_startTestLatency = num41;
        this.ndt_startTestDownload = num42;
        this.ndt_startTestUpload = num43;
        this.ndt_testCompletedFull = num44;
        this.ndt_testCompletedLatency = num45;
        this.ndt_testCompletedDownload = num46;
        this.ndt_testCompletedUpload = num47;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.system_clock_up_time = this.system_clock_up_time;
        builder.system_clock_elapsed_time = this.system_clock_elapsed_time;
        builder.is_storage_full = this.is_storage_full;
        builder.app_memory = this.app_memory;
        builder.system_current_memory = this.system_current_memory;
        builder.system_available_memory = this.system_available_memory;
        builder.system_total_internal_storage = this.system_total_internal_storage;
        builder.count_installed_apps = this.count_installed_apps;
        builder.logger_totalErrorCount = this.logger_totalErrorCount;
        builder.report_date = this.report_date;
        builder.system_available_internal_storage = this.system_available_internal_storage;
        builder.sdk_initialize = this.sdk_initialize;
        builder.sdk_start = this.sdk_start;
        builder.sdk_stop = this.sdk_stop;
        builder.sdk_configurationUpdated = this.sdk_configurationUpdated;
        builder.sdk_monitoring_upTime = this.sdk_monitoring_upTime;
        builder.sdk_timeChangeBack = this.sdk_timeChangeBack;
        builder.sdk_timeChangeForward = this.sdk_timeChangeForward;
        builder.sdk_collectionStarted = this.sdk_collectionStarted;
        builder.sdk_collectionStopped = this.sdk_collectionStopped;
        builder.receiver_autocheck = this.receiver_autocheck;
        builder.receiver_reinitialize = this.receiver_reinitialize;
        builder.receiver_ingestion_transmissionRequested = this.receiver_ingestion_transmissionRequested;
        builder.receiver_monitorStats_transmissionRequested = this.receiver_monitorStats_transmissionRequested;
        builder.receiver_location_updatedRequested = this.receiver_location_updatedRequested;
        builder.receiver_location_recurrentCollectionRequested = this.receiver_location_recurrentCollectionRequested;
        builder.receiver_wifi = this.receiver_wifi;
        builder.collection_mnsiCollected = this.collection_mnsiCollected;
        builder.collection_locationCollected = this.collection_locationCollected;
        builder.collection_ndtCollected = this.collection_ndtCollected;
        builder.collection_noSignalDataCollected = this.collection_noSignalDataCollected;
        builder.collection_wifiCollected = this.collection_wifiCollected;
        builder.ingestion_buildPacket_mnsiRecords = this.ingestion_buildPacket_mnsiRecords;
        builder.ingestion_buildPacket_wifiRecords = this.ingestion_buildPacket_wifiRecords;
        builder.ingestion_buildPacket_noSignalRecords = this.ingestion_buildPacket_noSignalRecords;
        builder.ingestion_buildPacket_networkDiagnosticRecords = this.ingestion_buildPacket_networkDiagnosticRecords;
        builder.ingestion_buildPacket_locationRecords = this.ingestion_buildPacket_locationRecords;
        builder.ingestion_transmitData_submittedNetworkPacketSent = this.ingestion_transmitData_submittedNetworkPacketSent;
        builder.ingestion_transmitData_submittedLocationPacketSent = this.ingestion_transmitData_submittedLocationPacketSent;
        builder.ingestion_transmitData_submittedMnsiRecordsAccepted = this.ingestion_transmitData_submittedMnsiRecordsAccepted;
        builder.ingestion_transmitData_submittedWifiRecordsAccepted = this.ingestion_transmitData_submittedWifiRecordsAccepted;
        builder.ingestion_transmitData_submittedNoSignalRecordsAccepted = this.ingestion_transmitData_submittedNoSignalRecordsAccepted;
        builder.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted = this.ingestion_transmitData_submittedNetworkDiagnosticRecordsAccepted;
        builder.ingestion_transmitData_submittedLocationRecordsAccepted = this.ingestion_transmitData_submittedLocationRecordsAccepted;
        builder.ndt_checkFullTest = this.ndt_checkFullTest;
        builder.ndt_checkLatencyTest = this.ndt_checkLatencyTest;
        builder.ndt_checkDownloadTest = this.ndt_checkDownloadTest;
        builder.ndt_checkUploadTest = this.ndt_checkUploadTest;
        builder.ndt_startTestFull = this.ndt_startTestFull;
        builder.ndt_startTestLatency = this.ndt_startTestLatency;
        builder.ndt_startTestDownload = this.ndt_startTestDownload;
        builder.ndt_startTestUpload = this.ndt_startTestUpload;
        builder.ndt_testCompletedFull = this.ndt_testCompletedFull;
        builder.ndt_testCompletedLatency = this.ndt_testCompletedLatency;
        builder.ndt_testCompletedDownload = this.ndt_testCompletedDownload;
        builder.ndt_testCompletedUpload = this.ndt_testCompletedUpload;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
