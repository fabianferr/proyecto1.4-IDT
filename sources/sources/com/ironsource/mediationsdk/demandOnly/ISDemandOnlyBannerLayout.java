package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;

public class ISDemandOnlyBannerLayout extends FrameLayout {
    /* access modifiers changed from: package-private */
    public View a;
    ISBannerSize b;
    String c;
    Activity d;
    boolean e = false;
    private a f;

    public ISDemandOnlyBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.d = activity;
        this.b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
        this.f = new a();
    }

    public Activity getActivity() {
        return this.d;
    }

    public ISDemandOnlyBannerListener getBannerDemandOnlyListener() {
        return (ISDemandOnlyBannerListener) this.f.a();
    }

    public View getBannerView() {
        return this.a;
    }

    public a getListener() {
        return this.f;
    }

    public String getPlacementName() {
        return this.c;
    }

    public ISBannerSize getSize() {
        return this.b;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void removeBannerListener() {
        IronLog.API.info();
        this.f.a(null);
    }

    public void setBannerDemandOnlyListener(ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
        IronLog.API.info();
        this.f.a(iSDemandOnlyBannerListener);
    }

    public void setPlacementName(String str) {
        this.c = str;
    }
}
