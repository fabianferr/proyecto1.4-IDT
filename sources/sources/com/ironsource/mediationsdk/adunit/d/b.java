package com.ironsource.mediationsdk.adunit.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;

public final class b extends c<a> implements BannerAdListener, com.ironsource.mediationsdk.adunit.b.c {
    private final IronSourceBannerLayout a;
    private final boolean b;

    public b(a aVar, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, IronSourceBannerLayout ironSourceBannerLayout, Placement placement, boolean z, a aVar2) {
        super(aVar, baseAdAdapter, new com.ironsource.mediationsdk.model.a(aVar.c, aVar.c.getBannerSettings(), IronSource.AD_UNIT.BANNER), aVar2);
        this.a = ironSourceBannerLayout;
        this.h = placement;
        this.b = z;
    }

    public final AdData a(String str, Map<String, Object> map) {
        return new AdData(str, v(), a(map));
    }

    public final Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        Map<String, Object> a2 = super.a(bVar);
        IronSourceBannerLayout ironSourceBannerLayout = this.a;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            C0224n.a(a2, this.a.getSize());
        }
        if (this.h != null) {
            a2.put("placement", x());
        }
        return a2;
    }

    public final Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> a2 = super.a(map);
        if (!(this.c == null || this.a == null || !TextUtils.isEmpty(this.c.c.getCustomNetwork()))) {
            a2.put(IronSourceConstants.BANNER_LAYOUT, this.a);
        }
        return a2;
    }

    public final void a() {
        if (this.e instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) this.e).loadAd(this.i, ContextProvider.getInstance().getCurrentActiveActivity(), this.a.getSize(), this);
        } else {
            IronLog.INTERNAL.error(b("adapter not instance of AdapterBannerInterface"));
        }
    }

    public final void c() {
        IronLog.INTERNAL.verbose(o());
        a(c.a.NONE);
        if (this.e == null) {
            IronLog.INTERNAL.warning("mAdapter == null");
            return;
        }
        try {
            if (this.e instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) this.e).destroyAd(this.i);
            } else {
                IronLog.INTERNAL.error(b("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.g;
            IronLog.INTERNAL.error(b(str));
            if (this.f != null) {
                this.f.g.n(str);
            }
        }
        if (this.f != null) {
            this.f.c.a(t().intValue());
        }
    }

    public final boolean d() {
        return false;
    }

    public final boolean e() {
        return this.b;
    }

    public final void onAdLeftApplication() {
        if (!(this.h == null || this.f == null)) {
            this.f.f.g(this.h.getPlacementName());
        }
        if (this.d != null) {
            ((a) this.d).c(this);
        }
    }

    public final void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams) {
        super.onAdLoadSuccess();
        if (g() && this.d != null) {
            ((a) this.d).a(this, view, layoutParams);
        }
    }

    public final void onAdOpened() {
        IronLog.INTERNAL.verbose(w());
        if (g()) {
            super.onAdOpened();
        } else if (this.g != c.a.FAILED) {
            String format = String.format("unexpected onAdOpened for %s, state - %s", new Object[]{o(), this.g});
            if (this.f != null) {
                this.f.g.m(format);
            }
        }
    }

    public final void onAdScreenDismissed() {
        if (!(this.h == null || this.f == null)) {
            this.f.f.i(this.h.getPlacementName());
        }
        if (this.d != null) {
            ((a) this.d).b(this);
        }
    }

    public final void onAdScreenPresented() {
        if (!(this.h == null || this.f == null)) {
            this.f.f.h(this.h.getPlacementName());
        }
        if (this.d != null) {
            ((a) this.d).a(this);
        }
    }
}
