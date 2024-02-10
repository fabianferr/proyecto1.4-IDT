package com.teragence.library;

import android.net.TrafficStats;

public class c1 {
    public static f1 a(boolean z, int i) {
        long totalRxBytes = z ? TrafficStats.getTotalRxBytes() : TrafficStats.getMobileRxBytes();
        long totalTxBytes = z ? TrafficStats.getTotalTxBytes() : TrafficStats.getMobileTxBytes();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Thread.sleep((long) i);
        } catch (Exception unused) {
        }
        double currentTimeMillis2 = (double) (System.currentTimeMillis() - currentTimeMillis);
        double totalRxBytes2 = (double) ((z ? TrafficStats.getTotalRxBytes() : TrafficStats.getMobileRxBytes()) - totalRxBytes);
        double totalTxBytes2 = (double) ((z ? TrafficStats.getTotalTxBytes() : TrafficStats.getMobileTxBytes()) - totalTxBytes);
        Double.isNaN(currentTimeMillis2);
        double d = currentTimeMillis2 / 1000.0d;
        Double.isNaN(totalRxBytes2);
        Double.isNaN(totalTxBytes2);
        return new e1(totalRxBytes2 / d, totalTxBytes2 / d);
    }
}
