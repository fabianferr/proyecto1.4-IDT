package com.umlaut.crowd.internal;

public class i3 implements s3 {
    private static final String b = "/sys/class/kgsl/kgsl-3d0/gpuclk";
    private static final String c = "/sys/class/kgsl/kgsl-3d0/max_gpuclk";
    private static final String d = "/sys/class/kgsl/kgsl-3d0/gpubusy";

    public boolean a() {
        return i9.a(b).length > 0;
    }

    public double b() {
        String[] a = i9.a(d);
        if (a.length == 0) {
            return -1.0d;
        }
        int i = 0;
        String[] split = a[0].split(" ");
        try {
            int parseInt = Integer.parseInt(split[split.length - 1]);
            if (parseInt == 0) {
                return 0.0d;
            }
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    break;
                }
                i2++;
            }
            double d2 = (double) i;
            double d3 = (double) parseInt;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public int c() {
        try {
            return Integer.parseInt(i9.a(c)[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public int d() {
        try {
            return Integer.parseInt(i9.a(b)[0]);
        } catch (Exception unused) {
            return -1;
        }
    }
}
