package com.cellrebel.sdk.trafficprofile;

import java.util.Arrays;
import java.util.List;

public class TrafficProfileMeasurementUtils {
    private static TrafficProfileMeasurementUtils b;
    private long a = 0;

    private TrafficProfileMeasurementUtils() {
    }

    public static synchronized TrafficProfileMeasurementUtils a() {
        TrafficProfileMeasurementUtils trafficProfileMeasurementUtils;
        synchronized (TrafficProfileMeasurementUtils.class) {
            if (b == null) {
                b = new TrafficProfileMeasurementUtils();
            }
            trafficProfileMeasurementUtils = b;
        }
        return trafficProfileMeasurementUtils;
    }

    public double a(int i, long j) {
        return (double) ((((float) (i * 8)) / (((float) j) / 1000.0f)) / 1048576.0f);
    }

    public int a(int i, int i2) {
        double d = (double) i;
        double d2 = (double) i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (int) ((d / d2) * 100.0d);
    }

    public int a(int[] iArr) {
        Arrays.sort(iArr);
        double length = (double) iArr.length;
        Double.isNaN(length);
        int ceil = (int) Math.ceil(length * 0.25d);
        double length2 = (double) iArr.length;
        Double.isNaN(length2);
        int ceil2 = (int) Math.ceil(length2 * 0.75d);
        int i = 0;
        for (int i2 = ceil; i2 < ceil2; i2++) {
            i += iArr[i2];
        }
        int i3 = ceil2 - ceil;
        if (i3 == 0) {
            return 0;
        }
        return i / i3;
    }

    public void a(long j) {
        this.a = j;
    }

    public int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public int b(int i, int i2) {
        return i2 - i;
    }

    public long b() {
        return System.currentTimeMillis() + this.a;
    }

    public int[] b(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            throw new IllegalArgumentException("Latency array must contain at least two elements.");
        }
        int[] iArr2 = new int[(iArr.length - 1)];
        for (int i = 1; i < iArr.length; i++) {
            int i2 = i - 1;
            iArr2[i2] = Math.abs(iArr[i] - iArr[i2]);
        }
        return iArr2;
    }

    public int c(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public int d(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            double d = (double) i2;
            double d2 = (double) i;
            Double.isNaN(d2);
            Double.isNaN(d);
            i = (int) (d2 + d);
        }
        return i / iArr.length;
    }

    public int e(int[] iArr) {
        Arrays.sort(iArr);
        int length = iArr.length / 2;
        return iArr.length % 2 == 0 ? (iArr[length - 1] + iArr[length]) / 2 : iArr[length];
    }

    public int f(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    public int g(int[] iArr) {
        Arrays.sort(iArr);
        double length = (double) iArr.length;
        Double.isNaN(length);
        return iArr[((int) Math.ceil(length * 0.1d)) - 1];
    }

    public int h(int[] iArr) {
        Arrays.sort(iArr);
        double length = (double) iArr.length;
        Double.isNaN(length);
        return iArr[((int) Math.ceil(length * 0.9d)) - 1];
    }
}
