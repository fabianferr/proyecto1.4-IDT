package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.work.WorkManager;

public class f {
    private static final String a = "f";

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            int i = Build.VERSION.SDK_INT;
            e.printStackTrace();
            return i;
        }
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 26 || a(context) < 26;
    }

    public static boolean c(Context context) {
        try {
            WorkManager.getInstance(context);
            return true;
        } catch (Error unused) {
            Log.i(a, "WorkManager not supported");
            return false;
        } catch (Exception unused2) {
            Log.i(a, "WorkManager not supported");
            return false;
        }
    }

    public static boolean a(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                Class.forName(strArr[i]);
                i++;
            } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                return false;
            }
        }
        return true;
    }
}
