package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.a.c;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.f.k;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final u b;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Map<d, b> d;
    private final Object e = new Object();
    private final Map<String, String> f = CollectionUtils.map();
    private final AtomicReference<JSONObject> g = new AtomicReference<>();

    private class a implements AppLovinAdLoadListener {
        private final b b;

        private a(b bVar) {
            this.b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
            d adZone = appLovinAdImpl.getAdZone();
            if (!(appLovinAd instanceof f)) {
                AppLovinAdServiceImpl.this.a.Z().a(appLovinAdImpl);
                appLovinAd = new f(adZone, AppLovinAdServiceImpl.this.a);
            }
            synchronized (this.b.a) {
                hashSet = new HashSet<>(this.b.c);
                this.b.c.clear();
                this.b.b = false;
            }
            for (AppLovinAdLoadListener a2 : hashSet) {
                AppLovinAdServiceImpl.this.a(appLovinAd, a2);
            }
        }

        public void failedToReceiveAd(int i) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.b.a) {
                hashSet = new HashSet<>(this.b.c);
                this.b.c.clear();
                this.b.b = false;
            }
            for (AppLovinAdLoadListener a2 : hashSet) {
                AppLovinAdServiceImpl.this.a(i, a2);
            }
        }
    }

    private static class b {
        final Object a;
        boolean b;
        final Collection<AppLovinAdLoadListener> c;

        private b() {
            this.a = new Object();
            this.c = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.b + ", pendingAdListeners=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    AppLovinAdServiceImpl(m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        Map<d, b> map = CollectionUtils.map(6);
        this.d = map;
        map.put(d.g(), new b());
        map.put(d.h(), new b());
        map.put(d.i(), new b());
        map.put(d.j(), new b());
        map.put(d.k(), new b());
    }

    private Uri a(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable unused) {
            if (!u.a()) {
                return null;
            }
            u A = this.a.A();
            A.d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            return null;
        }
    }

    private b a(d dVar) {
        b bVar;
        synchronized (this.e) {
            bVar = this.d.get(dVar);
            if (bVar == null) {
                bVar = new b();
                this.d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    private String a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            return null;
        }
    }

    private String a(String str, long j, long j2, List<Long> list, boolean z, int i) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i != h.a) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(h.a(i)));
        }
        return appendQueryParameter.build().toString();
    }

    /* access modifiers changed from: private */
    public void a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    if (u.a()) {
                        u.c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar) {
        if (Utils.openUri(appLovinAdView.getContext(), uri, this.a)) {
            j.c(bVar.g(), (AppLovinAd) eVar, appLovinAdView);
        }
        bVar.o();
    }

    private void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, m mVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri a2 = a(uri, "primaryUrl");
            List<Uri> b2 = b(uri, "primaryTrackingUrl");
            Uri a3 = a(uri, "fallbackUrl");
            List<Uri> b3 = b(uri, "fallbackTrackingUrl");
            if (a2 != null || a3 != null) {
                if (!a(a2, "primary", b2, eVar, appLovinAdView, bVar, context, mVar)) {
                    a(a3, "backup", b3, eVar, appLovinAdView, bVar, context, mVar);
                }
                if (bVar != null) {
                    bVar.o();
                }
            } else if (u.a()) {
                mVar.A().e("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
            }
        } else if (u.a()) {
            mVar.A().e("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private void a(Uri uri, e eVar, com.applovin.impl.adview.b bVar, final com.applovin.impl.adview.activity.b.a aVar) {
        if (u.a(this.a)) {
            u uVar = this.b;
            uVar.b("AppLovinAdService", "Forwarding click " + uri);
        }
        eVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.a.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.CLOSE_AD_ON_FORWARDING_CLICK_SCHEME);
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (aVar != null) {
                this.c.post(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            if (u.a(AppLovinAdServiceImpl.this.a)) {
                                AppLovinAdServiceImpl.this.b.b("AppLovinAdService", "Dismissing ad after forwarding click");
                            }
                            aVar.h();
                        }
                    }
                });
            } else if (bVar != null && !Utils.isBML(eVar.getSize())) {
                if (u.a(this.a)) {
                    this.b.b("AppLovinAdService", "Closing ad after forwarding click");
                }
                bVar.l();
            }
        }
    }

    private void a(d dVar, a aVar) {
        AppLovinAdImpl a2 = this.a.Z().a(dVar);
        if (a2 != null) {
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AppLovinAdService", "Using pre-loaded ad: " + a2 + " for " + dVar);
            }
            aVar.adReceived(a2);
            return;
        }
        a((com.applovin.impl.sdk.f.a) new k(dVar, aVar, this.a));
    }

    private void a(d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            if (u.a()) {
                u A = this.a.A();
                A.b("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            }
            b a2 = a(dVar);
            synchronized (a2.a) {
                a2.c.add(appLovinAdLoadListener);
                if (!a2.b) {
                    a2.b = true;
                    a(dVar, new a(a2));
                } else if (u.a()) {
                    this.b.b("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    private void a(com.applovin.impl.sdk.e.a aVar) {
        if (StringUtils.isValidString(aVar.a())) {
            this.a.U().a(h.o().c(aVar.a()).d(StringUtils.isValidString(aVar.b()) ? aVar.b() : null).b(aVar.c()).a(false).c(aVar.d()).a());
        } else if (u.a()) {
            this.b.d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    private void a(com.applovin.impl.sdk.f.a aVar) {
        if (!this.a.d() && u.a()) {
            u.h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.a.a();
        this.a.S().a(aVar, o.a.MAIN);
    }

    /* access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    if (u.a()) {
                        u.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                    }
                }
            }
        });
    }

    private boolean a(Uri uri, String str, List<Uri> list, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, m mVar) {
        if (u.a()) {
            u A = mVar.A();
            A.b("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean openUri = Utils.openUri(context, uri, mVar);
        boolean a2 = u.a();
        if (openUri) {
            if (a2) {
                u A2 = mVar.A();
                A2.b("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            for (Uri uri2 : list) {
                mVar.X().dispatchPostbackAsync(uri2.toString(), (AppLovinPostbackListener) null);
            }
            if (bVar != null) {
                j.c(bVar.g(), (AppLovinAd) eVar, appLovinAdView);
            }
        } else if (a2) {
            mVar.A().e("AppLovinAdService", "URL failed to open");
        }
        return openUri;
    }

    private boolean a(String str) {
        String str2 = this.a.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.FORWARDING_CLICK_SCHEME);
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private List<Uri> b(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        for (String parse : queryParameters) {
            try {
                arrayList.add(Uri.parse(parse));
            } catch (Throwable unused) {
                if (u.a()) {
                    u A = this.a.A();
                    A.d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
            }
        }
        return arrayList;
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.f) {
            this.f.putAll(map);
        }
    }

    public AppLovinAd dequeueAd(d dVar) {
        AppLovinAdImpl b2 = this.a.Z().b(dVar);
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AppLovinAdService", "Dequeued ad: " + b2 + " for zone: " + dVar + "...");
        }
        return b2;
    }

    public JSONObject getAndResetCustomPostBody() {
        return this.g.getAndSet((Object) null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.f) {
            map = CollectionUtils.map(this.f);
            this.f.clear();
        }
        return map;
    }

    public String getBidToken() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a2 = this.a.V().a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a2;
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v27, types: [com.applovin.impl.sdk.f.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x0020
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x001c
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.u.i(r2, r11)
        L_0x001c:
            r10.a((int) r1, (com.applovin.sdk.AppLovinAdLoadListener) r12)
            return
        L_0x0020:
            com.applovin.impl.sdk.ad.c r0 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.m r3 = r10.a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.ad.c$a r11 = r0.b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.ad.c.a.REGULAR
            if (r11 != r3) goto L_0x0054
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x0048
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Loading next ad for token: "
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.b(r2, r1)
        L_0x0048:
            com.applovin.impl.sdk.f.l r11 = new com.applovin.impl.sdk.f.l
            com.applovin.impl.sdk.m r1 = r10.a
            r11.<init>(r0, r12, r1)
        L_0x004f:
            r10.a((com.applovin.impl.sdk.f.a) r11)
            goto L_0x00fe
        L_0x0054:
            com.applovin.impl.sdk.ad.c$a r11 = r0.b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.ad.c.a.AD_RESPONSE_JSON
            if (r11 != r3) goto L_0x00e4
            org.json.JSONObject r5 = r0.d()
            if (r5 == 0) goto L_0x00d6
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.utils.h.f(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.utils.h.d(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.utils.h.c(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.utils.h.e(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.f.a((com.applovin.impl.sdk.m) r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            java.lang.String r1 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r5, r1, r11)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00b7
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x00a5
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Rendering ad for token: "
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.b(r2, r0)
        L_0x00a5:
            com.applovin.impl.sdk.m r11 = r10.a
            com.applovin.impl.sdk.ad.d r6 = com.applovin.impl.sdk.utils.Utils.getZone(r5, r11)
            com.applovin.impl.sdk.f.p r11 = new com.applovin.impl.sdk.f.p
            com.applovin.impl.sdk.ad.b r7 = com.applovin.impl.sdk.ad.b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.m r9 = r10.a
            r4 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x004f
        L_0x00b7:
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x00d0
            com.applovin.impl.sdk.u r11 = r10.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.e(r2, r0)
        L_0x00d0:
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00fe
        L_0x00d6:
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x00fb
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to retrieve ad response JSON from token: "
            r11.<init>(r3)
            goto L_0x00f1
        L_0x00e4:
            boolean r11 = com.applovin.impl.sdk.u.a()
            if (r11 == 0) goto L_0x00fb
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid ad token specified: "
            r11.<init>(r3)
        L_0x00f1:
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.u.i(r2, r11)
        L_0x00fb:
            r12.failedToReceiveAd(r1)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            }
            a(d.a(str), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (removeTrimmedEmptyStrings == null || removeTrimmedEmptyStrings.isEmpty()) {
            if (u.a()) {
                u.i("AppLovinAdService", "No zones were provided");
            }
            a(-7, appLovinAdLoadListener);
            return;
        }
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AppLovinAdService", "Loading next ad for zones: " + removeTrimmedEmptyStrings);
        }
        a((com.applovin.impl.sdk.f.a) new com.applovin.impl.sdk.f.j(removeTrimmedEmptyStrings, appLovinAdLoadListener, this.a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(d.b(str), appLovinAdLoadListener);
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.sdk.e.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.applovin.impl.sdk.e.a a2 : list) {
                a(a2);
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.g.set(jSONObject);
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public void trackAndLaunchClick(e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Uri uri, PointF pointF, boolean z) {
        if (eVar != null) {
            if (u.a()) {
                this.b.b("AppLovinAdService", "Tracking click on an ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.a(pointF, z));
            if (appLovinAdView == null || uri == null) {
                if (u.a()) {
                    this.b.e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
                }
            } else if (eVar.isDirectDownloadEnabled()) {
                final com.applovin.impl.adview.b bVar2 = bVar;
                final e eVar2 = eVar;
                final AppLovinAdView appLovinAdView2 = appLovinAdView;
                final Uri uri2 = uri;
                this.a.an().a((com.applovin.impl.sdk.a.b) eVar, (c.a) new c.a() {
                    public void a() {
                        AppLovinAdServiceImpl.this.a.ad().c();
                        com.applovin.impl.adview.b bVar = bVar2;
                        if (bVar != null) {
                            bVar.o();
                            j.a(bVar2.g(), (AppLovinAd) eVar2, appLovinAdView2);
                        }
                    }

                    public void b() {
                        if (bVar2 != null) {
                            AppLovinAdServiceImpl.this.a.ad().d();
                            j.b(bVar2.g(), (AppLovinAd) eVar2, appLovinAdView2);
                        }
                    }

                    public void c() {
                        AppLovinAdServiceImpl.this.a(uri2, eVar2, appLovinAdView2, bVar2);
                    }
                });
            } else if (a(uri.getScheme())) {
                a(uri, eVar, bVar, (com.applovin.impl.adview.activity.b.a) null);
            } else if (Utils.isDeepLinkPlusUrl(uri)) {
                a(uri, eVar, appLovinAdView, bVar, appLovinAdView.getContext(), this.a);
            } else {
                a(uri, eVar, appLovinAdView, bVar);
            }
        } else if (u.a()) {
            this.b.e("AppLovinAdService", "Unable to track ad view click. No ad specified");
        }
    }

    public void trackAndLaunchVideoClick(e eVar, final Uri uri, PointF pointF, com.applovin.impl.adview.activity.b.a aVar, final Context context) {
        if (eVar != null) {
            if (u.a()) {
                this.b.b("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.a(pointF));
            if (eVar.isDirectDownloadEnabled()) {
                this.a.an().a((com.applovin.impl.sdk.a.b) eVar, (c.a) new c.a() {
                    public void a() {
                        AppLovinAdServiceImpl.this.a.ad().c();
                    }

                    public void b() {
                        AppLovinAdServiceImpl.this.a.ad().d();
                    }

                    public void c() {
                        Utils.openUri(context, uri, AppLovinAdServiceImpl.this.a);
                    }
                });
            } else if (a(uri.getScheme())) {
                a(uri, eVar, (com.applovin.impl.adview.b) null, aVar);
            } else if (Utils.isDeepLinkPlusUrl(uri)) {
                a(uri, eVar, (AppLovinAdView) null, (com.applovin.impl.adview.b) null, context, this.a);
            } else {
                Utils.openUri(context, uri, this.a);
            }
        } else if (u.a()) {
            this.b.e("AppLovinAdService", "Unable to track video click. No ad specified");
        }
    }

    public void trackAppKilled(e eVar) {
        if (eVar != null) {
            if (u.a()) {
                this.b.b("AppLovinAdService", "Tracking app killed during ad...");
            }
            List<com.applovin.impl.sdk.e.a> as = eVar.as();
            if (as != null && !as.isEmpty()) {
                for (com.applovin.impl.sdk.e.a next : as) {
                    a(new com.applovin.impl.sdk.e.a(next.a(), next.b()));
                }
            } else if (u.a()) {
                u uVar = this.b;
                uVar.d("AppLovinAdService", "Unable to track app killed during AD #" + eVar.getAdIdNumber() + ". Missing app killed tracking URL.");
            }
        } else if (u.a()) {
            this.b.e("AppLovinAdService", "Unable to track app killed. No ad specified");
        }
    }

    public void trackFullScreenAdClosed(e eVar, long j, List<Long> list, long j2, boolean z, int i) {
        boolean a2 = u.a();
        if (eVar != null) {
            if (a2) {
                this.b.b("AppLovinAdService", "Tracking ad closed...");
            }
            List<com.applovin.impl.sdk.e.a> ar = eVar.ar();
            if (ar != null && !ar.isEmpty()) {
                for (com.applovin.impl.sdk.e.a next : ar) {
                    long j3 = j;
                    long j4 = j2;
                    List<Long> list2 = list;
                    boolean z2 = z;
                    int i2 = i;
                    String a3 = a(next.a(), j3, j4, list2, z2, i2);
                    String a4 = a(next.b(), j3, j4, list2, z2, i2);
                    if (StringUtils.isValidString(a3)) {
                        a(new com.applovin.impl.sdk.e.a(a3, a4));
                    } else if (u.a()) {
                        u uVar = this.b;
                        uVar.e("AppLovinAdService", "Failed to parse url: " + next.a());
                    }
                }
            } else if (u.a()) {
                u uVar2 = this.b;
                uVar2.d("AppLovinAdService", "Unable to track ad closed for AD #" + eVar.getAdIdNumber() + ". Missing ad close tracking URL." + eVar.getAdIdNumber());
            }
        } else if (a2) {
            this.b.e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
        }
    }

    public void trackImpression(e eVar) {
        if (eVar != null) {
            if (u.a()) {
                this.b.b("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.at());
        } else if (u.a()) {
            this.b.e("AppLovinAdService", "Unable to track impression click. No ad specified");
        }
    }

    public void trackVideoEnd(e eVar, long j, int i, boolean z) {
        boolean a2 = u.a();
        if (eVar != null) {
            if (a2) {
                this.b.b("AppLovinAdService", "Tracking video end on ad...");
            }
            List<com.applovin.impl.sdk.e.a> aq = eVar.aq();
            if (aq != null && !aq.isEmpty()) {
                String l = Long.toString(System.currentTimeMillis());
                for (com.applovin.impl.sdk.e.a next : aq) {
                    if (StringUtils.isValidString(next.a())) {
                        long j2 = j;
                        int i2 = i;
                        String str = l;
                        boolean z2 = z;
                        String a3 = a(next.a(), j2, i2, str, z2);
                        String a4 = a(next.b(), j2, i2, str, z2);
                        if (a3 != null) {
                            a(new com.applovin.impl.sdk.e.a(a3, a4));
                        } else if (u.a()) {
                            u uVar = this.b;
                            uVar.e("AppLovinAdService", "Failed to parse url: " + next.a());
                        }
                    } else if (u.a()) {
                        this.b.d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
                    }
                }
            } else if (u.a()) {
                u uVar2 = this.b;
                uVar2.d("AppLovinAdService", "Unable to submit persistent postback for AD #" + eVar.getAdIdNumber() + ". Missing video end tracking URL.");
            }
        } else if (a2) {
            this.b.e("AppLovinAdService", "Unable to track video end. No ad specified");
        }
    }
}
