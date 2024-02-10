package com.ironsource.adapters.ironsource;

import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.sdk.a;
import com.ironsource.sdk.j.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class IronSourceBannerListener implements b {
    private WeakReference<IronSourceAdapter> mAdapter;
    private final String mDemandSourceName;
    private final BannerSmashListener mListener;

    IronSourceBannerListener(IronSourceAdapter ironSourceAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mDemandSourceName = str;
        this.mListener = bannerSmashListener;
        this.mAdapter = new WeakReference<>(ironSourceAdapter);
    }

    public void onBannerClick() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerAdClicked();
    }

    public void onBannerInitFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
    }

    public void onBannerInitSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
    }

    public void onBannerLoadFail(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        BannerSmashListener bannerSmashListener = this.mListener;
        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("load failed - error = " + str));
    }

    public void onBannerLoadSuccess(com.ironsource.sdk.b bVar, com.ironsource.sdk.c.b bVar2) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        if (this.mAdapter.get() == null) {
            return;
        }
        if (bVar2 == null) {
            this.mListener.onBannerAdLoadFailed(ErrorBuilder.adContainerIsNull(((IronSourceAdapter) this.mAdapter.get()).getProviderName()));
            return;
        }
        ConcurrentHashMap<String, ArrayList<com.ironsource.sdk.b>> concurrentHashMap = ((IronSourceAdapter) this.mAdapter.get()).mDemandSourceToBnAd;
        if (concurrentHashMap.get(this.mDemandSourceName) == null) {
            concurrentHashMap.put(this.mDemandSourceName, new ArrayList());
        }
        concurrentHashMap.get(this.mDemandSourceName).add(bVar);
        a aVar = bVar2.a != null ? bVar2.a.d : new a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.a, aVar.b);
        layoutParams.gravity = 17;
        this.mListener.onBannerAdLoaded(bVar2, layoutParams);
    }

    public void onBannerShowSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " onBannerShowSuccess");
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
