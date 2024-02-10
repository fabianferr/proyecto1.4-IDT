package com.ironsource.mediationsdk;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

public class IronSourceBannerLayout extends FrameLayout {
    ISBannerSize a;
    String b;
    Activity c;
    private View d;
    private boolean e = false;
    private boolean f = false;
    private a g;

    @Deprecated
    public interface a extends com.ironsource.sdk.j.a {
    }

    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.c = activity;
        this.a = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.e = true;
        this.c = null;
        this.a = null;
        this.b = null;
        this.d = null;
        this.g = null;
        removeBannerListener();
    }

    public Activity getActivity() {
        return this.c;
    }

    public BannerListener getBannerListener() {
        return C0222l.a().a;
    }

    public LevelPlayBannerListener getLevelPlayBannerListener() {
        return C0222l.a().b;
    }

    public String getPlacementName() {
        return this.b;
    }

    public ISBannerSize getSize() {
        return this.a;
    }

    public a getWindowFocusChangedListener() {
        return this.g;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void removeBannerListener() {
        IronLog.API.info();
        C0222l.a().a = null;
        C0222l.a().b = null;
    }

    public void setBannerListener(BannerListener bannerListener) {
        IronLog.API.info();
        C0222l.a().a = bannerListener;
    }

    public void setLevelPlayBannerListener(LevelPlayBannerListener levelPlayBannerListener) {
        IronLog.API.info();
        C0222l.a().b = levelPlayBannerListener;
    }

    public void setPlacementName(String str) {
        this.b = str;
    }

    public void setWindowFocusChangedListener(a aVar) {
        this.g = aVar;
    }
}
