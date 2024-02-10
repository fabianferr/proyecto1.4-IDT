package com.teragence.library;

import android.net.wifi.WifiInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a2 {
    private static final Pattern b = Pattern.compile("^\"(.*)\"$");
    private final WifiInfo a;

    private a2(WifiInfo wifiInfo) {
        this.a = wifiInfo;
    }

    static a2 a(WifiInfo wifiInfo) {
        return new a2(wifiInfo);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return String.valueOf(this.a.getFrequency()) + "MHz";
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return String.valueOf(this.a.getLinkSpeed()) + "Mbps";
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return String.valueOf(this.a.getRssi());
    }

    /* access modifiers changed from: package-private */
    public String d() {
        String ssid = this.a.getSSID();
        Matcher matcher = b.matcher(ssid);
        return matcher.find() ? matcher.group(1) : ssid;
    }
}
