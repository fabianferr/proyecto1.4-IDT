package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.startapp.a0;
import com.startapp.h0;
import com.startapp.i3;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.z7;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class SplashScreen {
    public Activity a;
    public SplashEventHandler b;
    public SplashConfig c;
    public final AtomicReference<CacheKey> d = new AtomicReference<>();
    public SplashHtml e = null;
    public Handler f = new Handler();
    public boolean g = false;
    public SplashStartAppAd h;
    public AdPreferences i;
    public Runnable j = new a();
    public final Runnable k = new b();

    /* compiled from: Sta */
    public static class SplashStartAppAd extends StartAppAd {
        private static final long serialVersionUID = -1792364854785417686L;

        public SplashStartAppAd(Context context) {
            super(context);
            this.placement = AdPreferences.Placement.INAPP_SPLASH;
        }

        public AdRulesResult a(String str, AdPreferences.Placement placement) {
            return new AdRulesResult(true, "");
        }
    }

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            View view;
            boolean z;
            SplashScreen splashScreen = SplashScreen.this;
            if (splashScreen.c.b(splashScreen.a)) {
                if (splashScreen.b()) {
                    view = splashScreen.c.a((Context) splashScreen.a);
                } else {
                    SplashHtml splashHtml = splashScreen.e;
                    view = splashHtml != null ? splashHtml.b() : null;
                }
                if (view != null) {
                    splashScreen.a.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    SplashScreen splashScreen2 = SplashScreen.this;
                    Context a2 = h0.a(splashScreen2.a);
                    if (a2 == null) {
                        a2 = splashScreen2.a;
                    }
                    SplashStartAppAd splashStartAppAd = new SplashStartAppAd(a2);
                    splashScreen2.h = splashStartAppAd;
                    splashStartAppAd.loadSplash(splashScreen2.i, new c(splashScreen2));
                    SplashScreen splashScreen3 = SplashScreen.this;
                    splashScreen3.f.postDelayed(new d(splashScreen3), splashScreen3.c.a().longValue());
                    splashScreen3.f.postDelayed(new e(splashScreen3), splashScreen3.c.getMinSplashTime().getIndex());
                    return;
                }
                SplashScreen.this.a.finish();
                return;
            }
            throw new IllegalArgumentException(splashScreen.c.getErrorMessage());
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {

        /* compiled from: Sta */
        public class a implements z7 {

            /* renamed from: com.startapp.sdk.ads.splash.SplashScreen$b$a$a  reason: collision with other inner class name */
            /* compiled from: Sta */
            public class C0163a implements AdDisplayListener {
                public C0163a() {
                }

                public void adClicked(Ad ad) {
                    SplashScreen.this.b.f = true;
                }

                public void adDisplayed(Ad ad) {
                    SplashScreen.this.b.i = SplashEventHandler.SplashState.DISPLAYED;
                }

                public void adHidden(Ad ad) {
                    SplashEventHandler splashEventHandler = SplashScreen.this.b;
                    splashEventHandler.i = SplashEventHandler.SplashState.HIDDEN;
                    splashEventHandler.b();
                }

                public void adNotDisplayed(Ad ad) {
                }
            }

            public a() {
            }

            public void a() {
                SplashStartAppAd splashStartAppAd;
                SplashScreen splashScreen = SplashScreen.this;
                if (!splashScreen.g && (splashStartAppAd = splashScreen.h) != null) {
                    splashStartAppAd.showAd((AdDisplayListener) new C0163a());
                    SplashScreen splashScreen2 = SplashScreen.this;
                    if (splashScreen2.c.getMaxAdDisplayTime() != SplashConfig.MaxAdDisplayTime.FOR_EVER) {
                        splashScreen2.f.postDelayed(new f(splashScreen2), splashScreen2.c.getMaxAdDisplayTime().getIndex());
                    }
                    SplashScreen.this.a.finish();
                }
            }
        }

        public b() {
        }

        public void run() {
            SplashScreen splashScreen = SplashScreen.this;
            SplashEventHandler splashEventHandler = splashScreen.b;
            SplashHtml splashHtml = splashScreen.e;
            a aVar = new a();
            splashEventHandler.getClass();
            if (splashHtml == null) {
                aVar.a();
                return;
            }
            splashHtml.callback = aVar;
            splashHtml.a();
        }
    }

    /* compiled from: Sta */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.startapp.sdk.ads.splash.SplashConfig$Orientation[] r0 = com.startapp.sdk.ads.splash.SplashConfig.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.startapp.sdk.ads.splash.SplashConfig$Orientation r1 = com.startapp.sdk.ads.splash.SplashConfig.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.startapp.sdk.ads.splash.SplashConfig$Orientation r1 = com.startapp.sdk.ads.splash.SplashConfig.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.splash.SplashScreen.c.<clinit>():void");
        }
    }

    public SplashScreen(Activity activity, SplashConfig splashConfig, AdPreferences adPreferences) {
        this.a = activity;
        this.c = splashConfig;
        this.i = adPreferences;
        try {
            a();
            this.b = new SplashEventHandler(activity, this.e);
        } catch (Throwable th) {
            SplashEventHandler splashEventHandler = new SplashEventHandler(activity);
            this.b = splashEventHandler;
            splashEventHandler.d();
            this.b.a();
            i3.a(th);
        }
    }

    public final void a() {
        SplashConfig splashConfig = this.c;
        Activity activity = this.a;
        if (splashConfig.getLogo() == null && splashConfig.getLogoRes() == -1 && splashConfig.getLogoByteArray() != null) {
            byte[] logoByteArray = splashConfig.getLogoByteArray();
            splashConfig.a = new BitmapDrawable(activity.getResources(), BitmapFactory.decodeByteArray(logoByteArray, 0, logoByteArray.length));
        }
        if (!b()) {
            this.e = this.c.a(this.a);
        }
    }

    public final boolean b() {
        return !this.c.isHtmlSplash() || this.c.b();
    }

    public final boolean c() {
        int i2 = this.a.getResources().getConfiguration().orientation;
        if (this.c.getOrientation() == SplashConfig.Orientation.AUTO) {
            if (i2 == 2) {
                this.c.setOrientation(SplashConfig.Orientation.LANDSCAPE);
            } else {
                this.c.setOrientation(SplashConfig.Orientation.PORTRAIT);
            }
        }
        int i3 = c.a[this.c.getOrientation().ordinal()];
        boolean z = true;
        if (i3 == 1) {
            if (i2 != 2) {
                z = false;
            }
            Activity activity = this.a;
            int i4 = a0.a;
            activity.setRequestedOrientation(7);
        } else if (i3 != 2) {
            return false;
        } else {
            if (i2 != 1) {
                z = false;
            }
            Activity activity2 = this.a;
            int i5 = a0.a;
            try {
                activity2.setRequestedOrientation(6);
            } catch (Throwable unused) {
            }
        }
        return z;
    }
}
