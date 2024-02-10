package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {
    private MediationNativeAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    private MediaView mMediaView;
    private NativeAdBase mNativeAdBase;
    /* access modifiers changed from: private */
    public MediationNativeAdCallback mNativeAdCallback;

    private interface NativeAdMapperListener {
        void onMappingFailed(AdError adError);

        void onMappingSuccess();
    }

    public FacebookRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.callback = mediationAdLoadCallback;
        this.adConfiguration = mediationNativeAdConfiguration;
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookAdapter.TAG, adError.getMessage());
            this.callback.onFailure(adError);
            return;
        }
        FacebookAdapter.setMixedAudience(this.adConfiguration);
        this.mMediaView = new MediaView(this.adConfiguration.getContext());
        try {
            this.mNativeAdBase = NativeAdBase.fromBidPayload(this.adConfiguration.getContext(), placementID, this.adConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
                this.mNativeAdBase.setExtraHints(new ExtraHints.Builder().mediationData(this.adConfiguration.getWatermark()).build());
            }
            NativeAdBase nativeAdBase = this.mNativeAdBase;
            nativeAdBase.loadAd(nativeAdBase.buildLoadAdConfig().withAdListener(new NativeListener(this.adConfiguration.getContext(), this.mNativeAdBase)).withBid(this.adConfiguration.getBidResponse()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e) {
            AdError adError2 = new AdError(109, "Failed to create native ad from bid payload: " + e.getMessage(), "com.google.ads.mediation.facebook");
            Log.w(FacebookAdapter.TAG, adError2.getMessage());
            this.callback.onFailure(adError2);
        }
    }

    private class NativeListener implements AdListener, NativeAdListener {
        private WeakReference<Context> mContext;
        private NativeAdBase mNativeAd;

        public void onLoggingImpression(Ad ad) {
        }

        NativeListener(Context context, NativeAdBase nativeAdBase) {
            this.mNativeAd = nativeAdBase;
            this.mContext = new WeakReference<>(context);
        }

        public void onAdClicked(Ad ad) {
            FacebookRtbNativeAd.this.mNativeAdCallback.reportAdClicked();
            FacebookRtbNativeAd.this.mNativeAdCallback.onAdOpened();
            FacebookRtbNativeAd.this.mNativeAdCallback.onAdLeftApplication();
        }

        public void onAdLoaded(Ad ad) {
            if (ad != this.mNativeAd) {
                AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", "com.google.ads.mediation.facebook");
                Log.e(FacebookAdapter.TAG, adError.getMessage());
                FacebookRtbNativeAd.this.callback.onFailure(adError);
                return;
            }
            Context context = (Context) this.mContext.get();
            if (context == null) {
                AdError adError2 = new AdError(107, "Context is null.", "com.google.ads.mediation.facebook");
                Log.e(FacebookAdapter.TAG, adError2.getMessage());
                FacebookRtbNativeAd.this.callback.onFailure(adError2);
                return;
            }
            FacebookRtbNativeAd.this.mapNativeAd(context, new NativeAdMapperListener() {
                public void onMappingSuccess() {
                    MediationNativeAdCallback unused = FacebookRtbNativeAd.this.mNativeAdCallback = (MediationNativeAdCallback) FacebookRtbNativeAd.this.callback.onSuccess(FacebookRtbNativeAd.this);
                }

                public void onMappingFailed(AdError adError) {
                    Log.w(FacebookAdapter.TAG, adError.getMessage());
                    FacebookRtbNativeAd.this.callback.onFailure(adError);
                }
            });
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookAdapter.TAG, adError2.getMessage());
            FacebookRtbNativeAd.this.callback.onFailure(adError2);
        }

        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookAdapter.TAG, "onMediaDownloaded");
        }
    }

    public void mapNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
        if (!containsRequiredFieldsForUnifiedNativeAd(this.mNativeAdBase)) {
            AdError adError = new AdError(108, "Ad from Facebook doesn't have all required assets.", "com.google.ads.mediation.facebook");
            Log.w(FacebookAdapter.TAG, adError.getMessage());
            nativeAdMapperListener.onMappingFailed(adError);
            return;
        }
        setHeadline(this.mNativeAdBase.getAdHeadline());
        if (this.mNativeAdBase.getAdCoverImage() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAdBase.getAdCoverImage().getUrl())));
            setImages(arrayList);
        }
        setBody(this.mNativeAdBase.getAdBodyText());
        if (this.mNativeAdBase.getPreloadedIconViewDrawable() != null) {
            setIcon(new FacebookAdapterNativeAdImage(this.mNativeAdBase.getPreloadedIconViewDrawable()));
        } else if (this.mNativeAdBase.getAdIcon() == null) {
            setIcon(new FacebookAdapterNativeAdImage());
        } else {
            setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.mNativeAdBase.getAdIcon().getUrl())));
        }
        setCallToAction(this.mNativeAdBase.getAdCallToAction());
        setAdvertiser(this.mNativeAdBase.getAdvertiserName());
        this.mMediaView.setListener(new MediaViewListener() {
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
                if (FacebookRtbNativeAd.this.mNativeAdCallback != null) {
                    FacebookRtbNativeAd.this.mNativeAdCallback.onVideoComplete();
                }
            }
        });
        setHasVideoContent(true);
        setMediaView(this.mMediaView);
        setStarRating((Double) null);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("id", this.mNativeAdBase.getId());
        bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.mNativeAdBase.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.mNativeAdBase, (NativeAdLayout) null));
        nativeAdMapperListener.onMappingSuccess();
    }

    private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAdBase nativeAdBase) {
        boolean z = (nativeAdBase.getAdHeadline() == null || nativeAdBase.getAdBodyText() == null || nativeAdBase.getAdIcon() == null || nativeAdBase.getAdCallToAction() == null) ? false : true;
        if (nativeAdBase instanceof NativeBannerAd) {
            return z;
        }
        if (!z || nativeAdBase.getAdCoverImage() == null || this.mMediaView == null) {
            return false;
        }
        return true;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList(map.values());
        View view2 = map.get("3003");
        NativeAdBase nativeAdBase = this.mNativeAdBase;
        if (nativeAdBase instanceof NativeBannerAd) {
            if (view2 == null) {
                Log.w(FacebookAdapter.TAG, "Missing or invalid native ad icon asset. Facebook impression recording might be impacted for this ad.");
            } else if (!(view2 instanceof ImageView)) {
                Log.w(FacebookAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Facebook impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", new Object[]{view2.getClass()}));
            } else {
                ((NativeBannerAd) nativeAdBase).registerViewForInteraction(view, (ImageView) view2, (List<View>) arrayList);
            }
        } else if (nativeAdBase instanceof NativeAd) {
            NativeAd nativeAd = (NativeAd) nativeAdBase;
            if (view2 instanceof ImageView) {
                nativeAd.registerViewForInteraction(view, this.mMediaView, (ImageView) view2, (List<View>) arrayList);
                return;
            }
            Log.w(FacebookAdapter.TAG, "Native icon asset is not of type ImageView. Calling registerViewForInteraction() without a reference to the icon view.");
            nativeAd.registerViewForInteraction(view, this.mMediaView, (List<View>) arrayList);
        } else {
            Log.w(FacebookAdapter.TAG, "Native ad type is not of type NativeAd or NativeBannerAd. It is not currently supported by the Facebook Adapter. Facebook impression recording might be impacted for this ad.");
        }
    }

    public void untrackView(View view) {
        NativeAdBase nativeAdBase = this.mNativeAdBase;
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
        }
        super.untrackView(view);
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
