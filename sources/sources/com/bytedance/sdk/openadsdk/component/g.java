package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.b.a;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.f;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.model.v;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTAppOpenAdLoadManager */
public class g implements x.a {
    private final Context a;
    private final p<a> b;
    /* access modifiers changed from: private */
    public final f c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public int e = 0;
    /* access modifiers changed from: private */
    public AdSlot f;
    private PAGAppOpenAdLoadListener g;
    private int h;
    /* access modifiers changed from: private */
    public volatile int i = 0;
    /* access modifiers changed from: private */
    public final v j = new v();
    private boolean k;

    public g(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = o.a();
        }
        this.b = o.c();
        this.c = f.a(this.a);
    }

    public static g a(Context context) {
        return new g(context);
    }

    public void a(AdSlot adSlot, b bVar, int i2) {
        if (bVar != null) {
            if (i2 <= 0) {
                l.b("TTAppOpenAdLoadManager", "Since the timeout value passed by loadAppOpenAd is <=0, now it is set to the default value of 3500ms");
                i2 = IronSourceConstants.BN_AUCTION_REQUEST;
            }
            this.f = adSlot;
            this.j.a = !TextUtils.isEmpty(adSlot.getBidAdm());
            if (bVar instanceof PAGAppOpenAdLoadListener) {
                this.g = (PAGAppOpenAdLoadListener) bVar;
            }
            this.e = a(this.f);
            this.h = i2;
            this.j.a(ab.a());
            if (this.j.a || com.bytedance.sdk.openadsdk.core.settings.o.ai().x(this.f.getCodeId()) == 0) {
                b(this.f);
            }
            if (!this.j.a) {
                new x(com.bytedance.sdk.openadsdk.core.l.b().getLooper(), this).sendEmptyMessageDelayed(1, (long) i2);
                a();
            }
        }
    }

    private void b(final AdSlot adSlot) {
        final ab a2 = ab.a();
        this.i = 1;
        s sVar = new s();
        sVar.h = this.j;
        sVar.d = 1;
        sVar.f = 2;
        this.b.a(adSlot, sVar, 3, (p.a) new p.a() {
            public void a(int i, String str) {
                int unused = g.this.i = 3;
                l.b("TTAppOpenAdLoadManager", "try load app open ad from network fail, " + i + ", " + str);
                g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, i, str));
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                int unused = g.this.i = 2;
                l.b("TTAppOpenAdLoadManager", "try load app open ad from network success");
                if (aVar == null || aVar.c() == null || aVar.c().size() == 0) {
                    int unused2 = g.this.i = 3;
                    g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, Sdk.SDKError.Reason.AD_SERVER_ERROR_VALUE, com.bytedance.sdk.openadsdk.core.g.a(Sdk.SDKError.Reason.AD_SERVER_ERROR_VALUE)));
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                final q qVar = aVar.c().get(0);
                long m = qVar.m();
                g.this.j.b = m;
                if (qVar.br()) {
                    g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar));
                } else if (q.c(qVar)) {
                    g.this.a(qVar, adSlot);
                } else {
                    if (o.d().k() == 1) {
                        g.this.j.b = -1;
                        g.this.j.a(3);
                        g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar));
                    }
                    g.this.a(qVar);
                }
                if (g.this.j.a) {
                    c.c(qVar, "open_ad", a2.c());
                    l.a("TTAppOpenAdLoadManager", "onAdLoad: invoke callback after ", Long.valueOf(m), "ms for bidding");
                    if (m == 0) {
                        g.this.j.a(2);
                        g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar));
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.l.b().postDelayed(new Runnable() {
                        public void run() {
                            g.this.j.a(2);
                            g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar));
                        }
                    }, m);
                }
            }
        });
    }

    private void a() {
        aa.b(new h("tryGetAppOpenAdFromCache") {
            public void run() {
                boolean z;
                q e = g.this.c.e(g.this.e);
                if (e != null) {
                    boolean c = q.c(e);
                    if (e.br()) {
                        g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                        return;
                    }
                    if (c || o.d().k() != 1) {
                        z = false;
                    } else {
                        g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                        z = true;
                    }
                    if (g.this.c.b(g.this.e) || g.this.c.d(g.this.e)) {
                        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().x(g.this.f.getCodeId()) == 0) {
                            g.this.c.g(g.this.e);
                        }
                        l.b("TTAppOpenAdLoadManager", "Cached material resolution success, video = " + c);
                        if (c) {
                            if (!TextUtils.isEmpty(g.this.c.a(e)) || Build.VERSION.SDK_INT < 23) {
                                g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                                return;
                            }
                            l.b("TTAppOpenAdLoadManager", "Video cache path not found");
                            g.this.a(false);
                            com.bytedance.sdk.openadsdk.component.d.a.b(e);
                        } else if (!g.this.c.b(e)) {
                            l.b("TTAppOpenAdLoadManager", "Image cache path not found");
                            g.this.a(false);
                            com.bytedance.sdk.openadsdk.component.d.a.b(e);
                        } else if (!z) {
                            g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                        }
                    } else {
                        g.this.a(true);
                    }
                } else {
                    g.this.a(false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.g(this.e);
        }
        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().x(this.f.getCodeId()) == 1) {
            b(this.f);
        }
    }

    /* access modifiers changed from: private */
    public void a(final q qVar, AdSlot adSlot) {
        this.c.a(qVar, adSlot, this.j, (f.c) new f.c() {
            public void a() {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
                int unused = g.this.i = 4;
                com.bytedance.sdk.openadsdk.component.e.b bVar = new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar);
                bVar.a(true);
                g.this.a(bVar);
            }

            public void a(int i, String str) {
                l.b("TTAppOpenAdLoadManager", "preLoadFail() called with: code = [" + i + "], message = [" + str + "]");
                int unused = g.this.i = 5;
                g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, VungleError.CONFIGURATION_ERROR, com.bytedance.sdk.openadsdk.core.g.a(VungleError.CONFIGURATION_ERROR)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final q qVar) {
        this.c.a(qVar, this.j, (f.b) new f.b() {
            public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
                int unused = g.this.i = 4;
                com.bytedance.sdk.openadsdk.component.e.b bVar2 = new com.bytedance.sdk.openadsdk.component.e.b(1, 100, qVar);
                bVar2.a(true);
                g.this.a(bVar2);
            }

            public void a() {
                Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
                int unused = g.this.i = 5;
                g.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, VungleError.CONFIGURATION_ERROR, com.bytedance.sdk.openadsdk.core.g.a(VungleError.CONFIGURATION_ERROR)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.component.e.b bVar) {
        int b2 = bVar.b();
        int c2 = bVar.c();
        if (this.d.get()) {
            if (b2 == 1 && c2 == 100 && bVar.a()) {
                f.a(o.a()).a(new com.bytedance.sdk.openadsdk.component.e.a(this.e, bVar.d()));
                if (!this.k) {
                    com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), 1, this.j);
                }
            }
        } else if (b2 == 1) {
            if (this.g != null) {
                this.g.onAdLoaded(new d(this.a, bVar.d(), c2 == 101, this.f));
            }
            this.d.set(true);
            if (c2 == 101) {
                com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), this.j.a().c());
            } else if (c2 == 100) {
                com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), 0, this.j);
                this.k = true;
                if (this.j.a) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.settings.o.ai().x(this.f.getCodeId()) == 0) {
                    this.c.a(this.f);
                } else {
                    this.c.a(new com.bytedance.sdk.openadsdk.component.e.a(this.e, bVar.d()));
                }
            }
        } else if (b2 == 2 || b2 == 3) {
            PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.g;
            if (pAGAppOpenAdLoadListener != null) {
                pAGAppOpenAdLoadListener.onError(bVar.e(), bVar.f());
            }
            this.d.set(true);
            if (b2 == 3) {
                com.bytedance.sdk.openadsdk.component.d.a.a(this.i, this.h);
            }
        }
    }

    public int a(AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void a(Message message) {
        if (message.what == 1 && !this.d.get()) {
            a(new com.bytedance.sdk.openadsdk.component.e.b(3, 102, Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE, com.bytedance.sdk.openadsdk.core.g.a(Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE)));
        }
    }
}
