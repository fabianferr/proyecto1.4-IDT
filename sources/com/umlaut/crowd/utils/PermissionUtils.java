package com.umlaut.crowd.utils;

import android.content.Context;

public class PermissionUtils {
    public static boolean hasAnyLocationPermissionPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean hasReadCallLogPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_CALL_LOG") == 0;
    }
}
