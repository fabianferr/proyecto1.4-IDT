package com.startapp;

import android.content.Context;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerListener;

/* compiled from: Sta */
public class n0 implements Runnable {
    public final /* synthetic */ BannerListener a;
    public final /* synthetic */ View b;

    public n0(BannerListener bannerListener, View view, Context context) {
        this.a = bannerListener;
        this.b = view;
    }

    public void run() {
        try {
            this.a.onImpression(this.b);
        } catch (Throwable th) {
            k9.a((Object) this.a, th);
        }
    }
}
