package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class NativeExpressVideoView extends NativeExpressView implements c.C0035c, c.d, l {
    private long A;
    private com.bytedance.sdk.openadsdk.apiImpl.feed.c B;
    int a = 1;
    boolean b = false;
    boolean c = true;
    int d;
    boolean e = true;
    boolean f = true;
    private ExpressVideoView x;
    /* access modifiers changed from: private */
    public a y;
    private long z;

    public void b() {
    }

    public void e() {
    }

    public NativeExpressVideoView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context, qVar, adSlot, str, false);
        h();
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.k = new FrameLayout(this.g);
        int aZ = this.j != null ? this.j.aZ() : 0;
        this.d = aZ;
        c(aZ);
        q();
        addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
    }

    private void q() {
        try {
            this.y = new a();
            ExpressVideoView expressVideoView = new ExpressVideoView(this.g, this.j, this.h, this.t);
            this.x = expressVideoView;
            expressVideoView.setShouldCheckNetChange(false);
            this.x.setControllerStatusCallBack(new NativeVideoTsView.b() {
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.y.a = z;
                    NativeExpressVideoView.this.y.e = j;
                    NativeExpressVideoView.this.y.f = j2;
                    NativeExpressVideoView.this.y.g = j3;
                    NativeExpressVideoView.this.y.d = z2;
                }
            });
            this.x.setVideoAdLoadListener(this);
            this.x.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.h)) {
                this.x.setIsAutoPlay(this.b ? this.i.isAutoPlay() : this.c);
            } else if ("open_ad".equals(this.h)) {
                this.x.setIsAutoPlay(true);
            } else {
                this.x.setIsAutoPlay(this.c);
            }
            if ("open_ad".equals(this.h)) {
                this.x.setIsQuiet(true);
            } else {
                this.q = o.d().c(String.valueOf(this.d));
                this.x.setIsQuiet(this.q);
            }
            this.x.d();
        } catch (Exception unused) {
            this.x = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        int b2 = o.d().b(i);
        if (3 == b2) {
            this.b = false;
            this.c = false;
        } else if (4 == b2) {
            this.b = true;
        } else {
            int c2 = com.bytedance.sdk.component.utils.o.c(o.a());
            if (1 == b2) {
                this.b = false;
                this.c = ac.d(c2);
            } else if (2 == b2) {
                if (ac.e(c2) || ac.d(c2) || ac.f(c2)) {
                    this.b = false;
                    this.c = true;
                }
            } else if (5 == b2 && (ac.d(c2) || ac.f(c2))) {
                this.b = false;
                this.c = true;
            }
        }
        if (!this.c) {
            this.a = 3;
        }
        l.c("NativeVideoAdView", "mIsAutoPlay=" + this.c + ",status=" + b2);
    }

    public a getVideoModel() {
        return this.y;
    }

    private void setShowAdInteractionView(boolean z2) {
        ExpressVideoView expressVideoView = this.x;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z2);
        }
    }

    public void a(d<? extends View> dVar, n nVar) {
        this.w = dVar;
        if ((this.w instanceof p) && ((p) this.w).q() != null) {
            ((p) this.w).q().a((l) this);
        }
        if (nVar != null && nVar.c()) {
            b(nVar);
        }
        super.a(dVar, nVar);
    }

    private void b(final n nVar) {
        if (nVar != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    NativeExpressVideoView.this.c(nVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(n nVar) {
        double f2 = nVar.f();
        double g = nVar.g();
        double h = nVar.h();
        double i = nVar.i();
        l.b("TTAD.NativeExpressVideoView", "videoWH=" + h + "x" + i);
        if (h != 0.0d && i != 0.0d) {
            int b2 = ad.b(this.g, (float) f2);
            int b3 = ad.b(this.g, (float) g);
            int b4 = ad.b(this.g, (float) h);
            int b5 = ad.b(this.g, (float) i);
            float min = Math.min(Math.min((float) ad.b(this.g, nVar.k()), (float) ad.b(this.g, nVar.l())), Math.min((float) ad.b(this.g, nVar.m()), (float) ad.b(this.g, nVar.n())));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(b4, b5);
            }
            layoutParams.width = b4;
            layoutParams.height = b5;
            layoutParams.topMargin = b3;
            layoutParams.leftMargin = b2;
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            this.k.setLayoutParams(layoutParams);
            this.k.removeAllViews();
            if (this.x != null) {
                if (nVar.a() == null) {
                    this.k.addView(this.x);
                } else if (this.f) {
                    nVar.a().setTag(com.bytedance.sdk.component.adexpress.dynamic.a.f, 1);
                    FrameLayout frameLayout = (FrameLayout) nVar.a();
                    FrameLayout frameLayout2 = frameLayout;
                    frameLayout.removeAllViews();
                    FrameLayout frameLayout3 = (FrameLayout) nVar.a();
                    FrameLayout frameLayout4 = frameLayout3;
                    frameLayout3.addView(this.x, new FrameLayout.LayoutParams(-1, -1));
                    this.f = false;
                }
                ad.b((View) this.k, min);
                this.x.a(0, true, false);
                c(this.d);
                if (!com.bytedance.sdk.component.utils.o.d(this.g) && !this.c && this.e) {
                    this.x.e();
                }
                if (!TextUtils.equals("embeded_ad", this.h)) {
                    setShowAdInteractionView(false);
                }
            }
        }
    }

    public void a(boolean z2) {
        l.b("TTAD.NativeExpressVideoView", "onMuteVideo,mute:" + z2);
        ExpressVideoView expressVideoView = this.x;
        if (expressVideoView != null) {
            expressVideoView.setIsQuiet(z2);
            setSoundMute(z2);
        }
    }

    public void a() {
        l.b("TTAD.NativeExpressVideoView", "onSkipVideo");
    }

    public void a(int i) {
        l.b("TTAD.NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        ExpressVideoView expressVideoView = this.x;
        if (expressVideoView == null) {
            l.e("TTAD.NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        } else if (i == 1) {
            expressVideoView.a(0, true, false);
        } else if (i == 2 || i == 3) {
            expressVideoView.setCanInterruptVideoPlay(true);
            this.x.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().d();
        } else if (i == 5) {
            expressVideoView.a(0, true, false);
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i != -1 && cVar != null) {
            if (i == 11) {
                try {
                    ExpressVideoView expressVideoView = this.x;
                    if (expressVideoView != null) {
                        expressVideoView.setCanInterruptVideoPlay(true);
                        this.x.performClick();
                        if (this.l) {
                            this.x.findViewById(i.aJ).setVisibility(0);
                        }
                    }
                } catch (Exception unused) {
                }
            } else {
                super.a(view, i, cVar);
            }
        }
    }

    public long c() {
        return this.z;
    }

    public int d() {
        ExpressVideoView expressVideoView;
        if (this.a == 3 && (expressVideoView = this.x) != null) {
            expressVideoView.d();
        }
        ExpressVideoView expressVideoView2 = this.x;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().p()) {
            return this.a;
        }
        return 1;
    }

    public void a_() {
        this.e = false;
        l.b("TTAD.NativeExpressVideoView", "onVideoAdStartPlay");
        this.a = 2;
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.b((PAGNativeAd) null);
        }
    }

    public void d_() {
        this.e = false;
        l.b("TTAD.NativeExpressVideoView", "onVideoAdPaused");
        this.l = true;
        this.a = 3;
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.c((PAGNativeAd) null);
        }
    }

    public void e_() {
        this.e = false;
        l.b("TTAD.NativeExpressVideoView", "onVideoAdContinuePlay");
        this.l = false;
        this.a = 2;
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.d((PAGNativeAd) null);
        }
    }

    public void a(long j, long j2) {
        this.e = false;
        int i = this.a;
        if (!(i == 5 || i == 3 || j <= this.z)) {
            this.a = 2;
        }
        this.z = j;
        this.A = j2;
        if (!(this.v == null || this.v.d() == null)) {
            this.v.d().setTimeUpdate(((int) (j2 - j)) / 1000);
        }
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.a(j, j2);
        }
    }

    public void f_() {
        this.e = false;
        l.b("TTAD.NativeExpressVideoView", "onVideoComplete");
        this.a = 5;
        if (!(this.v == null || this.v.d() == null)) {
            this.v.d().f();
        }
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.e((PAGNativeAd) null);
        }
    }

    public void g_() {
        l.b("TTAD.NativeExpressVideoView", "onVideoLoad");
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.a((PAGNativeAd) null);
        }
    }

    public void a(int i, int i2) {
        l.b("TTAD.NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        this.z = this.A;
        this.a = 4;
        com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar = this.B;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public ExpressVideoView getExpressVideoView() {
        return this.x;
    }

    public c getVideoController() {
        ExpressVideoView expressVideoView = this.x;
        if (expressVideoView != null) {
            return expressVideoView.getNativeVideoController();
        }
        return null;
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.apiImpl.feed.c cVar) {
        this.B = cVar;
    }

    public com.bytedance.sdk.openadsdk.apiImpl.feed.c getVideoAdListener() {
        return this.B;
    }
}
