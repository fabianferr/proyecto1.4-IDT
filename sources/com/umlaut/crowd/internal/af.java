package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.ze;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class af {
    static final String X = "umlautYoutubeApi";
    /* access modifiers changed from: private */
    public static final String Y = "com.umlaut.crowd.internal.af";
    private static final boolean Z = false;
    private static final String a0 = "https://www.youtube.com";
    private static final long b0 = 60000;
    /* access modifiers changed from: private */
    public final int A;
    /* access modifiers changed from: private */
    public final Context B;
    private final String C;
    /* access modifiers changed from: private */
    public final Object D;
    /* access modifiers changed from: private */
    public final Handler E;
    /* access modifiers changed from: private */
    public final Handler F;
    /* access modifiers changed from: private */
    public final ze G;
    /* access modifiers changed from: private */
    public final CLC H;
    private final CLC.ProviderMode I;
    /* access modifiers changed from: private */
    public WebView J;
    /* access modifiers changed from: private */
    public Map<Long, l5> K;
    /* access modifiers changed from: private */
    public SparseArray<df> L;
    private ScheduledFuture<?> M;
    /* access modifiers changed from: private */
    public ScheduledExecutorService N;
    /* access modifiers changed from: private */
    public bf O;
    /* access modifiers changed from: private */
    public String P;
    /* access modifiers changed from: private */
    public String Q;
    /* access modifiers changed from: private */
    public String R;
    /* access modifiers changed from: private */
    public String S;
    /* access modifiers changed from: private */
    public boolean T;
    private final Runnable U;
    /* access modifiers changed from: private */
    public final Runnable V;
    private final WebViewClient W;
    private boolean a;
    /* access modifiers changed from: private */
    public boolean b;
    /* access modifiers changed from: private */
    public boolean c;
    /* access modifiers changed from: private */
    public boolean d;
    /* access modifiers changed from: private */
    public boolean e;
    /* access modifiers changed from: private */
    public int f;
    /* access modifiers changed from: private */
    public volatile float g;
    /* access modifiers changed from: private */
    public volatile long h;
    /* access modifiers changed from: private */
    public long i;
    /* access modifiers changed from: private */
    public long j;
    private long k;
    private int l;
    /* access modifiers changed from: private */
    public long m;
    /* access modifiers changed from: private */
    public long n;
    /* access modifiers changed from: private */
    public long o;
    private long p;
    /* access modifiers changed from: private */
    public long q;
    private long r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public long t;
    private int u;
    private int v;
    /* access modifiers changed from: private */
    public xe w;
    /* access modifiers changed from: private */
    public ye x;
    /* access modifiers changed from: private */
    public l2 y;
    /* access modifiers changed from: private */
    public HashMap<Object, w2> z;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ ye d;
        final /* synthetic */ long e;
        final /* synthetic */ cf f;
        final /* synthetic */ a g;

        /* renamed from: com.umlaut.crowd.internal.af$a$a  reason: collision with other inner class name */
        class C0173a implements Runnable {
            C0173a() {
            }

            public void run() {
                a aVar = a.this;
                String a2 = af.this.a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f);
                af.this.G.a(af.this.J, ze.a.Start, (String) null);
                af.this.J.loadDataWithBaseURL(af.a0, a2, "text/html", "UTF-8", (String) null);
            }
        }

        a(String str, int i, int i2, ye yeVar, long j, cf cfVar, a aVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = yeVar;
            this.e = j;
            this.f = cfVar;
            this.g = aVar;
        }

        public void run() {
            v.a((Object) af.this, w2.YT);
            af.this.m();
            af.this.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            af.this.E.post(new C0173a());
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.ye[] r0 = com.umlaut.crowd.internal.ye.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.HD2160     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.HD1440     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.HD1080     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.HD720     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.Large     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.Medium     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.Small     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.umlaut.crowd.internal.ye r1 = com.umlaut.crowd.internal.ye.Tiny     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.af.b.<clinit>():void");
        }
    }

    class c implements Runnable {
        final /* synthetic */ boolean a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                af.this.d();
                af.this.c();
                af.this.F.removeCallbacks(af.this.V);
                af.this.N.shutdown();
            }
        }

        c(boolean z) {
            this.a = z;
        }

        public void run() {
            af.this.O.CellInfoOnEnd = InsightCore.getRadioController().d();
            if (af.this.B != null) {
                af.this.O.BatteryInfoOnEnd = new x(af.this.B).a();
            }
            af.this.O.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
            af.this.O.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            long uidRxBytes = TrafficStats.getUidRxBytes(af.this.A);
            long uidTxBytes = TrafficStats.getUidTxBytes(af.this.A);
            af.this.O.RequestTotalRxBytes = uidRxBytes - af.this.i;
            af.this.O.RequestTotalTxBytes = uidTxBytes - af.this.j;
            af.this.O.TotalDroppedFrames = af.this.f;
            af.this.O.a(new ArrayList(af.this.K.values()));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < af.this.L.size(); i++) {
                arrayList.add(af.this.L.get(af.this.L.keyAt(i)));
            }
            af.this.O.YoutubeVideoInfo = (df[]) arrayList.toArray(new df[0]);
            af.this.O.Meta = af.this.P;
            af.this.O.CampaignId = af.this.Q;
            af.this.O.SequenceID = af.this.S;
            af.this.O.CustomerID = af.this.R;
            af.this.O.TestEndState = af.this.y;
            af.this.O.TestsInProgress = aa.a(new ArrayList(af.this.z.values()), AbstractJsonLexerKt.COMMA, true);
            if (af.this.T && !af.this.O.IspInfo.SuccessfulIspLookup) {
                af.this.O.IspInfo = g3.a(af.this.B).a(af.this.O.RadioInfoOnStart, af.this.O.WifiInfoOnStart, false);
            }
            if (!InsightCore.getInsightConfig().H()) {
                af.this.O.LocationInfoOnEnd = af.this.H.getLastLocationInfo();
            }
            af afVar = af.this;
            String b2 = af.Y;
            afVar.a(b2, "Result: " + JsonUtils.toJson(af.this.O));
            v.a((Object) af.this);
            af.this.o();
            if (this.a) {
                af.this.k();
                af.this.a(ze.a.End, (String) null);
            }
            af.this.E.post(new a());
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            synchronized (this) {
                if (af.this.J != null) {
                    ViewGroup viewGroup = (ViewGroup) af.this.J.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(af.this.J);
                    }
                    af.this.J.destroy();
                    af.this.a(af.Y, "WebView Destroyed");
                }
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        public void run() {
            if (af.this.J != null) {
                WebView s = af.this.J;
                s.evaluateJavascript("javascript: " + this.a, (ValueCallback) null);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        f(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        public void run() {
            long j = this.a;
            af.this.G.a(this.b, this.c, j > 0 ? j : 0);
        }
    }

    class g implements Runnable {
        final /* synthetic */ ze.a a;
        final /* synthetic */ String b;

        g(ze.a aVar, String str) {
            this.a = aVar;
            this.b = str;
        }

        public void run() {
            af.this.G.a(af.this.J, this.a, this.b);
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            if (af.this.d) {
                af.this.q();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uidRxBytes = TrafficStats.getUidRxBytes(af.this.A);
                long uidTxBytes = TrafficStats.getUidTxBytes(af.this.A);
                xe x = af.this.w;
                k kVar = new k(af.this, (a) null);
                af afVar = af.this;
                long j = uidTxBytes;
                long j2 = uidRxBytes;
                long j3 = elapsedRealtime;
                l5 a2 = afVar.a(x, afVar.x, elapsedRealtime, af.this.h, af.this.g, uidRxBytes, j, kVar, true);
                synchronized (af.this.D) {
                    if (af.this.c && x != xe.Ended && !af.this.K.containsKey(Long.valueOf(a2.Delta))) {
                        af.this.K.put(Long.valueOf(a2.Delta), a2);
                    }
                }
                long unused = af.this.m = j3;
                long unused2 = af.this.n = j2;
                long unused3 = af.this.o = j;
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            af.this.O.ErrorCode = "Test Interrupted.";
            af.this.e();
        }
    }

    public class l {
        public l() {
        }

        private long a(float f, float f2) {
            double d = (double) f;
            Double.isNaN(d);
            long round = Math.round(d * 1000.0d);
            long unused = af.this.h = round;
            float unused2 = af.this.g = f2;
            return round;
        }

        @JavascriptInterface
        public void currentValues(float f, float f2) {
            long a2 = a(f, f2);
            af.this.a(a2, (long) (f2 * 1000.0f), (long) ((((float) af.this.O.TotalDuration) * f2) - ((float) a2)));
            if (af.this.O.IsLiveStream && af.this.O.PlayerEndTime > 0) {
                if (af.this.q <= 0) {
                    long unused = af.this.q = (long) f;
                }
                float H = f - ((float) af.this.q);
                if (H > 0.0f && H > ((float) af.this.O.PlayerEndTime)) {
                    long unused2 = af.this.q = Long.MAX_VALUE;
                    af.this.O.Success = true;
                    l2 unused3 = af.this.y = l2.END;
                    af.this.a(true);
                }
            }
        }

        @JavascriptInterface
        public void onYouTubeAPIReady() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            xe unused = af.this.w = xe.Creating;
            af afVar = af.this;
            afVar.a(afVar.w, af.this.x, elapsedRealtime, af.this.h, af.this.g, (k) null);
        }

        @JavascriptInterface
        public void playerDuration(float f) {
            if (!af.this.O.IsLiveStream) {
                af afVar = af.this;
                String b = af.Y;
                afVar.a(b, "playerDuration: " + f);
                af.this.O.TotalDuration = (long) (f * 1000.0f);
            }
        }

        @JavascriptInterface
        public void playerError(String str) {
            af afVar = af.this;
            String b = af.Y;
            afVar.a(b, "playerError: " + str);
            bf O = af.this.O;
            O.ErrorCode = ": " + str + " -> " + af.this.a(str);
            af.this.e();
            af.this.a(ze.a.Error, str);
        }

        @JavascriptInterface
        public void playerIsReady(String str) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (af.this.c) {
                xe unused = af.this.w = xe.Ready;
                af afVar = af.this;
                afVar.a(afVar.w, af.this.x, elapsedRealtime, af.this.h, af.this.g, (k) null);
                af.this.O.WebViewWidth = af.this.J.getWidth();
                af.this.O.WebViewHeight = af.this.J.getHeight();
                l2 unused2 = af.this.y = l2.INIT_TEST;
                af afVar2 = af.this;
                String b = af.Y;
                afVar2.a(b, "playerIsReady: " + str);
            }
        }

        @JavascriptInterface
        public void playerQualityChanged(String str, float f, float f2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long a2 = a(f, f2);
            ye unused = af.this.x = ye.getName(str);
            af afVar = af.this;
            afVar.a(xe.QualityChanged, afVar.x, elapsedRealtime, a2, f2, (k) null);
            af afVar2 = af.this;
            String b = af.Y;
            afVar2.a(b, "playerQualityChanged: " + str);
        }

        @JavascriptInterface
        public void playerStateChanged(String str, float f, float f2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long a2 = a(f, f2);
            xe unused = af.this.w = xe.getState(str);
            xe x = af.this.w;
            xe xeVar = xe.Ended;
            if (x != xeVar || !af.this.e) {
                af afVar = af.this;
                afVar.a(afVar.w, af.this.x, elapsedRealtime, a2, f2, (k) null);
            }
            if (af.this.w != xeVar || af.this.O.IsLiveStream) {
                if (af.this.w == xe.Buffering) {
                    l2 unused2 = af.this.y = l2.PERFORM_TEST;
                } else if (af.this.w == xe.Paused) {
                    if (!af.this.b && af.this.c) {
                        af.this.n();
                    }
                } else if (af.this.w == xe.Playing) {
                    boolean unused3 = af.this.b = false;
                    l2 unused4 = af.this.y = l2.PERFORM_TEST;
                    if (af.this.O.VideoStartTime == -1) {
                        af.this.O.VideoStartTime = elapsedRealtime - af.this.s;
                    }
                    if (af.this.O.VideoLoadTime == -1) {
                        af.this.O.VideoLoadTime = elapsedRealtime - af.this.t;
                    }
                    if (af.this.O.TotalDuration <= 0 && !af.this.O.IsLiveStream) {
                        af.this.f();
                    }
                } else if (af.this.w == xe.Unstarted) {
                    long unused5 = af.this.t = elapsedRealtime;
                }
                af afVar2 = af.this;
                String b = af.Y;
                afVar2.a(b, "playerStateChanged: " + af.this.w);
                af afVar3 = af.this;
                afVar3.a(ze.a.Change, afVar3.w.name());
                return;
            }
            boolean unused6 = af.this.e = true;
            af.this.O.Success = true;
            l2 unused7 = af.this.y = l2.END;
            af.this.a(true);
        }

        @JavascriptInterface
        public void requestingAPI() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            xe unused = af.this.w = xe.DownloadingPlayer;
            af afVar = af.this;
            afVar.a(afVar.w, af.this.x, elapsedRealtime, af.this.h, af.this.g, (k) null);
            long unused2 = af.this.s = elapsedRealtime;
        }
    }

    public af(Context context, CLC.ProviderMode providerMode, ze zeVar) {
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.u = -1;
        this.v = -1;
        this.w = xe.Unknown;
        this.x = ye.Unknown;
        this.y = l2.UNKNOWN;
        this.D = new Object();
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = "";
        this.U = new h();
        this.V = new i();
        this.W = new j();
        this.B = context;
        this.G = zeVar;
        this.I = providerMode;
        this.H = new CLC(context);
        this.E = new Handler();
        this.F = new Handler();
        this.C = InsightCore.getInsightConfig().f1();
        this.A = Process.myUid();
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2) {
    }

    /* access modifiers changed from: private */
    public void k() {
        InsightCore.getDatabaseHelper().a(w2.YT, (RBR) this.O);
    }

    /* access modifiers changed from: private */
    public void l() {
        this.F.removeCallbacks(this.V);
        this.F.postDelayed(this.V, this.r);
    }

    /* access modifiers changed from: private */
    public void m() {
        this.H.startListening(this.I);
    }

    /* access modifiers changed from: private */
    public void n() {
        b("player.playVideo();");
    }

    /* access modifiers changed from: private */
    public void o() {
        this.H.stopListening();
    }

    /* access modifiers changed from: private */
    public void q() {
        b("if (player !== null && typeof player.getPlayerState === \"function\") {umlautYoutubeApi.currentValues(player.getCurrentTime(), player.getVideoLoadedFraction());}");
    }

    public boolean h() {
        return this.c;
    }

    public void i() {
        if (!this.b && this.c) {
            this.b = true;
            b("player.pauseVideo();");
        }
    }

    public void j() {
        if (this.b && this.c) {
            n();
        }
    }

    public void p() {
        if (this.c) {
            this.y = l2.ABORTED;
            d(true);
        }
    }

    static /* synthetic */ int a(af afVar, int i2) {
        int i3 = afVar.f + i2;
        afVar.f = i3;
        return i3;
    }

    private void d(boolean z2) {
        if (this.c) {
            this.O.Success = false;
            a(z2);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        b("umlautYoutubeApi.playerDuration(player.getDuration());");
    }

    public void e(boolean z2) {
        this.a = z2;
        if (this.c) {
            StringBuilder sb = new StringBuilder("if (player !== null) { player.");
            sb.append(z2 ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : "unMute");
            sb.append("(); }");
            b(sb.toString());
        }
    }

    public bf g() {
        return this.O;
    }

    private void c(boolean z2) {
        ScheduledFuture<?> scheduledFuture = this.M;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.d = false;
        this.c = false;
        this.O.TimeInfoOnEnd = TimeServer.getTimeInfo();
        this.N.execute(new c(z2));
    }

    public void f(String str) {
        this.S = str;
    }

    private class k {
        int a;
        long b;
        long c;
        String d;

        private k() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = "";
        }

        /* access modifiers changed from: package-private */
        public long a() {
            long j = this.b;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            long j2 = this.c;
            if (i > 0) {
                j2 = (j2 - j) + 1;
            }
            return Math.abs(j2);
        }

        /* synthetic */ k(af afVar, a aVar) {
            this();
        }
    }

    public void b(String str, int i2, int i3, ye yeVar, long j2, cf cfVar, a aVar) {
        if (!this.c) {
            WebView webView = this.J;
            if (webView != null) {
                webView.destroy();
            }
            WebView webView2 = new WebView(this.B);
            this.J = webView2;
            webView2.addJavascriptInterface(new l(), X);
            WebSettings settings = this.J.getSettings();
            settings.setCacheMode(2);
            settings.setAppCacheEnabled(false);
            this.J.clearCache(true);
            if (cfVar == cf.DESKTOP_TEST) {
                settings.setUserAgentString(InsightCore.getInsightConfig().n2());
            }
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            this.J.setWebViewClient(this.W);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.N = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new a(str, i2, i3, yeVar, j2, cfVar, aVar));
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        b("if (player !== null) { player.destroy(); }");
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.c) {
            String str = Y;
            a(str, "failedVideo: Test failed = " + this.O.ErrorCode);
            this.O.Success = false;
            this.y = l2.n;
            a(true);
            a(ze.a.Error, this.O.ErrorCode);
        }
    }

    public void d(String str) {
        this.R = str;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.B != null && this.J != null) {
            this.E.post(new d());
        }
    }

    public void e(String str) {
        this.P = str;
    }

    public void c(String str) {
        this.Q = str;
    }

    class j extends WebViewClient {
        j() {
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 23) {
                if (webResourceError.getDescription().toString().contains("CHUNKED")) {
                    str = ": " + webResourceError.getErrorCode() + " -> " + webResourceError.getDescription();
                } else {
                    str = ": " + webResourceError.getErrorCode() + " -> " + webResourceError.getDescription();
                    af.this.O.ErrorCode = str;
                }
                af.this.l();
            } else {
                str = "";
            }
            af.this.a(af.Y, "onReceivedError = " + str);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT < 23 || webResourceResponse == null) {
                str = "";
            } else {
                str = ": " + webResourceResponse.getStatusCode() + " -> " + webResourceResponse.getReasonPhrase();
            }
            af.this.a(af.Y, "onReceivedHttpError = " + str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.proceed();
            af afVar = af.this;
            String b = af.Y;
            afVar.a(b, "onReceivedSslError: " + sslError.getPrimaryError() + " , url = " + sslError.getUrl());
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String str2 = str;
            try {
                if (str2.contains("googlevideo.com/videoplayback")) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ye y = af.this.x;
                    xe x = af.this.w;
                    Uri parse = Uri.parse(str);
                    k kVar = new k(af.this, (a) null);
                    String queryParameter = parse.getQueryParameter("itag");
                    if (queryParameter != null && !queryParameter.isEmpty()) {
                        kVar.a = Integer.parseInt(queryParameter);
                    }
                    String queryParameter2 = parse.getQueryParameter("range");
                    if (queryParameter2 != null && !queryParameter2.isEmpty()) {
                        String[] split = queryParameter2.split("-");
                        if (split.length > 1) {
                            kVar.b = Long.parseLong(split[0]);
                            kVar.c = Long.parseLong(split[1]);
                        }
                    }
                    String queryParameter3 = parse.getQueryParameter("mime");
                    if (queryParameter3 != null && !queryParameter3.isEmpty()) {
                        kVar.d = URLDecoder.decode(queryParameter3, "UTF-8");
                    }
                    String queryParameter4 = parse.getQueryParameter("source");
                    if (queryParameter4 != null && af.this.O != null && !af.this.O.IsLiveStream && queryParameter4.equalsIgnoreCase("yt_live_broadcast")) {
                        af.this.O.IsLiveStream = true;
                    }
                    String queryParameter5 = parse.getQueryParameter("requiressl");
                    if (!(queryParameter5 == null || af.this.O == null || af.this.O.IsSSL)) {
                        af.this.O.IsSSL = queryParameter5.equalsIgnoreCase("yes");
                    }
                    synchronized (this) {
                        af afVar = af.this;
                        afVar.a(x, y, elapsedRealtime, afVar.h, af.this.g, kVar);
                    }
                } else if (str2.contains("stats/qoe")) {
                    Uri parse2 = Uri.parse(str);
                    String queryParameter6 = parse2.getQueryParameter("df");
                    if (queryParameter6 != null && queryParameter6.length() > 0) {
                        String[] split2 = queryParameter6.split(CertificateUtil.DELIMITER);
                        if (split2.length > 1) {
                            int parseInt = Integer.parseInt(split2[1]);
                            af.a(af.this, parseInt);
                            af afVar2 = af.this;
                            String b = af.Y;
                            afVar2.a(b, "Dropped Frames = " + parseInt + "  ,  Total DF = " + af.this.f);
                        }
                    }
                    String queryParameter7 = parse2.getQueryParameter("ctmp");
                    if (queryParameter7 != null && queryParameter7.length() > 0) {
                        String[] split3 = queryParameter7.split(CertificateUtil.DELIMITER);
                        if (split3.length > 1 && split3[0].contains("loudness")) {
                            Float valueOf = Float.valueOf(split3[1]);
                            if (valueOf == null || valueOf.isNaN() || valueOf.isInfinite()) {
                                af.this.O.Loudness = 0.0f;
                            } else {
                                af.this.O.Loudness = valueOf.floatValue();
                            }
                        }
                    }
                    String queryParameter8 = parse2.getQueryParameter("cbr");
                    if (queryParameter8 != null && queryParameter8.length() > 0) {
                        String decode = URLDecoder.decode(queryParameter8, "UTF-8");
                        af afVar3 = af.this;
                        String b2 = af.Y;
                        afVar3.a(b2, "Current Browser: " + decode);
                    }
                }
            } catch (Exception e) {
                af.this.b(af.Y, e.getMessage());
            }
            af afVar4 = af.this;
            String b3 = af.Y;
            afVar4.a(b3, "shouldInterceptRequest: " + str2);
            af.this.l();
            return super.shouldInterceptRequest(webView, str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            af afVar = af.this;
            String b = af.Y;
            afVar.a(b, "shouldOverrideUrlLoading: " + str);
            if (!str.contains("ytplayer://onYouTubeIframeAPIFailedToLoad")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            af.this.l();
            return true;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3;
            super.onReceivedError(webView, i, str, str2);
            if (str.contains("CHUNKED")) {
                str3 = ": " + i + " -> " + str;
            } else if (Build.VERSION.SDK_INT < 23) {
                str3 = ": " + i + " -> " + str;
                af.this.O.ErrorCode = str3;
            } else {
                str3 = "";
            }
            af.this.l();
            af.this.a(af.Y, "onReceivedError Old = " + str3);
        }
    }

    public void a() {
        if (this.c) {
            d(false);
        }
    }

    public void a(int i2, int i3) {
        this.u = i2;
        this.v = i3;
    }

    public void a(String str, int i2, int i3, int i4, long j2, String str2, long j3, a aVar) {
        this.r = j3;
        a(str, i2, i3, i4, j2, str2, aVar);
    }

    public void a(String str, int i2, int i3, int i4, long j2, String str2, a aVar) {
        StringBuilder sb = new StringBuilder();
        int i5 = i4;
        sb.append(i4);
        sb.append("p");
        ye quality = ye.getQuality(sb.toString());
        cf cfVar = cf.Unknown;
        try {
            cfVar = cf.valueOf(str2);
        } catch (Exception unused) {
        }
        b(str, i2, i3, quality, j2, cfVar, aVar);
    }

    /* access modifiers changed from: private */
    public String a(String str, int i2, int i3, ye yeVar, cf cfVar) {
        String str2;
        String str3;
        int i4;
        int i5;
        c2 c2Var = this.O.DeviceInfo.DisplayInfo;
        int i6 = c2Var.DisplayPixelWidth;
        int i7 = c2Var.DisplayPixelHeight;
        String lowerCase = ye.Default.name().toLowerCase();
        if (!(yeVar == null || yeVar == ye.Unknown || yeVar == ye.Auto)) {
            lowerCase = yeVar.name().toLowerCase();
        }
        if (cfVar != cf.DEVICE_TEST || yeVar == null || yeVar == ye.Unknown || i6 <= 0 || i7 <= 0) {
            str3 = "100%";
            str2 = str3;
        } else {
            switch (b.a[yeVar.ordinal()]) {
                case 1:
                    i5 = 3840;
                    i4 = 2160;
                    break;
                case 2:
                    i5 = 2560;
                    i4 = 1440;
                    break;
                case 3:
                    i5 = 1920;
                    i4 = 1080;
                    break;
                case 4:
                    i5 = 1280;
                    i4 = 720;
                    break;
                case 5:
                    i5 = 854;
                    i4 = 480;
                    break;
                case 6:
                    i5 = 640;
                    i4 = 360;
                    break;
                case 7:
                    i5 = 426;
                    i4 = 240;
                    break;
                case 8:
                    i5 = 256;
                    i4 = 144;
                    break;
                default:
                    i5 = 0;
                    i4 = 0;
                    break;
            }
            if (i5 > 0) {
                str3 = String.valueOf(i5);
                str2 = String.valueOf(i4);
            } else if (i7 > i6) {
                str3 = String.valueOf(i7);
                str2 = String.valueOf(i6);
            } else {
                str3 = String.valueOf(i6);
                str2 = String.valueOf(i7);
            }
        }
        int i8 = this.u;
        if (i8 > 0) {
            str3 = String.valueOf(i8);
        }
        int i9 = this.v;
        if (i9 > 0) {
            str2 = String.valueOf(i9);
        }
        String str4 = Y;
        a(str4, "Display size = " + str3 + " x " + str2);
        if (str3.equals("100%") && str2.equals("100%")) {
            this.J.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        return String.format(Locale.getDefault(), "<html>\n<head>\n<style>\nbody { margin: 0; width:100%% !important; height:100%% !important;  background-color:#ffffff; }\nhtml { width:100%% !important; height:100%% !important; background-color:#ffffff; }\n\n</style>\n</head>\n<body>\n<div id=\"player\" style=\"pointer-events: none;\" />\n<script>\nvar tag = document.createElement('script');\ntag.src = \"https://www.youtube.com/iframe_api\";\nvar firstScriptTag = document.getElementsByTagName('script')[0];\numlautYoutubeApi.requestingAPI();\nfirstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\nvar player;\nvar error = false;\n\nvar suggestedQuality = \"%3$s\";\nvar videoId = \"%4$s\";\nvar startTime = %5$d;\nvar endTime = %6$d;\nvar shouldMute = %7$b;\n\nfunction onYouTubeIframeAPIReady() {\n   umlautYoutubeApi.onYouTubeAPIReady();\n    player = new YT.Player('player', {\n        width: '%1$s',\n        height: '%2$s',\n        videoId: videoId,\n        playerVars : {\n           'rel' : 0,\n           'controls' : 0,\n           'enablejsapi' : 1,\n           'iv_load_policy' : 3,\n           'fs' : 0,\n           'playsinline' : 1,\n           'modestbranding' : 1,\n           'autoplay' : 0,\n           'end' : endTime > 0 ? endTime : -1,\n           'start' : startTime > 0 ? startTime : 0\n        },\n        events : {\n            'onPlaybackQualityChange' : onPlaybackQualityChange,\n            'onReady' : onReady,\n            'onError' : onPlayerError,\n            'onStateChange' : onStateChange\n        }\n    });\n    \n    window.setInterval(getCurrentTime, 100);\n}\nfunction getCurrentTime() {\n   if (player !== null && typeof player.getPlayerState === \"function\") {\n        var time = player.getCurrentTime();\n        var buffer = player.getVideoLoadedFraction();\n        umlautYoutubeApi.currentValues(time, buffer);\n   }\n}\n\nfunction startPlaying(event) {\n   if (startTime < 0) {\n       startTime = 0;\n   }\n   if (endTime > 0) {\n       event.target.loadVideoById({'videoId': videoId, 'startSeconds': startTime, 'endSeconds': endTime, 'suggestedQuality': suggestedQuality});\n   }\n   else {\n       event.target.loadVideoById(videoId, startTime, suggestedQuality);\n   }\n}\nfunction onReady(event) {\n    umlautYoutubeApi.playerIsReady(event.data);\n    if (shouldMute) {\n       event.target.mute();\n    }\n    else {\n       event.target.unMute();\n    }\n    event.target.playVideo();\n}\n\nfunction onStateChange(event) {\n    if (!error) {\n        var playerTime = player.getCurrentTime();\n        var buffer = player.getVideoLoadedFraction();\n        umlautYoutubeApi.playerStateChanged(event.data, playerTime, buffer);\n        if (shouldMute) {\n           player.mute();\n        }\n        else {\n           player.unMute();\n        }\n    }\n}\n\nfunction onPlaybackQualityChange(event) {\n    var time = player.getCurrentTime();\n    var buffer = player.getVideoLoadedFraction();\n    umlautYoutubeApi.playerQualityChanged(event.data, time, buffer);\n}\n\nfunction onPlayerError(event) {\n    error = true;\n    umlautYoutubeApi.playerError(event.data);\n}\n\nfunction startVideo() {\n    player.playVideo();\n}\n\n</script>\n</body>\n</html>", new Object[]{str3, str2, lowerCase, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.a)});
    }

    public void b(boolean z2) {
        this.T = z2;
    }

    private void b(String str) {
        if (this.J != null && this.B != null) {
            this.E.post(new e(str));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2, int i3, ye yeVar, long j2, cf cfVar, a aVar) {
        long j3 = j2;
        this.q = 0;
        this.h = 0;
        this.g = 0.0f;
        this.t = 0;
        this.s = 0;
        boolean z2 = false;
        this.f = 0;
        this.c = true;
        this.e = false;
        this.z = new HashMap<>();
        this.y = l2.INIT;
        this.w = xe.Unknown;
        this.x = ye.Unknown;
        this.K = new HashMap();
        this.L = new SparseArray<>();
        bf bfVar = new bf(this.C, InsightCore.getGUID());
        this.O = bfVar;
        bfVar.Trigger = aVar;
        bfVar.CellInfoOnStart = InsightCore.getRadioController().d();
        this.O.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
        this.O.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        if (this.T) {
            bf bfVar2 = this.O;
            g3 a2 = g3.a(this.B);
            bf bfVar3 = this.O;
            DRI dri = bfVar3.RadioInfoOnStart;
            bfVar2.IspInfo = a2.a(dri, bfVar3.WifiInfoOnStart, g3.a(dri.ConnectionType));
        }
        if (this.r <= 0) {
            this.r = 60000;
        }
        this.O.TimeInfoOnStart = TimeServer.getTimeInfo();
        this.O.BatteryInfoOnStart = new x(this.B).a();
        this.O.DeviceInfo = CDC.getDeviceInfo(this.B);
        if (!InsightCore.getInsightConfig().H()) {
            this.O.LocationInfoOnStart = this.H.getLastLocationInfo();
        }
        this.i = TrafficStats.getUidRxBytes(this.A);
        long uidTxBytes = TrafficStats.getUidTxBytes(this.A);
        this.j = uidTxBytes;
        this.n = this.i;
        this.o = uidTxBytes;
        bf bfVar4 = this.O;
        bfVar4.Success = false;
        bfVar4.ErrorCode = "";
        bfVar4.VideoId = str;
        bfVar4.YoutubeTestType = cfVar;
        bfVar4.PlayerEndTime = i3;
        bfVar4.PlayerStartTime = i2;
        int i4 = (int) j3;
        bfVar4.ReportingInterval = i4;
        bfVar4.SuggestedQuality = yeVar;
        bfVar4.IsAppInForeground = InsightCore.getForegroundTestManager().d();
        if (j3 > 0) {
            z2 = true;
        }
        this.d = z2;
        if (z2) {
            this.O.ReportingInterval = i4;
            this.p = j3;
            this.M = this.N.scheduleAtFixedRate(this.U, j2, j2, TimeUnit.MILLISECONDS);
        }
        this.l = 1;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.k = elapsedRealtime;
        this.m = elapsedRealtime;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umlaut.crowd.internal.xe r20, com.umlaut.crowd.internal.ye r21, long r22, long r24, float r26, com.umlaut.crowd.internal.af.k r27) {
        /*
            r19 = this;
            r15 = r19
            int r0 = r15.A
            long r13 = android.net.TrafficStats.getUidRxBytes(r0)
            int r0 = r15.A
            long r11 = android.net.TrafficStats.getUidTxBytes(r0)
            if (r27 != 0) goto L_0x0017
            com.umlaut.crowd.internal.af$k r0 = new com.umlaut.crowd.internal.af$k
            r1 = 0
            r0.<init>(r15, r1)
            goto L_0x0019
        L_0x0017:
            r0 = r27
        L_0x0019:
            r16 = 0
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r6 = r24
            r8 = r26
            r9 = r13
            r20 = r11
            r17 = r13
            r13 = r0
            r14 = r16
            com.umlaut.crowd.internal.l5 r0 = r1.a(r2, r3, r4, r6, r8, r9, r11, r13, r14)
            java.lang.Object r1 = r15.D
            monitor-enter(r1)
            boolean r2 = r15.c     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0096
            java.util.Map<java.lang.Long, com.umlaut.crowd.internal.l5> r2 = r15.K     // Catch:{ all -> 0x00a4 }
            long r3 = r0.Delta     // Catch:{ all -> 0x00a4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a4 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0088
            java.util.Map<java.lang.Long, com.umlaut.crowd.internal.l5> r2 = r15.K     // Catch:{ all -> 0x00a4 }
            long r3 = r0.Delta     // Catch:{ all -> 0x00a4 }
            r5 = 1
            long r3 = r3 - r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a4 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x005f
            long r2 = r0.Delta     // Catch:{ all -> 0x00a4 }
            long r2 = r2 - r5
            r0.Delta = r2     // Catch:{ all -> 0x00a4 }
            goto L_0x0088
        L_0x005f:
            java.util.Map<java.lang.Long, com.umlaut.crowd.internal.l5> r2 = r15.K     // Catch:{ all -> 0x00a4 }
            long r3 = r0.Delta     // Catch:{ all -> 0x00a4 }
            long r3 = r3 + r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a4 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x0074
            long r2 = r0.Delta     // Catch:{ all -> 0x00a4 }
            long r2 = r2 + r5
            r0.Delta = r2     // Catch:{ all -> 0x00a4 }
            goto L_0x0088
        L_0x0074:
            java.util.Map<java.lang.Long, com.umlaut.crowd.internal.l5> r2 = r15.K     // Catch:{ all -> 0x00a4 }
            long r3 = r0.Delta     // Catch:{ all -> 0x00a4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x00a4 }
            com.umlaut.crowd.internal.l5 r2 = (com.umlaut.crowd.internal.l5) r2     // Catch:{ all -> 0x00a4 }
            int r2 = r2.VideoInfoTag     // Catch:{ all -> 0x00a4 }
            if (r2 > 0) goto L_0x0088
            r2 = 0
            goto L_0x0089
        L_0x0088:
            r2 = 1
        L_0x0089:
            if (r2 == 0) goto L_0x0096
            java.util.Map<java.lang.Long, com.umlaut.crowd.internal.l5> r2 = r15.K     // Catch:{ all -> 0x00a4 }
            long r3 = r0.Delta     // Catch:{ all -> 0x00a4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a4 }
            r2.put(r3, r0)     // Catch:{ all -> 0x00a4 }
        L_0x0096:
            monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
            r0 = r22
            r15.m = r0
            r0 = r17
            r15.n = r0
            r0 = r20
            r15.o = r0
            return
        L_0x00a4:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.af.a(com.umlaut.crowd.internal.xe, com.umlaut.crowd.internal.ye, long, long, float, com.umlaut.crowd.internal.af$k):void");
    }

    /* access modifiers changed from: private */
    public l5 a(xe xeVar, ye yeVar, long j2, long j3, float f2, long j4, long j5, k kVar, boolean z2) {
        long j6;
        long j7 = j3;
        float f3 = f2;
        k kVar2 = kVar;
        if (z2) {
            long j8 = this.p;
            int i2 = this.l;
            this.l = i2 + 1;
            j6 = j8 * ((long) i2);
        } else {
            j6 = j2 - this.k;
        }
        DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        l5 l5Var = new l5();
        l5Var.PlayedTime = j7;
        l5Var.ConnectionType = radioInfoForDefaultDataSim.ConnectionType;
        l5Var.NetworkType = radioInfoForDefaultDataSim.NetworkType;
        l5Var.NrState = radioInfoForDefaultDataSim.NrState;
        l5Var.DisplayNetworkType = radioInfoForDefaultDataSim.DisplayNetworkType;
        l5Var.VideoQuality = yeVar;
        l5Var.RxLevel = radioInfoForDefaultDataSim.RXLevel;
        l5Var.BufferedPercent = f3;
        l5Var.RequestedBytesFrom = kVar2.b;
        l5Var.RequestedBytesTo = kVar2.c;
        l5Var.VideoInfoTag = kVar2.a;
        l5Var.PlayerState = xeVar;
        l5Var.Delta = j6;
        l5Var.Mime = kVar2.d;
        double d2 = (double) (j2 - this.m);
        long j9 = j4 - this.n;
        l5Var.RxBytes = j9;
        l5Var.TxBytes = j5 - this.o;
        double d3 = (double) j9;
        Double.isNaN(d3);
        Double.isNaN(d2);
        l5Var.ThroughputRateRx = Math.round((d3 / d2) * 8.0d * 1000.0d);
        double d4 = (double) l5Var.TxBytes;
        Double.isNaN(d4);
        Double.isNaN(d2);
        l5Var.ThroughputRateTx = Math.round((d4 / d2) * 8.0d * 1000.0d);
        for (Map.Entry next : v.c().entrySet()) {
            this.z.put(next.getKey(), next.getValue());
        }
        String str = Y;
        a(str, "Created Measurement Point : " + xeVar.name() + " , Delta = " + j6 + " , PlayedTime = " + j7 + " , Buffered = " + f3 + " , Tag = " + kVar2.a + " , Bytes = " + kVar2.b + "-" + kVar2.c + " , Mime = " + kVar2.d + " , Quality = " + yeVar.name());
        return l5Var;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.c) {
            synchronized (this) {
                c(z2);
            }
        }
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception unused) {
            i2 = -1;
        }
        if (i2 == -1) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (i2 == 2) {
            return "InvalidParam";
        }
        if (i2 == 5) {
            return "HTML5Error";
        }
        if (i2 == 100 || i2 == 105) {
            return "VideoNotFound";
        }
        return (i2 == 101 || i2 == 150) ? "VideoNotEmbeddable" : "";
    }

    /* access modifiers changed from: private */
    public void a(long j2, long j3, long j4) {
        if (this.G != null) {
            synchronized (this.E) {
                this.E.post(new f(j4, j2, j3));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ze.a aVar, String str) {
        if (this.G != null) {
            synchronized (this.E) {
                this.E.post(new g(aVar, str));
            }
        }
    }

    public af(Context context, ze zeVar) {
        this(context, CLC.ProviderMode.Passive, zeVar);
    }
}
