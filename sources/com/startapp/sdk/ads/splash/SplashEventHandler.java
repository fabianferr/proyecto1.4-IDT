package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.startapp.h0;
import com.startapp.i3;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.w4;
import com.startapp.z7;
import java.lang.ref.WeakReference;

/* compiled from: Sta */
public class SplashEventHandler {
    public final Context a;
    public final WeakReference<Activity> b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public SplashState i;
    public SplashHtml j;
    public final BroadcastReceiver k;

    /* compiled from: Sta */
    public enum SplashState {
        LOADING,
        RECEIVED,
        DISPLAYED,
        HIDDEN,
        DO_NOT_DISPLAY
    }

    /* compiled from: Sta */
    public class a implements z7 {
        public a() {
        }

        public void a() {
            SplashEventHandler.this.b();
        }
    }

    /* compiled from: Sta */
    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            SplashEventHandler.this.f = true;
        }
    }

    public SplashEventHandler(Activity activity) {
        this.c = false;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = SplashState.LOADING;
        this.j = null;
        this.k = new b();
        this.a = h0.b(activity);
        this.b = new WeakReference<>(activity);
    }

    public void a(Runnable runnable, CacheKey cacheKey) {
        AdRulesResult a2 = AdaptMetaData.a.a().a(AdPreferences.Placement.INAPP_SPLASH, (String) null);
        if (a2.b()) {
            a(runnable);
            return;
        }
        this.i = SplashState.DO_NOT_DISPLAY;
        if (cacheKey != null) {
            com.startapp.sdk.adsbase.a.a(com.startapp.sdk.adsbase.a.a(d.h.a(cacheKey)), (String) null, 0, a2.a());
        }
        c();
    }

    public void b() {
        if (!this.e) {
            this.e = true;
            w4.a(this.a).a(new Intent("com.startapp.android.splashHidden"));
        }
        try {
            w4.a(this.a).a(this.k);
        } catch (Throwable th) {
            i3.a(th);
        }
        Activity activity = (Activity) this.b.get();
        if (activity != null && !activity.isFinishing()) {
            try {
                activity.finish();
            } catch (Throwable th2) {
                i3.a(th2);
            }
        }
    }

    public final void c() {
        SplashHtml splashHtml = this.j;
        a aVar = new a();
        if (splashHtml == null) {
            b();
            return;
        }
        splashHtml.callback = aVar;
        splashHtml.a();
    }

    public void d() {
        this.c = true;
    }

    public void a() {
        this.i = SplashState.DO_NOT_DISPLAY;
        a((Runnable) null);
    }

    public final void a(Runnable runnable) {
        if (!this.c) {
            return;
        }
        if (this.h || runnable == null) {
            SplashState splashState = this.i;
            if (splashState == SplashState.RECEIVED && runnable != null) {
                this.d = false;
                runnable.run();
            } else if (splashState != SplashState.LOADING) {
                c();
            }
        }
    }

    public SplashEventHandler(Activity activity, SplashHtml splashHtml) {
        this(activity);
        this.j = splashHtml;
    }
}
