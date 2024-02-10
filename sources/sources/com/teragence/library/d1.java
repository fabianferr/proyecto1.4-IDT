package com.teragence.library;

import android.content.Context;
import android.telephony.TelephonyManager;

public class d1 {
    public static String a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).isNetworkRoaming();
    }
}
