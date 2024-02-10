package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.startapp.a0;
import com.startapp.b0;
import com.startapp.e0;
import com.startapp.f0;
import com.startapp.f2;
import com.startapp.g0;
import com.startapp.g6;
import com.startapp.h0;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.m6;
import com.startapp.n3;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.splash.SplashMetaData;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.components.x;
import com.startapp.t;
import com.startapp.t7;
import com.startapp.v1;
import com.startapp.z4;
import com.startapp.z8;
import java.lang.Thread;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Sta */
public class StartAppSDKInternal implements g0 {
    public static final Object E = new Object();
    public static volatile InitState F = InitState.UNSET;
    public d A = null;
    public f0 B;
    public z8 C;
    public boolean D;
    public SDKAdPreferences a;
    public boolean b = true;
    public final boolean c = a0.a();
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public long g;
    public Application h;
    public HashMap<Integer, Integer> i = new HashMap<>();
    public Object j;
    public final AtomicBoolean k = new AtomicBoolean();
    public Activity l;
    public boolean m = false;
    public boolean n = true;
    public boolean o = false;
    public boolean p = false;
    public Map<String, String> q;
    public Bundle r = null;
    public AdPreferences s;
    public CacheKey t;
    public boolean u;
    public boolean v;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    /* compiled from: Sta */
    public static class d {
        public static final StartAppSDKInternal a = new StartAppSDKInternal();
    }

    /* compiled from: Sta */
    public enum InitState {
        UNSET,
        IMPLICIT,
        EXPLICIT
    }

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ SDKAdPreferences d;
        public final /* synthetic */ boolean e;

        public a(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = sDKAdPreferences;
            this.e = z;
        }

        public void run() {
            Object obj = StartAppSDKInternal.E;
            synchronized (StartAppSDKInternal.E) {
                StartAppSDKInternal.a(StartAppSDKInternal.this, this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* compiled from: Sta */
    public class c implements d.C0000d {
        public c() {
        }

        public void a(Ad ad, CacheKey cacheKey, boolean z) {
            StartAppSDKInternal.this.t = cacheKey;
        }
    }

    public StartAppSDKInternal() {
        Map<Activity, Integer> map = k9.a;
    }

    public static void a(StartAppSDKInternal startAppSDKInternal, Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z2) {
        startAppSDKInternal.getClass();
        com.startapp.sdk.adsbase.crashreport.b a2 = ComponentLocator.a(context).I.a();
        InitState initState = F;
        InitState initState2 = InitState.EXPLICIT;
        if (initState != initState2) {
            boolean a3 = ComponentLocator.a(context).c().a();
            if (TextUtils.isEmpty(str2)) {
                if (k9.f(context) || a0.c(context)) {
                    throw new IllegalArgumentException("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n|   https://support.start.io/hc/en-us/articles/360014774799   |\n+-------------------------------------------------------------+\n");
                }
                Log.w("StartAppSDK", new IllegalArgumentException("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n|   https://support.start.io/hc/en-us/articles/360014774799   |\n+-------------------------------------------------------------+\n"));
            }
            b0 c2 = ComponentLocator.a(context).c();
            if (str != null) {
                str = str.trim();
            }
            if (str2 != null) {
                str2 = str2.trim();
            }
            synchronized (c2.a) {
                c2.c = str;
                c2.d = str2;
                c2.b.edit().putString("c88d4eab540fab77", str).putString("2696a7f502faed4b", str2).commit();
            }
            startAppSDKInternal.a = sDKAdPreferences;
            f2.b(context, "shared_prefs_sdk_ad_prefs", sDKAdPreferences);
            startAppSDKInternal.a(z2);
            if (F == InitState.IMPLICIT && !a3) {
                startAppSDKInternal.b(context, MetaDataRequest.RequestReason.LAUNCH);
            } else if (F == InitState.UNSET) {
                startAppSDKInternal.a(context, MetaDataRequest.RequestReason.LAUNCH);
            }
            F = initState2;
        }
    }

    public static boolean c() {
        boolean z2;
        synchronized (E) {
            z2 = F == InitState.EXPLICIT;
        }
        return z2;
    }

    public static void h(Context context) {
        if (context != null) {
            a(false, (g6) null);
        }
    }

    public boolean b() {
        return this.p;
    }

    public final boolean e(Context context) {
        e k2 = ComponentLocator.a(context).k();
        if (k2.contains("isma")) {
            if (k2.getBoolean("isma", false)) {
                if (!k2.contains("iscd") || k2.getBoolean("iscd", false)) {
                    return false;
                }
                return true;
            } else if (!k2.contains("iscd") || !k2.getBoolean("iscd", false)) {
                return true;
            } else {
                return false;
            }
        } else if (k2.contains("iscd")) {
            return !k2.getBoolean("iscd", false);
        } else {
            return true;
        }
    }

    public final void f(Context context) {
        if (this.u && !AdsCommonMetaData.h.K()) {
            com.startapp.sdk.adsbase.cache.d dVar = com.startapp.sdk.adsbase.cache.d.h;
            AdPreferences adPreferences = this.s;
            AdPreferences adPreferences2 = adPreferences != null ? new AdPreferences(adPreferences) : new AdPreferences();
            c cVar = new c();
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
            if (dVar.a(placement)) {
                dVar.a(context, (StartAppAd) null, placement, adPreferences2, cVar, false, 0);
            } else {
                cVar.a((Ad) null, (CacheKey) null, false);
            }
        }
    }

    public final void g(Context context) {
        if (a0.a() && (context instanceof Application)) {
            Application application = (Application) context;
            this.h = application;
            if (this.k.compareAndSet(false, true) && this.j == null) {
                g gVar = new g();
                application.registerActivityLifecycleCallbacks(gVar);
                this.j = gVar;
            }
        }
    }

    public final void i(Context context) {
        e e2 = ComponentLocator.a(context).e();
        int i2 = e2.getInt("shared_prefs_app_version_id", -1);
        int i3 = a0.a;
        int i4 = 0;
        try {
            i4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
        }
        if (i2 > 0 && i4 > i2) {
            this.p = true;
        }
        e.a a2 = e2.edit();
        a2.a("shared_prefs_app_version_id", Integer.valueOf(i4));
        a2.a.putInt("shared_prefs_app_version_id", i4);
        a2.apply();
    }

    public final void j(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        e.a a3 = a2.e().edit();
        Boolean bool = Boolean.FALSE;
        a3.a("periodicInfoEventPaused", bool);
        a3.a.putBoolean("periodicInfoEventPaused", false);
        a3.a("periodicMetadataPaused", bool);
        a3.a.putBoolean("periodicMetadataPaused", false);
        a3.apply();
        b bVar = new b(context, a2);
        if (MetaData.k.b) {
            bVar.a((MetaDataRequest.RequestReason) null, false);
        } else {
            MetaData.k.a((com.startapp.sdk.adsbase.remoteconfig.c) bVar);
        }
    }

    public void b(Context context, MetaDataRequest.RequestReason requestReason) {
        t7 t7Var = t7.d;
        t7.d.a(context, requestReason);
    }

    public final void d(Context context) {
        Application application;
        Context a2 = h0.a(context);
        if (a2 instanceof Application) {
            application = (Application) a2;
        } else if (context instanceof Application) {
            application = (Application) context;
        } else if (context instanceof Activity) {
            application = ((Activity) context).getApplication();
        } else {
            application = context instanceof Service ? ((Service) context).getApplication() : null;
        }
        if (application != null && this.B == null) {
            f0 f0Var = new f0(this);
            this.B = f0Var;
            application.registerActivityLifecycleCallbacks(f0Var);
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = ComponentLocator.a(context).t().e;
                if (activityLifecycleCallbacks != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    return;
                }
                throw new RuntimeException();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        if (r9.contains(r0) != false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e5, code lost:
        if (r0.isEmpty() == false) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "com.android.chrome"
            java.lang.String r1 = "android.support.customtabs.action.CustomTabsService"
            r2 = 1
            r3 = 0
            r4 = 0
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ all -> 0x00c8 }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00c8 }
            java.lang.String r7 = "android.intent.action.VIEW"
            java.lang.String r8 = "http://www.example.com"
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x00c8 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00c8 }
            android.content.pm.ResolveInfo r7 = r5.resolveActivity(r6, r3)     // Catch:{ all -> 0x00c8 }
            if (r7 == 0) goto L_0x0023
            android.content.pm.ActivityInfo r7 = r7.activityInfo     // Catch:{ all -> 0x00c8 }
            java.lang.String r7 = r7.packageName     // Catch:{ all -> 0x00c8 }
            goto L_0x0024
        L_0x0023:
            r7 = r4
        L_0x0024:
            java.util.List r8 = r5.queryIntentActivities(r6, r3)     // Catch:{ all -> 0x00c8 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00c8 }
            r9.<init>()     // Catch:{ all -> 0x00c8 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00c8 }
        L_0x0031:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x00c8 }
            if (r10 == 0) goto L_0x005a
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x00c8 }
            android.content.pm.ResolveInfo r10 = (android.content.pm.ResolveInfo) r10     // Catch:{ all -> 0x00c8 }
            android.content.Intent r11 = new android.content.Intent     // Catch:{ all -> 0x00c8 }
            r11.<init>()     // Catch:{ all -> 0x00c8 }
            r11.setAction(r1)     // Catch:{ all -> 0x00c8 }
            android.content.pm.ActivityInfo r12 = r10.activityInfo     // Catch:{ all -> 0x00c8 }
            java.lang.String r12 = r12.packageName     // Catch:{ all -> 0x00c8 }
            r11.setPackage(r12)     // Catch:{ all -> 0x00c8 }
            android.content.pm.ResolveInfo r11 = r5.resolveService(r11, r3)     // Catch:{ all -> 0x00c8 }
            if (r11 == 0) goto L_0x0031
            android.content.pm.ActivityInfo r10 = r10.activityInfo     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = r10.packageName     // Catch:{ all -> 0x00c8 }
            r9.add(r10)     // Catch:{ all -> 0x00c8 }
            goto L_0x0031
        L_0x005a:
            boolean r5 = r9.isEmpty()     // Catch:{ all -> 0x00c8 }
            if (r5 == 0) goto L_0x0062
            goto L_0x00cc
        L_0x0062:
            int r5 = r9.size()     // Catch:{ all -> 0x00c8 }
            if (r5 != r2) goto L_0x006f
            java.lang.Object r0 = r9.get(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00c8 }
            goto L_0x00c6
        L_0x006f:
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00c8 }
            if (r5 != 0) goto L_0x00c0
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ all -> 0x00b1 }
            r8 = 64
            java.util.List r5 = r5.queryIntentActivities(r6, r8)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x00b5
            int r6 = r5.size()     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x0088
            goto L_0x00b5
        L_0x0088:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00b1 }
        L_0x008c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00b1 }
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6     // Catch:{ all -> 0x00b1 }
            android.content.IntentFilter r8 = r6.filter     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x009d
            goto L_0x008c
        L_0x009d:
            int r10 = r8.countDataAuthorities()     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x008c
            int r8 = r8.countDataPaths()     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x00aa
            goto L_0x008c
        L_0x00aa:
            android.content.pm.ActivityInfo r6 = r6.activityInfo     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x00af
            goto L_0x008c
        L_0x00af:
            r5 = 1
            goto L_0x00b6
        L_0x00b1:
            r5 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x00c8 }
        L_0x00b5:
            r5 = 0
        L_0x00b6:
            if (r5 != 0) goto L_0x00c0
            boolean r5 = r9.contains(r7)     // Catch:{ all -> 0x00c8 }
            if (r5 == 0) goto L_0x00c0
            r4 = r7
            goto L_0x00cc
        L_0x00c0:
            boolean r5 = r9.contains(r0)     // Catch:{ all -> 0x00c8 }
            if (r5 == 0) goto L_0x00cc
        L_0x00c6:
            r4 = r0
            goto L_0x00cc
        L_0x00c8:
            r0 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x00cc:
            if (r4 != 0) goto L_0x00cf
            goto L_0x00e8
        L_0x00cf:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r1)
            r0.setPackage(r4)
            android.content.pm.PackageManager r1 = r14.getPackageManager()
            java.util.List r0 = r1.queryIntentServices(r0, r3)
            if (r0 == 0) goto L_0x00e8
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r2 = 0
        L_0x00e9:
            com.startapp.sdk.components.ComponentLocator r14 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r14)
            com.startapp.sdk.adsbase.e r14 = r14.e()
            com.startapp.sdk.adsbase.e$a r14 = r14.edit()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            java.lang.String r1 = "chromeTabs"
            r14.a((java.lang.String) r1, r0)
            android.content.SharedPreferences$Editor r0 = r14.a
            r0.putBoolean(r1, r2)
            r14.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppSDKInternal.b(android.content.Context):void");
    }

    public SDKAdPreferences c(Context context) {
        if (this.a == null) {
            SDKAdPreferences sDKAdPreferences = (SDKAdPreferences) f2.a(context, "shared_prefs_sdk_ad_prefs", SDKAdPreferences.class);
            if (sDKAdPreferences == null) {
                this.a = new SDKAdPreferences();
            } else {
                this.a = sDKAdPreferences;
            }
        }
        return this.a;
    }

    public boolean d() {
        return this.n;
    }

    public void a(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z2) {
        Context a2 = h0.a(context);
        Context context2 = a2 != null ? a2 : context;
        g(context2);
        try {
            ComponentLocator.a(context2).t().a(256);
        } catch (Throwable unused) {
        }
        ComponentLocator.a(context2).h().execute(new a(context2, str, str2, sDKAdPreferences, z2));
    }

    public static StartAppSDKInternal a() {
        return d.a;
    }

    public static void a(Context context) {
        MetaDataRequest.RequestReason requestReason;
        ComponentLocator a2 = ComponentLocator.a(context);
        com.startapp.sdk.adsbase.crashreport.b a3 = a2.I.a();
        e0 d2 = a2.d();
        ((x) d2.a).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d2.d = elapsedRealtime;
        d2.e = elapsedRealtime;
        z4 z4Var = new z4(context);
        if (!(z4Var.d == null && z4Var.e == null)) {
            e.a a4 = a2.k().edit();
            Boolean bool = z4Var.d;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                a4.a("isma", Boolean.valueOf(booleanValue));
                a4.a.putBoolean("isma", booleanValue);
            }
            Boolean bool2 = z4Var.e;
            if (bool2 != null) {
                boolean booleanValue2 = bool2.booleanValue();
                a4.a("iscd", Boolean.valueOf(booleanValue2));
                a4.a.putBoolean("iscd", booleanValue2);
            }
            a4.apply();
        }
        String str = z4Var.a;
        if (!TextUtils.isEmpty(str)) {
            d.a.a(context, (String) null, str, (SDKAdPreferences) null, z4Var.b);
            if (!z4Var.c) {
                StartAppAd.disableSplash();
            }
            if (a2.e().getBoolean("shared_prefs_first_init", true)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "ManifestInit";
                i3Var.a();
            }
        } else if (F == InitState.UNSET) {
            F = InitState.IMPLICIT;
            b0 c2 = a2.c();
            StartAppSDKInternal startAppSDKInternal = d.a;
            if (c2.a()) {
                requestReason = MetaDataRequest.RequestReason.LAUNCH;
            } else {
                requestReason = MetaDataRequest.RequestReason.IMPLICIT_LAUNCH;
            }
            startAppSDKInternal.a(context, requestReason);
        }
    }

    public final void a(Context context, MetaDataRequest.RequestReason requestReason) {
        ComponentLocator a2;
        if (Math.random() < 0.0d) {
            Log.i("StartAppSDK", "!SDK-VERSION-STRING!:com.startapp.startappsdk:inapp-sdk:4.11.0");
        }
        try {
            a2 = ComponentLocator.a(context);
            t a3 = a2.G.a();
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof t)) {
                Thread.setDefaultUncaughtExceptionHandler(a3);
                a3.a = defaultUncaughtExceptionHandler;
            }
        } catch (Throwable th) {
            i3.a(th);
            return;
        }
        a2.n().a();
        if (!a0.a(context, "android.permission.INTERNET") || !a0.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            k9.a(context, 6, "Please grant the mandatory permissions : INTERNET & ACCESS_NETWORK_STATE, SDK could not be initialized.", true);
        }
        this.n = !k9.d(context);
        a2.a().a(e(context));
        a2.x().c();
        d(context);
        MetaData.c(context);
        Map<Activity, Integer> map = k9.a;
        AdsCommonMetaData.a(context);
        BannerMetaData.a(context);
        SplashMetaData.a(context);
        if (this.b) {
            CacheMetaData.a(context);
        }
        AdInformationMetaData.a(context);
        SimpleTokenUtils.c(context);
        MetaData.k.a((com.startapp.sdk.adsbase.remoteconfig.c) a2.g());
        v1.a = new CookieManager(new m6(context), CookiePolicy.ACCEPT_ALL);
        i(context);
        b(context, requestReason);
        b(context);
        j(context);
        k9.a(context, 4, "StartApp SDK initialized", true);
    }

    public static void a(boolean z2, g6 g6Var) {
        i3 i3Var = new i3(j3.j);
        i3Var.j = z2;
        try {
            ComponentLocator componentLocator = (ComponentLocator) ComponentLocator.N.a;
            if (componentLocator != null) {
                componentLocator.n().a(i3Var, (n3) null);
            } else if (g6Var != null) {
                g6Var.a(false);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(Activity activity) {
        return this.z || activity.getClass().getName().equals(k9.c((Context) activity));
    }

    public boolean a(String str) {
        String str2;
        Map<String, String> map = this.q;
        if (map == null) {
            str2 = null;
        } else {
            str2 = map.get(str);
        }
        return str2 != null;
    }

    public void a(boolean z2) {
        if (!z2 || !a0.a()) {
            this.u = false;
            com.startapp.sdk.adsbase.cache.d.h.b(AdPreferences.Placement.INAPP_RETURN);
            return;
        }
        this.u = true;
    }

    /* compiled from: Sta */
    public class b implements com.startapp.sdk.adsbase.remoteconfig.c {
        public final /* synthetic */ Context a;
        public final /* synthetic */ ComponentLocator b;

        public b(Context context, ComponentLocator componentLocator) {
            this.a = context;
            this.b = componentLocator;
        }

        /* JADX WARNING: Removed duplicated region for block: B:121:0x038f  */
        /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest.RequestReason r19, boolean r20) {
            /*
                r18 = this;
                r1 = r18
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                android.content.Context r8 = r1.a
                boolean r2 = r0.b
                r9 = 0
                r10 = 1
                if (r2 != 0) goto L_0x000e
                goto L_0x0128
            L_0x000e:
                boolean r2 = r0.p
                if (r2 != 0) goto L_0x005f
                com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.a
                com.startapp.sdk.adsbase.cache.ACMConfig r2 = r2.a()
                boolean r2 = r2.f()
                if (r2 != 0) goto L_0x001f
                goto L_0x005f
            L_0x001f:
                boolean r2 = r0.c
                if (r2 == 0) goto L_0x0078
                com.startapp.sdk.adsbase.cache.d r2 = com.startapp.sdk.adsbase.cache.d.h
                r2.getClass()
                android.content.Context r3 = com.startapp.h0.a(r8)
                if (r3 == 0) goto L_0x002f
                goto L_0x0030
            L_0x002f:
                r3 = r8
            L_0x0030:
                r2.g = r3
                boolean r4 = r2.c
                if (r4 != 0) goto L_0x0044
                com.startapp.sdk.adsbase.cache.CacheMetaData r4 = com.startapp.sdk.adsbase.cache.CacheMetaData.a
                com.startapp.sdk.adsbase.cache.ACMConfig r4 = r4.a()
                boolean r4 = r4.f()
                if (r4 == 0) goto L_0x0044
                r4 = 1
                goto L_0x0045
            L_0x0044:
                r4 = 0
            L_0x0045:
                if (r4 == 0) goto L_0x0078
                r2.d = r10
                com.startapp.sdk.adsbase.cache.a r4 = new com.startapp.sdk.adsbase.cache.a
                r4.<init>(r2, r3)
                com.startapp.sdk.components.ComponentLocator r2 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r3)
                java.util.concurrent.Executor r2 = r2.j()
                com.startapp.sdk.adsbase.cache.j r5 = new com.startapp.sdk.adsbase.cache.j
                r5.<init>(r3, r4)
                r2.execute(r5)
                goto L_0x0078
            L_0x005f:
                com.startapp.sdk.adsbase.cache.d r2 = com.startapp.sdk.adsbase.cache.d.h
                r2.c = r10
                com.startapp.sdk.adsbase.cache.b r3 = new com.startapp.sdk.adsbase.cache.b
                r3.<init>(r2)
                com.startapp.sdk.components.ComponentLocator r2 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r8)
                java.util.concurrent.Executor r2 = r2.j()
                com.startapp.sdk.adsbase.cache.i r4 = new com.startapp.sdk.adsbase.cache.i
                r4.<init>(r8, r3)
                r2.execute(r4)
            L_0x0078:
                r0.f(r8)
                if (r20 == 0) goto L_0x0128
                com.startapp.sdk.adsbase.cache.d r0 = com.startapp.sdk.adsbase.cache.d.h
                r0.getClass()
                com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.a
                com.startapp.sdk.adsbase.cache.ACMConfig r2 = r2.a()
                if (r2 == 0) goto L_0x0128
                java.util.Set r2 = r2.b()
                if (r2 == 0) goto L_0x009e
                int r3 = r2.size()
                if (r3 <= 0) goto L_0x009e
                boolean r3 = com.startapp.sdk.adsbase.cache.CacheMetaData.d()
                if (r3 == 0) goto L_0x009e
                r3 = 1
                goto L_0x009f
            L_0x009e:
                r3 = 0
            L_0x009f:
                if (r3 == 0) goto L_0x0128
                com.startapp.sdk.components.ComponentLocator r3 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r8)
                com.startapp.sdk.adsbase.e r11 = r3.e()
                com.startapp.sdk.adsbase.remoteconfig.MetaData r3 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                int r12 = r3.N()
                com.startapp.sdk.adsbase.AdsCommonMetaData r3 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
                int r13 = r3.i()
                java.util.Iterator r14 = r2.iterator()
            L_0x00b9:
                boolean r2 = r14.hasNext()
                if (r2 == 0) goto L_0x0128
                java.lang.Object r2 = r14.next()
                r5 = r2
                com.startapp.sdk.adsbase.StartAppAd$AdMode r5 = (com.startapp.sdk.adsbase.StartAppAd.AdMode) r5
                if (r5 != 0) goto L_0x00c9
                goto L_0x00b9
            L_0x00c9:
                java.lang.String r15 = com.startapp.sdk.adsbase.cache.d.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r5)
                int r7 = r11.getInt(r15, r9)
                if (r7 < r12) goto L_0x00d4
                goto L_0x00b9
            L_0x00d4:
                com.startapp.sdk.adsbase.StartAppAd$AdMode r6 = com.startapp.sdk.adsbase.StartAppAd.AdMode.FULLPAGE
                if (r5 != r6) goto L_0x00f2
                if (r13 <= 0) goto L_0x00ef
                com.startapp.sdk.adsbase.model.AdPreferences r16 = new com.startapp.sdk.adsbase.model.AdPreferences
                r16.<init>()
                r4 = 0
                r17 = 0
                r2 = r0
                r3 = r8
                r5 = r6
                r6 = r16
                r16 = r7
                r7 = r17
                r2.a((android.content.Context) r3, (com.startapp.sdk.adsbase.StartAppAd) r4, (com.startapp.sdk.adsbase.StartAppAd.AdMode) r5, (com.startapp.sdk.adsbase.model.AdPreferences) r6, (com.startapp.sdk.adsbase.cache.d.C0000d) r7)
                goto L_0x011a
            L_0x00ef:
                r16 = r7
                goto L_0x011a
            L_0x00f2:
                r16 = r7
                com.startapp.sdk.adsbase.StartAppAd$AdMode r6 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OFFERWALL
                if (r5 != r6) goto L_0x010e
                r2 = 100
                if (r13 >= r2) goto L_0x011a
                com.startapp.sdk.adsbase.model.AdPreferences r7 = new com.startapp.sdk.adsbase.model.AdPreferences
                r7.<init>()
                r4 = 0
                r17 = 0
                r2 = r0
                r3 = r8
                r5 = r6
                r6 = r7
                r7 = r17
                r2.a((android.content.Context) r3, (com.startapp.sdk.adsbase.StartAppAd) r4, (com.startapp.sdk.adsbase.StartAppAd.AdMode) r5, (com.startapp.sdk.adsbase.model.AdPreferences) r6, (com.startapp.sdk.adsbase.cache.d.C0000d) r7)
                goto L_0x011a
            L_0x010e:
                com.startapp.sdk.adsbase.model.AdPreferences r6 = new com.startapp.sdk.adsbase.model.AdPreferences
                r6.<init>()
                r4 = 0
                r7 = 0
                r2 = r0
                r3 = r8
                r2.a((android.content.Context) r3, (com.startapp.sdk.adsbase.StartAppAd) r4, (com.startapp.sdk.adsbase.StartAppAd.AdMode) r5, (com.startapp.sdk.adsbase.model.AdPreferences) r6, (com.startapp.sdk.adsbase.cache.d.C0000d) r7)
            L_0x011a:
                com.startapp.sdk.adsbase.e$a r2 = r11.edit()
                int r7 = r16 + 1
                com.startapp.sdk.adsbase.e$a r2 = r2.a((java.lang.String) r15, (int) r7)
                r2.apply()
                goto L_0x00b9
            L_0x0128:
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.n4<com.startapp.f1> r0 = r0.r
                java.lang.Object r0 = r0.a()
                com.startapp.f1 r0 = (com.startapp.f1) r0
                r0.e()
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.n4<com.startapp.q7> r0 = r0.s
                java.lang.Object r0 = r0.a()
                com.startapp.q7 r0 = (com.startapp.q7) r0
                r0.e()
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.h8 r0 = r0.v()
                r0.e()
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                android.content.Context r2 = r1.a
                r0.getClass()
                com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)
                com.startapp.i4 r0 = r0.o()
                com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                boolean r2 = r2.Y()
                r3 = 60000(0xea60, double:2.9644E-319)
                if (r2 == 0) goto L_0x018c
                com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                int r2 = r2.D()
                long r5 = (long) r2
                long r5 = r5 * r3
                com.startapp.sdk.jobs.e$a r2 = new com.startapp.sdk.jobs.e$a
                java.lang.Class<com.startapp.sdk.adsbase.remoteconfig.d> r7 = com.startapp.sdk.adsbase.remoteconfig.d.class
                r2.<init>(r7)
                java.lang.Long r5 = java.lang.Long.valueOf(r5)
                r2.d = r5
                com.startapp.sdk.jobs.JobRequest$Network r5 = com.startapp.sdk.jobs.JobRequest.Network.ANY
                r2.b = r5
                com.startapp.sdk.jobs.e r5 = new com.startapp.sdk.jobs.e
                r5.<init>(r2)
                com.startapp.sdk.jobs.JobRequest[] r2 = new com.startapp.sdk.jobs.JobRequest[r10]
                r2[r9] = r5
                r0.a((com.startapp.sdk.jobs.JobRequest[]) r2)
                goto L_0x0199
            L_0x018c:
                java.lang.Class[] r2 = new java.lang.Class[r10]
                java.lang.Class<com.startapp.sdk.adsbase.remoteconfig.d> r5 = com.startapp.sdk.adsbase.remoteconfig.d.class
                r2[r9] = r5
                int r2 = com.startapp.sdk.jobs.JobRequest.a((java.lang.Class<? extends com.startapp.sdk.jobs.b>[]) r2)
                r0.a((int) r2)
            L_0x0199:
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                android.content.Context r2 = r1.a
                r0.getClass()
                com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)
                com.startapp.i4 r0 = r0.o()
                com.startapp.sdk.adsbase.remoteconfig.MetaData r5 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                boolean r5 = r5.X()
                if (r5 == 0) goto L_0x01d7
                com.startapp.sdk.adsbase.remoteconfig.MetaData r5 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                int r2 = r5.b(r2)
                long r5 = (long) r2
                long r5 = r5 * r3
                com.startapp.sdk.jobs.e$a r2 = new com.startapp.sdk.jobs.e$a
                java.lang.Class<com.startapp.l6> r3 = com.startapp.l6.class
                r2.<init>(r3)
                java.lang.Long r3 = java.lang.Long.valueOf(r5)
                r2.d = r3
                com.startapp.sdk.jobs.JobRequest$Network r3 = com.startapp.sdk.jobs.JobRequest.Network.ANY
                r2.b = r3
                com.startapp.sdk.jobs.e r3 = new com.startapp.sdk.jobs.e
                r3.<init>(r2)
                com.startapp.sdk.jobs.JobRequest[] r2 = new com.startapp.sdk.jobs.JobRequest[r10]
                r2[r9] = r3
                r0.a((com.startapp.sdk.jobs.JobRequest[]) r2)
                goto L_0x01e4
            L_0x01d7:
                java.lang.Class[] r2 = new java.lang.Class[r10]
                java.lang.Class<com.startapp.l6> r3 = com.startapp.l6.class
                r2[r9] = r3
                int r2 = com.startapp.sdk.jobs.JobRequest.a((java.lang.Class<? extends com.startapp.sdk.jobs.b>[]) r2)
                r0.a((int) r2)
            L_0x01e4:
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                android.content.Context r2 = r1.a
                r0.getClass()
                com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)
                com.startapp.i4 r0 = r0.o()
                com.startapp.sdk.adsbase.remoteconfig.MetaData r3 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                boolean r4 = r3.X()
                if (r4 == 0) goto L_0x022c
                boolean r4 = r3.W()
                if (r4 == 0) goto L_0x022c
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                int r2 = r3.a((android.content.Context) r2)
                long r2 = (long) r2
                long r2 = r4.toMillis(r2)
                com.startapp.sdk.jobs.e$a r4 = new com.startapp.sdk.jobs.e$a
                java.lang.Class<com.startapp.k6> r5 = com.startapp.k6.class
                r4.<init>(r5)
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                r4.d = r2
                com.startapp.sdk.jobs.JobRequest$Network r2 = com.startapp.sdk.jobs.JobRequest.Network.ANY
                r4.b = r2
                r4.c = r10
                com.startapp.sdk.jobs.e r2 = new com.startapp.sdk.jobs.e
                r2.<init>(r4)
                com.startapp.sdk.jobs.JobRequest[] r3 = new com.startapp.sdk.jobs.JobRequest[r10]
                r3[r9] = r2
                r0.a((com.startapp.sdk.jobs.JobRequest[]) r3)
                goto L_0x0239
            L_0x022c:
                java.lang.Class[] r2 = new java.lang.Class[r10]
                java.lang.Class<com.startapp.k6> r3 = com.startapp.k6.class
                r2[r9] = r3
                int r2 = com.startapp.sdk.jobs.JobRequest.a((java.lang.Class<? extends com.startapp.sdk.jobs.b>[]) r2)
                r0.a((int) r2)
            L_0x0239:
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                android.content.Context r2 = r1.a
                r0.getClass()
                com.startapp.sdk.components.ComponentLocator r3 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)
                com.startapp.sdk.adsbase.e r4 = r3.e()
                java.lang.String r5 = "shared_prefs_first_init"
                boolean r5 = r4.getBoolean(r5, r10)
                if (r5 != 0) goto L_0x0251
                goto L_0x0285
            L_0x0251:
                com.startapp.sdk.adsbase.e$a r5 = r4.edit()
                java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
                java.lang.String r7 = "totalSessions"
                r5.a((java.lang.String) r7, r6)
                android.content.SharedPreferences$Editor r6 = r5.a
                r6.putInt(r7, r9)
                long r6 = java.lang.System.currentTimeMillis()
                java.lang.Long r8 = java.lang.Long.valueOf(r6)
                java.lang.String r11 = "firstSessionTime"
                r5.a((java.lang.String) r11, r8)
                android.content.SharedPreferences$Editor r8 = r5.a
                r8.putLong(r11, r6)
                r5.apply()
                java.util.concurrent.Executor r5 = r3.r()
                com.startapp.sdk.adsbase.f r6 = new com.startapp.sdk.adsbase.f
                r6.<init>(r0, r2, r3, r4)
                r5.execute(r6)
            L_0x0285:
                android.content.Context r0 = r1.a
                com.startapp.sdk.adsbase.StartAppSDKInternal.h(r0)
                com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                r0.getClass()
                android.content.Context r0 = r1.a
                java.lang.Object r2 = com.startapp.sdk.adsbase.StartAppSDKInternal.E
                com.startapp.sdk.adsbase.StartAppSDKInternal r2 = com.startapp.sdk.adsbase.StartAppSDKInternal.this
                com.startapp.z8 r3 = r2.C
                if (r3 == 0) goto L_0x029a
                goto L_0x02ab
            L_0x029a:
                com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)
                com.startapp.n4<com.startapp.z8> r0 = r0.l
                java.lang.Object r0 = r0.a()
                com.startapp.z8 r0 = (com.startapp.z8) r0
                r2.C = r0
                r0.b()
            L_0x02ab:
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.g7 r0 = r0.t()
                boolean r2 = r0.b()     // Catch:{ all -> 0x02c3 }
                if (r2 == 0) goto L_0x02b8
                goto L_0x02c7
            L_0x02b8:
                java.util.concurrent.Executor r2 = r0.b     // Catch:{ all -> 0x02c3 }
                com.startapp.h7 r3 = new com.startapp.h7     // Catch:{ all -> 0x02c3 }
                r3.<init>(r0)     // Catch:{ all -> 0x02c3 }
                r2.execute(r3)     // Catch:{ all -> 0x02c3 }
                goto L_0x02c7
            L_0x02c3:
                r0 = move-exception
                com.startapp.i3.a((java.lang.Throwable) r0)
            L_0x02c7:
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.c7 r0 = r0.s()
                java.util.List r2 = r0.a()
                r3 = 1024(0x400, float:1.435E-42)
                boolean r0 = r0.a((int) r3)
                if (r0 == 0) goto L_0x0303
                com.startapp.i3 r0 = new com.startapp.i3
                com.startapp.j3 r3 = com.startapp.j3.d
                r0.<init>((com.startapp.j3) r3)
                java.lang.String r3 = "RSC init"
                r0.d = r3
                java.lang.String r3 = "targets: "
                java.lang.StringBuilder r3 = com.startapp.p0.a(r3)
                if (r2 == 0) goto L_0x02f6
                int r2 = r2.size()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x02f7
            L_0x02f6:
                r2 = 0
            L_0x02f7:
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r0.e = r2
                r0.a()
            L_0x0303:
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.b5 r0 = r0.q()
                com.startapp.sdk.adsbase.remoteconfig.MotionMetadata r2 = r0.a()
                if (r2 == 0) goto L_0x0320
                double r3 = java.lang.Math.random()
                double r5 = r2.k()
                int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r2 >= 0) goto L_0x031d
                r2 = 1
                goto L_0x031e
            L_0x031d:
                r2 = 0
            L_0x031e:
                r0.f = r2
            L_0x0320:
                android.os.Handler r2 = r0.d
                com.startapp.c5 r3 = new com.startapp.c5
                r3.<init>(r0)
                r2.post(r3)
                com.startapp.sdk.components.ComponentLocator r0 = r1.b
                com.startapp.y r0 = r0.b()
                if (r20 == 0) goto L_0x0334
                r2 = 1
                goto L_0x0335
            L_0x0334:
                r2 = 2
            L_0x0335:
                r0.a(r2)
                com.startapp.sdk.adsbase.remoteconfig.MetaData r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                java.lang.String r0 = r0.x()
                if (r0 == 0) goto L_0x03b3
                java.lang.String r2 = com.startapp.sdk.adsbase.StartAppSDK.getVersion()
                java.lang.String r3 = "\\."
                java.lang.String[] r4 = r0.split(r3)
                java.lang.String[] r2 = r2.split(r3)
                int r3 = r4.length
                int r5 = r2.length
                int r3 = java.lang.Math.min(r3, r5)
                r5 = 0
            L_0x0355:
                if (r5 >= r3) goto L_0x037e
                r6 = r4[r5]     // Catch:{ NumberFormatException -> 0x0369 }
                int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0369 }
                r7 = r2[r5]     // Catch:{ NumberFormatException -> 0x0369 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x0369 }
                if (r6 <= r7) goto L_0x0366
                goto L_0x0374
            L_0x0366:
                if (r6 >= r7) goto L_0x037b
                goto L_0x0378
            L_0x0369:
                r6 = r4[r5]
                r7 = r2[r5]
                int r6 = r6.compareTo(r7)
                if (r6 <= 0) goto L_0x0376
            L_0x0374:
                int r5 = r5 + r10
                goto L_0x038d
            L_0x0376:
                if (r6 >= 0) goto L_0x037b
            L_0x0378:
                int r5 = r5 + r10
                int r5 = -r5
                goto L_0x038d
            L_0x037b:
                int r5 = r5 + 1
                goto L_0x0355
            L_0x037e:
                int r5 = r4.length
                int r6 = r2.length
                if (r5 <= r6) goto L_0x0385
                int r5 = r3 + 1
                goto L_0x038d
            L_0x0385:
                int r4 = r4.length
                int r2 = r2.length
                if (r4 >= r2) goto L_0x038c
                int r3 = r3 + r10
                int r5 = -r3
                goto L_0x038d
            L_0x038c:
                r5 = 0
            L_0x038d:
                if (r5 <= 0) goto L_0x03b3
                android.content.Context r2 = r1.a
                java.lang.String r3 = "Current SDK version ("
                java.lang.StringBuilder r3 = com.startapp.p0.a(r3)
                java.lang.String r4 = com.startapp.sdk.adsbase.StartAppSDK.getVersion()
                r3.append(r4)
                java.lang.String r4 = ") is outdated. Integrate the most recent version ("
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = ") in order to improve your ads performance."
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r3 = 5
                com.startapp.k9.a((android.content.Context) r2, (int) r3, (java.lang.String) r0, (boolean) r9)
            L_0x03b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppSDKInternal.b.a(com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest$RequestReason, boolean):void");
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            this.b.b().a(0);
        }
    }
}
