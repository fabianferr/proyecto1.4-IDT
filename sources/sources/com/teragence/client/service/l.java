package com.teragence.client.service;

import android.content.Context;
import android.os.PowerManager;

public class l {
    public static PowerManager.WakeLock a(Context context) {
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "com.teragence:TeragenceMetrics");
        newWakeLock.setReferenceCounted(false);
        newWakeLock.acquire(300000);
        return newWakeLock;
    }
}
