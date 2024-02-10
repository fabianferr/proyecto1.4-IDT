package com.cellrebel.sdk.trafficprofile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrafficProfileResult {
    @SerializedName("profileName")
    @Expose
    public String a;
    @SerializedName("profile")
    @Expose
    public String b;
    @SerializedName("profileType")
    @Expose
    public int c;
    @SerializedName("meanLatency")
    @Expose
    public long d;
    @SerializedName("medianLatency")
    @Expose
    public long e;
    @SerializedName("minimumLatency")
    @Expose
    public long f;
    @SerializedName("maximumLatency")
    @Expose
    public long g;
    @SerializedName("p10Latency")
    @Expose
    public long h;
    @SerializedName("p90Latency")
    @Expose
    public long i;
    @SerializedName("iqmLatency")
    @Expose
    public long j;
    @SerializedName("meanJitter")
    @Expose
    public long k;
    @SerializedName("medianJitter")
    @Expose
    public long l;
    @SerializedName("minimumJitter")
    @Expose
    public long m;
    @SerializedName("maximumJitter")
    @Expose
    public long n;
    @SerializedName("p10Jitter")
    @Expose
    public long o;
    @SerializedName("p90Jitter")
    @Expose
    public long p;
    @SerializedName("iqmJitter")
    @Expose
    public long q;
    @SerializedName("packetLoss")
    @Expose
    public long r;
    @SerializedName("outOfOrderPackets")
    @Expose
    public int s;
    @SerializedName("packetCount")
    @Expose
    public int t;
    @SerializedName("numberOfOutOfOrderPackets")
    @Expose
    public int u;
    @SerializedName("throughput")
    @Expose
    public double v;
    @SerializedName("serverUrl")
    @Expose
    public String w;
    @SerializedName("errors")
    @Expose
    public String x;
}
