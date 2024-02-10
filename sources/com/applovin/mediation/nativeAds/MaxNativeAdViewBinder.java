package com.applovin.mediation.nativeAds;

import android.view.View;

public class MaxNativeAdViewBinder {
    protected final int advertiserTextViewId;
    protected final int bodyTextViewId;
    protected final int callToActionButtonId;
    protected final int iconContentViewId;
    protected final int iconImageViewId;
    protected final int layoutResourceId;
    protected final View mainView;
    protected final int mediaContentFrameLayoutId;
    protected final int mediaContentViewGroupId;
    protected final int optionsContentFrameLayoutId;
    protected final int optionsContentViewGroupId;
    protected final String templateType;
    protected final int titleTextViewId;

    public static class Builder {
        private final View a;
        private final int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private String m;

        public Builder(int i2) {
            this(i2, (View) null);
        }

        private Builder(int i2, View view) {
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.b = i2;
            this.a = view;
        }

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }

        public Builder setAdvertiserTextViewId(int i2) {
            this.d = i2;
            return this;
        }

        public Builder setBodyTextViewId(int i2) {
            this.e = i2;
            return this;
        }

        public Builder setCallToActionButtonId(int i2) {
            this.l = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setIconContentViewId(int i2) {
            this.g = i2;
            return this;
        }

        public Builder setIconImageViewId(int i2) {
            this.f = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setMediaContentFrameLayoutId(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setMediaContentViewGroupId(int i2) {
            this.j = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Builder setOptionsContentFrameLayoutId(int i2) {
            this.i = i2;
            return this;
        }

        public Builder setOptionsContentViewGroupId(int i2) {
            this.h = i2;
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder setTemplateType(String str) {
            this.m = str;
            return this;
        }

        public Builder setTitleTextViewId(int i2) {
            this.c = i2;
            return this;
        }
    }

    private MaxNativeAdViewBinder(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String str) {
        this.mainView = view;
        this.layoutResourceId = i;
        this.titleTextViewId = i2;
        this.advertiserTextViewId = i3;
        this.bodyTextViewId = i4;
        this.iconImageViewId = i5;
        this.iconContentViewId = i6;
        this.optionsContentViewGroupId = i7;
        this.optionsContentFrameLayoutId = i8;
        this.mediaContentViewGroupId = i9;
        this.mediaContentFrameLayoutId = i10;
        this.callToActionButtonId = i11;
        this.templateType = str;
    }
}
