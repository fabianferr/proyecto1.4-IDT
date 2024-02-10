package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import com.com.bytedance.overseas.sdk.a.c;
import com.com.bytedance.overseas.sdk.a.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PAGBannerAdImpl */
public class a extends PAGBannerAd implements x.a {
    protected BannerExpressView a;
    protected final Context b;
    protected q c;
    protected AdSlot d;
    TTDislikeDialogAbstract e;
    protected final View.OnAttachStateChangeListener f = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
            a aVar = a.this;
            aVar.a(aVar.a.getCurView(), a.this.c);
        }

        public void onViewDetachedFromWindow(View view) {
            a.this.a.c();
        }
    };
    /* access modifiers changed from: private */
    public final boolean g;
    /* access modifiers changed from: private */
    public PAGBannerAdWrapperListener h;
    /* access modifiers changed from: private */
    public int i;
    private int j = 0;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.dislike.b k;
    /* access modifiers changed from: private */
    public c l;
    private x m;
    private t.a n;
    private final Queue<Long> o = new LinkedList();
    private boolean p;
    private boolean q;
    /* access modifiers changed from: private */
    public String r = "banner_ad";
    /* access modifiers changed from: private */
    public NativeExpressView s;

    /* renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.a$a  reason: collision with other inner class name */
    /* compiled from: PAGBannerAdImpl */
    public interface C0062a {
        void a();
    }

    public a(Context context, q qVar, AdSlot adSlot) {
        this.b = context;
        this.c = qVar;
        this.d = adSlot;
        a(context, qVar, adSlot);
        this.g = false;
    }

    public void win(Double d2) {
        if (!this.p) {
            w.a(this.c, d2);
            this.p = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.q) {
            w.a(this.c, d2, str, str2);
            this.q = true;
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.c;
        if (qVar != null) {
            return qVar.ai();
        }
        return null;
    }

    public void setAdInteractionCallback(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        b bVar = new b(pAGBannerAdInteractionCallback);
        this.h = bVar;
        this.a.setExpressInteractionListener(bVar);
    }

    public void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        b bVar = new b(pAGBannerAdInteractionListener);
        this.h = bVar;
        this.a.setExpressInteractionListener(bVar);
    }

    public View getBannerView() {
        com.bytedance.sdk.openadsdk.utils.b.a(this.c);
        return this.a;
    }

    public void destroy() {
        if (this.a != null) {
            l.b("PAGBannerAdImpl", "PAGBanner destroy");
            try {
                this.a.c();
                this.a.removeOnAttachStateChangeListener(this.f);
            } catch (Throwable unused) {
            }
        }
        e();
    }

    public void a(Context context, q qVar, AdSlot adSlot) {
        BannerExpressView bannerExpressView = new BannerExpressView(context, qVar, adSlot);
        this.a = bannerExpressView;
        bannerExpressView.addOnAttachStateChangeListener(this.f);
    }

    /* access modifiers changed from: protected */
    public void a(final NativeExpressView nativeExpressView, q qVar) {
        EmptyView emptyView;
        if (nativeExpressView != null && qVar != null) {
            this.c = qVar;
            this.l = a(qVar);
            this.s = nativeExpressView;
            final String a2 = r.a();
            final C0062a a3 = a();
            nativeExpressView.setClosedListenerKey(a2);
            nativeExpressView.setBannerClickClosedListener(a3);
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.b.c() {
                public boolean a(ViewGroup viewGroup, int i) {
                    try {
                        nativeExpressView.m();
                        if (a.this.c.at()) {
                            VastBannerBackupView vastBannerBackupView = new VastBannerBackupView(nativeExpressView.getContext());
                            vastBannerBackupView.setClosedListenerKey(a2);
                            vastBannerBackupView.a(a.this.c, nativeExpressView, a.this.l);
                            vastBannerBackupView.setDislikeInner(a.this.k);
                            vastBannerBackupView.setDislikeOuter(a.this.e);
                            vastBannerBackupView.setAdInteractionListener(a.this.h);
                            nativeExpressView.setVastVideoHelper(vastBannerBackupView);
                            return true;
                        }
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView.getContext());
                        bannerExpressBackupView.setClosedListenerKey(a2);
                        bannerExpressBackupView.a(a.this.c, nativeExpressView, a.this.l);
                        bannerExpressBackupView.setDislikeInner(a.this.k);
                        bannerExpressBackupView.setDislikeOuter(a.this.e);
                        bannerExpressBackupView.setAdInteractionListener(a.this.h);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            if (!this.g) {
                EmptyView a4 = a((ViewGroup) nativeExpressView);
                if (a4 == null) {
                    a4 = new EmptyView(this.b, nativeExpressView);
                    nativeExpressView.addView(a4);
                }
                emptyView = a4;
                final q qVar2 = qVar;
                final EmptyView emptyView2 = emptyView;
                final NativeExpressView nativeExpressView2 = nativeExpressView;
                final String str = a2;
                emptyView.setCallback(new EmptyView.a() {
                    public void a(boolean z) {
                        a.this.a(z, qVar2);
                    }

                    public void a() {
                        a.this.c();
                    }

                    public void b() {
                        a.this.a(emptyView2, false, qVar2);
                    }

                    public void a(View view) {
                        a.this.a(view, nativeExpressView2, qVar2, str, a3);
                    }
                });
            } else {
                final q qVar3 = qVar;
                final NativeExpressView nativeExpressView3 = nativeExpressView;
                final String str2 = a2;
                final C0062a aVar = a3;
                ae.a(nativeExpressView, true, 1, new ae.b() {
                    public void a(boolean z) {
                        a.this.a(z, qVar3);
                    }

                    public void a() {
                        a.this.c();
                    }

                    public void b() {
                        a.this.a((EmptyView) null, true, qVar3);
                    }

                    public void a(View view, boolean z) {
                        if (z) {
                            a.this.a(view, nativeExpressView3, qVar3, str2, aVar);
                        }
                    }
                }, (List<ViewGroup>) null);
                emptyView = null;
            }
            g gVar = new g(this.b, qVar, this.r, 2);
            gVar.a((View) nativeExpressView);
            gVar.a((PangleAd) this);
            gVar.a(this.l);
            nativeExpressView.setClickListener(gVar);
            f fVar = new f(this.b, qVar, this.r, 2);
            fVar.a((View) nativeExpressView);
            fVar.a((PangleAd) this);
            NativeExpressView nativeExpressView4 = this.s;
            if (nativeExpressView4 instanceof NativeExpressVideoView) {
                fVar.a(((NativeExpressVideoView) nativeExpressView4).getVideoController());
            }
            fVar.a(this.l);
            nativeExpressView.setClickCreativeListener(fVar);
            if (!this.g) {
                emptyView.setNeedCheckingShow(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, q qVar) {
        if (z) {
            if (this.c.bj() && !this.c.bo()) {
                this.c.f(true);
                q qVar2 = this.c;
                com.bytedance.sdk.openadsdk.b.c.a(qVar2, this.r, qVar2.bk());
            }
            f();
            l.a("PAGBannerAdImpl", "banner_ad", "Get focus, start timing");
        } else {
            e();
            l.a("PAGBannerAdImpl", "banner_ad", "Lose focus, stop timing");
        }
        aa.b(new b(z, qVar, this), 10);
    }

    /* access modifiers changed from: private */
    public void c() {
        b();
        f();
    }

    /* access modifiers changed from: private */
    public void a(EmptyView emptyView, boolean z, q qVar) {
        BannerExpressView bannerExpressView = this.a;
        if (bannerExpressView != null) {
            if (!z && emptyView != null && emptyView == a((ViewGroup) bannerExpressView.getCurView())) {
                e();
            } else if (z) {
                e();
            }
        }
        b(qVar);
    }

    /* access modifiers changed from: private */
    public void a(View view, NativeExpressView nativeExpressView, q qVar, String str, C0062a aVar) {
        h.b().a(str, aVar);
        l.a("PAGBannerAdImpl", "banner_ad", "ExpressView SHOW");
        Queue<Long> queue = this.o;
        if (queue != null) {
            queue.offer(Long.valueOf(System.currentTimeMillis()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (nativeExpressView != null) {
                jSONObject.put("dynamic_show_type", nativeExpressView.getDynamicShowType());
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
                    jSONObject2.put("alpha", (double) view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.b.c.a(qVar, this.r, jSONObject);
        } catch (JSONException unused2) {
            l.e("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.h;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, qVar.M());
        }
        if (qVar.ah()) {
            ac.a(qVar, view);
        }
        f();
        BannerExpressView bannerExpressView = this.a;
        if (bannerExpressView != null && bannerExpressView.getCurView() != null) {
            this.a.getCurView().k();
            this.a.getCurView().i();
        }
    }

    private c a(q qVar) {
        if (qVar.M() == 4) {
            return d.a(this.b, qVar, this.r);
        }
        return null;
    }

    /* compiled from: PAGBannerAdImpl */
    private static class b extends com.bytedance.sdk.component.g.h {
        boolean a;
        q b;
        WeakReference<a> c;

        b(boolean z, q qVar, a aVar) {
            super("ReportWindowFocusChangedAdShow");
            this.a = z;
            this.b = qVar;
            this.c = new WeakReference<>(aVar);
        }

        public void run() {
            WeakReference<a> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.c.get()).b(this.a, this.b);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z, q qVar) {
        Long poll;
        if (z) {
            try {
                this.o.offer(Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e2) {
                l.e("PAGBannerAdImpl", e2.getMessage());
            }
        } else if (this.o.size() > 0 && this.s != null && (poll = this.o.poll()) != null) {
            com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(System.currentTimeMillis() - poll.longValue()), qVar, this.r, this.s.getAdShowTime());
        }
    }

    /* access modifiers changed from: private */
    public EmptyView a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < viewGroup.getChildCount()) {
            try {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void b(q qVar) {
        Queue<Long> queue = this.o;
        if (queue != null && queue.size() > 0 && qVar != null) {
            try {
                long longValue = this.o.poll().longValue();
                if (longValue > 0 && this.s != null) {
                    com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(System.currentTimeMillis() - longValue), qVar, this.r, this.s.getAdShowTime());
                }
            } catch (Exception e2) {
                l.e("PAGBannerAdImpl", e2.getMessage());
            }
        }
    }

    public C0062a a() {
        return new C0062a() {
            public void a() {
                EmptyView emptyView;
                int width = a.this.s.getWidth();
                int height = a.this.s.getHeight();
                double d = (double) width;
                Double.isNaN(d);
                View a2 = a(((double) height) >= Math.floor((d * 450.0d) / 600.0d));
                a.this.s.o();
                if (!a.this.g) {
                    a aVar = a.this;
                    emptyView = aVar.a((ViewGroup) aVar.s);
                } else {
                    emptyView = null;
                }
                a.this.s.removeAllViews();
                a.this.s.addView(a2, new ViewGroup.LayoutParams(width, height));
                a.this.s.setClickCreativeListener((f) null);
                a.this.s.setClickListener((g) null);
                if (o.d().E() == 1) {
                    a.this.e();
                } else if (!(a.this.i == 0 || a.this.g || emptyView == null)) {
                    a.this.s.addView(emptyView);
                }
                if (a.this.h != null) {
                    a.this.h.onAdDismissed();
                }
            }

            private View a(boolean z) {
                PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(a.this.b);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                pAGFrameLayout.setBackgroundColor(-1);
                pAGFrameLayout.setLayoutParams(layoutParams);
                View view = new View(a.this.b);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                view.setAlpha(0.3f);
                view.setBackgroundColor(Color.parseColor("#F3F7F8"));
                pAGFrameLayout.addView(view, layoutParams2);
                PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(a.this.b);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                if (z) {
                    pAGFrameLayout2.setBackground(s.c(a.this.b, "tt_ad_closed_background_300_250"));
                } else {
                    pAGFrameLayout2.setBackground(s.c(a.this.b, "tt_ad_closed_background_320_50"));
                }
                pAGFrameLayout.addView(pAGFrameLayout2, layoutParams3);
                PAGImageView pAGImageView = new PAGImageView(a.this.b);
                pAGImageView.setId(520093739);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                if (z) {
                    int b = ad.b(a.this.b, 16.0f);
                    layoutParams4.width = ad.b(a.this.b, 77.0f);
                    layoutParams4.height = ad.b(a.this.b, 14.0f);
                    layoutParams4.leftMargin = b;
                    layoutParams4.topMargin = b;
                } else {
                    int b2 = ad.b(a.this.b, 8.0f);
                    layoutParams4.width = ad.b(a.this.b, 45.0f);
                    layoutParams4.height = ad.b(a.this.b, 8.18f);
                    layoutParams4.leftMargin = b2;
                    layoutParams4.topMargin = b2;
                }
                pAGImageView.setImageResource(s.d(a.this.b, "tt_ad_closed_logo_red"));
                pAGFrameLayout2.addView(pAGImageView, layoutParams4);
                PAGTextView pAGTextView = new PAGTextView(a.this.b);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 17;
                pAGTextView.setAlpha(0.5f);
                pAGTextView.setLines(1);
                pAGTextView.setText(s.a(a.this.b, "tt_ad_is_closed"));
                if (z) {
                    pAGTextView.setTextSize(18.0f);
                } else {
                    pAGTextView.setTextSize(12.0f);
                }
                pAGFrameLayout2.addView(pAGTextView, layoutParams5);
                AnonymousClass1 r9 = new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(a.this.b, a.this.c, a.this.r);
                    }
                };
                pAGImageView.setOnClickListener(r9);
                pAGTextView.setOnClickListener(r9);
                return pAGFrameLayout;
            }
        };
    }

    public void a(Message message) {
        if (message.what == 112202) {
            if (y.a(this.a, 50, 1)) {
                this.j += 1000;
            }
            if (this.j >= this.i) {
                d();
                AdSlot adSlot = this.d;
                adSlot.setRotateOrder(adSlot.getRotateOrder() + 1);
                this.j = 0;
                e();
                return;
            }
            f();
        }
    }

    private void d() {
        e.a(this.b).a(this.d, 1, (com.bytedance.sdk.openadsdk.common.b) null, new e.a() {
            public void a(List<q> list) {
                if (list == null || list.isEmpty()) {
                    a.this.f();
                    return;
                }
                q qVar = list.get(0);
                a.this.a.a(qVar, a.this.d);
                a.this.c(qVar);
                a.this.a.d();
            }

            public void a() {
                a.this.f();
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    public void c(q qVar) {
        if (this.a.getNextView() != null && this.a.f()) {
            b(this.a.getNextView(), qVar);
            a(this.a.getNextView(), qVar);
        }
    }

    private void b(NativeExpressView nativeExpressView, q qVar) {
        if (nativeExpressView != null && qVar != null) {
            if (this.n != null) {
                this.k.a(qVar.ac(), qVar.ae());
                nativeExpressView.setDislike(this.k);
            }
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.e;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.setMaterialMeta(qVar.ac(), qVar.ae());
                nativeExpressView.setOuterDislike(this.e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacksAndMessages((Object) null);
            this.m.sendEmptyMessageDelayed(112202, 1000);
        }
    }

    public void b() {
        this.c.a(SystemClock.elapsedRealtime());
        this.a.b();
    }
}
