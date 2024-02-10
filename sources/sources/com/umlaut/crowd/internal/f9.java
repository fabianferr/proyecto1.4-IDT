package com.umlaut.crowd.internal;

import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class f9 {
    private static final String a = "f9";

    public static String d(String str) {
        return (str == null || str.length() <= 2) ? "" : str.substring(0, 3);
    }

    public static String a(String str) {
        if (str != null && str.contains("cloudfront")) {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                return d(split[1]);
            }
        }
        return "";
    }

    public static String c(String str) {
        try {
            return InetAddress.getByName(str).getCanonicalHostName();
        } catch (UnknownHostException e) {
            String str2 = a;
            Log.d(str2, "getRDNS: " + e.toString());
            return "";
        }
    }

    public static String b(String str) {
        String str2;
        try {
            str2 = InetAddress.getByName(str).getCanonicalHostName();
        } catch (UnknownHostException e) {
            String str3 = a;
            Log.d(str3, "serverResult: " + e.toString());
            str2 = null;
        }
        if (str2 != null && !str2.equals(str) && str2.contains("cloudfront")) {
            String[] split = str2.split("\\.");
            if (split.length > 0) {
                return d(split[1]);
            }
        }
        return "";
    }
}
