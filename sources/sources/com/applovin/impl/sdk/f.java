package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class f {
    private static final int a = ((int) TimeUnit.SECONDS.toMillis(30));
    private static final f m = new f();
    /* access modifiers changed from: private */
    public final AtomicLong b = new AtomicLong(0);
    /* access modifiers changed from: private */
    public Handler c;
    private final HandlerThread d = new HandlerThread("applovin-anr-detector");
    /* access modifiers changed from: private */
    public Handler e;
    /* access modifiers changed from: private */
    public final AtomicBoolean f = new AtomicBoolean();
    private final AtomicBoolean g = new AtomicBoolean();
    private m h;
    /* access modifiers changed from: private */
    public Thread i;
    /* access modifiers changed from: private */
    public long j = TimeUnit.SECONDS.toMillis(4);
    /* access modifiers changed from: private */
    public long k = TimeUnit.SECONDS.toMillis(3);
    /* access modifiers changed from: private */
    public long l = TimeUnit.SECONDS.toMillis(3);

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            if (!f.this.f.get()) {
                long currentTimeMillis = System.currentTimeMillis() - f.this.b.get();
                if (currentTimeMillis < 0 || currentTimeMillis > f.this.j) {
                    f.this.a();
                    f.this.b();
                }
                f.this.e.postDelayed(this, f.this.l);
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        public void run() {
            if (!f.this.f.get()) {
                f.this.b.set(System.currentTimeMillis());
                f.this.c.postDelayed(this, f.this.k);
            }
        }
    }

    private f() {
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.g.get()) {
            this.f.set(true);
        }
    }

    public static void a(m mVar) {
        if (mVar == null) {
            return;
        }
        if (!((Boolean) mVar.a(com.applovin.impl.sdk.d.b.eS)).booleanValue() || Utils.isPubInDebugMode(mVar.L(), mVar)) {
            m.a();
        } else {
            m.b(mVar);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c().openConnection();
            int i2 = a;
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(false);
            int responseCode = httpURLConnection.getResponseCode();
            Log.d("applovin-anr-detector", "ANR reported with code " + responseCode);
        } catch (Throwable th) {
            Log.w("applovin-anr-detector", "Failed to report ANR", th);
        }
    }

    private void b(m mVar) {
        if (this.g.compareAndSet(false, true)) {
            this.h = mVar;
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Thread unused = f.this.i = Thread.currentThread();
                }
            });
            this.j = ((Long) mVar.a(com.applovin.impl.sdk.d.b.eT)).longValue();
            this.k = ((Long) mVar.a(com.applovin.impl.sdk.d.b.eU)).longValue();
            this.l = ((Long) mVar.a(com.applovin.impl.sdk.d.b.eV)).longValue();
            this.c = new Handler(mVar.L().getMainLooper());
            this.d.start();
            this.c.post(new b());
            Handler handler = new Handler(this.d.getLooper());
            this.e = handler;
            handler.postDelayed(new a(), this.l / 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[SYNTHETIC, Splitter:B:13:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[Catch:{ MalformedURLException -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0105 A[Catch:{ MalformedURLException -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0115 A[Catch:{ MalformedURLException -> 0x016e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.URL c() {
        /*
            r11 = this;
            java.lang.String r0 = ""
            com.applovin.impl.sdk.m r1 = r11.h
            android.content.Context r1 = r1.L()
            r2 = 0
            r3 = 0
            android.content.pm.PackageManager r4 = r1.getPackageManager()     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0017 }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r1, r3)     // Catch:{ all -> 0x0018 }
            goto L_0x0019
        L_0x0017:
            r1 = r0
        L_0x0018:
            r4 = r2
        L_0x0019:
            com.applovin.impl.sdk.m r5 = r11.h     // Catch:{ MalformedURLException -> 0x016e }
            com.applovin.impl.sdk.s r5 = r5.ae()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.Object r5 = r5.c()     // Catch:{ MalformedURLException -> 0x016e }
            boolean r6 = r5 instanceof com.applovin.impl.sdk.ad.e     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r7 = "None"
            if (r6 == 0) goto L_0x0036
            com.applovin.impl.sdk.ad.e r5 = (com.applovin.impl.sdk.ad.e) r5     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r6 = "AppLovin"
            long r8 = r5.getAdIdNumber()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r5 = java.lang.Long.toString(r8)     // Catch:{ MalformedURLException -> 0x016e }
            goto L_0x0047
        L_0x0036:
            boolean r6 = r5 instanceof com.applovin.impl.mediation.a.a     // Catch:{ MalformedURLException -> 0x016e }
            if (r6 == 0) goto L_0x0045
            com.applovin.impl.mediation.a.a r5 = (com.applovin.impl.mediation.a.a) r5     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r6 = r5.getNetworkName()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r5 = r5.getCreativeId()     // Catch:{ MalformedURLException -> 0x016e }
            goto L_0x0047
        L_0x0045:
            r5 = r7
            r6 = r5
        L_0x0047:
            java.lang.Thread r8 = r11.i     // Catch:{ MalformedURLException -> 0x016e }
            if (r8 == 0) goto L_0x0076
            java.lang.StackTraceElement[] r8 = r8.getStackTrace()     // Catch:{ MalformedURLException -> 0x016e }
            int r8 = r8.length     // Catch:{ MalformedURLException -> 0x016e }
            if (r8 <= 0) goto L_0x0076
            java.lang.Thread r7 = r11.i     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.StackTraceElement[] r7 = r7.getStackTrace()     // Catch:{ MalformedURLException -> 0x016e }
            r7 = r7[r3]     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x016e }
            r8.<init>()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r9 = r7.getClassName()     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r9)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r9 = "."
            r8.append(r9)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r7 = r7.getMethodName()     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r7)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r7 = r8.toString()     // Catch:{ MalformedURLException -> 0x016e }
        L_0x0076:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x016e }
            r8.<init>()     // Catch:{ MalformedURLException -> 0x016e }
            com.applovin.impl.sdk.m r9 = r11.h     // Catch:{ MalformedURLException -> 0x016e }
            com.applovin.impl.sdk.d.b<java.lang.String> r10 = com.applovin.impl.sdk.d.b.bb     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.Object r9 = r9.a(r10)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r9)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r9 = "?type=anr&platform=android&package_name="
            r8.append(r9)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&applovin_random_token="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            com.applovin.impl.sdk.m r1 = r11.h     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = r1.o()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&compass_random_token="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            com.applovin.impl.sdk.m r1 = r11.h     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = r1.n()     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&model="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&brand="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&brand_name="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&hardware="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = android.os.Build.HARDWARE     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&revision="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = android.os.Build.DEVICE     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r1 = "&app_version="
            r8.append(r1)     // Catch:{ MalformedURLException -> 0x016e }
            if (r4 == 0) goto L_0x0107
            java.lang.String r0 = r4.versionName     // Catch:{ MalformedURLException -> 0x016e }
        L_0x0107:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&app_version_code="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            if (r4 == 0) goto L_0x0117
            int r3 = r4.versionCode     // Catch:{ MalformedURLException -> 0x016e }
        L_0x0117:
            r8.append(r3)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&os="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = android.os.Build.VERSION.RELEASE     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&api_level="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&sdk_version="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = com.applovin.sdk.AppLovinSdk.VERSION     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&fs_ad_network="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = a((java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&fs_ad_creative_id="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = a((java.lang.String) r5)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = "&top_main_method="
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = a((java.lang.String) r7)     // Catch:{ MalformedURLException -> 0x016e }
            r8.append(r0)     // Catch:{ MalformedURLException -> 0x016e }
            java.lang.String r0 = r8.toString()     // Catch:{ MalformedURLException -> 0x016e }
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x016e }
            r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x016e }
            return r1
        L_0x016e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.f.c():java.net.URL");
    }
}
