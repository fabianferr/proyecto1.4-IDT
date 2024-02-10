package com.m2catalyst.m2sdk;

import java.net.URLEncoder;

/* compiled from: Utils */
public final class b7 {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
