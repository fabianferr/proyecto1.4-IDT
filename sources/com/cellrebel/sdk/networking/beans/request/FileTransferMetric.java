package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileTransferMetric extends BaseMetric {
    @SerializedName("bytesReceived")
    @Expose
    public long bytesReceived;
    @SerializedName("bytesSent")
    @Expose
    public long bytesSent;
    @SerializedName("dnsLookupTime")
    @Expose
    public long dnsLookupTime;
    @SerializedName("downLoadFileTime")
    @Expose
    public long downLoadFileTime;
    @SerializedName("downloadAccessTechEnd")
    @Expose
    public String downloadAccessTechEnd;
    @SerializedName("downloadAccessTechNumChanges")
    @Expose
    public int downloadAccessTechNumChanges;
    @SerializedName("downloadAccessTechStart")
    @Expose
    public String downloadAccessTechStart;
    @SerializedName("downloadFirstByteTime")
    @Expose
    public long downloadFirstByteTime;
    @SerializedName("fileSize")
    @Expose
    public long fileSize;
    @SerializedName("fileTransferId")
    @Expose
    public Integer fileTransferId;
    @SerializedName("isFileDownLoaded")
    @Expose
    public boolean isFileDownLoaded;
    @SerializedName("isFileUpLoaded")
    @Expose
    public boolean isFileUpLoaded;
    @SerializedName("isFromLatencyTest")
    @Expose
    public boolean isFromLatencyTest;
    @SerializedName("latency")
    @Expose
    public int latency;
    @SerializedName("serverIdFileLoad")
    @Expose
    public String serverIdFileLoad;
    @SerializedName("tcpConnectTime")
    @Expose
    public long tcpConnectTime;
    @SerializedName("tlsSetupTime")
    @Expose
    public long tlsSetupTime;
    @SerializedName("upLoadFileTime")
    @Expose
    public long upLoadFileTime;
    @SerializedName("uploadAccessTechEnd")
    @Expose
    public String uploadAccessTechEnd;
    @SerializedName("uploadAccessTechNumChanges")
    @Expose
    public int uploadAccessTechNumChanges;
    @SerializedName("uploadAccessTechStart")
    @Expose
    public String uploadAccessTechStart;
    @SerializedName("uploadFirstByteTime")
    @Expose
    public long uploadFirstByteTime;

    public long bytesReceived() {
        return this.bytesReceived;
    }

    public FileTransferMetric bytesReceived(long j) {
        this.bytesReceived = j;
        return this;
    }

    public long bytesSent() {
        return this.bytesSent;
    }

    public FileTransferMetric bytesSent(long j) {
        this.bytesSent = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof FileTransferMetric;
    }

    public long dnsLookupTime() {
        return this.dnsLookupTime;
    }

    public FileTransferMetric dnsLookupTime(long j) {
        this.dnsLookupTime = j;
        return this;
    }

    public long downLoadFileTime() {
        return this.downLoadFileTime;
    }

    public FileTransferMetric downLoadFileTime(long j) {
        this.downLoadFileTime = j;
        return this;
    }

    public FileTransferMetric downloadAccessTechEnd(String str) {
        this.downloadAccessTechEnd = str;
        return this;
    }

    public String downloadAccessTechEnd() {
        return this.downloadAccessTechEnd;
    }

    public int downloadAccessTechNumChanges() {
        return this.downloadAccessTechNumChanges;
    }

    public FileTransferMetric downloadAccessTechNumChanges(int i) {
        this.downloadAccessTechNumChanges = i;
        return this;
    }

    public FileTransferMetric downloadAccessTechStart(String str) {
        this.downloadAccessTechStart = str;
        return this;
    }

    public String downloadAccessTechStart() {
        return this.downloadAccessTechStart;
    }

    public long downloadFirstByteTime() {
        return this.downloadFirstByteTime;
    }

    public FileTransferMetric downloadFirstByteTime(long j) {
        this.downloadFirstByteTime = j;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileTransferMetric)) {
            return false;
        }
        FileTransferMetric fileTransferMetric = (FileTransferMetric) obj;
        if (!fileTransferMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String serverIdFileLoad2 = serverIdFileLoad();
        String serverIdFileLoad3 = fileTransferMetric.serverIdFileLoad();
        if (serverIdFileLoad2 != null ? !serverIdFileLoad2.equals(serverIdFileLoad3) : serverIdFileLoad3 != null) {
            return false;
        }
        if (downLoadFileTime() != fileTransferMetric.downLoadFileTime() || upLoadFileTime() != fileTransferMetric.upLoadFileTime() || isFileDownLoaded() != fileTransferMetric.isFileDownLoaded() || isFileUpLoaded() != fileTransferMetric.isFileUpLoaded() || latency() != fileTransferMetric.latency() || downloadFirstByteTime() != fileTransferMetric.downloadFirstByteTime()) {
            return false;
        }
        String downloadAccessTechStart2 = downloadAccessTechStart();
        String downloadAccessTechStart3 = fileTransferMetric.downloadAccessTechStart();
        if (downloadAccessTechStart2 != null ? !downloadAccessTechStart2.equals(downloadAccessTechStart3) : downloadAccessTechStart3 != null) {
            return false;
        }
        String downloadAccessTechEnd2 = downloadAccessTechEnd();
        String downloadAccessTechEnd3 = fileTransferMetric.downloadAccessTechEnd();
        if (downloadAccessTechEnd2 != null ? !downloadAccessTechEnd2.equals(downloadAccessTechEnd3) : downloadAccessTechEnd3 != null) {
            return false;
        }
        if (downloadAccessTechNumChanges() != fileTransferMetric.downloadAccessTechNumChanges() || uploadFirstByteTime() != fileTransferMetric.uploadFirstByteTime()) {
            return false;
        }
        String uploadAccessTechStart2 = uploadAccessTechStart();
        String uploadAccessTechStart3 = fileTransferMetric.uploadAccessTechStart();
        if (uploadAccessTechStart2 != null ? !uploadAccessTechStart2.equals(uploadAccessTechStart3) : uploadAccessTechStart3 != null) {
            return false;
        }
        String uploadAccessTechEnd2 = uploadAccessTechEnd();
        String uploadAccessTechEnd3 = fileTransferMetric.uploadAccessTechEnd();
        if (uploadAccessTechEnd2 != null ? !uploadAccessTechEnd2.equals(uploadAccessTechEnd3) : uploadAccessTechEnd3 != null) {
            return false;
        }
        if (uploadAccessTechNumChanges() != fileTransferMetric.uploadAccessTechNumChanges() || bytesSent() != fileTransferMetric.bytesSent() || bytesReceived() != fileTransferMetric.bytesReceived() || dnsLookupTime() != fileTransferMetric.dnsLookupTime() || tcpConnectTime() != fileTransferMetric.tcpConnectTime() || tlsSetupTime() != fileTransferMetric.tlsSetupTime() || fileSize() != fileTransferMetric.fileSize() || isFromLatencyTest() != fileTransferMetric.isFromLatencyTest()) {
            return false;
        }
        Integer fileTransferId2 = fileTransferId();
        Integer fileTransferId3 = fileTransferMetric.fileTransferId();
        return fileTransferId2 != null ? fileTransferId2.equals(fileTransferId3) : fileTransferId3 == null;
    }

    public long fileSize() {
        return this.fileSize;
    }

    public FileTransferMetric fileSize(long j) {
        this.fileSize = j;
        return this;
    }

    public FileTransferMetric fileTransferId(Integer num) {
        this.fileTransferId = num;
        return this;
    }

    public Integer fileTransferId() {
        return this.fileTransferId;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String serverIdFileLoad2 = serverIdFileLoad();
        int i = hashCode * 59;
        int i2 = 43;
        int hashCode2 = serverIdFileLoad2 == null ? 43 : serverIdFileLoad2.hashCode();
        long downLoadFileTime2 = downLoadFileTime();
        long upLoadFileTime2 = upLoadFileTime();
        int i3 = 79;
        int i4 = (((((((i + hashCode2) * 59) + ((int) (downLoadFileTime2 ^ (downLoadFileTime2 >>> 32)))) * 59) + ((int) (upLoadFileTime2 ^ (upLoadFileTime2 >>> 32)))) * 59) + (isFileDownLoaded() ? 79 : 97)) * 59;
        int i5 = isFileUpLoaded() ? 79 : 97;
        long downloadFirstByteTime2 = downloadFirstByteTime();
        int latency2 = ((((i4 + i5) * 59) + latency()) * 59) + ((int) (downloadFirstByteTime2 ^ (downloadFirstByteTime2 >>> 32)));
        String downloadAccessTechStart2 = downloadAccessTechStart();
        int hashCode3 = (latency2 * 59) + (downloadAccessTechStart2 == null ? 43 : downloadAccessTechStart2.hashCode());
        String downloadAccessTechEnd2 = downloadAccessTechEnd();
        int i6 = hashCode3 * 59;
        int hashCode4 = downloadAccessTechEnd2 == null ? 43 : downloadAccessTechEnd2.hashCode();
        long uploadFirstByteTime2 = uploadFirstByteTime();
        int downloadAccessTechNumChanges2 = ((((i6 + hashCode4) * 59) + downloadAccessTechNumChanges()) * 59) + ((int) (uploadFirstByteTime2 ^ (uploadFirstByteTime2 >>> 32)));
        String uploadAccessTechStart2 = uploadAccessTechStart();
        int hashCode5 = (downloadAccessTechNumChanges2 * 59) + (uploadAccessTechStart2 == null ? 43 : uploadAccessTechStart2.hashCode());
        String uploadAccessTechEnd2 = uploadAccessTechEnd();
        int i7 = hashCode5 * 59;
        int hashCode6 = uploadAccessTechEnd2 == null ? 43 : uploadAccessTechEnd2.hashCode();
        long bytesSent2 = bytesSent();
        long bytesReceived2 = bytesReceived();
        long dnsLookupTime2 = dnsLookupTime();
        long tcpConnectTime2 = tcpConnectTime();
        long tlsSetupTime2 = tlsSetupTime();
        long fileSize2 = fileSize();
        int uploadAccessTechNumChanges2 = (((((((((((((((i7 + hashCode6) * 59) + uploadAccessTechNumChanges()) * 59) + ((int) (bytesSent2 ^ (bytesSent2 >>> 32)))) * 59) + ((int) (bytesReceived2 ^ (bytesReceived2 >>> 32)))) * 59) + ((int) (dnsLookupTime2 ^ (dnsLookupTime2 >>> 32)))) * 59) + ((int) (tcpConnectTime2 ^ (tcpConnectTime2 >>> 32)))) * 59) + ((int) (tlsSetupTime2 ^ (tlsSetupTime2 >>> 32)))) * 59) + ((int) (fileSize2 ^ (fileSize2 >>> 32)))) * 59;
        if (!isFromLatencyTest()) {
            i3 = 97;
        }
        Integer fileTransferId2 = fileTransferId();
        int i8 = (uploadAccessTechNumChanges2 + i3) * 59;
        if (fileTransferId2 != null) {
            i2 = fileTransferId2.hashCode();
        }
        return i8 + i2;
    }

    public FileTransferMetric isFileDownLoaded(boolean z) {
        this.isFileDownLoaded = z;
        return this;
    }

    public boolean isFileDownLoaded() {
        return this.isFileDownLoaded;
    }

    public FileTransferMetric isFileUpLoaded(boolean z) {
        this.isFileUpLoaded = z;
        return this;
    }

    public boolean isFileUpLoaded() {
        return this.isFileUpLoaded;
    }

    public FileTransferMetric isFromLatencyTest(boolean z) {
        this.isFromLatencyTest = z;
        return this;
    }

    public boolean isFromLatencyTest() {
        return this.isFromLatencyTest;
    }

    public int latency() {
        return this.latency;
    }

    public FileTransferMetric latency(int i) {
        this.latency = i;
        return this;
    }

    public void save() {
        try {
            if (this.accessTechnology == null) {
                accessTechnology(ConnectionType.UNKNOWN.toString());
            }
            if (this.uploadAccessTechStart == null) {
                uploadAccessTechStart(ConnectionType.UNKNOWN.toString());
            }
            if (this.uploadAccessTechEnd == null) {
                uploadAccessTechEnd(ConnectionType.UNKNOWN.toString());
            }
            if (this.downloadAccessTechStart == null) {
                downloadAccessTechStart(ConnectionType.UNKNOWN.toString());
            }
            if (this.downloadAccessTechEnd == null) {
                downloadAccessTechEnd(ConnectionType.UNKNOWN.toString());
            }
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().i().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public FileTransferMetric serverIdFileLoad(String str) {
        this.serverIdFileLoad = str;
        return this;
    }

    public String serverIdFileLoad() {
        return this.serverIdFileLoad;
    }

    public long tcpConnectTime() {
        return this.tcpConnectTime;
    }

    public FileTransferMetric tcpConnectTime(long j) {
        this.tcpConnectTime = j;
        return this;
    }

    public long tlsSetupTime() {
        return this.tlsSetupTime;
    }

    public FileTransferMetric tlsSetupTime(long j) {
        this.tlsSetupTime = j;
        return this;
    }

    public String toString() {
        return "FileTransferMetric(super=" + super.toString() + ", serverIdFileLoad=" + serverIdFileLoad() + ", downLoadFileTime=" + downLoadFileTime() + ", upLoadFileTime=" + upLoadFileTime() + ", isFileDownLoaded=" + isFileDownLoaded() + ", isFileUpLoaded=" + isFileUpLoaded() + ", latency=" + latency() + ", downloadFirstByteTime=" + downloadFirstByteTime() + ", downloadAccessTechStart=" + downloadAccessTechStart() + ", downloadAccessTechEnd=" + downloadAccessTechEnd() + ", downloadAccessTechNumChanges=" + downloadAccessTechNumChanges() + ", uploadFirstByteTime=" + uploadFirstByteTime() + ", uploadAccessTechStart=" + uploadAccessTechStart() + ", uploadAccessTechEnd=" + uploadAccessTechEnd() + ", uploadAccessTechNumChanges=" + uploadAccessTechNumChanges() + ", bytesSent=" + bytesSent() + ", bytesReceived=" + bytesReceived() + ", dnsLookupTime=" + dnsLookupTime() + ", tcpConnectTime=" + tcpConnectTime() + ", tlsSetupTime=" + tlsSetupTime() + ", fileSize=" + fileSize() + ", isFromLatencyTest=" + isFromLatencyTest() + ", fileTransferId=" + fileTransferId() + ")";
    }

    public long upLoadFileTime() {
        return this.upLoadFileTime;
    }

    public FileTransferMetric upLoadFileTime(long j) {
        this.upLoadFileTime = j;
        return this;
    }

    public FileTransferMetric uploadAccessTechEnd(String str) {
        this.uploadAccessTechEnd = str;
        return this;
    }

    public String uploadAccessTechEnd() {
        return this.uploadAccessTechEnd;
    }

    public int uploadAccessTechNumChanges() {
        return this.uploadAccessTechNumChanges;
    }

    public FileTransferMetric uploadAccessTechNumChanges(int i) {
        this.uploadAccessTechNumChanges = i;
        return this;
    }

    public FileTransferMetric uploadAccessTechStart(String str) {
        this.uploadAccessTechStart = str;
        return this;
    }

    public String uploadAccessTechStart() {
        return this.uploadAccessTechStart;
    }

    public long uploadFirstByteTime() {
        return this.uploadFirstByteTime;
    }

    public FileTransferMetric uploadFirstByteTime(long j) {
        this.uploadFirstByteTime = j;
        return this;
    }
}
