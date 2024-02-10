package com.cellrebel.sdk.youtube.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {
    public static String a(float f) {
        return String.format("%d:%02d", new Object[]{Integer.valueOf((int) (f / 60.0f)), Integer.valueOf((int) (f % 60.0f))});
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
