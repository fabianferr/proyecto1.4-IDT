package com.cellrebel.sdk.networking.beans.response;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Settings implements Serializable {
    @SerializedName("accessTechnologyCdnFileUrls")
    @Expose
    public String accessTechnologyCdnFileUrls;
    @SerializedName("accessTechnologyFileNames")
    @Expose
    public String accessTechnologyFileNames;
    @SerializedName("anonymize")
    @Expose
    public Boolean anonymize;
    @SerializedName("audioManagerEnabled")
    @Expose
    public Boolean audioManagerEnabled;
    @SerializedName("backgroundCoverageMeasurement")
    @Expose
    public Boolean backgroundCoverageMeasurement;
    @SerializedName("backgroundSamplingInterval")
    @Expose
    public Integer backgroundCoverageSamplingInterval;
    @SerializedName("backgroundCellInfoTimeout")
    @Expose
    public Integer backgroundCoverageTimeout;
    @SerializedName("backgroundGameMeasurement")
    @Expose
    public Boolean backgroundGameMeasurement;
    @SerializedName("backgroundGamePeriodicity")
    @Expose
    public Integer backgroundGamePeriodicity;
    @SerializedName("backgroundGameReportingPeriodicity")
    @Expose
    public Integer backgroundGameReportingPeriodicity;
    @SerializedName("backgroundLocationEnabled")
    @Expose
    public Boolean backgroundLocationEnabled;
    @SerializedName("cdnBackgroundMeasurement")
    @Expose
    public Boolean cdnBackgroundMeasurement;
    @SerializedName("cdnFileDownloadForegroundPeriodicity")
    @Expose
    public Integer cdnFileDownloadForegroundPeriodicity;
    @SerializedName("cdnFileDownloadPeriodicity")
    @Expose
    public Integer cdnFileDownloadPeriodicity;
    @SerializedName("cdnFileDownloadTimeout")
    @Expose
    public Integer cdnFileDownloadTimeout;
    @SerializedName("cdnFileMeasurements")
    @Expose
    public Boolean cdnFileMeasurements;
    @SerializedName("cdnFileUrl")
    @Expose
    public String cdnFileUrls;
    @SerializedName("cellInfoUpdateEnabled")
    @Expose
    public Boolean cellInfoUpdateEnabled;
    @SerializedName("connectionMeasurementFrequency")
    @Expose
    public Integer connectionMeasurementFrequency;
    @SerializedName("connectionMeasurementPeriodicity")
    @Expose
    public Integer connectionMeasurementPeriodicity;
    @SerializedName("connectionMeasurements")
    @Expose
    public Boolean connectionMeasurements;
    public Integer connectionTestPageLoadScore;
    public Integer connectionTestPageLoadTimeout;
    public String connectionTestPageLoadUrl;
    @SerializedName("connectionTestSettings")
    @Expose
    private ConnectionTestSettings connectionTestSettings;
    public Integer connectionTestVideoScore;
    public Integer connectionTestVideoTimeout;
    public String connectionTestVideoUrl;
    @SerializedName("coverageForegroundPeriodicity")
    @Expose
    public Integer coverageForegroundPeriodicity;
    @SerializedName("coverageMeasurements")
    @Expose
    public Boolean coverageMeasurement;
    @SerializedName("coveragePeriodicity")
    @Expose
    public Integer coveragePeriodicity;
    @SerializedName("dataUsage")
    @Expose
    public Boolean dataUsage;
    @SerializedName("dataUsageBackgroundMeasurement")
    @Expose
    public Boolean dataUsageBackgroundMeasurement;
    @SerializedName("dataUsageForegroundPeriodicity")
    @Expose
    public Integer dataUsageForegroundPeriodicity;
    @SerializedName("dataUsagePeriodicity")
    @Expose
    public Integer dataUsagePeriodicity;
    @SerializedName("deviceInfoActiveMeasurements")
    @Expose
    public Boolean deviceInfoActiveMeasurements;
    @SerializedName("deviceInfoBackgroundMeasurements")
    @Expose
    public Boolean deviceInfoBackgroundMeasurements;
    @SerializedName("deviceInfoBackgroundPeriodicity")
    @Expose
    public Integer deviceInfoBackgroundPeriodicity;
    @SerializedName("deviceInfoForegroundPeriodicity")
    @Expose
    public Integer deviceInfoForegroundPeriodicity;
    @SerializedName("fileMeasurement")
    @Expose
    public Boolean fileMeasurement;
    @SerializedName("fileName")
    @Expose
    public String fileName;
    @SerializedName("fileServerList")
    @Expose
    public String fileServerUrls;
    @SerializedName("fileTransferBackgroundMeasurement")
    @Expose
    public Boolean fileTransferBackgroundMeasurement;
    @SerializedName("fileTransferForegroundPeriodicityTimer")
    @Expose
    public Integer fileTransferForegroundPeriodicityTimer;
    @SerializedName("fileTransferPeriodicityTimer")
    @Expose
    public Integer fileTransferPeriodicityTimer;
    @SerializedName("fileTransferTimeoutTimer")
    @Expose
    public Integer fileTransferTimeoutTimer;
    @SerializedName("foregroundSamplingInterval")
    @Expose
    public Integer foregroundCoverageSamplingInterval;
    @SerializedName("foregroundCellInfoTimeout")
    @Expose
    public Integer foregroundCoverageTimeout;
    @SerializedName("foregroundGameMeasurement")
    @Expose
    public Boolean foregroundGameMeasurement;
    @SerializedName("foregroundGamePeriodicity")
    @Expose
    public Integer foregroundGamePeriodicity;
    @SerializedName("foregroundLoadedLatencyPeriodicity")
    @Expose
    public Integer foregroundLoadedLatencyPeriodicity;
    @SerializedName("foregroundLoadedLatencyPeriodicityWifi")
    @Expose
    public Integer foregroundLoadedLatencyPeriodicityWifi;
    @SerializedName("foregroundMeasurementPeriodicity")
    @Expose
    public Integer foregroundMeasurementPeriodicity;
    @SerializedName("foregroundPeriodicity")
    @Expose
    public Integer foregroundPeriodicity;
    @SerializedName("gameCacheRefresh")
    @Expose
    public Integer gameCacheRefresh;
    @SerializedName("gamePingsPerServer")
    @Expose
    public Integer gamePingsPerServer;
    @SerializedName("gameServersCache")
    @Expose
    public Integer gameServersCache;
    @SerializedName("gameServersCacheEnabled")
    @Expose
    public Boolean gameServersCacheEnabled;
    @SerializedName("gameTimeoutTimer")
    @Expose
    public Integer gameTimeoutTimer;
    public long id;
    @SerializedName("independentBackgroundCoverageMeasurement")
    @Expose
    public Boolean independentBackgroundCoverageMeasurement;
    @SerializedName("foregroundListenerEnabled")
    @Expose
    public Boolean isForegroundListenerEnabled;
    @SerializedName("measurementsAutoStartEnabled")
    @Expose
    public Boolean isMeasurementsAutoStartEnabled;
    @SerializedName("isPageLoadMeasurement")
    @Expose
    public Boolean isPageLoadMeasurement;
    @SerializedName("serverFallbackEnabled")
    @Expose
    public Boolean isServerFallbackEnabled;
    @SerializedName("loadedLatencyCacheRefresh")
    @Expose
    public Integer loadedLatencyCacheRefresh;
    @SerializedName("loadedLatencyEnabled")
    @Expose
    public Boolean loadedLatencyEnabled;
    @SerializedName("loadedLatencyMeasurementsPerServer")
    @Expose
    public Integer loadedLatencyMeasurementsPerServer;
    @SerializedName("loadedLatencyServersCache")
    @Expose
    public Integer loadedLatencyServersCache;
    @SerializedName("loadedLatencyServersCacheEnabled")
    @Expose
    public Boolean loadedLatencyServersCacheEnabled;
    @SerializedName("loadedLatencyTimeoutTimer")
    @Expose
    public Integer loadedLatencyTimeoutTimer;
    @SerializedName("measurementsAutoStartDelay")
    @Expose
    public Integer measurementsAutoStartDelay;
    @SerializedName("mobileClientId")
    @Expose
    public String mobileClientId;
    @SerializedName("noLocationMeasurementEnabled")
    @Expose
    public Boolean noLocationMeasurementEnabled;
    @SerializedName("onScreenMeasurement")
    @Expose
    public Integer onScreenMeasurement;
    @SerializedName("pageLoadBackgroundMeasurement")
    @Expose
    public Boolean pageLoadBackgroundMeasurement;
    @SerializedName("pageLoadForegroundPeriodicityMeasurement")
    @Expose
    public Integer pageLoadForegroundPeriodicityMeasurement;
    @SerializedName("pageLoadPeriodicityMeasurement")
    @Expose
    public Integer pageLoadPeriodicityMeasurement;
    @SerializedName("pageLoadTimeoutTimer")
    @Expose
    public Integer pageLoadTimeoutTimer;
    @SerializedName("pageLoadUrl")
    @Expose
    public String pageLoadUrl;
    @SerializedName("randomCdnBackgroundMeasurement")
    @Expose
    public Boolean randomCdnBackgroundMeasurement;
    @SerializedName("randomCdnFileDownloadForegroundPeriodicity")
    @Expose
    public Integer randomCdnFileDownloadForegroundPeriodicity;
    @SerializedName("randomCdnFileDownloadPeriodicity")
    @Expose
    public Integer randomCdnFileDownloadPeriodicity;
    @SerializedName("randomCdnFileDownloadTimeout")
    @Expose
    public Integer randomCdnFileDownloadTimeout;
    @SerializedName("randomCdnFileMeasurements")
    @Expose
    public Boolean randomCdnFileMeasurements;
    @SerializedName("randomCdnFileUrl")
    @Expose
    public String randomCdnFileUrls;
    @SerializedName("randomCdnServerCount")
    @Expose
    public Integer randomCdnServerCount;
    @SerializedName("reportingPeriodicity")
    @Expose
    public Integer reportingPeriodicity;
    @SerializedName("reportingUrl")
    @Expose
    public String reportingUrl;
    @SerializedName("sdkOrigin")
    @Expose
    public String sdkOrigin;
    @SerializedName("secondaryReportingUrls")
    @Expose
    public String secondaryReportingUrls;
    @SerializedName("serverFallbackCount")
    @Expose
    public Integer serverFallbackCount;
    @SerializedName("serverIdFileLoad")
    @Expose
    public String serverIdFileLoad;
    @SerializedName("settingsUrl")
    @Expose
    public String settingsUrl;
    @SerializedName("timeInBetweenMeasurements")
    @Expose
    public Integer timeInBetweenMeasurements;
    @SerializedName("timeToInteractionBackgroundMeasurementsEnabled")
    @Expose
    public Boolean timeToInteractionBackgroundMeasurementsEnabled;
    @SerializedName("timeToInteractionBackgroundPeriodicity")
    @Expose
    public Integer timeToInteractionBackgroundPeriodicity;
    @SerializedName("timeToInteractionDownloadFileSize")
    @Expose
    public Integer timeToInteractionDownloadFileSize;
    @SerializedName("timeToInteractionForegroundPeriodicity")
    @Expose
    public Integer timeToInteractionForegroundPeriodicity;
    @SerializedName("timeToInteractionMeasurementsEnabled")
    @Expose
    public Boolean timeToInteractionMeasurementsEnabled;
    @SerializedName("timeToInteractionPingTimeout")
    @Expose
    public Integer timeToInteractionPingTimeout;
    @SerializedName("timeToInteractionPingsPerServer")
    @Expose
    public Integer timeToInteractionPingsPerServer;
    @SerializedName("timeToInteractionServerListLimit")
    @Expose
    public Integer timeToInteractionServerListLimit;
    @SerializedName("timeToInteractionServerSelectionTimeout")
    @Expose
    public Integer timeToInteractionServerSelectionTimeout;
    @SerializedName("timeToInteractionTimeout")
    @Expose
    public Integer timeToInteractionTimeout;
    @SerializedName("timeToInteractionUploadFileSize")
    @Expose
    public Integer timeToInteractionUploadFileSize;
    @SerializedName("timeToInteractionUploadStatsInterval")
    @Expose
    public Integer timeToInteractionUploadStatsInterval;
    @SerializedName("timeToInteractionUploadStatsTimeout")
    @Expose
    public Integer timeToInteractionUploadStatsTimeout;
    @SerializedName("timeToInteractionWiFiPeriodicity")
    @Expose
    public Integer timeToInteractionWiFiPeriodicity;
    @SerializedName("tracerouteActiveMeasurements")
    @Expose
    public Boolean tracerouteActiveMeasurements;
    @SerializedName("tracerouteBackgroundMeasurements")
    @Expose
    public Boolean tracerouteBackgroundMeasurements;
    @SerializedName("tracerouteBackgroundPeriodicity")
    @Expose
    public Integer tracerouteBackgroundPeriodicity;
    @SerializedName("tracerouteForegroundPeriodicity")
    @Expose
    public Integer tracerouteForegroundPeriodicity;
    @SerializedName("tracerouteNumberOfHops")
    @Expose
    public Integer tracerouteNumberOfHops;
    @SerializedName("traceroutePacketSize")
    @Expose
    public Integer traceroutePacketSize;
    @SerializedName("tracerouteUrl")
    @Expose
    public String tracerouteUrl;
    @SerializedName("trafficProfileBackgroundMeasurementsEnabled")
    @Expose
    public Boolean trafficProfileBackgroundMeasurementsEnabled;
    @SerializedName("trafficProfileBackgroundPeriodicity")
    @Expose
    public Integer trafficProfileBackgroundPeriodicity;
    @SerializedName("trafficProfileForegroundPeriodicity")
    @Expose
    public Integer trafficProfileForegroundPeriodicity;
    @SerializedName("trafficProfileMeasurementLimit")
    @Expose
    public Integer trafficProfileMeasurementLimit;
    @SerializedName("trafficProfileMeasurementsEnabled")
    @Expose
    public Boolean trafficProfileMeasurementsEnabled;
    @SerializedName("trafficProfileServerUrls")
    @Expose
    public String trafficProfileServerUrls;
    @SerializedName("trafficProfileTimeout")
    @Expose
    public Integer trafficProfileTimeout;
    @SerializedName("trafficProfileWiFiPeriodicity")
    @Expose
    public Integer trafficProfileWiFiPeriodicity;
    @SerializedName("trafficProfiles")
    @Expose
    public List<TrafficProfiles> trafficProfiles;
    public String trafficProfilesJson;
    @SerializedName("videoActiveMeasurement")
    @Expose
    public Boolean videoActiveMeasurement;
    @SerializedName("videoBackgroundMeasurement")
    @Expose
    public Boolean videoBackgroundMeasurement;
    @SerializedName("videoBackgroundPeriodicityMeasurement")
    @Expose
    public Integer videoBackgroundPeriodicityMeasurement;
    @SerializedName("videoBufferingThreshold")
    @Expose
    public Integer videoBufferingThreshold;
    @SerializedName("videoForegroundPeriodicityMeasurement")
    @Expose
    public Integer videoForegroundPeriodicityMeasurement;
    @SerializedName("videoProvider")
    @Expose
    public String videoProvider;
    @SerializedName("videoTimeoutFactor")
    @Expose
    public Integer videoTimeoutFactor;
    @SerializedName("videoTimeoutTimer")
    @Expose
    public Integer videoTimeoutTimer;
    @SerializedName("videoUrl")
    @Expose
    public String videoUrl;
    @SerializedName("voiceCallMeasurements")
    @Expose
    public Boolean voiceCallMeasurements;
    @SerializedName("voiceCallsMeasurement")
    @Expose
    public Boolean voiceCallsMeasurement;
    @SerializedName("wifiCdnFileDownloadForegroundPeriodicity")
    @Expose
    public Integer wifiCdnFileDownloadForegroundPeriodicity;
    @SerializedName("wifiCoverageForegroundPeriodicity")
    @Expose
    public Integer wifiCoverageForegroundPeriodicity;
    @SerializedName("wifiDataUsageForegroundPeriodicity")
    @Expose
    public Integer wifiDataUsageForegroundPeriodicity;
    @SerializedName("wifiFileTransferForegroundPeriodicity")
    @Expose
    public Integer wifiFileTransferForegroundPeriodicity;
    @SerializedName("wifiForegroundTimer")
    @Expose
    public Integer wifiForegroundTimer;
    @SerializedName("wifiGameForegroundPeriodicity")
    @Expose
    public Integer wifiGameForegroundPeriodicity;
    @SerializedName("wifiLoadedLatencyEnabled")
    @Expose
    public Boolean wifiLoadedLatencyEnabled;
    @SerializedName("wifiMeasurementsEnabled")
    @Expose
    public Boolean wifiMeasurementsEnabled;
    @SerializedName("wifiPageLoadForegroundPeriodicity")
    @Expose
    public Integer wifiPageLoadForegroundPeriodicity;
    @SerializedName("wifiRandomCdnFileDownloadForegroundPeriodicity")
    @Expose
    public Integer wifiRandomCdnFileDownloadForegroundPeriodicity;
    @SerializedName("wifiTracerouteForegroundPeriodicity")
    @Expose
    public Integer wifiTracerouteForegroundPeriodicity;
    @SerializedName("wifiVideoForegroundPeriodicity")
    @Expose
    public Integer wifiVideoForegroundPeriodicity;

    public Boolean anonymize() {
        Boolean bool = this.anonymize;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean audioManagerEnabled() {
        Boolean bool = this.audioManagerEnabled;
        return Boolean.valueOf(bool == null ? true : bool.booleanValue());
    }

    public Settings backgroundCoverageMeasurement(Boolean bool) {
        this.backgroundCoverageMeasurement = bool;
        return this;
    }

    public Boolean backgroundCoverageMeasurement() {
        Boolean bool = this.backgroundCoverageMeasurement;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings backgroundCoverageSamplingInterval(Integer num) {
        this.backgroundCoverageSamplingInterval = num;
        return this;
    }

    public Integer backgroundCoverageSamplingInterval() {
        return this.backgroundCoverageSamplingInterval;
    }

    public Settings backgroundCoverageTimeout(Integer num) {
        this.backgroundCoverageTimeout = num;
        return this;
    }

    public Integer backgroundCoverageTimeout() {
        return this.backgroundCoverageTimeout;
    }

    public Settings backgroundGameMeasurement(Boolean bool) {
        this.backgroundGameMeasurement = bool;
        return this;
    }

    public Boolean backgroundGameMeasurement() {
        Boolean bool = this.backgroundGameMeasurement;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings backgroundGamePeriodicity(Integer num) {
        this.backgroundGamePeriodicity = num;
        return this;
    }

    public Integer backgroundGamePeriodicity() {
        Integer num = this.backgroundGamePeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings backgroundGameReportingPeriodicity(Integer num) {
        this.backgroundGameReportingPeriodicity = num;
        return this;
    }

    public Integer backgroundGameReportingPeriodicity() {
        Integer num = this.backgroundGameReportingPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean backgroundLocationEnabled() {
        Boolean bool = this.backgroundLocationEnabled;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings cdnBackgroundMeasurement(Boolean bool) {
        this.cdnBackgroundMeasurement = bool;
        return this;
    }

    public Boolean cdnBackgroundMeasurement() {
        return this.cdnBackgroundMeasurement;
    }

    public Integer cdnFileDownloadForegroundPeriodicity() {
        Integer num = this.cdnFileDownloadForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings cdnFileDownloadPeriodicity(Integer num) {
        this.cdnFileDownloadPeriodicity = num;
        return this;
    }

    public Integer cdnFileDownloadPeriodicity() {
        Integer num = this.cdnFileDownloadPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings cdnFileDownloadTimeout(Integer num) {
        this.cdnFileDownloadTimeout = num;
        return this;
    }

    public Integer cdnFileDownloadTimeout() {
        Integer num = this.cdnFileDownloadTimeout;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings cdnFileMeasurements(Boolean bool) {
        this.cdnFileMeasurements = bool;
        return this;
    }

    public Boolean cdnFileMeasurements() {
        return this.cdnFileMeasurements;
    }

    public Settings cdnFileUrls(String str) {
        this.cdnFileUrls = str;
        return this;
    }

    public String cdnFileUrls() {
        return this.cdnFileUrls;
    }

    public Boolean cellInfoUpdateEnabled() {
        Boolean bool = this.cellInfoUpdateEnabled;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings connectionMeasurementFrequency(Integer num) {
        this.connectionMeasurementFrequency = num;
        return this;
    }

    public Integer connectionMeasurementFrequency() {
        Integer num = this.connectionMeasurementFrequency;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings connectionMeasurementPeriodicity(Integer num) {
        this.connectionMeasurementPeriodicity = num;
        return this;
    }

    public Integer connectionMeasurementPeriodicity() {
        Integer num = this.connectionMeasurementPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings connectionMeasurements(Boolean bool) {
        this.connectionMeasurements = bool;
        return this;
    }

    public Boolean connectionMeasurements() {
        return this.connectionMeasurements;
    }

    public Settings connectionTestPageLoadScore(Integer num) {
        this.connectionTestPageLoadScore = num;
        return this;
    }

    public Integer connectionTestPageLoadScore() {
        return this.connectionTestPageLoadScore;
    }

    public Settings connectionTestPageLoadTimeout(Integer num) {
        this.connectionTestPageLoadTimeout = num;
        return this;
    }

    public Integer connectionTestPageLoadTimeout() {
        return this.connectionTestPageLoadTimeout;
    }

    public Settings connectionTestPageLoadUrl(String str) {
        this.connectionTestPageLoadUrl = str;
        return this;
    }

    public String connectionTestPageLoadUrl() {
        return this.connectionTestPageLoadUrl;
    }

    public ConnectionTestSettings connectionTestSettings() {
        ConnectionTestSettings connectionTestSettings2 = this.connectionTestSettings;
        if (connectionTestSettings2 != null) {
            return connectionTestSettings2;
        }
        ConnectionTestSettings connectionTestSettings3 = new ConnectionTestSettings();
        this.connectionTestSettings = connectionTestSettings3;
        connectionTestSettings3.videoUrl = this.connectionTestVideoUrl;
        connectionTestSettings3.videoTimeout = this.connectionTestVideoTimeout;
        connectionTestSettings3.videoScore = this.connectionTestVideoScore;
        connectionTestSettings3.pageLoadUrl = this.connectionTestPageLoadUrl;
        connectionTestSettings3.pageLoadTimeout = this.connectionTestPageLoadTimeout;
        connectionTestSettings3.pageLoadScore = this.connectionTestPageLoadScore;
        return connectionTestSettings3;
    }

    public Settings connectionTestSettings(ConnectionTestSettings connectionTestSettings2) {
        this.connectionTestSettings = connectionTestSettings2;
        return this;
    }

    public Settings connectionTestVideoScore(Integer num) {
        this.connectionTestVideoScore = num;
        return this;
    }

    public Integer connectionTestVideoScore() {
        return this.connectionTestVideoScore;
    }

    public Settings connectionTestVideoTimeout(Integer num) {
        this.connectionTestVideoTimeout = num;
        return this;
    }

    public Integer connectionTestVideoTimeout() {
        return this.connectionTestVideoTimeout;
    }

    public Settings connectionTestVideoUrl(String str) {
        this.connectionTestVideoUrl = str;
        return this;
    }

    public String connectionTestVideoUrl() {
        return this.connectionTestVideoUrl;
    }

    public Integer coverageForegroundPeriodicity() {
        Integer num = this.coverageForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings coverageMeasurement(Boolean bool) {
        this.coverageMeasurement = bool;
        return this;
    }

    public Boolean coverageMeasurement() {
        Boolean bool = this.coverageMeasurement;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings coveragePeriodicity(Integer num) {
        this.coveragePeriodicity = num;
        return this;
    }

    public Integer coveragePeriodicity() {
        Integer num = this.coveragePeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings dataUsage(Boolean bool) {
        this.dataUsage = bool;
        return this;
    }

    public Boolean dataUsage() {
        return this.dataUsage;
    }

    public Settings dataUsageBackgroundMeasurement(Boolean bool) {
        this.dataUsageBackgroundMeasurement = bool;
        return this;
    }

    public Boolean dataUsageBackgroundMeasurement() {
        return this.dataUsageBackgroundMeasurement;
    }

    public Integer dataUsageForegroundPeriodicity() {
        Integer num = this.dataUsageForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings dataUsagePeriodicity(Integer num) {
        this.dataUsagePeriodicity = num;
        return this;
    }

    public Integer dataUsagePeriodicity() {
        Integer num = this.dataUsagePeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean deviceInfoActiveMeasurements() {
        Boolean bool = this.deviceInfoActiveMeasurements;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean deviceInfoBackgroundMeasurements() {
        Boolean bool = this.deviceInfoBackgroundMeasurements;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Integer deviceInfoBackgroundPeriodicity() {
        Integer num = this.deviceInfoBackgroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer deviceInfoForegroundPeriodicity() {
        Integer num = this.deviceInfoForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings fileMeasurement(Boolean bool) {
        this.fileMeasurement = bool;
        return this;
    }

    public Boolean fileMeasurement() {
        return this.fileMeasurement;
    }

    public Settings fileName(String str) {
        this.fileName = str;
        return this;
    }

    public String fileName() {
        return this.fileName;
    }

    public Settings fileServerUrls(String str) {
        this.fileServerUrls = str;
        return this;
    }

    public String fileServerUrls() {
        return this.fileServerUrls;
    }

    public Settings fileTransferBackgroundMeasurement(Boolean bool) {
        this.fileTransferBackgroundMeasurement = bool;
        return this;
    }

    public Boolean fileTransferBackgroundMeasurement() {
        return this.fileTransferBackgroundMeasurement;
    }

    public Integer fileTransferForegroundPeriodicityTimer() {
        Integer num = this.fileTransferForegroundPeriodicityTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings fileTransferPeriodicityTimer(Integer num) {
        this.fileTransferPeriodicityTimer = num;
        return this;
    }

    public Integer fileTransferPeriodicityTimer() {
        Integer num = this.fileTransferPeriodicityTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings fileTransferTimeoutTimer(Integer num) {
        this.fileTransferTimeoutTimer = num;
        return this;
    }

    public Integer fileTransferTimeoutTimer() {
        Integer num = this.fileTransferTimeoutTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings foregroundCoverageSamplingInterval(Integer num) {
        this.foregroundCoverageSamplingInterval = num;
        return this;
    }

    public Integer foregroundCoverageSamplingInterval() {
        return this.foregroundCoverageSamplingInterval;
    }

    public Settings foregroundCoverageTimeout(Integer num) {
        this.foregroundCoverageTimeout = num;
        return this;
    }

    public Integer foregroundCoverageTimeout() {
        return this.foregroundCoverageTimeout;
    }

    public Settings foregroundGameMeasurement(Boolean bool) {
        this.foregroundGameMeasurement = bool;
        return this;
    }

    public Boolean foregroundGameMeasurement() {
        Boolean bool = this.foregroundGameMeasurement;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Integer foregroundGamePeriodicity() {
        Integer num = this.foregroundGamePeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer foregroundLoadedLatencyPeriodicity() {
        Integer num = this.foregroundLoadedLatencyPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer foregroundLoadedLatencyPeriodicityWifi() {
        Integer num = this.foregroundLoadedLatencyPeriodicityWifi;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer foregroundMeasurementPeriodicity() {
        Integer num = this.foregroundMeasurementPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings foregroundPeriodicity(Integer num) {
        this.foregroundPeriodicity = num;
        return this;
    }

    public Integer foregroundPeriodicity() {
        Integer num = this.foregroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings gameCacheRefresh(Integer num) {
        this.gameCacheRefresh = num;
        return this;
    }

    public Integer gameCacheRefresh() {
        Integer num = this.gameCacheRefresh;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings gamePingsPerServer(Integer num) {
        this.gamePingsPerServer = num;
        return this;
    }

    public Integer gamePingsPerServer() {
        return this.gamePingsPerServer;
    }

    public Settings gameServersCache(Integer num) {
        this.gameServersCache = num;
        return this;
    }

    public Integer gameServersCache() {
        Integer num = this.gameServersCache;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean gameServersCacheEnabled() {
        Boolean bool = this.gameServersCacheEnabled;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public Settings gameTimeoutTimer(Integer num) {
        this.gameTimeoutTimer = num;
        return this;
    }

    public Integer gameTimeoutTimer() {
        return this.gameTimeoutTimer;
    }

    public List<TrafficProfile> getTrafficProfiles() {
        return (List) new Gson().fromJson(this.trafficProfilesJson, new TypeToken<List<TrafficProfile>>() {
        }.getType());
    }

    public long id() {
        return this.id;
    }

    public Settings id(long j) {
        this.id = j;
        return this;
    }

    public Boolean independentBackgroundCoverageMeasurement() {
        Boolean bool = this.independentBackgroundCoverageMeasurement;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean isForegroundListenerEnabled() {
        Boolean bool = this.isForegroundListenerEnabled;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean isMeasurementsAutoStartEnabled() {
        Boolean bool = this.isMeasurementsAutoStartEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Settings isPageLoadMeasurement(Boolean bool) {
        this.isPageLoadMeasurement = bool;
        return this;
    }

    public Boolean isPageLoadMeasurement() {
        return this.isPageLoadMeasurement;
    }

    public Boolean isServerFallbackEnabled() {
        Boolean bool = this.isServerFallbackEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Integer loadedLatencyCacheRefresh() {
        Integer num = this.loadedLatencyCacheRefresh;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean loadedLatencyEnabled() {
        Boolean bool = this.loadedLatencyEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Integer loadedLatencyMeasurementsPerServer() {
        Integer num = this.loadedLatencyMeasurementsPerServer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer loadedLatencyServersCache() {
        Integer num = this.loadedLatencyServersCache;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean loadedLatencyServersCacheEnabled() {
        Boolean bool = this.loadedLatencyServersCacheEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Integer loadedLatencyTimeoutTimer() {
        Integer num = this.loadedLatencyTimeoutTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer measurementsAutoStartDelay() {
        Integer num = this.measurementsAutoStartDelay;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings mobileClientId(String str) {
        this.mobileClientId = str;
        return this;
    }

    public String mobileClientId() {
        return this.mobileClientId;
    }

    public Boolean noLocationMeasurementEnabled() {
        Boolean bool = this.noLocationMeasurementEnabled;
        return Boolean.valueOf(bool == null ? true : bool.booleanValue());
    }

    public Settings onScreenMeasurement(Integer num) {
        this.onScreenMeasurement = num;
        return this;
    }

    public Integer onScreenMeasurement() {
        Integer num = this.onScreenMeasurement;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings pageLoadBackgroundMeasurement(Boolean bool) {
        this.pageLoadBackgroundMeasurement = bool;
        return this;
    }

    public Boolean pageLoadBackgroundMeasurement() {
        return this.pageLoadBackgroundMeasurement;
    }

    public Integer pageLoadForegroundPeriodicityMeasurement() {
        Integer num = this.pageLoadForegroundPeriodicityMeasurement;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings pageLoadPeriodicityMeasurement(Integer num) {
        this.pageLoadPeriodicityMeasurement = num;
        return this;
    }

    public Integer pageLoadPeriodicityMeasurement() {
        Integer num = this.pageLoadPeriodicityMeasurement;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings pageLoadTimeoutTimer(Integer num) {
        this.pageLoadTimeoutTimer = num;
        return this;
    }

    public Integer pageLoadTimeoutTimer() {
        Integer num = this.pageLoadTimeoutTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings pageLoadUrl(String str) {
        this.pageLoadUrl = str;
        return this;
    }

    public String pageLoadUrl() {
        return this.pageLoadUrl;
    }

    public Boolean randomCdnBackgroundMeasurement() {
        Boolean bool = this.randomCdnBackgroundMeasurement;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Integer randomCdnFileDownloadForegroundPeriodicity() {
        Integer num = this.randomCdnFileDownloadForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer randomCdnFileDownloadPeriodicity() {
        Integer num = this.randomCdnFileDownloadPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer randomCdnFileDownloadTimeout() {
        Integer num = this.randomCdnFileDownloadTimeout;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean randomCdnFileMeasurements() {
        Boolean bool = this.randomCdnFileMeasurements;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String randomCdnFileUrls() {
        String str = this.randomCdnFileUrls;
        return str == null ? "" : str;
    }

    public Integer randomCdnServerCount() {
        Integer num = this.randomCdnServerCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings reportingPeriodicity(Integer num) {
        this.reportingPeriodicity = num;
        return this;
    }

    public Integer reportingPeriodicity() {
        Integer num = this.reportingPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer serverFallbackCount() {
        Integer num = this.serverFallbackCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings serverIdFileLoad(String str) {
        this.serverIdFileLoad = str;
        return this;
    }

    public String serverIdFileLoad() {
        return this.serverIdFileLoad;
    }

    public void setTrafficProfiles(List<TrafficProfile> list) {
        this.trafficProfilesJson = new Gson().toJson((Object) list);
    }

    public Settings timeInBetweenMeasurements(Integer num) {
        this.timeInBetweenMeasurements = num;
        return this;
    }

    public Integer timeInBetweenMeasurements() {
        Integer num = this.timeInBetweenMeasurements;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings timeToInteractionBackgroundMeasurementsEnabled(Boolean bool) {
        this.timeToInteractionBackgroundMeasurementsEnabled = bool;
        return this;
    }

    public Boolean timeToInteractionBackgroundMeasurementsEnabled() {
        Boolean bool = this.timeToInteractionBackgroundMeasurementsEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Settings timeToInteractionBackgroundPeriodicity(Integer num) {
        this.timeToInteractionBackgroundPeriodicity = num;
        return this;
    }

    public Integer timeToInteractionBackgroundPeriodicity() {
        Integer num = this.timeToInteractionBackgroundPeriodicity;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionDownloadFileSize(Integer num) {
        this.timeToInteractionDownloadFileSize = num;
        return this;
    }

    public Integer timeToInteractionDownloadFileSize() {
        Integer num = this.timeToInteractionDownloadFileSize;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionForegroundPeriodicity(Integer num) {
        this.timeToInteractionForegroundPeriodicity = num;
        return this;
    }

    public Integer timeToInteractionForegroundPeriodicity() {
        Integer num = this.timeToInteractionForegroundPeriodicity;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionMeasurementsEnabled(Boolean bool) {
        this.timeToInteractionMeasurementsEnabled = bool;
        return this;
    }

    public Boolean timeToInteractionMeasurementsEnabled() {
        Boolean bool = this.timeToInteractionMeasurementsEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Settings timeToInteractionPingTimeout(Integer num) {
        this.timeToInteractionPingTimeout = num;
        return this;
    }

    public Integer timeToInteractionPingTimeout() {
        Integer num = this.timeToInteractionPingTimeout;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionPingsPerServer(Integer num) {
        this.timeToInteractionPingsPerServer = num;
        return this;
    }

    public Integer timeToInteractionPingsPerServer() {
        Integer num = this.timeToInteractionPingsPerServer;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionServerListLimit(Integer num) {
        this.timeToInteractionServerListLimit = num;
        return this;
    }

    public Integer timeToInteractionServerListLimit() {
        Integer num = this.timeToInteractionServerListLimit;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionServerSelectionTimeout(Integer num) {
        this.timeToInteractionServerSelectionTimeout = num;
        return this;
    }

    public Integer timeToInteractionServerSelectionTimeout() {
        Integer num = this.timeToInteractionServerSelectionTimeout;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionTimeout(Integer num) {
        this.timeToInteractionTimeout = num;
        return this;
    }

    public Integer timeToInteractionTimeout() {
        Integer num = this.timeToInteractionTimeout;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionUploadFileSize(Integer num) {
        this.timeToInteractionUploadFileSize = num;
        return this;
    }

    public Integer timeToInteractionUploadFileSize() {
        Integer num = this.timeToInteractionUploadFileSize;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionUploadStatsInterval(Integer num) {
        this.timeToInteractionUploadStatsInterval = num;
        return this;
    }

    public Integer timeToInteractionUploadStatsInterval() {
        Integer num = this.timeToInteractionUploadStatsInterval;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionUploadStatsTimeout(Integer num) {
        this.timeToInteractionUploadStatsTimeout = num;
        return this;
    }

    public Integer timeToInteractionUploadStatsTimeout() {
        Integer num = this.timeToInteractionUploadStatsTimeout;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Settings timeToInteractionWiFiPeriodicity(Integer num) {
        this.timeToInteractionWiFiPeriodicity = num;
        return this;
    }

    public Integer timeToInteractionWiFiPeriodicity() {
        Integer num = this.timeToInteractionWiFiPeriodicity;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public String toString() {
        return "Settings(id=" + id() + ", mobileClientId=" + mobileClientId() + ", connectionMeasurements=" + connectionMeasurements() + ", connectionMeasurementPeriodicity=" + connectionMeasurementPeriodicity() + ", connectionMeasurementFrequency=" + connectionMeasurementFrequency() + "onScreenMeasurement=" + onScreenMeasurement() + ", voiceCallsMeasurement=" + voiceCallsMeasurement() + ", videoBackgroundMeasurement=" + videoBackgroundMeasurement() + ", videoActiveMeasurement=" + videoActiveMeasurement() + ", videoBackgroundPeriodicityMeasurement=" + videoBackgroundPeriodicityMeasurement() + ", videoBufferingThreshold=" + videoBufferingThreshold() + ", videoUrl=" + videoUrl() + ", videoProvider=" + videoProvider() + ", videoTimeoutTimer=" + videoTimeoutTimer() + ", videoTimeoutFactor=" + videoTimeoutFactor() + ", isPageLoadMeasurement=" + isPageLoadMeasurement() + ", pageLoadBackgroundMeasurement=" + pageLoadBackgroundMeasurement() + ", pageLoadUrl=" + pageLoadUrl() + ", pageLoadTimeoutTimer=" + pageLoadTimeoutTimer() + ", pageLoadPeriodicityMeasurement=" + pageLoadPeriodicityMeasurement() + ", fileName=" + fileName() + ", fileMeasurement=" + fileMeasurement() + ", fileTransferBackgroundMeasurement=" + fileTransferBackgroundMeasurement() + ", fileTransferPeriodicityTimer=" + fileTransferPeriodicityTimer() + ", fileTransferTimeoutTimer=" + fileTransferTimeoutTimer() + ", serverIdFileLoad=" + serverIdFileLoad() + ", fileServerUrls=" + fileServerUrls() + ", cdnFileMeasurements=" + cdnFileMeasurements() + ", cdnBackgroundMeasurement=" + cdnBackgroundMeasurement() + ", cdnFileDownloadPeriodicity=" + cdnFileDownloadPeriodicity() + ", cdnFileDownloadTimeout=" + cdnFileDownloadTimeout() + ", cdnFileUrls=" + cdnFileUrls() + ", timeInBetweenMeasurements=" + timeInBetweenMeasurements() + ", dataUsage=" + dataUsage() + ", dataUsageBackgroundMeasurement=" + dataUsageBackgroundMeasurement() + ", dataUsagePeriodicity=" + dataUsagePeriodicity() + ", foregroundPeriodicity=" + foregroundPeriodicity() + ", coverageMeasurement=" + coverageMeasurement() + ", backgroundCoverageMeasurement=" + backgroundCoverageMeasurement() + ", coveragePeriodicity=" + coveragePeriodicity() + ", foregroundCoverageTimeout=" + foregroundCoverageTimeout() + ", backgroundCoverageTimeout=" + backgroundCoverageTimeout() + ", foregroundCoverageSamplingInterval=" + foregroundCoverageSamplingInterval() + ", backgroundCoverageSamplingInterval=" + backgroundCoverageSamplingInterval() + ", reportingPeriodicity=" + reportingPeriodicity() + ", connectionTestSettings=" + connectionTestSettings() + ", gameCacheRefresh=" + gameCacheRefresh() + ", gamePingsPerServer=" + gamePingsPerServer() + ", gameServersCache=" + gameServersCache() + ", gameTimeoutTimer=" + gameTimeoutTimer() + ", backgroundGamePeriodicity=" + backgroundGamePeriodicity() + ", backgroundGameReportingPeriodicity=" + backgroundGameReportingPeriodicity() + ", foregroundGameMeasurement=" + foregroundGameMeasurement() + ", backgroundGameMeasurement=" + backgroundGameMeasurement() + ", connectionTestVideoUrl=" + connectionTestVideoUrl() + ", connectionTestVideoTimeout=" + connectionTestVideoTimeout() + ", connectionTestVideoScore=" + connectionTestVideoScore() + ", connectionTestPageLoadUrl=" + connectionTestPageLoadUrl() + ", connectionTestPageLoadTimeout=" + connectionTestPageLoadTimeout() + ", connectionTestPageLoadScore=" + connectionTestPageLoadScore() + ")";
    }

    public Boolean tracerouteActiveMeasurements() {
        Boolean bool = this.tracerouteActiveMeasurements;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean tracerouteBackgroundMeasurements() {
        Boolean bool = this.tracerouteBackgroundMeasurements;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Integer tracerouteBackgroundPeriodicity() {
        Integer num = this.tracerouteBackgroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer tracerouteForegroundPeriodicity() {
        Integer num = this.tracerouteForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer tracerouteNumberOfHops() {
        Integer num = this.tracerouteNumberOfHops;
        return Integer.valueOf(num == null ? 10 : num.intValue());
    }

    public Integer traceroutePacketSize() {
        Integer num = this.traceroutePacketSize;
        return Integer.valueOf(num == null ? 60 : num.intValue());
    }

    public Settings trafficProfile(List<TrafficProfiles> list) {
        this.trafficProfiles = list;
        return this;
    }

    public Settings trafficProfileBackgroundMeasurementsEnabled(Boolean bool) {
        this.trafficProfileBackgroundMeasurementsEnabled = bool;
        return this;
    }

    public Boolean trafficProfileBackgroundMeasurementsEnabled() {
        Boolean bool = this.trafficProfileBackgroundMeasurementsEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Settings trafficProfileBackgroundPeriodicity(Integer num) {
        this.trafficProfileBackgroundPeriodicity = num;
        return this;
    }

    public Integer trafficProfileBackgroundPeriodicity() {
        Integer num = this.trafficProfileBackgroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings trafficProfileForegroundPeriodicity(Integer num) {
        this.trafficProfileForegroundPeriodicity = num;
        return this;
    }

    public Integer trafficProfileForegroundPeriodicity() {
        Integer num = this.trafficProfileForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer trafficProfileMeasurementLimit() {
        Integer num = this.trafficProfileMeasurementLimit;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings trafficProfileMeasurementsEnabled(Boolean bool) {
        this.trafficProfileMeasurementsEnabled = bool;
        return this;
    }

    public Boolean trafficProfileMeasurementsEnabled() {
        Boolean bool = this.trafficProfileMeasurementsEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String trafficProfileServerUrls() {
        String str = this.trafficProfileServerUrls;
        return str == null ? "" : str;
    }

    public Settings trafficProfileTimeout(Integer num) {
        this.trafficProfileTimeout = num;
        return this;
    }

    public Integer trafficProfileTimeout() {
        Integer num = this.trafficProfileTimeout;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings trafficProfileWiFiPeriodicity(Integer num) {
        this.trafficProfileWiFiPeriodicity = num;
        return this;
    }

    public Integer trafficProfileWiFiPeriodicity() {
        Integer num = this.trafficProfileWiFiPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings trafficProfiles(List<TrafficProfile> list) {
        return this;
    }

    public List<TrafficProfiles> trafficProfiles() {
        List<TrafficProfiles> list = this.trafficProfiles;
        return list == null ? new ArrayList() : list;
    }

    public Settings videoActiveMeasurement(Boolean bool) {
        this.videoActiveMeasurement = bool;
        return this;
    }

    public Boolean videoActiveMeasurement() {
        return this.videoActiveMeasurement;
    }

    public Settings videoBackgroundMeasurement(Boolean bool) {
        this.videoBackgroundMeasurement = bool;
        return this;
    }

    public Boolean videoBackgroundMeasurement() {
        return this.videoBackgroundMeasurement;
    }

    public Settings videoBackgroundPeriodicityMeasurement(Integer num) {
        this.videoBackgroundPeriodicityMeasurement = num;
        return this;
    }

    public Integer videoBackgroundPeriodicityMeasurement() {
        Integer num = this.videoBackgroundPeriodicityMeasurement;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings videoBufferingThreshold(Integer num) {
        this.videoBufferingThreshold = num;
        return this;
    }

    public Integer videoBufferingThreshold() {
        return this.videoBufferingThreshold;
    }

    public Integer videoForegroundPeriodicityMeasurement() {
        Integer num = this.videoForegroundPeriodicityMeasurement;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings videoProvider(String str) {
        this.videoProvider = str;
        return this;
    }

    public String videoProvider() {
        return this.videoProvider;
    }

    public Settings videoTimeoutFactor(Integer num) {
        this.videoTimeoutFactor = num;
        return this;
    }

    public Integer videoTimeoutFactor() {
        Integer num = this.videoTimeoutFactor;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings videoTimeoutTimer(Integer num) {
        this.videoTimeoutTimer = num;
        return this;
    }

    public Integer videoTimeoutTimer() {
        Integer num = this.videoTimeoutTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Settings videoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public String videoUrl() {
        return this.videoUrl;
    }

    public Boolean voiceCallMeasurements() {
        Boolean bool = this.voiceCallMeasurements;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Settings voiceCallsMeasurement(Boolean bool) {
        this.voiceCallsMeasurement = bool;
        return this;
    }

    public Boolean voiceCallsMeasurement() {
        return this.voiceCallsMeasurement;
    }

    public Integer wifiCdnFileDownloadForegroundPeriodicity() {
        Integer num = this.wifiCdnFileDownloadForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiCoverageForegroundPeriodicity() {
        Integer num = this.wifiCoverageForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiDataUsageForegroundPeriodicity() {
        Integer num = this.wifiDataUsageForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiFileTransferForegroundPeriodicity() {
        Integer num = this.wifiFileTransferForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiForegroundTimer() {
        Integer num = this.wifiForegroundTimer;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiGameForegroundPeriodicity() {
        Integer num = this.wifiGameForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean wifiLoadedLatencyEnabled() {
        Boolean bool = this.wifiLoadedLatencyEnabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean wifiMeasurementsEnabled() {
        Boolean bool = this.wifiMeasurementsEnabled;
        return Boolean.valueOf(bool == null ? true : bool.booleanValue());
    }

    public Integer wifiPageLoadForegroundPeriodicity() {
        Integer num = this.wifiPageLoadForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiRandomCdnFileDownloadForegroundPeriodicity() {
        Integer num = this.wifiRandomCdnFileDownloadForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiTracerouteForegroundPeriodicity() {
        Integer num = this.wifiTracerouteForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer wifiVideoForegroundPeriodicity() {
        Integer num = this.wifiVideoForegroundPeriodicity;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }
}
