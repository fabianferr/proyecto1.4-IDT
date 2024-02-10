package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.TrafficStats;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.common.C;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.zd;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class wd {
    /* access modifiers changed from: private */
    public static final String M = "wd";
    private static final boolean N = false;
    private static final int O = 3000;
    private static final long P = 100;
    private static final String Q = "javascript:(function() {const [navigation_entries] = performance.getEntriesByType(\"navigation\");DTA.navigationTimings(JSON.stringify(navigation_entries));const resource_entries = performance.getEntriesByType(\"resource\");DTA.resourceTimings(JSON.stringify(resource_entries));})()";
    private int A;
    private int B;
    private boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    private ScheduledFuture<?> F;
    private ScheduledExecutorService G;
    private String H;
    private String I;
    private String J;
    private String K;
    private final Runnable L;
    private final Context a;
    private final String b;
    /* access modifiers changed from: private */
    public xd c;
    private final IS d;
    private final CLC e;
    /* access modifiers changed from: private */
    public final zd f;
    /* access modifiers changed from: private */
    public WebView g;
    private long h;
    private final CLC.ProviderMode i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public final int m;
    /* access modifiers changed from: private */
    public long n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public long p;
    private long q;
    private long r;
    /* access modifiers changed from: private */
    public final ArrayList<k5> s;
    /* access modifiers changed from: private */
    public HashMap<Object, w2> t;
    /* access modifiers changed from: private */
    public boolean u;
    private int v;
    /* access modifiers changed from: private */
    public final Handler w;
    private boolean x;
    /* access modifiers changed from: private */
    public ae y;
    /* access modifiers changed from: private */
    public final ArrayList<be> z;

    class a implements View.OnTouchListener {
        a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class b extends WebViewClient {
        b() {
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            wd.this.f.a(str);
            wd.m(wd.this);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!wd.this.D) {
                boolean unused = wd.this.D = true;
                wd.this.a(webView);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            wd.this.k();
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            wd.this.k();
        }
    }

    class c extends WebChromeClient {
        c() {
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            wd.this.f.a(i);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ a c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                wd.this.f.a(wd.this.g, zd.a.Start);
                wd.this.c.TimeInfoOnStart = TimeServer.getTimeInfo();
                long unused = wd.this.k = SystemClock.elapsedRealtime();
                long unused2 = wd.this.n = SystemClock.elapsedRealtime();
                int unused3 = wd.this.l = 1;
                wd.this.g.loadUrl(d.this.a);
            }
        }

        d(String str, boolean z, a aVar) {
            this.a = str;
            this.b = z;
            this.c = aVar;
        }

        public void run() {
            v.a((Object) wd.this, w2.WWW);
            wd.this.a(this.a, this.b, this.c);
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    class e implements Runnable {
        final /* synthetic */ WebView a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                wd.this.d();
                wd.this.h();
                wd wdVar = wd.this;
                wdVar.b(!wdVar.u);
                if (wd.this.u) {
                    wd.this.f.a(wd.this.g, zd.a.Error);
                } else {
                    wd.this.f.a(wd.this.g, zd.a.End);
                }
            }
        }

        e(WebView webView) {
            this.a = webView;
        }

        public void run() {
            wd.this.b(this.a);
            wd.this.w.postDelayed(new a(), 1000);
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            if (wd.this.j) {
                wd.this.t.putAll(v.c());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uidRxBytes = TrafficStats.getUidRxBytes(wd.this.m);
                long uidTxBytes = TrafficStats.getUidTxBytes(wd.this.m);
                k5 a2 = wd.this.a(elapsedRealtime, uidRxBytes, uidTxBytes);
                synchronized (this) {
                    if (wd.this.j) {
                        wd.this.s.add(a2);
                    }
                }
                long unused = wd.this.n = elapsedRealtime;
                long unused2 = wd.this.o = uidRxBytes;
                long unused3 = wd.this.p = uidTxBytes;
            }
        }
    }

    public class g {
        Context a;

        g(Context context) {
            this.a = context;
        }

        @JavascriptInterface
        public void navigationTimings(String str) {
            try {
                ae unused = wd.this.y = (ae) JsonUtils.fromJson(str, ae.class, true);
            } catch (Exception unused2) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A[SYNTHETIC, Splitter:B:26:0x0044] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resourceTimings(java.lang.String r5) {
            /*
                r4 = this;
                r0 = 0
                java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0053, all -> 0x0041 }
                java.lang.String r2 = "UTF-8"
                byte[] r5 = r5.getBytes(r2)     // Catch:{ Exception -> 0x0053, all -> 0x0041 }
                r1.<init>(r5)     // Catch:{ Exception -> 0x0053, all -> 0x0041 }
                com.umlaut.crowd.internal.k4 r5 = new com.umlaut.crowd.internal.k4     // Catch:{ Exception -> 0x0053, all -> 0x0041 }
                r5.<init>(r1)     // Catch:{ Exception -> 0x0053, all -> 0x0041 }
                r5.G()     // Catch:{ Exception -> 0x003e, all -> 0x0039 }
                monitor-enter(r4)     // Catch:{ Exception -> 0x003e, all -> 0x0039 }
            L_0x0015:
                boolean r0 = r5.p()     // Catch:{ all -> 0x0036 }
                if (r0 == 0) goto L_0x002e
                java.lang.Class<com.umlaut.crowd.internal.be> r0 = com.umlaut.crowd.internal.be.class
                r1 = 1
                java.lang.Object r0 = r5.a((java.lang.Class<?>) r0, (boolean) r1)     // Catch:{ all -> 0x0036 }
                com.umlaut.crowd.internal.be r0 = (com.umlaut.crowd.internal.be) r0     // Catch:{ all -> 0x0036 }
                com.umlaut.crowd.internal.wd r1 = com.umlaut.crowd.internal.wd.this     // Catch:{ all -> 0x0036 }
                java.util.ArrayList r1 = r1.z     // Catch:{ all -> 0x0036 }
                r1.add(r0)     // Catch:{ all -> 0x0036 }
                goto L_0x0015
            L_0x002e:
                monitor-exit(r4)     // Catch:{ all -> 0x0036 }
                r5.k()     // Catch:{ Exception -> 0x003e, all -> 0x0039 }
                r5.close()     // Catch:{ IOException -> 0x005a }
                goto L_0x0064
            L_0x0036:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0036 }
                throw r0     // Catch:{ Exception -> 0x003e, all -> 0x0039 }
            L_0x0039:
                r0 = move-exception
                r3 = r0
                r0 = r5
                r5 = r3
                goto L_0x0042
            L_0x003e:
                r0 = r5
                goto L_0x0054
            L_0x0041:
                r5 = move-exception
            L_0x0042:
                if (r0 == 0) goto L_0x0052
                r0.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x0052
            L_0x0048:
                r0 = move-exception
                java.lang.String r1 = com.umlaut.crowd.internal.wd.M
                java.lang.String r2 = "resourceTimings"
                android.util.Log.e(r1, r2, r0)
            L_0x0052:
                throw r5
            L_0x0053:
            L_0x0054:
                if (r0 == 0) goto L_0x0064
                r0.close()     // Catch:{ IOException -> 0x005a }
                goto L_0x0064
            L_0x005a:
                r5 = move-exception
                java.lang.String r0 = com.umlaut.crowd.internal.wd.M
                java.lang.String r1 = "resourceTimings"
                android.util.Log.e(r0, r1, r5)
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.wd.g.resourceTimings(java.lang.String):void");
        }
    }

    public wd(Context context, CLC.ProviderMode providerMode, zd zdVar) {
        this.j = false;
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = new f();
        this.a = context;
        this.b = InsightCore.getInsightConfig().f1();
        this.d = new IS(context);
        this.h = P;
        this.i = providerMode;
        this.f = zdVar;
        this.e = new CLC(context);
        this.w = new Handler();
        this.z = new ArrayList<>();
        this.s = new ArrayList<>();
        this.m = Process.myUid();
    }

    static /* synthetic */ int m(wd wdVar) {
        int i2 = wdVar.v;
        wdVar.v = i2 + 1;
        return i2;
    }

    private void f() {
        a("", false);
    }

    private void g() {
        InsightCore.getDatabaseHelper().a(w2.WWW, (RBR) this.c);
    }

    /* access modifiers changed from: private */
    public void h() {
        ArrayList arrayList;
        ae aeVar = this.y;
        if (aeVar != null) {
            this.c.StartTime = Math.round(aeVar.startTime);
            this.c.UnloadEventStart = Math.round(this.y.unloadEventStart);
            this.c.UnloadEventEnd = Math.round(this.y.unloadEventEnd);
            this.c.RedirectStart = Math.round(this.y.redirectStart);
            this.c.RedirectEnd = Math.round(this.y.redirectEnd);
            this.c.WorkerStart = Math.round(this.y.workerStart);
            this.c.FetchStart = Math.round(this.y.fetchStart);
            this.c.DomainLookupStart = Math.round(this.y.domainLookupStart);
            this.c.DomainLookupEnd = Math.round(this.y.domainLookupEnd);
            this.c.ConnectStart = Math.round(this.y.connectStart);
            this.c.SecureConnectionStart = Math.round(this.y.secureConnectionStart);
            this.c.ConnectEnd = Math.round(this.y.connectEnd);
            this.c.RequestStart = Math.round(this.y.requestStart);
            this.c.ResponseStart = Math.round(this.y.responseStart);
            this.c.ResponseEnd = Math.round(this.y.responseEnd);
            this.c.DomInteractive = Math.round(this.y.domInteractive);
            this.c.DomContentLoadedEventStart = Math.round(this.y.domContentLoadedEventStart);
            this.c.DomContentLoadedEventEnd = Math.round(this.y.domContentLoadedEventEnd);
            this.c.DomComplete = Math.round(this.y.domComplete);
            this.c.LoadEventStart = Math.round(this.y.loadEventStart);
            this.c.LoadEventEnd = Math.round(this.y.loadEventEnd);
            xd xdVar = this.c;
            ae aeVar2 = this.y;
            xdVar.RedirectDuration = Math.round(aeVar2.redirectEnd - aeVar2.redirectStart);
            xd xdVar2 = this.c;
            ae aeVar3 = this.y;
            xdVar2.FetchCacheDuration = Math.round(aeVar3.domainLookupStart - aeVar3.fetchStart);
            xd xdVar3 = this.c;
            ae aeVar4 = this.y;
            xdVar3.DnsLookupDuration = Math.round(aeVar4.domainLookupEnd - aeVar4.domainLookupStart);
            xd xdVar4 = this.c;
            ae aeVar5 = this.y;
            xdVar4.ConnectionDuration = Math.round(aeVar5.connectEnd - aeVar5.connectStart);
            xd xdVar5 = this.c;
            ae aeVar6 = this.y;
            double d2 = aeVar6.secureConnectionStart;
            xdVar5.SecureConnectionDuration = Math.round(d2 == 0.0d ? 0.0d : aeVar6.connectEnd - d2);
            xd xdVar6 = this.c;
            ae aeVar7 = this.y;
            xdVar6.RequestDuration = Math.round(aeVar7.responseStart - aeVar7.requestStart);
            xd xdVar7 = this.c;
            ae aeVar8 = this.y;
            xdVar7.ResponseDuration = Math.round(aeVar8.responseEnd - aeVar8.responseStart);
            xd xdVar8 = this.c;
            ae aeVar9 = this.y;
            xdVar8.DomLoadingDuration = Math.max(Math.round(aeVar9.domComplete - aeVar9.domInteractive), -1);
            xd xdVar9 = this.c;
            ae aeVar10 = this.y;
            xdVar9.LoadingDuration = Math.round(aeVar10.loadEventEnd - aeVar10.loadEventStart);
            this.c.OverallDuration = Math.round(this.y.duration);
            xd xdVar10 = this.c;
            ae aeVar11 = this.y;
            xdVar10.NumberOfRedirects = aeVar11.redirectCount;
            xdVar10.EncodedBodySize = aeVar11.encodedBodySize;
            xdVar10.TransferSize = aeVar11.transferSize;
            xdVar10.DecodedBodySize = aeVar11.decodedBodySize;
        }
        ArrayList<be> arrayList2 = this.z;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            synchronized (this) {
                arrayList = new ArrayList(this.z);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                be beVar = (be) it.next();
                u7 u7Var = new u7();
                u7Var.StartTime = Math.round(beVar.startTime);
                u7Var.RedirectStart = Math.round(beVar.redirectStart);
                u7Var.RedirectEnd = Math.round(beVar.redirectEnd);
                u7Var.WorkerStart = Math.round(beVar.workerStart);
                u7Var.FetchStart = Math.round(beVar.fetchStart);
                u7Var.DomainLookupStart = Math.round(beVar.domainLookupStart);
                u7Var.DomainLookupEnd = Math.round(beVar.domainLookupEnd);
                u7Var.ConnectStart = Math.round(beVar.connectStart);
                u7Var.SecureConnectionStart = Math.round(beVar.secureConnectionStart);
                u7Var.ConnectEnd = Math.round(beVar.connectEnd);
                u7Var.RequestStart = Math.round(beVar.requestStart);
                u7Var.ResponseStart = Math.round(beVar.responseStart);
                u7Var.ResponseEnd = Math.round(beVar.responseEnd);
                u7Var.RedirectDuration = Math.round(beVar.redirectEnd - beVar.redirectStart);
                double d3 = beVar.domainLookupStart;
                u7Var.FetchCacheDuration = Math.round(d3 == 0.0d ? 0.0d : d3 - beVar.fetchStart);
                u7Var.DnsLookupDuration = Math.round(beVar.domainLookupEnd - beVar.domainLookupStart);
                u7Var.ConnectionDuration = Math.round(beVar.connectEnd - beVar.connectStart);
                double d4 = beVar.secureConnectionStart;
                u7Var.SecureConnectionDuration = Math.round(d4 == 0.0d ? 0.0d : beVar.connectEnd - d4);
                u7Var.RequestDuration = Math.round(beVar.responseStart - beVar.requestStart);
                double d5 = beVar.responseStart;
                u7Var.ResponseDuration = Math.round(d5 == 0.0d ? 0.0d : beVar.responseEnd - d5);
                u7Var.OverallDuration = Math.round(beVar.duration);
                u7Var.EncodedBodySize = beVar.encodedBodySize;
                u7Var.TransferSize = beVar.transferSize;
                u7Var.DecodedBodySize = beVar.decodedBodySize;
                u7Var.ResourceURL = beVar.name;
                u7Var.ResourceType = beVar.initiatorType;
                arrayList3.add(u7Var);
            }
            this.c.ResourceMeasurement = (u7[]) arrayList3.toArray(new u7[0]);
        }
    }

    private void i() {
        this.e.startListening(this.i);
    }

    private void j() {
        this.e.stopListening();
    }

    /* access modifiers changed from: private */
    public void k() {
        this.u = true;
    }

    public xd e() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void d() {
        ViewGroup viewGroup = (ViewGroup) this.g.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.g);
        }
        this.g.destroy();
        this.x = true;
    }

    public void c() {
        this.w.removeCallbacksAndMessages((Object) null);
        a(false, true);
        if (!this.x) {
            this.g.stopLoading();
            d();
        }
        this.f.a(this.g, zd.a.Cancel);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        c(z2);
        g();
    }

    private void b(String str, boolean z2) {
        a(str, z2);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2, a aVar) {
        i();
        this.s.clear();
        xd xdVar = new xd(this.b, this.d.q());
        this.c = xdVar;
        xdVar.Trigger = aVar;
        xdVar.CellInfo = InsightCore.getRadioController().d();
        this.c.WifiInfo = InsightCore.getWifiController().getWifiInfo();
        this.c.RadioInfo = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        if (this.E) {
            xd xdVar2 = this.c;
            g3 a2 = g3.a(this.a);
            xd xdVar3 = this.c;
            DRI dri = xdVar3.RadioInfo;
            xdVar2.IspInfo = a2.a(dri, xdVar3.WifiInfo, g3.a(dri.ConnectionType));
        }
        this.c.DeviceInfo = CDC.getDeviceInfo(this.a);
        xd xdVar4 = this.c;
        xdVar4.IsCachingEnabled = z2;
        xdVar4.OriginalUrl = aa.a(str);
        this.c.IsAppInForeground = InsightCore.getForegroundTestManager().d();
        this.q = TrafficStats.getUidRxBytes(this.m);
        long uidTxBytes = TrafficStats.getUidTxBytes(this.m);
        this.r = uidTxBytes;
        this.o = this.q;
        this.p = uidTxBytes;
        this.j = true;
        ScheduledExecutorService scheduledExecutorService = this.G;
        Runnable runnable = this.L;
        long j2 = this.h;
        this.F = scheduledExecutorService.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public void b(WebView webView) {
        webView.loadUrl(Q);
    }

    private void c(boolean z2) {
        this.c.Success = z2;
    }

    public void b(String str) {
        this.J = str;
    }

    public void c(String str) {
        this.H = str;
    }

    public void d(String str) {
        this.K = str;
    }

    public void a(String str, boolean z2, long j2, a aVar) {
        if (!this.C) {
            this.C = true;
            WebView webView = this.g;
            if (webView != null) {
                webView.destroy();
            }
            this.A = 0;
            this.B = 0;
            this.v = 0;
            this.u = false;
            this.x = false;
            this.D = false;
            this.y = null;
            this.z.clear();
            if (j2 <= 0) {
                j2 = P;
            }
            this.h = j2;
            this.t = new HashMap<>();
            WebView webView2 = new WebView(this.a);
            this.g = webView2;
            webView2.setOnTouchListener(new a());
            this.g.addJavascriptInterface(new g(this.a), "DTA");
            WebSettings settings = this.g.getSettings();
            if (z2) {
                settings.setCacheMode(-1);
                settings.setAppCacheEnabled(true);
            } else {
                settings.setCacheMode(2);
                settings.setAppCacheEnabled(false);
                this.g.clearCache(true);
            }
            settings.setJavaScriptEnabled(true);
            this.g.setWebViewClient(new b());
            this.g.setWebChromeClient(new c());
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.G = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new d(str, z2, aVar));
        }
    }

    /* access modifiers changed from: private */
    public void a(WebView webView) {
        this.A = this.g.getHeight();
        this.B = this.g.getWidth();
        a(this.u, false);
        this.w.postDelayed(new e(webView), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void a() {
        if (!this.x && !this.D) {
            this.u = true;
            this.g.stopLoading();
        }
    }

    public void a(boolean z2) {
        this.E = z2;
    }

    private void a(boolean z2, boolean z3) {
        if (z3) {
            f();
        } else {
            b(this.g.getUrl(), z2);
        }
        j();
        this.G.shutdown();
        this.C = false;
        v.a((Object) this);
    }

    private void a(String str, boolean z2) {
        ScheduledFuture<?> scheduledFuture = this.F;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.j = false;
        if (this.c != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.c.TimeInfoOnEnd = TimeServer.getTimeInfo();
            xd xdVar = this.c;
            xdVar.Success = z2;
            xdVar.TestsInProgress = aa.a(new ArrayList(this.t.values()), AbstractJsonLexerKt.COMMA, true);
            this.c.FinalUrl = aa.a(str);
            xd xdVar2 = this.c;
            xdVar2.WebViewLoadingTime = elapsedRealtime - this.k;
            xdVar2.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
            this.c.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            if (this.E) {
                xd xdVar3 = this.c;
                if (!xdVar3.IspInfo.SuccessfulIspLookup) {
                    g3 a2 = g3.a(this.a);
                    xd xdVar4 = this.c;
                    xdVar3.IspInfo = a2.a(xdVar4.RadioInfo, xdVar4.WifiInfo, false);
                }
            }
            if (!InsightCore.getInsightConfig().G()) {
                this.c.LocationInfo = this.e.getLastLocationInfo();
            }
            long uidRxBytes = TrafficStats.getUidRxBytes(this.m);
            long uidTxBytes = TrafficStats.getUidTxBytes(this.m);
            xd xdVar5 = this.c;
            xdVar5.RequestTotalRxBytes = uidRxBytes - this.q;
            xdVar5.RequestTotalTxBytes = uidTxBytes - this.r;
            xdVar5.WebViewHeight = this.A;
            xdVar5.WebViewWidth = this.B;
            xdVar5.Meta = this.H;
            xdVar5.CampaignId = this.I;
            xdVar5.SequenceID = this.K;
            xdVar5.CustomerID = this.J;
            xdVar5.NumberOfResources = this.v;
            k5 a3 = a(elapsedRealtime, uidRxBytes, uidTxBytes);
            synchronized (this) {
                if (this.s.isEmpty()) {
                    this.s.add(a3);
                } else {
                    ArrayList<k5> arrayList = this.s;
                    if (arrayList.get(arrayList.size() - 1).Delta < a3.Delta) {
                        this.s.add(a3);
                    }
                }
                this.c.a(this.s);
            }
        }
    }

    /* access modifiers changed from: private */
    public k5 a(long j2, long j3, long j4) {
        k5 k5Var = new k5();
        long j5 = this.h;
        int i2 = this.l;
        this.l = i2 + 1;
        k5Var.Delta = j5 * ((long) i2);
        DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        k5Var.ConnectionType = radioInfoForDefaultDataSim.ConnectionType;
        k5Var.NetworkType = radioInfoForDefaultDataSim.NetworkType;
        k5Var.RxLevel = radioInfoForDefaultDataSim.RXLevel;
        k5Var.NrState = radioInfoForDefaultDataSim.NrState;
        k5Var.DisplayNetworkType = radioInfoForDefaultDataSim.DisplayNetworkType;
        double d2 = (double) (j2 - this.n);
        long j6 = j3 - this.o;
        k5Var.RxBytes = j6;
        k5Var.TxBytes = j4 - this.p;
        double d3 = (double) j6;
        Double.isNaN(d3);
        Double.isNaN(d2);
        k5Var.ThroughputRateRx = Math.round((d3 / d2) * 8.0d * 1000.0d);
        double d4 = (double) k5Var.TxBytes;
        Double.isNaN(d4);
        Double.isNaN(d2);
        k5Var.ThroughputRateTx = Math.round((d4 / d2) * 8.0d * 1000.0d);
        return k5Var;
    }

    public void a(String str) {
        this.I = str;
    }

    public wd(Context context, zd zdVar) {
        this(context, CLC.ProviderMode.Passive, zdVar);
    }
}
