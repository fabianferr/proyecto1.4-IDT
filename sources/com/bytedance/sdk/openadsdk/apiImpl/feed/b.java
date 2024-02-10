package com.bytedance.sdk.openadsdk.apiImpl.feed;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;

/* compiled from: PAGFeedNativeVideoAdImpl */
public class b extends h implements c.C0035c, c.d, a.C0073a {
    private c h;
    /* access modifiers changed from: private */
    public final a i;
    private boolean j = false;
    private boolean k = true;
    private AdSlot l;
    private long m;

    public b(Context context, q qVar, int i2, AdSlot adSlot) {
        super(context, qVar, i2, true);
        this.e = i2;
        this.l = adSlot;
        this.i = new a();
        a(this.f);
        a("embeded_ad");
        this.d.a(this);
    }

    public b(Context context, q qVar, int i2, AdSlot adSlot, a aVar, n nVar) {
        super(context, qVar, i2, false);
        this.d = aVar;
        this.a = nVar;
        this.e = i2;
        this.l = adSlot;
        this.i = new a();
        a(this.f);
        a("embeded_ad");
        aVar.a(this);
    }

    public View f() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.b == null || this.c == null)) {
            if (q.c(this.b)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.c, this.b, this.a.a());
                    if (this.b != null && this.b.at()) {
                        f a = nativeVideoTsView.a((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        if (this.d != null) {
                            this.d.a(a);
                        }
                    }
                    this.a.a(nativeVideoTsView.getNativeVideoController());
                    if (this.d != null) {
                        this.d.a(nativeVideoTsView);
                    }
                    nativeVideoTsView.setVideoAdClickListenerTTNativeAd(this);
                    nativeVideoTsView.setAdCreativeClickListener(new NativeVideoTsView.a() {
                        public void a(View view, int i) {
                            if (b.this.a != null) {
                                b.this.a.a(view, i);
                            }
                        }
                    });
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.b() {
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            b.this.i.a = z;
                            b.this.i.e = j;
                            b.this.i.f = j2;
                            b.this.i.g = j3;
                            b.this.i.d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.e) {
                        nativeVideoTsView.setIsAutoPlay(this.j ? this.l.isAutoPlay() : this.k);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.k);
                    }
                    nativeVideoTsView.setIsQuiet(o.d().c(String.valueOf(this.f)));
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                }
                if (!q.c(this.b) && nativeVideoTsView != null && nativeVideoTsView.a(0, true, false)) {
                    return nativeVideoTsView;
                }
                ApmHelper.reportCustomError(this.b.ad() + "," + nativeVideoTsView, "getAdView null", new RuntimeException());
            }
            nativeVideoTsView = null;
            if (!q.c(this.b)) {
            }
            ApmHelper.reportCustomError(this.b.ad() + "," + nativeVideoTsView, "getAdView null", new RuntimeException());
        }
        return null;
    }

    private void a(int i2) {
        int b = o.d().b(i2);
        int c = com.bytedance.sdk.component.utils.o.c(o.a());
        if (3 == b) {
            this.j = false;
            this.k = false;
        } else if (1 == b && ac.d(c)) {
            this.j = false;
            this.k = true;
        } else if (2 == b) {
            if (ac.e(c) || ac.d(c) || ac.f(c)) {
                this.j = false;
                this.k = true;
            }
        } else if (4 == b) {
            this.j = true;
        } else if (5 == b && (ac.d(c) || ac.f(c))) {
            this.k = true;
        }
        if (this.d != null) {
            this.d.a(this.j);
        }
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    public void g_() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public void a(int i2, int i3) {
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(i2, i3);
        }
    }

    public void a_() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void d_() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void e_() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.d(this);
        }
    }

    public void a(long j2, long j3) {
        this.m = j2;
        c cVar = this.h;
        if (cVar != null) {
            cVar.a(j2, j3);
        }
    }

    public void f_() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.e(this);
        }
    }

    public a g() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        super.a(str);
    }

    public void showPrivacyActivity() {
        if (this.d != null) {
            this.d.l();
        }
    }
}
