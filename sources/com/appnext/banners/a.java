package com.appnext.banners;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.SettingsManager;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.d;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.j;
import com.appnext.core.p;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends BaseBannerAdapter {
    private final int TICK = 330;
    /* access modifiers changed from: private */
    public BannerAdRequest adRequest;
    /* access modifiers changed from: private */
    public ArrayList<AppnextAd> ads;
    /* access modifiers changed from: private */
    public BannerAd bannerAd;
    private boolean clickEnabled = true;
    /* access modifiers changed from: private */
    public BannerAdData currentAd;
    /* access modifiers changed from: private */
    public int currentPosition = 0;
    /* access modifiers changed from: private */
    public boolean finished = false;
    private int lastProgress = 0;
    /* access modifiers changed from: private */
    public boolean loaded = false;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public boolean reportedImpression = false;
    /* access modifiers changed from: private */
    public boolean started = false;
    /* access modifiers changed from: private */
    public String template = "";
    /* access modifiers changed from: private */
    public Runnable tick = new Runnable() {
        public final void run() {
            try {
                a.this.checkProgress();
                a aVar = a.this;
                aVar.currentPosition = aVar.mediaPlayer.getCurrentPosition();
                if (a.this.mediaPlayer.getCurrentPosition() < a.this.mediaPlayer.getDuration() && !a.this.finished) {
                    a.this.mHandler.postDelayed(a.this.tick, 330);
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("BannerAdapter$Runnable", th);
            }
        }
    };
    /* access modifiers changed from: private */
    public p userAction;
    /* access modifiers changed from: private */
    public boolean userMute = true;
    private VideoView videoView;

    public void init(ViewGroup viewGroup) {
        super.init(viewGroup);
        this.userAction = new p(this.context, new p.a() {
            public final void report(String str) {
                a.this.report(str);
            }

            public final Ad c() {
                return a.this.bannerAd;
            }

            public final AppnextAd d() {
                return a.this.getSelectedAd();
            }

            public final SettingsManager e() {
                return d.K();
            }
        });
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.appnext.core.Ad createAd(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            com.appnext.banners.BannerSize r0 = r5.getBannerSize()     // Catch:{ all -> 0x0056 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0056 }
            int r1 = r0.hashCode()     // Catch:{ all -> 0x0056 }
            r2 = -1966536496(0xffffffff8ac908d0, float:-1.9358911E-32)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0032
            r2 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
            if (r1 == r2) goto L_0x0028
            r2 = 1951953708(0x7458732c, float:6.859571E31)
            if (r1 == r2) goto L_0x001e
            goto L_0x003c
        L_0x001e:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x003c
            r0 = 0
            goto L_0x003d
        L_0x0028:
            java.lang.String r1 = "MEDIUM_RECTANGLE"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x0032:
            java.lang.String r1 = "LARGE_BANNER"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            if (r0 == 0) goto L_0x0050
            if (r0 == r4) goto L_0x004a
            if (r0 == r3) goto L_0x0044
            goto L_0x005c
        L_0x0044:
            com.appnext.banners.MediumRectangleAd r0 = new com.appnext.banners.MediumRectangleAd     // Catch:{ all -> 0x0056 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x004a:
            com.appnext.banners.LargeBannerAd r0 = new com.appnext.banners.LargeBannerAd     // Catch:{ all -> 0x0056 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0050:
            com.appnext.banners.SmallBannerAd r0 = new com.appnext.banners.SmallBannerAd     // Catch:{ all -> 0x0056 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0056:
            r0 = move-exception
            java.lang.String r1 = "BannerAdapter$createAd"
            com.appnext.base.a.a(r1, r0)
        L_0x005c:
            com.appnext.banners.SmallBannerAd r0 = new com.appnext.banners.SmallBannerAd
            r0.<init>(r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.createAd(android.content.Context, java.lang.String):com.appnext.core.Ad");
    }

    public void loadAd(BannerAdRequest bannerAdRequest) {
        try {
            if (!g.g(this.context)) {
                BannerListener bannerListener = getBannerListener();
                if (bannerListener != null) {
                    bannerListener.onError(new AppnextError(AppnextError.CONNECTION_ERROR));
                }
            } else if (bannerAdRequest == null) {
                throw new IllegalStateException("BannerAdRequest cannot be null.");
            } else if (getPlacementId() == null) {
                throw new IllegalStateException("Missing placement id.");
            } else if (getBannerSize() != null) {
                if (this.bannerAd == null) {
                    this.bannerAd = (BannerAd) createAd(this.context, getPlacementId());
                }
                this.bannerAd.setCategories(bannerAdRequest.getCategories());
                this.bannerAd.setSpecificCategories(bannerAdRequest.getSpecificCategories());
                this.bannerAd.setPostback(bannerAdRequest.getPostback());
                this.adRequest = new BannerAdRequest(bannerAdRequest);
                setClickEnabled(bannerAdRequest.isClickEnabled());
                this.loaded = false;
                this.reportedImpression = false;
                if (g.q(g.c(this.context)) == 0) {
                    this.adRequest.setCreativeType("static");
                }
                d.K().a(this.context, getPlacementId(), new SettingsManager.ConfigCallback() {
                    public final void loaded(HashMap<String, Object> hashMap) {
                        a.this.load();
                    }

                    public final void error(String str) {
                        a.this.load();
                    }
                });
            } else {
                throw new IllegalStateException("Missing banner size.");
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$loadAd", th);
        }
    }

    /* access modifiers changed from: private */
    public void load() {
        try {
            if (this.adRequest != null) {
                b.J().a(this.context, (Ad) this.bannerAd, getPlacementId(), (d.a) new d.a() {
                    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                    /* JADX WARNING: Removed duplicated region for block: B:45:0x0128 A[Catch:{ all -> 0x0088, all -> 0x01aa }] */
                    /* JADX WARNING: Removed duplicated region for block: B:50:0x0135 A[Catch:{ all -> 0x0088, all -> 0x01aa }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final <T> void a(T r14) {
                        /*
                            r13 = this;
                            java.lang.String r0 = "BannerAdapter$load"
                            com.appnext.banners.a r1 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerAdRequest r1 = r1.adRequest     // Catch:{ all -> 0x01aa }
                            if (r1 != 0) goto L_0x000b
                            return
                        L_0x000b:
                            com.appnext.banners.b r1 = com.appnext.banners.b.J()     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.content.Context r2 = r2.context     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r3 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerAd r3 = r3.bannerAd     // Catch:{ all -> 0x01aa }
                            r4 = r14
                            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r5 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerAdRequest r5 = r5.adRequest     // Catch:{ all -> 0x01aa }
                            java.lang.String r5 = r5.getCreativeType()     // Catch:{ all -> 0x01aa }
                            com.appnext.core.AppnextAd r1 = r1.a((android.content.Context) r2, (com.appnext.core.Ad) r3, (java.util.ArrayList<?>) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01aa }
                            if (r1 != 0) goto L_0x004c
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.String r1 = "error_no_ads"
                            r14.report(r1)     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerListener r14 = r14.getBannerListener()     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x004b
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerListener r14 = r14.getBannerListener()     // Catch:{ all -> 0x01aa }
                            com.appnext.core.AppnextError r1 = new com.appnext.core.AppnextError     // Catch:{ all -> 0x01aa }
                            java.lang.String r2 = "No Ads"
                            r1.<init>(r2)     // Catch:{ all -> 0x01aa }
                            r14.onError(r1)     // Catch:{ all -> 0x01aa }
                        L_0x004b:
                            return
                        L_0x004c:
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.view.ViewGroup r2 = r2.rootView     // Catch:{ all -> 0x01aa }
                            if (r2 != 0) goto L_0x0053
                            return
                        L_0x0053:
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.content.Context r2 = r2.context     // Catch:{ all -> 0x01aa }
                            if (r2 != 0) goto L_0x0061
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.view.ViewGroup r14 = r14.rootView     // Catch:{ all -> 0x01aa }
                            r14.removeAllViews()     // Catch:{ all -> 0x01aa }
                            return
                        L_0x0061:
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x0088 }
                            java.util.ArrayList r2 = r2.ads     // Catch:{ all -> 0x0088 }
                            if (r2 != 0) goto L_0x0073
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x0088 }
                            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0088 }
                            r3.<init>()     // Catch:{ all -> 0x0088 }
                            r2.ads = r3     // Catch:{ all -> 0x0088 }
                        L_0x0073:
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x0088 }
                            java.util.ArrayList r2 = r2.ads     // Catch:{ all -> 0x0088 }
                            r2.clear()     // Catch:{ all -> 0x0088 }
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x0088 }
                            java.util.ArrayList r2 = r2.ads     // Catch:{ all -> 0x0088 }
                            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x0088 }
                            r2.addAll(r14)     // Catch:{ all -> 0x0088 }
                            goto L_0x008c
                        L_0x0088:
                            r14 = move-exception
                            com.appnext.base.a.a(r0, r14)     // Catch:{ all -> 0x01aa }
                        L_0x008c:
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerAdData r2 = new com.appnext.banners.BannerAdData     // Catch:{ all -> 0x01aa }
                            r2.<init>(r1)     // Catch:{ all -> 0x01aa }
                            r14.currentAd = r2     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.d r14 = com.appnext.banners.d.K()     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerSize r2 = r2.getBannerSize()     // Catch:{ all -> 0x01aa }
                            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = r14.t(r2)     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = com.appnext.banners.f.a(r14)     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01aa }
                            java.lang.String r4 = "apnxt_"
                            r3.<init>(r4)     // Catch:{ all -> 0x01aa }
                            r3.append(r14)     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = r3.toString()     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x01aa }
                            r2.template = r14     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.view.ViewGroup r14 = r14.rootView     // Catch:{ all -> 0x01aa }
                            android.content.Context r14 = r14.getContext()     // Catch:{ all -> 0x01aa }
                            android.content.res.Resources r14 = r14.getResources()     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r2 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.String r2 = r2.template     // Catch:{ all -> 0x01aa }
                            java.lang.String r3 = "layout"
                            com.appnext.banners.a r4 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            android.content.Context r4 = r4.context     // Catch:{ all -> 0x01aa }
                            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x01aa }
                            int r14 = r14.getIdentifier(r2, r3, r4)     // Catch:{ all -> 0x01aa }
                            java.lang.String r2 = "BANNER"
                            java.lang.String r3 = "MEDIUM_RECTANGLE"
                            java.lang.String r4 = "LARGE_BANNER"
                            r5 = 1951953708(0x7458732c, float:6.859571E31)
                            r6 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
                            r7 = -1966536496(0xffffffff8ac908d0, float:-1.9358911E-32)
                            r8 = -1
                            r9 = 0
                            r10 = 2
                            r11 = 1
                            if (r14 != 0) goto L_0x0137
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerSize r14 = r14.getBannerSize()     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01aa }
                            int r12 = r14.hashCode()     // Catch:{ all -> 0x01aa }
                            if (r12 == r7) goto L_0x011d
                            if (r12 == r6) goto L_0x0115
                            if (r12 == r5) goto L_0x010d
                            goto L_0x0125
                        L_0x010d:
                            boolean r14 = r14.equals(r2)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x0125
                            r14 = 0
                            goto L_0x0126
                        L_0x0115:
                            boolean r14 = r14.equals(r3)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x0125
                            r14 = 2
                            goto L_0x0126
                        L_0x011d:
                            boolean r14 = r14.equals(r4)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x0125
                            r14 = 1
                            goto L_0x0126
                        L_0x0125:
                            r14 = -1
                        L_0x0126:
                            if (r14 == 0) goto L_0x0135
                            if (r14 == r11) goto L_0x0132
                            if (r14 == r10) goto L_0x012f
                            int r14 = com.appnext.banners.R.layout.apnxt_banner_1     // Catch:{ all -> 0x01aa }
                            goto L_0x0137
                        L_0x012f:
                            int r14 = com.appnext.banners.R.layout.apnxt_medium_rectangle_1     // Catch:{ all -> 0x01aa }
                            goto L_0x0137
                        L_0x0132:
                            int r14 = com.appnext.banners.R.layout.apnxt_large_banner_1     // Catch:{ all -> 0x01aa }
                            goto L_0x0137
                        L_0x0135:
                            int r14 = com.appnext.banners.R.layout.apnxt_banner_1     // Catch:{ all -> 0x01aa }
                        L_0x0137:
                            com.appnext.banners.a r12 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            r12.loaded = r11     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r12 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            r12.reportedImpression = r9     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r12 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            r12.inflateView(r14, r1)     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerListener r14 = r14.getBannerListener()     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x015f
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerListener r14 = r14.getBannerListener()     // Catch:{ all -> 0x01aa }
                            java.lang.String r12 = r1.getBannerID()     // Catch:{ all -> 0x01aa }
                            com.appnext.core.AppnextAdCreativeType r1 = r1.getCreativeType()     // Catch:{ all -> 0x01aa }
                            r14.onAdLoaded(r12, r1)     // Catch:{ all -> 0x01aa }
                        L_0x015f:
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            com.appnext.banners.BannerSize r14 = r14.getBannerSize()     // Catch:{ all -> 0x01aa }
                            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01aa }
                            int r1 = r14.hashCode()     // Catch:{ all -> 0x01aa }
                            if (r1 == r7) goto L_0x0184
                            if (r1 == r6) goto L_0x017c
                            if (r1 == r5) goto L_0x0174
                            goto L_0x018b
                        L_0x0174:
                            boolean r14 = r14.equals(r2)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x018b
                            r8 = 0
                            goto L_0x018b
                        L_0x017c:
                            boolean r14 = r14.equals(r3)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x018b
                            r8 = 2
                            goto L_0x018b
                        L_0x0184:
                            boolean r14 = r14.equals(r4)     // Catch:{ all -> 0x01aa }
                            if (r14 == 0) goto L_0x018b
                            r8 = 1
                        L_0x018b:
                            if (r8 == 0) goto L_0x01a2
                            if (r8 == r11) goto L_0x019a
                            if (r8 == r10) goto L_0x0192
                            goto L_0x0199
                        L_0x0192:
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.String r1 = "loaded_medium_rectangle"
                            r14.report(r1)     // Catch:{ all -> 0x01aa }
                        L_0x0199:
                            return
                        L_0x019a:
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.String r1 = "loaded_large_banner"
                            r14.report(r1)     // Catch:{ all -> 0x01aa }
                            goto L_0x01ae
                        L_0x01a2:
                            com.appnext.banners.a r14 = com.appnext.banners.a.this     // Catch:{ all -> 0x01aa }
                            java.lang.String r1 = "loaded_banner"
                            r14.report(r1)     // Catch:{ all -> 0x01aa }
                            goto L_0x01ae
                        L_0x01aa:
                            r14 = move-exception
                            com.appnext.base.a.a(r0, r14)
                        L_0x01ae:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.AnonymousClass17.a(java.lang.Object):void");
                    }

                    /* JADX WARNING: Can't fix incorrect switch cases order */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void error(java.lang.String r8) {
                        /*
                            r7 = this;
                            java.lang.String r0 = ""
                            int r1 = r8.hashCode()     // Catch:{ all -> 0x0086 }
                            r2 = 5
                            r3 = 4
                            r4 = 3
                            r5 = 2
                            r6 = 1
                            switch(r1) {
                                case -2026653947: goto L_0x0041;
                                case -1958363695: goto L_0x0037;
                                case -1477010874: goto L_0x002d;
                                case -507110949: goto L_0x0023;
                                case 350741825: goto L_0x0019;
                                case 844170097: goto L_0x000f;
                                default: goto L_0x000e;
                            }     // Catch:{ all -> 0x0086 }
                        L_0x000e:
                            goto L_0x004b
                        L_0x000f:
                            java.lang.String r1 = "Too Slow Connection"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 4
                            goto L_0x004c
                        L_0x0019:
                            java.lang.String r1 = "Timeout"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 5
                            goto L_0x004c
                        L_0x0023:
                            java.lang.String r1 = "No market installed on the device"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 3
                            goto L_0x004c
                        L_0x002d:
                            java.lang.String r1 = "Connection Error"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 0
                            goto L_0x004c
                        L_0x0037:
                            java.lang.String r1 = "No Ads"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 2
                            goto L_0x004c
                        L_0x0041:
                            java.lang.String r1 = "Internal error"
                            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x0086 }
                            if (r1 == 0) goto L_0x004b
                            r1 = 1
                            goto L_0x004c
                        L_0x004b:
                            r1 = -1
                        L_0x004c:
                            if (r1 == 0) goto L_0x0068
                            if (r1 == r6) goto L_0x0065
                            if (r1 == r5) goto L_0x0062
                            if (r1 == r4) goto L_0x005f
                            if (r1 == r3) goto L_0x005c
                            if (r1 == r2) goto L_0x0059
                            goto L_0x006a
                        L_0x0059:
                            java.lang.String r0 = "error_timeout"
                            goto L_0x006a
                        L_0x005c:
                            java.lang.String r0 = "error_slow_connection"
                            goto L_0x006a
                        L_0x005f:
                            java.lang.String r0 = "error_no_market"
                            goto L_0x006a
                        L_0x0062:
                            java.lang.String r0 = "error_no_ads"
                            goto L_0x006a
                        L_0x0065:
                            java.lang.String r0 = "error_internal_error"
                            goto L_0x006a
                        L_0x0068:
                            java.lang.String r0 = "error_connection_error"
                        L_0x006a:
                            com.appnext.banners.a r1 = com.appnext.banners.a.this     // Catch:{ all -> 0x0086 }
                            r1.report(r0)     // Catch:{ all -> 0x0086 }
                            com.appnext.banners.a r0 = com.appnext.banners.a.this     // Catch:{ all -> 0x0086 }
                            com.appnext.banners.BannerListener r0 = r0.getBannerListener()     // Catch:{ all -> 0x0086 }
                            if (r0 == 0) goto L_0x0085
                            com.appnext.banners.a r0 = com.appnext.banners.a.this     // Catch:{ all -> 0x0086 }
                            com.appnext.banners.BannerListener r0 = r0.getBannerListener()     // Catch:{ all -> 0x0086 }
                            com.appnext.core.AppnextError r1 = new com.appnext.core.AppnextError     // Catch:{ all -> 0x0086 }
                            r1.<init>(r8)     // Catch:{ all -> 0x0086 }
                            r0.onError(r1)     // Catch:{ all -> 0x0086 }
                        L_0x0085:
                            return
                        L_0x0086:
                            r8 = move-exception
                            java.lang.String r0 = "BannerAdapter$load"
                            com.appnext.base.a.a(r0, r8)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.AnonymousClass17.error(java.lang.String):void");
                    }
                }, this.adRequest);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$load", th);
        }
    }

    public void getECPM(final BannerAdRequest bannerAdRequest, final OnECPMLoaded onECPMLoaded) {
        if (bannerAdRequest != null) {
            try {
                if (getPlacementId() == null) {
                    throw new IllegalStateException("Missing placement id.");
                } else if (getBannerSize() == null) {
                    throw new IllegalStateException("Missing banner size.");
                } else if (onECPMLoaded != null) {
                    if (this.bannerAd == null) {
                        this.bannerAd = (BannerAd) createAd(this.context, getPlacementId());
                    }
                    this.bannerAd.setCategories(bannerAdRequest.getCategories());
                    this.bannerAd.setSpecificCategories(bannerAdRequest.getSpecificCategories());
                    this.bannerAd.setPostback(bannerAdRequest.getPostback());
                    b.J().a(this.context, (Ad) this.bannerAd, getPlacementId(), (d.a) new d.a() {
                        public final <T> void a(T t) {
                            AppnextAd a = b.J().a(a.this.context, (Ad) a.this.bannerAd, bannerAdRequest.getCreativeType());
                            if (a == null) {
                                a.this.report("error_no_ads");
                                OnECPMLoaded onECPMLoaded = onECPMLoaded;
                                if (onECPMLoaded != null) {
                                    onECPMLoaded.error(AppnextError.NO_ADS);
                                    return;
                                }
                                return;
                            }
                            OnECPMLoaded onECPMLoaded2 = onECPMLoaded;
                            if (onECPMLoaded2 != null) {
                                onECPMLoaded2.ecpm(new ECPM(a.getECPM(), a.getPPR(), a.getBannerID()));
                            }
                        }

                        public final void error(String str) {
                            OnECPMLoaded onECPMLoaded = onECPMLoaded;
                            if (onECPMLoaded != null) {
                                onECPMLoaded.error(str);
                            }
                        }
                    }, bannerAdRequest);
                } else {
                    throw new IllegalStateException("callback cannot be null.");
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("BannerAdapter$load", th);
            }
        } else {
            throw new IllegalStateException("BannerAdRequest cannot be null.");
        }
    }

    /* access modifiers changed from: protected */
    public void inflateView(int i, final AppnextAd appnextAd) {
        View inflate;
        RatingBar ratingBar;
        try {
            inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(i, this.rootView, false);
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.report("banner_click_else");
                    a.this.click();
                }
            });
            ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.report("banner_click_icon");
                        a.this.click();
                    }
                });
                j.Y().a(this.context, imageView, appnextAd.getImageURL(), (j.a) null);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(appnextAd.getAdTitle());
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.report("banner_click_else");
                        a.this.click();
                    }
                });
            }
            ratingBar = (RatingBar) inflate.findViewById(R.id.ratingBar);
            if (ratingBar != null) {
                ratingBar.setRating(Float.parseFloat(appnextAd.getStoreRating()));
                ratingBar.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.report("banner_click_else");
                        a.this.click();
                    }
                });
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$inflateView", th);
            return;
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.description);
        if (textView2 != null) {
            textView2.setText(appnextAd.getAdDescription());
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.report("banner_click_else");
                    a.this.click();
                }
            });
        }
        View findViewById = inflate.findViewById(R.id.install);
        ((TextView) findViewById).setText(getButtonText(appnextAd));
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.report("banner_click_cta");
                a.this.click();
            }
        });
        View findViewById2 = inflate.findViewById(R.id.media);
        if (findViewById2 != null) {
            if (getCreativeType(appnextAd) != 0) {
                createWideImage((ImageView) inflate.findViewById(R.id.wide_image));
            } else {
                createVideo((ViewGroup) findViewById2);
            }
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.privacy);
        imageView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.openLink(g.e(appnextAd));
            }
        });
        if (i.a(appnextAd, (SettingsManager) d.K())) {
            i.a(this.context, imageView2);
        }
        if (this.rootView != null && this.rootView.getChildCount() > 0) {
            this.rootView.removeViewAt(0);
        }
        this.rootView.addView(inflate);
    }

    /* access modifiers changed from: protected */
    public String getButtonText(AppnextAd appnextAd) {
        try {
            String buttonText = new BannerAdData(appnextAd).getButtonText();
            boolean b = g.b(this.context, getSelectedAd().getAdPackage());
            String str = "existing";
            if (appnextAd != null) {
                if (buttonText.equals("")) {
                    if (b) {
                        return com.appnext.core.a.a.n(this.context.getApplicationContext()).a(getLanguage(), str, d.K().t("existing_button_text"));
                    }
                    return com.appnext.core.a.a.n(this.context.getApplicationContext()).a(getLanguage(), "new", d.K().t("new_button_text"));
                }
            }
            com.appnext.core.a.a n = com.appnext.core.a.a.n(this.context.getApplicationContext());
            String language = getLanguage();
            if (!b) {
                str = "new";
            }
            return n.a(language, str, buttonText);
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$getButtonText", th);
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public int getCreativeType(AppnextAd appnextAd) {
        try {
            return this.adRequest.getCreativeType().equals("all") ? b.hasVideo(appnextAd) ? 0 : 1 : (!this.adRequest.getCreativeType().equals("video") || !b.hasVideo(appnextAd)) ? 1 : 0;
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$getCreativeType", th);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (getSelectedAd() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r4.mHandler.postDelayed(new com.appnext.banners.a.AnonymousClass5(r4), (long) (java.lang.Integer.parseInt(com.appnext.banners.d.K().t("postpone_impression_sec")) * 1000));
        report("impression_event");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (java.lang.Boolean.parseBoolean(com.appnext.banners.d.K().t("pview")) == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r4.mHandler.postDelayed(new com.appnext.banners.a.AnonymousClass6(r4), (long) (java.lang.Integer.parseInt(com.appnext.banners.d.K().t("postpone_vta_sec")) * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        if (getBannerListener() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        getBannerListener().adImpression();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void impression() {
        /*
            r4 = this;
            monitor-enter(r4)     // Catch:{ all -> 0x0082 }
            boolean r0 = r4.loaded     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x007d
            boolean r0 = r4.reportedImpression     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x007d
            com.appnext.core.p r0 = r4.userAction     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x000e
            goto L_0x007d
        L_0x000e:
            r0 = 1
            r4.reportedImpression = r0     // Catch:{ all -> 0x007f }
            com.appnext.core.n r0 = com.appnext.core.n.aa()     // Catch:{ all -> 0x007f }
            com.appnext.banners.a$4 r1 = new com.appnext.banners.a$4     // Catch:{ all -> 0x007f }
            r1.<init>()     // Catch:{ all -> 0x007f }
            r0.a(r1)     // Catch:{ all -> 0x007f }
            monitor-exit(r4)     // Catch:{ all -> 0x007f }
            com.appnext.banners.BannerAdData r0 = r4.getSelectedAd()     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x007c
            android.os.Handler r0 = r4.mHandler     // Catch:{ all -> 0x0082 }
            com.appnext.banners.a$5 r1 = new com.appnext.banners.a$5     // Catch:{ all -> 0x0082 }
            r1.<init>()     // Catch:{ all -> 0x0082 }
            com.appnext.banners.d r2 = com.appnext.banners.d.K()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "postpone_impression_sec"
            java.lang.String r2 = r2.t(r3)     // Catch:{ all -> 0x0082 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0082 }
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch:{ all -> 0x0082 }
            r0.postDelayed(r1, r2)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "impression_event"
            r4.report(r0)     // Catch:{ all -> 0x0082 }
            com.appnext.banners.d r0 = com.appnext.banners.d.K()     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = "pview"
            java.lang.String r0 = r0.t(r1)     // Catch:{ all -> 0x0082 }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x006f
            android.os.Handler r0 = r4.mHandler     // Catch:{ all -> 0x0082 }
            com.appnext.banners.a$6 r1 = new com.appnext.banners.a$6     // Catch:{ all -> 0x0082 }
            r1.<init>()     // Catch:{ all -> 0x0082 }
            com.appnext.banners.d r2 = com.appnext.banners.d.K()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "postpone_vta_sec"
            java.lang.String r2 = r2.t(r3)     // Catch:{ all -> 0x0082 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0082 }
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch:{ all -> 0x0082 }
            r0.postDelayed(r1, r2)     // Catch:{ all -> 0x0082 }
        L_0x006f:
            com.appnext.banners.BannerListener r0 = r4.getBannerListener()     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x007c
            com.appnext.banners.BannerListener r0 = r4.getBannerListener()     // Catch:{ all -> 0x0082 }
            r0.adImpression()     // Catch:{ all -> 0x0082 }
        L_0x007c:
            return
        L_0x007d:
            monitor-exit(r4)     // Catch:{ all -> 0x007f }
            return
        L_0x007f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0082 }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            java.lang.String r1 = "BannerAdapter$impression"
            com.appnext.base.a.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.impression():void");
    }

    public void click() {
        report("click_event");
        if (getBannerListener() != null) {
            getBannerListener().onAdClicked();
        }
        this.userAction.a(getSelectedAd(), getSelectedAd().getAppURL(), getPlacementId(), new f.a() {
            public final void error(String str) {
            }

            public final void onMarket(String str) {
                try {
                    if (a.this.mediaPlayer != null && a.this.mediaPlayer.isPlaying()) {
                        a.this.pause();
                        ((ImageView) a.this.rootView.findViewById(R.id.media).findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                        a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(0);
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("BannerAdapter$click", th);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void openLink(String str) {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                pause();
                ((ImageView) this.rootView.findViewById(R.id.media).findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(0);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$openLink", th);
        }
        try {
            super.openLink(str);
        } catch (Throwable th2) {
            com.appnext.base.a.a("BannerAdapter$openLink", th2);
            report("error_no_market");
        }
    }

    private void createWideImage(ImageView imageView) {
        report("static_creative");
        j.Y().a(this.context, imageView, getSelectedAd().getWideImageURL(), (j.a) null);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.report("banner_click_else");
                a.this.click();
            }
        });
    }

    private void createVideo(final ViewGroup viewGroup) {
        try {
            if (this.adRequest.isAutoPlay()) {
                report("auto_play_on");
            } else {
                report("auto_play_off");
            }
            if (this.adRequest.isMute()) {
                report("mute_on");
            } else {
                report("mute_off");
            }
            this.userMute = this.adRequest.isMute();
            ((ImageView) viewGroup.findViewById(R.id.mute)).setImageResource(this.userMute ? R.drawable.apnxt_banner_unmute : R.drawable.apnxt_banner_mute);
            viewGroup.findViewById(R.id.mute).setVisibility(0);
            viewGroup.findViewById(R.id.mute).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = a.this;
                    aVar.userMute = !aVar.userMute;
                    if (a.this.mediaPlayer != null) {
                        try {
                            MediaPlayer r5 = a.this.mediaPlayer;
                            float f = 0.0f;
                            float f2 = a.this.userMute ? 0.0f : 1.0f;
                            if (!a.this.userMute) {
                                f = 1.0f;
                            }
                            r5.setVolume(f2, f);
                            ((ImageView) viewGroup.findViewById(R.id.mute)).setImageResource(a.this.userMute ? R.drawable.apnxt_banner_unmute : R.drawable.apnxt_banner_mute);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            this.videoView = new VideoView(this.context.getApplicationContext());
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$createVideo", th);
            return;
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        viewGroup.addView(this.videoView, 0);
        viewGroup.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!a.this.isClickEnabled() || a.this.mediaPlayer == null || !a.this.mediaPlayer.isPlaying()) {
                    ((ImageView) viewGroup.findViewById(R.id.play)).setImageResource(R.drawable.apnxt_banner_pause);
                    viewGroup.findViewById(R.id.play).setVisibility(0);
                    a.this.pause();
                    return;
                }
                a.this.click();
            }
        });
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                a.this.mediaPlayer = mediaPlayer;
                a.this.mediaPlayer.seekTo(a.this.currentPosition);
                a.this.mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                    public final void onSeekComplete(MediaPlayer mediaPlayer) {
                        if (a.this.adRequest.isAutoPlay() && !a.this.finished && a.this.getVisiblePercent(a.this.rootView) > 90 && !a.this.mediaPlayer.isPlaying()) {
                            a.this.play();
                            try {
                                a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(8);
                            } catch (Throwable th) {
                                com.appnext.base.a.a("BannerAdapter$createVideo", th);
                            }
                            if (!a.this.started) {
                                a.this.report("video_started");
                                a.this.started = true;
                            }
                        }
                    }
                });
                if (a.this.adRequest.isAutoPlay() && !a.this.finished) {
                    a aVar = a.this;
                    if (aVar.getVisiblePercent(aVar.rootView) > 90) {
                        a.this.play();
                        try {
                            a.this.rootView.findViewById(R.id.media).findViewById(R.id.play).setVisibility(8);
                        } catch (Throwable th) {
                            com.appnext.base.a.a("BannerAdapter$createVideo", th);
                        }
                        if (!a.this.started) {
                            a.this.report("video_started");
                            a.this.started = true;
                        }
                    }
                }
                a.this.mHandler.postDelayed(a.this.tick, 33);
                if (a.this.userMute) {
                    a.this.mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    a.this.mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.mediaPlayer != null && a.this.mediaPlayer.getCurrentPosition() != 0 && a.this.mediaPlayer.getDuration() != 0 && !a.this.finished) {
                    a.this.mediaPlayer.getCurrentPosition();
                    a.this.mediaPlayer.getDuration();
                    a.this.finished = true;
                    a.this.report("video_ended");
                }
            }
        });
        this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return true;
            }
        });
        this.videoView.setVideoURI(Uri.parse(getVideoUrl(getSelectedAd(), this.adRequest.getVideoLength())));
        viewGroup.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                viewGroup.findViewById(R.id.wide_image).setVisibility(8);
                viewGroup.findViewById(R.id.play).setVisibility(8);
                a.this.play();
            }
        });
        if (!this.adRequest.isAutoPlay()) {
            viewGroup.findViewById(R.id.play).setVisibility(0);
            j.Y().a(this.context, (ImageView) viewGroup.findViewById(R.id.wide_image), getSelectedAd().getWideImageURL(), (j.a) null);
        }
    }

    /* access modifiers changed from: protected */
    public String getVideoUrl(AppnextAd appnextAd, String str) {
        if (str.equals("30")) {
            String videoUrl30Sec = appnextAd.getVideoUrl30Sec();
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrl();
            }
            if (videoUrl30Sec.equals("")) {
                videoUrl30Sec = appnextAd.getVideoUrlHigh30Sec();
            }
            if (videoUrl30Sec.equals("")) {
                return appnextAd.getVideoUrlHigh();
            }
            return videoUrl30Sec;
        }
        String videoUrl = appnextAd.getVideoUrl();
        if (videoUrl.equals("")) {
            videoUrl = appnextAd.getVideoUrl30Sec();
        }
        if (videoUrl.equals("")) {
            videoUrl = appnextAd.getVideoUrlHigh();
        }
        return videoUrl.equals("") ? appnextAd.getVideoUrlHigh30Sec() : videoUrl;
    }

    /* access modifiers changed from: private */
    public void checkProgress() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                int currentPosition2 = (int) ((((float) mediaPlayer2.getCurrentPosition()) / ((float) this.mediaPlayer.getDuration())) * 100.0f);
                if (currentPosition2 > 25 && this.lastProgress == 0) {
                    this.lastProgress = 25;
                    report("video_25");
                } else if (currentPosition2 > 50 && this.lastProgress == 25) {
                    this.lastProgress = 50;
                    report("video_50");
                } else if (currentPosition2 > 75 && this.lastProgress == 50) {
                    this.lastProgress = 75;
                    report("video_75");
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$checkProgress", th);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrollChanged(int r4) {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.mediaPlayer     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0065
            boolean r1 = r3.finished     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0065
            boolean r0 = r0.isPlaying()     // Catch:{ all -> 0x0066 }
            r1 = 90
            if (r0 == 0) goto L_0x0027
            if (r4 >= r1) goto L_0x0027
            android.view.ViewGroup r0 = r3.rootView     // Catch:{ all -> 0x0024 }
            int r2 = com.appnext.banners.R.id.media     // Catch:{ all -> 0x0024 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0024 }
            int r2 = com.appnext.banners.R.id.play     // Catch:{ all -> 0x0024 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0024 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r3.pause()     // Catch:{ all -> 0x0066 }
        L_0x0027:
            android.media.MediaPlayer r0 = r3.mediaPlayer     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isPlaying()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0065
            if (r4 <= r1) goto L_0x0065
            com.appnext.banners.BannerAdRequest r4 = r3.adRequest     // Catch:{ all -> 0x0066 }
            boolean r4 = r4.isAutoPlay()     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x0065
            android.media.MediaPlayer r4 = r3.mediaPlayer     // Catch:{ all -> 0x0066 }
            r4.getCurrentPosition()     // Catch:{ all -> 0x0066 }
            android.media.MediaPlayer r4 = r3.mediaPlayer     // Catch:{ all -> 0x0066 }
            r4.getDuration()     // Catch:{ all -> 0x0066 }
            r3.play()     // Catch:{ all -> 0x0066 }
            android.view.ViewGroup r4 = r3.rootView     // Catch:{ all -> 0x0059 }
            int r0 = com.appnext.banners.R.id.media     // Catch:{ all -> 0x0059 }
            android.view.View r4 = r4.findViewById(r0)     // Catch:{ all -> 0x0059 }
            int r0 = com.appnext.banners.R.id.play     // Catch:{ all -> 0x0059 }
            android.view.View r4 = r4.findViewById(r0)     // Catch:{ all -> 0x0059 }
            r0 = 8
            r4.setVisibility(r0)     // Catch:{ all -> 0x0059 }
        L_0x0059:
            boolean r4 = r3.started     // Catch:{ all -> 0x0066 }
            if (r4 != 0) goto L_0x0065
            java.lang.String r4 = "video_started"
            r3.report(r4)     // Catch:{ all -> 0x0066 }
            r4 = 1
            r3.started = r4     // Catch:{ all -> 0x0066 }
        L_0x0065:
            return
        L_0x0066:
            r4 = move-exception
            java.lang.String r0 = "BannerAdapter$onScrollChanged"
            com.appnext.base.a.a(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.a.onScrollChanged(int):void");
    }

    public void destroy() {
        super.destroy();
        try {
            p pVar = this.userAction;
            if (pVar != null) {
                pVar.destroy();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$destroy", th);
        }
        try {
            VideoView videoView2 = this.videoView;
            if (videoView2 != null) {
                videoView2.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                this.videoView.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                this.videoView.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                this.videoView.suspend();
                this.videoView = null;
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th2) {
            com.appnext.base.a.a("BannerAdapter$destroy", th2);
        }
        try {
            BannerAd bannerAd2 = this.bannerAd;
            if (bannerAd2 != null) {
                bannerAd2.destroy();
                this.bannerAd = null;
            }
        } catch (Throwable th3) {
            com.appnext.base.a.a("BannerAdapter$destroy", th3);
        }
        this.adRequest = null;
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
        } catch (Throwable th4) {
            com.appnext.base.a.a("BannerAdapter$destroy", th4);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public void play() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && !mediaPlayer2.isPlaying()) {
            this.mediaPlayer.start();
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
            this.mediaPlayer.pause();
        }
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        try {
            if (this.bannerAd != null) {
                Context context = this.context;
                String tid = this.bannerAd.getTID();
                String vid = this.bannerAd.getVID();
                String auid = this.bannerAd.getAUID();
                String str2 = "";
                String placementId = getPlacementId() == null ? str2 : getPlacementId();
                String sessionId = this.bannerAd.getSessionId();
                String str3 = this.template;
                String bannerID = getSelectedAd() != null ? getSelectedAd().getBannerID() : str2;
                if (getSelectedAd() != null) {
                    str2 = getSelectedAd().getCampaignID();
                }
                g.a(context, tid, vid, auid, placementId, sessionId, str, str3, bannerID, str2);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdapter$report", th);
        }
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public void setClickEnabled(boolean z) {
        this.clickEnabled = z;
    }

    /* access modifiers changed from: protected */
    public BannerAd getBannerAd() {
        return this.bannerAd;
    }

    /* access modifiers changed from: protected */
    public BannerAdData getSelectedAd() {
        return this.currentAd;
    }

    /* access modifiers changed from: protected */
    public void setSelectedAd(BannerAdData bannerAdData) {
        this.currentAd = bannerAdData;
    }

    /* access modifiers changed from: protected */
    public BannerAdRequest getAdRequest() {
        return this.adRequest;
    }

    /* access modifiers changed from: protected */
    public void setReportedImpression(boolean z) {
        this.reportedImpression = z;
    }

    /* access modifiers changed from: protected */
    public boolean isReportedImpression() {
        return this.reportedImpression;
    }

    /* access modifiers changed from: protected */
    public p getUserAction() {
        return this.userAction;
    }

    /* access modifiers changed from: protected */
    public ArrayList<AppnextAd> getAds() {
        return this.ads;
    }
}
