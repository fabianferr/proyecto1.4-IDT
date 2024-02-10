package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;

/* compiled from: Sta */
public class i implements Runnable {
    public final /* synthetic */ AdDisplayListener a;
    public final /* synthetic */ Ad b;

    public i(AdDisplayListener adDisplayListener, Ad ad, Context context) {
        this.a = adDisplayListener;
        this.b = ad;
    }

    public void run() {
        try {
            this.a.adClicked(this.b);
        } catch (Throwable th) {
            k9.a((Object) this.a, th);
        }
    }
}
