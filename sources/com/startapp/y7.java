package com.startapp;

import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.a;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.c;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class y7 implements c {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ SplashEventHandler c;

    public y7(SplashEventHandler splashEventHandler, Runnable runnable, AtomicReference atomicReference) {
        this.c = splashEventHandler;
        this.a = runnable;
        this.b = atomicReference;
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z) {
        SplashEventHandler splashEventHandler = this.c;
        splashEventHandler.getClass();
        new Handler(Looper.getMainLooper()).post(new a(splashEventHandler, this.a, (CacheKey) this.b.get()));
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
        SplashEventHandler splashEventHandler = this.c;
        splashEventHandler.getClass();
        new Handler(Looper.getMainLooper()).post(new a(splashEventHandler, this.a, (CacheKey) this.b.get()));
    }
}
