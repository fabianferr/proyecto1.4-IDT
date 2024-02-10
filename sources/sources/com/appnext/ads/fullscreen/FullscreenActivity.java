package com.appnext.ads.fullscreen;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.appnext.R;
import com.appnext.base.a;
import com.appnext.core.Ad;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.n;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class FullscreenActivity extends AppnextActivity implements h, i, j, f.a {
    private ArrayList<AppnextAd> ads;
    private boolean finished = false;
    private SettingsManager g;
    private boolean h = true;
    /* access modifiers changed from: private */
    public AppnextAd i;
    /* access modifiers changed from: private */
    public AppnextAd j;
    private HashMap<String, Integer> k;
    /* access modifiers changed from: private */
    public Video l;
    private int m = 0;
    private Handler mHandler;
    Runnable n = new Runnable() {
        public final void run() {
            if (FullscreenActivity.this.userAction != null) {
                FullscreenActivity.this.userAction.d(FullscreenActivity.this.i);
            }
            FullscreenActivity.this.report("impression_event", "S2");
        }
    };
    Runnable o = new Runnable() {
        public final void run() {
            FullscreenActivity fullscreenActivity = FullscreenActivity.this;
            fullscreenActivity.a(fullscreenActivity.i, (f.a) null);
            FullscreenActivity.this.report("vta_event", "S2");
        }
    };
    private int type;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:67|(1:69)|70|(1:72)|73|(3:78|(1:80)|81)(1:77)|82|83|84|85|86|87) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01ea */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            java.lang.String r0 = "multi"
            if (r9 == 0) goto L_0x001a
            java.lang.String r1 = "templates"
            java.io.Serializable r1 = r9.getSerializable(r1)     // Catch:{ all -> 0x0017 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x0017 }
            r8.k = r1     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = "state"
            int r1 = r9.getInt(r1)     // Catch:{ all -> 0x0017 }
            r8.m = r1     // Catch:{ all -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r9 = move-exception
            goto L_0x020d
        L_0x001a:
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ all -> 0x0017 }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x0017 }
            java.util.Locale r2 = new java.util.Locale     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "en"
            r2.<init>(r3)     // Catch:{ all -> 0x0017 }
            r1.setLayoutDirection(r2)     // Catch:{ all -> 0x0017 }
            android.content.res.Resources r2 = r8.getResources()     // Catch:{ all -> 0x0017 }
            android.content.res.Resources r3 = r8.getResources()     // Catch:{ all -> 0x0017 }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ all -> 0x0017 }
            r2.updateConfiguration(r1, r3)     // Catch:{ all -> 0x0017 }
            super.onCreate(r9)     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r1 = com.appnext.ads.fullscreen.Video.currentAd     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "No Ads"
            if (r1 != 0) goto L_0x004b
            r8.onError(r2)     // Catch:{ all -> 0x0017 }
            r8.finish()     // Catch:{ all -> 0x0017 }
            return
        L_0x004b:
            com.appnext.ads.fullscreen.Video r1 = com.appnext.ads.fullscreen.Video.currentAd     // Catch:{ all -> 0x0017 }
            boolean r1 = r1 instanceof com.appnext.ads.fullscreen.RewardedVideo     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x005d
            com.appnext.ads.fullscreen.RewardedVideo r1 = new com.appnext.ads.fullscreen.RewardedVideo     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r3 = com.appnext.ads.fullscreen.Video.currentAd     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.RewardedVideo r3 = (com.appnext.ads.fullscreen.RewardedVideo) r3     // Catch:{ all -> 0x0017 }
            r1.<init>((android.content.Context) r8, (com.appnext.ads.fullscreen.RewardedVideo) r3)     // Catch:{ all -> 0x0017 }
            r8.l = r1     // Catch:{ all -> 0x0017 }
            goto L_0x0068
        L_0x005d:
            com.appnext.ads.fullscreen.FullScreenVideo r1 = new com.appnext.ads.fullscreen.FullScreenVideo     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r3 = com.appnext.ads.fullscreen.Video.currentAd     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.FullScreenVideo r3 = (com.appnext.ads.fullscreen.FullScreenVideo) r3     // Catch:{ all -> 0x0017 }
            r1.<init>((android.content.Context) r8, (com.appnext.ads.fullscreen.FullScreenVideo) r3)     // Catch:{ all -> 0x0017 }
            r8.l = r1     // Catch:{ all -> 0x0017 }
        L_0x0068:
            com.appnext.ads.fullscreen.Video r1 = r8.b()     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = r1.getOrientation()     // Catch:{ all -> 0x0017 }
            int r3 = r1.hashCode()     // Catch:{ all -> 0x0017 }
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case 729267099: goto L_0x0099;
                case 1430647483: goto L_0x008f;
                case 1673671211: goto L_0x0085;
                case 2129065206: goto L_0x007b;
                default: goto L_0x007a;
            }     // Catch:{ all -> 0x0017 }
        L_0x007a:
            goto L_0x00a3
        L_0x007b:
            java.lang.String r3 = "not_set"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x00a3
            r1 = 0
            goto L_0x00a4
        L_0x0085:
            java.lang.String r3 = "automatic"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x00a3
            r1 = 1
            goto L_0x00a4
        L_0x008f:
            java.lang.String r3 = "landscape"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x00a3
            r1 = 2
            goto L_0x00a4
        L_0x0099:
            java.lang.String r3 = "portrait"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x00a3
            r1 = 3
            goto L_0x00a4
        L_0x00a3:
            r1 = -1
        L_0x00a4:
            r3 = 7
            r7 = 6
            if (r1 == 0) goto L_0x00b7
            if (r1 == r6) goto L_0x00b7
            if (r1 == r5) goto L_0x00b3
            if (r1 == r4) goto L_0x00af
            goto L_0x00ca
        L_0x00af:
            r8.setRequestedOrientation(r3)     // Catch:{ all -> 0x0017 }
            goto L_0x00ca
        L_0x00b3:
            r8.setRequestedOrientation(r7)     // Catch:{ all -> 0x0017 }
            goto L_0x00ca
        L_0x00b7:
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ all -> 0x0017 }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x0017 }
            int r1 = r1.orientation     // Catch:{ all -> 0x0017 }
            if (r1 != r5) goto L_0x00c7
            r8.setRequestedOrientation(r7)     // Catch:{ all -> 0x0017 }
            goto L_0x00ca
        L_0x00c7:
            r8.setRequestedOrientation(r3)     // Catch:{ all -> 0x0017 }
        L_0x00ca:
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x0017 }
            r1.<init>()     // Catch:{ all -> 0x0017 }
            r8.mHandler = r1     // Catch:{ all -> 0x0017 }
            android.content.Intent r1 = r8.getIntent()     // Catch:{ all -> 0x0017 }
            android.os.Bundle r1 = r1.getExtras()     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "id"
            java.lang.String r1 = r1.getString(r3)     // Catch:{ all -> 0x0017 }
            r8.placementID = r1     // Catch:{ all -> 0x0017 }
            android.content.Intent r1 = r8.getIntent()     // Catch:{ all -> 0x0017 }
            android.os.Bundle r1 = r1.getExtras()     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "type"
            int r1 = r1.getInt(r3)     // Catch:{ all -> 0x0017 }
            r8.type = r1     // Catch:{ all -> 0x0017 }
            if (r1 != r6) goto L_0x00fa
            com.appnext.ads.fullscreen.c r1 = com.appnext.ads.fullscreen.c.h()     // Catch:{ all -> 0x0017 }
            r8.g = r1     // Catch:{ all -> 0x0017 }
            goto L_0x0100
        L_0x00fa:
            com.appnext.ads.fullscreen.f r1 = com.appnext.ads.fullscreen.f.o()     // Catch:{ all -> 0x0017 }
            r8.g = r1     // Catch:{ all -> 0x0017 }
        L_0x0100:
            com.appnext.core.SettingsManager r1 = r8.g     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "can_close"
            java.lang.String r1 = r1.t(r3)     // Catch:{ all -> 0x0017 }
            boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch:{ all -> 0x0017 }
            r8.h = r1     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r1 = r8.b()     // Catch:{ all -> 0x0017 }
            boolean r1 = r1 instanceof com.appnext.ads.fullscreen.FullScreenVideo     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0122
            com.appnext.ads.fullscreen.Video r1 = r8.b()     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.FullScreenVideo r1 = (com.appnext.ads.fullscreen.FullScreenVideo) r1     // Catch:{ all -> 0x0017 }
            boolean r1 = r1.isBackButtonCanClose()     // Catch:{ all -> 0x0017 }
            r8.h = r1     // Catch:{ all -> 0x0017 }
        L_0x0122:
            java.lang.String r1 = ""
            if (r9 != 0) goto L_0x0146
            com.appnext.ads.fullscreen.b r3 = com.appnext.ads.fullscreen.b.f()     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r4 = r8.b()     // Catch:{ all -> 0x0017 }
            java.util.ArrayList r3 = r3.e(r4)     // Catch:{ all -> 0x0017 }
            r8.ads = r3     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x013d
            r8.onError(r2)     // Catch:{ all -> 0x0017 }
            r8.finish()     // Catch:{ all -> 0x0017 }
            return
        L_0x013d:
            java.lang.String r4 = r8.placementID     // Catch:{ all -> 0x0017 }
            com.appnext.core.AppnextAd r3 = r8.a(r3, r4, r1)     // Catch:{ all -> 0x0017 }
            r8.i = r3     // Catch:{ all -> 0x0017 }
            goto L_0x015a
        L_0x0146:
            java.lang.String r3 = "ads"
            java.io.Serializable r3 = r9.getSerializable(r3)     // Catch:{ all -> 0x0017 }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x0017 }
            r8.ads = r3     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "currentAd"
            java.io.Serializable r3 = r9.getSerializable(r3)     // Catch:{ all -> 0x0017 }
            com.appnext.core.AppnextAd r3 = (com.appnext.core.AppnextAd) r3     // Catch:{ all -> 0x0017 }
            r8.i = r3     // Catch:{ all -> 0x0017 }
        L_0x015a:
            com.appnext.core.AppnextAd r3 = r8.i     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0165
            r8.onError(r2)     // Catch:{ all -> 0x0017 }
            r8.finish()     // Catch:{ all -> 0x0017 }
            return
        L_0x0165:
            int r2 = com.appnext.R.layout.apnxt_video_activity     // Catch:{ all -> 0x0017 }
            r8.setContentView(r2)     // Catch:{ all -> 0x0017 }
            if (r9 != 0) goto L_0x01ee
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0017 }
            r9.<init>()     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.Video r2 = r8.b()     // Catch:{ all -> 0x0017 }
            boolean r2 = r2 instanceof com.appnext.ads.fullscreen.RewardedVideo     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0183
            com.appnext.ads.fullscreen.Video r1 = r8.b()     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.RewardedVideo r1 = (com.appnext.ads.fullscreen.RewardedVideo) r1     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = r1.getMode()     // Catch:{ all -> 0x0017 }
        L_0x0183:
            java.lang.String r2 = "default"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0195
            com.appnext.core.SettingsManager r1 = r8.getConfig()     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "default_mode"
            java.lang.String r1 = r1.t(r2)     // Catch:{ all -> 0x0017 }
        L_0x0195:
            int r2 = r8.type     // Catch:{ all -> 0x0017 }
            if (r2 != r5) goto L_0x01b7
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x01b7
            com.appnext.ads.fullscreen.e r1 = new com.appnext.ads.fullscreen.e     // Catch:{ all -> 0x0017 }
            r1.<init>()     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "time"
            com.appnext.ads.fullscreen.Video r3 = r8.b()     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.RewardedVideo r3 = (com.appnext.ads.fullscreen.RewardedVideo) r3     // Catch:{ all -> 0x0017 }
            int r3 = r3.getMultiTimerLength()     // Catch:{ all -> 0x0017 }
            r9.putInt(r2, r3)     // Catch:{ all -> 0x0017 }
            r8.report(r0)     // Catch:{ all -> 0x0017 }
            goto L_0x01d4
        L_0x01b7:
            int r0 = r8.type     // Catch:{ all -> 0x0017 }
            if (r0 != r5) goto L_0x01c0
            java.lang.String r0 = "normal"
            r8.report(r0)     // Catch:{ all -> 0x0017 }
        L_0x01c0:
            com.appnext.ads.fullscreen.g r1 = new com.appnext.ads.fullscreen.g     // Catch:{ all -> 0x0017 }
            r1.<init>()     // Catch:{ all -> 0x0017 }
            java.lang.String r0 = "showCta"
            com.appnext.ads.fullscreen.Video r2 = r8.b()     // Catch:{ all -> 0x0017 }
            boolean r2 = r2.isShowCta()     // Catch:{ all -> 0x0017 }
            r9.putBoolean(r0, r2)     // Catch:{ all -> 0x0017 }
            r8.m = r6     // Catch:{ all -> 0x0017 }
        L_0x01d4:
            r1.setArguments(r9)     // Catch:{ all -> 0x0017 }
            android.app.FragmentManager r9 = r8.getFragmentManager()     // Catch:{ all -> 0x0017 }
            android.app.FragmentTransaction r9 = r9.beginTransaction()     // Catch:{ all -> 0x0017 }
            int r0 = com.appnext.R.id.ll     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = "fragment"
            r9.add(r0, r1, r2)     // Catch:{ all -> 0x0017 }
            r9.commit()     // Catch:{ Exception -> 0x01ea }
            goto L_0x01f6
        L_0x01ea:
            r8.finish()     // Catch:{ all -> 0x0017 }
            return
        L_0x01ee:
            java.lang.String r0 = "finished"
            boolean r9 = r9.getBoolean(r0, r6)     // Catch:{ all -> 0x0017 }
            r8.finished = r9     // Catch:{ all -> 0x0017 }
        L_0x01f6:
            int r9 = com.appnext.R.id.ll     // Catch:{ all -> 0x0017 }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ all -> 0x0017 }
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9     // Catch:{ all -> 0x0017 }
            r8.cv = r9     // Catch:{ all -> 0x0017 }
            com.appnext.core.p r9 = new com.appnext.core.p     // Catch:{ all -> 0x0017 }
            com.appnext.ads.fullscreen.FullscreenActivity$1 r0 = new com.appnext.ads.fullscreen.FullscreenActivity$1     // Catch:{ all -> 0x0017 }
            r0.<init>()     // Catch:{ all -> 0x0017 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x0017 }
            r8.userAction = r9     // Catch:{ all -> 0x0017 }
            return
        L_0x020d:
            java.lang.String r0 = "FullscreenActivity$onCreate"
            com.appnext.base.a.a(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.fullscreen.FullscreenActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public final void onError(String str) {
        OnAdError onAdErrorCallback;
        try {
            if (b() != null && (onAdErrorCallback = b().getOnAdErrorCallback()) != null) {
                onAdErrorCallback.adError(str);
            }
        } catch (Throwable th) {
            a.a("FullscreenActivity$onError", th);
        }
    }

    /* access modifiers changed from: protected */
    public final SettingsManager getConfig() {
        if (this.g == null) {
            if (this.type == 1) {
                this.g = c.h();
            } else {
                this.g = f.o();
            }
        }
        return this.g;
    }

    /* access modifiers changed from: protected */
    public final void a(AppnextAd appnextAd, f.a aVar) {
        super.a(appnextAd, (f.a) new f.a() {
            public final void error(String str) {
            }

            public final void onMarket(String str) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("finished", this.finished);
        bundle.putInt("type", this.type);
        bundle.putSerializable("templates", this.k);
        bundle.putSerializable(CampaignUnit.JSON_KEY_ADS, this.ads);
        bundle.putInt("state", this.m);
        bundle.putSerializable("currentAd", this.i);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.finished = bundle.getBoolean("finished", true);
        this.type = bundle.getInt("type");
        this.k = (HashMap) bundle.getSerializable("templates");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.n);
        this.mHandler.removeCallbacks(this.o);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 2 | 4 | 4096);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            g.a(new File(getFilesDir().getAbsolutePath() + "/data/appnext/videos/tmp/vid" + b().rnd + "/"));
        } catch (Throwable th) {
            a.a("FullscreenActivity$onDestroy", th);
        }
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.mHandler = null;
            this.j = null;
            this.i = null;
        } catch (Throwable th2) {
            a.a("FullscreenActivity$onDestroy", th2);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(AppnextAd appnextAd, f.a aVar) {
        OnAdClicked onAdClickedCallback;
        if (appnextAd != null) {
            this.j = appnextAd;
            Video b = b();
            if (!(b == null || (onAdClickedCallback = b.getOnAdClickedCallback()) == null)) {
                onAdClickedCallback.adClicked();
            }
            if (this.finished || !(b() instanceof RewardedVideo)) {
                super.b(appnextAd, aVar);
            }
        }
    }

    public void onMarket(String str) {
        S();
        this.finished = true;
        Collections.shuffle(this.ads, new Random(System.nanoTime()));
        this.ads.remove(this.i);
        this.ads.add(0, this.i);
        d dVar = new d();
        this.m = 2;
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll, dVar, "fragment");
        try {
            beginTransaction.commit();
        } catch (Throwable th) {
            a.a("FullscreenActivity$onMarket", th);
            finish();
        }
    }

    public void error(String str) {
        S();
        report("error_resolve_timeout");
    }

    private void a() {
        OnAdClosed onAdClosedCallback;
        try {
            b.f().a((Context) this, this.i.getBannerID(), (Ad) b());
            if (!(b() == null || (onAdClosedCallback = b().getOnAdClosedCallback()) == null)) {
                onAdClosedCallback.onAdClosed();
            }
            Video.currentAd = null;
        } catch (Throwable th) {
            a.a("FullscreenActivity$onClose", th);
        }
    }

    public void videoStarted() {
        OnAdOpened onAdOpenedCallback;
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    if (FullscreenActivity.this.i != null && FullscreenActivity.this.l != null) {
                        com.appnext.core.adswatched.a.l(FullscreenActivity.this).j(FullscreenActivity.this.i.getBannerID(), FullscreenActivity.this.l.getAUID());
                    }
                } catch (Throwable unused) {
                }
            }
        });
        this.mHandler.postDelayed(this.n, Long.parseLong(this.g.t("postpone_impression_sec")) * 1000);
        if (Boolean.parseBoolean(this.g.t("pview"))) {
            this.mHandler.postDelayed(this.o, Long.parseLong(this.g.t("postpone_vta_sec")) * 1000);
        }
        if (b() != null && (onAdOpenedCallback = b().getOnAdOpenedCallback()) != null) {
            onAdOpenedCallback.adOpened();
        }
    }

    public void videoEnded() {
        this.m = 2;
        this.finished = true;
        if (!(b() == null || b().getOnVideoEndedCallback() == null)) {
            b().getOnVideoEndedCallback().videoEnded();
        }
        n.aa().a(new Runnable() {
            public final void run() {
                RewardedServerSidePostback rewardedServerSidePostback;
                if ((FullscreenActivity.this.b() instanceof RewardedVideo) && (rewardedServerSidePostback = ((RewardedVideo) FullscreenActivity.this.b()).getRewardedServerSidePostback()) != null) {
                    HashMap<String, String> n = rewardedServerSidePostback.n();
                    n.put("placementId", FullscreenActivity.this.placementID);
                    try {
                        g.a(FullscreenActivity.this, "https://admin.appnext.com/adminService.asmx/SetRewards", n);
                    } catch (IOException unused) {
                    }
                }
            }
        });
        Collections.shuffle(this.ads, new Random(System.nanoTime()));
        this.ads.remove(this.i);
        this.ads.add(0, this.i);
        d dVar = new d();
        this.m = 2;
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll, dVar, "fragment");
        try {
            beginTransaction.commit();
            AppnextAd appnextAd = this.j;
            if (appnextAd != null) {
                super.b(appnextAd, this);
                report("roll_store_opened");
                return;
            }
            report("roll_click_cta_none");
            if (Integer.parseInt(getConfig().t("clickType_b")) > new Random(System.nanoTime()).nextInt(100)) {
                installClicked(getSelectedAd());
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public void videoSelected(AppnextAd appnextAd) {
        this.i = appnextAd;
        g gVar = new g();
        FragmentManager fragmentManager = getFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putBoolean("showCta", b().isShowCta());
        gVar.setArguments(bundle);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.ll, gVar, "fragment");
        try {
            beginTransaction.commit();
        } catch (Throwable th) {
            a.a("FullscreenActivity$videoSelected", th);
            finish();
        }
    }

    public ArrayList<AppnextAd> getPreRollAds() {
        if (this.ads == null) {
            this.ads = b.f().e(b());
        }
        ArrayList<AppnextAd> arrayList = new ArrayList<>();
        AppnextAd a = a(this.ads, this.placementID, "");
        arrayList.add(a);
        AppnextAd a2 = a(this.ads, this.placementID, a.getBannerID());
        if (a2 != null && !a2.getBannerID().equals(arrayList.get(0).getBannerID())) {
            arrayList.add(a2);
        }
        return arrayList;
    }

    public void privacyClicked() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(g.e(this.i)));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Throwable th) {
            a.a("FullscreenActivity$privacyClicked", th);
        }
    }

    public void installClicked(AppnextAd appnextAd) {
        if (this.m == 1 && !isRewarded()) {
            a((ViewGroup) this.cv, getResources().getDrawable(R.drawable.apnxt_loader));
        }
        b(appnextAd, this);
    }

    public void closeClicked() {
        try {
            if (this.m != 1 || isRewarded() || Integer.parseInt(getConfig().t("clickType_a")) <= new Random(System.nanoTime()).nextInt(100)) {
                a();
                finish();
                return;
            }
            installClicked(getSelectedAd());
        } catch (Throwable th) {
            a.a("FullscreenActivity$closeClicked", th);
        }
    }

    public AppnextAd getSelectedAd() {
        return this.i;
    }

    public boolean showClose() {
        return (b() instanceof FullScreenVideo) && ((FullScreenVideo) b()).isShowClose();
    }

    public SettingsManager getConfigManager() {
        return getConfig();
    }

    public int getTemplate(String str) {
        if (this.k == null) {
            this.k = new HashMap<>();
        }
        if (!this.k.containsKey(str)) {
            String a = com.appnext.ads.a.a(getConfig().t(str));
            Resources resources = getResources();
            int identifier = resources.getIdentifier("apnxt_" + a, "layout", getPackageName());
            if (identifier == 0) {
                Resources resources2 = getResources();
                identifier = resources2.getIdentifier("apnxt_" + str.toLowerCase() + "t1", "layout", getPackageName());
            }
            this.k.put(str, Integer.valueOf(identifier));
        }
        return this.k.get(str).intValue();
    }

    public boolean getMute() {
        return b().getMute();
    }

    public void report(String str, String str2) {
        a(str, getResources().getResourceEntryName(getTemplate(str2)));
    }

    public ArrayList<AppnextAd> getPostRollAds() {
        return this.ads;
    }

    public boolean isRewarded() {
        return b() instanceof RewardedVideo;
    }

    public String getLanguage() {
        return this.l.getLanguage();
    }

    public String getCtaText() {
        try {
            String buttonText = new FullscreenAd(this.i).getButtonText();
            String str = "existing";
            if (this.i != null) {
                if (buttonText.equals("")) {
                    if (isInstalled()) {
                        return com.appnext.core.a.a.n(this).a(this.l.getLanguage(), str, "Open");
                    }
                    return com.appnext.core.a.a.n(this).a(this.l.getLanguage(), "new", "Install");
                }
            }
            com.appnext.core.a.a n2 = com.appnext.core.a.a.n(this);
            String language = this.l.getLanguage();
            if (!isInstalled()) {
                str = "new";
            }
            return n2.a(language, str, buttonText);
        } catch (Throwable th) {
            a.a("FullscreenActivity$getCtaText", th);
            return "";
        }
    }

    public boolean isInstalled() {
        try {
            return g.b((Context) this, this.i.getAdPackage());
        } catch (Throwable unused) {
            return false;
        }
    }

    public int getCaptionTextTime() {
        try {
            return b().getRollCaptionTime();
        } catch (Throwable th) {
            a.a("FullscreenActivity$getCaptionTextTime", th);
            return 0;
        }
    }

    public long closeDelay() {
        try {
            if (b() instanceof FullScreenVideo) {
                return ((FullScreenVideo) b()).getCloseDelay();
            }
            return 0;
        } catch (Throwable th) {
            a.a("FullscreenActivity$closeDelay", th);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(ArrayList<AppnextAd> arrayList, String str, String str2) {
        try {
            Iterator<AppnextAd> it = arrayList.iterator();
            while (it.hasNext()) {
                AppnextAd next = it.next();
                if (a(next)) {
                    next.getBannerID();
                    if (!next.getBannerID().equals(str2)) {
                        return next;
                    }
                }
            }
            Iterator<AppnextAd> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                AppnextAd next2 = it2.next();
                if (a(next2)) {
                    next2.getBannerID();
                    return next2;
                }
            }
            return null;
        } catch (Throwable th) {
            a.a("FullscreenActivity$getFirst", th);
            return null;
        }
    }

    private static boolean a(AppnextAd appnextAd) {
        try {
            return !appnextAd.getVideoUrlHigh().equals("") || !appnextAd.getVideoUrlHigh30Sec().equals("");
        } catch (Throwable th) {
            a.a("FullscreenActivity$hasHiResVideo", th);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        try {
            Resources resources = getResources();
            a(str, resources.getResourceEntryName(getTemplate(ExifInterface.LATITUDE_SOUTH + (this.m + 1))));
        } catch (Throwable th) {
            a.a("FullscreenActivity$report", th);
        }
    }

    private void a(String str, String str2) {
        try {
            String tid = b().getTID();
            String vid = b().getVID();
            String auid = b().getAUID();
            String str3 = this.placementID;
            String sessionId = b().getSessionId();
            AppnextAd appnextAd = this.i;
            String bannerID = appnextAd != null ? appnextAd.getBannerID() : "";
            AppnextAd appnextAd2 = this.i;
            g.a(this, tid, vid, auid, str3, sessionId, str, str2, bannerID, appnextAd2 != null ? appnextAd2.getCampaignID() : "");
        } catch (Throwable th) {
            a.a("FullscreenActivity$sendReport", th);
        }
    }

    /* access modifiers changed from: private */
    public Video b() {
        if (Video.currentAd != null) {
            return Video.currentAd;
        }
        return this.l;
    }

    public void onBackPressed() {
        if (b().isBackButtonCanClose()) {
            a();
            super.onBackPressed();
        }
    }

    public Uri getSelectedVideoUri() {
        String str;
        String videoUrl = b.getVideoUrl(this.i, b().getVideoLength());
        String b = b.b(videoUrl);
        if (Video.getCacheVideo()) {
            str = getFilesDir().getAbsolutePath() + "/data/appnext/videos/";
        } else {
            str = getFilesDir().getAbsolutePath() + "/data/appnext/videos/tmp/vid" + b().rnd + "/";
        }
        File file = new File(str + b);
        if (file.exists()) {
            Uri parse = Uri.parse(str + b);
            parse.getPath();
            return parse;
        }
        Uri parse2 = Uri.parse(videoUrl);
        file.getAbsolutePath();
        return parse2;
    }
}
