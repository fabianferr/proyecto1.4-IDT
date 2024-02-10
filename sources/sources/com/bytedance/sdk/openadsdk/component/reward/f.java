package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.b.b;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.b.h;
import com.bytedance.sdk.openadsdk.core.model.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGInterstitialAdImpl */
class f extends PAGInterstitialAd {
    private final Context a;
    private final a b;
    /* access modifiers changed from: private */
    public b c;
    private boolean d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public final String g;
    private boolean h;
    private boolean i;

    f(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
        this.d = false;
        this.g = r.a();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a() {
        if (!this.e.get()) {
            this.d = true;
        }
    }

    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.c = new com.bytedance.sdk.openadsdk.component.c.a(pAGInterstitialAdInteractionListener);
        a(1);
    }

    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.c = new com.bytedance.sdk.openadsdk.component.c.a(pAGInterstitialAdInteractionCallback);
        a(1);
    }

    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            l.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        a aVar = this.b;
        if (aVar != null && aVar.d()) {
            boolean f2 = this.b.f();
            final q e2 = this.b.e();
            if (!com.bykv.vk.openvk.component.video.a.c.a.b()) {
                c.b(e2, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
                l.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
                throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
            } else if (!this.e.get()) {
                this.e.set(true);
                if (e2 == null || (e2.K() == null && e2.Q() == null)) {
                    c.b(e2, "fullscreen_interstitial_ad", "materialMeta error ");
                    return;
                }
                Context context = activity == null ? this.a : activity;
                if (context == null) {
                    context = o.a();
                }
                if (f2) {
                    intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
                } else if (e2.u() != 2 || e2.o() == 5 || e2.o() == 6 || e2.o() == 19) {
                    if (h.a(e2)) {
                        intent = new Intent(context, TTInterstitialActivity.class);
                    } else {
                        intent = new Intent(context, TTFullScreenVideoActivity.class);
                    }
                } else if (h.a(e2)) {
                    intent = new Intent(context, TTInterstitialExpressActivity.class);
                } else {
                    intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
                }
                intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
                com.bytedance.sdk.openadsdk.component.reward.a.b.a(intent, activity, this.d, this.b, this.g);
                intent.putExtra("is_verity_playable", this.f);
                if (!com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    s.a().a(this.c);
                    this.c = null;
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                    public void a() {
                        if (f.this.f) {
                            try {
                                com.bytedance.sdk.openadsdk.j.b.a().a(e2.K().l());
                            } catch (Throwable unused) {
                            }
                        }
                    }

                    public void a(Throwable th) {
                        l.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                        if (f.this.f) {
                            try {
                                com.bytedance.sdk.openadsdk.j.b.a().a(e2.K().l(), -1, th != null ? th.getMessage() : "playable tool error open");
                            } catch (Throwable unused) {
                            }
                        }
                        c.b(e2, "fullscreen_interstitial_ad", "activity start  fail ");
                    }
                });
                if (!f2) {
                    a.a(this.b.e(), this.d);
                }
            }
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        a aVar = this.b;
        if (aVar == null || aVar.e() == null) {
            return null;
        }
        return this.b.e().ai();
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            aa.c(new com.bytedance.sdk.component.g.h("FullScreen_registerMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a();
                    if (i2 == 1 && f.this.c != null) {
                        l.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(f.this.c);
                        IListenerManager asInterface = e.asInterface(a2.a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(f.this.g, cVar);
                                l.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e) {
                                l.e("TTFullScreenVideoAdImpl", e.getMessage());
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    public void win(Double d2) {
        if (!this.h) {
            w.a(this.b.e(), d2);
            this.h = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.i) {
            w.a(this.b.e(), d2, str, str2);
            this.i = true;
        }
    }
}
