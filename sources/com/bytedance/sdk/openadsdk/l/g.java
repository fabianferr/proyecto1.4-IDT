package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: PlayablePlugin */
public class g {
    /* access modifiers changed from: private */
    public WeakReference<View> A;
    private e B;
    private a C;
    private c D;
    private int E = 0;
    private int F = 0;
    private JSONObject G = new JSONObject();
    private String H;
    private String I;
    private String J;
    private Map<String, String> K = new HashMap();
    private JSONObject L;
    private String M;
    private JSONObject N;
    private float O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private String Z;
    /* access modifiers changed from: private */
    public final Handler a = new Handler(Looper.getMainLooper());
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private String ae;
    private String af;
    private boolean ag = false;
    private ViewTreeObserver.OnGlobalLayoutListener ah = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            try {
                View view = (View) g.this.A.get();
                if (view != null) {
                    g.this.b(view);
                }
            } catch (Throwable th) {
                f.a("PlayablePlugin", "onSizeChanged error", th);
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable b;
    /* access modifiers changed from: private */
    public Runnable c;
    private Timer d = new Timer();
    private TimerTask e;
    /* access modifiers changed from: private */
    public b f;
    private boolean g = true;
    private Set<String> h = new HashSet(Arrays.asList(new String[]{"adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"}));
    private String i = null;
    private String j = "embeded_ad";
    private boolean k = true;
    /* access modifiers changed from: private */
    public boolean l = true;
    private boolean m = true;
    private long n = 10;
    private long o = 10;
    private long p = 0;
    private long q = 0;
    private long r = -1;
    private long s = -1;
    private long t = -1;
    private long u = -1;
    private int v = 0;
    private int w = 0;
    private a x = a.MAIN;
    private Context y;
    /* access modifiers changed from: private */
    public WebView z;

    /* compiled from: PlayablePlugin */
    enum a {
        MAIN,
        RIFLE
    }

    public void q() {
    }

    public void r() {
    }

    public String w() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    static /* synthetic */ int h(g gVar) {
        int i2 = gVar.v;
        gVar.v = i2 + 1;
        return i2;
    }

    static /* synthetic */ int i(g gVar) {
        int i2 = gVar.w;
        gVar.w = i2 + 1;
        return i2;
    }

    private g(Context context, WebView webView, c cVar, a aVar) {
        this.z = webView;
        h.a(webView);
        a((View) webView);
        a(context, cVar, aVar);
        x();
    }

    private void a(Context context, c cVar, a aVar) {
        this.i = UUID.randomUUID().toString();
        this.y = context;
        this.B = new e(this);
        this.C = aVar;
        this.D = cVar;
    }

    private void x() {
        this.f = new b(this);
        this.b = new Runnable() {
            public void run() {
                if (g.this.l) {
                    boolean unused = g.this.l = false;
                    g.this.a.removeCallbacks(g.this.c);
                    g.this.a(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.c = new Runnable() {
            public void run() {
                if (g.this.l) {
                    boolean unused = g.this.l = false;
                    g.this.a.removeCallbacks(g.this.b);
                    g.this.a(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.e = new TimerTask() {
            public void run() {
                g.this.a.post(new Runnable() {
                    public void run() {
                        if (g.this.z != null) {
                            g.this.z.evaluateJavascript("javascript:playable_callJS()", new ValueCallback<String>() {
                                /* renamed from: a */
                                public void onReceiveValue(String str) {
                                    if (g.this.f != null) {
                                        g.this.f.a(System.currentTimeMillis());
                                    }
                                }
                            });
                        }
                    }
                });
            }
        };
    }

    private boolean y() {
        String str = this.M;
        if (str != null) {
            return str.contains("/union-fe/playable/") || this.M.contains("/union-fe-sg/playable/") || this.M.contains("/union-fe-i18n/playable/");
        }
        return false;
    }

    public void a(View view) {
        if (view != null) {
            try {
                this.A = new WeakReference<>(view);
                b(view);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.ah);
            } catch (Throwable th) {
                f.a("PlayablePlugin", "setViewForScreenSize error", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        if (view != null) {
            try {
                if (this.E != view.getWidth() || this.F != view.getHeight()) {
                    this.E = view.getWidth();
                    this.F = view.getHeight();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.E);
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.F);
                    a("resize", jSONObject);
                    this.G = jSONObject;
                }
            } catch (Throwable th) {
                f.a("PlayablePlugin", "resetViewDataJsonByView error", th);
            }
        }
    }

    public Context a() {
        return this.y;
    }

    public g a(String str, String str2) {
        this.K.put(str, str2);
        return this;
    }

    public Map<String, String> b() {
        return this.K;
    }

    public g a(String str) {
        this.H = str;
        return this;
    }

    public g b(String str) {
        this.I = str;
        return this;
    }

    public JSONObject c() {
        return this.N;
    }

    public g c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.N = jSONObject;
        } catch (Throwable th) {
            f.a("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public String d() {
        return this.I;
    }

    public String e() {
        return this.H;
    }

    public g d(String str) {
        this.J = str;
        return this;
    }

    public String f() {
        return this.J;
    }

    public g e(String str) {
        this.Z = str;
        return this;
    }

    public String g() {
        return this.Z;
    }

    public g a(boolean z2) {
        this.aa = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.aa);
            a("volumeChange", jSONObject);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean h() {
        return this.aa;
    }

    public g b(boolean z2) {
        if (this.ab == z2) {
            return this;
        }
        this.ab = z2;
        d(z2 ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", (JSONObject) null);
        if (this.s == -1 && this.ab) {
            this.s = System.currentTimeMillis();
            d("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.ab) {
            this.r = System.currentTimeMillis();
        } else if (this.r != -1) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            f.a("PlayablePlugin", "playable show time +" + currentTimeMillis);
            this.p = this.p + currentTimeMillis;
            this.r = -1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", this.ab);
            a("viewableChange", jSONObject);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "setViewable error", th);
        }
        return this;
    }

    public boolean i() {
        return this.ab;
    }

    public g c(boolean z2) {
        this.ac = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ac);
            a("change_playable_click", jSONObject);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public Set<String> j() {
        return this.B.a();
    }

    public void a(String str, JSONObject jSONObject) {
        if (f.a()) {
            StringBuilder sb = new StringBuilder("CALL JS [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            f.a("PlayablePlugin", sb.toString());
        }
        c cVar = this.D;
        if (cVar != null) {
            cVar.a(str, jSONObject);
        }
    }

    public d k() {
        return this.C.a();
    }

    public a l() {
        return this.C;
    }

    public JSONObject m() {
        return this.G;
    }

    public JSONObject n() {
        return this.L;
    }

    public g a(JSONObject jSONObject) {
        this.L = jSONObject;
        return this;
    }

    public g f(String str) {
        if (str != null) {
            try {
                int indexOf = str.indexOf("?");
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
            } catch (Throwable unused) {
            }
        }
        this.M = str;
        return this;
    }

    public JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", (double) this.O);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.P);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.Q);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.S);
            jSONObject3.put("y", this.R);
            jSONObject3.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.T);
            jSONObject3.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.U);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.W);
            jSONObject4.put("y", this.V);
            jSONObject4.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.X);
            jSONObject4.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.Y);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void p() {
        this.C.b();
    }

    public void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            this.t = System.currentTimeMillis();
            jSONObject.put("playable_full_url", str);
            long j2 = this.s;
            jSONObject.put("playable_page_show_duration", j2 != -1 ? this.t - j2 : 0);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        d("PL_sdk_html_load_start", jSONObject);
        if (this.k && this.x == a.MAIN) {
            this.a.postDelayed(this.b, this.n * 1000);
            this.a.postDelayed(this.c, this.o * 1000);
            this.k = false;
        }
    }

    public void h(String str) {
        b bVar;
        JSONObject jSONObject = new JSONObject();
        try {
            this.u = System.currentTimeMillis();
            jSONObject.put("playable_full_url", str);
            long j2 = this.t;
            jSONObject.put("playable_html_load_start_duration", j2 != -1 ? this.u - j2 : 0);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        d("PL_sdk_html_load_finish", jSONObject);
        this.a.removeCallbacks(this.b);
        if (this.g) {
            this.g = false;
            this.z.evaluateJavascript(w(), new ValueCallback<String>() {
                /* renamed from: a */
                public void onReceiveValue(String str) {
                    f.a("Playable_CrashMonitor", "load inject js=" + str);
                }
            });
        }
        try {
            if (this.x == a.MAIN && this.m && (bVar = this.f) != null) {
                this.m = false;
                bVar.a(System.currentTimeMillis());
                this.d.schedule(this.e, 0, 1500);
                this.f.a(1000);
            }
        } catch (Throwable th2) {
            f.a("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void s() {
        this.a.removeCallbacks(this.b);
        this.a.removeCallbacks(this.c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null && !jSONObject.optBoolean("success", true) && this.l) {
            this.l = false;
            this.a.removeCallbacks(this.b);
            this.a.removeCallbacks(this.c);
            a(4, "CaseRenderFail");
        }
    }

    private void b(int i2, String str) {
        if (this.C != null && y()) {
            this.C.a(i2, str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) {
        b(i2, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i2);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "reportRenderFatal error", th);
        }
        d("PL_sdk_global_faild", jSONObject);
    }

    public void t() {
        f.a("Playable_CrashMonitor", "-- Detected that the page is stuck for more than 2s and needs to be reported");
        d("PL_sdk_page_stuck", (JSONObject) null);
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            d(str, jSONObject);
        }
    }

    private String b(String str, String str2) {
        return String.format("rubeex://playable-lynx?accessKey=%1s&groupId=%2s&cardId=main", new Object[]{str, str2});
    }

    private void d(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("playable_event", str);
                jSONObject.put("playable_ts", System.currentTimeMillis());
                jSONObject.put("playable_viewable", this.ab);
                jSONObject.put("playable_session_id", this.i);
                if (this.x == a.MAIN) {
                    jSONObject.put("playable_url", this.M);
                } else {
                    jSONObject.put("playable_url", b(this.ae, this.af));
                }
                jSONObject.put("playable_is_prerender", this.ad);
                jSONObject.put("playable_render_type", this.x.ordinal());
                jSONObject.put("playable_sdk_version", "5.2.2");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_extra_data", jSONObject);
                jSONObject2.put(ViewHierarchyConstants.TAG_KEY, this.j);
                jSONObject2.put("nt", 4);
                jSONObject2.put("category", "umeng");
                jSONObject2.put("is_ad_event", "1");
                jSONObject2.put("refer", "playable");
                jSONObject2.put("value", this.L.opt(CmcdConfiguration.KEY_CONTENT_ID));
                jSONObject2.put("log_extra", this.L.opt("log_extra"));
                if (this.C != null) {
                    if (this.x == a.MAIN) {
                        if (y()) {
                            f.a("PlayablePlugin", "reportEvent by ActionProxy");
                            this.C.a("playable_track", jSONObject2);
                            this.C.a(jSONObject);
                            return;
                        }
                    }
                    if (this.x != a.MAIN) {
                        f.a("PlayablePlugin", "reportEvent by ActionProxy");
                        this.C.a("playable_track", jSONObject2);
                        this.C.a(jSONObject);
                        return;
                    }
                    f.a("PlayablePlugin", "reportEvent error no not playable url");
                    return;
                }
                f.a("PlayablePlugin", "reportEvent error no impl");
            } catch (Throwable th) {
                f.a("PlayablePlugin", "reportEvent error", th);
            }
        }
    }

    public void i(String str) {
        this.a.post(new Runnable() {
            public void run() {
                g.h(g.this);
            }
        });
    }

    public void j(String str) {
        this.a.post(new Runnable() {
            public void run() {
                g.i(g.this);
            }
        });
    }

    public void u() {
        this.O = 0.0f;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:3|4|5|(1:7)|8|9|10|11|(1:13)|14|(1:16)|19|20|21|22|(1:24)|25|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[Catch:{ all -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v() {
        /*
            r7 = this;
            java.lang.String r0 = "playable show time +"
            boolean r1 = r7.ag
            if (r1 == 0) goto L_0x0007
            return
        L_0x0007:
            r1 = 1
            r7.ag = r1
            r1 = 0
            r7.q = r1
            r7.u()
            java.lang.ref.WeakReference<android.view.View> r1 = r7.A     // Catch:{ all -> 0x0024 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0024 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0024
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()     // Catch:{ all -> 0x0024 }
            android.view.ViewTreeObserver$OnGlobalLayoutListener r2 = r7.ah     // Catch:{ all -> 0x0024 }
            r1.removeOnGlobalLayoutListener(r2)     // Catch:{ all -> 0x0024 }
        L_0x0024:
            com.bytedance.sdk.openadsdk.l.e r1 = r7.B     // Catch:{ all -> 0x0029 }
            r1.b()     // Catch:{ all -> 0x0029 }
        L_0x0029:
            java.util.Timer r1 = r7.d     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0030
            r1.cancel()     // Catch:{ all -> 0x003b }
        L_0x0030:
            com.bytedance.sdk.openadsdk.l.b r1 = r7.f     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x004f
            r1.a()     // Catch:{ all -> 0x003b }
            r1 = 0
            r7.f = r1     // Catch:{ all -> 0x003b }
            goto L_0x004f
        L_0x003b:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "crash -- "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "Playable_CrashMonitor"
            com.bytedance.sdk.openadsdk.l.f.a(r2, r1)
        L_0x004f:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = "playable_all_times"
            int r3 = r7.v     // Catch:{ all -> 0x0067 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = "playable_hit_times"
            int r3 = r7.w     // Catch:{ all -> 0x0067 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = "PL_sdk_preload_times"
            r7.d(r2, r1)     // Catch:{ all -> 0x0067 }
        L_0x0067:
            long r1 = r7.r     // Catch:{ all -> 0x009f }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x008e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009f }
            long r5 = r7.r     // Catch:{ all -> 0x009f }
            long r1 = r1 - r5
            java.lang.String r5 = "PlayablePlugin"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r6.<init>(r0)     // Catch:{ all -> 0x009f }
            r6.append(r1)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x009f }
            com.bytedance.sdk.openadsdk.l.f.a(r5, r0)     // Catch:{ all -> 0x009f }
            long r5 = r7.p     // Catch:{ all -> 0x009f }
            long r5 = r5 + r1
            r7.p = r5     // Catch:{ all -> 0x009f }
            r7.r = r3     // Catch:{ all -> 0x009f }
        L_0x008e:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x009f }
            r0.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "playable_user_play_duration"
            long r2 = r7.p     // Catch:{ all -> 0x009f }
            r0.put(r1, r2)     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "PL_sdk_user_play_duration"
            r7.d(r1, r0)     // Catch:{ all -> 0x009f }
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.g.v():void");
    }

    public void a(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
            jSONObject.put("description", str);
            jSONObject.put("failingUrl", str2);
        } catch (Throwable th) {
            f.a("PlayablePlugin", "onWebReceivedError error", th);
        }
        d("PL_sdk_html_load_error", jSONObject);
        if (this.l) {
            this.l = false;
            this.a.removeCallbacks(this.b);
            this.a.removeCallbacks(this.c);
            a(1, "ContainerLoadFail");
        }
    }

    public void a(boolean z2, String str, int i2) {
        if (z2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
                jSONObject.put("failingUrl", str);
            } catch (Throwable th) {
                f.a("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            d("PL_sdk_html_load_error", jSONObject);
            if (this.l) {
                this.l = false;
                this.a.removeCallbacks(this.b);
                this.a.removeCallbacks(this.c);
                a(1, "ContainerLoadFail");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        this.C.d(jSONObject);
    }

    /* access modifiers changed from: protected */
    public void d(JSONObject jSONObject) {
        this.C.e(jSONObject);
    }

    /* access modifiers changed from: protected */
    public void e(JSONObject jSONObject) {
        this.C.f(jSONObject);
    }

    public JSONObject c(String str, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        if (f.a()) {
            StringBuilder sb = new StringBuilder("PlayablePlugin JSB-REQ [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : str2);
            f.a("PlayablePlugin", sb.toString());
        }
        JSONObject a2 = this.B.a(str, jSONObject);
        if (f.a()) {
            StringBuilder sb2 = new StringBuilder("PlayablePlugin JSB-RSP [");
            sb2.append(str);
            sb2.append("] time:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append(" ");
            if (a2 != null) {
                str2 = a2.toString();
            }
            sb2.append(str2);
            f.a("PlayablePlugin", sb2.toString());
        }
        return a2;
    }

    public static g a(Context context, WebView webView, c cVar, a aVar) {
        if (webView == null || cVar == null || aVar == null) {
            return null;
        }
        return new g(context, webView, cVar, aVar);
    }
}
