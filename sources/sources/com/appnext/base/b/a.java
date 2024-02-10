package com.appnext.base.b;

import android.content.Context;

public final class a {
    private static Context bQ;

    public static void init(Context context) {
        if (context != null) {
            bQ = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context shouldn't be null");
    }

    public static Context getContext() {
        return bQ;
    }

    public static String getPackageName() {
        return bQ.getPackageName();
    }
}
