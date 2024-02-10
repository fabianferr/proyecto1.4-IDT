package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.b.a.a;
import com.applovin.impl.mediation.b.a.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;

public class MaxAdPlacer implements b.a {
    private AppLovinSdkUtils.Size a;
    private MaxNativeAdViewBinder b;
    /* access modifiers changed from: private */
    public final a c;
    /* access modifiers changed from: private */
    public final b d;
    private Listener e;
    protected final u logger;
    protected final m sdk;

    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i);

        void onAdRemoved(int i);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.a = AppLovinSdkUtils.Size.ZERO;
        m mVar = appLovinSdk.coreSdk;
        this.sdk = mVar;
        u A = mVar.A();
        this.logger = A;
        this.c = new a(maxAdPlacerSettings);
        this.d = new b(maxAdPlacerSettings.getAdUnitId(), maxAdPlacerSettings.getMaxPreloadedAdCount(), context, this);
        A.b("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
    }

    private void a() {
        int a2;
        while (this.d.b() && (a2 = this.c.a()) != -1) {
            u uVar = this.logger;
            uVar.b("MaxAdPlacer", "Placing ad at position: " + a2);
            this.c.a(this.d.d(), a2);
            Listener listener = this.e;
            if (listener != null) {
                listener.onAdLoaded(a2);
            }
        }
    }

    private void a(Collection<Integer> collection, Runnable runnable) {
        for (Integer intValue : collection) {
            this.d.a(this.c.c(intValue.intValue()));
        }
        runnable.run();
        if (!collection.isEmpty()) {
            u uVar = this.logger;
            uVar.b("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
            if (this.e != null) {
                for (Integer intValue2 : collection) {
                    this.e.onAdRemoved(intValue2.intValue());
                }
            }
        }
    }

    public void clearAds() {
        a(this.c.b(), new Runnable() {
            public void run() {
                MaxAdPlacer.this.logger.b("MaxAdPlacer", "Clearing all cached ads");
                MaxAdPlacer.this.c.c();
                MaxAdPlacer.this.d.e();
            }
        });
    }

    public Collection<Integer> clearTrailingAds(final int i) {
        final Collection<Integer> d2 = this.c.d(i);
        if (!d2.isEmpty()) {
            a(d2, new Runnable() {
                public void run() {
                    u uVar = MaxAdPlacer.this.logger;
                    uVar.b("MaxAdPlacer", "Clearing trailing ads after position " + i);
                    MaxAdPlacer.this.c.a((Collection<Integer>) d2);
                }
            });
        }
        return d2;
    }

    public void destroy() {
        this.logger.b("MaxAdPlacer", "Destroying ad placer");
        clearAds();
        this.d.a();
    }

    public long getAdItemId(int i) {
        if (isFilledPosition(i)) {
            return (long) (-System.identityHashCode(this.c.c(i)));
        }
        return 0;
    }

    public AppLovinSdkUtils.Size getAdSize(int i, int i2) {
        double d2;
        if (isFilledPosition(i)) {
            boolean z = this.a != AppLovinSdkUtils.Size.ZERO;
            int min = Math.min(z ? this.a.getWidth() : 360, i2);
            d dVar = (d) this.c.c(i);
            if ("small_template_1".equalsIgnoreCase(dVar.v())) {
                return new AppLovinSdkUtils.Size(min, z ? this.a.getHeight() : 120);
            } else if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(dVar.v())) {
                if (z) {
                    double width = (double) this.a.getWidth();
                    double height = (double) this.a.getHeight();
                    Double.isNaN(width);
                    Double.isNaN(height);
                    d2 = width / height;
                } else {
                    d2 = 1.2d;
                }
                double d3 = (double) min;
                Double.isNaN(d3);
                return new AppLovinSdkUtils.Size(min, (int) (d3 / d2));
            } else if (z) {
                return this.a;
            } else {
                if (dVar.u() != null) {
                    View mainView = dVar.u().getMainView();
                    return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
                }
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public int getAdjustedCount(int i) {
        return this.c.e(i);
    }

    public int getAdjustedPosition(int i) {
        return this.c.f(i);
    }

    public int getOriginalPosition(int i) {
        return this.c.g(i);
    }

    public void insertItem(int i) {
        u uVar = this.logger;
        uVar.b("MaxAdPlacer", "Inserting item at position: " + i);
        this.c.h(i);
    }

    public boolean isAdPosition(int i) {
        return this.c.a(i);
    }

    public boolean isFilledPosition(int i) {
        return this.c.b(i);
    }

    public void loadAds() {
        this.logger.b("MaxAdPlacer", "Loading ads");
        this.d.c();
    }

    public void moveItem(int i, int i2) {
        this.c.b(i, i2);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.e;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.e;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        u uVar = this.logger;
        uVar.e("MaxAdPlacer", "Native ad failed to load: " + maxError);
    }

    public void onNativeAdLoaded() {
        this.logger.b("MaxAdPlacer", "Native ad enqueued");
        a();
    }

    public void removeItem(final int i) {
        a(isFilledPosition(i) ? Collections.singletonList(Integer.valueOf(i)) : Collections.emptyList(), new Runnable() {
            public void run() {
                u uVar = MaxAdPlacer.this.logger;
                uVar.b("MaxAdPlacer", "Removing item at position: " + i);
                MaxAdPlacer.this.c.i(i);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderAd(int r7, android.view.ViewGroup r8) {
        /*
            r6 = this;
            com.applovin.impl.mediation.b.a.a r0 = r6.c
            com.applovin.mediation.MaxAd r0 = r0.c(r7)
            java.lang.String r1 = "MaxAdPlacer"
            if (r0 != 0) goto L_0x001e
            com.applovin.impl.sdk.u r8 = r6.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "An ad is not available for position: "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.b(r1, r7)
            return
        L_0x001e:
            r2 = r0
            com.applovin.impl.mediation.a.d r2 = (com.applovin.impl.mediation.a.d) r2
            com.applovin.mediation.nativeAds.MaxNativeAdView r2 = r2.u()
            if (r2 == 0) goto L_0x003b
            com.applovin.impl.sdk.u r0 = r6.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Using pre-rendered ad at position: "
            r3.<init>(r4)
        L_0x0030:
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.b(r1, r7)
            goto L_0x006f
        L_0x003b:
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder r2 = r6.b
            java.lang.String r3 = "Unable to render ad at position: "
            if (r2 == 0) goto L_0x0097
            com.applovin.mediation.nativeAds.MaxNativeAdView r2 = new com.applovin.mediation.nativeAds.MaxNativeAdView
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder r4 = r6.b
            android.content.Context r5 = r8.getContext()
            r2.<init>((com.applovin.mediation.nativeAds.MaxNativeAdViewBinder) r4, (android.content.Context) r5)
            com.applovin.impl.mediation.b.a.b r4 = r6.d
            boolean r0 = r4.a(r2, r0)
            if (r0 == 0) goto L_0x005e
            com.applovin.impl.sdk.u r0 = r6.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Rendered ad at position: "
            r3.<init>(r4)
            goto L_0x0030
        L_0x005e:
            com.applovin.impl.sdk.u r0 = r6.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r0.e(r1, r7)
        L_0x006f:
            int r7 = r8.getChildCount()
        L_0x0073:
            if (r7 < 0) goto L_0x0083
            android.view.View r0 = r8.getChildAt(r7)
            boolean r0 = r0 instanceof com.applovin.mediation.nativeAds.MaxNativeAdView
            if (r0 == 0) goto L_0x0080
            r8.removeViewAt(r7)
        L_0x0080:
            int r7 = r7 + -1
            goto L_0x0073
        L_0x0083:
            android.view.ViewParent r7 = r2.getParent()
            if (r7 == 0) goto L_0x0092
            android.view.ViewParent r7 = r2.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r2)
        L_0x0092:
            r7 = -1
            r8.addView(r2, r7, r7)
            return
        L_0x0097:
            com.applovin.impl.sdk.u r8 = r6.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            r0.append(r7)
            java.lang.String r7 = ". If you're using a custom ad template, check that nativeAdViewBinder is set."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.e(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.renderAd(int, android.view.ViewGroup):void");
    }

    public void setAdSize(int i, int i2) {
        this.a = new AppLovinSdkUtils.Size(i, i2);
    }

    public void setListener(Listener listener) {
        this.e = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.b = maxNativeAdViewBinder;
    }

    public void updateFillablePositions(int i, int i2) {
        this.c.a(i, i2);
        if (i != -1 && i2 != -1) {
            a();
        }
    }
}
