package com.teragence.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.teragence.client.i;

public class b1 {
    public static double a(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 <= 0.0d) {
                return -1.0d;
            }
            double d = (double) intExtra;
            Double.isNaN(d);
            Double.isNaN(intExtra2);
            return d / intExtra2;
        } catch (Exception e) {
            i.a("DeviceUtils", "Cannot capture battery level", e);
            return -1.0d;
        }
    }

    public static boolean b(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
            return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            i.a("DeviceUtils", "Cannot capture screen state", e);
            return false;
        } catch (Throwable th) {
            i.b("DeviceUtils", "Cannot capture screen state, error: " + th.getMessage());
            return false;
        }
    }
}
