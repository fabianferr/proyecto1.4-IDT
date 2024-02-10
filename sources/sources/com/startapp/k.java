package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

/* compiled from: Sta */
public class k {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ AdEventListener a;
        public final /* synthetic */ Ad b;

        public a(AdEventListener adEventListener, Ad ad, Context context) {
            this.a = adEventListener;
            this.b = ad;
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
        public final /* synthetic */ AdEventListener a;
        public final /* synthetic */ Ad b;

        public b(AdEventListener adEventListener, Ad ad, Context context) {
            this.a = adEventListener;
            this.b = ad;
        }

        public void run() {
            try {
                this.a.onFailedToReceiveAd(this.b);
            } catch (Throwable th) {
                k9.a((Object) this.a, th);
            }
        }
    }

    public static void a(Context context, AdEventListener adEventListener, Ad ad, boolean z) {
        b bVar = null;
        if (!z) {
            d2.a("onLoadFailed", adEventListener != null, (String) null, ad != null ? ad.getErrorMessage() : null);
        }
        if (adEventListener != null) {
            bVar = new b(adEventListener, ad, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) bVar);
    }

    public static void b(Context context, AdEventListener adEventListener, Ad ad, boolean z) {
        a aVar = null;
        if (!z) {
            d2.a("onLoad", adEventListener != null, (String) null, (String) null);
        }
        if (adEventListener != null) {
            aVar = new a(adEventListener, ad, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) aVar);
    }
}
