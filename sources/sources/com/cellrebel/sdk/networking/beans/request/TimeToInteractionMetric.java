package com.cellrebel.sdk.networking.beans.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeToInteractionMetric extends BaseMetric {
    @SerializedName("accessTechEnd")
    @Expose
    public String accessTechEnd;
    @SerializedName("accessTechNumChanges")
    @Expose
    public int accessTechNumChanges;
    @SerializedName("accessTechStart")
    @Expose
    public String accessTechStart;
    @SerializedName("bytesDownloaded")
    @Expose
    public Integer bytesDownloaded;
    @SerializedName("bytesUploaded")
    @Expose
    public Integer bytesUploaded;
    @SerializedName("downloadTime")
    @Expose
    public Integer downloadTime;
    @SerializedName("downloadTimeToFirstByte")
    @Expose
    public Integer downloadTimeToFirstByte;
    @SerializedName("errorTypes")
    @Expose
    public String errorTypes;
    @SerializedName("latency")
    @Expose
    public Integer latency;
    @SerializedName("serverBuild")
    @Expose
    public String serverBuild;
    @SerializedName("serverId")
    @Expose
    public Integer serverId;
    @SerializedName("serverPort")
    @Expose
    public Integer serverPort;
    @SerializedName("serverVersion")
    @Expose
    public String serverVersion;
    @SerializedName("uploadTime")
    @Expose
    public Integer uploadTime;
    @SerializedName("uploadTimeToFirstByte")
    @Expose
    public Integer uploadTimeToFirstByte;

    public TimeToInteractionMetric accessTechEnd(String str) {
        this.accessTechEnd = str;
        return this;
    }

    public String accessTechEnd() {
        return this.accessTechEnd;
    }

    public int accessTechNumChanges() {
        return this.accessTechNumChanges;
    }

    public TimeToInteractionMetric accessTechNumChanges(int i) {
        this.accessTechNumChanges = i;
        return this;
    }

    public TimeToInteractionMetric accessTechStart(String str) {
        this.accessTechStart = str;
        return this;
    }

    public String accessTechStart() {
        return this.accessTechStart;
    }

    public TimeToInteractionMetric bytesDownloaded(Integer num) {
        this.bytesDownloaded = num;
        return this;
    }

    public Integer bytesDownloaded() {
        return this.bytesDownloaded;
    }

    public TimeToInteractionMetric bytesUploaded(Integer num) {
        this.bytesUploaded = num;
        return this;
    }

    public Integer bytesUploaded() {
        return this.bytesUploaded;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof TimeToInteractionMetric;
    }

    public TimeToInteractionMetric downloadTime(Integer num) {
        this.downloadTime = num;
        return this;
    }

    public Integer downloadTime() {
        return this.downloadTime;
    }

    public TimeToInteractionMetric downloadTimeToFirstByte(Integer num) {
        this.downloadTimeToFirstByte = num;
        return this;
    }

    public Integer downloadTimeToFirstByte() {
        return this.downloadTimeToFirstByte;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeToInteractionMetric)) {
            return false;
        }
        TimeToInteractionMetric timeToInteractionMetric = (TimeToInteractionMetric) obj;
        if (!timeToInteractionMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Integer serverId2 = serverId();
        Integer serverId3 = timeToInteractionMetric.serverId();
        if (serverId2 != null ? !serverId2.equals(serverId3) : serverId3 != null) {
            return false;
        }
        Integer serverPort2 = serverPort();
        Integer serverPort3 = timeToInteractionMetric.serverPort();
        if (serverPort2 != null ? !serverPort2.equals(serverPort3) : serverPort3 != null) {
            return false;
        }
        String serverVersion2 = serverVersion();
        String serverVersion3 = timeToInteractionMetric.serverVersion();
        if (serverVersion2 != null ? !serverVersion2.equals(serverVersion3) : serverVersion3 != null) {
            return false;
        }
        String serverBuild2 = serverBuild();
        String serverBuild3 = timeToInteractionMetric.serverBuild();
        if (serverBuild2 != null ? !serverBuild2.equals(serverBuild3) : serverBuild3 != null) {
            return false;
        }
        Integer latency2 = latency();
        Integer latency3 = timeToInteractionMetric.latency();
        if (latency2 != null ? !latency2.equals(latency3) : latency3 != null) {
            return false;
        }
        Integer downloadTime2 = downloadTime();
        Integer downloadTime3 = timeToInteractionMetric.downloadTime();
        if (downloadTime2 != null ? !downloadTime2.equals(downloadTime3) : downloadTime3 != null) {
            return false;
        }
        Integer downloadTimeToFirstByte2 = downloadTimeToFirstByte();
        Integer downloadTimeToFirstByte3 = timeToInteractionMetric.downloadTimeToFirstByte();
        if (downloadTimeToFirstByte2 != null ? !downloadTimeToFirstByte2.equals(downloadTimeToFirstByte3) : downloadTimeToFirstByte3 != null) {
            return false;
        }
        Integer bytesDownloaded2 = bytesDownloaded();
        Integer bytesDownloaded3 = timeToInteractionMetric.bytesDownloaded();
        if (bytesDownloaded2 != null ? !bytesDownloaded2.equals(bytesDownloaded3) : bytesDownloaded3 != null) {
            return false;
        }
        Integer uploadTime2 = uploadTime();
        Integer uploadTime3 = timeToInteractionMetric.uploadTime();
        if (uploadTime2 != null ? !uploadTime2.equals(uploadTime3) : uploadTime3 != null) {
            return false;
        }
        Integer uploadTimeToFirstByte2 = uploadTimeToFirstByte();
        Integer uploadTimeToFirstByte3 = timeToInteractionMetric.uploadTimeToFirstByte();
        if (uploadTimeToFirstByte2 != null ? !uploadTimeToFirstByte2.equals(uploadTimeToFirstByte3) : uploadTimeToFirstByte3 != null) {
            return false;
        }
        Integer bytesUploaded2 = bytesUploaded();
        Integer bytesUploaded3 = timeToInteractionMetric.bytesUploaded();
        if (bytesUploaded2 != null ? !bytesUploaded2.equals(bytesUploaded3) : bytesUploaded3 != null) {
            return false;
        }
        String errorTypes2 = errorTypes();
        String errorTypes3 = timeToInteractionMetric.errorTypes();
        if (errorTypes2 != null ? !errorTypes2.equals(errorTypes3) : errorTypes3 != null) {
            return false;
        }
        String accessTechStart2 = accessTechStart();
        String accessTechStart3 = timeToInteractionMetric.accessTechStart();
        if (accessTechStart2 != null ? !accessTechStart2.equals(accessTechStart3) : accessTechStart3 != null) {
            return false;
        }
        String accessTechEnd2 = accessTechEnd();
        String accessTechEnd3 = timeToInteractionMetric.accessTechEnd();
        if (accessTechEnd2 != null ? accessTechEnd2.equals(accessTechEnd3) : accessTechEnd3 == null) {
            return accessTechNumChanges() == timeToInteractionMetric.accessTechNumChanges();
        }
        return false;
    }

    public TimeToInteractionMetric errorTypes(String str) {
        this.errorTypes = str;
        return this;
    }

    public String errorTypes() {
        return this.errorTypes;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Integer serverId2 = serverId();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (serverId2 == null ? 43 : serverId2.hashCode());
        Integer serverPort2 = serverPort();
        int hashCode3 = (hashCode2 * 59) + (serverPort2 == null ? 43 : serverPort2.hashCode());
        String serverVersion2 = serverVersion();
        int hashCode4 = (hashCode3 * 59) + (serverVersion2 == null ? 43 : serverVersion2.hashCode());
        String serverBuild2 = serverBuild();
        int hashCode5 = (hashCode4 * 59) + (serverBuild2 == null ? 43 : serverBuild2.hashCode());
        Integer latency2 = latency();
        int hashCode6 = (hashCode5 * 59) + (latency2 == null ? 43 : latency2.hashCode());
        Integer downloadTime2 = downloadTime();
        int hashCode7 = (hashCode6 * 59) + (downloadTime2 == null ? 43 : downloadTime2.hashCode());
        Integer downloadTimeToFirstByte2 = downloadTimeToFirstByte();
        int hashCode8 = (hashCode7 * 59) + (downloadTimeToFirstByte2 == null ? 43 : downloadTimeToFirstByte2.hashCode());
        Integer bytesDownloaded2 = bytesDownloaded();
        int hashCode9 = (hashCode8 * 59) + (bytesDownloaded2 == null ? 43 : bytesDownloaded2.hashCode());
        Integer uploadTime2 = uploadTime();
        int hashCode10 = (hashCode9 * 59) + (uploadTime2 == null ? 43 : uploadTime2.hashCode());
        Integer uploadTimeToFirstByte2 = uploadTimeToFirstByte();
        int hashCode11 = (hashCode10 * 59) + (uploadTimeToFirstByte2 == null ? 43 : uploadTimeToFirstByte2.hashCode());
        Integer bytesUploaded2 = bytesUploaded();
        int hashCode12 = (hashCode11 * 59) + (bytesUploaded2 == null ? 43 : bytesUploaded2.hashCode());
        String errorTypes2 = errorTypes();
        int hashCode13 = (hashCode12 * 59) + (errorTypes2 == null ? 43 : errorTypes2.hashCode());
        String accessTechStart2 = accessTechStart();
        int hashCode14 = (hashCode13 * 59) + (accessTechStart2 == null ? 43 : accessTechStart2.hashCode());
        String accessTechEnd2 = accessTechEnd();
        int i2 = hashCode14 * 59;
        if (accessTechEnd2 != null) {
            i = accessTechEnd2.hashCode();
        }
        return ((i2 + i) * 59) + accessTechNumChanges();
    }

    public TimeToInteractionMetric latency(Integer num) {
        this.latency = num;
        return this;
    }

    public Integer latency() {
        return this.latency;
    }

    public TimeToInteractionMetric serverBuild(String str) {
        this.serverBuild = str;
        return this;
    }

    public String serverBuild() {
        return this.serverBuild;
    }

    public TimeToInteractionMetric serverId(Integer num) {
        this.serverId = num;
        return this;
    }

    public Integer serverId() {
        return this.serverId;
    }

    public TimeToInteractionMetric serverPort(Integer num) {
        this.serverPort = num;
        return this;
    }

    public Integer serverPort() {
        return this.serverPort;
    }

    public TimeToInteractionMetric serverVersion(String str) {
        this.serverVersion = str;
        return this;
    }

    public String serverVersion() {
        return this.serverVersion;
    }

    public String toString() {
        return "TimeToInteractionMetric(super=" + super.toString() + ", serverId=" + serverId() + ", serverPort=" + serverPort() + ", serverVersion=" + serverVersion() + ", serverBuild=" + serverBuild() + ", latency=" + latency() + ", downloadTime=" + downloadTime() + ", downloadTimeToFirstByte=" + downloadTimeToFirstByte() + ", bytesDownloaded=" + bytesDownloaded() + ", uploadTime=" + uploadTime() + ", uploadTimeToFirstByte=" + uploadTimeToFirstByte() + ", bytesUploaded=" + bytesUploaded() + ", errorTypes=" + errorTypes() + ", accessTechStart=" + accessTechStart() + ", accessTechEnd=" + accessTechEnd() + ", accessTechNumChanges=" + accessTechNumChanges() + ")";
    }

    public TimeToInteractionMetric uploadTime(Integer num) {
        this.uploadTime = num;
        return this;
    }

    public Integer uploadTime() {
        return this.uploadTime;
    }

    public TimeToInteractionMetric uploadTimeToFirstByte(Integer num) {
        this.uploadTimeToFirstByte = num;
        return this;
    }

    public Integer uploadTimeToFirstByte() {
        return this.uploadTimeToFirstByte;
    }
}
