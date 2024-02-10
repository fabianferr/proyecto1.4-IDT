package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import com.applovin.mediation.MaxAdFormat;

public class MaxNativeAd {
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final String title;

    public static class Builder {
        /* access modifiers changed from: private */
        public MaxAdFormat a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public MaxNativeAdImage f;
        /* access modifiers changed from: private */
        public View g;
        /* access modifiers changed from: private */
        public View h;
        /* access modifiers changed from: private */
        public View i;
        /* access modifiers changed from: private */
        public MaxNativeAdImage j;
        /* access modifiers changed from: private */
        public float k;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.g = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.j = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f2) {
            this.k = f2;
            return this;
        }

        public Builder setMediaView(View view) {
            this.i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.h = view;
            return this;
        }

        public Builder setTitle(String str) {
            this.b = str;
            return this;
        }
    }

    public static class MaxNativeAdImage {
        private Drawable a;
        private Uri b;

        public MaxNativeAdImage(Drawable drawable) {
            this.a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.b = uri;
        }

        public Drawable getDrawable() {
            return this.a;
        }

        public Uri getUri() {
            return this.b;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.a;
        this.title = builder.b;
        this.advertiser = builder.c;
        this.body = builder.d;
        this.callToAction = builder.e;
        this.icon = builder.f;
        this.iconView = builder.g;
        this.optionsView = builder.h;
        this.mediaView = builder.i;
        this.mainImage = builder.j;
        this.mediaContentAspectRatio = builder.k;
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final MaxAdFormat getFormat() {
        return this.format;
    }

    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    public final View getIconView() {
        return this.iconView;
    }

    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    public final View getOptionsView() {
        return this.optionsView;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView != null && (callToActionButton = maxNativeAdView.getCallToActionButton()) != null) {
            callToActionButton.performClick();
        }
    }

    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }
}
