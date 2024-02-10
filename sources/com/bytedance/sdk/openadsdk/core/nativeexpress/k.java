package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.component.adexpress.b.i;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.aa;
import org.json.JSONObject;

/* compiled from: ExpressRenderEventMonitor */
public class k implements i {
    private final e a;
    /* access modifiers changed from: private */
    public final String b;
    /* access modifiers changed from: private */
    public final q c;
    private final String d;
    private long e;

    public k(e eVar, String str, q qVar, String str2) {
        this.a = eVar;
        this.b = str;
        this.d = str2;
        this.c = qVar;
    }

    public void a() {
        this.a.a();
        l.b("ExpressRenderEventMonitor", "start render ");
    }

    public void a(boolean z) {
        this.a.a(z ? 1 : 0);
        l.b("ExpressRenderEventMonitor", "webview start request");
    }

    public void b() {
        l.b("ExpressRenderEventMonitor", "WebView start load");
    }

    public void c() {
        l.b("ExpressRenderEventMonitor", "webview render success");
        this.a.b();
    }

    public void a(int i) {
        this.a.a(i, (String) null);
        i.a(i, this.b, this.d, this.c);
        l.b("ExpressRenderEventMonitor", "onWebViewFail() called with: errorCode = [" + i + "]");
    }

    public void b(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicStart() called with: renderType = [" + i + "]");
        this.e = System.currentTimeMillis();
        if (i == 3) {
            this.a.c("dynamic_render2_start");
        } else {
            this.a.c("dynamic_render_start");
        }
    }

    public void c(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicParseStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_analysis2_start");
        } else {
            this.a.d("dynamic_sub_analysis_start");
        }
    }

    public void d(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicParseEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_analysis2_end");
        } else {
            this.a.d("dynamic_sub_analysis_end");
        }
    }

    public void e(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicRealRenderStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_render2_start");
        } else {
            this.a.d("dynamic_sub_render_start");
        }
    }

    public void f(int i) {
        l.b("ExpressRenderEventMonitor", "onDynamicRealRenderEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.d("dynamic_sub_render2_end");
        } else {
            this.a.d("dynamic_sub_render_end");
        }
    }

    public void g(int i) {
        final String str;
        long currentTimeMillis = System.currentTimeMillis();
        l.b("ExpressRenderEventMonitor", "dynamic render success render type: " + i + "; ****cost time(ms): " + (currentTimeMillis - this.e) + "****");
        if (i == 3) {
            this.a.e("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.a.e("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.a.a(true);
        aa.b(new h("dynamic_success") {
            public void run() {
                c.b(k.this.c, k.this.b, str, (JSONObject) null);
            }
        }, 10);
    }

    public void a(int i, int i2, boolean z) {
        l.b("ExpressRenderEventMonitor", "onDynamicFail() called with: renderType = [" + i + "], errorCode = [" + i2 + "], hasNext = [" + z + "]");
        if (!z) {
            this.a.a(true);
        }
        if (i == 3) {
            this.a.b(i2, "dynamic_render2_error");
        } else {
            this.a.b(i2, "dynamic_render_error");
        }
        i.a(i2, this.b, this.d, this.c);
    }

    public void d() {
        l.b("ExpressRenderEventMonitor", "native render start");
        this.a.c();
    }

    public void e() {
        l.b("ExpressRenderEventMonitor", "native success");
        this.a.a(true);
        this.a.m();
        aa.b(new h("native_success") {
            public void run() {
                c.b(k.this.c, k.this.b, "dynamic_backup_render", (JSONObject) null);
            }
        }, 10);
    }

    public void f() {
        l.b("ExpressRenderEventMonitor", "no native render");
        this.a.n();
    }

    public void g() {
        l.b("ExpressRenderEventMonitor", "render fail");
        this.a.o();
    }

    public void h() {
        l.b("ExpressRenderEventMonitor", "render success");
        this.a.b();
    }

    public void i() {
        this.a.k();
        this.a.l();
    }
}
