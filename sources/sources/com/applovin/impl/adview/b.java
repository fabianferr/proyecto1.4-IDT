package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.k;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class b implements AppLovinCommunicatorSubscriber {
    private volatile AppLovinAdClickListener A;
    private volatile g B = null;
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public ViewGroup b;
    /* access modifiers changed from: private */
    public m c;
    /* access modifiers changed from: private */
    public AppLovinAdServiceImpl d;
    /* access modifiers changed from: private */
    public u e;
    private AppLovinCommunicator f;
    /* access modifiers changed from: private */
    public AppLovinAdSize g;
    private String h;
    /* access modifiers changed from: private */
    public d i;
    private e j;
    private c k;
    /* access modifiers changed from: private */
    public d l;
    private Runnable m;
    private Runnable n;
    /* access modifiers changed from: private */
    public volatile e o = null;
    private volatile AppLovinAd p = null;
    /* access modifiers changed from: private */
    public l q = null;
    /* access modifiers changed from: private */
    public l r = null;
    private final AtomicReference<AppLovinAd> s = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AtomicBoolean t = new AtomicBoolean();
    private volatile boolean u = false;
    /* access modifiers changed from: private */
    public volatile boolean v = false;
    /* access modifiers changed from: private */
    public volatile boolean w = false;
    /* access modifiers changed from: private */
    public volatile AppLovinAdLoadListener x;
    private volatile AppLovinAdDisplayListener y;
    /* access modifiers changed from: private */
    public volatile AppLovinAdViewEventListener z;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            if (b.this.l != null) {
                b.this.l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.b$b  reason: collision with other inner class name */
    private class C0009b implements Runnable {
        private C0009b() {
        }

        public void run() {
            if (b.this.o == null) {
                return;
            }
            if (b.this.l != null) {
                b.this.x();
                if (u.a()) {
                    u c = b.this.e;
                    c.b("AppLovinAdView", "Rendering advertisement ad for #" + b.this.o.getAdIdNumber() + "...");
                }
                b.b((View) b.this.l, b.this.o.getSize());
                b.this.l.a(b.this.o);
                if (b.this.o.getSize() != AppLovinAdSize.INTERSTITIAL && !b.this.v) {
                    b bVar = b.this;
                    d unused = bVar.i = new d(bVar.o, b.this.c);
                    b.this.i.a();
                    b.this.l.setStatsManagerHelper(b.this.i);
                    b.this.o.setHasShown(true);
                }
                if (b.this.l.getStatsManagerHelper() != null) {
                    b.this.l.getStatsManagerHelper().a(b.this.o.A() ? 0 : 1);
                    return;
                }
                return;
            }
            if (u.a()) {
                u.i("AppLovinAdView", "Unable to render advertisement for ad #" + b.this.o.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            }
            j.a(b.this.z, (AppLovinAd) b.this.o, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
        }
    }

    static class c implements AppLovinAdLoadListener {
        private final b a;

        c(b bVar, m mVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (mVar != null) {
                this.a = bVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        private b a() {
            return this.a;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            b a2 = a();
            if (a2 != null) {
                a2.b(appLovinAd);
            } else if (u.a()) {
                u.i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            b a2 = a();
            if (a2 != null) {
                a2.a(i);
            }
        }
    }

    private void a(AppLovinAdView appLovinAdView, m mVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.c = mVar;
            this.d = mVar.u();
            this.e = mVar.A();
            this.f = AppLovinCommunicator.getInstance(context);
            this.g = appLovinAdSize;
            this.h = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.a = context;
            this.b = appLovinAdView;
            this.j = new e(this, mVar);
            this.n = new a();
            this.m = new C0009b();
            this.k = new c(this, mVar);
            a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i2 = -1;
            int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                i2 = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = i2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private void t() {
        u uVar;
        if (u.a() && (uVar = this.e) != null) {
            uVar.b("AppLovinAdView", "Destroying...");
        }
        d dVar = this.l;
        if (dVar != null) {
            ViewParent parent = dVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.l);
            }
            this.l.removeAllViews();
            this.l.loadUrl("about:blank");
            this.l.onPause();
            this.l.destroyDrawingCache();
            this.l.destroy();
            this.l = null;
        }
        this.x = null;
        this.y = null;
        this.A = null;
        this.z = null;
        this.v = true;
    }

    private void u() {
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.q != null) {
                    if (u.a()) {
                        u c = b.this.e;
                        c.b("AppLovinAdView", "Detaching expanded ad: " + b.this.q.a());
                    }
                    b bVar = b.this;
                    l unused = bVar.r = bVar.q;
                    l unused2 = b.this.q = null;
                    b bVar2 = b.this;
                    bVar2.a(bVar2.g);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void v() {
        a((Runnable) new Runnable() {
            public void run() {
                com.applovin.impl.sdk.ad.a aVar;
                if (b.this.r != null || b.this.q != null) {
                    if (b.this.r != null) {
                        aVar = b.this.r.a();
                        b.this.r.dismiss();
                        l unused = b.this.r = null;
                    } else {
                        aVar = b.this.q.a();
                        b.this.q.dismiss();
                        l unused2 = b.this.q = null;
                    }
                    j.b(b.this.z, (AppLovinAd) aVar, (AppLovinAdView) b.this.b);
                }
            }
        });
    }

    private void w() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.c();
            this.i = null;
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        if (u.a()) {
            e eVar = this.o;
            k kVar = new k();
            kVar.a().a(eVar).a(r());
            if (!Utils.isBML(eVar.getSize())) {
                kVar.a().a("Fullscreen Ad Properties").b(eVar);
            }
            kVar.a(this.c);
            kVar.a();
            this.e.b("AppLovinAdView", kVar.toString());
        }
    }

    public void a() {
        if (this.c != null && this.k != null && this.a != null && this.u) {
            this.d.loadNextAd(this.h, this.g, this.k);
        } else if (u.a()) {
            u.g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final int i2) {
        if (!this.v) {
            a(this.n);
        }
        a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (b.this.x != null) {
                        b.this.x.failedToReceiveAd(i2);
                    }
                } catch (Throwable th) {
                    if (u.a()) {
                        u.c("AppLovinAdView", "Exception while running app load  callback", th);
                    }
                }
            }
        });
    }

    public void a(final PointF pointF) {
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.q == null && (b.this.o instanceof com.applovin.impl.sdk.ad.a) && b.this.l != null) {
                    com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) b.this.o;
                    Activity retrieveParentActivity = b.this.a instanceof Activity ? (Activity) b.this.a : Utils.retrieveParentActivity(b.this.l, b.this.c);
                    if (retrieveParentActivity != null) {
                        if (b.this.b != null) {
                            b.this.b.removeView(b.this.l);
                        }
                        l unused = b.this.q = new l(aVar, b.this.l, retrieveParentActivity, b.this.c);
                        b.this.q.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                b.this.k();
                            }
                        });
                        b.this.q.show();
                        j.a(b.this.z, (AppLovinAd) b.this.o, (AppLovinAdView) b.this.b);
                        if (b.this.i != null) {
                            b.this.i.d();
                        }
                        if (b.this.o.isOpenMeasurementEnabled()) {
                            b.this.o.o().a((View) b.this.q.b());
                            return;
                        }
                        return;
                    }
                    if (u.a()) {
                        u.i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    }
                    Uri j = aVar.j();
                    if (j != null) {
                        AppLovinAdServiceImpl l = b.this.d;
                        AppLovinAdView r = b.this.r();
                        b bVar = b.this;
                        l.trackAndLaunchClick(aVar, r, bVar, j, pointF, bVar.w);
                        if (b.this.i != null) {
                            b.this.i.b();
                        }
                    }
                    b.this.l.a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    public void a(final WebView webView) {
        a((Runnable) new Runnable() {
            public void run() {
                webView.setVisibility(0);
            }
        });
        try {
            if (this.o != this.p) {
                this.p = this.o;
                if (this.y != null) {
                    j.a(this.y, (AppLovinAd) this.o);
                    this.l.a("javascript:al_onAdViewRendered();");
                }
                if ((this.o instanceof com.applovin.impl.sdk.ad.a) && this.o.isOpenMeasurementEnabled()) {
                    this.c.S().a((com.applovin.impl.sdk.f.a) new z(this.c, new Runnable() {
                        public void run() {
                            b.this.o.o().b(webView);
                            b.this.o.o().a((View) webView);
                            b.this.o.o().c();
                            b.this.o.o().d();
                        }
                    }), o.a.MAIN, 500);
                }
            }
        } catch (Throwable th) {
            if (u.a()) {
                u.c("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context != null) {
            if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.sdk.utils.b.a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null) {
                a(appLovinAdView, appLovinSdk.coreSdk, appLovinAdSize2, str, context);
                if (com.applovin.impl.sdk.utils.b.b(attributeSet)) {
                    a();
                }
            }
        } else if (u.a()) {
            u.i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        }
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.z = appLovinAdViewEventListener;
    }

    public void a(g gVar) {
        this.B = gVar;
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        if (appLovinAdView != null) {
            this.d.trackAndLaunchClick(eVar, appLovinAdView, this, uri, pointF, this.w);
        } else if (u.a()) {
            this.e.e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
        j.a(this.A, (AppLovinAd) eVar);
    }

    public void a(d dVar) {
        d dVar2 = this.l;
        if (dVar2 != null) {
            dVar2.setStatsManagerHelper(dVar);
        }
    }

    public void a(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            Utils.validateAdSdkKey(appLovinAd, this.c);
            if (this.u) {
                e eVar = (e) Utils.maybeRetrieveNonDummyAd(appLovinAd, this.c);
                if (eVar != null && eVar != this.o) {
                    if (u.a()) {
                        u uVar = this.e;
                        uVar.b("AppLovinAdView", "Rendering ad #" + eVar.getAdIdNumber() + " (" + eVar.getSize() + ")");
                    }
                    j.b(this.y, (AppLovinAd) this.o);
                    if (eVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        w();
                    }
                    if (this.o != null && this.o.isOpenMeasurementEnabled()) {
                        this.o.o().e();
                    }
                    this.s.set((Object) null);
                    this.p = null;
                    this.o = eVar;
                    if (!this.v && Utils.isBML(this.g)) {
                        this.c.u().trackImpression(eVar);
                    }
                    if (this.q != null) {
                        u();
                    }
                    a(this.m);
                } else if (eVar != null) {
                    if (u.a()) {
                        u uVar2 = this.e;
                        uVar2.d("AppLovinAdView", "Ad #" + eVar.getAdIdNumber() + " is already showing, ignoring");
                    }
                    if (((Boolean) this.c.a(com.applovin.impl.sdk.d.b.ca)).booleanValue()) {
                        throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                    }
                } else if (u.a()) {
                    this.e.d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                }
            } else if (u.a()) {
                u.g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.A = appLovinAdClickListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.y = appLovinAdDisplayListener;
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.x = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public void a(AppLovinAdSize appLovinAdSize) {
        try {
            d dVar = new d(this.j, this.c, this.a);
            this.l = dVar;
            dVar.setBackgroundColor(0);
            this.l.setWillNotCacheDrawing(false);
            this.b.setBackgroundColor(0);
            this.b.addView(this.l);
            b((View) this.l, appLovinAdSize);
            if (!this.u) {
                a(this.n);
            }
            a((Runnable) new Runnable() {
                public void run() {
                    b.this.l.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
                }
            });
            this.u = true;
        } catch (Throwable th) {
            if (u.a()) {
                u.c("AppLovinAdView", "Failed to initialize AdWebView", th);
            }
            this.t.set(true);
        }
    }

    public AppLovinAdSize b() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public void b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.v) {
                a(appLovinAd);
            } else {
                this.s.set(appLovinAd);
                if (u.a()) {
                    this.e.b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.t.compareAndSet(true, false)) {
                        b bVar = b.this;
                        bVar.a(bVar.g);
                    }
                    try {
                        if (b.this.x != null) {
                            b.this.x.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        if (u.a()) {
                            u.i("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
                        }
                    }
                }
            });
            return;
        }
        if (u.a()) {
            this.e.e("AppLovinAdView", "No provided when to the view controller");
        }
        a(-1);
    }

    public String c() {
        return this.h;
    }

    public void d() {
        if (this.u && !this.v) {
            this.v = true;
        }
    }

    public void e() {
        if (this.u) {
            AppLovinAd andSet = this.s.getAndSet((Object) null);
            if (andSet != null) {
                a(andSet);
            }
            this.v = false;
        }
    }

    public void f() {
        if (!(this.l == null || this.q == null)) {
            k();
        }
        t();
    }

    public AppLovinAdViewEventListener g() {
        return this.z;
    }

    public String getCommunicatorId() {
        return "b";
    }

    public g h() {
        return this.B;
    }

    public void i() {
        if (com.applovin.impl.sdk.utils.b.a((View) this.l)) {
            this.c.T().a(f.o);
        }
    }

    public void j() {
        if (this.u) {
            j.b(this.y, (AppLovinAd) this.o);
            if (this.o != null && this.o.isOpenMeasurementEnabled() && Utils.isBML(this.o.getSize())) {
                this.o.o().e();
            }
            if (this.l != null && this.q != null) {
                if (u.a()) {
                    this.e.b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                u();
            } else if (u.a()) {
                this.e.b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
            }
        }
    }

    public void k() {
        a((Runnable) new Runnable() {
            public void run() {
                b.this.v();
                if (b.this.b != null && b.this.l != null && b.this.l.getParent() == null) {
                    b.this.b.addView(b.this.l);
                    b.b((View) b.this.l, b.this.o.getSize());
                    if (b.this.o.isOpenMeasurementEnabled()) {
                        b.this.o.o().a((View) b.this.l);
                    }
                }
            }
        });
    }

    public void l() {
        if (this.q == null && this.r == null) {
            if (u.a()) {
                u uVar = this.e;
                uVar.b("AppLovinAdView", "Ad: " + this.o + " closed.");
            }
            a(this.n);
            j.b(this.y, (AppLovinAd) this.o);
            this.o = null;
            return;
        }
        k();
    }

    public void m() {
        this.w = true;
    }

    public void n() {
        this.w = false;
    }

    public void o() {
        if ((this.a instanceof k) && this.o != null) {
            if (this.o.G() == e.a.DISMISS) {
                ((k) this.a).dismiss();
            }
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a((Runnable) new Runnable() {
                public void run() {
                    b.this.s().loadUrl("chrome://crash");
                }
            });
        }
    }

    public e p() {
        return this.o;
    }

    public m q() {
        return this.c;
    }

    public AppLovinAdView r() {
        return (AppLovinAdView) this.b;
    }

    public d s() {
        return this.l;
    }
}
