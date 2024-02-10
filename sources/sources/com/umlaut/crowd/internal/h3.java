package com.umlaut.crowd.internal;

public class h3 implements s3 {
    private static final String b = "/sys/class/misc/mali0/device/utilization";

    public boolean a() {
        return i9.a(b).length > 0;
    }

    public double b() {
        String[] a = i9.a(b);
        if (a.length != 1) {
            return -1.0d;
        }
        try {
            double parseInt = (double) Integer.parseInt(a[0]);
            Double.isNaN(parseInt);
            return parseInt / 100.0d;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public int c() {
        return -1;
    }

    public int d() {
        return -1;
    }
}
