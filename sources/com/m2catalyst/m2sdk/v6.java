package com.m2catalyst.m2sdk;

import android.net.TrafficStats;

/* compiled from: TrafficStatsWrapper.kt */
public final class v6 {
    public static long a() {
        return TrafficStats.getMobileRxBytes();
    }

    public static long b() {
        return TrafficStats.getMobileTxBytes();
    }

    public static long c() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static long d() {
        return TrafficStats.getTotalTxBytes() - TrafficStats.getMobileTxBytes();
    }
}
