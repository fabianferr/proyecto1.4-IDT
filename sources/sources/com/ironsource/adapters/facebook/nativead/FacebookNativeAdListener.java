package com.ironsource.adapters.facebook.nativead;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.workerthread.WorkerManager;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FacebookNativeAdListener implements NativeAdListener {
    private final AdOptionsPosition mAdOptionsPosition;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final NativeAdSmashListener mListener;
    private final String mPlacementId;

    public FacebookNativeAdListener(Context context, String str, AdOptionsPosition adOptionsPosition, NativeAdSmashListener nativeAdSmashListener) {
        this.mListener = nativeAdSmashListener;
        this.mPlacementId = str;
        this.mAdOptionsPosition = adOptionsPosition;
        this.mContext = context;
    }

    public void onMediaDownloaded(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
    }

    public void onAdLoaded(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else if (ad instanceof NativeAd) {
            NativeAd nativeAd = (NativeAd) ad;
            nativeAd.unregisterView();
            downloadDrawableFromUrlAndSendOnAdLoaded(nativeAd);
        } else {
            this.mListener.onNativeAdLoadFailed(new IronSourceError(510, "Expected an instance of " + NativeAd.class.getName() + ", received " + ad.getClass().getName()));
        }
    }

    public void onError(Ad ad, AdError adError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.error("error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            this.mListener.onNativeAdLoadFailed(new IronSourceError(FacebookAdapter.isNoFillError(adError) ? 706 : adError.getErrorCode(), adError.getErrorMessage()));
        }
    }

    public void onLoggingImpression(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        NativeAdSmashListener nativeAdSmashListener = this.mListener;
        if (nativeAdSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            nativeAdSmashListener.onNativeAdShown();
        }
    }

    public void onAdClicked(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        NativeAdSmashListener nativeAdSmashListener = this.mListener;
        if (nativeAdSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            nativeAdSmashListener.onNativeAdClicked();
        }
    }

    private void downloadDrawableFromUrlAndSendOnAdLoaded(final NativeAd nativeAd) {
        WorkerManager workerManager = new WorkerManager(Executors.newSingleThreadExecutor());
        workerManager.addCallable(new Callable<Drawable>() {
            public Drawable call() throws Exception {
                if (nativeAd.getAdIcon() == null || nativeAd.getAdIcon().getUrl() == null) {
                    return null;
                }
                return new BitmapDrawable(FacebookNativeAdListener.this.mContext.getResources(), BitmapFactory.decodeStream(new URL(nativeAd.getAdIcon().getUrl()).openStream()));
            }
        });
        workerManager.startWork(new WorkerManager.WorkEndedListener<Drawable>() {
            public void onWorkCompleted(List<WorkerResult<Drawable>> list, long j) {
                WorkerResult workerResult = list.get(0);
                FacebookNativeAdListener.this.handleOnAdLoaded(workerResult instanceof WorkerResult.Completed ? (Drawable) ((WorkerResult.Completed) workerResult).data : null, nativeAd);
            }

            public void onWorkFailed(String str) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("error while trying to download the native ad icon resource - " + str);
                FacebookNativeAdListener.this.handleOnAdLoaded((Drawable) null, nativeAd);
            }
        }, 3, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void handleOnAdLoaded(Drawable drawable, NativeAd nativeAd) {
        this.mListener.onNativeAdLoaded(new FacebookNativeAdData(nativeAd, drawable), new FacebookNativeAdViewBinder(nativeAd, this.mAdOptionsPosition));
    }
}
