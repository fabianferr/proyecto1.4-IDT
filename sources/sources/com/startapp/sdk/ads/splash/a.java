package com.startapp.sdk.ads.splash;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.cache.CacheKey;

/* compiled from: Sta */
public class a implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ CacheKey b;
    public final /* synthetic */ SplashEventHandler c;

    public a(SplashEventHandler splashEventHandler, Runnable runnable, CacheKey cacheKey) {
        this.c = splashEventHandler;
        this.a = runnable;
        this.b = cacheKey;
    }

    public void run() {
        SplashEventHandler splashEventHandler = this.c;
        splashEventHandler.h = true;
        if (splashEventHandler.i != SplashEventHandler.SplashState.DO_NOT_DISPLAY) {
            splashEventHandler.a(this.a, this.b);
        }
    }
}
