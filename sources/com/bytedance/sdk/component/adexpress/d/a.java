package com.bytedance.sdk.component.adexpress.d;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.a.c.b;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.h;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: BaseWebViewRender */
public abstract class a implements com.bytedance.sdk.component.adexpress.a, d<SSWebView>, k, com.bytedance.sdk.component.adexpress.theme.a {
    protected boolean a;
    protected SSWebView b;
    protected int c = 8;
    protected b d;
    protected AtomicBoolean e = new AtomicBoolean(false);
    private Context f;
    private String g;
    private JSONObject h;
    private String i;
    private volatile g j;
    private boolean k = false;
    private h l;
    private m m;
    private boolean n;
    private int o;

    public abstract void a(int i2);

    public int c() {
        return 0;
    }

    public abstract void g();

    public void h() {
    }

    public void i() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    public a(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.f = context;
        this.m = mVar;
        this.g = mVar.d();
        themeStatusBroadcastReceiver.a(this);
        if (com.bytedance.sdk.component.adexpress.d.b()) {
            n();
            return;
        }
        SSWebView a2 = e.a().a(this.f, this.g);
        this.b = a2;
        if (a2 == null) {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (com.bytedance.sdk.component.adexpress.d.a() != null) {
                this.b = new SSWebView(com.bytedance.sdk.component.adexpress.d.a());
                return;
            }
            return;
        }
        this.k = true;
        Log.d("WebViewRender", "initWebView: reuse WebView");
    }

    private void n() {
        if (this.f != null) {
            SSWebView a2 = e.a().a(this.f, this.g);
            this.b = a2;
            if (a2 == null) {
                Log.d("WebViewRender", "initWebView: create WebView by act");
                this.b = new SSWebView(new MutableContextWrapper(this.f));
                return;
            }
            this.k = true;
            Log.d("WebViewRender", "initWebView: reuse WebView");
        } else if (com.bytedance.sdk.component.adexpress.d.a() != null) {
            Log.d("WebViewRender", "initWebView: create  WebView by global context");
            this.b = new SSWebView(new MutableContextWrapper(com.bytedance.sdk.component.adexpress.d.a()));
        }
    }

    public void a(String str) {
        this.i = str;
    }

    public SSWebView a() {
        return this.b;
    }

    public void a(h hVar) {
        this.l = hVar;
    }

    public void a(g gVar) {
        this.j = gVar;
        if (a() == null || a().getWebView() == null) {
            this.j.a(102);
        } else if (!com.bytedance.sdk.component.adexpress.a.b.a.f()) {
            this.j.a(102);
        } else if (TextUtils.isEmpty(this.i)) {
            this.j.a(102);
        } else if (this.d != null || com.bytedance.sdk.component.adexpress.a.b.a.a(this.h)) {
            this.m.e().a(this.k);
            if (this.k) {
                try {
                    this.b.m();
                    this.m.e().b();
                    com.bytedance.sdk.component.utils.k.a(this.b.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                } catch (Exception unused) {
                    l.b("WebViewRender", "reuse webview load fail ");
                    e.a().c(this.b);
                    this.j.a(102);
                }
            } else {
                SSWebView a2 = a();
                a2.m();
                this.m.e().b();
                a2.a_(this.i);
            }
        } else {
            this.j.a(103);
        }
    }

    /* renamed from: b */
    public SSWebView e() {
        return a();
    }

    public void d() {
        if (!this.e.get()) {
            this.e.set(true);
            g();
            if (this.b.getParent() != null) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            if (this.a) {
                e.a().a(this.b);
            } else {
                e.a().c(this.b);
            }
        }
    }

    public void f() {
        if (a() != null) {
            try {
                a().getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a(final n nVar) {
        if (nVar != null) {
            boolean c2 = nVar.c();
            final float d2 = (float) nVar.d();
            final float e2 = (float) nVar.e();
            if (d2 > 0.0f && e2 > 0.0f) {
                this.a = c2;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(nVar, d2, e2);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            a.this.a(nVar, d2, e2);
                        }
                    });
                }
            } else if (this.j != null) {
                this.j.a(105);
            }
        } else if (this.j != null) {
            this.j.a(105);
        }
    }

    /* access modifiers changed from: private */
    public void a(n nVar, float f2, float f3) {
        boolean z = this.a;
        if (z && !this.n) {
            a(f2, f3);
            a(this.c);
            if (this.j != null) {
                this.j.a(a(), nVar);
            }
        } else if (!z) {
            e.a().c(this.b);
        } else {
            c(nVar.j());
        }
    }

    public void a(View view, int i2, c cVar) {
        h hVar = this.l;
        if (hVar != null) {
            hVar.a(view, i2, cVar);
        }
    }

    private void a(float f2, float f3) {
        this.m.e().c();
        int a2 = (int) e.a(this.f, f2);
        int a3 = (int) e.a(this.f, f3);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        a().setLayoutParams(layoutParams);
    }

    private void c(int i2) {
        if (this.j != null) {
            this.j.a(i2);
        }
    }

    public void j() {
        k();
        Activity a2 = com.bytedance.sdk.component.utils.b.a(this.b);
        if (a2 != null) {
            this.o = a2.hashCode();
        }
    }

    public void a(Activity activity) {
        if (this.o != 0 && activity != null && activity.hashCode() == this.o) {
            l.b("WebViewRender", "release from activity onDestroy");
            d();
            l();
        }
    }

    public void a(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public m m() {
        return this.m;
    }
}
