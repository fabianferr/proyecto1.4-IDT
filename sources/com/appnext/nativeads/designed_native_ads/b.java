package com.appnext.nativeads.designed_native_ads;

import com.appnext.core.Ad;
import com.appnext.core.SettingsManager;

public final class b extends com.appnext.nativeads.b {
    private static b fB;

    public static synchronized b aF() {
        b bVar;
        synchronized (b.class) {
            if (fB == null) {
                fB = new b();
            }
            bVar = fB;
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public final SettingsManager c(Ad ad) {
        return c.aG();
    }
}
