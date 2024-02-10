package com.ironsource.adapters.ironsource.nativeAd;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.a.b;
import com.ironsource.sdk.a.c;
import com.ironsource.sdk.a.h;
import com.ironsource.sdk.controller.g;
import com.ironsource.sdk.k.a;
import com.ironsource.sdk.k.e;
import com.ironsource.sdk.k.f;
import com.ironsource.sdk.utils.a.d;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J,\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractNativeAdAdapter;", "Lcom/ironsource/adapters/ironsource/IronSourceAdapter;", "adapter", "(Lcom/ironsource/adapters/ironsource/IronSourceAdapter;)V", "nativeAd", "Lcom/ironsource/sdk/nativeAd/ISNNativeAd;", "destroyNativeAd", "", "config", "Lorg/json/JSONObject;", "getNativeAdBiddingData", "", "", "", "adData", "initNativeAdForBidding", "appKey", "userId", "listener", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdSmashListener;", "loadNativeAdForBidding", "serverData", "prepareLoadParams", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "ironsourceadapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IronSourceNativeAdAdapter extends AbstractNativeAdAdapter<IronSourceAdapter> {
    private a nativeAd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IronSourceNativeAdAdapter(IronSourceAdapter ironSourceAdapter) {
        super(ironSourceAdapter);
        Intrinsics.checkNotNullParameter(ironSourceAdapter, "adapter");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadNativeAdForBidding$lambda-0  reason: not valid java name */
    public static final void m2127loadNativeAdForBidding$lambda0(IronSourceNativeAdAdapter ironSourceNativeAdAdapter, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener, String str) {
        Intrinsics.checkNotNullParameter(ironSourceNativeAdAdapter, "this$0");
        Intrinsics.checkNotNullParameter(jSONObject, "$config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, "$listener");
        try {
            a.C0122a aVar = a.a;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            g controllerManager = IronSourceNetwork.getControllerManager();
            Intrinsics.checkNotNullExpressionValue(controllerManager, "controllerManager");
            a aVar2 = new a(uuid, new f(uuid, controllerManager, (d) null, (com.ironsource.sdk.c.a) null, 12), new c());
            aVar2.g = new IronSourceNativeAdListener(new IronSourceNativeAdViewBinder(aVar2, ironSourceNativeAdAdapter.getNativeAdProperties(jSONObject)), nativeAdSmashListener);
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            JSONObject prepareLoadParams = ironSourceNativeAdAdapter.prepareLoadParams(jSONObject, str);
            Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "activity");
            Intrinsics.checkNotNullParameter(currentActiveActivity, "activity");
            Intrinsics.checkNotNullParameter(prepareLoadParams, "loadParams");
            aVar2.f = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            aVar2.d = prepareLoadParams.optString("demandSourceName");
            aVar2.e = prepareLoadParams.optString("inAppBidding");
            b bVar = aVar2.c;
            h.a aVar3 = h.f;
            Intrinsics.checkNotNullExpressionValue(aVar3, "loadAd");
            HashMap<String, Object> hashMap = aVar2.b().a;
            Intrinsics.checkNotNullExpressionValue(hashMap, "baseEventParams().data");
            bVar.a(aVar3, hashMap);
            JSONObject jSONObject2 = new JSONObject(prepareLoadParams.toString());
            jSONObject2.put("loadStartTime", String.valueOf(aVar2.f));
            aVar2.b.a(currentActiveActivity, jSONObject2);
            ironSourceNativeAdAdapter.nativeAd = aVar2;
        } catch (Exception e) {
            nativeAdSmashListener.onNativeAdLoadFailed(new IronSourceError(510, "IronSourceAdapter loadNativeAd exception " + e.getMessage()));
        }
    }

    private final JSONObject prepareLoadParams(JSONObject jSONObject, String str) {
        JSONObject put = new JSONObject().put("demandSourceName", ((IronSourceAdapter) getAdapter()).getDemandSourceName(jSONObject)).put("apiVersion", "2").put("inAppBidding", true);
        String str2 = ((IronSourceAdapter) getAdapter()).ADM_KEY;
        C0215e.a();
        JSONObject put2 = put.put(str2, C0215e.c(str));
        HashMap<String, String> initParams = ((IronSourceAdapter) getAdapter()).getInitParams();
        Intrinsics.checkNotNullExpressionValue(initParams, "extraParams");
        for (Map.Entry entry : initParams.entrySet()) {
            put2.put((String) entry.getKey(), (String) entry.getValue());
        }
        Intrinsics.checkNotNullExpressionValue(put2, "loadParams");
        return put2;
    }

    public final void destroyNativeAd(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        a aVar = this.nativeAd;
        if (aVar != null) {
            e eVar = aVar.h;
            if (eVar != null) {
                eVar.a = null;
            }
            aVar.b.a();
        }
    }

    public final Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        return ((IronSourceAdapter) getAdapter()).getBiddingData();
    }

    public final void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((IronSourceAdapter) getAdapter()).initSDK(str, jSONObject);
        nativeAdSmashListener.onNativeAdInitSuccess();
    }

    public final void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        postOnUIThread(new IronSourceNativeAdAdapter$$ExternalSyntheticLambda0(this, jSONObject, nativeAdSmashListener, str));
    }

    public final void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
    }
}
