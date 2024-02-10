package com.teragence.library;

import android.content.Context;

public class u0 implements t0 {
    private final Context a;

    public u0(Context context) {
        this.a = context;
    }

    public boolean a() {
        try {
            return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getBoolean("teragenceMobileMeasureOnWiFi", true);
        } catch (Exception unused) {
            return true;
        }
    }
}
