package com.applovin.sdk;

import java.util.Locale;

public class AppLovinAdType {
    public static final AppLovinAdType AUTO_INCENTIVIZED = new AppLovinAdType("AUTOREW");
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType NATIVE = new AppLovinAdType("NATIVE");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");
    private final String a;

    private AppLovinAdType(String str) {
        this.a = str;
    }

    public static AppLovinAdType fromString(String str) {
        if ("REGULAR".equalsIgnoreCase(str)) {
            return REGULAR;
        }
        if ("VIDEOA".equalsIgnoreCase(str)) {
            return INCENTIVIZED;
        }
        if ("AUTOREW".equalsIgnoreCase(str)) {
            return AUTO_INCENTIVIZED;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Type: " + str);
    }

    public String getLabel() {
        return this.a.toUpperCase(Locale.ENGLISH);
    }

    public String toString() {
        return getLabel();
    }
}
