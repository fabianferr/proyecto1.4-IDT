package com.bytedance.sdk.openadsdk.apiImpl.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.b;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.c;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: PAGExtraFuncationHelper */
public class a {
    protected final q a;
    private final Context b;
    private final String c;
    private boolean d;
    private WeakReference<NativeVideoTsView> e;
    private b f;
    private b g;
    private PAGMediaView h;
    private NativeExpressView i;
    private PAGMediaView j;
    private com.bytedance.sdk.openadsdk.core.b.a k;
    private com.bytedance.sdk.openadsdk.core.b.b l;
    private boolean m = false;
    private WeakReference<f> n;

    public a(Context context, q qVar, String str) {
        this.b = context;
        this.a = qVar;
        this.c = str;
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public void a(NativeVideoTsView nativeVideoTsView) {
        this.e = new WeakReference<>(nativeVideoTsView);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public PAGMediaView a() {
        return this.h;
    }

    public NativeExpressView b() {
        return this.i;
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.a aVar) {
        this.k = aVar;
    }

    public PAGImageItem c() {
        q qVar = this.a;
        if (qVar == null || qVar.N() == null) {
            return null;
        }
        return new PAGImageItem(this.a.N().c(), this.a.N().b(), this.a.N().a(), (float) this.a.N().d());
    }

    public String d() {
        q qVar = this.a;
        if (qVar != null) {
            return qVar.V();
        }
        return null;
    }

    public String e() {
        q qVar = this.a;
        if (qVar != null) {
            return qVar.W();
        }
        return null;
    }

    public String f() {
        q qVar = this.a;
        if (qVar != null) {
            return qVar.X();
        }
        return null;
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.b bVar) {
        this.l = bVar;
    }

    public PAGMediaView g() {
        PAGMediaView pAGMediaView;
        com.bytedance.sdk.openadsdk.utils.b.a(this.a);
        if (this.a.u() == 2) {
            pAGMediaView = o();
            a(pAGMediaView);
        } else {
            pAGMediaView = i();
        }
        if (pAGMediaView != null) {
            pAGMediaView.setMrcTrackerKey(e.b(this.a));
        } else {
            pAGMediaView = new PAGMediaView(this.b) {
                /* access modifiers changed from: protected */
                public void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    c.a((ViewGroup) this, a.this.a);
                }
            };
        }
        if (pAGMediaView instanceof PAGVideoMediaView) {
            ((PAGVideoMediaView) pAGMediaView).setMaterialMeta(this.a);
        }
        this.j = pAGMediaView;
        return pAGMediaView;
    }

    public PAGMediaView h() {
        return this.j;
    }

    private String n() {
        n nVar;
        List<n> Q = this.a.Q();
        if (!Q.isEmpty() && (nVar = Q.get(0)) != null) {
            return nVar.a();
        }
        return null;
    }

    private void a(final PAGMediaView pAGMediaView) {
        if (pAGMediaView != null) {
            try {
                String n2 = n();
                if (!TextUtils.isEmpty(n2)) {
                    d.a(n2).a(200).b(200).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a((h) new h() {
                        public Bitmap a(Bitmap bitmap) {
                            return com.bytedance.sdk.component.adexpress.c.a.a(o.a(), bitmap, 25);
                        }
                    }).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.openadsdk.f.b(this.a, n2, new com.bytedance.sdk.component.d.o<Bitmap>() {
                        public void a(int i, String str, Throwable th) {
                        }

                        public void a(k<Bitmap> kVar) {
                            pAGMediaView.setBackground(new BitmapDrawable(kVar.b()));
                        }
                    }));
                }
            } catch (Exception unused) {
            }
        }
    }

    private PAGMediaView o() {
        if (q.c(this.a)) {
            b bVar = this.g;
            if (bVar == null || !(bVar instanceof com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.a)) {
                return null;
            }
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) bVar.d();
            nativeExpressVideoView.setTag(520093762, true);
            if (!this.m) {
                this.g.e();
            }
            this.m = true;
            return a((View) nativeExpressVideoView);
        }
        b bVar2 = this.g;
        if (bVar2 == null) {
            return null;
        }
        NativeExpressView d2 = bVar2.d();
        d2.setTag(520093762, true);
        if (!this.m) {
            this.g.e();
        }
        this.m = true;
        return a((View) d2);
    }

    public PAGMediaView i() {
        if (q.c(this.a)) {
            b bVar = this.f;
            if (bVar != null) {
                View f2 = bVar.f();
                if (f2 != null) {
                    if (f2.getParent() instanceof ViewGroup) {
                        ((ViewGroup) f2.getParent()).removeView(f2);
                    }
                    PAGMediaView pAGMediaView = this.h;
                    if (pAGMediaView != null) {
                        pAGMediaView.setOnClickListener((View.OnClickListener) null);
                        this.h.setOnTouchListener((View.OnTouchListener) null);
                    }
                    PAGVideoMediaView pAGVideoMediaView = new PAGVideoMediaView(this.b, f2, this);
                    pAGVideoMediaView.setTag(520093762, true);
                    if (this.k == null || !com.bytedance.sdk.openadsdk.core.settings.o.ai().d(String.valueOf(this.a.aZ()))) {
                        AnonymousClass4 r0 = new com.bytedance.sdk.openadsdk.core.b.c() {
                            /* access modifiers changed from: protected */
                            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                                try {
                                    ((PAGVideoMediaView) view).handleInterruptVideo();
                                } catch (Exception unused) {
                                }
                            }
                        };
                        pAGVideoMediaView.setOnClickListener(r0);
                        pAGVideoMediaView.setOnTouchListener(r0);
                    } else {
                        pAGVideoMediaView.setOnClickListener(this.k);
                        pAGVideoMediaView.setOnTouchListener(this.k);
                    }
                    this.h = pAGVideoMediaView;
                    pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    return pAGVideoMediaView;
                }
                ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
                return null;
            }
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
            return null;
        }
        List<n> Q = this.a.Q();
        if (Q == null || Q.isEmpty()) {
            ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
            return null;
        }
        ImageView imageView = new ImageView(this.b);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        n nVar = Q.get(0);
        if (nVar != null) {
            d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.f.c.a(this.a, nVar.a(), imageView));
        }
        PAGMediaView a2 = a((View) imageView);
        if (this.k == null || !com.bytedance.sdk.openadsdk.core.settings.o.ai().d(String.valueOf(this.a.aZ()))) {
            a2.setOnClickListener((View.OnClickListener) null);
            a2.setOnTouchListener((View.OnTouchListener) null);
        } else {
            a2.setOnClickListener(this.k);
            a2.setOnTouchListener(this.k);
        }
        a2.setTag(520093762, true);
        PAGMediaView pAGMediaView2 = this.h;
        if (pAGMediaView2 != null) {
            pAGMediaView2.setOnClickListener((View.OnClickListener) null);
            this.h.setOnTouchListener((View.OnTouchListener) null);
        }
        this.h = a2;
        return a2;
    }

    private PAGMediaView a(final View view) {
        int i2;
        if (view == null) {
            return null;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        NativeExpressView nativeExpressView = this.i;
        if (nativeExpressView != null) {
            nativeExpressView.setClickListener((g) null);
            this.i.setClickCreativeListener((com.bytedance.sdk.openadsdk.core.nativeexpress.f) null);
        }
        com.bytedance.sdk.openadsdk.core.b.b bVar = this.l;
        if (bVar != null && (bVar instanceof g) && (view instanceof NativeExpressView)) {
            ((NativeExpressView) view).setClickListener((g) bVar);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.k;
        if (aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.f) && (view instanceof NativeExpressView)) {
            ((NativeExpressView) view).setClickCreativeListener((com.bytedance.sdk.openadsdk.core.nativeexpress.f) aVar);
        }
        AnonymousClass5 r0 = new PAGMediaView(this.b) {
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (!(view instanceof NativeExpressView)) {
                    a(z);
                }
            }

            private void a(boolean z) {
                if (this.a != null) {
                    e.a(e.a(this.a), z ? 4 : 8);
                }
            }

            public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
                super.setVideoAdListener(pAGVideoAdListener);
                a.this.a(pAGVideoAdListener);
            }

            /* access modifiers changed from: protected */
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                com.bytedance.sdk.openadsdk.utils.c.a((ViewGroup) this, a.this.a);
            }
        };
        int i3 = -1;
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i3 = layoutParams.width;
            i2 = layoutParams.height;
        } else {
            i2 = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i2);
        layoutParams2.gravity = 17;
        r0.addView(view, layoutParams2);
        if (view instanceof NativeExpressView) {
            this.i = (NativeExpressView) view;
        }
        return r0;
    }

    public View j() {
        if (o.a() == null) {
            l.e("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(o.a());
        imageView.setImageResource(s.d(o.a(), "tt_ad_logo_new"));
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.l();
            }
        });
        return imageView;
    }

    public View k() {
        q qVar;
        if (o.a() == null || (qVar = this.a) == null) {
            l.e("TTNativeAdImpl", "getAdChoicesView mContext == null");
            return null;
        } else if (!qVar.at() || !this.a.h()) {
            return null;
        } else {
            ImageView imageView = new ImageView(o.a());
            com.bytedance.sdk.openadsdk.k.c.a().a((int) ad.a(o.a(), 14.0f, true), imageView, this.a);
            return imageView;
        }
    }

    public void l() {
        Context context = this.b;
        if (context != null) {
            TTWebsiteActivity.a(context, this.a, this.c);
        }
    }

    public void a(PAGVideoAdListener pAGVideoAdListener) {
        b bVar;
        if (this.a.u() != 2 || !q.c(this.a) || (bVar = this.g) == null || !(bVar instanceof com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.a)) {
            b bVar2 = this.f;
            if (bVar2 != null) {
                bVar2.a(b(pAGVideoAdListener));
                return;
            }
            return;
        }
        NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) bVar.d();
        if (nativeExpressVideoView != null) {
            nativeExpressVideoView.setVideoAdListener(b(pAGVideoAdListener));
        }
    }

    private c b(final PAGVideoAdListener pAGVideoAdListener) {
        return new c() {
            public void a(long j, long j2) {
            }

            public void a(PAGNativeAd pAGNativeAd) {
            }

            public void d(PAGNativeAd pAGNativeAd) {
            }

            public void a(int i, int i2) {
                PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                if (pAGVideoAdListener != null) {
                    pAGVideoAdListener.onVideoError();
                }
            }

            public void b(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                if (pAGVideoAdListener != null) {
                    pAGVideoAdListener.onVideoAdPlay();
                }
            }

            public void c(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                if (pAGVideoAdListener != null) {
                    pAGVideoAdListener.onVideoAdPaused();
                }
            }

            public void e(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                if (pAGVideoAdListener != null) {
                    pAGVideoAdListener.onVideoAdComplete();
                }
            }
        };
    }

    public void m() {
        f fVar;
        WeakReference<f> weakReference = this.n;
        if (weakReference != null && (fVar = (f) weakReference.get()) != null) {
            fVar.a(13);
        }
    }

    public void a(f fVar) {
        this.n = new WeakReference<>(fVar);
    }
}
