package com.umlaut.crowd.internal;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.umlaut.crowd.utils.PermissionUtils;

public class ud {
    public static v0 a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || (Build.VERSION.SDK_INT > 30 && !PermissionUtils.hasReadPhoneStatePermission(context))) {
            return v0.Unknown;
        }
        int callState = telephonyManager.getCallState();
        if (callState == 0) {
            return v0.Idle;
        }
        if (callState == 1) {
            return v0.Ringing;
        }
        if (callState != 2) {
            return v0.Unknown;
        }
        return v0.Offhook;
    }
}
