package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MaxFullscreenAdImpl extends a implements b.a, e.a {
    /* access modifiers changed from: private */
    public final a a;
    /* access modifiers changed from: private */
    public final com.applovin.impl.sdk.b b;
    /* access modifiers changed from: private */
    public final com.applovin.impl.mediation.b c;
    /* access modifiers changed from: private */
    public final Object d = new Object();
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.a.c e = null;
    private c f = c.IDLE;
    /* access modifiers changed from: private */
    public final AtomicBoolean g = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public WeakReference<Activity> j = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<ViewGroup> k = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<Lifecycle> l = new WeakReference<>((Object) null);
    protected final b listenerWrapper;

    public interface a {
        Activity getActivity();
    }

    private class b implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        private b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            j.d(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            final boolean e = MaxFullscreenAdImpl.this.i;
            boolean unused = MaxFullscreenAdImpl.this.i = false;
            final com.applovin.impl.mediation.a.c cVar = (com.applovin.impl.mediation.a.c) maxAd;
            final MaxAd maxAd2 = maxAd;
            final MaxError maxError2 = maxError;
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(maxAd2);
                    if (e || !cVar.B() || !MaxFullscreenAdImpl.this.sdk.I().a(MaxFullscreenAdImpl.this.adUnitId)) {
                        j.a(MaxFullscreenAdImpl.this.adListener, maxAd2, maxError2, true);
                    } else {
                        AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
                            public void run() {
                                boolean unused = MaxFullscreenAdImpl.this.i = true;
                                MaxFullscreenAdImpl.this.loadAd(MaxFullscreenAdImpl.this.a.getActivity());
                            }
                        });
                    }
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.i = false;
            MaxFullscreenAdImpl.this.b.a();
            j.b(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdHidden(final MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.i = false;
            MaxFullscreenAdImpl.this.c.a(maxAd);
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(maxAd);
                    j.c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                }
            });
        }

        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.b();
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    j.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
                }
            });
        }

        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.a((com.applovin.impl.mediation.a.c) maxAd);
            if (MaxFullscreenAdImpl.this.g.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.a(c.READY, (Runnable) new Runnable() {
                    public void run() {
                        if (MaxFullscreenAdImpl.this.i) {
                            Activity activity = (Activity) MaxFullscreenAdImpl.this.j.get();
                            if (activity == null) {
                                activity = MaxFullscreenAdImpl.this.sdk.ao();
                            }
                            Activity activity2 = activity;
                            if (MaxFullscreenAdImpl.this.h) {
                                MaxFullscreenAdImpl.this.showAd(MaxFullscreenAdImpl.this.e.getPlacement(), MaxFullscreenAdImpl.this.e.ab(), (ViewGroup) MaxFullscreenAdImpl.this.k.get(), (Lifecycle) MaxFullscreenAdImpl.this.l.get(), activity2);
                            } else {
                                MaxFullscreenAdImpl.this.showAd(MaxFullscreenAdImpl.this.e.getPlacement(), MaxFullscreenAdImpl.this.e.ab(), activity2);
                            }
                        } else {
                            j.a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                        }
                    }
                });
            }
        }

        public void onAdRequestStarted(String str) {
            j.a(MaxFullscreenAdImpl.this.requestListener, str, true);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxFullscreenAdImpl.this.revenueListener, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            j.f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            j.e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            j.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    public enum c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, a aVar, String str2, m mVar) {
        super(str, maxAdFormat, str2, mVar);
        this.a = aVar;
        b bVar = new b();
        this.listenerWrapper = bVar;
        this.b = new com.applovin.impl.sdk.b(mVar, this);
        this.c = new com.applovin.impl.mediation.b(mVar, bVar);
        mVar.B().a((e.a) this);
        if (u.a()) {
            u.f(str2, "Created new " + str2 + " (" + this + ")");
        }
    }

    private void a() {
        com.applovin.impl.mediation.a.c cVar;
        synchronized (this.d) {
            cVar = this.e;
            this.e = null;
        }
        this.sdk.E().destroyAd(cVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.c cVar) {
        long u = cVar.u() - (SystemClock.elapsedRealtime() - cVar.q());
        if (u > TimeUnit.SECONDS.toMillis(2)) {
            this.e = cVar;
            if (u.a()) {
                u uVar = this.logger;
                String str = this.tag;
                uVar.b(str, "Handle ad loaded for regular ad: " + cVar);
                u uVar2 = this.logger;
                String str2 = this.tag;
                uVar2.b(str2, "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(u) + " seconds from now for " + getAdUnitId() + "...");
            }
            this.b.a(u);
            return;
        }
        if (u.a()) {
            this.logger.b(this.tag, "Loaded an expired ad, running expire logic...");
        }
        onAdExpired();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c r13, java.lang.Runnable r14) {
        /*
            r12 = this;
            java.lang.String r0 = "Unable to transition to: "
            java.lang.String r1 = "Unable to transition to: "
            java.lang.String r2 = "Unable to transition to: "
            java.lang.String r3 = "Unknown state: "
            java.lang.String r4 = "Unable to transition to: "
            java.lang.String r5 = "Transitioning from "
            java.lang.String r6 = "Not allowed transition from "
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r7 = r12.f
            java.lang.Object r8 = r12.d
            monitor-enter(r8)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r9 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01ce }
            r10 = 1
            r11 = 0
            if (r7 != r9) goto L_0x004e
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x001f
            goto L_0x0175
        L_0x001f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0025
            goto L_0x0175
        L_0x0025:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0034
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "No ad is loading or loaded"
            goto L_0x0066
        L_0x0034:
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r2.<init>(r4)     // Catch:{ all -> 0x01ce }
            r2.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01ce }
        L_0x004a:
            r0.e(r1, r2)     // Catch:{ all -> 0x01ce }
            goto L_0x0069
        L_0x004e:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r4 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01ce }
            if (r7 != r4) goto L_0x009e
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0058
            goto L_0x0175
        L_0x0058:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x006c
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "An ad is already loading"
        L_0x0066:
            com.applovin.impl.sdk.u.i(r0, r1)     // Catch:{ all -> 0x01ce }
        L_0x0069:
            r10 = 0
            goto L_0x0175
        L_0x006c:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0072
            goto L_0x0175
        L_0x0072:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0081
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "An ad is not ready to be shown yet"
            goto L_0x0066
        L_0x0081:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x0087
            goto L_0x0175
        L_0x0087:
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r3.<init>(r2)     // Catch:{ all -> 0x01ce }
            r3.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01ce }
            goto L_0x004a
        L_0x009e:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01ce }
            if (r7 != r2) goto L_0x00ef
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x00a8
            goto L_0x0175
        L_0x00a8:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x00b7
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "An ad is already loaded"
            goto L_0x0066
        L_0x00b7:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x00c8
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = "An ad is already marked as ready"
            goto L_0x004a
        L_0x00c8:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x00ce
            goto L_0x0175
        L_0x00ce:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01ce }
            if (r13 != r0) goto L_0x00d4
            goto L_0x0175
        L_0x00d4:
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r3.<init>(r1)     // Catch:{ all -> 0x01ce }
            r3.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x01ce }
            r0.e(r2, r1)     // Catch:{ all -> 0x01ce }
            goto L_0x0069
        L_0x00ef:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01ce }
            if (r7 != r1) goto L_0x014b
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01ce }
            if (r13 != r1) goto L_0x00f9
            goto L_0x0175
        L_0x00f9:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01ce }
            if (r13 != r1) goto L_0x0109
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "Can not load another ad while the ad is showing"
            goto L_0x0066
        L_0x0109:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01ce }
            if (r13 != r1) goto L_0x011b
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = "An ad is already showing, ignoring"
            goto L_0x004a
        L_0x011b:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01ce }
            if (r13 != r1) goto L_0x012b
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "The ad is already showing, not showing another one"
            goto L_0x0066
        L_0x012b:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01ce }
            if (r13 != r1) goto L_0x0130
            goto L_0x0175
        L_0x0130:
            boolean r1 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r1 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r1 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r3.<init>(r0)     // Catch:{ all -> 0x01ce }
            r3.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01ce }
            r1.e(r2, r0)     // Catch:{ all -> 0x01ce }
            goto L_0x0069
        L_0x014b:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01ce }
            if (r7 != r0) goto L_0x015b
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = "No operations are allowed on a destroyed instance"
            goto L_0x0066
        L_0x015b:
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r2.<init>(r3)     // Catch:{ all -> 0x01ce }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.f     // Catch:{ all -> 0x01ce }
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01ce }
            goto L_0x004a
        L_0x0175:
            if (r10 == 0) goto L_0x01a2
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x019f
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r2.<init>(r5)     // Catch:{ all -> 0x01ce }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.f     // Catch:{ all -> 0x01ce }
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            java.lang.String r3 = " to "
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            r2.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r3 = "..."
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01ce }
            r0.b(r1, r2)     // Catch:{ all -> 0x01ce }
        L_0x019f:
            r12.f = r13     // Catch:{ all -> 0x01ce }
            goto L_0x01c5
        L_0x01a2:
            boolean r0 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x01c5
            com.applovin.impl.sdk.u r0 = r12.logger     // Catch:{ all -> 0x01ce }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            r2.<init>(r6)     // Catch:{ all -> 0x01ce }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.f     // Catch:{ all -> 0x01ce }
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            java.lang.String r3 = " to "
            r2.append(r3)     // Catch:{ all -> 0x01ce }
            r2.append(r13)     // Catch:{ all -> 0x01ce }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x01ce }
            r0.d(r1, r13)     // Catch:{ all -> 0x01ce }
        L_0x01c5:
            monitor-exit(r8)     // Catch:{ all -> 0x01ce }
            if (r10 == 0) goto L_0x01cd
            if (r14 == 0) goto L_0x01cd
            r14.run()
        L_0x01cd:
            return
        L_0x01ce:
            r13 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x01ce }
            goto L_0x01d2
        L_0x01d1:
            throw r13
        L_0x01d2:
            goto L_0x01d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.b.a();
        a();
        this.sdk.F().b((com.applovin.impl.mediation.a.a) maxAd);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        this.c.b(this.e);
        this.e.e(str);
        this.e.f(str2);
        if (u.a()) {
            u uVar = this.logger;
            String str3 = this.tag;
            uVar.b(str3, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.e + "...");
        }
        a(this.e);
    }

    private boolean a(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        } else if (!isReady()) {
            String str = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            if (u.a()) {
                u.i(this.tag, str);
            }
            j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-24, str), true);
            return false;
        } else {
            if (Utils.getAlwaysFinishActivitiesSetting(activity) != 0 && this.sdk.p().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
                if (Utils.isPubInDebugMode(activity, this.sdk)) {
                    throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                } else if (((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.R)).booleanValue()) {
                    if (u.a()) {
                        u.i(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    }
                    j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!"), true);
                    return false;
                }
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.z)).booleanValue() && (this.sdk.ae().a() || this.sdk.ae().b())) {
                if (u.a()) {
                    u.i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
                }
                j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing"), true);
                return false;
            } else if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.A)).booleanValue() || h.a((Context) activity)) {
                String str2 = this.sdk.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.BLOCK_FULLSCREEN_ADS_SHOWING_IF_ACTIVITY_FINISHING);
                if ((!(StringUtils.isValidString(str2) && Boolean.valueOf(str2).booleanValue()) && !((Boolean) this.sdk.a(com.applovin.impl.sdk.d.a.B)).booleanValue()) || !activity.isFinishing()) {
                    return true;
                }
                if (u.a()) {
                    u.i(this.tag, "Attempting to show ad when activity is finishing");
                }
                j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-5601, "Attempting to show ad when activity is finishing"), true);
                return false;
            } else {
                if (u.a()) {
                    u.i(this.tag, "Attempting to show ad with no internet connection");
                }
                j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-1009), true);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        com.applovin.impl.mediation.a.c cVar;
        if (this.g.compareAndSet(true, false)) {
            synchronized (this.d) {
                cVar = this.e;
                this.e = null;
            }
            this.sdk.E().destroyAd(cVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    public void destroy() {
        a(c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.d) {
                    if (MaxFullscreenAdImpl.this.e != null) {
                        if (u.a()) {
                            u uVar = MaxFullscreenAdImpl.this.logger;
                            String str = MaxFullscreenAdImpl.this.tag;
                            uVar.b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.e + "...");
                        }
                        MaxFullscreenAdImpl.this.sdk.E().destroyAd(MaxFullscreenAdImpl.this.e);
                    }
                }
                MaxFullscreenAdImpl.this.sdk.B().b((e.a) MaxFullscreenAdImpl.this);
                MaxFullscreenAdImpl.super.destroy();
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.d) {
            com.applovin.impl.mediation.a.c cVar = this.e;
            z = cVar != null && cVar.e() && this.f == c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (isReady()) {
            if (u.a()) {
                u uVar2 = this.logger;
                String str2 = this.tag;
                uVar2.b(str2, "An ad is already loaded for '" + this.adUnitId + "'");
            }
            j.a(this.adListener, (MaxAd) this.e, true);
            return;
        }
        a(c.LOADING, (Runnable) new Runnable() {
            public void run() {
                Context context = activity;
                if (context == null) {
                    context = MaxFullscreenAdImpl.this.sdk.ao() != null ? MaxFullscreenAdImpl.this.sdk.ao() : MaxFullscreenAdImpl.this.sdk.L();
                }
                MaxFullscreenAdImpl.this.sdk.E().loadAd(MaxFullscreenAdImpl.this.adUnitId, (String) null, MaxFullscreenAdImpl.this.adFormat, MaxFullscreenAdImpl.this.localExtraParameters, MaxFullscreenAdImpl.this.extraParameters, context, MaxFullscreenAdImpl.this.listenerWrapper);
            }
        });
    }

    public void onAdExpired() {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Ad expired " + getAdUnitId());
        }
        this.g.set(true);
        Activity activity = this.a.getActivity();
        if (activity == null && (activity = this.sdk.af().a()) == null) {
            b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
            return;
        }
        this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.E().loadAd(this.adUnitId, (String) null, this.adFormat, this.localExtraParameters, this.extraParameters, activity, this.listenerWrapper);
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.a.c cVar = this.e;
        if (cVar != null && cVar.f().equalsIgnoreCase(str)) {
            this.e.b(str2);
            j.a(this.adReviewListener, str2, (MaxAd) this.e);
        }
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        String c2 = this.sdk.J().c();
        if (!this.sdk.J().b() || c2 == null || c2.equals(this.e.N())) {
            if (activity == null) {
                activity = this.sdk.ao();
            }
            if (a(activity)) {
                a(c.SHOWING, (Runnable) new Runnable() {
                    public void run() {
                        MaxFullscreenAdImpl.this.a(str, str2);
                        boolean unused = MaxFullscreenAdImpl.this.h = false;
                        WeakReference unused2 = MaxFullscreenAdImpl.this.j = new WeakReference(activity);
                        MaxFullscreenAdImpl.this.sdk.E().showFullscreenAd(MaxFullscreenAdImpl.this.e, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                    }
                });
                return;
            }
            return;
        }
        final String str3 = "Attempting to show ad from <" + this.e.N() + "> which does not match selected ad network <" + c2 + ">";
        u.i(this.tag, str3);
        a(c.IDLE, (Runnable) new Runnable() {
            public void run() {
                com.applovin.impl.mediation.a.c b2 = MaxFullscreenAdImpl.this.e;
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.a((MaxAd) maxFullscreenAdImpl.e);
                j.a(MaxFullscreenAdImpl.this.adListener, (MaxAd) b2, (MaxError) new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str3), true);
            }
        });
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            if (u.a()) {
                u.i(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            }
            j.a(this.adListener, (MaxAd) this.e, (MaxError) new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle."), true);
            return;
        }
        String c2 = this.sdk.J().c();
        if (!this.sdk.J().b() || c2 == null || c2.equals(this.e.N())) {
            if (activity == null) {
                activity = this.sdk.ao();
            }
            final Activity activity2 = activity;
            if (a(activity2)) {
                final String str3 = str;
                final String str4 = str2;
                final ViewGroup viewGroup2 = viewGroup;
                final Lifecycle lifecycle2 = lifecycle;
                a(c.SHOWING, (Runnable) new Runnable() {
                    public void run() {
                        MaxFullscreenAdImpl.this.a(str3, str4);
                        boolean unused = MaxFullscreenAdImpl.this.h = true;
                        WeakReference unused2 = MaxFullscreenAdImpl.this.j = new WeakReference(activity2);
                        WeakReference unused3 = MaxFullscreenAdImpl.this.k = new WeakReference(viewGroup2);
                        WeakReference unused4 = MaxFullscreenAdImpl.this.l = new WeakReference(lifecycle2);
                        MaxFullscreenAdImpl.this.sdk.E().showFullscreenAd(MaxFullscreenAdImpl.this.e, viewGroup2, lifecycle2, activity2, MaxFullscreenAdImpl.this.listenerWrapper);
                    }
                });
                return;
            }
            return;
        }
        final String str5 = "Attempting to show ad from <" + this.e.N() + "> which does not match selected ad network <" + c2 + ">";
        u.i(this.tag, str5);
        a(c.IDLE, (Runnable) new Runnable() {
            public void run() {
                com.applovin.impl.mediation.a.c b2 = MaxFullscreenAdImpl.this.e;
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.a((MaxAd) maxFullscreenAdImpl.e);
                j.a(MaxFullscreenAdImpl.this.adListener, (MaxAd) b2, (MaxError) new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str5), true);
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append("', adListener=");
        sb.append(this.adListener == this.a ? "this" : this.adListener);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
