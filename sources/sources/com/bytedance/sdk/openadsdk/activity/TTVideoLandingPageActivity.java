package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.t;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.b;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.com.bytedance.overseas.sdk.a.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class TTVideoLandingPageActivity extends TTBaseActivity implements d {
    protected Button A;
    protected c B;
    protected boolean C = false;
    protected String D;
    protected boolean E = false;
    protected boolean F = true;
    protected boolean G = false;
    protected String H = null;
    protected int I;
    protected com.bytedance.sdk.openadsdk.multipro.b.a J;
    protected j K;
    protected AtomicBoolean L = new AtomicBoolean(true);
    protected JSONArray M = null;
    protected String N;
    protected com.bytedance.sdk.openadsdk.core.b.a O = null;
    /* access modifiers changed from: private */
    public ILoader P;
    /* access modifiers changed from: private */
    public final AtomicInteger Q = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger R = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger S = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public int T;
    private int U;
    private final c.b V = new c.b() {
        public void a(boolean z) {
            TTVideoLandingPageActivity.this.C = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                ad.a((View) TTVideoLandingPageActivity.this.a, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.k.getLayoutParams();
                TTVideoLandingPageActivity.this.q = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.p = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.r = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.s = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.k.setLayoutParams(marginLayoutParams);
                return;
            }
            ad.a((View) TTVideoLandingPageActivity.this.a, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.k.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.r;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.s;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.q;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.p;
            TTVideoLandingPageActivity.this.k.setLayoutParams(marginLayoutParams2);
        }
    };
    private final v.a W = new v.a() {
        public void a(Context context, Intent intent, boolean z, final int i) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    AnonymousClass2.this.a(i);
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(int i) {
            if (!(TTVideoLandingPageActivity.this.I != 0 || i == 0 || TTVideoLandingPageActivity.this.a == null || TTVideoLandingPageActivity.this.H == null)) {
                TTVideoLandingPageActivity.this.a.a_(TTVideoLandingPageActivity.this.H);
            }
            if (!(TTVideoLandingPageActivity.this.m == null || TTVideoLandingPageActivity.this.m.getNativeVideoController() == null || TTVideoLandingPageActivity.this.E || TTVideoLandingPageActivity.this.I == i)) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) TTVideoLandingPageActivity.this.m.getNativeVideoController()).d(i);
            }
            TTVideoLandingPageActivity.this.I = i;
        }
    };
    protected SSWebView a;
    protected ImageView b;
    protected ImageView c;
    protected TextView d;
    protected Context e;
    protected int f;
    protected String g;
    protected String h;
    protected x i;
    protected int j;
    protected FrameLayout k;
    protected int l = -1;
    protected NativeVideoTsView m;
    protected long n;
    protected q o;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    protected int s = 0;
    protected String t = "ダウンロード";
    protected RelativeLayout u;
    protected TextView v;
    protected CornerIV w;
    protected TextView x;
    protected TextView y;
    protected PangleViewStub z;

    /* access modifiers changed from: protected */
    public abstract View a();

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|7|8|9|(8:11|12|13|(1:17)|18|(4:20|(2:22|23)|25|(1:27))(3:28|(1:30)|31)|32|(2:34|35)(14:36|(3:38|(1:40)(1:41)|42)|(4:44|45|47|(1:49))|(4:51|(2:53|54)|56|(1:58))|59|(1:61)|62|(1:64)|65|(1:69)|70|(3:72|(1:74)|75)|76|77))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            super.onCreate(r17)
            boolean r1 = com.bytedance.sdk.openadsdk.core.l.e()
            if (r1 != 0) goto L_0x0011
            r16.finish()
            return
        L_0x0011:
            long r8 = android.os.SystemClock.elapsedRealtime()
            android.view.Window r1 = r16.getWindow()     // Catch:{ all -> 0x001e }
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r1.addFlags(r2)     // Catch:{ all -> 0x001e }
        L_0x001e:
            com.bytedance.sdk.openadsdk.core.o.a(r16)     // Catch:{ all -> 0x0021 }
        L_0x0021:
            android.content.Context r1 = r16.getApplicationContext()
            int r1 = com.bytedance.sdk.component.utils.o.c(r1)
            r7.I = r1
            android.view.View r1 = r16.a()     // Catch:{ all -> 0x0227 }
            r7.setContentView(r1)     // Catch:{ all -> 0x0227 }
            r7.e = r7
            android.content.Intent r1 = r16.getIntent()
            java.lang.String r2 = "sdk_version"
            r3 = 1
            int r2 = r1.getIntExtra(r2, r3)
            r7.f = r2
            java.lang.String r2 = "adid"
            java.lang.String r2 = r1.getStringExtra(r2)
            r7.g = r2
            java.lang.String r2 = "log_extra"
            java.lang.String r2 = r1.getStringExtra(r2)
            r7.h = r2
            java.lang.String r2 = "source"
            r4 = -1
            int r2 = r1.getIntExtra(r2, r4)
            r7.j = r2
            java.lang.String r2 = "url"
            java.lang.String r2 = r1.getStringExtra(r2)
            r7.H = r2
            java.lang.String r2 = "web_title"
            java.lang.String r10 = r1.getStringExtra(r2)
            java.lang.String r2 = "event_tag"
            java.lang.String r2 = r1.getStringExtra(r2)
            r7.D = r2
            java.lang.String r2 = "gecko_id"
            java.lang.String r2 = r1.getStringExtra(r2)
            r7.N = r2
            java.lang.String r2 = "video_is_auto_play"
            boolean r2 = r1.getBooleanExtra(r2, r3)
            r7.G = r2
            r4 = 0
            java.lang.String r2 = "video_play_position"
            if (r0 == 0) goto L_0x0094
            long r11 = r0.getLong(r2)
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0094
            long r11 = r0.getLong(r2, r4)
            r7.n = r11
        L_0x0094:
            java.lang.String r6 = "multi_process_data"
            java.lang.String r6 = r1.getStringExtra(r6)
            boolean r11 = com.bytedance.sdk.openadsdk.multipro.b.c()
            if (r11 == 0) goto L_0x00c0
            java.lang.String r11 = "multi_process_materialmeta"
            java.lang.String r1 = r1.getStringExtra(r11)
            if (r1 == 0) goto L_0x00b5
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b4 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x00b4 }
            com.bytedance.sdk.openadsdk.core.model.q r1 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r11)     // Catch:{ Exception -> 0x00b4 }
            r7.o = r1     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b5
        L_0x00b4:
        L_0x00b5:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r7.o
            if (r1 == 0) goto L_0x00d9
            int r1 = r1.ad()
            r7.l = r1
            goto L_0x00d9
        L_0x00c0:
            com.bytedance.sdk.openadsdk.core.s r1 = com.bytedance.sdk.openadsdk.core.s.a()
            com.bytedance.sdk.openadsdk.core.model.q r1 = r1.b()
            r7.o = r1
            if (r1 == 0) goto L_0x00d2
            int r1 = r1.ad()
            r7.l = r1
        L_0x00d2:
            com.bytedance.sdk.openadsdk.core.s r1 = com.bytedance.sdk.openadsdk.core.s.a()
            r1.f()
        L_0x00d9:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r7.o
            if (r1 != 0) goto L_0x00e1
            r16.finish()
            return
        L_0x00e1:
            java.lang.String r1 = r7.N
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r11 = 0
            if (r1 != 0) goto L_0x0109
            com.bytedance.sdk.openadsdk.d.b r1 = com.bytedance.sdk.openadsdk.d.b.a()
            com.bykv.vk.openvk.preload.falconx.loader.ILoader r1 = r1.b()
            r7.P = r1
            com.bytedance.sdk.openadsdk.d.b r1 = com.bytedance.sdk.openadsdk.d.b.a()
            com.bykv.vk.openvk.preload.falconx.loader.ILoader r12 = r7.P
            java.lang.String r13 = r7.N
            int r1 = r1.a(r12, r13)
            r7.T = r1
            if (r1 <= 0) goto L_0x0106
            r1 = 2
            goto L_0x0107
        L_0x0106:
            r1 = 0
        L_0x0107:
            r7.U = r1
        L_0x0109:
            if (r6 == 0) goto L_0x0120
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0117 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0117 }
            com.bytedance.sdk.openadsdk.multipro.b.a r1 = com.bytedance.sdk.openadsdk.multipro.b.a.a((org.json.JSONObject) r1)     // Catch:{ Exception -> 0x0117 }
            r7.J = r1     // Catch:{ Exception -> 0x0117 }
            goto L_0x0118
        L_0x0117:
        L_0x0118:
            com.bytedance.sdk.openadsdk.multipro.b.a r1 = r7.J
            if (r1 == 0) goto L_0x0120
            long r12 = r1.g
            r7.n = r12
        L_0x0120:
            if (r0 == 0) goto L_0x0143
            java.lang.String r1 = "material_meta"
            java.lang.String r1 = r0.getString(r1)
            com.bytedance.sdk.openadsdk.core.model.q r6 = r7.o
            if (r6 != 0) goto L_0x0139
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0138 }
            r6.<init>(r1)     // Catch:{ all -> 0x0138 }
            com.bytedance.sdk.openadsdk.core.model.q r1 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r6)     // Catch:{ all -> 0x0138 }
            r7.o = r1     // Catch:{ all -> 0x0138 }
            goto L_0x0139
        L_0x0138:
        L_0x0139:
            long r0 = r0.getLong(r2)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0143
            r7.n = r0
        L_0x0143:
            r16.c()
            r16.i()
            r16.m()
            r0 = 4
            r7.a((int) r0)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            java.lang.String r12 = "landingpage_split_screen"
            if (r0 == 0) goto L_0x018a
            android.content.Context r0 = r7.e
            com.bytedance.sdk.openadsdk.core.widget.a.c r0 = com.bytedance.sdk.openadsdk.core.widget.a.c.a((android.content.Context) r0)
            com.bytedance.sdk.openadsdk.core.widget.a.c r0 = r0.a((boolean) r3)
            com.bytedance.sdk.openadsdk.core.widget.a.c r0 = r0.b((boolean) r11)
            com.bytedance.sdk.component.widget.SSWebView r1 = r7.a
            android.webkit.WebView r1 = r1.getWebView()
            r0.a((android.webkit.WebView) r1)
            com.bytedance.sdk.openadsdk.b.j r0 = new com.bytedance.sdk.openadsdk.b.j
            com.bytedance.sdk.openadsdk.core.model.q r1 = r7.o
            com.bytedance.sdk.component.widget.SSWebView r2 = r7.a
            android.webkit.WebView r2 = r2.getWebView()
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1 r4 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1
            r4.<init>()
            int r5 = r7.U
            r0.<init>(r1, r2, r4, r5)
            com.bytedance.sdk.openadsdk.b.j r0 = r0.a((boolean) r3)
            r7.K = r0
            r0.a((java.lang.String) r12)
        L_0x018a:
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            if (r0 == 0) goto L_0x01c6
            r0.setLandingPage(r3)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            r0.setTag(r12)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            com.bytedance.sdk.openadsdk.core.model.q r1 = r7.o
            com.bytedance.sdk.component.widget.b.a r1 = r1.aJ()
            r0.setMaterialMeta(r1)
            com.bytedance.sdk.component.widget.SSWebView r13 = r7.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4 r14 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4
            android.content.Context r2 = r7.e
            com.bytedance.sdk.openadsdk.core.x r3 = r7.i
            java.lang.String r4 = r7.g
            com.bytedance.sdk.openadsdk.b.j r5 = r7.K
            r6 = 1
            r0 = r14
            r1 = r16
            r0.<init>(r2, r3, r4, r5, r6)
            r13.setWebViewClient(r14)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            android.webkit.WebView r1 = r0.getWebView()
            int r2 = r7.f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.utils.l.a((android.webkit.WebView) r1, (int) r2)
            r0.setUserAgentString(r1)
        L_0x01c6:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x01d3
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            if (r0 == 0) goto L_0x01d3
            r0.setMixedContentMode(r11)
        L_0x01d3:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r7.o
            int r1 = r7.U
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r0, (java.lang.String) r12, (int) r1)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            java.lang.String r1 = r7.H
            com.bytedance.sdk.openadsdk.utils.o.a(r0, r1)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$5 r1 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$5
            com.bytedance.sdk.openadsdk.core.x r2 = r7.i
            com.bytedance.sdk.openadsdk.b.j r3 = r7.K
            r1.<init>(r2, r3)
            r0.setWebChromeClient(r1)
            com.bytedance.sdk.component.widget.SSWebView r0 = r7.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$6 r1 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$6
            r1.<init>()
            r0.setDownloadListener(r1)
            android.widget.TextView r0 = r7.d
            if (r0 == 0) goto L_0x020c
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x0209
            java.lang.String r1 = "tt_web_title_default"
            java.lang.String r10 = com.bytedance.sdk.component.utils.s.a(r7, r1)
        L_0x0209:
            r0.setText(r10)
        L_0x020c:
            r16.j()
            r16.d()
            r16.l()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r10 = r0 - r8
            com.bytedance.sdk.openadsdk.core.model.q r12 = r7.o
            java.lang.String r13 = "landingpage_split_screen"
            com.bykv.vk.openvk.preload.falconx.loader.ILoader r14 = r7.P
            java.lang.String r15 = r7.N
            com.bytedance.sdk.openadsdk.b.c.a.a(r10, r12, r13, r14, r15)
            return
        L_0x0227:
            r16.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.onCreate(android.os.Bundle):void");
    }

    private void l() {
        q qVar = this.o;
        if (qVar != null && qVar.M() == 4) {
            this.z.setVisibility(0);
            Button button = (Button) findViewById(i.am);
            this.A = button;
            if (button != null) {
                a(b());
                this.A.setOnClickListener(this.O);
                this.A.setOnTouchListener(this.O);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        q qVar = this.o;
        if (qVar != null && !TextUtils.isEmpty(qVar.X())) {
            this.t = this.o.X();
        }
        return this.t;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.A) != null) {
            button.post(new Runnable() {
                public void run() {
                    if (TTVideoLandingPageActivity.this.A != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                        TTVideoLandingPageActivity.this.A.setText(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.z = (PangleViewStub) findViewById(i.W);
        this.a = (SSWebView) findViewById(i.O);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.b = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.a == null) {
                        return;
                    }
                    if (TTVideoLandingPageActivity.this.a.e()) {
                        TTVideoLandingPageActivity.this.a.f();
                    } else if (TTVideoLandingPageActivity.this.q()) {
                        TTVideoLandingPageActivity.this.onBackPressed();
                    } else {
                        com.bytedance.sdk.openadsdk.b.c.a(TTVideoLandingPageActivity.this.o, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.f(), TTVideoLandingPageActivity.this.g(), (TTVideoLandingPageActivity.this.m == null || TTVideoLandingPageActivity.this.m.getNativeVideoController() == null) ? null : ac.a(TTVideoLandingPageActivity.this.o, TTVideoLandingPageActivity.this.m.getNativeVideoController().f(), TTVideoLandingPageActivity.this.m.getNativeVideoController().l()), (g) null);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setIsAutoPlay(this.G);
        }
        ImageView imageView2 = (ImageView) findViewById(i.I);
        this.c = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.m != null) {
                        com.bytedance.sdk.openadsdk.b.c.a(TTVideoLandingPageActivity.this.o, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.f(), TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.m.getNativeVideoController() != null ? ac.a(TTVideoLandingPageActivity.this.o, TTVideoLandingPageActivity.this.m.getNativeVideoController().f(), TTVideoLandingPageActivity.this.m.getNativeVideoController().l()) : null, (g) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.d = (TextView) findViewById(i.ao);
        this.k = (FrameLayout) findViewById(i.H);
        this.u = (RelativeLayout) findViewById(i.J);
        this.v = (TextView) findViewById(i.L);
        this.x = (TextView) findViewById(i.M);
        this.y = (TextView) findViewById(i.N);
        this.w = (CornerIV) findViewById(i.K);
        h();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        l();
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (e()) {
            try {
                NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.e, this.o, true, (g) null);
                this.m = nativeVideoTsView;
                if (nativeVideoTsView.getNativeVideoController() != null) {
                    this.m.getNativeVideoController().a(false);
                }
                if (this.E) {
                    this.k.setVisibility(0);
                    this.k.removeAllViews();
                    this.k.addView(this.m);
                    this.m.b(true);
                } else {
                    if (!this.G) {
                        this.n = 0;
                    }
                    if (!(this.J == null || this.m.getNativeVideoController() == null)) {
                        this.m.getNativeVideoController().b(this.J.g);
                        this.m.getNativeVideoController().c(this.J.e);
                        this.m.setIsQuiet(o.d().c(String.valueOf(this.o.aZ())));
                    }
                    if (this.m.a(this.n, this.F, this.E)) {
                        this.k.setVisibility(0);
                        this.k.removeAllViews();
                        this.k.addView(this.m);
                    }
                    if (this.m.getNativeVideoController() != null) {
                        this.m.getNativeVideoController().a(false);
                        this.m.getNativeVideoController().a(this.V);
                    }
                }
                String a2 = this.o.Q().get(0).a();
                com.bytedance.sdk.openadsdk.f.d.a().a(a2).a(this.o.Q().get(0).b()).b(this.o.Q().get(0).c()).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a(new b(this.o, a2, new com.bytedance.sdk.component.d.o<Bitmap>() {
                    public void a(int i, String str, Throwable th) {
                    }

                    public void a(k<Bitmap> kVar) {
                        try {
                            new a(kVar.b(), TTVideoLandingPageActivity.this.m.getNativeVideoController().m()).execute(new Void[0]);
                        } catch (Exception unused) {
                        }
                    }
                }), t.IO);
                this.m.findViewById(520093726).setOnTouchListener((View.OnTouchListener) null);
                this.m.findViewById(520093726).setOnClickListener((View.OnClickListener) null);
            } catch (Exception e2) {
                l.e("TTVideoLandingPage", e2.getMessage());
                if (this.m == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e2);
                }
            }
            if (this.I == 0) {
                try {
                    Toast.makeText(this, s.b(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public long f() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.m.getNativeVideoController().h();
    }

    /* access modifiers changed from: protected */
    public int g() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.m.getNativeVideoController().j();
    }

    /* access modifiers changed from: protected */
    public void h() {
        String str;
        q qVar = this.o;
        if (qVar != null && qVar.M() == 4) {
            ad.a((View) this.u, 0);
            if (!TextUtils.isEmpty(this.o.V())) {
                str = this.o.V();
            } else if (!TextUtils.isEmpty(this.o.W())) {
                str = this.o.W();
            } else {
                str = !TextUtils.isEmpty(this.o.L()) ? this.o.L() : "";
            }
            if (this.o.N() != null && this.o.N().a() != null) {
                ad.a((View) this.w, 0);
                ad.a((View) this.v, 4);
                com.bytedance.sdk.openadsdk.k.c.a().a(this.o.N(), (ImageView) this.w, this.o);
            } else if (!TextUtils.isEmpty(str)) {
                ad.a((View) this.w, 4);
                ad.a((View) this.v, 0);
                this.v.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(this.o.X())) {
                this.y.setText(this.o.X());
            }
            if (!TextUtils.isEmpty(str)) {
                this.x.setText(str);
            }
            ad.a((View) this.x, 0);
            ad.a((View) this.y, 0);
        }
    }

    public void i() {
        q qVar = this.o;
        if (qVar != null) {
            this.B = com.com.bytedance.overseas.sdk.a.d.a(this, qVar, this.D);
            com.bytedance.sdk.openadsdk.core.b.a aVar = new com.bytedance.sdk.openadsdk.core.b.a(this, this.o, this.D, this.j);
            this.O = aVar;
            aVar.a(false);
            this.O.c(true);
            this.y.setOnClickListener(this.O);
            this.y.setOnTouchListener(this.O);
            this.O.a(this.B);
        }
    }

    private void m() {
        x xVar = new x(this);
        this.i = xVar;
        xVar.b(this.a).d(this.g).e(this.h).b(this.j).a(this.o).a(this.o.H()).a(this.a).c("landingpage_split_screen").f(this.o.bb());
    }

    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.C && (nativeVideoTsView = this.m) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.d.a) this.m.getNativeVideoController()).e((com.bykv.vk.openvk.component.video.api.d.b) null, (View) null);
            this.C = false;
        } else if (!q() || this.L.getAndSet(true)) {
            super.onBackPressed();
        } else {
            r();
            a(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        q qVar = this.o;
        bundle.putString("material_meta", qVar != null ? qVar.ao().toString() : null);
        bundle.putLong("video_play_position", this.n);
        bundle.putBoolean("is_complete", this.E);
        long j2 = this.n;
        NativeVideoTsView nativeVideoTsView = this.m;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            j2 = this.m.getNativeVideoController().e();
        }
        bundle.putLong("video_play_position", j2);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.F) {
            n();
        }
        this.F = false;
        x xVar = this.i;
        if (xVar != null) {
            xVar.k();
        }
        j jVar = this.K;
        if (jVar != null) {
            jVar.g();
        }
    }

    private void n() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !p()) {
            this.m.m();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        x xVar = this.i;
        if (xVar != null) {
            xVar.l();
        }
        o();
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            a(this.m.getNativeVideoController());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        j jVar = this.K;
        if (jVar != null) {
            jVar.h();
        }
    }

    private void a(com.bykv.vk.openvk.component.video.api.d.c cVar) {
        boolean z2 = true;
        if (!this.E && !cVar.o()) {
            z2 = false;
        }
        this.E = z2;
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.E));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.e()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.h() + cVar.f()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.h()));
    }

    private void o() {
        if (this.m != null && !p()) {
            this.m.m();
        }
    }

    private boolean p() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.m.getNativeVideoController().o();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        k();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.o.e(false);
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.a;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.aa.a(sSWebView.getWebView());
        }
        this.a = null;
        x xVar = this.i;
        if (xVar != null) {
            xVar.m();
        }
        NativeVideoTsView nativeVideoTsView = this.m;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            this.m.getNativeVideoController().d();
        }
        this.m = null;
        this.o = null;
        j jVar = this.K;
        if (jVar != null) {
            jVar.c(true);
        }
        if (!TextUtils.isEmpty(this.N)) {
            c.a.a(this.R.get(), this.Q.get(), this.o);
        }
        com.bytedance.sdk.openadsdk.d.b.a().a(this.P);
    }

    /* access modifiers changed from: protected */
    public void j() {
        v.a(this.W, this.e);
    }

    /* access modifiers changed from: protected */
    public void k() {
        try {
            v.a(this.W);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean q() {
        return !TextUtils.isEmpty(this.H) && this.H.contains("__luban_sdk");
    }

    private void a(final int i2) {
        if (this.c != null && q()) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    ad.a((View) TTVideoLandingPageActivity.this.c, i2);
                }
            });
        }
    }

    private void r() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.i.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z2, JSONArray jSONArray) {
        if (z2 && jSONArray != null && jSONArray.length() > 0) {
            this.M = jSONArray;
        }
    }

    private static class a extends AsyncTask<Void, Void, Drawable> {
        private final Bitmap a;
        private final WeakReference<com.bykv.vk.openvk.component.video.api.d.b> b;

        private a(Bitmap bitmap, com.bykv.vk.openvk.component.video.api.d.b bVar) {
            this.a = bitmap;
            this.b = new WeakReference<>(bVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap a2 = com.bytedance.sdk.component.adexpress.c.a.a(o.a(), this.a, 25);
                if (a2 == null) {
                    return null;
                }
                return new BitmapDrawable(o.a().getResources(), a2);
            } catch (Throwable th) {
                l.e("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Drawable drawable) {
            WeakReference<com.bykv.vk.openvk.component.video.api.d.b> weakReference;
            if (drawable != null && (weakReference = this.b) != null && weakReference.get() != null) {
                ((com.bykv.vk.openvk.component.video.api.d.b) this.b.get()).a(drawable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.c.a((Activity) this, this.o);
    }
}
