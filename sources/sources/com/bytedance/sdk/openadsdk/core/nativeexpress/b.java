package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.b.o;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.google.android.material.badge.BadgeDrawable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BrandBannerController */
public class b {
    q a;
    private final Context b;
    /* access modifiers changed from: private */
    public a c;
    /* access modifiers changed from: private */
    public o d;
    /* access modifiers changed from: private */
    public NativeExpressView e;
    private int f;
    private int g;
    private ScheduledFuture<?> h;

    /* compiled from: BrandBannerController */
    interface c {
        void a();

        void a(int i, int i2);

        void a(String str);

        void b(String str);
    }

    public b(Context context, NativeExpressView nativeExpressView, q qVar, String str) {
        this.a = qVar;
        this.b = context;
        this.e = nativeExpressView;
        a(nativeExpressView);
        this.c = new a(context, qVar, this.f, this.g, str);
    }

    private void a(NativeExpressView nativeExpressView) {
        q qVar = this.a;
        if (qVar == null || !qVar.bd()) {
            m a2 = BannerExpressBackupView.a(nativeExpressView.getExpectExpressWidth(), nativeExpressView.getExpectExpressHeight());
            if (nativeExpressView.getExpectExpressWidth() <= 0 || nativeExpressView.getExpectExpressHeight() <= 0) {
                int c2 = ad.c(this.b);
                this.f = c2;
                this.g = Float.valueOf(((float) c2) / a2.b).intValue();
            } else {
                this.f = ad.b(this.b, (float) nativeExpressView.getExpectExpressWidth());
                this.g = ad.b(this.b, (float) nativeExpressView.getExpectExpressHeight());
            }
            int i = this.f;
            if (i > 0 && i > ad.c(this.b)) {
                float c3 = ((float) ad.c(this.b)) / ((float) this.f);
                this.f = ad.c(this.b);
                this.g = Float.valueOf(((float) this.g) * c3).intValue();
                return;
            }
            return;
        }
        this.f = -1;
        this.g = -1;
    }

    public void a(o oVar) {
        this.d = oVar;
    }

    public void a() {
        q qVar = this.a;
        if (qVar != null && qVar.bd()) {
            this.h = aa.a().schedule(new C0068b(this.c.m), (long) com.bytedance.sdk.openadsdk.core.o.d().B(), TimeUnit.MILLISECONDS);
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a((g) new g() {
                public void a(View view, n nVar) {
                    if (b.this.e != null && view != null) {
                        b.this.e.removeView(view);
                        if (view.getParent() != null) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        b.this.e.addView(view, new ViewGroup.LayoutParams(-1, -1));
                        if (b.this.d != null) {
                            b.this.d.a(b.this.c, nVar);
                        }
                    } else if (b.this.d != null) {
                        b.this.d.a_(106);
                    }
                    b.this.c();
                }

                public void a(int i) {
                    if (b.this.d != null) {
                        b.this.d.a_(106);
                    }
                    b.this.c();
                }
            });
            return;
        }
        o oVar = this.d;
        if (oVar != null) {
            oVar.a_(106);
        }
    }

    public void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d();
            this.c = null;
        }
        c();
        this.d = null;
        this.e = null;
    }

    public void a(t tVar) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(tVar);
        }
    }

    public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(tTDislikeDialogAbstract);
        }
    }

    public void a(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(pAGBannerAdWrapperListener);
        }
    }

    /* compiled from: BrandBannerController */
    public static class a implements d<View>, DspHtmlWebView.b {
        AtomicBoolean a = new AtomicBoolean(false);
        WeakReference<View> b;
        private com.bytedance.sdk.openadsdk.dislike.b c;
        private TTDislikeDialogAbstract d;
        private String e;
        /* access modifiers changed from: private */
        public final Context f;
        private final int g;
        private final int h;
        private FrameLayout i;
        /* access modifiers changed from: private */
        public q j;
        private final int k;
        /* access modifiers changed from: private */
        public String l;
        /* access modifiers changed from: private */
        public DspHtmlWebView m;
        private g n;
        private PAGBannerAdWrapperListener o;

        public int c() {
            return 5;
        }

        public a(Context context, q qVar, int i2, int i3, String str) {
            this.l = str;
            if (qVar != null && qVar.bd()) {
                this.l = "fullscreen_interstitial_ad";
            }
            this.f = context;
            this.g = i2;
            this.h = i3;
            this.j = qVar;
            this.k = ad.b(context, 3.0f);
            g();
        }

        private void g() {
            FrameLayout frameLayout = new FrameLayout(this.f);
            this.i = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
            }
            layoutParams.width = this.g;
            layoutParams.height = this.h;
            layoutParams.gravity = 17;
            this.i.setLayoutParams(layoutParams);
            DspHtmlWebView j2 = j();
            this.i.addView(j2);
            View h2 = h();
            this.i.addView(h2);
            q qVar = this.j;
            if (qVar == null || !qVar.bd()) {
                ImageView i2 = i();
                this.i.addView(i2);
                this.b = new WeakReference<>(i2);
                j2.a((View) i2, FriendlyObstructionPurpose.CLOSE_AD);
            } else {
                j2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.b = new WeakReference<>(((Activity) this.f).findViewById(520093713));
                j2.a(((Activity) this.f).findViewById(i.bs), FriendlyObstructionPurpose.OTHER);
            }
            j2.a(h2, FriendlyObstructionPurpose.OTHER);
        }

        public void a(g gVar) {
            q qVar;
            if (!this.a.get()) {
                if (this.f == null || (qVar = this.j) == null) {
                    gVar.a(106);
                    return;
                }
                this.n = gVar;
                if (TextUtils.isEmpty(qVar.aw())) {
                    gVar.a(106);
                } else {
                    this.m.p();
                }
            }
        }

        private View h() {
            TTBackUpAdImageView tTBackUpAdImageView = new TTBackUpAdImageView(this.f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            q qVar = this.j;
            if (qVar == null || !qVar.bd()) {
                layoutParams.topMargin = this.k;
                layoutParams.leftMargin = this.k;
            } else {
                layoutParams.leftMargin = ad.b(this.f, 20.0f);
                layoutParams.bottomMargin = ad.b(this.f, 20.0f);
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            }
            tTBackUpAdImageView.setLayoutParams(layoutParams);
            tTBackUpAdImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(a.this.f, a.this.j, a.this.l);
                }
            });
            return tTBackUpAdImageView;
        }

        private ImageView i() {
            PAGImageView pAGImageView = new PAGImageView(this.f);
            pAGImageView.setImageDrawable(ResourcesCompat.getDrawable(this.f.getResources(), s.d(this.f, "tt_dislike_icon2"), (Resources.Theme) null));
            int b2 = ad.b(this.f, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.gravity = GravityCompat.END;
            layoutParams.rightMargin = this.k;
            layoutParams.topMargin = this.k;
            pAGImageView.setLayoutParams(layoutParams);
            pAGImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f();
                }
            });
            return pAGImageView;
        }

        private DspHtmlWebView j() {
            DspHtmlWebView b2 = c.a().b();
            this.m = b2;
            if (b2 == null) {
                this.m = new DspHtmlWebView(this.f);
            }
            c.a().c(this.m);
            this.m.a(this.j, this, this.l);
            this.m.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.m;
        }

        public View e() {
            return this.i;
        }

        public void d() {
            this.i = null;
            this.c = null;
            this.d = null;
            this.n = null;
            this.j = null;
            DspHtmlWebView dspHtmlWebView = this.m;
            if (dspHtmlWebView != null) {
                dspHtmlWebView.l();
                c.a().a(this.m);
            }
            this.a.set(true);
        }

        public void a(t tVar) {
            if (tVar instanceof com.bytedance.sdk.openadsdk.dislike.b) {
                this.c = (com.bytedance.sdk.openadsdk.dislike.b) tVar;
            }
        }

        public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            q qVar;
            if (!(tTDislikeDialogAbstract == null || (qVar = this.j) == null)) {
                tTDislikeDialogAbstract.setMaterialMeta(qVar.ac(), this.j.ae());
            }
            this.d = tTDislikeDialogAbstract;
        }

        public void f() {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.d;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            } else {
                TTDelegateActivity.a(this.j, this.e);
            }
        }

        public void a(String str) {
            this.e = str;
        }

        public View a() {
            WeakReference<View> weakReference = this.b;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public View b() {
            FrameLayout frameLayout = this.i;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        public void a(View view, int i2) {
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.o;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onAdClicked(this.m, 2);
            }
        }

        public void b_() {
            if (this.n != null) {
                n nVar = new n();
                nVar.a(true);
                nVar.a((double) ad.c(this.f, (float) this.g));
                nVar.b((double) ad.c(this.f, (float) this.h));
                this.n.a(this.i, nVar);
            }
        }

        public void a(int i2, int i3) {
            g gVar = this.n;
            if (gVar != null) {
                gVar.a(i2);
            }
        }

        public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
            this.o = pAGBannerAdWrapperListener;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b$b  reason: collision with other inner class name */
    /* compiled from: BrandBannerController */
    private static class C0068b implements Runnable {
        c a;

        public C0068b(c cVar) {
            this.a = cVar;
        }

        public void run() {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(107, 107);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            ScheduledFuture<?> scheduledFuture = this.h;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.h.cancel(false);
                this.h = null;
            }
        } catch (Throwable unused) {
        }
    }
}
