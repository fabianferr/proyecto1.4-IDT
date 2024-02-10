package com.startapp.sdk.ads.splash;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.SplashScreen;

/* compiled from: Sta */
public class f implements Runnable {
    public final /* synthetic */ SplashScreen a;

    public f(SplashScreen splashScreen) {
        this.a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.a;
        SplashEventHandler splashEventHandler = splashScreen.b;
        SplashScreen.SplashStartAppAd splashStartAppAd = splashScreen.h;
        if (splashEventHandler.i == SplashEventHandler.SplashState.DISPLAYED && !splashEventHandler.f) {
            splashStartAppAd.close();
            splashEventHandler.i = SplashEventHandler.SplashState.HIDDEN;
            splashEventHandler.b();
        }
    }
}
