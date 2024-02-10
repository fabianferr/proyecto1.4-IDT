package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends com.applovin.impl.sdk.f.a {
    private static final AtomicBoolean a = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final String c;
    /* access modifiers changed from: private */
    public final MaxAdFormat d;
    private final JSONObject e;
    private final List<com.applovin.impl.mediation.a.a> f;
    /* access modifiers changed from: private */
    public final a.C0011a g;
    /* access modifiers changed from: private */
    public final WeakReference<Context> h;
    private long i;
    /* access modifiers changed from: private */
    public final List<MaxNetworkResponseInfo> j;

    private class a extends com.applovin.impl.sdk.f.a {
        /* access modifiers changed from: private */
        public final long c = SystemClock.elapsedRealtime();
        /* access modifiers changed from: private */
        public final int d;
        /* access modifiers changed from: private */
        public final com.applovin.impl.mediation.a.a e;
        /* access modifiers changed from: private */
        public final List<com.applovin.impl.mediation.a.a> f;

        a(int i, List<com.applovin.impl.mediation.a.a> list) {
            super(e.this.e(), e.this.b);
            this.d = i;
            this.e = list.get(i);
            this.f = list;
        }

        /* access modifiers changed from: private */
        public void a(com.applovin.impl.mediation.a.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
            MaxNetworkResponseInfo.AdLoadState adLoadState2 = adLoadState;
            e.this.j.add(new MaxNetworkResponseInfoImpl(adLoadState2, aVar.h(), new MaxMediatedNetworkInfoImpl(c.a(aVar.M(), this.b)), j, maxError));
        }

        /* access modifiers changed from: private */
        public void e(String str) {
        }

        public void run() {
            if (u.a()) {
                a("Loading ad " + (this.d + 1) + " of " + this.f.size() + ": " + this.e.N());
            }
            e("started to load ad");
            Context context = (Context) e.this.h.get();
            this.b.E().loadThirdPartyMediatedAd(e.this.c, this.e, context instanceof Activity ? (Activity) context : this.b.ao(), new com.applovin.impl.mediation.d.a(e.this.g) {
                public void onAdLoadFailed(String str, MaxError maxError) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.c;
                    if (u.a()) {
                        a aVar = a.this;
                        aVar.a("Ad failed to load in " + elapsedRealtime + " ms with error: " + maxError);
                    }
                    if (u.a()) {
                        a aVar2 = a.this;
                        aVar2.e("failed to load ad: " + maxError.getCode());
                    }
                    a aVar3 = a.this;
                    aVar3.a(aVar3.e, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                    if (a.this.d < a.this.f.size() - 1) {
                        a.this.b.S().a((com.applovin.impl.sdk.f.a) new a(a.this.d + 1, a.this.f), c.a(e.this.d));
                        return;
                    }
                    e.this.a((MaxError) new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }

                public void onAdLoaded(MaxAd maxAd) {
                    a.this.e("loaded ad");
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.c;
                    if (u.a()) {
                        a aVar = a.this;
                        aVar.a("Ad loaded in " + elapsedRealtime + "ms");
                    }
                    com.applovin.impl.mediation.a.a aVar2 = (com.applovin.impl.mediation.a.a) maxAd;
                    a.this.a(aVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, (MaxError) null);
                    int b = a.this.d;
                    while (true) {
                        b++;
                        if (b < a.this.f.size()) {
                            a aVar3 = a.this;
                            aVar3.a((com.applovin.impl.mediation.a.a) aVar3.f.get(b), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1, (MaxError) null);
                        } else {
                            e.this.a(aVar2);
                            return;
                        }
                    }
                }
            });
        }
    }

    e(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, m mVar, a.C0011a aVar) {
        super("TaskProcessMediationWaterfall:" + str + CertificateUtil.DELIMITER + maxAdFormat.getLabel(), mVar);
        this.c = str;
        this.d = maxAdFormat;
        this.e = jSONObject;
        this.g = aVar;
        this.h = new WeakReference<>(context);
        this.f = new ArrayList(jSONObject.length());
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f.add(com.applovin.impl.mediation.a.a.a(map, JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null), jSONObject, mVar));
        }
        this.j = new ArrayList(this.f.size());
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        this.b.F().a(aVar);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.i;
        if (u.a()) {
            b("Waterfall loaded in " + elapsedRealtime + "ms for " + aVar.N());
        }
        aVar.a((MaxAdWaterfallInfo) new MaxAdWaterfallInfoImpl(aVar, elapsedRealtime, this.j));
        j.a((MaxAdListener) this.g, (MaxAd) aVar);
    }

    /* access modifiers changed from: private */
    public void a(MaxError maxError) {
        g T;
        f fVar;
        if (maxError.getCode() == 204) {
            T = this.b.T();
            fVar = f.r;
        } else if (maxError.getCode() == -5001) {
            T = this.b.T();
            fVar = f.s;
        } else {
            T = this.b.T();
            fVar = f.t;
        }
        T.a(fVar);
        ArrayList arrayList = new ArrayList(this.j.size());
        for (MaxNetworkResponseInfo next : this.j) {
            if (next.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======\n");
            int i2 = 0;
            while (i2 < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo = (MaxNetworkResponseInfo) arrayList.get(i2);
                i2++;
                sb.append(i2);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo.getMediatedNetwork().getName());
                sb.append("\n..code: ");
                sb.append(maxNetworkResponseInfo.getError().getCode());
                sb.append("\n..message: ");
                sb.append(maxNetworkResponseInfo.getError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.i;
        if (u.a()) {
            b("Waterfall failed in " + elapsedRealtime + "ms with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl((com.applovin.impl.mediation.a.a) null, JsonUtils.getString(this.e, "waterfall_name", ""), JsonUtils.getString(this.e, "waterfall_test_name", ""), elapsedRealtime, this.j));
        j.a((MaxAdListener) this.g, this.c, maxError);
    }

    public void run() {
        this.i = SystemClock.elapsedRealtime();
        if (this.e.optBoolean("is_testing", false) && !this.b.J().a() && a.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", e.this.b.ao());
                }
            });
        }
        if (this.f.size() > 0) {
            if (u.a()) {
                a("Starting waterfall for " + this.f.size() + " ad(s)...");
            }
            this.b.S().a((com.applovin.impl.sdk.f.a) new a(0, this.f));
            return;
        }
        if (u.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher(this.c, this.d, this.e, this.b);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.e, "settings", new JSONObject());
        long j2 = JsonUtils.getLong(jSONObject, "alfdcs", 0);
        final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j2 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(j2);
            AnonymousClass2 r5 = new Runnable() {
                public void run() {
                    e.this.a(maxErrorImpl);
                }
            };
            if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", false).booleanValue()) {
                com.applovin.impl.sdk.utils.e.a(millis, this.b, r5);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r5, millis);
            }
        } else {
            a((MaxError) maxErrorImpl);
        }
    }
}
