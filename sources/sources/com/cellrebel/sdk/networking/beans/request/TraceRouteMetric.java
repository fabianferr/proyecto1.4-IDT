package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraceRouteMetric extends BaseMetric {
    @SerializedName("numberOfHops")
    @Expose
    public int numberOfHops;
    @SerializedName("packetSize")
    @Expose
    public int packetSize;
    @SerializedName("serverUrl")
    @Expose
    public String serverUrl;
    @SerializedName("traceroute")
    @Expose
    public String traceroute;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof TraceRouteMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceRouteMetric)) {
            return false;
        }
        TraceRouteMetric traceRouteMetric = (TraceRouteMetric) obj;
        if (!traceRouteMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String traceroute2 = traceroute();
        String traceroute3 = traceRouteMetric.traceroute();
        if (traceroute2 != null ? !traceroute2.equals(traceroute3) : traceroute3 != null) {
            return false;
        }
        String serverUrl2 = serverUrl();
        String serverUrl3 = traceRouteMetric.serverUrl();
        if (serverUrl2 != null ? serverUrl2.equals(serverUrl3) : serverUrl3 == null) {
            return numberOfHops() == traceRouteMetric.numberOfHops() && packetSize() == traceRouteMetric.packetSize();
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String traceroute2 = traceroute();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (traceroute2 == null ? 43 : traceroute2.hashCode());
        String serverUrl2 = serverUrl();
        int i2 = hashCode2 * 59;
        if (serverUrl2 != null) {
            i = serverUrl2.hashCode();
        }
        return ((((i2 + i) * 59) + numberOfHops()) * 59) + packetSize();
    }

    public int numberOfHops() {
        return this.numberOfHops;
    }

    public TraceRouteMetric numberOfHops(int i) {
        this.numberOfHops = i;
        return this;
    }

    public int packetSize() {
        return this.packetSize;
    }

    public TraceRouteMetric packetSize(int i) {
        this.packetSize = i;
        return this;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().r().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public TraceRouteMetric serverUrl(String str) {
        this.serverUrl = str;
        return this;
    }

    public String serverUrl() {
        return this.serverUrl;
    }

    public String toString() {
        return "TraceRouteMetric(super=" + super.toString() + ", traceroute=" + traceroute() + ", serverUrl=" + serverUrl() + ", numberOfHops=" + numberOfHops() + ", packetSize=" + packetSize() + ")";
    }

    public TraceRouteMetric traceroute(String str) {
        this.traceroute = str;
        return this;
    }

    public String traceroute() {
        return this.traceroute;
    }
}
