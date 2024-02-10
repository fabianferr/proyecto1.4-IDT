package com.ironsource.adapters.facebook.interstitial;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;

public class FacebookInterstitialAdListener implements InterstitialAdExtendedListener {
    private WeakReference<FacebookInterstitialAdapter> mAdapter;
    private boolean mDidCallClosed;
    private InterstitialSmashListener mListener;
    private String mPlacementId;

    FacebookInterstitialAdListener(FacebookInterstitialAdapter facebookInterstitialAdapter, String str, InterstitialSmashListener interstitialSmashListener) {
        this.mAdapter = new WeakReference<>(facebookInterstitialAdapter);
        this.mListener = interstitialSmashListener;
        this.mPlacementId = str;
    }

    public void onAdLoaded(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((FacebookInterstitialAdapter) this.mAdapter.get()).mAdsAvailability.put(this.mPlacementId, true);
        this.mListener.onInterstitialAdReady();
    }

    public void onError(Ad ad, AdError adError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId + " error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((FacebookInterstitialAdapter) this.mAdapter.get()).mAdsAvailability.put(this.mPlacementId, false);
        IronSourceError ironSourceError = new IronSourceError(FacebookAdapter.isNoFillError(adError) ? IronSourceError.ERROR_IS_LOAD_NO_FILL : adError.getErrorCode(), adError.getErrorMessage());
        if (((FacebookInterstitialAdapter) this.mAdapter.get()).mPlacementIdToShowAttempts.get(this.mPlacementId).booleanValue()) {
            this.mListener.onInterstitialAdShowFailed(ironSourceError);
        } else {
            this.mListener.onInterstitialAdLoadFailed(ironSourceError);
        }
    }

    public void onInterstitialDisplayed(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
    }

    public void onLoggingImpression(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mDidCallClosed = false;
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    public void onAdClicked(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    public void onInterstitialDismissed(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mDidCallClosed = true;
        this.mListener.onInterstitialAdClosed();
    }

    public void onInterstitialActivityDestroyed() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else if (!this.mDidCallClosed) {
            this.mListener.onInterstitialAdClosed();
        }
    }

    public void onRewardedAdCompleted() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
    }

    public void onRewardedAdServerSucceeded() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
    }

    public void onRewardedAdServerFailed() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
    }
}
