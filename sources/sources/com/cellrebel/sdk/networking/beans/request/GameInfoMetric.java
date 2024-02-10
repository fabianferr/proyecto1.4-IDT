package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class GameInfoMetric extends BaseMetric implements Cloneable {
    @SerializedName("failedMeasurementsCount")
    @Expose
    public Float failedMeasurementsCount;
    @SerializedName("fileTransferId")
    @Expose
    public Integer fileTransferId;
    @SerializedName("gameName")
    @Expose
    public String gameName;
    @SerializedName("isCached")
    @Expose
    public boolean isCached = false;
    public boolean isOffline = false;
    public boolean isSent = false;
    @SerializedName("isUnderAdditionalLoad")
    @Expose
    public boolean isUnderAdditionalLoad = false;
    @SerializedName("jitter")
    @Expose
    public Float jitter;
    @SerializedName("latency")
    @Expose
    public Float latency;
    public String loadedLatencyTestFileTransferUrl;
    @SerializedName("pingsCount")
    @Expose
    public Float pingsCount;
    @SerializedName("serverName")
    @Expose
    public String serverName;
    @SerializedName("serverUrl")
    @Expose
    public String serverUrl;

    public GameInfoMetric() {
        Float valueOf = Float.valueOf(0.0f);
        this.latency = valueOf;
        this.pingsCount = valueOf;
        this.failedMeasurementsCount = valueOf;
        this.jitter = valueOf;
    }

    public GameInfoMetric(String str, String str2, String str3, Float f, Float f2, Float f3, String str4, Integer num) {
        Float valueOf = Float.valueOf(0.0f);
        this.latency = valueOf;
        this.pingsCount = valueOf;
        this.failedMeasurementsCount = valueOf;
        this.jitter = valueOf;
        this.gameName = str;
        this.serverUrl = str2;
        this.serverName = str3;
        this.latency = f;
        this.pingsCount = f2;
        this.failedMeasurementsCount = f3;
        this.isSending = false;
        this.loadedLatencyTestFileTransferUrl = str4;
        this.fileTransferId = num;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof GameInfoMetric;
    }

    public GameInfoMetric convertToGameInfo(GameInfoMetric gameInfoMetric) {
        gameInfoMetric.serverName = this.serverName;
        gameInfoMetric.gameName = this.gameName;
        gameInfoMetric.serverUrl = this.serverUrl;
        gameInfoMetric.latency = this.latency;
        gameInfoMetric.pingsCount = this.pingsCount;
        gameInfoMetric.failedMeasurementsCount = this.failedMeasurementsCount;
        gameInfoMetric.isSent = this.isSent;
        gameInfoMetric.isUnderAdditionalLoad = this.isUnderAdditionalLoad;
        gameInfoMetric.isOffline = this.isOffline;
        gameInfoMetric.id = this.id;
        gameInfoMetric.loadedLatencyTestFileTransferUrl = this.loadedLatencyTestFileTransferUrl;
        gameInfoMetric.fileTransferId = this.fileTransferId;
        return gameInfoMetric;
    }

    public GameInfoMetric copy() {
        String str = this.gameName;
        GameInfoMetric gameInfoMetric = new GameInfoMetric(str, this.serverUrl, str, this.latency, this.pingsCount, this.failedMeasurementsCount, this.loadedLatencyTestFileTransferUrl, this.fileTransferId);
        gameInfoMetric.jitter = this.jitter;
        gameInfoMetric.serverIp = this.serverIp;
        return gameInfoMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GameInfoMetric)) {
            return false;
        }
        GameInfoMetric gameInfoMetric = (GameInfoMetric) obj;
        if (!gameInfoMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String serverName2 = serverName();
        String serverName3 = gameInfoMetric.serverName();
        if (serverName2 != null ? !serverName2.equals(serverName3) : serverName3 != null) {
            return false;
        }
        String gameName2 = gameName();
        String gameName3 = gameInfoMetric.gameName();
        if (gameName2 != null ? !gameName2.equals(gameName3) : gameName3 != null) {
            return false;
        }
        String serverUrl2 = serverUrl();
        String serverUrl3 = gameInfoMetric.serverUrl();
        if (serverUrl2 != null ? !serverUrl2.equals(serverUrl3) : serverUrl3 != null) {
            return false;
        }
        Float latency2 = latency();
        Float latency3 = gameInfoMetric.latency();
        if (latency2 != null ? !latency2.equals(latency3) : latency3 != null) {
            return false;
        }
        Float pingsCount2 = pingsCount();
        Float pingsCount3 = gameInfoMetric.pingsCount();
        if (pingsCount2 != null ? !pingsCount2.equals(pingsCount3) : pingsCount3 != null) {
            return false;
        }
        Float failedMeasurementsCount2 = failedMeasurementsCount();
        Float failedMeasurementsCount3 = gameInfoMetric.failedMeasurementsCount();
        if (failedMeasurementsCount2 != null ? !failedMeasurementsCount2.equals(failedMeasurementsCount3) : failedMeasurementsCount3 != null) {
            return false;
        }
        Float jitter2 = jitter();
        Float jitter3 = gameInfoMetric.jitter();
        if (jitter2 != null ? !jitter2.equals(jitter3) : jitter3 != null) {
            return false;
        }
        if (isSent() != gameInfoMetric.isSent() || isOffline() != gameInfoMetric.isOffline() || isUnderAdditionalLoad() != gameInfoMetric.isUnderAdditionalLoad() || isCached() != gameInfoMetric.isCached()) {
            return false;
        }
        String loadedLatencyTestFileTransferUrl2 = loadedLatencyTestFileTransferUrl();
        String loadedLatencyTestFileTransferUrl3 = gameInfoMetric.loadedLatencyTestFileTransferUrl();
        if (loadedLatencyTestFileTransferUrl2 != null ? !loadedLatencyTestFileTransferUrl2.equals(loadedLatencyTestFileTransferUrl3) : loadedLatencyTestFileTransferUrl3 != null) {
            return false;
        }
        Integer fileTransferId2 = fileTransferId();
        Integer fileTransferId3 = gameInfoMetric.fileTransferId();
        return fileTransferId2 != null ? fileTransferId2.equals(fileTransferId3) : fileTransferId3 == null;
    }

    public GameInfoMetric failedMeasurementsCount(Float f) {
        this.failedMeasurementsCount = f;
        return this;
    }

    public Float failedMeasurementsCount() {
        return this.failedMeasurementsCount;
    }

    public GameInfoMetric fileTransferId(Integer num) {
        this.fileTransferId = num;
        return this;
    }

    public Integer fileTransferId() {
        return this.fileTransferId;
    }

    public GameInfoMetric gameName(String str) {
        this.gameName = str;
        return this;
    }

    public String gameName() {
        return this.gameName;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String serverName2 = serverName();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (serverName2 == null ? 43 : serverName2.hashCode());
        String gameName2 = gameName();
        int hashCode3 = (hashCode2 * 59) + (gameName2 == null ? 43 : gameName2.hashCode());
        String serverUrl2 = serverUrl();
        int hashCode4 = (hashCode3 * 59) + (serverUrl2 == null ? 43 : serverUrl2.hashCode());
        Float latency2 = latency();
        int hashCode5 = (hashCode4 * 59) + (latency2 == null ? 43 : latency2.hashCode());
        Float pingsCount2 = pingsCount();
        int hashCode6 = (hashCode5 * 59) + (pingsCount2 == null ? 43 : pingsCount2.hashCode());
        Float failedMeasurementsCount2 = failedMeasurementsCount();
        int hashCode7 = (hashCode6 * 59) + (failedMeasurementsCount2 == null ? 43 : failedMeasurementsCount2.hashCode());
        Float jitter2 = jitter();
        int i2 = 79;
        int hashCode8 = ((((((((hashCode7 * 59) + (jitter2 == null ? 43 : jitter2.hashCode())) * 59) + (isSent() ? 79 : 97)) * 59) + (isOffline() ? 79 : 97)) * 59) + (isUnderAdditionalLoad() ? 79 : 97)) * 59;
        if (!isCached()) {
            i2 = 97;
        }
        String loadedLatencyTestFileTransferUrl2 = loadedLatencyTestFileTransferUrl();
        int hashCode9 = ((hashCode8 + i2) * 59) + (loadedLatencyTestFileTransferUrl2 == null ? 43 : loadedLatencyTestFileTransferUrl2.hashCode());
        Integer fileTransferId2 = fileTransferId();
        int i3 = hashCode9 * 59;
        if (fileTransferId2 != null) {
            i = fileTransferId2.hashCode();
        }
        return i3 + i;
    }

    public GameInfoMetric isCached(boolean z) {
        this.isCached = z;
        return this;
    }

    public boolean isCached() {
        return this.isCached;
    }

    public GameInfoMetric isOffline(boolean z) {
        this.isOffline = z;
        return this;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public GameInfoMetric isSent(boolean z) {
        this.isSent = z;
        return this;
    }

    public boolean isSent() {
        return this.isSent;
    }

    public GameInfoMetric isUnderAdditionalLoad(boolean z) {
        this.isUnderAdditionalLoad = z;
        return this;
    }

    public boolean isUnderAdditionalLoad() {
        return this.isUnderAdditionalLoad;
    }

    public GameInfoMetric jitter(Float f) {
        this.jitter = f;
        return this;
    }

    public Float jitter() {
        return this.jitter;
    }

    public GameInfoMetric latency(Float f) {
        this.latency = f;
        return this;
    }

    public Float latency() {
        return this.latency;
    }

    public GameInfoMetric loadedLatencyTestFileTransferUrl(String str) {
        this.loadedLatencyTestFileTransferUrl = str;
        return this;
    }

    public String loadedLatencyTestFileTransferUrl() {
        return this.loadedLatencyTestFileTransferUrl;
    }

    public GameInfoMetric pingsCount(Float f) {
        this.pingsCount = f;
        return this;
    }

    public Float pingsCount() {
        return this.pingsCount;
    }

    public void save() {
        try {
            if (this.serverUrl != null && this.gameName != null && this.latency.floatValue() > 0.0f && this.pingsCount.floatValue() > 0.0f && DatabaseClient.a() != null) {
                GameMetricDAO j = DatabaseClient.a().j();
                j.a(this.gameName, this.serverUrl, this.isUnderAdditionalLoad);
                j.b(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void saveOffline() {
        try {
            if (this.serverUrl != null && this.gameName != null && this.latency.floatValue() > 0.0f && this.pingsCount.floatValue() > 0.0f) {
                this.isOffline = true;
                this.id = 0;
                if (DatabaseClient.a() != null) {
                    DatabaseClient.a().j().b(this);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public GameInfoMetric serverName(String str) {
        this.serverName = str;
        return this;
    }

    public String serverName() {
        return this.serverName;
    }

    public GameInfoMetric serverUrl(String str) {
        this.serverUrl = str;
        return this;
    }

    public String serverUrl() {
        return this.serverUrl;
    }

    public void setJitter(int i, int i2) {
        Float f;
        if (i2 == 0 || i == 0 || i >= 999) {
            if (this.jitter == null) {
                f = Float.valueOf(0.0f);
            }
            Objects.toString(this.jitter);
        }
        float abs = (float) Math.abs(i - i2);
        Float f2 = this.jitter;
        if (!(f2 == null || f2.floatValue() == 0.0f)) {
            double floatValue = (double) (((this.pingsCount.floatValue() * this.jitter.floatValue()) + abs) / (this.pingsCount.floatValue() + 1.0f));
            Double.isNaN(floatValue);
            abs = ((float) Math.round(floatValue * 100.0d)) / 100.0f;
        }
        f = Float.valueOf(abs);
        this.jitter = f;
        Objects.toString(this.jitter);
    }

    public String toString() {
        return "GameInfoMetric(super=" + super.toString() + ", serverName=" + serverName() + ", gameName=" + gameName() + ", serverUrl=" + serverUrl() + ", latency=" + latency() + ", pingsCount=" + pingsCount() + ", failedMeasurementsCount=" + failedMeasurementsCount() + ", jitter=" + jitter() + ", isSent=" + isSent() + ", isOffline=" + isOffline() + ", isUnderAdditionalLoad=" + isUnderAdditionalLoad() + ", isCached=" + isCached() + ", loadedLatencyTestFileTransferUrl=" + loadedLatencyTestFileTransferUrl() + ", fileTransferId=" + fileTransferId() + ")";
    }
}
