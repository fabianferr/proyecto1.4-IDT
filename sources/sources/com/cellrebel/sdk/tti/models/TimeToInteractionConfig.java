package com.cellrebel.sdk.tti.models;

public class TimeToInteractionConfig {
    public final String appName;
    public final String appVersion;
    public final String deviceId;
    public final String deviceModel;
    public final int downloadFileSize;
    public final int pingTimeout;
    public final int pingsPerServer;
    public final String serverListUrl;
    public final int serverSelectionTimeout;
    public final int timeout;
    public final int uploadFileSize;
    public final int uploadStatsInterval;
    public final int uploadStatsTimeout;

    public static class Builder {
        private String appName;
        private String appVersion;
        private String deviceId;
        private String deviceModel;
        private int downloadFileSize;
        private int pingTimeout;
        private int pingsPerServer;
        private String serverListUrl;
        private int serverSelectionTimeout;
        private int timeout;
        private int uploadFileSize;
        private int uploadStatsInterval;
        private int uploadStatsTimeout;

        public TimeToInteractionConfig build() {
            return new TimeToInteractionConfig(this.serverListUrl, this.appName, this.appVersion, this.deviceModel, this.deviceId, this.downloadFileSize, this.uploadFileSize, this.uploadStatsTimeout, this.uploadStatsInterval, this.pingsPerServer, this.pingTimeout, this.serverSelectionTimeout, this.timeout);
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setDeviceModel(String str) {
            this.deviceModel = str;
            return this;
        }

        public Builder setDownloadFileSize(int i) {
            this.downloadFileSize = i;
            return this;
        }

        public Builder setPingTimeout(int i) {
            this.pingTimeout = i;
            return this;
        }

        public Builder setPingsPerServer(int i) {
            this.pingsPerServer = i;
            return this;
        }

        public Builder setServerListUrl(String str) {
            this.serverListUrl = str;
            return this;
        }

        public Builder setServerSelectionTimeout(int i) {
            this.serverSelectionTimeout = i;
            return this;
        }

        public Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public Builder setUploadFileSize(int i) {
            this.uploadFileSize = i;
            return this;
        }

        public Builder setUploadStatsInterval(int i) {
            this.uploadStatsInterval = i;
            return this;
        }

        public Builder setUploadStatsTimeout(int i) {
            this.uploadStatsTimeout = i;
            return this;
        }
    }

    public TimeToInteractionConfig(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.serverListUrl = str;
        this.appName = str2;
        this.appVersion = str3;
        this.deviceModel = str4;
        this.deviceId = str5;
        this.downloadFileSize = i;
        this.uploadFileSize = i2;
        this.uploadStatsTimeout = i3;
        this.uploadStatsInterval = i4;
        this.pingsPerServer = i5;
        this.pingTimeout = i6;
        this.serverSelectionTimeout = i7;
        this.timeout = i8;
    }
}
