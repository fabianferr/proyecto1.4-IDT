package com.cellrebel.sdk.workers;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.TrafficStats;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.CellInfo;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.PageLoadScore;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.PageLoadMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.ping.IPTools;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CollectPageLoadMetricsWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public volatile CountDownLatch j = new CountDownLatch(2);
    /* access modifiers changed from: private */
    public WebView k;
    /* access modifiers changed from: private */
    public ConnectionType l;
    /* access modifiers changed from: private */
    public int m;
    String n;
    String o;
    long p;
    /* access modifiers changed from: private */
    public long q;
    /* access modifiers changed from: private */
    public long r;
    public PageLoadScore s;
    /* access modifiers changed from: private */
    public List<CellInfo> t;
    private final ScheduledExecutorService u = Executors.newSingleThreadScheduledExecutor();

    class a implements Runnable {
        Long a = null;
        Long b = null;
        Long c = null;
        final /* synthetic */ PageLoadMetric d;
        final /* synthetic */ Context e;
        final /* synthetic */ String f;

        /* renamed from: com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker$a$a  reason: collision with other inner class name */
        class C0076a implements Runnable {
            C0076a() {
            }

            public void run() {
                a.this.c = Long.valueOf(System.currentTimeMillis());
                if (CollectPageLoadMetricsWorker.this.k != null) {
                    CollectPageLoadMetricsWorker.this.k.stopLoading();
                    a.this.d.isPageFailsToLoad(true);
                    a.this.c();
                }
            }
        }

        class b extends WebViewClient {
            b() {
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                a.this.d.isPageFailsToLoad(true);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                webResourceRequest.getUrl().toString();
                Objects.toString(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    a.this.d.isPageFailsToLoad(true);
                }
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                webResourceRequest.getUrl().toString();
                webResourceResponse.getStatusCode();
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                webResourceRequest.getUrl().toString();
                return false;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }
        }

        class c extends WebChromeClient {
            final /* synthetic */ Handler a;

            c(Handler handler) {
                this.a = handler;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ String a(Context context) {
                List unused = CollectPageLoadMetricsWorker.this.t = TelephonyHelper.b().a(context);
                return null;
            }

            public void onProgressChanged(WebView webView, int i) {
                try {
                    String.valueOf(i);
                    super.onProgressChanged(webView, i);
                    a aVar = a.this;
                    if (aVar.b == null && i > 10) {
                        aVar.b = Long.valueOf(System.currentTimeMillis() - a.this.a.longValue());
                        a aVar2 = a.this;
                        aVar2.d.firstByteTime(aVar2.b.longValue());
                        ThreadPoolProvider.a().a(new CollectPageLoadMetricsWorker$a$c$$ExternalSyntheticLambda0(this, a.this.e));
                        Long l = a.this.b;
                    }
                    a aVar3 = a.this;
                    if (System.currentTimeMillis() - a.this.a.longValue() > CollectPageLoadMetricsWorker.this.p) {
                        a.this.c = Long.valueOf(System.currentTimeMillis());
                        if (CollectPageLoadMetricsWorker.this.k != null) {
                            CollectPageLoadMetricsWorker.this.k.stopLoading();
                            a.this.d.isPageFailsToLoad(true);
                            this.a.removeCallbacksAndMessages((Object) null);
                            a.this.c();
                        }
                    } else if (aVar3.c == null && webView.getProgress() == 100) {
                        a.this.c = Long.valueOf(System.currentTimeMillis());
                        this.a.removeCallbacksAndMessages((Object) null);
                        a.this.c();
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
        }

        a(PageLoadMetric pageLoadMetric, Context context, String str) {
            this.d = pageLoadMetric;
            this.e = context;
            this.f = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(PageLoadMetric pageLoadMetric) {
            double d2;
            Settings c2 = SettingsManager.b().c();
            if (c2 == null || !c2.connectionTestPageLoadUrl.contains(pageLoadMetric.pageUrl())) {
                return null;
            }
            PageLoadScore pageLoadScore = new PageLoadScore();
            double d3 = 0.0d;
            if (!pageLoadMetric.isPageFailsToLoad()) {
                double intValue = (double) c2.connectionTestPageLoadScore.intValue();
                double pageLoadTime = (double) pageLoadMetric.pageLoadTime();
                Double.isNaN(pageLoadTime);
                Double.isNaN(intValue);
                d2 = intValue - (pageLoadTime / 1000.0d);
            } else {
                d2 = 0.0d;
            }
            if (d2 > 0.0d) {
                d3 = d2;
            }
            pageLoadScore.c(d3);
            pageLoadScore.a(System.currentTimeMillis());
            Location b2 = TrackingHelper.a().b();
            if (b2 != null) {
                pageLoadScore.a(b2.getLatitude());
                pageLoadScore.b(b2.getLongitude());
            }
            try {
                DatabaseClient.a().n().a(pageLoadScore);
                CollectPageLoadMetricsWorker.this.s = pageLoadScore;
                return null;
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            try {
                CollectPageLoadMetricsWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            try {
                CollectPageLoadMetricsWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        /* access modifiers changed from: private */
        public void c() {
            try {
                CollectPageLoadMetricsWorker.this.a = true;
                if (!this.d.isPageFailsToLoad()) {
                    this.d.pageLoadTime((int) (this.c.longValue() - this.a.longValue()));
                }
                this.d.pageUrl(this.f);
                ConnectionType unused = CollectPageLoadMetricsWorker.this.l = TrackingHelper.a().a(this.e);
                this.d.accessTechEnd(CollectPageLoadMetricsWorker.this.l.toString());
                this.d.accessTechNumChanges(CollectPageLoadMetricsWorker.this.m);
                this.d.bytesSent(TrafficStats.getTotalTxBytes() - CollectPageLoadMetricsWorker.this.q);
                this.d.bytesReceived(TrafficStats.getTotalRxBytes() - CollectPageLoadMetricsWorker.this.r);
                ThreadPoolProvider.a().a(new CollectPageLoadMetricsWorker$a$$ExternalSyntheticLambda0(this, this.d));
                if (CollectPageLoadMetricsWorker.this.t == null || CollectPageLoadMetricsWorker.this.t.isEmpty()) {
                    BaseMetricsWorker.a(this.e, (BaseMetric) this.d, (Runnable) new CollectPageLoadMetricsWorker$a$$ExternalSyntheticLambda2(this));
                } else {
                    BaseMetricsWorker.a(this.e, (BaseMetric) this.d, (List<CellInfo>) CollectPageLoadMetricsWorker.this.t, (Runnable) new CollectPageLoadMetricsWorker$a$$ExternalSyntheticLambda1(this));
                }
                CollectPageLoadMetricsWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused2) {
            }
        }

        public void run() {
            try {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new C0076a(), CollectPageLoadMetricsWorker.this.p);
                WebView unused = CollectPageLoadMetricsWorker.this.k = new WebView(this.e);
                CollectPageLoadMetricsWorker.this.k.setWebViewClient(new b());
                CollectPageLoadMetricsWorker.this.k.setWebChromeClient(new c(handler));
                WebSettings settings = CollectPageLoadMetricsWorker.this.k.getSettings();
                settings.setCacheMode(2);
                settings.setSaveFormData(false);
                settings.setDatabaseEnabled(false);
                if (Build.VERSION.SDK_INT >= 26) {
                    settings.setSafeBrowsingEnabled(false);
                }
                CollectPageLoadMetricsWorker.this.k.loadUrl(this.f);
                this.a = Long.valueOf(System.currentTimeMillis());
            } catch (Exception | OutOfMemoryError unused2) {
                this.d.isPageFailsToLoad(true);
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.j.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    private void a(Context context, String str) {
        try {
            PageLoadMetric pageLoadMetric = new PageLoadMetric();
            pageLoadMetric.measurementSequenceId = this.n;
            pageLoadMetric.pageUrl(str);
            pageLoadMetric.serverIp = IPTools.a(str);
            if (!TrackingHelper.a().c()) {
                pageLoadMetric.stateDuringMeasurement(500);
                this.j = new CountDownLatch(1);
                this.a = true;
                BaseMetricsWorker.a(context, (BaseMetric) pageLoadMetric, (Runnable) new CollectPageLoadMetricsWorker$$ExternalSyntheticLambda2(this));
                try {
                    this.j.await();
                } catch (Exception | OutOfMemoryError unused) {
                }
            } else {
                if (this.b) {
                    pageLoadMetric.stateDuringMeasurement(100);
                } else if (BaseMetricsWorker.h) {
                    PageLoadMetric pageLoadMetric2 = pageLoadMetric;
                    Utils.a(pageLoadMetric2, BaseMetricsWorker.h, this.c, (PowerManager) context.getSystemService("power"), this.b, this.d, this.e, this.f, this.g);
                } else {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (this.c) {
                        pageLoadMetric.stateDuringMeasurement(200);
                    } else if (powerManager == null || !powerManager.isScreenOn()) {
                        pageLoadMetric.stateDuringMeasurement(2);
                    } else {
                        pageLoadMetric.stateDuringMeasurement(1);
                    }
                }
                ConnectionType a2 = TrackingHelper.a().a(context);
                this.l = a2;
                pageLoadMetric.accessTechStart(a2.toString());
                a(context, str, pageLoadMetric);
            }
        } catch (Exception | OutOfMemoryError unused2) {
        }
    }

    private void a(Context context, String str, PageLoadMetric pageLoadMetric) {
        new Handler(Looper.getMainLooper()).post(new a(pageLoadMetric, context, str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            WebView webView = this.k;
            if (webView != null) {
                webView.destroy();
                this.k.destroyDrawingCache();
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Context context) {
        try {
            ConnectionType a2 = TrackingHelper.a().a(context);
            if (a2 != this.l) {
                this.m++;
            }
            this.l = a2;
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), PHI: r1 
      PHI: (r1v3 java.util.concurrent.ScheduledFuture<?>) = (r1v0 java.util.concurrent.ScheduledFuture<?>), (r1v4 java.util.concurrent.ScheduledFuture<?>), (r1v4 java.util.concurrent.ScheduledFuture<?>), (r1v4 java.util.concurrent.ScheduledFuture<?>), (r1v4 java.util.concurrent.ScheduledFuture<?>) binds: [B:4:0x000c, B:6:0x0040, B:9:0x0048, B:10:?, B:7:?] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:4:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r11) {
        /*
            r10 = this;
            super.a((android.content.Context) r11)
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            r0 = 1
            r1 = 0
            long r2 = r10.p     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r10.p = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            long r2 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r10.q = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            long r2 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r10.r = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            com.cellrebel.sdk.utils.TrackingHelper r2 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            com.cellrebel.sdk.database.ConnectionType r2 = r2.a((android.content.Context) r11)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r10.l = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            java.lang.String r2 = r10.o     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r10.a((android.content.Context) r11, (java.lang.String) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker$$ExternalSyntheticLambda0 r4 = new com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker$$ExternalSyntheticLambda0     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r4.<init>(r10, r11)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            java.util.concurrent.ScheduledExecutorService r3 = r10.u     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r5 = 0
            r7 = 500(0x1f4, double:2.47E-321)
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            java.util.concurrent.ScheduledFuture r1 = r3.scheduleAtFixedRate(r4, r5, r7, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            java.util.concurrent.CountDownLatch r11 = r10.j     // Catch:{ InterruptedException -> 0x0048, Exception | OutOfMemoryError -> 0x0046 }
            r11.await()     // Catch:{ InterruptedException -> 0x0048, Exception | OutOfMemoryError -> 0x0046 }
            goto L_0x0048
        L_0x0046:
            goto L_0x0064
        L_0x0048:
            android.os.Handler r11 = new android.os.Handler     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r11.<init>(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker$$ExternalSyntheticLambda1 r2 = new com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker$$ExternalSyntheticLambda1     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r2.<init>(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r11.post(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            r1.cancel(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0046, all -> 0x005d }
            goto L_0x0066
        L_0x005d:
            r11 = move-exception
            if (r1 == 0) goto L_0x0063
            r1.cancel(r0)
        L_0x0063:
            throw r11
        L_0x0064:
            if (r1 == 0) goto L_0x0069
        L_0x0066:
            r1.cancel(r0)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker.a(android.content.Context):void");
    }

    public void a(boolean z) {
    }
}
