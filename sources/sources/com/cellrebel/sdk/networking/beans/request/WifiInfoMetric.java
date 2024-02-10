package com.cellrebel.sdk.networking.beans.request;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiInfoMetric {
    @SerializedName("accessTechnology")
    @Expose
    public String accessTechnology;
    @SerializedName("age")
    @Expose
    public long age;
    @SerializedName("anonymize")
    @Expose
    public Boolean anonymize;
    @SerializedName("bssid")
    @Expose
    public String bssid;
    @SerializedName("channelWidth")
    @Expose
    public int channelWidth;
    @SerializedName("dateTimeOfMeasurement")
    @Expose
    public String dateTimeOfMeasurement;
    @SerializedName("frequency")
    @Expose
    public int frequency;
    public long id;
    @SerializedName("isConnected")
    @Expose
    public Boolean isConnected;
    @SerializedName("isRooted")
    @Expose
    public Boolean isRooted;
    public boolean isSending;
    @SerializedName("referenceSignalStrengthIndicator")
    @Expose
    public int level;
    @SerializedName("linkSpeed")
    @Expose
    public int linkSpeed;
    @SerializedName("maxSupportedRxLinkSpeed")
    @Expose
    public int maxSupportedRxLinkSpeed;
    @SerializedName("maxSupportedTxLinkSpeed")
    @Expose
    public int maxSupportedTxLinkSpeed;
    @SerializedName("measurementSequenceId")
    @Expose
    public String measurementSequenceId;
    @SerializedName("mobileClientId")
    @Expose
    public String mobileClientId;
    @SerializedName("networkId")
    @Expose
    public int networkId;
    @SerializedName("rxLinkSpeed")
    @Expose
    public int rxLinkSpeed;
    @SerializedName("sdkOrigin")
    @Expose
    public String sdkOrigin;
    @SerializedName("ssid")
    @Expose
    public String ssid;
    @SerializedName("txLinkSpeed")
    @Expose
    public int txLinkSpeed;
    @SerializedName("wifiStandard")
    @Expose
    public String wifiStandard;

    private void setWifiStandard(int i) {
        this.wifiStandard = i != 1 ? i != 4 ? i != 5 ? i != 6 ? "UNKNOWN" : "11AX" : "11AC" : "11N" : "LEGACY";
    }

    public WifiInfoMetric accessTechnology(String str) {
        this.accessTechnology = str;
        return this;
    }

    public String accessTechnology() {
        return this.accessTechnology;
    }

    public long age() {
        return this.age;
    }

    public WifiInfoMetric age(long j) {
        this.age = j;
        return this;
    }

    public WifiInfoMetric anonymize(Boolean bool) {
        this.anonymize = bool;
        return this;
    }

    public Boolean anonymize() {
        return this.anonymize;
    }

    public WifiInfoMetric bssid(String str) {
        this.bssid = str;
        return this;
    }

    public String bssid() {
        return this.bssid;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof WifiInfoMetric;
    }

    public int channelWidth() {
        return this.channelWidth;
    }

    public WifiInfoMetric channelWidth(int i) {
        this.channelWidth = i;
        return this;
    }

    public WifiInfoMetric dateTimeOfMeasurement(String str) {
        this.dateTimeOfMeasurement = str;
        return this;
    }

    public String dateTimeOfMeasurement() {
        return this.dateTimeOfMeasurement;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WifiInfoMetric)) {
            return false;
        }
        WifiInfoMetric wifiInfoMetric = (WifiInfoMetric) obj;
        if (!wifiInfoMetric.canEqual(this) || id() != wifiInfoMetric.id()) {
            return false;
        }
        String mobileClientId2 = mobileClientId();
        String mobileClientId3 = wifiInfoMetric.mobileClientId();
        if (mobileClientId2 != null ? !mobileClientId2.equals(mobileClientId3) : mobileClientId3 != null) {
            return false;
        }
        String measurementSequenceId2 = measurementSequenceId();
        String measurementSequenceId3 = wifiInfoMetric.measurementSequenceId();
        if (measurementSequenceId2 != null ? !measurementSequenceId2.equals(measurementSequenceId3) : measurementSequenceId3 != null) {
            return false;
        }
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        String dateTimeOfMeasurement3 = wifiInfoMetric.dateTimeOfMeasurement();
        if (dateTimeOfMeasurement2 != null ? !dateTimeOfMeasurement2.equals(dateTimeOfMeasurement3) : dateTimeOfMeasurement3 != null) {
            return false;
        }
        String accessTechnology2 = accessTechnology();
        String accessTechnology3 = wifiInfoMetric.accessTechnology();
        if (accessTechnology2 != null ? !accessTechnology2.equals(accessTechnology3) : accessTechnology3 != null) {
            return false;
        }
        String bssid2 = bssid();
        String bssid3 = wifiInfoMetric.bssid();
        if (bssid2 != null ? !bssid2.equals(bssid3) : bssid3 != null) {
            return false;
        }
        String ssid2 = ssid();
        String ssid3 = wifiInfoMetric.ssid();
        if (ssid2 != null ? !ssid2.equals(ssid3) : ssid3 != null) {
            return false;
        }
        if (level() != wifiInfoMetric.level() || age() != wifiInfoMetric.age()) {
            return false;
        }
        Boolean anonymize2 = anonymize();
        Boolean anonymize3 = wifiInfoMetric.anonymize();
        if (anonymize2 != null ? !anonymize2.equals(anonymize3) : anonymize3 != null) {
            return false;
        }
        String sdkOrigin2 = sdkOrigin();
        String sdkOrigin3 = wifiInfoMetric.sdkOrigin();
        if (sdkOrigin2 != null ? !sdkOrigin2.equals(sdkOrigin3) : sdkOrigin3 != null) {
            return false;
        }
        if (frequency() != wifiInfoMetric.frequency() || linkSpeed() != wifiInfoMetric.linkSpeed() || maxSupportedRxLinkSpeed() != wifiInfoMetric.maxSupportedRxLinkSpeed() || maxSupportedTxLinkSpeed() != wifiInfoMetric.maxSupportedTxLinkSpeed()) {
            return false;
        }
        String wifiStandard2 = wifiStandard();
        String wifiStandard3 = wifiInfoMetric.wifiStandard();
        if (wifiStandard2 != null ? !wifiStandard2.equals(wifiStandard3) : wifiStandard3 != null) {
            return false;
        }
        if (networkId() != wifiInfoMetric.networkId()) {
            return false;
        }
        Boolean isConnected2 = isConnected();
        Boolean isConnected3 = wifiInfoMetric.isConnected();
        if (isConnected2 != null ? !isConnected2.equals(isConnected3) : isConnected3 != null) {
            return false;
        }
        Boolean isRooted2 = isRooted();
        Boolean isRooted3 = wifiInfoMetric.isRooted();
        if (isRooted2 != null ? isRooted2.equals(isRooted3) : isRooted3 == null) {
            return rxLinkSpeed() == wifiInfoMetric.rxLinkSpeed() && txLinkSpeed() == wifiInfoMetric.txLinkSpeed() && channelWidth() == wifiInfoMetric.channelWidth() && isSending() == wifiInfoMetric.isSending();
        }
        return false;
    }

    public void fill(ScanResult scanResult) {
        this.bssid = scanResult.BSSID;
        this.ssid = scanResult.SSID;
        this.level = scanResult.level;
        int i = Build.VERSION.SDK_INT;
        this.age = (System.currentTimeMillis() - ((System.currentTimeMillis() - SystemClock.uptimeMillis()) + (scanResult.timestamp / 1000000))) / 1000;
        if (i >= 30) {
            setWifiStandard(scanResult.getWifiStandard());
        }
        this.frequency = scanResult.frequency;
        if (i >= 23) {
            this.channelWidth = scanResult.channelWidth;
        }
    }

    public void fill(WifiInfo wifiInfo) {
        this.bssid = wifiInfo.getBSSID();
        this.ssid = wifiInfo.getSSID();
        this.level = wifiInfo.getRssi();
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            this.frequency = wifiInfo.getFrequency();
        }
        this.linkSpeed = wifiInfo.getLinkSpeed();
        if (i >= 30) {
            this.maxSupportedRxLinkSpeed = wifiInfo.getMaxSupportedRxLinkSpeedMbps();
            this.maxSupportedTxLinkSpeed = wifiInfo.getMaxSupportedTxLinkSpeedMbps();
            setWifiStandard(wifiInfo.getWifiStandard());
        }
        this.networkId = wifiInfo.getNetworkId();
        if (i >= 29) {
            this.rxLinkSpeed = wifiInfo.getRxLinkSpeedMbps();
            this.txLinkSpeed = wifiInfo.getTxLinkSpeedMbps();
        }
    }

    public void fill(BaseMetric baseMetric) {
        this.mobileClientId = baseMetric.mobileClientId;
        this.anonymize = baseMetric.anonymize;
        this.sdkOrigin = baseMetric.sdkOrigin;
        this.dateTimeOfMeasurement = String.valueOf(System.currentTimeMillis() / 1000);
        this.accessTechnology = baseMetric.accessTechnology;
        this.isRooted = baseMetric.isRooted;
    }

    public int frequency() {
        return this.frequency;
    }

    public WifiInfoMetric frequency(int i) {
        this.frequency = i;
        return this;
    }

    public int hashCode() {
        long id2 = id();
        String mobileClientId2 = mobileClientId();
        int i = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (mobileClientId2 == null ? 43 : mobileClientId2.hashCode());
        String measurementSequenceId2 = measurementSequenceId();
        int hashCode2 = (hashCode * 59) + (measurementSequenceId2 == null ? 43 : measurementSequenceId2.hashCode());
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        int hashCode3 = (hashCode2 * 59) + (dateTimeOfMeasurement2 == null ? 43 : dateTimeOfMeasurement2.hashCode());
        String accessTechnology2 = accessTechnology();
        int hashCode4 = (hashCode3 * 59) + (accessTechnology2 == null ? 43 : accessTechnology2.hashCode());
        String bssid2 = bssid();
        int hashCode5 = (hashCode4 * 59) + (bssid2 == null ? 43 : bssid2.hashCode());
        String ssid2 = ssid();
        int i2 = hashCode5 * 59;
        int hashCode6 = ssid2 == null ? 43 : ssid2.hashCode();
        long age2 = age();
        int level2 = ((((i2 + hashCode6) * 59) + level()) * 59) + ((int) (age2 ^ (age2 >>> 32)));
        Boolean anonymize2 = anonymize();
        int hashCode7 = (level2 * 59) + (anonymize2 == null ? 43 : anonymize2.hashCode());
        String sdkOrigin2 = sdkOrigin();
        int hashCode8 = (((((((((hashCode7 * 59) + (sdkOrigin2 == null ? 43 : sdkOrigin2.hashCode())) * 59) + frequency()) * 59) + linkSpeed()) * 59) + maxSupportedRxLinkSpeed()) * 59) + maxSupportedTxLinkSpeed();
        String wifiStandard2 = wifiStandard();
        int hashCode9 = (((hashCode8 * 59) + (wifiStandard2 == null ? 43 : wifiStandard2.hashCode())) * 59) + networkId();
        Boolean isConnected2 = isConnected();
        int hashCode10 = (hashCode9 * 59) + (isConnected2 == null ? 43 : isConnected2.hashCode());
        Boolean isRooted2 = isRooted();
        int i3 = hashCode10 * 59;
        if (isRooted2 != null) {
            i = isRooted2.hashCode();
        }
        return ((((((((i3 + i) * 59) + rxLinkSpeed()) * 59) + txLinkSpeed()) * 59) + channelWidth()) * 59) + (isSending() ? 79 : 97);
    }

    public long id() {
        return this.id;
    }

    public WifiInfoMetric id(long j) {
        this.id = j;
        return this;
    }

    public WifiInfoMetric isConnected(Boolean bool) {
        this.isConnected = bool;
        return this;
    }

    public Boolean isConnected() {
        return this.isConnected;
    }

    public WifiInfoMetric isRooted(Boolean bool) {
        this.isRooted = bool;
        return this;
    }

    public Boolean isRooted() {
        return this.isRooted;
    }

    public WifiInfoMetric isSending(boolean z) {
        this.isSending = z;
        return this;
    }

    public boolean isSending() {
        return this.isSending;
    }

    public int level() {
        return this.level;
    }

    public WifiInfoMetric level(int i) {
        this.level = i;
        return this;
    }

    public int linkSpeed() {
        return this.linkSpeed;
    }

    public WifiInfoMetric linkSpeed(int i) {
        this.linkSpeed = i;
        return this;
    }

    public int maxSupportedRxLinkSpeed() {
        return this.maxSupportedRxLinkSpeed;
    }

    public WifiInfoMetric maxSupportedRxLinkSpeed(int i) {
        this.maxSupportedRxLinkSpeed = i;
        return this;
    }

    public int maxSupportedTxLinkSpeed() {
        return this.maxSupportedTxLinkSpeed;
    }

    public WifiInfoMetric maxSupportedTxLinkSpeed(int i) {
        this.maxSupportedTxLinkSpeed = i;
        return this;
    }

    public WifiInfoMetric measurementSequenceId(String str) {
        this.measurementSequenceId = str;
        return this;
    }

    public String measurementSequenceId() {
        return this.measurementSequenceId;
    }

    public WifiInfoMetric mobileClientId(String str) {
        this.mobileClientId = str;
        return this;
    }

    public String mobileClientId() {
        return this.mobileClientId;
    }

    public int networkId() {
        return this.networkId;
    }

    public WifiInfoMetric networkId(int i) {
        this.networkId = i;
        return this;
    }

    public int rxLinkSpeed() {
        return this.rxLinkSpeed;
    }

    public WifiInfoMetric rxLinkSpeed(int i) {
        this.rxLinkSpeed = i;
        return this;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().x().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public WifiInfoMetric sdkOrigin(String str) {
        this.sdkOrigin = str;
        return this;
    }

    public String sdkOrigin() {
        return this.sdkOrigin;
    }

    public WifiInfoMetric ssid(String str) {
        this.ssid = str;
        return this;
    }

    public String ssid() {
        return this.ssid;
    }

    public String toString() {
        return "WifiInfoMetric(id=" + id() + ", mobileClientId=" + mobileClientId() + ", measurementSequenceId=" + measurementSequenceId() + ", dateTimeOfMeasurement=" + dateTimeOfMeasurement() + ", accessTechnology=" + accessTechnology() + ", bssid=" + bssid() + ", ssid=" + ssid() + ", level=" + level() + ", age=" + age() + ", anonymize=" + anonymize() + ", sdkOrigin=" + sdkOrigin() + ", frequency=" + frequency() + ", linkSpeed=" + linkSpeed() + ", maxSupportedRxLinkSpeed=" + maxSupportedRxLinkSpeed() + ", maxSupportedTxLinkSpeed=" + maxSupportedTxLinkSpeed() + ", wifiStandard=" + wifiStandard() + ", networkId=" + networkId() + ", isConnected=" + isConnected() + ", isRooted=" + isRooted() + ", rxLinkSpeed=" + rxLinkSpeed() + ", txLinkSpeed=" + txLinkSpeed() + ", channelWidth=" + channelWidth() + ", isSending=" + isSending() + ")";
    }

    public int txLinkSpeed() {
        return this.txLinkSpeed;
    }

    public WifiInfoMetric txLinkSpeed(int i) {
        this.txLinkSpeed = i;
        return this;
    }

    public WifiInfoMetric wifiStandard(String str) {
        this.wifiStandard = str;
        return this;
    }

    public String wifiStandard() {
        return this.wifiStandard;
    }
}
