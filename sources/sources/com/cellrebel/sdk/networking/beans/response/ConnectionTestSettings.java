package com.cellrebel.sdk.networking.beans.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConnectionTestSettings implements Serializable {
    @SerializedName("scoreValuePageLoadAndroid")
    @Expose
    public Integer pageLoadScore;
    @SerializedName("pageLoadTimeout")
    @Expose
    public Integer pageLoadTimeout;
    @SerializedName("pageLoadUrl")
    @Expose
    public String pageLoadUrl;
    @SerializedName("scoreValueVideoAndroid")
    @Expose
    public Integer videoScore;
    @SerializedName("videoTimeout")
    @Expose
    public Integer videoTimeout;
    @SerializedName("videoUrl")
    @Expose
    public String videoUrl;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof ConnectionTestSettings;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionTestSettings)) {
            return false;
        }
        ConnectionTestSettings connectionTestSettings = (ConnectionTestSettings) obj;
        if (!connectionTestSettings.canEqual(this)) {
            return false;
        }
        String videoUrl2 = videoUrl();
        String videoUrl3 = connectionTestSettings.videoUrl();
        if (videoUrl2 != null ? !videoUrl2.equals(videoUrl3) : videoUrl3 != null) {
            return false;
        }
        Integer videoTimeout2 = videoTimeout();
        Integer videoTimeout3 = connectionTestSettings.videoTimeout();
        if (videoTimeout2 != null ? !videoTimeout2.equals(videoTimeout3) : videoTimeout3 != null) {
            return false;
        }
        Integer videoScore2 = videoScore();
        Integer videoScore3 = connectionTestSettings.videoScore();
        if (videoScore2 != null ? !videoScore2.equals(videoScore3) : videoScore3 != null) {
            return false;
        }
        String pageLoadUrl2 = pageLoadUrl();
        String pageLoadUrl3 = connectionTestSettings.pageLoadUrl();
        if (pageLoadUrl2 != null ? !pageLoadUrl2.equals(pageLoadUrl3) : pageLoadUrl3 != null) {
            return false;
        }
        Integer pageLoadTimeout2 = pageLoadTimeout();
        Integer pageLoadTimeout3 = connectionTestSettings.pageLoadTimeout();
        if (pageLoadTimeout2 != null ? !pageLoadTimeout2.equals(pageLoadTimeout3) : pageLoadTimeout3 != null) {
            return false;
        }
        Integer pageLoadScore2 = pageLoadScore();
        Integer pageLoadScore3 = connectionTestSettings.pageLoadScore();
        return pageLoadScore2 != null ? pageLoadScore2.equals(pageLoadScore3) : pageLoadScore3 == null;
    }

    public int hashCode() {
        String videoUrl2 = videoUrl();
        int i = 43;
        int hashCode = videoUrl2 == null ? 43 : videoUrl2.hashCode();
        Integer videoTimeout2 = videoTimeout();
        int hashCode2 = ((hashCode + 59) * 59) + (videoTimeout2 == null ? 43 : videoTimeout2.hashCode());
        Integer videoScore2 = videoScore();
        int hashCode3 = (hashCode2 * 59) + (videoScore2 == null ? 43 : videoScore2.hashCode());
        String pageLoadUrl2 = pageLoadUrl();
        int hashCode4 = (hashCode3 * 59) + (pageLoadUrl2 == null ? 43 : pageLoadUrl2.hashCode());
        Integer pageLoadTimeout2 = pageLoadTimeout();
        int hashCode5 = (hashCode4 * 59) + (pageLoadTimeout2 == null ? 43 : pageLoadTimeout2.hashCode());
        Integer pageLoadScore2 = pageLoadScore();
        int i2 = hashCode5 * 59;
        if (pageLoadScore2 != null) {
            i = pageLoadScore2.hashCode();
        }
        return i2 + i;
    }

    public ConnectionTestSettings pageLoadScore(Integer num) {
        this.pageLoadScore = num;
        return this;
    }

    public Integer pageLoadScore() {
        return this.pageLoadScore;
    }

    public ConnectionTestSettings pageLoadTimeout(Integer num) {
        this.pageLoadTimeout = num;
        return this;
    }

    public Integer pageLoadTimeout() {
        return this.pageLoadTimeout;
    }

    public ConnectionTestSettings pageLoadUrl(String str) {
        this.pageLoadUrl = str;
        return this;
    }

    public String pageLoadUrl() {
        return this.pageLoadUrl;
    }

    public String toString() {
        return "ConnectionTestSettings(videoUrl=" + videoUrl() + ", videoTimeout=" + videoTimeout() + ", videoScore=" + videoScore() + ", pageLoadUrl=" + pageLoadUrl() + ", pageLoadTimeout=" + pageLoadTimeout() + ", pageLoadScore=" + pageLoadScore() + ")";
    }

    public ConnectionTestSettings videoScore(Integer num) {
        this.videoScore = num;
        return this;
    }

    public Integer videoScore() {
        return this.videoScore;
    }

    public ConnectionTestSettings videoTimeout(Integer num) {
        this.videoTimeout = num;
        return this;
    }

    public Integer videoTimeout() {
        return this.videoTimeout;
    }

    public ConnectionTestSettings videoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public String videoUrl() {
        return this.videoUrl;
    }
}
