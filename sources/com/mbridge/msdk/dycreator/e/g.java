package com.mbridge.msdk.dycreator.e;

import android.util.Log;

/* compiled from: Logger */
public final class g {
    public static boolean a = false;

    public static void a(String str) {
        if (a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
