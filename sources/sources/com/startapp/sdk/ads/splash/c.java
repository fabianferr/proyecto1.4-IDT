package com.startapp.sdk.ads.splash;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.d;

/* compiled from: Sta */
public class c implements d.C0000d {
    public final /* synthetic */ SplashScreen a;

    public c(SplashScreen splashScreen) {
        this.a = splashScreen;
    }

    public void a(Ad ad, CacheKey cacheKey, boolean z) {
        this.a.d.set(cacheKey);
        if (z) {
            SplashScreen splashScreen = this.a;
            SplashEventHandler splashEventHandler = splashScreen.b;
            Runnable runnable = splashScreen.k;
            if (splashEventHandler.i == SplashEventHandler.SplashState.LOADING) {
                splashEventHandler.i = SplashEventHandler.SplashState.RECEIVED;
            }
            splashEventHandler.a(runnable);
            return;
        }
        SplashScreen splashScreen2 = this.a;
        if (splashScreen2.h != null) {
            SplashEventHandler splashEventHandler2 = splashScreen2.b;
            splashEventHandler2.i = SplashEventHandler.SplashState.DO_NOT_DISPLAY;
            splashEventHandler2.a((Runnable) null);
        }
    }
}
