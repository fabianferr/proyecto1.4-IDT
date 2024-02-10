package com.teragence.library;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class z1 implements b2 {
    private final Context a;

    public z1(Context context) {
        this.a = context;
    }

    public Map<String, Object> a() {
        a2 a2 = a2.a(((WifiManager) this.a.getApplicationContext().getSystemService("wifi")).getConnectionInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("SSID", a2.d());
        hashMap.put("dbmSignalStrength", a2.c());
        if (Build.VERSION.SDK_INT >= 21) {
            hashMap.put("Frequency", a2.a());
        }
        hashMap.put("Link speed", a2.b());
        return hashMap;
    }
}
