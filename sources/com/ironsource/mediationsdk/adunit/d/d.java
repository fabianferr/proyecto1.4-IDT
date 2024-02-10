package com.ironsource.mediationsdk.adunit.d;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.b.b;
import com.ironsource.mediationsdk.adunit.b.h;
import com.ironsource.mediationsdk.adunit.b.j;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0014J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ironsource/mediationsdk/adunit/smash/NativeAdSmash;", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "Lcom/ironsource/mediationsdk/adunit/manager/listeners/AdUnitManagerListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/NativeAdListener;", "Lcom/ironsource/mediationsdk/adunit/events/AdUnitEventsInterface;", "adSmashData", "Lcom/ironsource/mediationsdk/adunit/smash/AdSmashData;", "adapter", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "listener", "(Lcom/ironsource/mediationsdk/adunit/smash/AdSmashData;Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;Lcom/ironsource/mediationsdk/model/Placement;Lcom/ironsource/mediationsdk/adunit/manager/listeners/AdUnitManagerListener;)V", "<set-?>", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "adapterNativeAdData", "getAdapterNativeAdData", "()Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAdViewBinder", "getNativeAdViewBinder", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "destroyNativeAd", "", "getEventsAdditionalDataMap", "", "", "", "event", "Lcom/ironsource/mediationsdk/adunit/events/AdUnitEvents;", "loadAdWithAdapter", "onAdLoadSuccess", "onAdOpened", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends c<com.ironsource.mediationsdk.adunit.c.b.c> implements NativeAdListener, com.ironsource.mediationsdk.adunit.b.c {
    public AdapterNativeAdData a;
    public AdapterNativeAdViewBinder b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar, BaseAdAdapter<?, AdapterAdListener> baseAdAdapter, Placement placement, com.ironsource.mediationsdk.adunit.c.b.c cVar) {
        super(aVar, baseAdAdapter, new a(aVar.c, aVar.c.getNativeAdSettings(), IronSource.AD_UNIT.NATIVE_AD), cVar);
        Intrinsics.checkNotNullParameter(aVar, "adSmashData");
        this.h = placement;
    }

    public final Map<String, Object> a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "event");
        Map<String, Object> a2 = super.a(bVar);
        if (this.h != null) {
            Intrinsics.checkNotNullExpressionValue(a2, "data");
            a2.put("placement", x());
        }
        Intrinsics.checkNotNullExpressionValue(a2, "data");
        return a2;
    }

    public final void a() {
        j jVar;
        if (!(this.e instanceof AdapterNativeAdInterface)) {
            IronLog.INTERNAL.error(b("adapter not instance of AdapterNativeAdInterface"));
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() != null) {
            BaseAdAdapter baseAdAdapter = this.e;
            Intrinsics.checkNotNull(baseAdAdapter, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener>");
            AdData adData = this.i;
            Intrinsics.checkNotNullExpressionValue(adData, "mCurrentAdData");
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getInstance().currentActiveActivity");
            ((AdapterNativeAdInterface) baseAdAdapter).loadAd(adData, currentActiveActivity, this);
        } else {
            IronLog.INTERNAL.error(b("activity must not be null"));
            com.ironsource.mediationsdk.adunit.b.d dVar = this.f;
            if (dVar != null && (jVar = dVar.g) != null) {
                jVar.n("activity must not be null");
            }
        }
    }

    public final void c() {
        h hVar;
        j jVar;
        IronLog.INTERNAL.verbose(o());
        a(c.a.NONE);
        if (this.e == null) {
            IronLog.INTERNAL.warning("mAdapter == null");
            return;
        }
        try {
            if (this.e instanceof AdapterNativeAdInterface) {
                BaseAdAdapter baseAdAdapter = this.e;
                Intrinsics.checkNotNull(baseAdAdapter, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface<*>");
                AdData adData = this.i;
                Intrinsics.checkNotNullExpressionValue(adData, "mCurrentAdData");
                ((AdapterNativeAdInterface) baseAdAdapter).destroyAd(adData);
            } else {
                IronLog.INTERNAL.error(b("adapter not instance of AdapterNativeAdInterface"));
            }
        } catch (Throwable th) {
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str));
            com.ironsource.mediationsdk.adunit.b.d dVar = this.f;
            if (!(dVar == null || (jVar = dVar.g) == null)) {
                jVar.n(str);
            }
        }
        com.ironsource.mediationsdk.adunit.b.d dVar2 = this.f;
        if (dVar2 != null && (hVar = dVar2.c) != null) {
            Integer t = t();
            Intrinsics.checkNotNullExpressionValue(t, IronSourceConstants.KEY_SESSION_DEPTH);
            hVar.a(t.intValue());
        }
    }

    public final void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        this.a = adapterNativeAdData;
        this.b = adapterNativeAdViewBinder;
        onAdLoadSuccess();
    }

    public final void onAdOpened() {
        j jVar;
        IronLog.INTERNAL.verbose(w());
        if (g()) {
            super.onAdOpened();
        } else if (this.g != c.a.FAILED) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("unexpected onAdOpened for %s, state - %s", Arrays.copyOf(new Object[]{o(), this.g}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            com.ironsource.mediationsdk.adunit.b.d dVar = this.f;
            if (dVar != null && (jVar = dVar.g) != null) {
                jVar.m(format);
            }
        }
    }
}
