package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.n;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.v;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.o;
import com.applovin.impl.sdk.utils.q;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements b.a {
    /* access modifiers changed from: private */
    public int A = 0;
    /* access modifiers changed from: private */
    public final ArrayList<Long> B = new ArrayList<>();
    protected final e a;
    protected final m b;
    protected final u c;
    protected final d d;
    protected Activity e;
    protected AppLovinAdView f;
    protected final com.applovin.impl.adview.m g;
    protected final long h = SystemClock.elapsedRealtime();
    protected long i = -1;
    protected int j = 0;
    protected int k = 0;
    protected int l = h.a;
    protected boolean m;
    protected AppLovinAdClickListener n;
    protected AppLovinAdDisplayListener o;
    protected AppLovinAdVideoPlaybackListener p;
    protected final com.applovin.impl.sdk.c.b q;
    protected o r;
    private final Handler s = new Handler(Looper.getMainLooper());
    private final com.applovin.impl.sdk.utils.a t;
    /* access modifiers changed from: private */
    public final AppLovinBroadcastManager.Receiver u;
    private final h.a v;
    private final AtomicBoolean w = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean x = new AtomicBoolean();
    private long y;
    private boolean z;

    /* renamed from: com.applovin.impl.adview.activity.b.a$a  reason: collision with other inner class name */
    public interface C0008a {
        void a(a aVar);

        void a(String str, Throwable th);
    }

    private class b implements View.OnClickListener, AppLovinAdClickListener {
        private b() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            if (u.a()) {
                a.this.c.b("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            j.a(a.this.n, appLovinAd);
            a.this.d.b();
            a.this.k++;
        }

        public void onClick(View view) {
            if (view == a.this.g && ((Boolean) a.this.b.a(com.applovin.impl.sdk.d.b.co)).booleanValue()) {
                a.c(a.this);
                if (a.this.a.V()) {
                    a aVar = a.this;
                    aVar.b("javascript:al_onCloseButtonTapped(" + a.this.A + "," + a.this.j + "," + a.this.k + ");");
                }
                List<Integer> u = a.this.a.u();
                if (u.a()) {
                    u uVar = a.this.c;
                    uVar.b("AppLovinFullscreenActivity", "Handling close button tap " + a.this.A + " with multi close delay: " + u);
                }
                if (u == null || u.size() <= a.this.A) {
                    a.this.h();
                    return;
                }
                a.this.B.add(Long.valueOf(SystemClock.elapsedRealtime() - a.this.i));
                List<i.a> w = a.this.a.w();
                if (w != null && w.size() > a.this.A) {
                    a.this.g.a(w.get(a.this.A));
                }
                if (u.a()) {
                    u uVar2 = a.this.c;
                    uVar2.b("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + u.get(a.this.A));
                }
                a.this.g.setVisibility(8);
                a aVar2 = a.this;
                aVar2.a(aVar2.g, (long) u.get(a.this.A).intValue(), new Runnable() {
                    public void run() {
                        a.this.i = SystemClock.elapsedRealtime();
                    }
                });
            } else if (u.a()) {
                u uVar3 = a.this.c;
                uVar3.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    a(final e eVar, Activity activity, final m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.a = eVar;
        this.b = mVar;
        this.c = mVar.A();
        this.e = activity;
        this.n = appLovinAdClickListener;
        this.o = appLovinAdDisplayListener;
        this.p = appLovinAdVideoPlaybackListener;
        com.applovin.impl.sdk.c.b bVar = new com.applovin.impl.sdk.c.b(activity, mVar);
        this.q = bVar;
        bVar.a((b.a) this);
        d dVar = new d(eVar, mVar);
        this.d = dVar;
        b bVar2 = new b();
        n nVar = new n(mVar.Y(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f = nVar;
        nVar.setAdClickListener(bVar2);
        this.f.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                if (u.a()) {
                    a.this.c.b("AppLovinFullscreenActivity", "Web content rendered");
                }
            }

            public void adHidden(AppLovinAd appLovinAd) {
                if (u.a()) {
                    a.this.c.b("AppLovinFullscreenActivity", "Closing from WebView");
                }
                a.this.h();
            }
        });
        this.f.getController().a(dVar);
        mVar.u().trackImpression(eVar);
        List<Integer> u2 = eVar.u();
        if (eVar.t() >= 0 || u2 != null) {
            com.applovin.impl.adview.m mVar2 = new com.applovin.impl.adview.m(eVar.v(), activity);
            this.g = mVar2;
            mVar2.setVisibility(8);
            mVar2.setOnClickListener(bVar2);
        } else {
            this.g = null;
        }
        if (((Boolean) mVar.a(com.applovin.impl.sdk.d.b.cq)).booleanValue()) {
            this.u = new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    mVar.u().trackAppKilled(eVar);
                    mVar.aj().unregisterReceiver(this);
                }
            };
        } else {
            this.u = null;
        }
        if (eVar.al()) {
            this.v = new h.a() {
                public void a(int i) {
                    String str;
                    if (a.this.l != h.a) {
                        a.this.m = true;
                    }
                    com.applovin.impl.adview.d s = a.this.f.getController().s();
                    if (!h.a(i) || h.a(a.this.l)) {
                        if (i == 2) {
                            str = "javascript:al_muteSwitchOff();";
                        }
                        a.this.l = i;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    s.a(str);
                    a.this.l = i;
                }
            };
        } else {
            this.v = null;
        }
        if (((Boolean) mVar.a(com.applovin.impl.sdk.d.b.eF)).booleanValue()) {
            this.t = new com.applovin.impl.sdk.utils.a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!a.this.x.get()) {
                        if (activity.getClass().getName().equals(Utils.retrieveLauncherActivityFullyQualifiedName(activity.getApplicationContext()))) {
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    u.i("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
                                    try {
                                        a.this.h();
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                    }
                }
            };
        } else {
            this.t = null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.applovin.impl.adview.activity.b.a] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.applovin.impl.adview.activity.b.b] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v29, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.applovin.impl.adview.activity.b.e] */
    /* JADX WARNING: type inference failed for: r1v31, types: [com.applovin.impl.adview.activity.b.g] */
    /* JADX WARNING: type inference failed for: r1v32, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v33, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v34, types: [com.applovin.impl.adview.activity.b.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.applovin.impl.sdk.ad.e r16, com.applovin.sdk.AppLovinAdClickListener r17, com.applovin.sdk.AppLovinAdDisplayListener r18, com.applovin.sdk.AppLovinAdVideoPlaybackListener r19, com.applovin.impl.sdk.m r20, android.app.Activity r21, com.applovin.impl.adview.activity.b.a.C0008a r22) {
        /*
            r8 = r20
            r9 = r22
            boolean r0 = r16.aH()
            r1 = 0
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            if (r0 == 0) goto L_0x0016
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkExoPlayerEligibility(r20)
            if (r0 == 0) goto L_0x0016
            r1 = 1
        L_0x0016:
            r11 = r16
            boolean r0 = r11 instanceof com.applovin.impl.a.a
            java.lang.String r12 = "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter."
            java.lang.String r13 = "AppLovinFullscreenActivity"
            java.lang.String r14 = " and throwable: "
            if (r0 == 0) goto L_0x00a8
            java.lang.String r15 = "Failed to create FullscreenVastVideoAdPresenter with sdk: "
            if (r1 == 0) goto L_0x0079
            com.applovin.impl.adview.activity.b.c r0 = new com.applovin.impl.adview.activity.b.c     // Catch:{ all -> 0x003a }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003a }
            goto L_0x017d
        L_0x003a:
            r0 = move-exception
            boolean r1 = com.applovin.impl.sdk.u.a()
            if (r1 == 0) goto L_0x0048
            com.applovin.impl.sdk.u r1 = r20.A()
            r1.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.Throwable) r0)
        L_0x0048:
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r10
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x005e }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x005e }
            goto L_0x017d
        L_0x005e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x0079:
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x008d }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x008d }
            goto L_0x017d
        L_0x008d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r15)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x00a8:
            boolean r0 = r16.hasVideoUrl()
            if (r0 == 0) goto L_0x016b
            boolean r0 = r16.aK()
            if (r0 == 0) goto L_0x00e5
            com.applovin.impl.adview.activity.b.g r0 = new com.applovin.impl.adview.activity.b.g     // Catch:{ all -> 0x00c8 }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00c8 }
            goto L_0x017d
        L_0x00c8:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenWebVideoAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x00e5:
            if (r1 == 0) goto L_0x013b
            com.applovin.impl.adview.activity.b.e r0 = new com.applovin.impl.adview.activity.b.e     // Catch:{ all -> 0x00fb }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00fb }
            goto L_0x017d
        L_0x00fb:
            r0 = move-exception
            boolean r1 = com.applovin.impl.sdk.u.a()
            if (r1 == 0) goto L_0x0109
            com.applovin.impl.sdk.u r1 = r20.A()
            r1.a((java.lang.String) r13, (java.lang.String) r12, (java.lang.Throwable) r0)
        L_0x0109:
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r10
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x011e }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x011e }
            goto L_0x017d
        L_0x011e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x013b:
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x014e }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x014e }
            goto L_0x017d
        L_0x014e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenVideoAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x016b:
            com.applovin.impl.adview.activity.b.b r0 = new com.applovin.impl.adview.activity.b.b     // Catch:{ all -> 0x0184 }
            r1 = r0
            r2 = r16
            r3 = r21
            r4 = r20
            r5 = r17
            r6 = r18
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0184 }
        L_0x017d:
            r0.c()
            r9.a(r0)
            return
        L_0x0184:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to create FullscreenGraphicAdPresenter with sdk: "
            r1.<init>(r2)
            r1.append(r8)
            r1.append(r14)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.b.a.a(com.applovin.impl.sdk.ad.e, com.applovin.sdk.AppLovinAdClickListener, com.applovin.sdk.AppLovinAdDisplayListener, com.applovin.sdk.AppLovinAdVideoPlaybackListener, com.applovin.impl.sdk.m, android.app.Activity, com.applovin.impl.adview.activity.b.a$a):void");
    }

    static /* synthetic */ int c(a aVar) {
        int i2 = aVar.A;
        aVar.A = i2 + 1;
        return i2;
    }

    private void c() {
        if (this.u != null) {
            this.b.aj().registerReceiver(this.u, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
        if (this.v != null) {
            this.b.ai().a(this.v);
        }
        if (this.t != null) {
            this.b.af().a(this.t);
        }
    }

    public void a(int i2, KeyEvent keyEvent) {
        if (this.c != null && u.a()) {
            u uVar = this.c;
            uVar.c("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i2 + ", " + keyEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2, boolean z3, long j2) {
        int i3 = i2;
        if (this.w.compareAndSet(false, true)) {
            if (this.a.hasVideoUrl() || t()) {
                j.a(this.p, (AppLovinAd) this.a, (double) i3, z3);
            }
            if (this.a.hasVideoUrl()) {
                this.d.c((long) i3);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.h;
            this.b.u().trackVideoEnd(this.a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i2, z2);
            long j3 = -1;
            if (this.i != -1) {
                j3 = SystemClock.elapsedRealtime() - this.i;
            }
            this.b.u().trackFullScreenAdClosed(this.a, j3, this.B, j2, this.m, this.l);
            if (u.a()) {
                u uVar = this.c;
                uVar.b("AppLovinFullscreenActivity", "Video ad ended at percent: " + i3 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j2 + "ms, closeTimeMillis: " + j3 + "ms");
            }
        }
    }

    public abstract void a(long j2);

    public void a(Configuration configuration) {
        if (u.a()) {
            u uVar = this.c;
            uVar.c("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public abstract void a(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void a(final com.applovin.impl.adview.m mVar, long j2, final Runnable runnable) {
        if (j2 < ((Long) this.b.a(com.applovin.impl.sdk.d.b.cn)).longValue()) {
            this.b.S().a(new z(this.b, new Runnable() {
                public void run() {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            q.a((View) mVar, 400, (Runnable) new Runnable() {
                                public void run() {
                                    mVar.bringToFront();
                                    runnable.run();
                                }
                            });
                        }
                    });
                }
            }), o.a.MAIN, TimeUnit.SECONDS.toMillis(j2), true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable, long j2) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j2, this.s);
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        if (this.a.W()) {
            a(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(final String str, long j2) {
        if (j2 >= 0) {
            a((Runnable) new Runnable() {
                public void run() {
                    com.applovin.impl.adview.d s;
                    if (StringUtils.isValidString(str) && a.this.f != null && (s = a.this.f.getController().s()) != null) {
                        s.a(str);
                    }
                }
            }, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        List<Uri> checkCachedResourcesExist = Utils.checkCachedResourcesExist(z2, this.a, this.b, this.e);
        if (checkCachedResourcesExist.isEmpty()) {
            return;
        }
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.eJ)).booleanValue()) {
            u uVar = this.c;
            uVar.e("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + checkCachedResourcesExist);
            com.applovin.impl.adview.o.a(this.a, this.o, "Missing ad resources", (Throwable) null, (AppLovinFullscreenActivity) null);
            h();
            return;
        }
        u uVar2 = this.c;
        uVar2.e("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + checkCachedResourcesExist);
        this.a.a();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, long j2) {
        if (this.a.U()) {
            a(z2 ? "javascript:al_mute();" : "javascript:al_unmute();", j2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(long j2) {
        if (u.a()) {
            u uVar = this.c;
            uVar.b("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j2) + " seconds...");
        }
        this.r = com.applovin.impl.sdk.utils.o.a(j2, this.b, new Runnable() {
            public void run() {
                if (!a.this.a.ag().getAndSet(true)) {
                    a.this.b.S().a((com.applovin.impl.sdk.f.a) new v(a.this.a, a.this.b), o.a.REWARD);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        a(str, 0);
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        a(z2, ((Long) this.b.a(com.applovin.impl.sdk.d.b.cD)).longValue());
        j.a(this.o, (AppLovinAd) this.a);
        this.b.ae().a((Object) this.a);
        this.b.ak().a((Object) this.a);
        if (this.a.hasVideoUrl() || t()) {
            j.a(this.p, (AppLovinAd) this.a);
        }
        new com.applovin.impl.adview.activity.b(this.e).a(this.a);
        this.d.a();
        this.a.setHasShown(true);
    }

    public void c(boolean z2) {
        if (u.a()) {
            u uVar = this.c;
            uVar.c("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z2);
        }
        a("javascript:al_onWindowFocusChanged( " + z2 + " );");
    }

    public abstract void d();

    public abstract void e();

    public void f() {
        if (u.a()) {
            this.c.c("AppLovinFullscreenActivity", "onResume()");
        }
        this.d.d(SystemClock.elapsedRealtime() - this.y);
        a("javascript:al_onAppResumed();");
        q();
        if (this.q.c()) {
            this.q.a();
        }
    }

    public void g() {
        if (u.a()) {
            this.c.c("AppLovinFullscreenActivity", "onPause()");
        }
        this.y = SystemClock.elapsedRealtime();
        a("javascript:al_onAppPaused();");
        if (this.q.c()) {
            this.q.a();
        }
        p();
    }

    public void h() {
        this.z = true;
        if (u.a()) {
            this.c.c("AppLovinFullscreenActivity", "dismiss()");
        }
        e eVar = this.a;
        if (eVar != null) {
            eVar.o().e();
        }
        this.s.removeCallbacksAndMessages((Object) null);
        a("javascript:al_onPoststitialDismiss();", (long) this.a.T());
        n();
        this.d.c();
        if (this.u != null) {
            com.applovin.impl.sdk.utils.o.a(TimeUnit.SECONDS.toMillis(2), this.b, new Runnable() {
                public void run() {
                    a.this.e.stopService(new Intent(a.this.e.getApplicationContext(), AppKilledService.class));
                    a.this.b.aj().unregisterReceiver(a.this.u);
                }
            });
        }
        if (this.v != null) {
            this.b.ai().b(this.v);
        }
        if (this.t != null) {
            this.b.af().b(this.t);
        }
        if (o()) {
            this.e.finish();
            return;
        }
        if (u.a()) {
            this.b.A().b("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        k();
    }

    public boolean i() {
        return this.z;
    }

    public void j() {
        if (u.a()) {
            this.c.c("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public void k() {
        AppLovinAdView appLovinAdView = this.f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f.destroy();
            this.f = null;
            if ((parent instanceof ViewGroup) && o()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        m();
        n();
        this.n = null;
        this.o = null;
        this.p = null;
        this.e = null;
    }

    public void l() {
        if (u.a()) {
            this.c.c("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.a.V()) {
            b("javascript:onBackPressed();");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void m();

    /* access modifiers changed from: protected */
    public void n() {
        if (this.x.compareAndSet(false, true)) {
            j.b(this.o, (AppLovinAd) this.a);
            this.b.ae().b((Object) this.a);
            this.b.ak().a();
        }
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return this.e instanceof AppLovinFullscreenActivity;
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.applovin.impl.sdk.utils.o oVar = this.r;
        if (oVar != null) {
            oVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.applovin.impl.sdk.utils.o oVar = this.r;
        if (oVar != null) {
            oVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public abstract boolean s();

    /* access modifiers changed from: protected */
    public boolean t() {
        return AppLovinAdType.INCENTIVIZED == this.a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.a.getType();
    }

    /* access modifiers changed from: protected */
    public abstract void u();
}
