package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.component.f.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;

public class PAGAppOpenAdExpressView extends NativeExpressView {
    boolean a = true;
    private FrameLayout b;
    private a c;
    private c.a d;

    public PAGAppOpenAdExpressView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context, qVar, adSlot, str, true);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.m = true;
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.b = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        super.g();
    }

    public int getDynamicShowType() {
        if (this.w == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    public void a(d<? extends View> dVar, n nVar) {
        if (nVar != null && nVar.c()) {
            b(nVar);
        }
        super.a(dVar, nVar);
    }

    public void b(final n nVar) {
        if (nVar != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    PAGAppOpenAdExpressView.this.c(nVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(n nVar) {
        if (nVar != null) {
            if (nVar.a() == null) {
                double f = nVar.f();
                double g = nVar.g();
                double h = nVar.h();
                double i = nVar.i();
                int b2 = ad.b(this.g, (float) f);
                int b3 = ad.b(this.g, (float) g);
                int b4 = ad.b(this.g, (float) h);
                int b5 = ad.b(this.g, (float) i);
                l.b("ExpressView", "vW x vH =" + h + "x" + i);
                if (i != 0.0d && h != 0.0d) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(b4, b5);
                    }
                    layoutParams.width = b4;
                    layoutParams.height = b5;
                    layoutParams.topMargin = b3;
                    layoutParams.leftMargin = b2;
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                    this.b.setLayoutParams(layoutParams);
                }
            } else if (this.a) {
                nVar.a().setTag(com.bytedance.sdk.component.adexpress.dynamic.a.f, 1);
                FrameLayout frameLayout = (FrameLayout) nVar.a();
                FrameLayout frameLayout2 = frameLayout;
                frameLayout.removeAllViews();
                FrameLayout frameLayout3 = (FrameLayout) nVar.a();
                FrameLayout frameLayout4 = frameLayout3;
                this.b = frameLayout3;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout3.getLayoutParams();
                FrameLayout.LayoutParams layoutParams3 = layoutParams2;
                layoutParams2.gravity = 17;
                this.a = false;
            }
        }
    }

    public void setExpressVideoListenerProxy(c.a aVar) {
        this.d = aVar;
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b() {
        super.b();
    }

    public void a(int i) {
        super.a(i);
    }

    public void e() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i == -1 || cVar == null || i != 3) {
            super.a(view, i, cVar);
        } else {
            e();
        }
    }

    public void setTopListener(a aVar) {
        this.c = aVar;
    }

    public FrameLayout getVideoFrameLayout() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.g.a.a(this.j, o.d().g(String.valueOf(this.j.aZ())));
    }

    /* access modifiers changed from: protected */
    public void a(m.a aVar) {
        aVar.e(com.bytedance.sdk.openadsdk.component.g.a.b());
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.component.g.a.a(jSONObject, this.j == null ? 0 : this.j.aZ());
    }
}
