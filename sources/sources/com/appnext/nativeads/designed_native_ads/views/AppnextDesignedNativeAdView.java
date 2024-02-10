package com.appnext.nativeads.designed_native_ads.views;

import android.content.Context;
import android.util.AttributeSet;
import com.appnext.nativeads.designed_native_ads.DesignNativeAdsRequest;
import com.appnext.nativeads.designed_native_ads.interfaces.AppnextDesignedNativeAdViewCallbacks;
import com.appnext.nativeads.designed_native_ads.views.b.a;

public class AppnextDesignedNativeAdView extends a {
    public AppnextDesignedNativeAdView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public AppnextDesignedNativeAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppnextDesignedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AppnextDesignedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void load(String str, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        super.load(str, (DesignNativeAdsRequest) null, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, int i, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        super.load(str, (DesignNativeAdsRequest) null, i, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, DesignNativeAdsRequest designNativeAdsRequest, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        super.load(str, designNativeAdsRequest, appnextDesignedNativeAdViewCallbacks);
    }

    public void load(String str, DesignNativeAdsRequest designNativeAdsRequest, int i, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        super.load(str, designNativeAdsRequest, i, appnextDesignedNativeAdViewCallbacks);
    }

    public void setTitle(String str) {
        super.setTitle(str);
    }

    public void setTitleColor(int i) {
        super.setTitleColor(i);
    }

    public void setPresentAppTitles(boolean z) {
        super.setPresentAppTitles(z);
    }

    public void setLocalDirection(boolean z) {
        super.setLocalDirection(z);
    }

    public void setAppTitleColor(int i) {
        super.setAppTitleColor(i);
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
    }

    public void setTransparency(int i) {
        super.setTransparency(i);
    }
}
