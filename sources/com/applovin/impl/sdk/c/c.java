package com.applovin.impl.sdk.c;

import java.util.Map;

public class c {
    private final String a;
    private Map<String, String> b;

    private c(String str, Map<String, String> map) {
        this.a = str;
        this.b = map;
    }

    public static c a(String str) {
        return a(str, (Map<String, String>) null);
    }

    public static c a(String str, Map<String, String> map) {
        return new c(str, map);
    }

    public Map<String, String> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return "PendingReward{result='" + this.a + "'params='" + this.b + "'}";
    }
}
