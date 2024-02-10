package com.ironsource.mediationsdk.adunit.c;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.b.b;
import com.ironsource.mediationsdk.adunit.b.h;
import com.ironsource.mediationsdk.adunit.c.b.c;
import com.ironsource.mediationsdk.adunit.c.d;
import com.ironsource.mediationsdk.adunit.c.d.e;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.adunit.d.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.i;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.j;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004BC\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0017\u001a\u00020\u0018H\u0014J6\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0014J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u000bH\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u000bH\u0014J\b\u0010+\u001a\u00020\u0011H\u0014J\u0010\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.J\u001a\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0011H\u0014J \u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u000e\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020!H\u0014J\b\u0010<\u001a\u00020\u0011H\u0014R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006="}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/NativeAdManager;", "Lcom/ironsource/mediationsdk/adunit/manager/BaseAdUnitManager;", "Lcom/ironsource/mediationsdk/adunit/smash/NativeAdSmash;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/listener/AdapterAdListener;", "Lcom/ironsource/mediationsdk/adunit/manager/listeners/AdUnitManagerListener;", "providersList", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "configs", "Lcom/ironsource/mediationsdk/model/NativeAdConfigurations;", "userId", "", "publisherDataHolder", "Lcom/ironsource/mediationsdk/IronsourceObjectPublisherDataHolder;", "segment", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "isOneToken", "", "(Ljava/util/List;Lcom/ironsource/mediationsdk/model/NativeAdConfigurations;Ljava/lang/String;Lcom/ironsource/mediationsdk/IronsourceObjectPublisherDataHolder;Lcom/ironsource/mediationsdk/IronSourceSegment;Z)V", "mObjectId", "Ljava/util/UUID;", "getMObjectId", "()Ljava/util/UUID;", "createAdUnitListenerWrapper", "Lcom/ironsource/mediationsdk/adunit/manager/wrappers/AdUnitListenerWrapper;", "createSmash", "providerSettings", "adapter", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "sessionDepth", "", "currentAuctionId", "destroyNativeAd", "", "getAdUnitPrefix", "getAdUnitSettings", "Lorg/json/JSONObject;", "getEventsAdditionalDataMap", "", "", "event", "Lcom/ironsource/mediationsdk/adunit/events/AdUnitEvents;", "getManagerName", "isAutomaticReloadInProgress", "loadNativeAd", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "sendOnLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "isReload", "sendOnLoadSuccess", "smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "setNativeAdListener", "nativeAdListener", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "setupCallbackThrottlerDelayLoadFailureNotification", "shouldReportImpressionData", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g extends d<d, AdapterAdListener> implements c {
    public final UUID a = UUID.randomUUID();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(List<? extends NetworkSettings> list, i iVar, String str, com.ironsource.mediationsdk.d.c cVar, IronSourceSegment ironSourceSegment, boolean z) {
        super(new com.ironsource.mediationsdk.adunit.c.a.d(str, list, iVar), cVar, ironSourceSegment, z);
        Intrinsics.checkNotNullParameter(iVar, "configs");
        Intrinsics.checkNotNullParameter(cVar, "publisherDataHolder");
    }

    public final /* synthetic */ com.ironsource.mediationsdk.adunit.d.a.c a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str) {
        Intrinsics.checkNotNullParameter(networkSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(str, "currentAuctionId");
        return new d(new a(IronSource.AD_UNIT.NATIVE_AD, this.l.b(), i, this.h, str, this.f, this.g, networkSettings, this.l.c), baseAdAdapter, this.i, this);
    }

    public final Map<String, Object> a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "event");
        Map<String, Object> a2 = super.a(bVar);
        Placement placement = this.i;
        if (placement != null) {
            Intrinsics.checkNotNullExpressionValue(a2, "data");
            a2.put("placement", placement.getPlacementName());
        }
        UUID uuid = this.a;
        if (uuid != null) {
            Intrinsics.checkNotNullExpressionValue(a2, "data");
            a2.put(IronSourceConstants.EVENTS_OBJECT_ID, uuid);
        }
        Intrinsics.checkNotNullExpressionValue(a2, "data");
        return a2;
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(networkSettings, "providerSettings");
        JSONObject nativeAdSettings = networkSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    public final void a(InternalNativeAdListener internalNativeAdListener) {
        Intrinsics.checkNotNullParameter(internalNativeAdListener, "nativeAdListener");
        a((com.ironsource.mediationsdk.adunit.c.d.a) new e(internalNativeAdListener));
    }

    /* access modifiers changed from: protected */
    public final void a(com.ironsource.mediationsdk.adunit.d.a.c<?> cVar, AdInfo adInfo) {
        if (cVar instanceof d) {
            d dVar = (d) cVar;
            this.q.a(dVar.a, dVar.b, adInfo);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(IronSourceError ironSourceError, boolean z) {
        this.q.a(ironSourceError);
    }

    public final void a(Placement placement) {
        String str;
        int i;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placement = " + placement);
        if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            objArr[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load native ad - %s", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            i = com.ironsource.mediationsdk.adunit.a.a.b(this.l.a);
        } else if (j.a(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName(), this.l.a)) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format("placement %s is capped", Arrays.copyOf(new Object[]{placement.getPlacementName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            i = com.ironsource.mediationsdk.adunit.a.a.f(this.l.a);
        } else {
            str = null;
            i = 510;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(a(str));
            a(i, str, false);
            return;
        }
        this.i = placement;
        i();
    }

    /* access modifiers changed from: protected */
    public final com.ironsource.mediationsdk.adunit.c.d.a b() {
        return new com.ironsource.mediationsdk.adunit.c.d.c();
    }

    /* access modifiers changed from: protected */
    public final boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public final String f() {
        return "NA";
    }

    public final void h() {
        com.ironsource.mediationsdk.adunit.b.j jVar;
        h hVar;
        IronLog.INTERNAL.verbose();
        try {
            d dVar = (d) this.b.c;
            if (dVar != null) {
                Integer t = dVar.t();
                int a2 = t == null ? this.s.a(this.l.a) : t.intValue();
                com.ironsource.mediationsdk.adunit.b.d dVar2 = this.p;
                if (!(dVar2 == null || (hVar = dVar2.c) == null)) {
                    hVar.a(a2);
                }
                dVar.c();
                this.b.a((com.ironsource.mediationsdk.adunit.d.a.c<?>) null);
            }
            this.i = null;
            a(d.a.NONE);
        } catch (Throwable th) {
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            com.ironsource.mediationsdk.adunit.b.d dVar3 = this.p;
            if (dVar3 != null && (jVar = dVar3.g) != null) {
                jVar.n(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }
}
