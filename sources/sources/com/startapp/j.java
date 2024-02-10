package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

/* compiled from: Sta */
public class j {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ AdDisplayListener a;
        public final /* synthetic */ Ad b;

        public a(AdDisplayListener adDisplayListener, Ad ad, Context context) {
            this.a = adDisplayListener;
            this.b = ad;
        }

        public void run() {
            try {
                this.a.adNotDisplayed(this.b);
            } catch (Throwable th) {
                k9.a((Object) this.a, th);
            }
        }
    }

    public static void a(Context context, AdDisplayListener adDisplayListener, Ad ad) {
        a aVar = null;
        d2.a("adNotDisplayed", adDisplayListener != null, (String) null, ad != null ? ad.getErrorMessage() : null);
        if (adDisplayListener != null) {
            aVar = new a(adDisplayListener, ad, context);
        }
        com.startapp.sdk.adsbase.a.a((Runnable) aVar);
    }
}
