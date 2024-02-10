package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageLoadMetric extends BaseMetric {
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
    @SerializedName("firstByteTime")
    @Expose
    public long firstByteTime;
    @SerializedName("isPageFailsToLoad")
    @Expose
    public boolean isPageFailsToLoad;
    @SerializedName("pageLoadTime")
    @Expose
    public int pageLoadTime;
    @SerializedName("pageSize")
    @Expose
    public int pageSize;
    @SerializedName("pageUrl")
    @Expose
    public String pageUrl;

    public PageLoadMetric accessTechEnd(String str) {
        this.accessTechEnd = str;
        return this;
    }

    public String accessTechEnd() {
        return this.accessTechEnd;
    }

    public int accessTechNumChanges() {
        return this.accessTechNumChanges;
    }

    public PageLoadMetric accessTechNumChanges(int i) {
        this.accessTechNumChanges = i;
        return this;
    }

    public PageLoadMetric accessTechStart(String str) {
        this.accessTechStart = str;
        return this;
    }

    public String accessTechStart() {
        return this.accessTechStart;
    }

    public long bytesReceived() {
        return this.bytesReceived;
    }

    public PageLoadMetric bytesReceived(long j) {
        this.bytesReceived = j;
        return this;
    }

    public long bytesSent() {
        return this.bytesSent;
    }

    public PageLoadMetric bytesSent(long j) {
        this.bytesSent = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof PageLoadMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PageLoadMetric)) {
            return false;
        }
        PageLoadMetric pageLoadMetric = (PageLoadMetric) obj;
        if (!pageLoadMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String pageUrl2 = pageUrl();
        String pageUrl3 = pageLoadMetric.pageUrl();
        if (pageUrl2 != null ? !pageUrl2.equals(pageUrl3) : pageUrl3 != null) {
            return false;
        }
        if (pageSize() != pageLoadMetric.pageSize() || pageLoadTime() != pageLoadMetric.pageLoadTime() || firstByteTime() != pageLoadMetric.firstByteTime() || isPageFailsToLoad() != pageLoadMetric.isPageFailsToLoad()) {
            return false;
        }
        String accessTechStart2 = accessTechStart();
        String accessTechStart3 = pageLoadMetric.accessTechStart();
        if (accessTechStart2 != null ? !accessTechStart2.equals(accessTechStart3) : accessTechStart3 != null) {
            return false;
        }
        String accessTechEnd2 = accessTechEnd();
        String accessTechEnd3 = pageLoadMetric.accessTechEnd();
        if (accessTechEnd2 != null ? accessTechEnd2.equals(accessTechEnd3) : accessTechEnd3 == null) {
            return accessTechNumChanges() == pageLoadMetric.accessTechNumChanges() && bytesSent() == pageLoadMetric.bytesSent() && bytesReceived() == pageLoadMetric.bytesReceived();
        }
        return false;
    }

    public long firstByteTime() {
        return this.firstByteTime;
    }

    public PageLoadMetric firstByteTime(long j) {
        this.firstByteTime = j;
        return this;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String pageUrl2 = pageUrl();
        int i = hashCode * 59;
        int i2 = 43;
        int hashCode2 = pageUrl2 == null ? 43 : pageUrl2.hashCode();
        long firstByteTime2 = firstByteTime();
        int pageSize2 = ((((((((i + hashCode2) * 59) + pageSize()) * 59) + pageLoadTime()) * 59) + ((int) (firstByteTime2 ^ (firstByteTime2 >>> 32)))) * 59) + (isPageFailsToLoad() ? 79 : 97);
        String accessTechStart2 = accessTechStart();
        int hashCode3 = (pageSize2 * 59) + (accessTechStart2 == null ? 43 : accessTechStart2.hashCode());
        String accessTechEnd2 = accessTechEnd();
        int i3 = hashCode3 * 59;
        if (accessTechEnd2 != null) {
            i2 = accessTechEnd2.hashCode();
        }
        int accessTechNumChanges2 = ((i3 + i2) * 59) + accessTechNumChanges();
        long bytesSent2 = bytesSent();
        long bytesReceived2 = bytesReceived();
        return (((accessTechNumChanges2 * 59) + ((int) (bytesSent2 ^ (bytesSent2 >>> 32)))) * 59) + ((int) (bytesReceived2 ^ (bytesReceived2 >>> 32)));
    }

    public PageLoadMetric isPageFailsToLoad(boolean z) {
        this.isPageFailsToLoad = z;
        return this;
    }

    public boolean isPageFailsToLoad() {
        return this.isPageFailsToLoad;
    }

    public int pageLoadTime() {
        return this.pageLoadTime;
    }

    public PageLoadMetric pageLoadTime(int i) {
        this.pageLoadTime = i;
        return this;
    }

    public int pageSize() {
        return this.pageSize;
    }

    public PageLoadMetric pageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public PageLoadMetric pageUrl(String str) {
        this.pageUrl = str;
        return this;
    }

    public String pageUrl() {
        return this.pageUrl;
    }

    public void save() {
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
            DatabaseClient.a().m().a(this);
        }
    }

    public String toString() {
        return "PageLoadMetric(super=" + super.toString() + ", pageUrl=" + pageUrl() + ", pageSize=" + pageSize() + ", pageLoadTime=" + pageLoadTime() + ", firstByteTime=" + firstByteTime() + ", isPageFailsToLoad=" + isPageFailsToLoad() + ", accessTechStart=" + accessTechStart() + ", accessTechEnd=" + accessTechEnd() + ", accessTechNumChanges=" + accessTechNumChanges() + ", bytesSent=" + bytesSent() + ", bytesReceived=" + bytesReceived() + ")";
    }
}
