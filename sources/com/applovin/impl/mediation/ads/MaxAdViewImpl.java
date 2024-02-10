package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.y;
import com.applovin.impl.sdk.z;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MaxAdViewImpl extends a implements d.a, e.a, z.a {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public final MaxAdView b;
    /* access modifiers changed from: private */
    public final String c = UUID.randomUUID().toString().toLowerCase(Locale.US);
    /* access modifiers changed from: private */
    public final View d;
    /* access modifiers changed from: private */
    public long e = Long.MAX_VALUE;
    private com.applovin.impl.mediation.a.b f;
    /* access modifiers changed from: private */
    public String g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public final a i;
    /* access modifiers changed from: private */
    public final c j;
    /* access modifiers changed from: private */
    public final d k;
    /* access modifiers changed from: private */
    public final y l;
    /* access modifiers changed from: private */
    public final z m;
    /* access modifiers changed from: private */
    public final Object n = new Object();
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.a.b o = null;
    private boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    private boolean r;
    private boolean s;
    /* access modifiers changed from: private */
    public boolean t = false;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private boolean y;
    private boolean z;

    private class a extends b {
        private a() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            if (u.a()) {
                u uVar = MaxAdViewImpl.this.logger;
                String str2 = MaxAdViewImpl.this.tag;
                uVar.b(str2, "Calling ad load failed callback for publisher: " + MaxAdViewImpl.this.adListener);
            }
            j.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.t) {
                if (u.a()) {
                    u uVar = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    uVar.b(str, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.E().destroyAd(maxAd);
                return;
            }
            com.applovin.impl.mediation.a.b bVar = (com.applovin.impl.mediation.a.b) maxAd;
            bVar.e(MaxAdViewImpl.this.g);
            bVar.f(MaxAdViewImpl.this.h);
            if (bVar.w() != null) {
                MaxAdViewImpl.this.a(bVar);
                if (bVar.y()) {
                    long z = bVar.z();
                    if (u.a()) {
                        u A = MaxAdViewImpl.this.sdk.A();
                        String str2 = MaxAdViewImpl.this.tag;
                        A.b(str2, "Scheduling banner ad refresh " + z + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    }
                    MaxAdViewImpl.this.k.a(z);
                    if (MaxAdViewImpl.this.k.f() || MaxAdViewImpl.this.q) {
                        if (u.a()) {
                            MaxAdViewImpl.this.logger.b(MaxAdViewImpl.this.tag, "Pausing ad refresh for publisher");
                        }
                        MaxAdViewImpl.this.k.d();
                    }
                }
                if (u.a()) {
                    u uVar2 = MaxAdViewImpl.this.logger;
                    String str3 = MaxAdViewImpl.this.tag;
                    uVar2.b(str3, "Calling ad load success callback for publisher: " + MaxAdViewImpl.this.adListener);
                }
                j.a(MaxAdViewImpl.this.adListener, maxAd, true);
                return;
            }
            MaxAdViewImpl.this.sdk.E().destroyAd(bVar);
            onAdLoadFailed(bVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
        }
    }

    private abstract class b implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {
        private boolean a;

        private b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                j.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                if ((MaxAdViewImpl.this.o.A() || MaxAdViewImpl.this.x) && this.a) {
                    this.a = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                j.h(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                j.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                j.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                if ((MaxAdViewImpl.this.o.A() || MaxAdViewImpl.this.x) && !MaxAdViewImpl.this.k.f()) {
                    this.a = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                j.g(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.o)) {
                j.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdRequestStarted(String str) {
            j.a(MaxAdViewImpl.this.requestListener, str, true);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    private class c extends b {
        private c() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            if (u.a()) {
                u uVar = MaxAdViewImpl.this.logger;
                String str2 = MaxAdViewImpl.this.tag;
                uVar.b(str2, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.t) {
                if (u.a()) {
                    u uVar = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    uVar.b(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.E().destroyAd(maxAd);
                return;
            }
            if (u.a()) {
                MaxAdViewImpl.this.logger.b(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
            }
            MaxAdViewImpl.this.a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, m mVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", mVar);
        if (context != null) {
            this.a = context.getApplicationContext();
            this.b = maxAdView;
            this.d = view;
            this.i = new a();
            this.j = new c();
            this.k = new d(mVar, this);
            this.l = new y(maxAdView, mVar);
            this.m = new z(maxAdView, mVar, this);
            mVar.B().a((e.a) this);
            if (u.a()) {
                u uVar = this.logger;
                String str2 = this.tag;
                uVar.b(str2, "Created new MaxAdView (" + this + ")");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* access modifiers changed from: private */
    public void a() {
        com.applovin.impl.mediation.a.b bVar;
        MaxAdView maxAdView = this.b;
        if (maxAdView != null) {
            com.applovin.impl.sdk.utils.b.a(maxAdView, this.d);
        }
        this.m.a();
        synchronized (this.n) {
            bVar = this.o;
        }
        if (bVar != null) {
            this.sdk.E().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        if (!Utils.bitMaskContainsFlag(j2, ((Long) this.sdk.a(com.applovin.impl.sdk.d.a.x)).longValue()) || this.y) {
            if (u.a()) {
                this.logger.b(this.tag, "No undesired viewability flags matched or forcing pre-cache - scheduling viewability");
            }
            this.p = false;
            b();
            return;
        }
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Undesired flags matched - current: " + Long.toBinaryString(j2) + ", undesired: " + Long.toBinaryString(j2));
            this.logger.b(this.tag, "Waiting for refresh timer to manually fire request");
        }
        this.p = true;
    }

    /* access modifiers changed from: private */
    public void a(View view, com.applovin.impl.mediation.a.b bVar) {
        int u2 = bVar.u();
        int v2 = bVar.v();
        int i2 = -1;
        int dpToPx = u2 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), u2);
        if (v2 != -1) {
            i2 = AppLovinSdkUtils.dpToPx(view.getContext(), v2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i2);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (u.a()) {
                this.logger.b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + i2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : q.a(this.b.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void a(final com.applovin.impl.mediation.a.b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
                	at java.util.ArrayList.get(ArrayList.java:435)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                */
            public void run() {
                /*
                    r7 = this;
                    com.applovin.impl.mediation.a.b r0 = r2
                    android.view.View r0 = r0.w()
                    if (r0 != 0) goto L_0x000b
                    java.lang.String r1 = "MaxAdView does not have a loaded ad view"
                    goto L_0x000c
                L_0x000b:
                    r1 = 0
                L_0x000c:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.ads.MaxAdView r2 = r2.b
                    if (r2 != 0) goto L_0x0016
                    java.lang.String r1 = "MaxAdView does not have a parent view"
                L_0x0016:
                    if (r1 == 0) goto L_0x0039
                    boolean r0 = com.applovin.impl.sdk.u.a()
                    if (r0 == 0) goto L_0x0029
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.u r0 = r0.logger
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String r2 = r2.tag
                    r0.e(r2, r1)
                L_0x0029:
                    com.applovin.impl.mediation.MaxErrorImpl r0 = new com.applovin.impl.mediation.MaxErrorImpl
                    r2 = -1
                    r0.<init>(r2, r1)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.MaxAdListener r1 = r1.adListener
                    com.applovin.impl.mediation.a.b r2 = r2
                    com.applovin.impl.sdk.utils.j.a((com.applovin.mediation.MaxAdListener) r1, (com.applovin.mediation.MaxAd) r2, (com.applovin.mediation.MaxError) r0)
                    return
                L_0x0039:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    r1.a()
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r3 = r2
                    r1.a(r3)
                    com.applovin.impl.mediation.a.b r1 = r2
                    boolean r1 = r1.I()
                    if (r1 == 0) goto L_0x0058
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.z r1 = r1.m
                    com.applovin.impl.mediation.a.b r3 = r2
                    r1.a((com.applovin.impl.mediation.a.e) r3)
                L_0x0058:
                    r1 = 393216(0x60000, float:5.51013E-40)
                    r2.setDescendantFocusability(r1)
                    com.applovin.impl.mediation.a.b r1 = r2
                    long r3 = r1.B()
                    r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 == 0) goto L_0x007d
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r1 = r1.d
                    com.applovin.impl.mediation.a.b r3 = r2
                    long r3 = r3.B()
                L_0x0078:
                    int r4 = (int) r3
                    r1.setBackgroundColor(r4)
                    goto L_0x009e
                L_0x007d:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    long r3 = r1.e
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 == 0) goto L_0x0094
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r1 = r1.d
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r3 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    long r3 = r3.e
                    goto L_0x0078
                L_0x0094:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r1 = r1.d
                    r3 = 0
                    r1.setBackgroundColor(r3)
                L_0x009e:
                    r2.addView(r0)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r2 = r2
                    r1.a((android.view.View) r0, (com.applovin.impl.mediation.a.b) r2)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r1 = r2
                    r0.b((com.applovin.impl.mediation.a.b) r1)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.Object r0 = r0.n
                    monitor-enter(r0)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this     // Catch:{ all -> 0x011b }
                    com.applovin.impl.mediation.a.b r2 = r2     // Catch:{ all -> 0x011b }
                    com.applovin.impl.mediation.a.b unused = r1.o = r2     // Catch:{ all -> 0x011b }
                    monitor-exit(r0)     // Catch:{ all -> 0x011b }
                    boolean r0 = com.applovin.impl.sdk.u.a()
                    if (r0 == 0) goto L_0x00d1
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.u r0 = r0.logger
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String r1 = r1.tag
                    java.lang.String r2 = "Scheduling impression for ad manually..."
                    r0.b(r1, r2)
                L_0x00d1:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.m r0 = r0.sdk
                    com.applovin.impl.mediation.MediationServiceImpl r0 = r0.E()
                    com.applovin.impl.mediation.a.b r1 = r2
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.ads.MaxAdViewImpl$a r2 = r2.i
                    r0.processRawAdImpressionPostback(r1, r2)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r0 = r0.o
                    java.lang.String r0 = r0.getAdReviewCreativeId()
                    boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
                    if (r0 == 0) goto L_0x010c
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.MaxAdReviewListener r0 = r0.adReviewListener
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r1 = r1.o
                    java.lang.String r1 = r1.getAdReviewCreativeId()
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r2 = r2.o
                    r3 = 1
                    com.applovin.impl.sdk.utils.j.a((com.applovin.mediation.MaxAdReviewListener) r0, (java.lang.String) r1, (com.applovin.mediation.MaxAd) r2, (boolean) r3)
                L_0x010c:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl$2$1 r0 = new com.applovin.impl.mediation.ads.MaxAdViewImpl$2$1
                    r0.<init>()
                    com.applovin.impl.mediation.a.b r1 = r2
                    long r1 = r1.x()
                    com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r0, r1)
                    return
                L_0x011b:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x011b }
                    goto L_0x011f
                L_0x011e:
                    throw r1
                L_0x011f:
                    goto L_0x011e
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxAdViewImpl.AnonymousClass2.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.b bVar, long j2) {
        if (u.a()) {
            this.logger.b(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.E().processViewabilityAdImpressionPostback(bVar, j2, this.i);
    }

    /* access modifiers changed from: private */
    public void a(final a.C0011a aVar) {
        if (!e()) {
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
                public void run() {
                    if (MaxAdViewImpl.this.o != null) {
                        long a2 = MaxAdViewImpl.this.l.a(MaxAdViewImpl.this.o);
                        MaxAdViewImpl.this.extraParameters.put("visible_ad_ad_unit_id", MaxAdViewImpl.this.o.getAdUnitId());
                        MaxAdViewImpl.this.extraParameters.put("viewability_flags", Long.valueOf(a2));
                    } else {
                        MaxAdViewImpl.this.extraParameters.remove("visible_ad_ad_unit_id");
                        MaxAdViewImpl.this.extraParameters.remove("viewability_flags");
                    }
                    int pxToDp = AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.b.getContext(), MaxAdViewImpl.this.b.getWidth());
                    int pxToDp2 = AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.b.getContext(), MaxAdViewImpl.this.b.getHeight());
                    MaxAdViewImpl.this.extraParameters.put("viewport_width", Integer.valueOf(pxToDp));
                    MaxAdViewImpl.this.extraParameters.put("viewport_height", Integer.valueOf(pxToDp2));
                    MaxAdViewImpl.this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(MaxAdViewImpl.this.k.f() || MaxAdViewImpl.this.q));
                    MaxAdViewImpl.this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(MaxAdViewImpl.this.v));
                    if (u.a()) {
                        u uVar = MaxAdViewImpl.this.logger;
                        String str = MaxAdViewImpl.this.tag;
                        uVar.b(str, "Loading " + MaxAdViewImpl.this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + MaxAdViewImpl.this.adUnitId + "' and notifying " + aVar + "...");
                    }
                    MaxAdViewImpl.this.sdk.E().loadAd(MaxAdViewImpl.this.adUnitId, MaxAdViewImpl.this.c, MaxAdViewImpl.this.adFormat, MaxAdViewImpl.this.localExtraParameters, MaxAdViewImpl.this.extraParameters, MaxAdViewImpl.this.a, aVar);
                }
            });
        } else if (u.a()) {
            u.i(this.tag, "Failed to load new ad - this instance is already destroyed");
        }
    }

    /* access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.s = false;
        if (this.r) {
            this.r = false;
            if (u.a()) {
                u uVar = this.logger;
                String str = this.tag;
                uVar.b(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.i.onAdLoaded(maxAd);
            return;
        }
        if (u.a()) {
            this.logger.b(this.tag, "Saving pre-cache ad...");
        }
        this.f = (com.applovin.impl.mediation.a.b) maxAd;
    }

    /* access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (this.sdk.b(com.applovin.impl.sdk.d.a.n).contains(String.valueOf(maxError.getCode()))) {
            if (u.a()) {
                u A = this.sdk.A();
                String str = this.tag;
                A.b(str, "Ignoring banner ad refresh for error code " + maxError.getCode());
            }
        } else if (this.q || this.k.f()) {
            if (this.s) {
                this.logger.b(this.tag, "Refresh pre-cache failed when auto-refresh is stopped");
                this.s = false;
            }
            if (this.r) {
                this.logger.b(this.tag, "Refresh pre-cache failed - calling ad load failed callback for publisher");
                j.a(this.adListener, this.adUnitId, maxError);
            }
        } else {
            this.p = true;
            this.s = false;
            long longValue = ((Long) this.sdk.a(com.applovin.impl.sdk.d.a.m)).longValue();
            if (longValue >= 0) {
                if (u.a()) {
                    u A2 = this.sdk.A();
                    String str2 = this.tag;
                    A2.b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.k.a(longValue);
            }
        }
    }

    private void a(String str, String str2) {
        if (AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE.equalsIgnoreCase(str)) {
            if (u.a()) {
                u uVar = this.logger;
                String str3 = this.tag;
                uVar.b(str3, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.u = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES.equalsIgnoreCase(str)) {
            if (u.a()) {
                u uVar2 = this.logger;
                String str4 = this.tag;
                uVar2.b(str4, "Updated disable auto-retries to: " + str2);
            }
            this.v = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_PRECACHE.equalsIgnoreCase(str)) {
            if (u.a()) {
                u uVar3 = this.logger;
                String str5 = this.tag;
                uVar3.b(str5, "Updated precached disabled to: " + str2);
            }
            this.w = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_REFRESH_ON_AD_EXPAND.equals(str)) {
            if (u.a()) {
                u uVar4 = this.logger;
                String str6 = this.tag;
                uVar4.b(str6, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.x = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.FORCE_PRECACHE.equals(str)) {
            if (u.a()) {
                u uVar5 = this.logger;
                String str7 = this.tag;
                uVar5.b(str7, "Updated force precache to: " + str2);
            }
            this.y = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER.equalsIgnoreCase(str)) {
            if (u.a()) {
                u uVar6 = this.logger;
                String str8 = this.tag;
                uVar6.b(str8, "Updated is adaptive banner to: " + str2);
            }
            this.z = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    private void b() {
        if (d()) {
            if (u.a()) {
                this.logger.b(this.tag, "Scheduling refresh precache request now");
            }
            this.s = true;
            this.sdk.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.sdk.f.z(this.sdk, new Runnable() {
                public void run() {
                    if (u.a()) {
                        MaxAdViewImpl.this.logger.b(MaxAdViewImpl.this.tag, "Loading ad for pre-cache request...");
                    }
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.a((a.C0011a) maxAdViewImpl.j);
                }
            }), com.applovin.impl.mediation.d.c.a(this.adFormat));
        }
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.a.b bVar) {
        int height = this.b.getHeight();
        int width = this.b.getWidth();
        if (height > 0 || width > 0) {
            int pxToDp = AppLovinSdkUtils.pxToDp(this.a, height);
            int pxToDp2 = AppLovinSdkUtils.pxToDp(this.a, width);
            MaxAdFormat format = bVar.getFormat();
            int height2 = (this.z ? format.getAdaptiveSize(pxToDp2, this.a) : format.getSize()).getHeight();
            int width2 = format.getSize().getWidth();
            if (!u.a()) {
                return;
            }
            if (pxToDp < height2 || pxToDp2 < width2) {
                StringBuilder sb = new StringBuilder("\n**************************************************\n`MaxAdView` size ");
                sb.append(pxToDp2);
                sb.append("x");
                sb.append(pxToDp);
                sb.append(" dp smaller than required ");
                sb.append(this.z ? "adaptive " : "");
                sb.append("size: ");
                sb.append(width2);
                sb.append("x");
                sb.append(height2);
                sb.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                this.logger.e("AppLovinSdk", sb.toString());
            }
        }
    }

    private void c() {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Rendering for cached ad: " + this.f + "...");
        }
        this.i.onAdLoaded(this.f);
        this.f = null;
    }

    private boolean d() {
        if (this.w) {
            return false;
        }
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.y)).booleanValue();
    }

    private boolean e() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.t;
        }
        return z2;
    }

    public void destroy() {
        a();
        if (this.f != null) {
            this.sdk.E().destroyAd(this.f);
        }
        synchronized (this.n) {
            this.t = true;
        }
        this.k.c();
        this.sdk.B().b((e.a) this);
        this.sdk.I().a(this.adUnitId, this.c);
        super.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (com.applovin.impl.sdk.u.a() != false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bc, code lost:
        if (com.applovin.impl.sdk.u.a() != false) goto L_0x00be;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadAd() {
        /*
            r5 = this;
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x002a
            com.applovin.impl.sdk.u r0 = r5.logger
            java.lang.String r1 = r5.tag
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = " Loading ad for "
            r2.append(r3)
            java.lang.String r3 = r5.adUnitId
            r2.append(r3)
            java.lang.String r3 = "..."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.b(r1, r2)
        L_0x002a:
            boolean r0 = r5.u
            r1 = 1
            if (r0 != 0) goto L_0x0042
            com.applovin.impl.sdk.m r0 = r5.sdk
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.d.a.t
            java.lang.Object r0 = r0.a(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r0 = 0
            goto L_0x0043
        L_0x0042:
            r0 = 1
        L_0x0043:
            if (r0 == 0) goto L_0x0080
            com.applovin.impl.sdk.d r2 = r5.k
            boolean r2 = r2.f()
            if (r2 != 0) goto L_0x0080
            com.applovin.impl.sdk.d r2 = r5.k
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0080
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = r5.tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to load a new ad. An ad refresh has already been scheduled in "
            r1.<init>(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.applovin.impl.sdk.d r3 = r5.k
            long r3 = r3.b()
            long r2 = r2.toSeconds(r3)
            r1.append(r2)
            java.lang.String r2 = " seconds."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.applovin.impl.sdk.u.i(r0, r1)
        L_0x007f:
            return
        L_0x0080:
            java.lang.String r2 = "Loading ad..."
            if (r0 == 0) goto L_0x00b8
            com.applovin.impl.mediation.a.b r0 = r5.f
            if (r0 == 0) goto L_0x009b
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x0097
            com.applovin.impl.sdk.u r0 = r5.logger
            java.lang.String r1 = r5.tag
            java.lang.String r2 = "Rendering cached ad"
            r0.b(r1, r2)
        L_0x0097:
            r5.c()
            goto L_0x00ca
        L_0x009b:
            boolean r0 = r5.s
            if (r0 == 0) goto L_0x00b1
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x00ae
            com.applovin.impl.sdk.u r0 = r5.logger
            java.lang.String r2 = r5.tag
            java.lang.String r3 = "Waiting for precache ad to load to render"
            r0.b(r2, r3)
        L_0x00ae:
            r5.r = r1
            goto L_0x00ca
        L_0x00b1:
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x00c5
            goto L_0x00be
        L_0x00b8:
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x00c5
        L_0x00be:
            com.applovin.impl.sdk.u r0 = r5.logger
            java.lang.String r1 = r5.tag
            r0.b(r1, r2)
        L_0x00c5:
            com.applovin.impl.mediation.ads.MaxAdViewImpl$a r0 = r5.i
            r5.a((com.applovin.impl.mediation.ads.a.C0011a) r0)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxAdViewImpl.loadAd():void");
    }

    public void onAdRefresh() {
        String str;
        String str2;
        u uVar;
        this.r = false;
        if (this.f != null) {
            c();
            return;
        }
        if (!d()) {
            if (u.a()) {
                uVar = this.logger;
                str2 = this.tag;
                str = "Refreshing ad from network...";
            }
            loadAd();
        } else if (this.p) {
            if (u.a()) {
                uVar = this.logger;
                str2 = this.tag;
                str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
            }
            loadAd();
        } else {
            if (u.a()) {
                this.logger.e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.r = true;
            return;
        }
        uVar.b(str2, str);
        loadAd();
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.a.b bVar = this.o;
        if (bVar == null || !bVar.f().equalsIgnoreCase(str)) {
            com.applovin.impl.mediation.a.b bVar2 = this.f;
            if (bVar2 != null && bVar2.f().equalsIgnoreCase(str)) {
                this.f.b(str2);
                return;
            }
            return;
        }
        this.o.b(str2);
        j.a(this.adReviewListener, str2, (MaxAd) this.o);
    }

    public void onLogVisibilityImpression() {
        a(this.o, this.l.a(this.o));
    }

    public void onWindowVisibilityChanged(int i2) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.r)).booleanValue() && this.k.a()) {
            if (q.a(i2)) {
                if (u.a()) {
                    this.logger.b(this.tag, "Ad view visible");
                }
                this.k.h();
                return;
            }
            if (u.a()) {
                this.logger.b(this.tag, "Ad view hidden");
            }
            this.k.g();
        }
    }

    public void setCustomData(String str) {
        if (this.o != null) {
            String str2 = this.tag;
            u.i(str2, "Custom data for Ad Unit ID (" + this.adUnitId + ") was set after load was called. For the ads to be correctly attributed to this custom data, please set the custom data before loading the " + this.adFormat.getLabel() + ".");
        }
        Utils.maybeLogCustomDataSizeLimit(str, this.tag);
        this.h = str;
    }

    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (u.a() && this.o != null) {
            String str2 = this.tag;
            u.i(str2, "Placement for Ad Unit ID (" + this.adUnitId + ") was set after load was called. For the ads to be correctly attributed to this placement, please set the placement before loading the " + this.adFormat.getLabel() + ".");
        }
        this.g = str;
    }

    public void setPublisherBackgroundColor(int i2) {
        this.e = (long) i2;
    }

    public void startAutoRefresh() {
        String str;
        String str2;
        u uVar;
        this.q = false;
        if (this.k.f()) {
            this.k.e();
            if (u.a()) {
                uVar = this.logger;
                str2 = this.tag;
                str = "Resumed auto-refresh with remaining time: " + this.k.b() + "ms";
            } else {
                return;
            }
        } else if (u.a()) {
            uVar = this.logger;
            str2 = this.tag;
            str = "Ignoring call to startAutoRefresh() - ad refresh is not paused";
        } else {
            return;
        }
        uVar.b(str2, str);
    }

    public void stopAutoRefresh() {
        if (this.o != null) {
            if (u.a()) {
                u uVar = this.logger;
                String str = this.tag;
                uVar.b(str, "Pausing auto-refresh with remaining time: " + this.k.b() + "ms");
            }
            this.k.d();
        } else if (this.u || ((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.t)).booleanValue()) {
            this.q = true;
        } else if (u.a()) {
            u.h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append("', adListener=");
        sb.append(this.adListener == this.b ? "this" : this.adListener);
        sb.append(", isDestroyed=");
        sb.append(e());
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
