package com.google.ads.mediation.facebook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FacebookAdapter extends FacebookMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    private static final int MAX_STAR_RATING = 5;
    /* access modifiers changed from: private */
    public AtomicBoolean didInterstitialAdClose = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean isNativeBanner;
    /* access modifiers changed from: private */
    public AdView mAdView;
    /* access modifiers changed from: private */
    public MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mInterstitialListener;
    /* access modifiers changed from: private */
    public boolean mIsImpressionRecorded;
    /* access modifiers changed from: private */
    public MediaView mMediaView;
    private NativeAd mNativeAd;
    private NativeBannerAd mNativeBannerAd;
    /* access modifiers changed from: private */
    public MediationNativeListener mNativeListener;
    /* access modifiers changed from: private */
    public FrameLayout mWrappedAdView;
    /* access modifiers changed from: private */
    public AtomicBoolean showInterstitialCalled = new AtomicBoolean();

    private interface NativeAdMapperListener {
        void onMappingFailed(AdError adError);

        void onMappingSuccess();
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.mNativeAd.destroy();
        }
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.destroy();
        }
        NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
            this.mNativeBannerAd.destroy();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Log.w(TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mBannerListener = mediationBannerListener;
        String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.w(TAG, adError.getMessage());
            this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError);
            return;
        }
        final com.facebook.ads.AdSize adSize2 = getAdSize(context, adSize);
        if (adSize2 == null) {
            AdError adError2 = new AdError(102, "There is no matching Facebook ad size for Google ad size.", "com.google.ads.mediation.facebook");
            Log.w(TAG, adError2.getMessage());
            this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError2);
            return;
        }
        final Context context2 = context;
        final String str = placementID;
        final MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        final AdSize adSize3 = adSize;
        FacebookInitializer.getInstance().initialize(context, placementID, (FacebookInitializer.Listener) new FacebookInitializer.Listener() {
            public void onInitializeSuccess() {
                AdView unused = FacebookAdapter.this.mAdView = new AdView(context2, str, adSize2);
                FacebookAdapter.this.buildAdRequest(mediationAdRequest2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(adSize3.getWidthInPixels(context2), -2);
                FrameLayout unused2 = FacebookAdapter.this.mWrappedAdView = new FrameLayout(context2);
                FacebookAdapter.this.mAdView.setLayoutParams(layoutParams);
                FacebookAdapter.this.mWrappedAdView.addView(FacebookAdapter.this.mAdView);
                FacebookAdapter.this.mAdView.loadAd(FacebookAdapter.this.mAdView.buildLoadAdConfig().withAdListener(new BannerListener()).build());
            }

            public void onInitializeError(AdError adError) {
                if (FacebookAdapter.this.mBannerListener != null) {
                    FacebookAdapter.this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) FacebookAdapter.this, adError);
                }
            }
        });
    }

    public View getBannerView() {
        return this.mWrappedAdView;
    }

    public void requestInterstitialAd(final Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, final MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Log.w(TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mInterstitialListener = mediationInterstitialListener;
        final String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook"));
            return;
        }
        FacebookInitializer.getInstance().initialize(context, placementID, (FacebookInitializer.Listener) new FacebookInitializer.Listener() {
            public void onInitializeSuccess() {
                FacebookAdapter.this.createAndLoadInterstitial(context, placementID, mediationAdRequest);
            }

            public void onInitializeError(AdError adError) {
                if (FacebookAdapter.this.mInterstitialListener != null) {
                    FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) FacebookAdapter.this, adError);
                }
            }
        });
    }

    public void showInterstitial() {
        this.showInterstitialCalled.set(true);
        if (!this.mInterstitialAd.show()) {
            Log.w(TAG, new AdError(110, "Failed to present interstitial ad.", "com.google.ads.mediation.facebook").getMessage());
            MediationInterstitialListener mediationInterstitialListener = this.mInterstitialListener;
            if (mediationInterstitialListener != null) {
                mediationInterstitialListener.onAdOpened(this);
                this.mInterstitialListener.onAdClosed(this);
            }
        }
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.w(TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        super.loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        Log.w(TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        this.mNativeListener = mediationNativeListener;
        String placementID = getPlacementID(bundle);
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.w(TAG, adError.getMessage());
            this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, adError);
        } else if (!nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            AdError adError2 = new AdError(105, "Unified Native Ads should be requested.", "com.google.ads.mediation.facebook");
            Log.w(TAG, adError2.getMessage());
            this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, adError2);
        } else {
            final Context context2 = context;
            final String str = placementID;
            final NativeMediationAdRequest nativeMediationAdRequest2 = nativeMediationAdRequest;
            final Bundle bundle3 = bundle2;
            FacebookInitializer.getInstance().initialize(context, placementID, (FacebookInitializer.Listener) new FacebookInitializer.Listener() {
                public void onInitializeSuccess() {
                    FacebookAdapter.this.createAndLoadNativeAd(context2, str, nativeMediationAdRequest2, bundle3);
                }

                public void onInitializeError(AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
                    if (FacebookAdapter.this.mNativeListener != null) {
                        FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void buildAdRequest(MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest == null) {
            return;
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() == 1) {
            AdSettings.setMixedAudience(true);
        } else if (mediationAdRequest.taggedForChildDirectedTreatment() == 0) {
            AdSettings.setMixedAudience(false);
        }
    }

    private class BannerListener implements AdListener {
        public void onLoggingImpression(Ad ad) {
        }

        private BannerListener() {
        }

        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            FacebookAdapter.this.mBannerListener.onAdFailedToLoad((MediationBannerAdapter) FacebookAdapter.this, adError2);
        }
    }

    /* access modifiers changed from: private */
    public void createAndLoadInterstitial(Context context, String str, MediationAdRequest mediationAdRequest) {
        this.mInterstitialAd = new InterstitialAd(context, str);
        buildAdRequest(mediationAdRequest);
        InterstitialAd interstitialAd = this.mInterstitialAd;
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(new InterstitialListener()).build());
    }

    private class InterstitialListener implements InterstitialAdExtendedListener {
        public void onLoggingImpression(Ad ad) {
        }

        public void onRewardedAdCompleted() {
        }

        public void onRewardedAdServerFailed() {
        }

        public void onRewardedAdServerSucceeded() {
        }

        private InterstitialListener() {
        }

        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mInterstitialListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onAdLoaded(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            Log.w(FacebookMediationAdapter.TAG, FacebookMediationAdapter.getAdError(adError).getMessage());
            if (FacebookAdapter.this.showInterstitialCalled.get()) {
                FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
                return;
            }
            FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onInterstitialDismissed(Ad ad) {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }

        public void onInterstitialDisplayed(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
        }

        public void onInterstitialActivityDestroyed() {
            if (!FacebookAdapter.this.didInterstitialAdClose.getAndSet(true)) {
                FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void createAndLoadNativeAd(Context context, String str, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle) {
        if (bundle != null) {
            this.isNativeBanner = bundle.getBoolean(FacebookExtras.NATIVE_BANNER);
        }
        if (this.isNativeBanner) {
            this.mNativeBannerAd = new NativeBannerAd(context, str);
            buildAdRequest(nativeMediationAdRequest);
            NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
            nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withAdListener(new NativeBannerListener(context, this.mNativeBannerAd)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
            return;
        }
        this.mMediaView = new MediaView(context);
        this.mNativeAd = new NativeAd(context, str);
        buildAdRequest(nativeMediationAdRequest);
        NativeAd nativeAd = this.mNativeAd;
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new NativeListener(context, this.mNativeAd)).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
    }

    private class NativeBannerListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeBannerAd mNativeBannerAd;

        private NativeBannerListener(Context context, NativeBannerAd nativeBannerAd) {
            this.mContext = new WeakReference<>(context);
            this.mNativeBannerAd = nativeBannerAd;
        }

        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError2);
        }

        public void onAdLoaded(Ad ad) {
            if (ad != this.mNativeBannerAd) {
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, new AdError(106, "Ad loaded is not a native banner ad.", "com.google.ads.mediation.facebook"));
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, new AdError(107, "Failed to create ad options view. Context is null.", "com.google.ads.mediation.facebook"));
                return;
            }
            final UnifiedAdMapper unifiedAdMapper = new UnifiedAdMapper(this.mNativeBannerAd);
            unifiedAdMapper.mapUnifiedNativeAd(context, new NativeAdMapperListener() {
                public void onMappingSuccess() {
                    FacebookAdapter.this.mNativeListener.onAdLoaded(FacebookAdapter.this, unifiedAdMapper);
                }

                public void onMappingFailed(AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
                    FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError);
                }
            });
        }

        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onLoggingImpression(Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            boolean unused = FacebookAdapter.this.mIsImpressionRecorded = true;
        }
    }

    private class NativeListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeAd mNativeAd;

        private NativeListener(Context context, NativeAd nativeAd) {
            this.mContext = new WeakReference<>(context);
            this.mNativeAd = nativeAd;
        }

        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        public void onLoggingImpression(Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
                return;
            }
            FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
            boolean unused = FacebookAdapter.this.mIsImpressionRecorded = true;
        }

        public void onAdLoaded(Ad ad) {
            if (ad != this.mNativeAd) {
                AdError adError = new AdError(106, "Ad loaded is not a native ad.", "com.google.ads.mediation.facebook");
                Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError);
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                AdError adError2 = new AdError(107, "Failed to create ad options view. Context is null", "com.google.ads.mediation.facebook");
                Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError2);
                return;
            }
            final UnifiedAdMapper unifiedAdMapper = new UnifiedAdMapper(this.mNativeAd);
            unifiedAdMapper.mapUnifiedNativeAd(context, new NativeAdMapperListener() {
                public void onMappingSuccess() {
                    FacebookAdapter.this.mNativeListener.onAdLoaded(FacebookAdapter.this, unifiedAdMapper);
                }

                public void onMappingFailed(AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
                    FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError);
                }
            });
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            if (!TextUtils.isEmpty(adError.getErrorMessage())) {
                Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            }
            FacebookAdapter.this.mNativeListener.onAdFailedToLoad((MediationNativeAdapter) FacebookAdapter.this, adError.getErrorCode());
        }

        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }

    private com.facebook.ads.AdSize getAdSize(Context context, AdSize adSize) {
        int width = adSize.getWidth();
        if (width < 0) {
            width = Math.round(((float) adSize.getWidthInPixels(context)) / context.getResources().getDisplayMetrics().density);
        }
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(0, new AdSize(width, 50));
        arrayList.add(1, new AdSize(width, 90));
        arrayList.add(2, new AdSize(width, 250));
        String str = TAG;
        Log.i(str, "Potential ad sizes: " + arrayList.toString());
        AdSize findClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (findClosestSize == null) {
            return null;
        }
        String str2 = TAG;
        Log.i(str2, "Found closest ad size: " + findClosestSize.toString());
        int height = findClosestSize.getHeight();
        if (height == com.facebook.ads.AdSize.BANNER_HEIGHT_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (height == com.facebook.ads.AdSize.BANNER_HEIGHT_90.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        }
        if (height == com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250.getHeight()) {
            return com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    class UnifiedAdMapper extends UnifiedNativeAdMapper {
        private NativeAd mNativeAd;
        private NativeBannerAd mNativeBannerAd;

        public UnifiedAdMapper(NativeAd nativeAd) {
            this.mNativeAd = nativeAd;
        }

        public UnifiedAdMapper(NativeBannerAd nativeBannerAd) {
            this.mNativeBannerAd = nativeBannerAd;
        }

        public void mapUnifiedNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
            AdOptionsView adOptionsView;
            if (FacebookAdapter.this.isNativeBanner) {
                if (!containsRequiredFieldsForNativeBannerAd(this.mNativeBannerAd)) {
                    AdError adError = new AdError(108, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.", "com.google.ads.mediation.facebook");
                    Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
                    nativeAdMapperListener.onMappingFailed(adError);
                    return;
                }
                setHeadline(this.mNativeBannerAd.getAdHeadline());
                setBody(this.mNativeBannerAd.getAdBodyText());
                if (this.mNativeBannerAd.getPreloadedIconViewDrawable() != null) {
                    setIcon(new FacebookAdapterNativeAdImage(this.mNativeBannerAd.getPreloadedIconViewDrawable()));
                } else if (this.mNativeBannerAd.getAdIcon() == null) {
                    setIcon(new FacebookAdapterNativeAdImage());
                } else {
                    setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeBannerAd.getAdIcon().getUrl())));
                }
                setCallToAction(this.mNativeBannerAd.getAdCallToAction());
                setAdvertiser(this.mNativeBannerAd.getAdvertiserName());
                Bundle bundle = new Bundle();
                bundle.putCharSequence("id", this.mNativeBannerAd.getId());
                bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.mNativeBannerAd.getAdSocialContext());
                setExtras(bundle);
            } else if (!containsRequiredFieldsForUnifiedNativeAd(this.mNativeAd)) {
                AdError adError2 = new AdError(108, "Ad from Facebook doesn't have all assets required for the Native Banner Ad format.", "com.google.ads.mediation.facebook");
                Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
                nativeAdMapperListener.onMappingFailed(adError2);
                return;
            } else {
                setHeadline(this.mNativeAd.getAdHeadline());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdCoverImage().getUrl())));
                setImages(arrayList);
                setBody(this.mNativeAd.getAdBodyText());
                if (this.mNativeAd.getPreloadedIconViewDrawable() != null) {
                    setIcon(new FacebookAdapterNativeAdImage(this.mNativeAd.getPreloadedIconViewDrawable()));
                } else if (this.mNativeAd.getAdIcon() == null) {
                    setIcon(new FacebookAdapterNativeAdImage());
                } else {
                    setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAd.getAdIcon().getUrl())));
                }
                setCallToAction(this.mNativeAd.getAdCallToAction());
                setAdvertiser(this.mNativeAd.getAdvertiserName());
                FacebookAdapter.this.mMediaView.setListener(new MediaViewListener() {
                    public void onEnterFullscreen(MediaView mediaView) {
                    }

                    public void onExitFullscreen(MediaView mediaView) {
                    }

                    public void onFullscreenBackground(MediaView mediaView) {
                    }

                    public void onFullscreenForeground(MediaView mediaView) {
                    }

                    public void onPause(MediaView mediaView) {
                    }

                    public void onPlay(MediaView mediaView) {
                    }

                    public void onVolumeChange(MediaView mediaView, float f) {
                    }

                    public void onComplete(MediaView mediaView) {
                        if (FacebookAdapter.this.mNativeListener != null) {
                            FacebookAdapter.this.mNativeListener.onVideoEnd(FacebookAdapter.this);
                        }
                    }
                });
                setMediaView(FacebookAdapter.this.mMediaView);
                setHasVideoContent(true);
                Double rating = getRating(this.mNativeAd.getAdStarRating());
                if (rating != null) {
                    setStarRating(rating);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence("id", this.mNativeAd.getId());
                bundle2.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.mNativeAd.getAdSocialContext());
                setExtras(bundle2);
            }
            NativeAdLayout nativeAdLayout = new NativeAdLayout(context);
            if (FacebookAdapter.this.isNativeBanner) {
                adOptionsView = new AdOptionsView(context, this.mNativeBannerAd, nativeAdLayout);
            } else {
                adOptionsView = new AdOptionsView(context, this.mNativeAd, nativeAdLayout);
            }
            setAdChoicesContent(adOptionsView);
            nativeAdMapperListener.onMappingSuccess();
        }

        private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        private boolean containsRequiredFieldsForNativeBannerAd(NativeBannerAd nativeBannerAd) {
            return (nativeBannerAd.getAdHeadline() == null || nativeBannerAd.getAdBodyText() == null || nativeBannerAd.getAdIcon() == null || nativeBannerAd.getAdCallToAction() == null) ? false : true;
        }

        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList();
            View view2 = null;
            for (Map.Entry next : map.entrySet()) {
                arrayList.add((View) next.getValue());
                if (((String) next.getKey()).equals("3003")) {
                    view2 = (View) next.getValue();
                }
            }
            if (FacebookAdapter.this.isNativeBanner) {
                if (view2 == null) {
                    Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Facebook impression recording might be impacted for this ad.");
                } else if (!(view2 instanceof ImageView)) {
                    Log.w(FacebookMediationAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Facebook impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", new Object[]{view2.getClass()}));
                } else {
                    this.mNativeBannerAd.registerViewForInteraction(view, (ImageView) view2);
                }
            } else if (view2 instanceof ImageView) {
                this.mNativeAd.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, (ImageView) view2, (List<View>) arrayList);
            } else {
                Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView.Calling registerViewForInteraction() without a reference to the icon view.");
                this.mNativeAd.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, (List<View>) arrayList);
            }
        }

        public void untrackView(View view) {
            NativeBannerAd nativeBannerAd;
            if (!FacebookAdapter.this.isNativeBanner || (nativeBannerAd = this.mNativeBannerAd) == null) {
                NativeAd nativeAd = this.mNativeAd;
                if (nativeAd != null) {
                    nativeAd.unregisterView();
                }
            } else {
                nativeBannerAd.unregisterView();
            }
            super.untrackView(view);
        }

        private Double getRating(NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }
    }

    private class FacebookAdapterNativeAdImage extends NativeAd.Image {
        private Drawable mDrawable;
        private Uri mUri;

        public double getScale() {
            return 1.0d;
        }

        public FacebookAdapterNativeAdImage() {
        }

        public FacebookAdapterNativeAdImage(Uri uri) {
            this.mUri = uri;
        }

        public FacebookAdapterNativeAdImage(Drawable drawable) {
            this.mDrawable = drawable;
        }

        /* access modifiers changed from: protected */
        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public Uri getUri() {
            return this.mUri;
        }
    }
}
