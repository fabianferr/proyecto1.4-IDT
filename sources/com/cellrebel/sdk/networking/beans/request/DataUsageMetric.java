package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUsageMetric extends BaseMetric {
    @SerializedName("cellularReceivedUsage")
    @Expose
    public long cellularReceivedUsage;
    @SerializedName("cellularSentUsage")
    @Expose
    public long cellularSentUsage;
    @SerializedName("timePeriod")
    @Expose
    public long timePeriod;
    @SerializedName("wiFiReceivedUsage")
    @Expose
    public long wiFiReceivedUsage;
    @SerializedName("wiFiSentUsage")
    @Expose
    public long wiFiSentUsage;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof DataUsageMetric;
    }

    public long cellularReceivedUsage() {
        return this.cellularReceivedUsage;
    }

    public DataUsageMetric cellularReceivedUsage(long j) {
        this.cellularReceivedUsage = j;
        return this;
    }

    public long cellularSentUsage() {
        return this.cellularSentUsage;
    }

    public DataUsageMetric cellularSentUsage(long j) {
        this.cellularSentUsage = j;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUsageMetric)) {
            return false;
        }
        DataUsageMetric dataUsageMetric = (DataUsageMetric) obj;
        return dataUsageMetric.canEqual(this) && super.equals(obj) && wiFiSentUsage() == dataUsageMetric.wiFiSentUsage() && wiFiReceivedUsage() == dataUsageMetric.wiFiReceivedUsage() && cellularSentUsage() == dataUsageMetric.cellularSentUsage() && cellularReceivedUsage() == dataUsageMetric.cellularReceivedUsage() && timePeriod() == dataUsageMetric.timePeriod();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long wiFiSentUsage2 = wiFiSentUsage();
        long wiFiReceivedUsage2 = wiFiReceivedUsage();
        long cellularSentUsage2 = cellularSentUsage();
        long cellularReceivedUsage2 = cellularReceivedUsage();
        long timePeriod2 = timePeriod();
        return (((((((((hashCode * 59) + ((int) (wiFiSentUsage2 ^ (wiFiSentUsage2 >>> 32)))) * 59) + ((int) (wiFiReceivedUsage2 ^ (wiFiReceivedUsage2 >>> 32)))) * 59) + ((int) (cellularSentUsage2 ^ (cellularSentUsage2 >>> 32)))) * 59) + ((int) (cellularReceivedUsage2 ^ (cellularReceivedUsage2 >>> 32)))) * 59) + ((int) (timePeriod2 ^ (timePeriod2 >>> 32)));
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().f().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long timePeriod() {
        return this.timePeriod;
    }

    public DataUsageMetric timePeriod(long j) {
        this.timePeriod = j;
        return this;
    }

    public String toString() {
        return "DataUsageMetric(super=" + super.toString() + ", wiFiSentUsage=" + wiFiSentUsage() + ", wiFiReceivedUsage=" + wiFiReceivedUsage() + ", cellularSentUsage=" + cellularSentUsage() + ", cellularReceivedUsage=" + cellularReceivedUsage() + ", timePeriod=" + timePeriod() + ")";
    }

    public long wiFiReceivedUsage() {
        return this.wiFiReceivedUsage;
    }

    public DataUsageMetric wiFiReceivedUsage(long j) {
        this.wiFiReceivedUsage = j;
        return this;
    }

    public long wiFiSentUsage() {
        return this.wiFiSentUsage;
    }

    public DataUsageMetric wiFiSentUsage(long j) {
        this.wiFiSentUsage = j;
        return this;
    }
}
