package com.mbridge.msdk.foundation.download.utils;

public final class Utils {
    private Utils() {
    }

    public static int getDownloadRate(long j, long j2) {
        if (j == 0 || j2 == 0) {
            return 0;
        }
        if (j == j2) {
            return 100;
        }
        double d = (double) j2;
        Double.isNaN(d);
        double d2 = (double) j;
        Double.isNaN(d2);
        return (int) (((d * 1.0d) / (d2 * 1.0d)) * 100.0d);
    }
}
