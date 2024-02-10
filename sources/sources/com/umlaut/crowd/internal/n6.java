package com.umlaut.crowd.internal;

import android.net.NetworkCapabilities;

public class n6 {
    public static boolean a(NetworkCapabilities networkCapabilities) {
        return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    public static String a() {
        String[] a = i9.a("/sys/class/net/eth0/address");
        return a.length >= 1 ? a[0].trim() : "";
    }
}
