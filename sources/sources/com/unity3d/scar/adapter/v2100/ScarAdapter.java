package com.unity3d.scar.adapter.v2100;

import android.content.Context;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarAdapter;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.ScarAdapterBase;
import com.unity3d.scar.adapter.common.Utils;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.common.requests.RequestExtras;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;
import com.unity3d.scar.adapter.v2100.scarads.ScarInterstitialAd;
import com.unity3d.scar.adapter.v2100.scarads.ScarRewardedAd;
import com.unity3d.scar.adapter.v2100.signals.SignalsCollector;

public class ScarAdapter extends ScarAdapterBase implements IScarAdapter {
    private AdRequestFactory _adRequestFactory;

    public ScarAdapter(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler, String str) {
        super(iAdsErrorHandler);
        AdRequestFactory adRequestFactory = new AdRequestFactory(new RequestExtras(str));
        this._adRequestFactory = adRequestFactory;
        this._signalCollector = new SignalsCollector(adRequestFactory);
    }

    public void loadInterstitialAd(Context context, final ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        final ScarInterstitialAd scarInterstitialAd = new ScarInterstitialAd(context, this._adRequestFactory, scarAdMetadata, this._adsErrorHandler, iScarInterstitialAdListenerWrapper);
        Utils.runOnUiThread(new Runnable() {
            public void run() {
                scarInterstitialAd.loadAd(new IScarLoadListener() {
                    public void onAdLoaded() {
                        ScarAdapter.this._loadedAds.put(scarAdMetadata.getPlacementId(), scarInterstitialAd);
                    }
                });
            }
        });
    }

    public void loadRewardedAd(Context context, final ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        final ScarRewardedAd scarRewardedAd = new ScarRewardedAd(context, this._adRequestFactory, scarAdMetadata, this._adsErrorHandler, iScarRewardedAdListenerWrapper);
        Utils.runOnUiThread(new Runnable() {
            public void run() {
                scarRewardedAd.loadAd(new IScarLoadListener() {
                    public void onAdLoaded() {
                        ScarAdapter.this._loadedAds.put(scarAdMetadata.getPlacementId(), scarRewardedAd);
                    }
                });
            }
        });
    }
}
