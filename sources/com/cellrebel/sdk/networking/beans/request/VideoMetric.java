package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoMetric extends BaseMetric {
    @SerializedName("accessTechEnd")
    @Expose
    public String accessTechEnd;
    @SerializedName("accessTechNumChanges")
    @Expose
    public int accessTechNumChanges;
    @SerializedName("accessTechStart")
    @Expose
    public String accessTechStart;
    @SerializedName("bytesReceived")
    @Expose
    public long bytesReceived;
    @SerializedName("bytesSent")
    @Expose
    public long bytesSent;
    @SerializedName("fileUrl")
    @Expose
    public String fileUrl;
    @SerializedName("inStreamFailure")
    @Expose
    public boolean inStreamFailure;
    @SerializedName("isVideoFailsToStart")
    @Expose
    public boolean isVideoFailsToStart;
    @SerializedName("videoInitialBufferingTime")
    @Expose
    public long videoInitialBufferingTime;
    @SerializedName("videoLength")
    @Expose
    public int videoLength;
    @SerializedName("videoQualityTime1080p")
    @Expose
    public long videoQualityTime1080p;
    @SerializedName("videoQualityTime1440p")
    @Expose
    public long videoQualityTime1440p;
    @SerializedName("videoQualityTime144p")
    @Expose
    public long videoQualityTime144p;
    @SerializedName("videoQualityTime2160p")
    @Expose
    public long videoQualityTime2160p;
    @SerializedName("videoQualityTime240p")
    @Expose
    public long videoQualityTime240p;
    @SerializedName("videoQualityTime360p")
    @Expose
    public long videoQualityTime360p;
    @SerializedName("videoQualityTime480p")
    @Expose
    public long videoQualityTime480p;
    @SerializedName("videoQualityTime720p")
    @Expose
    public long videoQualityTime720p;
    @SerializedName("videoQualityTimeDefault")
    @Expose
    public long videoQualityTimeDefault;
    @SerializedName("videoQualityTimeHighRes")
    @Expose
    public long videoQualityTimeHighRes;
    @SerializedName("videoQualityTimeUnknown")
    @Expose
    public long videoQualityTimeUnknown;
    @SerializedName("videoRebufferingCount")
    @Expose
    public int videoRebufferingCount;
    @SerializedName("videoRebufferingTime")
    @Expose
    public long videoRebufferingTime;
    @SerializedName("videoSource")
    @Expose
    public String videoSource;
    @SerializedName("videoTimeToStart")
    @Expose
    public long videoTimeToStart;

    public VideoMetric accessTechEnd(String str) {
        this.accessTechEnd = str;
        return this;
    }

    public String accessTechEnd() {
        return this.accessTechEnd;
    }

    public int accessTechNumChanges() {
        return this.accessTechNumChanges;
    }

    public VideoMetric accessTechNumChanges(int i) {
        this.accessTechNumChanges = i;
        return this;
    }

    public VideoMetric accessTechStart(String str) {
        this.accessTechStart = str;
        return this;
    }

    public String accessTechStart() {
        return this.accessTechStart;
    }

    public long bytesReceived() {
        return this.bytesReceived;
    }

    public VideoMetric bytesReceived(long j) {
        this.bytesReceived = j;
        return this;
    }

    public long bytesSent() {
        return this.bytesSent;
    }

    public VideoMetric bytesSent(long j) {
        this.bytesSent = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof VideoMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoMetric)) {
            return false;
        }
        VideoMetric videoMetric = (VideoMetric) obj;
        if (!videoMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String videoSource2 = videoSource();
        String videoSource3 = videoMetric.videoSource();
        if (videoSource2 != null ? !videoSource2.equals(videoSource3) : videoSource3 != null) {
            return false;
        }
        String fileUrl2 = fileUrl();
        String fileUrl3 = videoMetric.fileUrl();
        if (fileUrl2 != null ? !fileUrl2.equals(fileUrl3) : fileUrl3 != null) {
            return false;
        }
        if (videoInitialBufferingTime() != videoMetric.videoInitialBufferingTime() || videoRebufferingTime() != videoMetric.videoRebufferingTime() || videoRebufferingCount() != videoMetric.videoRebufferingCount() || isVideoFailsToStart() != videoMetric.isVideoFailsToStart() || videoTimeToStart() != videoMetric.videoTimeToStart() || inStreamFailure() != videoMetric.inStreamFailure() || videoLength() != videoMetric.videoLength() || videoQualityTime144p() != videoMetric.videoQualityTime144p() || videoQualityTime240p() != videoMetric.videoQualityTime240p() || videoQualityTime360p() != videoMetric.videoQualityTime360p() || videoQualityTime480p() != videoMetric.videoQualityTime480p() || videoQualityTime720p() != videoMetric.videoQualityTime720p() || videoQualityTime1080p() != videoMetric.videoQualityTime1080p() || videoQualityTime1440p() != videoMetric.videoQualityTime1440p() || videoQualityTime2160p() != videoMetric.videoQualityTime2160p() || videoQualityTimeHighRes() != videoMetric.videoQualityTimeHighRes() || videoQualityTimeDefault() != videoMetric.videoQualityTimeDefault() || videoQualityTimeUnknown() != videoMetric.videoQualityTimeUnknown()) {
            return false;
        }
        String accessTechStart2 = accessTechStart();
        String accessTechStart3 = videoMetric.accessTechStart();
        if (accessTechStart2 != null ? !accessTechStart2.equals(accessTechStart3) : accessTechStart3 != null) {
            return false;
        }
        String accessTechEnd2 = accessTechEnd();
        String accessTechEnd3 = videoMetric.accessTechEnd();
        if (accessTechEnd2 != null ? accessTechEnd2.equals(accessTechEnd3) : accessTechEnd3 == null) {
            return accessTechNumChanges() == videoMetric.accessTechNumChanges() && bytesSent() == videoMetric.bytesSent() && bytesReceived() == videoMetric.bytesReceived();
        }
        return false;
    }

    public VideoMetric fileUrl(String str) {
        this.fileUrl = str;
        return this;
    }

    public String fileUrl() {
        return this.fileUrl;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String videoSource2 = videoSource();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (videoSource2 == null ? 43 : videoSource2.hashCode());
        String fileUrl2 = fileUrl();
        int i2 = hashCode2 * 59;
        int hashCode3 = fileUrl2 == null ? 43 : fileUrl2.hashCode();
        long videoInitialBufferingTime2 = videoInitialBufferingTime();
        long videoRebufferingTime2 = videoRebufferingTime();
        int videoRebufferingCount2 = (((((((i2 + hashCode3) * 59) + ((int) (videoInitialBufferingTime2 ^ (videoInitialBufferingTime2 >>> 32)))) * 59) + ((int) (videoRebufferingTime2 ^ (videoRebufferingTime2 >>> 32)))) * 59) + videoRebufferingCount()) * 59;
        int i3 = 79;
        int i4 = isVideoFailsToStart() ? 79 : 97;
        long videoTimeToStart2 = videoTimeToStart();
        int i5 = (((videoRebufferingCount2 + i4) * 59) + ((int) (videoTimeToStart2 ^ (videoTimeToStart2 >>> 32)))) * 59;
        if (!inStreamFailure()) {
            i3 = 97;
        }
        int videoLength2 = ((i5 + i3) * 59) + videoLength();
        long videoQualityTime144p2 = videoQualityTime144p();
        long videoQualityTime240p2 = videoQualityTime240p();
        long videoQualityTime360p2 = videoQualityTime360p();
        long videoQualityTime480p2 = videoQualityTime480p();
        long videoQualityTime720p2 = videoQualityTime720p();
        long videoQualityTime1080p2 = videoQualityTime1080p();
        long videoQualityTime1440p2 = videoQualityTime1440p();
        long videoQualityTime2160p2 = videoQualityTime2160p();
        long videoQualityTimeHighRes2 = videoQualityTimeHighRes();
        long videoQualityTimeDefault2 = videoQualityTimeDefault();
        long videoQualityTimeUnknown2 = videoQualityTimeUnknown();
        String accessTechStart2 = accessTechStart();
        int hashCode4 = (((((((((((((((((((((((videoLength2 * 59) + ((int) (videoQualityTime144p2 ^ (videoQualityTime144p2 >>> 32)))) * 59) + ((int) (videoQualityTime240p2 ^ (videoQualityTime240p2 >>> 32)))) * 59) + ((int) (videoQualityTime360p2 ^ (videoQualityTime360p2 >>> 32)))) * 59) + ((int) (videoQualityTime480p2 ^ (videoQualityTime480p2 >>> 32)))) * 59) + ((int) (videoQualityTime720p2 ^ (videoQualityTime720p2 >>> 32)))) * 59) + ((int) (videoQualityTime1080p2 ^ (videoQualityTime1080p2 >>> 32)))) * 59) + ((int) (videoQualityTime1440p2 ^ (videoQualityTime1440p2 >>> 32)))) * 59) + ((int) (videoQualityTime2160p2 ^ (videoQualityTime2160p2 >>> 32)))) * 59) + ((int) (videoQualityTimeHighRes2 ^ (videoQualityTimeHighRes2 >>> 32)))) * 59) + ((int) (videoQualityTimeDefault2 ^ (videoQualityTimeDefault2 >>> 32)))) * 59) + ((int) (videoQualityTimeUnknown2 ^ (videoQualityTimeUnknown2 >>> 32)))) * 59) + (accessTechStart2 == null ? 43 : accessTechStart2.hashCode());
        String accessTechEnd2 = accessTechEnd();
        int i6 = hashCode4 * 59;
        if (accessTechEnd2 != null) {
            i = accessTechEnd2.hashCode();
        }
        int accessTechNumChanges2 = ((i6 + i) * 59) + accessTechNumChanges();
        long bytesSent2 = bytesSent();
        long bytesReceived2 = bytesReceived();
        return (((accessTechNumChanges2 * 59) + ((int) (bytesSent2 ^ (bytesSent2 >>> 32)))) * 59) + ((int) (bytesReceived2 ^ (bytesReceived2 >>> 32)));
    }

    public VideoMetric inStreamFailure(boolean z) {
        this.inStreamFailure = z;
        return this;
    }

    public boolean inStreamFailure() {
        return this.inStreamFailure;
    }

    public VideoMetric isVideoFailsToStart(boolean z) {
        this.isVideoFailsToStart = z;
        return this;
    }

    public boolean isVideoFailsToStart() {
        return this.isVideoFailsToStart;
    }

    public void save() {
        try {
            if (this.accessTechnology == null) {
                accessTechnology(ConnectionType.UNKNOWN.toString());
            }
            if (this.accessTechStart == null) {
                accessTechStart(ConnectionType.UNKNOWN.toString());
            }
            if (this.accessTechEnd == null) {
                accessTechEnd(ConnectionType.UNKNOWN.toString());
            }
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().u().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public String toString() {
        return "VideoMetric(super=" + super.toString() + ", videoSource=" + videoSource() + ", fileUrl=" + fileUrl() + ", videoInitialBufferingTime=" + videoInitialBufferingTime() + ", videoRebufferingTime=" + videoRebufferingTime() + ", videoRebufferingCount=" + videoRebufferingCount() + ", isVideoFailsToStart=" + isVideoFailsToStart() + ", videoTimeToStart=" + videoTimeToStart() + ", inStreamFailure=" + inStreamFailure() + ", videoLength=" + videoLength() + ", videoQualityTime144p=" + videoQualityTime144p() + ", videoQualityTime240p=" + videoQualityTime240p() + ", videoQualityTime360p=" + videoQualityTime360p() + ", videoQualityTime480p=" + videoQualityTime480p() + ", videoQualityTime720p=" + videoQualityTime720p() + ", videoQualityTime1080p=" + videoQualityTime1080p() + ", videoQualityTime1440p=" + videoQualityTime1440p() + ", videoQualityTime2160p=" + videoQualityTime2160p() + ", videoQualityTimeHighRes=" + videoQualityTimeHighRes() + ", videoQualityTimeDefault=" + videoQualityTimeDefault() + ", videoQualityTimeUnknown=" + videoQualityTimeUnknown() + ", accessTechStart=" + accessTechStart() + ", accessTechEnd=" + accessTechEnd() + ", accessTechNumChanges=" + accessTechNumChanges() + ", bytesSent=" + bytesSent() + ", bytesReceived=" + bytesReceived() + ")";
    }

    public long videoInitialBufferingTime() {
        return this.videoInitialBufferingTime;
    }

    public VideoMetric videoInitialBufferingTime(long j) {
        this.videoInitialBufferingTime = j;
        return this;
    }

    public int videoLength() {
        return this.videoLength;
    }

    public VideoMetric videoLength(int i) {
        this.videoLength = i;
        return this;
    }

    public long videoQualityTime1080p() {
        return this.videoQualityTime1080p;
    }

    public VideoMetric videoQualityTime1080p(long j) {
        this.videoQualityTime1080p = j;
        return this;
    }

    public long videoQualityTime1440p() {
        return this.videoQualityTime1440p;
    }

    public VideoMetric videoQualityTime1440p(long j) {
        this.videoQualityTime1440p = j;
        return this;
    }

    public long videoQualityTime144p() {
        return this.videoQualityTime144p;
    }

    public VideoMetric videoQualityTime144p(long j) {
        this.videoQualityTime144p = j;
        return this;
    }

    public long videoQualityTime2160p() {
        return this.videoQualityTime2160p;
    }

    public VideoMetric videoQualityTime2160p(long j) {
        this.videoQualityTime2160p = j;
        return this;
    }

    public long videoQualityTime240p() {
        return this.videoQualityTime240p;
    }

    public VideoMetric videoQualityTime240p(long j) {
        this.videoQualityTime240p = j;
        return this;
    }

    public long videoQualityTime360p() {
        return this.videoQualityTime360p;
    }

    public VideoMetric videoQualityTime360p(long j) {
        this.videoQualityTime360p = j;
        return this;
    }

    public long videoQualityTime480p() {
        return this.videoQualityTime480p;
    }

    public VideoMetric videoQualityTime480p(long j) {
        this.videoQualityTime480p = j;
        return this;
    }

    public long videoQualityTime720p() {
        return this.videoQualityTime720p;
    }

    public VideoMetric videoQualityTime720p(long j) {
        this.videoQualityTime720p = j;
        return this;
    }

    public long videoQualityTimeDefault() {
        return this.videoQualityTimeDefault;
    }

    public VideoMetric videoQualityTimeDefault(long j) {
        this.videoQualityTimeDefault = j;
        return this;
    }

    public long videoQualityTimeHighRes() {
        return this.videoQualityTimeHighRes;
    }

    public VideoMetric videoQualityTimeHighRes(long j) {
        this.videoQualityTimeHighRes = j;
        return this;
    }

    public long videoQualityTimeUnknown() {
        return this.videoQualityTimeUnknown;
    }

    public VideoMetric videoQualityTimeUnknown(long j) {
        this.videoQualityTimeUnknown = j;
        return this;
    }

    public int videoRebufferingCount() {
        return this.videoRebufferingCount;
    }

    public VideoMetric videoRebufferingCount(int i) {
        this.videoRebufferingCount = i;
        return this;
    }

    public long videoRebufferingTime() {
        return this.videoRebufferingTime;
    }

    public VideoMetric videoRebufferingTime(long j) {
        this.videoRebufferingTime = j;
        return this;
    }

    public VideoMetric videoSource(String str) {
        this.videoSource = str;
        return this;
    }

    public String videoSource() {
        return this.videoSource;
    }

    public long videoTimeToStart() {
        return this.videoTimeToStart;
    }

    public VideoMetric videoTimeToStart(long j) {
        this.videoTimeToStart = j;
        return this;
    }
}
