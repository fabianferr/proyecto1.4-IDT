package com.umlaut.crowd.internal;

public enum qe {
    WiFi_11ac,
    WiFi_11ax,
    WiFi_11n,
    Legacy,
    Unknown;

    public static qe getWifiStandard(int i) {
        if (i == 1) {
            return Legacy;
        }
        if (i == 4) {
            return WiFi_11n;
        }
        if (i == 5) {
            return WiFi_11ac;
        }
        if (i != 6) {
            return Unknown;
        }
        return WiFi_11ax;
    }
}
