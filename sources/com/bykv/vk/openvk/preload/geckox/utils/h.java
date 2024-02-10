package com.bykv.vk.openvk.preload.geckox.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bykv.vk.openvk.preload.geckox.h.b;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: NetUtils */
public final class h {
    public static String a(Context context) {
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "unknow";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return "WIFI";
                    }
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "unknow";
                    }
                }
            }
            return "unknow";
        } catch (Throwable th) {
            b.a("gecko-debug-tag", "getNetworkState:", th);
            return AbstractJsonLexerKt.NULL;
        }
    }
}
