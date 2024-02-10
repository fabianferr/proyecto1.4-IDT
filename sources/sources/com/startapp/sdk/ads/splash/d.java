package com.startapp.sdk.ads.splash;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.cache.CacheKey;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class d implements Runnable {
    public final /* synthetic */ SplashScreen a;

    public d(SplashScreen splashScreen) {
        this.a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.a;
        SplashEventHandler splashEventHandler = splashScreen.b;
        Runnable runnable = splashScreen.k;
        AtomicReference<CacheKey> atomicReference = splashScreen.d;
        boolean z = false;
        if (!splashEventHandler.g) {
            SplashEventHandler.SplashState splashState = splashEventHandler.i;
            if (splashState == SplashEventHandler.SplashState.LOADING) {
                splashEventHandler.d = false;
                splashEventHandler.i = SplashEventHandler.SplashState.DO_NOT_DISPLAY;
                splashEventHandler.c();
                z = true;
            } else if (splashState == SplashEventHandler.SplashState.RECEIVED) {
                splashEventHandler.h = true;
                splashEventHandler.a(runnable, atomicReference.get());
            }
        }
        if (z) {
            SplashScreen splashScreen2 = this.a;
            splashScreen2.h = null;
            splashScreen2.d.set((Object) null);
        }
    }
}
