package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.h;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.component.adexpress.dynamic.c.f;
import com.bytedance.sdk.component.adexpress.dynamic.c.g;
import com.bytedance.sdk.component.adexpress.dynamic.d.b;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DynamicRender */
public class a implements d<DynamicRootView>, k {
    /* access modifiers changed from: private */
    public DynamicRootView a;
    /* access modifiers changed from: private */
    public g b;
    private Context c;
    private com.bytedance.sdk.component.adexpress.b.g d;
    private h e;
    /* access modifiers changed from: private */
    public m f;
    private ScheduledFuture<?> g;
    private AtomicBoolean h = new AtomicBoolean(false);

    public a(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, m mVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        this.c = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, mVar, aVar);
        this.a = dynamicRootView;
        this.b = gVar;
        this.f = mVar;
        dynamicRootView.setRenderListener(this);
        this.f = mVar;
    }

    public void a(com.bytedance.sdk.component.adexpress.b.g gVar) {
        this.d = gVar;
        int f2 = this.f.f();
        if (f2 < 0) {
            this.a.a(this.b instanceof f ? 127 : 117);
            return;
        }
        this.g = com.bytedance.sdk.component.g.f.f().schedule(new C0044a(2), (long) f2, TimeUnit.MILLISECONDS);
        com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
            public void run() {
                a.this.f();
            }
        }, this.f.i());
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f.e().c(c());
        if (!com.bytedance.sdk.component.adexpress.a.b.a.a(this.f.c())) {
            this.a.a(this.b instanceof f ? 123 : 113);
            return;
        }
        this.b.a((b) new b() {
            public void a(final com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
                a.this.h();
                a.this.f.e().d(a.this.c());
                a.this.a(hVar);
                a.this.b(hVar);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        a.this.c(hVar);
                    }
                });
                if (a.this.a != null && hVar != null) {
                    a.this.a.setBgColor(hVar.a());
                    a.this.a.setBgMaterialCenterCalcColor(hVar.b());
                }
            }
        });
        this.b.a(this.f);
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.b.h> k;
        if (hVar != null && (k = hVar.k()) != null && k.size() > 0) {
            Collections.sort(k, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.b.h>() {
                /* renamed from: a */
                public int compare(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar2) {
                    com.bytedance.sdk.component.adexpress.dynamic.b.f e = hVar.j().e();
                    com.bytedance.sdk.component.adexpress.dynamic.b.f e2 = hVar2.j().e();
                    if (e == null || e2 == null) {
                        return 0;
                    }
                    return e.am() >= e2.am() ? 1 : -1;
                }
            });
            for (com.bytedance.sdk.component.adexpress.dynamic.b.h next : k) {
                if (next != null) {
                    a(next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        float f2;
        float f3;
        List<com.bytedance.sdk.component.adexpress.dynamic.b.h> k;
        if (hVar != null) {
            List<com.bytedance.sdk.component.adexpress.dynamic.b.h> k2 = hVar.k();
            if (k2 == null || k2.size() <= 0) {
                f2 = 0.0f;
            } else {
                f2 = 0.0f;
                for (com.bytedance.sdk.component.adexpress.dynamic.b.h next : k2) {
                    if (next.g() > hVar.g() - next.i() || (k = next.k()) == null || k.size() <= 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = 0.0f;
                        for (com.bytedance.sdk.component.adexpress.dynamic.b.h next2 : k) {
                            if (next2.j().b().equals("logo-union")) {
                                f3 = (float) next2.j().f();
                                f2 = (((-f3) + hVar.g()) - next.g()) + ((float) next.j().e().as());
                            }
                        }
                    }
                    b(next);
                    if (f3 <= -15.0f) {
                        next.f(next.i() - f3);
                        next.d(next.g() + f3);
                        for (com.bytedance.sdk.component.adexpress.dynamic.b.h next3 : next.k()) {
                            next3.d(next3.g() - f3);
                        }
                    }
                }
            }
            com.bytedance.sdk.component.adexpress.dynamic.b.h l = hVar.l();
            if (l != null) {
                hVar.c(hVar.f() - l.f());
                hVar.d(hVar.g() - l.g());
                if (f2 > 0.0f) {
                    hVar.d(hVar.g() - f2);
                    hVar.f(hVar.i() + f2);
                    for (com.bytedance.sdk.component.adexpress.dynamic.b.h next4 : hVar.k()) {
                        next4.d(next4.g() + f2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public DynamicRootView e() {
        return d();
    }

    public void b() {
        a((View) e());
    }

    private void a(View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    a(viewGroup.getChildAt(i));
                    i++;
                }
            }
            if (view instanceof e) {
                ((e) view).b();
            }
        }
    }

    public int c() {
        return this.b instanceof f ? 3 : 2;
    }

    /* access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        if (hVar == null) {
            this.a.a(this.b instanceof f ? 123 : 113);
            return;
        }
        this.f.e().e(c());
        try {
            this.a.a(hVar, c());
        } catch (Exception unused) {
            this.a.a(this.b instanceof f ? 128 : 118);
        }
    }

    public DynamicRootView d() {
        return this.a;
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    private boolean g() {
        DynamicRootView dynamicRootView = this.a;
        if (dynamicRootView == null || dynamicRootView.getChildCount() == 0) {
            return false;
        }
        return true;
    }

    public void a(n nVar) {
        if (!this.h.get()) {
            this.h.set(true);
            if (!nVar.c() || !g()) {
                this.d.a(nVar.j());
                return;
            }
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.d.a(e(), nVar);
        }
    }

    public void a(View view, int i, c cVar) {
        h hVar = this.e;
        if (hVar != null) {
            hVar.a(view, i, cVar);
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.a.a$a  reason: collision with other inner class name */
    /* compiled from: DynamicRender */
    private class C0044a implements Runnable {
        private int b;

        public C0044a(int i) {
            this.b = i;
        }

        public void run() {
            if (this.b == 2) {
                l.b("DynamicRender", "Dynamic parse time out");
                a.this.a.a(a.this.b instanceof f ? 127 : 117);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            ScheduledFuture<?> scheduledFuture = this.g;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.g.cancel(false);
                this.g = null;
            }
            l.b("DynamicRender", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
