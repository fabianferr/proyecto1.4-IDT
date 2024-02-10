package com.appnext.nativeads.designed_native_ads.views.b;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.appnext.core.AppnextError;
import com.appnext.nativeads.R;
import com.appnext.nativeads.designed_native_ads.DesignNativeAdsRequest;
import com.appnext.nativeads.designed_native_ads.interfaces.AppnextDesignedNativeAdViewCallbacks;
import com.appnext.nativeads.designed_native_ads.views.a;
import com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide;

public class b extends a {
    /* access modifiers changed from: protected */
    public int height() {
        return 100;
    }

    /* access modifiers changed from: protected */
    public int maxSuggestedAdsCount() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public int width() {
        return 300;
    }

    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void loadWithImage(String str, int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            loadDesignedNativeAds(str, (DesignNativeAdsRequest) null, appnextSuggestedAppsImageSide.getOppositeSide(), appnextDesignedNativeAdViewCallbacks);
            loadImage(i, appnextSuggestedAppsImageSide);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsWithImageStyleView$loadWithImage", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    public void loadWithImage(String str, int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, int i2, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            loadDesignedNativeAds(str, (DesignNativeAdsRequest) null, i2, appnextSuggestedAppsImageSide.getOppositeSide(), appnextDesignedNativeAdViewCallbacks);
            loadImage(i, appnextSuggestedAppsImageSide);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsWithImageStyleView$loadWithImage", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    public void loadWithImage(String str, int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, DesignNativeAdsRequest designNativeAdsRequest, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            loadDesignedNativeAds(str, designNativeAdsRequest, appnextSuggestedAppsImageSide.getOppositeSide(), appnextDesignedNativeAdViewCallbacks);
            loadImage(i, appnextSuggestedAppsImageSide);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsWithImageStyleView$loadWithImage", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    public void loadWithImage(String str, int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, DesignNativeAdsRequest designNativeAdsRequest, int i2, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            loadDesignedNativeAds(str, designNativeAdsRequest, i2, appnextSuggestedAppsImageSide.getOppositeSide(), appnextDesignedNativeAdViewCallbacks);
            loadImage(i, appnextSuggestedAppsImageSide);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsWithImageStyleView$loadWithImage", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    /* renamed from: com.appnext.nativeads.designed_native_ads.views.b.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fY;

        static {
            int[] iArr = new int[AppnextSuggestedAppsImageSide.values().length];
            fY = iArr;
            try {
                iArr[AppnextSuggestedAppsImageSide.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void loadImage(int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide) {
        ImageView imageView;
        ImageView imageView2;
        try {
            if (AnonymousClass1.fY[appnextSuggestedAppsImageSide.ordinal()] != 1) {
                imageView = (ImageView) findViewById(R.id.right_image);
                imageView2 = (ImageView) findViewById(R.id.left_image);
            } else {
                imageView = (ImageView) findViewById(R.id.left_image);
                imageView2 = (ImageView) findViewById(R.id.right_image);
            }
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            imageView.setBackgroundResource(i);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsWithImageStyleView$loadImage", th);
        }
    }

    /* access modifiers changed from: protected */
    public int designedNativeAdsContainerResource() {
        return R.id.suggested_apps_with_image_container;
    }

    /* access modifiers changed from: protected */
    public int getContentResource() {
        return R.layout.suggested_apps_with_image_layout;
    }
}
