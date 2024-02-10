package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.component.h.a;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdBackupView;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenAdExpressView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;

/* compiled from: AppOpenAdExpressManager */
public class b extends c {
    /* access modifiers changed from: private */
    public PAGAppOpenAdExpressView j;
    /* access modifiers changed from: private */
    public boolean k;

    public b(Activity activity, q qVar, FrameLayout frameLayout, a aVar, int i, boolean z, a aVar2) {
        super(activity, qVar, frameLayout, aVar, i, z, aVar2);
    }

    public void a(ViewGroup viewGroup) {
        q.a I;
        Pair<Float, Float> a = com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.a(this.a.getWindow(), this.g);
        AdSlot build = new AdSlot.Builder().setCodeId(String.valueOf(this.b.aZ())).setExpressViewAcceptedSize(((Float) a.first).floatValue(), ((Float) a.second).floatValue()).build();
        if (l.d() && (I = this.b.I()) != null) {
            l.a("AppOpenAdExpressManager", "open_ad", "tryDynamicNative: id is " + I.e());
        }
        PAGAppOpenAdExpressView pAGAppOpenAdExpressView = new PAGAppOpenAdExpressView(this.a, this.b, build, "open_ad");
        this.j = pAGAppOpenAdExpressView;
        pAGAppOpenAdExpressView.setTopListener(this.e);
        this.j.setExpressVideoListenerProxy(this.e);
        this.j.setExpressInteractionListener(new PAGBannerAdWrapperListener() {
            public void onAdClicked(View view, int i) {
            }

            public void onAdDismissed() {
            }

            public void onAdShow(View view, int i) {
            }

            public void onRenderFail(View view, String str, int i) {
                b.this.e.d();
            }

            public void onRenderSuccess(View view, float f, float f2) {
                if (b.this.j.n()) {
                    boolean unused = b.this.k = true;
                    b bVar = b.this;
                    b.super.a((ViewGroup) bVar.d);
                    b.super.a();
                    b.super.b();
                } else if (b.this.b.br()) {
                    b.this.e.c();
                } else if (b.this.c) {
                    b bVar2 = b.this;
                    if (bVar2.a(bVar2.j.getVideoFrameLayout())) {
                        b.this.e.c();
                    } else {
                        b.this.e.d();
                    }
                } else {
                    b.this.e.c();
                }
            }
        });
        this.b.h(1);
        this.d.addView(this.j, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a() {
        this.j.setClickListener(com.bytedance.sdk.openadsdk.component.a.b.a(this.b, this.a, this.i, this.j));
        f b = com.bytedance.sdk.openadsdk.component.a.b.b(this.b, this.a, this.i, this.j);
        this.j.setClickCreativeListener(b);
        b.a((b.a) new b.a() {
            public void a(View view, int i) {
                b.this.e.e();
            }
        });
        this.j.setBackupListener(new c() {
            public boolean a(ViewGroup viewGroup, int i) {
                l.a("AppOpenAdExpressManager", "open_ad", "isUseBackup() called with: view = [" + viewGroup + "], errCode = [" + i + "]");
                try {
                    ((NativeExpressView) viewGroup).m();
                    new OpenScreenAdBackupView(b.this.a).a(b.this.j);
                    return true;
                } catch (Exception e) {
                    Log.e("AppOpenAdExpressManager", "", e);
                    return false;
                }
            }
        });
    }

    public void b() {
        this.j.j();
    }

    public void a(int i, int i2, boolean z) {
        if (this.k) {
            super.a(i, i2, z);
        } else {
            this.j.a(String.valueOf(i), i2, 0, z);
        }
    }

    public void c() {
        super.c();
        PAGAppOpenAdExpressView pAGAppOpenAdExpressView = this.j;
        if (pAGAppOpenAdExpressView != null) {
            pAGAppOpenAdExpressView.l();
        }
    }

    public int d() {
        return this.j.getDynamicShowType();
    }
}
