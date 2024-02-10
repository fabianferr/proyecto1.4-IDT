package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: Sta */
public class sa implements Runnable {
    public NotDisplayedReason a = NotDisplayedReason.AD_CLOSED_TOO_QUICKLY;
    public JSONObject b;
    public a c;
    public final Handler d = new Handler(Looper.getMainLooper());
    public final WeakReference<View> e;
    public final k7 f;
    public final BannerOptions g;
    public boolean h = true;

    /* compiled from: Sta */
    public interface a {
    }

    public sa(View view, k7 k7Var, BannerOptions bannerOptions) {
        this.e = new WeakReference<>(view);
        this.f = k7Var;
        this.g = bannerOptions;
    }

    public void a() {
        NotDisplayedReason notDisplayedReason;
        try {
            k7 k7Var = this.f;
            if (!(k7Var == null || (notDisplayedReason = this.a) == null)) {
                k7Var.a(notDisplayedReason.toString(), this.b);
            }
            this.d.removeCallbacksAndMessages((Object) null);
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        k7 k7Var = this.f;
        return (k7Var == null || k7Var.a() || this.e.get() == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r0 = (com.startapp.sdk.ads.nativead.NativeAdDetails.e) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            boolean r0 = r5.b()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007c
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x0080 }
            r0.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.ref.WeakReference<android.view.View> r1 = r5.e     // Catch:{ all -> 0x0080 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0080 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0080 }
            com.startapp.sdk.ads.banner.BannerOptions r2 = r5.g     // Catch:{ all -> 0x0080 }
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r1 = com.startapp.ra.a((android.view.View) r1, (com.startapp.sdk.ads.banner.BannerOptions) r2, (java.util.concurrent.atomic.AtomicReference<org.json.JSONObject>) r0)     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0033
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r2 = r5.a     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0029
            int r2 = r2.a()     // Catch:{ all -> 0x0080 }
            int r3 = r1.a()     // Catch:{ all -> 0x0080 }
            if (r2 > r3) goto L_0x0033
        L_0x0029:
            r5.a = r1     // Catch:{ all -> 0x0080 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0080 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0080 }
            r5.b = r0     // Catch:{ all -> 0x0080 }
        L_0x0033:
            r0 = 0
            r2 = 1
            if (r1 != 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            if (r1 == 0) goto L_0x004f
            boolean r3 = r5.h     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x004f
            r5.h = r0     // Catch:{ all -> 0x0080 }
            com.startapp.k7 r0 = r5.f     // Catch:{ all -> 0x0080 }
            r0.c()     // Catch:{ all -> 0x0080 }
            com.startapp.sa$a r0 = r5.c     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0074
            r0.getClass()     // Catch:{ all -> 0x0080 }
            goto L_0x0074
        L_0x004f:
            if (r1 != 0) goto L_0x0074
            boolean r0 = r5.h     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0074
            r5.h = r2     // Catch:{ all -> 0x0080 }
            com.startapp.k7 r0 = r5.f     // Catch:{ all -> 0x0080 }
            r0.b()     // Catch:{ all -> 0x0080 }
            com.startapp.sa$a r0 = r5.c     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0074
            com.startapp.sdk.ads.nativead.NativeAdDetails$e r0 = (com.startapp.sdk.ads.nativead.NativeAdDetails.e) r0     // Catch:{ all -> 0x0080 }
            com.startapp.sdk.ads.nativead.NativeAdDetails r1 = com.startapp.sdk.ads.nativead.NativeAdDetails.this     // Catch:{ all -> 0x0080 }
            com.startapp.sdk.ads.nativead.NativeAdDisplayListener r3 = r1.j     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x0074
            boolean r4 = r1.e     // Catch:{ all -> 0x0080 }
            if (r4 != 0) goto L_0x0074
            r3.adHidden(r1)     // Catch:{ all -> 0x0080 }
            com.startapp.sdk.ads.nativead.NativeAdDetails r0 = com.startapp.sdk.ads.nativead.NativeAdDetails.this     // Catch:{ all -> 0x0080 }
            boolean unused = r0.e = r2     // Catch:{ all -> 0x0080 }
        L_0x0074:
            android.os.Handler r0 = r5.d     // Catch:{ all -> 0x0080 }
            r1 = 100
            r0.postDelayed(r5, r1)     // Catch:{ all -> 0x0080 }
            goto L_0x0087
        L_0x007c:
            r5.a()     // Catch:{ all -> 0x0080 }
            goto L_0x0087
        L_0x0080:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.INTERNAL_ERROR
            r5.a = r0
            r5.a()
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sa.run():void");
    }

    public sa(WeakReference<View> weakReference, k7 k7Var, BannerOptions bannerOptions) {
        this.e = weakReference;
        this.f = k7Var;
        this.g = bannerOptions;
    }
}
