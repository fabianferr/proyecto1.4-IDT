package com.startapp;

import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.cache.h;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class k1 extends j1 {
    public k1(h hVar) {
        super(hVar);
    }

    public boolean a() {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        return startAppSDKInternal.c && !startAppSDKInternal.f && (!startAppSDKInternal.d || (this.a.a == AdPreferences.Placement.INAPP_RETURN && CacheMetaData.a.a().g()));
    }

    public long b() {
        d dVar = this.a.e;
        if (dVar == null) {
            return -1;
        }
        Long c = dVar.c();
        Long b = dVar.b();
        if (c == null || b == null) {
            return -1;
        }
        long longValue = c.longValue() - (System.currentTimeMillis() - b.longValue());
        if (longValue >= 0) {
            return longValue;
        }
        return 0;
    }
}
