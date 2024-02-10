package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.multipro.c;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ToolUtils */
public class ac {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public static volatile boolean b = false;
    private static final AtomicInteger c = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public static volatile String d = "";
    private static final ReentrantLock e = new ReentrantLock();
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static final HashSet<String> i = new HashSet<>(Arrays.asList(new String[]{"Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"}));
    private static final HashSet<String> j;

    public static String a(int i2) {
        if (i2 == 1) {
            return "embeded_ad";
        }
        if (i2 == 2) {
            return "banner_ad";
        }
        if (i2 == 3) {
            return "interaction";
        }
        if (i2 == 4) {
            return "open_ad";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static void a(q qVar, View view) {
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return "embeded_ad_landingpage";
        }
        if (i2 == 2) {
            return "banner_ad_landingpage";
        }
        if (i2 == 3) {
            return "interaction_landingpage";
        }
        if (i2 == 4) {
            return "splash_ad_landingpage";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return null;
        }
        return "rewarded_video_landingpage";
    }

    public static String c(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 == 4) ? "open_ad" : i2 != 7 ? i2 != 8 ? "embeded_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    public static boolean d(int i2) {
        return i2 == 4;
    }

    public static boolean e(int i2) {
        return i2 == 5;
    }

    public static boolean f(int i2) {
        return i2 == 6;
    }

    public static int g(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 != 6) {
            return i2;
        }
        return 5;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        j = hashSet;
        hashSet.addAll(Arrays.asList(new String[]{"America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"}));
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static b a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return new b((ComponentName) null, 0);
        }
        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
        if (activityInfo == null || TextUtils.isEmpty(activityInfo.packageName) || TextUtils.isEmpty(activityInfo.name)) {
            return new b((ComponentName) null, queryIntentActivities.size());
        }
        return new b(new ComponentName(activityInfo.packageName, activityInfo.name), queryIntentActivities.size());
    }

    /* compiled from: ToolUtils */
    public static class b {
        public final ComponentName a;
        public final int b;

        public b(ComponentName componentName, int i) {
            this.a = componentName;
            this.b = i;
        }
    }

    public static int b(Context context, Intent intent) {
        if (intent == null) {
            return 0;
        }
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean a() {
        return m.a() != null && !m.a().f();
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, (b.a) null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String a(q qVar) {
        if (qVar == null) {
            return null;
        }
        try {
            return c(qVar.aS());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c2 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 3;
                    break;
                }
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 7;
            case 2:
            case 4:
                return 4;
            case 3:
                return 5;
            case 5:
                return 3;
            default:
                return 1;
        }
    }

    public static String b() {
        String str;
        String str2 = "unKnow";
        c.a(o.a());
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "android_system_ua", str2);
            } else {
                str = com.bytedance.sdk.openadsdk.core.c.a(o.a()).b("android_system_ua", str2);
            }
            if (str != null && !str2.equals(str)) {
                return str;
            }
            FutureTask futureTask = new FutureTask(new a(2));
            a.execute(futureTask);
            str2 = (String) futureTask.get(500, TimeUnit.MILLISECONDS);
            l.e("getUA", " getAndroidSystemUA userAgent" + str2);
            return str2;
        } catch (Exception unused) {
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        c.a(o.a());
        d = h.a("sdk_local_web_ua", 86400000);
        if (TextUtils.isEmpty(d)) {
            ReentrantLock reentrantLock = e;
            if (reentrantLock.tryLock()) {
                try {
                    if (TextUtils.isEmpty(d)) {
                        d = WebSettings.getDefaultUserAgent(o.a());
                    }
                    h.a("sdk_local_web_ua", d);
                    reentrantLock.unlock();
                } catch (Exception e2) {
                    l.c("TTAD.ToolUtils", "", e2);
                } catch (NoClassDefFoundError e3) {
                    l.c("TTAD.ToolUtils", "", e3);
                } catch (Throwable th) {
                    e.unlock();
                    throw th;
                }
            }
        }
        return d;
        e.unlock();
        return d;
    }

    /* access modifiers changed from: private */
    public static String w() {
        try {
            WebView webView = new WebView(o.a());
            webView.setWebViewClient(new SSWebView.a());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.c.a(o.a()).a("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            l.e("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    /* compiled from: ToolUtils */
    public static class a implements Callable<String> {
        private final int a;

        a(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public synchronized String call() throws Exception {
            String str;
            str = "unKnow";
            int i = this.a;
            if (i == 1) {
                str = c();
            } else if (i == 2) {
                str = b();
            }
            return str;
        }

        private String b() {
            String str;
            Throwable th;
            try {
                str = System.getProperty("http.agent");
                if (str != null) {
                    try {
                        if (!"unKnow".equals(str)) {
                            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "android_system_ua", str);
                            } else {
                                com.bytedance.sdk.openadsdk.core.c.a(o.a()).a("android_system_ua", str);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        l.e("getUA", "e:" + th.getMessage());
                        return str;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                str = "unKnow";
                th = th4;
                l.e("getUA", "e:" + th.getMessage());
                return str;
            }
            return str;
        }

        private synchronized String c() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            aa.a((Runnable) new Runnable() {
                public void run() {
                    strArr[0] = ac.w();
                    l.b("getUA", "webview ua：" + strArr[0]);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                l.e("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }
    }

    public static String d() {
        return r.a();
    }

    public static synchronized String e() {
        String str;
        Context a2;
        synchronized (ac.class) {
            if (TextUtils.isEmpty(f) && (a2 = o.a()) != null) {
                try {
                    f = a2.getPackageName();
                } catch (Throwable th) {
                    l.c("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
            str = f;
        }
        return str;
    }

    public static synchronized String f() {
        String str;
        synchronized (ac.class) {
            if (TextUtils.isEmpty(g) && o.a() != null) {
                try {
                    PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(e(), 0);
                    g = String.valueOf(packageInfo.versionCode);
                    h = packageInfo.versionName;
                } catch (Throwable th) {
                    l.c("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = g;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (ac.class) {
            if (TextUtils.isEmpty(h) && o.a() != null) {
                try {
                    PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(e(), 0);
                    g = String.valueOf(packageInfo.versionCode);
                    h = packageInfo.versionName;
                } catch (Throwable th) {
                    l.c("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = h;
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = com.bytedance.sdk.openadsdk.core.c.a(context).b("total_memory", (String) null);
        if (b2 == null || b(b2) <= 0) {
            b2 = c("MemTotal");
            if (b(b2) <= 0) {
                b2 = h();
            }
            com.bytedance.sdk.openadsdk.core.c.a(context).a("total_memory", b2);
        }
        return b2;
    }

    public static long b(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String h() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) o.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return String.valueOf(memoryInfo.totalMem / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).b("total_memory", "0");
    }

    public static String i() {
        return c("MemTotal");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:17|18|19|20|21|22|23|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[SYNTHETIC, Splitter:B:11:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005f A[SYNTHETIC, Splitter:B:35:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066 A[SYNTHETIC, Splitter:B:39:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r7) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "/proc/meminfo"
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x004e }
            r3 = 4096(0x1000, float:5.74E-42)
            r2.<init>(r1, r3)     // Catch:{ all -> 0x004e }
        L_0x000f:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x001b
            boolean r4 = r3.contains(r7)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x000f
        L_0x001b:
            if (r3 != 0) goto L_0x0024
            r2.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r1.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            return r0
        L_0x0024:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r7 = r3.split(r7)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "ToolUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r5 = "getTotalMemory = "
            r4.append(r5)     // Catch:{ all -> 0x004c }
            r5 = 1
            r6 = r7[r5]     // Catch:{ all -> 0x004c }
            r4.append(r6)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004c }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x004c }
            r7 = r7[r5]     // Catch:{ all -> 0x004c }
            r2.close()     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r1.close()     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            return r7
        L_0x004c:
            r7 = move-exception
            goto L_0x0054
        L_0x004e:
            r7 = move-exception
            r2 = r0
            goto L_0x0054
        L_0x0051:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x0054:
            java.lang.String r3 = "TTAD.ToolUtils"
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x006a }
            com.bytedance.sdk.component.utils.l.e(r3, r7)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0064
            r2.close()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0064
        L_0x0063:
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            return r0
        L_0x006a:
            r7 = move-exception
            if (r2 == 0) goto L_0x0072
            r2.close()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0072
        L_0x0071:
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            goto L_0x0079
        L_0x0078:
            throw r7
        L_0x0079:
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ac.c(java.lang.String):java.lang.String");
    }

    public static long c(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).b("total_internal_storage", 0).longValue();
    }

    public static long j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long d(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).b("free_internal_storage", 0).longValue();
    }

    public static long e(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).b("total_sdcard_storage", 0).longValue();
    }

    public static long k() {
        try {
            if (!x()) {
                return 0;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            l.e("TTAD.ToolUtils", th.getMessage());
            return 0;
        }
    }

    private static boolean x() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int f(Context context) {
        return com.bytedance.sdk.openadsdk.core.c.a(context).b("is_root", -1);
    }

    public static boolean l() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String d(String str) {
        return a(str, false);
    }

    public static String a(String str, boolean z) {
        String str2;
        String G = o.d().G();
        if (TextUtils.isEmpty(G)) {
            int p = p();
            if (p == 1) {
                str2 = "https://pangolin16.sgsnssdk.com" + str;
            } else if (p == 2) {
                str2 = "https://pangolin16.sgsnssdk.com" + str;
            } else {
                str2 = "https://pangolin16.isnssdk.com" + str;
            }
            if (!z) {
                return z.a(str2);
            }
            return l(str2);
        }
        String str3 = "https://" + G + str;
        if (z.a() && !z) {
            str3 = z.a(str3);
        }
        return z ? l(str3) : str3;
    }

    private static String l(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", f()).toString();
        } catch (Exception e2) {
            l.e("TTAD.ToolUtils", e2.getMessage());
            return str;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = o.d().H();
        }
        if (TextUtils.isEmpty(str)) {
            return p() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        }
        if (str.startsWith("http")) {
            return str;
        }
        return "https://" + str;
    }

    public static String m() {
        return String.format("https://%s", new Object[]{"log.byteoversea.com/service/2/app_log_test/"});
    }

    public static String n() {
        int p = p();
        return (p == 1 || p == 2) ? "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String o() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            l.e("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static int p() {
        try {
            String id = TimeZone.getDefault().getID();
            if (i.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id == null || !id.startsWith("Europe/")) {
                return (id == null || !id.startsWith("America/") || j.contains(id)) ? 3 : 5;
            }
            return 4;
        } catch (Throwable th) {
            l.e("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static String g(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            return language + "_" + country;
        } catch (Exception e2) {
            l.e("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static String h(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            l.e("TTAD.ToolUtils", e2.toString());
            return "";
        }
    }

    public static int q() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String r() {
        int i2 = -q();
        if (i2 >= 0) {
            return "Etc/GMT+" + i2;
        }
        return "Etc/GMT" + i2;
    }

    public static JSONObject a(boolean z, q qVar, long j2, long j3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, qVar.Y());
            jSONObject.put("load_time", j2);
            com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
            if (K != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, K.e());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, K.i());
            }
            if (!z) {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, j3);
                if (TextUtils.isEmpty(str)) {
                    str = "unknown";
                }
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
            }
        } catch (JSONException e2) {
            l.c("TTAD.ToolUtils", "getVideoDownload json error", e2);
        }
        return jSONObject;
    }

    public static JSONObject a(q qVar, long j2, com.bykv.vk.openvk.component.video.api.a aVar) {
        if (qVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, qVar.Y());
            jSONObject.put("buffers_time", j2);
            com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
            if (K != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, K.e());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, K.i());
            }
            a(jSONObject, aVar);
        } catch (JSONException e2) {
            l.c("TTAD.ToolUtils", "getVideoAction json error", e2);
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, com.bykv.vk.openvk.component.video.api.a aVar) {
        if (!jSONObject.has(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) && aVar != null) {
            try {
                int d2 = aVar.d();
                int e2 = aVar.e();
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", new Object[]{Integer.valueOf(d2), Integer.valueOf(e2)}));
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean f(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(q qVar, String str) {
        if (qVar != null) {
            try {
                String P = qVar.P();
                if (TextUtils.isEmpty(P) && qVar.ab() != null && qVar.ab().c() == 1 && !TextUtils.isEmpty(qVar.ab().b())) {
                    P = qVar.ab().b();
                }
                String str2 = P;
                if (!TextUtils.isEmpty(str2)) {
                    z.a(o.a(), str2, qVar, a(str), str, false);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(q qVar) {
        if (qVar == null) {
            return true;
        }
        int b2 = o.d().b(qVar.aZ());
        int c2 = com.bytedance.sdk.component.utils.o.c(o.a());
        if (b2 == 1) {
            return d(c2);
        }
        if (b2 != 2) {
            if (b2 == 3) {
                return false;
            }
            if (b2 == 5 && !d(c2) && !f(c2)) {
                return false;
            }
            return true;
        } else if (e(c2) || d(c2) || f(c2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean i(Context context) {
        if (context != null) {
            boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
            StringBuilder sb = new StringBuilder("can query all package = ");
            sb.append(!z);
            l.c("TTAD.ToolUtils", sb.toString());
            return !z;
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        if (str.contains("kllk")) {
            return str.replace("kllk", "oppo");
        }
        return "";
    }

    public static void a(String str, String str2, Context context) {
        int i2;
        if (!TextUtils.isEmpty(str2) && j(context)) {
            int length = str2.length();
            int i3 = 1;
            if (length % 3572 == 0) {
                i2 = length / 3572;
            } else {
                i2 = (length / 3572) + 1;
            }
            int i4 = 3572;
            int i5 = 0;
            while (i3 <= i2) {
                if (i4 < length) {
                    Log.d(str, i2 + "-" + i3 + CertificateUtil.DELIMITER + str2.substring(i5, i4));
                    i3++;
                    i5 = i4;
                    i4 += 3572;
                } else {
                    Log.d(str, i2 + "-" + i3 + CertificateUtil.DELIMITER + str2.substring(i5));
                    return;
                }
            }
        }
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long k(Context context) {
        int i2 = -1;
        try {
            i2 = context.getApplicationInfo().targetSdkVersion;
            l.b("TTAD.ToolUtils", "targetSdkVersion = ", Integer.valueOf(i2));
        } catch (Throwable th) {
            l.e("TTAD.ToolUtils", th.getMessage());
        }
        return (long) i2;
    }

    public static long l(Context context) {
        int i2 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i2 = context.getApplicationInfo().minSdkVersion;
                l.b("TTAD.ToolUtils", "minSdkVersion = ", Integer.valueOf(i2));
            }
        } catch (Throwable th) {
            l.e("TTAD.ToolUtils", th.getMessage());
        }
        return (long) i2;
    }

    public static void h(final String str) {
        com.bytedance.sdk.openadsdk.j.b.a();
        com.bytedance.sdk.openadsdk.j.b.a("reportMultiLog", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
            public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                if (ac.b || !o.d().W()) {
                    return null;
                }
                boolean unused = ac.b = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("reportMultiLog").b(jSONObject.toString());
            }
        });
    }

    public static boolean i(String str) {
        if (com.bytedance.sdk.openadsdk.core.l.e()) {
            return true;
        }
        l.d("You must use method '" + str + "' after initialization, please check.");
        return false;
    }

    public static void j(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            l.d("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.");
        }
    }

    public static int m(Context context) {
        return g(v.a(context, 0));
    }

    public static boolean s() {
        return c.get() == 1;
    }

    public static void n(Context context) {
        try {
            AtomicInteger atomicInteger = c;
            if (atomicInteger.get() == 0) {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                boolean isEnabled = accessibilityManager.isEnabled();
                boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
                if (!isEnabled || !isTouchExplorationEnabled) {
                    atomicInteger.set(2);
                    return;
                }
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.j.b.a().b();
            }
        } catch (Exception unused) {
            c.set(2);
        }
    }

    public static boolean h(int i2) {
        if (i2 <= 0) {
            return false;
        }
        if (i2 >= 100) {
            return true;
        }
        int nextInt = new Random(System.currentTimeMillis()).nextInt(100) + 1;
        l.b("TTAD.ToolUtils", "isMatchProbability: " + nextInt + "/" + i2);
        if (nextInt <= i2) {
            return true;
        }
        return false;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        int indexOf;
        if (sb != null && !TextUtils.isEmpty(str) && (indexOf = sb.indexOf(str)) > 0) {
            sb.replace(indexOf, str.length() + indexOf, str2);
        }
    }
}
