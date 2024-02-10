package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.c.d;
import com.applovin.impl.mediation.c.g;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final u b;
    private final AtomicReference<JSONObject> c = new AtomicReference<>();

    public class a implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
        private final com.applovin.impl.mediation.a.a b;
        /* access modifiers changed from: private */
        public a.C0011a c;

        public a(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
            this.b = aVar;
            this.c = aVar2;
        }

        public void a(a.C0011a aVar) {
            this.c = aVar;
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.b.r();
            this.b.a(bundle);
            MediationServiceImpl.this.a(this.b);
            j.a((MaxAdListener) this.c, maxAd);
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            if (u.a()) {
                MediationServiceImpl.this.b.b("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.b, this.c);
            MediationServiceImpl.this.a.T().a(f.c);
            MediationServiceImpl.this.a.T().a(f.f);
            this.b.a(bundle);
            MediationServiceImpl.this.a.ag().a(this.b, "DID_DISPLAY");
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.a.ae().a((Object) maxAd);
                MediationServiceImpl.this.a.ak().a((Object) maxAd);
            }
            j.b((MaxAdListener) this.c, maxAd);
        }

        public void c(final MaxAd maxAd, Bundle bundle) {
            if (bundle != null && bundle.size() > 0) {
                ((com.applovin.impl.mediation.a.a) maxAd).a(BundleUtils.toJSONObject(bundle.getBundle(Utils.KEY_AD_VALUES)));
            }
            MediationServiceImpl.this.a.ag().a((com.applovin.impl.mediation.a.a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat().isFullscreenAd()) {
                        MediationServiceImpl.this.a.ae().b((Object) maxAd);
                        MediationServiceImpl.this.a.ak().a();
                    }
                    j.c(a.this.c, maxAd);
                }
            }, maxAd instanceof c ? ((c) maxAd).A() : 0);
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            if (bundle != null && bundle.size() > 0) {
                ((com.applovin.impl.mediation.a.a) maxAd).a(BundleUtils.toJSONObject(bundle.getBundle(Utils.KEY_AD_VALUES)));
            }
            MediationServiceImpl.this.a(this.b, this.c);
            j.d(this.c, maxAd);
        }

        public void onAdClicked(MaxAd maxAd) {
            d(maxAd, (Bundle) null);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            j.h(this.c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            MediationServiceImpl.this.b(this.b, maxError, this.c);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof c)) {
                ((c) maxAd).F();
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            b(maxAd, (Bundle) null);
        }

        public void onAdExpanded(MaxAd maxAd) {
            j.g(this.c, maxAd);
        }

        public void onAdHidden(MaxAd maxAd) {
            c(maxAd, (Bundle) null);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            this.b.r();
            MediationServiceImpl.this.a(this.b, maxError, (MaxAdListener) this.c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        public void onAdRequestStarted(String str) {
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            j.f(this.c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            j.e(this.c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            j.a((MaxAdListener) this.c, maxAd, maxReward);
            MediationServiceImpl.this.a.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.mediation.c.f((c) maxAd, MediationServiceImpl.this.a), o.a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    private g a(c cVar) {
        g g = cVar.g();
        if (g != null) {
            return g;
        }
        this.a.ae().a(false);
        if (u.a()) {
            u uVar = this.b;
            uVar.d("MediationService", "Failed to show " + cVar + ": adapter not found");
            u.i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        }
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        this.a.ag().a(aVar, "DID_LOAD");
        if (aVar.d().endsWith("load")) {
            this.a.ag().a(aVar);
        }
        long o = aVar.o();
        Map map = CollectionUtils.map(1);
        map.put("{LOAD_TIME_MS}", String.valueOf(o));
        a("load", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        this.a.ag().a(aVar, "DID_CLICKED");
        this.a.ag().a(aVar, "DID_CLICK");
        if (aVar.d().endsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
            this.a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        Map map = CollectionUtils.map(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.a.m());
        if (!((Boolean) this.a.a(b.dz)).booleanValue()) {
            emptyIfNull = "";
        }
        map.put("{CUID}", emptyIfNull);
        a("mclick", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, aVar);
        destroyAd(aVar);
        j.a(maxAdListener, aVar.getAdUnitId(), maxError);
    }

    /* access modifiers changed from: private */
    public void a(c cVar, a.C0011a aVar) {
        this.a.ae().a(false);
        a(cVar, (MaxAdListener) aVar);
        if (u.a()) {
            this.b.b("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpressionPostback(cVar, aVar);
    }

    private void a(c cVar, MaxAdListener maxAdListener) {
        long longValue = ((Long) this.a.a(com.applovin.impl.sdk.d.a.E)).longValue();
        if (longValue > 0) {
            final c cVar2 = cVar;
            final long j = longValue;
            final MaxAdListener maxAdListener2 = maxAdListener;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (!cVar2.s().get()) {
                        String str = "Ad (" + cVar2.O() + ") has not been displayed after " + j + "ms. Failing ad display...";
                        if (u.a()) {
                            u.i("MediationService", str);
                        }
                        MediationServiceImpl.this.b(cVar2, new MaxErrorImpl(-1, str), maxAdListener2);
                        MediationServiceImpl.this.a.ae().b((Object) cVar2);
                        MediationServiceImpl.this.a.ak().a();
                    }
                }
            }, longValue);
        }
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.a.a aVar) {
        long o = aVar.o();
        Map map = CollectionUtils.map(1);
        map.put("{LOAD_TIME_MS}", String.valueOf(o));
        a("mlerr", (Map<String, String>) map, maxError, (com.applovin.impl.mediation.a.f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(String str, h hVar, g gVar) {
        Map map = CollectionUtils.map(2);
        Utils.putObjectForStringIfValid("{ADAPTER_VERSION}", gVar.i(), map);
        Utils.putObjectForStringIfValid("{SDK_VERSION}", gVar.h(), map);
        a("serr", (Map<String, String>) map, (MaxError) new MaxErrorImpl(str), (com.applovin.impl.mediation.a.f) hVar);
    }

    private void a(String str, Map<String, String> map, com.applovin.impl.mediation.a.f fVar) {
        a(str, map, (MaxError) null, fVar);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, com.applovin.impl.mediation.a.f fVar) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put("{PLACEMENT}", StringUtils.emptyIfNull(fVar.getPlacement()));
        map2.put("{CUSTOM_DATA}", StringUtils.emptyIfNull(fVar.ab()));
        if (fVar instanceof com.applovin.impl.mediation.a.a) {
            map2.put("{CREATIVE_ID}", StringUtils.emptyIfNull(((com.applovin.impl.mediation.a.a) fVar).getCreativeId()));
        }
        this.a.S().a((com.applovin.impl.sdk.f.a) new d(str, map2, maxError, fVar, this.a), o.a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.a.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.a.ag().a(aVar, "DID_FAIL_DISPLAY");
        processAdDisplayErrorPostback(maxError, aVar);
        if (aVar.s().compareAndSet(false, true)) {
            j.a(maxAdListener, (MaxAd) aVar, maxError);
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.a.S().a((com.applovin.impl.sdk.f.a) new g(cVar, this.a), o.a.MEDIATION_REWARD);
        }
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final h hVar, Context context, final g.a aVar) {
        String str;
        u uVar;
        StringBuilder sb;
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar != null) {
            final g a2 = this.a.C().a(hVar, true);
            if (a2 != null) {
                Activity ao = context instanceof Activity ? (Activity) context : this.a.ao();
                MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(hVar, maxAdFormat);
                if (((Boolean) this.a.a(com.applovin.impl.sdk.d.a.P)).booleanValue()) {
                    this.a.D().a((com.applovin.impl.mediation.a.f) hVar, ao);
                }
                AnonymousClass3 r1 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.a(com.applovin.impl.mediation.a.g.a(hVar, a2, str));
                        a2.j();
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.a(str, hVar, a2);
                        aVar.a(com.applovin.impl.mediation.a.g.b(hVar, a2, str));
                        a2.j();
                    }
                };
                if (!hVar.a()) {
                    if (u.a()) {
                        uVar = this.b;
                        sb = new StringBuilder("Collecting signal for adapter: ");
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, ao, (MaxSignalCollectionListener) r1);
                    return;
                } else if (this.a.D().a((com.applovin.impl.mediation.a.f) hVar)) {
                    if (u.a()) {
                        uVar = this.b;
                        sb = new StringBuilder("Collecting signal for now-initialized adapter: ");
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, ao, (MaxSignalCollectionListener) r1);
                    return;
                } else {
                    if (u.a()) {
                        u uVar2 = this.b;
                        uVar2.e("MediationService", "Skip collecting signal for not-initialized adapter: " + a2.d());
                    }
                    str = "Adapter not initialized yet";
                }
                sb.append(a2.d());
                uVar.b("MediationService", sb.toString());
                a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, ao, (MaxSignalCollectionListener) r1);
                return;
            }
            str = "Could not load adapter";
            aVar.a(com.applovin.impl.mediation.a.g.a(hVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.a.a) {
            if (u.a()) {
                u uVar = this.b;
                uVar.c("MediationService", "Destroying " + maxAd);
            }
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) maxAd;
            g g = aVar.g();
            if (g != null) {
                g.j();
                aVar.t();
            }
            this.a.B().b(aVar.f());
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return this.c.getAndSet((Object) null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        String str3 = str;
        a.C0011a aVar2 = aVar;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar2 != null) {
            if (u.a() && TextUtils.isEmpty(this.a.t())) {
                u.i("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
            }
            if (u.a() && !this.a.d()) {
                u.h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.a.a();
            if (str.length() != 16 && !str.startsWith("test_mode") && !this.a.z().startsWith("05TMD") && u.a()) {
                u.i("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
            }
            MaxAdFormat maxAdFormat2 = maxAdFormat;
            if (this.a.a(maxAdFormat)) {
                if (u.a()) {
                    u.i("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
                }
                j.a((MaxAdListener) aVar2, str, (MaxError) new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
                return;
            }
            j.a((MaxAdRequestListener) aVar2, str, true);
            this.a.I().a(str, str2, maxAdFormat, map, map2, context, aVar);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, com.applovin.impl.mediation.a.a aVar, Activity activity, a.C0011a aVar2) {
        if (aVar != null) {
            if (u.a()) {
                this.b.b("MediationService", "Loading " + aVar + "...");
            }
            this.a.ag().a(aVar, "WILL_LOAD");
            g a2 = this.a.C().a((com.applovin.impl.mediation.a.f) aVar);
            if (a2 != null) {
                MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(aVar);
                if (((Boolean) this.a.a(com.applovin.impl.sdk.d.a.Q)).booleanValue()) {
                    this.a.D().a((com.applovin.impl.mediation.a.f) aVar, activity);
                }
                com.applovin.impl.mediation.a.a a4 = aVar.a(a2);
                a2.a(str, a4);
                a4.p();
                a2.a(str, a3, a4, activity, new a(a4, aVar2));
                return;
            }
            String str2 = "Failed to load " + aVar + ": adapter not loaded";
            if (u.a()) {
                u.i("MediationService", str2);
            }
            a(aVar, (MaxError) new MaxErrorImpl(-5001, str2), (MaxAdListener) aVar2);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object c2 = this.a.ae().c();
            if (c2 instanceof com.applovin.impl.mediation.a.a) {
                processAdDisplayErrorPostback(MaxAdapterError.WEBVIEW_ERROR, (com.applovin.impl.mediation.a.a) c2);
            }
        }
    }

    public void processAdDisplayErrorPostback(MaxError maxError, com.applovin.impl.mediation.a.a aVar) {
        a("mierr", (Map<String, String>) Collections.EMPTY_MAP, maxError, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processAdLossPostback(com.applovin.impl.mediation.a.a aVar, Float f) {
        String f2 = f != null ? f.toString() : "";
        Map map = CollectionUtils.map(1);
        map.put("{MBR}", f2);
        a("mloss", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processAdapterInitializationPostback(com.applovin.impl.mediation.a.f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        Map map = CollectionUtils.map(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", (Map<String, String>) map, (MaxError) new MaxErrorImpl(str), fVar);
    }

    public void processCallbackAdImpressionPostback(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        if (aVar.d().endsWith("cimp")) {
            this.a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        Map map = CollectionUtils.map(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.a.m());
        if (!((Boolean) this.a.a(b.dz)).booleanValue()) {
            emptyIfNull = "";
        }
        map.put("{CUID}", emptyIfNull);
        a("mcimp", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processRawAdImpressionPostback(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        this.a.ag().a(aVar, "WILL_DISPLAY");
        if (aVar.d().endsWith("mimp")) {
            this.a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        Map map = CollectionUtils.map(2);
        if (aVar instanceof c) {
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(((c) aVar).y()));
        }
        String emptyIfNull = StringUtils.emptyIfNull(this.a.m());
        if (!((Boolean) this.a.a(b.dz)).booleanValue()) {
            emptyIfNull = "";
        }
        map.put("{CUID}", emptyIfNull);
        a("mimp", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processViewabilityAdImpressionPostback(e eVar, long j, a.C0011a aVar) {
        if (eVar.d().endsWith("vimp")) {
            this.a.ag().a((com.applovin.impl.mediation.a.a) eVar);
            j.a((MaxAdRevenueListener) aVar, (MaxAd) eVar);
        }
        Map map = CollectionUtils.map(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(eVar.I()));
        String emptyIfNull = StringUtils.emptyIfNull(this.a.m());
        if (!((Boolean) this.a.a(b.dz)).booleanValue()) {
            emptyIfNull = "";
        }
        map.put("{CUID}", emptyIfNull);
        a("mvimp", (Map<String, String>) map, (com.applovin.impl.mediation.a.f) eVar);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.c.set(jSONObject);
    }

    public void showFullscreenAd(c cVar, Activity activity, a.C0011a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.a.ae().a(true);
            final g a2 = a(cVar);
            long z = cVar.z();
            if (u.a()) {
                u uVar = this.b;
                uVar.c("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + z + "ms...");
            }
            final c cVar2 = cVar;
            final Activity activity2 = activity;
            final a.C0011a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.b(cVar2);
                    a2.a((com.applovin.impl.mediation.a.a) cVar2, activity2);
                    MediationServiceImpl.this.a(cVar2, aVar2);
                }
            }, z);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    public void showFullscreenAd(c cVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.C0011a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.a.ae().a(true);
            final g a2 = a(cVar);
            long z = cVar.z();
            if (u.a()) {
                u uVar = this.b;
                uVar.c("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + z + "ms...");
            }
            final c cVar2 = cVar;
            final ViewGroup viewGroup2 = viewGroup;
            final Lifecycle lifecycle2 = lifecycle;
            final Activity activity2 = activity;
            final a.C0011a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.b(cVar2);
                    a2.a((com.applovin.impl.mediation.a.a) cVar2, viewGroup2, lifecycle2, activity2);
                    MediationServiceImpl.this.a(cVar2, aVar2);
                }
            }, z);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }
}
