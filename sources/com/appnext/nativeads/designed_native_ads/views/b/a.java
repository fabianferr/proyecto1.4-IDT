package com.appnext.nativeads.designed_native_ads.views.b;

import android.content.Context;
import android.util.AttributeSet;
import com.appnext.nativeads.R;
import com.appnext.nativeads.designed_native_ads.DesignNativeAdsRequest;
import com.appnext.nativeads.designed_native_ads.interfaces.AppnextDesignedNativeAdViewCallbacks;
import com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide;

public class a extends com.appnext.nativeads.designed_native_ads.views.a {
    /* access modifiers changed from: protected */
    public int height() {
        return 105;
    }

    /* access modifiers changed from: protected */
    public int maxSuggestedAdsCount() {
        return 5;
    }

    /* access modifiers changed from: protected */
    public int width() {
        return -1;
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public int designedNativeAdsContainerResource() {
        return R.id.regular_suggested_apps_container;
    }

    /* access modifiers changed from: protected */
    public int getContentResource() {
        return R.layout.suggested_apps_regular_layout;
    }

    public void load(String str, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        loadDesignedNativeAds(str, (DesignNativeAdsRequest) null, AppnextSuggestedAppsImageSide.Right, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, int i, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        loadDesignedNativeAds(str, (DesignNativeAdsRequest) null, i, AppnextSuggestedAppsImageSide.Right, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, DesignNativeAdsRequest designNativeAdsRequest, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        loadDesignedNativeAds(str, designNativeAdsRequest, AppnextSuggestedAppsImageSide.Right, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, DesignNativeAdsRequest designNativeAdsRequest, int i, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        loadDesignedNativeAds(str, designNativeAdsRequest, i, AppnextSuggestedAppsImageSide.Right, appnextDesignedNativeAdViewCallbacks);
    }
}
