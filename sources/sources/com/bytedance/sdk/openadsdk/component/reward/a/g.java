package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.appnext.core.Ad;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.j.a.b;
import com.bytedance.sdk.openadsdk.l.a;
import com.bytedance.sdk.openadsdk.l.f;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardFullPlayableManager */
public class g implements Handler.Callback, com.bytedance.sdk.openadsdk.i.g {
    private static final f.a h = new f.a() {
        public void a(String str, String str2) {
            l.b(str, str2);
        }

        public void a(String str, String str2, Throwable th) {
            l.c(str, str2, th);
        }
    };
    protected final AtomicBoolean a = new AtomicBoolean(false);
    boolean b = false;
    boolean c = false;
    long d = 0;
    int e = 0;
    int f = 0;
    int g = 0;
    private volatile boolean i;
    private final Activity j;
    /* access modifiers changed from: private */
    public final q k;
    /* access modifiers changed from: private */
    public final String l;
    /* access modifiers changed from: private */
    public final a m;
    /* access modifiers changed from: private */
    public final Handler n = new Handler(this);
    private m o;
    private int p = 1;
    private PlayableLoadingView q;
    /* access modifiers changed from: private */
    public boolean r = true;
    private HomeWatcherReceiver s;
    private com.bytedance.sdk.openadsdk.l.g t;
    private boolean u;
    private boolean v;
    private final d w = new d() {
        public void a(int i) {
        }

        public void b() {
        }

        public void a() {
            if (!g.this.m.V.isFinishing() && g.this.m.a.aQ() && !t.i(g.this.m.a)) {
                g.this.n.removeMessages(800);
                g.this.n.sendMessage(g.b(1));
            }
        }
    };

    public g(a aVar) {
        this.m = aVar;
        this.j = aVar.V;
        this.l = aVar.g;
        this.k = aVar.a;
    }

    public static Message b(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i2;
        return obtain;
    }

    public void a() {
        if (!this.u) {
            this.u = true;
            this.o = this.m.Q;
            this.p = this.m.j;
            p();
            if (t.b(this.k)) {
                DeviceUtils.AudioInfoReceiver.a((com.bytedance.sdk.openadsdk.i.g) this);
            }
            if (q() && t.k(this.k) && t.i(this.k)) {
                Handler handler = this.n;
                handler.sendMessageDelayed(handler.obtainMessage(800, 2, 0), 10000);
            }
        }
    }

    public void a(final e eVar, boolean z) {
        r a2;
        AnonymousClass4 r7;
        if (t.b(this.k)) {
            if (h.b().q()) {
                f.a(h);
            }
            AnonymousClass2 r1 = new a() {
                public com.bytedance.sdk.openadsdk.l.d a() {
                    String f = com.bytedance.sdk.openadsdk.common.a.f();
                    f.hashCode();
                    char c = 65535;
                    switch (f.hashCode()) {
                        case 1653:
                            if (f.equals("2g")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1684:
                            if (f.equals("3g")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1715:
                            if (f.equals("4g")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1746:
                            if (f.equals("5g")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3649301:
                            if (f.equals("wifi")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_2G;
                        case 1:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_3G;
                        case 2:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_4G;
                        case 3:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_5G;
                        case 4:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_WIFI;
                        default:
                            return com.bytedance.sdk.openadsdk.l.d.TYPE_UNKNOWN;
                    }
                }

                public void b() {
                    g.this.m.Q.j().d(true);
                    e eVar = eVar;
                    if (eVar != null) {
                        eVar.a();
                    }
                }

                public void a(JSONObject jSONObject) {
                    c.b(g.this.k, g.this.l, "playable_track", jSONObject);
                }
            };
            AnonymousClass3 r72 = new com.bytedance.sdk.openadsdk.l.c() {
                public void a(String str, JSONObject jSONObject) {
                    g.this.m.Q.j().a(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, this.k.Y());
                jSONObject.put("log_extra", this.k.ac());
                com.bytedance.sdk.openadsdk.l.g a3 = com.bytedance.sdk.openadsdk.l.g.a(o.a(), this.m.Q.h().getWebView(), r72, r1).f(this.m.Q.v()).e(com.bytedance.sdk.openadsdk.common.a.a(o.a())).a(com.bytedance.sdk.openadsdk.common.a.a()).a(jSONObject).a("sdkEdition", com.bytedance.sdk.openadsdk.common.a.c()).b(com.bytedance.sdk.openadsdk.common.a.e()).d(com.bytedance.sdk.openadsdk.common.a.d()).c(false).a(z);
                this.t = a3;
                if (a3 == null) {
                    r7 = new com.bytedance.sdk.openadsdk.j.a() {
                        public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("PlayablePlugin_is_null", true);
                            return b.b().a("PlayablePlugin_init").b(jSONObject.toString());
                        }
                    };
                    com.bytedance.sdk.openadsdk.j.b.a("PlayablePlugin_init", false, (com.bytedance.sdk.openadsdk.j.a) r7);
                }
            } catch (Exception unused) {
                if (this.t == null) {
                    r7 = new com.bytedance.sdk.openadsdk.j.a() {
                        public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("PlayablePlugin_is_null", true);
                            return b.b().a("PlayablePlugin_init").b(jSONObject.toString());
                        }
                    };
                }
            } catch (Throwable th) {
                if (this.t == null) {
                    com.bytedance.sdk.openadsdk.j.b.a("PlayablePlugin_init", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
                        public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("PlayablePlugin_is_null", true);
                            return b.b().a("PlayablePlugin_init").b(jSONObject.toString());
                        }
                    });
                }
                throw th;
            }
            if (this.t != null && !TextUtils.isEmpty(t.d(this.k))) {
                this.t.c(t.d(this.k));
            }
            com.bytedance.sdk.openadsdk.l.g gVar = this.t;
            if (gVar != null) {
                Set<String> j2 = gVar.j();
                final WeakReference weakReference = new WeakReference(this.t);
                for (String next : j2) {
                    if (!"subscribe_app_ad".equals(next) && !"adInfo".equals(next) && !"webview_time_track".equals(next) && !"download_app_ad".equals(next) && (a2 = this.m.Q.j().a()) != null) {
                        a2.a(next, (com.bytedance.sdk.component.a.e<?, ?>) new com.bytedance.sdk.component.a.e<JSONObject, JSONObject>() {
                            public JSONObject a(JSONObject jSONObject, com.bytedance.sdk.component.a.f fVar) {
                                try {
                                    com.bytedance.sdk.openadsdk.l.g gVar = (com.bytedance.sdk.openadsdk.l.g) weakReference.get();
                                    if (gVar == null) {
                                        return null;
                                    }
                                    return gVar.c(a(), jSONObject);
                                } catch (Throwable unused) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void p() {
        this.q = (PlayableLoadingView) this.j.findViewById(i.bi);
    }

    private boolean q() {
        if (this.q == null) {
            return false;
        }
        if (!this.k.aQ() || !t.k(this.k)) {
            this.q.a();
            return false;
        }
        this.q.b();
        return true;
    }

    public void b() {
        if (!this.a.getAndSet(true)) {
            this.o.F();
            if (t.c(this.k)) {
                this.o.f();
            }
        }
    }

    public void a(DownloadListener downloadListener) {
        SSWebView i2 = this.o.i();
        if (i2 != null) {
            String r2 = r();
            if (!TextUtils.isEmpty(r2)) {
                i2.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.e(this.j, this.o.k(), this.k.Y(), (j) null, false) {
                    public void onPageFinished(WebView webView, String str) {
                        if (g.this.r) {
                            c.c(g.this.k, g.this.l, "loading_h5_success", (JSONObject) null);
                        }
                        super.onPageFinished(webView, str);
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        boolean unused = g.this.r = false;
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        boolean unused = g.this.r = false;
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        boolean unused = g.this.r = false;
                    }
                });
                l.b("TTAD.RFPM", "startWebViewLoading: " + r2);
                i2.a_(r2);
                i2.setDisplayZoomControls(false);
                i2.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.o.k(), this.o.l()));
                i2.setDownloadListener(downloadListener);
            }
        }
    }

    private String r() {
        String A = o.d().A();
        l.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + A);
        if (TextUtils.isEmpty(A) || this.k.aa() == null) {
            return A;
        }
        String b2 = this.k.aa().b();
        double d2 = this.k.aa().d();
        int e2 = this.k.aa().e();
        String a2 = (this.k.N() == null || TextUtils.isEmpty(this.k.N().a())) ? "" : this.k.N().a();
        String Y = this.k.Y();
        String c2 = this.k.aa().c();
        String a3 = this.k.aa().a();
        String b3 = this.k.aa().b();
        String V = this.k.V();
        StringBuilder sb = new StringBuilder("appname=");
        sb.append(URLEncoder.encode(b2));
        sb.append("&stars=");
        sb.append(d2);
        sb.append("&comments=");
        sb.append(e2);
        sb.append("&icon=");
        sb.append(URLEncoder.encode(a2));
        sb.append("&downloading=true&id=");
        sb.append(URLEncoder.encode(Y));
        sb.append("&packageName=");
        sb.append(URLEncoder.encode(c2));
        sb.append("&downloadUrl=");
        sb.append(URLEncoder.encode(a3));
        sb.append("&name=");
        sb.append(URLEncoder.encode(b3));
        sb.append("&orientation=");
        sb.append(this.p == 1 ? Ad.ORIENTATION_PORTRAIT : Ad.ORIENTATION_LANDSCAPE);
        sb.append("&apptitle=");
        sb.append(URLEncoder.encode(V));
        String str = A + "?" + sb;
        l.c("Playable", "Playable-loadH5Url=" + str);
        return str;
    }

    public void c() {
        this.b = true;
    }

    public boolean d() {
        return this.b;
    }

    public void e() {
        if (!this.v) {
            this.v = true;
            c(false);
            a(this.j.getApplicationContext());
            com.bytedance.sdk.openadsdk.l.g gVar = this.t;
            if (gVar != null) {
                gVar.v();
            }
            this.n.removeCallbacksAndMessages((Object) null);
            DeviceUtils.AudioInfoReceiver.b((com.bytedance.sdk.openadsdk.i.g) this);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.o.h().setDomStorageEnabled(true);
        }
    }

    public void b(boolean z) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(this.o.v()) && this.o.t() != 0) {
                    com.bytedance.sdk.openadsdk.j.b.a().a(this.o.v(), this.o.t(), this.o.u());
                }
            } catch (Throwable unused) {
            }
        }
        if (z) {
            try {
                if (!TextUtils.isEmpty(this.o.v())) {
                    com.bytedance.sdk.openadsdk.j.b.a().b(this.o.v());
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public void f() {
        try {
            HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
            this.s = homeWatcherReceiver;
            homeWatcherReceiver.a(new HomeWatcherReceiver.a() {
                public void a() {
                    g.this.c = true;
                }

                public void b() {
                    g.this.c = true;
                }
            });
            this.j.getApplicationContext().registerReceiver(this.s, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            this.s.a((HomeWatcherReceiver.a) null);
            context.getApplicationContext().unregisterReceiver(this.s);
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.d);
            } catch (JSONException e2) {
                l.c("TTAD.RFPM", "sendPlayableEvent error", e2);
            }
            c.b(this.k, this.l, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.c = false;
            }
        }
    }

    public void g() {
        this.d = System.currentTimeMillis();
        Handler handler = this.n;
        handler.sendMessage(handler.obtainMessage(900, j(), 0));
        c(true);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.d);
            } catch (JSONException e2) {
                l.c("TTAD.RFPM", "endShow json error", e2);
            }
        }
    }

    public void c(int i2) {
        PlayableLoadingView playableLoadingView = this.q;
        if (playableLoadingView != null) {
            playableLoadingView.setProgress(i2);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        PlayableLoadingView playableLoadingView = this.q;
        if (playableLoadingView != null && playableLoadingView.getPlayView() != null && t.k(this.k)) {
            this.q.getPlayView().setOnClickListener(eVar);
            this.q.getPlayView().setOnTouchListener(eVar);
        }
    }

    public void h() {
        PlayableLoadingView playableLoadingView = this.q;
        if (playableLoadingView != null) {
            playableLoadingView.a();
        }
    }

    public boolean i() {
        return this.i;
    }

    public void c(boolean z) {
        this.i = z;
        if (!z) {
            this.n.removeMessages(900);
        }
    }

    public int d(int i2) {
        return this.g - (this.f - i2);
    }

    public int j() {
        return this.f;
    }

    public int k() {
        return this.e;
    }

    public void a(int i2, q qVar, boolean z) {
        if (qVar != null) {
            this.f = qVar.aq();
            this.g = o.d().a(String.valueOf(i2), z);
        }
    }

    public void e(int i2) {
        this.e = i2 - 1;
    }

    public void f(int i2) {
        this.e = i2;
    }

    public void a(int i2) {
        if (t.l(this.m.a) && !this.m.u.get()) {
            return;
        }
        if (!t.k(this.m.a) && !t.l(this.m.a)) {
            return;
        }
        if (this.m.O.b()) {
            l.b("TTAD.RFPM", "onVolumeChanged by SDK mIsMute=" + this.m.d + " mVolume=" + i2 + " mLastVolume=" + this.m.O.a());
            if (i2 == 0) {
                this.m.R.b(true);
                this.m.G.b(true);
                return;
            }
            this.m.R.b(false);
            this.m.G.b(false);
            return;
        }
        this.m.O.a(-1);
        l.b("TTAD.RFPM", "onVolumeChanged by User mIsMute=" + this.m.d + " mVolume=" + i2 + " mLastVolume=" + this.m.O.a());
        if (!this.m.e) {
            return;
        }
        if (i2 == 0) {
            this.m.d = true;
            this.m.R.b(true);
            this.m.G.b(true);
            return;
        }
        this.m.d = false;
        this.m.R.b(false);
        this.m.G.b(false);
    }

    public void l() {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.r();
            if (ad.d((View) this.m.Q.h())) {
                this.t.b(true);
            }
        }
    }

    public void m() {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.q();
            this.t.b(false);
        }
        this.n.removeMessages(900);
    }

    public void d(boolean z) {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.b(z);
        }
    }

    public void e(boolean z) {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void a(int i2, String str, String str2) {
        try {
            com.bytedance.sdk.openadsdk.l.g gVar = this.t;
            if (gVar != null) {
                gVar.a(i2, str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public void a(boolean z, String str, int i2) {
        try {
            com.bytedance.sdk.openadsdk.l.g gVar = this.t;
            if (gVar != null) {
                gVar.a(z, str, i2);
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.h(str);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.l.g gVar = this.t;
        if (gVar != null) {
            gVar.g(str);
        }
    }

    public void n() {
        this.n.removeMessages(900);
        this.n.removeMessages(600);
    }

    public void a(long j2) {
        Message obtain = Message.obtain();
        obtain.what = 900;
        obtain.arg1 = k();
        this.n.sendMessageDelayed(obtain, j2);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 900) {
            if (!this.i || !t.k(this.m.a)) {
                return true;
            }
            int i2 = message.arg1;
            if (i2 > 0) {
                this.m.R.d(true);
                int d2 = this.m.I.d(i2);
                if (d2 == i2) {
                    this.m.R.a(String.valueOf(i2), (CharSequence) null);
                } else if (d2 > 0) {
                    this.m.R.a(String.valueOf(i2), String.format(s.a(this.m.V.getApplicationContext(), "tt_skip_ad_time_text"), new Object[]{Integer.valueOf(d2)}));
                } else {
                    this.m.R.a(String.valueOf(i2), s.a(this.m.V.getApplicationContext(), "tt_txt_skip"));
                    this.m.R.e(true);
                }
                Message obtain = Message.obtain();
                obtain.what = 900;
                obtain.arg1 = i2 - 1;
                this.n.sendMessageDelayed(obtain, 1000);
                this.m.I.e(i2);
            } else if (t.c(this.k)) {
                this.m.R.c();
                this.m.R.e(true);
            } else {
                this.m.R.d(false);
                this.m.D.set(true);
                this.m.Y.p();
            }
            this.m.V.j();
        } else if (message.what == 800) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (this.m.a.K() != null) {
                    jSONObject.put("playable_url", this.m.a.K().l());
                }
            } catch (JSONException e2) {
                l.c("TTAD.RFPM", "handleMessage json error", e2);
            }
            c.b(this.m.a, this.m.V.a, "remove_loading_page", jSONObject);
            this.n.removeMessages(800);
            this.m.I.h();
        }
        return true;
    }

    public d o() {
        return this.w;
    }

    public void f(boolean z) {
        if (z) {
            boolean k2 = t.k(this.k);
            if (k2 && this.k.aQ() && !t.i(this.k)) {
                Handler handler = this.n;
                handler.sendMessageDelayed(handler.obtainMessage(800, 0, 0), 1000);
            }
            if (k2) {
                this.m.I.b();
                this.m.Q.b(true);
                this.m.Q.c(true);
                c.c(this.m.a, this.l, "py_loading_success", (JSONObject) null);
            }
        }
    }
}
