package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

/* compiled from: Sta */
public class m0 {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ BannerListener a;
        public final /* synthetic */ View b;

        public a(BannerListener bannerListener, View view, Context context) {
            this.a = bannerListener;
            this.b = view;
        }

        public void run() {
            try {
                this.a.onReceiveAd(this.b);
            } catch (Throwable th) {
                k9.a((Object) this.a, th);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public final /* synthetic */ BannerListener a;
        public final /* synthetic */ View b;

        public b(BannerListener bannerListener, View view, Context context) {
            this.a = bannerListener;
            this.b = view;
        }

        public void run() {
            try {
                this.a.onFailedToReceiveAd(this.b);
            } catch (Throwable th) {
                k9.a((Object) this.a, th);
            }
        }
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public final /* synthetic */ BannerListener a;
        public final /* synthetic */ View b;

        public c(BannerListener bannerListener, View view, Context context) {
            this.a = bannerListener;
            this.b = view;
        }

        public void run() {
            try {
                this.a.onClick(this.b);
            } catch (Throwable th) {
                k9.a((Object) this.a, th);
            }
        }
    }

    public static void a(Context context, BannerListener bannerListener, View view, String str) {
        c cVar = null;
        d2.a("onClicked", bannerListener != null, str, (String) null);
        if (bannerListener != null) {
            cVar = new c(bannerListener, view, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) cVar);
    }

    public static void b(Context context, BannerListener bannerListener, View view, String str) {
        b bVar = null;
        d2.a("onLoadFailed", bannerListener != null, str, (String) null);
        if (bannerListener != null) {
            bVar = new b(bannerListener, view, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) bVar);
    }

    public static void c(Context context, BannerListener bannerListener, View view, String str) {
        a aVar = null;
        d2.a("onLoad", bannerListener != null, str, (String) null);
        if (bannerListener != null) {
            aVar = new a(bannerListener, view, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) aVar);
    }
}
