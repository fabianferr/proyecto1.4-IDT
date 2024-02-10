package com.umlaut.crowd.internal;

import android.util.Log;

public class d1 {
    private static final String a = "d1";
    private static final String b = "/proc/net/tcp";
    private static final String c = "/proc/net/tcp6";
    private static final String d = "/proc/net/udp";
    private static final String e = "/proc/net/udp6";
    private static final String f = "0A";
    private static final String g = "07";
    private static final int h = 1;
    private static final int i = 0;

    public static int[] a(int i2) {
        return a(i2, 1);
    }

    public static int[] b(int i2) {
        return a(i2, 0);
    }

    private static int[] a(int i2, int i3) {
        String str;
        String str2;
        int[] iArr = {0, 0};
        if (i3 == 1) {
            str2 = b;
            str = c;
        } else {
            str2 = d;
            str = e;
        }
        try {
            String str3 = i2 + "";
            String[] a2 = i9.a(str);
            char c2 = 3;
            char c3 = 7;
            if (a2.length > 1) {
                int i4 = 1;
                while (i4 < a2.length) {
                    String[] split = a2[i4].trim().split(" +");
                    if (split.length >= 8) {
                        if (split[c3].equals(str3)) {
                            String str4 = split[c2];
                            if (!str4.toLowerCase().equals(f.toLowerCase())) {
                                if (!str4.toLowerCase().equals(g.toLowerCase())) {
                                    String str5 = split[2];
                                    if (str5.startsWith("0000000000000000FFFF0000")) {
                                        if (!str5.regionMatches(true, 30, "7F", 0, 2)) {
                                            iArr[0] = iArr[0] + 1;
                                        }
                                    } else if (!str5.startsWith("00000000000000000000000001")) {
                                        if (!str5.regionMatches(true, 4, "80FE", 0, 4)) {
                                            iArr[1] = iArr[1] + 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4++;
                    c2 = 3;
                    c3 = 7;
                }
            }
            String[] a3 = i9.a(str2);
            if (a3.length > 1) {
                for (int i5 = 1; i5 < a3.length; i5++) {
                    String[] split2 = a3[i5].trim().replaceAll(" +", " ").split(" ");
                    if (split2.length >= 8) {
                        if (split2[7].equals(str3)) {
                            String str6 = split2[3];
                            if (!str6.toLowerCase().equals(f.toLowerCase())) {
                                if (!str6.toLowerCase().equals(g.toLowerCase())) {
                                    if (!split2[2].regionMatches(true, 6, "7F", 0, 2)) {
                                        iArr[0] = iArr[0] + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return iArr;
        } catch (Exception e2) {
            Log.e(a, "getActiveTCPConnectionsForUid: " + e2.getMessage(), e2);
            return null;
        }
    }
}
