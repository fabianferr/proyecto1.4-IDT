package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.bykv.vk.openvk.component.video.api.f.c;
import com.bytedance.sdk.component.adexpress.a.b.d;
import com.bytedance.sdk.component.b;
import com.bytedance.sdk.component.d.n;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.g.i;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.PangleWebView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.c.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.e;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.m.a;
import com.bytedance.sdk.openadsdk.n.a.g;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long a = 0;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        b.a.a(aa.d());
        aa.a((h) new h("tt_init_memory_data") {
            public void run() {
                PAGInitHelper.initMemoryData();
            }
        });
        l.a(System.currentTimeMillis());
        l.b();
        SSWebView.setWebViewProvider(new SSWebView.c() {
            public WebView createWebView(Context context, AttributeSet attributeSet, int i) {
                if (i != 0) {
                    return new PangleWebView(context, attributeSet, i);
                }
                try {
                    return new PangleWebView(context, attributeSet);
                } catch (Exception unused) {
                    return i == 0 ? new PangleWebView(context, attributeSet) : new PangleWebView(context, attributeSet, i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        a = SystemClock.elapsedRealtime();
        o.a(context);
        if (pAGInitCallback != null) {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                if (!PAGInitHelper.CALLBACK_LIST.contains(pAGInitCallback)) {
                    PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
                    if (l.d() == 3) {
                        return;
                    }
                }
            }
        }
        if (isInitSuccess()) {
            d();
            return;
        }
        l.a(3);
        if (context == null) {
            b(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        if (initConfig == null) {
            b(4000, "PAGConfig is null, please check.");
            return;
        }
        d(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            com.bytedance.sdk.openadsdk.core.h.a((k) new k() {
                public void success() {
                    PAGSdk.d();
                }

                public void fail(int i, String str) {
                    PAGSdk.b(i, str);
                }
            });
            try {
                s.a(o.a(), "tt_ad_logo_txt");
                if (s.d(context, "tt_ad_logo_new") == 0) {
                    a(initConfig, pAGInitCallback);
                } else if (!isInitSuccess()) {
                    final a aVar = new a();
                    SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() {
                        public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                            return aVar;
                        }
                    });
                    if (!initConfig.isSupportMultiProcess()) {
                        b(context, initConfig);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.a.a().a((com.bytedance.sdk.openadsdk.multipro.aidl.b) new com.bytedance.sdk.openadsdk.multipro.aidl.b() {
                        public void onServiceConnected() {
                            l.b().post(new Runnable() {
                                public void run() {
                                    PAGSdk.b(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.a.a().c();
                } else if (pAGInitCallback != null) {
                    d();
                }
            } catch (Throwable unused) {
                a(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            b(4000, "Internal Error, setting exception. ");
        }
    }

    private static void a(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        l.a(2);
        if (pAGInitCallback == null) {
            return;
        }
        if (initConfig instanceof PAGConfig) {
            b(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
        } else {
            b(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, InitConfig initConfig) {
        long j;
        try {
            if (isInitSuccess()) {
                d();
                return;
            }
            e(context, initConfig);
            com.bytedance.sdk.openadsdk.core.settings.o.ai().u();
            j = SystemClock.elapsedRealtime() - a;
            d();
            f(context, initConfig);
            long elapsedRealtime = SystemClock.elapsedRealtime() - a;
            a(context, isInitSuccess(), initConfig, elapsedRealtime, j);
            com.bytedance.sdk.component.utils.l.b("TTAD.PAGSdk", "init Pangle exec init sdk sdkInitTime=", Long.valueOf(j), " duration=", Long.valueOf(elapsedRealtime));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.c("TTAD.PAGSdk", "init Pangle throwable " + th.getMessage());
            com.bytedance.sdk.component.utils.l.e("TTAD.PAGSdk", th.getMessage());
            b(4000, th.getMessage());
            j = SystemClock.elapsedRealtime() - a;
        }
    }

    private static void c(Context context, InitConfig initConfig) {
        l.a = true;
        v.a().a(initConfig.getAppId()).b(initConfig.getCoppa()).c(initConfig.getGdpr()).d(initConfig.getCcpa()).f(initConfig.getAppIconId()).a(initConfig.getTitleBarTheme()).a(initConfig.isUseTextureView());
        com.bytedance.sdk.openadsdk.core.h.w();
        if (initConfig instanceof PAGConfig) {
            v.a().e(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (b(initConfig)) {
                com.bytedance.sdk.component.utils.l.b();
                v.a().a();
                com.bytedance.sdk.openadsdk.utils.k.a();
                c.a();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.h.a();
    }

    /* access modifiers changed from: private */
    public static boolean b(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    private static void d(Context context, InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getPackageName())) {
            s.a(initConfig.getPackageName());
        } else {
            s.a((String) null);
        }
        o.a(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.b.a();
        } else {
            com.bytedance.sdk.openadsdk.multipro.b.b();
        }
        j.a();
    }

    private static void e(Context context, InitConfig initConfig) {
        if (com.bytedance.sdk.openadsdk.core.settings.k.a()) {
            f.c(-1);
            f.a(new com.bytedance.sdk.component.g.j() {
                public i createThreadFactory(int i, String str) {
                    return new i(i, str) {
                        public Thread newThread(Runnable runnable) {
                            int ah = com.bytedance.sdk.openadsdk.core.settings.o.ai().ah();
                            if (ah < -524288 || ah >= 0) {
                                return super.newThread(runnable);
                            }
                            Thread thread = new Thread(this.a, runnable, this.b, (long) ah);
                            if (thread.isDaemon()) {
                                thread.setDaemon(false);
                            }
                            if (this.c > 10 || this.c < 1) {
                                this.c = 5;
                            }
                            thread.setPriority(this.c);
                            return thread;
                        }
                    };
                }
            });
            com.bytedance.sdk.openadsdk.multipro.c.a(context);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aa.d();
            com.bytedance.sdk.component.f.c.a.a(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.d.b.a(threadPoolExecutor);
            l.b.set(true);
            try {
                com.bytedance.sdk.component.adexpress.a.a.a.a().a((n) new com.bytedance.sdk.openadsdk.f.a());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.l.e("TTAD.PAGSdk", e.getMessage());
            }
            c(initConfig);
            c(context, initConfig);
            c.a("PangleSDK-5509");
            com.bytedance.sdk.component.utils.l.a("PangleSDK-5509");
            com.bykv.vk.openvk.component.video.api.c.a(context, (String) null);
            com.bykv.vk.openvk.component.video.api.c.a(2);
            com.bykv.vk.openvk.component.video.api.c.a(initConfig.isSupportMultiProcess());
            com.bykv.vk.openvk.component.video.api.c.a(com.bytedance.sdk.openadsdk.k.c.a().b().e());
            if (Build.VERSION.SDK_INT < 23) {
                com.bykv.vk.openvk.component.video.a.a.a(context);
            }
        }
    }

    private static void f(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        aa.a((h) new h("init_sync") {
            public void run() {
                new com.bytedance.sdk.openadsdk.utils.i();
                d.a(com.bytedance.sdk.openadsdk.utils.n.a() * 10);
                com.bytedance.sdk.openadsdk.b.a.d.a(context, initConfig.isSupportMultiProcess());
                m.a().b();
                com.bytedance.sdk.openadsdk.core.e.c.a();
                com.bytedance.sdk.openadsdk.m.a.a(new a.C0072a() {
                    public void onGdprChanged(int i) {
                        PAGConfig.setGDPRConsent(i);
                    }
                });
                com.bytedance.sdk.openadsdk.core.settings.o.a = com.bytedance.sdk.openadsdk.core.settings.o.c(context);
                g.b();
                com.bykv.vk.openvk.component.video.a.a.a(o.d().ac());
                com.bykv.vk.openvk.component.video.a.a.a(CacheDirFactory.getICacheDir(0));
                e d = o.d();
                if (!d.V()) {
                    synchronized (d) {
                        if (!d.V()) {
                            d.b();
                            d.D();
                        }
                    }
                }
                DeviceUtils.i();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                f.a(true);
                f.a((com.bytedance.sdk.component.g.c) new com.bytedance.sdk.openadsdk.j.b.a());
                DeviceUtils.i(context);
                DeviceUtils.j(context);
                com.com.bytedance.overseas.sdk.a.b.a(context);
                com.bytedance.sdk.openadsdk.b.a.a.b();
                com.bytedance.sdk.openadsdk.b.a.f.a();
                com.bytedance.sdk.openadsdk.core.settings.c.a();
                com.bytedance.sdk.openadsdk.j.b.c();
                ac.n(context);
                com.bytedance.sdk.openadsdk.b.c.a();
                PAGSdk.c();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void c() {
        ShortcutManager shortcutManager;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context a2 = o.a();
                if (a2 != null && (shortcutManager = (ShortcutManager) a2.getSystemService(ShortcutManager.class)) != null) {
                    com.bytedance.sdk.openadsdk.core.h.b().a(shortcutManager.isRequestPinShortcutSupported());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void c(InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getData())) {
            com.bytedance.sdk.openadsdk.core.h.b().b(initConfig.getData());
        }
        com.bytedance.sdk.openadsdk.core.h.b().d(b(initConfig));
    }

    private static void a(Context context, boolean z, InitConfig initConfig, long j, long j2) {
        com.bytedance.sdk.openadsdk.j.b.a();
        final long j3 = j;
        final long j4 = j2;
        final InitConfig initConfig2 = initConfig;
        final Context context2 = context;
        final boolean z2 = z;
        com.bytedance.sdk.openadsdk.j.b.a("pangle_sdk_init", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
            public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean c2 = com.bytedance.sdk.openadsdk.core.h.b().c();
                    jSONObject.put("duration", j3);
                    jSONObject.put("sdk_init_time", j4);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig2.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.b(initConfig2));
                    jSONObject.put("is_use_texture_view", initConfig2.isUseTextureView());
                    jSONObject.put("is_activate_init", c2);
                    jSONObject.put("minSdkVersion", ac.l(context2));
                    jSONObject.put("targetSdkVersion", ac.k(context2));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z2);
                    com.bytedance.sdk.openadsdk.core.h.b().b(false);
                } catch (Exception e2) {
                    com.bytedance.sdk.component.utils.l.c("TTAD.PAGSdk", "run: ", e2);
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("pangle_sdk_init").b(jSONObject.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public static void d() {
        l.a(1);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.success();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.d(th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static void b(int i, String str) {
        l.a(2);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.fail(i, str);
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.d(th.getMessage());
        }
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        l.b().post(new Runnable() {
            public void run() {
                PAGSdk.b(context, pAGConfig, pAGInitCallback);
            }
        });
    }

    public static boolean isInitSuccess() {
        return l.d() == 1;
    }

    public static String getSDKVersion() {
        return v.a() != null ? v.a().d() : "";
    }

    public static String getBiddingToken(Context context, String str) {
        o.a(context);
        return getBiddingToken(str);
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback != null) {
            aa.a(new h("getBiddingToken") {
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                }
            }, 10);
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback != null) {
            aa.a(new h("getBiddingToken") {
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                }
            }, 10);
        }
    }

    public static String getBiddingToken(String str) {
        if (o.a() == null || v.a() == null) {
            return "";
        }
        return v.a().c(str);
    }

    public static String getBiddingToken(Context context) {
        o.a(context);
        return getBiddingToken();
    }

    public static String getBiddingToken() {
        if (o.a() == null || v.a() == null) {
            return "";
        }
        return v.a().e();
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (v.a() != null) {
            return v.a().a(str, i, str2, str3, str4);
        }
        return false;
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void closeMultiWebViewFileLock() {
        com.bytedance.sdk.openadsdk.multipro.c.a();
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && l.d() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void setAabPackageName(String str) {
        if (!TextUtils.isEmpty(str)) {
            s.a(str);
        }
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && o.d().r() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.j.b.a().a(jSONObject);
        }
    }
}
