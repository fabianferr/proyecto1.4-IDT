package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ApplovinAdapter extends AppLovinMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, OnContextChangedListener, MediationRewardedAd {
    private static final boolean LOGGING_ENABLED = true;
    /* access modifiers changed from: private */
    public static final HashMap<String, WeakReference<ApplovinAdapter>> appLovinInterstitialAds = new HashMap<>();
    /* access modifiers changed from: private */
    public AppLovinAd appLovinInterstitialAd;
    /* access modifiers changed from: private */
    public AppLovinAdView mAdView;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mMediationInterstitialListener;
    /* access modifiers changed from: private */
    public Bundle mNetworkExtras;
    /* access modifiers changed from: private */
    public AppLovinSdk mSdk;
    /* access modifiers changed from: private */
    public String mZoneId;

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        String retrieveSdkKey = AppLovinUtils.retrieveSdkKey(context, bundle);
        if (TextUtils.isEmpty(retrieveSdkKey)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            log(6, adError.getMessage());
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, adError);
            return;
        }
        final Bundle bundle3 = bundle;
        final MediationInterstitialListener mediationInterstitialListener2 = mediationInterstitialListener;
        final Context context2 = context;
        final Bundle bundle4 = bundle2;
        AppLovinInitializer.getInstance().initialize(context, retrieveSdkKey, new AppLovinInitializer.OnInitializeSuccessListener() {
            public void onInitializeSuccess(String str) {
                String unused = ApplovinAdapter.this.mZoneId = AppLovinUtils.retrieveZoneId(bundle3);
                if (!ApplovinAdapter.appLovinInterstitialAds.containsKey(ApplovinAdapter.this.mZoneId) || ((WeakReference) ApplovinAdapter.appLovinInterstitialAds.get(ApplovinAdapter.this.mZoneId)).get() == null) {
                    ApplovinAdapter.appLovinInterstitialAds.put(ApplovinAdapter.this.mZoneId, new WeakReference(ApplovinAdapter.this));
                    AppLovinSdk unused2 = ApplovinAdapter.this.mSdk = AppLovinUtils.retrieveSdk(bundle3, context2);
                    Context unused3 = ApplovinAdapter.this.mContext = context2;
                    Bundle unused4 = ApplovinAdapter.this.mNetworkExtras = bundle4;
                    MediationInterstitialListener unused5 = ApplovinAdapter.this.mMediationInterstitialListener = mediationInterstitialListener2;
                    ApplovinAdapter.log(3, "Requesting interstitial for zone: " + ApplovinAdapter.this.mZoneId);
                    AnonymousClass1 r4 = new AppLovinAdLoadListener() {
                        public void adReceived(AppLovinAd appLovinAd) {
                            ApplovinAdapter.log(3, "Interstitial did load ad: " + appLovinAd.getAdIdNumber() + " for zone: " + ApplovinAdapter.this.mZoneId);
                            AppLovinAd unused = ApplovinAdapter.this.appLovinInterstitialAd = appLovinAd;
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    ApplovinAdapter.this.mMediationInterstitialListener.onAdLoaded(ApplovinAdapter.this);
                                }
                            });
                        }

                        public void failedToReceiveAd(int i) {
                            final AdError adError = AppLovinUtils.getAdError(i);
                            ApplovinAdapter.log(5, adError.getMessage());
                            ApplovinAdapter.this.unregister();
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    ApplovinAdapter.this.mMediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) ApplovinAdapter.this, adError);
                                }
                            });
                        }
                    };
                    if (!TextUtils.isEmpty(ApplovinAdapter.this.mZoneId)) {
                        ApplovinAdapter.this.mSdk.getAdService().loadNextAdForZoneId(ApplovinAdapter.this.mZoneId, r4);
                    } else {
                        ApplovinAdapter.this.mSdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, r4);
                    }
                } else {
                    AdError adError = new AdError(105, " Cannot load multiple interstitial ads with the same Zone ID. Display one ad before attempting to load another. ", AppLovinMediationAdapter.ERROR_DOMAIN);
                    ApplovinAdapter.log(6, adError.getMessage());
                    mediationInterstitialListener2.onAdFailedToLoad((MediationInterstitialAdapter) ApplovinAdapter.this, adError);
                }
            }
        });
    }

    public void showInterstitial() {
        this.mSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.mNetworkExtras));
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.mSdk, this.mContext);
        AppLovinInterstitialAdListener appLovinInterstitialAdListener = new AppLovinInterstitialAdListener(this, this.mMediationInterstitialListener);
        create.setAdDisplayListener(appLovinInterstitialAdListener);
        create.setAdClickListener(appLovinInterstitialAdListener);
        create.setAdVideoPlaybackListener(appLovinInterstitialAdListener);
        if (this.appLovinInterstitialAd == null) {
            log(3, "Attempting to show interstitial before one was loaded.");
            if (TextUtils.isEmpty(this.mZoneId)) {
                log(3, "Showing interstitial preloaded by SDK.");
                create.show();
                return;
            }
            this.mMediationInterstitialListener.onAdOpened(this);
            this.mMediationInterstitialListener.onAdClosed(this);
            return;
        }
        log(3, "Showing interstitial for zone: " + this.mZoneId);
        create.showAndRender(this.appLovinInterstitialAd);
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        String retrieveSdkKey = AppLovinUtils.retrieveSdkKey(context, bundle);
        if (TextUtils.isEmpty(retrieveSdkKey)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            log(6, adError.getMessage());
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError);
            return;
        }
        final Bundle bundle3 = bundle;
        final Context context2 = context;
        final AdSize adSize2 = adSize;
        final MediationBannerListener mediationBannerListener2 = mediationBannerListener;
        AppLovinInitializer.getInstance().initialize(context, retrieveSdkKey, new AppLovinInitializer.OnInitializeSuccessListener() {
            public void onInitializeSuccess(String str) {
                AppLovinSdk unused = ApplovinAdapter.this.mSdk = AppLovinUtils.retrieveSdk(bundle3, context2);
                String unused2 = ApplovinAdapter.this.mZoneId = AppLovinUtils.retrieveZoneId(bundle3);
                AppLovinAdSize appLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(context2, adSize2);
                if (appLovinAdSizeFromAdMobAdSize == null) {
                    AdError adError = new AdError(101, "Failed to request banner with unsupported size.", AppLovinMediationAdapter.ERROR_DOMAIN);
                    ApplovinAdapter.log(6, adError.getMessage());
                    mediationBannerListener2.onAdFailedToLoad((MediationBannerAdapter) ApplovinAdapter.this, adError);
                }
                ApplovinAdapter.log(3, "Requesting banner of size " + appLovinAdSizeFromAdMobAdSize + " for zone: " + ApplovinAdapter.this.mZoneId);
                AppLovinAdView unused3 = ApplovinAdapter.this.mAdView = new AppLovinAdView(ApplovinAdapter.this.mSdk, appLovinAdSizeFromAdMobAdSize, context2);
                AppLovinBannerAdListener appLovinBannerAdListener = new AppLovinBannerAdListener(ApplovinAdapter.this.mZoneId, ApplovinAdapter.this.mAdView, ApplovinAdapter.this, mediationBannerListener2);
                ApplovinAdapter.this.mAdView.setAdDisplayListener(appLovinBannerAdListener);
                ApplovinAdapter.this.mAdView.setAdClickListener(appLovinBannerAdListener);
                ApplovinAdapter.this.mAdView.setAdViewEventListener(appLovinBannerAdListener);
                if (!TextUtils.isEmpty(ApplovinAdapter.this.mZoneId)) {
                    ApplovinAdapter.this.mSdk.getAdService().loadNextAdForZoneId(ApplovinAdapter.this.mZoneId, appLovinBannerAdListener);
                } else {
                    ApplovinAdapter.this.mSdk.getAdService().loadNextAd(appLovinAdSizeFromAdMobAdSize, appLovinBannerAdListener);
                }
            }
        });
    }

    public View getBannerView() {
        return this.mAdView;
    }

    public void onContextChanged(Context context) {
        log(3, "Context changed: " + context);
        this.mContext = context;
    }

    public static void log(int i, String str) {
        Log.println(i, "AppLovinAdapter", str);
    }

    /* access modifiers changed from: package-private */
    public void unregister() {
        if (!TextUtils.isEmpty(this.mZoneId)) {
            HashMap<String, WeakReference<ApplovinAdapter>> hashMap = appLovinInterstitialAds;
            if (hashMap.containsKey(this.mZoneId) && equals(hashMap.get(this.mZoneId).get())) {
                hashMap.remove(this.mZoneId);
            }
        }
    }
}
