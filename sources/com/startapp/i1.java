package com.startapp;

import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.cache.FailuresHandler;
import com.startapp.sdk.adsbase.cache.h;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class i1 extends j1 {
    public final FailuresHandler e = CacheMetaData.b().a().c();
    public int f = 0;
    public boolean g = false;

    public i1(h hVar) {
        super(hVar);
    }

    public boolean a() {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        if (!(startAppSDKInternal.c && !startAppSDKInternal.d && !startAppSDKInternal.f)) {
            return false;
        }
        FailuresHandler failuresHandler = this.e;
        if (!((failuresHandler == null || failuresHandler.a() == null) ? false : true)) {
            return false;
        }
        if (this.g) {
            return this.e.b();
        }
        return true;
    }

    public long b() {
        Long l;
        if (this.f >= this.e.a().size() || (l = this.c) == null) {
            return -1;
        }
        long millis = TimeUnit.SECONDS.toMillis((long) this.e.a().get(this.f).intValue()) - (System.currentTimeMillis() - l.longValue());
        if (millis >= 0) {
            return millis;
        }
        return 0;
    }

    public void c() {
        if (this.f == this.e.a().size() - 1) {
            this.g = true;
        } else {
            this.f++;
        }
        super.c();
    }

    public void f() {
        e();
        this.f = 0;
        this.g = false;
    }
}
