package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrafficProfileMetric extends BaseMetric {
    @SerializedName("errors")
    @Expose
    public String errors;
    @SerializedName("iqmJitter")
    @Expose
    public long iqmJitter;
    @SerializedName("iqmLatency")
    @Expose
    public long iqmLatency;
    @SerializedName("maximumJitter")
    @Expose
    public long maximumJitter;
    @SerializedName("maximumLatency")
    @Expose
    public long maximumLatency;
    @SerializedName("meanJitter")
    @Expose
    public long meanJitter;
    @SerializedName("meanLatency")
    @Expose
    public long meanLatency;
    @SerializedName("medianJitter")
    @Expose
    public long medianJitter;
    @SerializedName("medianLatency")
    @Expose
    public long medianLatency;
    @SerializedName("minimumJitter")
    @Expose
    public long minimumJitter;
    @SerializedName("minimumLatency")
    @Expose
    public long minimumLatency;
    @SerializedName("numberOfOutOfOrderPackets")
    @Expose
    public int numberOfOutOfOrderPackets;
    @SerializedName("outOfOrderPackets")
    @Expose
    public int outOfOrderPackets;
    @SerializedName("p10Jitter")
    @Expose
    public long p10Jitter;
    @SerializedName("p10Latency")
    @Expose
    public long p10Latency;
    @SerializedName("p90Jitter")
    @Expose
    public long p90Jitter;
    @SerializedName("p90Latency")
    @Expose
    public long p90Latency;
    @SerializedName("packetCount")
    @Expose
    public int packetCount;
    @SerializedName("packetLoss")
    @Expose
    public long packetLoss;
    @SerializedName("profile")
    @Expose
    public String profile;
    @SerializedName("profileName")
    @Expose
    public String profileName;
    @SerializedName("profileType")
    @Expose
    public int profileType;
    @SerializedName("serverUrl")
    @Expose
    public String serverUrl;
    @SerializedName("throughput")
    @Expose
    public double throughput;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof TrafficProfileMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficProfileMetric)) {
            return false;
        }
        TrafficProfileMetric trafficProfileMetric = (TrafficProfileMetric) obj;
        if (!trafficProfileMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String profileName2 = profileName();
        String profileName3 = trafficProfileMetric.profileName();
        if (profileName2 != null ? !profileName2.equals(profileName3) : profileName3 != null) {
            return false;
        }
        String profile2 = profile();
        String profile3 = trafficProfileMetric.profile();
        if (profile2 != null ? !profile2.equals(profile3) : profile3 != null) {
            return false;
        }
        if (profileType() != trafficProfileMetric.profileType() || meanLatency() != trafficProfileMetric.meanLatency() || medianLatency() != trafficProfileMetric.medianLatency() || minimumLatency() != trafficProfileMetric.minimumLatency() || maximumLatency() != trafficProfileMetric.maximumLatency() || p10Latency() != trafficProfileMetric.p10Latency() || p90Latency() != trafficProfileMetric.p90Latency() || iqmLatency() != trafficProfileMetric.iqmLatency() || meanJitter() != trafficProfileMetric.meanJitter() || medianJitter() != trafficProfileMetric.medianJitter() || minimumJitter() != trafficProfileMetric.minimumJitter() || maximumJitter() != trafficProfileMetric.maximumJitter() || p10Jitter() != trafficProfileMetric.p10Jitter() || p90Jitter() != trafficProfileMetric.p90Jitter() || iqmJitter() != trafficProfileMetric.iqmJitter() || packetLoss() != trafficProfileMetric.packetLoss() || outOfOrderPackets() != trafficProfileMetric.outOfOrderPackets() || packetCount() != trafficProfileMetric.packetCount() || numberOfOutOfOrderPackets() != trafficProfileMetric.numberOfOutOfOrderPackets() || Double.compare(throughput(), trafficProfileMetric.throughput()) != 0) {
            return false;
        }
        String serverUrl2 = serverUrl();
        String serverUrl3 = trafficProfileMetric.serverUrl();
        if (serverUrl2 != null ? !serverUrl2.equals(serverUrl3) : serverUrl3 != null) {
            return false;
        }
        String errors2 = errors();
        String errors3 = trafficProfileMetric.errors();
        return errors2 != null ? errors2.equals(errors3) : errors3 == null;
    }

    public TrafficProfileMetric errors(String str) {
        this.errors = str;
        return this;
    }

    public String errors() {
        return this.errors;
    }

    public void fill(TrafficProfileResult trafficProfileResult) {
        this.profileName = trafficProfileResult.a;
        this.profile = trafficProfileResult.b;
        this.profileType = trafficProfileResult.c;
        this.serverUrl = trafficProfileResult.w;
        this.meanLatency = trafficProfileResult.d;
        this.medianLatency = trafficProfileResult.e;
        this.minimumLatency = trafficProfileResult.f;
        this.maximumLatency = trafficProfileResult.g;
        this.p10Latency = trafficProfileResult.h;
        this.p90Latency = trafficProfileResult.i;
        this.iqmLatency = trafficProfileResult.j;
        this.packetCount = trafficProfileResult.t;
        this.packetLoss = trafficProfileResult.r;
        this.outOfOrderPackets = trafficProfileResult.s;
        this.numberOfOutOfOrderPackets = trafficProfileResult.u;
        this.throughput = trafficProfileResult.v;
        this.meanJitter = trafficProfileResult.k;
        this.medianJitter = trafficProfileResult.l;
        this.minimumJitter = trafficProfileResult.m;
        this.maximumJitter = trafficProfileResult.n;
        this.p10Jitter = trafficProfileResult.o;
        this.p90Jitter = trafficProfileResult.p;
        this.iqmJitter = trafficProfileResult.q;
        this.errors = trafficProfileResult.x;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String profileName2 = profileName();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (profileName2 == null ? 43 : profileName2.hashCode());
        String profile2 = profile();
        int i2 = hashCode2 * 59;
        int hashCode3 = profile2 == null ? 43 : profile2.hashCode();
        long meanLatency2 = meanLatency();
        long medianLatency2 = medianLatency();
        long minimumLatency2 = minimumLatency();
        long maximumLatency2 = maximumLatency();
        long p10Latency2 = p10Latency();
        long p90Latency2 = p90Latency();
        long iqmLatency2 = iqmLatency();
        long meanJitter2 = meanJitter();
        long medianJitter2 = medianJitter();
        long minimumJitter2 = minimumJitter();
        long maximumJitter2 = maximumJitter();
        long p10Jitter2 = p10Jitter();
        long p90Jitter2 = p90Jitter();
        long iqmJitter2 = iqmJitter();
        long packetLoss2 = packetLoss();
        int profileType2 = ((((((((((((((((((((((((((((((((((((((i2 + hashCode3) * 59) + profileType()) * 59) + ((int) (meanLatency2 ^ (meanLatency2 >>> 32)))) * 59) + ((int) (medianLatency2 ^ (medianLatency2 >>> 32)))) * 59) + ((int) (minimumLatency2 ^ (minimumLatency2 >>> 32)))) * 59) + ((int) (maximumLatency2 ^ (maximumLatency2 >>> 32)))) * 59) + ((int) (p10Latency2 ^ (p10Latency2 >>> 32)))) * 59) + ((int) (p90Latency2 ^ (p90Latency2 >>> 32)))) * 59) + ((int) (iqmLatency2 ^ (iqmLatency2 >>> 32)))) * 59) + ((int) (meanJitter2 ^ (meanJitter2 >>> 32)))) * 59) + ((int) (medianJitter2 ^ (medianJitter2 >>> 32)))) * 59) + ((int) (minimumJitter2 ^ (minimumJitter2 >>> 32)))) * 59) + ((int) (maximumJitter2 ^ (maximumJitter2 >>> 32)))) * 59) + ((int) (p10Jitter2 ^ (p10Jitter2 >>> 32)))) * 59) + ((int) (p90Jitter2 ^ (p90Jitter2 >>> 32)))) * 59) + ((int) (iqmJitter2 ^ (iqmJitter2 >>> 32)))) * 59) + ((int) (packetLoss2 ^ (packetLoss2 >>> 32)))) * 59) + outOfOrderPackets()) * 59) + packetCount()) * 59) + numberOfOutOfOrderPackets();
        long doubleToLongBits = Double.doubleToLongBits(throughput());
        String serverUrl2 = serverUrl();
        int hashCode4 = (((profileType2 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + (serverUrl2 == null ? 43 : serverUrl2.hashCode());
        String errors2 = errors();
        int i3 = hashCode4 * 59;
        if (errors2 != null) {
            i = errors2.hashCode();
        }
        return i3 + i;
    }

    public long iqmJitter() {
        return this.iqmJitter;
    }

    public TrafficProfileMetric iqmJitter(long j) {
        this.iqmJitter = j;
        return this;
    }

    public long iqmLatency() {
        return this.iqmLatency;
    }

    public TrafficProfileMetric iqmLatency(long j) {
        this.iqmLatency = j;
        return this;
    }

    public long maximumJitter() {
        return this.maximumJitter;
    }

    public TrafficProfileMetric maximumJitter(long j) {
        this.maximumJitter = j;
        return this;
    }

    public long maximumLatency() {
        return this.maximumLatency;
    }

    public TrafficProfileMetric maximumLatency(long j) {
        this.maximumLatency = j;
        return this;
    }

    public long meanJitter() {
        return this.meanJitter;
    }

    public TrafficProfileMetric meanJitter(long j) {
        this.meanJitter = j;
        return this;
    }

    public long meanLatency() {
        return this.meanLatency;
    }

    public TrafficProfileMetric meanLatency(long j) {
        this.meanLatency = j;
        return this;
    }

    public long medianJitter() {
        return this.medianJitter;
    }

    public TrafficProfileMetric medianJitter(long j) {
        this.medianJitter = j;
        return this;
    }

    public long medianLatency() {
        return this.medianLatency;
    }

    public TrafficProfileMetric medianLatency(long j) {
        this.medianLatency = j;
        return this;
    }

    public long minimumJitter() {
        return this.minimumJitter;
    }

    public TrafficProfileMetric minimumJitter(long j) {
        this.minimumJitter = j;
        return this;
    }

    public long minimumLatency() {
        return this.minimumLatency;
    }

    public TrafficProfileMetric minimumLatency(long j) {
        this.minimumLatency = j;
        return this;
    }

    public int numberOfOutOfOrderPackets() {
        return this.numberOfOutOfOrderPackets;
    }

    public TrafficProfileMetric numberOfOutOfOrderPackets(int i) {
        this.numberOfOutOfOrderPackets = i;
        return this;
    }

    public int outOfOrderPackets() {
        return this.outOfOrderPackets;
    }

    public TrafficProfileMetric outOfOrderPackets(int i) {
        this.outOfOrderPackets = i;
        return this;
    }

    public long p10Jitter() {
        return this.p10Jitter;
    }

    public TrafficProfileMetric p10Jitter(long j) {
        this.p10Jitter = j;
        return this;
    }

    public long p10Latency() {
        return this.p10Latency;
    }

    public TrafficProfileMetric p10Latency(long j) {
        this.p10Latency = j;
        return this;
    }

    public long p90Jitter() {
        return this.p90Jitter;
    }

    public TrafficProfileMetric p90Jitter(long j) {
        this.p90Jitter = j;
        return this;
    }

    public long p90Latency() {
        return this.p90Latency;
    }

    public TrafficProfileMetric p90Latency(long j) {
        this.p90Latency = j;
        return this;
    }

    public int packetCount() {
        return this.packetCount;
    }

    public TrafficProfileMetric packetCount(int i) {
        this.packetCount = i;
        return this;
    }

    public long packetLoss() {
        return this.packetLoss;
    }

    public TrafficProfileMetric packetLoss(long j) {
        this.packetLoss = j;
        return this;
    }

    public TrafficProfileMetric profile(String str) {
        this.profile = str;
        return this;
    }

    public String profile() {
        return this.profile;
    }

    public TrafficProfileMetric profileName(String str) {
        this.profileName = str;
        return this;
    }

    public String profileName() {
        return this.profileName;
    }

    public int profileType() {
        return this.profileType;
    }

    public TrafficProfileMetric profileType(int i) {
        this.profileType = i;
        return this;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().s().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public TrafficProfileMetric serverUrl(String str) {
        this.serverUrl = str;
        return this;
    }

    public String serverUrl() {
        return this.serverUrl;
    }

    public double throughput() {
        return this.throughput;
    }

    public TrafficProfileMetric throughput(double d) {
        this.throughput = d;
        return this;
    }

    public String toString() {
        return "TrafficProfileMetric(super=" + super.toString() + ", profileName=" + profileName() + ", profile=" + profile() + ", profileType=" + profileType() + ", meanLatency=" + meanLatency() + ", medianLatency=" + medianLatency() + ", minimumLatency=" + minimumLatency() + ", maximumLatency=" + maximumLatency() + ", p10Latency=" + p10Latency() + ", p90Latency=" + p90Latency() + ", iqmLatency=" + iqmLatency() + ", meanJitter=" + meanJitter() + ", medianJitter=" + medianJitter() + ", minimumJitter=" + minimumJitter() + ", maximumJitter=" + maximumJitter() + ", p10Jitter=" + p10Jitter() + ", p90Jitter=" + p90Jitter() + ", iqmJitter=" + iqmJitter() + ", packetLoss=" + packetLoss() + ", outOfOrderPackets=" + outOfOrderPackets() + ", packetCount=" + packetCount() + ", numberOfOutOfOrderPackets=" + numberOfOutOfOrderPackets() + ", throughput=" + throughput() + ", serverUrl=" + serverUrl() + ", errors=" + errors() + ")";
    }
}
