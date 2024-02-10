package com.startapp.sdk.ads.splash;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.c;
import com.startapp.y7;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class e implements Runnable {
    public final /* synthetic */ SplashScreen a;

    public e(SplashScreen splashScreen) {
        this.a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.a;
        SplashEventHandler splashEventHandler = splashScreen.b;
        Runnable runnable = splashScreen.k;
        AtomicReference<CacheKey> atomicReference = splashScreen.d;
        splashEventHandler.c = true;
        if (splashEventHandler.i != SplashEventHandler.SplashState.DO_NOT_DISPLAY) {
            y7 y7Var = new y7(splashEventHandler, runnable, atomicReference);
            Object obj = MetaData.d;
            synchronized (MetaData.d) {
                if (MetaData.k.b) {
                    y7Var.a((MetaDataRequest.RequestReason) null, false);
                } else {
                    MetaData.k.a((c) y7Var);
                }
            }
            return;
        }
        splashEventHandler.c();
    }
}
