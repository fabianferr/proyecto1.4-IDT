package com.applovin.impl.mediation.b.a;

import android.content.Context;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.LinkedList;
import java.util.Queue;

public class b extends MaxNativeAdListener implements MaxAdRevenueListener {
    private final int a;
    private final MaxNativeAdLoader b;
    private final Queue<MaxAd> c = new LinkedList();
    private boolean d = false;
    private final Object e = new Object();
    private a f;

    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public b(String str, int i, Context context, a aVar) {
        this.a = i;
        this.f = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(str, context);
        this.b = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
    }

    public void a() {
        this.f = null;
        e();
        this.b.destroy();
    }

    public void a(MaxAd maxAd) {
        this.b.destroy(maxAd);
    }

    public boolean a(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.b.render(maxNativeAdView, maxAd);
    }

    public boolean b() {
        boolean z;
        synchronized (this.e) {
            z = !this.c.isEmpty();
        }
        return z;
    }

    public void c() {
        synchronized (this.e) {
            if (!this.d && this.c.size() < this.a) {
                this.d = true;
                this.b.loadAd();
            }
        }
    }

    public MaxAd d() {
        MaxAd remove;
        synchronized (this.e) {
            remove = this.c.remove();
            c();
        }
        return remove;
    }

    public void e() {
        synchronized (this.e) {
            for (MaxAd a2 : this.c) {
                a(a2);
            }
            this.c.clear();
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.e) {
            this.c.add(maxAd);
            this.d = false;
            c();
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }
}
