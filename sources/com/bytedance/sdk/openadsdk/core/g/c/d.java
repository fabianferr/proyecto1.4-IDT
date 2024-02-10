package com.bytedance.sdk.openadsdk.core.g.c;

import java.util.Arrays;
import java.util.List;

/* compiled from: VastUtils */
public class d {
    public static final List<String> a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});

    public static double a(int i, double d, int i2, int i3, int i4, String str) {
        double a2 = a(i, d, i2, i3);
        return a(str) * (1.0d / ((a2 + 1.0d) + a(i4)));
    }

    private static double a(int i, double d, int i2, int i3) {
        double d2;
        double d3 = 0.0d;
        if (i3 > 0) {
            double d4 = (double) i2;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            d2 = d4 / d5;
        } else {
            d2 = 0.0d;
        }
        double abs = d > 0.0d ? Math.abs(d - d2) : 0.0d;
        if (i > 0) {
            d3 = (double) Math.abs((i - i2) / i);
        }
        return abs + d3;
    }

    private static double a(int i) {
        int max = Math.max(i, 0);
        if (700 > max || max > 1500) {
            return Math.min((double) (((float) Math.abs(700 - max)) / 700.0f), (double) (((float) Math.abs(1500 - max)) / 1500.0f));
        }
        return 0.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double a(java.lang.String r2) {
        /*
            if (r2 != 0) goto L_0x0004
            java.lang.String r2 = ""
        L_0x0004:
            int r0 = r2.hashCode()
            r1 = -1664118616(0xffffffff9ccf90a8, float:-1.3735504E-21)
            if (r0 == r1) goto L_0x001d
            r1 = 1331848029(0x4f62635d, float:3.79816269E9)
            if (r0 == r1) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            java.lang.String r0 = "video/mp4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0027
            r2 = 0
            goto L_0x0028
        L_0x001d:
            java.lang.String r0 = "video/3gpp"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0027
            r2 = 1
            goto L_0x0028
        L_0x0027:
            r2 = -1
        L_0x0028:
            if (r2 == 0) goto L_0x002d
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            return r0
        L_0x002d:
            r0 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.c.d.a(java.lang.String):double");
    }
}
