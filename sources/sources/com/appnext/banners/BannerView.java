package com.appnext.banners;

import android.content.Context;
import android.util.AttributeSet;
import com.appnext.base.Appnext;
import com.appnext.core.callbacks.OnECPMLoaded;

public class BannerView extends BaseBannerView {
    public BannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Appnext.init(context);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Appnext.init(context);
    }

    /* access modifiers changed from: protected */
    public BaseBannerAdapter getBannerAdapter() {
        if (this.bannerAdapter == null) {
            this.bannerAdapter = new e();
        }
        return this.bannerAdapter;
    }

    public void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded) {
        super.getECPM(bannerAdRequest, onECPMLoaded);
    }
}
