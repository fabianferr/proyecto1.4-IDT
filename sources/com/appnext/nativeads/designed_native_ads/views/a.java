package com.appnext.nativeads.designed_native_ads.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.appnext.base.Appnext;
import com.appnext.core.AppnextError;
import com.appnext.core.g;
import com.appnext.nativeads.R;
import com.appnext.nativeads.designed_native_ads.AppnextDesignedNativeAdData;
import com.appnext.nativeads.designed_native_ads.DesignNativeAdsRequest;
import com.appnext.nativeads.designed_native_ads.c;
import com.appnext.nativeads.designed_native_ads.interfaces.AppnextDesignedNativeAdViewCallbacks;
import com.appnext.nativeads.designed_native_ads.views.a.a;
import com.appnext.nativeads.designed_native_ads.views.a.b;
import com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide;
import java.lang.ref.WeakReference;

public abstract class a extends FrameLayout {
    /* access modifiers changed from: private */
    public int mAmountOfApps;
    /* access modifiers changed from: private */
    public int mAppTitleTextColor;
    /* access modifiers changed from: private */
    public int mBackgroundColor;
    /* access modifiers changed from: private */
    public com.appnext.nativeads.designed_native_ads.views.a.a mDesignedNativeAdView;
    /* access modifiers changed from: private */
    public AppnextDesignedNativeAdViewCallbacks mDesignedNativeAdViewCallbacks;
    /* access modifiers changed from: private */
    public boolean mIsInitialized;
    /* access modifiers changed from: private */
    public boolean mIsLocalDirectionExists;
    /* access modifiers changed from: private */
    public boolean mIsPresentTitlesExists;
    /* access modifiers changed from: private */
    public boolean mLocalDirection;
    /* access modifiers changed from: private */
    public boolean mPresentTitles;
    /* access modifiers changed from: private */
    public String mTitle;
    /* access modifiers changed from: private */
    public int mTitleTextColor;
    /* access modifiers changed from: private */
    public int mTransparency;

    /* access modifiers changed from: protected */
    public abstract int designedNativeAdsContainerResource();

    /* access modifiers changed from: protected */
    public abstract int getContentResource();

    /* access modifiers changed from: protected */
    public abstract int height();

    /* access modifiers changed from: protected */
    public abstract int maxSuggestedAdsCount();

    /* access modifiers changed from: protected */
    public abstract int width();

    public a(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPresentTitlesExists = false;
        this.mIsLocalDirectionExists = false;
        init(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsPresentTitlesExists = false;
        this.mIsLocalDirectionExists = false;
        try {
            init(context, attributeSet);
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextDesignedNativeAdViewProxy$AppnextDesignedNativeAdViewProxy", th);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        Appnext.init(context);
        buildView();
        setBackgroundColor(Color.parseColor(c.aG().t("background_color")));
        setVisibility(8);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppnextDesignedNativeAdView, 0, 0);
            try {
                this.mTitle = obtainStyledAttributes.getString(R.styleable.AppnextDesignedNativeAdView_title);
                this.mTitleTextColor = obtainStyledAttributes.getInteger(R.styleable.AppnextDesignedNativeAdView_titleColor, 0);
                this.mAmountOfApps = obtainStyledAttributes.getInteger(R.styleable.AppnextDesignedNativeAdView_amountOfApps, -1);
                String string = obtainStyledAttributes.getString(R.styleable.AppnextDesignedNativeAdView_presentAppTitles);
                boolean z = true;
                boolean z2 = !TextUtils.isEmpty(string);
                this.mIsPresentTitlesExists = z2;
                if (z2) {
                    this.mPresentTitles = Boolean.parseBoolean(string);
                }
                String string2 = obtainStyledAttributes.getString(R.styleable.AppnextDesignedNativeAdView_localDirection);
                if (TextUtils.isEmpty(string2)) {
                    z = false;
                }
                this.mIsLocalDirectionExists = z;
                if (z) {
                    this.mLocalDirection = Boolean.parseBoolean(string2);
                }
                this.mAppTitleTextColor = obtainStyledAttributes.getColor(R.styleable.AppnextDesignedNativeAdView_appTitletColor, 0);
                this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.AppnextDesignedNativeAdView_backgroundColor, 0);
                this.mTransparency = obtainStyledAttributes.getInteger(R.styleable.AppnextDesignedNativeAdView_transparency, -1);
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        this.mIsInitialized = false;
    }

    private void buildView() {
        try {
            inflate(getContext(), getContentResource(), this);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$buildView", th);
        }
    }

    private void setViewSize() {
        int width = width();
        if (width > 0) {
            width = (int) convertDpToPx((float) width);
        }
        int height = height();
        if (height > 0) {
            height = (int) convertDpToPx((float) height);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        setLayoutParams(layoutParams);
    }

    private float convertDpToPx(float f) {
        return f * getResources().getDisplayMetrics().density;
    }

    private void setSuggestedAppsBackgroundColor(int i) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(30.0f);
            setBackground(gradientDrawable);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$setSuggestedAppsBackgroundColor", th);
        }
    }

    /* access modifiers changed from: protected */
    public void loadDesignedNativeAds(String str, DesignNativeAdsRequest designNativeAdsRequest, int i, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            if (g.g(getContext())) {
                if (i > 0 && i <= maxSuggestedAdsCount()) {
                    this.mAmountOfApps = i;
                }
                this.mDesignedNativeAdViewCallbacks = appnextDesignedNativeAdViewCallbacks;
                final ViewGroup viewGroup = (ViewGroup) findViewById(designedNativeAdsContainerResource());
                if (viewGroup != null) {
                    b bVar = new b(getContext());
                    this.mDesignedNativeAdView = bVar;
                    bVar.setPrivacyIconSide(appnextSuggestedAppsImageSide);
                    final String str2 = str;
                    final DesignNativeAdsRequest designNativeAdsRequest2 = designNativeAdsRequest;
                    final AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks2 = appnextDesignedNativeAdViewCallbacks;
                    this.mDesignedNativeAdView.a(str, new a.b() {
                        public final void aM() {
                            try {
                                a.this.mIsInitialized = true;
                                if (a.this.mTitle != null) {
                                    a aVar = a.this;
                                    aVar.setTitle(aVar.mTitle);
                                    a.this.mDesignedNativeAdView.setTitle(a.this.mTitle);
                                }
                                if (a.this.mTitleTextColor != 0) {
                                    a.this.mDesignedNativeAdView.setTitleTextColor(a.this.mTitleTextColor);
                                }
                                if (a.this.mAmountOfApps > 0) {
                                    a.this.mDesignedNativeAdView.setAmountOfApps(a.this.mAmountOfApps);
                                } else if (a.this.mDesignedNativeAdView.getAmountOfApps() == 0) {
                                    a aVar2 = a.this;
                                    aVar2.mAmountOfApps = aVar2.maxSuggestedAdsCount();
                                    a.this.mDesignedNativeAdView.setAmountOfApps(a.this.mAmountOfApps);
                                }
                                if (a.this.mIsPresentTitlesExists) {
                                    a.this.mDesignedNativeAdView.setPresentTitles(a.this.mPresentTitles);
                                }
                                if (a.this.mIsLocalDirectionExists) {
                                    a.this.mDesignedNativeAdView.setLocalDirection(a.this.mLocalDirection);
                                }
                                if (a.this.mAppTitleTextColor != 0) {
                                    a.this.mDesignedNativeAdView.setIconAppTitleTextColor(a.this.mAppTitleTextColor);
                                }
                                if (a.this.mBackgroundColor != 0) {
                                    a.this.mDesignedNativeAdView.setBackgroundColor(a.this.mBackgroundColor);
                                } else if (a.this.mDesignedNativeAdView.getBackgroundColor() == 0) {
                                    a.this.mDesignedNativeAdView.setBackgroundColor(0);
                                }
                                if (a.this.mTransparency >= 0) {
                                    a.this.mDesignedNativeAdView.setTransparency(a.this.mTransparency);
                                }
                                viewGroup.removeAllViews();
                                ((FrameLayout) viewGroup).addView(a.this.mDesignedNativeAdView);
                                com.appnext.nativeads.designed_native_ads.views.a.a r0 = a.this.mDesignedNativeAdView;
                                String str = str2;
                                DesignNativeAdsRequest designNativeAdsRequest = designNativeAdsRequest2;
                                a aVar3 = a.this;
                                r0.a(str, designNativeAdsRequest, new C0028a(aVar3.mDesignedNativeAdViewCallbacks));
                            } catch (Throwable th) {
                                com.appnext.base.a.a("AppnextDesignedNativeAdViewProxy$load", th);
                                AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks = appnextDesignedNativeAdViewCallbacks2;
                                if (appnextDesignedNativeAdViewCallbacks != null) {
                                    appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
                                }
                            }
                        }
                    });
                }
            } else if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.CONNECTION_ERROR));
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$load", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loadDesignedNativeAds(String str, DesignNativeAdsRequest designNativeAdsRequest, AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide, AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
        try {
            loadDesignedNativeAds(str, designNativeAdsRequest, 0, appnextSuggestedAppsImageSide, appnextDesignedNativeAdViewCallbacks);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$loadDesignedNativeAds", th);
            if (appnextDesignedNativeAdViewCallbacks != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(new AppnextError(AppnextError.INTERNAL_ERROR));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setTitle(String str) {
        this.mTitle = str;
    }

    /* access modifiers changed from: protected */
    public void setPresentAppTitles(boolean z) {
        try {
            this.mPresentTitles = z;
            this.mIsPresentTitlesExists = true;
            com.appnext.nativeads.designed_native_ads.views.a.a aVar = this.mDesignedNativeAdView;
            if (aVar != null && this.mIsInitialized) {
                aVar.setPresentTitles(z);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setPresentAppTitles", th);
        }
    }

    /* access modifiers changed from: protected */
    public void setTitleColor(int i) {
        try {
            this.mTitleTextColor = i;
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setTitleColor", th);
        }
    }

    /* access modifiers changed from: protected */
    public void setAppTitleColor(int i) {
        try {
            this.mAppTitleTextColor = i;
            com.appnext.nativeads.designed_native_ads.views.a.a aVar = this.mDesignedNativeAdView;
            if (aVar != null && this.mIsInitialized) {
                aVar.setIconAppTitleTextColor(i);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setAppTitleColor", th);
        }
    }

    /* access modifiers changed from: protected */
    public void setLocalDirection(boolean z) {
        try {
            this.mLocalDirection = z;
            this.mIsLocalDirectionExists = true;
            com.appnext.nativeads.designed_native_ads.views.a.a aVar = this.mDesignedNativeAdView;
            if (aVar != null && this.mIsInitialized) {
                aVar.setLocalDirection(z);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setLocalDirection", th);
        }
    }

    /* access modifiers changed from: protected */
    public void setTransparency(int i) {
        try {
            this.mTransparency = i;
            com.appnext.nativeads.designed_native_ads.views.a.a aVar = this.mDesignedNativeAdView;
            if (aVar != null && this.mIsInitialized) {
                aVar.setTransparency(i);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setTransparency", th);
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.mBackgroundColor = i;
            setSuggestedAppsBackgroundColor(i);
        } catch (Throwable th) {
            com.appnext.base.a.a("ANDesignedNativeAdsView$setBackgroundColor", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setViewSize();
    }

    /* renamed from: com.appnext.nativeads.designed_native_ads.views.a$a  reason: collision with other inner class name */
    private class C0028a implements a.C0029a {
        private WeakReference<AppnextDesignedNativeAdViewCallbacks> fV;

        public C0028a(AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks) {
            this.fV = new WeakReference<>(appnextDesignedNativeAdViewCallbacks);
        }

        public final void onAdsLoadedSuccessfully() {
            AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks;
            a.this.setVisibility(0);
            WeakReference<AppnextDesignedNativeAdViewCallbacks> weakReference = this.fV;
            if (weakReference != null && (appnextDesignedNativeAdViewCallbacks = (AppnextDesignedNativeAdViewCallbacks) weakReference.get()) != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsLoadedSuccessfully();
            }
        }

        public final void onAdClicked(AppnextDesignedNativeAdData appnextDesignedNativeAdData) {
            AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks;
            WeakReference<AppnextDesignedNativeAdViewCallbacks> weakReference = this.fV;
            if (weakReference != null && (appnextDesignedNativeAdViewCallbacks = (AppnextDesignedNativeAdViewCallbacks) weakReference.get()) != null) {
                appnextDesignedNativeAdViewCallbacks.onAdClicked(appnextDesignedNativeAdData);
            }
        }

        public final void onError(AppnextError appnextError) {
            AppnextDesignedNativeAdViewCallbacks appnextDesignedNativeAdViewCallbacks;
            WeakReference<AppnextDesignedNativeAdViewCallbacks> weakReference = this.fV;
            if (weakReference != null && (appnextDesignedNativeAdViewCallbacks = (AppnextDesignedNativeAdViewCallbacks) weakReference.get()) != null) {
                appnextDesignedNativeAdViewCallbacks.onAppnextAdsError(appnextError);
            }
        }
    }
}
