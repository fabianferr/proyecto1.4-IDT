package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class q5 extends WebViewClient {
    public final Context a;
    public final com.startapp.sdk.adsbase.e b;
    public final Executor c;
    public final Handler d;
    public String e;
    public String f;
    public boolean g = false;
    public boolean h = false;
    public long i;
    public final long j;
    public boolean k;
    public Boolean l;
    public String m;
    public Runnable n;
    public boolean o = false;
    public boolean p = false;
    public final LinkedHashMap<String, Float> q = new LinkedHashMap<>();
    public long r;
    public final Runnable s = new a();
    public final Runnable t = new b();
    public final Runnable u = new c();
    public final Runnable v = new d();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            q5 q5Var = q5.this;
            q5Var.c.execute(q5Var.t);
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            q5 q5Var = q5.this;
            if (!q5Var.g) {
                try {
                    i3 i3Var = new i3(j3.e);
                    i3Var.d = "Failed smart redirect hop info: ".concat(q5Var.p ? "Page Finished" : "Timeout");
                    i3Var.f = q5Var.b();
                    i3Var.g = q5Var.f;
                    i3Var.a();
                } catch (Throwable th) {
                    i3.a(th);
                }
                try {
                    q5Var.o = true;
                    com.startapp.sdk.adsbase.a.c(q5Var.a);
                    q5Var.a();
                    if (!q5Var.k || !MetaData.k.U()) {
                        com.startapp.sdk.adsbase.a.b(q5Var.a, q5Var.e, q5Var.f);
                    } else {
                        com.startapp.sdk.adsbase.a.a(q5Var.a, q5Var.e, q5Var.f);
                    }
                    Runnable runnable = q5Var.n;
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (Throwable th2) {
                    i3.a(th2);
                }
            }
        }
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public c() {
        }

        public void run() {
            q5 q5Var = q5.this;
            q5Var.c.execute(q5Var.v);
        }
    }

    /* compiled from: Sta */
    public class d implements Runnable {
        public d() {
        }

        public void run() {
            q5 q5Var = q5.this;
            if (!q5Var.o && !q5Var.g) {
                try {
                    q5Var.g = true;
                    com.startapp.sdk.adsbase.a.c(q5Var.a);
                    if (!q5Var.k || !MetaData.k.U()) {
                        com.startapp.sdk.adsbase.a.b(q5Var.a, q5Var.e, q5Var.f);
                    } else {
                        com.startapp.sdk.adsbase.a.a(q5Var.a, q5Var.e, q5Var.f);
                    }
                    Runnable runnable = q5Var.n;
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }
    }

    /* compiled from: Sta */
    public class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        public void run() {
            q5 q5Var = q5.this;
            String str = this.a;
            if (!q5Var.h) {
                q5Var.r = System.currentTimeMillis();
                q5Var.q.put(str, Float.valueOf(-1.0f));
                q5Var.d.postDelayed(q5Var.s, q5Var.i);
                q5Var.h = true;
            }
            q5Var.p = false;
            q5Var.a();
        }
    }

    /* compiled from: Sta */
    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        public void run() {
            q5 q5Var = q5.this;
            String str = this.a;
            q5Var.getClass();
            long currentTimeMillis = System.currentTimeMillis();
            q5Var.r = currentTimeMillis;
            q5Var.q.put(q5Var.e, Float.valueOf(((float) (currentTimeMillis - q5Var.r)) / 1000.0f));
            q5Var.q.put(str, Float.valueOf(-1.0f));
            q5Var.e = str;
        }
    }

    /* compiled from: Sta */
    public class g implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public g(String str, boolean z, String str2) {
            this.a = str;
            this.b = z;
            this.c = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x008b A[Catch:{ all -> 0x00dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ all -> 0x00dc }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.String r0 = "Expected: "
                com.startapp.q5 r1 = com.startapp.q5.this
                java.lang.String r2 = r8.a
                boolean r3 = r8.b
                java.lang.String r4 = r8.c
                r1.getClass()
                boolean r5 = r1.o     // Catch:{ all -> 0x00dc }
                if (r5 != 0) goto L_0x00e0
                r5 = 1
                r1.g = r5     // Catch:{ all -> 0x00dc }
                android.content.Context r6 = r1.a     // Catch:{ all -> 0x00dc }
                com.startapp.sdk.adsbase.a.c((android.content.Context) r6)     // Catch:{ all -> 0x00dc }
                r1.a()     // Catch:{ all -> 0x00dc }
                android.content.Context r6 = r1.a     // Catch:{ all -> 0x00dc }
                if (r3 == 0) goto L_0x0021
                r2 = r4
            L_0x0021:
                r3 = 0
                com.startapp.sdk.adsbase.a.b(r6, r2, r3)     // Catch:{ all -> 0x00dc }
                java.lang.String r2 = r1.m     // Catch:{ all -> 0x00dc }
                if (r2 == 0) goto L_0x0070
                java.lang.String r3 = ""
                boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00dc }
                if (r2 != 0) goto L_0x0070
                java.lang.String r2 = r1.e     // Catch:{ all -> 0x00dc }
                java.lang.String r2 = r2.toLowerCase()     // Catch:{ all -> 0x00dc }
                java.lang.String r3 = r1.m     // Catch:{ all -> 0x00dc }
                java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x00dc }
                boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x00dc }
                if (r2 != 0) goto L_0x0070
                com.startapp.i3 r2 = new com.startapp.i3     // Catch:{ all -> 0x00dc }
                com.startapp.j3 r3 = com.startapp.j3.e     // Catch:{ all -> 0x00dc }
                r2.<init>((com.startapp.j3) r3)     // Catch:{ all -> 0x00dc }
                java.lang.String r3 = "Wrong package reached"
                r2.d = r3     // Catch:{ all -> 0x00dc }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
                r3.<init>(r0)     // Catch:{ all -> 0x00dc }
                java.lang.String r0 = r1.m     // Catch:{ all -> 0x00dc }
                r3.append(r0)     // Catch:{ all -> 0x00dc }
                java.lang.String r0 = ", Link: "
                r3.append(r0)     // Catch:{ all -> 0x00dc }
                java.lang.String r0 = r1.e     // Catch:{ all -> 0x00dc }
                r3.append(r0)     // Catch:{ all -> 0x00dc }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00dc }
                r2.e = r0     // Catch:{ all -> 0x00dc }
                java.lang.String r0 = r1.f     // Catch:{ all -> 0x00dc }
                r2.g = r0     // Catch:{ all -> 0x00dc }
                r2.a()     // Catch:{ all -> 0x00dc }
                goto L_0x00d4
            L_0x0070:
                com.startapp.sdk.adsbase.remoteconfig.MetaData r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k     // Catch:{ all -> 0x00dc }
                com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r0 = r0.analytics     // Catch:{ all -> 0x00dc }
                boolean r0 = r0.k()     // Catch:{ all -> 0x00dc }
                java.lang.String r2 = "firstSucceededSmartRedirect"
                r3 = 0
                if (r0 == 0) goto L_0x0086
                com.startapp.sdk.adsbase.e r0 = r1.b     // Catch:{ all -> 0x00dc }
                boolean r0 = r0.getBoolean(r2, r5)     // Catch:{ all -> 0x00dc }
                if (r0 == 0) goto L_0x0086
                goto L_0x0087
            L_0x0086:
                r5 = 0
            L_0x0087:
                java.lang.Boolean r0 = r1.l     // Catch:{ all -> 0x00dc }
                if (r0 != 0) goto L_0x0094
                com.startapp.sdk.adsbase.remoteconfig.MetaData r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k     // Catch:{ all -> 0x00dc }
                com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r0 = r0.analytics     // Catch:{ all -> 0x00dc }
                float r0 = r0.j()     // Catch:{ all -> 0x00dc }
                goto L_0x009e
            L_0x0094:
                boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00dc }
                if (r0 == 0) goto L_0x009d
                r0 = 1120403456(0x42c80000, float:100.0)
                goto L_0x009e
            L_0x009d:
                r0 = 0
            L_0x009e:
                if (r5 != 0) goto L_0x00ad
                double r4 = java.lang.Math.random()     // Catch:{ all -> 0x00dc }
                r6 = 4636737291354636288(0x4059000000000000, double:100.0)
                double r4 = r4 * r6
                double r6 = (double) r0     // Catch:{ all -> 0x00dc }
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 >= 0) goto L_0x00d4
            L_0x00ad:
                com.startapp.i3 r0 = new com.startapp.i3     // Catch:{ all -> 0x00dc }
                com.startapp.j3 r4 = com.startapp.j3.m     // Catch:{ all -> 0x00dc }
                r0.<init>((com.startapp.j3) r4)     // Catch:{ all -> 0x00dc }
                org.json.JSONArray r4 = r1.b()     // Catch:{ all -> 0x00dc }
                r0.f = r4     // Catch:{ all -> 0x00dc }
                java.lang.String r4 = r1.f     // Catch:{ all -> 0x00dc }
                r0.g = r4     // Catch:{ all -> 0x00dc }
                r0.a()     // Catch:{ all -> 0x00dc }
                com.startapp.sdk.adsbase.e r0 = r1.b     // Catch:{ all -> 0x00dc }
                com.startapp.sdk.adsbase.e$a r0 = r0.edit()     // Catch:{ all -> 0x00dc }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00dc }
                r0.a((java.lang.String) r2, r4)     // Catch:{ all -> 0x00dc }
                android.content.SharedPreferences$Editor r4 = r0.a     // Catch:{ all -> 0x00dc }
                r4.putBoolean(r2, r3)     // Catch:{ all -> 0x00dc }
                r0.apply()     // Catch:{ all -> 0x00dc }
            L_0x00d4:
                java.lang.Runnable r0 = r1.n     // Catch:{ all -> 0x00dc }
                if (r0 == 0) goto L_0x00e0
                r0.run()     // Catch:{ all -> 0x00dc }
                goto L_0x00e0
            L_0x00dc:
                r0 = move-exception
                com.startapp.i3.a((java.lang.Throwable) r0)
            L_0x00e0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.q5.g.run():void");
        }
    }

    /* compiled from: Sta */
    public class h implements Runnable {
        public final /* synthetic */ String a;

        public h(String str) {
            this.a = str;
        }

        public void run() {
            q5 q5Var = q5.this;
            String str = this.a;
            if (!q5Var.g && !q5Var.o && q5Var.e.equals(str) && !com.startapp.sdk.adsbase.a.b(str)) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    q5Var.p = true;
                    q5Var.a(str);
                    synchronized (q5Var.d) {
                        q5Var.d.removeCallbacks(q5Var.u);
                        q5Var.d.postDelayed(q5Var.u, q5Var.j);
                    }
                }
            }
        }
    }

    public q5(Context context, com.startapp.sdk.adsbase.e eVar, Executor executor, Handler handler, long j2, long j3, boolean z, Boolean bool, String str, String str2, String str3, Runnable runnable) {
        this.a = context;
        this.b = eVar;
        this.c = new r7(executor);
        this.d = handler;
        this.i = j2;
        this.j = j3;
        this.k = z;
        this.l = bool;
        this.e = str;
        this.m = str2;
        this.f = str3;
        this.n = runnable;
    }

    public void a() {
        synchronized (this.d) {
            this.d.removeCallbacks(this.u);
        }
    }

    public JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : this.q.entrySet()) {
            String str = (String) next.getKey();
            Float f2 = (Float) next.getValue();
            JSONObject jSONObject = new JSONObject();
            try {
                a(str);
                jSONObject.put("time", String.valueOf(f2));
                jSONObject.put("url", str);
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        return jSONArray;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.c.execute(new h(str));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.c.execute(new e(str));
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        a();
        if (str2 != null && !com.startapp.sdk.adsbase.a.b(str2) && com.startapp.sdk.adsbase.a.c(str2)) {
            i3 i3Var = new i3(j3.e);
            i3Var.d = "Failed smart redirect: " + i2;
            i3Var.e = str2;
            i3Var.g = this.f;
            i3Var.a();
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!(webView == null || str == null)) {
            this.c.execute(new f(str));
            if (k9.b(webView.getContext(), str)) {
                return true;
            }
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            boolean b2 = com.startapp.sdk.adsbase.a.b(lowerCase);
            boolean startsWith = lowerCase.startsWith("intent://");
            if (!b2 && !startsWith) {
                return false;
            }
            this.c.execute(new g(str, startsWith, webView.getUrl()));
        }
        return true;
    }

    public final void a(String str) {
        Float f2 = this.q.get(str);
        if (f2 == null || f2.floatValue() < 0.0f) {
            this.q.put(str, Float.valueOf(((float) (System.currentTimeMillis() - this.r)) / 1000.0f));
        }
    }
}
