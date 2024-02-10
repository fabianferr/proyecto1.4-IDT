package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.AdCallbacksConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

/* compiled from: Sta */
public class d2 {
    public static void a(String str, boolean z, String str2, String str3) {
        try {
            AdCallbacksConfig a = MetaData.k.analytics.a();
            if (a != null) {
                if ((a.a() || z) && a.a(str)) {
                    i3 i3Var = new i3(j3.d);
                    i3Var.d = "adCallback";
                    i3Var.i = str;
                    i3Var.g = str2;
                    i3Var.e = str3;
                    i3Var.a();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
