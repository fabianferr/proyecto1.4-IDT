package com.applovin.impl.sdk.e;

import java.util.Map;

public class a {
    private final String a;
    private final String b;
    private final Map<String, String> c;
    private final boolean d;

    public a(String str, String str2) {
        this(str, str2, (Map<String, String>) null, false);
    }

    public a(String str, String str2, Map<String, String> map, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.a + "', backupUrl='" + this.b + "', headers='" + this.c + "', shouldFireInWebView='" + this.d + "'}";
    }
}
