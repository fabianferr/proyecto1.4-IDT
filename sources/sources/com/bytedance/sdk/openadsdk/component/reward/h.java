package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.a.b;
import com.bytedance.sdk.openadsdk.core.model.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.g;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.d;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import com.facebook.AccessToken;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGRewardVideoAdImpl */
class h extends PAGRewardedAd {
    /* access modifiers changed from: private */
    public final Context a;
    private final a b;
    private final AdSlot c;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.apiImpl.d.a d;
    /* access modifiers changed from: private */
    public boolean e;
    private final AtomicBoolean f = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final String g;
    private boolean h;
    private boolean i;

    h(Context context, a aVar, AdSlot adSlot) {
        this.a = context;
        this.b = aVar;
        this.c = adSlot;
        this.g = r.a();
    }

    public void a() {
        if (!this.f.get()) {
            this.e = true;
        }
    }

    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.d = new i(pAGRewardedAdInteractionListener);
        a(0);
    }

    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.d = new i(pAGRewardedAdInteractionCallback);
        a(0);
    }

    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            l.e("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        a aVar = this.b;
        if (aVar != null && aVar.d()) {
            boolean f2 = this.b.f();
            final q e2 = this.b.e();
            if (!com.bykv.vk.openvk.component.video.a.c.a.b()) {
                c.b(e2, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
                l.e("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
                throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
            } else if (this.f.compareAndSet(false, true)) {
                if (e2 == null || e2.K() == null) {
                    c.b(e2, "fullscreen_interstitial_ad", "materialMeta error ");
                    return;
                }
                Context context = activity == null ? this.a : activity;
                if (context == null) {
                    context = o.a();
                }
                if (f2) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else if (e2.u() != 2 || e2.o() == 5 || e2.o() == 6 || e2.o() == 19) {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                }
                b.a(intent, activity, this.e, this.b, this.g);
                intent.putExtra("media_extra", this.c.getMediaExtra());
                intent.putExtra(AccessToken.USER_ID_KEY, this.c.getUserID());
                intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
                if (!com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    s.a().a(this.d);
                    this.d = null;
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                    public void a() {
                    }

                    public void a(Throwable th) {
                        l.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                        c.b(e2, "fullscreen_interstitial_ad", "activity start  fail ");
                    }
                });
                com.bytedance.sdk.openadsdk.core.l.b().post(new Runnable() {
                    public void run() {
                        try {
                            AdSlot D = e2.D();
                            if (D != null) {
                                l.a(h.this.a).a(D.getCodeId());
                                if (h.this.e) {
                                    l.a(h.this.a).b(D);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
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
            aa.c(new com.bytedance.sdk.component.g.h("Reward_registerMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a();
                    if (i2 == 0 && h.this.d != null) {
                        l.b("MultiProcess", "start registerRewardVideoListener ! ");
                        d dVar = new d(h.this.d);
                        IListenerManager asInterface = g.asInterface(a2.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(h.this.g, dVar);
                                l.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e) {
                                l.e("TTRewardVideoAdImpl", e.getMessage());
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
