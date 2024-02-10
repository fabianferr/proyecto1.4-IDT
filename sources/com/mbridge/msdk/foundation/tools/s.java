package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;
import com.mbridge.msdk.foundation.controller.b;

/* compiled from: NetManager */
public final class s {
    private static ConnectivityManager a;

    public static synchronized ConnectivityManager a() {
        ConnectivityManager connectivityManager;
        synchronized (s.class) {
            try {
                if (a == null && b.d().g() != null) {
                    a = (ConnectivityManager) b.d().g().getSystemService("connectivity");
                }
            } catch (Exception e) {
                aa.d("NetManager", e.getMessage());
            }
            connectivityManager = a;
        }
        return connectivityManager;
    }
}
